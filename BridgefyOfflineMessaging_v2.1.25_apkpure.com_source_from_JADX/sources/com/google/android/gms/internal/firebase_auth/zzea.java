package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzea;

public abstract class zzea<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzea<MessageType, BuilderType>> implements zzhd {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzet */
    public abstract BuilderType clone();

    public final /* synthetic */ zzhd zzb(zzhc zzhc) {
        if (zzhi().getClass().isInstance(zzhc)) {
            return zza((zzdz) zzhc);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
