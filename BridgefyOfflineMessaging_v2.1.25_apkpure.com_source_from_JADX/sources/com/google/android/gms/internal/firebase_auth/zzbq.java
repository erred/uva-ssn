package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "SignInWithCredentialAidlRequestCreator")
public final class zzbq extends AbstractSafeParcelable {
    public static final Creator<zzbq> CREATOR = new zzbr();
    @Field(getter = "getVerifyAssertionRequest", mo13446id = 1)
    private final zzdr zzie;

    @Constructor
    public zzbq(@Param(mo13449id = 1) zzdr zzdr) {
        this.zzie = zzdr;
    }

    public final zzdr zzco() {
        return this.zzie;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzie, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
