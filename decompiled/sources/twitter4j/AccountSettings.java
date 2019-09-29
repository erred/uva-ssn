package twitter4j;

import java.io.Serializable;

public interface AccountSettings extends Serializable, TwitterResponse {
    String getLanguage();

    String getScreenName();

    String getSleepEndTime();

    String getSleepStartTime();

    TimeZone getTimeZone();

    Location[] getTrendLocations();

    boolean isAlwaysUseHttps();

    boolean isDiscoverableByEmail();

    boolean isGeoEnabled();

    boolean isSleepTimeEnabled();
}
