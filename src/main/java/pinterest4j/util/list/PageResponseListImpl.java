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

package pinterest4j.util.list;

import org.json.JSONObject;
import pinterest4j.util.http.HttpResponse;
import pinterest4j.util.json.JsonUtil;

/**
 * Created by Aniket Divekar.
 */
public class PageResponseListImpl<T> extends ResponseListImpl<T> implements PageResponseList<T> {

    private static final long serialVersionUID = -8074643789888432803L;
    private String cursor;
    private String next;

    public PageResponseListImpl(HttpResponse res) {
        super(res);
        init(res);
    }

    public PageResponseListImpl(int size, HttpResponse res) {
        super(size, res);
        init(res);
    }

    private void init(HttpResponse res) {
        JSONObject json = res.getResponseJson();
        if (json.has("page")) {
            json = json.getJSONObject("page");
            this.cursor = JsonUtil.getString("cursor", json);
            this.next = JsonUtil.getString("next", json);
        }
    }

    @Override
    public String getCursor() {
        return this.cursor;
    }

    @Override
    public String getNext() {
        return this.next;
    }
}
