package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.C0795a;

/* renamed from: androidx.constraintlayout.widget.h */
/* compiled from: Guideline */
public class C0814h extends View {
    public void draw(Canvas canvas) {
    }

    public void setVisibility(int i) {
    }

    public C0814h(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        C0795a aVar = (C0795a) getLayoutParams();
        aVar.f2501a = i;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i) {
        C0795a aVar = (C0795a) getLayoutParams();
        aVar.f2516b = i;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f) {
        C0795a aVar = (C0795a) getLayoutParams();
        aVar.f2517c = f;
        setLayoutParams(aVar);
    }
}
