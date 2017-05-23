package pinterest4j.util.json;

import org.json.JSONObject;
import pinterest4j.entity.Board;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;

/**
 *
 * Created by Aniket Divekar.
 */
public interface ObjectFactory {

    User createUser(JSONObject json);

    Board createBoard(JSONObject json);

    Pin createPin(JSONObject json);

}
