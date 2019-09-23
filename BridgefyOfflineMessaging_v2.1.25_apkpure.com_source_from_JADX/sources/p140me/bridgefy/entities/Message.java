package p140me.bridgefy.entities;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.api.client.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.UUID;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BgfyMessage;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.utils.C3667g;

/* renamed from: me.bridgefy.entities.Message */
public class Message implements Parcelable {
    public static final Creator<Message> CREATOR = new Creator<Message>() {
        /* renamed from: a */
        public Message createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        /* renamed from: a */
        public Message[] newArray(int i) {
            return new Message[i];
        }
    };
    String conversation;
    @SerializedName("datesent")
    String dateSent;
    private byte[] fileContent;
    private String fileName;
    String messageId;
    private int messageType;
    String offlineId;
    private String otherUserName;
    String receiver;
    String sender;
    @SerializedName("serverdate")
    String serverDate;
    private int status;
    @SerializedName("message")
    String text;

    public int describeContents() {
        return 0;
    }

    public Message() {
        this.messageId = String.valueOf(-1);
        this.status = 0;
        this.receiver = "";
        this.sender = "";
        this.messageId = String.valueOf(0);
    }

    public Message(String str, String str2, String str3, String str4, int i) {
        this.messageId = String.valueOf(-1);
        this.status = 0;
        this.receiver = str;
        this.sender = str2;
        this.text = str3;
        this.otherUserName = str4;
        this.messageType = i;
        this.offlineId = UUID.randomUUID().toString();
        this.dateSent = String.valueOf(System.currentTimeMillis());
        this.serverDate = String.valueOf(System.currentTimeMillis());
        this.conversation = str;
    }

    public Message(String str, long j, String str2, String str3, String str4, String str5, int i) {
        this.messageId = String.valueOf(-1);
        this.status = 0;
        this.offlineId = str;
        this.messageId = str;
        this.dateSent = String.valueOf(j);
        this.serverDate = String.valueOf(System.currentTimeMillis());
        this.receiver = str2;
        this.conversation = str2;
        this.sender = str3;
        this.text = str4;
        this.messageType = i;
        this.otherUserName = str5;
    }

    public Message(String str, String str2, String str3) {
        this.messageId = String.valueOf(-1);
        this.status = 0;
        this.offlineId = UUID.randomUUID().toString();
        this.dateSent = String.valueOf(System.currentTimeMillis());
        this.serverDate = String.valueOf(System.currentTimeMillis());
        this.fileName = str;
        this.receiver = str2;
        this.conversation = str2;
        this.sender = str3;
        this.messageType = 1;
    }

    public Message(MessageDTO messageDTO) {
        this.messageId = String.valueOf(-1);
        this.status = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(messageDTO.getDatabaseId());
        sb.append("");
        this.offlineId = sb.toString();
        this.conversation = messageDTO.getConversation();
        this.dateSent = messageDTO.getDateSent();
        this.serverDate = messageDTO.getServerDate();
        this.fileName = messageDTO.getFileName();
        this.receiver = messageDTO.getReceiver();
        this.sender = messageDTO.getSender();
        this.text = messageDTO.getMessage();
        this.otherUserName = messageDTO.getFriend().getUsername();
        this.messageId = messageDTO.getMessageId();
        this.status = messageDTO.getStatus().intValue();
        this.messageType = messageDTO.getMessageType();
    }

    public Message(BgfyMessage bgfyMessage) {
        this.messageId = String.valueOf(-1);
        this.status = 0;
        this.dateSent = String.valueOf(bgfyMessage.getDateSent());
        this.serverDate = String.valueOf(bgfyMessage.getDateSent());
        this.fileName = bgfyMessage.getFilePath();
        this.receiver = bgfyMessage.getReceiver();
        this.conversation = bgfyMessage.getReceiver();
        this.sender = bgfyMessage.getSender();
        this.fileContent = Base64.decodeBase64(bgfyMessage.getFileBytes());
        this.text = bgfyMessage.getText();
        if (bgfyMessage.getMessageId() != null) {
            this.messageId = String.valueOf(bgfyMessage.getMessageId());
        }
        if (bgfyMessage.getLocalID() != null) {
            this.offlineId = bgfyMessage.getLocalID();
        }
        if (this.offlineId == null && this.messageId != null) {
            this.offlineId = this.messageId;
        }
        if (bgfyMessage.getMessageType() != null) {
            this.messageType = bgfyMessage.getMessageType().intValue();
        } else if (bgfyMessage.getFilePath() == null || bgfyMessage.getFilePath().trim().length() <= 0) {
            this.messageType = 0;
        } else {
            this.messageType = 1;
        }
    }

    public String getBridgefyImagePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(C3667g.m10937a("Bridgefy").getPath());
        sb.append("/");
        sb.append(this.fileName);
        return sb.toString();
    }

    public String findFilePath() {
        try {
            return findFileUri().getPath();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public Uri findThumbnailUri() {
        StringBuilder sb = new StringBuilder();
        sb.append(C3667g.m10937a("Bridgefy/thumbs").getPath());
        sb.append("/");
        sb.append(this.fileName);
        File file = new File(sb.toString());
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        File file2 = new File(this.fileName);
        if (file2.exists()) {
            return Uri.fromFile(file2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C3667g.m10937a("Bridgefy").getPath());
        sb2.append("/");
        sb2.append(this.fileName);
        File file3 = new File(sb2.toString());
        if (file3.exists()) {
            return Uri.fromFile(file3);
        }
        try {
            if (this.fileName.indexOf(":") != -1) {
                File file4 = new File(this.fileName.split(":")[1]);
                if (file4.exists()) {
                    return Uri.fromFile(file4);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Uri findFileUri() {
        File file = new File(this.fileName);
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C3667g.m10937a("Bridgefy").getPath());
        sb.append("/");
        sb.append(this.fileName);
        File file2 = new File(sb.toString());
        if (file2.exists()) {
            return Uri.fromFile(file2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C3667g.m10937a("Bridgefy/thumbs").getPath());
        sb2.append("/");
        sb2.append(this.fileName);
        File file3 = new File(sb2.toString());
        if (file3.exists()) {
            return Uri.fromFile(file3);
        }
        try {
            if (this.fileName.indexOf(":") != -1) {
                File file4 = new File(this.fileName.split(":")[1]);
                if (file4.exists()) {
                    return Uri.fromFile(file4);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Message {offlineId='");
        sb.append(this.offlineId);
        sb.append('\'');
        sb.append(", conversation=");
        sb.append(this.conversation);
        sb.append(", dateSent='");
        sb.append(this.dateSent);
        sb.append('\'');
        sb.append(", serverDate='");
        sb.append(this.serverDate);
        sb.append('\'');
        sb.append(", fileName='");
        sb.append(this.fileName);
        sb.append('\'');
        sb.append(", receiver='");
        sb.append(this.receiver);
        sb.append('\'');
        sb.append(", sender='");
        sb.append(this.sender);
        sb.append('\'');
        sb.append(", text='");
        sb.append(this.text);
        sb.append('\'');
        sb.append(", otherUserName='");
        sb.append(this.otherUserName);
        sb.append('\'');
        sb.append(", messageId=");
        sb.append(this.messageId);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", messageType=");
        sb.append(this.messageType);
        sb.append('}');
        return sb.toString();
    }

    public String serialize() {
        return new Gson().toJson((Object) this);
    }

    public static Message create(String str) throws JsonSyntaxException {
        return (Message) new Gson().fromJson(str, Message.class);
    }

    public String getOfflineId() {
        return this.offlineId;
    }

    public void setOfflineId(String str) {
        this.offlineId = str;
    }

    public String getConversation() {
        return this.conversation;
    }

    public void setConversation(String str) {
        this.conversation = str;
    }

    public String getDateSent() {
        return this.dateSent;
    }

    public void setDateSent(String str) {
        this.dateSent = str;
    }

    public String getServerDate() {
        return this.serverDate;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getSender() {
        return this.sender;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getOtherUserName() {
        return this.otherUserName;
    }

    public void setOtherUserName(String str) {
        this.otherUserName = str;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public byte[] getFileContent() {
        return this.fileContent;
    }

    public void setFileContent(byte[] bArr) {
        this.fileContent = bArr;
    }

    public int getType() {
        return this.messageType;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.offlineId);
        parcel.writeString(this.conversation);
        parcel.writeString(this.dateSent);
        parcel.writeString(this.serverDate);
        parcel.writeString(this.receiver);
        parcel.writeString(this.sender);
        parcel.writeString(this.text);
        parcel.writeString(this.messageId);
        parcel.writeString(this.otherUserName);
        parcel.writeInt(this.status);
        parcel.writeInt(this.messageType);
        parcel.writeString(this.fileName);
        parcel.writeByteArray(this.fileContent);
    }

    protected Message(Parcel parcel) {
        this.messageId = String.valueOf(-1);
        this.status = 0;
        this.offlineId = parcel.readString();
        this.conversation = parcel.readString();
        this.dateSent = parcel.readString();
        this.serverDate = parcel.readString();
        this.receiver = parcel.readString();
        this.sender = parcel.readString();
        this.text = parcel.readString();
        this.messageId = parcel.readString();
        this.otherUserName = parcel.readString();
        this.status = parcel.readInt();
        this.messageType = parcel.readInt();
        this.fileName = parcel.readString();
        this.fileContent = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if (message.getOfflineId() != null && message.getOfflineId().trim().equalsIgnoreCase(getOfflineId())) {
            return true;
        }
        if (message.getMessageId() != null && message.getMessageId().trim().equalsIgnoreCase(getMessageId())) {
            z = true;
        }
        return z;
    }
}
