package com.firebase.p119ui.auth.p124ui.phone;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.C0686l;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.ui.phone.SpacedEditText */
public final class SpacedEditText extends C0686l {

    /* renamed from: a */
    private float f6428a;

    /* renamed from: b */
    private SpannableStringBuilder f6429b;

    public SpacedEditText(Context context) {
        super(context);
    }

    public SpacedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo11932a(context, attributeSet);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11932a(Context context, AttributeSet attributeSet) {
        this.f6429b = new SpannableStringBuilder("");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SpacedEditText);
        this.f6428a = obtainStyledAttributes.getFloat(R.styleable.SpacedEditText_spacingProportion, 1.0f);
        obtainStyledAttributes.recycle();
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        this.f6429b = new SpannableStringBuilder(charSequence);
        super.setText(m8397a(charSequence), BufferType.SPANNABLE);
    }

    public void setSelection(int i) {
        super.setSelection(i + (i == 0 ? 0 : i - 1));
    }

    /* renamed from: a */
    private SpannableStringBuilder m8397a(CharSequence charSequence) {
        int i;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int length = charSequence.length();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            i = length - 1;
            if (i3 >= i) {
                break;
            }
            spannableStringBuilder.append(charSequence.charAt(i3));
            spannableStringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            i2 += 2;
            spannableStringBuilder.setSpan(new ScaleXSpan(this.f6428a), i2, i2 + 1, 33);
            i3++;
        }
        if (length != 0) {
            spannableStringBuilder.append(charSequence.charAt(i));
        }
        return spannableStringBuilder;
    }

    public Editable getUnspacedText() {
        return this.f6429b;
    }
}
