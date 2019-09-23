package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.widget.C1015j;

/* renamed from: androidx.appcompat.widget.t */
/* compiled from: AppCompatRadioButton */
public class C0694t extends RadioButton implements C1015j {
    private final C0679j mCompoundButtonHelper;
    private final C0705y mTextHelper;

    public C0694t(Context context) {
        this(context, null);
    }

    public C0694t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public C0694t(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        this.mCompoundButtonHelper = new C0679j(this);
        this.mCompoundButtonHelper.mo2586a(attributeSet, i);
        this.mTextHelper = new C0705y(this);
        this.mTextHelper.mo2703a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.mo2588c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(C0424a.m1270b(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.mo2582a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.mo2584a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.mCompoundButtonHelper != null) {
            return this.mCompoundButtonHelper.mo2583a();
        }
        return null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.mo2585a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        if (this.mCompoundButtonHelper != null) {
            return this.mCompoundButtonHelper.mo2587b();
        }
        return null;
    }
}
