package p140me.bridgefy.backend.bgfyKeyApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.bgfyKeyApi.model.BgfyKey */
public final class BgfyKey extends GenericJson {
    @Key
    private String load;
    @Key
    private String owner;

    public String getLoad() {
        return this.load;
    }

    public BgfyKey setLoad(String str) {
        this.load = str;
        return this;
    }

    public String getOwner() {
        return this.owner;
    }

    public BgfyKey setOwner(String str) {
        this.owner = str;
        return this;
    }

    public BgfyKey set(String str, Object obj) {
        return (BgfyKey) super.set(str, obj);
    }

    public BgfyKey clone() {
        return (BgfyKey) super.clone();
    }
}
