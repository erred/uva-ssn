package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhc;
import java.io.InputStream;

public abstract class zzec<MessageType extends zzhc> implements zzhm<MessageType> {
    private static final zzfg zzsj = zzfg.zzgq();

    private final MessageType zza(InputStream inputStream, zzfg zzfg) throws zzgc {
        zzet zzet;
        if (inputStream == null) {
            byte[] bArr = zzfv.EMPTY_BYTE_ARRAY;
            zzet = zzet.zza(bArr, 0, bArr.length, false);
        } else {
            zzet = new zzew(inputStream);
        }
        MessageType messagetype = (zzhc) zza(zzet, zzfg);
        try {
            zzet.zzn(0);
            return messagetype;
        } catch (zzgc e) {
            throw e.zzh(messagetype);
        }
    }

    public final /* synthetic */ Object zzb(InputStream inputStream, zzfg zzfg) throws zzgc {
        zzip zzip;
        zzhc zza = zza(inputStream, zzfg);
        if (zza == null || zza.isInitialized()) {
            return zza;
        }
        if (zza instanceof zzdz) {
            zzip = new zzip((zzdz) zza);
        } else if (zza instanceof zzeb) {
            zzip = new zzip((zzeb) zza);
        } else {
            zzip = new zzip(zza);
        }
        throw new zzgc(zzip.getMessage()).zzh(zza);
    }
}
