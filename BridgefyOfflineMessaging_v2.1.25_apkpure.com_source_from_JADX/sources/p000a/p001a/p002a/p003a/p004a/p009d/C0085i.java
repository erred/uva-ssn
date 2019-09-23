package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;

/* renamed from: a.a.a.a.a.d.i */
/* compiled from: TimeBasedFileRollOverRunnable */
public class C0085i implements Runnable {

    /* renamed from: a */
    private final Context f173a;

    /* renamed from: b */
    private final C0081e f174b;

    public C0085i(Context context, C0081e eVar) {
        this.f173a = context;
        this.f174b = eVar;
    }

    public void run() {
        try {
            C0020i.m67a(this.f173a, "Performing time based file roll over.");
            if (!this.f174b.mo178c()) {
                this.f174b.mo179d();
            }
        } catch (Exception e) {
            C0020i.m68a(this.f173a, "Failed to roll over file", (Throwable) e);
        }
    }
}
