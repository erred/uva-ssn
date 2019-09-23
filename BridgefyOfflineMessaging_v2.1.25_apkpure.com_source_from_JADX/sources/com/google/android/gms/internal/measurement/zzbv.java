package com.google.android.gms.internal.measurement;

import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.measurement.zzbu;

class zzbv<T extends zzbu> extends zzat {
    private zzbw<T> zzyj;

    public zzbv(zzaw zzaw, zzbw<T> zzbw) {
        super(zzaw);
        this.zzyj = zzbw;
    }

    public final T zzq(int i) {
        try {
            return zza(zzbw().zzcm().getResources().getXml(i));
        } catch (NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        zzc("Error parsing bool configuration value", r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d4, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d5, code lost:
        zze("Error parsing tracker configuration file", r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4 A[ExcHandler: IOException | XmlPullParserException (r5v3 'e' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final T zza(android.content.res.XmlResourceParser r5) {
        /*
            r4 = this;
            r5.next()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            int r0 = r5.getEventType()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
        L_0x0007:
            r1 = 1
            if (r0 == r1) goto L_0x00da
            int r0 = r5.getEventType()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            r1 = 2
            if (r0 != r1) goto L_0x00ce
            java.lang.String r0 = r5.getName()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r0 = r0.toLowerCase(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = "screenname"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            r2 = 0
            if (r1 == 0) goto L_0x0045
            java.lang.String r0 = "name"
            java.lang.String r0 = r5.getAttributeValue(r2, r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r5.nextText()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            com.google.android.gms.internal.measurement.zzbw<T> r2 = r4.zzyj     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            r2.zzb(r0, r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            goto L_0x00ce
        L_0x0045:
            java.lang.String r1 = "string"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r1 == 0) goto L_0x0069
            java.lang.String r0 = "name"
            java.lang.String r0 = r5.getAttributeValue(r2, r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r5.nextText()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            if (r1 == 0) goto L_0x00ce
            com.google.android.gms.internal.measurement.zzbw<T> r2 = r4.zzyj     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            r2.zzc(r0, r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            goto L_0x00ce
        L_0x0069:
            java.lang.String r1 = "bool"
            boolean r1 = r0.equals(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r1 == 0) goto L_0x009c
            java.lang.String r0 = "name"
            java.lang.String r0 = r5.getAttributeValue(r2, r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r5.nextText()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            boolean r2 = java.lang.Boolean.parseBoolean(r1)     // Catch:{ NumberFormatException -> 0x0095, IOException | XmlPullParserException -> 0x00d4 }
            com.google.android.gms.internal.measurement.zzbw<T> r3 = r4.zzyj     // Catch:{ NumberFormatException -> 0x0095, IOException | XmlPullParserException -> 0x00d4 }
            r3.zza(r0, r2)     // Catch:{ NumberFormatException -> 0x0095, IOException | XmlPullParserException -> 0x00d4 }
            goto L_0x00ce
        L_0x0095:
            r0 = move-exception
            java.lang.String r2 = "Error parsing bool configuration value"
            r4.zzc(r2, r1, r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            goto L_0x00ce
        L_0x009c:
            java.lang.String r1 = "integer"
            boolean r0 = r0.equals(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r0 == 0) goto L_0x00ce
            java.lang.String r0 = "name"
            java.lang.String r0 = r5.getAttributeValue(r2, r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r5.nextText()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            java.lang.String r1 = r1.trim()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            if (r2 != 0) goto L_0x00ce
            int r2 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x00c8, IOException | XmlPullParserException -> 0x00d4 }
            com.google.android.gms.internal.measurement.zzbw<T> r3 = r4.zzyj     // Catch:{ NumberFormatException -> 0x00c8, IOException | XmlPullParserException -> 0x00d4 }
            r3.zzb(r0, r2)     // Catch:{ NumberFormatException -> 0x00c8, IOException | XmlPullParserException -> 0x00d4 }
            goto L_0x00ce
        L_0x00c8:
            r0 = move-exception
            java.lang.String r2 = "Error parsing int configuration value"
            r4.zzc(r2, r1, r0)     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
        L_0x00ce:
            int r0 = r5.next()     // Catch:{ IOException | XmlPullParserException -> 0x00d4 }
            goto L_0x0007
        L_0x00d4:
            r5 = move-exception
            java.lang.String r0 = "Error parsing tracker configuration file"
            r4.zze(r0, r5)
        L_0x00da:
            com.google.android.gms.internal.measurement.zzbw<T> r5 = r4.zzyj
            com.google.android.gms.internal.measurement.zzbu r5 = r5.zzdv()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbv.zza(android.content.res.XmlResourceParser):com.google.android.gms.internal.measurement.zzbu");
    }
}
