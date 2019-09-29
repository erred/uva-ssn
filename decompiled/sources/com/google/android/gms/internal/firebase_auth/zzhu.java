package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayDeque;
import java.util.Arrays;

final class zzhu {
    private final ArrayDeque<zzeh> zzaar;

    private zzhu() {
        this.zzaar = new ArrayDeque<>();
    }

    /* access modifiers changed from: private */
    public final zzeh zzc(zzeh zzeh, zzeh zzeh2) {
        zzd(zzeh);
        zzd(zzeh2);
        zzeh zzeh3 = (zzeh) this.zzaar.pop();
        while (!this.zzaar.isEmpty()) {
            zzeh3 = new zzhs((zzeh) this.zzaar.pop(), zzeh3, null);
        }
        return zzeh3;
    }

    private final void zzd(zzeh zzeh) {
        while (!zzeh.zzfd()) {
            if (zzeh instanceof zzhs) {
                zzhs zzhs = (zzhs) zzeh;
                zzd(zzhs.zzaak);
                zzeh = zzhs.zzaal;
            } else {
                String valueOf = String.valueOf(zzeh.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzba = zzba(zzeh.size());
        int i = zzhs.zzaai[zzba + 1];
        if (this.zzaar.isEmpty() || ((zzeh) this.zzaar.peek()).size() >= i) {
            this.zzaar.push(zzeh);
            return;
        }
        int i2 = zzhs.zzaai[zzba];
        zzeh zzeh2 = (zzeh) this.zzaar.pop();
        while (!this.zzaar.isEmpty() && ((zzeh) this.zzaar.peek()).size() < i2) {
            zzeh2 = new zzhs((zzeh) this.zzaar.pop(), zzeh2, null);
        }
        zzhs zzhs2 = new zzhs(zzeh2, zzeh, null);
        while (!this.zzaar.isEmpty()) {
            if (((zzeh) this.zzaar.peek()).size() >= zzhs.zzaai[zzba(zzhs2.size()) + 1]) {
                break;
            }
            zzhs2 = new zzhs((zzeh) this.zzaar.pop(), zzhs2, null);
        }
        this.zzaar.push(zzhs2);
    }

    private static int zzba(int i) {
        int binarySearch = Arrays.binarySearch(zzhs.zzaai, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzhu(zzht zzht) {
        this();
    }
}
