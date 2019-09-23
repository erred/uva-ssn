package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C0611af.C0612a;

public class FitWindowsFrameLayout extends FrameLayout implements C0611af {

    /* renamed from: a */
    private C0612a f1597a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0612a aVar) {
        this.f1597a = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (this.f1597a != null) {
            this.f1597a.mo1024a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
