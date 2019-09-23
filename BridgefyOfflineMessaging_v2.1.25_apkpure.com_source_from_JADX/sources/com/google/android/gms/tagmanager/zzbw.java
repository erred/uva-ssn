package com.google.android.gms.tagmanager;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzbw {
    private final long zzaax;
    private final long zzbcj;
    private final long zzbck;
    private String zzbcl;

    /* access modifiers changed from: 0000 */
    public final long zzov() {
        return this.zzbcj;
    }

    /* access modifiers changed from: 0000 */
    public final long zzow() {
        return this.zzbck;
    }

    zzbw(long j, long j2, long j3) {
        this.zzbcj = j;
        this.zzaax = j2;
        this.zzbck = j3;
    }

    /* access modifiers changed from: 0000 */
    public final String zzox() {
        return this.zzbcl;
    }

    /* access modifiers changed from: 0000 */
    public final void zzds(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzbcl = str;
        }
    }
}
