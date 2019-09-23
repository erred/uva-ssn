package p000a.p013b.p020e.p032g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: a.b.e.g.i */
/* compiled from: SchedulerPoolFactory */
public final class C0295i {

    /* renamed from: a */
    public static final boolean f619a;

    /* renamed from: b */
    public static final int f620b;

    /* renamed from: c */
    static final AtomicReference<ScheduledExecutorService> f621c = new AtomicReference<>();

    /* renamed from: d */
    static final Map<ScheduledThreadPoolExecutor, Object> f622d = new ConcurrentHashMap();

    /* renamed from: a.b.e.g.i$a */
    /* compiled from: SchedulerPoolFactory */
    static final class C0296a {

        /* renamed from: a */
        boolean f623a;

        /* renamed from: b */
        int f624b;

        C0296a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo499a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f623a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f623a = true;
            }
            if (!this.f623a || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f624b = 1;
                return;
            }
            try {
                this.f624b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f624b = 1;
            }
        }
    }

    /* renamed from: a.b.e.g.i$b */
    /* compiled from: SchedulerPoolFactory */
    static final class C0297b implements Runnable {
        C0297b() {
        }

        public void run() {
            Iterator it = new ArrayList(C0295i.f622d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    C0295i.f622d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        C0296a aVar = new C0296a();
        aVar.mo499a(properties);
        f619a = aVar.f623a;
        f620b = aVar.f624b;
        m788a();
    }

    /* renamed from: a */
    public static void m788a() {
        m789a(f619a);
    }

    /* renamed from: a */
    static void m789a(boolean z) {
        if (z) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) f621c.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new C0291f("RxSchedulerPurge"));
                    if (f621c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        newScheduledThreadPool.scheduleAtFixedRate(new C0297b(), (long) f620b, (long) f620b, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m787a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        m790a(f619a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    /* renamed from: a */
    static void m790a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f622d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }
}
