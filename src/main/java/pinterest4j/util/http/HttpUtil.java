package pinterest4j.util.http;

import pinterest4j.util.exception.PinterestException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Aniket Divekar.
 */
public class HttpUtil {

    public static String getResponseAsString(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        return response.toString();
    }

    public static HttpResponse handleNonOkResponse(HttpsURLConnection con, int statusCode) throws IOException, PinterestException {
        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
        String resp = HttpUtil.getResponseAsString(in);

        // close the stream
        in.close();

        throw new PinterestException(resp, statusCode);
    }
}
