package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0551p.C0552a;
import androidx.appcompat.widget.C0645av;
import androidx.core.p070g.C0962r;

public class ListMenuItemView extends LinearLayout implements SelectionBoundsAdjuster, C0552a {

    /* renamed from: a */
    private C0537j f1299a;

    /* renamed from: b */
    private ImageView f1300b;

    /* renamed from: c */
    private RadioButton f1301c;

    /* renamed from: d */
    private TextView f1302d;

    /* renamed from: e */
    private CheckBox f1303e;

    /* renamed from: f */
    private TextView f1304f;

    /* renamed from: g */
    private ImageView f1305g;

    /* renamed from: h */
    private ImageView f1306h;

    /* renamed from: i */
    private LinearLayout f1307i;

    /* renamed from: j */
    private Drawable f1308j;

    /* renamed from: k */
    private int f1309k;

    /* renamed from: l */
    private Context f1310l;

    /* renamed from: m */
    private boolean f1311m;

    /* renamed from: n */
    private Drawable f1312n;

    /* renamed from: o */
    private boolean f1313o;

    /* renamed from: p */
    private int f1314p;

    /* renamed from: q */
    private LayoutInflater f1315q;

    /* renamed from: r */
    private boolean f1316r;

    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0645av a = C0645av.m2230a(getContext(), attributeSet, R.styleable.MenuView, i, 0);
        this.f1308j = a.mo2449a(R.styleable.MenuView_android_itemBackground);
        this.f1309k = a.mo2463g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f1311m = a.mo2451a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f1310l = context;
        this.f1312n = a.mo2449a(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.f1313o = obtainStyledAttributes.hasValue(0);
        a.mo2450a();
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        C0962r.m3557a((View) this, this.f1308j);
        this.f1302d = (TextView) findViewById(R.id.title);
        if (this.f1309k != -1) {
            this.f1302d.setTextAppearance(this.f1310l, this.f1309k);
        }
        this.f1304f = (TextView) findViewById(R.id.shortcut);
        this.f1305g = (ImageView) findViewById(R.id.submenuarrow);
        if (this.f1305g != null) {
            this.f1305g.setImageDrawable(this.f1312n);
        }
        this.f1306h = (ImageView) findViewById(R.id.group_divider);
        this.f1307i = (LinearLayout) findViewById(R.id.content);
    }

    public void initialize(C0537j jVar, int i) {
        this.f1299a = jVar;
        this.f1314p = i;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.mo1566a((C0552a) this));
        setCheckable(jVar.isCheckable());
        mo1339a(jVar.mo1579f(), jVar.mo1575d());
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    /* renamed from: a */
    private void m1721a(View view) {
        m1722a(view, -1);
    }

    /* renamed from: a */
    private void m1722a(View view, int i) {
        if (this.f1307i != null) {
            this.f1307i.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.f1316r = z;
        this.f1311m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1302d.setText(charSequence);
            if (this.f1302d.getVisibility() != 0) {
                this.f1302d.setVisibility(0);
            }
        } else if (this.f1302d.getVisibility() != 8) {
            this.f1302d.setVisibility(8);
        }
    }

    public C0537j getItemData() {
        return this.f1299a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f1301c != null || this.f1303e != null) {
            if (this.f1299a.mo1580g()) {
                if (this.f1301c == null) {
                    m1723b();
                }
                compoundButton2 = this.f1301c;
                compoundButton = this.f1303e;
            } else {
                if (this.f1303e == null) {
                    m1724c();
                }
                compoundButton2 = this.f1303e;
                compoundButton = this.f1301c;
            }
            if (z) {
                compoundButton2.setChecked(this.f1299a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (!(compoundButton == null || compoundButton.getVisibility() == 8)) {
                    compoundButton.setVisibility(8);
                }
            } else {
                if (this.f1303e != null) {
                    this.f1303e.setVisibility(8);
                }
                if (this.f1301c != null) {
                    this.f1301c.setVisibility(8);
                }
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1299a.mo1580g()) {
            if (this.f1301c == null) {
                m1723b();
            }
            compoundButton = this.f1301c;
        } else {
            if (this.f1303e == null) {
                m1724c();
            }
            compoundButton = this.f1303e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f1305g != null) {
            this.f1305g.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void mo1339a(boolean z, char c) {
        int i = (!z || !this.f1299a.mo1579f()) ? 8 : 0;
        if (i == 0) {
            this.f1304f.setText(this.f1299a.mo1577e());
        }
        if (this.f1304f.getVisibility() != i) {
            this.f1304f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f1299a.mo1595i() || this.f1316r;
        if (!z && !this.f1311m) {
            return;
        }
        if (this.f1300b != null || drawable != null || this.f1311m) {
            if (this.f1300b == null) {
                m1720a();
            }
            if (drawable != null || this.f1311m) {
                ImageView imageView = this.f1300b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1300b.getVisibility() != 0) {
                    this.f1300b.setVisibility(0);
                }
            } else {
                this.f1300b.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f1300b != null && this.f1311m) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1300b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private void m1720a() {
        this.f1300b = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        m1722a((View) this.f1300b, 0);
    }

    /* renamed from: b */
    private void m1723b() {
        this.f1301c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        m1721a(this.f1301c);
    }

    /* renamed from: c */
    private void m1724c() {
        this.f1303e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        m1721a(this.f1303e);
    }

    private LayoutInflater getInflater() {
        if (this.f1315q == null) {
            this.f1315q = LayoutInflater.from(getContext());
        }
        return this.f1315q;
    }

    public void setGroupDividerEnabled(boolean z) {
        if (this.f1306h != null) {
            this.f1306h.setVisibility((this.f1313o || !z) ? 8 : 0);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        if (this.f1306h != null && this.f1306h.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1306h.getLayoutParams();
            rect.top += this.f1306h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }
}
