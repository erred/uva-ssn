package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.C3068t.C3074d;

/* renamed from: com.squareup.picasso.ad */
/* compiled from: TargetAction */
final class C3028ad extends C3021a<C3027ac> {
    C3028ad(C3068t tVar, C3027ac acVar, C3081w wVar, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(tVar, acVar, wVar, i, i2, i3, drawable, str, obj, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27419a(Bitmap bitmap, C3074d dVar) {
        if (bitmap != null) {
            C3027ac acVar = (C3027ac) mo27422c();
            if (acVar != null) {
                acVar.mo27446a(bitmap, dVar);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27420a(Exception exc) {
        C3027ac acVar = (C3027ac) mo27422c();
        if (acVar == null) {
            return;
        }
        if (this.f7883g != 0) {
            acVar.mo27448a(exc, this.f7877a.f8021c.getResources().getDrawable(this.f7883g));
        } else {
            acVar.mo27448a(exc, this.f7884h);
        }
    }
}
