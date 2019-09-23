package twitter4j;

public final class HttpResponseEvent {
    private final HttpRequest request;
    private final HttpResponse response;
    private final TwitterException twitterException;

    HttpResponseEvent(HttpRequest httpRequest, HttpResponse httpResponse, TwitterException twitterException2) {
        this.request = httpRequest;
        this.response = httpResponse;
        this.twitterException = twitterException2;
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public TwitterException getTwitterException() {
        return this.twitterException;
    }

    public boolean isAuthenticated() {
        return this.request.getAuthorization().isEnabled();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpResponseEvent httpResponseEvent = (HttpResponseEvent) obj;
        if (this.request == null ? httpResponseEvent.request == null : this.request.equals(httpResponseEvent.request)) {
            return this.response == null ? httpResponseEvent.response == null : this.response.equals(httpResponseEvent.response);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.request != null ? this.request.hashCode() : 0) * 31;
        if (this.response != null) {
            i = this.response.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpResponseEvent{request=");
        sb.append(this.request);
        sb.append(", response=");
        sb.append(this.response);
        sb.append('}');
        return sb.toString();
    }
}
