package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.C3176g;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.z */
/* compiled from: TimeBasedFileRollOverRunnable */
public class C3252z implements Runnable {

    /* renamed from: a */
    private final Context f8521a;

    /* renamed from: b */
    private final C3228m f8522b;

    public C3252z(Context context, C3228m mVar) {
        this.f8521a = context;
        this.f8522b = mVar;
    }

    public void run() {
        try {
            C3176g.m9302a(this.f8521a, "Performing time based file roll over.");
            if (!this.f8522b.mo27774c()) {
                this.f8522b.mo27773b();
            }
        } catch (Exception e) {
            C3176g.m9303a(this.f8521a, "Failed to roll over file", (Throwable) e);
        }
    }
}
