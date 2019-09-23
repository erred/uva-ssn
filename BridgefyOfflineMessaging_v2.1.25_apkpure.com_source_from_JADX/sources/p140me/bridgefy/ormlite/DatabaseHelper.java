package p140me.bridgefy.ormlite;

import android.content.Context;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.entities.ConversationProcessingDTO;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.ormlite.entities.MessageDTO;

/* renamed from: me.bridgefy.ormlite.DatabaseHelper */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String DATABASE_NAME = "bridgefy.db";
    public static final int DATABASE_VERSION = 10;
    private static final String PASS = BridgefyApp.m10557c().getSharedPreferences("BgfyPrefs", 0).getString("database_password", "");
    private static final String TAG = "DatabaseHelper";
    private Context context;
    private Dao<ConversationProcessingDTO, Long> conversationProcessingDAO = null;
    private RuntimeExceptionDao<ConversationProcessingDTO, Long> conversationProcessingRuntimeDAO = null;
    private Dao<FriendDTO, String> friendDAO = null;
    private RuntimeExceptionDao<FriendDTO, String> friendRuntimeDAO = null;
    private Dao<MessageDTO, Long> messageDAO = null;
    private RuntimeExceptionDao<MessageDTO, String> messageRuntimeDAO = null;

    public DatabaseHelper(Context context2) {
        super(context2, DATABASE_NAME, null, 10, PASS);
        this.context = context2;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, MessageDTO.class);
            Log.v(TAG, "Create bgf_message");
            TableUtils.createTable(connectionSource, FriendDTO.class);
            Log.v(TAG, "Create bgf_friend");
            TableUtils.createTable(connectionSource, ConversationProcessingDTO.class);
            Log.v(TAG, "Create conversation_processing");
        } catch (SQLException e) {
            Log.e(TAG, "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        r4.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ce, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        deleteAllTables(r5);
        onCreate(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d6, code lost:
        deleteAllTables(r5);
        onCreate(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dd, code lost:
        deleteAllTables(r5);
        onCreate(r4, r5);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:2:0x0021, B:31:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpgrade(net.sqlcipher.database.SQLiteDatabase r4, com.j256.ormlite.support.ConnectionSource r5, int r6, int r7) {
        /*
            r3 = this;
            java.lang.String r0 = "DatabaseHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onUpgrade, oldVersion= "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = ", newVersion= "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            r0 = 1
            if (r7 != r0) goto L_0x0025
            r3.onCreate(r4, r5)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            return
        L_0x0025:
            r1 = 0
        L_0x0026:
            int r6 = r6 + r0
            if (r6 > r7) goto L_0x006e
            switch(r6) {
                case 2: goto L_0x006a;
                case 3: goto L_0x0062;
                case 4: goto L_0x005a;
                case 5: goto L_0x0053;
                case 6: goto L_0x004c;
                case 7: goto L_0x0045;
                case 8: goto L_0x003d;
                case 9: goto L_0x0035;
                case 10: goto L_0x002d;
                default: goto L_0x002c;
            }     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
        L_0x002c:
            goto L_0x0026
        L_0x002d:
            if (r1 != 0) goto L_0x0026
            r2 = 10
            p140me.bridgefy.ormlite.UpgradeHelper.addUpgrade(r2)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x0035:
            if (r1 != 0) goto L_0x0026
            r2 = 9
            p140me.bridgefy.ormlite.UpgradeHelper.addUpgrade(r2)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x003d:
            if (r1 != 0) goto L_0x0026
            r2 = 8
            p140me.bridgefy.ormlite.UpgradeHelper.addUpgrade(r2)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x0045:
            if (r1 != 0) goto L_0x0026
            r2 = 7
            p140me.bridgefy.ormlite.UpgradeHelper.addUpgrade(r2)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x004c:
            if (r1 != 0) goto L_0x0026
            r2 = 6
            p140me.bridgefy.ormlite.UpgradeHelper.addUpgrade(r2)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x0053:
            if (r1 != 0) goto L_0x0026
            r2 = 5
            p140me.bridgefy.ormlite.UpgradeHelper.addUpgrade(r2)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x005a:
            if (r1 != 0) goto L_0x0026
            java.lang.Class<me.bridgefy.ormlite.entities.ConversationProcessingDTO> r2 = p140me.bridgefy.ormlite.entities.ConversationProcessingDTO.class
            com.j256.ormlite.table.TableUtils.createTableIfNotExists(r5, r2)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x0062:
            r3.deleteAllTables(r5)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            r3.onCreate(r4, r5)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            r1 = 1
            goto L_0x0026
        L_0x006a:
            r3.deleteAllTables(r5)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x0026
        L_0x006e:
            android.content.Context r6 = r3.context     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.util.List r6 = p140me.bridgefy.ormlite.UpgradeHelper.availableUpdates(r6)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.lang.String r7 = "DatabaseHelper"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            r0.<init>()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.lang.String r1 = "Found a total of "
            r0.append(r1)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            int r1 = r6.size()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            r0.append(r1)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.lang.String r1 = " update statements"
            r0.append(r1)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.lang.String r0 = r0.toString()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            android.util.Log.d(r7, r0)     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
        L_0x009b:
            boolean r7 = r6.hasNext()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            if (r7 == 0) goto L_0x00e3
            java.lang.Object r7 = r6.next()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            r4.beginTransaction()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            java.lang.String r0 = "DatabaseHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r1.<init>()     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = "Executing statement: "
            r1.append(r2)     // Catch:{ all -> 0x00ca }
            r1.append(r7)     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ca }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00ca }
            r4.execSQL(r7)     // Catch:{ all -> 0x00ca }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x00ca }
            r4.endTransaction()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            goto L_0x009b
        L_0x00ca:
            r6 = move-exception
            r4.endTransaction()     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
            throw r6     // Catch:{ SQLException -> 0x00dd, SQLException -> 0x00d6, Exception -> 0x00cf }
        L_0x00cf:
            r3.deleteAllTables(r5)
            r3.onCreate(r4, r5)
            goto L_0x00e3
        L_0x00d6:
            r3.deleteAllTables(r5)
            r3.onCreate(r4, r5)
            goto L_0x00e3
        L_0x00dd:
            r3.deleteAllTables(r5)
            r3.onCreate(r4, r5)
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.ormlite.DatabaseHelper.onUpgrade(net.sqlcipher.database.SQLiteDatabase, com.j256.ormlite.support.ConnectionSource, int, int):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|(1:4)|5|6|(1:8)|9|10|(2:12|14)(1:16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0012 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0023 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f A[Catch:{ Exception -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e A[Catch:{ Exception -> 0x0023 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void deleteAllTables(com.j256.ormlite.support.ConnectionSource r4) {
        /*
            r3 = this;
            r0 = 1
            com.j256.ormlite.support.DatabaseConnection r1 = r4.getReadOnlyConnection()     // Catch:{ Exception -> 0x0012 }
            java.lang.String r2 = "bgf_message"
            boolean r1 = r1.isTableExists(r2)     // Catch:{ Exception -> 0x0012 }
            if (r1 == 0) goto L_0x0012
            java.lang.Class<me.bridgefy.ormlite.entities.MessageDTO> r1 = p140me.bridgefy.ormlite.entities.MessageDTO.class
            com.j256.ormlite.table.TableUtils.dropTable(r4, r1, r0)     // Catch:{ Exception -> 0x0012 }
        L_0x0012:
            com.j256.ormlite.support.DatabaseConnection r1 = r4.getReadOnlyConnection()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = "bgf_friend"
            boolean r1 = r1.isTableExists(r2)     // Catch:{ Exception -> 0x0023 }
            if (r1 == 0) goto L_0x0023
            java.lang.Class<me.bridgefy.ormlite.entities.FriendDTO> r1 = p140me.bridgefy.ormlite.entities.FriendDTO.class
            com.j256.ormlite.table.TableUtils.dropTable(r4, r1, r0)     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            com.j256.ormlite.support.DatabaseConnection r1 = r4.getReadOnlyConnection()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = "conversation_processing"
            boolean r1 = r1.isTableExists(r2)     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0034
            java.lang.Class<me.bridgefy.ormlite.entities.ConversationProcessingDTO> r1 = p140me.bridgefy.ormlite.entities.ConversationProcessingDTO.class
            com.j256.ormlite.table.TableUtils.dropTable(r4, r1, r0)     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.ormlite.DatabaseHelper.deleteAllTables(com.j256.ormlite.support.ConnectionSource):void");
    }

    public Dao<MessageDTO, Long> getMessageDAO() throws SQLException {
        if (this.messageDAO == null) {
            this.messageDAO = getDao(MessageDTO.class);
        }
        return this.messageDAO;
    }

    public RuntimeExceptionDao<MessageDTO, String> getMessageRuntimeDAO() {
        if (this.messageRuntimeDAO == null) {
            this.messageRuntimeDAO = getRuntimeExceptionDao(MessageDTO.class);
        }
        return this.messageRuntimeDAO;
    }

    public Dao<FriendDTO, String> getFriendDAO() throws SQLException {
        if (this.friendDAO == null) {
            this.friendDAO = getDao(FriendDTO.class);
        }
        return this.friendDAO;
    }

    public RuntimeExceptionDao<FriendDTO, String> getFriendRuntimeDAO() {
        if (this.friendRuntimeDAO == null) {
            this.friendRuntimeDAO = getRuntimeExceptionDao(FriendDTO.class);
        }
        return this.friendRuntimeDAO;
    }

    public Dao<ConversationProcessingDTO, Long> getConversationProcessingDAO() throws SQLException {
        if (this.conversationProcessingDAO == null) {
            this.conversationProcessingDAO = getDao(ConversationProcessingDTO.class);
        }
        return this.conversationProcessingDAO;
    }

    public RuntimeExceptionDao<ConversationProcessingDTO, Long> getConversationProcessingRuntimeDAO() {
        if (this.conversationProcessingRuntimeDAO == null) {
            this.conversationProcessingRuntimeDAO = getRuntimeExceptionDao(ConversationProcessingDTO.class);
        }
        return this.conversationProcessingRuntimeDAO;
    }

    public void close() {
        super.close();
        this.messageDAO = null;
        this.messageRuntimeDAO = null;
        this.friendDAO = null;
        this.friendRuntimeDAO = null;
    }

    public void clearDataBase() {
        try {
            TableUtils.clearTable(getConnectionSource(), MessageDTO.class);
            TableUtils.clearTable(getConnectionSource(), FriendDTO.class);
            TableUtils.clearTable(getConnectionSource(), ConversationProcessingDTO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTables() {
        onCreate(null, this.connectionSource);
    }
}
