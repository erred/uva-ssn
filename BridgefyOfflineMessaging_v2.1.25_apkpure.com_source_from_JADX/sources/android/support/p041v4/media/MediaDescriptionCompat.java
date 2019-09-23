package android.support.p041v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m977a(C0374a.m995a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a */
    private final String f750a;

    /* renamed from: b */
    private final CharSequence f751b;

    /* renamed from: c */
    private final CharSequence f752c;

    /* renamed from: d */
    private final CharSequence f753d;

    /* renamed from: e */
    private final Bitmap f754e;

    /* renamed from: f */
    private final Uri f755f;

    /* renamed from: g */
    private final Bundle f756g;

    /* renamed from: h */
    private final Uri f757h;

    /* renamed from: i */
    private Object f758i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    public static final class C0371a {

        /* renamed from: a */
        private String f759a;

        /* renamed from: b */
        private CharSequence f760b;

        /* renamed from: c */
        private CharSequence f761c;

        /* renamed from: d */
        private CharSequence f762d;

        /* renamed from: e */
        private Bitmap f763e;

        /* renamed from: f */
        private Uri f764f;

        /* renamed from: g */
        private Bundle f765g;

        /* renamed from: h */
        private Uri f766h;

        /* renamed from: a */
        public C0371a mo604a(String str) {
            this.f759a = str;
            return this;
        }

        /* renamed from: a */
        public C0371a mo603a(CharSequence charSequence) {
            this.f760b = charSequence;
            return this;
        }

        /* renamed from: b */
        public C0371a mo607b(CharSequence charSequence) {
            this.f761c = charSequence;
            return this;
        }

        /* renamed from: c */
        public C0371a mo608c(CharSequence charSequence) {
            this.f762d = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0371a mo600a(Bitmap bitmap) {
            this.f763e = bitmap;
            return this;
        }

        /* renamed from: a */
        public C0371a mo601a(Uri uri) {
            this.f764f = uri;
            return this;
        }

        /* renamed from: a */
        public C0371a mo602a(Bundle bundle) {
            this.f765g = bundle;
            return this;
        }

        /* renamed from: b */
        public C0371a mo606b(Uri uri) {
            this.f766h = uri;
            return this;
        }

        /* renamed from: a */
        public MediaDescriptionCompat mo605a() {
            MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(this.f759a, this.f760b, this.f761c, this.f762d, this.f763e, this.f764f, this.f765g, this.f766h);
            return mediaDescriptionCompat;
        }
    }

    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f750a = str;
        this.f751b = charSequence;
        this.f752c = charSequence2;
        this.f753d = charSequence3;
        this.f754e = bitmap;
        this.f755f = uri;
        this.f756g = bundle;
        this.f757h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f750a = parcel.readString();
        this.f751b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f752c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f753d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.f754e = (Bitmap) parcel.readParcelable(classLoader);
        this.f755f = (Uri) parcel.readParcelable(classLoader);
        this.f756g = parcel.readBundle(classLoader);
        this.f757h = (Uri) parcel.readParcelable(classLoader);
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f750a);
            TextUtils.writeToParcel(this.f751b, parcel, i);
            TextUtils.writeToParcel(this.f752c, parcel, i);
            TextUtils.writeToParcel(this.f753d, parcel, i);
            parcel.writeParcelable(this.f754e, i);
            parcel.writeParcelable(this.f755f, i);
            parcel.writeBundle(this.f756g);
            parcel.writeParcelable(this.f757h, i);
            return;
        }
        C0374a.m997a(mo592a(), parcel, i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f751b);
        sb.append(", ");
        sb.append(this.f752c);
        sb.append(", ");
        sb.append(this.f753d);
        return sb.toString();
    }

    /* renamed from: a */
    public Object mo592a() {
        if (this.f758i != null || VERSION.SDK_INT < 21) {
            return this.f758i;
        }
        Object a = C0375a.m1004a();
        C0375a.m1010a(a, this.f750a);
        C0375a.m1009a(a, this.f751b);
        C0375a.m1011b(a, this.f752c);
        C0375a.m1012c(a, this.f753d);
        C0375a.m1006a(a, this.f754e);
        C0375a.m1007a(a, this.f755f);
        Bundle bundle = this.f756g;
        if (VERSION.SDK_INT < 23 && this.f757h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f757h);
        }
        C0375a.m1008a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            C0377a.m1014a(a, this.f757h);
        }
        this.f758i = C0375a.m1005a(a);
        return this.f758i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p041v4.media.MediaDescriptionCompat m977a(java.lang.Object r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0085
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0085
            android.support.v4.media.MediaDescriptionCompat$a r1 = new android.support.v4.media.MediaDescriptionCompat$a
            r1.<init>()
            java.lang.String r2 = android.support.p041v4.media.C0374a.m996a(r6)
            r1.mo604a(r2)
            java.lang.CharSequence r2 = android.support.p041v4.media.C0374a.m998b(r6)
            r1.mo603a(r2)
            java.lang.CharSequence r2 = android.support.p041v4.media.C0374a.m999c(r6)
            r1.mo607b(r2)
            java.lang.CharSequence r2 = android.support.p041v4.media.C0374a.m1000d(r6)
            r1.mo608c(r2)
            android.graphics.Bitmap r2 = android.support.p041v4.media.C0374a.m1001e(r6)
            r1.mo600a(r2)
            android.net.Uri r2 = android.support.p041v4.media.C0374a.m1002f(r6)
            r1.mo601a(r2)
            android.os.Bundle r2 = android.support.p041v4.media.C0374a.m1003g(r6)
            if (r2 == 0) goto L_0x004a
            android.support.p041v4.media.session.MediaSessionCompat.m1057a(r2)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r3 = r2.getParcelable(r3)
            android.net.Uri r3 = (android.net.Uri) r3
            goto L_0x004b
        L_0x004a:
            r3 = r0
        L_0x004b:
            if (r3 == 0) goto L_0x0067
            java.lang.String r4 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r4 = r2.containsKey(r4)
            if (r4 == 0) goto L_0x005d
            int r4 = r2.size()
            r5 = 2
            if (r4 != r5) goto L_0x005d
            goto L_0x0068
        L_0x005d:
            java.lang.String r0 = "android.support.v4.media.description.MEDIA_URI"
            r2.remove(r0)
            java.lang.String r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            r2.remove(r0)
        L_0x0067:
            r0 = r2
        L_0x0068:
            r1.mo602a(r0)
            if (r3 == 0) goto L_0x0071
            r1.mo606b(r3)
            goto L_0x007e
        L_0x0071:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L_0x007e
            android.net.Uri r0 = android.support.p041v4.media.C0376b.m1013a(r6)
            r1.mo606b(r0)
        L_0x007e:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.mo605a()
            r0.f758i = r6
            return r0
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p041v4.media.MediaDescriptionCompat.m977a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }
}
