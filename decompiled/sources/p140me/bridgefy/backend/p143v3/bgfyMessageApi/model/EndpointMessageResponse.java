package p140me.bridgefy.backend.p143v3.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.model.EndpointMessageResponse */
public final class EndpointMessageResponse extends GenericJson {
    @Key
    private List<BgfyMessage> bgfyMessages;
    @Key
    private List<BgfyMessage> bgfyMessagesError;

    static {
        Data.nullOf(BgfyMessage.class);
        Data.nullOf(BgfyMessage.class);
    }

    public List<BgfyMessage> getBgfyMessages() {
        return this.bgfyMessages;
    }

    public EndpointMessageResponse setBgfyMessages(List<BgfyMessage> list) {
        this.bgfyMessages = list;
        return this;
    }

    public List<BgfyMessage> getBgfyMessagesError() {
        return this.bgfyMessagesError;
    }

    public EndpointMessageResponse setBgfyMessagesError(List<BgfyMessage> list) {
        this.bgfyMessagesError = list;
        return this;
    }

    public EndpointMessageResponse set(String str, Object obj) {
        return (EndpointMessageResponse) super.set(str, obj);
    }

    public EndpointMessageResponse clone() {
        return (EndpointMessageResponse) super.clone();
    }
}
