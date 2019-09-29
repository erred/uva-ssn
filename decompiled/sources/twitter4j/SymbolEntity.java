package twitter4j;

import java.io.Serializable;

public interface SymbolEntity extends Serializable, TweetEntity {
    int getEnd();

    int getStart();
}
