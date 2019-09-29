package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.firebase.auth.PhoneAuthCredential;

@Class(creator = "SignInWithPhoneNumberAidlRequestCreator")
public final class zzby extends AbstractSafeParcelable {
    public static final Creator<zzby> CREATOR = new zzbz();
    @Field(getter = "getTenantId", mo13446id = 2)
    private final String zzgw;
    @Field(getter = "getCredential", mo13446id = 1)
    private final PhoneAuthCredential zzif;

    @Constructor
    public zzby(@Param(mo13449id = 1) PhoneAuthCredential phoneAuthCredential, @Param(mo13449id = 2) String str) {
        this.zzif = phoneAuthCredential;
        this.zzgw = str;
    }

    public final PhoneAuthCredential zzcp() {
        return this.zzif;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzif, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
