package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzhv implements Iterator<zzeq> {
    private final ArrayDeque<zzhs> zzaas;
    private zzeq zzaat;

    private zzhv(zzeh zzeh) {
        this.zzaas = new ArrayDeque<>();
        this.zzaat = zze(zzeh);
    }

    private final zzeq zze(zzeh zzeh) {
        while (zzeh instanceof zzhs) {
            zzhs zzhs = (zzhs) zzeh;
            this.zzaas.push(zzhs);
            zzeh = zzhs.zzaak;
        }
        return (zzeq) zzeh;
    }

    public final boolean hasNext() {
        return this.zzaat != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        zzeq zzeq;
        boolean z;
        if (this.zzaat != null) {
            zzeq zzeq2 = this.zzaat;
            while (true) {
                if (!this.zzaas.isEmpty()) {
                    zzeq = zze(((zzhs) this.zzaas.pop()).zzaal);
                    if (zzeq.size() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                } else {
                    zzeq = null;
                    break;
                }
            }
            this.zzaat = zzeq;
            return zzeq2;
        }
        throw new NoSuchElementException();
    }

    /* synthetic */ zzhv(zzeh zzeh, zzht zzht) {
        this(zzeh);
    }
}
