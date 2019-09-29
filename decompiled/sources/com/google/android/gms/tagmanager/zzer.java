package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzrs;

final class zzer implements Runnable {
    private final String zzazo;
    private volatile String zzbap;
    private final zzrs zzbeo;
    private final String zzbep;
    private zzdh<zzo> zzbeq;
    private volatile zzal zzber;
    private volatile String zzbes;
    private final Context zzri;

    public zzer(Context context, String str, zzal zzal) {
        this(context, str, new zzrs(), zzal);
    }

    @VisibleForTesting
    private zzer(Context context, String str, zzrs zzrs, zzal zzal) {
        this.zzri = context;
        this.zzbeo = zzrs;
        this.zzazo = str;
        this.zzber = zzal;
        String valueOf = String.valueOf("/r?id=");
        String valueOf2 = String.valueOf(str);
        this.zzbep = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        this.zzbap = this.zzbep;
        this.zzbes = null;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x01e9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r0 = r6.zzbeq
            if (r0 == 0) goto L_0x022e
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r0 = r6.zzbeq
            r0.zznx()
            android.content.Context r0 = r6.zzri
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = 1
            goto L_0x0028
        L_0x0022:
            java.lang.String r0 = "...no network connectivity"
            com.google.android.gms.tagmanager.zzdi.m8601v(r0)
            r0 = 0
        L_0x0028:
            if (r0 != 0) goto L_0x0032
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r0 = r6.zzbeq
            int r1 = com.google.android.gms.tagmanager.zzcz.zzbde
            r0.zzu(r1)
            return
        L_0x0032:
            java.lang.String r0 = "Start loading resource from network ..."
            com.google.android.gms.tagmanager.zzdi.m8601v(r0)
            com.google.android.gms.tagmanager.zzal r0 = r6.zzber
            java.lang.String r0 = r0.zzoe()
            java.lang.String r1 = r6.zzbap
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 12
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = "&v=a65833898"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = r6.zzbes
            if (r1 == 0) goto L_0x00a5
            java.lang.String r1 = r6.zzbes
            java.lang.String r1 = r1.trim()
            java.lang.String r2 = ""
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a5
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = r6.zzbes
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 4
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = "&pv="
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
        L_0x00a5:
            com.google.android.gms.tagmanager.zzeh r1 = com.google.android.gms.tagmanager.zzeh.zzpm()
            com.google.android.gms.tagmanager.zzeh$zza r1 = r1.zzpn()
            com.google.android.gms.tagmanager.zzeh$zza r2 = com.google.android.gms.tagmanager.zzeh.zza.CONTAINER_DEBUG
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00d0
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "&gtm_debug=x"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x00ca
            java.lang.String r0 = r0.concat(r1)
            goto L_0x00d0
        L_0x00ca:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x00d0:
            com.google.android.gms.internal.measurement.zzrr r1 = com.google.android.gms.internal.measurement.zzrs.zzth()
            r2 = 0
            java.io.InputStream r3 = r1.zzez(r0)     // Catch:{ FileNotFoundException -> 0x01e9, zzrt -> 0x011d, IOException -> 0x00de }
            r2 = r3
            goto L_0x013e
        L_0x00db:
            r0 = move-exception
            goto L_0x022a
        L_0x00de:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x00db }
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00db }
            int r4 = r4.length()     // Catch:{ all -> 0x00db }
            int r4 = r4 + 40
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00db }
            int r5 = r5.length()     // Catch:{ all -> 0x00db }
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r5.<init>(r4)     // Catch:{ all -> 0x00db }
            java.lang.String r4 = "Error when loading resources from url: "
            r5.append(r4)     // Catch:{ all -> 0x00db }
            r5.append(r0)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = " "
            r5.append(r0)     // Catch:{ all -> 0x00db }
            r5.append(r3)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00db }
            com.google.android.gms.tagmanager.zzdi.zzb(r0, r2)     // Catch:{ all -> 0x00db }
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r0 = r6.zzbeq     // Catch:{ all -> 0x00db }
            int r2 = com.google.android.gms.tagmanager.zzcz.zzbdf     // Catch:{ all -> 0x00db }
            r0.zzu(r2)     // Catch:{ all -> 0x00db }
            r1.close()
            return
        L_0x011d:
            java.lang.String r3 = "Error when loading resource for url: "
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00db }
            int r5 = r4.length()     // Catch:{ all -> 0x00db }
            if (r5 == 0) goto L_0x012e
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x00db }
            goto L_0x0134
        L_0x012e:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x00db }
            r4.<init>(r3)     // Catch:{ all -> 0x00db }
            r3 = r4
        L_0x0134:
            com.google.android.gms.tagmanager.zzdi.zzab(r3)     // Catch:{ all -> 0x00db }
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r3 = r6.zzbeq     // Catch:{ all -> 0x00db }
            int r4 = com.google.android.gms.tagmanager.zzcz.zzbdh     // Catch:{ all -> 0x00db }
            r3.zzu(r4)     // Catch:{ all -> 0x00db }
        L_0x013e:
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01aa }
            r3.<init>()     // Catch:{ IOException -> 0x01aa }
            com.google.android.gms.internal.measurement.zzrg.zza(r2, r3)     // Catch:{ IOException -> 0x01aa }
            byte[] r2 = r3.toByteArray()     // Catch:{ IOException -> 0x01aa }
            com.google.android.gms.internal.measurement.zzo r3 = new com.google.android.gms.internal.measurement.zzo     // Catch:{ IOException -> 0x01aa }
            r3.<init>()     // Catch:{ IOException -> 0x01aa }
            com.google.android.gms.internal.measurement.zzyi r2 = com.google.android.gms.internal.measurement.zzyi.zza(r3, r2)     // Catch:{ IOException -> 0x01aa }
            com.google.android.gms.internal.measurement.zzo r2 = (com.google.android.gms.internal.measurement.zzo) r2     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x01aa }
            int r4 = r4.length()     // Catch:{ IOException -> 0x01aa }
            int r4 = r4 + 43
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01aa }
            r5.<init>(r4)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = "Successfully loaded supplemented resource: "
            r5.append(r4)     // Catch:{ IOException -> 0x01aa }
            r5.append(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = r5.toString()     // Catch:{ IOException -> 0x01aa }
            com.google.android.gms.tagmanager.zzdi.m8601v(r3)     // Catch:{ IOException -> 0x01aa }
            com.google.android.gms.internal.measurement.zzl r3 = r2.zzqg     // Catch:{ IOException -> 0x01aa }
            if (r3 != 0) goto L_0x019c
            com.google.android.gms.internal.measurement.zzn[] r3 = r2.zzqf     // Catch:{ IOException -> 0x01aa }
            int r3 = r3.length     // Catch:{ IOException -> 0x01aa }
            if (r3 != 0) goto L_0x019c
            java.lang.String r3 = "No change for container: "
            java.lang.String r4 = r6.zzazo     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x01aa }
            int r5 = r4.length()     // Catch:{ IOException -> 0x01aa }
            if (r5 == 0) goto L_0x0193
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException -> 0x01aa }
            goto L_0x0199
        L_0x0193:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x01aa }
            r4.<init>(r3)     // Catch:{ IOException -> 0x01aa }
            r3 = r4
        L_0x0199:
            com.google.android.gms.tagmanager.zzdi.m8601v(r3)     // Catch:{ IOException -> 0x01aa }
        L_0x019c:
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r3 = r6.zzbeq     // Catch:{ IOException -> 0x01aa }
            r3.onSuccess(r2)     // Catch:{ IOException -> 0x01aa }
            r1.close()
            java.lang.String r0 = "Load resource from network finished."
            com.google.android.gms.tagmanager.zzdi.m8601v(r0)
            return
        L_0x01aa:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x00db }
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00db }
            int r4 = r4.length()     // Catch:{ all -> 0x00db }
            int r4 = r4 + 51
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00db }
            int r5 = r5.length()     // Catch:{ all -> 0x00db }
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r5.<init>(r4)     // Catch:{ all -> 0x00db }
            java.lang.String r4 = "Error when parsing downloaded resources from url: "
            r5.append(r4)     // Catch:{ all -> 0x00db }
            r5.append(r0)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = " "
            r5.append(r0)     // Catch:{ all -> 0x00db }
            r5.append(r3)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00db }
            com.google.android.gms.tagmanager.zzdi.zzb(r0, r2)     // Catch:{ all -> 0x00db }
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r0 = r6.zzbeq     // Catch:{ all -> 0x00db }
            int r2 = com.google.android.gms.tagmanager.zzcz.zzbdg     // Catch:{ all -> 0x00db }
            r0.zzu(r2)     // Catch:{ all -> 0x00db }
            r1.close()
            return
        L_0x01e9:
            java.lang.String r2 = r6.zzazo     // Catch:{ all -> 0x00db }
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00db }
            int r3 = r3.length()     // Catch:{ all -> 0x00db }
            int r3 = r3 + 79
            java.lang.String r4 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00db }
            int r4 = r4.length()     // Catch:{ all -> 0x00db }
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r4.<init>(r3)     // Catch:{ all -> 0x00db }
            java.lang.String r3 = "No data is retrieved from the given url: "
            r4.append(r3)     // Catch:{ all -> 0x00db }
            r4.append(r0)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = ". Make sure container_id: "
            r4.append(r0)     // Catch:{ all -> 0x00db }
            r4.append(r2)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = " is correct."
            r4.append(r0)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00db }
            com.google.android.gms.tagmanager.zzdi.zzab(r0)     // Catch:{ all -> 0x00db }
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzo> r0 = r6.zzbeq     // Catch:{ all -> 0x00db }
            int r2 = com.google.android.gms.tagmanager.zzcz.zzbdg     // Catch:{ all -> 0x00db }
            r0.zzu(r2)     // Catch:{ all -> 0x00db }
            r1.close()
            return
        L_0x022a:
            r1.close()
            throw r0
        L_0x022e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "callback must be set before execute"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzer.run():void");
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzdh<zzo> zzdh) {
        this.zzbeq = zzdh;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zzdg(String str) {
        if (str == null) {
            this.zzbap = this.zzbep;
            return;
        }
        String str2 = "Setting CTFE URL path: ";
        String valueOf = String.valueOf(str);
        zzdi.zzdn(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzbap = str;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zzdy(String str) {
        String str2 = "Setting previous container version: ";
        String valueOf = String.valueOf(str);
        zzdi.zzdn(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzbes = str;
    }
}