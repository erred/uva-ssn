package twitter4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import twitter4j.conf.ConfigurationContext;

public abstract class HttpResponse {
    private static final Logger logger = Logger.getLogger(HttpResponseImpl.class);
    protected final HttpClientConfiguration CONF;

    /* renamed from: is */
    protected InputStream f9918is;
    private JSONObject json;
    private JSONArray jsonArray;
    protected String responseAsString;
    protected int statusCode;
    private boolean streamConsumed;

    public abstract void disconnect() throws IOException;

    public abstract String getResponseHeader(String str);

    public abstract Map<String, List<String>> getResponseHeaderFields();

    HttpResponse() {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = ConfigurationContext.getInstance().getHttpClientConfiguration();
    }

    public HttpResponse(HttpClientConfiguration httpClientConfiguration) {
        this.responseAsString = null;
        this.streamConsumed = false;
        this.json = null;
        this.jsonArray = null;
        this.CONF = httpClientConfiguration;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public InputStream asStream() {
        if (!this.streamConsumed) {
            return this.f9918is;
        }
        throw new IllegalStateException("Stream has already been consumed.");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075 A[SYNTHETIC, Splitter:B:41:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007c A[SYNTHETIC, Splitter:B:45:0x007c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String asString() throws twitter4j.TwitterException {
        /*
            r6 = this;
            java.lang.String r0 = r6.responseAsString
            if (r0 != 0) goto L_0x0083
            r0 = 0
            java.io.InputStream r1 = r6.asStream()     // Catch:{ IOException -> 0x0064, all -> 0x005f }
            if (r1 != 0) goto L_0x0014
            if (r1 == 0) goto L_0x0010
            r1.close()     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            r6.disconnectForcibly()
            return r0
        L_0x0014:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r1, r4)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x005a, all -> 0x0055 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0053 }
            r0.<init>()     // Catch:{ IOException -> 0x0053 }
        L_0x0025:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x0053 }
            if (r3 == 0) goto L_0x0034
            r0.append(r3)     // Catch:{ IOException -> 0x0053 }
            java.lang.String r3 = "\n"
            r0.append(r3)     // Catch:{ IOException -> 0x0053 }
            goto L_0x0025
        L_0x0034:
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0053 }
            r6.responseAsString = r0     // Catch:{ IOException -> 0x0053 }
            twitter4j.Logger r0 = logger     // Catch:{ IOException -> 0x0053 }
            java.lang.String r3 = r6.responseAsString     // Catch:{ IOException -> 0x0053 }
            r0.debug(r3)     // Catch:{ IOException -> 0x0053 }
            r1.close()     // Catch:{ IOException -> 0x0053 }
            r0 = 1
            r6.streamConsumed = r0     // Catch:{ IOException -> 0x0053 }
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            r6.disconnectForcibly()
            goto L_0x0083
        L_0x0053:
            r0 = move-exception
            goto L_0x0068
        L_0x0055:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0073
        L_0x005a:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0068
        L_0x005f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L_0x0073
        L_0x0064:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x0068:
            twitter4j.TwitterException r3 = new twitter4j.TwitterException     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0072 }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0072 }
            throw r3     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r0 = move-exception
        L_0x0073:
            if (r1 == 0) goto L_0x007a
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007a
        L_0x0079:
        L_0x007a:
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ IOException -> 0x007f }
        L_0x007f:
            r6.disconnectForcibly()
            throw r0
        L_0x0083:
            java.lang.String r0 = r6.responseAsString
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpResponse.asString():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070 A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092 A[SYNTHETIC, Splitter:B:39:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public twitter4j.JSONObject asJSONObject() throws twitter4j.TwitterException {
        /*
            r6 = this;
            twitter4j.JSONObject r0 = r6.json
            if (r0 != 0) goto L_0x0099
            r0 = 0
            java.lang.String r1 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            if (r1 != 0) goto L_0x0026
            java.io.Reader r1 = r6.asReader()     // Catch:{ JSONException -> 0x0061 }
            twitter4j.JSONObject r0 = new twitter4j.JSONObject     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            twitter4j.JSONTokener r2 = new twitter4j.JSONTokener     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r6.json = r0     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r0 = r1
            goto L_0x002f
        L_0x001b:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0090
        L_0x0021:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0062
        L_0x0026:
            twitter4j.JSONObject r1 = new twitter4j.JSONObject     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r2 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0061 }
            r6.json = r1     // Catch:{ JSONException -> 0x0061 }
        L_0x002f:
            twitter4j.HttpClientConfiguration r1 = r6.CONF     // Catch:{ JSONException -> 0x0061 }
            boolean r1 = r1.isPrettyDebugEnabled()     // Catch:{ JSONException -> 0x0061 }
            if (r1 == 0) goto L_0x0044
            twitter4j.Logger r1 = logger     // Catch:{ JSONException -> 0x0061 }
            twitter4j.JSONObject r2 = r6.json     // Catch:{ JSONException -> 0x0061 }
            r3 = 1
            java.lang.String r2 = r2.toString(r3)     // Catch:{ JSONException -> 0x0061 }
            r1.debug(r2)     // Catch:{ JSONException -> 0x0061 }
            goto L_0x0056
        L_0x0044:
            twitter4j.Logger r1 = logger     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r2 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            goto L_0x0053
        L_0x004d:
            twitter4j.JSONObject r2 = r6.json     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0061 }
        L_0x0053:
            r1.debug(r2)     // Catch:{ JSONException -> 0x0061 }
        L_0x0056:
            if (r0 == 0) goto L_0x005b
            r0.close()     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            r6.disconnectForcibly()
            goto L_0x0099
        L_0x005f:
            r1 = move-exception
            goto L_0x0090
        L_0x0061:
            r1 = move-exception
        L_0x0062:
            java.lang.String r2 = r6.responseAsString     // Catch:{ all -> 0x005f }
            if (r2 != 0) goto L_0x0070
            twitter4j.TwitterException r2 = new twitter4j.TwitterException     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x0070:
            twitter4j.TwitterException r2 = new twitter4j.TwitterException     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r3.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x005f }
            r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r4 = ":"
            r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r6.responseAsString     // Catch:{ all -> 0x005f }
            r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x0090:
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch:{ IOException -> 0x0095 }
        L_0x0095:
            r6.disconnectForcibly()
            throw r1
        L_0x0099:
            twitter4j.JSONObject r0 = r6.json
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpResponse.asJSONObject():twitter4j.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a A[Catch:{ all -> 0x005f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0096 A[SYNTHETIC, Splitter:B:39:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public twitter4j.JSONArray asJSONArray() throws twitter4j.TwitterException {
        /*
            r6 = this;
            twitter4j.JSONArray r0 = r6.jsonArray
            if (r0 != 0) goto L_0x009d
            r0 = 0
            java.lang.String r1 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            if (r1 != 0) goto L_0x0026
            java.io.Reader r1 = r6.asReader()     // Catch:{ JSONException -> 0x0061 }
            twitter4j.JSONArray r0 = new twitter4j.JSONArray     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            twitter4j.JSONTokener r2 = new twitter4j.JSONTokener     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r6.jsonArray = r0     // Catch:{ JSONException -> 0x0021, all -> 0x001b }
            r0 = r1
            goto L_0x002f
        L_0x001b:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0094
        L_0x0021:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0062
        L_0x0026:
            twitter4j.JSONArray r1 = new twitter4j.JSONArray     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r2 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x0061 }
            r6.jsonArray = r1     // Catch:{ JSONException -> 0x0061 }
        L_0x002f:
            twitter4j.HttpClientConfiguration r1 = r6.CONF     // Catch:{ JSONException -> 0x0061 }
            boolean r1 = r1.isPrettyDebugEnabled()     // Catch:{ JSONException -> 0x0061 }
            if (r1 == 0) goto L_0x0044
            twitter4j.Logger r1 = logger     // Catch:{ JSONException -> 0x0061 }
            twitter4j.JSONArray r2 = r6.jsonArray     // Catch:{ JSONException -> 0x0061 }
            r3 = 1
            java.lang.String r2 = r2.toString(r3)     // Catch:{ JSONException -> 0x0061 }
            r1.debug(r2)     // Catch:{ JSONException -> 0x0061 }
            goto L_0x0056
        L_0x0044:
            twitter4j.Logger r1 = logger     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r2 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = r6.responseAsString     // Catch:{ JSONException -> 0x0061 }
            goto L_0x0053
        L_0x004d:
            twitter4j.JSONArray r2 = r6.jsonArray     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0061 }
        L_0x0053:
            r1.debug(r2)     // Catch:{ JSONException -> 0x0061 }
        L_0x0056:
            if (r0 == 0) goto L_0x005b
            r0.close()     // Catch:{ IOException -> 0x005b }
        L_0x005b:
            r6.disconnectForcibly()
            goto L_0x009d
        L_0x005f:
            r1 = move-exception
            goto L_0x0094
        L_0x0061:
            r1 = move-exception
        L_0x0062:
            twitter4j.Logger r2 = logger     // Catch:{ all -> 0x005f }
            boolean r2 = r2.isDebugEnabled()     // Catch:{ all -> 0x005f }
            if (r2 == 0) goto L_0x008a
            twitter4j.TwitterException r2 = new twitter4j.TwitterException     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r3.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x005f }
            r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r4 = ":"
            r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r6.responseAsString     // Catch:{ all -> 0x005f }
            r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x008a:
            twitter4j.TwitterException r2 = new twitter4j.TwitterException     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x0094:
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ IOException -> 0x0099 }
        L_0x0099:
            r6.disconnectForcibly()
            throw r1
        L_0x009d:
            twitter4j.JSONArray r0 = r6.jsonArray
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpResponse.asJSONArray():twitter4j.JSONArray");
    }

    public Reader asReader() {
        try {
            return new BufferedReader(new InputStreamReader(this.f9918is, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return new InputStreamReader(this.f9918is);
        }
    }

    private void disconnectForcibly() {
        try {
            disconnect();
        } catch (Exception unused) {
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpResponse{statusCode=");
        sb.append(this.statusCode);
        sb.append(", responseAsString='");
        sb.append(this.responseAsString);
        sb.append('\'');
        sb.append(", is=");
        sb.append(this.f9918is);
        sb.append(", streamConsumed=");
        sb.append(this.streamConsumed);
        sb.append('}');
        return sb.toString();
    }
}
