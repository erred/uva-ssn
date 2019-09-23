package p140me.bridgefy.storage.p150b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: me.bridgefy.storage.b.a */
/* compiled from: UploadNotificationConfig */
public class C3645a implements Parcelable {
    public static final Creator<C3645a> CREATOR = new Creator<C3645a>() {
        /* renamed from: a */
        public C3645a createFromParcel(Parcel parcel) {
            return new C3645a(parcel);
        }

        /* renamed from: a */
        public C3645a[] newArray(int i) {
            return new C3645a[i];
        }
    };

    /* renamed from: a */
    private final int f9628a;

    /* renamed from: b */
    private final String f9629b;

    /* renamed from: c */
    private final String f9630c;

    /* renamed from: d */
    private final String f9631d;

    /* renamed from: e */
    private final String f9632e;

    /* renamed from: f */
    private final boolean f9633f;

    /* renamed from: g */
    private Intent f9634g;

    public int describeContents() {
        return 0;
    }

    public C3645a() {
        this.f9628a = 17301589;
        this.f9629b = "File Upload";
        this.f9630c = "uploading in progress";
        this.f9631d = "upload completed successfully!";
        this.f9632e = "error during upload";
        this.f9633f = false;
        this.f9634g = null;
    }

    public C3645a(int i, String str, String str2, String str3, String str4, boolean z) throws IllegalArgumentException {
        if (str == null || str2 == null || str3 == null || str4 == null) {
            throw new IllegalArgumentException("You can't provide null parameters");
        }
        this.f9628a = i;
        this.f9629b = str;
        this.f9630c = str2;
        this.f9631d = str3;
        this.f9632e = str4;
        this.f9633f = z;
    }

    /* renamed from: a */
    public final int mo29759a() {
        return this.f9628a;
    }

    /* renamed from: b */
    public final String mo29761b() {
        return this.f9629b;
    }

    /* renamed from: c */
    public final String mo29762c() {
        return this.f9630c;
    }

    /* renamed from: d */
    public final String mo29763d() {
        return this.f9631d;
    }

    /* renamed from: e */
    public final String mo29765e() {
        return this.f9632e;
    }

    /* renamed from: f */
    public final boolean mo29766f() {
        return this.f9633f;
    }

    /* renamed from: a */
    public final PendingIntent mo29760a(Context context) {
        if (this.f9634g == null) {
            return PendingIntent.getBroadcast(context, 0, new Intent(), 134217728);
        }
        return PendingIntent.getActivity(context, 1, this.f9634g, 134217728);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9628a);
        parcel.writeString(this.f9629b);
        parcel.writeString(this.f9630c);
        parcel.writeString(this.f9631d);
        parcel.writeString(this.f9632e);
        parcel.writeByte(this.f9633f ? (byte) 1 : 0);
        parcel.writeParcelable(this.f9634g, 0);
    }

    private C3645a(Parcel parcel) {
        this.f9628a = parcel.readInt();
        this.f9629b = parcel.readString();
        this.f9630c = parcel.readString();
        this.f9631d = parcel.readString();
        this.f9632e = parcel.readString();
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.f9633f = z;
        this.f9634g = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }
}
