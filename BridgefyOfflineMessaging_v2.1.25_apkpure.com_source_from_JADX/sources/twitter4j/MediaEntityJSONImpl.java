package twitter4j;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;

public class MediaEntityJSONImpl extends EntityIndex implements MediaEntity {
    private static final long serialVersionUID = 3609683338035442290L;
    private String displayURL;
    private String expandedURL;

    /* renamed from: id */
    private long f9920id;
    private String mediaURL;
    private String mediaURLHttps;
    private Map<Integer, twitter4j.MediaEntity.Size> sizes;
    private String type;
    private String url;

    static class Size implements twitter4j.MediaEntity.Size {
        private static final long serialVersionUID = -2515842281909325169L;
        int height;
        int resize;
        int width;

        Size(JSONObject jSONObject) throws JSONException {
            this.width = jSONObject.getInt("w");
            this.height = jSONObject.getInt("h");
            this.resize = "fit".equals(jSONObject.getString("resize")) ? 100 : 101;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public int getResize() {
            return this.resize;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.height == size.height && this.resize == size.resize && this.width == size.width;
        }

        public int hashCode() {
            return (((this.width * 31) + this.height) * 31) + this.resize;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Size{width=");
            sb.append(this.width);
            sb.append(", height=");
            sb.append(this.height);
            sb.append(", resize=");
            sb.append(this.resize);
            sb.append('}');
            return sb.toString();
        }
    }

    public /* bridge */ /* synthetic */ int compareTo(EntityIndex entityIndex) {
        return super.compareTo(entityIndex);
    }

    MediaEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            this.f9920id = ParseUtil.getLong("id", jSONObject);
            this.url = jSONObject.getString(ImagesContract.URL);
            this.expandedURL = jSONObject.getString("expanded_url");
            this.mediaURL = jSONObject.getString("media_url");
            this.mediaURLHttps = jSONObject.getString("media_url_https");
            this.displayURL = jSONObject.getString("display_url");
            JSONObject jSONObject2 = jSONObject.getJSONObject("sizes");
            this.sizes = new HashMap(4);
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, twitter4j.MediaEntity.Size.LARGE, "large");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, twitter4j.MediaEntity.Size.MEDIUM, Param.MEDIUM);
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, twitter4j.MediaEntity.Size.SMALL, "small");
            addMediaEntitySizeIfNotNull(this.sizes, jSONObject2, twitter4j.MediaEntity.Size.THUMB, "thumb");
            if (!jSONObject.isNull(AppMeasurement.Param.TYPE)) {
                this.type = jSONObject.getString(AppMeasurement.Param.TYPE);
            }
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    private void addMediaEntitySizeIfNotNull(Map<Integer, twitter4j.MediaEntity.Size> map, JSONObject jSONObject, Integer num, String str) throws JSONException {
        if (!jSONObject.isNull(str)) {
            map.put(num, new Size(jSONObject.getJSONObject(str)));
        }
    }

    MediaEntityJSONImpl() {
    }

    public long getId() {
        return this.f9920id;
    }

    public String getMediaURL() {
        return this.mediaURL;
    }

    public String getMediaURLHttps() {
        return this.mediaURLHttps;
    }

    public String getText() {
        return this.url;
    }

    public String getURL() {
        return this.url;
    }

    public String getDisplayURL() {
        return this.displayURL;
    }

    public String getExpandedURL() {
        return this.expandedURL;
    }

    public Map<Integer, twitter4j.MediaEntity.Size> getSizes() {
        return this.sizes;
    }

    public String getType() {
        return this.type;
    }

    public int getStart() {
        return super.getStart();
    }

    public int getEnd() {
        return super.getEnd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaEntityJSONImpl)) {
            return false;
        }
        return this.f9920id == ((MediaEntityJSONImpl) obj).f9920id;
    }

    public int hashCode() {
        return (int) (this.f9920id ^ (this.f9920id >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaEntityJSONImpl{id=");
        sb.append(this.f9920id);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", mediaURL=");
        sb.append(this.mediaURL);
        sb.append(", mediaURLHttps=");
        sb.append(this.mediaURLHttps);
        sb.append(", expandedURL=");
        sb.append(this.expandedURL);
        sb.append(", displayURL='");
        sb.append(this.displayURL);
        sb.append('\'');
        sb.append(", sizes=");
        sb.append(this.sizes);
        sb.append(", type=");
        sb.append(this.type);
        sb.append('}');
        return sb.toString();
    }
}
