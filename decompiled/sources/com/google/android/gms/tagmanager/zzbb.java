package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbb implements zzbx {
    private static final Object zzazc = new Object();
    private static zzbb zzbbu;
    private zzej zzbah;
    private zzby zzbbv;

    private zzbb(Context context) {
        this(zzbz.zzv(context), new zzfl());
    }

    @VisibleForTesting
    private zzbb(zzby zzby, zzej zzej) {
        this.zzbbv = zzby;
        this.zzbah = zzej;
    }

    public static zzbx zzp(Context context) {
        zzbb zzbb;
        synchronized (zzazc) {
            if (zzbbu == null) {
                zzbbu = new zzbb(context);
            }
            zzbb = zzbbu;
        }
        return zzbb;
    }

    public final boolean zzdo(String str) {
        if (!this.zzbah.zzew()) {
            zzdi.zzab("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        this.zzbbv.zzdt(str);
        return true;
    }
}
