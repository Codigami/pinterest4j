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

package pinterest4j.util.json;

import pinterest4j.entity.Board;
import pinterest4j.entity.Interest;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.exception.PinterestException;
import pinterest4j.util.http.HttpResponse;
import pinterest4j.util.list.PageResponseList;
import pinterest4j.util.list.ResponseList;

/**
 * Helper class to create Objects using response from Pinterest
 *
 * Created by Aniket Divekar.
 */
public class JsonObjectHelperImpl implements ObjectHelper {

    public User createUser(HttpResponse res) {
        return new User(res);
    }

    @Override
    public Board createBoard(HttpResponse res) {
        return new Board(res);
    }

    @Override
    public Pin createPin(HttpResponse res) {
        return new Pin(res);
    }

    @Override
    public ResponseList<Board> createBoardList(HttpResponse res) throws PinterestException {
        return Board.createBoardList(res);
    }

    @Override
    public PageResponseList<Board> createPageBoardList(HttpResponse res) throws PinterestException {
        return Board.createPageBoardList(res);
    }

    @Override
    public PageResponseList<User> createPageUserList(HttpResponse res) throws PinterestException {
        return User.createPageUserList(res);
    }

    @Override
    public PageResponseList<Pin> createPagePinList(HttpResponse res) throws PinterestException {
        return Pin.createPagePinList(res);
    }

    @Override
    public PageResponseList<Interest> createPageInterestList(HttpResponse res) throws PinterestException {
        return Interest.createPageInterestList(res);
    }

}

