package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "DefaultFirebaseUserMetadataCreator")
public final class zzn implements FirebaseUserMetadata {
    public static final Creator<zzn> CREATOR = new zzo();
    @Field(getter = "getCreationTimestamp", mo13446id = 2)
    private long zzpc;
    @Field(getter = "getLastSignInTimestamp", mo13446id = 1)
    private long zzra;

    @Constructor
    public zzn(@Param(mo13449id = 1) long j, @Param(mo13449id = 2) long j2) {
        this.zzra = j;
        this.zzpc = j2;
    }

    public final int describeContents() {
        return 0;
    }

    public final long getLastSignInTimestamp() {
        return this.zzra;
    }

    public final long getCreationTimestamp() {
        return this.zzpc;
    }

    public final JSONObject zzeg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.zzra);
            jSONObject.put("creationTimestamp", this.zzpc);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static zzn zza(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new zzn(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getLastSignInTimestamp());
        SafeParcelWriter.writeLong(parcel, 2, getCreationTimestamp());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
