package pinterest4j.util.http;

import pinterest4j.util.exception.PinterestException;

/**
 * Created by Aniket Divekar.
 */
public interface HttpClient {

    HttpResponse get(String url) throws PinterestException;
}
