package p140me.bridgefy.backend.bgfyKeyApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.bgfyKeyApi.model.CollectionResponseBgfyKey */
public final class CollectionResponseBgfyKey extends GenericJson {
    @Key
    private List<BgfyKey> items;
    @Key
    private String nextPageToken;

    static {
        Data.nullOf(BgfyKey.class);
    }

    public List<BgfyKey> getItems() {
        return this.items;
    }

    public CollectionResponseBgfyKey setItems(List<BgfyKey> list) {
        this.items = list;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public CollectionResponseBgfyKey setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public CollectionResponseBgfyKey set(String str, Object obj) {
        return (CollectionResponseBgfyKey) super.set(str, obj);
    }

    public CollectionResponseBgfyKey clone() {
        return (CollectionResponseBgfyKey) super.clone();
    }
}
