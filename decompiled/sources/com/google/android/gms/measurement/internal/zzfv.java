package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "UserAttributeParcelCreator")
public final class zzfv extends AbstractSafeParcelable {
    public static final Creator<zzfv> CREATOR = new zzfw();
    @Field(mo13446id = 2)
    public final String name;
    @Field(mo13446id = 7)
    public final String origin;
    @Field(mo13446id = 1)
    private final int versionCode;
    @Field(mo13446id = 6)
    public final String zzaml;
    @Field(mo13446id = 3)
    public final long zzauk;
    @Field(mo13446id = 4)
    public final Long zzaul;
    @Field(mo13446id = 5)
    private final Float zzaum;
    @Field(mo13446id = 8)
    public final Double zzaun;

    zzfv(zzfx zzfx) {
        this(zzfx.name, zzfx.zzauk, zzfx.value, zzfx.origin);
    }

    zzfv(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzauk = j;
        this.origin = str2;
        if (obj == null) {
            this.zzaul = null;
            this.zzaum = null;
            this.zzaun = null;
            this.zzaml = null;
        } else if (obj instanceof Long) {
            this.zzaul = (Long) obj;
            this.zzaum = null;
            this.zzaun = null;
            this.zzaml = null;
        } else if (obj instanceof String) {
            this.zzaul = null;
            this.zzaum = null;
            this.zzaun = null;
            this.zzaml = (String) obj;
        } else if (obj instanceof Double) {
            this.zzaul = null;
            this.zzaum = null;
            this.zzaun = (Double) obj;
            this.zzaml = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    @Constructor
    zzfv(@Param(mo13449id = 1) int i, @Param(mo13449id = 2) String str, @Param(mo13449id = 3) long j, @Param(mo13449id = 4) Long l, @Param(mo13449id = 5) Float f, @Param(mo13449id = 6) String str2, @Param(mo13449id = 7) String str3, @Param(mo13449id = 8) Double d) {
        this.versionCode = i;
        this.name = str;
        this.zzauk = j;
        this.zzaul = l;
        Double d2 = null;
        this.zzaum = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.zzaun = d2;
        } else {
            this.zzaun = d;
        }
        this.zzaml = str2;
        this.origin = str3;
    }

    public final Object getValue() {
        if (this.zzaul != null) {
            return this.zzaul;
        }
        if (this.zzaun != null) {
            return this.zzaun;
        }
        if (this.zzaml != null) {
            return this.zzaml;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzauk);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzaul, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzaml, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzaun, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
