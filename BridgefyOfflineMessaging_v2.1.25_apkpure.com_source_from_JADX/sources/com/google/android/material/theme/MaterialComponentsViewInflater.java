package com.google.android.material.theme;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.C0676g;
import androidx.appcompat.widget.C0677h;
import androidx.appcompat.widget.C0694t;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;

@Keep
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    private static int floatingToolbarItemBackgroundResId = -1;

    /* access modifiers changed from: protected */
    public C0676g createButton(Context context, AttributeSet attributeSet) {
        if (VERSION.SDK_INT != 23 || !isFloatingToolbarItemButton(context, attributeSet)) {
            return new MaterialButton(context, attributeSet);
        }
        return new C0676g(context, attributeSet);
    }

    private boolean isFloatingToolbarItemButton(Context context, AttributeSet attributeSet) {
        if (floatingToolbarItemBackgroundResId == -1) {
            floatingToolbarItemBackgroundResId = context.getResources().getIdentifier("floatingToolbarItemBackgroundDrawable", "^attr-private", BleHandshake.DEVICE_TYPE);
        }
        if (!(floatingToolbarItemBackgroundResId == 0 || floatingToolbarItemBackgroundResId == -1)) {
            for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
                if (attributeSet.getAttributeNameResource(i) == 16842964 && floatingToolbarItemBackgroundResId == attributeSet.getAttributeListValue(i, null, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public C0677h createCheckBox(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0694t createRadioButton(Context context, AttributeSet attributeSet) {
        return new MaterialRadioButton(context, attributeSet);
    }
}
