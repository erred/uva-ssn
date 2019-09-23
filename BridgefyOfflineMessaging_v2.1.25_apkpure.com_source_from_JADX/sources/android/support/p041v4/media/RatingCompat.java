package android.support.p041v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };

    /* renamed from: a */
    private final int f773a;

    /* renamed from: b */
    private final float f774b;

    RatingCompat(int i, float f) {
        this.f773a = i;
        this.f774b = f;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f773a);
        sb.append(" rating=");
        if (this.f774b < BitmapDescriptorFactory.HUE_RED) {
            str = "unrated";
        } else {
            str = String.valueOf(this.f774b);
        }
        sb.append(str);
        return sb.toString();
    }

    public int describeContents() {
        return this.f773a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f773a);
        parcel.writeFloat(this.f774b);
    }
}
