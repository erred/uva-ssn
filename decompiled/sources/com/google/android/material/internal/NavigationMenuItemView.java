package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0551p.C0552a;
import androidx.appcompat.widget.C0616ah.C0617a;
import androidx.appcompat.widget.C0649ax;
import androidx.core.content.p066a.C0886f;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p070g.C0932a;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.widget.C1013i;
import com.google.android.material.C2167R;

public class NavigationMenuItemView extends ForegroundLinearLayout implements C0552a {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private final C0932a accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    private C0537j itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean z, char c) {
    }

    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.accessibilityDelegate = new C0932a() {
            public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
                super.onInitializeAccessibilityNodeInfo(view, bVar);
                bVar.mo3675a(NavigationMenuItemView.this.checkable);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(C2167R.layout.design_navigation_menu_item, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(C2167R.dimen.design_navigation_icon_size));
        this.textView = (CheckedTextView) findViewById(C2167R.C2170id.design_menu_item_text);
        this.textView.setDuplicateParentStateEnabled(true);
        C0962r.m3559a((View) this.textView, this.accessibilityDelegate);
    }

    public void initialize(C0537j jVar, int i) {
        this.itemData = jVar;
        setVisibility(jVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            C0962r.m3557a((View) this, (Drawable) createDefaultBackground());
        }
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setTitle(jVar.getTitle());
        setIcon(jVar.getIcon());
        setActionView(jVar.getActionView());
        setContentDescription(jVar.getContentDescription());
        C0649ax.m2296a(this, jVar.getTooltipText());
        adjustAppearance();
    }

    private boolean shouldExpandActionArea() {
        return this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null;
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea()) {
            this.textView.setVisibility(8);
            if (this.actionArea != null) {
                C0617a aVar = (C0617a) this.actionArea.getLayoutParams();
                aVar.width = -1;
                this.actionArea.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.textView.setVisibility(0);
        if (this.actionArea != null) {
            C0617a aVar2 = (C0617a) this.actionArea.getLayoutParams();
            aVar2.width = -2;
            this.actionArea.setLayoutParams(aVar2);
        }
    }

    public void recycle() {
        if (this.actionArea != null) {
            this.actionArea.removeAllViews();
        }
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(C2167R.C2170id.design_menu_item_action_area_stub)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(view);
        }
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    public C0537j getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.checkable != z) {
            this.checkable = z;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.textView.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.hasIconTintList) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = C0983a.m3709g(drawable).mutate();
                C0983a.m3698a(drawable, this.iconTintList);
            }
            drawable.setBounds(0, 0, this.iconSize, this.iconSize);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                this.emptyDrawable = C0886f.m3296a(getResources(), C2167R.C2169drawable.navigation_empty_icon, getContext().getTheme());
                if (this.emptyDrawable != null) {
                    this.emptyDrawable.setBounds(0, 0, this.iconSize, this.iconSize);
                }
            }
            drawable = this.emptyDrawable;
        }
        C1013i.m3866a(this.textView, drawable, null, null, null);
    }

    public void setIconSize(int i) {
        this.iconSize = i;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.itemData != null && this.itemData.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: 0000 */
    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.hasIconTintList = this.iconTintList != null;
        if (this.itemData != null) {
            setIcon(this.itemData.getIcon());
        }
    }

    public void setTextAppearance(int i) {
        C1013i.m3865a((TextView) this.textView, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.needsEmptyIcon = z;
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIconPadding(int i) {
        this.textView.setCompoundDrawablePadding(i);
    }
}
