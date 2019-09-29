package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzp;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzm extends zzgh {

    /* renamed from: ID */
    private static final String f6706ID = com.google.android.gms.internal.measurement.zza.ARBITRARY_PIXEL.toString();
    private static final String URL = zzb.URL.toString();
    private static final String zzazi = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzazj = zzb.UNREPEATABLE.toString();
    private static final String zzazk;
    private static final Set<String> zzazl = new HashSet();
    private final zza zzazm;
    private final Context zzri;

    public interface zza {
        zzbx zznl();
    }

    public zzm(Context context) {
        this(context, new zzn(context));
    }

    @VisibleForTesting
    private zzm(Context context, zza zza2) {
        super(f6706ID, URL);
        this.zzazm = zza2;
        this.zzri = context;
    }

    public final void zze(Map<String, zzp> map) {
        String zzc = map.get(zzazj) != null ? zzgj.zzc((zzp) map.get(zzazj)) : null;
        if (zzc == null || !zzdb(zzc)) {
            Builder buildUpon = Uri.parse(zzgj.zzc((zzp) map.get(URL))).buildUpon();
            zzp zzp = (zzp) map.get(zzazi);
            if (zzp != null) {
                Object zzh = zzgj.zzh(zzp);
                if (!(zzh instanceof List)) {
                    String str = "ArbitraryPixel: additional params not a list: not sending partial hit: ";
                    String valueOf = String.valueOf(buildUpon.build().toString());
                    zzdi.m8600e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return;
                }
                for (Object next : (List) zzh) {
                    if (!(next instanceof Map)) {
                        String str2 = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ";
                        String valueOf2 = String.valueOf(buildUpon.build().toString());
                        zzdi.m8600e(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                        return;
                    }
                    for (Entry entry : ((Map) next).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.zzazm.zznl().zzdo(uri);
            String str3 = "ArbitraryPixel: url = ";
            String valueOf3 = String.valueOf(uri);
            zzdi.m8601v(valueOf3.length() != 0 ? str3.concat(valueOf3) : new String(str3));
            if (zzc != null) {
                synchronized (zzm.class) {
                    zzazl.add(zzc);
                    zzft.zza(this.zzri, zzazk, zzc, "true");
                }
            }
        }
    }

    private final synchronized boolean zzdb(String str) {
        if (zzazl.contains(str)) {
            return true;
        }
        if (!this.zzri.getSharedPreferences(zzazk, 0).contains(str)) {
            return false;
        }
        zzazl.add(str);
        return true;
    }

    static {
        String str = f6706ID;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 17);
        sb.append("gtm_");
        sb.append(str);
        sb.append("_unrepeatable");
        zzazk = sb.toString();
    }
}
