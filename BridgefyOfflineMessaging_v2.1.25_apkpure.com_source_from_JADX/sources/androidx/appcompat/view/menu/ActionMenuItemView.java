package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0533h.C0535b;
import androidx.appcompat.view.menu.C0551p.C0552a;
import androidx.appcompat.widget.ActionMenuView.C0567a;
import androidx.appcompat.widget.C0613ag;
import androidx.appcompat.widget.C0649ax;
import androidx.appcompat.widget.C0707z;
import com.google.common.primitives.Ints;

public class ActionMenuItemView extends C0707z implements OnClickListener, C0552a, C0567a {

    /* renamed from: a */
    C0537j f1284a;

    /* renamed from: b */
    C0535b f1285b;

    /* renamed from: c */
    C0519b f1286c;

    /* renamed from: e */
    private CharSequence f1287e;

    /* renamed from: f */
    private Drawable f1288f;

    /* renamed from: g */
    private C0613ag f1289g;

    /* renamed from: h */
    private boolean f1290h;

    /* renamed from: i */
    private boolean f1291i;

    /* renamed from: j */
    private int f1292j;

    /* renamed from: k */
    private int f1293k;

    /* renamed from: l */
    private int f1294l;

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$a */
    private class C0518a extends C0613ag {
        public C0518a() {
            super(ActionMenuItemView.this);
        }

        /* renamed from: a */
        public C0555s mo1331a() {
            if (ActionMenuItemView.this.f1286c != null) {
                return ActionMenuItemView.this.f1286c.mo1333a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo1332b() {
            boolean z = false;
            if (ActionMenuItemView.this.f1285b == null || !ActionMenuItemView.this.f1285b.mo1334a(ActionMenuItemView.this.f1284a)) {
                return false;
            }
            C0555s a = mo1331a();
            if (a != null && a.mo1443c()) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$b */
    public static abstract class C0519b {
        /* renamed from: a */
        public abstract C0555s mo1333a();
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1290h = m1711d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.f1292j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1294l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1293k = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1290h = m1711d();
        m1712e();
    }

    /* renamed from: d */
    private boolean m1711d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1293k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C0537j getItemData() {
        return this.f1284a;
    }

    public void initialize(C0537j jVar, int i) {
        this.f1284a = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.mo1566a((C0552a) this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.f1289g == null) {
            this.f1289g = new C0518a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f1284a.hasSubMenu() || this.f1289g == null || !this.f1289g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onClick(View view) {
        if (this.f1285b != null) {
            this.f1285b.mo1334a(this.f1284a);
        }
    }

    public void setItemInvoker(C0535b bVar) {
        this.f1285b = bVar;
    }

    public void setPopupCallback(C0519b bVar) {
        this.f1286c = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1291i != z) {
            this.f1291i = z;
            if (this.f1284a != null) {
                this.f1284a.mo1593h();
            }
        }
    }

    /* renamed from: e */
    private void m1712e() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1287e);
        if (this.f1288f != null && (!this.f1284a.mo1603m() || (!this.f1290h && !this.f1291i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.f1287e : null);
        CharSequence contentDescription = this.f1284a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f1284a.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1284a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f1284a.getTitle();
            }
            C0649ax.m2296a(this, charSequence2);
            return;
        }
        C0649ax.m2296a(this, tooltipText);
    }

    public void setIcon(Drawable drawable) {
        this.f1288f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1294l) {
                float f = ((float) this.f1294l) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1294l;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1294l) {
                float f2 = ((float) this.f1294l) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1294l;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m1712e();
    }

    /* renamed from: a */
    public boolean mo1312a() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f1287e = charSequence;
        m1712e();
    }

    /* renamed from: b */
    public boolean mo1313b() {
        return mo1312a() && this.f1284a.getIcon() == null;
    }

    /* renamed from: c */
    public boolean mo1314c() {
        return mo1312a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean a = mo1312a();
        if (a && this.f1293k >= 0) {
            super.setPadding(this.f1293k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f1292j) : this.f1292j;
        if (mode != 1073741824 && this.f1292j > 0 && measuredWidth < min) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(min, Ints.MAX_POWER_OF_TWO), i2);
        }
        if (!a && this.f1288f != null) {
            super.setPadding((getMeasuredWidth() - this.f1288f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
