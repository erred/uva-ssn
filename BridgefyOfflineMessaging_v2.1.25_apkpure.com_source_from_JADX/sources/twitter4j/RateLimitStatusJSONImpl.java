package twitter4j;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import twitter4j.conf.Configuration;

final class RateLimitStatusJSONImpl implements Serializable, RateLimitStatus {
    private static final long serialVersionUID = 7790337632915862445L;
    private int limit;
    private int remaining;
    private int resetTimeInSeconds;
    private int secondsUntilReset;

    static Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject asJSONObject = httpResponse.asJSONObject();
        Map<String, RateLimitStatus> createRateLimitStatuses = createRateLimitStatuses(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(createRateLimitStatuses, asJSONObject);
        }
        return createRateLimitStatuses;
    }

    static Map<String, RateLimitStatus> createRateLimitStatuses(JSONObject jSONObject) throws TwitterException {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("resources");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject((String) keys.next());
                Iterator keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String str = (String) keys2.next();
                    hashMap.put(str, new RateLimitStatusJSONImpl(jSONObject3.getJSONObject(str)));
                }
            }
            return Collections.unmodifiableMap(hashMap);
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    private RateLimitStatusJSONImpl(int i, int i2, int i3) {
        this.limit = i;
        this.remaining = i2;
        this.resetTimeInSeconds = i3;
        this.secondsUntilReset = (int) (((((long) i3) * 1000) - System.currentTimeMillis()) / 1000);
    }

    RateLimitStatusJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    /* access modifiers changed from: 0000 */
    public void init(JSONObject jSONObject) throws TwitterException {
        this.limit = ParseUtil.getInt("limit", jSONObject);
        this.remaining = ParseUtil.getInt("remaining", jSONObject);
        this.resetTimeInSeconds = ParseUtil.getInt("reset", jSONObject);
        this.secondsUntilReset = (int) (((((long) this.resetTimeInSeconds) * 1000) - System.currentTimeMillis()) / 1000);
    }

    static RateLimitStatus createFromResponseHeader(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return null;
        }
        String responseHeader = httpResponse.getResponseHeader("X-Rate-Limit-Limit");
        if (responseHeader == null) {
            return null;
        }
        int parseInt = Integer.parseInt(responseHeader);
        String responseHeader2 = httpResponse.getResponseHeader("X-Rate-Limit-Remaining");
        if (responseHeader2 == null) {
            return null;
        }
        int parseInt2 = Integer.parseInt(responseHeader2);
        String responseHeader3 = httpResponse.getResponseHeader("X-Rate-Limit-Reset");
        if (responseHeader3 != null) {
            return new RateLimitStatusJSONImpl(parseInt, parseInt2, (int) Long.parseLong(responseHeader3));
        }
        return null;
    }

    public int getRemaining() {
        return this.remaining;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getResetTimeInSeconds() {
        return this.resetTimeInSeconds;
    }

    public int getSecondsUntilReset() {
        return this.secondsUntilReset;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RateLimitStatusJSONImpl rateLimitStatusJSONImpl = (RateLimitStatusJSONImpl) obj;
        return this.limit == rateLimitStatusJSONImpl.limit && this.remaining == rateLimitStatusJSONImpl.remaining && this.resetTimeInSeconds == rateLimitStatusJSONImpl.resetTimeInSeconds && this.secondsUntilReset == rateLimitStatusJSONImpl.secondsUntilReset;
    }

    public int hashCode() {
        return (((((this.remaining * 31) + this.limit) * 31) + this.resetTimeInSeconds) * 31) + this.secondsUntilReset;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RateLimitStatusJSONImpl{remaining=");
        sb.append(this.remaining);
        sb.append(", limit=");
        sb.append(this.limit);
        sb.append(", resetTimeInSeconds=");
        sb.append(this.resetTimeInSeconds);
        sb.append(", secondsUntilReset=");
        sb.append(this.secondsUntilReset);
        sb.append('}');
        return sb.toString();
    }
}
