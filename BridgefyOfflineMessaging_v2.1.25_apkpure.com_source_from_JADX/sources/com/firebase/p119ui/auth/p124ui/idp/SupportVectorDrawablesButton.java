package com.firebase.p119ui.auth.p124ui.idp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.widget.C0676g;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.ui.idp.SupportVectorDrawablesButton */
public class SupportVectorDrawablesButton extends C0676g {
    public SupportVectorDrawablesButton(Context context) {
        super(context);
    }

    public SupportVectorDrawablesButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8350a(attributeSet);
    }

    public SupportVectorDrawablesButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8350a(attributeSet);
    }

    /* renamed from: a */
    private void m8350a(AttributeSet attributeSet) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SupportVectorDrawablesButton);
            Drawable drawable4 = null;
            if (VERSION.SDK_INT >= 21) {
                drawable3 = obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableStartCompat);
                Drawable drawable5 = obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableEndCompat);
                drawable = obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableTopCompat);
                drawable4 = obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableBottomCompat);
                drawable2 = drawable5;
            } else {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SupportVectorDrawablesButton_drawableStartCompat, -1);
                int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.SupportVectorDrawablesButton_drawableEndCompat, -1);
                int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.SupportVectorDrawablesButton_drawableTopCompat, -1);
                int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.SupportVectorDrawablesButton_drawableBottomCompat, -1);
                drawable3 = resourceId != -1 ? C0424a.m1270b(getContext(), resourceId) : null;
                drawable2 = resourceId2 != -1 ? C0424a.m1270b(getContext(), resourceId2) : null;
                drawable = resourceId3 != -1 ? C0424a.m1270b(getContext(), resourceId3) : null;
                if (resourceId4 != -1) {
                    drawable4 = C0424a.m1270b(getContext(), resourceId4);
                }
            }
            if (VERSION.SDK_INT >= 17) {
                setCompoundDrawablesRelativeWithIntrinsicBounds(drawable3, drawable, drawable2, drawable4);
            } else {
                setCompoundDrawablesWithIntrinsicBounds(drawable3, drawable, drawable2, drawable4);
            }
            obtainStyledAttributes.recycle();
        }
    }
}
