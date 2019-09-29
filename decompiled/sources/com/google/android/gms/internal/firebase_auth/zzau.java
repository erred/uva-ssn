package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "GetAccessTokenAidlRequestCreator")
public final class zzau extends AbstractSafeParcelable {
    public static final Creator<zzau> CREATOR = new zzav();
    @Field(getter = "getRefreshToken", mo13446id = 1)
    private final String zzid;

    @Constructor
    public zzau(@Param(mo13449id = 1) String str) {
        this.zzid = str;
    }

    public final String zzr() {
        return this.zzid;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzid, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
