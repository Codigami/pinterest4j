package pinterest4j.util.http;

/**
 * Enum for representing HTTP Response codes
 *
 * Created by Aniket Divekar.
 */
public enum HttpResponseCodes {

    OK(200);

    private int responseCode;

    HttpResponseCodes(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}
