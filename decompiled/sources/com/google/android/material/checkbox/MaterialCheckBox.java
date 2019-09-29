package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.C0677h;
import androidx.core.widget.C1007c;
import com.google.android.material.C2167R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialCheckBox extends C0677h {
    private static final int DEF_STYLE_RES = C2167R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    private ColorStateList materialThemeColorsTintList;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2167R.attr.checkboxStyle);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, C2167R.styleable.MaterialCheckBox, i, DEF_STYLE_RES, new int[0]);
        boolean z = obtainStyledAttributes.getBoolean(C2167R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        obtainStyledAttributes.recycle();
        if (z && C1007c.m3843a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        if (z) {
            C1007c.m3844a((CompoundButton) this, getMaterialThemeColorsTintList());
        } else {
            C1007c.m3844a((CompoundButton) this, (ColorStateList) null);
        }
    }

    public boolean isUseMaterialThemeColors() {
        return this.materialThemeColorsTintList != null && this.materialThemeColorsTintList.equals(C1007c.m3843a(this));
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int[] iArr = new int[ENABLED_CHECKED_STATES.length];
            int color = MaterialColors.getColor(this, C2167R.attr.colorSecondary);
            int color2 = MaterialColors.getColor(this, C2167R.attr.colorSurface);
            int color3 = MaterialColors.getColor(this, C2167R.attr.colorOnSurface);
            iArr[0] = MaterialColors.layer(color2, color, 1.0f);
            iArr[1] = MaterialColors.layer(color2, color3, 0.54f);
            iArr[2] = MaterialColors.layer(color2, color3, 0.38f);
            iArr[3] = MaterialColors.layer(color2, color3, 0.38f);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
        }
        return this.materialThemeColorsTintList;
    }
}
