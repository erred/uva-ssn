package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R;

/* renamed from: androidx.appcompat.widget.u */
/* compiled from: AppCompatRatingBar */
public class C0695u extends RatingBar {

    /* renamed from: a */
    private final C0693s f2009a;

    public C0695u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public C0695u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2009a = new C0693s(this);
        this.f2009a.mo2643a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f2009a.mo2642a();
        if (a != null) {
            setMeasuredDimension(View.resolveSizeAndState(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
