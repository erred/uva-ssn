package twitter4j;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.Serializable;
import java.util.Date;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import twitter4j.conf.Configuration;

final class UserJSONImpl extends TwitterResponseImpl implements Serializable, User {
    private static final long serialVersionUID = -5448266606847617015L;
    private Date createdAt;
    private String description;
    private URLEntity[] descriptionURLEntities;
    private int favouritesCount;
    private int followersCount;
    private int friendsCount;

    /* renamed from: id */
    private long f9928id;
    private boolean isContributorsEnabled;
    private boolean isDefaultProfile;
    private boolean isDefaultProfileImage;
    private boolean isFollowRequestSent;
    private boolean isGeoEnabled;
    private boolean isProtected;
    private boolean isVerified;
    private String lang;
    private int listedCount;
    private String location;
    private String name;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private boolean profileBackgroundTiled;
    private String profileBannerImageUrl;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private boolean profileUseBackgroundImage;
    private String screenName;
    private boolean showAllInlineMedia;
    private Status status;
    private int statusesCount;
    private String timeZone;
    private boolean translator;
    private String url;
    private URLEntity urlEntity;
    private int utcOffset;

    UserJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
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

    UserJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    UserJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.f9928id = ParseUtil.getLong("id", jSONObject);
            this.name = ParseUtil.getRawString("name", jSONObject);
            this.screenName = ParseUtil.getRawString("screen_name", jSONObject);
            this.location = ParseUtil.getRawString(Param.LOCATION, jSONObject);
            this.descriptionURLEntities = getURLEntitiesFromJSON(jSONObject, "description");
            this.descriptionURLEntities = this.descriptionURLEntities == null ? new URLEntity[0] : this.descriptionURLEntities;
            URLEntity[] uRLEntitiesFromJSON = getURLEntitiesFromJSON(jSONObject, ImagesContract.URL);
            if (uRLEntitiesFromJSON != null && uRLEntitiesFromJSON.length > 0) {
                this.urlEntity = uRLEntitiesFromJSON[0];
            }
            this.description = ParseUtil.getRawString("description", jSONObject);
            if (this.description != null) {
                this.description = HTMLEntity.unescapeAndSlideEntityIncdices(this.description, null, this.descriptionURLEntities, null, null);
            }
            this.isContributorsEnabled = ParseUtil.getBoolean("contributors_enabled", jSONObject);
            this.profileImageUrl = ParseUtil.getRawString("profile_image_url", jSONObject);
            this.profileImageUrlHttps = ParseUtil.getRawString("profile_image_url_https", jSONObject);
            this.isDefaultProfileImage = ParseUtil.getBoolean("default_profile_image", jSONObject);
            this.url = ParseUtil.getRawString(ImagesContract.URL, jSONObject);
            this.isProtected = ParseUtil.getBoolean("protected", jSONObject);
            this.isGeoEnabled = ParseUtil.getBoolean("geo_enabled", jSONObject);
            this.isVerified = ParseUtil.getBoolean("verified", jSONObject);
            this.translator = ParseUtil.getBoolean("is_translator", jSONObject);
            this.followersCount = ParseUtil.getInt("followers_count", jSONObject);
            this.profileBackgroundColor = ParseUtil.getRawString("profile_background_color", jSONObject);
            this.profileTextColor = ParseUtil.getRawString("profile_text_color", jSONObject);
            this.profileLinkColor = ParseUtil.getRawString("profile_link_color", jSONObject);
            this.profileSidebarFillColor = ParseUtil.getRawString("profile_sidebar_fill_color", jSONObject);
            this.profileSidebarBorderColor = ParseUtil.getRawString("profile_sidebar_border_color", jSONObject);
            this.profileUseBackgroundImage = ParseUtil.getBoolean("profile_use_background_image", jSONObject);
            this.isDefaultProfile = ParseUtil.getBoolean("default_profile", jSONObject);
            this.showAllInlineMedia = ParseUtil.getBoolean("show_all_inline_media", jSONObject);
            this.friendsCount = ParseUtil.getInt("friends_count", jSONObject);
            this.createdAt = ParseUtil.getDate("created_at", jSONObject, "EEE MMM dd HH:mm:ss z yyyy");
            this.favouritesCount = ParseUtil.getInt("favourites_count", jSONObject);
            this.utcOffset = ParseUtil.getInt("utc_offset", jSONObject);
            this.timeZone = ParseUtil.getRawString("time_zone", jSONObject);
            this.profileBackgroundImageUrl = ParseUtil.getRawString("profile_background_image_url", jSONObject);
            this.profileBackgroundImageUrlHttps = ParseUtil.getRawString("profile_background_image_url_https", jSONObject);
            this.profileBannerImageUrl = ParseUtil.getRawString("profile_banner_url", jSONObject);
            this.profileBackgroundTiled = ParseUtil.getBoolean("profile_background_tile", jSONObject);
            this.lang = ParseUtil.getRawString("lang", jSONObject);
            this.statusesCount = ParseUtil.getInt("statuses_count", jSONObject);
            this.listedCount = ParseUtil.getInt("listed_count", jSONObject);
            this.isFollowRequestSent = ParseUtil.getBoolean("follow_request_sent", jSONObject);
            if (!jSONObject.isNull(MessageDTO.STATUS)) {
                this.status = new StatusJSONImpl(jSONObject.getJSONObject(MessageDTO.STATUS));
            }
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(":");
            sb.append(jSONObject.toString());
            throw new TwitterException(sb.toString(), (Throwable) e);
        }
    }

    private static URLEntity[] getURLEntitiesFromJSON(JSONObject jSONObject, String str) throws JSONException, TwitterException {
        if (!jSONObject.isNull("entities")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("entities");
            if (!jSONObject2.isNull(str)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
                if (!jSONObject3.isNull("urls")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("urls");
                    int length = jSONArray.length();
                    URLEntity[] uRLEntityArr = new URLEntity[length];
                    for (int i = 0; i < length; i++) {
                        uRLEntityArr[i] = new URLEntityJSONImpl(jSONArray.getJSONObject(i));
                    }
                    return uRLEntityArr;
                }
            }
        }
        return null;
    }

    public int compareTo(User user) {
        return (int) (this.f9928id - user.getId());
    }

    public long getId() {
        return this.f9928id;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isContributorsEnabled() {
        return this.isContributorsEnabled;
    }

    public String getProfileImageURL() {
        return this.profileImageUrl;
    }

    public String getBiggerProfileImageURL() {
        return toResizedURL(this.profileImageUrl, "_bigger");
    }

    public String getMiniProfileImageURL() {
        return toResizedURL(this.profileImageUrl, "_mini");
    }

    public String getOriginalProfileImageURL() {
        return toResizedURL(this.profileImageUrl, "");
    }

    private String toResizedURL(String str, String str2) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("_");
        int lastIndexOf2 = str.lastIndexOf(".");
        int lastIndexOf3 = str.lastIndexOf("/");
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, lastIndexOf));
        sb.append(str2);
        String sb2 = sb.toString();
        if (lastIndexOf2 > lastIndexOf3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(str.substring(lastIndexOf2));
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public String getProfileImageURLHttps() {
        return this.profileImageUrlHttps;
    }

    public String getBiggerProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, "_bigger");
    }

    public String getMiniProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, "_mini");
    }

    public String getOriginalProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, "");
    }

    public boolean isDefaultProfileImage() {
        return this.isDefaultProfileImage;
    }

    public String getURL() {
        return this.url;
    }

    public boolean isProtected() {
        return this.isProtected;
    }

    public int getFollowersCount() {
        return this.followersCount;
    }

    public String getProfileBackgroundColor() {
        return this.profileBackgroundColor;
    }

    public String getProfileTextColor() {
        return this.profileTextColor;
    }

    public String getProfileLinkColor() {
        return this.profileLinkColor;
    }

    public String getProfileSidebarFillColor() {
        return this.profileSidebarFillColor;
    }

    public String getProfileSidebarBorderColor() {
        return this.profileSidebarBorderColor;
    }

    public boolean isProfileUseBackgroundImage() {
        return this.profileUseBackgroundImage;
    }

    public boolean isDefaultProfile() {
        return this.isDefaultProfile;
    }

    public boolean isShowAllInlineMedia() {
        return this.showAllInlineMedia;
    }

    public int getFriendsCount() {
        return this.friendsCount;
    }

    public Status getStatus() {
        return this.status;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public int getFavouritesCount() {
        return this.favouritesCount;
    }

    public int getUtcOffset() {
        return this.utcOffset;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getProfileBackgroundImageURL() {
        return this.profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return this.profileBackgroundImageUrlHttps;
    }

    public String getProfileBannerURL() {
        if (this.profileBannerImageUrl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.profileBannerImageUrl);
        sb.append("/web");
        return sb.toString();
    }

    public String getProfileBannerRetinaURL() {
        if (this.profileBannerImageUrl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.profileBannerImageUrl);
        sb.append("/web_retina");
        return sb.toString();
    }

    public String getProfileBannerIPadURL() {
        if (this.profileBannerImageUrl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.profileBannerImageUrl);
        sb.append("/ipad");
        return sb.toString();
    }

    public String getProfileBannerIPadRetinaURL() {
        if (this.profileBannerImageUrl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.profileBannerImageUrl);
        sb.append("/ipad_retina");
        return sb.toString();
    }

    public String getProfileBannerMobileURL() {
        if (this.profileBannerImageUrl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.profileBannerImageUrl);
        sb.append("/mobile");
        return sb.toString();
    }

    public String getProfileBannerMobileRetinaURL() {
        if (this.profileBannerImageUrl == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.profileBannerImageUrl);
        sb.append("/mobile_retina");
        return sb.toString();
    }

    public boolean isProfileBackgroundTiled() {
        return this.profileBackgroundTiled;
    }

    public String getLang() {
        return this.lang;
    }

    public int getStatusesCount() {
        return this.statusesCount;
    }

    public boolean isGeoEnabled() {
        return this.isGeoEnabled;
    }

    public boolean isVerified() {
        return this.isVerified;
    }

    public boolean isTranslator() {
        return this.translator;
    }

    public int getListedCount() {
        return this.listedCount;
    }

    public boolean isFollowRequestSent() {
        return this.isFollowRequestSent;
    }

    public URLEntity[] getDescriptionURLEntities() {
        return this.descriptionURLEntities;
    }

    public URLEntity getURLEntity() {
        if (this.urlEntity == null) {
            String str = this.url == null ? "" : this.url;
            URLEntityJSONImpl uRLEntityJSONImpl = new URLEntityJSONImpl(0, str.length(), str, str, str);
            this.urlEntity = uRLEntityJSONImpl;
        }
        return this.urlEntity;
    }

    static PagableResponseList<User> createPagableUserList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONObject asJSONObject = httpResponse.asJSONObject();
            JSONArray jSONArray = asJSONObject.getJSONArray("users");
            int length = jSONArray.length();
            PagableResponseListImpl pagableResponseListImpl = new PagableResponseListImpl(length, asJSONObject, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userJSONImpl, jSONObject);
                }
                pagableResponseListImpl.add(userJSONImpl);
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(pagableResponseListImpl, asJSONObject);
            }
            return pagableResponseListImpl;
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    static ResponseList<User> createUserList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        return createUserList(httpResponse.asJSONArray(), httpResponse, configuration);
    }

    static ResponseList<User> createUserList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserJSONImpl userJSONImpl = new UserJSONImpl(jSONObject);
                responseListImpl.add(userJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(userJSONImpl, jSONObject);
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

    public int hashCode() {
        return (int) this.f9928id;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if ((obj instanceof User) && ((User) obj).getId() == this.f9928id) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserJSONImpl{id=");
        sb.append(this.f9928id);
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", screenName='");
        sb.append(this.screenName);
        sb.append('\'');
        sb.append(", location='");
        sb.append(this.location);
        sb.append('\'');
        sb.append(", description='");
        sb.append(this.description);
        sb.append('\'');
        sb.append(", isContributorsEnabled=");
        sb.append(this.isContributorsEnabled);
        sb.append(", profileImageUrl='");
        sb.append(this.profileImageUrl);
        sb.append('\'');
        sb.append(", profileImageUrlHttps='");
        sb.append(this.profileImageUrlHttps);
        sb.append('\'');
        sb.append(", isDefaultProfileImage=");
        sb.append(this.isDefaultProfileImage);
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", isProtected=");
        sb.append(this.isProtected);
        sb.append(", followersCount=");
        sb.append(this.followersCount);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", profileBackgroundColor='");
        sb.append(this.profileBackgroundColor);
        sb.append('\'');
        sb.append(", profileTextColor='");
        sb.append(this.profileTextColor);
        sb.append('\'');
        sb.append(", profileLinkColor='");
        sb.append(this.profileLinkColor);
        sb.append('\'');
        sb.append(", profileSidebarFillColor='");
        sb.append(this.profileSidebarFillColor);
        sb.append('\'');
        sb.append(", profileSidebarBorderColor='");
        sb.append(this.profileSidebarBorderColor);
        sb.append('\'');
        sb.append(", profileUseBackgroundImage=");
        sb.append(this.profileUseBackgroundImage);
        sb.append(", isDefaultProfile=");
        sb.append(this.isDefaultProfile);
        sb.append(", showAllInlineMedia=");
        sb.append(this.showAllInlineMedia);
        sb.append(", friendsCount=");
        sb.append(this.friendsCount);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", favouritesCount=");
        sb.append(this.favouritesCount);
        sb.append(", utcOffset=");
        sb.append(this.utcOffset);
        sb.append(", timeZone='");
        sb.append(this.timeZone);
        sb.append('\'');
        sb.append(", profileBackgroundImageUrl='");
        sb.append(this.profileBackgroundImageUrl);
        sb.append('\'');
        sb.append(", profileBackgroundImageUrlHttps='");
        sb.append(this.profileBackgroundImageUrlHttps);
        sb.append('\'');
        sb.append(", profileBackgroundTiled=");
        sb.append(this.profileBackgroundTiled);
        sb.append(", lang='");
        sb.append(this.lang);
        sb.append('\'');
        sb.append(", statusesCount=");
        sb.append(this.statusesCount);
        sb.append(", isGeoEnabled=");
        sb.append(this.isGeoEnabled);
        sb.append(", isVerified=");
        sb.append(this.isVerified);
        sb.append(", translator=");
        sb.append(this.translator);
        sb.append(", listedCount=");
        sb.append(this.listedCount);
        sb.append(", isFollowRequestSent=");
        sb.append(this.isFollowRequestSent);
        sb.append('}');
        return sb.toString();
    }
}
