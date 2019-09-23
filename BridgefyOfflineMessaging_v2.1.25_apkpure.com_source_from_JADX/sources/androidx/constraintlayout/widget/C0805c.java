package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.p060b.p061a.C0766f;
import androidx.constraintlayout.p060b.p061a.C0773j;
import androidx.constraintlayout.widget.ConstraintLayout.C0795a;
import androidx.constraintlayout.widget.R.id;
import java.util.Arrays;

/* renamed from: androidx.constraintlayout.widget.c */
/* compiled from: ConstraintHelper */
public abstract class C0805c extends View {

    /* renamed from: a */
    protected int[] f2561a = new int[32];

    /* renamed from: b */
    protected int f2562b;

    /* renamed from: c */
    protected Context f2563c;

    /* renamed from: d */
    protected C0773j f2564d;

    /* renamed from: e */
    protected boolean f2565e = false;

    /* renamed from: f */
    private String f2566f;

    /* renamed from: g */
    private View[] f2567g = null;

    /* renamed from: b */
    public void mo3278b(ConstraintLayout constraintLayout) {
    }

    /* renamed from: c */
    public void mo3279c(ConstraintLayout constraintLayout) {
    }

    public void onDraw(Canvas canvas) {
    }

    public C0805c(Context context) {
        super(context);
        this.f2563c = context;
        mo3270a((AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3270a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f2566f = obtainStyledAttributes.getString(index);
                    setIds(this.f2566f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2561a, this.f2562b);
    }

    public void setReferencedIds(int[] iArr) {
        this.f2562b = 0;
        for (int tag : iArr) {
            setTag(tag, null);
        }
    }

    public void setTag(int i, Object obj) {
        if (this.f2562b + 1 > this.f2561a.length) {
            this.f2561a = Arrays.copyOf(this.f2561a, this.f2561a.length * 2);
        }
        this.f2561a[this.f2562b] = i;
        this.f2562b++;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f2565e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* renamed from: b */
    public void mo3277b() {
        if (this.f2564d != null) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof C0795a) {
                ((C0795a) layoutParams).f2514am = (C0766f) this.f2564d;
            }
        }
    }

    /* renamed from: a */
    private void m3005a(String str) {
        int i;
        if (str != null && this.f2563c != null) {
            String trim = str.trim();
            try {
                i = id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = this.f2563c.getResources().getIdentifier(trim, "id", this.f2563c.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object a = ((ConstraintLayout) getParent()).mo3237a(0, (Object) trim);
                if (a != null && (a instanceof Integer)) {
                    i = ((Integer) a).intValue();
                }
            }
            if (i != 0) {
                setTag(i, null);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find id of \"");
                sb.append(trim);
                sb.append("\"");
                Log.w("ConstraintHelper", sb.toString());
            }
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    m3005a(str.substring(i));
                    return;
                } else {
                    m3005a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3276a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f2566f);
        }
        if (this.f2564d != null) {
            this.f2564d.mo3147a_();
            for (int i = 0; i < this.f2562b; i++) {
                View findViewById = constraintLayout.findViewById(this.f2561a[i]);
                if (findViewById != null) {
                    this.f2564d.mo3146a(constraintLayout.mo3234a(findViewById));
                }
            }
        }
    }
}
