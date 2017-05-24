package pinterest4j.entity;

import org.joda.time.DateTime;
import org.json.JSONObject;
import pinterest4j.util.http.HttpResponse;
import pinterest4j.util.json.JsonUtil;

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
}
