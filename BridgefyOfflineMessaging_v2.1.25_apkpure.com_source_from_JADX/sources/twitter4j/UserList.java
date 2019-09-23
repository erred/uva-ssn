package twitter4j;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;

public interface UserList extends Serializable, Comparable<UserList>, TwitterResponse {
    Date getCreatedAt();

    String getDescription();

    String getFullName();

    long getId();

    int getMemberCount();

    String getName();

    String getSlug();

    int getSubscriberCount();

    URI getURI();

    User getUser();

    boolean isFollowing();

    boolean isPublic();
}
