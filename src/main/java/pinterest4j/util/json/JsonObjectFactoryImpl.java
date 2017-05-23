package pinterest4j.util.json;

import org.json.JSONObject;
import pinterest4j.entity.Board;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;

/**
 *
 *
 * Created by Aniket Divekar.
 */
public class JsonObjectFactoryImpl implements ObjectFactory {

    public User createUser(JSONObject json) {
        return new User(json.getJSONObject("data"));
    }

    @Override
    public Board createBoard(JSONObject json) {
        return new Board(json.getJSONObject("data"));
    }

    @Override
    public Pin createPin(JSONObject json) {
        return new Pin(json.getJSONObject("data"));
    }
}

