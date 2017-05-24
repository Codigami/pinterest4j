package pinterest4j.util.json;

import org.json.JSONObject;

/**
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
