package twitter4j;

import java.io.Serializable;

public interface HashtagEntity extends Serializable, TweetEntity {
    int getEnd();

    int getStart();

    String getText();
}
