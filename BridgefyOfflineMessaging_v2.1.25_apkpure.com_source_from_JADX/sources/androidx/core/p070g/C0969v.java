package androidx.core.p070g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: androidx.core.g.v */
/* compiled from: ViewPropertyAnimatorCompat */
public final class C0969v {

    /* renamed from: a */
    Runnable f3028a = null;

    /* renamed from: b */
    Runnable f3029b = null;

    /* renamed from: c */
    int f3030c = -1;

    /* renamed from: d */
    private WeakReference<View> f3031d;

    /* renamed from: androidx.core.g.v$a */
    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0972a implements C0973w {

        /* renamed from: a */
        C0969v f3038a;

        /* renamed from: b */
        boolean f3039b;

        C0972a(C0969v vVar) {
            this.f3038a = vVar;
        }

        /* renamed from: a */
        public void mo1028a(View view) {
            this.f3039b = false;
            C0973w wVar = null;
            if (this.f3038a.f3030c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f3038a.f3028a != null) {
                Runnable runnable = this.f3038a.f3028a;
                this.f3038a.f3028a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof C0973w) {
                wVar = (C0973w) tag;
            }
            if (wVar != null) {
                wVar.mo1028a(view);
            }
        }

        /* renamed from: b */
        public void mo1029b(View view) {
            C0973w wVar = null;
            if (this.f3038a.f3030c > -1) {
                view.setLayerType(this.f3038a.f3030c, null);
                this.f3038a.f3030c = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.f3039b) {
                if (this.f3038a.f3029b != null) {
                    Runnable runnable = this.f3038a.f3029b;
                    this.f3038a.f3029b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof C0973w) {
                    wVar = (C0973w) tag;
                }
                if (wVar != null) {
                    wVar.mo1029b(view);
                }
                this.f3039b = true;
            }
        }

        /* renamed from: c */
        public void mo2144c(View view) {
            Object tag = view.getTag(2113929216);
            C0973w wVar = tag instanceof C0973w ? (C0973w) tag : null;
            if (wVar != null) {
                wVar.mo2144c(view);
            }
        }
    }

    C0969v(View view) {
        this.f3031d = new WeakReference<>(view);
    }

    /* renamed from: a */
    public C0969v mo3764a(long j) {
        View view = (View) this.f3031d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: a */
    public C0969v mo3763a(float f) {
        View view = (View) this.f3031d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* renamed from: b */
    public C0969v mo3768b(float f) {
        View view = (View) this.f3031d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* renamed from: a */
    public long mo3762a() {
        View view = (View) this.f3031d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    /* renamed from: a */
    public C0969v mo3765a(Interpolator interpolator) {
        View view = (View) this.f3031d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: b */
    public C0969v mo3769b(long j) {
        View view = (View) this.f3031d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* renamed from: b */
    public void mo3770b() {
        View view = (View) this.f3031d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: c */
    public void mo3771c() {
        View view = (View) this.f3031d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: a */
    public C0969v mo3766a(C0973w wVar) {
        View view = (View) this.f3031d.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                m3627a(view, wVar);
            } else {
                view.setTag(2113929216, wVar);
                m3627a(view, new C0972a(this));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m3627a(final View view, final C0973w wVar) {
        if (wVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    wVar.mo2144c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    wVar.mo1029b(view);
                }

                public void onAnimationStart(Animator animator) {
                    wVar.mo1028a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: a */
    public C0969v mo3767a(final C0975y yVar) {
        final View view = (View) this.f3031d.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            C09712 r1 = null;
            if (yVar != null) {
                r1 = new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        yVar.mo1095a(view);
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }
}
