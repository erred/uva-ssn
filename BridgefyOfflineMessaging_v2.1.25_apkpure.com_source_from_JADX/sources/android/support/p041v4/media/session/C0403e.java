package android.support.p041v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.media.session.e */
/* compiled from: PlaybackStateCompatApi21 */
class C0403e {

    /* renamed from: android.support.v4.media.session.e$a */
    /* compiled from: PlaybackStateCompatApi21 */
    static final class C0404a {
        /* renamed from: a */
        public static String m1226a(Object obj) {
            return ((CustomAction) obj).getAction();
        }

        /* renamed from: b */
        public static CharSequence m1227b(Object obj) {
            return ((CustomAction) obj).getName();
        }

        /* renamed from: c */
        public static int m1228c(Object obj) {
            return ((CustomAction) obj).getIcon();
        }

        /* renamed from: d */
        public static Bundle m1229d(Object obj) {
            return ((CustomAction) obj).getExtras();
        }
    }

    /* renamed from: a */
    public static int m1217a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    /* renamed from: b */
    public static long m1218b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    /* renamed from: c */
    public static long m1219c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    /* renamed from: d */
    public static float m1220d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    /* renamed from: e */
    public static long m1221e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    /* renamed from: f */
    public static CharSequence m1222f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    /* renamed from: g */
    public static long m1223g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    /* renamed from: h */
    public static List<Object> m1224h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    /* renamed from: i */
    public static long m1225i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
