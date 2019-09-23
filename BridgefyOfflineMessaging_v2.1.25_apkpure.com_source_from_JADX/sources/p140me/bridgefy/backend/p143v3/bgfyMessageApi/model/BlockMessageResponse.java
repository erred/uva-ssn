package p140me.bridgefy.backend.p143v3.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.model.BlockMessageResponse */
public final class BlockMessageResponse extends GenericJson {
    @Key
    private String message;
    @JsonString
    @Key
    private Long messageId;
    @Key
    private Integer reasonId;
    @Key
    private String receivedId;
    @Key
    private String senderId;

    public String getMessage() {
        return this.message;
    }

    public BlockMessageResponse setMessage(String str) {
        this.message = str;
        return this;
    }

    public Long getMessageId() {
        return this.messageId;
    }

    public BlockMessageResponse setMessageId(Long l) {
        this.messageId = l;
        return this;
    }

    public Integer getReasonId() {
        return this.reasonId;
    }

    public BlockMessageResponse setReasonId(Integer num) {
        this.reasonId = num;
        return this;
    }

    public String getReceivedId() {
        return this.receivedId;
    }

    public BlockMessageResponse setReceivedId(String str) {
        this.receivedId = str;
        return this;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public BlockMessageResponse setSenderId(String str) {
        this.senderId = str;
        return this;
    }

    public BlockMessageResponse set(String str, Object obj) {
        return (BlockMessageResponse) super.set(str, obj);
    }

    public BlockMessageResponse clone() {
        return (BlockMessageResponse) super.clone();
    }
}
