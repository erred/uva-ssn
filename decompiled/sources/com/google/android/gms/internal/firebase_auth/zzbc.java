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

@Class(creator = "LinkPhoneAuthCredentialAidlRequestCreator")
public final class zzbc extends AbstractSafeParcelable {
    public static final Creator<zzbc> CREATOR = new zzbd();
    @Field(getter = "getCachedState", mo13446id = 1)
    private final String zzgk;
    @Field(getter = "getCredential", mo13446id = 2)
    private final PhoneAuthCredential zzif;

    @Constructor
    public zzbc(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) PhoneAuthCredential phoneAuthCredential) {
        this.zzgk = str;
        this.zzif = phoneAuthCredential;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final PhoneAuthCredential zzcp() {
        return this.zzif;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzif, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
