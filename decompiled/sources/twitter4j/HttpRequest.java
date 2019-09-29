package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import twitter4j.auth.Authorization;

public final class HttpRequest implements Serializable {
    private static final HttpParameter[] NULL_PARAMETERS = new HttpParameter[0];
    private static final long serialVersionUID = 3365496352032493020L;
    private final Authorization authorization;
    private final RequestMethod method;
    private final HttpParameter[] parameters;
    private final Map<String, String> requestHeaders;
    private final String url;

    public HttpRequest(RequestMethod requestMethod, String str, HttpParameter[] httpParameterArr, Authorization authorization2, Map<String, String> map) {
        this.method = requestMethod;
        if (requestMethod == RequestMethod.POST || httpParameterArr == null || httpParameterArr.length == 0) {
            this.url = str;
            this.parameters = httpParameterArr;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?");
            sb.append(HttpParameter.encodeParameters(httpParameterArr));
            this.url = sb.toString();
            this.parameters = NULL_PARAMETERS;
        }
        this.authorization = authorization2;
        this.requestHeaders = map;
    }

    public RequestMethod getMethod() {
        return this.method;
    }

    public HttpParameter[] getParameters() {
        return this.parameters;
    }

    public String getURL() {
        return this.url;
    }

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        if (this.authorization == null ? httpRequest.authorization != null : !this.authorization.equals(httpRequest.authorization)) {
            return false;
        }
        if (!Arrays.equals(this.parameters, httpRequest.parameters)) {
            return false;
        }
        if (this.requestHeaders == null ? httpRequest.requestHeaders != null : !this.requestHeaders.equals(httpRequest.requestHeaders)) {
            return false;
        }
        if (this.method == null ? httpRequest.method == null : this.method.equals(httpRequest.method)) {
            return this.url == null ? httpRequest.url == null : this.url.equals(httpRequest.url);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((this.method != null ? this.method.hashCode() : 0) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + (this.parameters != null ? Arrays.hashCode(this.parameters) : 0)) * 31) + (this.authorization != null ? this.authorization.hashCode() : 0)) * 31;
        if (this.requestHeaders != null) {
            i = this.requestHeaders.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        List list;
        StringBuilder sb = new StringBuilder();
        sb.append("HttpRequest{requestMethod=");
        sb.append(this.method);
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", postParams=");
        if (this.parameters == null) {
            list = null;
        } else {
            list = Arrays.asList(this.parameters);
        }
        sb.append(list);
        sb.append(", authentication=");
        sb.append(this.authorization);
        sb.append(", requestHeaders=");
        sb.append(this.requestHeaders);
        sb.append('}');
        return sb.toString();
    }
}
