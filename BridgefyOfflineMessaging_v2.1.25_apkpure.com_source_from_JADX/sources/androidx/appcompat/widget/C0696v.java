package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;

/* renamed from: androidx.appcompat.widget.v */
/* compiled from: AppCompatSeekBar */
public class C0696v extends SeekBar {

    /* renamed from: a */
    private final C0697w f2010a;

    public C0696v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public C0696v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2010a = new C0697w(this);
        this.f2010a.mo2643a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2010a.mo2652a(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2010a.mo2655c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f2010a.mo2654b();
    }
}
