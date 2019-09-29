package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.firebase.auth.EmailAuthCredential;

@Class(creator = "SignInWithEmailLinkAidlRequestCreator")
public final class zzbw extends AbstractSafeParcelable {
    public static final Creator<zzbw> CREATOR = new zzbx();
    @Field(getter = "getCredential", mo13446id = 1)
    private final EmailAuthCredential zzij;

    @Constructor
    public zzbw(@Param(mo13449id = 1) EmailAuthCredential emailAuthCredential) {
        this.zzij = emailAuthCredential;
    }

    public final EmailAuthCredential zzct() {
        return this.zzij;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzij, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
