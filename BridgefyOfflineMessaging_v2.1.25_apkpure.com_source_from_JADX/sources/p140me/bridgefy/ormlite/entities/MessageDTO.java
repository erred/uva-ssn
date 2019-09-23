package p140me.bridgefy.ormlite.entities;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import p140me.bridgefy.entities.Message;

@DatabaseTable(tableName = "bgf_message")
/* renamed from: me.bridgefy.ormlite.entities.MessageDTO */
public class MessageDTO extends ORMLiteActions<MessageDTO, String> {
    public static final String CONVERSATION = "conversation";
    public static final String DATE_SENT = "dataSent";

    /* renamed from: ID */
    public static final String f9516ID = "id";
    public static final String IMAGE = "image";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_ID = "message_id";
    public static final String MESSAGE_TYPE = "message_type";
    public static final String RECEIVER = "receiver";
    public static final String SENDER = "sender";
    public static final String SERVER_DATE = "serverDate";
    public static final String STATUS = "status";
    public static final String TABLE_NAME = "bgf_message";
    @DatabaseField(canBeNull = true, columnName = "conversation")
    private String conversation;
    @SerializedName("datasent")
    @DatabaseField(canBeNull = true, columnName = "dataSent")
    private String dateSent;
    @DatabaseField(canBeNull = true, columnName = "image")
    private String fileName;
    @DatabaseField(canBeNull = false, foreign = true)
    private FriendDTO friend;
    @DatabaseField(columnName = "id", mo26675id = true, index = true)

    /* renamed from: id */
    private String f9517id;
    @DatabaseField(canBeNull = true, columnName = "message")
    private String message;
    @DatabaseField(canBeNull = true, columnName = "message_id")
    private String messageId;
    @DatabaseField(canBeNull = true, columnName = "message_type")
    private int messageType;
    @DatabaseField(canBeNull = true, columnName = "receiver")
    private String receiver;
    @DatabaseField(canBeNull = true, columnName = "sender")
    private String sender;
    @SerializedName("serverDate")
    @DatabaseField(canBeNull = true, columnName = "serverDate")
    private String serverDate;
    @DatabaseField(canBeNull = true, columnName = "status")
    private int status;

    public MessageDTO() {
    }

    public MessageDTO(Message message2) {
        this.f9517id = message2.getOfflineId();
        this.conversation = message2.getConversation();
        this.dateSent = message2.getDateSent();
        this.serverDate = message2.getServerDate();
        this.fileName = message2.getFileName();
        this.receiver = message2.getReceiver();
        this.sender = message2.getSender();
        this.message = message2.getText();
        this.messageId = message2.getMessageId();
        this.status = message2.getStatus();
        this.messageType = message2.getType();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessageDTO {id='");
        sb.append(this.f9517id);
        sb.append('\'');
        sb.append(", conversation='");
        sb.append(this.conversation);
        sb.append('\'');
        sb.append(", dateSent='");
        sb.append(this.dateSent);
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
        sb.append(", message='");
        sb.append(this.message);
        sb.append('\'');
        sb.append(", messageId='");
        sb.append(this.messageId);
        sb.append('\'');
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", messageType=");
        sb.append(this.messageType);
        sb.append('}');
        return sb.toString();
    }

    public String getDatabaseId() {
        return this.f9517id;
    }

    public void setDatabaseId(String str) {
        this.f9517id = str;
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

    public void setServerDate(String str) {
        this.serverDate = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String str) {
        this.receiver = str;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Integer getStatus() {
        return Integer.valueOf(this.status);
    }

    public void setStatus(Integer num) {
        this.status = num.intValue();
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public FriendDTO getFriend() {
        return this.friend;
    }

    public void setFriend(FriendDTO friendDTO) {
        this.friend = friendDTO;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public MessageDTO set(RuntimeExceptionDao<MessageDTO, String> runtimeExceptionDao) {
        if (runtimeExceptionDao.idExists(this.f9517id)) {
            if (update(runtimeExceptionDao)) {
                return this;
            }
        } else if (runtimeExceptionDao.create(this) != -1) {
            return this;
        }
        return null;
    }

    public boolean update(RuntimeExceptionDao<MessageDTO, String> runtimeExceptionDao) {
        return runtimeExceptionDao.update(this) != -1;
    }

    public boolean delete(RuntimeExceptionDao<MessageDTO, String> runtimeExceptionDao) {
        return runtimeExceptionDao.delete(this) != -1;
    }
}
