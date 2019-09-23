package p000a.p001a.p002a.p003a.p004a.p007c.p008a;

/* renamed from: a.a.a.a.a.c.a.e */
/* compiled from: RetryState */
public class C0059e {

    /* renamed from: a */
    private final int f135a;

    /* renamed from: b */
    private final C0055a f136b;

    /* renamed from: c */
    private final C0058d f137c;

    public C0059e(C0055a aVar, C0058d dVar) {
        this(0, aVar, dVar);
    }

    public C0059e(int i, C0055a aVar, C0058d dVar) {
        this.f135a = i;
        this.f136b = aVar;
        this.f137c = dVar;
    }

    /* renamed from: a */
    public long mo102a() {
        return this.f136b.mo101a(this.f135a);
    }

    /* renamed from: b */
    public C0059e mo103b() {
        return new C0059e(this.f135a + 1, this.f136b, this.f137c);
    }

    /* renamed from: c */
    public C0059e mo104c() {
        return new C0059e(this.f136b, this.f137c);
    }
}
