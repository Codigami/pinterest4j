package pinterest4j.entity;

import org.joda.time.DateTime;
import org.json.JSONObject;
import pinterest4j.util.http.HttpResponse;
import pinterest4j.util.json.JsonUtil;

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
}
