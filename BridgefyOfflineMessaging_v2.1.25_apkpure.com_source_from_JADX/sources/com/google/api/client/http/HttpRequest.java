package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.23.0 (gzip)";
    public static final String VERSION = "1.23.0";
    @Beta
    @Deprecated
    private BackOffPolicy backOffPolicy;
    private int connectTimeout = 20000;
    private HttpContent content;
    private int contentLoggingLimit = 16384;
    private boolean curlLoggingEnabled = true;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;
    private boolean followRedirects = true;
    private HttpHeaders headers = new HttpHeaders();
    @Beta
    private HttpIOExceptionHandler ioExceptionHandler;
    private boolean loggingEnabled = true;
    private int numRetries = 10;
    private ObjectParser objectParser;
    private int readTimeout = 20000;
    private String requestMethod;
    private HttpHeaders responseHeaders = new HttpHeaders();
    private HttpResponseInterceptor responseInterceptor;
    @Beta
    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;
    private boolean suppressUserAgentSuffix;
    private boolean throwExceptionOnExecuteError = true;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;

    HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    public HttpContent getContent() {
        return this.content;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpEncoding getEncoding() {
        return this.encoding;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    @Beta
    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.backOffPolicy;
    }

    @Beta
    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy2) {
        this.backOffPolicy = backOffPolicy2;
        return this;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public boolean isCurlLoggingEnabled() {
        return this.curlLoggingEnabled;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.curlLoggingEnabled = z;
        return this;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.connectTimeout = i;
        return this;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.readTimeout = i;
        return this;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.executeInterceptor;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.unsuccessfulResponseHandler;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    @Beta
    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.ioExceptionHandler;
    }

    @Beta
    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.ioExceptionHandler = httpIOExceptionHandler;
        return this;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    public int getNumberOfRetries() {
        return this.numRetries;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.numRetries = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser2) {
        this.objectParser = objectParser2;
        return this;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.throwExceptionOnExecuteError = z;
        return this;
    }

    @Beta
    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.retryOnExecuteIOException;
    }

    @Beta
    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.retryOnExecuteIOException = z;
        return this;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.suppressUserAgentSuffix;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.suppressUserAgentSuffix = z;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x027b A[SYNTHETIC, Splitter:B:111:0x027b] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02fe A[LOOP:0: B:8:0x0024->B:163:0x02fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02db A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0208  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.api.client.http.HttpResponse execute() throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            int r0 = r1.numRetries
            r3 = 1
            if (r0 < 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            com.google.api.client.util.Preconditions.checkArgument(r0)
            int r0 = r1.numRetries
            com.google.api.client.http.BackOffPolicy r4 = r1.backOffPolicy
            if (r4 == 0) goto L_0x0018
            com.google.api.client.http.BackOffPolicy r4 = r1.backOffPolicy
            r4.reset()
        L_0x0018:
            java.lang.String r4 = r1.requestMethod
            com.google.api.client.util.Preconditions.checkNotNull(r4)
            com.google.api.client.http.GenericUrl r4 = r1.url
            com.google.api.client.util.Preconditions.checkNotNull(r4)
            r5 = r0
            r0 = 0
        L_0x0024:
            if (r0 == 0) goto L_0x0029
            r0.ignore()
        L_0x0029:
            com.google.api.client.http.HttpExecuteInterceptor r0 = r1.executeInterceptor
            if (r0 == 0) goto L_0x0032
            com.google.api.client.http.HttpExecuteInterceptor r0 = r1.executeInterceptor
            r0.intercept(r1)
        L_0x0032:
            com.google.api.client.http.GenericUrl r0 = r1.url
            java.lang.String r0 = r0.build()
            com.google.api.client.http.HttpTransport r6 = r1.transport
            java.lang.String r7 = r1.requestMethod
            com.google.api.client.http.LowLevelHttpRequest r6 = r6.buildRequest(r7, r0)
            java.util.logging.Logger r7 = com.google.api.client.http.HttpTransport.LOGGER
            boolean r8 = r1.loggingEnabled
            if (r8 == 0) goto L_0x0050
            java.util.logging.Level r8 = java.util.logging.Level.CONFIG
            boolean r8 = r7.isLoggable(r8)
            if (r8 == 0) goto L_0x0050
            r8 = 1
            goto L_0x0051
        L_0x0050:
            r8 = 0
        L_0x0051:
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "-------------- REQUEST  --------------"
            r9.append(r10)
            java.lang.String r10 = com.google.api.client.util.StringUtils.LINE_SEPARATOR
            r9.append(r10)
            java.lang.String r10 = r1.requestMethod
            r9.append(r10)
            r10 = 32
            r9.append(r10)
            r9.append(r0)
            java.lang.String r10 = com.google.api.client.util.StringUtils.LINE_SEPARATOR
            r9.append(r10)
            boolean r10 = r1.curlLoggingEnabled
            if (r10 == 0) goto L_0x0095
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "curl -v --compressed"
            r10.<init>(r11)
            java.lang.String r11 = r1.requestMethod
            java.lang.String r12 = "GET"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0096
            java.lang.String r11 = " -X "
            r10.append(r11)
            java.lang.String r11 = r1.requestMethod
            r10.append(r11)
            goto L_0x0096
        L_0x0094:
            r9 = 0
        L_0x0095:
            r10 = 0
        L_0x0096:
            com.google.api.client.http.HttpHeaders r11 = r1.headers
            java.lang.String r11 = r11.getUserAgent()
            boolean r12 = r1.suppressUserAgentSuffix
            if (r12 != 0) goto L_0x00e1
            if (r11 != 0) goto L_0x00aa
            com.google.api.client.http.HttpHeaders r12 = r1.headers
            java.lang.String r13 = "Google-HTTP-Java-Client/1.23.0 (gzip)"
            r12.setUserAgent(r13)
            goto L_0x00e1
        L_0x00aa:
            com.google.api.client.http.HttpHeaders r12 = r1.headers
            java.lang.String r13 = java.lang.String.valueOf(r11)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r14 = "Google-HTTP-Java-Client/1.23.0 (gzip)"
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            int r16 = r13.length()
            int r16 = r16 + 1
            int r17 = r14.length()
            int r2 = r16 + r17
            r15.<init>(r2)
            r15.append(r13)
            java.lang.String r2 = " "
            r15.append(r2)
            r15.append(r14)
            java.lang.String r2 = r15.toString()
            r12.setUserAgent(r2)
        L_0x00e1:
            com.google.api.client.http.HttpHeaders r2 = r1.headers
            com.google.api.client.http.HttpHeaders.serializeHeaders(r2, r9, r10, r7, r6)
            boolean r2 = r1.suppressUserAgentSuffix
            if (r2 != 0) goto L_0x00ef
            com.google.api.client.http.HttpHeaders r2 = r1.headers
            r2.setUserAgent(r11)
        L_0x00ef:
            com.google.api.client.http.HttpContent r2 = r1.content
            if (r2 == 0) goto L_0x00fe
            com.google.api.client.http.HttpContent r11 = r1.content
            boolean r11 = r11.retrySupported()
            if (r11 == 0) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r11 = 0
            goto L_0x00ff
        L_0x00fe:
            r11 = 1
        L_0x00ff:
            if (r2 == 0) goto L_0x0205
            com.google.api.client.http.HttpContent r14 = r1.content
            java.lang.String r14 = r14.getType()
            if (r8 == 0) goto L_0x0115
            com.google.api.client.util.LoggingStreamingContent r15 = new com.google.api.client.util.LoggingStreamingContent
            java.util.logging.Logger r3 = com.google.api.client.http.HttpTransport.LOGGER
            java.util.logging.Level r4 = java.util.logging.Level.CONFIG
            int r12 = r1.contentLoggingLimit
            r15.<init>(r2, r3, r4, r12)
            goto L_0x0116
        L_0x0115:
            r15 = r2
        L_0x0116:
            com.google.api.client.http.HttpEncoding r2 = r1.encoding
            if (r2 != 0) goto L_0x0122
            com.google.api.client.http.HttpContent r2 = r1.content
            long r2 = r2.getLength()
            r4 = 0
            goto L_0x013a
        L_0x0122:
            com.google.api.client.http.HttpEncoding r2 = r1.encoding
            java.lang.String r4 = r2.getName()
            com.google.api.client.http.HttpEncodingStreamingContent r2 = new com.google.api.client.http.HttpEncodingStreamingContent
            com.google.api.client.http.HttpEncoding r3 = r1.encoding
            r2.<init>(r15, r3)
            if (r11 == 0) goto L_0x0136
            long r12 = com.google.api.client.util.IOUtils.computeLength(r2)
            goto L_0x0138
        L_0x0136:
            r12 = -1
        L_0x0138:
            r15 = r2
            r2 = r12
        L_0x013a:
            if (r8 == 0) goto L_0x01f1
            if (r14 == 0) goto L_0x0186
            java.lang.String r12 = "Content-Type: "
            java.lang.String r13 = java.lang.String.valueOf(r14)
            int r16 = r13.length()
            if (r16 == 0) goto L_0x014f
            java.lang.String r12 = r12.concat(r13)
            goto L_0x0155
        L_0x014f:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r12)
            r12 = r13
        L_0x0155:
            r9.append(r12)
            java.lang.String r13 = com.google.api.client.util.StringUtils.LINE_SEPARATOR
            r9.append(r13)
            if (r10 == 0) goto L_0x0186
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            int r16 = r12.length()
            int r1 = r16 + 6
            r13.<init>(r1)
            java.lang.String r1 = " -H '"
            r13.append(r1)
            r13.append(r12)
            java.lang.String r1 = "'"
            r13.append(r1)
            java.lang.String r1 = r13.toString()
            r10.append(r1)
        L_0x0186:
            if (r4 == 0) goto L_0x01d0
            java.lang.String r1 = "Content-Encoding: "
            java.lang.String r12 = java.lang.String.valueOf(r4)
            int r13 = r12.length()
            if (r13 == 0) goto L_0x0199
            java.lang.String r1 = r1.concat(r12)
            goto L_0x019f
        L_0x0199:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r1)
            r1 = r12
        L_0x019f:
            r9.append(r1)
            java.lang.String r12 = com.google.api.client.util.StringUtils.LINE_SEPARATOR
            r9.append(r12)
            if (r10 == 0) goto L_0x01d0
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            int r13 = r1.length()
            int r13 = r13 + 6
            r12.<init>(r13)
            java.lang.String r13 = " -H '"
            r12.append(r13)
            r12.append(r1)
            java.lang.String r1 = "'"
            r12.append(r1)
            java.lang.String r1 = r12.toString()
            r10.append(r1)
        L_0x01d0:
            r12 = 0
            int r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x01f1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r12 = 36
            r1.<init>(r12)
            java.lang.String r12 = "Content-Length: "
            r1.append(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.append(r1)
            java.lang.String r1 = com.google.api.client.util.StringUtils.LINE_SEPARATOR
            r9.append(r1)
        L_0x01f1:
            if (r10 == 0) goto L_0x01f8
            java.lang.String r1 = " -d '@-'"
            r10.append(r1)
        L_0x01f8:
            r6.setContentType(r14)
            r6.setContentEncoding(r4)
            r6.setContentLength(r2)
            r6.setStreamingContent(r15)
            goto L_0x0206
        L_0x0205:
            r15 = r2
        L_0x0206:
            if (r8 == 0) goto L_0x0234
            java.lang.String r1 = r9.toString()
            r7.config(r1)
            if (r10 == 0) goto L_0x0234
            java.lang.String r1 = " -- '"
            r10.append(r1)
            java.lang.String r1 = "'"
            java.lang.String r2 = "'\"'\"'"
            java.lang.String r0 = r0.replaceAll(r1, r2)
            r10.append(r0)
            java.lang.String r0 = "'"
            r10.append(r0)
            if (r15 == 0) goto L_0x022d
            java.lang.String r0 = " << $$$"
            r10.append(r0)
        L_0x022d:
            java.lang.String r0 = r10.toString()
            r7.config(r0)
        L_0x0234:
            if (r11 == 0) goto L_0x023c
            if (r5 <= 0) goto L_0x023c
            r1 = r18
            r2 = 1
            goto L_0x023f
        L_0x023c:
            r1 = r18
            r2 = 0
        L_0x023f:
            int r0 = r1.connectTimeout
            int r3 = r1.readTimeout
            r6.setTimeout(r0, r3)
            com.google.api.client.http.LowLevelHttpResponse r3 = r6.execute()     // Catch:{ IOException -> 0x025d }
            com.google.api.client.http.HttpResponse r0 = new com.google.api.client.http.HttpResponse     // Catch:{ all -> 0x0252 }
            r0.<init>(r1, r3)     // Catch:{ all -> 0x0252 }
            r3 = r0
            r4 = 0
            goto L_0x0279
        L_0x0252:
            r0 = move-exception
            java.io.InputStream r3 = r3.getContent()     // Catch:{ IOException -> 0x025d }
            if (r3 == 0) goto L_0x025c
            r3.close()     // Catch:{ IOException -> 0x025d }
        L_0x025c:
            throw r0     // Catch:{ IOException -> 0x025d }
        L_0x025d:
            r0 = move-exception
            r4 = r0
            boolean r0 = r1.retryOnExecuteIOException
            if (r0 != 0) goto L_0x0271
            com.google.api.client.http.HttpIOExceptionHandler r0 = r1.ioExceptionHandler
            if (r0 == 0) goto L_0x0270
            com.google.api.client.http.HttpIOExceptionHandler r0 = r1.ioExceptionHandler
            boolean r0 = r0.handleIOException(r1, r2)
            if (r0 == 0) goto L_0x0270
            goto L_0x0271
        L_0x0270:
            throw r4
        L_0x0271:
            java.util.logging.Level r0 = java.util.logging.Level.WARNING
            java.lang.String r3 = "exception thrown while executing request"
            r7.log(r0, r3, r4)
            r3 = 0
        L_0x0279:
            if (r3 == 0) goto L_0x02d1
            boolean r0 = r3.isSuccessStatusCode()     // Catch:{ all -> 0x02ca }
            if (r0 != 0) goto L_0x02d1
            com.google.api.client.http.HttpUnsuccessfulResponseHandler r0 = r1.unsuccessfulResponseHandler     // Catch:{ all -> 0x02ca }
            if (r0 == 0) goto L_0x028c
            com.google.api.client.http.HttpUnsuccessfulResponseHandler r0 = r1.unsuccessfulResponseHandler     // Catch:{ all -> 0x02ca }
            boolean r0 = r0.handleResponse(r1, r3, r2)     // Catch:{ all -> 0x02ca }
            goto L_0x028d
        L_0x028c:
            r0 = 0
        L_0x028d:
            if (r0 != 0) goto L_0x02c3
            int r6 = r3.getStatusCode()     // Catch:{ all -> 0x02ca }
            com.google.api.client.http.HttpHeaders r7 = r3.getHeaders()     // Catch:{ all -> 0x02ca }
            boolean r6 = r1.handleRedirect(r6, r7)     // Catch:{ all -> 0x02ca }
            if (r6 == 0) goto L_0x029f
        L_0x029d:
            r0 = 1
            goto L_0x02c3
        L_0x029f:
            if (r2 == 0) goto L_0x02c3
            com.google.api.client.http.BackOffPolicy r6 = r1.backOffPolicy     // Catch:{ all -> 0x02ca }
            if (r6 == 0) goto L_0x02c3
            com.google.api.client.http.BackOffPolicy r6 = r1.backOffPolicy     // Catch:{ all -> 0x02ca }
            int r7 = r3.getStatusCode()     // Catch:{ all -> 0x02ca }
            boolean r6 = r6.isBackOffRequired(r7)     // Catch:{ all -> 0x02ca }
            if (r6 == 0) goto L_0x02c3
            com.google.api.client.http.BackOffPolicy r6 = r1.backOffPolicy     // Catch:{ all -> 0x02ca }
            long r6 = r6.getNextBackOffMillis()     // Catch:{ all -> 0x02ca }
            r8 = -1
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x02c3
            com.google.api.client.util.Sleeper r0 = r1.sleeper     // Catch:{ InterruptedException -> 0x029d }
            r0.sleep(r6)     // Catch:{ InterruptedException -> 0x029d }
            goto L_0x029d
        L_0x02c3:
            r0 = r0 & r2
            if (r0 == 0) goto L_0x02d7
            r3.ignore()     // Catch:{ all -> 0x02ca }
            goto L_0x02d7
        L_0x02ca:
            r0 = move-exception
            if (r3 == 0) goto L_0x02d0
            r3.disconnect()
        L_0x02d0:
            throw r0
        L_0x02d1:
            if (r3 != 0) goto L_0x02d5
            r0 = 1
            goto L_0x02d6
        L_0x02d5:
            r0 = 0
        L_0x02d6:
            r0 = r0 & r2
        L_0x02d7:
            int r5 = r5 + -1
            if (r0 != 0) goto L_0x02fe
            if (r3 == 0) goto L_0x02fd
            com.google.api.client.http.HttpResponseInterceptor r0 = r1.responseInterceptor
            if (r0 == 0) goto L_0x02e6
            com.google.api.client.http.HttpResponseInterceptor r0 = r1.responseInterceptor
            r0.interceptResponse(r3)
        L_0x02e6:
            boolean r0 = r1.throwExceptionOnExecuteError
            if (r0 == 0) goto L_0x02fc
            boolean r0 = r3.isSuccessStatusCode()
            if (r0 == 0) goto L_0x02f1
            goto L_0x02fc
        L_0x02f1:
            com.google.api.client.http.HttpResponseException r0 = new com.google.api.client.http.HttpResponseException     // Catch:{ all -> 0x02f7 }
            r0.<init>(r3)     // Catch:{ all -> 0x02f7 }
            throw r0     // Catch:{ all -> 0x02f7 }
        L_0x02f7:
            r0 = move-exception
            r3.disconnect()
            throw r0
        L_0x02fc:
            return r3
        L_0x02fd:
            throw r4
        L_0x02fe:
            r0 = r3
            r3 = 1
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.HttpRequest.execute():com.google.api.client.http.HttpResponse");
    }

    @Beta
    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new Callable<HttpResponse>() {
            public HttpResponse call() throws Exception {
                return HttpRequest.this.execute();
            }
        });
        executor.execute(futureTask);
        return futureTask;
    }

    @Beta
    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newSingleThreadExecutor());
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location)));
        if (i == 303) {
            setRequestMethod(HttpMethods.GET);
            setContent(null);
        }
        String str = null;
        this.headers.setAuthorization(str);
        this.headers.setIfMatch(str);
        this.headers.setIfNoneMatch(str);
        this.headers.setIfModifiedSince(str);
        this.headers.setIfUnmodifiedSince(str);
        this.headers.setIfRange(str);
        return true;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public HttpRequest setSleeper(Sleeper sleeper2) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper2);
        return this;
    }
}
