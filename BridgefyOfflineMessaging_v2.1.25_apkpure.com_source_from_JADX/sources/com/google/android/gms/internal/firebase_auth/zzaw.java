package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "GetProvidersForEmailAidlRequestCreator")
public final class zzaw extends AbstractSafeParcelable {
    public static final Creator<zzaw> CREATOR = new zzax();
    @Field(getter = "getEmail", mo13446id = 1)
    private final String zzgh;
    @Field(getter = "getTenantId", mo13446id = 2)
    private final String zzgw;

    @Constructor
    public zzaw(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2) {
        this.zzgh = str;
        this.zzgw = str2;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
