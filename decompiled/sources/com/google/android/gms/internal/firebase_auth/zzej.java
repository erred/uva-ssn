package com.google.android.gms.internal.firebase_auth;

import java.util.Comparator;

final class zzej implements Comparator<zzeh> {
    zzej() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzeh zzeh = (zzeh) obj;
        zzeh zzeh2 = (zzeh) obj2;
        zzeo zzeo = (zzeo) zzeh.iterator();
        zzeo zzeo2 = (zzeo) zzeh2.iterator();
        while (zzeo.hasNext() && zzeo2.hasNext()) {
            int compare = Integer.compare(zzeh.zza(zzeo.nextByte()), zzeh.zza(zzeo2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeh.size(), zzeh2.size());
    }
}
