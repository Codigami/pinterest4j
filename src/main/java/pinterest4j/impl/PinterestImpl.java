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
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.json.JsonObjectHelperImpl;
import pinterest4j.util.json.ObjectHelper;

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
        return objectHelper.createUser(http.get(conf.getUsersRestBaseUrl() + "/" + id
                + "?access_token=" + oAuth2Token.getAccessToken()));
    }

    public User getUser(String id, String[] fields) throws PinterestException {
        return objectHelper.createUser(http.get(conf.getUsersRestBaseUrl() + "/" + id
                + "?fields=" + String.join(",", fields) + "&access_token=" + oAuth2Token.getAccessToken()));
    }

    @Override
    public Board getBoard(String id, String board) throws PinterestException {
        return objectHelper.createBoard(http.get(conf.getBoardsRestBaseUrl() + "/" + id + "/" + board
                + "?access_token=" + oAuth2Token.getAccessToken()));
    }

    @Override
    public Board getBoard(String id, String board, String[] fields) throws PinterestException {
        return objectHelper.createBoard(http.get(conf.getBoardsRestBaseUrl() + "/" + id + "/" + board
                + "?fields=" + String.join(",", fields)
                + "&access_token=" + oAuth2Token.getAccessToken()));
    }

    @Override
    public Pin getPin(String id) throws PinterestException {
        return objectHelper.createPin(http.get(conf.getPinsRestBaseUrl() + "/" + id
                + "?access_token=" + oAuth2Token.getAccessToken()));
    }

    @Override
    public Pin getPin(String id, String[] fields) throws PinterestException {
        return objectHelper.createPin(http.get(conf.getPinsRestBaseUrl() + "/" + id
                + "?fields=" + String.join(",", fields)
                + "&access_token=" + oAuth2Token.getAccessToken()));
    }
}
