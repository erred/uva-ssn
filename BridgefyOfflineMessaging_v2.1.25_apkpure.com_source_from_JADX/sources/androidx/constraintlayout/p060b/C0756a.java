package androidx.constraintlayout.p060b;

import androidx.constraintlayout.p060b.C0792h.C0793a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

/* renamed from: androidx.constraintlayout.b.a */
/* compiled from: ArrayLinkedVariables */
public class C0756a {

    /* renamed from: a */
    int f2166a = 0;

    /* renamed from: b */
    private final C0783b f2167b;

    /* renamed from: c */
    private final C0784c f2168c;

    /* renamed from: d */
    private int f2169d = 8;

    /* renamed from: e */
    private C0792h f2170e = null;

    /* renamed from: f */
    private int[] f2171f = new int[this.f2169d];

    /* renamed from: g */
    private int[] f2172g = new int[this.f2169d];

    /* renamed from: h */
    private float[] f2173h = new float[this.f2169d];

    /* renamed from: i */
    private int f2174i = -1;

    /* renamed from: j */
    private int f2175j = -1;

    /* renamed from: k */
    private boolean f2176k = false;

    C0756a(C0783b bVar, C0784c cVar) {
        this.f2167b = bVar;
        this.f2168c = cVar;
    }

    /* renamed from: a */
    public final void mo3022a(C0792h hVar, float f) {
        if (f == BitmapDescriptorFactory.HUE_RED) {
            mo3014a(hVar, true);
        } else if (this.f2174i == -1) {
            this.f2174i = 0;
            this.f2173h[this.f2174i] = f;
            this.f2171f[this.f2174i] = hVar.f2435a;
            this.f2172g[this.f2174i] = -1;
            hVar.f2443i++;
            hVar.mo3228a(this.f2167b);
            this.f2166a++;
            if (!this.f2176k) {
                this.f2175j++;
                if (this.f2175j >= this.f2171f.length) {
                    this.f2176k = true;
                    this.f2175j = this.f2171f.length - 1;
                }
            }
        } else {
            int i = this.f2174i;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f2166a) {
                if (this.f2171f[i] == hVar.f2435a) {
                    this.f2173h[i] = f;
                    return;
                }
                if (this.f2171f[i] < hVar.f2435a) {
                    i3 = i;
                }
                i = this.f2172g[i];
                i2++;
            }
            int i4 = this.f2175j + 1;
            if (this.f2176k) {
                if (this.f2171f[this.f2175j] == -1) {
                    i4 = this.f2175j;
                } else {
                    i4 = this.f2171f.length;
                }
            }
            if (i4 >= this.f2171f.length && this.f2166a < this.f2171f.length) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f2171f.length) {
                        break;
                    } else if (this.f2171f[i5] == -1) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (i4 >= this.f2171f.length) {
                i4 = this.f2171f.length;
                this.f2169d *= 2;
                this.f2176k = false;
                this.f2175j = i4 - 1;
                this.f2173h = Arrays.copyOf(this.f2173h, this.f2169d);
                this.f2171f = Arrays.copyOf(this.f2171f, this.f2169d);
                this.f2172g = Arrays.copyOf(this.f2172g, this.f2169d);
            }
            this.f2171f[i4] = hVar.f2435a;
            this.f2173h[i4] = f;
            if (i3 != -1) {
                this.f2172g[i4] = this.f2172g[i3];
                this.f2172g[i3] = i4;
            } else {
                this.f2172g[i4] = this.f2174i;
                this.f2174i = i4;
            }
            hVar.f2443i++;
            hVar.mo3228a(this.f2167b);
            this.f2166a++;
            if (!this.f2176k) {
                this.f2175j++;
            }
            if (this.f2166a >= this.f2171f.length) {
                this.f2176k = true;
            }
            if (this.f2175j >= this.f2171f.length) {
                this.f2176k = true;
                this.f2175j = this.f2171f.length - 1;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo3023a(C0792h hVar, float f, boolean z) {
        if (f != BitmapDescriptorFactory.HUE_RED) {
            if (this.f2174i == -1) {
                this.f2174i = 0;
                this.f2173h[this.f2174i] = f;
                this.f2171f[this.f2174i] = hVar.f2435a;
                this.f2172g[this.f2174i] = -1;
                hVar.f2443i++;
                hVar.mo3228a(this.f2167b);
                this.f2166a++;
                if (!this.f2176k) {
                    this.f2175j++;
                    if (this.f2175j >= this.f2171f.length) {
                        this.f2176k = true;
                        this.f2175j = this.f2171f.length - 1;
                    }
                }
                return;
            }
            int i = this.f2174i;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f2166a) {
                if (this.f2171f[i] == hVar.f2435a) {
                    float[] fArr = this.f2173h;
                    fArr[i] = fArr[i] + f;
                    if (this.f2173h[i] == BitmapDescriptorFactory.HUE_RED) {
                        if (i == this.f2174i) {
                            this.f2174i = this.f2172g[i];
                        } else {
                            this.f2172g[i3] = this.f2172g[i];
                        }
                        if (z) {
                            hVar.mo3231b(this.f2167b);
                        }
                        if (this.f2176k) {
                            this.f2175j = i;
                        }
                        hVar.f2443i--;
                        this.f2166a--;
                    }
                    return;
                }
                if (this.f2171f[i] < hVar.f2435a) {
                    i3 = i;
                }
                i = this.f2172g[i];
                i2++;
            }
            int i4 = this.f2175j + 1;
            if (this.f2176k) {
                if (this.f2171f[this.f2175j] == -1) {
                    i4 = this.f2175j;
                } else {
                    i4 = this.f2171f.length;
                }
            }
            if (i4 >= this.f2171f.length && this.f2166a < this.f2171f.length) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f2171f.length) {
                        break;
                    } else if (this.f2171f[i5] == -1) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (i4 >= this.f2171f.length) {
                i4 = this.f2171f.length;
                this.f2169d *= 2;
                this.f2176k = false;
                this.f2175j = i4 - 1;
                this.f2173h = Arrays.copyOf(this.f2173h, this.f2169d);
                this.f2171f = Arrays.copyOf(this.f2171f, this.f2169d);
                this.f2172g = Arrays.copyOf(this.f2172g, this.f2169d);
            }
            this.f2171f[i4] = hVar.f2435a;
            this.f2173h[i4] = f;
            if (i3 != -1) {
                this.f2172g[i4] = this.f2172g[i3];
                this.f2172g[i3] = i4;
            } else {
                this.f2172g[i4] = this.f2174i;
                this.f2174i = i4;
            }
            hVar.f2443i++;
            hVar.mo3228a(this.f2167b);
            this.f2166a++;
            if (!this.f2176k) {
                this.f2175j++;
            }
            if (this.f2175j >= this.f2171f.length) {
                this.f2176k = true;
                this.f2175j = this.f2171f.length - 1;
            }
        }
    }

    /* renamed from: a */
    public final float mo3014a(C0792h hVar, boolean z) {
        if (this.f2170e == hVar) {
            this.f2170e = null;
        }
        if (this.f2174i == -1) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i = this.f2174i;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f2166a) {
            if (this.f2171f[i] == hVar.f2435a) {
                if (i == this.f2174i) {
                    this.f2174i = this.f2172g[i];
                } else {
                    this.f2172g[i3] = this.f2172g[i];
                }
                if (z) {
                    hVar.mo3231b(this.f2167b);
                }
                hVar.f2443i--;
                this.f2166a--;
                this.f2171f[i] = -1;
                if (this.f2176k) {
                    this.f2175j = i;
                }
                return this.f2173h[i];
            }
            i2++;
            i3 = i;
            i = this.f2172g[i];
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: a */
    public final void mo3018a() {
        int i = this.f2174i;
        int i2 = 0;
        while (i != -1 && i2 < this.f2166a) {
            C0792h hVar = this.f2168c.f2379c[this.f2171f[i]];
            if (hVar != null) {
                hVar.mo3231b(this.f2167b);
            }
            i = this.f2172g[i];
            i2++;
        }
        this.f2174i = -1;
        this.f2175j = -1;
        this.f2176k = false;
        this.f2166a = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo3024a(C0792h hVar) {
        if (this.f2174i == -1) {
            return false;
        }
        int i = this.f2174i;
        int i2 = 0;
        while (i != -1 && i2 < this.f2166a) {
            if (this.f2171f[i] == hVar.f2435a) {
                return true;
            }
            i = this.f2172g[i];
            i2++;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo3027b() {
        int i = this.f2174i;
        int i2 = 0;
        while (i != -1 && i2 < this.f2166a) {
            float[] fArr = this.f2173h;
            fArr[i] = fArr[i] * -1.0f;
            i = this.f2172g[i];
            i2++;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3019a(float f) {
        int i = this.f2174i;
        int i2 = 0;
        while (i != -1 && i2 < this.f2166a) {
            float[] fArr = this.f2173h;
            fArr[i] = fArr[i] / f;
            i = this.f2172g[i];
            i2++;
        }
    }

    /* renamed from: a */
    private boolean m2697a(C0792h hVar, C0786e eVar) {
        return hVar.f2443i <= 1;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.p060b.C0792h mo3016a(androidx.constraintlayout.p060b.C0786e r15) {
        /*
            r14 = this;
            int r0 = r14.f2174i
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000a:
            r9 = -1
            if (r0 == r9) goto L_0x009c
            int r9 = r14.f2166a
            if (r2 >= r9) goto L_0x009c
            float[] r9 = r14.f2173h
            r9 = r9[r0]
            r10 = 981668463(0x3a83126f, float:0.001)
            androidx.constraintlayout.b.c r11 = r14.f2168c
            androidx.constraintlayout.b.h[] r11 = r11.f2379c
            int[] r12 = r14.f2171f
            r12 = r12[r0]
            r11 = r11[r12]
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0038
            r10 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0046
            float[] r9 = r14.f2173h
            r9[r0] = r3
            androidx.constraintlayout.b.b r9 = r14.f2167b
            r11.mo3231b(r9)
        L_0x0036:
            r9 = 0
            goto L_0x0046
        L_0x0038:
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0046
            float[] r9 = r14.f2173h
            r9[r0] = r3
            androidx.constraintlayout.b.b r9 = r14.f2167b
            r11.mo3231b(r9)
            goto L_0x0036
        L_0x0046:
            r10 = 1
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x0094
            androidx.constraintlayout.b.h$a r12 = r11.f2440f
            androidx.constraintlayout.b.h$a r13 = androidx.constraintlayout.p060b.C0792h.C0793a.UNRESTRICTED
            if (r12 != r13) goto L_0x0070
            if (r1 != 0) goto L_0x005b
            boolean r1 = r14.m2697a(r11, r15)
        L_0x0057:
            r6 = r1
            r5 = r9
            r1 = r11
            goto L_0x0094
        L_0x005b:
            int r12 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x0064
            boolean r1 = r14.m2697a(r11, r15)
            goto L_0x0057
        L_0x0064:
            if (r6 != 0) goto L_0x0094
            boolean r12 = r14.m2697a(r11, r15)
            if (r12 == 0) goto L_0x0094
            r5 = r9
            r1 = r11
            r6 = 1
            goto L_0x0094
        L_0x0070:
            if (r1 != 0) goto L_0x0094
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0094
            if (r4 != 0) goto L_0x0080
            boolean r4 = r14.m2697a(r11, r15)
        L_0x007c:
            r8 = r4
            r7 = r9
            r4 = r11
            goto L_0x0094
        L_0x0080:
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x0089
            boolean r4 = r14.m2697a(r11, r15)
            goto L_0x007c
        L_0x0089:
            if (r8 != 0) goto L_0x0094
            boolean r12 = r14.m2697a(r11, r15)
            if (r12 == 0) goto L_0x0094
            r7 = r9
            r4 = r11
            r8 = 1
        L_0x0094:
            int[] r9 = r14.f2172g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto L_0x000a
        L_0x009c:
            if (r1 == 0) goto L_0x009f
            return r1
        L_0x009f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.C0756a.mo3016a(androidx.constraintlayout.b.e):androidx.constraintlayout.b.h");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo3020a(C0783b bVar, C0783b bVar2, boolean z) {
        int i = this.f2174i;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.f2166a) {
                if (this.f2171f[i] == bVar2.f2372a.f2435a) {
                    float f = this.f2173h[i];
                    mo3014a(bVar2.f2372a, z);
                    C0756a aVar = bVar2.f2375d;
                    int i3 = aVar.f2174i;
                    int i4 = 0;
                    while (i3 != -1 && i4 < aVar.f2166a) {
                        mo3023a(this.f2168c.f2379c[aVar.f2171f[i3]], aVar.f2173h[i3] * f, z);
                        i3 = aVar.f2172g[i3];
                        i4++;
                    }
                    bVar.f2373b += bVar2.f2373b * f;
                    if (z) {
                        bVar2.f2372a.mo3231b(bVar);
                    }
                    i = this.f2174i;
                } else {
                    i = this.f2172g[i];
                    i2++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3021a(C0783b bVar, C0783b[] bVarArr) {
        int i = this.f2174i;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.f2166a) {
                C0792h hVar = this.f2168c.f2379c[this.f2171f[i]];
                if (hVar.f2436b != -1) {
                    float f = this.f2173h[i];
                    mo3014a(hVar, true);
                    C0783b bVar2 = bVarArr[hVar.f2436b];
                    if (!bVar2.f2376e) {
                        C0756a aVar = bVar2.f2375d;
                        int i3 = aVar.f2174i;
                        int i4 = 0;
                        while (i3 != -1 && i4 < aVar.f2166a) {
                            mo3023a(this.f2168c.f2379c[aVar.f2171f[i3]], aVar.f2173h[i3] * f, true);
                            i3 = aVar.f2172g[i3];
                            i4++;
                        }
                    }
                    bVar.f2373b += bVar2.f2373b * f;
                    bVar2.f2372a.mo3231b(bVar);
                    i = this.f2174i;
                } else {
                    i = this.f2172g[i];
                    i2++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0792h mo3017a(boolean[] zArr, C0792h hVar) {
        int i = this.f2174i;
        int i2 = 0;
        C0792h hVar2 = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        while (i != -1 && i2 < this.f2166a) {
            if (this.f2173h[i] < BitmapDescriptorFactory.HUE_RED) {
                C0792h hVar3 = this.f2168c.f2379c[this.f2171f[i]];
                if ((zArr == null || !zArr[hVar3.f2435a]) && hVar3 != hVar && (hVar3.f2440f == C0793a.SLACK || hVar3.f2440f == C0793a.ERROR)) {
                    float f2 = this.f2173h[i];
                    if (f2 < f) {
                        hVar2 = hVar3;
                        f = f2;
                    }
                }
            }
            i = this.f2172g[i];
            i2++;
        }
        return hVar2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C0792h mo3015a(int i) {
        int i2 = this.f2174i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2166a) {
            if (i3 == i) {
                return this.f2168c.f2379c[this.f2171f[i2]];
            }
            i2 = this.f2172g[i2];
            i3++;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final float mo3025b(int i) {
        int i2 = this.f2174i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f2166a) {
            if (i3 == i) {
                return this.f2173h[i2];
            }
            i2 = this.f2172g[i2];
            i3++;
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: b */
    public final float mo3026b(C0792h hVar) {
        int i = this.f2174i;
        int i2 = 0;
        while (i != -1 && i2 < this.f2166a) {
            if (this.f2171f[i] == hVar.f2435a) {
                return this.f2173h[i];
            }
            i = this.f2172g[i];
            i2++;
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    public String toString() {
        String str = "";
        int i = this.f2174i;
        int i2 = 0;
        while (i != -1 && i2 < this.f2166a) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" -> ");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(this.f2173h[i]);
            sb3.append(" : ");
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(this.f2168c.f2379c[this.f2171f[i]]);
            str = sb5.toString();
            i = this.f2172g[i];
            i2++;
        }
        return str;
    }
}
