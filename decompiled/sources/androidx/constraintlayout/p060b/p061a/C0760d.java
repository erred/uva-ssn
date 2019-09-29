package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.p061a.C0766f.C0768a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.b.a.d */
/* compiled from: ChainHead */
public class C0760d {

    /* renamed from: a */
    protected C0766f f2180a;

    /* renamed from: b */
    protected C0766f f2181b;

    /* renamed from: c */
    protected C0766f f2182c;

    /* renamed from: d */
    protected C0766f f2183d;

    /* renamed from: e */
    protected C0766f f2184e;

    /* renamed from: f */
    protected C0766f f2185f;

    /* renamed from: g */
    protected C0766f f2186g;

    /* renamed from: h */
    protected ArrayList<C0766f> f2187h;

    /* renamed from: i */
    protected int f2188i;

    /* renamed from: j */
    protected int f2189j;

    /* renamed from: k */
    protected float f2190k = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: l */
    protected boolean f2191l;

    /* renamed from: m */
    protected boolean f2192m;

    /* renamed from: n */
    protected boolean f2193n;

    /* renamed from: o */
    private int f2194o;

    /* renamed from: p */
    private boolean f2195p = false;

    /* renamed from: q */
    private boolean f2196q;

    public C0760d(C0766f fVar, int i, boolean z) {
        this.f2180a = fVar;
        this.f2194o = i;
        this.f2195p = z;
    }

    /* renamed from: a */
    private static boolean m2731a(C0766f fVar, int i) {
        return fVar.mo3105l() != 8 && fVar.f2228C[i] == C0768a.MATCH_CONSTRAINT && (fVar.f2275g[i] == 0 || fVar.f2275g[i] == 3);
    }

    /* renamed from: b */
    private void m2732b() {
        int i = this.f2194o * 2;
        C0766f fVar = this.f2180a;
        C0766f fVar2 = this.f2180a;
        boolean z = false;
        C0766f fVar3 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.f2188i++;
            C0766f fVar4 = null;
            fVar3.f2254ac[this.f2194o] = null;
            fVar3.f2253ab[this.f2194o] = null;
            if (fVar3.mo3105l() != 8) {
                if (this.f2181b == null) {
                    this.f2181b = fVar3;
                }
                if (this.f2183d != null) {
                    this.f2183d.f2254ac[this.f2194o] = fVar3;
                }
                this.f2183d = fVar3;
                if (fVar3.f2228C[this.f2194o] == C0768a.MATCH_CONSTRAINT && (fVar3.f2275g[this.f2194o] == 0 || fVar3.f2275g[this.f2194o] == 3 || fVar3.f2275g[this.f2194o] == 2)) {
                    this.f2189j++;
                    float f = fVar3.f2252aa[this.f2194o];
                    if (f > BitmapDescriptorFactory.HUE_RED) {
                        this.f2190k += fVar3.f2252aa[this.f2194o];
                    }
                    if (m2731a(fVar3, this.f2194o)) {
                        if (f < BitmapDescriptorFactory.HUE_RED) {
                            this.f2191l = true;
                        } else {
                            this.f2192m = true;
                        }
                        if (this.f2187h == null) {
                            this.f2187h = new ArrayList<>();
                        }
                        this.f2187h.add(fVar3);
                    }
                    if (this.f2185f == null) {
                        this.f2185f = fVar3;
                    }
                    if (this.f2186g != null) {
                        this.f2186g.f2253ab[this.f2194o] = fVar3;
                    }
                    this.f2186g = fVar3;
                }
            }
            C0761e eVar = fVar3.f2226A[i + 1].f2199c;
            if (eVar != null) {
                C0766f fVar5 = eVar.f2197a;
                if (fVar5.f2226A[i].f2199c != null && fVar5.f2226A[i].f2199c.f2197a == fVar3) {
                    fVar4 = fVar5;
                }
            }
            if (fVar4 != null) {
                fVar3 = fVar4;
            } else {
                z2 = true;
            }
        }
        this.f2182c = fVar3;
        if (this.f2194o != 0 || !this.f2195p) {
            this.f2184e = this.f2180a;
        } else {
            this.f2184e = this.f2182c;
        }
        if (this.f2192m && this.f2191l) {
            z = true;
        }
        this.f2193n = z;
    }

    /* renamed from: a */
    public void mo3037a() {
        if (!this.f2196q) {
            m2732b();
        }
        this.f2196q = true;
    }
}
