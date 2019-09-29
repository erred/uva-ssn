package com.squareup.picasso;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: com.squareup.picasso.h */
/* compiled from: DeferredRequestCreator */
class C3047h implements OnAttachStateChangeListener, OnPreDrawListener {

    /* renamed from: a */
    final WeakReference<ImageView> f7960a;

    /* renamed from: b */
    C3044e f7961b;

    /* renamed from: c */
    private final C3084x f7962c;

    C3047h(C3084x xVar, ImageView imageView, C3044e eVar) {
        this.f7962c = xVar;
        this.f7960a = new WeakReference<>(imageView);
        this.f7961b = eVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f7960a.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width <= 0 || height <= 0) {
            return true;
        }
        imageView.removeOnAttachStateChangeListener(this);
        viewTreeObserver.removeOnPreDrawListener(this);
        this.f7960a.clear();
        this.f7962c.mo27578b().mo27573a(width, height).mo27576a(imageView, this.f7961b);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27487a() {
        this.f7962c.mo27580c();
        this.f7961b = null;
        ImageView imageView = (ImageView) this.f7960a.get();
        if (imageView != null) {
            this.f7960a.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }
}
