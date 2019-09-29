package p140me.bridgefy.backend.p143v3.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.model.EndpointConversationListContainer */
public final class EndpointConversationListContainer extends GenericJson {
    @Key
    private List<String> senders;

    public List<String> getSenders() {
        return this.senders;
    }

    public EndpointConversationListContainer setSenders(List<String> list) {
        this.senders = list;
        return this;
    }

    public EndpointConversationListContainer set(String str, Object obj) {
        return (EndpointConversationListContainer) super.set(str, obj);
    }

    public EndpointConversationListContainer clone() {
        return (EndpointConversationListContainer) super.clone();
    }
}
