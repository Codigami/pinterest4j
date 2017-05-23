package pinterest4j.util.http;

import org.json.JSONObject;

/**
 * Created by Aniket Divekar.
 */
public class HttpResponse {

    private int statusCode;
    private String response;
    private JSONObject responseJson;

    public HttpResponse(int statusCode, String response, JSONObject responseJson) {
        this.statusCode = statusCode;
        this.response = response;
        this.responseJson = responseJson;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponse() {
        return response;
    }

    public JSONObject getResponseJson() {
        return responseJson;
    }
}
