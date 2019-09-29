package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class StatementBuilder<T, ID> {
    private static Logger logger = LoggerFactory.getLogger(StatementBuilder.class);
    protected boolean addTableName;
    protected final Dao<T, ID> dao;
    protected final DatabaseType databaseType;
    protected final TableInfo<T, ID> tableInfo;
    protected final String tableName;
    protected StatementType type;
    protected Where<T, ID> where = null;

    public static class StatementInfo {
        private final List<ArgumentHolder> argList;
        private final String statement;

        private StatementInfo(String str, List<ArgumentHolder> list) {
            this.argList = list;
            this.statement = str;
        }

        public String getStatement() {
            return this.statement;
        }

        public List<ArgumentHolder> getArgList() {
            return this.argList;
        }
    }

    public enum StatementType {
        SELECT(true, true, false, false),
        SELECT_LONG(true, true, false, false),
        SELECT_RAW(true, true, false, false),
        UPDATE(true, false, true, false),
        DELETE(true, false, true, false),
        EXECUTE(false, false, false, true);
        
        private final boolean okForExecute;
        private final boolean okForQuery;
        private final boolean okForStatementBuilder;
        private final boolean okForUpdate;

        private StatementType(boolean z, boolean z2, boolean z3, boolean z4) {
            this.okForStatementBuilder = z;
            this.okForQuery = z2;
            this.okForUpdate = z3;
            this.okForExecute = z4;
        }

        public boolean isOkForStatementBuilder() {
            return this.okForStatementBuilder;
        }

        public boolean isOkForQuery() {
            return this.okForQuery;
        }

        public boolean isOkForUpdate() {
            return this.okForUpdate;
        }

        public boolean isOkForExecute() {
            return this.okForExecute;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) throws SQLException;

    /* access modifiers changed from: protected */
    public abstract void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) throws SQLException;

    /* access modifiers changed from: protected */
    public FieldType[] getResultFieldTypes() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean shouldPrependTableNameToColumns() {
        return false;
    }

    public StatementBuilder(DatabaseType databaseType2, TableInfo<T, ID> tableInfo2, Dao<T, ID> dao2, StatementType statementType) {
        this.databaseType = databaseType2;
        this.tableInfo = tableInfo2;
        this.tableName = tableInfo2.getTableName();
        this.dao = dao2;
        this.type = statementType;
        if (!statementType.isOkForStatementBuilder()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Building a statement from a ");
            sb.append(statementType);
            sb.append(" statement is not allowed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public Where<T, ID> where() {
        this.where = new Where<>(this.tableInfo, this, this.databaseType);
        return this.where;
    }

    public void setWhere(Where<T, ID> where2) {
        this.where = where2;
    }

    /* access modifiers changed from: protected */
    public MappedPreparedStmt<T, ID> prepareStatement(Long l) throws SQLException {
        ArrayList arrayList = new ArrayList();
        String buildStatementString = buildStatementString(arrayList);
        ArgumentHolder[] argumentHolderArr = (ArgumentHolder[]) arrayList.toArray(new ArgumentHolder[arrayList.size()]);
        FieldType[] resultFieldTypes = getResultFieldTypes();
        FieldType[] fieldTypeArr = new FieldType[arrayList.size()];
        for (int i = 0; i < argumentHolderArr.length; i++) {
            fieldTypeArr[i] = argumentHolderArr[i].getFieldType();
        }
        if (this.type.isOkForStatementBuilder()) {
            TableInfo<T, ID> tableInfo2 = this.tableInfo;
            if (this.databaseType.isLimitSqlSupported()) {
                l = null;
            }
            MappedPreparedStmt mappedPreparedStmt = new MappedPreparedStmt(tableInfo2, buildStatementString, fieldTypeArr, resultFieldTypes, argumentHolderArr, l, this.type);
            return mappedPreparedStmt;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Building a statement from a ");
        sb.append(this.type);
        sb.append(" statement is not allowed");
        throw new IllegalStateException(sb.toString());
    }

    public String prepareStatementString() throws SQLException {
        return buildStatementString(new ArrayList());
    }

    public StatementInfo prepareStatementInfo() throws SQLException {
        ArrayList arrayList = new ArrayList();
        return new StatementInfo(buildStatementString(arrayList), arrayList);
    }

    public void clear() {
        this.where = null;
    }

    /* access modifiers changed from: protected */
    public String buildStatementString(List<ArgumentHolder> list) throws SQLException {
        StringBuilder sb = new StringBuilder(128);
        appendStatementString(sb, list);
        String sb2 = sb.toString();
        logger.debug("built statement {}", (Object) sb2);
        return sb2;
    }

    /* access modifiers changed from: protected */
    public void appendStatementString(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendStatementStart(sb, list);
        appendWhereStatement(sb, list, true);
        appendStatementEnd(sb, list);
    }

    /* access modifiers changed from: protected */
    public void appendWhereStatement(StringBuilder sb, List<ArgumentHolder> list, boolean z) throws SQLException {
        if (this.where != null) {
            if (z) {
                sb.append("WHERE ");
            } else {
                sb.append("AND (");
            }
            this.where.appendSql(this.addTableName ? this.tableName : null, sb, list);
            if (!z) {
                sb.append(") ");
            }
        }
    }

    /* access modifiers changed from: protected */
    public FieldType verifyColumnName(String str) {
        return this.tableInfo.getFieldTypeByColumnName(str);
    }

    /* access modifiers changed from: 0000 */
    public StatementType getType() {
        return this.type;
    }
}
