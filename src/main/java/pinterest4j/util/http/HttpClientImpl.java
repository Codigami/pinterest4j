/*
 * Copyright (c) 2017 Aniket Divekar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pinterest4j.util.http;

import org.json.JSONObject;
import pinterest4j.util.exception.PinterestException;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Client for making HTTP calls
 *
 * Created by Aniket Divekar.
 */
public class HttpClientImpl implements HttpClient {

    @Override
    public HttpResponse get(String requestUrl) throws PinterestException {
        return request(requestUrl, "GET", new QueryParam[]{});
    }

    @Override
    public HttpResponse delete(String requestUrl) throws PinterestException {
        return request(requestUrl, "DELETE", new QueryParam[]{});
    }

    @Override
    public HttpResponse post(String requestUrl, QueryParam[] params) throws PinterestException {
        return request(requestUrl, "POST", params);
    }

    @Override
    public HttpResponse patch(String requestUrl, QueryParam[] params) throws PinterestException {
        return request(requestUrl, "PATCH", params);
    }

    private HttpResponse request(String requestUrl, String method, QueryParam[] params) throws PinterestException {

        try {

            URL url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.addRequestProperty("Accept-Charset", "UTF-8");
            con.setDoInput(true);
            con.setRequestMethod(method);
            con.setUseCaches(false);
            OutputStream outputStream = null;

            if (!"GET".equalsIgnoreCase(method) && params != null) {
                try {
                    if (QueryParam.containsFile(params)) {
                        String boundary = "----pinterest4J-file-upload" + System.currentTimeMillis();
                        con.setRequestProperty("Content-Type", HttpUtil.CONTENT_TYPE_MULTIPART + "; boundary=" + boundary);
                        boundary = "--" + boundary;
                        con.setDoOutput(true);
                        outputStream = con.getOutputStream();
                        DataOutputStream out = new DataOutputStream(outputStream);
                        for (QueryParam param : params) {
                            if (param.isFile()) {
                                out.writeBytes(boundary + "\r\n");
                                out.writeBytes("Content-Disposition: form-data; name=\"" + param.getKey() + "\"; filename=\"" + param.getFile().getName() + "\"\r\n");
                                out.writeBytes("Content-Type: " + param.getContentType() + "\r\n\r\n");
                                BufferedInputStream in = new BufferedInputStream( new FileInputStream(param.getFile()));
                                byte[] buff = new byte[1024];
                                int length;
                                while ((length = in.read(buff)) != -1) {
                                    out.write(buff, 0, length);
                                    //sb.append(new String(buff));
                                }
                                out.writeBytes( "\r\n");
                                in.close();
                            } else if (param.getValue() != null){
                                out.writeBytes(boundary + "\r\n");
                                out.writeBytes( "Content-Disposition: form-data; name=\"" + param.getKey() + "\"\r\n");
                                out.writeBytes( "Content-Type: " + HttpUtil.CONTENT_TYPE_TEXT + "\r\n\r\n");
                                out.write(param.getValue().getBytes("UTF-8"));
                                out.writeBytes( "\r\n");
                            }
                        }
                        out.writeBytes( boundary + "--\r\n");
                        out.writeBytes( "\r\n");

                    } else {
                        con.setRequestProperty("Content-Type", HttpUtil.CONTENT_TYPE_FORM);
                        String postParam = UrlEncodeUtil.encodeParams(params);
                        byte[] bytes = postParam.getBytes("UTF-8");
                        con.setRequestProperty("Content-Length", Integer.toString(bytes.length));
                        con.setDoOutput(true);
                        outputStream = con.getOutputStream();
                        outputStream.write(bytes);
                    }
                    outputStream.flush();
                    outputStream.close();

                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            }

            int statusCode = con.getResponseCode();
            BufferedReader in;

            if (statusCode < HttpURLConnection.HTTP_OK || statusCode >= HttpURLConnection.HTTP_MOVED_PERM) {
                // non-ok response
                return HttpUtil.handleNonOkResponse(con.getErrorStream(), statusCode);
            }

            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            String resp = HttpUtil.getResponseAsString(in);

            Map<String, List<String>> headerFields = con.getHeaderFields();

            // close the stream
            in.close();

            return new HttpResponse(statusCode, resp, new JSONObject(resp), headerFields);

        } catch (Exception e) {
            // log error

            throw new PinterestException(e.getMessage());
        }
    }

    /*
     * Workaround for a bug in {@code HttpURLConnection.setRequestMethod(String)}
     * The implementation of Sun/Oracle is throwing a {@code ProtocolException}
     * when the method is other than the HTTP/1.1 default methods. So to use {@code PROPFIND}
     * and others, we must apply this workaround.
     *
     * See issue http://java.net/jira/browse/JERSEY-639
     */

    static {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
            methodsField.setAccessible(true);
            // get the methods field modifiers
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            // bypass the "private" modifier
            modifiersField.setAccessible(true);

            // remove the "final" modifier
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            /* valid HTTP methods */
            String[] methods = {
                    "GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "TRACE", "PATCH"
            };
            // set the new methods - including patch
            methodsField.set(null, methods);

        } catch (IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
