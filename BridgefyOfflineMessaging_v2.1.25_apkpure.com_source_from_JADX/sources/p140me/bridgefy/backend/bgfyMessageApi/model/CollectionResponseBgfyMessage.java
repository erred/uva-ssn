package p140me.bridgefy.backend.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.bgfyMessageApi.model.CollectionResponseBgfyMessage */
public final class CollectionResponseBgfyMessage extends GenericJson {
    @Key
    private List<BgfyMessage> items;
    @Key
    private String nextPageToken;

    public List<BgfyMessage> getItems() {
        return this.items;
    }

    public CollectionResponseBgfyMessage setItems(List<BgfyMessage> list) {
        this.items = list;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public CollectionResponseBgfyMessage setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public CollectionResponseBgfyMessage set(String str, Object obj) {
        return (CollectionResponseBgfyMessage) super.set(str, obj);
    }

    public CollectionResponseBgfyMessage clone() {
        return (CollectionResponseBgfyMessage) super.clone();
    }
}
