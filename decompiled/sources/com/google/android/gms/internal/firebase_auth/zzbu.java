package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "SignInWithEmailAndPasswordAidlRequestCreator")
public final class zzbu extends AbstractSafeParcelable {
    public static final Creator<zzbu> CREATOR = new zzbv();
    @Field(getter = "getEmail", mo13446id = 1)
    private final String zzgh;
    @Field(getter = "getPassword", mo13446id = 2)
    private final String zzgi;
    @Field(getter = "getTenantId", mo13446id = 3)
    private final String zzgw;

    @Constructor
    public zzbu(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2, @Param(mo13449id = 3) String str3) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgw = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
