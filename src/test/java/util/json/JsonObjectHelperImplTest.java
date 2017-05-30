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

package util.json;

import junit.framework.TestCase;
import org.json.JSONObject;
import org.junit.Assert;
import pinterest4j.entity.Board;
import pinterest4j.entity.Pin;
import pinterest4j.entity.User;
import pinterest4j.util.http.HttpResponse;
import pinterest4j.util.json.JsonObjectHelperImpl;
import pinterest4j.util.json.ObjectHelper;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test cases for {@link JsonObjectHelperImpl}
 *
 * Created by Aniket Divekar.
 */
public class JsonObjectHelperImplTest extends TestCase {

    private static ObjectHelper objectHelper = new JsonObjectHelperImpl();

    public void testCreateBoard() {
        String RAW_BOARD_JSON = "{\"data\": {\"name\": \"Techies\", \"creator\": {\"url\": \"https://www.pinterest.com/username/\", " +
                "\"first_name\": \"Bob\", \"last_name\": \"Builder\", \"id\": \"750141019092329713\"}, " +
                "\"url\": \"https://www.pinterest.com/username/techies/\", \"created_at\": \"2016-08-01T09:45:39\", " +
                "\"privacy\": \"public\", \"reason\": null, " +
                "\"image\": {\"60x60\": {\"url\": \"https://abcd.com/2e9a216cf54ebe02c5c91f904c13f5a3.jpg\", " +
                "\"width\": 60, \"height\": 60}}, \"counts\": {\"pins\": 1, \"collaborators\": 0, \"followers\": 5}," +
                " \"id\": \"750140950372852834\", \"description\": \"\"}}";


        HttpResponse resp = new HttpResponse(HttpURLConnection.HTTP_OK, RAW_BOARD_JSON,
                new JSONObject(RAW_BOARD_JSON), null);
        Board board = objectHelper.createBoard(resp);

        Assert.assertEquals("750140950372852834", board.getId());
        Assert.assertEquals("Techies", board.getName());
        Assert.assertEquals("750141019092329713", board.getCreator().getId());
        Assert.assertEquals("public", board.getPrivacy());
        Assert.assertEquals(1, board.getCounts().getPins());
        Assert.assertEquals(0, board.getCounts().getCollaborators());
        Assert.assertEquals(5,  board.getCounts().getFollowers());
        Assert.assertEquals("https://abcd.com/2e9a216cf54ebe02c5c91f904c13f5a3.jpg", board.getImageUrl());
    }

    public void testCreateUser() {
        String RAW_USER_JSON = "{\"data\": {\"username\": \"username\", \"bio\": \"\", \"first_name\": \"Bob\", " +
                "\"last_name\": \"Builder\", \"account_type\": \"individual\", " +
                "\"url\": \"https://www.pinterest.com/username/\", \"created_at\": \"2016-08-01T08:17:04\", " +
                "\"image\": {\"60x60\": {\"url\": \"https://abce.com/username_1470039428_60.jpg\", " +
                "\"width\": 60, \"height\": 60}}, \"counts\": {\"pins\": 129, \"following\": 7, \"followers\": 5, " +
                "\"boards\": 6, \"likes\": 6}, \"id\": \"750131012032379713\"}}";

        HttpResponse resp = new HttpResponse(HttpURLConnection.HTTP_OK, RAW_USER_JSON,
                new JSONObject(RAW_USER_JSON), getResponseHeaders());
        User user = objectHelper.createUser(resp);

        Assert.assertEquals("750131012032379713", user.getId());
        Assert.assertEquals("username", user.getUsername());
        Assert.assertEquals("Bob", user.getFirstName());
        Assert.assertEquals("Builder", user.getLastName());
        Assert.assertEquals("individual", user.getAccountType());
        Assert.assertEquals(5,  user.getCounts().getFollowers());
        Assert.assertEquals(6,  user.getCounts().getBoards());
        Assert.assertEquals(129,  user.getCounts().getPins());
        Assert.assertEquals("https://abce.com/username_1470039428_60.jpg", user.getImageUrl());
        Assert.assertNotNull(user.getRateLimitStatus());
    }


    public void testCreatePin() {
        String RAW_PIN_JSON = "{\"data\": {\"attribution\": null, \"creator\": " +
                "{\"url\": \"https://www.pinterest.com/username/\", \"first_name\": \"Bob\", \"last_name\": \"Builder\"," +
                " \"id\": \"750231019092329713\"}, \"url\": \"https://www.pinterest.com/pin/750130881654060304/\", " +
                "\"media\": {\"type\": \"image\"}, \"created_at\": \"2017-01-29T07:32:00\", " +
                "\"original_link\": \"http://manof2moro.tumblr.com/post/146617473475\", \"note\": \"Jon Snow - Neil Davies\", " +
                "\"color\": \"#838383\", " +
                "\"link\": \"https://www.pinterest.com/r/pin/750230881654060304/4779055074072594921/7c9050684d0ed8b9ba33348a385b9a4b8620c1c07793f3577f73c449fcd78a3f\", " +
                "\"board\": {\"url\": \"https://www.pinterest.com/username/game-of-thrones/\", " +
                "\"id\": \"750230950372884440\", \"name\": \"Game of Thrones.\"}, " +
                "\"image\": {\"original\": " +
                "{\"url\": \"https://s-media-cache-ak0.pinimg.com/originals/53/aa/e9/53aae9cdc912d0de034b3f8a689a73ce.jpg\", " +
                "\"width\": 700, \"height\": 1008}}, " +
                "\"counts\": {\"likes\": 2, \"comments\": 0, \"repins\": 5}, \"id\": \"750130881654060304\"}}";

        HttpResponse resp = new HttpResponse(HttpURLConnection.HTTP_OK, RAW_PIN_JSON,
                new JSONObject(RAW_PIN_JSON), null);
        Pin pin = objectHelper.createPin(resp);

        Assert.assertEquals("750130881654060304", pin.getId());
        Assert.assertEquals("750231019092329713", pin.getCreator().getId());
        Assert.assertEquals("Jon Snow - Neil Davies", pin.getNote());
        Assert.assertEquals("#838383", pin.getColor());
        Assert.assertEquals("750230950372884440", pin.getBoard().getId());
        Assert.assertEquals(0, pin.getCounts().getComments());
        Assert.assertNotNull(pin.getMedia());
    }

    private Map<String, List<String>> getResponseHeaders() {
        Map<String, List<String>> headers = new HashMap<>();

        headers.put("X-Ratelimit-Limit", Collections.singletonList("1000"));
        headers.put("X-Ratelimit-Remaining", Collections.singletonList("95"));

        return headers;
    }
}
