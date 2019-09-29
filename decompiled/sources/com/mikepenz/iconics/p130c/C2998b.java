package com.mikepenz.iconics.p130c;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* renamed from: com.mikepenz.iconics.c.b */
/* compiled from: IconicsTypefaceSpan */
public class C2998b extends TypefaceSpan {

    /* renamed from: a */
    private final Typeface f7837a;

    public C2998b(String str, Typeface typeface) {
        super(str);
        this.f7837a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        m8859a(textPaint, this.f7837a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m8859a(textPaint, this.f7837a);
    }

    /* renamed from: a */
    private static void m8859a(Paint paint, Typeface typeface) {
        int i;
        Typeface typeface2 = paint.getTypeface();
        if (typeface2 == null) {
            i = 0;
        } else {
            i = typeface2.getStyle();
        }
        int i2 = i & (~typeface.getStyle());
        if ((i2 & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((i2 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }
}
