package androidx.media;

import java.util.Arrays;

/* renamed from: androidx.media.c */
/* compiled from: AudioAttributesImplBase */
class C1224c implements C1222a {

    /* renamed from: a */
    int f3634a = 0;

    /* renamed from: b */
    int f3635b = 0;

    /* renamed from: c */
    int f3636c = 0;

    /* renamed from: d */
    int f3637d = -1;

    C1224c() {
    }

    /* renamed from: a */
    public int mo4718a() {
        if (this.f3637d != -1) {
            return this.f3637d;
        }
        return AudioAttributesCompat.m4558a(false, this.f3636c, this.f3634a);
    }

    /* renamed from: b */
    public int mo4719b() {
        return this.f3635b;
    }

    /* renamed from: c */
    public int mo4720c() {
        return this.f3634a;
    }

    /* renamed from: d */
    public int mo4721d() {
        int i = this.f3636c;
        int a = mo4718a();
        if (a == 6) {
            i |= 4;
        } else if (a == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3635b), Integer.valueOf(this.f3636c), Integer.valueOf(this.f3634a), Integer.valueOf(this.f3637d)});
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C1224c)) {
            return false;
        }
        C1224c cVar = (C1224c) obj;
        if (this.f3635b == cVar.mo4719b() && this.f3636c == cVar.mo4721d() && this.f3634a == cVar.mo4720c() && this.f3637d == cVar.f3637d) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3637d != -1) {
            sb.append(" stream=");
            sb.append(this.f3637d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.m4559a(this.f3634a));
        sb.append(" content=");
        sb.append(this.f3635b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3636c).toUpperCase());
        return sb.toString();
    }
}
