package twitter4j;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import twitter4j.MediaEntity.Size;
import twitter4j.conf.Configuration;

class TwitterAPIConfigurationJSONImpl extends TwitterResponseImpl implements TwitterAPIConfiguration {
    private static final long serialVersionUID = -3588904550808591686L;
    private int charactersReservedPerMedia;
    private int maxMediaPerUpload;
    private String[] nonUsernamePaths;
    private int photoSizeLimit;
    private Map<Integer, Size> photoSizes;
    private int shortURLLength;
    private int shortURLLengthHttps;

    TwitterAPIConfigurationJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject jSONObject;
        super(httpResponse);
        try {
            JSONObject asJSONObject = httpResponse.asJSONObject();
            this.photoSizeLimit = ParseUtil.getInt("photo_size_limit", asJSONObject);
            this.shortURLLength = ParseUtil.getInt("short_url_length", asJSONObject);
            this.shortURLLengthHttps = ParseUtil.getInt("short_url_length_https", asJSONObject);
            this.charactersReservedPerMedia = ParseUtil.getInt("characters_reserved_per_media", asJSONObject);
            JSONObject jSONObject2 = asJSONObject.getJSONObject("photo_sizes");
            this.photoSizes = new HashMap(4);
            this.photoSizes.put(Size.LARGE, new Size(jSONObject2.getJSONObject("large")));
            if (jSONObject2.isNull("med")) {
                jSONObject = jSONObject2.getJSONObject(Param.MEDIUM);
            } else {
                jSONObject = jSONObject2.getJSONObject("med");
            }
            this.photoSizes.put(Size.MEDIUM, new Size(jSONObject));
            this.photoSizes.put(Size.SMALL, new Size(jSONObject2.getJSONObject("small")));
            this.photoSizes.put(Size.THUMB, new Size(jSONObject2.getJSONObject("thumb")));
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
                TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
            }
            JSONArray jSONArray = asJSONObject.getJSONArray("non_username_paths");
            this.nonUsernamePaths = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                this.nonUsernamePaths[i] = jSONArray.getString(i);
            }
            this.maxMediaPerUpload = ParseUtil.getInt("max_media_per_upload", asJSONObject);
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public int getPhotoSizeLimit() {
        return this.photoSizeLimit;
    }

    public int getShortURLLength() {
        return this.shortURLLength;
    }

    public int getShortURLLengthHttps() {
        return this.shortURLLengthHttps;
    }

    public int getCharactersReservedPerMedia() {
        return this.charactersReservedPerMedia;
    }

    public Map<Integer, Size> getPhotoSizes() {
        return this.photoSizes;
    }

    public String[] getNonUsernamePaths() {
        return this.nonUsernamePaths;
    }

    public int getMaxMediaPerUpload() {
        return this.maxMediaPerUpload;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterAPIConfigurationJSONImpl)) {
            return false;
        }
        TwitterAPIConfigurationJSONImpl twitterAPIConfigurationJSONImpl = (TwitterAPIConfigurationJSONImpl) obj;
        if (this.charactersReservedPerMedia == twitterAPIConfigurationJSONImpl.charactersReservedPerMedia && this.maxMediaPerUpload == twitterAPIConfigurationJSONImpl.maxMediaPerUpload && this.photoSizeLimit == twitterAPIConfigurationJSONImpl.photoSizeLimit && this.shortURLLength == twitterAPIConfigurationJSONImpl.shortURLLength && this.shortURLLengthHttps == twitterAPIConfigurationJSONImpl.shortURLLengthHttps && Arrays.equals(this.nonUsernamePaths, twitterAPIConfigurationJSONImpl.nonUsernamePaths)) {
            return this.photoSizes == null ? twitterAPIConfigurationJSONImpl.photoSizes == null : this.photoSizes.equals(twitterAPIConfigurationJSONImpl.photoSizes);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.photoSizeLimit * 31) + this.shortURLLength) * 31) + this.shortURLLengthHttps) * 31) + this.charactersReservedPerMedia) * 31) + (this.photoSizes != null ? this.photoSizes.hashCode() : 0)) * 31;
        if (this.nonUsernamePaths != null) {
            i = Arrays.hashCode(this.nonUsernamePaths);
        }
        return ((hashCode + i) * 31) + this.maxMediaPerUpload;
    }

    public String toString() {
        List list;
        StringBuilder sb = new StringBuilder();
        sb.append("TwitterAPIConfigurationJSONImpl{photoSizeLimit=");
        sb.append(this.photoSizeLimit);
        sb.append(", shortURLLength=");
        sb.append(this.shortURLLength);
        sb.append(", shortURLLengthHttps=");
        sb.append(this.shortURLLengthHttps);
        sb.append(", charactersReservedPerMedia=");
        sb.append(this.charactersReservedPerMedia);
        sb.append(", photoSizes=");
        sb.append(this.photoSizes);
        sb.append(", nonUsernamePaths=");
        if (this.nonUsernamePaths == null) {
            list = null;
        } else {
            list = Arrays.asList(this.nonUsernamePaths);
        }
        sb.append(list);
        sb.append(", maxMediaPerUpload=");
        sb.append(this.maxMediaPerUpload);
        sb.append('}');
        return sb.toString();
    }
}
