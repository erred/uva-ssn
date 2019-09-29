package twitter4j;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.Serializable;
import twitter4j.conf.Configuration;

public class OEmbedJSONImpl extends TwitterResponseImpl implements Serializable, OEmbed {
    private static final long serialVersionUID = -2207801480251709819L;
    private String authorName;
    private String authorURL;
    private long cacheAge;
    private String html;
    private String url;
    private String version;
    private int width;

    public /* bridge */ /* synthetic */ int getAccessLevel() {
        return super.getAccessLevel();
    }

    public /* bridge */ /* synthetic */ RateLimitStatus getRateLimitStatus() {
        return super.getRateLimitStatus();
    }

    OEmbedJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    OEmbedJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.html = jSONObject.getString("html");
            this.authorName = jSONObject.getString("author_name");
            this.url = jSONObject.getString(ImagesContract.URL);
            this.version = jSONObject.getString("version");
            this.cacheAge = jSONObject.getLong("cache_age");
            this.authorURL = jSONObject.getString("author_url");
            this.width = jSONObject.getInt("width");
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public String getHtml() {
        return this.html;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getURL() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public long getCacheAge() {
        return this.cacheAge;
    }

    public String getAuthorURL() {
        return this.authorURL;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OEmbedJSONImpl oEmbedJSONImpl = (OEmbedJSONImpl) obj;
        if (this.cacheAge != oEmbedJSONImpl.cacheAge || this.width != oEmbedJSONImpl.width) {
            return false;
        }
        if (this.authorName == null ? oEmbedJSONImpl.authorName != null : !this.authorName.equals(oEmbedJSONImpl.authorName)) {
            return false;
        }
        if (this.authorURL == null ? oEmbedJSONImpl.authorURL != null : !this.authorURL.equals(oEmbedJSONImpl.authorURL)) {
            return false;
        }
        if (this.html == null ? oEmbedJSONImpl.html != null : !this.html.equals(oEmbedJSONImpl.html)) {
            return false;
        }
        if (this.url == null ? oEmbedJSONImpl.url == null : this.url.equals(oEmbedJSONImpl.url)) {
            return this.version == null ? oEmbedJSONImpl.version == null : this.version.equals(oEmbedJSONImpl.version);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((this.html != null ? this.html.hashCode() : 0) * 31) + (this.authorName != null ? this.authorName.hashCode() : 0)) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + (this.version != null ? this.version.hashCode() : 0)) * 31) + ((int) (this.cacheAge ^ (this.cacheAge >>> 32)))) * 31;
        if (this.authorURL != null) {
            i = this.authorURL.hashCode();
        }
        return ((hashCode + i) * 31) + this.width;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OEmbedJSONImpl{html='");
        sb.append(this.html);
        sb.append('\'');
        sb.append(", authorName='");
        sb.append(this.authorName);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", cacheAge=");
        sb.append(this.cacheAge);
        sb.append(", authorURL='");
        sb.append(this.authorURL);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.width);
        sb.append('}');
        return sb.toString();
    }
}
