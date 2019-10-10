package p140me.bridgefy.p141a;

import android.content.Context;
import android.util.Log;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.sqlcipher.database.SQLiteException;
import p000a.p013b.C0353r;
import p000a.p013b.C0354s;
import p000a.p013b.C0355t;
import p000a.p013b.C0356u;
import p000a.p013b.p014a.p016b.C0153a;
import p000a.p013b.p038h.C0331a;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.entities.ChatEntry;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.integration.C3549b;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3662d;

/* renamed from: me.bridgefy.a.d */
/* compiled from: MessageController */
public class C3460d extends C3456b {

    /* renamed from: a */
    private String f8963a = "MessageController";

    /* renamed from: b */
    private RuntimeExceptionDao<MessageDTO, String> f8964b;

    /* renamed from: c */
    private RuntimeExceptionDao<FriendDTO, String> f8965c;

    public C3460d(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        this.f8964b = databaseHelper.getMessageRuntimeDAO();
        this.f8965c = databaseHelper.getFriendRuntimeDAO();
    }

    /* renamed from: a */
    public MessageDTO mo28335a(String str) {
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            queryBuilder.where().mo27052eq("id", str);
            return (MessageDTO) this.f8964b.queryForFirst(queryBuilder.prepare());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Message mo28341b(String str) {
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            queryBuilder.where().mo27052eq(MessageDTO.MESSAGE_ID, str).mo27074or().mo27052eq("id", str);
            return new Message((MessageDTO) this.f8964b.queryForFirst(queryBuilder.prepare()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public Message mo28334a(String str, String str2) {
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            queryBuilder.where().mo27052eq(MessageDTO.DATE_SENT, str).and().mo27052eq(MessageDTO.CONVERSATION, str2);
            return new Message((MessageDTO) this.f8964b.queryForFirst(queryBuilder.prepare()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public List<MessageDTO> mo28332a(String[] strArr) {
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            queryBuilder.where().mo27061in(MessageDTO.MESSAGE_ID, (Object[]) strArr).mo27074or().mo27061in("id", (Object[]) strArr);
            return this.f8964b.query(queryBuilder.prepare());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public List<Message> mo28331a(String str, long j) {
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            queryBuilder.where().mo27052eq(MessageDTO.CONVERSATION, str);
            queryBuilder.orderBy(MessageDTO.DATE_SENT, false).distinct();
            queryBuilder.offset(Long.valueOf(j)).limit(Long.valueOf(20));
            for (MessageDTO messageDTO : this.f8964b.query(queryBuilder.prepare())) {
                Message message = new Message(messageDTO);
                message.setOfflineId(String.valueOf(messageDTO.getDatabaseId()));
                arrayList.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public ArrayList<MessageDTO> mo28330a(int i, String str) {
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            Where where = queryBuilder.where();
            if (str != null) {
                where.mo27052eq(MessageDTO.CONVERSATION, str).and().mo27052eq(MessageDTO.STATUS, Integer.valueOf(i));
            } else {
                where.mo27052eq(MessageDTO.STATUS, Integer.valueOf(i));
            }
            queryBuilder.groupBy(MessageDTO.DATE_SENT);
            queryBuilder.orderBy(MessageDTO.DATE_SENT, true).distinct();
            return (ArrayList) this.f8964b.query(queryBuilder.prepare());
        } catch (SQLException e) {
            String str2 = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("Query error: ");
            sb.append(e.getMessage());
            Log.e(str2, sb.toString());
            return null;
        } catch (IllegalStateException e2) {
            String str3 = this.f8963a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DataBase error: ");
            sb2.append(e2.getMessage());
            Log.e(str3, sb2.toString());
            return null;
        } catch (SQLiteException e3) {
            String str4 = this.f8963a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Encripted DB ");
            sb3.append(e3.getMessage());
            Log.e(str4, sb3.toString());
            mo28314a(e3);
            return null;
        }
    }

    /* renamed from: b */
    public ArrayList<MessageDTO> mo28340b(int i, String str) {
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            Where where = queryBuilder.where();
            if (str != null) {
                where.mo27052eq(MessageDTO.SENDER, str).and().mo27052eq(MessageDTO.STATUS, Integer.valueOf(i));
            } else {
                where.mo27052eq(MessageDTO.STATUS, Integer.valueOf(i));
            }
            queryBuilder.groupBy(MessageDTO.DATE_SENT);
            queryBuilder.orderBy(MessageDTO.DATE_SENT, true).distinct();
            return (ArrayList) this.f8964b.query(queryBuilder.prepare());
        } catch (SQLException e) {
            String str2 = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("Query error: ");
            sb.append(e.getMessage());
            Log.e(str2, sb.toString());
            return null;
        } catch (IllegalStateException e2) {
            String str3 = this.f8963a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DataBase error: ");
            sb2.append(e2.getMessage());
            Log.e(str3, sb2.toString());
            return null;
        }
    }

    /* renamed from: c */
    public ArrayList<Message> mo28344c(String str) {
        ArrayList<Message> arrayList = new ArrayList<>();
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            queryBuilder.where().mo27052eq(MessageDTO.CONVERSATION, str).and().mo27052eq(MessageDTO.STATUS, Integer.valueOf(0));
            queryBuilder.orderBy(MessageDTO.DATE_SENT, true);
            for (MessageDTO message : this.f8964b.query(queryBuilder.prepare())) {
                arrayList.add(new Message(message));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo28339a(C3662d dVar, C3523c<ArrayList<ChatEntry>> cVar) {
        C0353r.m949a((C0356u<T>) new C0356u(dVar) {
            private final /* synthetic */ C3662d f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(C0354s sVar) {
                C3460d.this.m10062a(this.f$1, sVar);
            }
        }).mo564b(C0331a.m925b()).mo562a(C0153a.m534a()).mo563a((C0355t<? super T>) cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10062a(C3662d dVar, C0354s sVar) throws Exception {
        C3662d dVar2 = dVar;
        C0354s sVar2 = sVar;
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = this.f8964b.queryBuilder();
            queryBuilder.where().mo27068ne(MessageDTO.CONVERSATION, "broadcast.public");
            queryBuilder.groupBy(MessageDTO.CONVERSATION).orderBy(MessageDTO.DATE_SENT, false);
            for (MessageDTO messageDTO : this.f8964b.query(queryBuilder.prepare())) {
                FriendDTO friend = messageDTO.getFriend();
                this.f8965c.refresh(friend);
                if (friend != null) {
                    if (!(dVar2 == null || friend.getPhoneNumber() == null || !C3659b.m10912g(friend.getPhoneNumber()))) {
                        friend.setContactName((String) dVar2.mo29827b(friend.getPhoneNumber()).second);
                    }
                    friend.update(this.f8965c);
                    ChatEntry chatEntry = new ChatEntry(C3659b.m10902b(friend.getContactOrUsername()), friend.buildDisplayName(), messageDTO.getConversation(), messageDTO.getMessage(), messageDTO.getDateSent(), messageDTO.getStatus().intValue(), messageDTO.getSender(), messageDTO.getMessageType(), friend.getColor());
                    arrayList.add(chatEntry);
                }
            }
            sVar2.mo463a(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            sVar2.mo464a((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo28338a(MessageDTO messageDTO) {
        messageDTO.set((RuntimeExceptionDao) this.f8964b);
    }

    /* renamed from: a */
    public synchronized void mo28337a(Message message) {
        String str = this.f8963a;
        StringBuilder sb = new StringBuilder();
        sb.append("... saveOutgoingMessage: ");
        sb.append(message.getOfflineId());
        Log.v(str, sb.toString());
        MessageDTO messageDTO = new MessageDTO(message);
        if (message.getOfflineId() == null) {
            String str2 = this.f8963a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Outgoing message with no offlineId, setting it to databaseId: ");
            sb2.append(message.getMessageId());
            Log.w(str2, sb2.toString());
            if (message.getMessageId() == null || message.getMessageId().equals(String.valueOf(-1))) {
                Log.e(this.f8963a, "... outgoing messageId was invalid! setting a random new one :/");
                messageDTO.setDatabaseId(UUID.randomUUID().toString());
            } else {
                messageDTO.setDatabaseId(message.getMessageId());
            }
        }
        if (message.getOfflineId() != null) {
            MessageDTO messageDTO2 = (MessageDTO) this.f8964b.queryForId(message.getOfflineId());
            if (messageDTO2 != null && messageDTO2.getStatus().intValue() > message.getStatus()) {
                messageDTO.setStatus(messageDTO2.getStatus());
            }
        }
        try {
            FriendDTO c = new C3457c(mo28313a()).query_friend_dto_by_id(message.getReceiver());
            if (c == null) {
                c = new FriendDTO(message.getReceiver(), message.getOtherUserName(), null);
                c.set(mo28313a().getFriendRuntimeDAO());
            }
            messageDTO.setFriend(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mo28338a(messageDTO);
    }

    /* renamed from: a */
    public MessageDTO mo28336a(FriendDTO friendDTO, Message message, String str) {
        MessageDTO messageDTO;
        message.setConversation(message.getSender());
        MessageDTO messageDTO2 = new MessageDTO(message);
        if (message.getOfflineId() != null) {
            messageDTO = (MessageDTO) this.f8964b.queryForId(message.getOfflineId());
            if (messageDTO != null) {
                messageDTO2.setDatabaseId(messageDTO.getDatabaseId());
            }
        } else {
            messageDTO2.setDatabaseId(UUID.randomUUID().toString());
            messageDTO = null;
        }
        FriendDTO friendDTO2 = (FriendDTO) this.f8965c.queryForId(message.getSender());
        if (friendDTO2 == null) {
            friendDTO2 = new FriendDTO(message.getSender(), message.getOtherUserName(), str);
            friendDTO2.set((RuntimeExceptionDao) this.f8965c);
        }
        messageDTO2.setFriend(friendDTO2);
        mo28338a(messageDTO2);
        message.setOfflineId(messageDTO2.getDatabaseId());
        return messageDTO;
    }

    /* renamed from: d */
    public void mo28345d(String str) {
        ArrayList a = mo28330a(1, str);
        Iterator it = a.iterator();
        while (it.hasNext()) {
            MessageDTO messageDTO = (MessageDTO) it.next();
            String str2 = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("rescueMessagesInProgress needs update message: ");
            sb.append(messageDTO.getMessageId());
            sb.append(" database id: ");
            sb.append(messageDTO.getDatabaseId());
            Log.w(str2, sb.toString());
            messageDTO.setStatus(0);
            messageDTO.set((RuntimeExceptionDao) this.f8964b);
        }
        a.clear();
    }

    /* renamed from: e */
    public void mo28348e(String str) {
        mo28345d(str);
        Iterator it = mo28330a(2, str).iterator();
        while (it.hasNext()) {
            MessageDTO messageDTO = (MessageDTO) it.next();
            String str2 = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("findMessageDTOsByStatusAndConversation#rescuePendingMessages needs update message: ");
            sb.append(messageDTO.getMessageId());
            sb.append(" database id: ");
            sb.append(messageDTO.getDatabaseId());
            Log.w(str2, sb.toString());
            messageDTO.setStatus(0);
            messageDTO.set((RuntimeExceptionDao) this.f8964b);
            C3549b.m10417a(new Message(messageDTO));
        }
    }

    /* renamed from: f */
    public void mo28349f(String str) {
        ArrayList a = mo28330a(1, str);
        a.addAll(mo28330a(0, str));
        Iterator it = a.iterator();
        while (it.hasNext()) {
            MessageDTO messageDTO = (MessageDTO) it.next();
            messageDTO.setStatus(2);
            messageDTO.set((RuntimeExceptionDao) this.f8964b);
            C3549b.m10417a(new Message(messageDTO));
        }
    }

    /* renamed from: b */
    public void mo28342b() {
        try {
            DeleteBuilder deleteBuilder = this.f8964b.deleteBuilder();
            deleteBuilder.where().isNotNull("id");
            String str = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("Delete rows: ");
            sb.append(deleteBuilder.delete());
            Log.i(str, sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long deleteMessages(String str) {
        try {
            DeleteBuilder deleteBuilder = this.f8964b.deleteBuilder();
            deleteBuilder.where().mo27052eq(MessageDTO.CONVERSATION, str);
            int delete = deleteBuilder.delete();
            String str2 = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("Deleted rows: ");
            sb.append(delete);
            Log.d(str2, sb.toString());
            return (long) delete;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void deleteMessages(String str, long j) {
        try {
            DeleteBuilder deleteBuilder = this.f8964b.deleteBuilder();
            deleteBuilder.where().mo27052eq(MessageDTO.CONVERSATION, str);
            String str2 = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("Deleted rows: ");
            sb.append(deleteBuilder.delete());
            Log.d(str2, sb.toString());
        } catch (IndexOutOfBoundsException | SQLException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public Message mo28333a(Context context, Message message) {
        C3457c cVar = new C3457c(mo28313a());
        Message b = mo28341b(message.getMessageId());
        if (cVar.mo28329h(message.getSender()) || b != null) {
            String str = this.f8963a;
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring blocked or duplicate message from: ");
            sb.append(message.getSender());
            Log.w(str, sb.toString());
            return null;
        }
        FriendDTO c = cVar.query_friend_dto_by_id(message.getSender());
        cVar.mo28316a(c, message.getSender(), message.getOtherUserName(), null, context);
        message.setConversation("broadcast.public");
        MessageDTO messageDTO = new MessageDTO(message);
        if (c == null) {
            c = new FriendDTO(message.getSender(), message.getOtherUserName(), null);
            c.set(mo28313a().getFriendRuntimeDAO());
        }
        messageDTO.setFriend(c);
        mo28338a(messageDTO);
        message.setOfflineId(String.valueOf(messageDTO.getDatabaseId()));
        return message;
    }

    /* renamed from: b */
    public void mo28343b(Message message) {
        message.setConversation("broadcast.public");
        MessageDTO messageDTO = new MessageDTO(message);
        try {
            FriendDTO friendDTO = new FriendDTO("broadcast.public", "broadcast.public", null);
            friendDTO.set(mo28313a().getFriendRuntimeDAO());
            messageDTO.setFriend(friendDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mo28338a(messageDTO);
    }
}
