package android.support.p041v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };

    /* renamed from: a */
    final int f804a;

    /* renamed from: b */
    final long f805b;

    /* renamed from: c */
    final long f806c;

    /* renamed from: d */
    final float f807d;

    /* renamed from: e */
    final long f808e;

    /* renamed from: f */
    final int f809f;

    /* renamed from: g */
    final CharSequence f810g;

    /* renamed from: h */
    final long f811h;

    /* renamed from: i */
    List<CustomAction> f812i;

    /* renamed from: j */
    final long f813j;

    /* renamed from: k */
    final Bundle f814k;

    /* renamed from: l */
    private Object f815l;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* renamed from: a */
        private final String f816a;

        /* renamed from: b */
        private final CharSequence f817b;

        /* renamed from: c */
        private final int f818c;

        /* renamed from: d */
        private final Bundle f819d;

        /* renamed from: e */
        private Object f820e;

        public int describeContents() {
            return 0;
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f816a = str;
            this.f817b = charSequence;
            this.f818c = i;
            this.f819d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f816a = parcel.readString();
            this.f817b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f818c = parcel.readInt();
            this.f819d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f816a);
            TextUtils.writeToParcel(this.f817b, parcel, i);
            parcel.writeInt(this.f818c);
            parcel.writeBundle(this.f819d);
        }

        /* renamed from: a */
        public static CustomAction m1074a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0404a.m1226a(obj), C0404a.m1227b(obj), C0404a.m1228c(obj), C0404a.m1229d(obj));
            customAction.f820e = obj;
            return customAction;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Action:mName='");
            sb.append(this.f817b);
            sb.append(", mIcon=");
            sb.append(this.f818c);
            sb.append(", mExtras=");
            sb.append(this.f819d);
            return sb.toString();
        }
    }

    public int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f804a = i;
        this.f805b = j;
        this.f806c = j2;
        this.f807d = f;
        this.f808e = j3;
        this.f809f = i2;
        this.f810g = charSequence;
        this.f811h = j4;
        this.f812i = new ArrayList(list);
        this.f813j = j5;
        this.f814k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f804a = parcel.readInt();
        this.f805b = parcel.readLong();
        this.f807d = parcel.readFloat();
        this.f811h = parcel.readLong();
        this.f806c = parcel.readLong();
        this.f808e = parcel.readLong();
        this.f810g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f812i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f813j = parcel.readLong();
        this.f814k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f809f = parcel.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=");
        sb.append(this.f804a);
        sb.append(", position=");
        sb.append(this.f805b);
        sb.append(", buffered position=");
        sb.append(this.f806c);
        sb.append(", speed=");
        sb.append(this.f807d);
        sb.append(", updated=");
        sb.append(this.f811h);
        sb.append(", actions=");
        sb.append(this.f808e);
        sb.append(", error code=");
        sb.append(this.f809f);
        sb.append(", error message=");
        sb.append(this.f810g);
        sb.append(", custom actions=");
        sb.append(this.f812i);
        sb.append(", active item id=");
        sb.append(this.f813j);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f804a);
        parcel.writeLong(this.f805b);
        parcel.writeFloat(this.f807d);
        parcel.writeLong(this.f811h);
        parcel.writeLong(this.f806c);
        parcel.writeLong(this.f808e);
        TextUtils.writeToParcel(this.f810g, parcel, i);
        parcel.writeTypedList(this.f812i);
        parcel.writeLong(this.f813j);
        parcel.writeBundle(this.f814k);
        parcel.writeInt(this.f809f);
    }

    /* renamed from: a */
    public static PlaybackStateCompat m1071a(Object obj) {
        List list;
        Object obj2 = obj;
        Bundle bundle = null;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h = C0403e.m1224h(obj);
        if (h != null) {
            ArrayList arrayList = new ArrayList(h.size());
            for (Object a : h) {
                arrayList.add(CustomAction.m1074a(a));
            }
            list = arrayList;
        } else {
            list = null;
        }
        if (VERSION.SDK_INT >= 22) {
            bundle = C0405f.m1230a(obj);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0403e.m1217a(obj), C0403e.m1218b(obj), C0403e.m1219c(obj), C0403e.m1220d(obj), C0403e.m1221e(obj), 0, C0403e.m1222f(obj), C0403e.m1223g(obj), list, C0403e.m1225i(obj), bundle);
        playbackStateCompat.f815l = obj2;
        return playbackStateCompat;
    }
}
