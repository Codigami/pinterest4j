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

package pinterest4j.entity;

import org.json.JSONObject;
import pinterest4j.util.json.JsonUtil;

import java.io.Serializable;

/**
 * Entity representing Pinterest Media
 *
 * Created by Aniket Divekar.
 */
public class Media implements Serializable{

    private static final long serialVersionUID = 8565758825062577871L;

    private String type;

    public Media(JSONObject json) {
        this.type = JsonUtil.getString("type", json);
    }

    public String getType() {
        return type;
    }
}
