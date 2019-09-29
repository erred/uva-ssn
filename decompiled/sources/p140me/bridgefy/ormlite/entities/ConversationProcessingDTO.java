package p140me.bridgefy.ormlite.entities;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "conversation_processing")
/* renamed from: me.bridgefy.ormlite.entities.ConversationProcessingDTO */
public class ConversationProcessingDTO extends ORMLiteActions<ConversationProcessingDTO, Long> {

    /* renamed from: ID */
    public static final String f9512ID = "id";
    public static final String MESSAGE_STATUS = "message_status";
    public static final String SENDER = "sender_id";
    public static final String TABLE_NAME = "conversation_processing";
    @DatabaseField(columnName = "id", generatedId = true)

    /* renamed from: id */
    private long f9513id;
    @DatabaseField(canBeNull = false, columnName = "message_status")
    private Integer messageStatus;
    @DatabaseField(canBeNull = false, columnName = "sender_id")
    private String sender;

    public ConversationProcessingDTO() {
    }

    public ConversationProcessingDTO(String str, Integer num) {
        this.sender = str;
        this.messageStatus = num;
    }

    public long getId() {
        return this.f9513id;
    }

    public void setId(long j) {
        this.f9513id = j;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public Integer getMessageStatus() {
        return this.messageStatus;
    }

    public void setMessageStatus(Integer num) {
        this.messageStatus = num;
    }

    public ConversationProcessingDTO set(RuntimeExceptionDao<ConversationProcessingDTO, Long> runtimeExceptionDao) {
        if (!runtimeExceptionDao.idExists(Long.valueOf(this.f9513id))) {
            return (ConversationProcessingDTO) runtimeExceptionDao.createIfNotExists(this);
        }
        if (update(runtimeExceptionDao)) {
            return this;
        }
        return null;
    }

    public boolean update(RuntimeExceptionDao<ConversationProcessingDTO, Long> runtimeExceptionDao) {
        return runtimeExceptionDao.update(this) != -1;
    }

    public boolean delete(RuntimeExceptionDao<ConversationProcessingDTO, Long> runtimeExceptionDao) {
        return runtimeExceptionDao.delete(this) != -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConversationProcessingDTO{id=");
        sb.append(this.f9513id);
        sb.append(", sender='");
        sb.append(this.sender);
        sb.append('\'');
        sb.append(", messageStatus=");
        sb.append(this.messageStatus);
        sb.append('}');
        return sb.toString();
    }
}
