package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0786e;
import androidx.constraintlayout.p060b.C0788f;
import androidx.constraintlayout.p060b.C0792h;
import androidx.constraintlayout.p060b.p061a.C0766f.C0768a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.b.a.b */
/* compiled from: Barrier */
public class C0758b extends C0774k {

    /* renamed from: ah */
    private int f2177ah = 0;

    /* renamed from: ai */
    private ArrayList<C0777n> f2178ai = new ArrayList<>(4);

    /* renamed from: aj */
    private boolean f2179aj = true;

    /* renamed from: a */
    public boolean mo3032a() {
        return true;
    }

    /* renamed from: a */
    public void mo3029a(int i) {
        this.f2177ah = i;
    }

    /* renamed from: a */
    public void mo3031a(boolean z) {
        this.f2179aj = z;
    }

    /* renamed from: b */
    public boolean mo3034b() {
        return this.f2179aj;
    }

    /* renamed from: c */
    public void mo3035c() {
        super.mo3035c();
        this.f2178ai.clear();
    }

    /* renamed from: b */
    public void mo3033b(int i) {
        C0777n nVar;
        C0777n nVar2;
        if (this.f2229D != null && ((C0769g) this.f2229D).mo3140q(2)) {
            switch (this.f2177ah) {
                case 0:
                    nVar = this.f2287s.mo3038a();
                    break;
                case 1:
                    nVar = this.f2289u.mo3038a();
                    break;
                case 2:
                    nVar = this.f2288t.mo3038a();
                    break;
                case 3:
                    nVar = this.f2290v.mo3038a();
                    break;
                default:
                    return;
            }
            nVar.mo3156b(5);
            if (this.f2177ah == 0 || this.f2177ah == 1) {
                this.f2288t.mo3038a().mo3151a((C0777n) null, (float) BitmapDescriptorFactory.HUE_RED);
                this.f2290v.mo3038a().mo3151a((C0777n) null, (float) BitmapDescriptorFactory.HUE_RED);
            } else {
                this.f2287s.mo3038a().mo3151a((C0777n) null, (float) BitmapDescriptorFactory.HUE_RED);
                this.f2289u.mo3038a().mo3151a((C0777n) null, (float) BitmapDescriptorFactory.HUE_RED);
            }
            this.f2178ai.clear();
            for (int i2 = 0; i2 < this.f2343ag; i2++) {
                C0766f fVar = this.f2342af[i2];
                if (this.f2179aj || fVar.mo3032a()) {
                    switch (this.f2177ah) {
                        case 0:
                            nVar2 = fVar.f2287s.mo3038a();
                            break;
                        case 1:
                            nVar2 = fVar.f2289u.mo3038a();
                            break;
                        case 2:
                            nVar2 = fVar.f2288t.mo3038a();
                            break;
                        case 3:
                            nVar2 = fVar.f2290v.mo3038a();
                            break;
                        default:
                            nVar2 = null;
                            break;
                    }
                    if (nVar2 != null) {
                        this.f2178ai.add(nVar2);
                        nVar2.mo3164a(nVar);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo3036d() {
        C0777n nVar;
        float f = Float.MAX_VALUE;
        switch (this.f2177ah) {
            case 0:
                nVar = this.f2287s.mo3038a();
                break;
            case 1:
                nVar = this.f2289u.mo3038a();
                break;
            case 2:
                nVar = this.f2288t.mo3038a();
                break;
            case 3:
                nVar = this.f2290v.mo3038a();
                break;
            default:
                return;
        }
        f = BitmapDescriptorFactory.HUE_RED;
        int size = this.f2178ai.size();
        C0777n nVar2 = null;
        int i = 0;
        while (i < size) {
            C0777n nVar3 = (C0777n) this.f2178ai.get(i);
            if (nVar3.f2360i == 1) {
                if (this.f2177ah == 0 || this.f2177ah == 2) {
                    if (nVar3.f2350f < f) {
                        f = nVar3.f2350f;
                        nVar2 = nVar3.f2349e;
                    }
                } else if (nVar3.f2350f > f) {
                    f = nVar3.f2350f;
                    nVar2 = nVar3.f2349e;
                }
                i++;
            } else {
                return;
            }
        }
        if (C0786e.m2935a() != null) {
            C0788f a = C0786e.m2935a();
            a.f2427z++;
        }
        nVar.f2349e = nVar2;
        nVar.f2350f = f;
        nVar.mo3166f();
        switch (this.f2177ah) {
            case 0:
                this.f2289u.mo3038a().mo3151a(nVar2, f);
                break;
            case 1:
                this.f2287s.mo3038a().mo3151a(nVar2, f);
                break;
            case 2:
                this.f2290v.mo3038a().mo3151a(nVar2, f);
                break;
            case 3:
                this.f2288t.mo3038a().mo3151a(nVar2, f);
                break;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo3030a(C0786e eVar) {
        boolean z;
        this.f2226A[0] = this.f2287s;
        this.f2226A[2] = this.f2288t;
        this.f2226A[1] = this.f2289u;
        this.f2226A[3] = this.f2290v;
        for (int i = 0; i < this.f2226A.length; i++) {
            this.f2226A[i].f2202f = eVar.mo3204a((Object) this.f2226A[i]);
        }
        if (this.f2177ah >= 0 && this.f2177ah < 4) {
            C0761e eVar2 = this.f2226A[this.f2177ah];
            int i2 = 0;
            while (true) {
                if (i2 >= this.f2343ag) {
                    z = false;
                    break;
                }
                C0766f fVar = this.f2342af[i2];
                if ((this.f2179aj || fVar.mo3032a()) && (((this.f2177ah == 0 || this.f2177ah == 1) && fVar.mo3059G() == C0768a.MATCH_CONSTRAINT) || ((this.f2177ah == 2 || this.f2177ah == 3) && fVar.mo3060H() == C0768a.MATCH_CONSTRAINT))) {
                    z = true;
                } else {
                    i2++;
                }
            }
            z = true;
            if (this.f2177ah == 0 || this.f2177ah == 1 ? mo3103k().mo3059G() == C0768a.WRAP_CONTENT : mo3103k().mo3060H() == C0768a.WRAP_CONTENT) {
                z = false;
            }
            for (int i3 = 0; i3 < this.f2343ag; i3++) {
                C0766f fVar2 = this.f2342af[i3];
                if (this.f2179aj || fVar2.mo3032a()) {
                    C0792h a = eVar.mo3204a((Object) fVar2.f2226A[this.f2177ah]);
                    fVar2.f2226A[this.f2177ah].f2202f = a;
                    if (this.f2177ah == 0 || this.f2177ah == 2) {
                        eVar.mo3217b(eVar2.f2202f, a, z);
                    } else {
                        eVar.mo3213a(eVar2.f2202f, a, z);
                    }
                }
            }
            if (this.f2177ah == 0) {
                eVar.mo3219c(this.f2289u.f2202f, this.f2287s.f2202f, 0, 6);
                if (!z) {
                    eVar.mo3219c(this.f2287s.f2202f, this.f2229D.f2289u.f2202f, 0, 5);
                }
            } else if (this.f2177ah == 1) {
                eVar.mo3219c(this.f2287s.f2202f, this.f2289u.f2202f, 0, 6);
                if (!z) {
                    eVar.mo3219c(this.f2287s.f2202f, this.f2229D.f2287s.f2202f, 0, 5);
                }
            } else if (this.f2177ah == 2) {
                eVar.mo3219c(this.f2290v.f2202f, this.f2288t.f2202f, 0, 6);
                if (!z) {
                    eVar.mo3219c(this.f2288t.f2202f, this.f2229D.f2290v.f2202f, 0, 5);
                }
            } else if (this.f2177ah == 3) {
                eVar.mo3219c(this.f2288t.f2202f, this.f2290v.f2202f, 0, 6);
                if (!z) {
                    eVar.mo3219c(this.f2288t.f2202f, this.f2229D.f2288t.f2202f, 0, 5);
                }
            }
        }
    }
}
