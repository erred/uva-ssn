package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.C0645av;
import com.google.android.material.C2167R;

public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0645av a = C0645av.m2229a(context, attributeSet, C2167R.styleable.TabItem);
        this.text = a.mo2456c(C2167R.styleable.TabItem_android_text);
        this.icon = a.mo2449a(C2167R.styleable.TabItem_android_icon);
        this.customLayout = a.mo2463g(C2167R.styleable.TabItem_android_layout, 0);
        a.mo2450a();
    }
}
