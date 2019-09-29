package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.C0611af.C0612a;

public class FitWindowsLinearLayout extends LinearLayout implements C0611af {

    /* renamed from: a */
    private C0612a f1598a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0612a aVar) {
        this.f1598a = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (this.f1598a != null) {
            this.f1598a.mo1024a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
