package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.zzd;
import java.util.List;

public final class zzm implements Creator<zzl> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzcz zzcz = null;
        zzh zzh = null;
        String str = null;
        String str2 = null;
        List list = null;
        List list2 = null;
        String str3 = null;
        Boolean bool = null;
        zzn zzn = null;
        zzd zzd = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzcz = (zzcz) SafeParcelReader.createParcelable(parcel2, readHeader, zzcz.CREATOR);
                    break;
                case 2:
                    zzh = (zzh) SafeParcelReader.createParcelable(parcel2, readHeader, zzh.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    list = SafeParcelReader.createTypedList(parcel2, readHeader, zzh.CREATOR);
                    break;
                case 6:
                    list2 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    bool = SafeParcelReader.readBooleanObject(parcel2, readHeader);
                    break;
                case 9:
                    zzn = (zzn) SafeParcelReader.createParcelable(parcel2, readHeader, zzn.CREATOR);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel2, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzl zzl = new zzl(zzcz, zzh, str, str2, list, list2, str3, bool, zzn, z, zzd);
        return zzl;
    }
}
