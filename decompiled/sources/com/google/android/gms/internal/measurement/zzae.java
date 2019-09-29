package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import p140me.bridgefy.ormlite.entities.FriendDTO;

@ShowFirstParty
public final class zzae extends zzi<zzae> {
    private String category;
    private String label;
    private long value;
    private String zzul;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.category);
        hashMap.put("action", this.zzul);
        hashMap.put(FriendDTO.LABEL, this.label);
        hashMap.put(Param.VALUE, Long.valueOf(this.value));
        return zza((Object) hashMap);
    }

    public final String zzbb() {
        return this.category;
    }

    public final String getAction() {
        return this.zzul;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getValue() {
        return this.value;
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzae zzae = (zzae) zzi;
        if (!TextUtils.isEmpty(this.category)) {
            zzae.category = this.category;
        }
        if (!TextUtils.isEmpty(this.zzul)) {
            zzae.zzul = this.zzul;
        }
        if (!TextUtils.isEmpty(this.label)) {
            zzae.label = this.label;
        }
        if (this.value != 0) {
            zzae.value = this.value;
        }
    }
}
