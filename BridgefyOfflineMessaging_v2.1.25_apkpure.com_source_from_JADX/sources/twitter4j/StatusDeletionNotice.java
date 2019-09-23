package twitter4j;

import java.io.Serializable;

public interface StatusDeletionNotice extends Serializable, Comparable<StatusDeletionNotice> {
    long getStatusId();

    long getUserId();
}
