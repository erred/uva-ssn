package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible(emulated = true)
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient Map<K, V> delegate;
    private transient Set<Entry<K, V>> entrySet;
    transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    private class EntrySet extends ForwardingSet<Entry<K, V>> {
        final Set<Entry<K, V>> esDelegate;

        private EntrySet() {
            this.esDelegate = AbstractBiMap.this.delegate.entrySet();
        }

        /* access modifiers changed from: protected */
        public Set<Entry<K, V>> delegate() {
            return this.esDelegate;
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(Object obj) {
            if (!this.esDelegate.contains(obj)) {
                return false;
            }
            Entry entry = (Entry) obj;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.esDelegate.remove(entry);
            return true;
        }

        public Iterator<Entry<K, V>> iterator() {
            final Iterator it = this.esDelegate.iterator();
            return new Iterator<Entry<K, V>>() {
                Entry<K, V> entry;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public Entry<K, V> next() {
                    this.entry = (Entry) it.next();
                    final Entry<K, V> entry2 = this.entry;
                    return new ForwardingMapEntry<K, V>() {
                        /* access modifiers changed from: protected */
                        public Entry<K, V> delegate() {
                            return entry2;
                        }

                        public V setValue(V v) {
                            Preconditions.checkState(EntrySet.this.contains(this), "entry no longer in map");
                            if (Objects.equal(v, getValue())) {
                                return v;
                            }
                            Preconditions.checkArgument(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
                            V value = entry2.setValue(v);
                            Preconditions.checkState(Objects.equal(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
                            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
                            return value;
                        }
                    };
                }

                public void remove() {
                    CollectPreconditions.checkRemove(this.entry != null);
                    Object value = this.entry.getValue();
                    it.remove();
                    AbstractBiMap.this.removeFromInverseMap(value);
                }
            };
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public boolean contains(Object obj) {
            return Maps.containsEntryImpl(delegate(), obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    private static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible("Not needed in emulated source.")
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object delegate() {
            return AbstractBiMap.super.delegate();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return AbstractBiMap.super.values();
        }

        private Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        /* access modifiers changed from: 0000 */
        public K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        /* access modifiers changed from: 0000 */
        public V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @GwtIncompatible("java.io.ObjectOuputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        /* access modifiers changed from: 0000 */
        @GwtIncompatible("Not needed in the emulated source.")
        public Object readResolve() {
            return inverse().inverse();
        }
    }

    private class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        /* access modifiers changed from: protected */
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
        }
    }

    private class ValueSet extends ForwardingSet<V> {
        final Set<V> valuesDelegate;

        private ValueSet() {
            this.valuesDelegate = AbstractBiMap.this.inverse.keySet();
        }

        /* access modifiers changed from: protected */
        public Set<V> delegate() {
            return this.valuesDelegate;
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public String toString() {
            return standardToString();
        }
    }

    /* access modifiers changed from: 0000 */
    public K checkKey(K k) {
        return k;
    }

    /* access modifiers changed from: 0000 */
    public V checkValue(V v) {
        return v;
    }

    AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    /* access modifiers changed from: protected */
    public Map<K, V> delegate() {
        return this.delegate;
    }

    /* access modifiers changed from: 0000 */
    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        boolean z = false;
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        if (map != map2) {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.delegate = map;
        this.inverse = new Inverse(map2, this);
    }

    /* access modifiers changed from: 0000 */
    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    public V put(K k, V v) {
        return putInBothMaps(k, v, false);
    }

    public V forcePut(K k, V v) {
        return putInBothMaps(k, v, true);
    }

    private V putInBothMaps(K k, V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && Objects.equal(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            Preconditions.checkArgument(!containsValue(v), "value already present: %s", v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    /* access modifiers changed from: private */
    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* access modifiers changed from: private */
    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }
}
