package pinterest4j.util.http;

import org.json.JSONObject;
import pinterest4j.util.exception.PinterestException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Client for making HTTP calls
 *
 * Created by Aniket Divekar.
 */
public class HttpClientImpl implements HttpClient {

    public HttpResponse get(String requestUrl) throws PinterestException {

        try {

            URL url = new URL(requestUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int statusCode = con.getResponseCode();
            BufferedReader in;

            if (statusCode != HttpResponseCodes.OK.getResponseCode()) {
                // non-ok response
                return HttpUtil.handleNonOkResponse(con, statusCode);
            }

            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            String resp = HttpUtil.getResponseAsString(in);

            Map<String, List<String>> headerFields = con.getHeaderFields();

            // close the stream
            in.close();

            return new HttpResponse(statusCode, resp, new JSONObject(resp), headerFields);

        } catch (IOException e) {
            // log error

            throw new PinterestException(e.getMessage());
        }

    }

}
