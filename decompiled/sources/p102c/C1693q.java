package p102c;

import java.util.Arrays;

/* renamed from: c.q */
/* compiled from: SegmentedByteString */
final class C1693q extends C1677f {

    /* renamed from: f */
    final transient byte[][] f5332f;

    /* renamed from: g */
    final transient int[] f5333g;

    C1693q(C1672c cVar, int i) {
        super(null);
        C1698u.m7136a(cVar.f5290b, 0, (long) i);
        int i2 = 0;
        C1691o oVar = cVar.f5289a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (oVar.f5325c != oVar.f5324b) {
                i3 += oVar.f5325c - oVar.f5324b;
                i4++;
                oVar = oVar.f5328f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f5332f = new byte[i4][];
        this.f5333g = new int[(i4 * 2)];
        C1691o oVar2 = cVar.f5289a;
        int i5 = 0;
        while (i2 < i) {
            this.f5332f[i5] = oVar2.f5323a;
            i2 += oVar2.f5325c - oVar2.f5324b;
            if (i2 > i) {
                i2 = i;
            }
            this.f5333g[i5] = i2;
            this.f5333g[this.f5332f.length + i5] = oVar2.f5324b;
            oVar2.f5326d = true;
            i5++;
            oVar2 = oVar2.f5328f;
        }
    }

    /* renamed from: a */
    public String mo6888a() {
        return m7104j().mo6888a();
    }

    /* renamed from: b */
    public String mo6894b() {
        return m7104j().mo6894b();
    }

    /* renamed from: f */
    public String mo6900f() {
        return m7104j().mo6900f();
    }

    /* renamed from: g */
    public C1677f mo6901g() {
        return m7104j().mo6901g();
    }

    /* renamed from: c */
    public C1677f mo6895c() {
        return m7104j().mo6895c();
    }

    /* renamed from: d */
    public C1677f mo6897d() {
        return m7104j().mo6897d();
    }

    /* renamed from: e */
    public C1677f mo6898e() {
        return m7104j().mo6898e();
    }

    /* renamed from: a */
    public C1677f mo6887a(int i, int i2) {
        return m7104j().mo6887a(i, i2);
    }

    /* renamed from: a */
    public byte mo6886a(int i) {
        int i2;
        C1698u.m7136a((long) this.f5333g[this.f5332f.length - 1], (long) i, 1);
        int b = m7103b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.f5333g[b - 1];
        }
        return this.f5332f[b][(i - i2) + this.f5333g[this.f5332f.length + b]];
    }

    /* renamed from: b */
    private int m7103b(int i) {
        int binarySearch = Arrays.binarySearch(this.f5333g, 0, this.f5332f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* renamed from: h */
    public int mo6902h() {
        return this.f5333g[this.f5332f.length - 1];
    }

    /* renamed from: i */
    public byte[] mo6904i() {
        byte[] bArr = new byte[this.f5333g[this.f5332f.length - 1]];
        int length = this.f5332f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f5333g[length + i];
            int i4 = this.f5333g[i];
            System.arraycopy(this.f5332f[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6889a(C1672c cVar) {
        int length = this.f5332f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.f5333g[length + i];
            int i4 = this.f5333g[i];
            C1691o oVar = new C1691o(this.f5332f[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.f5289a == null) {
                oVar.f5329g = oVar;
                oVar.f5328f = oVar;
                cVar.f5289a = oVar;
            } else {
                cVar.f5289a.f5329g.mo6938a(oVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f5290b += (long) i2;
    }

    /* renamed from: a */
    public boolean mo6890a(int i, C1677f fVar, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo6902h() - i3) {
            return false;
        }
        int b = m7103b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f5333g[b - 1];
            }
            int min = Math.min(i3, ((this.f5333g[b] - i4) + i4) - i);
            if (!fVar.mo6891a(i2, this.f5332f[b], (i - i4) + this.f5333g[this.f5332f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo6891a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > mo6902h() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = m7103b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.f5333g[b - 1];
            }
            int min = Math.min(i3, ((this.f5333g[b] - i4) + i4) - i);
            if (!C1698u.m7138a(this.f5332f[b], (i - i4) + this.f5333g[this.f5332f.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    /* renamed from: j */
    private C1677f m7104j() {
        return new C1677f(mo6904i());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (mo6890a(0, r5, 0, mo6902h()) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof p102c.C1677f
            r2 = 0
            if (r1 == 0) goto L_0x0020
            c.f r5 = (p102c.C1677f) r5
            int r1 = r5.mo6902h()
            int r3 = r4.mo6902h()
            if (r1 != r3) goto L_0x0020
            int r1 = r4.mo6902h()
            boolean r5 = r4.mo6890a(r2, r5, r2, r1)
            if (r5 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p102c.C1693q.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = this.f5296d;
        if (i != 0) {
            return i;
        }
        int length = this.f5332f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f5332f[i2];
            int i5 = this.f5333g[length + i2];
            int i6 = this.f5333g[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f5296d = i4;
        return i4;
    }

    public String toString() {
        return m7104j().toString();
    }
}
