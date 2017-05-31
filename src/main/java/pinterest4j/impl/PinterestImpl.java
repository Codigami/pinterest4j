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

package pinterest4j.impl;

import pinterest4j.api.Pinterest;
import pinterest4j.auth.OAuth2Token;
import pinterest4j.config.Configuration;
import pinterest4j.entity.Board;
import pinterest4j.entity.Interest;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.http.QueryParam;
import pinterest4j.util.http.UrlEncodeUtil;
import pinterest4j.util.json.JsonObjectHelperImpl;
import pinterest4j.util.json.ObjectHelper;
import pinterest4j.util.list.PageResponseList;
import pinterest4j.util.list.ResponseList;

import java.io.File;

/**
 * This class is representation of Pinterest REST APIs
 *
 * Created by Aniket Divekar.
 */
public class PinterestImpl extends PinterestBase implements Pinterest {

    private static final long serialVersionUID = 4683756956434000684L;

    private ObjectHelper objectHelper;

    public PinterestImpl(Configuration conf, OAuth2Token oAuth2Token) {
        super(conf, oAuth2Token);
        objectHelper = new JsonObjectHelperImpl();
    }

    public User getUser(String id) throws PinterestException {
        return objectHelper.createUser(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getUsersRestBaseUrl() + "/" + id,
                        new QueryParam("access_token", oAuth2Token.getAccessToken()))));
    }

    public User getUser(String id, String[] fields) throws PinterestException {
        return objectHelper.createUser(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getUsersRestBaseUrl() + "/" + id,
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)))));
    }

    @Override
    public Board getBoard(String username, String board) throws PinterestException {
        return objectHelper.createBoard(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/" + username + "/" + board.replaceAll(" +", "-"),
                        new QueryParam("access_token", oAuth2Token.getAccessToken()))));
    }

    @Override
    public Board getBoard(String username, String board, String[] fields) throws PinterestException {
        return objectHelper.createBoard(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/" + username + "/" + board.replaceAll(" +", "-"),
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)))));
    }

    @Override
    public PageResponseList<Pin> getBoardPins(String username, String board, String cursor) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/" + username + "/" + board.replaceAll(" +", "-") + "/pins",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Pin> getBoardPins(String username, String board, String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/" + username + "/" + board.replaceAll(" +", "-") + "/pins",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public Board createBoard(String username, String board, String description) throws PinterestException {
        return objectHelper.createBoard(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("name", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("description", description)
                }));
    }

    @Override
    public Board createBoard(String username, String board, String description, String[] fields) throws PinterestException {
        return objectHelper.createBoard(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields))),
                new QueryParam[] {
                        new QueryParam("name", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("description", description)
                }));
    }

    @Override
    public Board editBoard(String username, String board, String name, String description) throws PinterestException {
        return objectHelper.createBoard(http.patch(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/" + username + "/" + board.replaceAll(" +", "-"),
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("name", name),
                        new QueryParam("description", description)
                }));
    }

    @Override
    public Board editBoard(String username, String board, String name, String description, String[] fields) throws PinterestException {
        return objectHelper.createBoard(http.patch(
                UrlEncodeUtil.getEncodedUrl(conf.getBoardsRestBaseUrl() + "/" + username + "/" + board.replaceAll(" +", "-"),
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields))),
                new QueryParam[] {
                        new QueryParam("name", name),
                        new QueryParam("description", description)
                }));
    }

    @Override
    public void deleteBoard(String username, String board) throws PinterestException {
        http.delete(
                UrlEncodeUtil.getEncodedUrl(
                        conf.getBoardsRestBaseUrl() + "/" + username + "/" + board.replaceAll(" +", "-")
                ));
    }

    @Override
    public Pin getPin(String id) throws PinterestException {
        return objectHelper.createPin(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/" + id,
                        new QueryParam("access_token", oAuth2Token.getAccessToken()))));
    }

    @Override
    public Pin getPin(String id, String[] fields) throws PinterestException {
        return objectHelper.createPin(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/" + id,
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)))));
    }

    @Override
    public Pin editPin(String id, String username, String board, String note, String link) throws PinterestException {
        return objectHelper.createPin(http.patch(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/" + id,
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("link", link),
                        new QueryParam("note", note)
                }));
    }

    @Override
    public Pin editPin(String id, String username, String board, String note, String link, String[] fields) throws PinterestException {
        return objectHelper.createPin(http.patch(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/" + id,
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields))),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("link", link),
                        new QueryParam("note", note)
                }));
    }

    @Override
    public void deletePin(String id) throws PinterestException {
        http.delete(
                UrlEncodeUtil.getEncodedUrl(
                        conf.getPinsRestBaseUrl() + "/" + id
                ));
    }

    @Override
    public Pin createPinWithImageUrl(String username, String board, String note, String link, String imageUrl) throws PinterestException {
        return objectHelper.createPin(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("note", note),
                        new QueryParam("link", link),
                        new QueryParam("image_url", imageUrl)
                }));
    }

    @Override
    public Pin createPinWithImageUrl(String username, String board, String note, String link, String imageUrl, String[] fields) throws PinterestException {
        return objectHelper.createPin(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields))),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("note", note),
                        new QueryParam("link", link),
                        new QueryParam("image_url", imageUrl)
                }));
    }

    @Override
    public Pin createPinWithBase64EncodedImageUrl(String username, String board, String note, String link, String imageUrl) throws PinterestException {
        return objectHelper.createPin(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" ", "-")),
                        new QueryParam("note", note),
                        new QueryParam("link", link),
                        new QueryParam("image_base64", imageUrl)
                }));
    }

    @Override
    public Pin createPinWithBase64EncodedImageUrl(String username, String board, String note, String link, String imageUrl, String[] fields) throws PinterestException {
        return objectHelper.createPin(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields))),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("note", note),
                        new QueryParam("link", link),
                        new QueryParam("image_base64", imageUrl)
                }));
    }

    @Override
    public Pin createPinWithImageFile(String username, String board, String note, String link, File image) throws PinterestException {
        return objectHelper.createPin(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("note", note),
                        new QueryParam("link", link),
                        new QueryParam("image", image)
                }));
    }

    @Override
    public Pin createPinWithImageFile(String username, String board, String note, String link, File image, String[] fields) throws PinterestException {
        return objectHelper.createPin(http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getPinsRestBaseUrl() + "/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields))),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-")),
                        new QueryParam("note", note),
                        new QueryParam("link", link),
                        new QueryParam("image", image)
                }));
    }

    @Override
    public User getMe() throws PinterestException {
        return objectHelper.createUser(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl(),
                        new QueryParam("access_token", oAuth2Token.getAccessToken()))));
    }

    @Override
    public User getMe(String[] fields) throws PinterestException {
        return objectHelper.createUser(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl(),
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)))));
    }

    @Override
    public ResponseList<Board> getMeBoards() throws PinterestException {
        return objectHelper.createBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/boards",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()))));
    }

    @Override
    public ResponseList<Board> getMeBoards(String[] fields) throws PinterestException {
        return objectHelper.createBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/boards",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)))));
    }

    @Override
    public ResponseList<Board> getMeSuggestedBoards(int count, String pin) throws PinterestException {
        return objectHelper.createBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/boards/suggested",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("count", count),
                        new QueryParam("pin", pin))));
    }

    @Override
    public ResponseList<Board> getMeSuggestedBoards(int count, String pin, String[] fields) throws PinterestException {
        return objectHelper.createBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/boards/suggested",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("count", count),
                        new QueryParam("pin", pin))));
    }

    @Override
    public PageResponseList<User> getMeFollowers(String cursor) throws PinterestException {
        return objectHelper.createPageUserList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/followers",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<User> getMeFollowers(String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPageUserList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/followers",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Board> getMeFollowingBoards(String cursor) throws PinterestException {
        return objectHelper.createPageBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/boards",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Board> getMeFollowingBoards(String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPageBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/boards",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<User> getMeFollowing(String cursor) throws PinterestException {
        return objectHelper.createPageUserList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/users",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<User> getMeFollowing(String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPageUserList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/users",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Pin> getMeLikedPins(String cursor) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/likes",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Pin> getMeLikedPins(String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/likes",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Pin> getMePins(String cursor) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/pins",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Pin> getMePins(String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/pins",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Board> searchMeBoards(String query, String cursor) throws PinterestException {
        return objectHelper.createPageBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/search/boards",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("query", query),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Board> searchMeBoards(String query, String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPageBoardList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/search/boards",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("query", query),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Pin> searchMePins(String query, String cursor) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/search/pins",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("query", query),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Pin> searchMePins(String query, String cursor, String[] fields) throws PinterestException {
        return objectHelper.createPagePinList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/search/pins",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("fields", String.join(",", fields)),
                        new QueryParam("query", query),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public PageResponseList<Interest> getMeInterests(String cursor) throws PinterestException {
        return objectHelper.createPageInterestList(http.get(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/interests",
                        new QueryParam("access_token", oAuth2Token.getAccessToken()),
                        new QueryParam("cursor", cursor))));
    }

    @Override
    public void followBoard(String username, String board) throws PinterestException {
        http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/boards/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("board", username + "/" + board.replaceAll(" +", "-"))
                });
    }

    @Override
    public void unfollowBoard(String username, String board) throws PinterestException {
        http.delete(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/boards/" + username + "/" + board.replaceAll(" +", "-"),
                new QueryParam("access_token", oAuth2Token.getAccessToken())
        ));
    }

    @Override
    public void followUser(String id) throws PinterestException {
        http.post(
                UrlEncodeUtil.getEncodedUrl(conf.getMeRestBaseUrl() + "/following/users/",
                        new QueryParam("access_token", oAuth2Token.getAccessToken())),
                new QueryParam[] {
                        new QueryParam("user", id)
                });
    }

    @Override
    public void unfollowUser(String id) throws PinterestException {
        http.delete(
                UrlEncodeUtil.getEncodedUrl(
                        conf.getMeRestBaseUrl() + "/following/users/" + id,
                        new QueryParam("access_token", oAuth2Token.getAccessToken())
                ));
    }
    
}
