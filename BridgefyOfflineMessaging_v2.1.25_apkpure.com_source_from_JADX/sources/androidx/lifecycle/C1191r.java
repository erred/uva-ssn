package androidx.lifecycle;

import java.util.HashMap;

/* renamed from: androidx.lifecycle.r */
/* compiled from: ViewModelStore */
public class C1191r {

    /* renamed from: a */
    private final HashMap<String, C1188p> f3589a = new HashMap<>();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo4626a(String str, C1188p pVar) {
        C1188p pVar2 = (C1188p) this.f3589a.put(str, pVar);
        if (pVar2 != null) {
            pVar2.mo4620a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C1188p mo4624a(String str) {
        return (C1188p) this.f3589a.get(str);
    }

    /* renamed from: a */
    public final void mo4625a() {
        for (C1188p a : this.f3589a.values()) {
            a.mo4620a();
        }
        this.f3589a.clear();
    }
}
