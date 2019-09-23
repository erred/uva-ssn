package com.twitter.sdk.android.tweetcomposer.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObservableScrollView extends ScrollView {

    /* renamed from: a */
    C3302a f8619a;

    /* renamed from: com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView$a */
    public interface C3302a {
        /* renamed from: a */
        void mo27942a(int i);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ObservableScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f8619a != null) {
            this.f8619a.mo27942a(i2);
        }
    }

    public void setScrollViewListener(C3302a aVar) {
        this.f8619a = aVar;
    }
}
