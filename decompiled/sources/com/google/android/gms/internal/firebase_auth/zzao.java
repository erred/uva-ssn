package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConfirmPasswordResetAidlRequestCreator")
public final class zzao extends AbstractSafeParcelable {
    public static final Creator<zzao> CREATOR = new zzap();
    @Field(getter = "getTenantId", mo13446id = 3)
    private final String zzgw;
    @Field(getter = "getCode", mo13446id = 1)
    private final String zzib;
    @Field(getter = "getNewPassword", mo13446id = 2)
    private final String zzic;

    @Constructor
    public zzao(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2, @Param(mo13449id = 3) String str3) {
        this.zzib = str;
        this.zzic = str2;
        this.zzgw = str3;
    }

    public final String zzcm() {
        return this.zzib;
    }

    public final String zzcn() {
        return this.zzic;
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzib, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzic, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
