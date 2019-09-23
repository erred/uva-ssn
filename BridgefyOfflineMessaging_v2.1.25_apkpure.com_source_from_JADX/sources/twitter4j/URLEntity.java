package twitter4j;

import java.io.Serializable;

public interface URLEntity extends Serializable, TweetEntity {
    String getDisplayURL();

    int getEnd();

    String getExpandedURL();

    int getStart();

    String getText();

    String getURL();
}
