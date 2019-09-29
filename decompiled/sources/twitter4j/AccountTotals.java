package twitter4j;

import java.io.Serializable;

public interface AccountTotals extends Serializable, TwitterResponse {
    int getFavorites();

    int getFollowers();

    int getFriends();

    int getUpdates();
}
