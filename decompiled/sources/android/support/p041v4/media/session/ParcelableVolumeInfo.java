package android.support.p041v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.ParcelableVolumeInfo */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new Creator<ParcelableVolumeInfo>() {
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };

    /* renamed from: a */
    public int f799a;

    /* renamed from: b */
    public int f800b;

    /* renamed from: c */
    public int f801c;

    /* renamed from: d */
    public int f802d;

    /* renamed from: e */
    public int f803e;

    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f799a = parcel.readInt();
        this.f801c = parcel.readInt();
        this.f802d = parcel.readInt();
        this.f803e = parcel.readInt();
        this.f800b = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f799a);
        parcel.writeInt(this.f801c);
        parcel.writeInt(this.f802d);
        parcel.writeInt(this.f803e);
        parcel.writeInt(this.f800b);
    }
}
