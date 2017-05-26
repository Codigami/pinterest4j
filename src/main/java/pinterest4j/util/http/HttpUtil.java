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

import pinterest4j.util.exception.PinterestException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utility for handling http response from {@link HttpsURLConnection#getInputStream()}, {@link HttpsURLConnection#getErrorStream()}
 *
 * Created by Aniket Divekar.
 */
public class HttpUtil {

    public static String getResponseAsString(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        return response.toString();
    }

    public static HttpResponse handleNonOkResponse(InputStream in, int statusCode) throws IOException, PinterestException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String resp = HttpUtil.getResponseAsString(br);

        // close the stream
        br.close();

        throw new PinterestException(resp, statusCode);
    }
}
