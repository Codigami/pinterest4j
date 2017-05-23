package pinterest4j.entity;

import org.json.JSONObject;
import pinterest4j.util.json.JsonUtil;

import java.io.Serializable;

/**
 * Entity representing Pinterest Counts(count of pins, followings, followers, boards, likes, collaborators)
 *
 * Created by Aniket Divekar.
 */
public class Counts  implements Serializable{

    private static final long serialVersionUID = 7797933474836307126L;
    private long pins;
    private long following;
    private long followers;
    private long boards;
    private long likes;
    private long collaborators;
    private long comments;
    private long repins;

    public Counts(JSONObject json) {
        this.pins = JsonUtil.getLong("pins", json);
        this.following = JsonUtil.getLong("following", json);
        this.followers = JsonUtil.getLong("followers", json);
        this.boards = JsonUtil.getLong("boards", json);
        this.likes = JsonUtil.getLong("likes", json);
        this.collaborators = JsonUtil.getLong("collaborators", json);
        this.comments = JsonUtil.getLong("comments", json);
        this.repins = JsonUtil.getLong("repins", json);
    }

    public long getPins() {
        return pins;
    }

    public long getFollowing() {
        return following;
    }

    public long getFollowers() {
        return followers;
    }

    public long getBoards() {
        return boards;
    }

    public long getLikes() {
        return likes;
    }

    public long getCollaborators() {
        return collaborators;
    }
}
