package com.firebase.p119ui.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.firebase.ui.auth.a */
/* compiled from: AuthUI */
public class C2001a {

    /* renamed from: a */
    public static final Set<String> f6189a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"password", "google.com", "facebook.com", "twitter.com", "phone"})));

    /* renamed from: b */
    private static final IdentityHashMap<FirebaseApp, C2001a> f6190b = new IdentityHashMap<>();

    /* renamed from: com.firebase.ui.auth.a$1 */
    /* compiled from: AuthUI */
    class C20021 implements Continuation<Void, Task<Void>> {

        /* renamed from: a */
        final /* synthetic */ Task f6191a;

        /* renamed from: a */
        public Task<Void> then(Task<Void> task) throws Exception {
            task.getResult(Exception.class);
            return this.f6191a;
        }
    }

    /* renamed from: com.firebase.ui.auth.a$a */
    /* compiled from: AuthUI */
    public static class C2003a implements Parcelable {
        public static final Creator<C2003a> CREATOR = new Creator<C2003a>() {
            /* renamed from: a */
            public C2003a createFromParcel(Parcel parcel) {
                return new C2003a(parcel, null);
            }

            /* renamed from: a */
            public C2003a[] newArray(int i) {
                return new C2003a[i];
            }
        };

        /* renamed from: a */
        private final String f6192a;

        /* renamed from: b */
        private final List<String> f6193b;

        /* renamed from: c */
        private final Bundle f6194c;

        public int describeContents() {
            return 0;
        }

        /* synthetic */ C2003a(Parcel parcel, C20021 r2) {
            this(parcel);
        }

        private C2003a(Parcel parcel) {
            this.f6192a = parcel.readString();
            this.f6193b = Collections.unmodifiableList(parcel.createStringArrayList());
            this.f6194c = parcel.readBundle(getClass().getClassLoader());
        }

        /* renamed from: a */
        public String mo11789a() {
            return this.f6192a;
        }

        /* renamed from: b */
        public List<String> mo11790b() {
            return this.f6193b;
        }

        /* renamed from: c */
        public Bundle mo11791c() {
            return this.f6194c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f6192a);
            parcel.writeStringList(this.f6193b);
            parcel.writeBundle(this.f6194c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f6192a.equals(((C2003a) obj).f6192a);
        }

        public int hashCode() {
            return this.f6192a.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("IdpConfig{mProviderId='");
            sb.append(this.f6192a);
            sb.append('\'');
            sb.append(", mScopes=");
            sb.append(this.f6193b);
            sb.append(", mParams=");
            sb.append(this.f6194c);
            sb.append('}');
            return sb.toString();
        }
    }
}
