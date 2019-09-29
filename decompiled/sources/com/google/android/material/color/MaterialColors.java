package com.google.android.material.color;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.C0977a;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    public static int getColor(View view, int i) {
        return MaterialAttributes.resolveAttributeOrThrow(view, i).data;
    }

    public static int getColor(View view, int i, int i2) {
        TypedValue resolveAttribute = MaterialAttributes.resolveAttribute(view.getContext(), i);
        return resolveAttribute != null ? resolveAttribute.data : i2;
    }

    public static int layer(View view, int i, int i2) {
        return layer(view, i, i2, 1.0f);
    }

    public static int layer(View view, int i, int i2, float f) {
        return layer(getColor(view, i), getColor(view, i2), f);
    }

    public static int layer(int i, int i2, float f) {
        return layer(i, C0977a.m3660b(i2, Math.round(((float) Color.alpha(i2)) * f)));
    }

    public static int layer(int i, int i2) {
        return C0977a.m3658a(i2, i);
    }
}
