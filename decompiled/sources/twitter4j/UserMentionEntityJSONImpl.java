package twitter4j;

class UserMentionEntityJSONImpl extends EntityIndex implements UserMentionEntity {
    private static final long serialVersionUID = 6060510953676673013L;

    /* renamed from: id */
    private long f9930id;
    private String name;
    private String screenName;

    UserMentionEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    UserMentionEntityJSONImpl(int i, int i2, String str, String str2, long j) {
        setStart(i);
        setEnd(i2);
        this.name = str;
        this.screenName = str2;
        this.f9930id = j;
    }

    UserMentionEntityJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull("name")) {
                this.name = jSONObject.getString("name");
            }
            if (!jSONObject.isNull("screen_name")) {
                this.screenName = jSONObject.getString("screen_name");
            }
            this.f9930id = ParseUtil.getLong("id", jSONObject);
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public String getText() {
        return this.screenName;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public long getId() {
        return this.f9930id;
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserMentionEntityJSONImpl userMentionEntityJSONImpl = (UserMentionEntityJSONImpl) obj;
        if (this.f9930id != userMentionEntityJSONImpl.f9930id) {
            return false;
        }
        if (this.name == null ? userMentionEntityJSONImpl.name == null : this.name.equals(userMentionEntityJSONImpl.name)) {
            return this.screenName == null ? userMentionEntityJSONImpl.screenName == null : this.screenName.equals(userMentionEntityJSONImpl.screenName);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.name != null ? this.name.hashCode() : 0) * 31;
        if (this.screenName != null) {
            i = this.screenName.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (this.f9930id ^ (this.f9930id >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserMentionEntityJSONImpl{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", screenName='");
        sb.append(this.screenName);
        sb.append('\'');
        sb.append(", id=");
        sb.append(this.f9930id);
        sb.append('}');
        return sb.toString();
    }
}
