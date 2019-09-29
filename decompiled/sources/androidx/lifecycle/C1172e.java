package androidx.lifecycle;

/* renamed from: androidx.lifecycle.e */
/* compiled from: Lifecycle */
public abstract class C1172e {

    /* renamed from: androidx.lifecycle.e$a */
    /* compiled from: Lifecycle */
    public enum C1173a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* renamed from: androidx.lifecycle.e$b */
    /* compiled from: Lifecycle */
    public enum C1174b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public boolean mo4604a(C1174b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    /* renamed from: a */
    public abstract C1174b mo4601a();

    /* renamed from: a */
    public abstract void mo4602a(C1175f fVar);

    /* renamed from: b */
    public abstract void mo4603b(C1175f fVar);
}
