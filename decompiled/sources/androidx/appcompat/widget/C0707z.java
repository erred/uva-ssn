package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.p068e.C0911c;
import androidx.core.p068e.C0911c.C0912a;
import androidx.core.p070g.C0961q;
import androidx.core.widget.C1006b;
import androidx.core.widget.C1013i;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: androidx.appcompat.widget.z */
/* compiled from: AppCompatTextView */
public class C0707z extends TextView implements C0961q, C1006b {

    /* renamed from: a */
    private final C0675f f2052a;

    /* renamed from: b */
    private final C0705y f2053b;

    /* renamed from: c */
    private Future<C0911c> f2054c;

    public C0707z(Context context) {
        this(context, null);
    }

    public C0707z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public C0707z(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        this.f2052a = new C0675f(this);
        this.f2052a.mo2547a(attributeSet, i);
        this.f2053b = new C0705y(this);
        this.f2053b.mo2703a(attributeSet, i);
        this.f2053b.mo2698a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2052a != null) {
            this.f2052a.mo2543a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2052a != null) {
            this.f2052a.mo2546a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2052a != null) {
            this.f2052a.mo2544a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2052a != null) {
            return this.f2052a.mo2542a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2052a != null) {
            this.f2052a.mo2545a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        if (this.f2052a != null) {
            return this.f2052a.mo2548b();
        }
        return null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2053b != null) {
            this.f2053b.mo2702a(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2052a != null) {
            this.f2052a.mo2550c();
        }
        if (this.f2053b != null) {
            this.f2053b.mo2698a();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2053b != null) {
            this.f2053b.mo2706a(z, i, i2, i3, i4);
        }
    }

    public void setTextSize(int i, float f) {
        if (f3146d) {
            super.setTextSize(i, f);
        } else if (this.f2053b != null) {
            this.f2053b.mo2700a(i, f);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f2053b != null && !f3146d && this.f2053b.mo2709c()) {
            this.f2053b.mo2708b();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f3146d) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f2053b != null) {
            this.f2053b.mo2699a(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (f3146d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f2053b != null) {
            this.f2053b.mo2701a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (f3146d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f2053b != null) {
            this.f2053b.mo2707a(iArr, i);
        }
    }

    public int getAutoSizeTextType() {
        int i = 0;
        if (f3146d) {
            if (super.getAutoSizeTextType() == 1) {
                i = 1;
            }
            return i;
        } else if (this.f2053b != null) {
            return this.f2053b.mo2710d();
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (f3146d) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f2053b != null) {
            return this.f2053b.mo2711e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f3146d) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f2053b != null) {
            return this.f2053b.mo2712f();
        }
        return -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (f3146d) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f2053b != null) {
            return this.f2053b.mo2713g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f3146d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f2053b != null) {
            return this.f2053b.mo2714h();
        }
        return new int[0];
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0687m.m2428a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            C1013i.m3869b(this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            C1013i.m3872c(this, i);
        }
    }

    public int getFirstBaselineToTopHeight() {
        return C1013i.m3871c(this);
    }

    public int getLastBaselineToBottomHeight() {
        return C1013i.m3873d(this);
    }

    public void setLineHeight(int i) {
        C1013i.m3874d(this, i);
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(C1013i.m3863a((TextView) this, callback));
    }

    public C0912a getTextMetricsParamsCompat() {
        return C1013i.m3875e(this);
    }

    public void setTextMetricsParamsCompat(C0912a aVar) {
        C1013i.m3867a((TextView) this, aVar);
    }

    public void setPrecomputedText(C0911c cVar) {
        C1013i.m3868a((TextView) this, cVar);
    }

    /* renamed from: a */
    private void mo1312a() {
        if (this.f2054c != null) {
            try {
                Future<C0911c> future = this.f2054c;
                this.f2054c = null;
                C1013i.m3868a((TextView) this, (C0911c) future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public CharSequence getText() {
        mo1312a();
        return super.getText();
    }

    public void setTextFuture(Future<C0911c> future) {
        this.f2054c = future;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        mo1312a();
        super.onMeasure(i, i2);
    }
}
