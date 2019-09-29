package twitter4j;

import com.google.android.gms.common.internal.ImagesContract;
import twitter4j.conf.Configuration;

final class LocationJSONImpl implements Location {
    private static final long serialVersionUID = -1312752311160422264L;
    private final String countryCode;
    private final String countryName;
    private final String name;
    private final int placeCode;
    private final String placeName;
    private final String url;
    private final int woeid;

    LocationJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            this.woeid = ParseUtil.getInt("woeid", jSONObject);
            this.countryName = ParseUtil.getUnescapedString("country", jSONObject);
            this.countryCode = ParseUtil.getRawString("countryCode", jSONObject);
            if (!jSONObject.isNull("placeType")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("placeType");
                this.placeName = ParseUtil.getUnescapedString("name", jSONObject2);
                this.placeCode = ParseUtil.getInt("code", jSONObject2);
            } else {
                this.placeName = null;
                this.placeCode = -1;
            }
            this.name = ParseUtil.getUnescapedString("name", jSONObject);
            this.url = ParseUtil.getUnescapedString(ImagesContract.URL, jSONObject);
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    static ResponseList<Location> createLocationList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        return createLocationList(httpResponse.asJSONArray(), configuration.isJSONStoreEnabled());
    }

    static ResponseList<Location> createLocationList(JSONArray jSONArray, boolean z) throws TwitterException {
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, (HttpResponse) null);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                LocationJSONImpl locationJSONImpl = new LocationJSONImpl(jSONObject);
                responseListImpl.add(locationJSONImpl);
                if (z) {
                    TwitterObjectFactory.registerJSONObject(locationJSONImpl, jSONObject);
                }
            }
            if (z) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public int getWoeid() {
        return this.woeid;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public int getPlaceCode() {
        return this.placeCode;
    }

    public String getName() {
        return this.name;
    }

    public String getURL() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationJSONImpl)) {
            return false;
        }
        return this.woeid == ((LocationJSONImpl) obj).woeid;
    }

    public int hashCode() {
        return this.woeid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationJSONImpl{woeid=");
        sb.append(this.woeid);
        sb.append(", countryName='");
        sb.append(this.countryName);
        sb.append('\'');
        sb.append(", countryCode='");
        sb.append(this.countryCode);
        sb.append('\'');
        sb.append(", placeName='");
        sb.append(this.placeName);
        sb.append('\'');
        sb.append(", placeCode='");
        sb.append(this.placeCode);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
