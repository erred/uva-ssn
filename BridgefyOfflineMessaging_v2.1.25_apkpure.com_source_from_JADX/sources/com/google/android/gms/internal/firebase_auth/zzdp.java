package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class(creator = "StringListCreator")
public final class zzdp extends AbstractSafeParcelable {
    public static final Creator<zzdp> CREATOR = new zzdq();
    @VersionField(mo13452id = 1)
    private final int versionCode;
    @Field(getter = "getValues", mo13446id = 2)
    private List<String> zzpw;

    public final List<String> zzeb() {
        return this.zzpw;
    }

    public zzdp() {
        this(null);
    }

    private zzdp(List<String> list) {
        this.versionCode = 1;
        this.zzpw = new ArrayList();
        if (list != null && !list.isEmpty()) {
            this.zzpw.addAll(list);
        }
    }

    @Constructor
    zzdp(@Param(mo13449id = 1) int i, @Param(mo13449id = 2) List<String> list) {
        this.versionCode = i;
        if (list == null || list.isEmpty()) {
            this.zzpw = Collections.emptyList();
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, Strings.emptyToNull((String) list.get(i2)));
        }
        this.zzpw = Collections.unmodifiableList(list);
    }

    public static zzdp zzec() {
        return new zzdp(null);
    }

    public static zzdp zza(zzdp zzdp) {
        return new zzdp(zzdp != null ? zzdp.zzpw : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzpw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
