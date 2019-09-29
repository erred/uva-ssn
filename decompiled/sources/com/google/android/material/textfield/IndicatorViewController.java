package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0707z;
import androidx.core.p070g.C0962r;
import androidx.core.widget.C1013i;
import androidx.legacy.p085c.C1146a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.C2167R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController {
    private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
    static final int COUNTER_INDEX = 2;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;
    /* access modifiers changed from: private */
    public Animator captionAnimator;
    private FrameLayout captionArea;
    /* access modifiers changed from: private */
    public int captionDisplayed;
    private int captionToShow;
    private final float captionTranslationYPx = ((float) this.context.getResources().getDimensionPixelSize(C2167R.dimen.design_textinput_caption_translate_y));
    private int captionViewsAdded;
    private final Context context;
    private boolean errorEnabled;
    private CharSequence errorText;
    private int errorTextAppearance;
    /* access modifiers changed from: private */
    public TextView errorView;
    private ColorStateList errorViewTextColor;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;
    private TextView helperTextView;
    private ColorStateList helperTextViewTextColor;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;
    private final TextInputLayout textInputView;
    private Typeface typeface;

    /* access modifiers changed from: 0000 */
    public boolean isCaptionView(int i) {
        return i == 0 || i == 1;
    }

    public IndicatorViewController(TextInputLayout textInputLayout) {
        this.context = textInputLayout.getContext();
        this.textInputView = textInputLayout;
    }

    /* access modifiers changed from: 0000 */
    public void showHelper(CharSequence charSequence) {
        cancelCaptionAnimator();
        this.helperText = charSequence;
        this.helperTextView.setText(charSequence);
        if (this.captionDisplayed != 2) {
            this.captionToShow = 2;
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, charSequence));
    }

    /* access modifiers changed from: 0000 */
    public void hideHelperText() {
        cancelCaptionAnimator();
        if (this.captionDisplayed == 2) {
            this.captionToShow = 0;
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, null));
    }

    /* access modifiers changed from: 0000 */
    public void showError(CharSequence charSequence) {
        cancelCaptionAnimator();
        this.errorText = charSequence;
        this.errorView.setText(charSequence);
        if (this.captionDisplayed != 1) {
            this.captionToShow = 1;
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, charSequence));
    }

    /* access modifiers changed from: 0000 */
    public void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (!this.helperTextEnabled || TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 0;
            } else {
                this.captionToShow = 2;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, null));
    }

    private boolean shouldAnimateCaptionView(TextView textView, CharSequence charSequence) {
        return C0962r.m3603z(this.textInputView) && this.textInputView.isEnabled() && (this.captionToShow != this.captionDisplayed || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    private void updateCaptionViewsVisibility(int i, int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.captionAnimator = animatorSet;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = arrayList;
            int i3 = i;
            int i4 = i2;
            createCaptionAnimators(arrayList2, this.helperTextEnabled, this.helperTextView, 2, i3, i4);
            createCaptionAnimators(arrayList2, this.errorEnabled, this.errorView, 1, i3, i4);
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            final TextView captionViewFromDisplayState = getCaptionViewFromDisplayState(i);
            final TextView captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i2);
            final int i5 = i2;
            final int i6 = i;
            C22511 r0 = new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    IndicatorViewController.this.captionDisplayed = i5;
                    IndicatorViewController.this.captionAnimator = null;
                    if (captionViewFromDisplayState != null) {
                        captionViewFromDisplayState.setVisibility(4);
                        if (i6 == 1 && IndicatorViewController.this.errorView != null) {
                            IndicatorViewController.this.errorView.setText(null);
                        }
                    }
                }

                public void onAnimationStart(Animator animator) {
                    if (captionViewFromDisplayState2 != null) {
                        captionViewFromDisplayState2.setVisibility(0);
                    }
                }
            };
            animatorSet.addListener(r0);
            animatorSet.start();
        } else {
            setCaptionViewVisibilities(i, i2);
        }
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(z);
        this.textInputView.updateTextInputBoxState();
    }

    private void setCaptionViewVisibilities(int i, int i2) {
        if (i != i2) {
            if (i2 != 0) {
                TextView captionViewFromDisplayState = getCaptionViewFromDisplayState(i2);
                if (captionViewFromDisplayState != null) {
                    captionViewFromDisplayState.setVisibility(0);
                    captionViewFromDisplayState.setAlpha(1.0f);
                }
            }
            if (i != 0) {
                TextView captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i);
                if (captionViewFromDisplayState2 != null) {
                    captionViewFromDisplayState2.setVisibility(4);
                    if (i == 1) {
                        captionViewFromDisplayState2.setText(null);
                    }
                }
            }
            this.captionDisplayed = i2;
        }
    }

    private void createCaptionAnimators(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView != null && z) {
            if (i == i3 || i == i2) {
                list.add(createCaptionOpacityAnimator(textView, i3 == i));
                if (i3 == i) {
                    list.add(createCaptionTranslationYAnimator(textView));
                }
            }
        }
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z ? 1.0f : BitmapDescriptorFactory.HUE_RED});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.captionTranslationYPx, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return ofFloat;
    }

    /* access modifiers changed from: 0000 */
    public void cancelCaptionAnimator() {
        if (this.captionAnimator != null) {
            this.captionAnimator.cancel();
        }
    }

    private TextView getCaptionViewFromDisplayState(int i) {
        switch (i) {
            case 1:
                return this.errorView;
            case 2:
                return this.helperTextView;
            default:
                return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding()) {
            C0962r.m3553a(this.indicatorArea, C0962r.m3583h(this.textInputView.getEditText()), 0, C0962r.m3585i(this.textInputView.getEditText()), 0);
        }
    }

    private boolean canAdjustIndicatorPadding() {
        return (this.indicatorArea == null || this.textInputView.getEditText() == null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    public void addIndicator(TextView textView, int i) {
        if (this.indicatorArea == null && this.captionArea == null) {
            this.indicatorArea = new LinearLayout(this.context);
            this.indicatorArea.setOrientation(0);
            this.textInputView.addView(this.indicatorArea, -1, -2);
            this.captionArea = new FrameLayout(this.context);
            this.indicatorArea.addView(this.captionArea, -1, new LayoutParams(-2, -2));
            this.indicatorArea.addView(new C1146a(this.context), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.textInputView.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (isCaptionView(i)) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(textView);
            this.captionViewsAdded++;
        } else {
            this.indicatorArea.addView(textView, i);
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    /* access modifiers changed from: 0000 */
    public void removeIndicator(TextView textView, int i) {
        if (this.indicatorArea != null) {
            if (!isCaptionView(i) || this.captionArea == null) {
                this.indicatorArea.removeView(textView);
            } else {
                this.captionViewsAdded--;
                setViewGroupGoneIfEmpty(this.captionArea, this.captionViewsAdded);
                this.captionArea.removeView(textView);
            }
            this.indicatorsAdded--;
            setViewGroupGoneIfEmpty(this.indicatorArea, this.indicatorsAdded);
        }
    }

    private void setViewGroupGoneIfEmpty(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setErrorEnabled(boolean z) {
        if (this.errorEnabled != z) {
            cancelCaptionAnimator();
            if (z) {
                this.errorView = new C0707z(this.context);
                this.errorView.setId(C2167R.C2170id.textinput_error);
                if (this.typeface != null) {
                    this.errorView.setTypeface(this.typeface);
                }
                setErrorTextAppearance(this.errorTextAppearance);
                setErrorViewTextColor(this.errorViewTextColor);
                this.errorView.setVisibility(4);
                C0962r.m3576d(this.errorView, 1);
                addIndicator(this.errorView, 0);
            } else {
                hideError();
                removeIndicator(this.errorView, 0);
                this.errorView = null;
                this.textInputView.updateEditTextBackground();
                this.textInputView.updateTextInputBoxState();
            }
            this.errorEnabled = z;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    /* access modifiers changed from: 0000 */
    public boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    /* access modifiers changed from: 0000 */
    public void setHelperTextEnabled(boolean z) {
        if (this.helperTextEnabled != z) {
            cancelCaptionAnimator();
            if (z) {
                this.helperTextView = new C0707z(this.context);
                this.helperTextView.setId(C2167R.C2170id.textinput_helper_text);
                if (this.typeface != null) {
                    this.helperTextView.setTypeface(this.typeface);
                }
                this.helperTextView.setVisibility(4);
                C0962r.m3576d(this.helperTextView, 1);
                setHelperTextAppearance(this.helperTextTextAppearance);
                setHelperTextViewTextColor(this.helperTextViewTextColor);
                addIndicator(this.helperTextView, 1);
            } else {
                hideHelperText();
                removeIndicator(this.helperTextView, 1);
                this.helperTextView = null;
                this.textInputView.updateEditTextBackground();
                this.textInputView.updateTextInputBoxState();
            }
            this.helperTextEnabled = z;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    /* access modifiers changed from: 0000 */
    public boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    private boolean isCaptionStateError(int i) {
        if (i != 1 || this.errorView == null || TextUtils.isEmpty(this.errorText)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    /* access modifiers changed from: 0000 */
    public boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    private boolean isCaptionStateHelperText(int i) {
        return i == 2 && this.helperTextView != null && !TextUtils.isEmpty(this.helperText);
    }

    /* access modifiers changed from: 0000 */
    public CharSequence getErrorText() {
        return this.errorText;
    }

    /* access modifiers changed from: 0000 */
    public CharSequence getHelperText() {
        return this.helperText;
    }

    /* access modifiers changed from: 0000 */
    public void setTypefaces(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            setTextViewTypeface(this.errorView, typeface2);
            setTextViewTypeface(this.helperTextView, typeface2);
        }
    }

    private void setTextViewTypeface(TextView textView, Typeface typeface2) {
        if (textView != null) {
            textView.setTypeface(typeface2);
        }
    }

    /* access modifiers changed from: 0000 */
    public int getErrorViewCurrentTextColor() {
        if (this.errorView != null) {
            return this.errorView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList getErrorViewTextColors() {
        if (this.errorView != null) {
            return this.errorView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void setErrorViewTextColor(ColorStateList colorStateList) {
        this.errorViewTextColor = colorStateList;
        if (this.errorView != null && colorStateList != null) {
            this.errorView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setErrorTextAppearance(int i) {
        this.errorTextAppearance = i;
        if (this.errorView != null) {
            this.textInputView.setTextAppearanceCompatWithErrorFallback(this.errorView, i);
        }
    }

    /* access modifiers changed from: 0000 */
    public int getHelperTextViewCurrentTextColor() {
        if (this.helperTextView != null) {
            return this.helperTextView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList getHelperTextViewColors() {
        if (this.helperTextView != null) {
            return this.helperTextView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void setHelperTextViewTextColor(ColorStateList colorStateList) {
        this.helperTextViewTextColor = colorStateList;
        if (this.helperTextView != null && colorStateList != null) {
            this.helperTextView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setHelperTextAppearance(int i) {
        this.helperTextTextAppearance = i;
        if (this.helperTextView != null) {
            C1013i.m3865a(this.helperTextView, i);
        }
    }
}