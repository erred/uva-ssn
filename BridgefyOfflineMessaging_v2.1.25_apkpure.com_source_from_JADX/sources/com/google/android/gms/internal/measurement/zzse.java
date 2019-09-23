package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import androidx.core.content.C0891b;

final class zzse implements zzsb {
    static zzse zzbrj;
    private final Context zzri;

    static zzse zzad(Context context) {
        zzse zzse;
        synchronized (zzse.class) {
            if (zzbrj == null) {
                zzbrj = C0891b.m3308a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzse(context) : new zzse();
            }
            zzse = zzbrj;
        }
        return zzse;
    }

    private zzse(Context context) {
        this.zzri = context;
        this.zzri.getContentResolver().registerContentObserver(zzru.CONTENT_URI, true, new zzsg(this, null));
    }

    private zzse() {
        this.zzri = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfo */
    public final String zzfn(String str) {
        if (this.zzri == null) {
            return null;
        }
        try {
            return (String) zzsc.zza(new zzsf(this, str));
        } catch (SecurityException e) {
            String str2 = "GservicesLoader";
            String str3 = "Unable to read GServices for: ";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ String zzfp(String str) {
        return zzru.zza(this.zzri.getContentResolver(), str, (String) null);
    }
}
