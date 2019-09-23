package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "UnlinkFederatedCredentialAidlRequestCreator")
public final class zzcc extends AbstractSafeParcelable {
    public static final Creator<zzcc> CREATOR = new zzcd();
    @Field(getter = "getCachedState", mo13446id = 2)
    private final String zzgk;
    @Field(getter = "getProvider", mo13446id = 1)
    private final String zzik;

    @Constructor
    public zzcc(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2) {
        this.zzik = str;
        this.zzgk = str2;
    }

    public final String getProvider() {
        return this.zzik;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzik, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
