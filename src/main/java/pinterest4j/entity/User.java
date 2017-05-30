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

import java.io.Serializable;

/**
 * Entity representing Pinterest User
 *
 * Created by Aniket Divekar.
 */
public class User extends PinterestBaseEntity implements Serializable{

    private static final long serialVersionUID = -1966121343500495296L;
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String accountType;
    private String bio;
    private String url;
    private DateTime createdAt;
    private Counts counts;
    private String imageUrl;


    public User(HttpResponse res) {
        super(res);
        init(res.getResponseJson().getJSONObject("data"));
    }

    User(JSONObject json) {
        init(json);
    }

    private void init(JSONObject json) {
        this.id = JsonUtil.getString("id", json);
        this.username = JsonUtil.getString("username", json);
        this.firstName = JsonUtil.getString("first_name", json);
        this.lastName = JsonUtil.getString("last_name", json);
        this.accountType = JsonUtil.getString("account_type", json);
        this.bio = JsonUtil.getString("bio", json);
        this.url = JsonUtil.getString("url", json);
        this.createdAt = new DateTime(JsonUtil.getString("created_at", json));
        this.imageUrl = JsonUtil.getImageUrl60x60(json);

        if (!json.isNull("counts")) {
            JSONObject counts = json.getJSONObject("counts");
            this.counts = new Counts(counts);
        }
    }

    public static PageResponseList<User> createPageUserList(HttpResponse res) throws PinterestException{
        try {
            JSONArray list = res.getResponseJson().getJSONArray("data");
            int size = list.length();
            PageResponseList<User> users = new PageResponseListImpl<>(size, res);

            for(int index = 0; index < size; index++) {
                JSONObject userJson = list.getJSONObject(index);
                users.add(new User(userJson));
            }

            return users;

        } catch (JSONException e){
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBio() {
        return bio;
    }

    public String getUrl() {
        return url;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public Counts getCounts() {
        return counts;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", bio='" + bio + '\'' +
                ", url='" + url + '\'' +
                ", createdAt=" + createdAt +
                ", counts=" + counts +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
