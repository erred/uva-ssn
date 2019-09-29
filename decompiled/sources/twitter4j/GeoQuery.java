package twitter4j;

import com.google.android.gms.actions.SearchIntents;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class GeoQuery implements Serializable {
    private static final long serialVersionUID = 5434503339001056634L;
    private String accuracy = null;
    private String granularity = null;

    /* renamed from: ip */
    private String f9917ip = null;
    private GeoLocation location;
    private int maxResults = -1;
    private String query = null;

    public GeoQuery(GeoLocation geoLocation) {
        this.location = geoLocation;
    }

    public GeoQuery(String str) {
        this.f9917ip = str;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public String getIp() {
        return this.f9917ip;
    }

    public String getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(String str) {
        this.accuracy = str;
    }

    public GeoQuery accuracy(String str) {
        setAccuracy(str);
        return this;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public void setGranularity(String str) {
        this.granularity = str;
    }

    public GeoQuery granularity(String str) {
        setGranularity(str);
        return this;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(int i) {
        this.maxResults = i;
    }

    public GeoQuery maxResults(int i) {
        setMaxResults(i);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        if (this.location != null) {
            appendParameter("lat", this.location.getLatitude(), (List<HttpParameter>) arrayList);
            appendParameter("long", this.location.getLongitude(), (List<HttpParameter>) arrayList);
        }
        if (this.f9917ip != null) {
            appendParameter("ip", this.f9917ip, (List<HttpParameter>) arrayList);
        }
        appendParameter("accuracy", this.accuracy, (List<HttpParameter>) arrayList);
        appendParameter(SearchIntents.EXTRA_QUERY, this.query, (List<HttpParameter>) arrayList);
        appendParameter("granularity", this.granularity, (List<HttpParameter>) arrayList);
        appendParameter("max_results", this.maxResults, (List<HttpParameter>) arrayList);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, int i, List<HttpParameter> list) {
        if (i > 0) {
            list.add(new HttpParameter(str, String.valueOf(i)));
        }
    }

    private void appendParameter(String str, double d, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(d)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeoQuery geoQuery = (GeoQuery) obj;
        if (this.maxResults != geoQuery.maxResults) {
            return false;
        }
        if (this.accuracy == null ? geoQuery.accuracy != null : !this.accuracy.equals(geoQuery.accuracy)) {
            return false;
        }
        if (this.granularity == null ? geoQuery.granularity != null : !this.granularity.equals(geoQuery.granularity)) {
            return false;
        }
        if (this.f9917ip == null ? geoQuery.f9917ip == null : this.f9917ip.equals(geoQuery.f9917ip)) {
            return this.location == null ? geoQuery.location == null : this.location.equals(geoQuery.location);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((this.location != null ? this.location.hashCode() : 0) * 31) + (this.f9917ip != null ? this.f9917ip.hashCode() : 0)) * 31) + (this.accuracy != null ? this.accuracy.hashCode() : 0)) * 31;
        if (this.granularity != null) {
            i = this.granularity.hashCode();
        }
        return ((hashCode + i) * 31) + this.maxResults;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeoQuery{location=");
        sb.append(this.location);
        sb.append(", query='");
        sb.append(this.query);
        sb.append('\'');
        sb.append(", ip='");
        sb.append(this.f9917ip);
        sb.append('\'');
        sb.append(", accuracy='");
        sb.append(this.accuracy);
        sb.append('\'');
        sb.append(", granularity='");
        sb.append(this.granularity);
        sb.append('\'');
        sb.append(", maxResults=");
        sb.append(this.maxResults);
        sb.append('}');
        return sb.toString();
    }
}
