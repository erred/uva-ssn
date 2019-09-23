package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@ShowFirstParty
@Class(creator = "FieldMapPairCreator")
public final class zam extends AbstractSafeParcelable {
    public static final Creator<zam> CREATOR = new zaj();
    @VersionField(mo13452id = 1)
    private final int versionCode;
    @Field(mo13446id = 2)
    final String zaqy;
    @Field(mo13446id = 3)
    final FastJsonResponse.Field<?, ?> zaqz;

    @Constructor
    zam(@Param(mo13449id = 1) int i, @Param(mo13449id = 2) String str, @Param(mo13449id = 3) FastJsonResponse.Field<?, ?> field) {
        this.versionCode = i;
        this.zaqy = str;
        this.zaqz = field;
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.versionCode = 1;
        this.zaqy = str;
        this.zaqz = field;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zaqy, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zaqz, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
