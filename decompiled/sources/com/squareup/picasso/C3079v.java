package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.C3068t.C3075e;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.squareup.picasso.v */
/* compiled from: PicassoExecutorService */
class C3079v extends ThreadPoolExecutor {

    /* renamed from: com.squareup.picasso.v$a */
    /* compiled from: PicassoExecutorService */
    private static final class C3080a extends FutureTask<C3035c> implements Comparable<C3080a> {

        /* renamed from: a */
        private final C3035c f8068a;

        C3080a(C3035c cVar) {
            super(cVar, null);
            this.f8068a = cVar;
        }

        /* renamed from: a */
        public int compareTo(C3080a aVar) {
            C3075e n = this.f8068a.mo27472n();
            C3075e n2 = aVar.f8068a.mo27472n();
            return n == n2 ? this.f8068a.f7932a - aVar.f8068a.f7932a : n2.ordinal() - n.ordinal();
        }
    }

    C3079v() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C3033b());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27554a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m9080a(3);
            return;
        }
        int type = networkInfo.getType();
        if (!(type == 6 || type == 9)) {
            switch (type) {
                case 0:
                    int subtype = networkInfo.getSubtype();
                    switch (subtype) {
                        case 1:
                        case 2:
                            m9080a(1);
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            m9080a(2);
                            break;
                        default:
                            switch (subtype) {
                                case 12:
                                    break;
                                case 13:
                                case 14:
                                case 15:
                                    m9080a(3);
                                    break;
                                default:
                                    m9080a(3);
                                    break;
                            }
                            m9080a(2);
                            break;
                    }
                case 1:
                    break;
                default:
                    m9080a(3);
                    break;
            }
        }
        m9080a(4);
    }

    /* renamed from: a */
    private void m9080a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public Future<?> submit(Runnable runnable) {
        C3080a aVar = new C3080a((C3035c) runnable);
        execute(aVar);
        return aVar;
    }
}
