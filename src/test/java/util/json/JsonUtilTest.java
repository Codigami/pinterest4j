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
import pinterest4j.util.json.JsonUtil;

/**
 * Test cases for {@link JsonUtil}
 *
 * Created by Aniket Divekar.
 */
public class JsonUtilTest extends TestCase {

    private static String RAW_JSON = "{\"id\":\"423etrgdfadsf\", \"followers\": \"1234\", " +
            "\"image\": {\"60x60\": {\"url\": \"https://abcd.com/test.jpeg\"}, " +
            "\"original\": {\"url\": \"https://abcd.com/original.jpeg\"}}}}";
    private static JSONObject jsonObject = new JSONObject(RAW_JSON);

    public void testReturnLong() {
        Assert.assertEquals(1234l, JsonUtil.getLong("followers", jsonObject));
    }

    public void testReturnString() {
        Assert.assertEquals("423etrgdfadsf", JsonUtil.getString("id", jsonObject));
    }

    public void testImageUrl60x60() {
        Assert.assertEquals("https://abcd.com/test.jpeg", JsonUtil.getImageUrl60x60(jsonObject));
    }

    public void testImageUrlOriginal() {
        Assert.assertEquals("https://abcd.com/original.jpeg", JsonUtil.getImageUrlOriginal(jsonObject));
    }
}
