package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.p070g.C0943b;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.primitives.Ints;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a */
    final C0572a f1562a;

    /* renamed from: b */
    final FrameLayout f1563b;

    /* renamed from: c */
    final FrameLayout f1564c;

    /* renamed from: d */
    C0943b f1565d;

    /* renamed from: e */
    final DataSetObserver f1566e;

    /* renamed from: f */
    OnDismissListener f1567f;

    /* renamed from: g */
    boolean f1568g;

    /* renamed from: h */
    int f1569h;

    /* renamed from: i */
    private final C0573b f1570i;

    /* renamed from: j */
    private final View f1571j;

    /* renamed from: k */
    private final ImageView f1572k;

    /* renamed from: l */
    private final int f1573l;

    /* renamed from: m */
    private final OnGlobalLayoutListener f1574m;

    /* renamed from: n */
    private C0618ai f1575n;

    /* renamed from: o */
    private boolean f1576o;

    /* renamed from: p */
    private int f1577p;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        private static final int[] f1578a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0645av a = C0645av.m2229a(context, attributeSet, f1578a);
            setBackgroundDrawable(a.mo2449a(0));
            a.mo2450a();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$a */
    private class C0572a extends BaseAdapter {

        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f1579a;

        /* renamed from: b */
        private C0668d f1580b;

        /* renamed from: c */
        private int f1581c;

        /* renamed from: d */
        private boolean f1582d;

        /* renamed from: e */
        private boolean f1583e;

        /* renamed from: f */
        private boolean f1584f;

        public long getItemId(int i) {
            return (long) i;
        }

        public int getViewTypeCount() {
            return 3;
        }

        /* renamed from: a */
        public void mo1907a(C0668d dVar) {
            C0668d d = this.f1579a.f1562a.mo1912d();
            if (d != null && this.f1579a.isShown()) {
                d.unregisterObserver(this.f1579a.f1566e);
            }
            this.f1580b = dVar;
            if (dVar != null && this.f1579a.isShown()) {
                dVar.registerObserver(this.f1579a.f1566e);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            return (!this.f1584f || i != getCount() - 1) ? 0 : 1;
        }

        public int getCount() {
            int a = this.f1580b.mo2514a();
            if (!this.f1582d && this.f1580b.mo2518b() != null) {
                a--;
            }
            int min = Math.min(a, this.f1581c);
            return this.f1584f ? min + 1 : min;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f1582d && this.f1580b.mo2518b() != null) {
                        i++;
                    }
                    return this.f1580b.mo2516a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != R.id.list_item) {
                        view = LayoutInflater.from(this.f1579a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1579a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (!this.f1582d || i != 0 || !this.f1583e) {
                        view.setActivated(false);
                    } else {
                        view.setActivated(true);
                    }
                    return view;
                case 1:
                    if (view == null || view.getId() != 1) {
                        view = LayoutInflater.from(this.f1579a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                        view.setId(1);
                        ((TextView) view.findViewById(R.id.title)).setText(this.f1579a.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                    }
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: a */
        public int mo1905a() {
            int i = this.f1581c;
            this.f1581c = BaseClientBuilder.API_PRIORITY_OTHER;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f1581c = i;
            return i2;
        }

        /* renamed from: a */
        public void mo1906a(int i) {
            if (this.f1581c != i) {
                this.f1581c = i;
                notifyDataSetChanged();
            }
        }

        /* renamed from: b */
        public ResolveInfo mo1910b() {
            return this.f1580b.mo2518b();
        }

        /* renamed from: a */
        public void mo1908a(boolean z) {
            if (this.f1584f != z) {
                this.f1584f = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: c */
        public int mo1911c() {
            return this.f1580b.mo2514a();
        }

        /* renamed from: d */
        public C0668d mo1912d() {
            return this.f1580b;
        }

        /* renamed from: a */
        public void mo1909a(boolean z, boolean z2) {
            if (this.f1582d != z || this.f1583e != z2) {
                this.f1582d = z;
                this.f1583e = z2;
                notifyDataSetChanged();
            }
        }

        /* renamed from: e */
        public boolean mo1913e() {
            return this.f1582d;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$b */
    private class C0573b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f1585a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0572a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f1585a.mo1890b();
                    if (!this.f1585a.f1568g) {
                        if (!this.f1585a.f1562a.mo1913e()) {
                            i++;
                        }
                        Intent b = this.f1585a.f1562a.mo1912d().mo2517b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f1585a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f1585a.f1562a.mo1912d().mo2519c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f1585a.mo1888a(BaseClientBuilder.API_PRIORITY_OTHER);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f1585a.f1564c) {
                this.f1585a.mo1890b();
                Intent b = this.f1585a.f1562a.mo1912d().mo2517b(this.f1585a.f1562a.mo1912d().mo2515a(this.f1585a.f1562a.mo1910b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f1585a.getContext().startActivity(b);
                }
            } else if (view == this.f1585a.f1563b) {
                this.f1585a.f1568g = false;
                this.f1585a.mo1888a(this.f1585a.f1569h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1585a.f1564c) {
                if (this.f1585a.f1562a.getCount() > 0) {
                    this.f1585a.f1568g = true;
                    this.f1585a.mo1888a(this.f1585a.f1569h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            m1953a();
            if (this.f1585a.f1565d != null) {
                this.f1585a.f1565d.mo3733a(false);
            }
        }

        /* renamed from: a */
        private void m1953a() {
            if (this.f1585a.f1567f != null) {
                this.f1585a.f1567f.onDismiss();
            }
        }
    }

    public void setActivityChooserModel(C0668d dVar) {
        this.f1562a.mo1907a(dVar);
        if (mo1891c()) {
            mo1890b();
            mo1889a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1572k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1572k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(C0943b bVar) {
        this.f1565d = bVar;
    }

    /* renamed from: a */
    public boolean mo1889a() {
        if (mo1891c() || !this.f1576o) {
            return false;
        }
        this.f1568g = false;
        mo1888a(this.f1569h);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1888a(int i) {
        if (this.f1562a.mo1912d() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f1574m);
            boolean z = this.f1564c.getVisibility() == 0;
            int c = this.f1562a.mo1911c();
            if (i == Integer.MAX_VALUE || c <= i + (z ? 1 : 0)) {
                this.f1562a.mo1908a(false);
                this.f1562a.mo1906a(i);
            } else {
                this.f1562a.mo1908a(true);
                this.f1562a.mo1906a(i - 1);
            }
            C0618ai listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.mo1443c()) {
                if (this.f1568g || !z) {
                    this.f1562a.mo1909a(true, z);
                } else {
                    this.f1562a.mo1909a(false, false);
                }
                listPopupWindow.mo2269g(Math.min(this.f1562a.mo1905a(), this.f1573l));
                listPopupWindow.mo1433a();
                if (this.f1565d != null) {
                    this.f1565d.mo3733a(true);
                }
                listPopupWindow.mo1444d().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
                listPopupWindow.mo1444d().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* renamed from: b */
    public boolean mo1890b() {
        if (mo1891c()) {
            getListPopupWindow().mo1439b();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1574m);
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo1891c() {
        return getListPopupWindow().mo1443c();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0668d d = this.f1562a.mo1912d();
        if (d != null) {
            d.registerObserver(this.f1566e);
        }
        this.f1576o = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0668d d = this.f1562a.mo1912d();
        if (d != null) {
            d.unregisterObserver(this.f1566e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1574m);
        }
        if (mo1891c()) {
            mo1890b();
        }
        this.f1576o = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View view = this.f1571j;
        if (this.f1564c.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), Ints.MAX_POWER_OF_TWO);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1571j.layout(0, 0, i3 - i, i4 - i2);
        if (!mo1891c()) {
            mo1890b();
        }
    }

    public C0668d getDataModel() {
        return this.f1562a.mo1912d();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1567f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1569h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1577p = i;
    }

    /* access modifiers changed from: 0000 */
    public C0618ai getListPopupWindow() {
        if (this.f1575n == null) {
            this.f1575n = new C0618ai(getContext());
            this.f1575n.mo2259a((ListAdapter) this.f1562a);
            this.f1575n.mo2263b((View) this);
            this.f1575n.mo2261a(true);
            this.f1575n.mo2258a((OnItemClickListener) this.f1570i);
            this.f1575n.mo2260a((OnDismissListener) this.f1570i);
        }
        return this.f1575n;
    }
}
