package androidx.fragment.p081a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: androidx.fragment.a.l */
/* compiled from: FragmentManager */
final class C1099l implements Parcelable {
    public static final Creator<C1099l> CREATOR = new Creator<C1099l>() {
        /* renamed from: a */
        public C1099l createFromParcel(Parcel parcel) {
            return new C1099l(parcel);
        }

        /* renamed from: a */
        public C1099l[] newArray(int i) {
            return new C1099l[i];
        }
    };

    /* renamed from: a */
    C1102n[] f3424a;

    /* renamed from: b */
    int[] f3425b;

    /* renamed from: c */
    C1059b[] f3426c;

    /* renamed from: d */
    int f3427d = -1;

    /* renamed from: e */
    int f3428e;

    public int describeContents() {
        return 0;
    }

    public C1099l() {
    }

    public C1099l(Parcel parcel) {
        this.f3424a = (C1102n[]) parcel.createTypedArray(C1102n.CREATOR);
        this.f3425b = parcel.createIntArray();
        this.f3426c = (C1059b[]) parcel.createTypedArray(C1059b.CREATOR);
        this.f3427d = parcel.readInt();
        this.f3428e = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f3424a, i);
        parcel.writeIntArray(this.f3425b);
        parcel.writeTypedArray(this.f3426c, i);
        parcel.writeInt(this.f3427d);
        parcel.writeInt(this.f3428e);
    }
}
