package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.widget.C0645av;

public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = C0424a.m1267a(context, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        if (VERSION.SDK_INT <= 15) {
            int color = typedArray.getColor(i, -1);
            if (color != -1) {
                return ColorStateList.valueOf(color);
            }
        }
        return typedArray.getColorStateList(i);
    }

    public static ColorStateList getColorStateList(Context context, C0645av avVar, int i) {
        if (avVar.mo2464g(i)) {
            int g = avVar.mo2463g(i, 0);
            if (g != 0) {
                ColorStateList a = C0424a.m1267a(context, g);
                if (a != null) {
                    return a;
                }
            }
        }
        if (VERSION.SDK_INT <= 15) {
            int b = avVar.mo2453b(i, -1);
            if (b != -1) {
                return ColorStateList.valueOf(b);
            }
        }
        return avVar.mo2460e(i);
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                Drawable b = C0424a.m1270b(context, resourceId);
                if (b != null) {
                    return b;
                }
            }
        }
        return typedArray.getDrawable(i);
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                return new TextAppearance(context, resourceId);
            }
        }
        return null;
    }

    static int getIndexWithValue(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }
}
