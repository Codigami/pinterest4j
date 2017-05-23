package pinterest4j.auth;

import java.io.Serializable;

/**
 * Entity to represent OAuth 2 access token.
 *
 * Created by Aniket Divekar.
 */
public class OAuth2Token implements Serializable {

    private static final long serialVersionUID = -965007698209367157L;
    private String accessToken;

    public OAuth2Token(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

}
