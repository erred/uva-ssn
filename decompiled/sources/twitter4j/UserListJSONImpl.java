package twitter4j;

import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import twitter4j.conf.Configuration;

class UserListJSONImpl extends TwitterResponseImpl implements Serializable, UserList {
    private static final long serialVersionUID = 449418980060197008L;
    private Date createdAt;
    private String description;
    private boolean following;
    private String fullName;

    /* renamed from: id */
    private long f9929id;
    private int memberCount;
    private boolean mode;
    private String name;
    private String slug;
    private int subscriberCount;
    private String uri;
    private User user;

    UserListJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
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

    UserListJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.f9929id = ParseUtil.getLong("id", jSONObject);
        this.name = ParseUtil.getRawString("name", jSONObject);
        this.fullName = ParseUtil.getRawString("full_name", jSONObject);
        this.slug = ParseUtil.getRawString("slug", jSONObject);
        this.description = ParseUtil.getRawString("description", jSONObject);
        this.subscriberCount = ParseUtil.getInt("subscriber_count", jSONObject);
        this.memberCount = ParseUtil.getInt("member_count", jSONObject);
        this.uri = ParseUtil.getRawString("uri", jSONObject);
        this.mode = "public".equals(ParseUtil.getRawString("mode", jSONObject));
        this.following = ParseUtil.getBoolean("following", jSONObject);
        this.createdAt = ParseUtil.getDate("created_at", jSONObject);
        try {
            if (!jSONObject.isNull("user")) {
                this.user = new UserJSONImpl(jSONObject.getJSONObject("user"));
            }
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(":");
            sb.append(jSONObject.toString());
            throw new TwitterException(sb.toString(), (Throwable) e);
        }
    }

    public int compareTo(UserList userList) {
        long id = this.f9929id - userList.getId();
        if (id < -2147483648L) {
            return C1024a.INVALID_ID;
        }
        return id > 2147483647L ? BaseClientBuilder.API_PRIORITY_OTHER : (int) id;
    }

    public long getId() {
        return this.f9929id;
    }

    public String getName() {
        return this.name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getDescription() {
        return this.description;
    }

    public int getSubscriberCount() {
        return this.subscriberCount;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public URI getURI() {
        try {
            return new URI(this.uri);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public boolean isPublic() {
        return this.mode;
    }

    public boolean isFollowing() {
        return this.following;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public User getUser() {
        return this.user;
    }

    static PagableResponseList<UserList> createPagableUserListList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONObject asJSONObject = httpResponse.asJSONObject();
            JSONArray jSONArray = asJSONObject.getJSONArray("lists");
            int length = jSONArray.length();
            PagableResponseListImpl pagableResponseListImpl = new PagableResponseListImpl(length, asJSONObject, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserListJSONImpl userListJSONImpl = new UserListJSONImpl(jSONObject);
                pagableResponseListImpl.add(userListJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userListJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(pagableResponseListImpl, asJSONObject);
            }
            return pagableResponseListImpl;
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    static ResponseList<UserList> createUserListList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                UserListJSONImpl userListJSONImpl = new UserListJSONImpl(jSONObject);
                responseListImpl.add(userListJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userListJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public int hashCode() {
        return (int) this.f9929id;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UserList) && ((UserList) obj).getId() == this.f9929id) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserListJSONImpl{id=");
        sb.append(this.f9929id);
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", fullName='");
        sb.append(this.fullName);
        sb.append('\'');
        sb.append(", slug='");
        sb.append(this.slug);
        sb.append('\'');
        sb.append(", description='");
        sb.append(this.description);
        sb.append('\'');
        sb.append(", subscriberCount=");
        sb.append(this.subscriberCount);
        sb.append(", memberCount=");
        sb.append(this.memberCount);
        sb.append(", uri='");
        sb.append(this.uri);
        sb.append('\'');
        sb.append(", mode=");
        sb.append(this.mode);
        sb.append(", user=");
        sb.append(this.user);
        sb.append(", following=");
        sb.append(this.following);
        sb.append('}');
        return sb.toString();
    }
}
