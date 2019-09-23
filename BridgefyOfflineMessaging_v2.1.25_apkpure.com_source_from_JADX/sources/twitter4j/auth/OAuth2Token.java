package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import twitter4j.HttpResponse;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.TwitterException;

public class OAuth2Token implements Serializable {
    private static final long serialVersionUID = -8985359441959903216L;
    private String accessToken;
    private String tokenType;

    OAuth2Token(HttpResponse httpResponse) throws TwitterException {
        JSONObject asJSONObject = httpResponse.asJSONObject();
        this.tokenType = getRawString("token_type", asJSONObject);
        try {
            this.accessToken = URLDecoder.decode(getRawString("access_token", asJSONObject), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public OAuth2Token(String str, String str2) {
        this.tokenType = str;
        this.accessToken = str2;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    /* access modifiers changed from: 0000 */
    public String generateAuthorizationHeader() {
        String str = "";
        try {
            str = URLEncoder.encode(this.accessToken, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(str);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OAuth2Token)) {
            return false;
        }
        OAuth2Token oAuth2Token = (OAuth2Token) obj;
        if (this.tokenType == null ? oAuth2Token.tokenType != null : !this.tokenType.equals(oAuth2Token.tokenType)) {
            return false;
        }
        if (this.accessToken == null ? oAuth2Token.accessToken == null : this.accessToken.equals(oAuth2Token.accessToken)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.tokenType != null ? this.tokenType.hashCode() : 0) * 31;
        if (this.accessToken != null) {
            i = this.accessToken.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OAuth2Token{tokenType='");
        sb.append(this.tokenType);
        sb.append('\'');
        sb.append(", accessToken='");
        sb.append(this.accessToken);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    private static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
