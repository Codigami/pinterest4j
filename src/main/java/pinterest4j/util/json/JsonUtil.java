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

package pinterest4j.util.json;

import org.json.JSONObject;

/**
 * Utility class for parsing input JSON
 *
 *  Created by Aniket Divekar.
 */
public class JsonUtil {

    public static String getString(String name, JSONObject json) {
        try {
            if (json.isNull(name)) {
                return null;
            } else {
                return json.getString(name);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static long getLong(String name, JSONObject json) {
        try {
            if (json.isNull(name)) {
                return 0;
            } else {
                return json.getLong(name);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getImageUrl60x60(JSONObject json) {
        if (!json.isNull("image")) {
            JSONObject image = json.getJSONObject("image");
            if (!image.isNull("60x60")) {
                image = image.getJSONObject("60x60");
                return getString("url", image);
            }
        }
        return null;
    }

    public static String getImageUrlOriginal(JSONObject json) {
        if (!json.isNull("image")) {
            JSONObject image = json.getJSONObject("image");
            if (!image.isNull("original")) {
                image = image.getJSONObject("original");
                return getString("url", image);
            }
        }

        return null;
    }
}
