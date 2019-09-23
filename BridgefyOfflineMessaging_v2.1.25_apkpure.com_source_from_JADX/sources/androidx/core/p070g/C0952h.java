package androidx.core.p070g;

import android.view.MotionEvent;

/* renamed from: androidx.core.g.h */
/* compiled from: MotionEventCompat */
public final class C0952h {
    @Deprecated
    /* renamed from: a */
    public static int m3513a(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    /* renamed from: a */
    public static int m3514a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    /* renamed from: b */
    public static int m3515b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    /* renamed from: c */
    public static float m3516c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    /* renamed from: d */
    public static boolean m3517d(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
