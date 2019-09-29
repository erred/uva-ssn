package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "DeviceMetaDataRequestCreator")
public final class zzv extends AbstractSafeParcelable {
    public static final Creator<zzv> CREATOR = new zzw();
    @Field(mo13446id = 2)
    private final String accountType;
    @VersionField(mo13452id = 1)
    private final int zzv;

    public zzv(String str) {
        this(1, str);
    }

    @Constructor
    zzv(@Param(mo13449id = 1) int i, @Param(mo13449id = 2) String str) {
        this.zzv = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
