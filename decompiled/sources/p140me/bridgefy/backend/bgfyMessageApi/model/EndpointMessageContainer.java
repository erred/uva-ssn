package p140me.bridgefy.backend.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.bgfyMessageApi.model.EndpointMessageContainer */
public final class EndpointMessageContainer extends GenericJson {
    @Key
    private List<BgfyMessage> bgfyMessageList;

    static {
        Data.nullOf(BgfyMessage.class);
    }

    public List<BgfyMessage> getBgfyMessageList() {
        return this.bgfyMessageList;
    }

    public EndpointMessageContainer setBgfyMessageList(List<BgfyMessage> list) {
        this.bgfyMessageList = list;
        return this;
    }

    public EndpointMessageContainer set(String str, Object obj) {
        return (EndpointMessageContainer) super.set(str, obj);
    }

    public EndpointMessageContainer clone() {
        return (EndpointMessageContainer) super.clone();
    }
}
