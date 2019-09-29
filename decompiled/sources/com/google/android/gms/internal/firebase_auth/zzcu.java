package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zzd;

public final class zzcu implements Creator<zzct> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzct[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzdd zzdd = null;
        String str5 = null;
        String str6 = null;
        zzd zzd = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    zzdd = (zzdd) SafeParcelReader.createParcelable(parcel2, readHeader, zzdd.CREATOR);
                    break;
                case 8:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 11:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 12:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 13:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel2, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzct zzct = new zzct(str, str2, z, str3, str4, zzdd, str5, str6, j, j2, z2, zzd);
        return zzct;
    }
}
