package twitter4j;

import twitter4j.TwitterResponse;

public interface PagableResponseList<T extends TwitterResponse> extends CursorSupport, ResponseList<T> {
    long getNextCursor();

    long getPreviousCursor();

    boolean hasNext();

    boolean hasPrevious();
}
