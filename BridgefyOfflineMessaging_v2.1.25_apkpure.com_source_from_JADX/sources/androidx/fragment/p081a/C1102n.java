package androidx.fragment.p081a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.lifecycle.C1191r;

/* renamed from: androidx.fragment.a.n */
/* compiled from: FragmentState */
final class C1102n implements Parcelable {
    public static final Creator<C1102n> CREATOR = new Creator<C1102n>() {
        /* renamed from: a */
        public C1102n createFromParcel(Parcel parcel) {
            return new C1102n(parcel);
        }

        /* renamed from: a */
        public C1102n[] newArray(int i) {
            return new C1102n[i];
        }
    };

    /* renamed from: a */
    final String f3432a;

    /* renamed from: b */
    final int f3433b;

    /* renamed from: c */
    final boolean f3434c;

    /* renamed from: d */
    final int f3435d;

    /* renamed from: e */
    final int f3436e;

    /* renamed from: f */
    final String f3437f;

    /* renamed from: g */
    final boolean f3438g;

    /* renamed from: h */
    final boolean f3439h;

    /* renamed from: i */
    final Bundle f3440i;

    /* renamed from: j */
    final boolean f3441j;

    /* renamed from: k */
    Bundle f3442k;

    /* renamed from: l */
    C1062d f3443l;

    public int describeContents() {
        return 0;
    }

    C1102n(C1062d dVar) {
        this.f3432a = dVar.getClass().getName();
        this.f3433b = dVar.mIndex;
        this.f3434c = dVar.mFromLayout;
        this.f3435d = dVar.mFragmentId;
        this.f3436e = dVar.mContainerId;
        this.f3437f = dVar.mTag;
        this.f3438g = dVar.mRetainInstance;
        this.f3439h = dVar.mDetached;
        this.f3440i = dVar.mArguments;
        this.f3441j = dVar.mHidden;
    }

    C1102n(Parcel parcel) {
        this.f3432a = parcel.readString();
        this.f3433b = parcel.readInt();
        boolean z = false;
        this.f3434c = parcel.readInt() != 0;
        this.f3435d = parcel.readInt();
        this.f3436e = parcel.readInt();
        this.f3437f = parcel.readString();
        this.f3438g = parcel.readInt() != 0;
        this.f3439h = parcel.readInt() != 0;
        this.f3440i = parcel.readBundle();
        if (parcel.readInt() != 0) {
            z = true;
        }
        this.f3441j = z;
        this.f3442k = parcel.readBundle();
    }

    /* renamed from: a */
    public C1062d mo4507a(C1077h hVar, C1075f fVar, C1062d dVar, C1098k kVar, C1191r rVar) {
        if (this.f3443l == null) {
            Context i = hVar.mo4366i();
            if (this.f3440i != null) {
                this.f3440i.setClassLoader(i.getClassLoader());
            }
            if (fVar != null) {
                this.f3443l = fVar.mo4278a(i, this.f3432a, this.f3440i);
            } else {
                this.f3443l = C1062d.instantiate(i, this.f3432a, this.f3440i);
            }
            if (this.f3442k != null) {
                this.f3442k.setClassLoader(i.getClassLoader());
                this.f3443l.mSavedFragmentState = this.f3442k;
            }
            this.f3443l.setIndex(this.f3433b, dVar);
            this.f3443l.mFromLayout = this.f3434c;
            this.f3443l.mRestored = true;
            this.f3443l.mFragmentId = this.f3435d;
            this.f3443l.mContainerId = this.f3436e;
            this.f3443l.mTag = this.f3437f;
            this.f3443l.mRetainInstance = this.f3438g;
            this.f3443l.mDetached = this.f3439h;
            this.f3443l.mHidden = this.f3441j;
            this.f3443l.mFragmentManager = hVar.f3347b;
            if (C1081j.f3355a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiated fragment ");
                sb.append(this.f3443l);
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f3443l.mChildNonConfig = kVar;
        this.f3443l.mViewModelStore = rVar;
        return this.f3443l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3432a);
        parcel.writeInt(this.f3433b);
        parcel.writeInt(this.f3434c ? 1 : 0);
        parcel.writeInt(this.f3435d);
        parcel.writeInt(this.f3436e);
        parcel.writeString(this.f3437f);
        parcel.writeInt(this.f3438g ? 1 : 0);
        parcel.writeInt(this.f3439h ? 1 : 0);
        parcel.writeBundle(this.f3440i);
        parcel.writeInt(this.f3441j ? 1 : 0);
        parcel.writeBundle(this.f3442k);
    }
}
