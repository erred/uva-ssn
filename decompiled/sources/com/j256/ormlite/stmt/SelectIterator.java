package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class SelectIterator<T, ID> implements CloseableIterator<T> {
    private static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
    private boolean alreadyMoved = false;
    private final Dao<T, ID> classDao;
    private boolean closed = false;
    private final CompiledStatement compiledStmt;
    private final DatabaseConnection connection;
    private final ConnectionSource connectionSource;
    private final Class<?> dataClass;
    private boolean first = true;
    private T last = null;
    private final DatabaseResults results;
    private int rowC = 0;
    private final GenericRowMapper<T> rowMapper;
    private final String statement;

    public SelectIterator(Class<?> cls, Dao<T, ID> dao, GenericRowMapper<T> genericRowMapper, ConnectionSource connectionSource2, DatabaseConnection databaseConnection, CompiledStatement compiledStatement, String str, ObjectCache objectCache) throws SQLException {
        this.dataClass = cls;
        this.classDao = dao;
        this.rowMapper = genericRowMapper;
        this.connectionSource = connectionSource2;
        this.connection = databaseConnection;
        this.compiledStmt = compiledStatement;
        this.results = compiledStatement.runQuery(objectCache);
        this.statement = str;
        if (str != null) {
            logger.debug("starting iterator @{} for '{}'", (Object) Integer.valueOf(hashCode()), (Object) str);
        }
    }

    public boolean hasNextThrow() throws SQLException {
        boolean z;
        if (this.closed) {
            return false;
        }
        if (this.alreadyMoved) {
            return true;
        }
        if (this.first) {
            this.first = false;
            z = this.results.first();
        } else {
            z = this.results.next();
        }
        if (!z) {
            close();
        }
        this.alreadyMoved = true;
        return z;
    }

    public boolean hasNext() {
        try {
            return hasNextThrow();
        } catch (SQLException e) {
            this.last = null;
            closeQuietly();
            StringBuilder sb = new StringBuilder();
            sb.append("Errors getting more results of ");
            sb.append(this.dataClass);
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    public T first() throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.first()) {
            return getCurrent();
        }
        return null;
    }

    public T previous() throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.previous()) {
            return getCurrent();
        }
        return null;
    }

    public T current() throws SQLException {
        if (this.closed) {
            return null;
        }
        if (this.first) {
            return first();
        }
        return getCurrent();
    }

    public T nextThrow() throws SQLException {
        boolean z;
        if (this.closed) {
            return null;
        }
        if (!this.alreadyMoved) {
            if (this.first) {
                this.first = false;
                z = this.results.first();
            } else {
                z = this.results.next();
            }
            if (!z) {
                this.first = false;
                return null;
            }
        }
        this.first = false;
        return getCurrent();
    }

    public T next() {
        try {
            T nextThrow = nextThrow();
            if (nextThrow != null) {
                return nextThrow;
            }
            e = null;
            this.last = null;
            closeQuietly();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not get next result for ");
            sb.append(this.dataClass);
            throw new IllegalStateException(sb.toString(), e);
        } catch (SQLException e) {
            e = e;
        }
    }

    public T moveRelative(int i) throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.moveRelative(i)) {
            return getCurrent();
        }
        return null;
    }

    public void removeThrow() throws SQLException {
        if (this.last == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No last ");
            sb.append(this.dataClass);
            sb.append(" object to remove. Must be called after a call to next.");
            throw new IllegalStateException(sb.toString());
        } else if (this.classDao != null) {
            try {
                this.classDao.delete(this.last);
            } finally {
                this.last = null;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot remove ");
            sb2.append(this.dataClass);
            sb2.append(" object because classDao not initialized");
            throw new IllegalStateException(sb2.toString());
        }
    }

    public void remove() {
        try {
            removeThrow();
        } catch (SQLException e) {
            closeQuietly();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not delete ");
            sb.append(this.dataClass);
            sb.append(" object ");
            sb.append(this.last);
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    public void close() throws SQLException {
        if (!this.closed) {
            this.compiledStmt.close();
            this.closed = true;
            this.last = null;
            if (this.statement != null) {
                logger.debug("closed iterator @{} after {} rows", (Object) Integer.valueOf(hashCode()), (Object) Integer.valueOf(this.rowC));
            }
            this.connectionSource.releaseConnection(this.connection);
        }
    }

    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    public DatabaseResults getRawResults() {
        return this.results;
    }

    public void moveToNext() {
        this.last = null;
        this.first = false;
        this.alreadyMoved = false;
    }

    private T getCurrent() throws SQLException {
        this.last = this.rowMapper.mapRow(this.results);
        this.alreadyMoved = false;
        this.rowC++;
        return this.last;
    }
}
