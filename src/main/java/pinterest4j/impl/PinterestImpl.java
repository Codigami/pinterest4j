package pinterest4j.impl;

import pinterest4j.api.Pinterest;
import pinterest4j.auth.OAuth2Token;
import pinterest4j.config.Configuration;
import pinterest4j.entity.Board;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.json.JsonObjectFactoryImpl;
import pinterest4j.util.json.ObjectFactory;

/**
 *
 *
 * Created by Aniket Divekar.
 */
public class PinterestImpl extends PinterestBase implements Pinterest {

    private static final long serialVersionUID = 4683756956434000684L;

    private ObjectFactory objectFactory;

    public PinterestImpl(Configuration conf, OAuth2Token oAuth2Token) {
        super(conf, oAuth2Token);
        objectFactory = new JsonObjectFactoryImpl();
    }

    public User getUser(String id) throws PinterestException {
        return objectFactory.createUser(http.get(conf.getUsersRestBaseUrl() + "/" + id
                + "?access_token=" + oAuth2Token.getAccessToken()).getResponseJson());
    }

    public User getUser(String id, String[] fields) throws PinterestException {
        return objectFactory.createUser(http.get(conf.getUsersRestBaseUrl() + "/" + id
                + "?fields=" + String.join(",", fields) + "&access_token=" + oAuth2Token.getAccessToken()).getResponseJson());
    }

    @Override
    public Board getBoard(String id, String board) throws PinterestException {
        return objectFactory.createBoard(http.get(conf.getBoardsRestBaseUrl() + "/" + id + "/" + board
                + "?access_token=" + oAuth2Token.getAccessToken()).getResponseJson());
    }

    @Override
    public Board getBoard(String id, String board, String[] fields) throws PinterestException {
        return objectFactory.createBoard(http.get(conf.getBoardsRestBaseUrl() + "/" + id + "/" + board
                + "?fields=" + String.join(",", fields)
                + "&access_token=" + oAuth2Token.getAccessToken()).getResponseJson());
    }

    @Override
    public Pin getPin(String id) throws PinterestException {
        return objectFactory.createPin(http.get(conf.getPinsRestBaseUrl() + "/" + id
                + "?access_token=" + oAuth2Token.getAccessToken()).getResponseJson());
    }

    @Override
    public Pin getPin(String id, String[] fields) throws PinterestException {
        return objectFactory.createPin(http.get(conf.getPinsRestBaseUrl() + "/" + id
                + "?fields=" + String.join(",", fields)
                + "&access_token=" + oAuth2Token.getAccessToken()).getResponseJson());
    }
}
