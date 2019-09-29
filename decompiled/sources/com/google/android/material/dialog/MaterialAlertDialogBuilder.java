package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.appcompat.app.C0446c;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.core.p070g.C0962r;
import com.google.android.material.C2167R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialAlertDialogBuilder extends C0447a {
    private static final float DEFAULT_DIM_AMOUNT = 0.32f;
    private static final int DEF_STYLE_ATTR = C2167R.attr.alertDialogStyle;
    private static final int DEF_STYLE_RES = C2167R.style.AlertDialog_MaterialComponents;
    private Drawable background;
    private int backgroundInsetBottom;
    private int backgroundInsetEnd;
    private int backgroundInsetStart;
    private int backgroundInsetTop;

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    public MaterialAlertDialogBuilder(Context context, int i) {
        super(ThemeEnforcement.createThemedContext(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES), i);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, null, C2167R.styleable.MaterialAlertDialog, DEF_STYLE_ATTR, DEF_STYLE_RES, new int[0]);
        this.backgroundInsetStart = obtainStyledAttributes.getDimensionPixelSize(C2167R.styleable.MaterialAlertDialog_backgroundInsetStart, context2.getResources().getDimensionPixelSize(C2167R.dimen.mtrl_alert_dialog_background_inset_start));
        this.backgroundInsetTop = obtainStyledAttributes.getDimensionPixelSize(C2167R.styleable.MaterialAlertDialog_backgroundInsetTop, context2.getResources().getDimensionPixelSize(C2167R.dimen.mtrl_alert_dialog_background_inset_top));
        this.backgroundInsetEnd = obtainStyledAttributes.getDimensionPixelSize(C2167R.styleable.MaterialAlertDialog_backgroundInsetEnd, context2.getResources().getDimensionPixelSize(C2167R.dimen.mtrl_alert_dialog_background_inset_end));
        this.backgroundInsetBottom = obtainStyledAttributes.getDimensionPixelSize(C2167R.styleable.MaterialAlertDialog_backgroundInsetBottom, context2.getResources().getDimensionPixelSize(C2167R.dimen.mtrl_alert_dialog_background_inset_bottom));
        obtainStyledAttributes.recycle();
        TypedValue typedValue = new TypedValue();
        context2.getTheme().resolveAttribute(C2167R.attr.colorSurface, typedValue, true);
        int i2 = typedValue.data;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(i2));
        this.background = materialShapeDrawable;
    }

    public C0446c create() {
        int i;
        int i2;
        C0446c create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        window.setDimAmount(0.32f);
        if (C0962r.m3579f(decorView) == 0) {
            i = this.backgroundInsetStart;
            i2 = this.backgroundInsetEnd;
        } else {
            i = this.backgroundInsetEnd;
            i2 = this.backgroundInsetStart;
        }
        InsetDrawable insetDrawable = new InsetDrawable(this.background, i, this.backgroundInsetTop, i2, this.backgroundInsetBottom);
        window.setBackgroundDrawable(insetDrawable);
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, i, this.backgroundInsetTop));
        return create;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public MaterialAlertDialogBuilder setBackground(Drawable drawable) {
        this.background = drawable;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetStart(int i) {
        this.backgroundInsetStart = i;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetTop(int i) {
        this.backgroundInsetTop = i;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int i) {
        this.backgroundInsetEnd = i;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int i) {
        this.backgroundInsetBottom = i;
        return this;
    }

    public MaterialAlertDialogBuilder setTitle(int i) {
        return (MaterialAlertDialogBuilder) super.setTitle(i);
    }

    public MaterialAlertDialogBuilder setTitle(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    public MaterialAlertDialogBuilder setCustomTitle(View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    public MaterialAlertDialogBuilder setMessage(int i) {
        return (MaterialAlertDialogBuilder) super.setMessage(i);
    }

    public MaterialAlertDialogBuilder setMessage(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    public MaterialAlertDialogBuilder setIcon(int i) {
        return (MaterialAlertDialogBuilder) super.setIcon(i);
    }

    public MaterialAlertDialogBuilder setIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    public MaterialAlertDialogBuilder setIconAttribute(int i) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(i);
    }

    public MaterialAlertDialogBuilder setPositiveButton(int i, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i, onClickListener);
    }

    public MaterialAlertDialogBuilder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setPositiveButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    public MaterialAlertDialogBuilder setNegativeButton(int i, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i, onClickListener);
    }

    public MaterialAlertDialogBuilder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setNegativeButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    public MaterialAlertDialogBuilder setNeutralButton(int i, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(i, onClickListener);
    }

    public MaterialAlertDialogBuilder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setNeutralButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    public MaterialAlertDialogBuilder setCancelable(boolean z) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z);
    }

    public MaterialAlertDialogBuilder setOnCancelListener(OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    public MaterialAlertDialogBuilder setOnDismissListener(OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    public MaterialAlertDialogBuilder setOnKeyListener(OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    public MaterialAlertDialogBuilder setItems(int i, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(i, onClickListener);
    }

    public MaterialAlertDialogBuilder setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    public MaterialAlertDialogBuilder setAdapter(ListAdapter listAdapter, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    public MaterialAlertDialogBuilder setCursor(Cursor cursor, OnClickListener onClickListener, String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(int i, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i, zArr, onMultiChoiceClickListener);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(int i, int i2, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i, i2, onClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(Cursor cursor, int i, String str, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i, str, onClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i, onClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(ListAdapter listAdapter, int i, OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i, onClickListener);
    }

    public MaterialAlertDialogBuilder setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    public MaterialAlertDialogBuilder setView(int i) {
        return (MaterialAlertDialogBuilder) super.setView(i);
    }

    public MaterialAlertDialogBuilder setView(View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }
}
