package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.p070g.C0961q;

/* renamed from: androidx.appcompat.widget.q */
/* compiled from: AppCompatMultiAutoCompleteTextView */
public class C0691q extends MultiAutoCompleteTextView implements C0961q {

    /* renamed from: a */
    private static final int[] f2001a = {16843126};

    /* renamed from: b */
    private final C0675f f2002b;

    /* renamed from: c */
    private final C0705y f2003c;

    public C0691q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public C0691q(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        C0645av a = C0645av.m2230a(getContext(), attributeSet, f2001a, i, 0);
        if (a.mo2464g(0)) {
            setDropDownBackgroundDrawable(a.mo2449a(0));
        }
        a.mo2450a();
        this.f2002b = new C0675f(this);
        this.f2002b.mo2547a(attributeSet, i);
        this.f2003c = new C0705y(this);
        this.f2003c.mo2703a(attributeSet, i);
        this.f2003c.mo2698a();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0424a.m1270b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2002b != null) {
            this.f2002b.mo2543a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2002b != null) {
            this.f2002b.mo2546a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2002b != null) {
            this.f2002b.mo2544a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2002b != null) {
            return this.f2002b.mo2542a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2002b != null) {
            this.f2002b.mo2545a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        if (this.f2002b != null) {
            return this.f2002b.mo2548b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2002b != null) {
            this.f2002b.mo2550c();
        }
        if (this.f2003c != null) {
            this.f2003c.mo2698a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2003c != null) {
            this.f2003c.mo2702a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0687m.m2428a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
