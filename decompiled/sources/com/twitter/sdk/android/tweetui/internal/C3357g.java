package com.twitter.sdk.android.tweetui.internal;

import android.os.Build.VERSION;
import com.twitter.sdk.android.core.p132a.C3112j;
import com.twitter.sdk.android.core.p132a.C3125u.C3126a;

/* renamed from: com.twitter.sdk.android.tweetui.internal.g */
/* compiled from: TweetMediaUtils */
public final class C3357g {
    /* renamed from: a */
    static boolean m9803a(C3112j jVar) {
        return "photo".equals(jVar.f8170c);
    }

    /* renamed from: b */
    static boolean m9805b(C3112j jVar) {
        return "video".equals(jVar.f8170c) || "animated_gif".equals(jVar.f8170c);
    }

    /* renamed from: c */
    public static C3126a m9806c(C3112j jVar) {
        for (C3126a aVar : jVar.f8171d.f8258b) {
            if (m9804a(aVar)) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static boolean m9807d(C3112j jVar) {
        return "animated_gif".equals(jVar.f8170c) || ("video".endsWith(jVar.f8170c) && jVar.f8171d.f8257a < 6500);
    }

    /* renamed from: e */
    public static boolean m9808e(C3112j jVar) {
        return !"animated_gif".equals(jVar.f8170c);
    }

    /* renamed from: a */
    static boolean m9804a(C3126a aVar) {
        if ((VERSION.SDK_INT < 21 || !"application/x-mpegURL".equals(aVar.f8259a)) && !"video/mp4".equals(aVar.f8259a)) {
            return false;
        }
        return true;
    }
}
