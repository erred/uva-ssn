package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface User extends Serializable, Comparable<User>, TwitterResponse {
    String getBiggerProfileImageURL();

    String getBiggerProfileImageURLHttps();

    Date getCreatedAt();

    String getDescription();

    URLEntity[] getDescriptionURLEntities();

    int getFavouritesCount();

    int getFollowersCount();

    int getFriendsCount();

    long getId();

    String getLang();

    int getListedCount();

    String getLocation();

    String getMiniProfileImageURL();

    String getMiniProfileImageURLHttps();

    String getName();

    String getOriginalProfileImageURL();

    String getOriginalProfileImageURLHttps();

    String getProfileBackgroundColor();

    String getProfileBackgroundImageURL();

    String getProfileBackgroundImageUrlHttps();

    String getProfileBannerIPadRetinaURL();

    String getProfileBannerIPadURL();

    String getProfileBannerMobileRetinaURL();

    String getProfileBannerMobileURL();

    String getProfileBannerRetinaURL();

    String getProfileBannerURL();

    String getProfileImageURL();

    String getProfileImageURLHttps();

    String getProfileLinkColor();

    String getProfileSidebarBorderColor();

    String getProfileSidebarFillColor();

    String getProfileTextColor();

    String getScreenName();

    Status getStatus();

    int getStatusesCount();

    String getTimeZone();

    String getURL();

    URLEntity getURLEntity();

    int getUtcOffset();

    boolean isContributorsEnabled();

    boolean isDefaultProfile();

    boolean isDefaultProfileImage();

    boolean isFollowRequestSent();

    boolean isGeoEnabled();

    boolean isProfileBackgroundTiled();

    boolean isProfileUseBackgroundImage();

    boolean isProtected();

    boolean isShowAllInlineMedia();

    boolean isTranslator();

    boolean isVerified();
}
