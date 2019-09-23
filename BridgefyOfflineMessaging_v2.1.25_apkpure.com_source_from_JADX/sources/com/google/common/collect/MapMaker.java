package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.base.Ticker;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
public final class MapMaker extends GenericMapMaker<Object, Object> {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int UNSET_INT = -1;
    int concurrencyLevel = -1;
    long expireAfterAccessNanos = -1;
    long expireAfterWriteNanos = -1;
    int initialCapacity = -1;
    Equivalence<Object> keyEquivalence;
    Strength keyStrength;
    int maximumSize = -1;
    RemovalCause nullRemovalCause;
    Ticker ticker;
    boolean useCustomMap;
    Strength valueStrength;

    static final class ComputingMapAdapter<K, V> extends ComputingConcurrentHashMap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        ComputingMapAdapter(MapMaker mapMaker, Function<? super K, ? extends V> function) {
            super(mapMaker, function);
        }

        public V get(Object obj) {
            try {
                V orCompute = getOrCompute(obj);
                if (orCompute != null) {
                    return orCompute;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.computingFunction);
                sb.append(" returned null for key ");
                sb.append(obj);
                sb.append(".");
                throw new NullPointerException(sb.toString());
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                Throwables.propagateIfInstanceOf(cause, ComputationException.class);
                throw new ComputationException(cause);
            }
        }
    }

    static final class NullComputingConcurrentMap<K, V> extends NullConcurrentMap<K, V> {
        private static final long serialVersionUID = 0;
        final Function<? super K, ? extends V> computingFunction;

        NullComputingConcurrentMap(MapMaker mapMaker, Function<? super K, ? extends V> function) {
            super(mapMaker);
            this.computingFunction = (Function) Preconditions.checkNotNull(function);
        }

        public V get(Object obj) {
            V compute = compute(obj);
            Preconditions.checkNotNull(compute, "%s returned null for key %s.", this.computingFunction, obj);
            notifyRemoval(obj, compute);
            return compute;
        }

        private V compute(K k) {
            Preconditions.checkNotNull(k);
            try {
                return this.computingFunction.apply(k);
            } catch (ComputationException e) {
                throw e;
            } catch (Throwable th) {
                throw new ComputationException(th);
            }
        }
    }

    static class NullConcurrentMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
        private static final long serialVersionUID = 0;
        private final RemovalCause removalCause;
        private final RemovalListener<K, V> removalListener;

        public boolean containsKey(Object obj) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public V get(Object obj) {
            return null;
        }

        public V remove(Object obj) {
            return null;
        }

        public boolean remove(Object obj, Object obj2) {
            return false;
        }

        NullConcurrentMap(MapMaker mapMaker) {
            this.removalListener = mapMaker.getRemovalListener();
            this.removalCause = mapMaker.nullRemovalCause;
        }

        /* access modifiers changed from: 0000 */
        public void notifyRemoval(K k, V v) {
            this.removalListener.onRemoval(new RemovalNotification(k, v, this.removalCause));
        }

        public V put(K k, V v) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(v);
            notifyRemoval(k, v);
            return null;
        }

        public V putIfAbsent(K k, V v) {
            return put(k, v);
        }

        public V replace(K k, V v) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(v);
            return null;
        }

        public boolean replace(K k, V v, V v2) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(v2);
            return false;
        }

        public Set<Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }
    }

    enum RemovalCause {
        EXPLICIT {
            /* access modifiers changed from: 0000 */
            public boolean wasEvicted() {
                return false;
            }
        },
        REPLACED {
            /* access modifiers changed from: 0000 */
            public boolean wasEvicted() {
                return false;
            }
        },
        COLLECTED {
            /* access modifiers changed from: 0000 */
            public boolean wasEvicted() {
                return true;
            }
        },
        EXPIRED {
            /* access modifiers changed from: 0000 */
            public boolean wasEvicted() {
                return true;
            }
        },
        SIZE {
            /* access modifiers changed from: 0000 */
            public boolean wasEvicted() {
                return true;
            }
        };

        /* access modifiers changed from: 0000 */
        public abstract boolean wasEvicted();
    }

    interface RemovalListener<K, V> {
        void onRemoval(RemovalNotification<K, V> removalNotification);
    }

    static final class RemovalNotification<K, V> extends ImmutableEntry<K, V> {
        private static final long serialVersionUID = 0;
        private final RemovalCause cause;

        RemovalNotification(K k, V v, RemovalCause removalCause) {
            super(k, v);
            this.cause = removalCause;
        }

        public RemovalCause getCause() {
            return this.cause;
        }

        public boolean wasEvicted() {
            return this.cause.wasEvicted();
        }
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("To be supported")
    public MapMaker keyEquivalence(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) Objects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public MapMaker initialCapacity(int i) {
        boolean z = false;
        Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", Integer.valueOf(this.initialCapacity));
        if (i >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.initialCapacity = i;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public int getInitialCapacity() {
        if (this.initialCapacity == -1) {
            return 16;
        }
        return this.initialCapacity;
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public MapMaker maximumSize(int i) {
        boolean z = false;
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", Integer.valueOf(this.maximumSize));
        if (i >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "maximum size must not be negative");
        this.maximumSize = i;
        this.useCustomMap = true;
        if (this.maximumSize == 0) {
            this.nullRemovalCause = RemovalCause.SIZE;
        }
        return this;
    }

    public MapMaker concurrencyLevel(int i) {
        boolean z = false;
        Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", Integer.valueOf(this.concurrencyLevel));
        if (i > 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.concurrencyLevel = i;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public int getConcurrencyLevel() {
        if (this.concurrencyLevel == -1) {
            return 4;
        }
        return this.concurrencyLevel;
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public MapMaker weakKeys() {
        return setKeyStrength(Strength.WEAK);
    }

    /* access modifiers changed from: 0000 */
    public MapMaker setKeyStrength(Strength strength) {
        boolean z = false;
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", this.keyStrength);
        this.keyStrength = (Strength) Preconditions.checkNotNull(strength);
        if (this.keyStrength != Strength.SOFT) {
            z = true;
        }
        Preconditions.checkArgument(z, "Soft keys are not supported");
        if (strength != Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Strength getKeyStrength() {
        return (Strength) Objects.firstNonNull(this.keyStrength, Strength.STRONG);
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public MapMaker weakValues() {
        return setValueStrength(Strength.WEAK);
    }

    @GwtIncompatible("java.lang.ref.SoftReference")
    @Deprecated
    public MapMaker softValues() {
        return setValueStrength(Strength.SOFT);
    }

    /* access modifiers changed from: 0000 */
    public MapMaker setValueStrength(Strength strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", this.valueStrength);
        this.valueStrength = (Strength) Preconditions.checkNotNull(strength);
        if (strength != Strength.STRONG) {
            this.useCustomMap = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Strength getValueStrength() {
        return (Strength) Objects.firstNonNull(this.valueStrength, Strength.STRONG);
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public MapMaker expireAfterWrite(long j, TimeUnit timeUnit) {
        checkExpiration(j, timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j);
        if (j == 0 && this.nullRemovalCause == null) {
            this.nullRemovalCause = RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }

    private void checkExpiration(long j, TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterWriteNanos == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.expireAfterWriteNanos));
        Preconditions.checkState(this.expireAfterAccessNanos == -1, "expireAfterAccess was already set to %s ns", Long.valueOf(this.expireAfterAccessNanos));
        Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
    }

    /* access modifiers changed from: 0000 */
    public long getExpireAfterWriteNanos() {
        if (this.expireAfterWriteNanos == -1) {
            return 0;
        }
        return this.expireAfterWriteNanos;
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("To be supported")
    @Deprecated
    public MapMaker expireAfterAccess(long j, TimeUnit timeUnit) {
        checkExpiration(j, timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j);
        if (j == 0 && this.nullRemovalCause == null) {
            this.nullRemovalCause = RemovalCause.EXPIRED;
        }
        this.useCustomMap = true;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public long getExpireAfterAccessNanos() {
        if (this.expireAfterAccessNanos == -1) {
            return 0;
        }
        return this.expireAfterAccessNanos;
    }

    /* access modifiers changed from: 0000 */
    public Ticker getTicker() {
        return (Ticker) Objects.firstNonNull(this.ticker, Ticker.systemTicker());
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("To be supported")
    @Deprecated
    public <K, V> GenericMapMaker<K, V> removalListener(RemovalListener<K, V> removalListener) {
        Preconditions.checkState(this.removalListener == null);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener);
        this.useCustomMap = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (!this.useCustomMap) {
            return new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel());
        }
        return this.nullRemovalCause == null ? new MapMakerInternalMap<>(this) : new NullConcurrentMap<>(this);
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("MapMakerInternalMap")
    public <K, V> MapMakerInternalMap<K, V> makeCustomMap() {
        return new MapMakerInternalMap<>(this);
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public <K, V> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> function) {
        return this.nullRemovalCause == null ? new ComputingMapAdapter<>(this, function) : new NullComputingConcurrentMap<>(this, function);
    }

    public String toString() {
        ToStringHelper stringHelper = Objects.toStringHelper((Object) this);
        if (this.initialCapacity != -1) {
            stringHelper.add("initialCapacity", this.initialCapacity);
        }
        if (this.concurrencyLevel != -1) {
            stringHelper.add("concurrencyLevel", this.concurrencyLevel);
        }
        if (this.maximumSize != -1) {
            stringHelper.add("maximumSize", this.maximumSize);
        }
        if (this.expireAfterWriteNanos != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.expireAfterWriteNanos);
            sb.append("ns");
            stringHelper.add("expireAfterWrite", (Object) sb.toString());
        }
        if (this.expireAfterAccessNanos != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.expireAfterAccessNanos);
            sb2.append("ns");
            stringHelper.add("expireAfterAccess", (Object) sb2.toString());
        }
        if (this.keyStrength != null) {
            stringHelper.add("keyStrength", (Object) Ascii.toLowerCase(this.keyStrength.toString()));
        }
        if (this.valueStrength != null) {
            stringHelper.add("valueStrength", (Object) Ascii.toLowerCase(this.valueStrength.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue((Object) "keyEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue((Object) "removalListener");
        }
        return stringHelper.toString();
    }
}
