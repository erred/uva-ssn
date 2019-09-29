package p000a.p001a.p002a.p003a.p004a.p006b;

/* renamed from: a.a.a.a.a.b.l */
/* compiled from: DeliveryMechanism */
public enum C0026l {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: e */
    private final int f48e;

    private C0026l(int i) {
        this.f48e = i;
    }

    /* renamed from: a */
    public int mo50a() {
        return this.f48e;
    }

    public String toString() {
        return Integer.toString(this.f48e);
    }

    /* renamed from: a */
    public static C0026l m99a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
