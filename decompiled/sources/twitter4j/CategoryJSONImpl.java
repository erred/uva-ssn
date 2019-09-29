package twitter4j;

import java.io.Serializable;
import twitter4j.conf.Configuration;

final class CategoryJSONImpl implements Serializable, Category {
    private static final long serialVersionUID = 3811335888122469876L;
    private String name;
    private int size;
    private String slug;

    CategoryJSONImpl(JSONObject jSONObject) throws JSONException {
        init(jSONObject);
    }

    /* access modifiers changed from: 0000 */
    public void init(JSONObject jSONObject) throws JSONException {
        this.name = jSONObject.getString("name");
        this.slug = jSONObject.getString("slug");
        this.size = ParseUtil.getInt("size", jSONObject);
    }

    static ResponseList<Category> createCategoriesList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        return createCategoriesList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    static ResponseList<Category> createCategoriesList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONArray.length(), httpResponse);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CategoryJSONImpl categoryJSONImpl = new CategoryJSONImpl(jSONObject);
                responseListImpl.add(categoryJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(categoryJSONImpl, jSONObject);
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

    public String getSlug() {
        return this.slug;
    }

    public int getSize() {
        return this.size;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CategoryJSONImpl categoryJSONImpl = (CategoryJSONImpl) obj;
        if (this.size != categoryJSONImpl.size) {
            return false;
        }
        if (this.name == null ? categoryJSONImpl.name == null : this.name.equals(categoryJSONImpl.name)) {
            return this.slug == null ? categoryJSONImpl.slug == null : this.slug.equals(categoryJSONImpl.slug);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.name != null ? this.name.hashCode() : 0) * 31;
        if (this.slug != null) {
            i = this.slug.hashCode();
        }
        return ((hashCode + i) * 31) + this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryJSONImpl{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", slug='");
        sb.append(this.slug);
        sb.append('\'');
        sb.append(", size=");
        sb.append(this.size);
        sb.append('}');
        return sb.toString();
    }
}
