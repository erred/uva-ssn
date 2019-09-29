package androidx.core.p065c;

import android.os.Build.VERSION;
import android.os.Trace;

/* renamed from: androidx.core.c.b */
/* compiled from: TraceCompat */
public final class C0872b {
    /* renamed from: a */
    public static void m3226a(String str) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    /* renamed from: a */
    public static void m3225a() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
