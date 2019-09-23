package twitter4j;

import java.io.Serializable;

public interface OEmbed extends Serializable, TwitterResponse {
    String getAuthorName();

    String getAuthorURL();

    long getCacheAge();

    String getHtml();

    String getURL();

    String getVersion();

    int getWidth();
}
