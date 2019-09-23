package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public final class Futures {
    private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER = new AsyncFunction<ListenableFuture<Object>, Object>() {
        public ListenableFuture<Object> apply(ListenableFuture<Object> listenableFuture) {
            return listenableFuture;
        }
    };
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new Function<Constructor<?>, Boolean>() {
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }).reverse();

    private static class ChainingListenableFuture<I, O> extends AbstractFuture<O> implements Runnable {
        private AsyncFunction<? super I, ? extends O> function;
        private ListenableFuture<? extends I> inputFuture;
        private final CountDownLatch outputCreated;
        /* access modifiers changed from: private */
        public volatile ListenableFuture<? extends O> outputFuture;

        private ChainingListenableFuture(AsyncFunction<? super I, ? extends O> asyncFunction, ListenableFuture<? extends I> listenableFuture) {
            this.outputCreated = new CountDownLatch(1);
            this.function = (AsyncFunction) Preconditions.checkNotNull(asyncFunction);
            this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        }

        public boolean cancel(boolean z) {
            if (!super.cancel(z)) {
                return false;
            }
            cancel(this.inputFuture, z);
            cancel(this.outputFuture, z);
            return true;
        }

        private void cancel(Future<?> future, boolean z) {
            if (future != null) {
                future.cancel(z);
            }
        }

        public void run() {
            try {
                try {
                    final ListenableFuture<? extends O> listenableFuture = (ListenableFuture) Preconditions.checkNotNull(this.function.apply(Uninterruptibles.getUninterruptibly(this.inputFuture)), "AsyncFunction may not return null.");
                    this.outputFuture = listenableFuture;
                    if (isCancelled()) {
                        listenableFuture.cancel(wasInterrupted());
                        this.outputFuture = null;
                        this.function = null;
                        this.inputFuture = null;
                        this.outputCreated.countDown();
                        return;
                    }
                    listenableFuture.addListener(new Runnable() {
                        public void run() {
                            try {
                                ChainingListenableFuture.this.set(Uninterruptibles.getUninterruptibly(listenableFuture));
                            } catch (CancellationException unused) {
                                ChainingListenableFuture.this.cancel(false);
                                ChainingListenableFuture.this.outputFuture = null;
                                return;
                            } catch (ExecutionException e) {
                                ChainingListenableFuture.this.setException(e.getCause());
                            } catch (Throwable th) {
                                ChainingListenableFuture.this.outputFuture = null;
                                throw th;
                            }
                            ChainingListenableFuture.this.outputFuture = null;
                        }
                    }, MoreExecutors.sameThreadExecutor());
                    this.function = null;
                    this.inputFuture = null;
                    this.outputCreated.countDown();
                } catch (UndeclaredThrowableException e) {
                    setException(e.getCause());
                } catch (Throwable th) {
                    this.function = null;
                    this.inputFuture = null;
                    this.outputCreated.countDown();
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e2) {
                setException(e2.getCause());
            }
        }
    }

    private static class CombinedFuture<V, C> extends AbstractFuture<C> {
        private static final Logger logger = Logger.getLogger(CombinedFuture.class.getName());
        final boolean allMustSucceed;
        FutureCombiner<V, C> combiner;
        ImmutableCollection<? extends ListenableFuture<? extends V>> futures;
        final AtomicInteger remaining;
        Set<Throwable> seenExceptions;
        final Object seenExceptionsLock = new Object();
        List<Optional<V>> values;

        CombinedFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z, Executor executor, FutureCombiner<V, C> futureCombiner) {
            this.futures = immutableCollection;
            this.allMustSucceed = z;
            this.remaining = new AtomicInteger(immutableCollection.size());
            this.combiner = futureCombiner;
            this.values = Lists.newArrayListWithCapacity(immutableCollection.size());
            init(executor);
        }

        /* access modifiers changed from: protected */
        public void init(Executor executor) {
            addListener(new Runnable() {
                public void run() {
                    if (CombinedFuture.this.isCancelled()) {
                        Iterator it = CombinedFuture.this.futures.iterator();
                        while (it.hasNext()) {
                            ((ListenableFuture) it.next()).cancel(CombinedFuture.this.wasInterrupted());
                        }
                    }
                    CombinedFuture.this.futures = null;
                    CombinedFuture.this.values = null;
                    CombinedFuture.this.combiner = null;
                }
            }, MoreExecutors.sameThreadExecutor());
            if (this.futures.isEmpty()) {
                set(this.combiner.combine(ImmutableList.m8668of()));
                return;
            }
            final int i = 0;
            for (int i2 = 0; i2 < this.futures.size(); i2++) {
                this.values.add(null);
            }
            Iterator it = this.futures.iterator();
            while (it.hasNext()) {
                final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                int i3 = i + 1;
                listenableFuture.addListener(new Runnable() {
                    public void run() {
                        CombinedFuture.this.setOneValue(i, listenableFuture);
                    }
                }, executor);
                i = i3;
            }
        }

        private void setExceptionAndMaybeLog(Throwable th) {
            boolean z;
            boolean z2;
            if (this.allMustSucceed) {
                z2 = super.setException(th);
                synchronized (this.seenExceptionsLock) {
                    if (this.seenExceptions == null) {
                        this.seenExceptions = Sets.newHashSet();
                    }
                    z = this.seenExceptions.add(th);
                }
            } else {
                z2 = false;
                z = true;
            }
            if ((th instanceof Error) || (this.allMustSucceed && !z2 && z)) {
                logger.log(Level.SEVERE, "input future failed.", th);
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
            if (r0 != null) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            set(r6.combine(r0));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0078, code lost:
            if (r0 != null) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0098, code lost:
            if (r0 != null) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b7, code lost:
            if (r0 != null) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x009b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setOneValue(int r6, java.util.concurrent.Future<? extends V> r7) {
            /*
                r5 = this;
                java.util.List<com.google.common.base.Optional<V>> r0 = r5.values
                boolean r1 = r5.isDone()
                r2 = 1
                r3 = 0
                if (r1 != 0) goto L_0x000c
                if (r0 != 0) goto L_0x001f
            L_0x000c:
                boolean r1 = r5.allMustSucceed
                if (r1 != 0) goto L_0x0019
                boolean r1 = r5.isCancelled()
                if (r1 == 0) goto L_0x0017
                goto L_0x0019
            L_0x0017:
                r1 = 0
                goto L_0x001a
            L_0x0019:
                r1 = 1
            L_0x001a:
                java.lang.String r4 = "Future was done before all dependencies completed"
                com.google.common.base.Preconditions.checkState(r1, r4)
            L_0x001f:
                boolean r1 = r7.isDone()     // Catch:{ CancellationException -> 0x009b, ExecutionException -> 0x007b, Throwable -> 0x005f }
                java.lang.String r4 = "Tried to set value from future which is not done"
                com.google.common.base.Preconditions.checkState(r1, r4)     // Catch:{ CancellationException -> 0x009b, ExecutionException -> 0x007b, Throwable -> 0x005f }
                java.lang.Object r7 = com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(r7)     // Catch:{ CancellationException -> 0x009b, ExecutionException -> 0x007b, Throwable -> 0x005f }
                if (r0 == 0) goto L_0x0035
                com.google.common.base.Optional r7 = com.google.common.base.Optional.fromNullable(r7)     // Catch:{ CancellationException -> 0x009b, ExecutionException -> 0x007b, Throwable -> 0x005f }
                r0.set(r6, r7)     // Catch:{ CancellationException -> 0x009b, ExecutionException -> 0x007b, Throwable -> 0x005f }
            L_0x0035:
                java.util.concurrent.atomic.AtomicInteger r6 = r5.remaining
                int r6 = r6.decrementAndGet()
                if (r6 < 0) goto L_0x003e
                goto L_0x003f
            L_0x003e:
                r2 = 0
            L_0x003f:
                java.lang.String r7 = "Less than 0 remaining futures"
                com.google.common.base.Preconditions.checkState(r2, r7)
                if (r6 != 0) goto L_0x00ba
                com.google.common.util.concurrent.Futures$FutureCombiner<V, C> r6 = r5.combiner
                if (r6 == 0) goto L_0x0055
                if (r0 == 0) goto L_0x0055
            L_0x004c:
                java.lang.Object r6 = r6.combine(r0)
                r5.set(r6)
                goto L_0x00ba
            L_0x0055:
                boolean r6 = r5.isDone()
                com.google.common.base.Preconditions.checkState(r6)
                goto L_0x00ba
            L_0x005d:
                r6 = move-exception
                goto L_0x00bb
            L_0x005f:
                r6 = move-exception
                r5.setExceptionAndMaybeLog(r6)     // Catch:{ all -> 0x005d }
                java.util.concurrent.atomic.AtomicInteger r6 = r5.remaining
                int r6 = r6.decrementAndGet()
                if (r6 < 0) goto L_0x006c
                goto L_0x006d
            L_0x006c:
                r2 = 0
            L_0x006d:
                java.lang.String r7 = "Less than 0 remaining futures"
                com.google.common.base.Preconditions.checkState(r2, r7)
                if (r6 != 0) goto L_0x00ba
                com.google.common.util.concurrent.Futures$FutureCombiner<V, C> r6 = r5.combiner
                if (r6 == 0) goto L_0x0055
                if (r0 == 0) goto L_0x0055
                goto L_0x004c
            L_0x007b:
                r6 = move-exception
                java.lang.Throwable r6 = r6.getCause()     // Catch:{ all -> 0x005d }
                r5.setExceptionAndMaybeLog(r6)     // Catch:{ all -> 0x005d }
                java.util.concurrent.atomic.AtomicInteger r6 = r5.remaining
                int r6 = r6.decrementAndGet()
                if (r6 < 0) goto L_0x008c
                goto L_0x008d
            L_0x008c:
                r2 = 0
            L_0x008d:
                java.lang.String r7 = "Less than 0 remaining futures"
                com.google.common.base.Preconditions.checkState(r2, r7)
                if (r6 != 0) goto L_0x00ba
                com.google.common.util.concurrent.Futures$FutureCombiner<V, C> r6 = r5.combiner
                if (r6 == 0) goto L_0x0055
                if (r0 == 0) goto L_0x0055
                goto L_0x004c
            L_0x009b:
                boolean r6 = r5.allMustSucceed     // Catch:{ all -> 0x005d }
                if (r6 == 0) goto L_0x00a2
                r5.cancel(r3)     // Catch:{ all -> 0x005d }
            L_0x00a2:
                java.util.concurrent.atomic.AtomicInteger r6 = r5.remaining
                int r6 = r6.decrementAndGet()
                if (r6 < 0) goto L_0x00ab
                goto L_0x00ac
            L_0x00ab:
                r2 = 0
            L_0x00ac:
                java.lang.String r7 = "Less than 0 remaining futures"
                com.google.common.base.Preconditions.checkState(r2, r7)
                if (r6 != 0) goto L_0x00ba
                com.google.common.util.concurrent.Futures$FutureCombiner<V, C> r6 = r5.combiner
                if (r6 == 0) goto L_0x0055
                if (r0 == 0) goto L_0x0055
                goto L_0x004c
            L_0x00ba:
                return
            L_0x00bb:
                java.util.concurrent.atomic.AtomicInteger r7 = r5.remaining
                int r7 = r7.decrementAndGet()
                if (r7 < 0) goto L_0x00c4
                goto L_0x00c5
            L_0x00c4:
                r2 = 0
            L_0x00c5:
                java.lang.String r1 = "Less than 0 remaining futures"
                com.google.common.base.Preconditions.checkState(r2, r1)
                if (r7 != 0) goto L_0x00e1
                com.google.common.util.concurrent.Futures$FutureCombiner<V, C> r7 = r5.combiner
                if (r7 == 0) goto L_0x00da
                if (r0 == 0) goto L_0x00da
                java.lang.Object r7 = r7.combine(r0)
                r5.set(r7)
                goto L_0x00e1
            L_0x00da:
                boolean r7 = r5.isDone()
                com.google.common.base.Preconditions.checkState(r7)
            L_0x00e1:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Futures.CombinedFuture.setOneValue(int, java.util.concurrent.Future):void");
        }
    }

    private static class FallbackFuture<V> extends AbstractFuture<V> {
        /* access modifiers changed from: private */
        public volatile ListenableFuture<? extends V> running;

        FallbackFuture(ListenableFuture<? extends V> listenableFuture, final FutureFallback<? extends V> futureFallback, Executor executor) {
            this.running = listenableFuture;
            Futures.addCallback(this.running, new FutureCallback<V>() {
                public void onSuccess(V v) {
                    FallbackFuture.this.set(v);
                }

                public void onFailure(Throwable th) {
                    if (!FallbackFuture.this.isCancelled()) {
                        try {
                            FallbackFuture.this.running = futureFallback.create(th);
                            if (FallbackFuture.this.isCancelled()) {
                                FallbackFuture.this.running.cancel(FallbackFuture.this.wasInterrupted());
                            } else {
                                Futures.addCallback(FallbackFuture.this.running, new FutureCallback<V>() {
                                    public void onSuccess(V v) {
                                        FallbackFuture.this.set(v);
                                    }

                                    public void onFailure(Throwable th) {
                                        if (FallbackFuture.this.running.isCancelled()) {
                                            FallbackFuture.this.cancel(false);
                                        } else {
                                            FallbackFuture.this.setException(th);
                                        }
                                    }
                                }, MoreExecutors.sameThreadExecutor());
                            }
                        } catch (Throwable th2) {
                            FallbackFuture.this.setException(th2);
                        }
                    }
                }
            }, executor);
        }

        public boolean cancel(boolean z) {
            if (!super.cancel(z)) {
                return false;
            }
            this.running.cancel(z);
            return true;
        }
    }

    private interface FutureCombiner<V, C> {
        C combine(List<Optional<V>> list);
    }

    private static class ImmediateCancelledFuture<V> extends ImmediateFuture<V> {
        private final CancellationException thrown = new CancellationException("Immediate cancelled future.");

        public boolean isCancelled() {
            return true;
        }

        ImmediateCancelledFuture() {
            super();
        }

        public V get() {
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
        }
    }

    private static class ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
        private final X thrown;

        ImmediateFailedCheckedFuture(X x) {
            super();
            this.thrown = x;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }

        public V checkedGet() throws Exception {
            throw this.thrown;
        }

        public V checkedGet(long j, TimeUnit timeUnit) throws Exception {
            Preconditions.checkNotNull(timeUnit);
            throw this.thrown;
        }
    }

    private static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable thrown;

        ImmediateFailedFuture(Throwable th) {
            super();
            this.thrown = th;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }
    }

    private static abstract class ImmediateFuture<V> implements ListenableFuture<V> {
        private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());

        public boolean cancel(boolean z) {
            return false;
        }

        public abstract V get() throws ExecutionException;

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }

        private ImmediateFuture() {
        }

        public void addListener(Runnable runnable, Executor executor) {
            Preconditions.checkNotNull(runnable, "Runnable was null.");
            Preconditions.checkNotNull(executor, "Executor was null.");
            try {
                executor.execute(runnable);
            } catch (RuntimeException e) {
                Logger logger = log;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder();
                sb.append("RuntimeException while executing runnable ");
                sb.append(runnable);
                sb.append(" with executor ");
                sb.append(executor);
                logger.log(level, sb.toString(), e);
            }
        }

        public V get(long j, TimeUnit timeUnit) throws ExecutionException {
            Preconditions.checkNotNull(timeUnit);
            return get();
        }
    }

    private static class ImmediateSuccessfulCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
        private final V value;

        ImmediateSuccessfulCheckedFuture(V v) {
            super();
            this.value = v;
        }

        public V get() {
            return this.value;
        }

        public V checkedGet() {
            return this.value;
        }

        public V checkedGet(long j, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            return this.value;
        }
    }

    private static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        private final V value;

        ImmediateSuccessfulFuture(V v) {
            super();
            this.value = v;
        }

        public V get() {
            return this.value;
        }
    }

    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X> {
        final Function<Exception, X> mapper;

        MappingCheckedFuture(ListenableFuture<V> listenableFuture, Function<Exception, X> function) {
            super(listenableFuture);
            this.mapper = (Function) Preconditions.checkNotNull(function);
        }

        /* access modifiers changed from: protected */
        public X mapException(Exception exc) {
            return (Exception) this.mapper.apply(exc);
        }
    }

    private static class NonCancellationPropagatingFuture<V> extends AbstractFuture<V> {
        NonCancellationPropagatingFuture(final ListenableFuture<V> listenableFuture) {
            Preconditions.checkNotNull(listenableFuture);
            Futures.addCallback(listenableFuture, new FutureCallback<V>() {
                public void onSuccess(V v) {
                    NonCancellationPropagatingFuture.this.set(v);
                }

                public void onFailure(Throwable th) {
                    if (listenableFuture.isCancelled()) {
                        NonCancellationPropagatingFuture.this.cancel(false);
                    } else {
                        NonCancellationPropagatingFuture.this.setException(th);
                    }
                }
            }, MoreExecutors.sameThreadExecutor());
        }
    }

    private Futures() {
    }

    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> listenableFuture, Function<Exception, X> function) {
        return new MappingCheckedFuture((ListenableFuture) Preconditions.checkNotNull(listenableFuture), function);
    }

    public static <V> ListenableFuture<V> immediateFuture(V v) {
        return new ImmediateSuccessfulFuture(v);
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(V v) {
        return new ImmediateSuccessfulCheckedFuture(v);
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        return new ImmediateFailedFuture(th);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateCancelledFuture();
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X x) {
        Preconditions.checkNotNull(x);
        return new ImmediateFailedCheckedFuture(x);
    }

    public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> listenableFuture, FutureFallback<? extends V> futureFallback) {
        return withFallback(listenableFuture, futureFallback, MoreExecutors.sameThreadExecutor());
    }

    public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> listenableFuture, FutureFallback<? extends V> futureFallback, Executor executor) {
        Preconditions.checkNotNull(futureFallback);
        return new FallbackFuture(listenableFuture, futureFallback, executor);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
        return transform(listenableFuture, asyncFunction, (Executor) MoreExecutors.sameThreadExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, listenableFuture);
        listenableFuture.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function) {
        return transform(listenableFuture, function, (Executor) MoreExecutors.sameThreadExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, final Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return transform(listenableFuture, (AsyncFunction<? super I, ? extends O>) new AsyncFunction<I, O>() {
            public ListenableFuture<O> apply(I i) {
                return Futures.immediateFuture(function.apply(i));
            }
        }, executor);
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> future, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Future<O>() {
            public boolean cancel(boolean z) {
                return future.cancel(z);
            }

            public boolean isCancelled() {
                return future.isCancelled();
            }

            public boolean isDone() {
                return future.isDone();
            }

            public O get() throws InterruptedException, ExecutionException {
                return applyTransformation(future.get());
            }

            public O get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return applyTransformation(future.get(j, timeUnit));
            }

            private O applyTransformation(I i) throws ExecutionException {
                try {
                    return function.apply(i);
                } catch (Throwable th) {
                    throw new ExecutionException(th);
                }
            }
        };
    }

    public static <V> ListenableFuture<V> dereference(ListenableFuture<? extends ListenableFuture<? extends V>> listenableFuture) {
        return transform(listenableFuture, DEREFERENCER);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return listFuture(ImmutableList.copyOf((E[]) listenableFutureArr), true, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return listFuture(ImmutableList.copyOf(iterable), true, MoreExecutors.sameThreadExecutor());
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        return new NonCancellationPropagatingFuture(listenableFuture);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return listFuture(ImmutableList.copyOf((E[]) listenableFutureArr), false, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return listFuture(ImmutableList.copyOf(iterable), false, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        final ConcurrentLinkedQueue newConcurrentLinkedQueue = Queues.newConcurrentLinkedQueue();
        Builder builder = ImmutableList.builder();
        SerializingExecutor serializingExecutor = new SerializingExecutor(MoreExecutors.sameThreadExecutor());
        for (final ListenableFuture listenableFuture : iterable) {
            AsyncSettableFuture create = AsyncSettableFuture.create();
            newConcurrentLinkedQueue.add(create);
            listenableFuture.addListener(new Runnable() {
                public void run() {
                    ((AsyncSettableFuture) newConcurrentLinkedQueue.remove()).setFuture(listenableFuture);
                }
            }, serializingExecutor);
            builder.add((Object) create);
        }
        return builder.build();
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback) {
        addCallback(listenableFuture, futureCallback, MoreExecutors.sameThreadExecutor());
    }

    public static <V> void addCallback(final ListenableFuture<V> listenableFuture, final FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new Runnable() {
            public void run() {
                try {
                    futureCallback.onSuccess(Uninterruptibles.getUninterruptibly(listenableFuture));
                } catch (ExecutionException e) {
                    futureCallback.onFailure(e.getCause());
                } catch (RuntimeException e2) {
                    futureCallback.onFailure(e2);
                } catch (Error e3) {
                    futureCallback.onFailure(e3);
                }
            }
        }, executor);
    }

    public static <V, X extends Exception> V get(Future<V> future, Class<X> cls) throws Exception {
        Preconditions.checkNotNull(future);
        Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(cls), "Futures.get exception type (%s) must not be a RuntimeException", cls);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e);
        } catch (ExecutionException e2) {
            wrapAndThrowExceptionOrError(e2.getCause(), cls);
            throw new AssertionError();
        }
    }

    public static <V, X extends Exception> V get(Future<V> future, long j, TimeUnit timeUnit, Class<X> cls) throws Exception {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(cls), "Futures.get exception type (%s) must not be a RuntimeException", cls);
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e);
        } catch (TimeoutException e2) {
            throw newWithCause(cls, e2);
        } catch (ExecutionException e3) {
            wrapAndThrowExceptionOrError(e3.getCause(), cls);
            throw new AssertionError();
        }
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw newWithCause(cls, th);
        }
    }

    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e) {
            wrapAndThrowUnchecked(e.getCause());
            throw new AssertionError();
        }
    }

    private static void wrapAndThrowUnchecked(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    private static <X extends Exception> X newWithCause(Class<X> cls, Throwable th) {
        for (Constructor newFromConstructor : preferringStrings(Arrays.asList(cls.getConstructors()))) {
            X x = (Exception) newFromConstructor(newFromConstructor, th);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No appropriate constructor for exception of type ");
        sb.append(cls);
        sb.append(" in response to chained exception");
        throw new IllegalArgumentException(sb.toString(), th);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> list) {
        return WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }

    private static <X> X newFromConstructor(Constructor<X> constructor, Throwable th) {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalArgumentException unused) {
            return null;
        } catch (InstantiationException unused2) {
            return null;
        } catch (IllegalAccessException unused3) {
            return null;
        } catch (InvocationTargetException unused4) {
            return null;
        }
    }

    private static <V> ListenableFuture<List<V>> listFuture(ImmutableList<ListenableFuture<? extends V>> immutableList, boolean z, Executor executor) {
        return new CombinedFuture(immutableList, z, executor, new FutureCombiner<V, List<V>>() {
            public List<V> combine(List<Optional<V>> list) {
                ArrayList newArrayList = Lists.newArrayList();
                for (Optional optional : list) {
                    newArrayList.add(optional != null ? optional.orNull() : null);
                }
                return Collections.unmodifiableList(newArrayList);
            }
        });
    }
}
