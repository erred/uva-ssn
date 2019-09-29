package p102c;

/* renamed from: c.o */
/* compiled from: Segment */
final class C1691o {

    /* renamed from: a */
    final byte[] f5323a;

    /* renamed from: b */
    int f5324b;

    /* renamed from: c */
    int f5325c;

    /* renamed from: d */
    boolean f5326d;

    /* renamed from: e */
    boolean f5327e;

    /* renamed from: f */
    C1691o f5328f;

    /* renamed from: g */
    C1691o f5329g;

    C1691o() {
        this.f5323a = new byte[8192];
        this.f5327e = true;
        this.f5326d = false;
    }

    C1691o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f5323a = bArr;
        this.f5324b = i;
        this.f5325c = i2;
        this.f5326d = z;
        this.f5327e = z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1691o mo6936a() {
        this.f5326d = true;
        C1691o oVar = new C1691o(this.f5323a, this.f5324b, this.f5325c, true, false);
        return oVar;
    }

    /* renamed from: b */
    public C1691o mo6940b() {
        C1691o oVar = this.f5328f != this ? this.f5328f : null;
        this.f5329g.f5328f = this.f5328f;
        this.f5328f.f5329g = this.f5329g;
        this.f5328f = null;
        this.f5329g = null;
        return oVar;
    }

    /* renamed from: a */
    public C1691o mo6938a(C1691o oVar) {
        oVar.f5329g = this;
        oVar.f5328f = this.f5328f;
        this.f5328f.f5329g = oVar;
        this.f5328f = oVar;
        return oVar;
    }

    /* renamed from: a */
    public C1691o mo6937a(int i) {
        C1691o oVar;
        if (i <= 0 || i > this.f5325c - this.f5324b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            oVar = mo6936a();
        } else {
            oVar = C1692p.m7101a();
            System.arraycopy(this.f5323a, this.f5324b, oVar.f5323a, 0, i);
        }
        oVar.f5325c = oVar.f5324b + i;
        this.f5324b += i;
        this.f5329g.mo6938a(oVar);
        return oVar;
    }

    /* renamed from: c */
    public void mo6941c() {
        if (this.f5329g == this) {
            throw new IllegalStateException();
        } else if (this.f5329g.f5327e) {
            int i = this.f5325c - this.f5324b;
            if (i <= (8192 - this.f5329g.f5325c) + (this.f5329g.f5326d ? 0 : this.f5329g.f5324b)) {
                mo6939a(this.f5329g, i);
                mo6940b();
                C1692p.m7102a(this);
            }
        }
    }

    /* renamed from: a */
    public void mo6939a(C1691o oVar, int i) {
        if (oVar.f5327e) {
            if (oVar.f5325c + i > 8192) {
                if (oVar.f5326d) {
                    throw new IllegalArgumentException();
                } else if ((oVar.f5325c + i) - oVar.f5324b <= 8192) {
                    System.arraycopy(oVar.f5323a, oVar.f5324b, oVar.f5323a, 0, oVar.f5325c - oVar.f5324b);
                    oVar.f5325c -= oVar.f5324b;
                    oVar.f5324b = 0;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f5323a, this.f5324b, oVar.f5323a, oVar.f5325c, i);
            oVar.f5325c += i;
            this.f5324b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
