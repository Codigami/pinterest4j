package pinterest4j.config;

import java.io.Serializable;

/**
 *
 *
 * Created by Aniket Divekar.
 */
public class ConfigurationImpl implements Configuration, Serializable {

    private static final long serialVersionUID = -912105459125357372L;
    private String restBaseUrl = "https://api.pinterest.com/v1";

    public String getRestBaseUrl() {
        return this.restBaseUrl;
    }

    public String getUsersRestBaseUrl() {
        return this.restBaseUrl + "/users";
    }

    public String getBoardsRestBaseUrl() {
        return this.restBaseUrl + "/boards";
    }

    public String getMeRestBaseUrl() {
        return this.restBaseUrl + "/me";
    }

    public String getPinsRestBaseUrl() {
        return this.restBaseUrl + "/pins";
    }

    protected final void setRestBaseUrl(String restBaseUrl) {
        this.restBaseUrl = restBaseUrl;
    }

}
