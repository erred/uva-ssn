package p140me.bridgefy.backend.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.bgfyMessageApi.model.EndpointMessageListContainer */
public final class EndpointMessageListContainer extends GenericJson {
    @JsonString
    @Key
    private List<Long> messageIDs;
    @Key
    private Integer messagesStatus;

    public List<Long> getMessageIDs() {
        return this.messageIDs;
    }

    public EndpointMessageListContainer setMessageIDs(List<Long> list) {
        this.messageIDs = list;
        return this;
    }

    public Integer getMessagesStatus() {
        return this.messagesStatus;
    }

    public EndpointMessageListContainer setMessagesStatus(Integer num) {
        this.messagesStatus = num;
        return this;
    }

    public EndpointMessageListContainer set(String str, Object obj) {
        return (EndpointMessageListContainer) super.set(str, obj);
    }

    public EndpointMessageListContainer clone() {
        return (EndpointMessageListContainer) super.clone();
    }
}
