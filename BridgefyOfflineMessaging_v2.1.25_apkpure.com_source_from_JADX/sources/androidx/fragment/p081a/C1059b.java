package androidx.fragment.p081a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: androidx.fragment.a.b */
/* compiled from: BackStackRecord */
final class C1059b implements Parcelable {
    public static final Creator<C1059b> CREATOR = new Creator<C1059b>() {
        /* renamed from: a */
        public C1059b createFromParcel(Parcel parcel) {
            return new C1059b(parcel);
        }

        /* renamed from: a */
        public C1059b[] newArray(int i) {
            return new C1059b[i];
        }
    };

    /* renamed from: a */
    final int[] f3305a;

    /* renamed from: b */
    final int f3306b;

    /* renamed from: c */
    final int f3307c;

    /* renamed from: d */
    final String f3308d;

    /* renamed from: e */
    final int f3309e;

    /* renamed from: f */
    final int f3310f;

    /* renamed from: g */
    final CharSequence f3311g;

    /* renamed from: h */
    final int f3312h;

    /* renamed from: i */
    final CharSequence f3313i;

    /* renamed from: j */
    final ArrayList<String> f3314j;

    /* renamed from: k */
    final ArrayList<String> f3315k;

    /* renamed from: l */
    final boolean f3316l;

    public int describeContents() {
        return 0;
    }

    public C1059b(C1057a aVar) {
        int size = aVar.f3279b.size();
        this.f3305a = new int[(size * 6)];
        if (aVar.f3286i) {
            int i = 0;
            int i2 = 0;
            while (i < size) {
                C1058a aVar2 = (C1058a) aVar.f3279b.get(i);
                int i3 = i2 + 1;
                this.f3305a[i2] = aVar2.f3299a;
                int i4 = i3 + 1;
                this.f3305a[i3] = aVar2.f3300b != null ? aVar2.f3300b.mIndex : -1;
                int i5 = i4 + 1;
                this.f3305a[i4] = aVar2.f3301c;
                int i6 = i5 + 1;
                this.f3305a[i5] = aVar2.f3302d;
                int i7 = i6 + 1;
                this.f3305a[i6] = aVar2.f3303e;
                int i8 = i7 + 1;
                this.f3305a[i7] = aVar2.f3304f;
                i++;
                i2 = i8;
            }
            this.f3306b = aVar.f3284g;
            this.f3307c = aVar.f3285h;
            this.f3308d = aVar.f3288k;
            this.f3309e = aVar.f3290m;
            this.f3310f = aVar.f3291n;
            this.f3311g = aVar.f3292o;
            this.f3312h = aVar.f3293p;
            this.f3313i = aVar.f3294q;
            this.f3314j = aVar.f3295r;
            this.f3315k = aVar.f3296s;
            this.f3316l = aVar.f3297t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C1059b(Parcel parcel) {
        this.f3305a = parcel.createIntArray();
        this.f3306b = parcel.readInt();
        this.f3307c = parcel.readInt();
        this.f3308d = parcel.readString();
        this.f3309e = parcel.readInt();
        this.f3310f = parcel.readInt();
        this.f3311g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3312h = parcel.readInt();
        this.f3313i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3314j = parcel.createStringArrayList();
        this.f3315k = parcel.createStringArrayList();
        this.f3316l = parcel.readInt() != 0;
    }

    /* renamed from: a */
    public C1057a mo4093a(C1081j jVar) {
        C1057a aVar = new C1057a(jVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f3305a.length) {
            C1058a aVar2 = new C1058a();
            int i3 = i + 1;
            aVar2.f3299a = this.f3305a[i];
            if (C1081j.f3355a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(aVar);
                sb.append(" op #");
                sb.append(i2);
                sb.append(" base fragment #");
                sb.append(this.f3305a[i3]);
                Log.v("FragmentManager", sb.toString());
            }
            int i4 = i3 + 1;
            int i5 = this.f3305a[i3];
            if (i5 >= 0) {
                aVar2.f3300b = (C1062d) jVar.f3367f.get(i5);
            } else {
                aVar2.f3300b = null;
            }
            int i6 = i4 + 1;
            aVar2.f3301c = this.f3305a[i4];
            int i7 = i6 + 1;
            aVar2.f3302d = this.f3305a[i6];
            int i8 = i7 + 1;
            aVar2.f3303e = this.f3305a[i7];
            int i9 = i8 + 1;
            aVar2.f3304f = this.f3305a[i8];
            aVar.f3280c = aVar2.f3301c;
            aVar.f3281d = aVar2.f3302d;
            aVar.f3282e = aVar2.f3303e;
            aVar.f3283f = aVar2.f3304f;
            aVar.mo4072a(aVar2);
            i2++;
            i = i9;
        }
        aVar.f3284g = this.f3306b;
        aVar.f3285h = this.f3307c;
        aVar.f3288k = this.f3308d;
        aVar.f3290m = this.f3309e;
        aVar.f3286i = true;
        aVar.f3291n = this.f3310f;
        aVar.f3292o = this.f3311g;
        aVar.f3293p = this.f3312h;
        aVar.f3294q = this.f3313i;
        aVar.f3295r = this.f3314j;
        aVar.f3296s = this.f3315k;
        aVar.f3297t = this.f3316l;
        aVar.mo4071a(1);
        return aVar;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f3305a);
        parcel.writeInt(this.f3306b);
        parcel.writeInt(this.f3307c);
        parcel.writeString(this.f3308d);
        parcel.writeInt(this.f3309e);
        parcel.writeInt(this.f3310f);
        TextUtils.writeToParcel(this.f3311g, parcel, 0);
        parcel.writeInt(this.f3312h);
        TextUtils.writeToParcel(this.f3313i, parcel, 0);
        parcel.writeStringList(this.f3314j);
        parcel.writeStringList(this.f3315k);
        parcel.writeInt(this.f3316l ? 1 : 0);
    }
}
