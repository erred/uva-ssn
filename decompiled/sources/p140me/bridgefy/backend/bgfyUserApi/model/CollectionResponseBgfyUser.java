package p140me.bridgefy.backend.bgfyUserApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.bgfyUserApi.model.CollectionResponseBgfyUser */
public final class CollectionResponseBgfyUser extends GenericJson {
    @Key
    private List<BgfyUser> items;
    @Key
    private String nextPageToken;

    public List<BgfyUser> getItems() {
        return this.items;
    }

    public CollectionResponseBgfyUser setItems(List<BgfyUser> list) {
        this.items = list;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public CollectionResponseBgfyUser setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public CollectionResponseBgfyUser set(String str, Object obj) {
        return (CollectionResponseBgfyUser) super.set(str, obj);
    }

    public CollectionResponseBgfyUser clone() {
        return (CollectionResponseBgfyUser) super.clone();
    }
}
