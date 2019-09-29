package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public abstract class AbstractListeningExecutorService implements ListeningExecutorService {
    public ListenableFuture<?> submit(Runnable runnable) {
        ListenableFutureTask create = ListenableFutureTask.create(runnable, null);
        execute(create);
        return create;
    }

    public <T> ListenableFuture<T> submit(Runnable runnable, T t) {
        ListenableFutureTask create = ListenableFutureTask.create(runnable, t);
        execute(create);
        return create;
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        ListenableFutureTask create = ListenableFutureTask.create(callable);
        execute(create);
        return create;
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        try {
            return MoreExecutors.invokeAnyImpl(this, collection, false, 0);
        } catch (TimeoutException unused) {
            throw new AssertionError();
        }
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return MoreExecutors.invokeAnyImpl(this, collection, true, timeUnit.toNanos(j));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        if (collection != null) {
            ArrayList<Future> arrayList = new ArrayList<>(collection.size());
            try {
                for (Callable create : collection) {
                    ListenableFutureTask create2 = ListenableFutureTask.create(create);
                    arrayList.add(create2);
                    execute(create2);
                }
                for (Future future : arrayList) {
                    if (!future.isDone()) {
                        try {
                            future.get();
                        } catch (CancellationException | ExecutionException unused) {
                        }
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                for (Future cancel : arrayList) {
                    cancel.cancel(true);
                }
                throw th;
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> r9, long r10, java.util.concurrent.TimeUnit r12) throws java.lang.InterruptedException {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00d3
            if (r12 == 0) goto L_0x00d3
            long r10 = r12.toNanos(r10)
            java.util.ArrayList r12 = new java.util.ArrayList
            int r0 = r9.size()
            r12.<init>(r0)
            r0 = 1
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x00bd }
        L_0x0016:
            boolean r1 = r9.hasNext()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r9.next()     // Catch:{ all -> 0x00bd }
            java.util.concurrent.Callable r1 = (java.util.concurrent.Callable) r1     // Catch:{ all -> 0x00bd }
            com.google.common.util.concurrent.ListenableFutureTask r1 = com.google.common.util.concurrent.ListenableFutureTask.create(r1)     // Catch:{ all -> 0x00bd }
            r12.add(r1)     // Catch:{ all -> 0x00bd }
            goto L_0x0016
        L_0x002a:
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00bd }
            java.util.Iterator r9 = r12.iterator()     // Catch:{ all -> 0x00bd }
        L_0x0032:
            boolean r3 = r9.hasNext()     // Catch:{ all -> 0x00bd }
            r4 = 0
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x00bd }
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x00bd }
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x00bd }
            r8.execute(r3)     // Catch:{ all -> 0x00bd }
            long r6 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00bd }
            r3 = 0
            long r1 = r6 - r1
            long r10 = r10 - r1
            int r1 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x0066
            java.util.Iterator r9 = r12.iterator()
        L_0x0055:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0065
            java.lang.Object r10 = r9.next()
            java.util.concurrent.Future r10 = (java.util.concurrent.Future) r10
            r10.cancel(r0)
            goto L_0x0055
        L_0x0065:
            return r12
        L_0x0066:
            r1 = r6
            goto L_0x0032
        L_0x0068:
            java.util.Iterator r9 = r12.iterator()     // Catch:{ all -> 0x00bd }
        L_0x006c:
            boolean r3 = r9.hasNext()     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x00bc
            java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x00bd }
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3     // Catch:{ all -> 0x00bd }
            boolean r6 = r3.isDone()     // Catch:{ all -> 0x00bd }
            if (r6 != 0) goto L_0x006c
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0097
            java.util.Iterator r9 = r12.iterator()
        L_0x0086:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0096
            java.lang.Object r10 = r9.next()
            java.util.concurrent.Future r10 = (java.util.concurrent.Future) r10
            r10.cancel(r0)
            goto L_0x0086
        L_0x0096:
            return r12
        L_0x0097:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ CancellationException | ExecutionException -> 0x00b2, TimeoutException -> 0x009d }
            r3.get(r10, r6)     // Catch:{ CancellationException | ExecutionException -> 0x00b2, TimeoutException -> 0x009d }
            goto L_0x00b2
        L_0x009d:
            java.util.Iterator r9 = r12.iterator()
        L_0x00a1:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00b1
            java.lang.Object r10 = r9.next()
            java.util.concurrent.Future r10 = (java.util.concurrent.Future) r10
            r10.cancel(r0)
            goto L_0x00a1
        L_0x00b1:
            return r12
        L_0x00b2:
            long r6 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00bd }
            r3 = 0
            long r1 = r6 - r1
            long r10 = r10 - r1
            r1 = r6
            goto L_0x006c
        L_0x00bc:
            return r12
        L_0x00bd:
            r9 = move-exception
            java.util.Iterator r10 = r12.iterator()
        L_0x00c2:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00d2
            java.lang.Object r11 = r10.next()
            java.util.concurrent.Future r11 = (java.util.concurrent.Future) r11
            r11.cancel(r0)
            goto L_0x00c2
        L_0x00d2:
            throw r9
        L_0x00d3:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractListeningExecutorService.invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit):java.util.List");
    }
}
