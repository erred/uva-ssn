package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.p070g.C0961q;
import androidx.core.widget.C1013i;

/* renamed from: androidx.appcompat.widget.l */
/* compiled from: AppCompatEditText */
public class C0686l extends EditText implements C0961q {
    private final C0675f mBackgroundTintHelper;
    private final C0705y mTextHelper;

    public C0686l(Context context) {
        this(context, null);
    }

    public C0686l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public C0686l(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        this.mBackgroundTintHelper = new C0675f(this);
        this.mBackgroundTintHelper.mo2547a(attributeSet, i);
        this.mTextHelper = new C0705y(this);
        this.mTextHelper.mo2703a(attributeSet, i);
        this.mTextHelper.mo2698a();
    }

    public Editable getText() {
        if (VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2543a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2546a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2544a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.mBackgroundTintHelper != null) {
            return this.mBackgroundTintHelper.mo2542a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2545a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        if (this.mBackgroundTintHelper != null) {
            return this.mBackgroundTintHelper.mo2548b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2550c();
        }
        if (this.mTextHelper != null) {
            this.mTextHelper.mo2698a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.mTextHelper != null) {
            this.mTextHelper.mo2702a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0687m.m2428a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(C1013i.m3863a((TextView) this, callback));
    }
}
