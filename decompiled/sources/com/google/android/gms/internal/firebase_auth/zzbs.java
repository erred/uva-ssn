package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "SignInWithCustomTokenAidlRequestCreator")
public final class zzbs extends AbstractSafeParcelable {
    public static final Creator<zzbs> CREATOR = new zzbt();
    @Field(getter = "getToken", mo13446id = 1)
    private final String zzhm;

    @Constructor
    public zzbs(@Param(mo13449id = 1) String str) {
        this.zzhm = str;
    }

    public final String getToken() {
        return this.zzhm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
