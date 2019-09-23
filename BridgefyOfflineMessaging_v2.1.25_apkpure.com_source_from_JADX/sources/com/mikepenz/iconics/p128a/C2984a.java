package com.mikepenz.iconics.p128a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.mikepenz.iconics.C2994b;
import com.mikepenz.iconics.core.R;

/* renamed from: com.mikepenz.iconics.a.a */
/* compiled from: IconicsAttrsApplier */
public class C2984a {
    /* renamed from: a */
    public static C2994b m8792a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Iconics);
        try {
            return new C2985b(context, obtainStyledAttributes).mo27310a(R.styleable.Iconics_ico_icon).mo27313c(R.styleable.Iconics_ico_color).mo27312b(R.styleable.Iconics_ico_size).mo27314d(R.styleable.Iconics_ico_padding).mo27315e(R.styleable.Iconics_ico_contour_color).mo27316f(R.styleable.Iconics_ico_contour_width).mo27317g(R.styleable.Iconics_ico_background_color).mo27318h(R.styleable.Iconics_ico_corner_radius).mo27319i(R.styleable.Iconics_ico_background_contour_color).mo27320j(R.styleable.Iconics_ico_background_contour_width).mo27321k(R.styleable.Iconics_ico_offset_x).mo27322l(R.styleable.Iconics_ico_offset_y).mo27311a();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
