package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;
import p140me.bridgefy.ormlite.entities.FriendDTO;

@ShowFirstParty
public final class zzaj extends zzi<zzaj> {
    public String mCategory;
    public String zzvg;
    public long zzvh;
    public String zzvi;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.zzvg);
        hashMap.put("timeInMillis", Long.valueOf(this.zzvh));
        hashMap.put("category", this.mCategory);
        hashMap.put(FriendDTO.LABEL, this.zzvi);
        return zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaj zzaj = (zzaj) zzi;
        if (!TextUtils.isEmpty(this.zzvg)) {
            zzaj.zzvg = this.zzvg;
        }
        if (this.zzvh != 0) {
            zzaj.zzvh = this.zzvh;
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzaj.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzvi)) {
            zzaj.zzvi = this.zzvi;
        }
    }
}
