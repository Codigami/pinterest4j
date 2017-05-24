package pinterest4j.config;

import java.io.Serializable;

/**
 * Interface to represent configurations for the Pinterest APIs
 *
 * Created by Aniket Divekar.
 */
public interface Configuration extends Serializable {

    String getRestBaseUrl();

    String getUsersRestBaseUrl();

    String getBoardsRestBaseUrl();

    String getMeRestBaseUrl();

    String getPinsRestBaseUrl();
}
