package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.p070g.C0961q;
import androidx.core.widget.C1013i;

/* renamed from: androidx.appcompat.widget.e */
/* compiled from: AppCompatAutoCompleteTextView */
public class C0674e extends AutoCompleteTextView implements C0961q {

    /* renamed from: a */
    private static final int[] f1963a = {16843126};

    /* renamed from: b */
    private final C0675f f1964b;

    /* renamed from: c */
    private final C0705y f1965c;

    public C0674e(Context context) {
        this(context, null);
    }

    public C0674e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public C0674e(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        C0645av a = C0645av.m2230a(getContext(), attributeSet, f1963a, i, 0);
        if (a.mo2464g(0)) {
            setDropDownBackgroundDrawable(a.mo2449a(0));
        }
        a.mo2450a();
        this.f1964b = new C0675f(this);
        this.f1964b.mo2547a(attributeSet, i);
        this.f1965c = new C0705y(this);
        this.f1965c.mo2703a(attributeSet, i);
        this.f1965c.mo2698a();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0424a.m1270b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1964b != null) {
            this.f1964b.mo2543a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1964b != null) {
            this.f1964b.mo2546a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1964b != null) {
            this.f1964b.mo2544a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1964b != null) {
            return this.f1964b.mo2542a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1964b != null) {
            this.f1964b.mo2545a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        if (this.f1964b != null) {
            return this.f1964b.mo2548b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1964b != null) {
            this.f1964b.mo2550c();
        }
        if (this.f1965c != null) {
            this.f1965c.mo2698a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1965c != null) {
            this.f1965c.mo2702a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0687m.m2428a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(C1013i.m3863a((TextView) this, callback));
    }
}
