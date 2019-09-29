package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.C0983a;
import com.google.android.gms.base.C2152R;
import com.google.android.gms.common.util.DeviceProperties;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
    }

    public final void configure(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int zaa = zaa(i2, C2152R.C2154drawable.common_google_signin_btn_icon_dark, C2152R.C2154drawable.common_google_signin_btn_icon_light, C2152R.C2154drawable.common_google_signin_btn_icon_light);
        int zaa2 = zaa(i2, C2152R.C2154drawable.common_google_signin_btn_text_dark, C2152R.C2154drawable.common_google_signin_btn_text_light, C2152R.C2154drawable.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                zaa = zaa2;
                break;
            case 2:
                break;
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("Unknown button size: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
        Drawable g = C0983a.m3709g(resources.getDrawable(zaa));
        C0983a.m3698a(g, resources.getColorStateList(C2152R.C2153color.common_google_signin_btn_tint));
        C0983a.m3701a(g, Mode.SRC_ATOP);
        setBackgroundDrawable(g);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zaa(i2, C2152R.C2153color.common_google_signin_btn_text_dark, C2152R.C2153color.common_google_signin_btn_text_light, C2152R.C2153color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C2152R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C2152R.string.common_signin_button_text_long));
                break;
            case 2:
                setText(null);
                break;
            default:
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown button size: ");
                sb2.append(i);
                throw new IllegalStateException(sb2.toString());
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }

    private static int zaa(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unknown color scheme: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
    }
}
