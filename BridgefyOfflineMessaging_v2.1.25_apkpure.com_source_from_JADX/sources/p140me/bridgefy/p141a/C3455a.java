package p140me.bridgefy.p141a;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.UpdateBuilder;
import java.sql.SQLException;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.ConversationProcessingDTO;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.ormlite.exception.OrmLiteBridgefyException;

/* renamed from: me.bridgefy.a.a */
/* compiled from: ConversationController */
public class C3455a extends C3456b {

    /* renamed from: a */
    private RuntimeExceptionDao<ConversationProcessingDTO, Long> f8953a;

    /* renamed from: b */
    private RuntimeExceptionDao<MessageDTO, String> f8954b = mo28313a().getMessageRuntimeDAO();

    public C3455a(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        this.f8953a = databaseHelper.getConversationProcessingRuntimeDAO();
    }

    /* renamed from: a */
    public void mo28310a(String str, Integer num) {
        if (str != null) {
            try {
                if (num.intValue() != 0) {
                    mo28311a(new ConversationProcessingDTO(str, num), num.intValue());
                    return;
                }
                throw new IllegalArgumentException("Status cannt be null.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Conversation cannt be null.");
        }
    }

    /* renamed from: a */
    public void mo28311a(ConversationProcessingDTO conversationProcessingDTO, int i) throws SQLException, OrmLiteBridgefyException {
        if (conversationProcessingDTO == null) {
            throw new IllegalArgumentException("Conversation cannt be null.");
        } else if (i != 0) {
            mo28312a(new ConversationProcessingDTO[]{conversationProcessingDTO}, i);
        } else {
            throw new IllegalArgumentException("Status cannt be null.");
        }
    }

    /* renamed from: a */
    public synchronized void mo28312a(ConversationProcessingDTO[] conversationProcessingDTOArr, int i) throws SQLException, OrmLiteBridgefyException {
        if (conversationProcessingDTOArr == null) {
            throw new IllegalArgumentException("Conversations cannot be null.");
        } else if (i == 0) {
            throw new IllegalArgumentException("Status cannt be null.");
        } else if (mo28313a() == null || !mo28313a().isOpen()) {
            throw new OrmLiteBridgefyException("Data Base is closed.");
        } else {
            for (ConversationProcessingDTO conversationProcessingDTO : conversationProcessingDTOArr) {
                UpdateBuilder updateBuilder = this.f8954b.updateBuilder();
                updateBuilder.updateColumnValue(MessageDTO.STATUS, Integer.valueOf(i));
                updateBuilder.where().mo27052eq(MessageDTO.RECEIVER, conversationProcessingDTO.getSender()).and().between(MessageDTO.STATUS, Integer.valueOf(3), Integer.valueOf(4));
                this.f8954b.update(updateBuilder.prepare());
            }
        }
    }
}
