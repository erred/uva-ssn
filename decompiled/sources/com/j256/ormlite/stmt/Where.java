package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.stmt.QueryBuilder.InternalQueryBuilderWrapper;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.C2956In;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Where<T, ID> {
    private static final int START_CLAUSE_SIZE = 4;
    private Clause[] clauseStack = new Clause[4];
    private int clauseStackLevel = 0;
    private final DatabaseType databaseType;
    private final String idColumnName;
    private final FieldType idFieldType;
    private NeedsFutureClause needsFuture = null;
    private final StatementBuilder<T, ID> statementBuilder;
    private final TableInfo<T, ID> tableInfo;

    Where(TableInfo<T, ID> tableInfo2, StatementBuilder<T, ID> statementBuilder2, DatabaseType databaseType2) {
        this.tableInfo = tableInfo2;
        this.statementBuilder = statementBuilder2;
        this.idFieldType = tableInfo2.getIdField();
        if (this.idFieldType == null) {
            this.idColumnName = null;
        } else {
            this.idColumnName = this.idFieldType.getColumnName();
        }
        this.databaseType = databaseType2;
    }

    public Where<T, ID> and() {
        addNeedsFuture(new ManyClause(pop(ManyClause.AND_OPERATION), ManyClause.AND_OPERATION));
        return this;
    }

    public Where<T, ID> and(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] buildClauseArray = buildClauseArray(whereArr, ManyClause.AND_OPERATION);
        addClause(new ManyClause(pop(ManyClause.AND_OPERATION), pop(ManyClause.AND_OPERATION), buildClauseArray, ManyClause.AND_OPERATION));
        return this;
    }

    public Where<T, ID> and(int i) {
        if (i != 0) {
            Clause[] clauseArr = new Clause[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                clauseArr[i2] = pop(ManyClause.AND_OPERATION);
            }
            addClause(new ManyClause(clauseArr, ManyClause.AND_OPERATION));
            return this;
        }
        throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
    }

    public Where<T, ID> between(String str, Object obj, Object obj2) throws SQLException {
        addClause(new Between(str, findColumnFieldType(str), obj, obj2));
        return this;
    }

    /* renamed from: eq */
    public Where<T, ID> mo27052eq(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.EQUAL_TO_OPERATION));
        return this;
    }

    /* renamed from: ge */
    public Where<T, ID> mo27054ge(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    /* renamed from: gt */
    public Where<T, ID> mo27056gt(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.GREATER_THAN_OPERATION));
        return this;
    }

    /* renamed from: in */
    public Where<T, ID> mo27060in(String str, Iterable<?> iterable) throws SQLException {
        addClause(new C2956In(str, findColumnFieldType(str), iterable, true));
        return this;
    }

    public Where<T, ID> notIn(String str, Iterable<?> iterable) throws SQLException {
        addClause(new C2956In(str, findColumnFieldType(str), iterable, false));
        return this;
    }

    /* renamed from: in */
    public Where<T, ID> mo27061in(String str, Object... objArr) throws SQLException {
        return m8767in(true, str, objArr);
    }

    public Where<T, ID> notIn(String str, Object... objArr) throws SQLException {
        return m8767in(false, str, objArr);
    }

    /* renamed from: in */
    public Where<T, ID> mo27059in(String str, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        return m8766in(true, str, queryBuilder);
    }

    public Where<T, ID> notIn(String str, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        return m8766in(false, str, queryBuilder);
    }

    public Where<T, ID> exists(QueryBuilder<?, ?> queryBuilder) {
        queryBuilder.enableInnerQuery();
        addClause(new Exists(new InternalQueryBuilderWrapper(queryBuilder)));
        return this;
    }

    public Where<T, ID> isNull(String str) throws SQLException {
        addClause(new IsNull(str, findColumnFieldType(str)));
        return this;
    }

    public Where<T, ID> isNotNull(String str) throws SQLException {
        addClause(new IsNotNull(str, findColumnFieldType(str)));
        return this;
    }

    /* renamed from: le */
    public Where<T, ID> mo27065le(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    /* renamed from: lt */
    public Where<T, ID> mo27067lt(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LESS_THAN_OPERATION));
        return this;
    }

    public Where<T, ID> like(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LIKE_OPERATION));
        return this;
    }

    /* renamed from: ne */
    public Where<T, ID> mo27068ne(String str, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.NOT_EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> not() {
        addNeedsFuture(new Not());
        return this;
    }

    public Where<T, ID> not(Where<T, ID> where) {
        addClause(new Not(pop("NOT")));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> mo27074or() {
        addNeedsFuture(new ManyClause(pop(ManyClause.OR_OPERATION), ManyClause.OR_OPERATION));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> mo27076or(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] buildClauseArray = buildClauseArray(whereArr, ManyClause.OR_OPERATION);
        addClause(new ManyClause(pop(ManyClause.OR_OPERATION), pop(ManyClause.OR_OPERATION), buildClauseArray, ManyClause.OR_OPERATION));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> mo27075or(int i) {
        if (i != 0) {
            Clause[] clauseArr = new Clause[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                clauseArr[i2] = pop(ManyClause.OR_OPERATION);
            }
            addClause(new ManyClause(clauseArr, ManyClause.OR_OPERATION));
            return this;
        }
        throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
    }

    public Where<T, ID> idEq(ID id) throws SQLException {
        if (this.idColumnName != null) {
            addClause(new SimpleComparison(this.idColumnName, this.idFieldType, id, SimpleComparison.EQUAL_TO_OPERATION));
            return this;
        }
        throw new SQLException("Object has no id column specified");
    }

    public <OD> Where<T, ID> idEq(Dao<OD, ?> dao, OD od) throws SQLException {
        if (this.idColumnName != null) {
            addClause(new SimpleComparison(this.idColumnName, this.idFieldType, dao.extractId(od), SimpleComparison.EQUAL_TO_OPERATION));
            return this;
        }
        throw new SQLException("Object has no id column specified");
    }

    public Where<T, ID> raw(String str, ArgumentHolder... argumentHolderArr) {
        for (ArgumentHolder argumentHolder : argumentHolderArr) {
            String columnName = argumentHolder.getColumnName();
            if (columnName != null) {
                argumentHolder.setMetaInfo(findColumnFieldType(columnName));
            } else if (argumentHolder.getSqlType() == null) {
                throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument");
            }
        }
        addClause(new Raw(str, argumentHolderArr));
        return this;
    }

    public Where<T, ID> rawComparison(String str, String str2, Object obj) throws SQLException {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, str2));
        return this;
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return this.statementBuilder.prepareStatement(null);
    }

    public List<T> query() throws SQLException {
        return checkQueryBuilderMethod("query()").query();
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return checkQueryBuilderMethod("queryRaw()").queryRaw();
    }

    public T queryForFirst() throws SQLException {
        return checkQueryBuilderMethod("queryForFirst()").queryForFirst();
    }

    public String[] queryRawFirst() throws SQLException {
        return checkQueryBuilderMethod("queryRawFirst()").queryRawFirst();
    }

    public long countOf() throws SQLException {
        return checkQueryBuilderMethod("countOf()").countOf();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return checkQueryBuilderMethod("iterator()").iterator();
    }

    public Where<T, ID> clear() {
        for (int i = 0; i < this.clauseStackLevel; i++) {
            this.clauseStack[i] = null;
        }
        this.clauseStackLevel = 0;
        return this;
    }

    public String getStatement() throws SQLException {
        StringBuilder sb = new StringBuilder();
        appendSql(null, sb, new ArrayList());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public void appendSql(String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        if (this.clauseStackLevel == 0) {
            throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
        } else if (this.clauseStackLevel == 1) {
            peek().appendSql(this.databaseType, str, sb, list);
        } else {
            throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
        }
    }

    public String toString() {
        if (this.clauseStackLevel == 0) {
            return "empty where clause";
        }
        Clause peek = peek();
        StringBuilder sb = new StringBuilder();
        sb.append("where clause: ");
        sb.append(peek);
        return sb.toString();
    }

    private QueryBuilder<T, ID> checkQueryBuilderMethod(String str) throws SQLException {
        if (this.statementBuilder instanceof QueryBuilder) {
            return (QueryBuilder) this.statementBuilder;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call ");
        sb.append(str);
        sb.append(" on a statement of type ");
        sb.append(this.statementBuilder.getType());
        throw new SQLException(sb.toString());
    }

    /* renamed from: in */
    private Where<T, ID> m8767in(boolean z, String str, Object... objArr) throws SQLException {
        if (objArr.length == 1) {
            if (objArr[0].getClass().isArray()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Object argument to ");
                sb.append(z ? "IN" : "notId");
                sb.append(" seems to be an array within an array");
                throw new IllegalArgumentException(sb.toString());
            } else if (objArr[0] instanceof Where) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Object argument to ");
                sb2.append(z ? "IN" : "notId");
                sb2.append(" seems to be a Where object, did you mean the QueryBuilder?");
                throw new IllegalArgumentException(sb2.toString());
            } else if (objArr[0] instanceof PreparedStmt) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Object argument to ");
                sb3.append(z ? "IN" : "notId");
                sb3.append(" seems to be a prepared statement, did you mean the QueryBuilder?");
                throw new IllegalArgumentException(sb3.toString());
            }
        }
        addClause(new C2956In(str, findColumnFieldType(str), objArr, z));
        return this;
    }

    /* renamed from: in */
    private Where<T, ID> m8766in(boolean z, String str, QueryBuilder<?, ?> queryBuilder) throws SQLException {
        if (queryBuilder.getSelectColumnCount() == 1) {
            queryBuilder.enableInnerQuery();
            addClause(new InSubQuery(str, findColumnFieldType(str), new InternalQueryBuilderWrapper(queryBuilder), z));
            return this;
        } else if (queryBuilder.getSelectColumnCount() == 0) {
            throw new SQLException("Inner query must have only 1 select column specified instead of *");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Inner query must have only 1 select column specified instead of ");
            sb.append(queryBuilder.getSelectColumnCount());
            sb.append(": ");
            sb.append(Arrays.toString(queryBuilder.getSelectColumns().toArray(new String[0])));
            throw new SQLException(sb.toString());
        }
    }

    private Clause[] buildClauseArray(Where<T, ID>[] whereArr, String str) {
        if (whereArr.length == 0) {
            return null;
        }
        Clause[] clauseArr = new Clause[whereArr.length];
        for (int length = whereArr.length - 1; length >= 0; length--) {
            clauseArr[length] = pop(str);
        }
        return clauseArr;
    }

    private void addNeedsFuture(NeedsFutureClause needsFutureClause) {
        if (this.needsFuture == null) {
            this.needsFuture = needsFutureClause;
            push(needsFutureClause);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.needsFuture);
        sb.append(" is already waiting for a future clause, can't add: ");
        sb.append(needsFutureClause);
        throw new IllegalStateException(sb.toString());
    }

    private void addClause(Clause clause) {
        if (this.needsFuture == null) {
            push(clause);
            return;
        }
        this.needsFuture.setMissingClause(clause);
        this.needsFuture = null;
    }

    private FieldType findColumnFieldType(String str) {
        return this.tableInfo.getFieldTypeByColumnName(str);
    }

    private void push(Clause clause) {
        if (this.clauseStackLevel == this.clauseStack.length) {
            Clause[] clauseArr = new Clause[(this.clauseStackLevel * 2)];
            for (int i = 0; i < this.clauseStackLevel; i++) {
                clauseArr[i] = this.clauseStack[i];
                this.clauseStack[i] = null;
            }
            this.clauseStack = clauseArr;
        }
        Clause[] clauseArr2 = this.clauseStack;
        int i2 = this.clauseStackLevel;
        this.clauseStackLevel = i2 + 1;
        clauseArr2[i2] = clause;
    }

    private Clause pop(String str) {
        if (this.clauseStackLevel != 0) {
            Clause[] clauseArr = this.clauseStack;
            int i = this.clauseStackLevel - 1;
            this.clauseStackLevel = i;
            Clause clause = clauseArr[i];
            this.clauseStack[this.clauseStackLevel] = null;
            return clause;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expecting there to be a clause already defined for '");
        sb.append(str);
        sb.append("' operation");
        throw new IllegalStateException(sb.toString());
    }

    private Clause peek() {
        return this.clauseStack[this.clauseStackLevel - 1];
    }
}
