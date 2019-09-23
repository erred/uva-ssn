package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.squareup.picasso.C3027ac;
import com.squareup.picasso.C3068t.C3074d;
import com.twitter.sdk.android.tweetui.internal.C3353f.C3355a;

/* renamed from: com.twitter.sdk.android.tweetui.internal.b */
/* compiled from: GalleryImageView */
public class C3345b extends FrameLayout implements C3027ac {

    /* renamed from: a */
    final C3347d f8742a;

    /* renamed from: b */
    final ProgressBar f8743b;

    public C3345b(Context context) {
        this(context, new C3347d(context), new ProgressBar(context));
    }

    C3345b(Context context, C3347d dVar, ProgressBar progressBar) {
        super(context);
        this.f8742a = dVar;
        this.f8743b = progressBar;
        progressBar.setLayoutParams(new LayoutParams(-2, -2, 17));
        addView(progressBar);
        dVar.setLayoutParams(new LayoutParams(-1, -1, 17));
        addView(dVar);
    }

    public void setSwipeToDismissCallback(C3355a aVar) {
        this.f8742a.setOnTouchListener(C3353f.m9788a((View) this.f8742a, aVar));
    }

    /* renamed from: a */
    public void mo27446a(Bitmap bitmap, C3074d dVar) {
        this.f8742a.setImageBitmap(bitmap);
        this.f8743b.setVisibility(8);
    }

    /* renamed from: a */
    public void mo27447a(Drawable drawable) {
        this.f8742a.setImageResource(17170445);
        this.f8743b.setVisibility(0);
    }
}
