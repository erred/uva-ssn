package twitter4j;

import com.google.android.gms.actions.SearchIntents;
import java.util.Date;
import twitter4j.conf.Configuration;

final class SavedSearchJSONImpl extends TwitterResponseImpl implements SavedSearch {
    private static final long serialVersionUID = 846086437256360810L;
    private Date createdAt;

    /* renamed from: id */
    private int f9925id;
    private String name;
    private int position;
    private String query;

    SavedSearchJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    SavedSearchJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    static ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONArray asJSONArray = httpResponse.asJSONArray();
        try {
            ResponseListImpl responseListImpl = new ResponseListImpl(asJSONArray.length(), httpResponse);
            for (int i = 0; i < asJSONArray.length(); i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                SavedSearchJSONImpl savedSearchJSONImpl = new SavedSearchJSONImpl(jSONObject);
                responseListImpl.add(savedSearchJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(savedSearchJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(":");
            sb.append(httpResponse.asString());
            throw new TwitterException(sb.toString(), (Throwable) e);
        }
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.createdAt = ParseUtil.getDate("created_at", jSONObject, "EEE MMM dd HH:mm:ss z yyyy");
        this.query = ParseUtil.getUnescapedString(SearchIntents.EXTRA_QUERY, jSONObject);
        this.position = ParseUtil.getInt("position", jSONObject);
        this.name = ParseUtil.getUnescapedString("name", jSONObject);
        this.f9925id = ParseUtil.getInt("id", jSONObject);
    }

    public int compareTo(SavedSearch savedSearch) {
        return this.f9925id - savedSearch.getId();
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getQuery() {
        return this.query;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.f9925id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedSearch)) {
            return false;
        }
        return this.f9925id == ((SavedSearch) obj).getId();
    }

    public int hashCode() {
        return (((((((this.createdAt.hashCode() * 31) + this.query.hashCode()) * 31) + this.position) * 31) + this.name.hashCode()) * 31) + this.f9925id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavedSearchJSONImpl{createdAt=");
        sb.append(this.createdAt);
        sb.append(", query='");
        sb.append(this.query);
        sb.append('\'');
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", id=");
        sb.append(this.f9925id);
        sb.append('}');
        return sb.toString();
    }
}
