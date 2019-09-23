package p091b.p092a;

/* renamed from: b.a.b */
/* compiled from: NamedRunnable */
public abstract class C1498b implements Runnable {

    /* renamed from: b */
    protected final String f4511b;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo6226c();

    public C1498b(String str, Object... objArr) {
        this.f4511b = C1508c.m6075a(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f4511b);
        try {
            mo6226c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
