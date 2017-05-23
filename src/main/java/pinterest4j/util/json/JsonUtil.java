package pinterest4j.util.json;

import org.json.JSONException;
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
}
