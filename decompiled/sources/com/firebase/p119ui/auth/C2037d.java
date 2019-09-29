package com.firebase.p119ui.auth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.firebase.ui.auth.d */
/* compiled from: User */
public class C2037d implements Parcelable {
    public static final Creator<C2037d> CREATOR = new Creator<C2037d>() {
        /* renamed from: a */
        public C2037d createFromParcel(Parcel parcel) {
            C2037d dVar = new C2037d(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(Uri.class.getClassLoader()));
            return dVar;
        }

        /* renamed from: a */
        public C2037d[] newArray(int i) {
            return new C2037d[i];
        }
    };

    /* renamed from: a */
    private final String f6287a;

    /* renamed from: b */
    private final String f6288b;

    /* renamed from: c */
    private final String f6289c;

    /* renamed from: d */
    private final String f6290d;

    /* renamed from: e */
    private final Uri f6291e;

    /* renamed from: com.firebase.ui.auth.d$a */
    /* compiled from: User */
    public static class C2039a {

        /* renamed from: a */
        private String f6292a;

        /* renamed from: b */
        private String f6293b;

        /* renamed from: c */
        private String f6294c;

        /* renamed from: d */
        private String f6295d;

        /* renamed from: e */
        private Uri f6296e;

        public C2039a(String str, String str2) {
            this.f6292a = str;
            this.f6293b = str2;
        }

        /* renamed from: a */
        public C2039a mo11864a(String str) {
            this.f6294c = str;
            return this;
        }

        /* renamed from: b */
        public C2039a mo11866b(String str) {
            this.f6295d = str;
            return this;
        }

        /* renamed from: a */
        public C2039a mo11863a(Uri uri) {
            this.f6296e = uri;
            return this;
        }

        /* renamed from: a */
        public C2037d mo11865a() {
            C2037d dVar = new C2037d(this.f6292a, this.f6293b, this.f6294c, this.f6295d, this.f6296e);
            return dVar;
        }
    }

    public int describeContents() {
        return 0;
    }

    private C2037d(String str, String str2, String str3, String str4, Uri uri) {
        this.f6287a = str;
        this.f6288b = str2;
        this.f6289c = str3;
        this.f6290d = str4;
        this.f6291e = uri;
    }

    /* renamed from: a */
    public static C2037d m8247a(Intent intent) {
        return (C2037d) intent.getParcelableExtra("extra_user");
    }

    /* renamed from: a */
    public static C2037d m8248a(Bundle bundle) {
        return (C2037d) bundle.getParcelable("extra_user");
    }

    /* renamed from: a */
    public String mo11850a() {
        return this.f6287a;
    }

    /* renamed from: b */
    public String mo11851b() {
        return this.f6288b;
    }

    /* renamed from: c */
    public String mo11852c() {
        return this.f6290d;
    }

    /* renamed from: d */
    public Uri mo11853d() {
        return this.f6291e;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2037d dVar = (C2037d) obj;
        if (!this.f6287a.equals(dVar.f6287a) || (this.f6288b != null ? !this.f6288b.equals(dVar.f6288b) : dVar.f6288b != null) || (this.f6290d != null ? !this.f6290d.equals(dVar.f6290d) : dVar.f6290d != null) || (this.f6291e != null ? !this.f6291e.equals(dVar.f6291e) : dVar.f6291e != null)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f6287a.hashCode() * 31) + (this.f6288b == null ? 0 : this.f6288b.hashCode())) * 31) + (this.f6290d == null ? 0 : this.f6290d.hashCode())) * 31;
        if (this.f6291e != null) {
            i = this.f6291e.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{mProviderId='");
        sb.append(this.f6287a);
        sb.append('\'');
        sb.append(", mEmail='");
        sb.append(this.f6288b);
        sb.append('\'');
        sb.append(", mName='");
        sb.append(this.f6290d);
        sb.append('\'');
        sb.append(", mPhotoUri=");
        sb.append(this.f6291e);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6287a);
        parcel.writeString(this.f6288b);
        parcel.writeString(this.f6289c);
        parcel.writeString(this.f6290d);
        parcel.writeParcelable(this.f6291e, i);
    }
}
