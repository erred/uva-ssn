package androidx.p043a.p044a.p045a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.a.a.a.b */
/* compiled from: DefaultTaskExecutor */
public class C0409b extends C0411c {

    /* renamed from: a */
    private final Object f829a = new Object();

    /* renamed from: b */
    private final ExecutorService f830b = Executors.newFixedThreadPool(2, new ThreadFactory() {

        /* renamed from: b */
        private final AtomicInteger f833b = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f833b.getAndIncrement())}));
            return thread;
        }
    });

    /* renamed from: c */
    private volatile Handler f831c;

    /* renamed from: a */
    public void mo766a(Runnable runnable) {
        this.f830b.execute(runnable);
    }

    /* renamed from: b */
    public void mo767b(Runnable runnable) {
        if (this.f831c == null) {
            synchronized (this.f829a) {
                if (this.f831c == null) {
                    this.f831c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f831c.post(runnable);
    }

    /* renamed from: b */
    public boolean mo768b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
