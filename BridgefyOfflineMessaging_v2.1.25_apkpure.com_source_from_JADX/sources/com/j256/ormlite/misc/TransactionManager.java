package com.j256.ormlite.misc;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager() {
    }

    public TransactionManager(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
        initialize();
    }

    public void initialize() {
        if (this.connectionSource == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("dataSource was not set on ");
            sb.append(getClass().getSimpleName());
            throw new IllegalStateException(sb.toString());
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return callInTransaction(this.connectionSource, callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource2, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource2.getReadWriteConnection();
        try {
            return callInTransaction(readWriteConnection, connectionSource2.saveSpecialConnection(readWriteConnection), connectionSource2.getDatabaseType(), callable);
        } finally {
            connectionSource2.clearSpecialConnection(readWriteConnection);
            connectionSource2.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:33|34|35|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:41|42|43|44) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0090 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[Catch:{ SQLException -> 0x0089, Exception -> 0x0074, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0090=Splitter:B:43:0x0090, B:35:0x007b=Splitter:B:35:0x007b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T callInTransaction(com.j256.ormlite.support.DatabaseConnection r4, boolean r5, com.j256.ormlite.p127db.DatabaseType r6, java.util.concurrent.Callable<T> r7) throws java.sql.SQLException {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L_0x0011
            boolean r5 = r6.isNestedSavePointsSupported()     // Catch:{ all -> 0x000e }
            if (r5 == 0) goto L_0x000c
            goto L_0x0011
        L_0x000c:
            r5 = 0
            goto L_0x005a
        L_0x000e:
            r5 = move-exception
            goto L_0x0098
        L_0x0011:
            boolean r5 = r4.isAutoCommitSupported()     // Catch:{ all -> 0x000e }
            if (r5 == 0) goto L_0x0028
            boolean r5 = r4.isAutoCommit()     // Catch:{ all -> 0x000e }
            if (r5 == 0) goto L_0x0027
            r4.setAutoCommit(r2)     // Catch:{ all -> 0x0070 }
            com.j256.ormlite.logger.Logger r6 = logger     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = "had to set auto-commit to false"
            r6.debug(r0)     // Catch:{ all -> 0x0070 }
        L_0x0027:
            r2 = r5
        L_0x0028:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r5.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r6 = "ORMLITE"
            r5.append(r6)     // Catch:{ all -> 0x000e }
            java.util.concurrent.atomic.AtomicInteger r6 = savePointCounter     // Catch:{ all -> 0x000e }
            int r6 = r6.incrementAndGet()     // Catch:{ all -> 0x000e }
            r5.append(r6)     // Catch:{ all -> 0x000e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x000e }
            java.sql.Savepoint r0 = r4.setSavePoint(r5)     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x004d
            com.j256.ormlite.logger.Logger r5 = logger     // Catch:{ all -> 0x000e }
            java.lang.String r6 = "started savePoint transaction"
            r5.debug(r6)     // Catch:{ all -> 0x000e }
            goto L_0x0058
        L_0x004d:
            com.j256.ormlite.logger.Logger r5 = logger     // Catch:{ all -> 0x000e }
            java.lang.String r6 = "started savePoint transaction {}"
            java.lang.String r3 = r0.getSavepointName()     // Catch:{ all -> 0x000e }
            r5.debug(r6, r3)     // Catch:{ all -> 0x000e }
        L_0x0058:
            r5 = r2
            r2 = 1
        L_0x005a:
            java.lang.Object r6 = r7.call()     // Catch:{ SQLException -> 0x0089, Exception -> 0x0074 }
            if (r2 == 0) goto L_0x0063
            commit(r4, r0)     // Catch:{ SQLException -> 0x0089, Exception -> 0x0074 }
        L_0x0063:
            if (r5 == 0) goto L_0x006f
            r4.setAutoCommit(r1)
            com.j256.ormlite.logger.Logger r4 = logger
            java.lang.String r5 = "restored auto-commit to true"
            r4.debug(r5)
        L_0x006f:
            return r6
        L_0x0070:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L_0x0098
        L_0x0074:
            r6 = move-exception
            if (r2 == 0) goto L_0x0082
            rollBack(r4, r0)     // Catch:{ SQLException -> 0x007b }
            goto L_0x0082
        L_0x007b:
            com.j256.ormlite.logger.Logger r7 = logger     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = "after commit exception, rolling back to save-point also threw exception"
            r7.error(r6, r0)     // Catch:{ all -> 0x0070 }
        L_0x0082:
            java.lang.String r7 = "Transaction callable threw non-SQL exception"
            java.sql.SQLException r6 = com.j256.ormlite.misc.SqlExceptionUtil.create(r7, r6)     // Catch:{ all -> 0x0070 }
            throw r6     // Catch:{ all -> 0x0070 }
        L_0x0089:
            r6 = move-exception
            if (r2 == 0) goto L_0x0097
            rollBack(r4, r0)     // Catch:{ SQLException -> 0x0090 }
            goto L_0x0097
        L_0x0090:
            com.j256.ormlite.logger.Logger r7 = logger     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = "after commit exception, rolling back to save-point also threw exception"
            r7.error(r6, r0)     // Catch:{ all -> 0x0070 }
        L_0x0097:
            throw r6     // Catch:{ all -> 0x0070 }
        L_0x0098:
            if (r2 == 0) goto L_0x00a4
            r4.setAutoCommit(r1)
            com.j256.ormlite.logger.Logger r4 = logger
            java.lang.String r6 = "restored auto-commit to true"
            r4.debug(r6)
        L_0x00a4:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.misc.TransactionManager.callInTransaction(com.j256.ormlite.support.DatabaseConnection, boolean, com.j256.ormlite.db.DatabaseType, java.util.concurrent.Callable):java.lang.Object");
    }

    public void setConnectionSource(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", (Object) savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", (Object) savepointName);
        }
    }
}
