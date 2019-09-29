package p140me.bridgefy.entities;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/* renamed from: me.bridgefy.entities.ChatEntry */
public class ChatEntry {
    private int color;
    private String initials;
    private String lastDateSent;
    private String lastMessageSender;
    private int lastMessageStatus;
    private String lastText;
    private boolean meshEnabled;
    private int messageType;
    private int unseenMessages;
    private String userId;
    private String userName;

    public ChatEntry(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, int i3) {
        this.initials = str;
        this.userName = str2;
        this.userId = str3;
        this.lastText = str4;
        this.lastDateSent = str5;
        this.lastMessageStatus = i;
        this.lastMessageSender = str6;
        this.messageType = i2;
        this.color = i3;
    }

    public String serialize() {
        return new Gson().toJson((Object) this);
    }

    public static ChatEntry create(String str) throws JsonSyntaxException {
        return (ChatEntry) new Gson().fromJson(str, ChatEntry.class);
    }

    public boolean equals(Object obj) {
        return getUserId().equals(((ChatEntry) obj).getUserId());
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getLastText() {
        return this.lastText;
    }

    public String getLastDateSent() {
        return this.lastDateSent;
    }

    public boolean isMeshEnabled() {
        return this.meshEnabled;
    }

    public void setMeshEnabled(boolean z) {
        this.meshEnabled = z;
    }

    public int getLastMessageStatus() {
        return this.lastMessageStatus;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getColor() {
        return this.color;
    }

    public String getInitials() {
        return this.initials;
    }

    public void setUnseenMessages(int i) {
        this.unseenMessages = i;
    }

    public String getLastMessageSender() {
        return this.lastMessageSender;
    }
}
