package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.twitter.sdk.android.core.internal.C3207q;
import com.twitter.sdk.android.core.p132a.C3107e;
import com.twitter.sdk.android.core.p132a.C3112j;
import com.twitter.sdk.android.tweetui.R;

public class MediaBadgeView extends FrameLayout {

    /* renamed from: a */
    TextView f8678a;

    /* renamed from: b */
    ImageView f8679b;

    public MediaBadgeView(Context context) {
        this(context, null);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo28031a(context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28031a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tw__media_badge, this, true);
        this.f8678a = (TextView) inflate.findViewById(R.id.tw__video_duration);
        this.f8679b = (ImageView) inflate.findViewById(R.id.tw__gif_badge);
    }

    public void setMediaEntity(C3112j jVar) {
        if ("animated_gif".equals(jVar.f8170c)) {
            setBadge(getResources().getDrawable(R.drawable.tw__gif_badge));
        } else if ("video".equals(jVar.f8170c)) {
            setText(jVar.f8171d == null ? 0 : jVar.f8171d.f8257a);
        } else {
            mo28030a();
        }
    }

    public void setCard(C3107e eVar) {
        if (C3207q.m9385a(eVar)) {
            setBadge(getResources().getDrawable(R.drawable.tw__vine_badge));
        } else {
            mo28030a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void setText(long j) {
        this.f8678a.setVisibility(0);
        this.f8679b.setVisibility(8);
        this.f8678a.setText(C3346c.m9770a(j));
    }

    /* access modifiers changed from: 0000 */
    public void setBadge(Drawable drawable) {
        this.f8679b.setVisibility(0);
        this.f8678a.setVisibility(8);
        this.f8679b.setImageDrawable(drawable);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28030a() {
        this.f8678a.setVisibility(8);
        this.f8679b.setVisibility(8);
    }
}
