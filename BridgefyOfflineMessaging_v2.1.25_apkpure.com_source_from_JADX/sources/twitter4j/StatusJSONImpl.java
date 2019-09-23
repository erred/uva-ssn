package twitter4j;

import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.conf.Configuration;

final class StatusJSONImpl extends TwitterResponseImpl implements Serializable, Status {
    private static final Logger logger = Logger.getLogger(StatusJSONImpl.class);
    private static final long serialVersionUID = -6461195536943679985L;
    private long[] contributorsIDs;
    private Date createdAt;
    private long currentUserRetweetId = -1;
    private MediaEntity[] extendedMediaEntities;
    private int favoriteCount;
    private GeoLocation geoLocation = null;
    private HashtagEntity[] hashtagEntities;

    /* renamed from: id */
    private long f9926id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isPossiblySensitive;
    private boolean isRetweeted;
    private boolean isTruncated;
    private String lang;
    private MediaEntity[] mediaEntities;
    private Place place = null;
    private long retweetCount;
    private Status retweetedStatus;
    private Scopes scopes;
    private String source;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private User user = null;
    private UserMentionEntity[] userMentionEntities;

    StatusJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject asJSONObject = httpResponse.asJSONObject();
        init(asJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asJSONObject);
        }
    }

    StatusJSONImpl(JSONObject jSONObject, Configuration configuration) throws TwitterException {
        init(jSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, jSONObject);
        }
    }

    StatusJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    StatusJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.f9926id = ParseUtil.getLong("id", jSONObject);
        this.source = ParseUtil.getUnescapedString(Param.SOURCE, jSONObject);
        this.createdAt = ParseUtil.getDate("created_at", jSONObject);
        this.isTruncated = ParseUtil.getBoolean("truncated", jSONObject);
        this.inReplyToStatusId = ParseUtil.getLong("in_reply_to_status_id", jSONObject);
        this.inReplyToUserId = ParseUtil.getLong("in_reply_to_user_id", jSONObject);
        this.isFavorited = ParseUtil.getBoolean("favorited", jSONObject);
        this.isRetweeted = ParseUtil.getBoolean("retweeted", jSONObject);
        this.inReplyToScreenName = ParseUtil.getUnescapedString("in_reply_to_screen_name", jSONObject);
        this.retweetCount = ParseUtil.getLong("retweet_count", jSONObject);
        this.favoriteCount = ParseUtil.getInt("favorite_count", jSONObject);
        this.isPossiblySensitive = ParseUtil.getBoolean("possibly_sensitive", jSONObject);
        try {
            if (!jSONObject.isNull("user")) {
                this.user = new UserJSONImpl(jSONObject.getJSONObject("user"));
            }
            this.geoLocation = JSONImplFactory.createGeoLocation(jSONObject);
            if (!jSONObject.isNull("place")) {
                this.place = new PlaceJSONImpl(jSONObject.getJSONObject("place"));
            }
            if (!jSONObject.isNull("retweeted_status")) {
                this.retweetedStatus = new StatusJSONImpl(jSONObject.getJSONObject("retweeted_status"));
            }
            if (!jSONObject.isNull("contributors")) {
                JSONArray jSONArray = jSONObject.getJSONArray("contributors");
                this.contributorsIDs = new long[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.contributorsIDs[i] = Long.parseLong(jSONArray.getString(i));
                }
            } else {
                this.contributorsIDs = new long[0];
            }
            if (!jSONObject.isNull("entities")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("entities");
                if (!jSONObject2.isNull("user_mentions")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("user_mentions");
                    int length = jSONArray2.length();
                    this.userMentionEntities = new UserMentionEntity[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        this.userMentionEntities[i2] = new UserMentionEntityJSONImpl(jSONArray2.getJSONObject(i2));
                    }
                }
                if (!jSONObject2.isNull("urls")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("urls");
                    int length2 = jSONArray3.length();
                    this.urlEntities = new URLEntity[length2];
                    for (int i3 = 0; i3 < length2; i3++) {
                        this.urlEntities[i3] = new URLEntityJSONImpl(jSONArray3.getJSONObject(i3));
                    }
                }
                if (!jSONObject2.isNull("hashtags")) {
                    JSONArray jSONArray4 = jSONObject2.getJSONArray("hashtags");
                    int length3 = jSONArray4.length();
                    this.hashtagEntities = new HashtagEntity[length3];
                    for (int i4 = 0; i4 < length3; i4++) {
                        this.hashtagEntities[i4] = new HashtagEntityJSONImpl(jSONArray4.getJSONObject(i4));
                    }
                }
                if (!jSONObject2.isNull("symbols")) {
                    JSONArray jSONArray5 = jSONObject2.getJSONArray("symbols");
                    int length4 = jSONArray5.length();
                    this.symbolEntities = new SymbolEntity[length4];
                    for (int i5 = 0; i5 < length4; i5++) {
                        this.symbolEntities[i5] = new HashtagEntityJSONImpl(jSONArray5.getJSONObject(i5));
                    }
                }
                if (!jSONObject2.isNull("media")) {
                    JSONArray jSONArray6 = jSONObject2.getJSONArray("media");
                    int length5 = jSONArray6.length();
                    this.mediaEntities = new MediaEntity[length5];
                    for (int i6 = 0; i6 < length5; i6++) {
                        this.mediaEntities[i6] = new MediaEntityJSONImpl(jSONArray6.getJSONObject(i6));
                    }
                }
            }
            if (!jSONObject.isNull("extended_entities")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("extended_entities");
                if (!jSONObject3.isNull("media")) {
                    JSONArray jSONArray7 = jSONObject3.getJSONArray("media");
                    int length6 = jSONArray7.length();
                    this.extendedMediaEntities = new MediaEntity[length6];
                    for (int i7 = 0; i7 < length6; i7++) {
                        this.extendedMediaEntities[i7] = new MediaEntityJSONImpl(jSONArray7.getJSONObject(i7));
                    }
                }
            }
            this.userMentionEntities = this.userMentionEntities == null ? new UserMentionEntity[0] : this.userMentionEntities;
            this.urlEntities = this.urlEntities == null ? new URLEntity[0] : this.urlEntities;
            this.hashtagEntities = this.hashtagEntities == null ? new HashtagEntity[0] : this.hashtagEntities;
            this.symbolEntities = this.symbolEntities == null ? new SymbolEntity[0] : this.symbolEntities;
            this.mediaEntities = this.mediaEntities == null ? new MediaEntity[0] : this.mediaEntities;
            this.extendedMediaEntities = this.extendedMediaEntities == null ? new MediaEntity[0] : this.extendedMediaEntities;
            this.text = HTMLEntity.unescapeAndSlideEntityIncdices(jSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
            if (!jSONObject.isNull("current_user_retweet")) {
                this.currentUserRetweetId = jSONObject.getJSONObject("current_user_retweet").getLong("id");
            }
            if (!jSONObject.isNull("lang")) {
                this.lang = ParseUtil.getUnescapedString("lang", jSONObject);
            }
            if (!jSONObject.isNull("scopes")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("scopes");
                if (!jSONObject4.isNull("place_ids")) {
                    JSONArray jSONArray8 = jSONObject4.getJSONArray("place_ids");
                    int length7 = jSONArray8.length();
                    String[] strArr = new String[length7];
                    for (int i8 = 0; i8 < length7; i8++) {
                        strArr[i8] = jSONArray8.getString(i8);
                    }
                    this.scopes = new ScopesImpl(strArr);
                }
            }
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public int compareTo(Status status) {
        long id = this.f9926id - status.getId();
        if (id < -2147483648L) {
            return C1024a.INVALID_ID;
        }
        return id > 2147483647L ? BaseClientBuilder.API_PRIORITY_OTHER : (int) id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public long getId() {
        return this.f9926id;
    }

    public String getText() {
        return this.text;
    }

    public String getSource() {
        return this.source;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    public long getInReplyToUserId() {
        return this.inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return this.inReplyToScreenName;
    }

    public GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    public Place getPlace() {
        return this.place;
    }

    public long[] getContributors() {
        return this.contributorsIDs;
    }

    public boolean isFavorited() {
        return this.isFavorited;
    }

    public boolean isRetweeted() {
        return this.isRetweeted;
    }

    public int getFavoriteCount() {
        return this.favoriteCount;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isRetweet() {
        return this.retweetedStatus != null;
    }

    public Status getRetweetedStatus() {
        return this.retweetedStatus;
    }

    public int getRetweetCount() {
        return (int) this.retweetCount;
    }

    public boolean isRetweetedByMe() {
        return this.currentUserRetweetId != -1;
    }

    public long getCurrentUserRetweetId() {
        return this.currentUserRetweetId;
    }

    public boolean isPossiblySensitive() {
        return this.isPossiblySensitive;
    }

    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }

    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }

    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }

    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }

    public MediaEntity[] getExtendedMediaEntities() {
        return this.extendedMediaEntities;
    }

    public SymbolEntity[] getSymbolEntities() {
        return this.symbolEntities;
    }

    public Scopes getScopes() {
        return this.scopes;
    }

    public String getLang() {
        return this.lang;
    }

    static ResponseList<Status> createStatusList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray asJSONArray = httpResponse.asJSONArray();
            int length = asJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = asJSONArray.getJSONObject(i);
                StatusJSONImpl statusJSONImpl = new StatusJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(statusJSONImpl, jSONObject);
                }
                responseListImpl.add(statusJSONImpl);
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
        return (int) this.f9926id;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Status) && ((Status) obj).getId() == this.f9926id) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatusJSONImpl{createdAt=");
        sb.append(this.createdAt);
        sb.append(", id=");
        sb.append(this.f9926id);
        sb.append(", text='");
        sb.append(this.text);
        sb.append('\'');
        sb.append(", source='");
        sb.append(this.source);
        sb.append('\'');
        sb.append(", isTruncated=");
        sb.append(this.isTruncated);
        sb.append(", inReplyToStatusId=");
        sb.append(this.inReplyToStatusId);
        sb.append(", inReplyToUserId=");
        sb.append(this.inReplyToUserId);
        sb.append(", isFavorited=");
        sb.append(this.isFavorited);
        sb.append(", isRetweeted=");
        sb.append(this.isRetweeted);
        sb.append(", favoriteCount=");
        sb.append(this.favoriteCount);
        sb.append(", inReplyToScreenName='");
        sb.append(this.inReplyToScreenName);
        sb.append('\'');
        sb.append(", geoLocation=");
        sb.append(this.geoLocation);
        sb.append(", place=");
        sb.append(this.place);
        sb.append(", retweetCount=");
        sb.append(this.retweetCount);
        sb.append(", isPossiblySensitive=");
        sb.append(this.isPossiblySensitive);
        sb.append(", lang='");
        sb.append(this.lang);
        sb.append('\'');
        sb.append(", contributorsIDs=");
        sb.append(Arrays.toString(this.contributorsIDs));
        sb.append(", retweetedStatus=");
        sb.append(this.retweetedStatus);
        sb.append(", userMentionEntities=");
        sb.append(Arrays.toString(this.userMentionEntities));
        sb.append(", urlEntities=");
        sb.append(Arrays.toString(this.urlEntities));
        sb.append(", hashtagEntities=");
        sb.append(Arrays.toString(this.hashtagEntities));
        sb.append(", mediaEntities=");
        sb.append(Arrays.toString(this.mediaEntities));
        sb.append(", symbolEntities=");
        sb.append(Arrays.toString(this.symbolEntities));
        sb.append(", currentUserRetweetId=");
        sb.append(this.currentUserRetweetId);
        sb.append(", user=");
        sb.append(this.user);
        sb.append('}');
        return sb.toString();
    }
}
