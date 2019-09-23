package p091b.p092a.p097e;

import java.util.Arrays;

/* renamed from: b.a.e.m */
/* compiled from: Settings */
public final class C1570m {

    /* renamed from: a */
    private int f4814a;

    /* renamed from: b */
    private final int[] f4815b = new int[10];

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6403a() {
        this.f4814a = 0;
        Arrays.fill(this.f4815b, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1570m mo6402a(int i, int i2) {
        if (i < 0 || i >= this.f4815b.length) {
            return this;
        }
        this.f4814a = (1 << i) | this.f4814a;
        this.f4815b[i] = i2;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6405a(int i) {
        return ((1 << i) & this.f4814a) != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo6407b(int i) {
        return this.f4815b[i];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo6406b() {
        return Integer.bitCount(this.f4814a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo6408c() {
        if ((this.f4814a & 2) != 0) {
            return this.f4815b[1];
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo6409c(int i) {
        return (this.f4814a & 16) != 0 ? this.f4815b[4] : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo6411d(int i) {
        return (this.f4814a & 32) != 0 ? this.f4815b[5] : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo6410d() {
        if ((this.f4814a & 128) != 0) {
            return this.f4815b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6404a(C1570m mVar) {
        for (int i = 0; i < 10; i++) {
            if (mVar.mo6405a(i)) {
                mo6402a(i, mVar.mo6407b(i));
            }
        }
    }
}
