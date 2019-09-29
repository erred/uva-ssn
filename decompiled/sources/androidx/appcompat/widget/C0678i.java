package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.widget.C1013i;

/* renamed from: androidx.appcompat.widget.i */
/* compiled from: AppCompatCheckedTextView */
public class C0678i extends CheckedTextView {

    /* renamed from: a */
    private static final int[] f1972a = {16843016};

    /* renamed from: b */
    private final C0705y f1973b;

    public C0678i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0678i(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        this.f1973b = new C0705y(this);
        this.f1973b.mo2703a(attributeSet, i);
        this.f1973b.mo2698a();
        C0645av a = C0645av.m2230a(getContext(), attributeSet, f1972a, i, 0);
        setCheckMarkDrawable(a.mo2449a(0));
        a.mo2450a();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0424a.m1270b(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1973b != null) {
            this.f1973b.mo2702a(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1973b != null) {
            this.f1973b.mo2698a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0687m.m2428a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(C1013i.m3863a((TextView) this, callback));
    }
}
