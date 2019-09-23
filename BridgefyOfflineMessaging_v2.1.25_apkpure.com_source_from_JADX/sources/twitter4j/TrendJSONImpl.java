package twitter4j;

import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.Serializable;

final class TrendJSONImpl implements Serializable, Trend {
    private static final long serialVersionUID = -4353426776065521132L;
    private final String name;
    private String query;
    private String url;

    TrendJSONImpl(JSONObject jSONObject, boolean z) {
        this.url = null;
        this.query = null;
        this.name = ParseUtil.getRawString("name", jSONObject);
        this.url = ParseUtil.getRawString(ImagesContract.URL, jSONObject);
        this.query = ParseUtil.getRawString(SearchIntents.EXTRA_QUERY, jSONObject);
        if (z) {
            TwitterObjectFactory.registerJSONObject(this, jSONObject);
        }
    }

    TrendJSONImpl(JSONObject jSONObject) {
        this(jSONObject, false);
    }

    public String getName() {
        return this.name;
    }

    public String getURL() {
        return this.url;
    }

    public String getQuery() {
        return this.query;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trend)) {
            return false;
        }
        Trend trend = (Trend) obj;
        if (!this.name.equals(trend.getName())) {
            return false;
        }
        if (this.query == null ? trend.getQuery() == null : this.query.equals(trend.getQuery())) {
            return this.url == null ? trend.getURL() == null : this.url.equals(trend.getURL());
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.name.hashCode() * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31;
        if (this.query != null) {
            i = this.query.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrendJSONImpl{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", query='");
        sb.append(this.query);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
