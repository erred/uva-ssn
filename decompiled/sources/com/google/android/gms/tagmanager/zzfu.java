package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

final class zzfu implements zzbe {
    private final String zzabl;
    private final zzfx zzbgl;
    private final zzfw zzbgm;
    private final Context zzri;

    @VisibleForTesting
    private zzfu(zzfx zzfx, Context context, zzfw zzfw) {
        this.zzbgl = zzfx;
        this.zzri = context.getApplicationContext();
        this.zzbgm = zzfw;
        String str = "GoogleTagManager";
        String str2 = "4.00";
        String str3 = VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str4 = null;
        if (!(locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            str4 = sb.toString();
        }
        this.zzabl = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, Build.MODEL, Build.ID});
    }

    @VisibleForTesting
    zzfu(Context context, zzfw zzfw) {
        this(new zzfv(), context, zzfw);
    }

    public final boolean zzom() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzri.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzdi.m8601v("...no network connectivity");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c A[Catch:{ IOException -> 0x0083 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(java.util.List<com.google.android.gms.tagmanager.zzbw> r11) {
        /*
            r10 = this;
            int r0 = r11.size()
            r1 = 40
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = 1
            r2 = 0
            r3 = 1
        L_0x000e:
            if (r2 >= r0) goto L_0x00b6
            java.lang.Object r4 = r11.get(r2)
            com.google.android.gms.tagmanager.zzbw r4 = (com.google.android.gms.tagmanager.zzbw) r4
            java.net.URL r5 = zzd(r4)
            if (r5 != 0) goto L_0x0028
            java.lang.String r5 = "No destination: discarding hit."
            com.google.android.gms.tagmanager.zzdi.zzab(r5)
            com.google.android.gms.tagmanager.zzfw r5 = r10.zzbgm
            r5.zzb(r4)
            goto L_0x00b2
        L_0x0028:
            r6 = 0
            com.google.android.gms.tagmanager.zzfx r7 = r10.zzbgl     // Catch:{ IOException -> 0x0083 }
            java.net.HttpURLConnection r5 = r7.zzc(r5)     // Catch:{ IOException -> 0x0083 }
            if (r3 == 0) goto L_0x003b
            android.content.Context r7 = r10.zzri     // Catch:{ all -> 0x0038 }
            com.google.android.gms.tagmanager.zzdn.zzw(r7)     // Catch:{ all -> 0x0038 }
            r3 = 0
            goto L_0x003b
        L_0x0038:
            r7 = move-exception
            r8 = r6
            goto L_0x007a
        L_0x003b:
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = r10.zzabl     // Catch:{ all -> 0x0038 }
            r5.setRequestProperty(r7, r8)     // Catch:{ all -> 0x0038 }
            int r7 = r5.getResponseCode()     // Catch:{ all -> 0x0038 }
            java.io.InputStream r8 = r5.getInputStream()     // Catch:{ all -> 0x0038 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r7 == r6) goto L_0x006c
            r6 = 25
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r9.<init>(r6)     // Catch:{ all -> 0x006a }
            java.lang.String r6 = "Bad response: "
            r9.append(r6)     // Catch:{ all -> 0x006a }
            r9.append(r7)     // Catch:{ all -> 0x006a }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.zzdi.zzab(r6)     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.zzfw r6 = r10.zzbgm     // Catch:{ all -> 0x006a }
            r6.zzc(r4)     // Catch:{ all -> 0x006a }
            goto L_0x0071
        L_0x006a:
            r7 = move-exception
            goto L_0x007a
        L_0x006c:
            com.google.android.gms.tagmanager.zzfw r6 = r10.zzbgm     // Catch:{ all -> 0x006a }
            r6.zza(r4)     // Catch:{ all -> 0x006a }
        L_0x0071:
            if (r8 == 0) goto L_0x0076
            r8.close()     // Catch:{ IOException -> 0x0083 }
        L_0x0076:
            r5.disconnect()     // Catch:{ IOException -> 0x0083 }
            goto L_0x00b2
        L_0x007a:
            if (r8 == 0) goto L_0x007f
            r8.close()     // Catch:{ IOException -> 0x0083 }
        L_0x007f:
            r5.disconnect()     // Catch:{ IOException -> 0x0083 }
            throw r7     // Catch:{ IOException -> 0x0083 }
        L_0x0083:
            r5 = move-exception
            java.lang.String r6 = "Exception sending hit: "
            java.lang.Class r7 = r5.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r8 = r7.length()
            if (r8 == 0) goto L_0x009d
            java.lang.String r6 = r6.concat(r7)
            goto L_0x00a3
        L_0x009d:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r6)
            r6 = r7
        L_0x00a3:
            com.google.android.gms.tagmanager.zzdi.zzab(r6)
            java.lang.String r5 = r5.getMessage()
            com.google.android.gms.tagmanager.zzdi.zzab(r5)
            com.google.android.gms.tagmanager.zzfw r5 = r10.zzbgm
            r5.zzc(r4)
        L_0x00b2:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfu.zzf(java.util.List):void");
    }

    @VisibleForTesting
    private static URL zzd(zzbw zzbw) {
        try {
            return new URL(zzbw.zzox());
        } catch (MalformedURLException unused) {
            zzdi.m8600e("Error trying to parse the GTM url.");
            return null;
        }
    }
}
