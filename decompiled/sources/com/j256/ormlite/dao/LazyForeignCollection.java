package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5460708106909626233L;
    private transient CloseableIterator<T> lastIterator;

    public boolean isEager() {
        return false;
    }

    public int refreshCollection() {
        return 0;
    }

    public LazyForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        super(dao, obj, obj2, fieldType, str, z);
    }

    public CloseableIterator<T> iterator() {
        return closeableIterator();
    }

    public CloseableIterator<T> closeableIterator() {
        try {
            return iteratorThrow();
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not build lazy iterator for ");
            sb.append(this.dao.getDataClass());
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    public CloseableIterator<T> iteratorThrow() throws SQLException {
        this.lastIterator = seperateIteratorThrow();
        return this.lastIterator;
    }

    public CloseableIterator<T> seperateIteratorThrow() throws SQLException {
        if (this.dao != null) {
            return this.dao.iterator(getPreparedQuery());
        }
        throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
    }

    public CloseableWrappedIterable<T> getWrappedIterable() {
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            public CloseableIterator<T> iterator() {
                return closeableIterator();
            }

            public CloseableIterator<T> closeableIterator() {
                try {
                    return LazyForeignCollection.this.seperateIteratorThrow();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not build lazy iterator for ");
                    sb.append(LazyForeignCollection.this.dao.getDataClass());
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

    public int size() {
        CloseableIterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            try {
                it.moveToNext();
                i++;
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return i;
    }

    public boolean isEmpty() {
        CloseableIterator it = iterator();
        try {
            return !it.hasNext();
        } finally {
            try {
                it.close();
            } catch (SQLException unused) {
            }
        }
    }

    public boolean contains(Object obj) {
        CloseableIterator it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                    } catch (SQLException unused) {
                    }
                    return false;
                }
            } finally {
                try {
                    it.close();
                } catch (SQLException unused2) {
                }
            }
        } while (!it.next().equals(obj));
        return true;
    }

    public boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet(collection);
        CloseableIterator it = iterator();
        while (it.hasNext()) {
            try {
                hashSet.remove(it.next());
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return hashSet.isEmpty();
    }

    public boolean remove(Object obj) {
        CloseableIterator it = iterator();
        do {
            try {
                if (!it.hasNext()) {
                    try {
                        it.close();
                    } catch (SQLException unused) {
                    }
                    return false;
                }
            } finally {
                try {
                    it.close();
                } catch (SQLException unused2) {
                }
            }
        } while (!it.next().equals(obj));
        it.remove();
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        CloseableIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            try {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return z;
    }

    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator it = iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next());
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        return arrayList.toArray();
    }

    public <E> E[] toArray(E[] eArr) {
        CloseableIterator it = iterator();
        List list = null;
        int i = 0;
        while (it.hasNext()) {
            try {
                E next = it.next();
                if (i >= eArr.length) {
                    if (list == null) {
                        list = new ArrayList();
                        for (E add : eArr) {
                            list.add(add);
                        }
                    }
                    list.add(next);
                } else {
                    eArr[i] = next;
                }
                i++;
            } finally {
                try {
                    it.close();
                } catch (SQLException unused) {
                }
            }
        }
        if (list != null) {
            return list.toArray(eArr);
        }
        if (i < eArr.length - 1) {
            eArr[i] = null;
        }
        return eArr;
    }

    public int updateAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    public int refreshAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
