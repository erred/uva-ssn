package twitter4j;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import twitter4j.conf.Configuration;

final class PlaceJSONImpl extends TwitterResponseImpl implements Serializable, Place {
    private static final long serialVersionUID = -6368276880878829754L;
    private GeoLocation[][] boundingBoxCoordinates;
    private String boundingBoxType;
    private Place[] containedWithIn;
    private String country;
    private String countryCode;
    private String fullName;
    private GeoLocation[][] geometryCoordinates;
    private String geometryType;

    /* renamed from: id */
    private String f9922id;
    private String name;
    private String placeType;
    private String streetAddress;
    private String url;

    PlaceJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    PlaceJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    PlaceJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.name = ParseUtil.getUnescapedString("name", jSONObject);
            this.streetAddress = ParseUtil.getUnescapedString("street_address", jSONObject);
            this.countryCode = ParseUtil.getRawString("country_code", jSONObject);
            this.f9922id = ParseUtil.getRawString("id", jSONObject);
            this.country = ParseUtil.getRawString("country", jSONObject);
            if (!jSONObject.isNull("place_type")) {
                this.placeType = ParseUtil.getRawString("place_type", jSONObject);
            } else {
                this.placeType = ParseUtil.getRawString(Param.TYPE, jSONObject);
            }
            this.url = ParseUtil.getRawString(ImagesContract.URL, jSONObject);
            this.fullName = ParseUtil.getRawString("full_name", jSONObject);
            if (!jSONObject.isNull("bounding_box")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("bounding_box");
                this.boundingBoxType = ParseUtil.getRawString(Param.TYPE, jSONObject2);
                this.boundingBoxCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONObject2.getJSONArray("coordinates"));
            } else {
                this.boundingBoxType = null;
                this.boundingBoxCoordinates = null;
            }
            if (!jSONObject.isNull("geometry")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("geometry");
                this.geometryType = ParseUtil.getRawString(Param.TYPE, jSONObject3);
                JSONArray jSONArray = jSONObject3.getJSONArray("coordinates");
                if (this.geometryType.equals("Point")) {
                    this.geometryCoordinates = (GeoLocation[][]) Array.newInstance(GeoLocation.class, new int[]{1, 1});
                    this.geometryCoordinates[0][0] = new GeoLocation(jSONArray.getDouble(1), jSONArray.getDouble(0));
                } else if (this.geometryType.equals("Polygon")) {
                    this.geometryCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONArray);
                } else {
                    this.geometryType = null;
                    this.geometryCoordinates = null;
                }
            } else {
                this.geometryType = null;
                this.geometryCoordinates = null;
            }
            if (!jSONObject.isNull("contained_within")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("contained_within");
                this.containedWithIn = new Place[jSONArray2.length()];
                for (int i = 0; i < jSONArray2.length(); i++) {
                    this.containedWithIn[i] = new PlaceJSONImpl(jSONArray2.getJSONObject(i));
                }
                return;
            }
            this.containedWithIn = null;
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(":");
            sb.append(jSONObject.toString());
            throw new TwitterException(sb.toString(), (Throwable) e);
        }
    }

    public int compareTo(Place place) {
        return this.f9922id.compareTo(place.getId());
    }

    static ResponseList<Place> createPlaceList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject jSONObject;
        try {
            jSONObject = httpResponse.asJSONObject();
            try {
                return createPlaceList(jSONObject.getJSONObject("result").getJSONArray("places"), httpResponse, configuration);
            } catch (JSONException e) {
                e = e;
                StringBuilder sb = new StringBuilder();
                sb.append(e.getMessage());
                sb.append(":");
                sb.append(jSONObject.toString());
                throw new TwitterException(sb.toString(), (Throwable) e);
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e.getMessage());
            sb2.append(":");
            sb2.append(jSONObject.toString());
            throw new TwitterException(sb2.toString(), (Throwable) e);
        }
    }

    static ResponseList<Place> createPlaceList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                PlaceJSONImpl placeJSONImpl = new PlaceJSONImpl(jSONObject);
                responseListImpl.add(placeJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(placeJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getId() {
        return this.f9922id;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPlaceType() {
        return this.placeType;
    }

    public String getURL() {
        return this.url;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getBoundingBoxType() {
        return this.boundingBoxType;
    }

    public GeoLocation[][] getBoundingBoxCoordinates() {
        return this.boundingBoxCoordinates;
    }

    public String getGeometryType() {
        return this.geometryType;
    }

    public GeoLocation[][] getGeometryCoordinates() {
        return this.geometryCoordinates;
    }

    public Place[] getContainedWithIn() {
        return this.containedWithIn;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Place) && ((Place) obj).getId().equals(this.f9922id)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f9922id.hashCode();
    }

    public String toString() {
        Object obj;
        Object obj2;
        StringBuilder sb = new StringBuilder();
        sb.append("PlaceJSONImpl{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", streetAddress='");
        sb.append(this.streetAddress);
        sb.append('\'');
        sb.append(", countryCode='");
        sb.append(this.countryCode);
        sb.append('\'');
        sb.append(", id='");
        sb.append(this.f9922id);
        sb.append('\'');
        sb.append(", country='");
        sb.append(this.country);
        sb.append('\'');
        sb.append(", placeType='");
        sb.append(this.placeType);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", fullName='");
        sb.append(this.fullName);
        sb.append('\'');
        sb.append(", boundingBoxType='");
        sb.append(this.boundingBoxType);
        sb.append('\'');
        sb.append(", boundingBoxCoordinates=");
        List list = null;
        if (this.boundingBoxCoordinates == null) {
            obj = null;
        } else {
            obj = Arrays.asList(this.boundingBoxCoordinates);
        }
        sb.append(obj);
        sb.append(", geometryType='");
        sb.append(this.geometryType);
        sb.append('\'');
        sb.append(", geometryCoordinates=");
        if (this.geometryCoordinates == null) {
            obj2 = null;
        } else {
            obj2 = Arrays.asList(this.geometryCoordinates);
        }
        sb.append(obj2);
        sb.append(", containedWithIn=");
        if (this.containedWithIn != null) {
            list = Arrays.asList(this.containedWithIn);
        }
        sb.append(list);
        sb.append('}');
        return sb.toString();
    }
}
