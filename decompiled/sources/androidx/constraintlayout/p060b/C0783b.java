package androidx.constraintlayout.p060b;

import androidx.constraintlayout.p060b.C0792h.C0793a;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.constraintlayout.b.b */
/* compiled from: ArrayRow */
public class C0783b implements C0787a {

    /* renamed from: a */
    C0792h f2372a = null;

    /* renamed from: b */
    float f2373b = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: c */
    boolean f2374c = false;

    /* renamed from: d */
    public final C0756a f2375d;

    /* renamed from: e */
    boolean f2376e = false;

    public C0783b(C0784c cVar) {
        this.f2375d = new C0756a(this, cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo3186a() {
        return this.f2372a != null && (this.f2372a.f2440f == C0793a.UNRESTRICTED || this.f2373b >= BitmapDescriptorFactory.HUE_RED);
    }

    public String toString() {
        return mo3193b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo3193b() {
        String str;
        boolean z;
        String str2;
        String str3 = "";
        if (this.f2372a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("0");
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(this.f2372a);
            str = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(" = ");
        String sb4 = sb3.toString();
        if (this.f2373b != BitmapDescriptorFactory.HUE_RED) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(this.f2373b);
            sb4 = sb5.toString();
            z = true;
        } else {
            z = false;
        }
        int i = this.f2375d.f2166a;
        for (int i2 = 0; i2 < i; i2++) {
            C0792h a = this.f2375d.mo3015a(i2);
            if (a != null) {
                float b = this.f2375d.mo3025b(i2);
                int i3 = (b > BitmapDescriptorFactory.HUE_RED ? 1 : (b == BitmapDescriptorFactory.HUE_RED ? 0 : -1));
                if (i3 != 0) {
                    String hVar = a.toString();
                    if (!z) {
                        if (b < BitmapDescriptorFactory.HUE_RED) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str2);
                            sb6.append("- ");
                            str2 = sb6.toString();
                            b *= -1.0f;
                        }
                    } else if (i3 > 0) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str2);
                        sb7.append(" + ");
                        str2 = sb7.toString();
                    } else {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(str2);
                        sb8.append(" - ");
                        str2 = sb8.toString();
                        b *= -1.0f;
                    }
                    if (b == 1.0f) {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(str2);
                        sb9.append(hVar);
                        str2 = sb9.toString();
                    } else {
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append(str2);
                        sb10.append(b);
                        sb10.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb10.append(hVar);
                        str2 = sb10.toString();
                    }
                    z = true;
                }
            }
        }
        if (z) {
            return str2;
        }
        StringBuilder sb11 = new StringBuilder();
        sb11.append(str2);
        sb11.append("0.0");
        return sb11.toString();
    }

    /* renamed from: c */
    public void mo3195c() {
        this.f2372a = null;
        this.f2375d.mo3018a();
        this.f2373b = BitmapDescriptorFactory.HUE_RED;
        this.f2376e = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo3188a(C0792h hVar) {
        return this.f2375d.mo3024a(hVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0783b mo3178a(C0792h hVar, int i) {
        this.f2372a = hVar;
        float f = (float) i;
        hVar.f2438d = f;
        this.f2373b = f;
        this.f2376e = true;
        return this;
    }

    /* renamed from: b */
    public C0783b mo3189b(C0792h hVar, int i) {
        if (i < 0) {
            this.f2373b = (float) (i * -1);
            this.f2375d.mo3022a(hVar, 1.0f);
        } else {
            this.f2373b = (float) i;
            this.f2375d.mo3022a(hVar, -1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public C0783b mo3179a(C0792h hVar, C0792h hVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f2373b = (float) i;
        }
        if (!z) {
            this.f2375d.mo3022a(hVar, -1.0f);
            this.f2375d.mo3022a(hVar2, 1.0f);
        } else {
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0783b mo3194c(C0792h hVar, int i) {
        this.f2375d.mo3022a(hVar, (float) i);
        return this;
    }

    /* renamed from: a */
    public C0783b mo3182a(C0792h hVar, C0792h hVar2, C0792h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f2373b = (float) i;
        }
        if (!z) {
            this.f2375d.mo3022a(hVar, -1.0f);
            this.f2375d.mo3022a(hVar2, 1.0f);
            this.f2375d.mo3022a(hVar3, 1.0f);
        } else {
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar2, -1.0f);
            this.f2375d.mo3022a(hVar3, -1.0f);
        }
        return this;
    }

    /* renamed from: b */
    public C0783b mo3190b(C0792h hVar, C0792h hVar2, C0792h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f2373b = (float) i;
        }
        if (!z) {
            this.f2375d.mo3022a(hVar, -1.0f);
            this.f2375d.mo3022a(hVar2, 1.0f);
            this.f2375d.mo3022a(hVar3, -1.0f);
        } else {
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar2, -1.0f);
            this.f2375d.mo3022a(hVar3, 1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public C0783b mo3176a(float f, float f2, float f3, C0792h hVar, C0792h hVar2, C0792h hVar3, C0792h hVar4) {
        this.f2373b = BitmapDescriptorFactory.HUE_RED;
        if (f2 == BitmapDescriptorFactory.HUE_RED || f == f3) {
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar2, -1.0f);
            this.f2375d.mo3022a(hVar4, 1.0f);
            this.f2375d.mo3022a(hVar3, -1.0f);
        } else if (f == BitmapDescriptorFactory.HUE_RED) {
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar2, -1.0f);
        } else if (f3 == BitmapDescriptorFactory.HUE_RED) {
            this.f2375d.mo3022a(hVar3, 1.0f);
            this.f2375d.mo3022a(hVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar2, -1.0f);
            this.f2375d.mo3022a(hVar4, f4);
            this.f2375d.mo3022a(hVar3, -f4);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0783b mo3180a(C0792h hVar, C0792h hVar2, int i, float f, C0792h hVar3, C0792h hVar4, int i2) {
        if (hVar2 == hVar3) {
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar4, 1.0f);
            this.f2375d.mo3022a(hVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.f2375d.mo3022a(hVar, 1.0f);
            this.f2375d.mo3022a(hVar2, -1.0f);
            this.f2375d.mo3022a(hVar3, -1.0f);
            this.f2375d.mo3022a(hVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f2373b = (float) ((-i) + i2);
            }
        } else if (f <= BitmapDescriptorFactory.HUE_RED) {
            this.f2375d.mo3022a(hVar, -1.0f);
            this.f2375d.mo3022a(hVar2, 1.0f);
            this.f2373b = (float) i;
        } else if (f >= 1.0f) {
            this.f2375d.mo3022a(hVar3, -1.0f);
            this.f2375d.mo3022a(hVar4, 1.0f);
            this.f2373b = (float) i2;
        } else {
            float f2 = 1.0f - f;
            this.f2375d.mo3022a(hVar, f2 * 1.0f);
            this.f2375d.mo3022a(hVar2, f2 * -1.0f);
            this.f2375d.mo3022a(hVar3, -1.0f * f);
            this.f2375d.mo3022a(hVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f2373b = (((float) (-i)) * f2) + (((float) i2) * f);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C0783b mo3177a(C0786e eVar, int i) {
        this.f2375d.mo3022a(eVar.mo3203a(i, "ep"), 1.0f);
        this.f2375d.mo3022a(eVar.mo3203a(i, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0783b mo3181a(C0792h hVar, C0792h hVar2, C0792h hVar3, float f) {
        this.f2375d.mo3022a(hVar, -1.0f);
        this.f2375d.mo3022a(hVar2, 1.0f - f);
        this.f2375d.mo3022a(hVar3, f);
        return this;
    }

    /* renamed from: a */
    public C0783b mo3183a(C0792h hVar, C0792h hVar2, C0792h hVar3, C0792h hVar4, float f) {
        this.f2375d.mo3022a(hVar, -1.0f);
        this.f2375d.mo3022a(hVar2, 1.0f);
        this.f2375d.mo3022a(hVar3, f);
        this.f2375d.mo3022a(hVar4, -f);
        return this;
    }

    /* renamed from: b */
    public C0783b mo3191b(C0792h hVar, C0792h hVar2, C0792h hVar3, C0792h hVar4, float f) {
        this.f2375d.mo3022a(hVar3, 0.5f);
        this.f2375d.mo3022a(hVar4, 0.5f);
        this.f2375d.mo3022a(hVar, -0.5f);
        this.f2375d.mo3022a(hVar2, -0.5f);
        this.f2373b = -f;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo3197d() {
        if (this.f2373b < BitmapDescriptorFactory.HUE_RED) {
            this.f2373b *= -1.0f;
            this.f2375d.mo3027b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo3187a(C0786e eVar) {
        boolean z;
        C0792h a = this.f2375d.mo3016a(eVar);
        if (a == null) {
            z = true;
        } else {
            mo3196c(a);
            z = false;
        }
        if (this.f2375d.f2166a == 0) {
            this.f2376e = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0792h mo3192b(C0792h hVar) {
        return this.f2375d.mo3017a((boolean[]) null, hVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo3196c(C0792h hVar) {
        if (this.f2372a != null) {
            this.f2375d.mo3022a(this.f2372a, -1.0f);
            this.f2372a = null;
        }
        float a = this.f2375d.mo3014a(hVar, true) * -1.0f;
        this.f2372a = hVar;
        if (a != 1.0f) {
            this.f2373b /= a;
            this.f2375d.mo3019a(a);
        }
    }

    /* renamed from: e */
    public boolean mo3199e() {
        return this.f2372a == null && this.f2373b == BitmapDescriptorFactory.HUE_RED && this.f2375d.f2166a == 0;
    }

    /* renamed from: a */
    public C0792h mo3184a(C0786e eVar, boolean[] zArr) {
        return this.f2375d.mo3017a(zArr, (C0792h) null);
    }

    /* renamed from: f */
    public void mo3200f() {
        this.f2375d.mo3018a();
        this.f2372a = null;
        this.f2373b = BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: a */
    public void mo3185a(C0787a aVar) {
        if (aVar instanceof C0783b) {
            C0783b bVar = (C0783b) aVar;
            this.f2372a = null;
            this.f2375d.mo3018a();
            for (int i = 0; i < bVar.f2375d.f2166a; i++) {
                this.f2375d.mo3023a(bVar.f2375d.mo3015a(i), bVar.f2375d.mo3025b(i), true);
            }
        }
    }

    /* renamed from: d */
    public void mo3198d(C0792h hVar) {
        float f = 1.0f;
        if (hVar.f2437c != 1) {
            if (hVar.f2437c == 2) {
                f = 1000.0f;
            } else if (hVar.f2437c == 3) {
                f = 1000000.0f;
            } else if (hVar.f2437c == 4) {
                f = 1.0E9f;
            } else if (hVar.f2437c == 5) {
                f = 1.0E12f;
            }
        }
        this.f2375d.mo3022a(hVar, f);
    }

    /* renamed from: g */
    public C0792h mo3201g() {
        return this.f2372a;
    }
}
