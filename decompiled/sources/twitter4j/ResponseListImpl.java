package twitter4j;

import java.util.ArrayList;

class ResponseListImpl<T> extends ArrayList<T> implements ResponseList<T> {
    private static final long serialVersionUID = 9105950888010803544L;
    private transient int accessLevel;
    private transient RateLimitStatus rateLimitStatus = null;

    ResponseListImpl(HttpResponse httpResponse) {
        init(httpResponse);
    }

    ResponseListImpl(int i, HttpResponse httpResponse) {
        super(i);
        init(httpResponse);
    }

    ResponseListImpl(RateLimitStatus rateLimitStatus2, int i) {
        this.rateLimitStatus = rateLimitStatus2;
        this.accessLevel = i;
    }

    private void init(HttpResponse httpResponse) {
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(httpResponse);
        this.accessLevel = ParseUtil.toAccessLevel(httpResponse);
    }

    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }

    public int getAccessLevel() {
        return this.accessLevel;
    }
}
