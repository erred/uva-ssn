package twitter4j;

import java.io.Serializable;
import java.util.Date;

public interface Trends extends Serializable, Comparable<Trends>, TwitterResponse {
    Date getAsOf();

    Location getLocation();

    Date getTrendAt();

    Trend[] getTrends();
}
