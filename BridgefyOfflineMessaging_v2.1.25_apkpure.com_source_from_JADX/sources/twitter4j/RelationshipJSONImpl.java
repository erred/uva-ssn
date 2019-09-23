package twitter4j;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.Serializable;
import twitter4j.conf.Configuration;

class RelationshipJSONImpl extends TwitterResponseImpl implements Serializable, Relationship {
    private static final long serialVersionUID = -2001484553401916448L;
    private final boolean sourceBlockingTarget;
    private final boolean sourceCanDm;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceFollowingTarget;
    private final boolean sourceMutingTarget;
    private final boolean sourceNotificationsEnabled;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private final long targetUserId;
    private final String targetUserScreenName;
    private boolean wantRetweets;

    RelationshipJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    RelationshipJSONImpl(JSONObject jSONObject) throws TwitterException {
        this((HttpResponse) null, jSONObject);
    }

    RelationshipJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("relationship");
            JSONObject jSONObject3 = jSONObject2.getJSONObject(Param.SOURCE);
            JSONObject jSONObject4 = jSONObject2.getJSONObject("target");
            this.sourceUserId = ParseUtil.getLong("id", jSONObject3);
            this.targetUserId = ParseUtil.getLong("id", jSONObject4);
            this.sourceUserScreenName = ParseUtil.getUnescapedString("screen_name", jSONObject3);
            this.targetUserScreenName = ParseUtil.getUnescapedString("screen_name", jSONObject4);
            this.sourceBlockingTarget = ParseUtil.getBoolean("blocking", jSONObject3);
            this.sourceFollowingTarget = ParseUtil.getBoolean("following", jSONObject3);
            this.sourceFollowedByTarget = ParseUtil.getBoolean("followed_by", jSONObject3);
            this.sourceCanDm = ParseUtil.getBoolean("can_dm", jSONObject3);
            this.sourceMutingTarget = ParseUtil.getBoolean("muting", jSONObject3);
            this.sourceNotificationsEnabled = ParseUtil.getBoolean("notifications_enabled", jSONObject3);
            this.wantRetweets = ParseUtil.getBoolean("want_retweets", jSONObject3);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(":");
            sb.append(jSONObject.toString());
            throw new TwitterException(sb.toString(), (Throwable) e);
        }
    }

    static ResponseList<Relationship> createRelationshipList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                RelationshipJSONImpl relationshipJSONImpl = new RelationshipJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(relationshipJSONImpl, jSONObject);
                }
                responseListImpl.add(relationshipJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, asJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public long getSourceUserId() {
        return this.sourceUserId;
    }

    public long getTargetUserId() {
        return this.targetUserId;
    }

    public boolean isSourceBlockingTarget() {
        return this.sourceBlockingTarget;
    }

    public String getSourceUserScreenName() {
        return this.sourceUserScreenName;
    }

    public String getTargetUserScreenName() {
        return this.targetUserScreenName;
    }

    public boolean isSourceFollowingTarget() {
        return this.sourceFollowingTarget;
    }

    public boolean isTargetFollowingSource() {
        return this.sourceFollowedByTarget;
    }

    public boolean isSourceFollowedByTarget() {
        return this.sourceFollowedByTarget;
    }

    public boolean isTargetFollowedBySource() {
        return this.sourceFollowingTarget;
    }

    public boolean canSourceDm() {
        return this.sourceCanDm;
    }

    public boolean isSourceMutingTarget() {
        return this.sourceMutingTarget;
    }

    public boolean isSourceNotificationsEnabled() {
        return this.sourceNotificationsEnabled;
    }

    public boolean isSourceWantRetweets() {
        return this.wantRetweets;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RelationshipJSONImpl relationshipJSONImpl = (RelationshipJSONImpl) obj;
        if (this.sourceBlockingTarget != relationshipJSONImpl.sourceBlockingTarget || this.sourceCanDm != relationshipJSONImpl.sourceCanDm || this.sourceFollowedByTarget != relationshipJSONImpl.sourceFollowedByTarget || this.sourceFollowingTarget != relationshipJSONImpl.sourceFollowingTarget || this.sourceMutingTarget != relationshipJSONImpl.sourceMutingTarget || this.sourceNotificationsEnabled != relationshipJSONImpl.sourceNotificationsEnabled || this.sourceUserId != relationshipJSONImpl.sourceUserId || this.targetUserId != relationshipJSONImpl.targetUserId || this.wantRetweets != relationshipJSONImpl.wantRetweets) {
            return false;
        }
        if (this.sourceUserScreenName == null ? relationshipJSONImpl.sourceUserScreenName == null : this.sourceUserScreenName.equals(relationshipJSONImpl.sourceUserScreenName)) {
            return this.targetUserScreenName == null ? relationshipJSONImpl.targetUserScreenName == null : this.targetUserScreenName.equals(relationshipJSONImpl.targetUserScreenName);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((((int) (this.targetUserId ^ (this.targetUserId >>> 32))) * 31) + (this.targetUserScreenName != null ? this.targetUserScreenName.hashCode() : 0)) * 31) + (this.sourceBlockingTarget ? 1 : 0)) * 31) + (this.sourceNotificationsEnabled ? 1 : 0)) * 31) + (this.sourceFollowingTarget ? 1 : 0)) * 31) + (this.sourceFollowedByTarget ? 1 : 0)) * 31) + (this.sourceCanDm ? 1 : 0)) * 31) + (this.sourceMutingTarget ? 1 : 0)) * 31) + ((int) ((this.sourceUserId >>> 32) ^ this.sourceUserId))) * 31;
        if (this.sourceUserScreenName != null) {
            i = this.sourceUserScreenName.hashCode();
        }
        return ((hashCode + i) * 31) + (this.wantRetweets ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RelationshipJSONImpl{targetUserId=");
        sb.append(this.targetUserId);
        sb.append(", targetUserScreenName='");
        sb.append(this.targetUserScreenName);
        sb.append('\'');
        sb.append(", sourceBlockingTarget=");
        sb.append(this.sourceBlockingTarget);
        sb.append(", sourceNotificationsEnabled=");
        sb.append(this.sourceNotificationsEnabled);
        sb.append(", sourceFollowingTarget=");
        sb.append(this.sourceFollowingTarget);
        sb.append(", sourceFollowedByTarget=");
        sb.append(this.sourceFollowedByTarget);
        sb.append(", sourceCanDm=");
        sb.append(this.sourceCanDm);
        sb.append(", sourceMutingTarget=");
        sb.append(this.sourceMutingTarget);
        sb.append(", sourceUserId=");
        sb.append(this.sourceUserId);
        sb.append(", sourceUserScreenName='");
        sb.append(this.sourceUserScreenName);
        sb.append('\'');
        sb.append(", wantRetweets=");
        sb.append(this.wantRetweets);
        sb.append('}');
        return sb.toString();
    }
}
