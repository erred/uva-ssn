package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
public final class zzac extends zzi<zzac> {
    private String zzuf;
    public int zzug;
    public int zzuh;
    public int zzui;
    public int zzuj;
    public int zzuk;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.zzuf);
        hashMap.put("screenColors", Integer.valueOf(this.zzug));
        hashMap.put("screenWidth", Integer.valueOf(this.zzuh));
        hashMap.put("screenHeight", Integer.valueOf(this.zzui));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzuj));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzuk));
        return zza((Object) hashMap);
    }

    public final String getLanguage() {
        return this.zzuf;
    }

    public final void setLanguage(String str) {
        this.zzuf = str;
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzac zzac = (zzac) zzi;
        if (this.zzug != 0) {
            zzac.zzug = this.zzug;
        }
        if (this.zzuh != 0) {
            zzac.zzuh = this.zzuh;
        }
        if (this.zzui != 0) {
            zzac.zzui = this.zzui;
        }
        if (this.zzuj != 0) {
            zzac.zzuj = this.zzuj;
        }
        if (this.zzuk != 0) {
            zzac.zzuk = this.zzuk;
        }
        if (!TextUtils.isEmpty(this.zzuf)) {
            zzac.zzuf = this.zzuf;
        }
    }
}
