package androidx.customview.p072a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

/* renamed from: androidx.customview.a.a */
/* compiled from: AbsSavedState */
public abstract class C1021a implements Parcelable {
    public static final Creator<C1021a> CREATOR = new ClassLoaderCreator<C1021a>() {
        /* renamed from: a */
        public C1021a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return C1021a.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: a */
        public C1021a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        /* renamed from: a */
        public C1021a[] newArray(int i) {
            return new C1021a[i];
        }
    };
    public static final C1021a EMPTY_STATE = new C1021a() {
    };
    private final Parcelable mSuperState;

    public int describeContents() {
        return 0;
    }

    private C1021a() {
        this.mSuperState = null;
    }

    protected C1021a(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable == EMPTY_STATE) {
                parcelable = null;
            }
            this.mSuperState = parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected C1021a(Parcel parcel) {
        this(parcel, null);
    }

    protected C1021a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = EMPTY_STATE;
        }
        this.mSuperState = readParcelable;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
