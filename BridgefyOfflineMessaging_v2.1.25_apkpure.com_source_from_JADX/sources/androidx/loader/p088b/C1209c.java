package androidx.loader.p088b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.loader.b.c */
/* compiled from: ModernAsyncTask */
abstract class C1209c<Params, Progress, Result> {

    /* renamed from: a */
    private static final ThreadFactory f3608a = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f3618a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ModernAsyncTask #");
            sb.append(this.f3618a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    };

    /* renamed from: b */
    private static final BlockingQueue<Runnable> f3609b = new LinkedBlockingQueue(10);

    /* renamed from: c */
    public static final Executor f3610c;

    /* renamed from: f */
    private static C1215b f3611f;

    /* renamed from: g */
    private static volatile Executor f3612g = f3610c;

    /* renamed from: d */
    final AtomicBoolean f3613d = new AtomicBoolean();

    /* renamed from: e */
    final AtomicBoolean f3614e = new AtomicBoolean();

    /* renamed from: h */
    private final C1217d<Params, Result> f3615h = new C1217d<Params, Result>() {
        public Result call() throws Exception {
            C1209c.this.f3614e.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                Result a = C1209c.this.mo4665a((Params[]) this.f3628b);
                try {
                    Binder.flushPendingCommands();
                    C1209c.this.mo4705d(a);
                    return a;
                } catch (Throwable th) {
                    th = th;
                    obj = a;
                    C1209c.this.mo4705d(obj);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C1209c.this.f3613d.set(true);
                throw th;
            }
        }
    };

    /* renamed from: i */
    private final FutureTask<Result> f3616i = new FutureTask<Result>(this.f3615h) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                C1209c.this.mo4704c(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                C1209c.this.mo4704c(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* renamed from: j */
    private volatile C1216c f3617j = C1216c.PENDING;

    /* renamed from: androidx.loader.b.c$a */
    /* compiled from: ModernAsyncTask */
    private static class C1214a<Data> {

        /* renamed from: a */
        final C1209c f3622a;

        /* renamed from: b */
        final Data[] f3623b;

        C1214a(C1209c cVar, Data... dataArr) {
            this.f3622a = cVar;
            this.f3623b = dataArr;
        }
    }

    /* renamed from: androidx.loader.b.c$b */
    /* compiled from: ModernAsyncTask */
    private static class C1215b extends Handler {
        C1215b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C1214a aVar = (C1214a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.f3622a.mo4707e(aVar.f3623b[0]);
                    return;
                case 2:
                    aVar.f3622a.mo4702b((Progress[]) aVar.f3623b);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: androidx.loader.b.c$c */
    /* compiled from: ModernAsyncTask */
    public enum C1216c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: androidx.loader.b.c$d */
    /* compiled from: ModernAsyncTask */
    private static abstract class C1217d<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        Params[] f3628b;

        C1217d() {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo4665a(Params... paramsArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4668a(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4701b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4702b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4703c() {
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f3609b, f3608a);
        f3610c = threadPoolExecutor;
    }

    /* renamed from: a */
    private static Handler mo4667a() {
        C1215b bVar;
        synchronized (C1209c.class) {
            if (f3611f == null) {
                f3611f = new C1215b();
            }
            bVar = f3611f;
        }
        return bVar;
    }

    C1209c() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4704c(Result result) {
        if (!this.f3614e.get()) {
            mo4705d(result);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Result mo4705d(Result result) {
        mo4667a().obtainMessage(1, new C1214a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4669b(Result result) {
        mo4703c();
    }

    /* renamed from: d */
    public final boolean mo4706d() {
        return this.f3613d.get();
    }

    /* renamed from: a */
    public final boolean mo4700a(boolean z) {
        this.f3613d.set(true);
        return this.f3616i.cancel(z);
    }

    /* renamed from: a */
    public final C1209c<Params, Progress, Result> mo4699a(Executor executor, Params... paramsArr) {
        if (this.f3617j != C1216c.PENDING) {
            switch (this.f3617j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                default:
                    throw new IllegalStateException("We should never reach this state");
            }
        } else {
            this.f3617j = C1216c.RUNNING;
            mo4701b();
            this.f3615h.f3628b = paramsArr;
            executor.execute(this.f3616i);
            return this;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo4707e(Result result) {
        if (mo4706d()) {
            mo4669b(result);
        } else {
            mo4668a(result);
        }
        this.f3617j = C1216c.FINISHED;
    }
}
