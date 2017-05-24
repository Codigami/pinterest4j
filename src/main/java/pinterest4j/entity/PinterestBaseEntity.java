package pinterest4j.entity;

import pinterest4j.util.http.HttpResponse;

/**
 *
 * Created by Aniket Divekar.
 */
public class PinterestBaseEntity {
    private RateLimitStatus rateLimitStatus;

    PinterestBaseEntity() {
        // default constructor
    }

    PinterestBaseEntity(HttpResponse res) {
        this.rateLimitStatus = RateLimitStatus.createRateLimitStatus(res);
    }

    public RateLimitStatus getRateLimitStatus() {
        return rateLimitStatus;
    }
}
