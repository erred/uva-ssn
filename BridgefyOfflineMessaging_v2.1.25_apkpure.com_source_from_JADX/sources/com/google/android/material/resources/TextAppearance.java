package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.p066a.C0886f;
import androidx.core.content.p066a.C0886f.C0887a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.C2167R;

public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    /* access modifiers changed from: private */
    public Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    /* access modifiers changed from: private */
    public boolean fontResolved = false;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    public final ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C2167R.styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(C2167R.styleable.TextAppearance_android_textSize, BitmapDescriptorFactory.HUE_RED);
        this.textColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, C2167R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, C2167R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, C2167R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(C2167R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(C2167R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, C2167R.styleable.TextAppearance_fontFamily, C2167R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(C2167R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, C2167R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(C2167R.styleable.TextAppearance_android_shadowDx, BitmapDescriptorFactory.HUE_RED);
        this.shadowDy = obtainStyledAttributes.getFloat(C2167R.styleable.TextAppearance_android_shadowDy, BitmapDescriptorFactory.HUE_RED);
        this.shadowRadius = obtainStyledAttributes.getFloat(C2167R.styleable.TextAppearance_android_shadowRadius, BitmapDescriptorFactory.HUE_RED);
        obtainStyledAttributes.recycle();
    }

    public Typeface getFont(Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                this.font = C0886f.m3292a(context, this.fontFamilyResourceId);
                if (this.font != null) {
                    this.font = Typeface.create(this.font, this.textStyle);
                }
            } catch (NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Error loading font ");
                sb.append(this.fontFamily);
                Log.d(str, sb.toString(), e);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(Context context, final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        if (this.fontFamilyResourceId == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            C0886f.m3297a(context, this.fontFamilyResourceId, new C0887a() {
                public void onFontRetrieved(Typeface typeface) {
                    TextAppearance.this.font = Typeface.create(typeface, TextAppearance.this.textStyle);
                    TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(TextAppearance.this.font, false);
                }

                public void onFontRetrievalFailed(int i) {
                    TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i);
                }
            }, null);
        } catch (NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Error loading font ");
            sb.append(this.fontFamily);
            Log.d(str, sb.toString(), e);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    public void getFontAsync(Context context, final TextPaint textPaint, final TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(textPaint, getFallbackFont());
        getFontAsync(context, new TextAppearanceFontCallback() {
            public void onFontRetrieved(Typeface typeface, boolean z) {
                TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z);
            }

            public void onFontRetrievalFailed(int i) {
                textAppearanceFontCallback.onFontRetrievalFailed(i);
            }
        });
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    private void createFallbackFont() {
        if (this.font == null && this.fontFamily != null) {
            this.font = Typeface.create(this.fontFamily, this.textStyle);
        }
        if (this.font == null) {
            switch (this.typeface) {
                case 1:
                    this.font = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.font = Typeface.SERIF;
                    break;
                case 3:
                    this.font = Typeface.MONOSPACE;
                    break;
                default:
                    this.font = Typeface.DEFAULT;
                    break;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    public void updateDrawState(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        textPaint.setColor(this.textColor != null ? this.textColor.getColorForState(textPaint.drawableState, this.textColor.getDefaultColor()) : -16777216);
        textPaint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor != null ? this.shadowColor.getColorForState(textPaint.drawableState, this.shadowColor.getDefaultColor()) : 0);
    }

    public void updateMeasureState(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            updateTextPaintMeasureState(textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(TextPaint textPaint, Typeface typeface2) {
        textPaint.setTypeface(typeface2);
        int i = (~typeface2.getStyle()) & this.textStyle;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : BitmapDescriptorFactory.HUE_RED);
        textPaint.setTextSize(this.textSize);
    }
}
