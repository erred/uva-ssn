package p140me.bridgefy.backend.p143v3.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.model.BgfyUserCollection */
public final class BgfyUserCollection extends GenericJson {
    @Key
    private List<BgfyUser> items;

    public List<BgfyUser> getItems() {
        return this.items;
    }

    public BgfyUserCollection setItems(List<BgfyUser> list) {
        this.items = list;
        return this;
    }

    public BgfyUserCollection set(String str, Object obj) {
        return (BgfyUserCollection) super.set(str, obj);
    }

    public BgfyUserCollection clone() {
        return (BgfyUserCollection) super.clone();
    }
}
