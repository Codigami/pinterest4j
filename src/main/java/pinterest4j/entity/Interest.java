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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.http.HttpResponse;
import pinterest4j.util.json.JsonUtil;
import pinterest4j.util.list.PageResponseList;
import pinterest4j.util.list.PageResponseListImpl;

import java.io.Serializable;

/**
 * Entity representing Pinterest Interest
 *
 * Created by Aniket Divekar.
 */
public class Interest extends PinterestBaseEntity implements Serializable {

    private static final long serialVersionUID = -5491473694569084821L;
    private String id;
    private String name;

    public Interest(JSONObject json) {
        init(json);
    }

    private void init(JSONObject json) {
        this.id = JsonUtil.getString("id", json);
        this.name = JsonUtil.getString("name", json);
    }

    public static PageResponseList<Interest> createPageInterestList(HttpResponse res) throws PinterestException {
        try {

            JSONArray list = res.getResponseJson().getJSONArray("data");
            int size = list.length();
            PageResponseList<Interest> interests = new PageResponseListImpl<>(size, res);

            for(int index = 0; index < size; index++) {
                JSONObject boardJson = list.getJSONObject(index);
                interests.add(new Interest(boardJson));
            }

            return interests;

        } catch (JSONException e){
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
