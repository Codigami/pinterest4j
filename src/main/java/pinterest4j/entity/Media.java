package pinterest4j.entity;

import org.json.JSONObject;
import pinterest4j.util.json.JsonUtil;

import java.io.Serializable;

/**
 *
 *
 * Created by Aniket Divekar.
 */
public class Media implements Serializable{

    private static final long serialVersionUID = 8565758825062577871L;

    private String type;

    public Media(JSONObject json) {
        this.type = JsonUtil.getString("type", json);
    }

    public String getType() {
        return type;
    }
}
