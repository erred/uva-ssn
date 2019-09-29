package com.firebase.p119ui.auth;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: com.firebase.ui.auth.c */
/* compiled from: IdpResponse */
public class C2034c implements Parcelable {
    public static final Creator<C2034c> CREATOR = new Creator<C2034c>() {
        /* renamed from: a */
        public C2034c createFromParcel(Parcel parcel) {
            C2034c cVar = new C2034c((C2037d) parcel.readParcelable(C2037d.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readInt());
            return cVar;
        }

        /* renamed from: a */
        public C2034c[] newArray(int i) {
            return new C2034c[i];
        }
    };

    /* renamed from: a */
    private final C2037d f6280a;

    /* renamed from: b */
    private final String f6281b;

    /* renamed from: c */
    private final String f6282c;

    /* renamed from: d */
    private final int f6283d;

    /* renamed from: com.firebase.ui.auth.c$a */
    /* compiled from: IdpResponse */
    public static class C2036a {

        /* renamed from: a */
        private C2037d f6284a;

        /* renamed from: b */
        private String f6285b;

        /* renamed from: c */
        private String f6286c;

        public C2036a(C2037d dVar) {
            this.f6284a = dVar;
        }

        /* renamed from: a */
        public C2036a mo11847a(String str) {
            this.f6285b = str;
            return this;
        }

        /* renamed from: b */
        public C2036a mo11849b(String str) {
            this.f6286c = str;
            return this;
        }

        /* renamed from: a */
        public C2034c mo11848a() {
            String a = this.f6284a.mo11850a();
            if ((a.equalsIgnoreCase("google.com") || a.equalsIgnoreCase("facebook.com") || a.equalsIgnoreCase("twitter.com")) && TextUtils.isEmpty(this.f6285b)) {
                throw new IllegalStateException("Token cannot be null when using a non-email provider.");
            } else if (!a.equalsIgnoreCase("twitter.com") || !TextUtils.isEmpty(this.f6286c)) {
                C2034c cVar = new C2034c(this.f6284a, this.f6285b, this.f6286c, -1);
                return cVar;
            } else {
                throw new IllegalStateException("Secret cannot be null when using the Twitter provider.");
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    private C2034c(int i) {
        this(null, null, null, i);
    }

    private C2034c(C2037d dVar, String str, String str2, int i) {
        this.f6280a = dVar;
        this.f6281b = str;
        this.f6282c = str2;
        this.f6283d = i;
    }

    /* renamed from: a */
    public static C2034c m8235a(Intent intent) {
        if (intent != null) {
            return (C2034c) intent.getParcelableExtra("extra_idp_response");
        }
        return null;
    }

    /* renamed from: a */
    public static Intent m8234a(int i) {
        return new C2034c(i).mo11835a();
    }

    /* renamed from: a */
    public Intent mo11835a() {
        return new Intent().putExtra("extra_idp_response", this);
    }

    /* renamed from: b */
    public C2037d mo11836b() {
        return this.f6280a;
    }

    /* renamed from: c */
    public String mo11837c() {
        return this.f6280a.mo11850a();
    }

    /* renamed from: d */
    public String mo11838d() {
        return this.f6280a.mo11851b();
    }

    /* renamed from: e */
    public String mo11840e() {
        return this.f6281b;
    }

    /* renamed from: f */
    public String mo11841f() {
        return this.f6282c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6280a, i);
        parcel.writeString(this.f6281b);
        parcel.writeString(this.f6282c);
        parcel.writeInt(this.f6283d);
    }
}
