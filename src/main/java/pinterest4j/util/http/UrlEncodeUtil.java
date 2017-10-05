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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Aniket Divekar.
 */
public final class UrlEncodeUtil {

    public static String getEncodedUrl(String baseUrl, QueryParam... queryParams) {
        if (queryParams == null || queryParams.length == 0) {
            return baseUrl;
        }

        return baseUrl + "?" + getQueryString(queryParams);
    }

    public static String encodeParams(QueryParam... queryParams) {
        return getQueryString(queryParams);
    }

    private static String getQueryString(QueryParam[] queryParams) {
        if (queryParams == null) {
            return "";
        }

        StringBuilder query = new StringBuilder();
        boolean appendAmpersand = false;
        for(int index = 0; index < queryParams.length; index++) {
            if (appendAmpersand) {
                query.append("&");
            }
            if (queryParams[index].getKey() != null && queryParams[index].getValue() != null) {
                query.append(encode(queryParams[index].getKey()))
                        .append("=").append(encode(queryParams[index].getValue()));
                appendAmpersand = true;
            }
        }

        return query.toString();
    }

    private static String encode(String value) {
        if (value == null) {
            return "";
        }
        String encodedValue;
        try {
            encodedValue = URLEncoder.encode(value, "UTF-8");
            StringBuilder buf = new StringBuilder(encodedValue.length());
            char c;
            for (int i = 0; i < encodedValue.length(); i++) {
                c = encodedValue.charAt(i);
                if (c == '*') {
                    buf.append("%2A");
                } else if (c == '+') {
                    buf.append("%20");
                } else if (c == '%'
                        && (i + 1) < encodedValue.length()
                        && encodedValue.charAt(i + 1) == '7'
                        && encodedValue.charAt(i + 2) == 'E') {
                    buf.append('~');
                    i += 2;
                } else {
                    buf.append(c);
                }
            }
            return buf.toString();
        } catch (UnsupportedEncodingException ignore) {
            return "";
        }
    }
}
