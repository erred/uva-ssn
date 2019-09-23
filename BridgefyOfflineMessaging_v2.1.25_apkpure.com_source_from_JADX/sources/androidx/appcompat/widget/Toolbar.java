package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.C0440a.C0441a;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.view.C0507c;
import androidx.appcompat.view.C0512g;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0533h.C0534a;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0549o;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.view.menu.C0559u;
import androidx.appcompat.widget.ActionMenuView.C0571e;
import androidx.core.p070g.C0946c;
import androidx.core.p070g.C0950f;
import androidx.core.p070g.C0962r;
import androidx.customview.p072a.C1021a;
import androidx.customview.p073b.C1024a;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private C0550a mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private C0630am mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private C0596a mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private C0534a mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final C0571e mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    C0598c mOnMenuItemClickListener;
    private C0658c mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private C0646aw mWrapper;

    /* renamed from: androidx.appcompat.widget.Toolbar$a */
    private class C0596a implements C0549o {

        /* renamed from: a */
        C0533h f1678a;

        /* renamed from: b */
        C0537j f1679b;

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public void onCloseMenu(C0533h hVar, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(C0559u uVar) {
            return false;
        }

        public void setCallback(C0550a aVar) {
        }

        C0596a() {
        }

        public void initForMenu(Context context, C0533h hVar) {
            if (!(this.f1678a == null || this.f1679b == null)) {
                this.f1678a.collapseItemActionView(this.f1679b);
            }
            this.f1678a = hVar;
        }

        public void updateMenuView(boolean z) {
            if (this.f1679b != null) {
                boolean z2 = false;
                if (this.f1678a != null) {
                    int size = this.f1678a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f1678a.getItem(i) == this.f1679b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.f1678a, this.f1679b);
                }
            }
        }

        public boolean expandItemActionView(C0533h hVar, C0537j jVar) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.mCollapseButtonView);
                }
                Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = jVar.getActionView();
            this.f1679b = jVar;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.mExpandedActionView);
                }
                C0597b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f973a = 8388611 | (Toolbar.this.mButtonGravity & 112);
                generateDefaultLayoutParams.f1681b = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            jVar.mo1578e(true);
            if (Toolbar.this.mExpandedActionView instanceof C0507c) {
                ((C0507c) Toolbar.this.mExpandedActionView).mo1252a();
            }
            return true;
        }

        public boolean collapseItemActionView(C0533h hVar, C0537j jVar) {
            if (Toolbar.this.mExpandedActionView instanceof C0507c) {
                ((C0507c) Toolbar.this.mExpandedActionView).mo1253b();
            }
            Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
            Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.addChildrenForExpandedActionView();
            this.f1679b = null;
            Toolbar.this.requestLayout();
            jVar.mo1578e(false);
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$b */
    public static class C0597b extends C0441a {

        /* renamed from: b */
        int f1681b;

        public C0597b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1681b = 0;
        }

        public C0597b(int i, int i2) {
            super(i, i2);
            this.f1681b = 0;
            this.f973a = 8388627;
        }

        public C0597b(int i, int i2, int i3) {
            super(i, i2);
            this.f1681b = 0;
            this.f973a = i3;
        }

        public C0597b(C0597b bVar) {
            super((C0441a) bVar);
            this.f1681b = 0;
            this.f1681b = bVar.f1681b;
        }

        public C0597b(C0441a aVar) {
            super(aVar);
            this.f1681b = 0;
        }

        public C0597b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f1681b = 0;
            mo2120a(marginLayoutParams);
        }

        public C0597b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1681b = 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo2120a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$c */
    public interface C0598c {
        /* renamed from: a */
        boolean mo1079a(MenuItem menuItem);
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$d */
    public static class C0599d extends C1021a {
        public static final Creator<C0599d> CREATOR = new ClassLoaderCreator<C0599d>() {
            /* renamed from: a */
            public C0599d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0599d(parcel, classLoader);
            }

            /* renamed from: a */
            public C0599d createFromParcel(Parcel parcel) {
                return new C0599d(parcel, null);
            }

            /* renamed from: a */
            public C0599d[] newArray(int i) {
                return new C0599d[i];
            }
        };

        /* renamed from: a */
        int f1682a;

        /* renamed from: b */
        boolean f1683b;

        public C0599d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1682a = parcel.readInt();
            this.f1683b = parcel.readInt() != 0;
        }

        public C0599d(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1682a);
            parcel.writeInt(this.f1683b ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new C0571e() {
            /* renamed from: a */
            public boolean mo1887a(MenuItem menuItem) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.mo1079a(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() {
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        C0645av a = C0645av.m2230a(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        this.mTitleTextAppearance = a.mo2463g(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = a.mo2463g(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a.mo2455c(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = a.mo2455c(R.styleable.Toolbar_buttonGravity, 48);
        int d = a.mo2457d(R.styleable.Toolbar_titleMargin, 0);
        if (a.mo2464g(R.styleable.Toolbar_titleMargins)) {
            d = a.mo2457d(R.styleable.Toolbar_titleMargins, d);
        }
        this.mTitleMarginBottom = d;
        this.mTitleMarginTop = d;
        this.mTitleMarginEnd = d;
        this.mTitleMarginStart = d;
        int d2 = a.mo2457d(R.styleable.Toolbar_titleMarginStart, -1);
        if (d2 >= 0) {
            this.mTitleMarginStart = d2;
        }
        int d3 = a.mo2457d(R.styleable.Toolbar_titleMarginEnd, -1);
        if (d3 >= 0) {
            this.mTitleMarginEnd = d3;
        }
        int d4 = a.mo2457d(R.styleable.Toolbar_titleMarginTop, -1);
        if (d4 >= 0) {
            this.mTitleMarginTop = d4;
        }
        int d5 = a.mo2457d(R.styleable.Toolbar_titleMarginBottom, -1);
        if (d5 >= 0) {
            this.mTitleMarginBottom = d5;
        }
        this.mMaxButtonHeight = a.mo2459e(R.styleable.Toolbar_maxButtonHeight, -1);
        int d6 = a.mo2457d(R.styleable.Toolbar_contentInsetStart, C1024a.INVALID_ID);
        int d7 = a.mo2457d(R.styleable.Toolbar_contentInsetEnd, C1024a.INVALID_ID);
        int e = a.mo2459e(R.styleable.Toolbar_contentInsetLeft, 0);
        int e2 = a.mo2459e(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.mo2344b(e, e2);
        if (!(d6 == Integer.MIN_VALUE && d7 == Integer.MIN_VALUE)) {
            this.mContentInsets.mo2341a(d6, d7);
        }
        this.mContentInsetStartWithNavigation = a.mo2457d(R.styleable.Toolbar_contentInsetStartWithNavigation, C1024a.INVALID_ID);
        this.mContentInsetEndWithActions = a.mo2457d(R.styleable.Toolbar_contentInsetEndWithActions, C1024a.INVALID_ID);
        this.mCollapseIcon = a.mo2449a(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = a.mo2456c(R.styleable.Toolbar_collapseContentDescription);
        CharSequence c = a.mo2456c(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        CharSequence c2 = a.mo2456c(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c2)) {
            setSubtitle(c2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(a.mo2463g(R.styleable.Toolbar_popupTheme, 0));
        Drawable a2 = a.mo2449a(R.styleable.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        CharSequence c3 = a.mo2456c(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c3)) {
            setNavigationContentDescription(c3);
        }
        Drawable a3 = a.mo2449a(R.styleable.Toolbar_logo);
        if (a3 != null) {
            setLogo(a3);
        }
        CharSequence c4 = a.mo2456c(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c4)) {
            setLogoDescription(c4);
        }
        if (a.mo2464g(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a.mo2453b(R.styleable.Toolbar_titleTextColor, -1));
        }
        if (a.mo2464g(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.mo2453b(R.styleable.Toolbar_subtitleTextColor, -1));
        }
        a.mo2450a();
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.mTitleMarginStart = i;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ensureContentInsets();
        C0630am amVar = this.mContentInsets;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        amVar.mo2342a(z);
    }

    public void setLogo(int i) {
        setLogo(C0424a.m1270b(getContext(), i));
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.mo1858a();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.mo1867g();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.mo1875h();
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.mo1865e();
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.mo1866f();
    }

    public void setMenu(C0533h hVar, C0658c cVar) {
        if (hVar != null || this.mMenuView != null) {
            ensureMenuView();
            C0533h d = this.mMenuView.mo1863d();
            if (d != hVar) {
                if (d != null) {
                    d.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    d.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new C0596a();
                }
                cVar.mo2497b(true);
                if (hVar != null) {
                    hVar.addMenuPresenter(cVar, this.mPopupContext);
                    hVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    cVar.initForMenu(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                    cVar.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(cVar);
                this.mOuterActionMenuPresenter = cVar;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.mo1876i();
        }
    }

    public boolean isTitleTruncated() {
        if (this.mTitleTextView == null) {
            return false;
        }
        Layout layout = this.mTitleTextView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else if (this.mLogoView != null && isChildOrHidden(this.mLogoView)) {
            removeView(this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.mLogoView != null) {
            return this.mLogoView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.mLogoView != null) {
            return this.mLogoView.getContentDescription();
        }
        return null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new C0690p(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.f1679b == null) ? false : true;
    }

    public void collapseActionView() {
        C0537j jVar = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.f1679b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new C0707z(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else if (this.mTitleTextView != null && isChildOrHidden(this.mTitleTextView)) {
            removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new C0707z(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else if (this.mSubtitleTextView != null && isChildOrHidden(this.mSubtitleTextView)) {
            removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mSubtitleTextAppearance = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.mTitleTextColor = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.mSubtitleTextColor = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        if (this.mNavButtonView != null) {
            return this.mNavButtonView.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C0424a.m1270b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else if (this.mNavButtonView != null && isChildOrHidden(this.mNavButtonView)) {
            removeView(this.mNavButtonView);
            this.mHiddenViews.remove(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        if (this.mNavButtonView != null) {
            return this.mNavButtonView.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.mo1863d() == null) {
            C0533h hVar = (C0533h) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new C0596a();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            hVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.mo1857a(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            C0597b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f973a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C0512g(getContext());
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(C0598c cVar) {
        this.mOnMenuItemClickListener = cVar;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.mo2341a(i, i2);
    }

    public int getContentInsetStart() {
        if (this.mContentInsets != null) {
            return this.mContentInsets.mo2345c();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        if (this.mContentInsets != null) {
            return this.mContentInsets.mo2346d();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.mo2344b(i, i2);
    }

    public int getContentInsetLeft() {
        if (this.mContentInsets != null) {
            return this.mContentInsets.mo2340a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.mContentInsets != null) {
            return this.mContentInsets.mo2343b();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.mContentInsetStartWithNavigation != Integer.MIN_VALUE) {
            return this.mContentInsetStartWithNavigation;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = C1024a.INVALID_ID;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.mContentInsetEndWithActions != Integer.MIN_VALUE) {
            return this.mContentInsetEndWithActions;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = C1024a.INVALID_ID;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.mMenuView
            r1 = 0
            if (r0 == 0) goto L_0x0015
            androidx.appcompat.widget.ActionMenuView r0 = r3.mMenuView
            androidx.appcompat.view.menu.h r0 = r0.mo1863d()
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x0027
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.mContentInsetEndWithActions
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x002b
        L_0x0027:
            int r0 = r3.getContentInsetEnd()
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        if (C0962r.m3579f(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (C0962r.m3579f(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new C0688n(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            C0597b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f973a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* access modifiers changed from: 0000 */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new C0688n(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            C0597b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f973a = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.f1681b = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(View view, boolean z) {
        C0597b bVar;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVar = generateLayoutParams(layoutParams);
        } else {
            bVar = (C0597b) layoutParams;
        }
        bVar.f1681b = 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, bVar);
            return;
        }
        view.setLayoutParams(bVar);
        this.mHiddenViews.add(view);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0599d dVar = new C0599d(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.f1679b == null)) {
            dVar.f1682a = this.mExpandedMenuPresenter.f1679b.getItemId();
        }
        dVar.f1683b = isOverflowMenuShowing();
        return dVar;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0599d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0599d dVar = (C0599d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        C0533h d = this.mMenuView != null ? this.mMenuView.mo1863d() : null;
        if (!(dVar.f1682a == 0 || this.mExpandedMenuPresenter == null || d == null)) {
            MenuItem findItem = d.findItem(dVar.f1682a);
            if (findItem != null) {
                findItem.expandActionView();
            }
        }
        if (dVar.f1683b) {
            postShowOverflowMenu();
        }
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, Ints.MAX_POWER_OF_TWO);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.mTempMargins;
        if (C0656bb.m2314a(this)) {
            c2 = 1;
            c = 0;
        } else {
            c2 = 0;
            c = 1;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i5 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i4 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i3 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i5 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i4 = Math.max(i4, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i3 = View.combineMeasuredStates(i3, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i5) + 0;
        iArr[c2] = Math.max(0, currentContentInsetStart - i5);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max, i2, 0, this.mMaxButtonHeight);
            i6 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i4 = Math.max(i4, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i3 = View.combineMeasuredStates(i3, this.mMenuView.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c] = Math.max(0, currentContentInsetEnd - i6);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i3 = View.combineMeasuredStates(i3, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i3 = View.combineMeasuredStates(i3, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        int i10 = i4;
        int i11 = max2;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((C0597b) childAt.getLayoutParams()).f1681b == 0 && shouldLayout(childAt)) {
                i11 += measureChildCollapseMargins(childAt, i, i11, i2, 0, iArr);
                i10 = Math.max(i10, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
            }
        }
        int i13 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i14 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, i11 + i14, i2, i13, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i7 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i9 = View.combineMeasuredStates(i3, this.mTitleTextView.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i9 = i3;
            i8 = 0;
            i7 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            int i15 = i7 + i13;
            int i16 = i9;
            i8 = Math.max(i8, measureChildCollapseMargins(this.mSubtitleTextView, i, i11 + i14, i2, i15, iArr));
            i7 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i9 = View.combineMeasuredStates(i16, this.mSubtitleTextView.getMeasuredState());
        } else {
            int i17 = i9;
        }
        int i18 = i11 + i8;
        int max3 = Math.max(i10, i7) + getPaddingTop() + getPaddingBottom();
        int i19 = i;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(i18 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i19, -16777216 & i9);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(max3, getSuggestedMinimumHeight()), i2, i9 << 16);
        if (shouldCollapse()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02aa A[LOOP:0: B:101:0x02a8->B:102:0x02aa, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02cc A[LOOP:1: B:104:0x02ca->B:105:0x02cc, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0306 A[LOOP:2: B:112:0x0304->B:113:0x0306, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            r24 = this;
            r0 = r24
            int r1 = androidx.core.p070g.C0962r.m3579f(r24)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r24.getWidth()
            int r5 = r24.getHeight()
            int r6 = r24.getPaddingLeft()
            int r7 = r24.getPaddingRight()
            int r8 = r24.getPaddingTop()
            int r9 = r24.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.mTempMargins
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.p070g.C0962r.m3590m(r24)
            if (r12 < 0) goto L_0x003a
            int r13 = r29 - r27
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.mNavButtonView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x004d
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildRight(r13, r10, r11, r12)
            r14 = r6
            goto L_0x0057
        L_0x004d:
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildLeft(r13, r6, r11, r12)
            r14 = r13
            goto L_0x0056
        L_0x0055:
            r14 = r6
        L_0x0056:
            r13 = r10
        L_0x0057:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x0068
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r13 = r0.layoutChildRight(r15, r13, r11, r12)
            goto L_0x006e
        L_0x0068:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r14 = r0.layoutChildLeft(r15, r14, r11, r12)
        L_0x006e:
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x0085
            if (r1 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            int r14 = r0.layoutChildLeft(r15, r14, r11, r12)
            goto L_0x0085
        L_0x007f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            int r13 = r0.layoutChildRight(r15, r13, r11, r12)
        L_0x0085:
            int r15 = r24.getCurrentContentInsetLeft()
            int r16 = r24.getCurrentContentInsetRight()
            int r2 = r15 - r14
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r13
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r14, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r13, r10)
            android.view.View r13 = r0.mExpandedActionView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00bc
            android.view.View r13 = r0.mExpandedActionView
            int r10 = r0.layoutChildRight(r13, r10, r11, r12)
            goto L_0x00c2
        L_0x00bc:
            android.view.View r13 = r0.mExpandedActionView
            int r2 = r0.layoutChildLeft(r13, r2, r11, r12)
        L_0x00c2:
            android.widget.ImageView r13 = r0.mLogoView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d3
            android.widget.ImageView r13 = r0.mLogoView
            int r10 = r0.layoutChildRight(r13, r10, r11, r12)
            goto L_0x00d9
        L_0x00d3:
            android.widget.ImageView r13 = r0.mLogoView
            int r2 = r0.layoutChildLeft(r13, r2, r11, r12)
        L_0x00d9:
            android.widget.TextView r13 = r0.mTitleTextView
            boolean r13 = r0.shouldLayout(r13)
            android.widget.TextView r14 = r0.mSubtitleTextView
            boolean r14 = r0.shouldLayout(r14)
            if (r13 == 0) goto L_0x0100
            android.widget.TextView r15 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r15 = (androidx.appcompat.widget.Toolbar.C0597b) r15
            int r3 = r15.topMargin
            r19 = r7
            android.widget.TextView r7 = r0.mTitleTextView
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x0103
        L_0x0100:
            r19 = r7
            r3 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r7 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r7 = (androidx.appcompat.widget.Toolbar.C0597b) r7
            int r15 = r7.topMargin
            r20 = r4
            android.widget.TextView r4 = r0.mSubtitleTextView
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x011f
        L_0x011d:
            r20 = r4
        L_0x011f:
            if (r13 != 0) goto L_0x012b
            if (r14 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r21 = r6
            r22 = r12
        L_0x0128:
            r7 = 0
            goto L_0x029a
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            android.widget.TextView r4 = r0.mTitleTextView
            goto L_0x0132
        L_0x0130:
            android.widget.TextView r4 = r0.mSubtitleTextView
        L_0x0132:
            if (r14 == 0) goto L_0x0137
            android.widget.TextView r7 = r0.mSubtitleTextView
            goto L_0x0139
        L_0x0137:
            android.widget.TextView r7 = r0.mTitleTextView
        L_0x0139:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r4 = (androidx.appcompat.widget.Toolbar.C0597b) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r7 = (androidx.appcompat.widget.Toolbar.C0597b) r7
            if (r13 == 0) goto L_0x014f
            android.widget.TextView r15 = r0.mTitleTextView
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0159
        L_0x014f:
            if (r14 == 0) goto L_0x015d
            android.widget.TextView r15 = r0.mSubtitleTextView
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x015d
        L_0x0159:
            r21 = r6
            r15 = 1
            goto L_0x0160
        L_0x015d:
            r21 = r6
            r15 = 0
        L_0x0160:
            int r6 = r0.mGravity
            r6 = r6 & 112(0x70, float:1.57E-43)
            r22 = r12
            r12 = 48
            if (r6 == r12) goto L_0x01a9
            r12 = 80
            if (r6 == r12) goto L_0x019d
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r12 = r4.topMargin
            r23 = r2
            int r2 = r0.mTitleMarginTop
            int r12 = r12 + r2
            if (r6 >= r12) goto L_0x0184
            int r2 = r4.topMargin
            int r3 = r0.mTitleMarginTop
            int r6 = r2 + r3
            goto L_0x019b
        L_0x0184:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.mTitleMarginBottom
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x019b
            int r2 = r7.bottomMargin
            int r3 = r0.mTitleMarginBottom
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x019b:
            int r8 = r8 + r6
            goto L_0x01b6
        L_0x019d:
            r23 = r2
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.mTitleMarginBottom
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01b6
        L_0x01a9:
            r23 = r2
            int r2 = r24.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.mTitleMarginTop
            int r8 = r2 + r3
        L_0x01b6:
            if (r1 == 0) goto L_0x022b
            if (r15 == 0) goto L_0x01be
            int r3 = r0.mTitleMarginStart
            r1 = 1
            goto L_0x01c0
        L_0x01be:
            r1 = 1
            r3 = 0
        L_0x01c0:
            r2 = r11[r1]
            int r3 = r3 - r2
            r2 = 0
            int r4 = java.lang.Math.max(r2, r3)
            int r10 = r10 - r4
            int r3 = -r3
            int r3 = java.lang.Math.max(r2, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x01f6
            android.widget.TextView r1 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r1 = (androidx.appcompat.widget.Toolbar.C0597b) r1
            android.widget.TextView r2 = r0.mTitleTextView
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.mTitleTextView
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.mTitleTextView
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.mTitleMarginEnd
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f7
        L_0x01f6:
            r2 = r10
        L_0x01f7:
            if (r14 == 0) goto L_0x021f
            android.widget.TextView r1 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r1 = (androidx.appcompat.widget.Toolbar.C0597b) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.mSubtitleTextView
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.mSubtitleTextView
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.mSubtitleTextView
            r5.layout(r3, r8, r10, r4)
            int r3 = r0.mTitleMarginEnd
            int r3 = r10 - r3
            int r1 = r1.bottomMargin
            goto L_0x0220
        L_0x021f:
            r3 = r10
        L_0x0220:
            if (r15 == 0) goto L_0x0227
            int r1 = java.lang.Math.min(r2, r3)
            r10 = r1
        L_0x0227:
            r2 = r23
            goto L_0x0128
        L_0x022b:
            if (r15 == 0) goto L_0x0233
            int r3 = r0.mTitleMarginStart
            r18 = r3
            r7 = 0
            goto L_0x0236
        L_0x0233:
            r7 = 0
            r18 = 0
        L_0x0236:
            r1 = r11[r7]
            int r1 = r18 - r1
            int r2 = java.lang.Math.max(r7, r1)
            int r2 = r23 + r2
            int r1 = -r1
            int r1 = java.lang.Math.max(r7, r1)
            r11[r7] = r1
            if (r13 == 0) goto L_0x026c
            android.widget.TextView r1 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r1 = (androidx.appcompat.widget.Toolbar.C0597b) r1
            android.widget.TextView r3 = r0.mTitleTextView
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r2
            android.widget.TextView r4 = r0.mTitleTextView
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.mTitleTextView
            r5.layout(r2, r8, r3, r4)
            int r5 = r0.mTitleMarginEnd
            int r3 = r3 + r5
            int r1 = r1.bottomMargin
            int r8 = r4 + r1
            goto L_0x026d
        L_0x026c:
            r3 = r2
        L_0x026d:
            if (r14 == 0) goto L_0x0293
            android.widget.TextView r1 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$b r1 = (androidx.appcompat.widget.Toolbar.C0597b) r1
            int r4 = r1.topMargin
            int r8 = r8 + r4
            android.widget.TextView r4 = r0.mSubtitleTextView
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.mSubtitleTextView
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.mSubtitleTextView
            r6.layout(r2, r8, r4, r5)
            int r5 = r0.mTitleMarginEnd
            int r4 = r4 + r5
            int r1 = r1.bottomMargin
            goto L_0x0294
        L_0x0293:
            r4 = r2
        L_0x0294:
            if (r15 == 0) goto L_0x029a
            int r2 = java.lang.Math.max(r3, r4)
        L_0x029a:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r3 = 3
            r0.addCustomViewsWithGravity(r1, r3)
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r1.size()
            r3 = r2
            r2 = 0
        L_0x02a8:
            if (r2 >= r1) goto L_0x02bb
            java.util.ArrayList<android.view.View> r4 = r0.mTempViews
            java.lang.Object r4 = r4.get(r2)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r3 = r0.layoutChildLeft(r4, r3, r11, r12)
            int r2 = r2 + 1
            goto L_0x02a8
        L_0x02bb:
            r12 = r22
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r2 = 5
            r0.addCustomViewsWithGravity(r1, r2)
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r1.size()
            r2 = 0
        L_0x02ca:
            if (r2 >= r1) goto L_0x02db
            java.util.ArrayList<android.view.View> r4 = r0.mTempViews
            java.lang.Object r4 = r4.get(r2)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.layoutChildRight(r4, r10, r11, r12)
            int r2 = r2 + 1
            goto L_0x02ca
        L_0x02db:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r2 = 1
            r0.addCustomViewsWithGravity(r1, r2)
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r0.getViewListMeasuredWidth(r1, r11)
            int r4 = r20 - r21
            int r4 = r4 - r19
            int r4 = r4 / 2
            int r6 = r21 + r4
            int r2 = r1 / 2
            int r2 = r6 - r2
            int r1 = r1 + r2
            if (r2 >= r3) goto L_0x02f7
            goto L_0x02fe
        L_0x02f7:
            if (r1 <= r10) goto L_0x02fd
            int r1 = r1 - r10
            int r3 = r2 - r1
            goto L_0x02fe
        L_0x02fd:
            r3 = r2
        L_0x02fe:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            int r1 = r1.size()
        L_0x0304:
            if (r7 >= r1) goto L_0x0315
            java.util.ArrayList<android.view.View> r2 = r0.mTempViews
            java.lang.Object r2 = r2.get(r7)
            android.view.View r2 = (android.view.View) r2
            int r3 = r0.layoutChildLeft(r2, r3, r11, r12)
            int r7 = r7 + 1
            goto L_0x0304
        L_0x0315:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            View view = (View) list.get(i4);
            C0597b bVar = (C0597b) view.getLayoutParams();
            int i6 = bVar.leftMargin - i;
            int i7 = bVar.rightMargin - i3;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            i5 += max + view.getMeasuredWidth() + max2;
            i4++;
            i3 = Math.max(0, -i7);
            i = max3;
        }
        return i5;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        C0597b bVar = (C0597b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        C0597b bVar = (C0597b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int getChildTop(View view, int i) {
        C0597b bVar = (C0597b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(bVar.f973a);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i2;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (i3 < bVar.topMargin) {
            i3 = bVar.topMargin;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            if (i4 < bVar.bottomMargin) {
                i3 = Math.max(0, i3 - (bVar.bottomMargin - i4));
            }
        }
        return paddingTop + i3;
    }

    private int getChildVerticalGravity(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(List<View> list, int i) {
        boolean z = C0962r.m3579f(this) == 1;
        int childCount = getChildCount();
        int a = C0946c.m3493a(i, C0962r.m3579f(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                C0597b bVar = (C0597b) childAt.getLayoutParams();
                if (bVar.f1681b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(bVar.f973a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            C0597b bVar2 = (C0597b) childAt2.getLayoutParams();
            if (bVar2.f1681b == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(bVar2.f973a) == a) {
                list.add(childAt2);
            }
        }
    }

    private int getChildHorizontalGravity(int i) {
        int f = C0962r.m3579f(this);
        int a = C0946c.m3493a(i, f) & 7;
        if (a != 1) {
            int i2 = 3;
            if (!(a == 3 || a == 5)) {
                if (f == 1) {
                    i2 = 5;
                }
                return i2;
            }
        }
        return a;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return C0950f.m3503a(marginLayoutParams) + C0950f.m3505b(marginLayoutParams);
    }

    private int getVerticalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public C0597b generateLayoutParams(AttributeSet attributeSet) {
        return new C0597b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0597b generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof C0597b) {
            return new C0597b((C0597b) layoutParams);
        }
        if (layoutParams instanceof C0441a) {
            return new C0597b((C0441a) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new C0597b((MarginLayoutParams) layoutParams);
        }
        return new C0597b(layoutParams);
    }

    /* access modifiers changed from: protected */
    public C0597b generateDefaultLayoutParams() {
        return new C0597b(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0597b);
    }

    private static boolean isCustomView(View view) {
        return ((C0597b) view.getLayoutParams()).f1681b == 0;
    }

    public C0606ac getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new C0646aw(this, true);
        }
        return this.mWrapper;
    }

    /* access modifiers changed from: 0000 */
    public void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0597b) childAt.getLayoutParams()).f1681b == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView((View) this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setMenuCallbacks(C0550a aVar, C0534a aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
        if (this.mMenuView != null) {
            this.mMenuView.mo1857a(aVar, aVar2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new C0630am();
        }
    }

    /* access modifiers changed from: 0000 */
    public C0658c getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    /* access modifiers changed from: 0000 */
    public Context getPopupContext() {
        return this.mPopupContext;
    }
}
