package p140me.bridgefy.backend.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.bgfyMessageApi.model.BgfyMessageCollection */
public final class BgfyMessageCollection extends GenericJson {
    @Key
    private List<BgfyMessage> items;

    static {
        Data.nullOf(BgfyMessage.class);
    }

    public List<BgfyMessage> getItems() {
        return this.items;
    }

    public BgfyMessageCollection setItems(List<BgfyMessage> list) {
        this.items = list;
        return this;
    }

    public BgfyMessageCollection set(String str, Object obj) {
        return (BgfyMessageCollection) super.set(str, obj);
    }

    public BgfyMessageCollection clone() {
        return (BgfyMessageCollection) super.clone();
    }
}
