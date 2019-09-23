package p140me.bridgefy.backend.p143v3.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.model.BgfyMessage */
public final class BgfyMessage extends GenericJson {
    @JsonString
    @Key("checksum_key")
    private Long checksumKey;
    @JsonString
    @Key
    private Long dateSent;
    @Key
    private String fileBytes;
    @Key
    private String filePath;
    @Key
    private String localID;
    @Key
    private String messageError;
    @JsonString
    @Key
    private Long messageId;
    @Key
    private Integer messageType;
    @Key
    private String mimetype;
    @Key
    private String receiver;
    @Key
    private String sender;
    @Key
    private Integer status;
    @Key
    private String text;

    public Long getChecksumKey() {
        return this.checksumKey;
    }

    public BgfyMessage setChecksumKey(Long l) {
        this.checksumKey = l;
        return this;
    }

    public Long getDateSent() {
        return this.dateSent;
    }

    public BgfyMessage setDateSent(Long l) {
        this.dateSent = l;
        return this;
    }

    public String getFileBytes() {
        return this.fileBytes;
    }

    public byte[] decodeFileBytes() {
        return Base64.decodeBase64(this.fileBytes);
    }

    public BgfyMessage setFileBytes(String str) {
        this.fileBytes = str;
        return this;
    }

    public BgfyMessage encodeFileBytes(byte[] bArr) {
        this.fileBytes = Base64.encodeBase64URLSafeString(bArr);
        return this;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public BgfyMessage setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public String getLocalID() {
        return this.localID;
    }

    public BgfyMessage setLocalID(String str) {
        this.localID = str;
        return this;
    }

    public String getMessageError() {
        return this.messageError;
    }

    public BgfyMessage setMessageError(String str) {
        this.messageError = str;
        return this;
    }

    public Long getMessageId() {
        return this.messageId;
    }

    public BgfyMessage setMessageId(Long l) {
        this.messageId = l;
        return this;
    }

    public Integer getMessageType() {
        return this.messageType;
    }

    public BgfyMessage setMessageType(Integer num) {
        this.messageType = num;
        return this;
    }

    public String getMimetype() {
        return this.mimetype;
    }

    public BgfyMessage setMimetype(String str) {
        this.mimetype = str;
        return this;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public BgfyMessage setReceiver(String str) {
        this.receiver = str;
        return this;
    }

    public String getSender() {
        return this.sender;
    }

    public BgfyMessage setSender(String str) {
        this.sender = str;
        return this;
    }

    public Integer getStatus() {
        return this.status;
    }

    public BgfyMessage setStatus(Integer num) {
        this.status = num;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public BgfyMessage setText(String str) {
        this.text = str;
        return this;
    }

    public BgfyMessage set(String str, Object obj) {
        return (BgfyMessage) super.set(str, obj);
    }

    public BgfyMessage clone() {
        return (BgfyMessage) super.clone();
    }
}
