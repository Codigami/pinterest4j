package pinterest4j.util.json;

import pinterest4j.entity.Board;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.http.HttpResponse;

/**
 *
 * Created by Aniket Divekar.
 */
public interface ObjectHelper {

    User createUser(HttpResponse res);

    Board createBoard(HttpResponse res);

    Pin createPin(HttpResponse res);

}
