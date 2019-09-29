package p000a.p001a.p002a.p003a.p004a.p007c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
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

/* renamed from: a.a.a.a.a.c.a */
/* compiled from: AsyncTask */
public abstract class C0044a<Params, Progress, Result> {

    /* renamed from: a */
    private static final int f103a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    public static final Executor f104b;

    /* renamed from: c */
    public static final Executor f105c = new C0051c();

    /* renamed from: d */
    private static final int f106d = (f103a + 1);

    /* renamed from: e */
    private static final int f107e = ((f103a * 2) + 1);

    /* renamed from: f */
    private static final ThreadFactory f108f = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f117a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncTask #");
            sb.append(this.f117a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    };

    /* renamed from: g */
    private static final BlockingQueue<Runnable> f109g = new LinkedBlockingQueue(128);

    /* renamed from: h */
    private static final C0050b f110h = new C0050b();

    /* renamed from: i */
    private static volatile Executor f111i = f105c;

    /* renamed from: j */
    private final C0054e<Params, Result> f112j = new C0054e<Params, Result>() {
        public Result call() throws Exception {
            C0044a.this.f116n.set(true);
            Process.setThreadPriority(10);
            return C0044a.this.m167e(C0044a.this.mo85a((Params[]) this.f131b));
        }
    };

    /* renamed from: k */
    private final FutureTask<Result> f113k = new FutureTask<Result>(this.f112j) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                C0044a.this.m166d(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                C0044a.this.m166d(null);
            }
        }
    };

    /* renamed from: l */
    private volatile C0053d f114l = C0053d.PENDING;

    /* renamed from: m */
    private final AtomicBoolean f115m = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f116n = new AtomicBoolean();

    /* renamed from: a.a.a.a.a.c.a$a */
    /* compiled from: AsyncTask */
    private static class C0049a<Data> {

        /* renamed from: a */
        final C0044a f121a;

        /* renamed from: b */
        final Data[] f122b;

        C0049a(C0044a aVar, Data... dataArr) {
            this.f121a = aVar;
            this.f122b = dataArr;
        }
    }

    /* renamed from: a.a.a.a.a.c.a$b */
    /* compiled from: AsyncTask */
    private static class C0050b extends Handler {
        public C0050b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C0049a aVar = (C0049a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.f121a.m168f(aVar.f122b[0]);
                    return;
                case 2:
                    aVar.f121a.mo90b((Progress[]) aVar.f122b);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a.a.a.a.a.c.a$c */
    /* compiled from: AsyncTask */
    private static class C0051c implements Executor {

        /* renamed from: a */
        final LinkedList<Runnable> f123a;

        /* renamed from: b */
        Runnable f124b;

        private C0051c() {
            this.f123a = new LinkedList<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f123a.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        C0051c.this.mo98a();
                    }
                }
            });
            if (this.f124b == null) {
                mo98a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public synchronized void mo98a() {
            Runnable runnable = (Runnable) this.f123a.poll();
            this.f124b = runnable;
            if (runnable != null) {
                C0044a.f104b.execute(this.f124b);
            }
        }
    }

    /* renamed from: a.a.a.a.a.c.a$d */
    /* compiled from: AsyncTask */
    public enum C0053d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: a.a.a.a.a.c.a$e */
    /* compiled from: AsyncTask */
    private static abstract class C0054e<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        Params[] f131b;

        private C0054e() {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Result mo85a(Params... paramsArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo86a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo87a(Result result) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo90b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d_ */
    public void mo92d_() {
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f106d, f107e, 1, TimeUnit.SECONDS, f109g, f108f);
        f104b = threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m166d(Result result) {
        if (!this.f116n.get()) {
            m167e(result);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Result m167e(Result result) {
        f110h.obtainMessage(1, new C0049a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: c_ */
    public final C0053d mo91c_() {
        return this.f114l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo89b(Result result) {
        mo92d_();
    }

    /* renamed from: e */
    public final boolean mo93e() {
        return this.f115m.get();
    }

    /* renamed from: a */
    public final boolean mo88a(boolean z) {
        this.f115m.set(true);
        return this.f113k.cancel(z);
    }

    /* renamed from: a */
    public final C0044a<Params, Progress, Result> mo84a(Executor executor, Params... paramsArr) {
        if (this.f114l != C0053d.PENDING) {
            switch (this.f114l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f114l = C0053d.RUNNING;
        mo86a();
        this.f112j.f131b = paramsArr;
        executor.execute(this.f113k);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m168f(Result result) {
        if (mo93e()) {
            mo89b(result);
        } else {
            mo87a(result);
        }
        this.f114l = C0053d.FINISHED;
    }
}
