package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.C1012h;

/* renamed from: androidx.appcompat.widget.r */
/* compiled from: AppCompatPopupWindow */
class C0692r extends PopupWindow {

    /* renamed from: a */
    private static final boolean f2004a = (VERSION.SDK_INT < 21);

    /* renamed from: b */
    private boolean f2005b;

    public C0692r(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m2439a(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m2439a(Context context, AttributeSet attributeSet, int i, int i2) {
        C0645av a = C0645av.m2230a(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (a.mo2464g(R.styleable.PopupWindow_overlapAnchor)) {
            m2440a(a.mo2451a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.mo2449a(R.styleable.PopupWindow_android_popupBackground));
        a.mo2450a();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2004a && this.f2005b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2004a && this.f2005b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f2004a && this.f2005b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m2440a(boolean z) {
        if (f2004a) {
            this.f2005b = z;
        } else {
            C1012h.m3859a((PopupWindow) this, z);
        }
    }
}
