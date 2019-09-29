package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;

@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap<K, V> {
    /* access modifiers changed from: private */
    public final transient EnumMap<K, V> delegate;

    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        /* access modifiers changed from: 0000 */
        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return false;
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> enumMap) {
        switch (enumMap.size()) {
            case 0:
                return ImmutableMap.m8687of();
            case 1:
                Entry entry = (Entry) Iterables.getOnlyElement(enumMap.entrySet());
                return ImmutableMap.m8688of(entry.getKey(), entry.getValue());
            default:
                return new ImmutableEnumMap(enumMap);
        }
    }

    private ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.delegate = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }

    /* access modifiers changed from: 0000 */
    public ImmutableSet<K> createKeySet() {
        return new ImmutableSet<K>() {
            /* access modifiers changed from: 0000 */
            public boolean isPartialView() {
                return true;
            }

            public boolean contains(Object obj) {
                return ImmutableEnumMap.this.delegate.containsKey(obj);
            }

            public int size() {
                return ImmutableEnumMap.this.size();
            }

            public UnmodifiableIterator<K> iterator() {
                return Iterators.unmodifiableIterator(ImmutableEnumMap.this.delegate.keySet().iterator());
            }
        };
    }

    public int size() {
        return this.delegate.size();
    }

    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    public V get(Object obj) {
        return this.delegate.get(obj);
    }

    /* access modifiers changed from: 0000 */
    public ImmutableSet<Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet<K, V>() {
            /* access modifiers changed from: 0000 */
            public ImmutableMap<K, V> map() {
                return ImmutableEnumMap.this;
            }

            public UnmodifiableIterator<Entry<K, V>> iterator() {
                return new UnmodifiableIterator<Entry<K, V>>() {
                    private final Iterator<Entry<K, V>> backingIterator = ImmutableEnumMap.this.delegate.entrySet().iterator();

                    public boolean hasNext() {
                        return this.backingIterator.hasNext();
                    }

                    public Entry<K, V> next() {
                        Entry entry = (Entry) this.backingIterator.next();
                        return Maps.immutableEntry(entry.getKey(), entry.getValue());
                    }
                };
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}
