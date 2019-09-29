package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.firebase.auth.ActionCodeSettings;

@Class(creator = "SendGetOobConfirmationCodeEmailAidlRequestCreator")
public final class zzbi extends AbstractSafeParcelable {
    public static final Creator<zzbi> CREATOR = new zzbj();
    @Field(getter = "getEmail", mo13446id = 1)
    private final String zzgh;
    @Field(getter = "getTenantId", mo13446id = 3)
    private final String zzgw;
    @Field(getter = "getActionCodeSettings", mo13446id = 2)
    private final ActionCodeSettings zzig;

    @Constructor
    public zzbi(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) ActionCodeSettings actionCodeSettings, @Param(mo13449id = 3) String str2) {
        this.zzgh = str;
        this.zzig = actionCodeSettings;
        this.zzgw = str2;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzig, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
