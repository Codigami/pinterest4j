package pinterest4j.entity;

import pinterest4j.util.http.HttpResponse;

import java.util.List;
import java.util.Map;

/**
 * Entity representing Rate limit status for Pinterest API
 *
 * Created by Aniket Divekar.
 */
public class RateLimitStatus {
    private int limit;
    private int remaining;

    private RateLimitStatus(int limit, int remaining) {
        this.limit = limit;
        this.remaining = remaining;
    }

    static RateLimitStatus createRateLimitStatus(HttpResponse res) {
        if (null == res) {
            return null;
        }
        Map<String, List<String>> headerFields = res.getResponseHeaderFields();

        List<String> limits = headerFields.get("X-Ratelimit-Limit");
        List<String> remaining = headerFields.get("X-Ratelimit-Remaining");
        if (limits == null || remaining == null || limits.isEmpty() || remaining.isEmpty()) {
            return null;
        }

        return new RateLimitStatus(Integer.valueOf(limits.get(0)), Integer.valueOf(remaining.get(0)));
    }

    public void init (int limit, int remaining) {
        this.limit = limit;
        this.remaining = remaining;
    }

    public int getLimit() {
        return limit;
    }

    public int getRemaining() {
        return remaining;
    }
}
