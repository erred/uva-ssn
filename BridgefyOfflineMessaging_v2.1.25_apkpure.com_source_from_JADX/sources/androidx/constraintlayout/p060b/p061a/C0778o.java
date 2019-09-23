package androidx.constraintlayout.p060b.p061a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.constraintlayout.b.a.o */
/* compiled from: ResolutionDimension */
public class C0778o extends C0779p {

    /* renamed from: a */
    float f2358a = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: b */
    public void mo3155b() {
        super.mo3155b();
        this.f2358a = BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: a */
    public void mo3162a(int i) {
        if (this.f2360i == 0 || this.f2358a != ((float) i)) {
            this.f2358a = (float) i;
            if (this.f2360i == 1) {
                mo3165e();
            }
            mo3166f();
        }
    }

    /* renamed from: c */
    public void mo3163c() {
        this.f2360i = 2;
    }
}
