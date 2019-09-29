package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.p070g.C0969v;
import androidx.core.p070g.C0973w;
import androidx.core.p070g.C0974x;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.appcompat.view.h */
/* compiled from: ViewPropertyAnimatorCompatSet */
public class C0515h {

    /* renamed from: a */
    final ArrayList<C0969v> f1274a = new ArrayList<>();

    /* renamed from: b */
    C0973w f1275b;

    /* renamed from: c */
    private long f1276c = -1;

    /* renamed from: d */
    private Interpolator f1277d;

    /* renamed from: e */
    private boolean f1278e;

    /* renamed from: f */
    private final C0974x f1279f = new C0974x() {

        /* renamed from: b */
        private boolean f1281b = false;

        /* renamed from: c */
        private int f1282c = 0;

        /* renamed from: a */
        public void mo1028a(View view) {
            if (!this.f1281b) {
                this.f1281b = true;
                if (C0515h.this.f1275b != null) {
                    C0515h.this.f1275b.mo1028a(null);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo1297a() {
            this.f1282c = 0;
            this.f1281b = false;
            C0515h.this.mo1295b();
        }

        /* renamed from: b */
        public void mo1029b(View view) {
            int i = this.f1282c + 1;
            this.f1282c = i;
            if (i == C0515h.this.f1274a.size()) {
                if (C0515h.this.f1275b != null) {
                    C0515h.this.f1275b.mo1029b(null);
                }
                mo1297a();
            }
        }
    };

    /* renamed from: a */
    public C0515h mo1291a(C0969v vVar) {
        if (!this.f1278e) {
            this.f1274a.add(vVar);
        }
        return this;
    }

    /* renamed from: a */
    public C0515h mo1292a(C0969v vVar, C0969v vVar2) {
        this.f1274a.add(vVar);
        vVar2.mo3769b(vVar.mo3762a());
        this.f1274a.add(vVar2);
        return this;
    }

    /* renamed from: a */
    public void mo1294a() {
        if (!this.f1278e) {
            Iterator it = this.f1274a.iterator();
            while (it.hasNext()) {
                C0969v vVar = (C0969v) it.next();
                if (this.f1276c >= 0) {
                    vVar.mo3764a(this.f1276c);
                }
                if (this.f1277d != null) {
                    vVar.mo3765a(this.f1277d);
                }
                if (this.f1275b != null) {
                    vVar.mo3766a((C0973w) this.f1279f);
                }
                vVar.mo3771c();
            }
            this.f1278e = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo1295b() {
        this.f1278e = false;
    }

    /* renamed from: c */
    public void mo1296c() {
        if (this.f1278e) {
            Iterator it = this.f1274a.iterator();
            while (it.hasNext()) {
                ((C0969v) it.next()).mo3770b();
            }
            this.f1278e = false;
        }
    }

    /* renamed from: a */
    public C0515h mo1289a(long j) {
        if (!this.f1278e) {
            this.f1276c = j;
        }
        return this;
    }

    /* renamed from: a */
    public C0515h mo1290a(Interpolator interpolator) {
        if (!this.f1278e) {
            this.f1277d = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public C0515h mo1293a(C0973w wVar) {
        if (!this.f1278e) {
            this.f1275b = wVar;
        }
        return this;
    }
}
