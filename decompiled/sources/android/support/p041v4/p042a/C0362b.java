package android.support.p041v4.p042a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p041v4.p042a.C0359a.C0360a;

/* renamed from: android.support.v4.a.b */
/* compiled from: ResultReceiver */
public class C0362b implements Parcelable {
    public static final Creator<C0362b> CREATOR = new Creator<C0362b>() {
        /* renamed from: a */
        public C0362b createFromParcel(Parcel parcel) {
            return new C0362b(parcel);
        }

        /* renamed from: a */
        public C0362b[] newArray(int i) {
            return new C0362b[i];
        }
    };

    /* renamed from: a */
    final boolean f732a = false;

    /* renamed from: b */
    final Handler f733b = null;

    /* renamed from: c */
    C0359a f734c;

    /* renamed from: android.support.v4.a.b$a */
    /* compiled from: ResultReceiver */
    class C0364a extends C0360a {
        C0364a() {
        }

        /* renamed from: a */
        public void mo566a(int i, Bundle bundle) {
            if (C0362b.this.f733b != null) {
                C0362b.this.f733b.post(new C0365b(i, bundle));
            } else {
                C0362b.this.mo570a(i, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.a.b$b */
    /* compiled from: ResultReceiver */
    class C0365b implements Runnable {

        /* renamed from: a */
        final int f736a;

        /* renamed from: b */
        final Bundle f737b;

        C0365b(int i, Bundle bundle) {
            this.f736a = i;
            this.f737b = bundle;
        }

        public void run() {
            C0362b.this.mo570a(this.f736a, this.f737b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo570a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f734c == null) {
                this.f734c = new C0364a();
            }
            parcel.writeStrongBinder(this.f734c.asBinder());
        }
    }

    C0362b(Parcel parcel) {
        this.f734c = C0360a.m959a(parcel.readStrongBinder());
    }
}
