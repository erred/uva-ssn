package twitter4j.auth;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;

abstract class OAuthToken implements Serializable {
    private static final long serialVersionUID = -7841506492508140600L;
    private String[] responseStr;
    private transient SecretKeySpec secretKeySpec;
    private final String token;
    private final String tokenSecret;

    public OAuthToken(String str, String str2) {
        this.responseStr = null;
        if (str == null) {
            throw new IllegalArgumentException("Token can't be null");
        } else if (str2 != null) {
            this.token = str;
            this.tokenSecret = str2;
        } else {
            throw new IllegalArgumentException("TokenSecret can't be null");
        }
    }

    OAuthToken(HttpResponse httpResponse) throws TwitterException {
        this(httpResponse.asString());
    }

    OAuthToken(String str) {
        this.responseStr = null;
        this.responseStr = str.split("&");
        this.tokenSecret = getParameter("oauth_token_secret");
        this.token = getParameter("oauth_token");
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenSecret() {
        return this.tokenSecret;
    }

    /* access modifiers changed from: 0000 */
    public void setSecretKeySpec(SecretKeySpec secretKeySpec2) {
        this.secretKeySpec = secretKeySpec2;
    }

    /* access modifiers changed from: 0000 */
    public SecretKeySpec getSecretKeySpec() {
        return this.secretKeySpec;
    }

    public String getParameter(String str) {
        String[] strArr;
        for (String str2 : this.responseStr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('=');
            if (str2.startsWith(sb.toString())) {
                return str2.split(SimpleComparison.EQUAL_TO_OPERATION)[1].trim();
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuthToken)) {
            return false;
        }
        OAuthToken oAuthToken = (OAuthToken) obj;
        return this.token.equals(oAuthToken.token) && this.tokenSecret.equals(oAuthToken.tokenSecret);
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.tokenSecret.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OAuthToken{token='");
        sb.append(this.token);
        sb.append('\'');
        sb.append(", tokenSecret='");
        sb.append(this.tokenSecret);
        sb.append('\'');
        sb.append(", secretKeySpec=");
        sb.append(this.secretKeySpec);
        sb.append('}');
        return sb.toString();
    }
}
