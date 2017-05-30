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

import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.http.HttpResponse;
import pinterest4j.util.json.JsonUtil;
import pinterest4j.util.list.PageResponseList;
import pinterest4j.util.list.PageResponseListImpl;
import pinterest4j.util.list.ResponseList;
import pinterest4j.util.list.ResponseListImpl;

import java.io.Serializable;

/**
 * Entity representing Pinterest Board
 *
 * Created by Aniket Divekar.
 */
public class Board extends PinterestBaseEntity implements Serializable {

    private static final long serialVersionUID = 6472179025193738672L;
    private String id;
    private String name;
    private User creator;
    private String url;
    private DateTime createdAt;
    private String privacy;
    private String imageUrl;
    private String description;
    private Counts counts;

    // reason field is remaining

    public Board(HttpResponse res) {
        super(res);
        init(res.getResponseJson().getJSONObject("data"));
    }

    Board(JSONObject json) {
        init(json);
    }

    private void init(JSONObject json) {
        this.id = JsonUtil.getString("id", json);
        this.name = JsonUtil.getString("name", json);
        if (!json.isNull("creator")) {
            this.creator = new User(json.getJSONObject("creator"));
        }
        this.url = JsonUtil.getString("url", json);
        this.createdAt = new DateTime(JsonUtil.getString("created_at", json));
        this.privacy = JsonUtil.getString("privacy", json);
        this.imageUrl = JsonUtil.getImageUrl60x60(json);

        if (!json.isNull("counts")) {
            JSONObject counts = json.getJSONObject("counts");
            this.counts = new Counts(counts);
        }

        this.description = JsonUtil.getString("description", json);
    }

    public static ResponseList<Board> createBoardList(HttpResponse res) throws PinterestException {
        try {

            JSONArray list = res.getResponseJson().getJSONArray("data");
            int size = list.length();
            ResponseList<Board> boards = new ResponseListImpl<>(size, res);

            for(int index = 0; index < size; index++) {
                JSONObject boardJson = list.getJSONObject(index);
                boards.add(new Board(boardJson));
            }

            return boards;

        } catch (JSONException e){
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public static PageResponseList<Board> createPageBoardList(HttpResponse res) throws PinterestException {
        try {

            JSONArray list = res.getResponseJson().getJSONArray("data");
            int size = list.length();
            PageResponseList<Board> boards = new PageResponseListImpl<>(size, res);

            for(int index = 0; index < size; index++) {
                JSONObject boardJson = list.getJSONObject(index);
                boards.add(new Board(boardJson));
            }

            return boards;

        } catch (JSONException e){
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getCreator() {
        return creator;
    }

    public String getUrl() {
        return url;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public String getPrivacy() {
        return privacy;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public Counts getCounts() {
        return counts;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creator=" + creator +
                ", url='" + url + '\'' +
                ", createdAt=" + createdAt +
                ", privacy='" + privacy + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", counts=" + counts +
                '}';
    }
}
