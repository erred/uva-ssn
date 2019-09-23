package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.transition.d */
/* compiled from: Fade */
public class C1392d extends C1372aj {

    /* renamed from: androidx.transition.d$a */
    /* compiled from: Fade */
    private static class C1394a extends AnimatorListenerAdapter {

        /* renamed from: a */
        private final View f4171a;

        /* renamed from: b */
        private boolean f4172b = false;

        C1394a(View view) {
            this.f4171a = view;
        }

        public void onAnimationStart(Animator animator) {
            if (C0962r.m3597t(this.f4171a) && this.f4171a.getLayerType() == 0) {
                this.f4172b = true;
                this.f4171a.setLayerType(2, null);
            }
        }

        public void onAnimationEnd(Animator animator) {
            C1365ae.m5556a(this.f4171a, 1.0f);
            if (this.f4172b) {
                this.f4171a.setLayerType(0, null);
            }
        }
    }

    public C1392d(int i) {
        mo5728a(i);
    }

    public C1392d() {
    }

    public void captureStartValues(C1424t tVar) {
        super.captureStartValues(tVar);
        tVar.f4233a.put("android:fade:transitionAlpha", Float.valueOf(C1365ae.m5562c(tVar.f4234b)));
    }

    /* renamed from: a */
    private Animator m5625a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        C1365ae.m5556a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, C1365ae.f4098a, new float[]{f2});
        ofFloat.addListener(new C1394a(view));
        addListener(new C1415n() {
            /* renamed from: b */
            public void mo5738b(C1407m mVar) {
                C1365ae.m5556a(view, 1.0f);
                C1365ae.m5564e(view);
                mVar.removeListener(this);
            }
        });
        return ofFloat;
    }

    /* renamed from: a */
    public Animator mo5726a(ViewGroup viewGroup, View view, C1424t tVar, C1424t tVar2) {
        float f = BitmapDescriptorFactory.HUE_RED;
        float a = m5624a(tVar, BitmapDescriptorFactory.HUE_RED);
        if (a != 1.0f) {
            f = a;
        }
        return m5625a(view, f, 1.0f);
    }

    /* renamed from: b */
    public Animator mo5729b(ViewGroup viewGroup, View view, C1424t tVar, C1424t tVar2) {
        C1365ae.m5563d(view);
        return m5625a(view, m5624a(tVar, 1.0f), BitmapDescriptorFactory.HUE_RED);
    }

    /* renamed from: a */
    private static float m5624a(C1424t tVar, float f) {
        if (tVar == null) {
            return f;
        }
        Float f2 = (Float) tVar.f4233a.get("android:fade:transitionAlpha");
        return f2 != null ? f2.floatValue() : f;
    }
}
