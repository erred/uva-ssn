package twitter4j.conf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import twitter4j.HttpClientConfiguration;
import twitter4j.Logger;

class ConfigurationBase implements Serializable, Configuration {
    private static final List<ConfigurationBase> instances = new ArrayList();
    private static final long serialVersionUID = 6175546394599249696L;
    private boolean applicationOnlyAuthEnabled = false;
    private int asyncNumThreads = 1;
    private long contributingTo = -1;
    private boolean daemonEnabled = true;
    private boolean debug = false;
    private String dispatcherImpl = "twitter4j.DispatcherImpl";
    private HttpClientConfiguration httpConf;
    /* access modifiers changed from: private */
    public int httpRetryCount = 0;
    /* access modifiers changed from: private */
    public int httpRetryIntervalSeconds = 5;
    private int httpStreamingReadTimeout = 40000;
    private boolean includeEntitiesEnabled = true;
    private boolean includeMyRetweetEnabled = true;
    private boolean jsonStoreEnabled = false;
    private String loggerFactory = null;
    private boolean mbeanEnabled = false;
    private String mediaProvider = "TWITTER";
    private String mediaProviderAPIKey = null;
    private Properties mediaProviderParameters = null;
    private String oAuth2AccessToken;
    private String oAuth2InvalidateTokenURL = "https://api.twitter.com/oauth2/invalidate_token";
    private String oAuth2Scope;
    private String oAuth2TokenType;
    private String oAuth2TokenURL = "https://api.twitter.com/oauth2/token";
    private String oAuthAccessToken = null;
    private String oAuthAccessTokenSecret = null;
    private String oAuthAccessTokenURL = "https://api.twitter.com/oauth/access_token";
    private String oAuthAuthenticationURL = "https://api.twitter.com/oauth/authenticate";
    private String oAuthAuthorizationURL = "https://api.twitter.com/oauth/authorize";
    private String oAuthConsumerKey = null;
    private String oAuthConsumerSecret = null;
    private String oAuthRequestTokenURL = "https://api.twitter.com/oauth/request_token";
    private String password = null;
    private String restBaseURL = "https://api.twitter.com/1.1/";
    private String siteStreamBaseURL = "https://sitestream.twitter.com/1.1/";
    private boolean stallWarningsEnabled = true;
    private String streamBaseURL = "https://stream.twitter.com/1.1/";
    private boolean trimUserEnabled = false;
    private String uploadBaseURL = "https://upload.twitter.com/1.1/";
    private String user = null;
    private String userStreamBaseURL = "https://userstream.twitter.com/1.1/";
    private boolean userStreamRepliesAllEnabled = false;
    private boolean userStreamWithFollowingsEnabled = true;

    class MyHttpClientConfiguration implements Serializable, HttpClientConfiguration {
        private static final long serialVersionUID = 8226866124868861058L;
        private boolean gzipEnabled = true;
        private int httpConnectionTimeout = 20000;
        private String httpProxyHost = null;
        private String httpProxyPassword = null;
        private int httpProxyPort = -1;
        private String httpProxyUser = null;
        private int httpReadTimeout = 120000;
        private boolean prettyDebug = false;

        MyHttpClientConfiguration(String str, String str2, String str3, int i, int i2, int i3, boolean z, boolean z2) {
            this.httpProxyHost = str;
            this.httpProxyUser = str2;
            this.httpProxyPassword = str3;
            this.httpProxyPort = i;
            this.httpConnectionTimeout = i2;
            this.httpReadTimeout = i3;
            this.prettyDebug = z;
            this.gzipEnabled = z2;
        }

        public String getHttpProxyHost() {
            return this.httpProxyHost;
        }

        public int getHttpProxyPort() {
            return this.httpProxyPort;
        }

        public String getHttpProxyUser() {
            return this.httpProxyUser;
        }

        public String getHttpProxyPassword() {
            return this.httpProxyPassword;
        }

        public int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }

        public int getHttpReadTimeout() {
            return this.httpReadTimeout;
        }

        public int getHttpRetryCount() {
            return ConfigurationBase.this.httpRetryCount;
        }

        public int getHttpRetryIntervalSeconds() {
            return ConfigurationBase.this.httpRetryIntervalSeconds;
        }

        public boolean isPrettyDebugEnabled() {
            return this.prettyDebug;
        }

        public boolean isGZIPEnabled() {
            return this.gzipEnabled;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MyHttpClientConfiguration myHttpClientConfiguration = (MyHttpClientConfiguration) obj;
            if (this.gzipEnabled != myHttpClientConfiguration.gzipEnabled || this.httpConnectionTimeout != myHttpClientConfiguration.httpConnectionTimeout || this.httpProxyPort != myHttpClientConfiguration.httpProxyPort || this.httpReadTimeout != myHttpClientConfiguration.httpReadTimeout || this.prettyDebug != myHttpClientConfiguration.prettyDebug) {
                return false;
            }
            if (this.httpProxyHost == null ? myHttpClientConfiguration.httpProxyHost != null : !this.httpProxyHost.equals(myHttpClientConfiguration.httpProxyHost)) {
                return false;
            }
            if (this.httpProxyPassword == null ? myHttpClientConfiguration.httpProxyPassword == null : this.httpProxyPassword.equals(myHttpClientConfiguration.httpProxyPassword)) {
                return this.httpProxyUser == null ? myHttpClientConfiguration.httpProxyUser == null : this.httpProxyUser.equals(myHttpClientConfiguration.httpProxyUser);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.httpProxyHost != null ? this.httpProxyHost.hashCode() : 0) * 31) + (this.httpProxyUser != null ? this.httpProxyUser.hashCode() : 0)) * 31;
            if (this.httpProxyPassword != null) {
                i = this.httpProxyPassword.hashCode();
            }
            return ((((((((((hashCode + i) * 31) + this.httpProxyPort) * 31) + this.httpConnectionTimeout) * 31) + this.httpReadTimeout) * 31) + (this.prettyDebug ? 1 : 0)) * 31) + (this.gzipEnabled ? 1 : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MyHttpClientConfiguration{httpProxyHost='");
            sb.append(this.httpProxyHost);
            sb.append('\'');
            sb.append(", httpProxyUser='");
            sb.append(this.httpProxyUser);
            sb.append('\'');
            sb.append(", httpProxyPassword='");
            sb.append(this.httpProxyPassword);
            sb.append('\'');
            sb.append(", httpProxyPort=");
            sb.append(this.httpProxyPort);
            sb.append(", httpConnectionTimeout=");
            sb.append(this.httpConnectionTimeout);
            sb.append(", httpReadTimeout=");
            sb.append(this.httpReadTimeout);
            sb.append(", prettyDebug=");
            sb.append(this.prettyDebug);
            sb.append(", gzipEnabled=");
            sb.append(this.gzipEnabled);
            sb.append('}');
            return sb.toString();
        }
    }

    protected ConfigurationBase() {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(null, null, null, -1, 20000, 120000, false, true);
        this.httpConf = myHttpClientConfiguration;
    }

    public void dumpConfiguration() {
        Field[] declaredFields;
        // Logger logger = Logger.getLogger(ConfigurationBase.class);
        if (this.debug) {
            for (Field field : ConfigurationBase.class.getDeclaredFields()) {
                try {
                    Object obj = field.get(this);
                    String valueOf = String.valueOf(obj);
                    if (obj != null && field.getName().matches("oAuthConsumerSecret|oAuthAccessTokenSecret|password")) {
                        valueOf = String.valueOf(obj).replaceAll(".", "*");
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(field.getName());
                    sb.append(": ");
                    sb.append(valueOf);
                    logger.debug(sb.toString());
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public final boolean isDebugEnabled() {
        return this.debug;
    }

    /* access modifiers changed from: protected */
    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final String getUser() {
        return this.user;
    }

    /* access modifiers changed from: protected */
    public final void setUser(String str) {
        this.user = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public HttpClientConfiguration getHttpClientConfiguration() {
        return this.httpConf;
    }

    /* access modifiers changed from: protected */
    public final void setPassword(String str) {
        this.password = str;
    }

    /* access modifiers changed from: protected */
    public final void setPrettyDebugEnabled(boolean z) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), z, this.httpConf.isGZIPEnabled());
        this.httpConf = myHttpClientConfiguration;
    }

    /* access modifiers changed from: protected */
    public final void setGZIPEnabled(boolean z) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), z);
        this.httpConf = myHttpClientConfiguration;
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyHost(String str) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(str, this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
        this.httpConf = myHttpClientConfiguration;
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyUser(String str) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), str, this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
        this.httpConf = myHttpClientConfiguration;
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyPassword(String str) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), str, this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
        this.httpConf = myHttpClientConfiguration;
    }

    /* access modifiers changed from: protected */
    public final void setHttpProxyPort(int i) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), i, this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
        this.httpConf = myHttpClientConfiguration;
    }

    /* access modifiers changed from: protected */
    public final void setHttpConnectionTimeout(int i) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), i, this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
        this.httpConf = myHttpClientConfiguration;
    }

    /* access modifiers changed from: protected */
    public final void setHttpReadTimeout(int i) {
        MyHttpClientConfiguration myHttpClientConfiguration = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.getHttpConnectionTimeout(), i, this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
        this.httpConf = myHttpClientConfiguration;
    }

    public int getHttpStreamingReadTimeout() {
        return this.httpStreamingReadTimeout;
    }

    /* access modifiers changed from: protected */
    public final void setHttpStreamingReadTimeout(int i) {
        this.httpStreamingReadTimeout = i;
    }

    /* access modifiers changed from: protected */
    public final void setHttpRetryCount(int i) {
        this.httpRetryCount = i;
    }

    /* access modifiers changed from: protected */
    public final void setHttpRetryIntervalSeconds(int i) {
        this.httpRetryIntervalSeconds = i;
    }

    public final String getOAuthConsumerKey() {
        return this.oAuthConsumerKey;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthConsumerKey(String str) {
        this.oAuthConsumerKey = str;
    }

    public final String getOAuthConsumerSecret() {
        return this.oAuthConsumerSecret;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthConsumerSecret(String str) {
        this.oAuthConsumerSecret = str;
    }

    public String getOAuthAccessToken() {
        return this.oAuthAccessToken;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAccessToken(String str) {
        this.oAuthAccessToken = str;
    }

    public String getOAuthAccessTokenSecret() {
        return this.oAuthAccessTokenSecret;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAccessTokenSecret(String str) {
        this.oAuthAccessTokenSecret = str;
    }

    public String getOAuth2TokenType() {
        return this.oAuth2TokenType;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2TokenType(String str) {
        this.oAuth2TokenType = str;
    }

    public String getOAuth2AccessToken() {
        return this.oAuth2AccessToken;
    }

    public String getOAuth2Scope() {
        return this.oAuth2Scope;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2AccessToken(String str) {
        this.oAuth2AccessToken = str;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2Scope(String str) {
        this.oAuth2Scope = str;
    }

    public final int getAsyncNumThreads() {
        return this.asyncNumThreads;
    }

    /* access modifiers changed from: protected */
    public final void setAsyncNumThreads(int i) {
        this.asyncNumThreads = i;
    }

    public final long getContributingTo() {
        return this.contributingTo;
    }

    /* access modifiers changed from: protected */
    public final void setContributingTo(long j) {
        this.contributingTo = j;
    }

    public String getRestBaseURL() {
        return this.restBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setRestBaseURL(String str) {
        this.restBaseURL = str;
    }

    public String getUploadBaseURL() {
        return this.uploadBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setUploadBaseURL(String str) {
        this.uploadBaseURL = str;
    }

    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setStreamBaseURL(String str) {
        this.streamBaseURL = str;
    }

    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setUserStreamBaseURL(String str) {
        this.userStreamBaseURL = str;
    }

    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }

    /* access modifiers changed from: protected */
    public final void setSiteStreamBaseURL(String str) {
        this.siteStreamBaseURL = str;
    }

    public String getOAuthRequestTokenURL() {
        return this.oAuthRequestTokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthRequestTokenURL(String str) {
        this.oAuthRequestTokenURL = str;
    }

    public String getOAuthAuthorizationURL() {
        return this.oAuthAuthorizationURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAuthorizationURL(String str) {
        this.oAuthAuthorizationURL = str;
    }

    public String getOAuthAccessTokenURL() {
        return this.oAuthAccessTokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAccessTokenURL(String str) {
        this.oAuthAccessTokenURL = str;
    }

    public String getOAuthAuthenticationURL() {
        return this.oAuthAuthenticationURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuthAuthenticationURL(String str) {
        this.oAuthAuthenticationURL = str;
    }

    public String getOAuth2TokenURL() {
        return this.oAuth2TokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2TokenURL(String str) {
        this.oAuth2TokenURL = str;
    }

    public String getOAuth2InvalidateTokenURL() {
        return this.oAuth2InvalidateTokenURL;
    }

    /* access modifiers changed from: protected */
    public final void setOAuth2InvalidateTokenURL(String str) {
        this.oAuth2InvalidateTokenURL = str;
    }

    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }

    /* access modifiers changed from: protected */
    public final void setDispatcherImpl(String str) {
        this.dispatcherImpl = str;
    }

    public String getLoggerFactory() {
        return this.loggerFactory;
    }

    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }

    /* access modifiers changed from: protected */
    public void setIncludeEntitiesEnabled(boolean z) {
        this.includeEntitiesEnabled = z;
    }

    /* access modifiers changed from: protected */
    public final void setLoggerFactory(String str) {
        this.loggerFactory = str;
    }

    public boolean isIncludeMyRetweetEnabled() {
        return this.includeMyRetweetEnabled;
    }

    public void setIncludeMyRetweetEnabled(boolean z) {
        this.includeMyRetweetEnabled = z;
    }

    public boolean isTrimUserEnabled() {
        return this.trimUserEnabled;
    }

    public boolean isDaemonEnabled() {
        return this.daemonEnabled;
    }

    /* access modifiers changed from: protected */
    public void setDaemonEnabled(boolean z) {
        this.daemonEnabled = z;
    }

    public void setTrimUserEnabled(boolean z) {
        this.trimUserEnabled = z;
    }

    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setJSONStoreEnabled(boolean z) {
        this.jsonStoreEnabled = z;
    }

    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setMBeanEnabled(boolean z) {
        this.mbeanEnabled = z;
    }

    public boolean isUserStreamRepliesAllEnabled() {
        return this.userStreamRepliesAllEnabled;
    }

    public boolean isUserStreamWithFollowingsEnabled() {
        return this.userStreamWithFollowingsEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setUserStreamRepliesAllEnabled(boolean z) {
        this.userStreamRepliesAllEnabled = z;
    }

    /* access modifiers changed from: protected */
    public final void setUserStreamWithFollowingsEnabled(boolean z) {
        this.userStreamWithFollowingsEnabled = z;
    }

    public boolean isStallWarningsEnabled() {
        return this.stallWarningsEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setStallWarningsEnabled(boolean z) {
        this.stallWarningsEnabled = z;
    }

    public boolean isApplicationOnlyAuthEnabled() {
        return this.applicationOnlyAuthEnabled;
    }

    /* access modifiers changed from: protected */
    public final void setApplicationOnlyAuthEnabled(boolean z) {
        this.applicationOnlyAuthEnabled = z;
    }

    public String getMediaProvider() {
        return this.mediaProvider;
    }

    /* access modifiers changed from: protected */
    public final void setMediaProvider(String str) {
        this.mediaProvider = str;
    }

    public String getMediaProviderAPIKey() {
        return this.mediaProviderAPIKey;
    }

    /* access modifiers changed from: protected */
    public final void setMediaProviderAPIKey(String str) {
        this.mediaProviderAPIKey = str;
    }

    public Properties getMediaProviderParameters() {
        return this.mediaProviderParameters;
    }

    /* access modifiers changed from: protected */
    public final void setMediaProviderParameters(Properties properties) {
        this.mediaProviderParameters = properties;
    }

    static String fixURL(boolean z, String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("://");
        if (-1 != indexOf) {
            String substring = str.substring(indexOf + 3);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://");
                sb.append(substring);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://");
            sb2.append(substring);
            return sb2.toString();
        }
        throw new IllegalArgumentException("url should contain '://'");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConfigurationBase configurationBase = (ConfigurationBase) obj;
        if (this.applicationOnlyAuthEnabled != configurationBase.applicationOnlyAuthEnabled || this.asyncNumThreads != configurationBase.asyncNumThreads || this.contributingTo != configurationBase.contributingTo || this.daemonEnabled != configurationBase.daemonEnabled || this.debug != configurationBase.debug || this.httpRetryCount != configurationBase.httpRetryCount || this.httpRetryIntervalSeconds != configurationBase.httpRetryIntervalSeconds || this.httpStreamingReadTimeout != configurationBase.httpStreamingReadTimeout || this.includeEntitiesEnabled != configurationBase.includeEntitiesEnabled || this.includeMyRetweetEnabled != configurationBase.includeMyRetweetEnabled || this.jsonStoreEnabled != configurationBase.jsonStoreEnabled || this.mbeanEnabled != configurationBase.mbeanEnabled || this.stallWarningsEnabled != configurationBase.stallWarningsEnabled || this.trimUserEnabled != configurationBase.trimUserEnabled || this.userStreamRepliesAllEnabled != configurationBase.userStreamRepliesAllEnabled || this.userStreamWithFollowingsEnabled != configurationBase.userStreamWithFollowingsEnabled) {
            return false;
        }
        if (this.dispatcherImpl == null ? configurationBase.dispatcherImpl != null : !this.dispatcherImpl.equals(configurationBase.dispatcherImpl)) {
            return false;
        }
        if (this.httpConf == null ? configurationBase.httpConf != null : !this.httpConf.equals(configurationBase.httpConf)) {
            return false;
        }
        if (this.loggerFactory == null ? configurationBase.loggerFactory != null : !this.loggerFactory.equals(configurationBase.loggerFactory)) {
            return false;
        }
        if (this.mediaProvider == null ? configurationBase.mediaProvider != null : !this.mediaProvider.equals(configurationBase.mediaProvider)) {
            return false;
        }
        if (this.mediaProviderAPIKey == null ? configurationBase.mediaProviderAPIKey != null : !this.mediaProviderAPIKey.equals(configurationBase.mediaProviderAPIKey)) {
            return false;
        }
        if (this.mediaProviderParameters == null ? configurationBase.mediaProviderParameters != null : !this.mediaProviderParameters.equals(configurationBase.mediaProviderParameters)) {
            return false;
        }
        if (this.oAuth2AccessToken == null ? configurationBase.oAuth2AccessToken != null : !this.oAuth2AccessToken.equals(configurationBase.oAuth2AccessToken)) {
            return false;
        }
        if (this.oAuth2InvalidateTokenURL == null ? configurationBase.oAuth2InvalidateTokenURL != null : !this.oAuth2InvalidateTokenURL.equals(configurationBase.oAuth2InvalidateTokenURL)) {
            return false;
        }
        if (this.oAuth2TokenType == null ? configurationBase.oAuth2TokenType != null : !this.oAuth2TokenType.equals(configurationBase.oAuth2TokenType)) {
            return false;
        }
        if (this.oAuth2TokenURL == null ? configurationBase.oAuth2TokenURL != null : !this.oAuth2TokenURL.equals(configurationBase.oAuth2TokenURL)) {
            return false;
        }
        if (this.oAuth2Scope == null ? configurationBase.oAuth2Scope != null : !this.oAuth2Scope.equals(configurationBase.oAuth2Scope)) {
            return false;
        }
        if (this.oAuthAccessToken == null ? configurationBase.oAuthAccessToken != null : !this.oAuthAccessToken.equals(configurationBase.oAuthAccessToken)) {
            return false;
        }
        if (this.oAuthAccessTokenSecret == null ? configurationBase.oAuthAccessTokenSecret != null : !this.oAuthAccessTokenSecret.equals(configurationBase.oAuthAccessTokenSecret)) {
            return false;
        }
        if (this.oAuthAccessTokenURL == null ? configurationBase.oAuthAccessTokenURL != null : !this.oAuthAccessTokenURL.equals(configurationBase.oAuthAccessTokenURL)) {
            return false;
        }
        if (this.oAuthAuthenticationURL == null ? configurationBase.oAuthAuthenticationURL != null : !this.oAuthAuthenticationURL.equals(configurationBase.oAuthAuthenticationURL)) {
            return false;
        }
        if (this.oAuthAuthorizationURL == null ? configurationBase.oAuthAuthorizationURL != null : !this.oAuthAuthorizationURL.equals(configurationBase.oAuthAuthorizationURL)) {
            return false;
        }
        if (this.oAuthConsumerKey == null ? configurationBase.oAuthConsumerKey != null : !this.oAuthConsumerKey.equals(configurationBase.oAuthConsumerKey)) {
            return false;
        }
        if (this.oAuthConsumerSecret == null ? configurationBase.oAuthConsumerSecret != null : !this.oAuthConsumerSecret.equals(configurationBase.oAuthConsumerSecret)) {
            return false;
        }
        if (this.oAuthRequestTokenURL == null ? configurationBase.oAuthRequestTokenURL != null : !this.oAuthRequestTokenURL.equals(configurationBase.oAuthRequestTokenURL)) {
            return false;
        }
        if (this.password == null ? configurationBase.password != null : !this.password.equals(configurationBase.password)) {
            return false;
        }
        if (this.restBaseURL == null ? configurationBase.restBaseURL != null : !this.restBaseURL.equals(configurationBase.restBaseURL)) {
            return false;
        }
        if (this.uploadBaseURL == null ? configurationBase.uploadBaseURL != null : !this.uploadBaseURL.equals(configurationBase.uploadBaseURL)) {
            return false;
        }
        if (this.siteStreamBaseURL == null ? configurationBase.siteStreamBaseURL != null : !this.siteStreamBaseURL.equals(configurationBase.siteStreamBaseURL)) {
            return false;
        }
        if (this.streamBaseURL == null ? configurationBase.streamBaseURL != null : !this.streamBaseURL.equals(configurationBase.streamBaseURL)) {
            return false;
        }
        if (this.user == null ? configurationBase.user == null : this.user.equals(configurationBase.user)) {
            return this.userStreamBaseURL == null ? configurationBase.userStreamBaseURL == null : this.userStreamBaseURL.equals(configurationBase.userStreamBaseURL);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.debug ? 1 : 0) * true) + (this.user != null ? this.user.hashCode() : 0)) * 31) + (this.password != null ? this.password.hashCode() : 0)) * 31) + (this.httpConf != null ? this.httpConf.hashCode() : 0)) * 31) + this.httpStreamingReadTimeout) * 31) + this.httpRetryCount) * 31) + this.httpRetryIntervalSeconds) * 31) + (this.oAuthConsumerKey != null ? this.oAuthConsumerKey.hashCode() : 0)) * 31) + (this.oAuthConsumerSecret != null ? this.oAuthConsumerSecret.hashCode() : 0)) * 31) + (this.oAuthAccessToken != null ? this.oAuthAccessToken.hashCode() : 0)) * 31) + (this.oAuthAccessTokenSecret != null ? this.oAuthAccessTokenSecret.hashCode() : 0)) * 31) + (this.oAuth2TokenType != null ? this.oAuth2TokenType.hashCode() : 0)) * 31) + (this.oAuth2AccessToken != null ? this.oAuth2AccessToken.hashCode() : 0)) * 31) + (this.oAuth2Scope != null ? this.oAuth2Scope.hashCode() : 0)) * 31) + (this.oAuthRequestTokenURL != null ? this.oAuthRequestTokenURL.hashCode() : 0)) * 31) + (this.oAuthAuthorizationURL != null ? this.oAuthAuthorizationURL.hashCode() : 0)) * 31) + (this.oAuthAccessTokenURL != null ? this.oAuthAccessTokenURL.hashCode() : 0)) * 31) + (this.oAuthAuthenticationURL != null ? this.oAuthAuthenticationURL.hashCode() : 0)) * 31) + (this.oAuth2TokenURL != null ? this.oAuth2TokenURL.hashCode() : 0)) * 31) + (this.oAuth2InvalidateTokenURL != null ? this.oAuth2InvalidateTokenURL.hashCode() : 0)) * 31) + (this.restBaseURL != null ? this.restBaseURL.hashCode() : 0)) * 31) + (this.uploadBaseURL != null ? this.uploadBaseURL.hashCode() : 0)) * 31) + (this.streamBaseURL != null ? this.streamBaseURL.hashCode() : 0)) * 31) + (this.userStreamBaseURL != null ? this.userStreamBaseURL.hashCode() : 0)) * 31) + (this.siteStreamBaseURL != null ? this.siteStreamBaseURL.hashCode() : 0)) * 31) + (this.dispatcherImpl != null ? this.dispatcherImpl.hashCode() : 0)) * 31) + this.asyncNumThreads) * 31) + (this.loggerFactory != null ? this.loggerFactory.hashCode() : 0)) * 31) + ((int) (this.contributingTo ^ (this.contributingTo >>> 32)))) * 31) + (this.includeMyRetweetEnabled ? 1 : 0)) * 31) + (this.includeEntitiesEnabled ? 1 : 0)) * 31) + (this.trimUserEnabled ? 1 : 0)) * 31) + (this.jsonStoreEnabled ? 1 : 0)) * 31) + (this.mbeanEnabled ? 1 : 0)) * 31) + (this.userStreamRepliesAllEnabled ? 1 : 0)) * 31) + (this.userStreamWithFollowingsEnabled ? 1 : 0)) * 31) + (this.stallWarningsEnabled ? 1 : 0)) * 31) + (this.applicationOnlyAuthEnabled ? 1 : 0)) * 31) + (this.mediaProvider != null ? this.mediaProvider.hashCode() : 0)) * 31) + (this.mediaProviderAPIKey != null ? this.mediaProviderAPIKey.hashCode() : 0)) * 31;
        if (this.mediaProviderParameters != null) {
            i = this.mediaProviderParameters.hashCode();
        }
        return ((hashCode + i) * 31) + (this.daemonEnabled ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConfigurationBase{debug=");
        sb.append(this.debug);
        sb.append(", user='");
        sb.append(this.user);
        sb.append('\'');
        sb.append(", password='");
        sb.append(this.password);
        sb.append('\'');
        sb.append(", httpConf=");
        sb.append(this.httpConf);
        sb.append(", httpStreamingReadTimeout=");
        sb.append(this.httpStreamingReadTimeout);
        sb.append(", httpRetryCount=");
        sb.append(this.httpRetryCount);
        sb.append(", httpRetryIntervalSeconds=");
        sb.append(this.httpRetryIntervalSeconds);
        sb.append(", oAuthConsumerKey='");
        sb.append(this.oAuthConsumerKey);
        sb.append('\'');
        sb.append(", oAuthConsumerSecret='");
        sb.append(this.oAuthConsumerSecret);
        sb.append('\'');
        sb.append(", oAuthAccessToken='");
        sb.append(this.oAuthAccessToken);
        sb.append('\'');
        sb.append(", oAuthAccessTokenSecret='");
        sb.append(this.oAuthAccessTokenSecret);
        sb.append('\'');
        sb.append(", oAuth2TokenType='");
        sb.append(this.oAuth2TokenType);
        sb.append('\'');
        sb.append(", oAuth2AccessToken='");
        sb.append(this.oAuth2AccessToken);
        sb.append('\'');
        sb.append(", oAuth2Scope='");
        sb.append(this.oAuth2Scope);
        sb.append('\'');
        sb.append(", oAuthRequestTokenURL='");
        sb.append(this.oAuthRequestTokenURL);
        sb.append('\'');
        sb.append(", oAuthAuthorizationURL='");
        sb.append(this.oAuthAuthorizationURL);
        sb.append('\'');
        sb.append(", oAuthAccessTokenURL='");
        sb.append(this.oAuthAccessTokenURL);
        sb.append('\'');
        sb.append(", oAuthAuthenticationURL='");
        sb.append(this.oAuthAuthenticationURL);
        sb.append('\'');
        sb.append(", oAuth2TokenURL='");
        sb.append(this.oAuth2TokenURL);
        sb.append('\'');
        sb.append(", oAuth2InvalidateTokenURL='");
        sb.append(this.oAuth2InvalidateTokenURL);
        sb.append('\'');
        sb.append(", restBaseURL='");
        sb.append(this.restBaseURL);
        sb.append('\'');
        sb.append(", uploadBaseURL='");
        sb.append(this.uploadBaseURL);
        sb.append('\'');
        sb.append(", streamBaseURL='");
        sb.append(this.streamBaseURL);
        sb.append('\'');
        sb.append(", userStreamBaseURL='");
        sb.append(this.userStreamBaseURL);
        sb.append('\'');
        sb.append(", siteStreamBaseURL='");
        sb.append(this.siteStreamBaseURL);
        sb.append('\'');
        sb.append(", dispatcherImpl='");
        sb.append(this.dispatcherImpl);
        sb.append('\'');
        sb.append(", asyncNumThreads=");
        sb.append(this.asyncNumThreads);
        sb.append(", loggerFactory='");
        sb.append(this.loggerFactory);
        sb.append('\'');
        sb.append(", contributingTo=");
        sb.append(this.contributingTo);
        sb.append(", includeMyRetweetEnabled=");
        sb.append(this.includeMyRetweetEnabled);
        sb.append(", includeEntitiesEnabled=");
        sb.append(this.includeEntitiesEnabled);
        sb.append(", trimUserEnabled=");
        sb.append(this.trimUserEnabled);
        sb.append(", jsonStoreEnabled=");
        sb.append(this.jsonStoreEnabled);
        sb.append(", mbeanEnabled=");
        sb.append(this.mbeanEnabled);
        sb.append(", userStreamRepliesAllEnabled=");
        sb.append(this.userStreamRepliesAllEnabled);
        sb.append(", userStreamWithFollowingsEnabled=");
        sb.append(this.userStreamWithFollowingsEnabled);
        sb.append(", stallWarningsEnabled=");
        sb.append(this.stallWarningsEnabled);
        sb.append(", applicationOnlyAuthEnabled=");
        sb.append(this.applicationOnlyAuthEnabled);
        sb.append(", mediaProvider='");
        sb.append(this.mediaProvider);
        sb.append('\'');
        sb.append(", mediaProviderAPIKey='");
        sb.append(this.mediaProviderAPIKey);
        sb.append('\'');
        sb.append(", mediaProviderParameters=");
        sb.append(this.mediaProviderParameters);
        sb.append(", daemonEnabled=");
        sb.append(this.daemonEnabled);
        sb.append('}');
        return sb.toString();
    }

    private static void cacheInstance(ConfigurationBase configurationBase) {
        if (!instances.contains(configurationBase)) {
            instances.add(configurationBase);
        }
    }

    /* access modifiers changed from: protected */
    public void cacheInstance() {
        cacheInstance(this);
    }

    private static ConfigurationBase getInstance(ConfigurationBase configurationBase) {
        int indexOf = instances.indexOf(configurationBase);
        if (indexOf != -1) {
            return (ConfigurationBase) instances.get(indexOf);
        }
        instances.add(configurationBase);
        return configurationBase;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return getInstance(this);
    }
}
