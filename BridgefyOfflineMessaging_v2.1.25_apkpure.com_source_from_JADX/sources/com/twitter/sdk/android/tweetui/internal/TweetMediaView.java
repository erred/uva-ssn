package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.primitives.Ints;
import com.squareup.picasso.C3044e;
import com.squareup.picasso.C3068t;
import com.twitter.sdk.android.core.C3134g;
import com.twitter.sdk.android.core.internal.C3207q;
import com.twitter.sdk.android.core.internal.scribe.C3243w;
import com.twitter.sdk.android.core.p132a.C3107e;
import com.twitter.sdk.android.core.p132a.C3110h;
import com.twitter.sdk.android.core.p132a.C3112j;
import com.twitter.sdk.android.core.p132a.C3119o;
import com.twitter.sdk.android.tweetui.C3327i;
import com.twitter.sdk.android.tweetui.C3363m;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.GalleryActivity.C3305a;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.PlayerActivity.C3307a;
import com.twitter.sdk.android.tweetui.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class TweetMediaView extends ViewGroup implements OnClickListener {

    /* renamed from: a */
    final float[] f8680a;

    /* renamed from: b */
    int f8681b;

    /* renamed from: c */
    int f8682c;

    /* renamed from: d */
    final C3328a f8683d;

    /* renamed from: e */
    boolean f8684e;

    /* renamed from: f */
    C3327i f8685f;

    /* renamed from: g */
    C3119o f8686g;

    /* renamed from: h */
    private final C3351e[] f8687h;

    /* renamed from: i */
    private List<C3112j> f8688i;

    /* renamed from: j */
    private final Path f8689j;

    /* renamed from: k */
    private final RectF f8690k;

    /* renamed from: l */
    private final int f8691l;

    /* renamed from: m */
    private int f8692m;

    /* renamed from: com.twitter.sdk.android.tweetui.internal.TweetMediaView$a */
    static class C3328a {
        C3328a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C3068t mo28058a() {
            return C3363m.m9824a().mo28165e();
        }
    }

    /* renamed from: com.twitter.sdk.android.tweetui.internal.TweetMediaView$b */
    static class C3329b implements C3044e {

        /* renamed from: a */
        final WeakReference<ImageView> f8693a;

        C3329b(ImageView imageView) {
            this.f8693a = new WeakReference<>(imageView);
        }

        /* renamed from: a */
        public void mo27484a() {
            ImageView imageView = (ImageView) this.f8693a.get();
            if (imageView != null) {
                imageView.setBackgroundResource(17170445);
            }
        }
    }

    /* renamed from: com.twitter.sdk.android.tweetui.internal.TweetMediaView$c */
    static class C3330c {

        /* renamed from: a */
        static final C3330c f8694a = new C3330c();

        /* renamed from: b */
        final int f8695b;

        /* renamed from: c */
        final int f8696c;

        private C3330c() {
            this(0, 0);
        }

        private C3330c(int i, int i2) {
            this.f8695b = i;
            this.f8696c = i2;
        }

        /* renamed from: a */
        static C3330c m9710a(int i, int i2) {
            int max = Math.max(i, 0);
            int max2 = Math.max(i2, 0);
            return (max == 0 && max2 == 0) ? f8694a : new C3330c(max, max2);
        }
    }

    public TweetMediaView(Context context) {
        this(context, null);
    }

    public TweetMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new C3328a());
    }

    TweetMediaView(Context context, AttributeSet attributeSet, C3328a aVar) {
        super(context, attributeSet);
        this.f8687h = new C3351e[4];
        this.f8688i = Collections.emptyList();
        this.f8689j = new Path();
        this.f8690k = new RectF();
        this.f8680a = new float[8];
        this.f8681b = -16777216;
        this.f8683d = aVar;
        this.f8691l = getResources().getDimensionPixelSize(R.dimen.tw__media_view_divider_size);
        this.f8682c = R.drawable.tw__ic_tweet_photo_error_dark;
    }

    public void setMediaBgColor(int i) {
        this.f8681b = i;
    }

    public void setTweetMediaClickListener(C3327i iVar) {
        this.f8685f = iVar;
    }

    public void setPhotoErrorResId(int i) {
        this.f8682c = i;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f8692m > 0) {
            mo28037a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        C3330c cVar;
        if (this.f8692m > 0) {
            cVar = mo28036a(i, i2);
        } else {
            cVar = C3330c.f8694a;
        }
        setMeasuredDimension(cVar.f8695b, cVar.f8696c);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8689j.reset();
        this.f8690k.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) i, (float) i2);
        this.f8689j.addRoundRect(this.f8690k, this.f8680a, Direction.CW);
        this.f8689j.close();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (!this.f8684e || VERSION.SDK_INT < 18) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f8689j);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void onClick(View view) {
        Integer num = (Integer) view.getTag(R.id.tw__entity_index);
        if (this.f8685f != null) {
            this.f8685f.mo28027a(this.f8686g, !this.f8688i.isEmpty() ? (C3112j) this.f8688i.get(num.intValue()) : null);
        } else if (!this.f8688i.isEmpty()) {
            C3112j jVar = (C3112j) this.f8688i.get(num.intValue());
            if (C3357g.m9805b(jVar)) {
                mo28043a(jVar);
            } else if (C3357g.m9803a(jVar)) {
                mo28038a(num.intValue());
            }
        } else {
            mo28044a(this.f8686g);
        }
    }

    /* renamed from: a */
    public void mo28043a(C3112j jVar) {
        if (C3357g.m9806c(jVar) != null) {
            Intent intent = new Intent(getContext(), PlayerActivity.class);
            C3307a aVar = new C3307a(C3357g.m9806c(jVar).f8260b, C3357g.m9807d(jVar), C3357g.m9808e(jVar), null, null);
            intent.putExtra("PLAYER_ITEM", aVar);
            C3134g.m9164b(getContext(), intent);
        }
    }

    /* renamed from: a */
    public void mo28044a(C3119o oVar) {
        C3107e eVar = oVar.f8185H;
        Intent intent = new Intent(getContext(), PlayerActivity.class);
        C3307a aVar = new C3307a(C3207q.m9387c(eVar), true, false, null, null);
        intent.putExtra("PLAYER_ITEM", aVar);
        intent.putExtra("SCRIBE_ITEM", C3243w.m9517a(oVar.f8194i, eVar));
        C3134g.m9164b(getContext(), intent);
    }

    /* renamed from: a */
    public void mo28038a(int i) {
        Intent intent = new Intent(getContext(), GalleryActivity.class);
        intent.putExtra("GALLERY_ITEM", new C3305a(this.f8686g.f8194i, i, this.f8688i));
        C3134g.m9164b(getContext(), intent);
    }

    public void setVineCard(C3119o oVar) {
        if (oVar != null && oVar.f8185H != null && C3207q.m9385a(oVar.f8185H)) {
            this.f8686g = oVar;
            this.f8688i = Collections.emptyList();
            mo28047b();
            mo28042a(oVar.f8185H);
            this.f8684e = false;
            requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3330c mo28036a(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = (size - this.f8691l) / 2;
        int i4 = (size2 - this.f8691l) / 2;
        switch (this.f8692m) {
            case 1:
                mo28039a(0, size, size2);
                break;
            case 2:
                mo28039a(0, i3, size2);
                mo28039a(1, i3, size2);
                break;
            case 3:
                mo28039a(0, i3, size2);
                mo28039a(1, i3, i4);
                mo28039a(2, i3, i4);
                break;
            case 4:
                mo28039a(0, i3, i4);
                mo28039a(1, i3, i4);
                mo28039a(2, i3, i4);
                mo28039a(3, i3, i4);
                break;
        }
        return C3330c.m9710a(size, size2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28039a(int i, int i2, int i3) {
        this.f8687h[i].measure(MeasureSpec.makeMeasureSpec(i2, Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec(i3, Ints.MAX_POWER_OF_TWO));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28037a() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = (measuredWidth - this.f8691l) / 2;
        int i2 = (measuredHeight - this.f8691l) / 2;
        int i3 = i + this.f8691l;
        switch (this.f8692m) {
            case 1:
                mo28040a(0, 0, 0, measuredWidth, measuredHeight);
                return;
            case 2:
                int i4 = measuredHeight;
                mo28040a(0, 0, 0, i, i4);
                mo28040a(1, i + this.f8691l, 0, measuredWidth, i4);
                return;
            case 3:
                mo28040a(0, 0, 0, i, measuredHeight);
                int i5 = i3;
                int i6 = measuredWidth;
                mo28040a(1, i5, 0, i6, i2);
                mo28040a(2, i5, i2 + this.f8691l, i6, measuredHeight);
                return;
            case 4:
                int i7 = i;
                mo28040a(0, 0, 0, i7, i2);
                mo28040a(2, 0, i2 + this.f8691l, i7, measuredHeight);
                int i8 = i3;
                int i9 = measuredWidth;
                mo28040a(1, i8, 0, i9, i2);
                mo28040a(3, i8, i2 + this.f8691l, i9, measuredHeight);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28040a(int i, int i2, int i3, int i4, int i5) {
        C3351e eVar = this.f8687h[i];
        if (eVar.getLeft() != i2 || eVar.getTop() != i3 || eVar.getRight() != i4 || eVar.getBottom() != i5) {
            eVar.layout(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28047b() {
        for (int i = 0; i < this.f8692m; i++) {
            C3351e eVar = this.f8687h[i];
            if (eVar != null) {
                eVar.setVisibility(8);
            }
        }
        this.f8692m = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28042a(C3107e eVar) {
        this.f8692m = 1;
        C3351e b = mo28046b(0);
        C3110h d = C3207q.m9388d(eVar);
        mo28041a((ImageView) b, d.f8166b);
        mo28048b(b, d.f8165a);
        mo28045a(b, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3351e mo28046b(int i) {
        C3351e eVar = this.f8687h[i];
        if (eVar == null) {
            eVar = new C3351e(getContext());
            eVar.setLayoutParams(generateDefaultLayoutParams());
            eVar.setOnClickListener(this);
            this.f8687h[i] = eVar;
            addView(eVar, i);
        } else {
            mo28039a(i, 0, 0);
            mo28040a(i, 0, 0, 0, 0);
        }
        eVar.setVisibility(0);
        eVar.setBackgroundColor(this.f8681b);
        eVar.setTag(R.id.tw__entity_index, Integer.valueOf(i));
        return eVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28041a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            imageView.setContentDescription(str);
        } else {
            imageView.setContentDescription(getResources().getString(R.string.tw__tweet_media));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28045a(C3351e eVar, boolean z) {
        if (z) {
            eVar.setOverlayDrawable(getContext().getResources().getDrawable(R.drawable.tw__player_overlay));
        } else {
            eVar.setOverlayDrawable(null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28048b(ImageView imageView, String str) {
        C3068t a = this.f8683d.mo28058a();
        if (a != null) {
            a.mo27533a(str).mo27571a().mo27581d().mo27579b(this.f8682c).mo27576a(imageView, (C3044e) new C3329b(imageView));
        }
    }
}
