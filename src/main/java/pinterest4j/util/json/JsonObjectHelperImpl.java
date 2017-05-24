package pinterest4j.util.json;

import pinterest4j.entity.Board;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.http.HttpResponse;

/**
 * Helper class to create Objects using response from Pinterest
 *
 * Created by Aniket Divekar.
 */
public class JsonObjectHelperImpl implements ObjectHelper {

    public User createUser(HttpResponse res) {
        return new User(res);
    }

    @Override
    public Board createBoard(HttpResponse res) {
        return new Board(res);
    }

    @Override
    public Pin createPin(HttpResponse res) {
        return new Pin(res);
    }
}

