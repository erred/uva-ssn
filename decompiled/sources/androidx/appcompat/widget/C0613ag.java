package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.C0555s;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.appcompat.widget.ag */
/* compiled from: ForwardingListener */
public abstract class C0613ag implements OnAttachStateChangeListener, OnTouchListener {

    /* renamed from: a */
    private final float f1730a;

    /* renamed from: b */
    private final int f1731b;

    /* renamed from: c */
    final View f1732c;

    /* renamed from: d */
    private final int f1733d;

    /* renamed from: e */
    private Runnable f1734e;

    /* renamed from: f */
    private Runnable f1735f;

    /* renamed from: g */
    private boolean f1736g;

    /* renamed from: h */
    private int f1737h;

    /* renamed from: i */
    private final int[] f1738i = new int[2];

    /* renamed from: androidx.appcompat.widget.ag$a */
    /* compiled from: ForwardingListener */
    private class C0614a implements Runnable {
        C0614a() {
        }

        public void run() {
            ViewParent parent = C0613ag.this.f1732c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ag$b */
    /* compiled from: ForwardingListener */
    private class C0615b implements Runnable {
        C0615b() {
        }

        public void run() {
            C0613ag.this.mo2206d();
        }
    }

    /* renamed from: a */
    public abstract C0555s mo1331a();

    public void onViewAttachedToWindow(View view) {
    }

    public C0613ag(View view) {
        this.f1732c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1730a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1731b = ViewConfiguration.getTapTimeout();
        this.f1733d = (this.f1731b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1736g;
        if (z2) {
            z = m2125b(motionEvent) || !mo2205c();
        } else {
            z = m2122a(motionEvent) && mo1332b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                this.f1732c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1736g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1736g = false;
        this.f1737h = -1;
        if (this.f1734e != null) {
            this.f1732c.removeCallbacks(this.f1734e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo1332b() {
        C0555s a = mo1331a();
        if (a != null && !a.mo1443c()) {
            a.mo1433a();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo2205c() {
        C0555s a = mo1331a();
        if (a != null && a.mo1443c()) {
            a.mo1439b();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2122a(MotionEvent motionEvent) {
        View view = this.f1732c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f1737h = motionEvent.getPointerId(0);
                if (this.f1734e == null) {
                    this.f1734e = new C0614a();
                }
                view.postDelayed(this.f1734e, (long) this.f1731b);
                if (this.f1735f == null) {
                    this.f1735f = new C0615b();
                }
                view.postDelayed(this.f1735f, (long) this.f1733d);
                break;
            case 1:
            case 3:
                m2127e();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1737h);
                if (findPointerIndex >= 0 && !m2123a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1730a)) {
                    m2127e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
        }
        return false;
    }

    /* renamed from: e */
    private void m2127e() {
        if (this.f1735f != null) {
            this.f1732c.removeCallbacks(this.f1735f);
        }
        if (this.f1734e != null) {
            this.f1732c.removeCallbacks(this.f1734e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo2206d() {
        m2127e();
        View view = this.f1732c;
        if (view.isEnabled() && !view.isLongClickable() && mo1332b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1736g = true;
        }
    }

    /* renamed from: b */
    private boolean m2125b(MotionEvent motionEvent) {
        View view = this.f1732c;
        C0555s a = mo1331a();
        if (a == null || !a.mo1443c()) {
            return false;
        }
        C0608ae aeVar = (C0608ae) a.mo1444d();
        if (aeVar == null || !aeVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m2126b(view, obtainNoHistory);
        m2124a(aeVar, obtainNoHistory);
        boolean a2 = aeVar.mo2189a(obtainNoHistory, this.f1737h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        boolean z = true;
        boolean z2 = (actionMasked == 1 || actionMasked == 3) ? false : true;
        if (!a2 || !z2) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m2123a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: a */
    private boolean m2124a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1738i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    /* renamed from: b */
    private boolean m2126b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1738i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }
}
