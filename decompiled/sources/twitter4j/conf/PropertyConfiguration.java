package twitter4j.conf;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import twitter4j.HttpClientConfiguration;

public final class PropertyConfiguration extends ConfigurationBase implements Serializable {
    private static final String APPLICATION_ONLY_AUTH_ENABLED = "enableApplicationOnlyAuth";
    private static final String ASYNC_DAEMON_ENABLED = "async.daemonEnabled";
    private static final String ASYNC_DISPATCHER_IMPL = "async.dispatcherImpl";
    private static final String ASYNC_NUM_THREADS = "async.numThreads";
    private static final String CONTRIBUTING_TO = "contributingTo";
    private static final String DEBUG = "debug";
    private static final String HTTP_CONNECTION_TIMEOUT = "http.connectionTimeout";
    private static final String HTTP_GZIP = "http.gzip";
    private static final String HTTP_PRETTY_DEBUG = "http.prettyDebug";
    private static final String HTTP_PROXY_HOST = "http.proxyHost";
    private static final String HTTP_PROXY_HOST_FALLBACK = "http.proxyHost";
    private static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";
    private static final String HTTP_PROXY_PORT = "http.proxyPort";
    private static final String HTTP_PROXY_PORT_FALLBACK = "http.proxyPort";
    private static final String HTTP_PROXY_USER = "http.proxyUser";
    private static final String HTTP_READ_TIMEOUT = "http.readTimeout";
    private static final String HTTP_RETRY_COUNT = "http.retryCount";
    private static final String HTTP_RETRY_INTERVAL_SECS = "http.retryIntervalSecs";
    private static final String HTTP_STREAMING_READ_TIMEOUT = "http.streamingReadTimeout";
    private static final String INCLUDE_ENTITIES = "includeEntities";
    private static final String INCLUDE_MY_RETWEET = "includeMyRetweet";
    private static final String JSON_STORE_ENABLED = "jsonStoreEnabled";
    private static final String LOGGER_FACTORY = "loggerFactory";
    private static final String MBEAN_ENABLED = "mbeanEnabled";
    private static final String MEDIA_PROVIDER = "media.provider";
    private static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
    private static final String MEDIA_PROVIDER_PARAMETERS = "media.providerParameters";
    private static final String OAUTH2_ACCESS_TOKEN = "oauth2.accessToken";
    private static final String OAUTH2_INVALIDATE_TOKEN_URL = "oauth2.invalidateTokenURL";
    private static final String OAUTH2_SCOPE = "oauth2.scope";
    private static final String OAUTH2_TOKEN_TYPE = "oauth2.tokenType";
    private static final String OAUTH2_TOKEN_URL = "oauth2.tokenURL";
    private static final String OAUTH_ACCESS_TOKEN = "oauth.accessToken";
    private static final String OAUTH_ACCESS_TOKEN_SECRET = "oauth.accessTokenSecret";
    private static final String OAUTH_ACCESS_TOKEN_URL = "oauth.accessTokenURL";
    private static final String OAUTH_AUTHENTICATION_URL = "oauth.authenticationURL";
    private static final String OAUTH_AUTHORIZATION_URL = "oauth.authorizationURL";
    private static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
    private static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";
    private static final String OAUTH_REQUEST_TOKEN_URL = "oauth.requestTokenURL";
    private static final String PASSWORD = "password";
    private static final String REST_BASE_URL = "restBaseURL";
    private static final String SITE_STREAM_BASE_URL = "siteStreamBaseURL";
    private static final String STREAM_BASE_URL = "streamBaseURL";
    private static final String STREAM_STALL_WARNINGS_ENABLED = "stream.enableStallWarnings";
    private static final String STREAM_USER_REPLIES_ALL = "stream.user.repliesAll";
    private static final String STREAM_USER_WITH_FOLLOWINGS = "stream.user.withFollowings";
    private static final String USER = "user";
    private static final String USER_STREAM_BASE_URL = "userStreamBaseURL";
    private static final long serialVersionUID = -7262615247923693252L;
    private String OAuth2Scope;

    public /* bridge */ /* synthetic */ void dumpConfiguration() {
        super.dumpConfiguration();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ String getDispatcherImpl() {
        return super.getDispatcherImpl();
    }

    public /* bridge */ /* synthetic */ HttpClientConfiguration getHttpClientConfiguration() {
        return super.getHttpClientConfiguration();
    }

    public /* bridge */ /* synthetic */ int getHttpStreamingReadTimeout() {
        return super.getHttpStreamingReadTimeout();
    }

    public /* bridge */ /* synthetic */ String getLoggerFactory() {
        return super.getLoggerFactory();
    }

    public /* bridge */ /* synthetic */ String getMediaProvider() {
        return super.getMediaProvider();
    }

    public /* bridge */ /* synthetic */ String getMediaProviderAPIKey() {
        return super.getMediaProviderAPIKey();
    }

    public /* bridge */ /* synthetic */ Properties getMediaProviderParameters() {
        return super.getMediaProviderParameters();
    }

    public /* bridge */ /* synthetic */ String getOAuth2AccessToken() {
        return super.getOAuth2AccessToken();
    }

    public /* bridge */ /* synthetic */ String getOAuth2InvalidateTokenURL() {
        return super.getOAuth2InvalidateTokenURL();
    }

    public /* bridge */ /* synthetic */ String getOAuth2Scope() {
        return super.getOAuth2Scope();
    }

    public /* bridge */ /* synthetic */ String getOAuth2TokenType() {
        return super.getOAuth2TokenType();
    }

    public /* bridge */ /* synthetic */ String getOAuth2TokenURL() {
        return super.getOAuth2TokenURL();
    }

    public /* bridge */ /* synthetic */ String getOAuthAccessToken() {
        return super.getOAuthAccessToken();
    }

    public /* bridge */ /* synthetic */ String getOAuthAccessTokenSecret() {
        return super.getOAuthAccessTokenSecret();
    }

    public /* bridge */ /* synthetic */ String getOAuthAccessTokenURL() {
        return super.getOAuthAccessTokenURL();
    }

    public /* bridge */ /* synthetic */ String getOAuthAuthenticationURL() {
        return super.getOAuthAuthenticationURL();
    }

    public /* bridge */ /* synthetic */ String getOAuthAuthorizationURL() {
        return super.getOAuthAuthorizationURL();
    }

    public /* bridge */ /* synthetic */ String getOAuthRequestTokenURL() {
        return super.getOAuthRequestTokenURL();
    }

    public /* bridge */ /* synthetic */ String getRestBaseURL() {
        return super.getRestBaseURL();
    }

    public /* bridge */ /* synthetic */ String getSiteStreamBaseURL() {
        return super.getSiteStreamBaseURL();
    }

    public /* bridge */ /* synthetic */ String getStreamBaseURL() {
        return super.getStreamBaseURL();
    }

    public /* bridge */ /* synthetic */ String getUploadBaseURL() {
        return super.getUploadBaseURL();
    }

    public /* bridge */ /* synthetic */ String getUserStreamBaseURL() {
        return super.getUserStreamBaseURL();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isApplicationOnlyAuthEnabled() {
        return super.isApplicationOnlyAuthEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isDaemonEnabled() {
        return super.isDaemonEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isIncludeEntitiesEnabled() {
        return super.isIncludeEntitiesEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isIncludeMyRetweetEnabled() {
        return super.isIncludeMyRetweetEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isJSONStoreEnabled() {
        return super.isJSONStoreEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isMBeanEnabled() {
        return super.isMBeanEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isStallWarningsEnabled() {
        return super.isStallWarningsEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isTrimUserEnabled() {
        return super.isTrimUserEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isUserStreamRepliesAllEnabled() {
        return super.isUserStreamRepliesAllEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isUserStreamWithFollowingsEnabled() {
        return super.isUserStreamWithFollowingsEnabled();
    }

    public /* bridge */ /* synthetic */ void setIncludeMyRetweetEnabled(boolean z) {
        super.setIncludeMyRetweetEnabled(z);
    }

    public /* bridge */ /* synthetic */ void setTrimUserEnabled(boolean z) {
        super.setTrimUserEnabled(z);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public PropertyConfiguration(InputStream inputStream) {
        Properties properties = new Properties();
        loadProperties(properties, inputStream);
        setFieldsWithTreePath(properties, "/");
    }

    public PropertyConfiguration(Properties properties) {
        this(properties, "/");
    }

    public PropertyConfiguration(Properties properties, String str) {
        setFieldsWithTreePath(properties, str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|(2:7|5)|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PropertyConfiguration(java.lang.String r6) {
        /*
            r5 = this;
            r5.<init>()
            java.util.Properties r0 = java.lang.System.getProperties()     // Catch:{ SecurityException -> 0x0033 }
            java.lang.Object r0 = r0.clone()     // Catch:{ SecurityException -> 0x0033 }
            java.util.Properties r0 = (java.util.Properties) r0     // Catch:{ SecurityException -> 0x0033 }
            java.util.Map r1 = java.lang.System.getenv()     // Catch:{ SecurityException -> 0x002f }
            java.util.Set r2 = r1.keySet()     // Catch:{ SecurityException -> 0x002f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ SecurityException -> 0x002f }
        L_0x0019:
            boolean r3 = r2.hasNext()     // Catch:{ SecurityException -> 0x002f }
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()     // Catch:{ SecurityException -> 0x002f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ SecurityException -> 0x002f }
            java.lang.Object r4 = r1.get(r3)     // Catch:{ SecurityException -> 0x002f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ SecurityException -> 0x002f }
            r0.setProperty(r3, r4)     // Catch:{ SecurityException -> 0x002f }
            goto L_0x0019
        L_0x002f:
            r5.normalize(r0)     // Catch:{ SecurityException -> 0x0033 }
            goto L_0x0038
        L_0x0033:
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
        L_0x0038:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "."
            r1.append(r2)
            char r2 = java.io.File.separatorChar
            r1.append(r2)
            java.lang.String r2 = "twitter4j.properties"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r5.loadProperties(r0, r1)
            java.lang.Class<twitter4j.conf.Configuration> r1 = twitter4j.conf.Configuration.class
            java.lang.String r2 = "/twitter4j.properties"
            java.io.InputStream r1 = r1.getResourceAsStream(r2)
            r5.loadProperties(r0, r1)
            java.lang.Class<twitter4j.conf.Configuration> r1 = twitter4j.conf.Configuration.class
            java.lang.String r2 = "/WEB-INF/twitter4j.properties"
            java.io.InputStream r1 = r1.getResourceAsStream(r2)
            r5.loadProperties(r0, r1)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException | SecurityException -> 0x0073 }
            java.lang.String r2 = "WEB-INF/twitter4j.properties"
            r1.<init>(r2)     // Catch:{ FileNotFoundException | SecurityException -> 0x0073 }
            r5.loadProperties(r0, r1)     // Catch:{ FileNotFoundException | SecurityException -> 0x0073 }
        L_0x0073:
            r5.setFieldsWithTreePath(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.conf.PropertyConfiguration.<init>(java.lang.String):void");
    }

    PropertyConfiguration() {
        this("/");
    }

    private boolean notNull(Properties properties, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return properties.getProperty(sb.toString()) != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002a A[SYNTHETIC, Splitter:B:20:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0030 A[SYNTHETIC, Splitter:B:26:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean loadProperties(java.util.Properties r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            boolean r4 = r1.exists()     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            if (r4 == 0) goto L_0x0033
            boolean r4 = r1.isFile()     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            if (r4 == 0) goto L_0x0033
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            r3.load(r4)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r2.normalize(r3)     // Catch:{ Exception -> 0x0025, all -> 0x0022 }
            r3 = 1
            r4.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            return r3
        L_0x0022:
            r3 = move-exception
            r0 = r4
            goto L_0x0028
        L_0x0025:
            r0 = r4
            goto L_0x002e
        L_0x0027:
            r3 = move-exception
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            r0.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r3
        L_0x002e:
            if (r0 == 0) goto L_0x0033
            r0.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.conf.PropertyConfiguration.loadProperties(java.util.Properties, java.lang.String):boolean");
    }

    private boolean loadProperties(Properties properties, InputStream inputStream) {
        try {
            properties.load(inputStream);
            normalize(properties);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void normalize(Properties properties) {
        Set<String> keySet = properties.keySet();
        ArrayList arrayList = new ArrayList(10);
        for (String str : keySet) {
            if (-1 != str.indexOf("twitter4j.")) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String property = properties.getProperty(str2);
            int indexOf = str2.indexOf("twitter4j.");
            StringBuilder sb = new StringBuilder();
            sb.append(str2.substring(0, indexOf));
            sb.append(str2.substring(indexOf + 10));
            properties.setProperty(sb.toString(), property);
        }
    }

    private void setFieldsWithTreePath(Properties properties, String str) {
        String[] split;
        setFieldsWithPrefix(properties, "");
        String str2 = null;
        for (String str3 : str.split("/")) {
            if (!"".equals(str3)) {
                if (str2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(".");
                    str2 = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str3);
                    sb2.append(".");
                    str2 = sb2.toString();
                }
                setFieldsWithPrefix(properties, str2);
            }
        }
    }

    private void setFieldsWithPrefix(Properties properties, String str) {
        if (notNull(properties, str, "debug")) {
            setDebug(getBoolean(properties, str, "debug"));
        }
        if (notNull(properties, str, USER)) {
            setUser(getString(properties, str, USER));
        }
        if (notNull(properties, str, "password")) {
            setPassword(getString(properties, str, "password"));
        }
        if (notNull(properties, str, HTTP_PRETTY_DEBUG)) {
            setPrettyDebugEnabled(getBoolean(properties, str, HTTP_PRETTY_DEBUG));
        }
        if (notNull(properties, str, HTTP_GZIP)) {
            setGZIPEnabled(getBoolean(properties, str, HTTP_GZIP));
        }
        if (notNull(properties, str, "http.proxyHost")) {
            setHttpProxyHost(getString(properties, str, "http.proxyHost"));
        } else if (notNull(properties, str, "http.proxyHost")) {
            setHttpProxyHost(getString(properties, str, "http.proxyHost"));
        }
        if (notNull(properties, str, HTTP_PROXY_USER)) {
            setHttpProxyUser(getString(properties, str, HTTP_PROXY_USER));
        }
        if (notNull(properties, str, HTTP_PROXY_PASSWORD)) {
            setHttpProxyPassword(getString(properties, str, HTTP_PROXY_PASSWORD));
        }
        if (notNull(properties, str, "http.proxyPort")) {
            setHttpProxyPort(getIntProperty(properties, str, "http.proxyPort"));
        } else if (notNull(properties, str, "http.proxyPort")) {
            setHttpProxyPort(getIntProperty(properties, str, "http.proxyPort"));
        }
        if (notNull(properties, str, HTTP_CONNECTION_TIMEOUT)) {
            setHttpConnectionTimeout(getIntProperty(properties, str, HTTP_CONNECTION_TIMEOUT));
        }
        if (notNull(properties, str, HTTP_READ_TIMEOUT)) {
            setHttpReadTimeout(getIntProperty(properties, str, HTTP_READ_TIMEOUT));
        }
        if (notNull(properties, str, HTTP_STREAMING_READ_TIMEOUT)) {
            setHttpStreamingReadTimeout(getIntProperty(properties, str, HTTP_STREAMING_READ_TIMEOUT));
        }
        if (notNull(properties, str, HTTP_RETRY_COUNT)) {
            setHttpRetryCount(getIntProperty(properties, str, HTTP_RETRY_COUNT));
        }
        if (notNull(properties, str, HTTP_RETRY_INTERVAL_SECS)) {
            setHttpRetryIntervalSeconds(getIntProperty(properties, str, HTTP_RETRY_INTERVAL_SECS));
        }
        if (notNull(properties, str, OAUTH_CONSUMER_KEY)) {
            setOAuthConsumerKey(getString(properties, str, OAUTH_CONSUMER_KEY));
        }
        if (notNull(properties, str, OAUTH_CONSUMER_SECRET)) {
            setOAuthConsumerSecret(getString(properties, str, OAUTH_CONSUMER_SECRET));
        }
        if (notNull(properties, str, OAUTH_ACCESS_TOKEN)) {
            setOAuthAccessToken(getString(properties, str, OAUTH_ACCESS_TOKEN));
        }
        if (notNull(properties, str, OAUTH_ACCESS_TOKEN_SECRET)) {
            setOAuthAccessTokenSecret(getString(properties, str, OAUTH_ACCESS_TOKEN_SECRET));
        }
        if (notNull(properties, str, OAUTH2_TOKEN_TYPE)) {
            setOAuth2TokenType(getString(properties, str, OAUTH2_TOKEN_TYPE));
        }
        if (notNull(properties, str, OAUTH2_ACCESS_TOKEN)) {
            setOAuth2AccessToken(getString(properties, str, OAUTH2_ACCESS_TOKEN));
        }
        if (notNull(properties, str, OAUTH2_SCOPE)) {
            setOAuth2Scope(getString(properties, str, OAUTH2_SCOPE));
        }
        if (notNull(properties, str, ASYNC_NUM_THREADS)) {
            setAsyncNumThreads(getIntProperty(properties, str, ASYNC_NUM_THREADS));
        }
        if (notNull(properties, str, ASYNC_DAEMON_ENABLED)) {
            setDaemonEnabled(getBoolean(properties, str, ASYNC_DAEMON_ENABLED));
        }
        if (notNull(properties, str, CONTRIBUTING_TO)) {
            setContributingTo(getLongProperty(properties, str, CONTRIBUTING_TO));
        }
        if (notNull(properties, str, ASYNC_DISPATCHER_IMPL)) {
            setDispatcherImpl(getString(properties, str, ASYNC_DISPATCHER_IMPL));
        }
        if (notNull(properties, str, OAUTH_REQUEST_TOKEN_URL)) {
            setOAuthRequestTokenURL(getString(properties, str, OAUTH_REQUEST_TOKEN_URL));
        }
        if (notNull(properties, str, OAUTH_AUTHORIZATION_URL)) {
            setOAuthAuthorizationURL(getString(properties, str, OAUTH_AUTHORIZATION_URL));
        }
        if (notNull(properties, str, OAUTH_ACCESS_TOKEN_URL)) {
            setOAuthAccessTokenURL(getString(properties, str, OAUTH_ACCESS_TOKEN_URL));
        }
        if (notNull(properties, str, OAUTH_AUTHENTICATION_URL)) {
            setOAuthAuthenticationURL(getString(properties, str, OAUTH_AUTHENTICATION_URL));
        }
        if (notNull(properties, str, OAUTH2_TOKEN_URL)) {
            setOAuth2TokenURL(getString(properties, str, OAUTH2_TOKEN_URL));
        }
        if (notNull(properties, str, OAUTH2_INVALIDATE_TOKEN_URL)) {
            setOAuth2InvalidateTokenURL(getString(properties, str, OAUTH2_INVALIDATE_TOKEN_URL));
        }
        if (notNull(properties, str, REST_BASE_URL)) {
            setRestBaseURL(getString(properties, str, REST_BASE_URL));
        }
        if (notNull(properties, str, STREAM_BASE_URL)) {
            setStreamBaseURL(getString(properties, str, STREAM_BASE_URL));
        }
        if (notNull(properties, str, USER_STREAM_BASE_URL)) {
            setUserStreamBaseURL(getString(properties, str, USER_STREAM_BASE_URL));
        }
        if (notNull(properties, str, SITE_STREAM_BASE_URL)) {
            setSiteStreamBaseURL(getString(properties, str, SITE_STREAM_BASE_URL));
        }
        if (notNull(properties, str, INCLUDE_MY_RETWEET)) {
            setIncludeMyRetweetEnabled(getBoolean(properties, str, INCLUDE_MY_RETWEET));
        }
        if (notNull(properties, str, INCLUDE_ENTITIES)) {
            setIncludeEntitiesEnabled(getBoolean(properties, str, INCLUDE_ENTITIES));
        }
        if (notNull(properties, str, LOGGER_FACTORY)) {
            setLoggerFactory(getString(properties, str, LOGGER_FACTORY));
        }
        if (notNull(properties, str, JSON_STORE_ENABLED)) {
            setJSONStoreEnabled(getBoolean(properties, str, JSON_STORE_ENABLED));
        }
        if (notNull(properties, str, MBEAN_ENABLED)) {
            setMBeanEnabled(getBoolean(properties, str, MBEAN_ENABLED));
        }
        if (notNull(properties, str, STREAM_USER_REPLIES_ALL)) {
            setUserStreamRepliesAllEnabled(getBoolean(properties, str, STREAM_USER_REPLIES_ALL));
        }
        if (notNull(properties, str, STREAM_USER_WITH_FOLLOWINGS)) {
            setUserStreamWithFollowingsEnabled(getBoolean(properties, str, STREAM_USER_WITH_FOLLOWINGS));
        }
        if (notNull(properties, str, STREAM_STALL_WARNINGS_ENABLED)) {
            setStallWarningsEnabled(getBoolean(properties, str, STREAM_STALL_WARNINGS_ENABLED));
        }
        if (notNull(properties, str, APPLICATION_ONLY_AUTH_ENABLED)) {
            setApplicationOnlyAuthEnabled(getBoolean(properties, str, APPLICATION_ONLY_AUTH_ENABLED));
        }
        if (notNull(properties, str, MEDIA_PROVIDER)) {
            setMediaProvider(getString(properties, str, MEDIA_PROVIDER));
        }
        if (notNull(properties, str, MEDIA_PROVIDER_API_KEY)) {
            setMediaProviderAPIKey(getString(properties, str, MEDIA_PROVIDER_API_KEY));
        }
        if (notNull(properties, str, MEDIA_PROVIDER_PARAMETERS)) {
            String[] split = getString(properties, str, MEDIA_PROVIDER_PARAMETERS).split("&");
            Properties properties2 = new Properties();
            for (String split2 : split) {
                String[] split3 = split2.split(SimpleComparison.EQUAL_TO_OPERATION);
                properties2.setProperty(split3[0], split3[1]);
            }
            setMediaProviderParameters(properties2);
        }
        cacheInstance();
    }

    /* access modifiers changed from: 0000 */
    public boolean getBoolean(Properties properties, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return Boolean.valueOf(properties.getProperty(sb.toString())).booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public int getIntProperty(Properties properties, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        try {
            return Integer.parseInt(properties.getProperty(sb.toString()));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: 0000 */
    public long getLongProperty(Properties properties, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        try {
            return Long.parseLong(properties.getProperty(sb.toString()));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: 0000 */
    public String getString(Properties properties, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return properties.getProperty(sb.toString());
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return super.readResolve();
    }
}
