package p140me.bridgefy.storage.p151c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.UnsupportedEncodingException;

/* renamed from: me.bridgefy.storage.c.b */
/* compiled from: NameValue */
public class C3649b implements Parcelable {
    public static final Creator<C3649b> CREATOR = new Creator<C3649b>() {
        /* renamed from: a */
        public C3649b createFromParcel(Parcel parcel) {
            return new C3649b(parcel);
        }

        /* renamed from: a */
        public C3649b[] newArray(int i) {
            return new C3649b[i];
        }
    };

    /* renamed from: a */
    private final String f9639a;

    /* renamed from: b */
    private final String f9640b;

    public int describeContents() {
        return 0;
    }

    public C3649b(String str, String str2) {
        this.f9639a = str;
        this.f9640b = str2;
    }

    /* renamed from: a */
    public final String mo29782a() {
        return this.f9639a;
    }

    /* renamed from: b */
    public final String mo29783b() {
        return this.f9640b;
    }

    /* renamed from: c */
    public byte[] mo29784c() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(this.f9639a);
        sb.append("\"");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(this.f9640b);
        return sb.toString().getBytes("UTF-8");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3649b)) {
            return false;
        }
        C3649b bVar = (C3649b) obj;
        if (!this.f9639a.equals(bVar.f9639a) || !this.f9640b.equals(bVar.f9640b)) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9639a);
        parcel.writeString(this.f9640b);
    }

    private C3649b(Parcel parcel) {
        this.f9639a = parcel.readString();
        this.f9640b = parcel.readString();
    }
}
