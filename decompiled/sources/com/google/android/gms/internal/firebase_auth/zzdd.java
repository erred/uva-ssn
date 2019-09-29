package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class(creator = "ProviderUserInfoListCreator")
@Reserved({1})
public final class zzdd extends AbstractSafeParcelable {
    public static final Creator<zzdd> CREATOR = new zzde();
    @Field(getter = "getProviderUserInfos", mo13446id = 2)
    private List<zzdb> zzpm;

    public zzdd() {
        this.zzpm = new ArrayList();
    }

    public final List<zzdb> zzdu() {
        return this.zzpm;
    }

    @Constructor
    zzdd(@Param(mo13449id = 2) List<zzdb> list) {
        if (list == null || list.isEmpty()) {
            this.zzpm = Collections.emptyList();
        } else {
            this.zzpm = Collections.unmodifiableList(list);
        }
    }

    public static zzdd zza(zzdd zzdd) {
        List<zzdb> list = zzdd.zzpm;
        zzdd zzdd2 = new zzdd();
        if (list != null) {
            zzdd2.zzpm.addAll(list);
        }
        return zzdd2;
    }

    public static zzdd zzc(List<zzm> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzm zzm = (zzm) list.get(i);
            zzdb zzdb = new zzdb(Strings.emptyToNull(zzm.zzbg()), Strings.emptyToNull(zzm.getDisplayName()), Strings.emptyToNull(zzm.zzal()), Strings.emptyToNull(zzm.getProviderId()), null, Strings.emptyToNull(zzm.getPhoneNumber()), Strings.emptyToNull(zzm.getEmail()));
            arrayList.add(zzdb);
        }
        return new zzdd(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzpm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
