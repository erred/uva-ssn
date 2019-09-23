package p140me.bridgefy.storage.p151c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: me.bridgefy.storage.c.a */
/* compiled from: FileToUpload */
public class C3647a implements Parcelable {
    public static final Creator<C3647a> CREATOR = new Creator<C3647a>() {
        /* renamed from: a */
        public C3647a createFromParcel(Parcel parcel) {
            return new C3647a(parcel);
        }

        /* renamed from: a */
        public C3647a[] newArray(int i) {
            return new C3647a[i];
        }
    };

    /* renamed from: a */
    private final File f9635a;

    /* renamed from: b */
    private final String f9636b;

    /* renamed from: c */
    private final String f9637c;

    /* renamed from: d */
    private String f9638d;

    public int describeContents() {
        return 0;
    }

    public C3647a(String str, String str2, String str3, String str4) {
        this.f9635a = new File(str);
        this.f9637c = str2;
        this.f9638d = str4;
        if (str3 == null || "".equals(str3)) {
            this.f9636b = this.f9635a.getName();
        } else {
            this.f9636b = str3;
        }
    }

    /* renamed from: a */
    public final InputStream mo29773a() throws FileNotFoundException {
        return new FileInputStream(this.f9635a);
    }

    /* renamed from: b */
    public byte[] mo29774b() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(this.f9637c);
        sb.append("\"; filename=\"");
        sb.append(this.f9636b);
        sb.append("\"");
        sb.append("\r\n");
        if (this.f9638d == null) {
            this.f9638d = "application/octet-stream";
        }
        sb.append("Content-Type: ");
        sb.append(this.f9638d);
        sb.append("\r\n");
        sb.append("\r\n");
        return sb.toString().getBytes("US-ASCII");
    }

    /* renamed from: c */
    public long mo29775c() {
        return this.f9635a.length();
    }

    /* renamed from: a */
    public long mo29772a(long j) throws UnsupportedEncodingException {
        return j + ((long) mo29774b().length) + this.f9635a.length();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9635a.getAbsolutePath());
        parcel.writeString(this.f9637c);
        parcel.writeString(this.f9638d);
        parcel.writeString(this.f9636b);
    }

    private C3647a(Parcel parcel) {
        this.f9635a = new File(parcel.readString());
        this.f9637c = parcel.readString();
        this.f9638d = parcel.readString();
        this.f9636b = parcel.readString();
    }
}
