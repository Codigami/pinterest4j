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
