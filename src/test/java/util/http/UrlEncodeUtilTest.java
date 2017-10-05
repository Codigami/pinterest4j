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

package util.http;

import junit.framework.TestCase;
import org.junit.Assert;
import pinterest4j.util.http.QueryParam;
import pinterest4j.util.http.UrlEncodeUtil;

/**
 * Test cases for {@link UrlEncodeUtil}
 *
 * Created by Aniket Divekar.
 */
public class UrlEncodeUtilTest extends TestCase {

    public void testEncodeParams() {
        QueryParam[] queryParams = new QueryParam[] {
                new QueryParam("name", "test name"),
                new QueryParam("description", "test_description"),
                new QueryParam("fields", String.join(",", new String[] {"id", "board"}))
        };
        Assert.assertEquals("name=test%20name&description=test_description&fields=id%2Cboard",
                UrlEncodeUtil.encodeParams(queryParams));
    }

    public void testGetEncodedUrl() {
        QueryParam[] queryParams = new QueryParam[] {
                new QueryParam("name", "test name"),
                new QueryParam("description", "test_description")
        };
        Assert.assertEquals("https://api.pinterest.com/v1?name=test%20name&description=test_description",
                UrlEncodeUtil.getEncodedUrl("https://api.pinterest.com/v1", queryParams));
    }
}
