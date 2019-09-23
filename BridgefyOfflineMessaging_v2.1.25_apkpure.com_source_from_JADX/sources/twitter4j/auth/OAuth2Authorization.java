package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import twitter4j.BASE64Encoder;
import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpRequest;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;

public class OAuth2Authorization implements Serializable, Authorization, OAuth2Support {
    private static final long serialVersionUID = -2895232598422218647L;
    private final Configuration conf;
    private String consumerKey;
    private String consumerSecret;
    private final HttpClient http;
    private OAuth2Token token;

    public OAuth2Authorization(Configuration configuration) {
        this.conf = configuration;
        setOAuthConsumer(configuration.getOAuthConsumerKey(), configuration.getOAuthConsumerSecret());
        this.http = HttpClientFactory.getInstance(configuration.getHttpClientConfiguration());
    }

    public void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.consumerKey = str;
        if (str2 == null) {
            str2 = "";
        }
        this.consumerSecret = str2;
    }

    public OAuth2Token getOAuth2Token() throws TwitterException {
        if (this.token == null) {
            HttpParameter[] httpParameterArr = new HttpParameter[(this.conf.getOAuth2Scope() == null ? 1 : 2)];
            httpParameterArr[0] = new HttpParameter("grant_type", "client_credentials");
            if (this.conf.getOAuth2Scope() != null) {
                httpParameterArr[1] = new HttpParameter("scope", this.conf.getOAuth2Scope());
            }
            HttpResponse post = this.http.post(this.conf.getOAuth2TokenURL(), httpParameterArr, this, null);
            if (post.getStatusCode() == 200) {
                this.token = new OAuth2Token(post);
                return this.token;
            }
            throw new TwitterException("Obtaining OAuth 2 Bearer Token failed.", post);
        }
        throw new IllegalStateException("OAuth 2 Bearer Token is already available.");
    }

    public void setOAuth2Token(OAuth2Token oAuth2Token) {
        this.token = oAuth2Token;
    }

    public void invalidateOAuth2Token() throws TwitterException {
        if (this.token != null) {
            HttpParameter[] httpParameterArr = {new HttpParameter("access_token", this.token.getAccessToken())};
            OAuth2Token oAuth2Token = this.token;
            try {
                this.token = null;
                HttpResponse post = this.http.post(this.conf.getOAuth2InvalidateTokenURL(), httpParameterArr, this, null);
                if (post.getStatusCode() != 200) {
                    throw new TwitterException("Invalidating OAuth 2 Bearer Token failed.", post);
                }
            } catch (Throwable th) {
                this.token = oAuth2Token;
                throw th;
            }
        } else {
            throw new IllegalStateException("OAuth 2 Bearer Token is not available.");
        }
    }

    public String getAuthorizationHeader(HttpRequest httpRequest) {
        if (this.token != null) {
            return this.token.generateAuthorizationHeader();
        }
        String str = "";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(URLEncoder.encode(this.consumerKey, "UTF-8"));
            sb.append(":");
            sb.append(URLEncoder.encode(this.consumerSecret, "UTF-8"));
            str = sb.toString();
        } catch (UnsupportedEncodingException unused) {
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Basic ");
        sb2.append(BASE64Encoder.encode(str.getBytes()));
        return sb2.toString();
    }

    public boolean isEnabled() {
        return this.token != null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OAuth2Authorization)) {
            return false;
        }
        OAuth2Authorization oAuth2Authorization = (OAuth2Authorization) obj;
        if (this.consumerKey == null ? oAuth2Authorization.consumerKey != null : !this.consumerKey.equals(oAuth2Authorization.consumerKey)) {
            return false;
        }
        if (this.consumerSecret == null ? oAuth2Authorization.consumerSecret != null : !this.consumerSecret.equals(oAuth2Authorization.consumerSecret)) {
            return false;
        }
        if (this.token == null ? oAuth2Authorization.token == null : this.token.equals(oAuth2Authorization.token)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.consumerKey != null ? this.consumerKey.hashCode() : 0) * 31) + (this.consumerSecret != null ? this.consumerSecret.hashCode() : 0)) * 31;
        if (this.token != null) {
            i = this.token.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("OAuth2Authorization{consumerKey='");
        sb.append(this.consumerKey);
        sb.append('\'');
        sb.append(", consumerSecret='******************************************'");
        sb.append(", token=");
        if (this.token == null) {
            str = "null";
        } else {
            str = this.token.toString();
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
