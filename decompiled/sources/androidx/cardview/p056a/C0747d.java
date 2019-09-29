package androidx.cardview.p056a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.cardview.a.d */
/* compiled from: CardViewBaseImpl */
class C0747d implements C0750f {

    /* renamed from: a */
    final RectF f2132a = new RectF();

    /* renamed from: g */
    public void mo2974g(C0749e eVar) {
    }

    C0747d() {
    }

    /* renamed from: a */
    public void mo2961a() {
        C0752h.f2145a = new C0753a() {
            /* renamed from: a */
            public void mo2962a(Canvas canvas, RectF rectF, float f, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    C0747d.this.f2132a.set(f4, f4, f3, f3);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                    canvas.drawArc(C0747d.this.f2132a, 180.0f, 90.0f, true, paint);
                    canvas2.translate(width, BitmapDescriptorFactory.HUE_RED);
                    canvas2.rotate(90.0f);
                    Paint paint2 = paint;
                    canvas.drawArc(C0747d.this.f2132a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, BitmapDescriptorFactory.HUE_RED);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(C0747d.this.f2132a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, BitmapDescriptorFactory.HUE_RED);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(C0747d.this.f2132a, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint);
                    canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
            }
        };
    }

    /* renamed from: a */
    public void mo2965a(C0749e eVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C0752h a = m2626a(context, colorStateList, f, f2, f3);
        a.mo2997a(eVar.mo2958b());
        eVar.mo2956a(a);
        mo2973f(eVar);
    }

    /* renamed from: a */
    private C0752h m2626a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C0752h hVar = new C0752h(context.getResources(), colorStateList, f, f2, f3);
        return hVar;
    }

    /* renamed from: f */
    public void mo2973f(C0749e eVar) {
        Rect rect = new Rect();
        m2627j(eVar).mo2996a(rect);
        eVar.mo2954a((int) Math.ceil((double) mo2967b(eVar)), (int) Math.ceil((double) mo2969c(eVar)));
        eVar.mo2955a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: h */
    public void mo2975h(C0749e eVar) {
        m2627j(eVar).mo2997a(eVar.mo2958b());
        mo2973f(eVar);
    }

    /* renamed from: a */
    public void mo2966a(C0749e eVar, ColorStateList colorStateList) {
        m2627j(eVar).mo2995a(colorStateList);
    }

    /* renamed from: i */
    public ColorStateList mo2976i(C0749e eVar) {
        return m2627j(eVar).mo3005f();
    }

    /* renamed from: a */
    public void mo2964a(C0749e eVar, float f) {
        m2627j(eVar).mo2994a(f);
        mo2973f(eVar);
    }

    /* renamed from: d */
    public float mo2971d(C0749e eVar) {
        return m2627j(eVar).mo2993a();
    }

    /* renamed from: c */
    public void mo2970c(C0749e eVar, float f) {
        m2627j(eVar).mo2999b(f);
    }

    /* renamed from: e */
    public float mo2972e(C0749e eVar) {
        return m2627j(eVar).mo2998b();
    }

    /* renamed from: b */
    public void mo2968b(C0749e eVar, float f) {
        m2627j(eVar).mo3001c(f);
        mo2973f(eVar);
    }

    /* renamed from: a */
    public float mo2963a(C0749e eVar) {
        return m2627j(eVar).mo3000c();
    }

    /* renamed from: b */
    public float mo2967b(C0749e eVar) {
        return m2627j(eVar).mo3002d();
    }

    /* renamed from: c */
    public float mo2969c(C0749e eVar) {
        return m2627j(eVar).mo3004e();
    }

    /* renamed from: j */
    private C0752h m2627j(C0749e eVar) {
        return (C0752h) eVar.mo2959c();
    }
}
