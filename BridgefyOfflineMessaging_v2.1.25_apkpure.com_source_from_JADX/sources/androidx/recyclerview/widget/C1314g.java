package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView.C1254i;
import androidx.recyclerview.widget.RecyclerView.C1259j;
import androidx.recyclerview.widget.RecyclerView.C1271t;
import androidx.recyclerview.widget.RecyclerView.C1271t.C1272a;
import androidx.recyclerview.widget.RecyclerView.C1274u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.recyclerview.widget.g */
/* compiled from: LinearSmoothScroller */
public class C1314g extends C1271t {

    /* renamed from: a */
    protected final LinearInterpolator f3973a = new LinearInterpolator();

    /* renamed from: b */
    protected final DecelerateInterpolator f3974b = new DecelerateInterpolator();

    /* renamed from: c */
    protected PointF f3975c;

    /* renamed from: d */
    protected int f3976d = 0;

    /* renamed from: e */
    protected int f3977e = 0;

    /* renamed from: f */
    private final float f3978f;

    /* renamed from: b */
    private int m5336b(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5264a() {
    }

    public C1314g(Context context) {
        this.f3978f = mo5518a(context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5268a(View view, C1274u uVar, C1272a aVar) {
        int b = mo5524b(view, mo5525c());
        int a = mo5521a(view, mo5526d());
        int a2 = mo5519a((int) Math.sqrt((double) ((b * b) + (a * a))));
        if (a2 > 0) {
            aVar.mo5282a(-b, -a, a2, this.f3974b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5266a(int i, int i2, C1274u uVar, C1272a aVar) {
        if (mo5280j() == 0) {
            mo5276f();
            return;
        }
        this.f3976d = m5336b(this.f3976d, i);
        this.f3977e = m5336b(this.f3977e, i2);
        if (this.f3976d == 0 && this.f3977e == 0) {
            mo5522a(aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5270b() {
        this.f3977e = 0;
        this.f3976d = 0;
        this.f3975c = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo5518a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo5519a(int i) {
        return (int) Math.ceil(((double) mo5523b(i)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo5523b(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f3978f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo5525c() {
        if (this.f3975c == null || this.f3975c.x == BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        return this.f3975c.x > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo5526d() {
        if (this.f3975c == null || this.f3975c.y == BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        return this.f3975c.y > BitmapDescriptorFactory.HUE_RED ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5522a(C1272a aVar) {
        PointF d = mo5273d(mo5279i());
        if (d == null || (d.x == BitmapDescriptorFactory.HUE_RED && d.y == BitmapDescriptorFactory.HUE_RED)) {
            aVar.mo5281a(mo5279i());
            mo5276f();
            return;
        }
        mo5267a(d);
        this.f3975c = d;
        this.f3976d = (int) (d.x * 10000.0f);
        this.f3977e = (int) (d.y * 10000.0f);
        aVar.mo5282a((int) (((float) this.f3976d) * 1.2f), (int) (((float) this.f3977e) * 1.2f), (int) (((float) mo5523b(10000)) * 1.2f), this.f3973a);
    }

    /* renamed from: a */
    public int mo5520a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                int i7 = i4 - i2;
                if (i7 < 0) {
                    return i7;
                }
                return 0;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    /* renamed from: a */
    public int mo5521a(View view, int i) {
        C1254i e = mo5275e();
        if (e == null || !e.mo4784f()) {
            return 0;
        }
        C1259j jVar = (C1259j) view.getLayoutParams();
        return mo5520a(e.mo5168i(view) - jVar.topMargin, e.mo5172k(view) + jVar.bottomMargin, e.mo5100C(), e.mo5098A() - e.mo5102E(), i);
    }

    /* renamed from: b */
    public int mo5524b(View view, int i) {
        C1254i e = mo5275e();
        if (e == null || !e.mo4781e()) {
            return 0;
        }
        C1259j jVar = (C1259j) view.getLayoutParams();
        return mo5520a(e.mo5166h(view) - jVar.leftMargin, e.mo5170j(view) + jVar.rightMargin, e.mo5099B(), e.mo5189z() - e.mo5101D(), i);
    }
}
