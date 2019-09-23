package twitter4j;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import twitter4j.conf.ConfigurationContext;

class HttpClientImpl extends HttpClientBase implements Serializable, HttpResponseCode {
    private static final Map<HttpClientConfiguration, HttpClient> instanceMap = new HashMap(1);
    private static final Logger logger = Logger.getLogger(HttpClientImpl.class);
    private static final long serialVersionUID = -403500272719330534L;

    static {
        try {
            if (Integer.parseInt((String) Class.forName("android.os.Build$VERSION").getField("SDK").get(null)) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
        } catch (Exception unused) {
        }
    }

    public HttpClientImpl() {
        super(ConfigurationContext.getInstance().getHttpClientConfiguration());
    }

    public HttpClientImpl(HttpClientConfiguration httpClientConfiguration) {
        super(httpClientConfiguration);
    }

    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        HttpClient httpClient = (HttpClient) instanceMap.get(httpClientConfiguration);
        if (httpClient != null) {
            return httpClient;
        }
        HttpClientImpl httpClientImpl = new HttpClientImpl(httpClientConfiguration);
        instanceMap.put(httpClientConfiguration, httpClientImpl);
        return httpClientImpl;
    }

    public HttpResponse get(String str) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.GET, str, null, null, null);
        return request(httpRequest);
    }

    public HttpResponse post(String str, HttpParameter[] httpParameterArr) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.POST, str, httpParameterArr, null, null);
        return request(httpRequest);
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r11v0, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r11v11 */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r11v16, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17, types: [int] */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r5v25 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* JADX WARNING: type inference failed for: r5v30 */
    /* JADX WARNING: type inference failed for: r5v31 */
    /* JADX WARNING: type inference failed for: r5v32 */
    /* JADX WARNING: type inference failed for: r5v33 */
    /* JADX WARNING: type inference failed for: r11v20 */
    /* JADX WARNING: type inference failed for: r11v21 */
    /* JADX WARNING: type inference failed for: r11v22 */
    /* JADX WARNING: type inference failed for: r5v34 */
    /* JADX WARNING: type inference failed for: r5v35 */
    /* JADX WARNING: type inference failed for: r5v36 */
    /* JADX WARNING: type inference failed for: r5v37 */
    /* JADX WARNING: type inference failed for: r5v38 */
    /* JADX WARNING: type inference failed for: r5v39 */
    /* JADX WARNING: type inference failed for: r5v40 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x02a0 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v1
      assigns: []
      uses: []
      mth insns count: 298
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 16 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public twitter4j.HttpResponse handleRequest(twitter4j.HttpRequest r19) throws twitter4j.TwitterException {
        /*
            r18 = this;
            r1 = r18
            twitter4j.HttpClientConfiguration r0 = r1.CONF
            int r0 = r0.getHttpRetryCount()
            r2 = 1
            int r3 = r0 + 1
            r6 = 0
            r7 = 0
        L_0x000d:
            if (r6 >= r3) goto L_0x02f3
            r8 = -1
            java.lang.String r0 = r19.getURL()     // Catch:{ all -> 0x0293 }
            java.net.HttpURLConnection r0 = r1.getConnection(r0)     // Catch:{ all -> 0x0293 }
            r0.setDoInput(r2)     // Catch:{ all -> 0x0293 }
            r9 = r19
            r1.setHeaders(r9, r0)     // Catch:{ all -> 0x0291 }
            twitter4j.RequestMethod r10 = r19.getMethod()     // Catch:{ all -> 0x0291 }
            java.lang.String r10 = r10.name()     // Catch:{ all -> 0x0291 }
            r0.setRequestMethod(r10)     // Catch:{ all -> 0x0291 }
            twitter4j.RequestMethod r10 = r19.getMethod()     // Catch:{ all -> 0x0291 }
            twitter4j.RequestMethod r11 = twitter4j.RequestMethod.POST     // Catch:{ all -> 0x0291 }
            if (r10 != r11) goto L_0x01e4
            twitter4j.HttpParameter[] r10 = r19.getParameters()     // Catch:{ all -> 0x0291 }
            boolean r10 = twitter4j.HttpParameter.containsFile(r10)     // Catch:{ all -> 0x0291 }
            if (r10 == 0) goto L_0x01a8
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0291 }
            r10.<init>()     // Catch:{ all -> 0x0291 }
            java.lang.String r11 = "----Twitter4J-upload"
            r10.append(r11)     // Catch:{ all -> 0x0291 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0291 }
            r10.append(r11)     // Catch:{ all -> 0x0291 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0291 }
            java.lang.String r11 = "Content-Type"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0291 }
            r12.<init>()     // Catch:{ all -> 0x0291 }
            java.lang.String r13 = "multipart/form-data; boundary="
            r12.append(r13)     // Catch:{ all -> 0x0291 }
            r12.append(r10)     // Catch:{ all -> 0x0291 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0291 }
            r0.setRequestProperty(r11, r12)     // Catch:{ all -> 0x0291 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0291 }
            r11.<init>()     // Catch:{ all -> 0x0291 }
            java.lang.String r12 = "--"
            r11.append(r12)     // Catch:{ all -> 0x0291 }
            r11.append(r10)     // Catch:{ all -> 0x0291 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0291 }
            r0.setDoOutput(r2)     // Catch:{ all -> 0x0291 }
            java.io.OutputStream r11 = r0.getOutputStream()     // Catch:{ all -> 0x0291 }
            java.io.DataOutputStream r12 = new java.io.DataOutputStream     // Catch:{ all -> 0x01a4 }
            r12.<init>(r11)     // Catch:{ all -> 0x01a4 }
            twitter4j.HttpParameter[] r13 = r19.getParameters()     // Catch:{ all -> 0x01a4 }
            int r14 = r13.length     // Catch:{ all -> 0x01a4 }
            r15 = 0
        L_0x008b:
            if (r15 >= r14) goto L_0x0184
            r16 = r13[r15]     // Catch:{ all -> 0x01a4 }
            boolean r17 = r16.isFile()     // Catch:{ all -> 0x01a4 }
            if (r17 == 0) goto L_0x012c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a4 }
            r4.<init>()     // Catch:{ all -> 0x01a4 }
            r4.append(r10)     // Catch:{ all -> 0x01a4 }
            java.lang.String r2 = "\r\n"
            r4.append(r2)     // Catch:{ all -> 0x01a4 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x01a4 }
            r1.write(r12, r2)     // Catch:{ all -> 0x01a4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a4 }
            r2.<init>()     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = "Content-Disposition: form-data; name=\""
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = r16.getName()     // Catch:{ all -> 0x01a4 }
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = "\"; filename=\""
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.io.File r4 = r16.getFile()     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x01a4 }
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = "\"\r\n"
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01a4 }
            r1.write(r12, r2)     // Catch:{ all -> 0x01a4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a4 }
            r2.<init>()     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = "Content-Type: "
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = r16.getContentType()     // Catch:{ all -> 0x01a4 }
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.lang.String r4 = "\r\n\r\n"
            r2.append(r4)     // Catch:{ all -> 0x01a4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01a4 }
            r1.write(r12, r2)     // Catch:{ all -> 0x01a4 }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x01a4 }
            boolean r4 = r16.hasFileBody()     // Catch:{ all -> 0x01a4 }
            if (r4 == 0) goto L_0x0106
            java.io.InputStream r4 = r16.getFileBody()     // Catch:{ all -> 0x0100 }
            goto L_0x010f
        L_0x0100:
            r0 = move-exception
            r2 = r7
            r7 = -1
            r8 = 0
            goto L_0x029a
        L_0x0106:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x01a4 }
            java.io.File r5 = r16.getFile()     // Catch:{ all -> 0x01a4 }
            r4.<init>(r5)     // Catch:{ all -> 0x01a4 }
        L_0x010f:
            r2.<init>(r4)     // Catch:{ all -> 0x01a4 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x01a4 }
        L_0x0116:
            int r5 = r2.read(r4)     // Catch:{ all -> 0x01a4 }
            if (r5 == r8) goto L_0x0122
            r8 = 0
            r12.write(r4, r8, r5)     // Catch:{ all -> 0x01a1 }
            r8 = -1
            goto L_0x0116
        L_0x0122:
            r8 = 0
            java.lang.String r4 = "\r\n"
            r1.write(r12, r4)     // Catch:{ all -> 0x01a1 }
            r2.close()     // Catch:{ all -> 0x01a1 }
            goto L_0x017e
        L_0x012c:
            r8 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r2.<init>()     // Catch:{ all -> 0x01a1 }
            r2.append(r10)     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "\r\n"
            r2.append(r4)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01a1 }
            r1.write(r12, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r2.<init>()     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "Content-Disposition: form-data; name=\""
            r2.append(r4)     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = r16.getName()     // Catch:{ all -> 0x01a1 }
            r2.append(r4)     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "\"\r\n"
            r2.append(r4)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01a1 }
            r1.write(r12, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "Content-Type: text/plain; charset=UTF-8\r\n\r\n"
            r1.write(r12, r2)     // Catch:{ all -> 0x01a1 }
            twitter4j.Logger r2 = logger     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = r16.getValue()     // Catch:{ all -> 0x01a1 }
            r2.debug(r4)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r16.getValue()     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "UTF-8"
            byte[] r2 = r2.getBytes(r4)     // Catch:{ all -> 0x01a1 }
            r12.write(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "\r\n"
            r1.write(r12, r2)     // Catch:{ all -> 0x01a1 }
        L_0x017e:
            int r15 = r15 + 1
            r2 = 1
            r8 = -1
            goto L_0x008b
        L_0x0184:
            r8 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r2.<init>()     // Catch:{ all -> 0x01a1 }
            r2.append(r10)     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "--\r\n"
            r2.append(r4)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01a1 }
            r1.write(r12, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "\r\n"
            r1.write(r12, r2)     // Catch:{ all -> 0x01a1 }
            r5 = r11
            r4 = 1
            goto L_0x01da
        L_0x01a1:
            r0 = move-exception
            goto L_0x028e
        L_0x01a4:
            r0 = move-exception
            r8 = 0
            goto L_0x028e
        L_0x01a8:
            r8 = 0
            java.lang.String r2 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r0.setRequestProperty(r2, r4)     // Catch:{ all -> 0x01e1 }
            twitter4j.HttpParameter[] r2 = r19.getParameters()     // Catch:{ all -> 0x01e1 }
            java.lang.String r2 = twitter4j.HttpParameter.encodeParameters(r2)     // Catch:{ all -> 0x01e1 }
            twitter4j.Logger r4 = logger     // Catch:{ all -> 0x01e1 }
            java.lang.String r5 = "Post Params: "
            r4.debug(r5, r2)     // Catch:{ all -> 0x01e1 }
            java.lang.String r4 = "UTF-8"
            byte[] r2 = r2.getBytes(r4)     // Catch:{ all -> 0x01e1 }
            java.lang.String r4 = "Content-Length"
            int r5 = r2.length     // Catch:{ all -> 0x01e1 }
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x01e1 }
            r0.setRequestProperty(r4, r5)     // Catch:{ all -> 0x01e1 }
            r4 = 1
            r0.setDoOutput(r4)     // Catch:{ all -> 0x01e1 }
            java.io.OutputStream r5 = r0.getOutputStream()     // Catch:{ all -> 0x01e1 }
            r5.write(r2)     // Catch:{ all -> 0x028c }
        L_0x01da:
            r5.flush()     // Catch:{ all -> 0x028c }
            r5.close()     // Catch:{ all -> 0x028c }
            goto L_0x01e7
        L_0x01e1:
            r0 = move-exception
            goto L_0x0297
        L_0x01e4:
            r4 = 1
            r8 = 0
            r5 = 0
        L_0x01e7:
            twitter4j.HttpResponseImpl r2 = new twitter4j.HttpResponseImpl     // Catch:{ all -> 0x028c }
            twitter4j.HttpClientConfiguration r10 = r1.CONF     // Catch:{ all -> 0x028c }
            r2.<init>(r0, r10)     // Catch:{ all -> 0x028c }
            int r7 = r0.getResponseCode()     // Catch:{ all -> 0x0289 }
            twitter4j.Logger r10 = logger     // Catch:{ all -> 0x0286 }
            boolean r10 = r10.isDebugEnabled()     // Catch:{ all -> 0x0286 }
            if (r10 == 0) goto L_0x0252
            twitter4j.Logger r10 = logger     // Catch:{ all -> 0x0286 }
            java.lang.String r11 = "Response: "
            r10.debug(r11)     // Catch:{ all -> 0x0286 }
            java.util.Map r0 = r0.getHeaderFields()     // Catch:{ all -> 0x0286 }
            java.util.Set r10 = r0.keySet()     // Catch:{ all -> 0x0286 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0286 }
        L_0x020d:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0286 }
            if (r11 == 0) goto L_0x0252
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0286 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0286 }
            java.lang.Object r12 = r0.get(r11)     // Catch:{ all -> 0x0286 }
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x0286 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0286 }
        L_0x0223:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0286 }
            if (r13 == 0) goto L_0x020d
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x0286 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0286 }
            if (r11 == 0) goto L_0x024b
            twitter4j.Logger r14 = logger     // Catch:{ all -> 0x0286 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0286 }
            r15.<init>()     // Catch:{ all -> 0x0286 }
            r15.append(r11)     // Catch:{ all -> 0x0286 }
            java.lang.String r4 = ": "
            r15.append(r4)     // Catch:{ all -> 0x0286 }
            r15.append(r13)     // Catch:{ all -> 0x0286 }
            java.lang.String r4 = r15.toString()     // Catch:{ all -> 0x0286 }
            r14.debug(r4)     // Catch:{ all -> 0x0286 }
            goto L_0x0250
        L_0x024b:
            twitter4j.Logger r4 = logger     // Catch:{ all -> 0x0286 }
            r4.debug(r13)     // Catch:{ all -> 0x0286 }
        L_0x0250:
            r4 = 1
            goto L_0x0223
        L_0x0252:
            r0 = 200(0xc8, float:2.8E-43)
            if (r7 < r0) goto L_0x0264
            r0 = 302(0x12e, float:4.23E-43)
            if (r7 == r0) goto L_0x025f
            r0 = 300(0x12c, float:4.2E-43)
            if (r0 > r7) goto L_0x025f
            goto L_0x0264
        L_0x025f:
            r5.close()     // Catch:{ Exception -> 0x02f4 }
            goto L_0x02f4
        L_0x0264:
            r0 = 420(0x1a4, float:5.89E-43)
            if (r7 == r0) goto L_0x027c
            r0 = 400(0x190, float:5.6E-43)
            if (r7 == r0) goto L_0x027c
            r0 = 500(0x1f4, float:7.0E-43)
            if (r7 < r0) goto L_0x027c
            twitter4j.HttpClientConfiguration r0 = r1.CONF     // Catch:{ all -> 0x0286 }
            int r0 = r0.getHttpRetryCount()     // Catch:{ all -> 0x0286 }
            if (r6 == r0) goto L_0x027c
            r5.close()     // Catch:{ Exception -> 0x02a9 }
            goto L_0x02a9
        L_0x027c:
            twitter4j.TwitterException r0 = new twitter4j.TwitterException     // Catch:{ all -> 0x0286 }
            java.lang.String r4 = r2.asString()     // Catch:{ all -> 0x0286 }
            r0.<init>(r4, r2)     // Catch:{ all -> 0x0286 }
            throw r0     // Catch:{ all -> 0x0286 }
        L_0x0286:
            r0 = move-exception
            r11 = r5
            goto L_0x029a
        L_0x0289:
            r0 = move-exception
            r11 = r5
            goto L_0x028f
        L_0x028c:
            r0 = move-exception
            r11 = r5
        L_0x028e:
            r2 = r7
        L_0x028f:
            r7 = -1
            goto L_0x029a
        L_0x0291:
            r0 = move-exception
            goto L_0x0296
        L_0x0293:
            r0 = move-exception
            r9 = r19
        L_0x0296:
            r8 = 0
        L_0x0297:
            r2 = r7
            r7 = -1
            r11 = 0
        L_0x029a:
            r11.close()     // Catch:{ Exception -> 0x02a0 }
            goto L_0x02a0
        L_0x029e:
            r0 = move-exception
            goto L_0x02a1
        L_0x02a0:
            throw r0     // Catch:{ IOException -> 0x029e }
        L_0x02a1:
            twitter4j.HttpClientConfiguration r4 = r1.CONF
            int r4 = r4.getHttpRetryCount()
            if (r6 == r4) goto L_0x02e9
        L_0x02a9:
            r7 = r2
            twitter4j.Logger r0 = logger     // Catch:{ InterruptedException -> 0x02e4 }
            boolean r0 = r0.isDebugEnabled()     // Catch:{ InterruptedException -> 0x02e4 }
            if (r0 == 0) goto L_0x02b7
            if (r7 == 0) goto L_0x02b7
            r7.asString()     // Catch:{ InterruptedException -> 0x02e4 }
        L_0x02b7:
            twitter4j.Logger r0 = logger     // Catch:{ InterruptedException -> 0x02e4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x02e4 }
            r2.<init>()     // Catch:{ InterruptedException -> 0x02e4 }
            java.lang.String r4 = "Sleeping "
            r2.append(r4)     // Catch:{ InterruptedException -> 0x02e4 }
            twitter4j.HttpClientConfiguration r4 = r1.CONF     // Catch:{ InterruptedException -> 0x02e4 }
            int r4 = r4.getHttpRetryIntervalSeconds()     // Catch:{ InterruptedException -> 0x02e4 }
            r2.append(r4)     // Catch:{ InterruptedException -> 0x02e4 }
            java.lang.String r4 = " seconds until the next retry."
            r2.append(r4)     // Catch:{ InterruptedException -> 0x02e4 }
            java.lang.String r2 = r2.toString()     // Catch:{ InterruptedException -> 0x02e4 }
            r0.debug(r2)     // Catch:{ InterruptedException -> 0x02e4 }
            twitter4j.HttpClientConfiguration r0 = r1.CONF     // Catch:{ InterruptedException -> 0x02e4 }
            int r0 = r0.getHttpRetryIntervalSeconds()     // Catch:{ InterruptedException -> 0x02e4 }
            int r0 = r0 * 1000
            long r4 = (long) r0     // Catch:{ InterruptedException -> 0x02e4 }
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x02e4 }
        L_0x02e4:
            int r6 = r6 + 1
            r2 = 1
            goto L_0x000d
        L_0x02e9:
            twitter4j.TwitterException r2 = new twitter4j.TwitterException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0, r7)
            throw r2
        L_0x02f3:
            r2 = r7
        L_0x02f4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpClientImpl.handleRequest(twitter4j.HttpRequest):twitter4j.HttpResponse");
    }

    private void setHeaders(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        if (logger.isDebugEnabled()) {
            logger.debug("Request: ");
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder();
            sb.append(httpRequest.getMethod().name());
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            logger2.debug(sb.toString(), httpRequest.getURL());
        }
        if (httpRequest.getAuthorization() != null) {
            String authorizationHeader = httpRequest.getAuthorization().getAuthorizationHeader(httpRequest);
            if (authorizationHeader != null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Authorization: ", authorizationHeader.replaceAll(".", "*"));
                }
                httpURLConnection.addRequestProperty(HttpHeaders.AUTHORIZATION, authorizationHeader);
            }
        }
        if (httpRequest.getRequestHeaders() != null) {
            for (String str : httpRequest.getRequestHeaders().keySet()) {
                httpURLConnection.addRequestProperty(str, (String) httpRequest.getRequestHeaders().get(str));
                Logger logger3 = logger;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(": ");
                sb2.append((String) httpRequest.getRequestHeaders().get(str));
                logger3.debug(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public HttpURLConnection getConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection;
        if (isProxyConfigured()) {
            if (this.CONF.getHttpProxyUser() != null && !this.CONF.getHttpProxyUser().equals("")) {
                if (logger.isDebugEnabled()) {
                    Logger logger2 = logger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Proxy AuthUser: ");
                    sb.append(this.CONF.getHttpProxyUser());
                    logger2.debug(sb.toString());
                    Logger logger3 = logger;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Proxy AuthPassword: ");
                    sb2.append(this.CONF.getHttpProxyPassword().replaceAll(".", "*"));
                    logger3.debug(sb2.toString());
                }
                Authenticator.setDefault(new Authenticator() {
                    /* access modifiers changed from: protected */
                    public PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType().equals(RequestorType.PROXY)) {
                            return new PasswordAuthentication(HttpClientImpl.this.CONF.getHttpProxyUser(), HttpClientImpl.this.CONF.getHttpProxyPassword().toCharArray());
                        }
                        return null;
                    }
                });
            }
            Proxy proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
            if (logger.isDebugEnabled()) {
                Logger logger4 = logger;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Opening proxied connection(");
                sb3.append(this.CONF.getHttpProxyHost());
                sb3.append(":");
                sb3.append(this.CONF.getHttpProxyPort());
                sb3.append(")");
                logger4.debug(sb3.toString());
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        }
        if (this.CONF.getHttpConnectionTimeout() > 0) {
            httpURLConnection.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
        }
        if (this.CONF.getHttpReadTimeout() > 0) {
            httpURLConnection.setReadTimeout(this.CONF.getHttpReadTimeout());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
