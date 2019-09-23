package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzre;
import com.google.android.gms.internal.measurement.zzrg;
import com.google.android.gms.internal.measurement.zzrk;
import com.google.android.gms.internal.measurement.zzro;
import com.google.android.gms.internal.measurement.zzyh;
import com.google.android.gms.internal.measurement.zzyi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

final class zzex implements zzah {
    private final ExecutorService zzadl = Executors.newSingleThreadExecutor();
    private final String zzazo;
    private zzdh<zzre> zzbeq;
    private final Context zzri;

    zzex(Context context, String str) {
        this.zzri = context;
        this.zzazo = str;
    }

    public final void zza(zzdh<zzre> zzdh) {
        this.zzbeq = zzdh;
    }

    public final void zzny() {
        this.zzadl.execute(new zzey(this));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r3.zzbeq.zzu(com.google.android.gms.tagmanager.zzcz.zzbdf);
        com.google.android.gms.tagmanager.zzdi.zzab("Failed to read the resource from disk. The resource is inconsistent");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        com.google.android.gms.tagmanager.zzdi.zzab("Error closing stream for reading resource from disk");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r3.zzbeq.zzu(com.google.android.gms.tagmanager.zzcz.zzbdf);
        com.google.android.gms.tagmanager.zzdi.zzab("Failed to read the resource from disk");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a6, code lost:
        com.google.android.gms.tagmanager.zzdi.zzab("Error closing stream for reading resource from disk");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b5, code lost:
        com.google.android.gms.tagmanager.zzdi.zzab("Error closing stream for reading resource from disk");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ba, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:26:0x0080, B:32:0x0096] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0080 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0096 */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzpr() {
        /*
            r3 = this;
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzre> r0 = r3.zzbeq
            if (r0 == 0) goto L_0x00c8
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzre> r0 = r3.zzbeq
            r0.zznx()
            java.lang.String r0 = "Attempting to load resource from disk"
            com.google.android.gms.tagmanager.zzdi.m8601v(r0)
            com.google.android.gms.tagmanager.zzeh r0 = com.google.android.gms.tagmanager.zzeh.zzpm()
            com.google.android.gms.tagmanager.zzeh$zza r0 = r0.zzpn()
            com.google.android.gms.tagmanager.zzeh$zza r1 = com.google.android.gms.tagmanager.zzeh.zza.CONTAINER
            if (r0 == r1) goto L_0x0026
            com.google.android.gms.tagmanager.zzeh r0 = com.google.android.gms.tagmanager.zzeh.zzpm()
            com.google.android.gms.tagmanager.zzeh$zza r0 = r0.zzpn()
            com.google.android.gms.tagmanager.zzeh$zza r1 = com.google.android.gms.tagmanager.zzeh.zza.CONTAINER_DEBUG
            if (r0 != r1) goto L_0x003e
        L_0x0026:
            java.lang.String r0 = r3.zzazo
            com.google.android.gms.tagmanager.zzeh r1 = com.google.android.gms.tagmanager.zzeh.zzpm()
            java.lang.String r1 = r1.getContainerId()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzre> r0 = r3.zzbeq
            int r1 = com.google.android.gms.tagmanager.zzcz.zzbde
            r0.zzu(r1)
            return
        L_0x003e:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bb }
            java.io.File r1 = r3.zzps()     // Catch:{ FileNotFoundException -> 0x00bb }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00bb }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            r1.<init>()     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzrg.zza(r0, r1)     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            byte[] r1 = r1.toByteArray()     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzre r2 = new com.google.android.gms.internal.measurement.zzre     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            r2.<init>()     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzyi r1 = com.google.android.gms.internal.measurement.zzyi.zza(r2, r1)     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzre r1 = (com.google.android.gms.internal.measurement.zzre) r1     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzl r2 = r1.zzqg     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            if (r2 != 0) goto L_0x006f
            com.google.android.gms.internal.measurement.zzo r2 = r1.zzbqd     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            if (r2 == 0) goto L_0x0067
            goto L_0x006f
        L_0x0067:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            java.lang.String r2 = "Resource and SupplementedResource are NULL."
            r1.<init>(r2)     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            throw r1     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
        L_0x006f:
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzre> r2 = r3.zzbeq     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            r2.onSuccess(r1)     // Catch:{ IOException -> 0x0096, IllegalArgumentException -> 0x0080 }
            r0.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x00ab
        L_0x0078:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzab(r0)
            goto L_0x00ab
        L_0x007e:
            r1 = move-exception
            goto L_0x00b1
        L_0x0080:
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzre> r1 = r3.zzbeq     // Catch:{ all -> 0x007e }
            int r2 = com.google.android.gms.tagmanager.zzcz.zzbdf     // Catch:{ all -> 0x007e }
            r1.zzu(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r1 = "Failed to read the resource from disk. The resource is inconsistent"
            com.google.android.gms.tagmanager.zzdi.zzab(r1)     // Catch:{ all -> 0x007e }
            r0.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x00ab
        L_0x0090:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzab(r0)
            goto L_0x00ab
        L_0x0096:
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzre> r1 = r3.zzbeq     // Catch:{ all -> 0x007e }
            int r2 = com.google.android.gms.tagmanager.zzcz.zzbdf     // Catch:{ all -> 0x007e }
            r1.zzu(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r1 = "Failed to read the resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzab(r1)     // Catch:{ all -> 0x007e }
            r0.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00ab
        L_0x00a6:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzab(r0)
        L_0x00ab:
            java.lang.String r0 = "The Disk resource was successfully read."
            com.google.android.gms.tagmanager.zzdi.m8601v(r0)
            return
        L_0x00b1:
            r0.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00ba
        L_0x00b5:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzab(r0)
        L_0x00ba:
            throw r1
        L_0x00bb:
            java.lang.String r0 = "Failed to find the resource in the disk"
            com.google.android.gms.tagmanager.zzdi.zzdn(r0)
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.measurement.zzre> r0 = r3.zzbeq
            int r1 = com.google.android.gms.tagmanager.zzcz.zzbde
            r0.zzu(r1)
            return
        L_0x00c8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Callback must be set before execute"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzex.zzpr():void");
    }

    public final void zza(zzre zzre) {
        this.zzadl.execute(new zzez(this, zzre));
    }

    public final zzrk zzv(int i) {
        try {
            InputStream openRawResource = this.zzri.getResources().openRawResource(i);
            String resourceName = this.zzri.getResources().getResourceName(i);
            StringBuilder sb = new StringBuilder(String.valueOf(resourceName).length() + 66);
            sb.append("Attempting to load a container from the resource ID ");
            sb.append(i);
            sb.append(" (");
            sb.append(resourceName);
            sb.append(")");
            zzdi.m8601v(sb.toString());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzrg.zza(openRawResource, byteArrayOutputStream);
                zzrk zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zze(byteArrayOutputStream.toByteArray());
                }
                zzdi.m8601v("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException unused) {
                String resourceName2 = this.zzri.getResources().getResourceName(i);
                StringBuilder sb2 = new StringBuilder(String.valueOf(resourceName2).length() + 67);
                sb2.append("Error reading the default container with resource ID ");
                sb2.append(i);
                sb2.append(" (");
                sb2.append(resourceName2);
                sb2.append(")");
                zzdi.zzab(sb2.toString());
                return null;
            }
        } catch (NotFoundException unused2) {
            StringBuilder sb3 = new StringBuilder(98);
            sb3.append("Failed to load the container. No default container resource found with the resource ID ");
            sb3.append(i);
            zzdi.zzab(sb3.toString());
            return null;
        }
    }

    private static zzrk zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzda.zzdv(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            zzdi.zzdn("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException unused2) {
            zzdi.zzab("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private static zzrk zze(byte[] bArr) {
        try {
            zzrk zza = zzrg.zza((zzl) zzyi.zza(new zzl(), bArr));
            if (zza != null) {
                zzdi.m8601v("The container was successfully loaded from the resource (using binary file)");
            }
            return zza;
        } catch (zzyh unused) {
            zzdi.m8600e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzro unused2) {
            zzdi.zzab("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    public final synchronized void release() {
        this.zzadl.shutdown();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final boolean zzb(zzre zzre) {
        File zzps = zzps();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzps);
            try {
                byte[] bArr = new byte[zzre.zzvx()];
                zzyi.zza(zzre, bArr, 0, bArr.length);
                fileOutputStream.write(bArr);
                try {
                } catch (IOException unused) {
                    zzdi.zzab("error closing stream for writing resource to disk");
                }
                return true;
            } catch (IOException unused2) {
                zzdi.zzab("Error writing resource to disk. Removing resource from disk.");
                zzps.delete();
                try {
                } catch (IOException unused3) {
                    zzdi.zzab("error closing stream for writing resource to disk");
                }
                return false;
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    zzdi.zzab("error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException unused5) {
            zzdi.m8600e("Error opening resource file for writing");
            return false;
        }
    }

    @VisibleForTesting
    private final File zzps() {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(this.zzazo);
        return new File(this.zzri.getDir("google_tagmanager", 0), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }
}
