package p000a.p013b.p014a.p016b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p000a.p013b.C0350q;
import p000a.p013b.C0350q.C0352b;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p017b.C0162c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.a.b.b */
/* compiled from: HandlerScheduler */
final class C0156b extends C0350q {

    /* renamed from: b */
    private final Handler f373b;

    /* renamed from: c */
    private final boolean f374c;

    /* renamed from: a.b.a.b.b$a */
    /* compiled from: HandlerScheduler */
    private static final class C0157a extends C0352b {

        /* renamed from: a */
        private final Handler f375a;

        /* renamed from: b */
        private final boolean f376b;

        /* renamed from: c */
        private volatile boolean f377c;

        C0157a(Handler handler, boolean z) {
            this.f375a = handler;
            this.f376b = z;
        }

        @SuppressLint({"NewApi"})
        /* renamed from: a */
        public C0161b mo336a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f377c) {
                return C0162c.m565a();
            } else {
                C0158b bVar = new C0158b(this.f375a, C0324a.m883a(runnable));
                Message obtain = Message.obtain(this.f375a, bVar);
                obtain.obj = this;
                if (this.f376b) {
                    obtain.setAsynchronous(true);
                }
                this.f375a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.f377c) {
                    return bVar;
                }
                this.f375a.removeCallbacks(bVar);
                return C0162c.m565a();
            }
        }

        public void dispose() {
            this.f377c = true;
            this.f375a.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: a.b.a.b.b$b */
    /* compiled from: HandlerScheduler */
    private static final class C0158b implements C0161b, Runnable {

        /* renamed from: a */
        private final Handler f378a;

        /* renamed from: b */
        private final Runnable f379b;

        /* renamed from: c */
        private volatile boolean f380c;

        C0158b(Handler handler, Runnable runnable) {
            this.f378a = handler;
            this.f379b = runnable;
        }

        public void run() {
            try {
                this.f379b.run();
            } catch (Throwable th) {
                C0324a.m885a(th);
            }
        }

        public void dispose() {
            this.f378a.removeCallbacks(this);
            this.f380c = true;
        }
    }

    C0156b(Handler handler, boolean z) {
        this.f373b = handler;
        this.f374c = z;
    }

    /* renamed from: a */
    public C0161b mo334a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C0158b bVar = new C0158b(this.f373b, C0324a.m883a(runnable));
            this.f373b.postDelayed(bVar, timeUnit.toMillis(j));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* renamed from: a */
    public C0352b mo335a() {
        return new C0157a(this.f373b, this.f374c);
    }
}
