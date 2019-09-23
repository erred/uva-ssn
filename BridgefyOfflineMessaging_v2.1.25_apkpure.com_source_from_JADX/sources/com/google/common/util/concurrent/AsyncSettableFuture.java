package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

final class AsyncSettableFuture<V> extends ForwardingListenableFuture<V> {
    private final ListenableFuture<V> dereferenced = Futures.dereference(this.nested);
    private final NestedFuture<V> nested = new NestedFuture<>();

    private static final class NestedFuture<V> extends AbstractFuture<ListenableFuture<? extends V>> {
        private NestedFuture() {
        }

        /* access modifiers changed from: 0000 */
        public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
            boolean z = set(listenableFuture);
            if (isCancelled()) {
                listenableFuture.cancel(wasInterrupted());
            }
            return z;
        }
    }

    public static <V> AsyncSettableFuture<V> create() {
        return new AsyncSettableFuture<>();
    }

    private AsyncSettableFuture() {
    }

    /* access modifiers changed from: protected */
    public ListenableFuture<V> delegate() {
        return this.dereferenced;
    }

    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return this.nested.setFuture((ListenableFuture) Preconditions.checkNotNull(listenableFuture));
    }

    public boolean setValue(V v) {
        return setFuture(Futures.immediateFuture(v));
    }

    public boolean setException(Throwable th) {
        return setFuture(Futures.immediateFailedFuture(th));
    }

    public boolean isSet() {
        return this.nested.isDone();
    }
}
