package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzst {
    private final ConcurrentHashMap<zzsu, List<Throwable>> zzbsg = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzbsh = new ReferenceQueue<>();

    zzst() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference poll = this.zzbsh.poll();
        while (poll != null) {
            this.zzbsg.remove(poll);
            poll = this.zzbsh.poll();
        }
        return (List) this.zzbsg.get(new zzsu(th, null));
    }
}
