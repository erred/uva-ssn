package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.widget.C0607ad;
import androidx.appcompat.widget.C0645av;
import androidx.appcompat.widget.C0680k;
import androidx.appcompat.widget.C0707z;
import androidx.core.content.C0875a;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p070g.C0932a;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.widget.C1013i;
import androidx.customview.p072a.C1021a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.C2167R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = C2167R.style.Widget_Design_TextInputLayout;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private MaterialShapeDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxBottomOffsetPx;
    private final int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    final CollapsingTextHelper collapsingTextHelper;
    private final ShapeAppearanceModel cornerAdjustedShapeAppearanceModel;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    private final int disabledFilledBackgroundColor;
    EditText editText;
    private Drawable editTextOriginalDrawable;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasPasswordToggleTintList;
    private boolean hasPasswordToggleTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredFilledBackgroundColor;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private CharSequence passwordToggleContentDesc;
    private Drawable passwordToggleDrawable;
    private Drawable passwordToggleDummyDrawable;
    private boolean passwordToggleEnabled;
    private ColorStateList passwordToggleTintList;
    private Mode passwordToggleTintMode;
    private CheckableImageButton passwordToggleView;
    private boolean passwordToggledVisible;
    /* access modifiers changed from: private */
    public boolean restoringSavedState;
    private final ShapeAppearanceModel shapeAppearanceModel;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends C0932a {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                bVar.mo3685c((CharSequence) text);
            } else if (z2) {
                bVar.mo3685c(hint);
            }
            if (z2) {
                bVar.mo3691e(hint);
                if (!z && z2) {
                    z4 = true;
                }
                bVar.mo3709l(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                bVar.mo3695f(error);
                bVar.mo3705j(true);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            EditText editText = this.layout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.layout.getHint();
            }
            if (!TextUtils.isEmpty(text)) {
                accessibilityEvent.getText().add(text);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    static class SavedState extends C1021a {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence error;
        boolean isPasswordToggledVisible;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.isPasswordToggledVisible = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isPasswordToggledVisible ? 1 : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TextInputLayout.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" error=");
            sb.append(this.error);
            sb.append("}");
            return sb.toString();
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2167R.attr.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.collapsingTextHelper = new CollapsingTextHelper(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.inputFrame = new FrameLayout(context2);
        this.inputFrame.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        this.collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setCollapsedTextGravity(8388659);
        C0645av obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, C2167R.styleable.TextInputLayout, i, DEF_STYLE_RES, C2167R.styleable.TextInputLayout_counterTextAppearance, C2167R.styleable.TextInputLayout_counterOverflowTextAppearance, C2167R.styleable.TextInputLayout_errorTextAppearance, C2167R.styleable.TextInputLayout_helperTextTextAppearance, C2167R.styleable.TextInputLayout_hintTextAppearance);
        this.hintEnabled = obtainTintedStyledAttributes.mo2451a(C2167R.styleable.TextInputLayout_hintEnabled, true);
        setHint(obtainTintedStyledAttributes.mo2456c(C2167R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = obtainTintedStyledAttributes.mo2451a(C2167R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.shapeAppearanceModel = new ShapeAppearanceModel(context2, attributeSet, i, DEF_STYLE_RES);
        this.cornerAdjustedShapeAppearanceModel = new ShapeAppearanceModel(this.shapeAppearanceModel);
        setBoxBackgroundMode(obtainTintedStyledAttributes.mo2447a(C2167R.styleable.TextInputLayout_boxBackgroundMode, 0));
        this.boxBottomOffsetPx = context2.getResources().getDimensionPixelOffset(C2167R.dimen.mtrl_textinput_box_bottom_offset);
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(C2167R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = obtainTintedStyledAttributes.mo2457d(C2167R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = context2.getResources().getDimensionPixelSize(C2167R.dimen.mtrl_textinput_box_stroke_width_default);
        this.boxStrokeWidthFocusedPx = context2.getResources().getDimensionPixelSize(C2167R.dimen.mtrl_textinput_box_stroke_width_focused);
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float b = obtainTintedStyledAttributes.mo2452b(C2167R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float b2 = obtainTintedStyledAttributes.mo2452b(C2167R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float b3 = obtainTintedStyledAttributes.mo2452b(C2167R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float b4 = obtainTintedStyledAttributes.mo2452b(C2167R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        if (b >= BitmapDescriptorFactory.HUE_RED) {
            this.shapeAppearanceModel.getTopLeftCorner().setCornerSize(b);
        }
        if (b2 >= BitmapDescriptorFactory.HUE_RED) {
            this.shapeAppearanceModel.getTopRightCorner().setCornerSize(b2);
        }
        if (b3 >= BitmapDescriptorFactory.HUE_RED) {
            this.shapeAppearanceModel.getBottomRightCorner().setCornerSize(b3);
        }
        if (b4 >= BitmapDescriptorFactory.HUE_RED) {
            this.shapeAppearanceModel.getBottomLeftCorner().setCornerSize(b4);
        }
        adjustCornerSizeForStrokeWidth();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, C2167R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateList != null) {
            this.defaultFilledBackgroundColor = colorStateList.getDefaultColor();
            this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623}, -1);
            } else {
                ColorStateList a = C0424a.m1267a(context2, C2167R.C2168color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = a.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = a.getColorForState(new int[]{16843623}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList e = obtainTintedStyledAttributes.mo2460e(C2167R.styleable.TextInputLayout_android_textColorHint);
            this.focusedTextColor = e;
            this.defaultHintTextColor = e;
        }
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, C2167R.styleable.TextInputLayout_boxStrokeColor);
        if (colorStateList2 == null || !colorStateList2.isStateful()) {
            this.focusedStrokeColor = obtainTintedStyledAttributes.mo2453b(C2167R.styleable.TextInputLayout_boxStrokeColor, 0);
            this.defaultStrokeColor = C0875a.m3248c(context2, C2167R.C2168color.mtrl_textinput_default_box_stroke_color);
            this.disabledColor = C0875a.m3248c(context2, C2167R.C2168color.mtrl_textinput_disabled_color);
            this.hoveredStrokeColor = C0875a.m3248c(context2, C2167R.C2168color.mtrl_textinput_hovered_box_stroke_color);
        } else {
            this.defaultStrokeColor = colorStateList2.getDefaultColor();
            this.disabledColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList2.getColorForState(new int[]{16843623}, -1);
            this.focusedStrokeColor = colorStateList2.getColorForState(new int[]{16842908}, 0);
        }
        if (obtainTintedStyledAttributes.mo2463g(C2167R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainTintedStyledAttributes.mo2463g(C2167R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int g = obtainTintedStyledAttributes.mo2463g(C2167R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean a2 = obtainTintedStyledAttributes.mo2451a(C2167R.styleable.TextInputLayout_errorEnabled, false);
        int g2 = obtainTintedStyledAttributes.mo2463g(C2167R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean a3 = obtainTintedStyledAttributes.mo2451a(C2167R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence c = obtainTintedStyledAttributes.mo2456c(C2167R.styleable.TextInputLayout_helperText);
        boolean a4 = obtainTintedStyledAttributes.mo2451a(C2167R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainTintedStyledAttributes.mo2447a(C2167R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = obtainTintedStyledAttributes.mo2463g(C2167R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = obtainTintedStyledAttributes.mo2463g(C2167R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.passwordToggleEnabled = obtainTintedStyledAttributes.mo2451a(C2167R.styleable.TextInputLayout_passwordToggleEnabled, false);
        this.passwordToggleDrawable = obtainTintedStyledAttributes.mo2449a(C2167R.styleable.TextInputLayout_passwordToggleDrawable);
        this.passwordToggleContentDesc = obtainTintedStyledAttributes.mo2456c(C2167R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_passwordToggleTint)) {
            this.hasPasswordToggleTintList = true;
            this.passwordToggleTintList = C0424a.m1267a(context2, obtainTintedStyledAttributes.mo2463g(C2167R.styleable.TextInputLayout_passwordToggleTint, -1));
        }
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.hasPasswordToggleTintMode = true;
            this.passwordToggleTintMode = ViewUtils.parseTintMode(obtainTintedStyledAttributes.mo2447a(C2167R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        setHelperTextEnabled(a3);
        setHelperText(c);
        setHelperTextTextAppearance(g2);
        setErrorEnabled(a2);
        setErrorTextAppearance(g);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_errorTextColor)) {
            setErrorTextColor(obtainTintedStyledAttributes.mo2460e(C2167R.styleable.TextInputLayout_errorTextColor));
        }
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(obtainTintedStyledAttributes.mo2460e(C2167R.styleable.TextInputLayout_helperTextTextColor));
        }
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_hintTextColor)) {
            setHintTextColor(obtainTintedStyledAttributes.mo2460e(C2167R.styleable.TextInputLayout_hintTextColor));
        }
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_counterTextColor)) {
            setCounterTextColor(obtainTintedStyledAttributes.mo2460e(C2167R.styleable.TextInputLayout_counterTextColor));
        }
        if (obtainTintedStyledAttributes.mo2464g(C2167R.styleable.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(obtainTintedStyledAttributes.mo2460e(C2167R.styleable.TextInputLayout_counterOverflowTextColor));
        }
        setCounterEnabled(a4);
        obtainTintedStyledAttributes.mo2450a();
        applyPasswordToggleTint();
        C0962r.m3569b((View) this, 2);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private Drawable getBoxBackground() {
        if (this.boxBackgroundMode == 1 || this.boxBackgroundMode == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.boxBackgroundMode) {
            this.boxBackgroundMode = i;
            onApplyBoxBackgroundMode();
        }
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
        updateTextInputBoxBounds();
    }

    private void assignBoxBackgroundByMode() {
        if (this.boxBackgroundMode == 0) {
            this.boxBackground = null;
        } else if (this.boxBackgroundMode == 2 && this.hintEnabled && !(this.boxBackground instanceof CutoutDrawable)) {
            this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
        } else if (this.boxBackground == null) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(C0875a.m3248c(getContext(), i));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        if (this.shapeAppearanceModel.getTopLeftCorner().getCornerSize() != f || this.shapeAppearanceModel.getTopRightCorner().getCornerSize() != f2 || this.shapeAppearanceModel.getBottomRightCorner().getCornerSize() != f4 || this.shapeAppearanceModel.getBottomLeftCorner().getCornerSize() != f3) {
            this.shapeAppearanceModel.getTopLeftCorner().setCornerSize(f);
            this.shapeAppearanceModel.getTopRightCorner().setCornerSize(f2);
            this.shapeAppearanceModel.getBottomRightCorner().setCornerSize(f4);
            this.shapeAppearanceModel.getBottomLeftCorner().setCornerSize(f3);
            applyBoxAttributes();
        }
    }

    public float getBoxCornerRadiusTopStart() {
        return this.shapeAppearanceModel.getTopLeftCorner().getCornerSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.shapeAppearanceModel.getTopRightCorner().getCornerSize();
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.shapeAppearanceModel.getBottomLeftCorner().getCornerSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.shapeAppearanceModel.getBottomRightCorner().getCornerSize();
    }

    private void adjustCornerSizeForStrokeWidth() {
        float f = this.boxBackgroundMode == 2 ? ((float) this.boxStrokeWidthPx) / 2.0f : BitmapDescriptorFactory.HUE_RED;
        if (f > BitmapDescriptorFactory.HUE_RED) {
            this.cornerAdjustedShapeAppearanceModel.getTopLeftCorner().setCornerSize(this.shapeAppearanceModel.getTopLeftCorner().getCornerSize() + f);
            this.cornerAdjustedShapeAppearanceModel.getTopRightCorner().setCornerSize(this.shapeAppearanceModel.getTopRightCorner().getCornerSize() + f);
            this.cornerAdjustedShapeAppearanceModel.getBottomRightCorner().setCornerSize(this.shapeAppearanceModel.getBottomRightCorner().getCornerSize() + f);
            this.cornerAdjustedShapeAppearanceModel.getBottomLeftCorner().setCornerSize(this.shapeAppearanceModel.getBottomLeftCorner().getCornerSize() + f);
            ensureCornerAdjustedShapeAppearanceModel();
        }
    }

    private void ensureCornerAdjustedShapeAppearanceModel() {
        if (this.boxBackgroundMode != 0 && (getBoxBackground() instanceof MaterialShapeDrawable)) {
            ((MaterialShapeDrawable) getBoxBackground()).setShapeAppearanceModel(this.cornerAdjustedShapeAppearanceModel);
        }
    }

    public void setTypeface(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            this.indicatorViewController.setTypefaces(typeface2);
            if (this.counterView != null) {
                this.counterView.setTypeface(typeface2);
            }
        }
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.originalHint == null || this.editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence hint2 = this.editText.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.editText.setHint(hint2);
            this.isProvidingHint = z;
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (!(editText2 instanceof TextInputEditText)) {
                Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            if (!hasPasswordTransformation()) {
                this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            }
            this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
            this.collapsingTextHelper.setExpandedTextGravity(gravity);
            this.editText.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    TextInputLayout.this.updateLabelState(!TextInputLayout.this.restoringSavedState);
                    if (TextInputLayout.this.counterEnabled) {
                        TextInputLayout.this.updateCounter(editable.length());
                    }
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    this.originalHint = this.editText.getHint();
                    setHint(this.originalHint);
                    this.editText.setHint(null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            this.indicatorViewController.adjustIndicatorPadding();
            updatePasswordToggleView();
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void updateInputLayoutMargins() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int calculateLabelMarginTop = calculateLabelMarginTop();
        if (calculateLabelMarginTop != layoutParams.topMargin) {
            layoutParams.topMargin = calculateLabelMarginTop;
            this.inputFrame.requestLayout();
        }
    }

    public int getBaseline() {
        if (this.editText != null) {
            return this.editText.getBaseline() + getPaddingTop() + calculateLabelMarginTop();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: 0000 */
    public void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    private void updateLabelState(boolean z, boolean z2) {
        boolean isEnabled = isEnabled();
        boolean z3 = true;
        boolean z4 = this.editText != null && !TextUtils.isEmpty(this.editText.getText());
        if (this.editText == null || !this.editText.hasFocus()) {
            z3 = false;
        }
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        if (this.defaultHintTextColor != null) {
            this.collapsingTextHelper.setCollapsedTextColor(this.defaultHintTextColor);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.disabledColor));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.disabledColor));
        } else if (errorShouldBeShown) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && this.counterView != null) {
            this.collapsingTextHelper.setCollapsedTextColor(this.counterView.getTextColors());
        } else if (z3 && this.focusedTextColor != null) {
            this.collapsingTextHelper.setCollapsedTextColor(this.focusedTextColor);
        }
        if (z4 || (isEnabled() && (z3 || errorShouldBeShown))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
            }
        } else if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    public EditText getEditText() {
        return this.editText;
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.setText(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!this.hintEnabled) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint(null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    /* access modifiers changed from: 0000 */
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public void setHintTextAppearance(int i) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.collapsingTextHelper.getCollapsedTextColor() != colorStateList) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    public ColorStateList getHintTextColor() {
        return this.collapsingTextHelper.getCollapsedTextColor();
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.setErrorEnabled(z);
    }

    public void setErrorTextAppearance(int i) {
        this.indicatorViewController.setErrorTextAppearance(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public void setHelperTextTextAppearance(int i) {
        this.indicatorViewController.setHelperTextAppearance(i);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.setHelperTextEnabled(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.showError(charSequence);
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                this.counterView = new C0707z(getContext());
                this.counterView.setId(C2167R.C2170id.textinput_counter);
                if (this.typeface != null) {
                    this.counterView.setTypeface(this.typeface);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            updateCounter(this.editText == null ? 0 : this.editText.getText().length());
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            if (C0962r.m3581g(this.counterView) == 1) {
                C0962r.m3576d(this.counterView, 0);
            }
            this.counterOverflowed = i > this.counterMaxLength;
            updateCounterContentDescription(getContext(), this.counterView, i, this.counterMaxLength, this.counterOverflowed);
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
                if (this.counterOverflowed) {
                    C0962r.m3576d(this.counterView, 1);
                }
            }
            this.counterView.setText(getContext().getString(C2167R.string.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)}));
        }
        if (this.editText != null && z != this.counterOverflowed) {
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    private static void updateCounterContentDescription(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? C2167R.string.character_counter_overflowed_content_description : C2167R.string.character_counter_content_description, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    /* access modifiers changed from: 0000 */
    public CharSequence getCounterOverflowDescription() {
        if (!this.counterEnabled || !this.counterOverflowed || this.counterView == null) {
            return null;
        }
        return this.counterView.getContentDescription();
    }

    private void updateCounterTextAppearanceAndColor() {
        if (this.counterView != null) {
            setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && this.counterTextColor != null) {
                this.counterView.setTextColor(this.counterTextColor);
            }
            if (this.counterOverflowed && this.counterOverflowTextColor != null) {
                this.counterView.setTextColor(this.counterOverflowTextColor);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setTextAppearanceCompatWithErrorFallback(TextView textView, int i) {
        boolean z = true;
        try {
            C1013i.m3865a(textView, i);
            if (VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            C1013i.m3865a(textView, C2167R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(C0875a.m3248c(getContext(), C2167R.C2168color.design_error));
        }
    }

    private void updateTextInputBoxBounds() {
        if (this.boxBackgroundMode != 0 && this.boxBackground != null && this.editText != null && getRight() != 0) {
            int left = this.editText.getLeft();
            int calculateBoxBackgroundTop = calculateBoxBackgroundTop();
            int right = this.editText.getRight();
            int bottom = this.editText.getBottom() + this.boxBottomOffsetPx;
            if (this.boxBackgroundMode == 2) {
                left += this.boxStrokeWidthFocusedPx / 2;
                calculateBoxBackgroundTop -= this.boxStrokeWidthFocusedPx / 2;
                right -= this.boxStrokeWidthFocusedPx / 2;
                bottom += this.boxStrokeWidthFocusedPx / 2;
            }
            this.boxBackground.setBounds(left, calculateBoxBackgroundTop, right, bottom);
            applyBoxAttributes();
            updateEditTextBackgroundBounds();
        }
    }

    private int calculateBoxBackgroundTop() {
        if (this.editText == null) {
            return 0;
        }
        switch (this.boxBackgroundMode) {
            case 1:
                return this.editText.getTop();
            case 2:
                return this.editText.getTop() + calculateLabelMarginTop();
            default:
                return 0;
        }
    }

    private int calculateLabelMarginTop() {
        if (!this.hintEnabled) {
            return 0;
        }
        switch (this.boxBackgroundMode) {
            case 0:
            case 1:
                return (int) this.collapsingTextHelper.getCollapsedTextHeight();
            case 2:
                return (int) (this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f);
            default:
                return 0;
        }
    }

    private Rect calculateCollapsedTextBounds(Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            rect2.bottom = rect.bottom;
            switch (this.boxBackgroundMode) {
                case 1:
                    rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
                    rect2.top = getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
                    rect2.right = rect.right - this.editText.getCompoundPaddingRight();
                    return rect2;
                case 2:
                    rect2.left = rect.left + this.editText.getPaddingLeft();
                    rect2.top = getBoxBackground().getBounds().top - calculateLabelMarginTop();
                    rect2.right = rect.right - this.editText.getPaddingRight();
                    return rect2;
                default:
                    rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
                    rect2.top = getPaddingTop();
                    rect2.right = rect.right - this.editText.getCompoundPaddingRight();
                    return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private Rect calculateExpandedTextBounds(Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
            rect2.top = rect.top + this.editText.getCompoundPaddingTop();
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            rect2.bottom = rect.bottom - this.editText.getCompoundPaddingBottom();
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void updateEditTextBackgroundBounds() {
        if (this.editText != null) {
            Drawable background = this.editText.getBackground();
            if (background != null) {
                if (C0607ad.m2105c(background)) {
                    background = background.mutate();
                }
                DescendantOffsetUtils.getDescendantRect(this, this.editText, new Rect());
                Rect bounds = background.getBounds();
                if (bounds.left != bounds.right) {
                    Rect rect = new Rect();
                    background.getPadding(rect);
                    background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.editText.getBottom());
                }
            }
        }
    }

    private void setBoxAttributes() {
        switch (this.boxBackgroundMode) {
            case 1:
                this.boxStrokeWidthPx = 0;
                return;
            case 2:
                if (this.focusedStrokeColor == 0) {
                    this.focusedStrokeColor = this.focusedTextColor.getColorForState(getDrawableState(), this.focusedTextColor.getDefaultColor());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? MaterialColors.layer(MaterialColors.getColor(this, C2167R.attr.colorSurface, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    private void applyBoxAttributes() {
        if (this.boxBackground != null) {
            setBoxAttributes();
            if (this.editText != null && this.boxBackgroundMode == 2) {
                if (this.editText.getBackground() != null) {
                    this.editTextOriginalDrawable = this.editText.getBackground();
                }
                C0962r.m3557a((View) this.editText, (Drawable) null);
            }
            if (!(this.editText == null || this.boxBackgroundMode != 1 || this.editTextOriginalDrawable == null)) {
                C0962r.m3557a((View) this.editText, this.editTextOriginalDrawable);
            }
            if (this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0) {
                this.boxBackground.setStroke((float) this.boxStrokeWidthPx, this.boxStrokeColor);
            }
            this.boxBackground.setFillColor(ColorStateList.valueOf(calculateBoxBackgroundColor()));
            invalidate();
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateEditTextBackground() {
        if (this.editText != null) {
            Drawable background = this.editText.getBackground();
            if (background != null) {
                if (C0607ad.m2105c(background)) {
                    background = background.mutate();
                }
                if (this.indicatorViewController.errorShouldBeShown()) {
                    background.setColorFilter(C0680k.m2393a(this.indicatorViewController.getErrorViewCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.counterOverflowed || this.counterView == null) {
                    C0983a.m3708f(background);
                    this.editText.refreshDrawableState();
                } else {
                    background.setColorFilter(C0680k.m2393a(this.counterView.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isPasswordToggledVisible = this.passwordToggledVisible;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isPasswordToggledVisible) {
            passwordVisibilityToggleRequested(true);
        }
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void draw(Canvas canvas) {
        if (this.boxBackground != null) {
            this.boxBackground.draw(canvas);
        }
        super.draw(canvas);
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updatePasswordToggleView();
    }

    private void updatePasswordToggleView() {
        if (this.editText != null) {
            if (shouldShowPasswordIcon()) {
                if (this.passwordToggleView == null) {
                    this.passwordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C2167R.layout.design_text_input_password_icon, this.inputFrame, false);
                    this.passwordToggleView.setImageDrawable(this.passwordToggleDrawable);
                    this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
                    this.inputFrame.addView(this.passwordToggleView);
                    this.passwordToggleView.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            TextInputLayout.this.passwordVisibilityToggleRequested(false);
                        }
                    });
                }
                if (this.editText != null && C0962r.m3590m(this.editText) <= 0) {
                    this.editText.setMinimumHeight(C0962r.m3590m(this.passwordToggleView));
                }
                this.passwordToggleView.setVisibility(0);
                this.passwordToggleView.setChecked(this.passwordToggledVisible);
                if (this.passwordToggleDummyDrawable == null) {
                    this.passwordToggleDummyDrawable = new ColorDrawable();
                }
                this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
                Drawable[] b = C1013i.m3870b(this.editText);
                if (b[2] != this.passwordToggleDummyDrawable) {
                    this.originalEditTextEndDrawable = b[2];
                }
                C1013i.m3866a(this.editText, b[0], b[1], this.passwordToggleDummyDrawable, b[3]);
                this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
            } else {
                if (this.passwordToggleView != null && this.passwordToggleView.getVisibility() == 0) {
                    this.passwordToggleView.setVisibility(8);
                }
                if (this.passwordToggleDummyDrawable != null) {
                    Drawable[] b2 = C1013i.m3870b(this.editText);
                    if (b2[2] == this.passwordToggleDummyDrawable) {
                        C1013i.m3866a(this.editText, b2[0], b2[1], this.originalEditTextEndDrawable, b2[3]);
                        this.passwordToggleDummyDrawable = null;
                    }
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? C0424a.m1270b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.passwordToggleDrawable = drawable;
        if (this.passwordToggleView != null) {
            this.passwordToggleView.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.passwordToggleContentDesc = charSequence;
        if (this.passwordToggleView != null) {
            this.passwordToggleView.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.passwordToggleDrawable;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.passwordToggleContentDesc;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.passwordToggleEnabled != z) {
            this.passwordToggleEnabled = z;
            if (!z && this.passwordToggledVisible && this.editText != null) {
                this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.passwordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.passwordToggleTintList = colorStateList;
        this.hasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.passwordToggleTintMode = mode;
        this.hasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.passwordToggleEnabled) {
            int selectionEnd = this.editText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.editText.setTransformationMethod(null);
                this.passwordToggledVisible = true;
            } else {
                this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordToggledVisible = false;
            }
            this.passwordToggleView.setChecked(this.passwordToggledVisible);
            if (z) {
                this.passwordToggleView.jumpDrawablesToCurrentState();
            }
            this.editText.setSelection(selectionEnd);
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        if (this.editText != null) {
            C0962r.m3559a((View) this.editText, (C0932a) accessibilityDelegate);
        }
    }

    private boolean hasPasswordTransformation() {
        return this.editText != null && (this.editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean shouldShowPasswordIcon() {
        return this.passwordToggleEnabled && (hasPasswordTransformation() || this.passwordToggledVisible);
    }

    private void applyPasswordToggleTint() {
        if (this.passwordToggleDrawable == null) {
            return;
        }
        if (this.hasPasswordToggleTintList || this.hasPasswordToggleTintMode) {
            this.passwordToggleDrawable = C0983a.m3709g(this.passwordToggleDrawable).mutate();
            if (this.hasPasswordToggleTintList) {
                C0983a.m3698a(this.passwordToggleDrawable, this.passwordToggleTintList);
            }
            if (this.hasPasswordToggleTintMode) {
                C0983a.m3701a(this.passwordToggleDrawable, this.passwordToggleTintMode);
            }
            if (this.passwordToggleView != null && this.passwordToggleView.getDrawable() != this.passwordToggleDrawable) {
                this.passwordToggleView.setImageDrawable(this.passwordToggleDrawable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.boxBackground != null) {
            updateTextInputBoxBounds();
        }
        if (this.hintEnabled && this.editText != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, this.editText, rect);
            this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
            this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
            this.collapsingTextHelper.recalculate();
            if (cutoutEnabled() && !this.hintExpanded) {
                openCutout();
            }
        }
    }

    private void collapseHint(boolean z) {
        if (this.animator != null && this.animator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF);
            applyCutoutPadding(rectF);
            ((CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void applyCutoutPadding(RectF rectF) {
        rectF.left -= (float) this.boxLabelCutoutPaddingPx;
        rectF.top -= (float) this.boxLabelCutoutPaddingPx;
        rectF.right += (float) this.boxLabelCutoutPaddingPx;
        rectF.bottom += (float) this.boxLabelCutoutPaddingPx;
    }

    /* access modifiers changed from: 0000 */
    public boolean cutoutIsOpen() {
        return cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.inDrawableStateChanged) {
            boolean z = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!C0962r.m3603z(this) || !isEnabled()) {
                z = false;
            }
            updateLabelState(z);
            updateEditTextBackground();
            updateTextInputBoxBounds();
            updateTextInputBoxState();
            if (this.collapsingTextHelper != null ? this.collapsingTextHelper.setState(drawableState) | false : false) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateTextInputBoxState() {
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z = false;
            boolean z2 = this.editText != null && this.editText.hasFocus();
            if (this.editText != null && this.editText.isHovered()) {
                z = true;
            }
            if (this.boxBackgroundMode == 2) {
                if (!isEnabled()) {
                    this.boxStrokeColor = this.disabledColor;
                } else if (this.indicatorViewController.errorShouldBeShown()) {
                    this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
                } else if (this.counterOverflowed && this.counterView != null) {
                    this.boxStrokeColor = this.counterView.getCurrentTextColor();
                } else if (z2) {
                    this.boxStrokeColor = this.focusedStrokeColor;
                } else if (z) {
                    this.boxStrokeColor = this.hoveredStrokeColor;
                } else {
                    this.boxStrokeColor = this.defaultStrokeColor;
                }
                if ((z || z2) && isEnabled()) {
                    this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
                    adjustCornerSizeForStrokeWidth();
                } else {
                    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
                    adjustCornerSizeForStrokeWidth();
                }
            } else if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    private void expandHint(boolean z) {
        if (this.animator != null && this.animator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(BitmapDescriptorFactory.HUE_RED);
        } else {
            animateToExpansionFraction(BitmapDescriptorFactory.HUE_RED);
        }
        if (cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
    }

    /* access modifiers changed from: 0000 */
    public void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.getExpansionFraction() != f) {
            if (this.animator == null) {
                this.animator = new ValueAnimator();
                this.animator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.animator.setDuration(167);
                this.animator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), f});
            this.animator.start();
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    /* access modifiers changed from: 0000 */
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    /* access modifiers changed from: 0000 */
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    /* access modifiers changed from: 0000 */
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }
}
