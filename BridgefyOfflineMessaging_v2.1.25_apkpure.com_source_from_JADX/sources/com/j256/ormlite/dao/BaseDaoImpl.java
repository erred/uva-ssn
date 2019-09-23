package com.j256.ormlite.dao;

import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

public abstract class BaseDaoImpl<T, ID> implements Dao<T, ID> {
    private static final ThreadLocal<DaoConfigArray> daoConfigLevelLocal = new ThreadLocal<DaoConfigArray>() {
        /* access modifiers changed from: protected */
        public DaoConfigArray initialValue() {
            return new DaoConfigArray();
        }
    };
    private static ReferenceObjectCache defaultObjectCache;
    protected ConnectionSource connectionSource;
    protected final Class<T> dataClass;
    protected DatabaseType databaseType;
    private boolean initialized;
    protected CloseableIterator<T> lastIterator;
    private ObjectCache objectCache;
    protected ObjectFactory<T> objectFactory;
    protected StatementExecutor<T, ID> statementExecutor;
    protected DatabaseTableConfig<T> tableConfig;
    protected TableInfo<T, ID> tableInfo;

    private static class DaoConfigArray {
        private BaseDaoImpl<?, ?>[] daoArray;
        private int daoArrayC;

        private DaoConfigArray() {
            this.daoArray = new BaseDaoImpl[10];
            this.daoArrayC = 0;
        }

        public void addDao(BaseDaoImpl<?, ?> baseDaoImpl) {
            if (this.daoArrayC == this.daoArray.length) {
                BaseDaoImpl<?, ?>[] baseDaoImplArr = new BaseDaoImpl[(this.daoArray.length * 2)];
                for (int i = 0; i < this.daoArray.length; i++) {
                    baseDaoImplArr[i] = this.daoArray[i];
                    this.daoArray[i] = null;
                }
                this.daoArray = baseDaoImplArr;
            }
            BaseDaoImpl<?, ?>[] baseDaoImplArr2 = this.daoArray;
            int i2 = this.daoArrayC;
            this.daoArrayC = i2 + 1;
            baseDaoImplArr2[i2] = baseDaoImpl;
        }

        public int size() {
            return this.daoArrayC;
        }

        public BaseDaoImpl<?, ?> get(int i) {
            return this.daoArray[i];
        }

        public void clear() {
            for (int i = 0; i < this.daoArrayC; i++) {
                this.daoArray[i] = null;
            }
            this.daoArrayC = 0;
        }
    }

    protected BaseDaoImpl(Class<T> cls) throws SQLException {
        this(null, cls, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource2, Class<T> cls) throws SQLException {
        this(connectionSource2, cls, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource2, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        this(connectionSource2, databaseTableConfig.getDataClass(), databaseTableConfig);
    }

    private BaseDaoImpl(ConnectionSource connectionSource2, Class<T> cls, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        this.dataClass = cls;
        this.tableConfig = databaseTableConfig;
        if (connectionSource2 != null) {
            this.connectionSource = connectionSource2;
            initialize();
        }
    }

    public void initialize() throws SQLException {
        BaseDaoImpl baseDaoImpl;
        if (!this.initialized) {
            if (this.connectionSource != null) {
                this.databaseType = this.connectionSource.getDatabaseType();
                if (this.databaseType != null) {
                    if (this.tableConfig == null) {
                        this.tableInfo = new TableInfo<>(this.connectionSource, this, this.dataClass);
                    } else {
                        this.tableConfig.extractFieldTypes(this.connectionSource);
                        this.tableInfo = new TableInfo<>(this.databaseType, this, this.tableConfig);
                    }
                    this.statementExecutor = new StatementExecutor<>(this.databaseType, this.tableInfo, this);
                    DaoConfigArray daoConfigArray = (DaoConfigArray) daoConfigLevelLocal.get();
                    if (daoConfigArray.size() > 0) {
                        daoConfigArray.addDao(this);
                        return;
                    }
                    daoConfigArray.addDao(this);
                    int i = 0;
                    while (i < daoConfigArray.size()) {
                        try {
                            baseDaoImpl = daoConfigArray.get(i);
                            DaoManager.registerDao(this.connectionSource, baseDaoImpl);
                            for (FieldType configDaoInformation : baseDaoImpl.getTableInfo().getFieldTypes()) {
                                configDaoInformation.configDaoInformation(this.connectionSource, baseDaoImpl.getDataClass());
                            }
                            baseDaoImpl.initialized = true;
                            i++;
                        } catch (SQLException e) {
                            DaoManager.unregisterDao(this.connectionSource, baseDaoImpl);
                            throw e;
                        } catch (Throwable th) {
                            daoConfigArray.clear();
                            throw th;
                        }
                    }
                    daoConfigArray.clear();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("connectionSource is getting a null DatabaseType in ");
                sb.append(getClass().getSimpleName());
                throw new IllegalStateException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("connectionSource was never set on ");
            sb2.append(getClass().getSimpleName());
            throw new IllegalStateException(sb2.toString());
        }
    }

    public T queryForId(ID id) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.queryForId(readOnlyConnection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public T queryForFirst(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.queryForFirst(readOnlyConnection, preparedQuery, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public List<T> queryForAll() throws SQLException {
        checkForInitialized();
        return this.statementExecutor.queryForAll(this.connectionSource, this.objectCache);
    }

    public List<T> queryForEq(String str, Object obj) throws SQLException {
        return queryBuilder().where().mo27052eq(str, obj).query();
    }

    public QueryBuilder<T, ID> queryBuilder() {
        checkForInitialized();
        return new QueryBuilder<>(this.databaseType, this.tableInfo, this);
    }

    public UpdateBuilder<T, ID> updateBuilder() {
        checkForInitialized();
        return new UpdateBuilder<>(this.databaseType, this.tableInfo, this);
    }

    public DeleteBuilder<T, ID> deleteBuilder() {
        checkForInitialized();
        return new DeleteBuilder<>(this.databaseType, this.tableInfo, this);
    }

    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        return this.statementExecutor.query(this.connectionSource, preparedQuery, this.objectCache);
    }

    public List<T> queryForMatching(T t) throws SQLException {
        return queryForMatching(t, false);
    }

    public List<T> queryForMatchingArgs(T t) throws SQLException {
        return queryForMatching(t, true);
    }

    public List<T> queryForFieldValues(Map<String, Object> map) throws SQLException {
        return queryForFieldValues(map, false);
    }

    public List<T> queryForFieldValuesArgs(Map<String, Object> map) throws SQLException {
        return queryForFieldValues(map, true);
    }

    public T queryForSameId(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return null;
        }
        Object extractId = extractId(t);
        if (extractId == null) {
            return null;
        }
        return queryForId(extractId);
    }

    public int create(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.create(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public T createIfNotExists(T t) throws SQLException {
        if (t == null) {
            return null;
        }
        T queryForSameId = queryForSameId(t);
        if (queryForSameId != null) {
            return queryForSameId;
        }
        create(t);
        return t;
    }

    public CreateOrUpdateStatus createOrUpdate(T t) throws SQLException {
        if (t == null) {
            return new CreateOrUpdateStatus(false, false, 0);
        }
        Object extractId = extractId(t);
        if (extractId == null || !idExists(extractId)) {
            return new CreateOrUpdateStatus(true, false, create(t));
        }
        return new CreateOrUpdateStatus(false, true, update(t));
    }

    public int update(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.update(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int updateId(T t, ID id) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            int updateId = this.statementExecutor.updateId(readWriteConnection, t, id, this.objectCache);
            return updateId;
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int update(PreparedUpdate<T> preparedUpdate) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.update(readWriteConnection, preparedUpdate);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int refresh(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        if (t instanceof BaseDaoEnabled) {
            ((BaseDaoEnabled) t).setDao(this);
        }
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.refresh(readOnlyConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public int delete(T t) throws SQLException {
        checkForInitialized();
        if (t == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.delete(readWriteConnection, t, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int deleteById(ID id) throws SQLException {
        checkForInitialized();
        if (id == null) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.deleteById(readWriteConnection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int delete(Collection<T> collection) throws SQLException {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.deleteObjects(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int deleteIds(Collection<ID> collection) throws SQLException {
        checkForInitialized();
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.deleteIds(readWriteConnection, collection, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public int delete(PreparedDelete<T> preparedDelete) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.delete(readWriteConnection, preparedDelete);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public CloseableIterator<T> iterator() {
        return iterator(-1);
    }

    public CloseableIterator<T> closeableIterator() {
        return iterator(-1);
    }

    public CloseableIterator<T> iterator(int i) {
        checkForInitialized();
        this.lastIterator = createIterator(i);
        return this.lastIterator;
    }

    public CloseableWrappedIterable<T> getWrappedIterable() {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            public Iterator<T> iterator() {
                return closeableIterator();
            }

            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(-1);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not build iterator for ");
                    sb.append(BaseDaoImpl.this.dataClass);
                    throw new IllegalStateException(sb.toString(), e);
                }
            }
        });
    }

    public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            public Iterator<T> iterator() {
                return closeableIterator();
            }

            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(preparedQuery, -1);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not build prepared-query iterator for ");
                    sb.append(BaseDaoImpl.this.dataClass);
                    throw new IllegalStateException(sb.toString(), e);
                }
            }
        });
    }

    public void closeLastIterator() throws SQLException {
        if (this.lastIterator != null) {
            this.lastIterator.close();
            this.lastIterator = null;
        }
    }

    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) throws SQLException {
        return iterator(preparedQuery, -1);
    }

    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int i) throws SQLException {
        checkForInitialized();
        this.lastIterator = createIterator(preparedQuery, i);
        return this.lastIterator;
    }

    public GenericRawResults<String[]> queryRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public <GR> GenericRawResults<GR> queryRaw(String str, RawRowMapper<GR> rawRowMapper, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, rawRowMapper, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public GenericRawResults<Object[]> queryRaw(String str, DataType[] dataTypeArr, String... strArr) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, str, dataTypeArr, strArr, this.objectCache);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public long queryRawValue(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
        try {
            long queryForLong = this.statementExecutor.queryForLong(readOnlyConnection, str, strArr);
            this.connectionSource.releaseConnection(readOnlyConnection);
            return queryForLong;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not perform raw value query for ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readOnlyConnection);
            throw th;
        }
    }

    public int executeRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            int executeRaw = this.statementExecutor.executeRaw(readWriteConnection, str, strArr);
            this.connectionSource.releaseConnection(readWriteConnection);
            return executeRaw;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not run raw execute statement ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readWriteConnection);
            throw th;
        }
    }

    public int executeRawNoArgs(String str) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            int executeRawNoArgs = this.statementExecutor.executeRawNoArgs(readWriteConnection, str);
            this.connectionSource.releaseConnection(readWriteConnection);
            return executeRawNoArgs;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not run raw execute statement ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readWriteConnection);
            throw th;
        }
    }

    public int updateRaw(String str, String... strArr) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            int updateRaw = this.statementExecutor.updateRaw(readWriteConnection, str, strArr);
            this.connectionSource.releaseConnection(readWriteConnection);
            return updateRaw;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not run raw update statement ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(readWriteConnection);
            throw th;
        }
    }

    public <CT> CT callBatchTasks(Callable<CT> callable) throws SQLException {
        checkForInitialized();
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.callBatchTasks(readWriteConnection, this.connectionSource.saveSpecialConnection(readWriteConnection), callable);
        } finally {
            this.connectionSource.clearSpecialConnection(readWriteConnection);
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public String objectToString(T t) {
        checkForInitialized();
        return this.tableInfo.objectToString(t);
    }

    public boolean objectsEqual(T t, T t2) throws SQLException {
        FieldType[] fieldTypes;
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (!fieldType.getDataPersister().dataIsEqual(fieldType.extractJavaFieldValue(t), fieldType.extractJavaFieldValue(t2))) {
                return false;
            }
        }
        return true;
    }

    public ID extractId(T t) throws SQLException {
        checkForInitialized();
        FieldType idField = this.tableInfo.getIdField();
        if (idField != null) {
            return idField.extractJavaFieldValue(t);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Class ");
        sb.append(this.dataClass);
        sb.append(" does not have an id field");
        throw new SQLException(sb.toString());
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public FieldType findForeignFieldType(Class<?> cls) {
        FieldType[] fieldTypes;
        checkForInitialized();
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getType() == cls) {
                return fieldType;
            }
        }
        return null;
    }

    public boolean isUpdatable() {
        return this.tableInfo.isUpdatable();
    }

    public boolean isTableExists() throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
        try {
            return readOnlyConnection.isTableExists(this.tableInfo.getTableName());
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public long countOf() throws SQLException {
        checkForInitialized();
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.queryForCountStar(readOnlyConnection);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public long countOf(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        if (preparedQuery.getType() == StatementType.SELECT_LONG) {
            DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
            try {
                long queryForLong = this.statementExecutor.queryForLong(readOnlyConnection, preparedQuery);
                return queryForLong;
            } finally {
                this.connectionSource.releaseConnection(readOnlyConnection);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Prepared query is not of type ");
            sb.append(StatementType.SELECT_LONG);
            sb.append(", did you call QueryBuilder.setCountOf(true)?");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void assignEmptyForeignCollection(T t, String str) throws SQLException {
        makeEmptyForeignCollection(t, str);
    }

    public <FT> ForeignCollection<FT> getEmptyForeignCollection(String str) throws SQLException {
        return makeEmptyForeignCollection(null, str);
    }

    public void setObjectCache(boolean z) throws SQLException {
        if (z) {
            if (this.objectCache != null) {
                return;
            }
            if (this.tableInfo.getIdField() != null) {
                synchronized (getClass()) {
                    if (defaultObjectCache == null) {
                        defaultObjectCache = ReferenceObjectCache.makeWeakCache();
                    }
                    this.objectCache = defaultObjectCache;
                }
                this.objectCache.registerClass(this.dataClass);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(this.dataClass);
            sb.append(" must have an id field to enable the object cache");
            throw new SQLException(sb.toString());
        } else if (this.objectCache != null) {
            this.objectCache.clear(this.dataClass);
            this.objectCache = null;
        }
    }

    public void setObjectCache(ObjectCache objectCache2) throws SQLException {
        if (objectCache2 != null) {
            if (!(this.objectCache == null || this.objectCache == objectCache2)) {
                this.objectCache.clear(this.dataClass);
            }
            if (this.tableInfo.getIdField() != null) {
                this.objectCache = objectCache2;
                this.objectCache.registerClass(this.dataClass);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(this.dataClass);
            sb.append(" must have an id field to enable the object cache");
            throw new SQLException(sb.toString());
        } else if (this.objectCache != null) {
            this.objectCache.clear(this.dataClass);
            this.objectCache = null;
        }
    }

    public ObjectCache getObjectCache() {
        return this.objectCache;
    }

    public void clearObjectCache() {
        if (this.objectCache != null) {
            this.objectCache.clear(this.dataClass);
        }
    }

    public static synchronized void clearAllInternalObjectCaches() {
        synchronized (BaseDaoImpl.class) {
            if (defaultObjectCache != null) {
                defaultObjectCache.clearAll();
                defaultObjectCache = null;
            }
        }
    }

    public T mapSelectStarRow(DatabaseResults databaseResults) throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper().mapRow(databaseResults);
    }

    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper();
    }

    public RawRowMapper<T> getRawRowMapper() {
        return this.statementExecutor.getRawRowMapper();
    }

    public boolean idExists(ID id) throws SQLException {
        DatabaseConnection readOnlyConnection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.ifExists(readOnlyConnection, id);
        } finally {
            this.connectionSource.releaseConnection(readOnlyConnection);
        }
    }

    public DatabaseConnection startThreadConnection() throws SQLException {
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        this.connectionSource.saveSpecialConnection(readWriteConnection);
        return readWriteConnection;
    }

    public void endThreadConnection(DatabaseConnection databaseConnection) throws SQLException {
        this.connectionSource.clearSpecialConnection(databaseConnection);
        this.connectionSource.releaseConnection(databaseConnection);
    }

    public void setAutoCommit(boolean z) throws SQLException {
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            setAutoCommit(readWriteConnection, z);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public void setAutoCommit(DatabaseConnection databaseConnection, boolean z) throws SQLException {
        databaseConnection.setAutoCommit(z);
    }

    public boolean isAutoCommit() throws SQLException {
        DatabaseConnection readWriteConnection = this.connectionSource.getReadWriteConnection();
        try {
            return isAutoCommit(readWriteConnection);
        } finally {
            this.connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public boolean isAutoCommit(DatabaseConnection databaseConnection) throws SQLException {
        return databaseConnection.isAutoCommit();
    }

    public void commit(DatabaseConnection databaseConnection) throws SQLException {
        databaseConnection.commit(null);
    }

    public void rollBack(DatabaseConnection databaseConnection) throws SQLException {
        databaseConnection.rollback(null);
    }

    public ObjectFactory<T> getObjectFactory() {
        return this.objectFactory;
    }

    public void setObjectFactory(ObjectFactory<T> objectFactory2) {
        checkForInitialized();
        this.objectFactory = objectFactory2;
    }

    public DatabaseTableConfig<T> getTableConfig() {
        return this.tableConfig;
    }

    public TableInfo<T, ID> getTableInfo() {
        return this.tableInfo;
    }

    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    public void setConnectionSource(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
    }

    public void setTableConfig(DatabaseTableConfig<T> databaseTableConfig) {
        this.tableConfig = databaseTableConfig;
    }

    static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource2, Class<T> cls) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource2, cls) {
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return BaseDaoImpl.super.iterator();
            }
        };
    }

    static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource2, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource2, databaseTableConfig) {
            public /* bridge */ /* synthetic */ Iterator iterator() {
                return BaseDaoImpl.super.iterator();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void checkForInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("you must call initialize() before you can use the dao");
        }
    }

    private <FT> ForeignCollection<FT> makeEmptyForeignCollection(T t, String str) throws SQLException {
        Object obj;
        FieldType[] fieldTypes;
        checkForInitialized();
        if (t == null) {
            obj = null;
        } else {
            obj = extractId(t);
        }
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            if (fieldType.getColumnName().equals(str)) {
                BaseForeignCollection buildForeignCollection = fieldType.buildForeignCollection(t, obj);
                if (t != null) {
                    fieldType.assignField(t, buildForeignCollection, true, null);
                }
                return buildForeignCollection;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find a field named ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: private */
    public CloseableIterator<T> createIterator(int i) {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, i, this.objectCache);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not build iterator for ");
            sb.append(this.dataClass);
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: private */
    public CloseableIterator<T> createIterator(PreparedQuery<T> preparedQuery, int i) throws SQLException {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, preparedQuery, this.objectCache, i);
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not build prepared-query iterator for ");
            sb.append(this.dataClass);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    private List<T> queryForMatching(T t, boolean z) throws SQLException {
        FieldType[] fieldTypes;
        checkForInitialized();
        QueryBuilder queryBuilder = queryBuilder();
        Where where = queryBuilder.where();
        int i = 0;
        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
            Object fieldValueIfNotDefault = fieldType.getFieldValueIfNotDefault(t);
            if (fieldValueIfNotDefault != null) {
                if (z) {
                    fieldValueIfNotDefault = new SelectArg(fieldValueIfNotDefault);
                }
                where.mo27052eq(fieldType.getColumnName(), fieldValueIfNotDefault);
                i++;
            }
        }
        if (i == 0) {
            return Collections.emptyList();
        }
        where.and(i);
        return queryBuilder.query();
    }

    private List<T> queryForFieldValues(Map<String, Object> map, boolean z) throws SQLException {
        checkForInitialized();
        QueryBuilder queryBuilder = queryBuilder();
        Where where = queryBuilder.where();
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (z) {
                value = new SelectArg(value);
            }
            where.mo27052eq((String) entry.getKey(), value);
        }
        if (map.size() == 0) {
            return Collections.emptyList();
        }
        where.and(map.size());
        return queryBuilder.query();
    }
}
