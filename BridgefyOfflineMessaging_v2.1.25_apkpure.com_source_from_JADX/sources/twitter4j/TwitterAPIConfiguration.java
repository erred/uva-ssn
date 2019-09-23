package twitter4j;

import java.io.Serializable;
import java.util.Map;
import twitter4j.MediaEntity.Size;

public interface TwitterAPIConfiguration extends Serializable, TwitterResponse {
    int getCharactersReservedPerMedia();

    int getMaxMediaPerUpload();

    String[] getNonUsernamePaths();

    int getPhotoSizeLimit();

    Map<Integer, Size> getPhotoSizes();

    int getShortURLLength();

    int getShortURLLengthHttps();
}
