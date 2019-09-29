package androidx.fragment.p081a;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: androidx.fragment.a.s */
/* compiled from: OneShotPreDrawListener */
class C1120s implements OnAttachStateChangeListener, OnPreDrawListener {

    /* renamed from: a */
    private final View f3507a;

    /* renamed from: b */
    private ViewTreeObserver f3508b;

    /* renamed from: c */
    private final Runnable f3509c;

    private C1120s(View view, Runnable runnable) {
        this.f3507a = view;
        this.f3508b = view.getViewTreeObserver();
        this.f3509c = runnable;
    }

    /* renamed from: a */
    public static C1120s m4356a(View view, Runnable runnable) {
        C1120s sVar = new C1120s(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(sVar);
        view.addOnAttachStateChangeListener(sVar);
        return sVar;
    }

    public boolean onPreDraw() {
        mo4556a();
        this.f3509c.run();
        return true;
    }

    /* renamed from: a */
    public void mo4556a() {
        if (this.f3508b.isAlive()) {
            this.f3508b.removeOnPreDrawListener(this);
        } else {
            this.f3507a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f3507a.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        this.f3508b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        mo4556a();
    }
}
