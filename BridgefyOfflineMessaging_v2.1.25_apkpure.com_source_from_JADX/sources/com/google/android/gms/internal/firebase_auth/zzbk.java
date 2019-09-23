package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "SendVerificationCodeAidlRequestCreator")
public final class zzbk extends AbstractSafeParcelable {
    public static final Creator<zzbk> CREATOR = new zzbl();
    @Field(getter = "getSendVerificationCodeRequest", mo13446id = 1)
    private final zzdj zzih;

    @Constructor
    public zzbk(@Param(mo13449id = 1) zzdj zzdj) {
        this.zzih = zzdj;
    }

    public final zzdj zzcr() {
        return this.zzih;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzih, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
