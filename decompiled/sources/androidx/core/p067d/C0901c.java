package androidx.core.p067d;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;

/* renamed from: androidx.core.d.c */
/* compiled from: SelfDestructiveThread */
public class C0901c {

    /* renamed from: a */
    private final Object f2879a = new Object();

    /* renamed from: b */
    private HandlerThread f2880b;

    /* renamed from: c */
    private Handler f2881c;

    /* renamed from: d */
    private int f2882d;

    /* renamed from: e */
    private Callback f2883e = new Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C0901c.this.mo3602a();
                    return true;
                case 1:
                    C0901c.this.mo3603a((Runnable) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    };

    /* renamed from: f */
    private final int f2884f;

    /* renamed from: g */
    private final int f2885g;

    /* renamed from: h */
    private final String f2886h;

    /* renamed from: androidx.core.d.c$a */
    /* compiled from: SelfDestructiveThread */
    public interface C0906a<T> {
        /* renamed from: a */
        void mo3590a(T t);
    }

    public C0901c(String str, int i, int i2) {
        this.f2886h = str;
        this.f2885g = i;
        this.f2884f = i2;
        this.f2882d = 0;
    }

    /* renamed from: b */
    private void m3338b(Runnable runnable) {
        synchronized (this.f2879a) {
            if (this.f2880b == null) {
                this.f2880b = new HandlerThread(this.f2886h, this.f2885g);
                this.f2880b.start();
                this.f2881c = new Handler(this.f2880b.getLooper(), this.f2883e);
                this.f2882d++;
            }
            this.f2881c.removeMessages(0);
            this.f2881c.sendMessage(this.f2881c.obtainMessage(1, runnable));
        }
    }

    /* renamed from: a */
    public <T> void mo3604a(final Callable<T> callable, final C0906a<T> aVar) {
        final Handler handler = new Handler();
        m3338b(new Runnable() {
            public void run() {
                final Object obj;
                try {
                    obj = callable.call();
                } catch (Exception unused) {
                    obj = null;
                }
                handler.post(new Runnable() {
                    public void run() {
                        aVar.mo3590a(obj);
                    }
                });
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|(4:26|15|16|17)(1:18)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T mo3601a(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.d.c$3 r11 = new androidx.core.d.c$3
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r2, r3, r4, r5, r6)
            r12.m3338b(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005d }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005d }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005d }
            long r0 = (long) r14     // Catch:{ all -> 0x005d }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005d }
        L_0x003b:
            long r0 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x0040 }
            r13 = r0
        L_0x0040:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x004e
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005d }
            r7.unlock()
            return r13
        L_0x004e:
            r0 = 0
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0055
            goto L_0x003b
        L_0x0055:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005d }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005d }
            throw r13     // Catch:{ all -> 0x005d }
        L_0x005d:
            r13 = move-exception
            r7.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p067d.C0901c.mo3601a(java.util.concurrent.Callable, int):java.lang.Object");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3603a(Runnable runnable) {
        runnable.run();
        synchronized (this.f2879a) {
            this.f2881c.removeMessages(0);
            this.f2881c.sendMessageDelayed(this.f2881c.obtainMessage(0), (long) this.f2884f);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3602a() {
        synchronized (this.f2879a) {
            if (!this.f2881c.hasMessages(1)) {
                this.f2880b.quit();
                this.f2880b = null;
                this.f2881c = null;
            }
        }
    }
}
