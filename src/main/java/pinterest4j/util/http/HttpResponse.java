package pinterest4j.util.http;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Aniket Divekar.
 */
public class HttpResponse {

    private int statusCode;
    private String response;
    private JSONObject responseJson;
    private Map<String, List<String>> responseHeaderFields;

    public HttpResponse(int statusCode, String response, JSONObject responseJson, Map<String, List<String>> responseHeaderFields) {
        this.statusCode = statusCode;
        this.response = response;
        this.responseJson = responseJson;
        this.responseHeaderFields = responseHeaderFields;
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

    public Map<String, List<String>> getResponseHeaderFields() {
        return responseHeaderFields;
    }
}
