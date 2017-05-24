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

import pinterest4j.auth.OAuth2Token;
import pinterest4j.config.Configuration;
import pinterest4j.util.http.HttpClient;
import pinterest4j.util.http.HttpClientImpl;

import java.io.Serializable;

/**
 * Base class for Pinteres to support OAuth
 *
 * Created by Aniket Divekar.
 */
abstract class PinterestBase implements Serializable {

    private static final long serialVersionUID = -8515484116132831232L;

    Configuration conf;
    OAuth2Token oAuth2Token;
    HttpClient http = new HttpClientImpl();

    PinterestBase(Configuration conf, OAuth2Token oAuth2Token) {
        this.conf = conf;
        this.oAuth2Token = oAuth2Token;
    }
}
