package twitter4j;

import java.io.Serializable;
import twitter4j.auth.Authorization;
import twitter4j.auth.BasicAuthorization;

public class XAuthAuthorization implements Serializable, Authorization {
    private static final long serialVersionUID = -7260372598870697494L;
    private final BasicAuthorization basic;
    private String consumerKey;
    private String consumerSecret;

    public XAuthAuthorization(BasicAuthorization basicAuthorization) {
        this.basic = basicAuthorization;
    }

    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return this.basic.getAuthorizationHeader(httpRequest);
    }

    public String getUserId() {
        return this.basic.getUserId();
    }

    public String getPassword() {
        return this.basic.getPassword();
    }

    public String getConsumerKey() {
        return this.consumerKey;
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public synchronized void setOAuthConsumer(String str, String str2) {
        this.consumerKey = str;
        this.consumerSecret = str2;
    }

    public boolean isEnabled() {
        return this.basic.isEnabled();
    }
}
