package pinterest4j.config;

/**
 *
 *
 * Created by Aniket Divekar.
 */
public interface Configuration {

    String getRestBaseUrl();

    String getUsersRestBaseUrl();

    String getBoardsRestBaseUrl();

    String getMeRestBaseUrl();

    String getPinsRestBaseUrl();
}
