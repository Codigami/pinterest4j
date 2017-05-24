/*
 * Copyright (c) 2017 Aniket Divekar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
