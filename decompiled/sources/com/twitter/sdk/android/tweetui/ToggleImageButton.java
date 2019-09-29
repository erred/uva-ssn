package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class ToggleImageButton extends ImageButton {

    /* renamed from: e */
    private static final int[] f8636e = {R.attr.state_toggled_on};

    /* renamed from: a */
    boolean f8637a;

    /* renamed from: b */
    String f8638b;

    /* renamed from: c */
    String f8639c;

    /* renamed from: d */
    final boolean f8640d;

    public ToggleImageButton(Context context) {
        this(context, null);
    }

    public ToggleImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ToggleImageButton(android.content.Context r4, android.util.AttributeSet r5, int r6) {
        /*
            r3 = this;
            r3.<init>(r4, r5, r6)
            r0 = 0
            android.content.res.Resources$Theme r4 = r4.getTheme()     // Catch:{ all -> 0x0044 }
            int[] r1 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton     // Catch:{ all -> 0x0044 }
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r6, r2)     // Catch:{ all -> 0x0044 }
            int r5 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton_contentDescriptionOn     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ all -> 0x0042 }
            int r6 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton_contentDescriptionOff     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = r4.getString(r6)     // Catch:{ all -> 0x0042 }
            if (r5 != 0) goto L_0x0023
            java.lang.CharSequence r5 = r3.getContentDescription()     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0042 }
        L_0x0023:
            r3.f8638b = r5     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x002e
            java.lang.CharSequence r5 = r3.getContentDescription()     // Catch:{ all -> 0x0042 }
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0042 }
        L_0x002e:
            r3.f8639c = r6     // Catch:{ all -> 0x0042 }
            int r5 = com.twitter.sdk.android.tweetui.R.styleable.ToggleImageButton_toggleOnClick     // Catch:{ all -> 0x0042 }
            r6 = 1
            boolean r5 = r4.getBoolean(r5, r6)     // Catch:{ all -> 0x0042 }
            r3.f8640d = r5     // Catch:{ all -> 0x0042 }
            r3.setToggledOn(r2)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x0041
            r4.recycle()
        L_0x0041:
            return
        L_0x0042:
            r5 = move-exception
            goto L_0x0046
        L_0x0044:
            r5 = move-exception
            r4 = r0
        L_0x0046:
            if (r4 == 0) goto L_0x004b
            r4.recycle()
        L_0x004b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.ToggleImageButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (this.f8637a) {
            mergeDrawableStates(onCreateDrawableState, f8636e);
        }
        return onCreateDrawableState;
    }

    public boolean performClick() {
        if (this.f8640d) {
            mo27985a();
        }
        return super.performClick();
    }

    public void setToggledOn(boolean z) {
        this.f8637a = z;
        setContentDescription(z ? this.f8638b : this.f8639c);
        refreshDrawableState();
    }

    /* renamed from: a */
    public void mo27985a() {
        setToggledOn(!this.f8637a);
    }
}
