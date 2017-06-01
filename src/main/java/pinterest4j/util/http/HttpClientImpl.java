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

import okhttp3.*;
import org.json.JSONObject;
import pinterest4j.util.exception.PinterestException;

import java.net.URL;

/**
 * Client for making HTTP calls
 *
 * Created by Aniket Divekar.
 */
public class HttpClientImpl implements HttpClient {

    private static final OkHttpClient client = new OkHttpClient.Builder().build();

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
            // build the request
            Request request = new Request.Builder().url(new URL(requestUrl))
                    .method(method, getRequestBody(method, params)).build();

            // execute the request
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                // non-ok response
                throw new PinterestException(response.message(), response.code());
            }

            final String resp = response.body().string();

            return new HttpResponse(response.code(), resp, new JSONObject(resp), response.headers().toMultimap());

        } catch (Exception e) {
            // log error

            throw new PinterestException(e.getMessage());
        }
    }

    private RequestBody getRequestBody(String method, QueryParam[] params) {
        RequestBody body = null;

        if (!HttpRequestMethods.GET.name().equalsIgnoreCase(method) && params != null) {
            if (QueryParam.containsFile(params)) {
                MultipartBody.Builder builder = new MultipartBody.Builder().setType(MediaType.parse(HttpUtil.CONTENT_TYPE_MULTIPART));
                for (QueryParam param : params) {
                    if (param.isFile()) {
                        builder.addFormDataPart(param.getKey(), param.getFile().getName(), RequestBody.create(MediaType.parse(param.getContentType()), param.getFile()));
                    } else if (param.getValue() != null){
                        builder.addFormDataPart(param.getKey(), param.getValue());
                    }
                }
                body = builder.build();
            } else {
                body = RequestBody.create(MediaType.parse(HttpUtil.CONTENT_TYPE_FORM), UrlEncodeUtil.encodeParams(params));
            }
        }

        return body;
    }
}
