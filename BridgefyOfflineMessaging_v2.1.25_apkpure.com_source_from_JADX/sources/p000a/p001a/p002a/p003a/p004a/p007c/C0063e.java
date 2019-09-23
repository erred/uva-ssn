package p000a.p001a.p002a.p003a.p004a.p007c;

/* renamed from: a.a.a.a.a.c.e */
/* compiled from: Priority */
public enum C0063e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    /* renamed from: a */
    static <Y> int m199a(C0069i iVar, Y y) {
        C0063e eVar;
        if (y instanceof C0069i) {
            eVar = ((C0069i) y).mo135b();
        } else {
            eVar = NORMAL;
        }
        return eVar.ordinal() - iVar.mo135b().ordinal();
    }
}
