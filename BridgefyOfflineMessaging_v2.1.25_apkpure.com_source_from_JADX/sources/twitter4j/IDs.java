package twitter4j;

import java.io.Serializable;

public interface IDs extends Serializable, CursorSupport, TwitterResponse {
    long[] getIDs();

    long getNextCursor();

    long getPreviousCursor();

    boolean hasNext();

    boolean hasPrevious();
}
