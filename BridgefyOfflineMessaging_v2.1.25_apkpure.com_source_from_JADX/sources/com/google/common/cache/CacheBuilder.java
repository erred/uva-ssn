package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache.SimpleStatsCounter;
import com.google.common.cache.AbstractCache.StatsCounter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
public final class CacheBuilder<K, V> {
    static final Supplier<StatsCounter> CACHE_STATS_COUNTER = new Supplier<StatsCounter>() {
        public StatsCounter get() {
            return new SimpleStatsCounter();
        }
    };
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final CacheStats EMPTY_STATS;
    static final Supplier<? extends StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new StatsCounter() {
        public void recordEviction() {
        }

        public void recordHits(int i) {
        }

        public void recordLoadException(long j) {
        }

        public void recordLoadSuccess(long j) {
        }

        public void recordMisses(int i) {
        }

        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    static final Ticker NULL_TICKER = new Ticker() {
        public long read() {
            return 0;
        }
    };
    static final int UNSET_INT = -1;
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    int concurrencyLevel = -1;
    long expireAfterAccessNanos = -1;
    long expireAfterWriteNanos = -1;
    int initialCapacity = -1;
    Equivalence<Object> keyEquivalence;
    Strength keyStrength;
    long maximumSize = -1;
    long maximumWeight = -1;
    long refreshNanos = -1;
    RemovalListener<? super K, ? super V> removalListener;
    Supplier<? extends StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
    boolean strictParsing = true;
    Ticker ticker;
    Equivalence<Object> valueEquivalence;
    Strength valueStrength;
    Weigher<? super K, ? super V> weigher;

    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    static {
        CacheStats cacheStats = new CacheStats(0, 0, 0, 0, 0, 0);
        EMPTY_STATS = cacheStats;
    }

    CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    @GwtIncompatible("To be supported")
    @Beta
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    @GwtIncompatible("To be supported")
    @Beta
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("To be supported")
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("To be supported")
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) Objects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("To be supported")
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.valueEquivalence == null, "value equivalence was already set to %s", this.valueEquivalence);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) Objects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public CacheBuilder<K, V> initialCapacity(int i) {
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

    public CacheBuilder<K, V> concurrencyLevel(int i) {
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

    public CacheBuilder<K, V> maximumSize(long j) {
        boolean z = false;
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", Long.valueOf(this.maximumSize));
        Preconditions.checkState(this.maximumWeight == -1, "maximum weight was already set to %s", Long.valueOf(this.maximumWeight));
        Preconditions.checkState(this.weigher == null, "maximum size can not be combined with weigher");
        if (j >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "maximum size must not be negative");
        this.maximumSize = j;
        return this;
    }

    @GwtIncompatible("To be supported")
    public CacheBuilder<K, V> maximumWeight(long j) {
        boolean z = false;
        Preconditions.checkState(this.maximumWeight == -1, "maximum weight was already set to %s", Long.valueOf(this.maximumWeight));
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", Long.valueOf(this.maximumSize));
        this.maximumWeight = j;
        if (j >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "maximum weight must not be negative");
        return this;
    }

    @GwtIncompatible("To be supported")
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher2) {
        Preconditions.checkState(this.weigher == null);
        if (this.strictParsing) {
            Preconditions.checkState(this.maximumSize == -1, "weigher can not be combined with maximum size", Long.valueOf(this.maximumSize));
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher2);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0;
        }
        return this.weigher == null ? this.maximumSize : this.maximumWeight;
    }

    /* access modifiers changed from: 0000 */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) Objects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(Strength.WEAK);
    }

    /* access modifiers changed from: 0000 */
    public CacheBuilder<K, V> setKeyStrength(Strength strength) {
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", this.keyStrength);
        this.keyStrength = (Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Strength getKeyStrength() {
        return (Strength) Objects.firstNonNull(this.keyStrength, Strength.STRONG);
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(Strength.WEAK);
    }

    @GwtIncompatible("java.lang.ref.SoftReference")
    public CacheBuilder<K, V> softValues() {
        return setValueStrength(Strength.SOFT);
    }

    /* access modifiers changed from: 0000 */
    public CacheBuilder<K, V> setValueStrength(Strength strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", this.valueStrength);
        this.valueStrength = (Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Strength getValueStrength() {
        return (Strength) Objects.firstNonNull(this.valueStrength, Strength.STRONG);
    }

    public CacheBuilder<K, V> expireAfterWrite(long j, TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterWriteNanos == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.expireAfterWriteNanos));
        Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public long getExpireAfterWriteNanos() {
        if (this.expireAfterWriteNanos == -1) {
            return 0;
        }
        return this.expireAfterWriteNanos;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j, TimeUnit timeUnit) {
        Preconditions.checkState(this.expireAfterAccessNanos == -1, "expireAfterAccess was already set to %s ns", Long.valueOf(this.expireAfterAccessNanos));
        Preconditions.checkArgument(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public long getExpireAfterAccessNanos() {
        if (this.expireAfterAccessNanos == -1) {
            return 0;
        }
        return this.expireAfterAccessNanos;
    }

    @GwtIncompatible("To be supported (synchronously).")
    @Beta
    public CacheBuilder<K, V> refreshAfterWrite(long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkState(this.refreshNanos == -1, "refresh was already set to %s ns", Long.valueOf(this.refreshNanos));
        Preconditions.checkArgument(j > 0, "duration must be positive: %s %s", Long.valueOf(j), timeUnit);
        this.refreshNanos = timeUnit.toNanos(j);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public long getRefreshNanos() {
        if (this.refreshNanos == -1) {
            return 0;
        }
        return this.refreshNanos;
    }

    public CacheBuilder<K, V> ticker(Ticker ticker2) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker2);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public Ticker getTicker(boolean z) {
        if (this.ticker != null) {
            return this.ticker;
        }
        return z ? Ticker.systemTicker() : NULL_TICKER;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener2) {
        Preconditions.checkState(this.removalListener == null);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener2);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) Objects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public boolean isRecordingStats() {
        return this.statsCounterSupplier == CACHE_STATS_COUNTER;
    }

    /* access modifiers changed from: 0000 */
    public Supplier<? extends StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalLoadingCache(this, cacheLoader);
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalManualCache(this);
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.refreshNanos == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z = false;
        if (this.weigher == null) {
            if (this.maximumWeight == -1) {
                z = true;
            }
            Preconditions.checkState(z, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            if (this.maximumWeight != -1) {
                z = true;
            }
            Preconditions.checkState(z, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
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
        if (this.maximumWeight != -1) {
            stringHelper.add("maximumWeight", this.maximumWeight);
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
        if (this.valueEquivalence != null) {
            stringHelper.addValue((Object) "valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue((Object) "removalListener");
        }
        return stringHelper.toString();
    }
}
