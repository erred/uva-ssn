package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new zza();
    private long durationMillis;
    @VersionField(mo13452id = 1)
    private final int versionCode;
    @Field(getter = "getTimeMillis", mo13446id = 2)
    private final long zzfo;
    @Field(getter = "getEventType", mo13446id = 11)
    private int zzfp;
    @Field(getter = "getWakeLockName", mo13446id = 4)
    private final String zzfq;
    @Field(getter = "getSecondaryWakeLockName", mo13446id = 10)
    private final String zzfr;
    @Field(getter = "getCodePackage", mo13446id = 17)
    private final String zzfs;
    @Field(getter = "getWakeLockType", mo13446id = 5)
    private final int zzft;
    @Field(getter = "getCallingPackages", mo13446id = 6)
    private final List<String> zzfu;
    @Field(getter = "getEventKey", mo13446id = 12)
    private final String zzfv;
    @Field(getter = "getElapsedRealtime", mo13446id = 8)
    private final long zzfw;
    @Field(getter = "getDeviceState", mo13446id = 14)
    private int zzfx;
    @Field(getter = "getHostPackage", mo13446id = 13)
    private final String zzfy;
    @Field(getter = "getBeginPowerPercentage", mo13446id = 15)
    private final float zzfz;
    @Field(getter = "getTimeout", mo13446id = 16)
    private final long zzga;

    @Constructor
    WakeLockEvent(@Param(mo13449id = 1) int i, @Param(mo13449id = 2) long j, @Param(mo13449id = 11) int i2, @Param(mo13449id = 4) String str, @Param(mo13449id = 5) int i3, @Param(mo13449id = 6) List<String> list, @Param(mo13449id = 12) String str2, @Param(mo13449id = 8) long j2, @Param(mo13449id = 14) int i4, @Param(mo13449id = 10) String str3, @Param(mo13449id = 13) String str4, @Param(mo13449id = 15) float f, @Param(mo13449id = 16) long j3, @Param(mo13449id = 17) String str5) {
        this.versionCode = i;
        this.zzfo = j;
        this.zzfp = i2;
        this.zzfq = str;
        this.zzfr = str3;
        this.zzfs = str5;
        this.zzft = i3;
        this.durationMillis = -1;
        this.zzfu = list;
        this.zzfv = str2;
        this.zzfw = j2;
        this.zzfx = i4;
        this.zzfy = str4;
        this.zzfz = f;
        this.zzga = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public final long getTimeMillis() {
        return this.zzfo;
    }

    public final int getEventType() {
        return this.zzfp;
    }

    public final long zzv() {
        return this.durationMillis;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, this.zzfq, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzft);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzfu, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzfw);
        SafeParcelWriter.writeString(parcel, 10, this.zzfr, false);
        SafeParcelWriter.writeInt(parcel, 11, getEventType());
        SafeParcelWriter.writeString(parcel, 12, this.zzfv, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzfy, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzfx);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzfz);
        SafeParcelWriter.writeLong(parcel, 16, this.zzga);
        SafeParcelWriter.writeString(parcel, 17, this.zzfs, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzw() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = this.zzfq;
        int i = this.zzft;
        if (this.zzfu == null) {
            str = "";
        } else {
            str = TextUtils.join(",", this.zzfu);
        }
        int i2 = this.zzfx;
        if (this.zzfr == null) {
            str2 = "";
        } else {
            str2 = this.zzfr;
        }
        if (this.zzfy == null) {
            str3 = "";
        } else {
            str3 = this.zzfy;
        }
        float f = this.zzfz;
        if (this.zzfs == null) {
            str4 = "";
        } else {
            str4 = this.zzfs;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 45 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str4);
        return sb.toString();
    }
}
