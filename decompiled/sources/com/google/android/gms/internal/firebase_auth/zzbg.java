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

@Class(creator = "SendEmailVerificationWithSettingsAidlRequestCreator")
public final class zzbg extends AbstractSafeParcelable {
    public static final Creator<zzbg> CREATOR = new zzbh();
    @Field(getter = "getToken", mo13446id = 1)
    private final String zzhm;
    @Field(getter = "getActionCodeSettings", mo13446id = 2)
    private final ActionCodeSettings zzig;

    @Constructor
    public zzbg(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) ActionCodeSettings actionCodeSettings) {
        this.zzhm = str;
        this.zzig = actionCodeSettings;
    }

    public final String getToken() {
        return this.zzhm;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzig, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
