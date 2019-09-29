package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryBuilder<T, ID> extends StatementBuilder<T, ID> {
    private boolean distinct;
    private List<String> groupByList;
    private String groupByRaw;
    private String having;
    private final FieldType idField;
    private boolean isCountOfQuery;
    private boolean isInnerQuery;
    private List<JoinInfo> joinList;
    private Long limit;
    private Long offset;
    private ArgumentHolder[] orderByArgs;
    private List<OrderBy> orderByList;
    private String orderByRaw;
    private FieldType[] resultFieldTypes;
    private List<String> selectColumnList;
    private boolean selectIdColumn = true;
    private List<String> selectRawList;

    public static class InternalQueryBuilderWrapper {
        private final QueryBuilder<?, ?> queryBuilder;

        InternalQueryBuilderWrapper(QueryBuilder<?, ?> queryBuilder2) {
            this.queryBuilder = queryBuilder2;
        }

        public void appendStatementString(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
            this.queryBuilder.appendStatementString(sb, list);
        }

        public FieldType[] getResultFieldTypes() {
            return this.queryBuilder.getResultFieldTypes();
        }
    }

    private class JoinInfo {
        FieldType localField;
        final QueryBuilder<?, ?> queryBuilder;
        FieldType remoteField;
        final String type;

        public JoinInfo(String str, QueryBuilder<?, ?> queryBuilder2) {
            this.type = str;
            this.queryBuilder = queryBuilder2;
        }
    }

    public QueryBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementType.SELECT);
        this.idField = tableInfo.getIdField();
    }

    /* access modifiers changed from: 0000 */
    public void enableInnerQuery() {
        this.isInnerQuery = true;
    }

    /* access modifiers changed from: 0000 */
    public int getSelectColumnCount() {
        if (this.isCountOfQuery) {
            return 1;
        }
        if (this.selectRawList != null && !this.selectRawList.isEmpty()) {
            return this.selectRawList.size();
        }
        if (this.selectColumnList == null) {
            return 0;
        }
        return this.selectColumnList.size();
    }

    /* access modifiers changed from: 0000 */
    public List<String> getSelectColumns() {
        if (this.isCountOfQuery) {
            return Collections.singletonList("COUNT(*)");
        }
        if (this.selectRawList != null && !this.selectRawList.isEmpty()) {
            return this.selectRawList;
        }
        if (this.selectColumnList == null) {
            return Collections.emptyList();
        }
        return this.selectColumnList;
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return super.prepareStatement(this.limit);
    }

    public QueryBuilder<T, ID> selectColumns(String... strArr) {
        if (this.selectColumnList == null) {
            this.selectColumnList = new ArrayList();
        }
        for (String addSelectColumnToList : strArr) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectColumns(Iterable<String> iterable) {
        if (this.selectColumnList == null) {
            this.selectColumnList = new ArrayList();
        }
        for (String addSelectColumnToList : iterable) {
            addSelectColumnToList(addSelectColumnToList);
        }
        return this;
    }

    public QueryBuilder<T, ID> selectRaw(String... strArr) {
        if (this.selectRawList == null) {
            this.selectRawList = new ArrayList();
        }
        for (String add : strArr) {
            this.selectRawList.add(add);
        }
        return this;
    }

    public QueryBuilder<T, ID> groupBy(String str) {
        if (!verifyColumnName(str).isForeignCollection()) {
            if (this.groupByList == null) {
                this.groupByList = new ArrayList();
            }
            this.groupByList.add(str);
            this.selectIdColumn = false;
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't groupBy foreign colletion field: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public QueryBuilder<T, ID> groupByRaw(String str) {
        this.groupByRaw = str;
        return this;
    }

    public QueryBuilder<T, ID> orderBy(String str, boolean z) {
        if (!verifyColumnName(str).isForeignCollection()) {
            if (this.orderByList == null) {
                this.orderByList = new ArrayList();
            }
            this.orderByList.add(new OrderBy(str, z));
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't orderBy foreign colletion field: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public QueryBuilder<T, ID> orderByRaw(String str) {
        return orderByRaw(str, null);
    }

    public QueryBuilder<T, ID> orderByRaw(String str, ArgumentHolder... argumentHolderArr) {
        this.orderByRaw = str;
        this.orderByArgs = argumentHolderArr;
        return this;
    }

    public QueryBuilder<T, ID> distinct() {
        this.distinct = true;
        this.selectIdColumn = false;
        return this;
    }

    @Deprecated
    public QueryBuilder<T, ID> limit(int i) {
        return limit(Long.valueOf((long) i));
    }

    public QueryBuilder<T, ID> limit(Long l) {
        this.limit = l;
        return this;
    }

    @Deprecated
    public QueryBuilder<T, ID> offset(int i) throws SQLException {
        return offset(Long.valueOf((long) i));
    }

    public QueryBuilder<T, ID> offset(Long l) throws SQLException {
        if (this.databaseType.isOffsetSqlSupported()) {
            this.offset = l;
            return this;
        }
        throw new SQLException("Offset is not supported by this database");
    }

    public QueryBuilder<T, ID> setCountOf(boolean z) {
        this.isCountOfQuery = z;
        return this;
    }

    public QueryBuilder<T, ID> having(String str) {
        this.having = str;
        return this;
    }

    public QueryBuilder<T, ID> join(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo("INNER", queryBuilder);
        return this;
    }

    public QueryBuilder<T, ID> leftJoin(QueryBuilder<?, ?> queryBuilder) throws SQLException {
        addJoinInfo("LEFT", queryBuilder);
        return this;
    }

    public List<T> query() throws SQLException {
        return this.dao.query(prepare());
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return this.dao.queryRaw(prepareStatementString(), new String[0]);
    }

    public T queryForFirst() throws SQLException {
        return this.dao.queryForFirst(prepare());
    }

    public String[] queryRawFirst() throws SQLException {
        return (String[]) this.dao.queryRaw(prepareStatementString(), new String[0]).getFirstResult();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return this.dao.iterator(prepare());
    }

    public long countOf() throws SQLException {
        setCountOf(true);
        return this.dao.countOf(prepare());
    }

    public void clear() {
        super.clear();
        this.distinct = false;
        this.selectIdColumn = true;
        this.selectColumnList = null;
        this.selectRawList = null;
        this.orderByList = null;
        this.orderByRaw = null;
        this.groupByList = null;
        this.groupByRaw = null;
        this.isInnerQuery = false;
        this.isCountOfQuery = false;
        this.having = null;
        this.limit = null;
        this.offset = null;
        if (this.joinList != null) {
            this.joinList.clear();
            this.joinList = null;
        }
        this.addTableName = false;
    }

    /* access modifiers changed from: protected */
    public void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) {
        if (this.joinList == null) {
            setAddTableName(false);
        } else {
            setAddTableName(true);
        }
        sb.append("SELECT ");
        if (this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        if (this.distinct) {
            sb.append("DISTINCT ");
        }
        if (this.isCountOfQuery) {
            this.type = StatementType.SELECT_LONG;
            sb.append("COUNT(*) ");
        } else if (this.selectRawList == null || this.selectRawList.isEmpty()) {
            this.type = StatementType.SELECT;
            appendColumns(sb);
        } else {
            this.type = StatementType.SELECT_RAW;
            appendSelectRaw(sb);
        }
        sb.append("FROM ");
        this.databaseType.appendEscapedEntityName(sb, this.tableName);
        sb.append(' ');
        if (this.joinList != null) {
            appendJoinSql(sb);
        }
    }

    /* access modifiers changed from: protected */
    public FieldType[] getResultFieldTypes() {
        return this.resultFieldTypes;
    }

    /* access modifiers changed from: protected */
    public void appendWhereStatement(StringBuilder sb, List<ArgumentHolder> list, boolean z) throws SQLException {
        if (this.where != null) {
            super.appendWhereStatement(sb, list, z);
            z = false;
        }
        if (this.joinList != null) {
            for (JoinInfo joinInfo : this.joinList) {
                joinInfo.queryBuilder.appendWhereStatement(sb, list, z);
                z = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendGroupBys(sb);
        appendHaving(sb);
        appendOrderBys(sb, list);
        if (!this.databaseType.isLimitAfterSelect()) {
            appendLimit(sb);
        }
        appendOffset(sb);
        setAddTableName(false);
    }

    /* access modifiers changed from: protected */
    public boolean shouldPrependTableNameToColumns() {
        return this.joinList != null;
    }

    private void setAddTableName(boolean z) {
        this.addTableName = z;
        if (this.joinList != null) {
            for (JoinInfo joinInfo : this.joinList) {
                joinInfo.queryBuilder.setAddTableName(z);
            }
        }
    }

    private void addJoinInfo(String str, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        JoinInfo joinInfo = new JoinInfo(str, queryBuilder);
        matchJoinedFields(joinInfo, queryBuilder);
        if (this.joinList == null) {
            this.joinList = new ArrayList();
        }
        this.joinList.add(joinInfo);
    }

    private void matchJoinedFields(JoinInfo joinInfo, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            FieldType fieldType = fieldTypes[i2];
            FieldType foreignIdField = fieldType.getForeignIdField();
            if (!fieldType.isForeign() || !foreignIdField.equals(queryBuilder.tableInfo.getIdField())) {
                i2++;
            } else {
                joinInfo.localField = fieldType;
                joinInfo.remoteField = foreignIdField;
                return;
            }
        }
        FieldType[] fieldTypes2 = queryBuilder.tableInfo.getFieldTypes();
        int length2 = fieldTypes2.length;
        while (i < length2) {
            FieldType fieldType2 = fieldTypes2[i];
            if (!fieldType2.isForeign() || !fieldType2.getForeignIdField().equals(this.idField)) {
                i++;
            } else {
                joinInfo.localField = this.idField;
                joinInfo.remoteField = fieldType2;
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find a foreign ");
        sb.append(this.tableInfo.getDataClass());
        sb.append(" field in ");
        sb.append(queryBuilder.tableInfo.getDataClass());
        sb.append(" or vice versa");
        throw new SQLException(sb.toString());
    }

    private void addSelectColumnToList(String str) {
        verifyColumnName(str);
        this.selectColumnList.add(str);
    }

    private void appendJoinSql(StringBuilder sb) {
        for (JoinInfo joinInfo : this.joinList) {
            sb.append(joinInfo.type);
            sb.append(" JOIN ");
            this.databaseType.appendEscapedEntityName(sb, joinInfo.queryBuilder.tableName);
            sb.append(" ON ");
            this.databaseType.appendEscapedEntityName(sb, this.tableName);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, joinInfo.localField.getColumnName());
            sb.append(" = ");
            this.databaseType.appendEscapedEntityName(sb, joinInfo.queryBuilder.tableName);
            sb.append('.');
            this.databaseType.appendEscapedEntityName(sb, joinInfo.remoteField.getColumnName());
            sb.append(' ');
            if (joinInfo.queryBuilder.joinList != null) {
                joinInfo.queryBuilder.appendJoinSql(sb);
            }
        }
    }

    private void appendSelectRaw(StringBuilder sb) {
        boolean z = true;
        for (String str : this.selectRawList) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    private void appendColumns(StringBuilder sb) {
        if (this.selectColumnList == null) {
            if (this.addTableName) {
                this.databaseType.appendEscapedEntityName(sb, this.tableName);
                sb.append('.');
            }
            sb.append("* ");
            this.resultFieldTypes = this.tableInfo.getFieldTypes();
            return;
        }
        boolean z = this.isInnerQuery;
        ArrayList arrayList = new ArrayList(this.selectColumnList.size() + 1);
        boolean z2 = true;
        for (String fieldTypeByColumnName : this.selectColumnList) {
            FieldType fieldTypeByColumnName2 = this.tableInfo.getFieldTypeByColumnName(fieldTypeByColumnName);
            if (fieldTypeByColumnName2.isForeignCollection()) {
                arrayList.add(fieldTypeByColumnName2);
            } else {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(',');
                }
                appendFieldColumnName(sb, fieldTypeByColumnName2, arrayList);
                if (fieldTypeByColumnName2 == this.idField) {
                    z = true;
                }
            }
        }
        if (!z && this.selectIdColumn) {
            if (!z2) {
                sb.append(',');
            }
            appendFieldColumnName(sb, this.idField, arrayList);
        }
        sb.append(' ');
        this.resultFieldTypes = (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
    }

    private void appendFieldColumnName(StringBuilder sb, FieldType fieldType, List<FieldType> list) {
        appendColumnName(sb, fieldType.getColumnName());
        if (list != null) {
            list.add(fieldType);
        }
    }

    private void appendLimit(StringBuilder sb) {
        if (this.limit != null && this.databaseType.isLimitSqlSupported()) {
            this.databaseType.appendLimitValue(sb, this.limit.longValue(), this.offset);
        }
    }

    private void appendOffset(StringBuilder sb) throws SQLException {
        if (this.offset != null) {
            if (!this.databaseType.isOffsetLimitArgument()) {
                this.databaseType.appendOffsetValue(sb, this.offset.longValue());
            } else if (this.limit == null) {
                throw new SQLException("If the offset is specified, limit must also be specified with this database");
            }
        }
    }

    private void appendGroupBys(StringBuilder sb) {
        boolean z = true;
        if (hasGroupStuff()) {
            appendGroupBys(sb, true);
            z = false;
        }
        if (this.joinList != null) {
            for (JoinInfo joinInfo : this.joinList) {
                if (joinInfo.queryBuilder != null && joinInfo.queryBuilder.hasGroupStuff()) {
                    joinInfo.queryBuilder.appendGroupBys(sb, z);
                }
            }
        }
    }

    private boolean hasGroupStuff() {
        return (this.groupByList != null && !this.groupByList.isEmpty()) || this.groupByRaw != null;
    }

    private void appendGroupBys(StringBuilder sb, boolean z) {
        if (z) {
            sb.append("GROUP BY ");
        }
        if (this.groupByRaw != null) {
            if (!z) {
                sb.append(',');
            }
            sb.append(this.groupByRaw);
        } else {
            for (String str : this.groupByList) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                appendColumnName(sb, str);
            }
        }
        sb.append(' ');
    }

    private void appendOrderBys(StringBuilder sb, List<ArgumentHolder> list) {
        boolean z = true;
        if (hasOrderStuff()) {
            appendOrderBys(sb, true, list);
            z = false;
        }
        if (this.joinList != null) {
            for (JoinInfo joinInfo : this.joinList) {
                if (joinInfo.queryBuilder != null && joinInfo.queryBuilder.hasOrderStuff()) {
                    joinInfo.queryBuilder.appendOrderBys(sb, z, list);
                }
            }
        }
    }

    private boolean hasOrderStuff() {
        return (this.orderByList != null && !this.orderByList.isEmpty()) || this.orderByRaw != null;
    }

    private void appendOrderBys(StringBuilder sb, boolean z, List<ArgumentHolder> list) {
        if (z) {
            sb.append("ORDER BY ");
        }
        if (this.orderByRaw != null) {
            if (!z) {
                sb.append(',');
            }
            sb.append(this.orderByRaw);
            if (this.orderByArgs != null) {
                for (ArgumentHolder add : this.orderByArgs) {
                    list.add(add);
                }
            }
        } else {
            for (OrderBy orderBy : this.orderByList) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                appendColumnName(sb, orderBy.getColumnName());
                if (!orderBy.isAscending()) {
                    sb.append(" DESC");
                }
            }
        }
        sb.append(' ');
    }

    private void appendColumnName(StringBuilder sb, String str) {
        if (this.addTableName) {
            this.databaseType.appendEscapedEntityName(sb, this.tableName);
            sb.append('.');
        }
        this.databaseType.appendEscapedEntityName(sb, str);
    }

    private void appendHaving(StringBuilder sb) {
        if (this.having != null) {
            sb.append("HAVING ");
            sb.append(this.having);
            sb.append(' ');
        }
    }
}
