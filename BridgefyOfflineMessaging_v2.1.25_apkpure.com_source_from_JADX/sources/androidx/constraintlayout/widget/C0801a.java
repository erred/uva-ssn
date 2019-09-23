package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.constraintlayout.p060b.p061a.C0758b;

/* renamed from: androidx.constraintlayout.widget.a */
/* compiled from: Barrier */
public class C0801a extends C0805c {

    /* renamed from: f */
    private int f2542f;

    /* renamed from: g */
    private int f2543g;

    /* renamed from: h */
    private C0758b f2544h;

    public C0801a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f2542f;
    }

    public void setType(int i) {
        this.f2542f = i;
        this.f2543g = i;
        if (VERSION.SDK_INT >= 17) {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                if (this.f2542f == 5) {
                    this.f2543g = 1;
                } else if (this.f2542f == 6) {
                    this.f2543g = 0;
                }
            } else if (this.f2542f == 5) {
                this.f2543g = 0;
            } else if (this.f2542f == 6) {
                this.f2543g = 1;
            }
        } else if (this.f2542f == 5) {
            this.f2543g = 0;
        } else if (this.f2542f == 6) {
            this.f2543g = 1;
        }
        this.f2544h.mo3029a(this.f2543g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3270a(AttributeSet attributeSet) {
        super.mo3270a(attributeSet);
        this.f2544h = new C0758b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2544h.mo3031a(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f2564d = this.f2544h;
        mo3277b();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2544h.mo3031a(z);
    }

    /* renamed from: a */
    public boolean mo3271a() {
        return this.f2544h.mo3034b();
    }
}
