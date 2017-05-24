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

import java.util.List;
import java.util.Map;

/**
 * Entity to represent HTTP Response.
 *
 * Created by Aniket Divekar.
 */
public class HttpResponse {

    private int statusCode;
    private String response;
    private JSONObject responseJson;
    private Map<String, List<String>> responseHeaderFields;

    public HttpResponse(int statusCode, String response, JSONObject responseJson, Map<String, List<String>> responseHeaderFields) {
        this.statusCode = statusCode;
        this.response = response;
        this.responseJson = responseJson;
        this.responseHeaderFields = responseHeaderFields;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponse() {
        return response;
    }

    public JSONObject getResponseJson() {
        return responseJson;
    }

    public Map<String, List<String>> getResponseHeaderFields() {
        return responseHeaderFields;
    }
}
