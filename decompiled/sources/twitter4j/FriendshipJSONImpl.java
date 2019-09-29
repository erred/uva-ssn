package twitter4j;

import twitter4j.conf.Configuration;

class FriendshipJSONImpl implements Friendship {
    private static final long serialVersionUID = 6847273186993125826L;
    private boolean followedBy = false;
    private boolean following = false;

    /* renamed from: id */
    private final long f9916id;
    private final String name;
    private final String screenName;

    FriendshipJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            this.f9916id = ParseUtil.getLong("id", jSONObject);
            this.name = jSONObject.getString("name");
            this.screenName = jSONObject.getString("screen_name");
            JSONArray jSONArray = jSONObject.getJSONArray("connections");
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if ("following".equals(string)) {
                    this.following = true;
                } else if ("followed_by".equals(string)) {
                    this.followedBy = true;
                }
            }
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(":");
            sb.append(jSONObject.toString());
            throw new TwitterException(sb.toString(), (Throwable) e);
        }
    }

    static ResponseList<Friendship> createFriendshipList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                FriendshipJSONImpl friendshipJSONImpl = new FriendshipJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(friendshipJSONImpl, jSONObject);
                }
                responseListImpl.add(friendshipJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public long getId() {
        return this.f9916id;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public boolean isFollowing() {
        return this.following;
    }

    public boolean isFollowedBy() {
        return this.followedBy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FriendshipJSONImpl friendshipJSONImpl = (FriendshipJSONImpl) obj;
        return this.followedBy == friendshipJSONImpl.followedBy && this.following == friendshipJSONImpl.following && this.f9916id == friendshipJSONImpl.f9916id && this.name.equals(friendshipJSONImpl.name) && this.screenName.equals(friendshipJSONImpl.screenName);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((int) (this.f9916id ^ (this.f9916id >>> 32))) * 31) + (this.name != null ? this.name.hashCode() : 0)) * 31;
        if (this.screenName != null) {
            i = this.screenName.hashCode();
        }
        return ((((hashCode + i) * 31) + (this.following ? 1 : 0)) * 31) + (this.followedBy ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FriendshipJSONImpl{id=");
        sb.append(this.f9916id);
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", screenName='");
        sb.append(this.screenName);
        sb.append('\'');
        sb.append(", following=");
        sb.append(this.following);
        sb.append(", followedBy=");
        sb.append(this.followedBy);
        sb.append('}');
        return sb.toString();
    }
}
