package com.github.clans.fab;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: com.github.clans.fab.b */
/* compiled from: Util */
final class C2138b {
    /* renamed from: a */
    static int m8571a(Context context, float f) {
        return Math.round(f * context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: a */
    static boolean m8572a() {
        return VERSION.SDK_INT >= 16;
    }

    /* renamed from: b */
    static boolean m8573b() {
        return VERSION.SDK_INT >= 21;
    }
}
