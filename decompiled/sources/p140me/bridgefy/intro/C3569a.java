package p140me.bridgefy.intro;

import android.view.View;
import androidx.viewpager.widget.ViewPager.C1476g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: me.bridgefy.intro.a */
/* compiled from: DepthPageTransformer */
public class C3569a implements C1476g {
    /* renamed from: a */
    public void mo6134a(View view, float f) {
        int width = view.getWidth();
        if (f < -1.0f) {
            view.setAlpha(BitmapDescriptorFactory.HUE_RED);
        } else if (f <= BitmapDescriptorFactory.HUE_RED) {
            view.setAlpha(1.0f);
            view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f <= 1.0f) {
            view.setAlpha(1.0f - f);
            view.setTranslationX(((float) width) * (-f));
            float abs = ((1.0f - Math.abs(f)) * 0.25f) + 0.75f;
            view.setScaleX(abs);
            view.setScaleY(abs);
        } else {
            view.setAlpha(BitmapDescriptorFactory.HUE_RED);
        }
    }
}
