package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.cardview.p056a.C0742a;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo;

public class CircularRevealCardView extends C0742a implements CircularRevealWidget {
    private final CircularRevealHelper helper;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.helper = new CircularRevealHelper(this);
    }

    public void buildCircularRevealCache() {
        this.helper.buildCircularRevealCache();
    }

    public void destroyCircularRevealCache() {
        this.helper.destroyCircularRevealCache();
    }

    public void setRevealInfo(RevealInfo revealInfo) {
        this.helper.setRevealInfo(revealInfo);
    }

    public RevealInfo getRevealInfo() {
        return this.helper.getRevealInfo();
    }

    public void setCircularRevealScrimColor(int i) {
        this.helper.setCircularRevealScrimColor(i);
    }

    public int getCircularRevealScrimColor() {
        return this.helper.getCircularRevealScrimColor();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.helper.getCircularRevealOverlayDrawable();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.helper.setCircularRevealOverlayDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        if (this.helper != null) {
            this.helper.draw(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public void actualDraw(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean isOpaque() {
        if (this.helper != null) {
            return this.helper.isOpaque();
        }
        return super.isOpaque();
    }

    public boolean actualIsOpaque() {
        return super.isOpaque();
    }
}