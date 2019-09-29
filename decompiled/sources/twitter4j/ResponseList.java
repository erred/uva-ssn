package twitter4j;

import java.util.List;

public interface ResponseList<T> extends List<T>, TwitterResponse {
    RateLimitStatus getRateLimitStatus();
}
