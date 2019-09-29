package p000a.p001a.p002a.p003a.p004a.p006b;

/* renamed from: a.a.a.a.a.b.b */
/* compiled from: AdvertisingInfo */
class C0009b {

    /* renamed from: a */
    public final String f14a;

    /* renamed from: b */
    public final boolean f15b;

    C0009b(String str, boolean z) {
        this.f14a = str;
        this.f15b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0009b bVar = (C0009b) obj;
        if (this.f15b != bVar.f15b) {
            return false;
        }
        return this.f14a == null ? bVar.f14a == null : this.f14a.equals(bVar.f14a);
    }

    public int hashCode() {
        return ((this.f14a != null ? this.f14a.hashCode() : 0) * 31) + (this.f15b ? 1 : 0);
    }
}
