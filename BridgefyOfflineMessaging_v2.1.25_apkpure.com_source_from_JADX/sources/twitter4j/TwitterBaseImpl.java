package twitter4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.NullAuthorization;
import twitter4j.auth.OAuth2Authorization;
import twitter4j.auth.OAuth2Support;
import twitter4j.auth.OAuth2Token;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;

abstract class TwitterBaseImpl implements Serializable, HttpResponseListener, TwitterBase, OAuth2Support, OAuthSupport {
    private static final String WWW_DETAILS = "See http://twitter4j.org/en/configuration.html for details";
    private static final long serialVersionUID = -7824361938865528554L;
    Authorization auth;
    Configuration conf;
    ObjectFactory factory;
    transient HttpClient http;

    /* renamed from: id */
    private transient long f9927id = 0;
    private List<RateLimitStatusListener> rateLimitStatusListeners = new ArrayList(0);
    private transient String screenName = null;

    TwitterBaseImpl(Configuration configuration, Authorization authorization) {
        this.conf = configuration;
        this.auth = authorization;
        init();
    }

    private void init() {
        if (this.auth == null) {
            String oAuthConsumerKey = this.conf.getOAuthConsumerKey();
            String oAuthConsumerSecret = this.conf.getOAuthConsumerSecret();
            if (oAuthConsumerKey == null || oAuthConsumerSecret == null) {
                this.auth = NullAuthorization.getInstance();
            } else if (this.conf.isApplicationOnlyAuthEnabled()) {
                OAuth2Authorization oAuth2Authorization = new OAuth2Authorization(this.conf);
                String oAuth2TokenType = this.conf.getOAuth2TokenType();
                String oAuth2AccessToken = this.conf.getOAuth2AccessToken();
                if (!(oAuth2TokenType == null || oAuth2AccessToken == null)) {
                    oAuth2Authorization.setOAuth2Token(new OAuth2Token(oAuth2TokenType, oAuth2AccessToken));
                }
                this.auth = oAuth2Authorization;
            } else {
                OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                String oAuthAccessToken = this.conf.getOAuthAccessToken();
                String oAuthAccessTokenSecret = this.conf.getOAuthAccessTokenSecret();
                if (!(oAuthAccessToken == null || oAuthAccessTokenSecret == null)) {
                    oAuthAuthorization.setOAuthAccessToken(new AccessToken(oAuthAccessToken, oAuthAccessTokenSecret));
                }
                this.auth = oAuthAuthorization;
            }
        }
        this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
        setFactory();
    }

    /* access modifiers changed from: 0000 */
    public void setFactory() {
        this.factory = new JSONImplFactory(this.conf);
    }

    public String getScreenName() throws TwitterException, IllegalStateException {
        if (this.auth.isEnabled()) {
            if (this.screenName == null) {
                if (this.auth instanceof BasicAuthorization) {
                    this.screenName = ((BasicAuthorization) this.auth).getUserId();
                    if (this.screenName.contains("@")) {
                        this.screenName = null;
                    }
                }
                if (this.screenName == null) {
                    fillInIDAndScreenName();
                }
            }
            return this.screenName;
        }
        throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
    }

    public long getId() throws TwitterException, IllegalStateException {
        if (this.auth.isEnabled()) {
            if (0 == this.f9927id) {
                fillInIDAndScreenName();
            }
            return this.f9927id;
        }
        throw new IllegalStateException("Neither user ID/password combination nor OAuth consumer key/secret combination supplied");
    }

    /* access modifiers changed from: 0000 */
    public User fillInIDAndScreenName() throws TwitterException {
        ensureAuthorizationEnabled();
        HttpClient httpClient = this.http;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/verify_credentials.json");
        UserJSONImpl userJSONImpl = new UserJSONImpl(httpClient.get(sb.toString(), null, this.auth, this), this.conf);
        this.screenName = userJSONImpl.getScreenName();
        this.f9927id = userJSONImpl.getId();
        return userJSONImpl;
    }

    public void addRateLimitStatusListener(RateLimitStatusListener rateLimitStatusListener) {
        this.rateLimitStatusListeners.add(rateLimitStatusListener);
    }

    public void httpResponseReceived(HttpResponseEvent httpResponseEvent) {
        int i;
        RateLimitStatus rateLimitStatus;
        if (this.rateLimitStatusListeners.size() != 0) {
            HttpResponse response = httpResponseEvent.getResponse();
            TwitterException twitterException = httpResponseEvent.getTwitterException();
            if (twitterException != null) {
                rateLimitStatus = twitterException.getRateLimitStatus();
                i = twitterException.getStatusCode();
            } else {
                RateLimitStatus createRateLimitStatusFromResponseHeader = JSONImplFactory.createRateLimitStatusFromResponseHeader(response);
                i = response.getStatusCode();
                rateLimitStatus = createRateLimitStatusFromResponseHeader;
            }
            if (rateLimitStatus != null) {
                RateLimitStatusEvent rateLimitStatusEvent = new RateLimitStatusEvent(this, rateLimitStatus, httpResponseEvent.isAuthenticated());
                if (i == 420 || i == 503 || i == 429) {
                    for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
                        rateLimitStatusListener.onRateLimitStatus(rateLimitStatusEvent);
                        rateLimitStatusListener.onRateLimitReached(rateLimitStatusEvent);
                    }
                    return;
                }
                for (RateLimitStatusListener onRateLimitStatus : this.rateLimitStatusListeners) {
                    onRateLimitStatus.onRateLimitStatus(rateLimitStatusEvent);
                }
            }
        }
    }

    public final Authorization getAuthorization() {
        return this.auth;
    }

    public Configuration getConfiguration() {
        return this.conf;
    }

    /* access modifiers changed from: 0000 */
    public final void ensureAuthorizationEnabled() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException("Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for details");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void ensureOAuthEnabled() {
        if (!(this.auth instanceof OAuthAuthorization)) {
            throw new IllegalStateException("OAuth required. Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for details");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.putFields();
        objectOutputStream.writeFields();
        objectOutputStream.writeObject(this.conf);
        objectOutputStream.writeObject(this.auth);
        ArrayList arrayList = new ArrayList(0);
        for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
            if (rateLimitStatusListener instanceof Serializable) {
                arrayList.add(rateLimitStatusListener);
            }
        }
        objectOutputStream.writeObject(arrayList);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.readFields();
        this.conf = (Configuration) objectInputStream.readObject();
        this.auth = (Authorization) objectInputStream.readObject();
        this.rateLimitStatusListeners = (List) objectInputStream.readObject();
        this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
        setFactory();
    }

    public synchronized void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("consumer key is null");
        } else if (str2 == null) {
            throw new NullPointerException("consumer secret is null");
        } else if (this.auth instanceof NullAuthorization) {
            if (this.conf.isApplicationOnlyAuthEnabled()) {
                OAuth2Authorization oAuth2Authorization = new OAuth2Authorization(this.conf);
                oAuth2Authorization.setOAuthConsumer(str, str2);
                this.auth = oAuth2Authorization;
            } else {
                OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                oAuthAuthorization.setOAuthConsumer(str, str2);
                this.auth = oAuthAuthorization;
            }
        } else if (this.auth instanceof BasicAuthorization) {
            XAuthAuthorization xAuthAuthorization = new XAuthAuthorization((BasicAuthorization) this.auth);
            xAuthAuthorization.setOAuthConsumer(str, str2);
            this.auth = xAuthAuthorization;
        } else if ((this.auth instanceof OAuthAuthorization) || (this.auth instanceof OAuth2Authorization)) {
            throw new IllegalStateException("consumer key/secret pair already set.");
        }
    }

    public RequestToken getOAuthRequestToken() throws TwitterException {
        return getOAuthRequestToken(null);
    }

    public RequestToken getOAuthRequestToken(String str) throws TwitterException {
        return getOAuth().getOAuthRequestToken(str);
    }

    public RequestToken getOAuthRequestToken(String str, String str2) throws TwitterException {
        return getOAuth().getOAuthRequestToken(str, str2);
    }

    public synchronized AccessToken getOAuthAccessToken() throws TwitterException {
        AccessToken accessToken;
        Authorization authorization = getAuthorization();
        if (authorization instanceof BasicAuthorization) {
            BasicAuthorization basicAuthorization = (BasicAuthorization) authorization;
            Authorization instance = AuthorizationFactory.getInstance(this.conf);
            if (instance instanceof OAuthAuthorization) {
                this.auth = instance;
                accessToken = ((OAuthAuthorization) instance).getOAuthAccessToken(basicAuthorization.getUserId(), basicAuthorization.getPassword());
            } else {
                throw new IllegalStateException("consumer key / secret combination not supplied.");
            }
        } else if (authorization instanceof XAuthAuthorization) {
            XAuthAuthorization xAuthAuthorization = (XAuthAuthorization) authorization;
            this.auth = xAuthAuthorization;
            OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
            oAuthAuthorization.setOAuthConsumer(xAuthAuthorization.getConsumerKey(), xAuthAuthorization.getConsumerSecret());
            accessToken = oAuthAuthorization.getOAuthAccessToken(xAuthAuthorization.getUserId(), xAuthAuthorization.getPassword());
        } else {
            accessToken = getOAuth().getOAuthAccessToken();
        }
        this.screenName = accessToken.getScreenName();
        this.f9927id = accessToken.getUserId();
        return accessToken;
    }

    public synchronized AccessToken getOAuthAccessToken(String str) throws TwitterException {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(str);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken) throws TwitterException {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(requestToken);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken, String str) throws TwitterException {
        return getOAuth().getOAuthAccessToken(requestToken, str);
    }

    public synchronized void setOAuthAccessToken(AccessToken accessToken) {
        getOAuth().setOAuthAccessToken(accessToken);
    }

    public synchronized AccessToken getOAuthAccessToken(String str, String str2) throws TwitterException {
        return getOAuth().getOAuthAccessToken(str, str2);
    }

    private OAuthSupport getOAuth() {
        if (this.auth instanceof OAuthSupport) {
            return (OAuthSupport) this.auth;
        }
        throw new IllegalStateException("OAuth consumer key/secret combination not supplied");
    }

    public synchronized OAuth2Token getOAuth2Token() throws TwitterException {
        return getOAuth2().getOAuth2Token();
    }

    public void setOAuth2Token(OAuth2Token oAuth2Token) {
        getOAuth2().setOAuth2Token(oAuth2Token);
    }

    public synchronized void invalidateOAuth2Token() throws TwitterException {
        getOAuth2().invalidateOAuth2Token();
    }

    private OAuth2Support getOAuth2() {
        if (this.auth instanceof OAuth2Support) {
            return (OAuth2Support) this.auth;
        }
        throw new IllegalStateException("OAuth consumer key/secret combination not supplied");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterBaseImpl)) {
            return false;
        }
        TwitterBaseImpl twitterBaseImpl = (TwitterBaseImpl) obj;
        if (this.auth == null ? twitterBaseImpl.auth != null : !this.auth.equals(twitterBaseImpl.auth)) {
            return false;
        }
        if (!this.conf.equals(twitterBaseImpl.conf)) {
            return false;
        }
        if (this.http == null ? twitterBaseImpl.http == null : this.http.equals(twitterBaseImpl.http)) {
            return this.rateLimitStatusListeners.equals(twitterBaseImpl.rateLimitStatusListeners);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.conf.hashCode() * 31) + (this.http != null ? this.http.hashCode() : 0)) * 31) + this.rateLimitStatusListeners.hashCode()) * 31;
        if (this.auth != null) {
            i = this.auth.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwitterBase{conf=");
        sb.append(this.conf);
        sb.append(", http=");
        sb.append(this.http);
        sb.append(", rateLimitStatusListeners=");
        sb.append(this.rateLimitStatusListeners);
        sb.append(", auth=");
        sb.append(this.auth);
        sb.append('}');
        return sb.toString();
    }
}
