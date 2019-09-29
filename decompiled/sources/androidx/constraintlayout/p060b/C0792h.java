package androidx.constraintlayout.p060b;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

/* renamed from: androidx.constraintlayout.b.h */
/* compiled from: SolverVariable */
public class C0792h {

    /* renamed from: j */
    private static int f2430j = 1;

    /* renamed from: k */
    private static int f2431k = 1;

    /* renamed from: l */
    private static int f2432l = 1;

    /* renamed from: m */
    private static int f2433m = 1;

    /* renamed from: n */
    private static int f2434n = 1;

    /* renamed from: a */
    public int f2435a = -1;

    /* renamed from: b */
    int f2436b = -1;

    /* renamed from: c */
    public int f2437c = 0;

    /* renamed from: d */
    public float f2438d;

    /* renamed from: e */
    float[] f2439e = new float[7];

    /* renamed from: f */
    C0793a f2440f;

    /* renamed from: g */
    C0783b[] f2441g = new C0783b[8];

    /* renamed from: h */
    int f2442h = 0;

    /* renamed from: i */
    public int f2443i = 0;

    /* renamed from: o */
    private String f2444o;

    /* renamed from: androidx.constraintlayout.b.h$a */
    /* compiled from: SolverVariable */
    public enum C0793a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* renamed from: a */
    static void m2976a() {
        f2431k++;
    }

    public C0792h(C0793a aVar, String str) {
        this.f2440f = aVar;
    }

    /* renamed from: a */
    public final void mo3228a(C0783b bVar) {
        int i = 0;
        while (i < this.f2442h) {
            if (this.f2441g[i] != bVar) {
                i++;
            } else {
                return;
            }
        }
        if (this.f2442h >= this.f2441g.length) {
            this.f2441g = (C0783b[]) Arrays.copyOf(this.f2441g, this.f2441g.length * 2);
        }
        this.f2441g[this.f2442h] = bVar;
        this.f2442h++;
    }

    /* renamed from: b */
    public final void mo3231b(C0783b bVar) {
        int i = this.f2442h;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f2441g[i2] == bVar) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    int i4 = i2 + i3;
                    this.f2441g[i4] = this.f2441g[i4 + 1];
                }
                this.f2442h--;
                return;
            }
        }
    }

    /* renamed from: c */
    public final void mo3232c(C0783b bVar) {
        int i = this.f2442h;
        for (int i2 = 0; i2 < i; i2++) {
            this.f2441g[i2].f2375d.mo3020a(this.f2441g[i2], bVar, false);
        }
        this.f2442h = 0;
    }

    /* renamed from: b */
    public void mo3230b() {
        this.f2444o = null;
        this.f2440f = C0793a.UNKNOWN;
        this.f2437c = 0;
        this.f2435a = -1;
        this.f2436b = -1;
        this.f2438d = BitmapDescriptorFactory.HUE_RED;
        this.f2442h = 0;
        this.f2443i = 0;
    }

    /* renamed from: a */
    public void mo3229a(C0793a aVar, String str) {
        this.f2440f = aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f2444o);
        return sb.toString();
    }
}
