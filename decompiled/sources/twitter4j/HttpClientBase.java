package twitter4j;

import com.google.common.net.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import twitter4j.auth.Authorization;

public abstract class HttpClientBase implements Serializable, HttpClient {
    private static final Logger logger = Logger.getLogger(HttpClientBase.class);
    private static final long serialVersionUID = -8016974810651763053L;
    protected final HttpClientConfiguration CONF;
    private final Map<String, String> requestHeaders = new HashMap();

    /* access modifiers changed from: 0000 */
    public abstract HttpResponse handleRequest(HttpRequest httpRequest) throws TwitterException;

    public HttpClientBase(HttpClientConfiguration httpClientConfiguration) {
        this.CONF = httpClientConfiguration;
        this.requestHeaders.put("X-Twitter-Client-Version", Version.getVersion());
        StringBuilder sb = new StringBuilder();
        sb.append("http://twitter4j.org/en/twitter4j-");
        sb.append(Version.getVersion());
        sb.append(".xml");
        this.requestHeaders.put("X-Twitter-Client-URL", sb.toString());
        this.requestHeaders.put("X-Twitter-Client", "Twitter4J");
        Map<String, String> map = this.requestHeaders;
        String str = HttpHeaders.USER_AGENT;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("twitter4j http://twitter4j.org/ /");
        sb2.append(Version.getVersion());
        map.put(str, sb2.toString());
        if (httpClientConfiguration.isGZIPEnabled()) {
            this.requestHeaders.put(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isProxyConfigured() {
        return this.CONF.getHttpProxyHost() != null && !this.CONF.getHttpProxyHost().equals("");
    }

    public void write(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        logger.debug(str);
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public void addDefaultRequestHeader(String str, String str2) {
        this.requestHeaders.put(str, str2);
    }

    public final HttpResponse request(HttpRequest httpRequest) throws TwitterException {
        return handleRequest(httpRequest);
    }

    public final HttpResponse request(HttpRequest httpRequest, HttpResponseListener httpResponseListener) throws TwitterException {
        try {
            HttpResponse handleRequest = handleRequest(httpRequest);
            if (httpResponseListener != null) {
                httpResponseListener.httpResponseReceived(new HttpResponseEvent(httpRequest, handleRequest, null));
            }
            return handleRequest;
        } catch (TwitterException e) {
            if (httpResponseListener != null) {
                httpResponseListener.httpResponseReceived(new HttpResponseEvent(httpRequest, null, e));
            }
            throw e;
        }
    }

    public HttpResponse get(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.GET, str, httpParameterArr, authorization, this.requestHeaders);
        return request(httpRequest, httpResponseListener);
    }

    public HttpResponse get(String str) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.GET, str, null, null, this.requestHeaders);
        return request(httpRequest);
    }

    public HttpResponse post(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.POST, str, httpParameterArr, authorization, this.requestHeaders);
        return request(httpRequest, httpResponseListener);
    }

    public HttpResponse post(String str) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.POST, str, null, null, this.requestHeaders);
        return request(httpRequest);
    }

    public HttpResponse delete(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.DELETE, str, httpParameterArr, authorization, this.requestHeaders);
        return request(httpRequest, httpResponseListener);
    }

    public HttpResponse delete(String str) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.DELETE, str, null, null, this.requestHeaders);
        return request(httpRequest);
    }

    public HttpResponse head(String str) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.HEAD, str, null, null, this.requestHeaders);
        return request(httpRequest);
    }

    public HttpResponse put(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.PUT, str, httpParameterArr, authorization, this.requestHeaders);
        return request(httpRequest, httpResponseListener);
    }

    public HttpResponse put(String str) throws TwitterException {
        HttpRequest httpRequest = new HttpRequest(RequestMethod.PUT, str, null, null, this.requestHeaders);
        return request(httpRequest);
    }
}
