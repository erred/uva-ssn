package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map.Entry;

@GwtCompatible
@Beta
public final class RemovalNotification<K, V> implements Entry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;
    private final K key;
    private final V value;

    RemovalNotification(K k, V v, RemovalCause removalCause) {
        this.key = k;
        this.value = v;
        this.cause = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (Objects.equal(getKey(), entry.getKey()) && Objects.equal(getValue(), entry.getValue())) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int i;
        Object key2 = getKey();
        Object value2 = getValue();
        int i2 = 0;
        if (key2 == null) {
            i = 0;
        } else {
            i = key2.hashCode();
        }
        if (value2 != null) {
            i2 = value2.hashCode();
        }
        return i ^ i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(getValue());
        return sb.toString();
    }
}
