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

package pinterest4j.config;

/**
 * Configuration class with default settings
 *
 * Created by Aniket Divekar.
 */
public class ConfigurationImpl implements Configuration {

    private static final long serialVersionUID = -912105459125357372L;
    private String restBaseUrl = "https://api.pinterest.com/v1";

    public String getRestBaseUrl() {
        return this.restBaseUrl;
    }

    public String getUsersRestBaseUrl() {
        return this.restBaseUrl + "/users";
    }

    public String getBoardsRestBaseUrl() {
        return this.restBaseUrl + "/boards";
    }

    public String getMeRestBaseUrl() {
        return this.restBaseUrl + "/me";
    }

    public String getPinsRestBaseUrl() {
        return this.restBaseUrl + "/pins";
    }

    protected final void setRestBaseUrl(String restBaseUrl) {
        this.restBaseUrl = restBaseUrl;
    }

}
