package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.p070g.p071a.C0935b.C0938c;
import androidx.customview.p073b.C1024a;
import androidx.recyclerview.widget.RecyclerView.C1254i;
import androidx.recyclerview.widget.RecyclerView.C1254i.C1257a;
import androidx.recyclerview.widget.RecyclerView.C1254i.C1258b;
import androidx.recyclerview.widget.RecyclerView.C1259j;
import androidx.recyclerview.widget.RecyclerView.C1266p;
import androidx.recyclerview.widget.RecyclerView.C1271t;
import androidx.recyclerview.widget.RecyclerView.C1271t.C1273b;
import androidx.recyclerview.widget.RecyclerView.C1274u;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C1254i implements C1273b {

    /* renamed from: A */
    private C1284d f3789A;

    /* renamed from: B */
    private int f3790B;

    /* renamed from: C */
    private final Rect f3791C = new Rect();

    /* renamed from: D */
    private final C1279a f3792D = new C1279a();

    /* renamed from: E */
    private boolean f3793E = false;

    /* renamed from: F */
    private boolean f3794F = true;

    /* renamed from: G */
    private int[] f3795G;

    /* renamed from: H */
    private final Runnable f3796H = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.mo5353g();
        }
    };

    /* renamed from: a */
    C1286e[] f3797a;

    /* renamed from: b */
    C1317i f3798b;

    /* renamed from: c */
    C1317i f3799c;

    /* renamed from: d */
    boolean f3800d = false;

    /* renamed from: e */
    boolean f3801e = false;

    /* renamed from: f */
    int f3802f = -1;

    /* renamed from: g */
    int f3803g = C1024a.INVALID_ID;

    /* renamed from: h */
    C1281c f3804h = new C1281c();

    /* renamed from: i */
    private int f3805i = -1;

    /* renamed from: j */
    private int f3806j;

    /* renamed from: k */
    private int f3807k;

    /* renamed from: l */
    private final C1313f f3808l;

    /* renamed from: m */
    private BitSet f3809m;

    /* renamed from: n */
    private int f3810n = 2;

    /* renamed from: o */
    private boolean f3811o;

    /* renamed from: z */
    private boolean f3812z;

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$a */
    class C1279a {

        /* renamed from: a */
        int f3814a;

        /* renamed from: b */
        int f3815b;

        /* renamed from: c */
        boolean f3816c;

        /* renamed from: d */
        boolean f3817d;

        /* renamed from: e */
        boolean f3818e;

        /* renamed from: f */
        int[] f3819f;

        C1279a() {
            mo5362a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5362a() {
            this.f3814a = -1;
            this.f3815b = C1024a.INVALID_ID;
            this.f3816c = false;
            this.f3817d = false;
            this.f3818e = false;
            if (this.f3819f != null) {
                Arrays.fill(this.f3819f, -1);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5364a(C1286e[] eVarArr) {
            int length = eVarArr.length;
            if (this.f3819f == null || this.f3819f.length < length) {
                this.f3819f = new int[StaggeredGridLayoutManager.this.f3797a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f3819f[i] = eVarArr[i].mo5396a((int) C1024a.INVALID_ID);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5365b() {
            int i;
            if (this.f3816c) {
                i = StaggeredGridLayoutManager.this.f3798b.mo5537d();
            } else {
                i = StaggeredGridLayoutManager.this.f3798b.mo5535c();
            }
            this.f3815b = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5363a(int i) {
            if (this.f3816c) {
                this.f3815b = StaggeredGridLayoutManager.this.f3798b.mo5537d() - i;
            } else {
                this.f3815b = StaggeredGridLayoutManager.this.f3798b.mo5535c() + i;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$b */
    public static class C1280b extends C1259j {

        /* renamed from: a */
        C1286e f3821a;

        /* renamed from: b */
        boolean f3822b;

        public C1280b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C1280b(int i, int i2) {
            super(i, i2);
        }

        public C1280b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1280b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public boolean mo5366a() {
            return this.f3822b;
        }

        /* renamed from: b */
        public final int mo5367b() {
            if (this.f3821a == null) {
                return -1;
            }
            return this.f3821a.f3843e;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c */
    static class C1281c {

        /* renamed from: a */
        int[] f3823a;

        /* renamed from: b */
        List<C1282a> f3824b;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a */
        static class C1282a implements Parcelable {
            public static final Creator<C1282a> CREATOR = new Creator<C1282a>() {
                /* renamed from: a */
                public C1282a createFromParcel(Parcel parcel) {
                    return new C1282a(parcel);
                }

                /* renamed from: a */
                public C1282a[] newArray(int i) {
                    return new C1282a[i];
                }
            };

            /* renamed from: a */
            int f3825a;

            /* renamed from: b */
            int f3826b;

            /* renamed from: c */
            int[] f3827c;

            /* renamed from: d */
            boolean f3828d;

            public int describeContents() {
                return 0;
            }

            C1282a(Parcel parcel) {
                this.f3825a = parcel.readInt();
                this.f3826b = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f3828d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f3827c = new int[readInt];
                    parcel.readIntArray(this.f3827c);
                }
            }

            C1282a() {
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public int mo5380a(int i) {
                if (this.f3827c == null) {
                    return 0;
                }
                return this.f3827c[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3825a);
                parcel.writeInt(this.f3826b);
                parcel.writeInt(this.f3828d ? 1 : 0);
                if (this.f3827c == null || this.f3827c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f3827c.length);
                parcel.writeIntArray(this.f3827c);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("FullSpanItem{mPosition=");
                sb.append(this.f3825a);
                sb.append(", mGapDir=");
                sb.append(this.f3826b);
                sb.append(", mHasUnwantedGapAfter=");
                sb.append(this.f3828d);
                sb.append(", mGapPerSpan=");
                sb.append(Arrays.toString(this.f3827c));
                sb.append('}');
                return sb.toString();
            }
        }

        C1281c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo5368a(int i) {
            if (this.f3824b != null) {
                for (int size = this.f3824b.size() - 1; size >= 0; size--) {
                    if (((C1282a) this.f3824b.get(size)).f3825a >= i) {
                        this.f3824b.remove(size);
                    }
                }
            }
            return mo5374b(i);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo5374b(int i) {
            if (this.f3823a == null || i >= this.f3823a.length) {
                return -1;
            }
            int g = m5157g(i);
            if (g == -1) {
                Arrays.fill(this.f3823a, i, this.f3823a.length, -1);
                return this.f3823a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f3823a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public int mo5376c(int i) {
            if (this.f3823a == null || i >= this.f3823a.length) {
                return -1;
            }
            return this.f3823a[i];
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5372a(int i, C1286e eVar) {
            mo5378e(i);
            this.f3823a[i] = eVar.f3843e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo5377d(int i) {
            int length = this.f3823a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo5378e(int i) {
            if (this.f3823a == null) {
                this.f3823a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f3823a, -1);
            } else if (i >= this.f3823a.length) {
                int[] iArr = this.f3823a;
                this.f3823a = new int[mo5377d(i)];
                System.arraycopy(iArr, 0, this.f3823a, 0, iArr.length);
                Arrays.fill(this.f3823a, iArr.length, this.f3823a.length, -1);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5370a() {
            if (this.f3823a != null) {
                Arrays.fill(this.f3823a, -1);
            }
            this.f3824b = null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5371a(int i, int i2) {
            if (this.f3823a != null && i < this.f3823a.length) {
                int i3 = i + i2;
                mo5378e(i3);
                System.arraycopy(this.f3823a, i3, this.f3823a, i, (this.f3823a.length - i) - i2);
                Arrays.fill(this.f3823a, this.f3823a.length - i2, this.f3823a.length, -1);
                m5155c(i, i2);
            }
        }

        /* renamed from: c */
        private void m5155c(int i, int i2) {
            if (this.f3824b != null) {
                int i3 = i + i2;
                for (int size = this.f3824b.size() - 1; size >= 0; size--) {
                    C1282a aVar = (C1282a) this.f3824b.get(size);
                    if (aVar.f3825a >= i) {
                        if (aVar.f3825a < i3) {
                            this.f3824b.remove(size);
                        } else {
                            aVar.f3825a -= i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5375b(int i, int i2) {
            if (this.f3823a != null && i < this.f3823a.length) {
                int i3 = i + i2;
                mo5378e(i3);
                System.arraycopy(this.f3823a, i, this.f3823a, i3, (this.f3823a.length - i) - i2);
                Arrays.fill(this.f3823a, i, i3, -1);
                m5156d(i, i2);
            }
        }

        /* renamed from: d */
        private void m5156d(int i, int i2) {
            if (this.f3824b != null) {
                for (int size = this.f3824b.size() - 1; size >= 0; size--) {
                    C1282a aVar = (C1282a) this.f3824b.get(size);
                    if (aVar.f3825a >= i) {
                        aVar.f3825a += i2;
                    }
                }
            }
        }

        /* renamed from: g */
        private int m5157g(int i) {
            if (this.f3824b == null) {
                return -1;
            }
            C1282a f = mo5379f(i);
            if (f != null) {
                this.f3824b.remove(f);
            }
            int size = this.f3824b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (((C1282a) this.f3824b.get(i2)).f3825a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            C1282a aVar = (C1282a) this.f3824b.get(i2);
            this.f3824b.remove(i2);
            return aVar.f3825a;
        }

        /* renamed from: a */
        public void mo5373a(C1282a aVar) {
            if (this.f3824b == null) {
                this.f3824b = new ArrayList();
            }
            int size = this.f3824b.size();
            for (int i = 0; i < size; i++) {
                C1282a aVar2 = (C1282a) this.f3824b.get(i);
                if (aVar2.f3825a == aVar.f3825a) {
                    this.f3824b.remove(i);
                }
                if (aVar2.f3825a >= aVar.f3825a) {
                    this.f3824b.add(i, aVar);
                    return;
                }
            }
            this.f3824b.add(aVar);
        }

        /* renamed from: f */
        public C1282a mo5379f(int i) {
            if (this.f3824b == null) {
                return null;
            }
            for (int size = this.f3824b.size() - 1; size >= 0; size--) {
                C1282a aVar = (C1282a) this.f3824b.get(size);
                if (aVar.f3825a == i) {
                    return aVar;
                }
            }
            return null;
        }

        /* renamed from: a */
        public C1282a mo5369a(int i, int i2, int i3, boolean z) {
            if (this.f3824b == null) {
                return null;
            }
            int size = this.f3824b.size();
            for (int i4 = 0; i4 < size; i4++) {
                C1282a aVar = (C1282a) this.f3824b.get(i4);
                if (aVar.f3825a >= i2) {
                    return null;
                }
                if (aVar.f3825a >= i && (i3 == 0 || aVar.f3826b == i3 || (z && aVar.f3828d))) {
                    return aVar;
                }
            }
            return null;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d */
    public static class C1284d implements Parcelable {
        public static final Creator<C1284d> CREATOR = new Creator<C1284d>() {
            /* renamed from: a */
            public C1284d createFromParcel(Parcel parcel) {
                return new C1284d(parcel);
            }

            /* renamed from: a */
            public C1284d[] newArray(int i) {
                return new C1284d[i];
            }
        };

        /* renamed from: a */
        int f3829a;

        /* renamed from: b */
        int f3830b;

        /* renamed from: c */
        int f3831c;

        /* renamed from: d */
        int[] f3832d;

        /* renamed from: e */
        int f3833e;

        /* renamed from: f */
        int[] f3834f;

        /* renamed from: g */
        List<C1282a> f3835g;

        /* renamed from: h */
        boolean f3836h;

        /* renamed from: i */
        boolean f3837i;

        /* renamed from: j */
        boolean f3838j;

        public int describeContents() {
            return 0;
        }

        public C1284d() {
        }

        C1284d(Parcel parcel) {
            this.f3829a = parcel.readInt();
            this.f3830b = parcel.readInt();
            this.f3831c = parcel.readInt();
            if (this.f3831c > 0) {
                this.f3832d = new int[this.f3831c];
                parcel.readIntArray(this.f3832d);
            }
            this.f3833e = parcel.readInt();
            if (this.f3833e > 0) {
                this.f3834f = new int[this.f3833e];
                parcel.readIntArray(this.f3834f);
            }
            boolean z = false;
            this.f3836h = parcel.readInt() == 1;
            this.f3837i = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            this.f3838j = z;
            this.f3835g = parcel.readArrayList(C1282a.class.getClassLoader());
        }

        public C1284d(C1284d dVar) {
            this.f3831c = dVar.f3831c;
            this.f3829a = dVar.f3829a;
            this.f3830b = dVar.f3830b;
            this.f3832d = dVar.f3832d;
            this.f3833e = dVar.f3833e;
            this.f3834f = dVar.f3834f;
            this.f3836h = dVar.f3836h;
            this.f3837i = dVar.f3837i;
            this.f3838j = dVar.f3838j;
            this.f3835g = dVar.f3835g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5388a() {
            this.f3832d = null;
            this.f3831c = 0;
            this.f3833e = 0;
            this.f3834f = null;
            this.f3835g = null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5389b() {
            this.f3832d = null;
            this.f3831c = 0;
            this.f3829a = -1;
            this.f3830b = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3829a);
            parcel.writeInt(this.f3830b);
            parcel.writeInt(this.f3831c);
            if (this.f3831c > 0) {
                parcel.writeIntArray(this.f3832d);
            }
            parcel.writeInt(this.f3833e);
            if (this.f3833e > 0) {
                parcel.writeIntArray(this.f3834f);
            }
            parcel.writeInt(this.f3836h ? 1 : 0);
            parcel.writeInt(this.f3837i ? 1 : 0);
            parcel.writeInt(this.f3838j ? 1 : 0);
            parcel.writeList(this.f3835g);
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$e */
    class C1286e {

        /* renamed from: a */
        ArrayList<View> f3839a = new ArrayList<>();

        /* renamed from: b */
        int f3840b = C1024a.INVALID_ID;

        /* renamed from: c */
        int f3841c = C1024a.INVALID_ID;

        /* renamed from: d */
        int f3842d = 0;

        /* renamed from: e */
        final int f3843e;

        C1286e(int i) {
            this.f3843e = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo5396a(int i) {
            if (this.f3840b != Integer.MIN_VALUE) {
                return this.f3840b;
            }
            if (this.f3839a.size() == 0) {
                return i;
            }
            mo5400a();
            return this.f3840b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5400a() {
            View view = (View) this.f3839a.get(0);
            C1280b c = mo5406c(view);
            this.f3840b = StaggeredGridLayoutManager.this.f3798b.mo5530a(view);
            if (c.f3822b) {
                C1282a f = StaggeredGridLayoutManager.this.f3804h.mo5379f(c.mo5199f());
                if (f != null && f.f3826b == -1) {
                    this.f3840b -= f.mo5380a(this.f3843e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo5403b() {
            if (this.f3840b != Integer.MIN_VALUE) {
                return this.f3840b;
            }
            mo5400a();
            return this.f3840b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo5404b(int i) {
            if (this.f3841c != Integer.MIN_VALUE) {
                return this.f3841c;
            }
            if (this.f3839a.size() == 0) {
                return i;
            }
            mo5407c();
            return this.f3841c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5407c() {
            View view = (View) this.f3839a.get(this.f3839a.size() - 1);
            C1280b c = mo5406c(view);
            this.f3841c = StaggeredGridLayoutManager.this.f3798b.mo5534b(view);
            if (c.f3822b) {
                C1282a f = StaggeredGridLayoutManager.this.f3804h.mo5379f(c.mo5199f());
                if (f != null && f.f3826b == 1) {
                    this.f3841c += f.mo5380a(this.f3843e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo5409d() {
            if (this.f3841c != Integer.MIN_VALUE) {
                return this.f3841c;
            }
            mo5407c();
            return this.f3841c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5401a(View view) {
            C1280b c = mo5406c(view);
            c.f3821a = this;
            this.f3839a.add(0, view);
            this.f3840b = C1024a.INVALID_ID;
            if (this.f3839a.size() == 1) {
                this.f3841c = C1024a.INVALID_ID;
            }
            if (c.mo5197d() || c.mo5198e()) {
                this.f3842d += StaggeredGridLayoutManager.this.f3798b.mo5540e(view);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5405b(View view) {
            C1280b c = mo5406c(view);
            c.f3821a = this;
            this.f3839a.add(view);
            this.f3841c = C1024a.INVALID_ID;
            if (this.f3839a.size() == 1) {
                this.f3840b = C1024a.INVALID_ID;
            }
            if (c.mo5197d() || c.mo5198e()) {
                this.f3842d += StaggeredGridLayoutManager.this.f3798b.mo5540e(view);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5402a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = mo5404b((int) C1024a.INVALID_ID);
            } else {
                i2 = mo5396a((int) C1024a.INVALID_ID);
            }
            mo5411e();
            if (i2 != Integer.MIN_VALUE) {
                if ((!z || i2 >= StaggeredGridLayoutManager.this.f3798b.mo5537d()) && (z || i2 <= StaggeredGridLayoutManager.this.f3798b.mo5535c())) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.f3841c = i2;
                    this.f3840b = i2;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo5411e() {
            this.f3839a.clear();
            mo5412f();
            this.f3842d = 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo5412f() {
            this.f3840b = C1024a.INVALID_ID;
            this.f3841c = C1024a.INVALID_ID;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5408c(int i) {
            this.f3840b = i;
            this.f3841c = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public void mo5413g() {
            int size = this.f3839a.size();
            View view = (View) this.f3839a.remove(size - 1);
            C1280b c = mo5406c(view);
            c.f3821a = null;
            if (c.mo5197d() || c.mo5198e()) {
                this.f3842d -= StaggeredGridLayoutManager.this.f3798b.mo5540e(view);
            }
            if (size == 1) {
                this.f3840b = C1024a.INVALID_ID;
            }
            this.f3841c = C1024a.INVALID_ID;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public void mo5414h() {
            View view = (View) this.f3839a.remove(0);
            C1280b c = mo5406c(view);
            c.f3821a = null;
            if (this.f3839a.size() == 0) {
                this.f3841c = C1024a.INVALID_ID;
            }
            if (c.mo5197d() || c.mo5198e()) {
                this.f3842d -= StaggeredGridLayoutManager.this.f3798b.mo5540e(view);
            }
            this.f3840b = C1024a.INVALID_ID;
        }

        /* renamed from: i */
        public int mo5415i() {
            return this.f3842d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public C1280b mo5406c(View view) {
            return (C1280b) view.getLayoutParams();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo5410d(int i) {
            if (this.f3840b != Integer.MIN_VALUE) {
                this.f3840b += i;
            }
            if (this.f3841c != Integer.MIN_VALUE) {
                this.f3841c += i;
            }
        }

        /* renamed from: j */
        public int mo5416j() {
            if (StaggeredGridLayoutManager.this.f3800d) {
                return mo5397a(this.f3839a.size() - 1, -1, true);
            }
            return mo5397a(0, this.f3839a.size(), true);
        }

        /* renamed from: k */
        public int mo5417k() {
            if (StaggeredGridLayoutManager.this.f3800d) {
                return mo5397a(0, this.f3839a.size(), true);
            }
            return mo5397a(this.f3839a.size() - 1, -1, true);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo5398a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c = StaggeredGridLayoutManager.this.f3798b.mo5535c();
            int d = StaggeredGridLayoutManager.this.f3798b.mo5537d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.f3839a.get(i);
                int a = StaggeredGridLayoutManager.this.f3798b.mo5530a(view);
                int b = StaggeredGridLayoutManager.this.f3798b.mo5534b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a < d : a <= d;
                if (!z3 ? b > c : b >= c) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.mo5152d(view);
                        }
                        if (a < c || b > d) {
                            return StaggeredGridLayoutManager.this.mo5152d(view);
                        }
                    } else if (a >= c && b <= d) {
                        return StaggeredGridLayoutManager.this.mo5152d(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo5397a(int i, int i2, boolean z) {
            return mo5398a(i, i2, false, false, z);
        }

        /* renamed from: a */
        public View mo5399a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f3839a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f3839a.get(size);
                    if ((StaggeredGridLayoutManager.this.f3800d && StaggeredGridLayoutManager.this.mo5152d(view2) >= i) || ((!StaggeredGridLayoutManager.this.f3800d && StaggeredGridLayoutManager.this.mo5152d(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f3839a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = (View) this.f3839a.get(i3);
                    if ((StaggeredGridLayoutManager.this.f3800d && StaggeredGridLayoutManager.this.mo5152d(view3) <= i) || ((!StaggeredGridLayoutManager.this.f3800d && StaggeredGridLayoutManager.this.mo5152d(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        C1258b a = m4784a(context, attributeSet, i, i2);
        mo5348b(a.f3725a);
        mo5343a(a.f3726b);
        mo5346a(a.f3727c);
        this.f3808l = new C1313f();
        m5051M();
    }

    /* renamed from: c */
    public boolean mo4775c() {
        return this.f3810n != 0;
    }

    /* renamed from: M */
    private void m5051M() {
        this.f3798b = C1317i.m5359a(this, this.f3806j);
        this.f3799c = C1317i.m5359a(this, 1 - this.f3806j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo5353g() {
        int i;
        int i2;
        if (mo5186w() == 0 || this.f3810n == 0 || !mo5181r()) {
            return false;
        }
        if (this.f3801e) {
            i2 = mo5360o();
            i = mo5342L();
        } else {
            i2 = mo5342L();
            i = mo5360o();
        }
        if (i2 == 0 && mo5354h() != null) {
            this.f3804h.mo5370a();
            mo5107J();
            mo5179p();
            return true;
        } else if (!this.f3793E) {
            return false;
        } else {
            int i3 = this.f3801e ? -1 : 1;
            int i4 = i + 1;
            C1282a a = this.f3804h.mo5369a(i2, i4, i3, true);
            if (a == null) {
                this.f3793E = false;
                this.f3804h.mo5368a(i4);
                return false;
            }
            C1282a a2 = this.f3804h.mo5369a(i2, a.f3825a, i3 * -1, true);
            if (a2 == null) {
                this.f3804h.mo5368a(a.f3825a);
            } else {
                this.f3804h.mo5368a(a2.f3825a + 1);
            }
            mo5107J();
            mo5179p();
            return true;
        }
    }

    /* renamed from: l */
    public void mo5175l(int i) {
        if (i == 0) {
            mo5353g();
        }
    }

    /* renamed from: a */
    public void mo4765a(RecyclerView recyclerView, C1266p pVar) {
        super.mo4765a(recyclerView, pVar);
        mo5137a(this.f3796H);
        for (int i = 0; i < this.f3805i; i++) {
            this.f3797a[i].mo5411e();
        }
        recyclerView.requestLayout();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo5354h() {
        /*
            r12 = this;
            int r0 = r12.mo5186w()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f3805i
            r2.<init>(r3)
            int r3 = r12.f3805i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f3806j
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.mo5356j()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f3801e
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.mo5169i(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1280b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f3821a
            int r9 = r9.f3843e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f3821a
            boolean r9 = r12.m5065a(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.f3821a
            int r9 = r9.f3843e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f3822b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.mo5169i(r9)
            boolean r10 = r12.f3801e
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.i r10 = r12.f3798b
            int r10 = r10.mo5534b(r7)
            androidx.recyclerview.widget.i r11 = r12.f3798b
            int r11 = r11.mo5534b(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.i r10 = r12.f3798b
            int r10 = r10.mo5530a(r7)
            androidx.recyclerview.widget.i r11 = r12.f3798b
            int r11 = r11.mo5530a(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1280b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r8 = r8.f3821a
            int r8 = r8.f3843e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r9.f3821a
            int r9 = r9.f3843e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.mo5354h():android.view.View");
    }

    /* renamed from: a */
    private boolean m5065a(C1286e eVar) {
        if (this.f3801e) {
            if (eVar.mo5409d() < this.f3798b.mo5537d()) {
                return !eVar.mo5406c((View) eVar.f3839a.get(eVar.f3839a.size() - 1)).f3822b;
            }
        } else if (eVar.mo5403b() > this.f3798b.mo5535c()) {
            return !eVar.mo5406c((View) eVar.f3839a.get(0)).f3822b;
        }
        return false;
    }

    /* renamed from: a */
    public void mo5343a(int i) {
        mo4767a((String) null);
        if (i != this.f3805i) {
            mo5355i();
            this.f3805i = i;
            this.f3809m = new BitSet(this.f3805i);
            this.f3797a = new C1286e[this.f3805i];
            for (int i2 = 0; i2 < this.f3805i; i2++) {
                this.f3797a[i2] = new C1286e(i2);
            }
            mo5179p();
        }
    }

    /* renamed from: b */
    public void mo5348b(int i) {
        if (i == 0 || i == 1) {
            mo4767a((String) null);
            if (i != this.f3806j) {
                this.f3806j = i;
                C1317i iVar = this.f3798b;
                this.f3798b = this.f3799c;
                this.f3799c = iVar;
                mo5179p();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    /* renamed from: a */
    public void mo5346a(boolean z) {
        mo4767a((String) null);
        if (!(this.f3789A == null || this.f3789A.f3836h == z)) {
            this.f3789A.f3836h = z;
        }
        this.f3800d = z;
        mo5179p();
    }

    /* renamed from: a */
    public void mo4767a(String str) {
        if (this.f3789A == null) {
            super.mo4767a(str);
        }
    }

    /* renamed from: i */
    public void mo5355i() {
        this.f3804h.mo5370a();
        mo5179p();
    }

    /* renamed from: N */
    private void m5052N() {
        if (this.f3806j == 1 || !mo5356j()) {
            this.f3801e = this.f3800d;
        } else {
            this.f3801e = !this.f3800d;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo5356j() {
        return mo5184u() == 1;
    }

    /* renamed from: a */
    public void mo4734a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int B = mo5099B() + mo5101D();
        int C = mo5100C() + mo5102E();
        if (this.f3806j == 1) {
            i4 = m4782a(i2, rect.height() + C, mo5105H());
            i3 = m4782a(i, (this.f3807k * this.f3805i) + B, mo5104G());
        } else {
            i3 = m4782a(i, rect.width() + B, mo5104G());
            i4 = m4782a(i2, (this.f3807k * this.f3805i) + C, mo5105H());
        }
        mo5162f(i3, i4);
    }

    /* renamed from: c */
    public void mo4750c(C1266p pVar, C1274u uVar) {
        m5061a(pVar, uVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0163, code lost:
        if (mo5353g() != false) goto L_0x0167;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5061a(androidx.recyclerview.widget.RecyclerView.C1266p r9, androidx.recyclerview.widget.RecyclerView.C1274u r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r0 = r8.f3792D
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r1 = r8.f3789A
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f3802f
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.mo5291e()
            if (r1 != 0) goto L_0x0018
            r8.mo5149c(r9)
            r0.mo5362a()
            return
        L_0x0018:
            boolean r1 = r0.f3818e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f3802f
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r1 = r8.f3789A
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.mo5362a()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f3789A
            if (r5 == 0) goto L_0x0037
            r8.m5063a(r0)
            goto L_0x003e
        L_0x0037:
            r8.m5052N()
            boolean r5 = r8.f3801e
            r0.f3816c = r5
        L_0x003e:
            r8.mo5345a(r10, r0)
            r0.f3818e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f3789A
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f3802f
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f3816c
            boolean r6 = r8.f3811o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.mo5356j()
            boolean r6 = r8.f3812z
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r5 = r8.f3804h
            r5.mo5370a()
            r0.f3817d = r4
        L_0x0060:
            int r5 = r8.mo5186w()
            if (r5 <= 0) goto L_0x00cd
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f3789A
            if (r5 == 0) goto L_0x0070
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f3789A
            int r5 = r5.f3831c
            if (r5 >= r4) goto L_0x00cd
        L_0x0070:
            boolean r5 = r0.f3817d
            if (r5 == 0) goto L_0x0092
            r1 = 0
        L_0x0075:
            int r5 = r8.f3805i
            if (r1 >= r5) goto L_0x00cd
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3797a
            r5 = r5[r1]
            r5.mo5411e()
            int r5 = r0.f3815b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3797a
            r5 = r5[r1]
            int r6 = r0.f3815b
            r5.mo5408c(r6)
        L_0x008f:
            int r1 = r1 + 1
            goto L_0x0075
        L_0x0092:
            if (r1 != 0) goto L_0x00b3
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.f3792D
            int[] r1 = r1.f3819f
            if (r1 != 0) goto L_0x009b
            goto L_0x00b3
        L_0x009b:
            r1 = 0
        L_0x009c:
            int r5 = r8.f3805i
            if (r1 >= r5) goto L_0x00cd
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3797a
            r5 = r5[r1]
            r5.mo5411e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r6 = r8.f3792D
            int[] r6 = r6.f3819f
            r6 = r6[r1]
            r5.mo5408c(r6)
            int r1 = r1 + 1
            goto L_0x009c
        L_0x00b3:
            r1 = 0
        L_0x00b4:
            int r5 = r8.f3805i
            if (r1 >= r5) goto L_0x00c6
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3797a
            r5 = r5[r1]
            boolean r6 = r8.f3801e
            int r7 = r0.f3815b
            r5.mo5402a(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b4
        L_0x00c6:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.f3792D
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.f3797a
            r1.mo5364a(r5)
        L_0x00cd:
            r8.mo5121a(r9)
            androidx.recyclerview.widget.f r1 = r8.f3808l
            r1.f3964a = r3
            r8.f3793E = r3
            androidx.recyclerview.widget.i r1 = r8.f3799c
            int r1 = r1.mo5541f()
            r8.mo5352f(r1)
            int r1 = r0.f3814a
            r8.m5068b(r1, r10)
            boolean r1 = r0.f3816c
            if (r1 == 0) goto L_0x0104
            r8.m5076m(r2)
            androidx.recyclerview.widget.f r1 = r8.f3808l
            r8.m5054a(r9, r1, r10)
            r8.m5076m(r4)
            androidx.recyclerview.widget.f r1 = r8.f3808l
            int r2 = r0.f3814a
            androidx.recyclerview.widget.f r5 = r8.f3808l
            int r5 = r5.f3967d
            int r2 = r2 + r5
            r1.f3966c = r2
            androidx.recyclerview.widget.f r1 = r8.f3808l
            r8.m5054a(r9, r1, r10)
            goto L_0x011f
        L_0x0104:
            r8.m5076m(r4)
            androidx.recyclerview.widget.f r1 = r8.f3808l
            r8.m5054a(r9, r1, r10)
            r8.m5076m(r2)
            androidx.recyclerview.widget.f r1 = r8.f3808l
            int r2 = r0.f3814a
            androidx.recyclerview.widget.f r5 = r8.f3808l
            int r5 = r5.f3967d
            int r2 = r2 + r5
            r1.f3966c = r2
            androidx.recyclerview.widget.f r1 = r8.f3808l
            r8.m5054a(r9, r1, r10)
        L_0x011f:
            r8.m5053O()
            int r1 = r8.mo5186w()
            if (r1 <= 0) goto L_0x0139
            boolean r1 = r8.f3801e
            if (r1 == 0) goto L_0x0133
            r8.m5070b(r9, r10, r4)
            r8.m5072c(r9, r10, r3)
            goto L_0x0139
        L_0x0133:
            r8.m5072c(r9, r10, r4)
            r8.m5070b(r9, r10, r3)
        L_0x0139:
            if (r11 == 0) goto L_0x0166
            boolean r11 = r10.mo5287a()
            if (r11 != 0) goto L_0x0166
            int r11 = r8.f3810n
            if (r11 == 0) goto L_0x0157
            int r11 = r8.mo5186w()
            if (r11 <= 0) goto L_0x0157
            boolean r11 = r8.f3793E
            if (r11 != 0) goto L_0x0155
            android.view.View r11 = r8.mo5354h()
            if (r11 == 0) goto L_0x0157
        L_0x0155:
            r11 = 1
            goto L_0x0158
        L_0x0157:
            r11 = 0
        L_0x0158:
            if (r11 == 0) goto L_0x0166
            java.lang.Runnable r11 = r8.f3796H
            r8.mo5137a(r11)
            boolean r11 = r8.mo5353g()
            if (r11 == 0) goto L_0x0166
            goto L_0x0167
        L_0x0166:
            r4 = 0
        L_0x0167:
            boolean r11 = r10.mo5287a()
            if (r11 == 0) goto L_0x0172
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.f3792D
            r11.mo5362a()
        L_0x0172:
            boolean r11 = r0.f3816c
            r8.f3811o = r11
            boolean r11 = r8.mo5356j()
            r8.f3812z = r11
            if (r4 == 0) goto L_0x0186
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.f3792D
            r11.mo5362a()
            r8.m5061a(r9, r10, r3)
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m5061a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, boolean):void");
    }

    /* renamed from: a */
    public void mo4738a(C1274u uVar) {
        super.mo4738a(uVar);
        this.f3802f = -1;
        this.f3803g = C1024a.INVALID_ID;
        this.f3789A = null;
        this.f3792D.mo5362a();
    }

    /* renamed from: O */
    private void m5053O() {
        if (this.f3799c.mo5544h() != 1073741824) {
            int w = mo5186w();
            float f = BitmapDescriptorFactory.HUE_RED;
            for (int i = 0; i < w; i++) {
                View i2 = mo5169i(i);
                float e = (float) this.f3799c.mo5540e(i2);
                if (e >= f) {
                    if (((C1280b) i2.getLayoutParams()).mo5366a()) {
                        e = (e * 1.0f) / ((float) this.f3805i);
                    }
                    f = Math.max(f, e);
                }
            }
            int i3 = this.f3807k;
            int round = Math.round(f * ((float) this.f3805i));
            if (this.f3799c.mo5544h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f3799c.mo5541f());
            }
            mo5352f(round);
            if (this.f3807k != i3) {
                for (int i4 = 0; i4 < w; i4++) {
                    View i5 = mo5169i(i4);
                    C1280b bVar = (C1280b) i5.getLayoutParams();
                    if (!bVar.f3822b) {
                        if (!mo5356j() || this.f3806j != 1) {
                            int i6 = bVar.f3821a.f3843e * this.f3807k;
                            int i7 = bVar.f3821a.f3843e * i3;
                            if (this.f3806j == 1) {
                                i5.offsetLeftAndRight(i6 - i7);
                            } else {
                                i5.offsetTopAndBottom(i6 - i7);
                            }
                        } else {
                            i5.offsetLeftAndRight(((-((this.f3805i - 1) - bVar.f3821a.f3843e)) * this.f3807k) - ((-((this.f3805i - 1) - bVar.f3821a.f3843e)) * i3));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m5063a(C1279a aVar) {
        if (this.f3789A.f3831c > 0) {
            if (this.f3789A.f3831c == this.f3805i) {
                for (int i = 0; i < this.f3805i; i++) {
                    this.f3797a[i].mo5411e();
                    int i2 = this.f3789A.f3832d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f3789A.f3837i) {
                            i2 += this.f3798b.mo5537d();
                        } else {
                            i2 += this.f3798b.mo5535c();
                        }
                    }
                    this.f3797a[i].mo5408c(i2);
                }
            } else {
                this.f3789A.mo5388a();
                this.f3789A.f3829a = this.f3789A.f3830b;
            }
        }
        this.f3812z = this.f3789A.f3838j;
        mo5346a(this.f3789A.f3836h);
        m5052N();
        if (this.f3789A.f3829a != -1) {
            this.f3802f = this.f3789A.f3829a;
            aVar.f3816c = this.f3789A.f3837i;
        } else {
            aVar.f3816c = this.f3801e;
        }
        if (this.f3789A.f3833e > 1) {
            this.f3804h.f3823a = this.f3789A.f3834f;
            this.f3804h.f3824b = this.f3789A.f3835g;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5345a(C1274u uVar, C1279a aVar) {
        if (!mo5349b(uVar, aVar) && !m5073c(uVar, aVar)) {
            aVar.mo5365b();
            aVar.f3814a = 0;
        }
    }

    /* renamed from: c */
    private boolean m5073c(C1274u uVar, C1279a aVar) {
        int i;
        if (this.f3811o) {
            i = m5088w(uVar.mo5291e());
        } else {
            i = m5087v(uVar.mo5291e());
        }
        aVar.f3814a = i;
        aVar.f3815b = C1024a.INVALID_ID;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo5349b(C1274u uVar, C1279a aVar) {
        int i;
        int i2;
        boolean z = false;
        if (uVar.mo5287a() || this.f3802f == -1) {
            return false;
        }
        if (this.f3802f < 0 || this.f3802f >= uVar.mo5291e()) {
            this.f3802f = -1;
            this.f3803g = C1024a.INVALID_ID;
            return false;
        }
        if (this.f3789A == null || this.f3789A.f3829a == -1 || this.f3789A.f3831c < 1) {
            View c = mo4774c(this.f3802f);
            if (c != null) {
                if (this.f3801e) {
                    i = mo5360o();
                } else {
                    i = mo5342L();
                }
                aVar.f3814a = i;
                if (this.f3803g != Integer.MIN_VALUE) {
                    if (aVar.f3816c) {
                        aVar.f3815b = (this.f3798b.mo5537d() - this.f3803g) - this.f3798b.mo5534b(c);
                    } else {
                        aVar.f3815b = (this.f3798b.mo5535c() + this.f3803g) - this.f3798b.mo5530a(c);
                    }
                    return true;
                } else if (this.f3798b.mo5540e(c) > this.f3798b.mo5541f()) {
                    if (aVar.f3816c) {
                        i2 = this.f3798b.mo5537d();
                    } else {
                        i2 = this.f3798b.mo5535c();
                    }
                    aVar.f3815b = i2;
                    return true;
                } else {
                    int a = this.f3798b.mo5530a(c) - this.f3798b.mo5535c();
                    if (a < 0) {
                        aVar.f3815b = -a;
                        return true;
                    }
                    int d = this.f3798b.mo5537d() - this.f3798b.mo5534b(c);
                    if (d < 0) {
                        aVar.f3815b = d;
                        return true;
                    }
                    aVar.f3815b = C1024a.INVALID_ID;
                }
            } else {
                aVar.f3814a = this.f3802f;
                if (this.f3803g == Integer.MIN_VALUE) {
                    if (m5086u(aVar.f3814a) == 1) {
                        z = true;
                    }
                    aVar.f3816c = z;
                    aVar.mo5365b();
                } else {
                    aVar.mo5363a(this.f3803g);
                }
                aVar.f3817d = true;
            }
        } else {
            aVar.f3815b = C1024a.INVALID_ID;
            aVar.f3814a = this.f3802f;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo5352f(int i) {
        this.f3807k = i / this.f3805i;
        this.f3790B = MeasureSpec.makeMeasureSpec(i, this.f3799c.mo5544h());
    }

    /* renamed from: b */
    public boolean mo4749b() {
        return this.f3789A == null;
    }

    /* renamed from: c */
    public int mo4773c(C1274u uVar) {
        return m5067b(uVar);
    }

    /* renamed from: b */
    private int m5067b(C1274u uVar) {
        if (mo5186w() == 0) {
            return 0;
        }
        return C1322k.m5406a(uVar, this.f3798b, mo5347b(!this.f3794F), mo5351c(!this.f3794F), this, this.f3794F, this.f3801e);
    }

    /* renamed from: d */
    public int mo4776d(C1274u uVar) {
        return m5067b(uVar);
    }

    /* renamed from: e */
    public int mo4779e(C1274u uVar) {
        return m5074i(uVar);
    }

    /* renamed from: i */
    private int m5074i(C1274u uVar) {
        if (mo5186w() == 0) {
            return 0;
        }
        return C1322k.m5405a(uVar, this.f3798b, mo5347b(!this.f3794F), mo5351c(!this.f3794F), this, this.f3794F);
    }

    /* renamed from: f */
    public int mo4783f(C1274u uVar) {
        return m5074i(uVar);
    }

    /* renamed from: g */
    public int mo4786g(C1274u uVar) {
        return m5075j(uVar);
    }

    /* renamed from: j */
    private int m5075j(C1274u uVar) {
        if (mo5186w() == 0) {
            return 0;
        }
        return C1322k.m5407b(uVar, this.f3798b, mo5347b(!this.f3794F), mo5351c(!this.f3794F), this, this.f3794F);
    }

    /* renamed from: h */
    public int mo4787h(C1274u uVar) {
        return m5075j(uVar);
    }

    /* renamed from: a */
    private void m5059a(View view, C1280b bVar, boolean z) {
        if (bVar.f3822b) {
            if (this.f3806j == 1) {
                m5057a(view, this.f3790B, m4783a(mo5098A(), mo5188y(), mo5100C() + mo5102E(), bVar.height, true), z);
            } else {
                m5057a(view, m4783a(mo5189z(), mo5187x(), mo5099B() + mo5101D(), bVar.width, true), this.f3790B, z);
            }
        } else if (this.f3806j == 1) {
            m5057a(view, m4783a(this.f3807k, mo5187x(), 0, bVar.width, false), m4783a(mo5098A(), mo5188y(), mo5100C() + mo5102E(), bVar.height, true), z);
        } else {
            m5057a(view, m4783a(mo5189z(), mo5187x(), mo5099B() + mo5101D(), bVar.width, true), m4783a(this.f3807k, mo5188y(), 0, bVar.height, false), z);
        }
    }

    /* renamed from: a */
    private void m5057a(View view, int i, int i2, boolean z) {
        boolean z2;
        mo5140b(view, this.f3791C);
        C1280b bVar = (C1280b) view.getLayoutParams();
        int b = m5066b(i, bVar.leftMargin + this.f3791C.left, bVar.rightMargin + this.f3791C.right);
        int b2 = m5066b(i2, bVar.topMargin + this.f3791C.top, bVar.bottomMargin + this.f3791C.bottom);
        if (z) {
            z2 = mo5127a(view, b, b2, (C1259j) bVar);
        } else {
            z2 = mo5145b(view, b, b2, (C1259j) bVar);
        }
        if (z2) {
            view.measure(b, b2);
        }
    }

    /* renamed from: b */
    private int m5066b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    /* renamed from: a */
    public void mo4763a(Parcelable parcelable) {
        if (parcelable instanceof C1284d) {
            this.f3789A = (C1284d) parcelable;
            mo5179p();
        }
    }

    /* renamed from: d */
    public Parcelable mo4778d() {
        int i;
        int i2;
        if (this.f3789A != null) {
            return new C1284d(this.f3789A);
        }
        C1284d dVar = new C1284d();
        dVar.f3836h = this.f3800d;
        dVar.f3837i = this.f3811o;
        dVar.f3838j = this.f3812z;
        if (this.f3804h == null || this.f3804h.f3823a == null) {
            dVar.f3833e = 0;
        } else {
            dVar.f3834f = this.f3804h.f3823a;
            dVar.f3833e = dVar.f3834f.length;
            dVar.f3835g = this.f3804h.f3824b;
        }
        if (mo5186w() > 0) {
            if (this.f3811o) {
                i = mo5360o();
            } else {
                i = mo5342L();
            }
            dVar.f3829a = i;
            dVar.f3830b = mo5357k();
            dVar.f3831c = this.f3805i;
            dVar.f3832d = new int[this.f3805i];
            for (int i3 = 0; i3 < this.f3805i; i3++) {
                if (this.f3811o) {
                    i2 = this.f3797a[i3].mo5404b((int) C1024a.INVALID_ID);
                    if (i2 != Integer.MIN_VALUE) {
                        i2 -= this.f3798b.mo5537d();
                    }
                } else {
                    i2 = this.f3797a[i3].mo5396a((int) C1024a.INVALID_ID);
                    if (i2 != Integer.MIN_VALUE) {
                        i2 -= this.f3798b.mo5535c();
                    }
                }
                dVar.f3832d[i3] = i2;
            }
        } else {
            dVar.f3829a = -1;
            dVar.f3830b = -1;
            dVar.f3831c = 0;
        }
        return dVar;
    }

    /* renamed from: a */
    public void mo4735a(C1266p pVar, C1274u uVar, View view, C0935b bVar) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C1280b)) {
            super.mo5116a(view, bVar);
            return;
        }
        C1280b bVar2 = (C1280b) layoutParams;
        if (this.f3806j == 0) {
            bVar.mo3680b((Object) C0938c.m3471a(bVar2.mo5367b(), bVar2.f3822b ? this.f3805i : 1, -1, -1, bVar2.f3822b, false));
        } else {
            bVar.mo3680b((Object) C0938c.m3471a(-1, -1, bVar2.mo5367b(), bVar2.f3822b ? this.f3805i : 1, bVar2.f3822b, false));
        }
    }

    /* renamed from: a */
    public void mo4764a(AccessibilityEvent accessibilityEvent) {
        super.mo4764a(accessibilityEvent);
        if (mo5186w() > 0) {
            View b = mo5347b(false);
            View c = mo5351c(false);
            if (b != null && c != null) {
                int d = mo5152d(b);
                int d2 = mo5152d(c);
                if (d < d2) {
                    accessibilityEvent.setFromIndex(d);
                    accessibilityEvent.setToIndex(d2);
                } else {
                    accessibilityEvent.setFromIndex(d2);
                    accessibilityEvent.setToIndex(d);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public int mo5357k() {
        View view;
        if (this.f3801e) {
            view = mo5351c(true);
        } else {
            view = mo5347b(true);
        }
        if (view == null) {
            return -1;
        }
        return mo5152d(view);
    }

    /* renamed from: a */
    public int mo4727a(C1266p pVar, C1274u uVar) {
        if (this.f3806j == 0) {
            return this.f3805i;
        }
        return super.mo4727a(pVar, uVar);
    }

    /* renamed from: b */
    public int mo4747b(C1266p pVar, C1274u uVar) {
        if (this.f3806j == 1) {
            return this.f3805i;
        }
        return super.mo4747b(pVar, uVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public View mo5347b(boolean z) {
        int c = this.f3798b.mo5535c();
        int d = this.f3798b.mo5537d();
        int w = mo5186w();
        View view = null;
        for (int i = 0; i < w; i++) {
            View i2 = mo5169i(i);
            int a = this.f3798b.mo5530a(i2);
            if (this.f3798b.mo5534b(i2) > c && a < d) {
                if (a >= c || !z) {
                    return i2;
                }
                if (view == null) {
                    view = i2;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public View mo5351c(boolean z) {
        int c = this.f3798b.mo5535c();
        int d = this.f3798b.mo5537d();
        View view = null;
        for (int w = mo5186w() - 1; w >= 0; w--) {
            View i = mo5169i(w);
            int a = this.f3798b.mo5530a(i);
            int b = this.f3798b.mo5534b(i);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return i;
                }
                if (view == null) {
                    view = i;
                }
            }
        }
        return view;
    }

    /* renamed from: b */
    private void m5070b(C1266p pVar, C1274u uVar, boolean z) {
        int r = m5083r(C1024a.INVALID_ID);
        if (r != Integer.MIN_VALUE) {
            int d = this.f3798b.mo5537d() - r;
            if (d > 0) {
                int i = d - (-mo5350c(-d, pVar, uVar));
                if (z && i > 0) {
                    this.f3798b.mo5532a(i);
                }
            }
        }
    }

    /* renamed from: c */
    private void m5072c(C1266p pVar, C1274u uVar, boolean z) {
        int q = m5081q((int) BaseClientBuilder.API_PRIORITY_OTHER);
        if (q != Integer.MAX_VALUE) {
            int c = q - this.f3798b.mo5535c();
            if (c > 0) {
                int c2 = c - mo5350c(c, pVar, uVar);
                if (z && c2 > 0) {
                    this.f3798b.mo5532a(-c2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5068b(int r5, androidx.recyclerview.widget.RecyclerView.C1274u r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.f r0 = r4.f3808l
            r1 = 0
            r0.f3965b = r1
            androidx.recyclerview.widget.f r0 = r4.f3808l
            r0.f3966c = r5
            boolean r0 = r4.mo5183t()
            r2 = 1
            if (r0 == 0) goto L_0x0030
            int r6 = r6.mo5289c()
            r0 = -1
            if (r6 == r0) goto L_0x0030
            boolean r0 = r4.f3801e
            if (r6 >= r5) goto L_0x001d
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            if (r0 != r5) goto L_0x0029
            androidx.recyclerview.widget.i r5 = r4.f3798b
            int r5 = r5.mo5541f()
            r6 = r5
            r5 = 0
            goto L_0x0032
        L_0x0029:
            androidx.recyclerview.widget.i r5 = r4.f3798b
            int r5 = r5.mo5541f()
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            r6 = 0
        L_0x0032:
            boolean r0 = r4.mo5182s()
            if (r0 == 0) goto L_0x004f
            androidx.recyclerview.widget.f r0 = r4.f3808l
            androidx.recyclerview.widget.i r3 = r4.f3798b
            int r3 = r3.mo5535c()
            int r3 = r3 - r5
            r0.f3969f = r3
            androidx.recyclerview.widget.f r5 = r4.f3808l
            androidx.recyclerview.widget.i r0 = r4.f3798b
            int r0 = r0.mo5537d()
            int r0 = r0 + r6
            r5.f3970g = r0
            goto L_0x005f
        L_0x004f:
            androidx.recyclerview.widget.f r0 = r4.f3808l
            androidx.recyclerview.widget.i r3 = r4.f3798b
            int r3 = r3.mo5539e()
            int r3 = r3 + r6
            r0.f3970g = r3
            androidx.recyclerview.widget.f r6 = r4.f3808l
            int r5 = -r5
            r6.f3969f = r5
        L_0x005f:
            androidx.recyclerview.widget.f r5 = r4.f3808l
            r5.f3971h = r1
            androidx.recyclerview.widget.f r5 = r4.f3808l
            r5.f3964a = r2
            androidx.recyclerview.widget.f r5 = r4.f3808l
            androidx.recyclerview.widget.i r6 = r4.f3798b
            int r6 = r6.mo5544h()
            if (r6 != 0) goto L_0x007a
            androidx.recyclerview.widget.i r6 = r4.f3798b
            int r6 = r6.mo5539e()
            if (r6 != 0) goto L_0x007a
            r1 = 1
        L_0x007a:
            r5.f3972i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m5068b(int, androidx.recyclerview.widget.RecyclerView$u):void");
    }

    /* renamed from: m */
    private void m5076m(int i) {
        this.f3808l.f3968e = i;
        C1313f fVar = this.f3808l;
        int i2 = 1;
        if (this.f3801e != (i == -1)) {
            i2 = -1;
        }
        fVar.f3967d = i2;
    }

    /* renamed from: j */
    public void mo5171j(int i) {
        super.mo5171j(i);
        for (int i2 = 0; i2 < this.f3805i; i2++) {
            this.f3797a[i2].mo5410d(i);
        }
    }

    /* renamed from: k */
    public void mo5173k(int i) {
        super.mo5173k(i);
        for (int i2 = 0; i2 < this.f3805i; i2++) {
            this.f3797a[i2].mo5410d(i);
        }
    }

    /* renamed from: b */
    public void mo4748b(RecyclerView recyclerView, int i, int i2) {
        m5071c(i, i2, 2);
    }

    /* renamed from: a */
    public void mo4741a(RecyclerView recyclerView, int i, int i2) {
        m5071c(i, i2, 1);
    }

    /* renamed from: a */
    public void mo4740a(RecyclerView recyclerView) {
        this.f3804h.mo5370a();
        mo5179p();
    }

    /* renamed from: a */
    public void mo4742a(RecyclerView recyclerView, int i, int i2, int i3) {
        m5071c(i, i2, 8);
    }

    /* renamed from: a */
    public void mo4743a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m5071c(i, i2, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5071c(int r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r5.f3801e
            if (r0 == 0) goto L_0x0009
            int r0 = r5.mo5360o()
            goto L_0x000d
        L_0x0009:
            int r0 = r5.mo5342L()
        L_0x000d:
            r1 = 8
            if (r8 != r1) goto L_0x001b
            if (r6 >= r7) goto L_0x0016
            int r2 = r7 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r6 + 1
            r3 = r2
            r2 = r7
            goto L_0x001f
        L_0x001b:
            int r2 = r6 + r7
        L_0x001d:
            r3 = r2
            r2 = r6
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r4 = r5.f3804h
            r4.mo5374b(r2)
            if (r8 == r1) goto L_0x0036
            switch(r8) {
                case 1: goto L_0x0030;
                case 2: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0041
        L_0x002a:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.f3804h
            r8.mo5371a(r6, r7)
            goto L_0x0041
        L_0x0030:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.f3804h
            r8.mo5375b(r6, r7)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r5.f3804h
            r1 = 1
            r8.mo5371a(r6, r1)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r6 = r5.f3804h
            r6.mo5375b(r7, r1)
        L_0x0041:
            if (r3 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r6 = r5.f3801e
            if (r6 == 0) goto L_0x004d
            int r6 = r5.mo5342L()
            goto L_0x0051
        L_0x004d:
            int r6 = r5.mo5360o()
        L_0x0051:
            if (r2 > r6) goto L_0x0056
            r5.mo5179p()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m5071c(int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v1, types: [boolean, int]
      assigns: []
      uses: [boolean, int, ?[int, short, byte, char]]
      mth insns count: 222
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m5054a(androidx.recyclerview.widget.RecyclerView.C1266p r17, androidx.recyclerview.widget.C1313f r18, androidx.recyclerview.widget.RecyclerView.C1274u r19) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            r8 = r18
            java.util.BitSet r0 = r6.f3809m
            int r1 = r6.f3805i
            r9 = 0
            r10 = 1
            r0.set(r9, r1, r10)
            androidx.recyclerview.widget.f r0 = r6.f3808l
            boolean r0 = r0.f3972i
            if (r0 == 0) goto L_0x0025
            int r0 = r8.f3968e
            if (r0 != r10) goto L_0x0020
            r0 = 2147483647(0x7fffffff, float:NaN)
            r11 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0036
        L_0x0020:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0036
        L_0x0025:
            int r0 = r8.f3968e
            if (r0 != r10) goto L_0x0030
            int r0 = r8.f3970g
            int r1 = r8.f3965b
            int r0 = r0 + r1
        L_0x002e:
            r11 = r0
            goto L_0x0036
        L_0x0030:
            int r0 = r8.f3969f
            int r1 = r8.f3965b
            int r0 = r0 - r1
            goto L_0x002e
        L_0x0036:
            int r0 = r8.f3968e
            r6.m5056a(r0, r11)
            boolean r0 = r6.f3801e
            if (r0 == 0) goto L_0x0047
            androidx.recyclerview.widget.i r0 = r6.f3798b
            int r0 = r0.mo5537d()
        L_0x0045:
            r12 = r0
            goto L_0x004e
        L_0x0047:
            androidx.recyclerview.widget.i r0 = r6.f3798b
            int r0 = r0.mo5535c()
            goto L_0x0045
        L_0x004e:
            r0 = 0
        L_0x004f:
            boolean r1 = r18.mo5516a(r19)
            r2 = -1
            if (r1 == 0) goto L_0x01d1
            androidx.recyclerview.widget.f r1 = r6.f3808l
            boolean r1 = r1.f3972i
            if (r1 != 0) goto L_0x0064
            java.util.BitSet r1 = r6.f3809m
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x01d1
        L_0x0064:
            android.view.View r13 = r8.mo5515a(r7)
            android.view.ViewGroup$LayoutParams r0 = r13.getLayoutParams()
            r14 = r0
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r14 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1280b) r14
            int r0 = r14.mo5199f()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r1 = r6.f3804h
            int r1 = r1.mo5376c(r0)
            if (r1 != r2) goto L_0x007d
            r3 = 1
            goto L_0x007e
        L_0x007d:
            r3 = 0
        L_0x007e:
            if (r3 == 0) goto L_0x0093
            boolean r1 = r14.f3822b
            if (r1 == 0) goto L_0x0089
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r1 = r6.f3797a
            r1 = r1[r9]
            goto L_0x008d
        L_0x0089:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r1 = r6.m5055a(r8)
        L_0x008d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r4 = r6.f3804h
            r4.mo5372a(r0, r1)
            goto L_0x0097
        L_0x0093:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r4 = r6.f3797a
            r1 = r4[r1]
        L_0x0097:
            r15 = r1
            r14.f3821a = r15
            int r1 = r8.f3968e
            if (r1 != r10) goto L_0x00a2
            r6.mo5138b(r13)
            goto L_0x00a5
        L_0x00a2:
            r6.mo5139b(r13, r9)
        L_0x00a5:
            r6.m5059a(r13, r14, r9)
            int r1 = r8.f3968e
            if (r1 != r10) goto L_0x00d6
            boolean r1 = r14.f3822b
            if (r1 == 0) goto L_0x00b5
            int r1 = r6.m5083r(r12)
            goto L_0x00b9
        L_0x00b5:
            int r1 = r15.mo5404b(r12)
        L_0x00b9:
            androidx.recyclerview.widget.i r4 = r6.f3798b
            int r4 = r4.mo5540e(r13)
            int r4 = r4 + r1
            if (r3 == 0) goto L_0x00d3
            boolean r5 = r14.f3822b
            if (r5 == 0) goto L_0x00d3
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a r5 = r6.m5077n(r1)
            r5.f3826b = r2
            r5.f3825a = r0
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.f3804h
            r9.mo5373a(r5)
        L_0x00d3:
            r5 = r4
            r4 = r1
            goto L_0x00ff
        L_0x00d6:
            boolean r1 = r14.f3822b
            if (r1 == 0) goto L_0x00df
            int r1 = r6.m5081q(r12)
            goto L_0x00e3
        L_0x00df:
            int r1 = r15.mo5396a(r12)
        L_0x00e3:
            androidx.recyclerview.widget.i r4 = r6.f3798b
            int r4 = r4.mo5540e(r13)
            int r4 = r1 - r4
            if (r3 == 0) goto L_0x00fe
            boolean r5 = r14.f3822b
            if (r5 == 0) goto L_0x00fe
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a r5 = r6.m5078o(r1)
            r5.f3826b = r10
            r5.f3825a = r0
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.f3804h
            r9.mo5373a(r5)
        L_0x00fe:
            r5 = r1
        L_0x00ff:
            boolean r1 = r14.f3822b
            if (r1 == 0) goto L_0x0129
            int r1 = r8.f3967d
            if (r1 != r2) goto L_0x0129
            if (r3 == 0) goto L_0x010c
            r6.f3793E = r10
            goto L_0x0129
        L_0x010c:
            int r1 = r8.f3968e
            if (r1 != r10) goto L_0x0116
            boolean r1 = r16.mo5358m()
        L_0x0114:
            r1 = r1 ^ r10
            goto L_0x011b
        L_0x0116:
            boolean r1 = r16.mo5359n()
            goto L_0x0114
        L_0x011b:
            if (r1 == 0) goto L_0x0129
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r1 = r6.f3804h
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c$a r0 = r1.mo5379f(r0)
            if (r0 == 0) goto L_0x0127
            r0.f3828d = r10
        L_0x0127:
            r6.f3793E = r10
        L_0x0129:
            r6.m5058a(r13, r14, r8)
            boolean r0 = r16.mo5356j()
            if (r0 == 0) goto L_0x015d
            int r0 = r6.f3806j
            if (r0 != r10) goto L_0x015d
            boolean r0 = r14.f3822b
            if (r0 == 0) goto L_0x0141
            androidx.recyclerview.widget.i r0 = r6.f3799c
            int r0 = r0.mo5537d()
            goto L_0x0152
        L_0x0141:
            androidx.recyclerview.widget.i r0 = r6.f3799c
            int r0 = r0.mo5537d()
            int r1 = r6.f3805i
            int r1 = r1 - r10
            int r2 = r15.f3843e
            int r1 = r1 - r2
            int r2 = r6.f3807k
            int r1 = r1 * r2
            int r0 = r0 - r1
        L_0x0152:
            androidx.recyclerview.widget.i r1 = r6.f3799c
            int r1 = r1.mo5540e(r13)
            int r1 = r0 - r1
            r9 = r0
            r3 = r1
            goto L_0x017e
        L_0x015d:
            boolean r0 = r14.f3822b
            if (r0 == 0) goto L_0x0168
            androidx.recyclerview.widget.i r0 = r6.f3799c
            int r0 = r0.mo5535c()
            goto L_0x0175
        L_0x0168:
            int r0 = r15.f3843e
            int r1 = r6.f3807k
            int r0 = r0 * r1
            androidx.recyclerview.widget.i r1 = r6.f3799c
            int r1 = r1.mo5535c()
            int r0 = r0 + r1
        L_0x0175:
            androidx.recyclerview.widget.i r1 = r6.f3799c
            int r1 = r1.mo5540e(r13)
            int r1 = r1 + r0
            r3 = r0
            r9 = r1
        L_0x017e:
            int r0 = r6.f3806j
            if (r0 != r10) goto L_0x018c
            r0 = r16
            r1 = r13
            r2 = r3
            r3 = r4
            r4 = r9
            r0.mo5113a(r1, r2, r3, r4, r5)
            goto L_0x0195
        L_0x018c:
            r0 = r16
            r1 = r13
            r2 = r4
            r4 = r5
            r5 = r9
            r0.mo5113a(r1, r2, r3, r4, r5)
        L_0x0195:
            boolean r0 = r14.f3822b
            if (r0 == 0) goto L_0x01a1
            androidx.recyclerview.widget.f r0 = r6.f3808l
            int r0 = r0.f3968e
            r6.m5056a(r0, r11)
            goto L_0x01a8
        L_0x01a1:
            androidx.recyclerview.widget.f r0 = r6.f3808l
            int r0 = r0.f3968e
            r6.m5064a(r15, r0, r11)
        L_0x01a8:
            androidx.recyclerview.widget.f r0 = r6.f3808l
            r6.m5062a(r7, r0)
            androidx.recyclerview.widget.f r0 = r6.f3808l
            boolean r0 = r0.f3971h
            if (r0 == 0) goto L_0x01cc
            boolean r0 = r13.hasFocusable()
            if (r0 == 0) goto L_0x01cc
            boolean r0 = r14.f3822b
            if (r0 == 0) goto L_0x01c3
            java.util.BitSet r0 = r6.f3809m
            r0.clear()
            goto L_0x01cc
        L_0x01c3:
            java.util.BitSet r0 = r6.f3809m
            int r1 = r15.f3843e
            r3 = 0
            r0.set(r1, r3)
            goto L_0x01cd
        L_0x01cc:
            r3 = 0
        L_0x01cd:
            r0 = 1
            r9 = 0
            goto L_0x004f
        L_0x01d1:
            r3 = 0
            if (r0 != 0) goto L_0x01d9
            androidx.recyclerview.widget.f r0 = r6.f3808l
            r6.m5062a(r7, r0)
        L_0x01d9:
            androidx.recyclerview.widget.f r0 = r6.f3808l
            int r0 = r0.f3968e
            if (r0 != r2) goto L_0x01f1
            androidx.recyclerview.widget.i r0 = r6.f3798b
            int r0 = r0.mo5535c()
            int r0 = r6.m5081q(r0)
            androidx.recyclerview.widget.i r1 = r6.f3798b
            int r1 = r1.mo5535c()
            int r1 = r1 - r0
            goto L_0x0203
        L_0x01f1:
            androidx.recyclerview.widget.i r0 = r6.f3798b
            int r0 = r0.mo5537d()
            int r0 = r6.m5083r(r0)
            androidx.recyclerview.widget.i r1 = r6.f3798b
            int r1 = r1.mo5537d()
            int r1 = r0 - r1
        L_0x0203:
            if (r1 <= 0) goto L_0x020c
            int r0 = r8.f3965b
            int r9 = java.lang.Math.min(r0, r1)
            r3 = r9
        L_0x020c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m5054a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.f, androidx.recyclerview.widget.RecyclerView$u):int");
    }

    /* renamed from: n */
    private C1282a m5077n(int i) {
        C1282a aVar = new C1282a();
        aVar.f3827c = new int[this.f3805i];
        for (int i2 = 0; i2 < this.f3805i; i2++) {
            aVar.f3827c[i2] = i - this.f3797a[i2].mo5404b(i);
        }
        return aVar;
    }

    /* renamed from: o */
    private C1282a m5078o(int i) {
        C1282a aVar = new C1282a();
        aVar.f3827c = new int[this.f3805i];
        for (int i2 = 0; i2 < this.f3805i; i2++) {
            aVar.f3827c[i2] = this.f3797a[i2].mo5396a(i) - i;
        }
        return aVar;
    }

    /* renamed from: a */
    private void m5058a(View view, C1280b bVar, C1313f fVar) {
        if (fVar.f3968e == 1) {
            if (bVar.f3822b) {
                m5080p(view);
            } else {
                bVar.f3821a.mo5405b(view);
            }
        } else if (bVar.f3822b) {
            m5082q(view);
        } else {
            bVar.f3821a.mo5401a(view);
        }
    }

    /* renamed from: a */
    private void m5062a(C1266p pVar, C1313f fVar) {
        int i;
        int i2;
        if (fVar.f3964a && !fVar.f3972i) {
            if (fVar.f3965b == 0) {
                if (fVar.f3968e == -1) {
                    m5069b(pVar, fVar.f3970g);
                } else {
                    m5060a(pVar, fVar.f3969f);
                }
            } else if (fVar.f3968e == -1) {
                int p = fVar.f3969f - m5079p(fVar.f3969f);
                if (p < 0) {
                    i2 = fVar.f3970g;
                } else {
                    i2 = fVar.f3970g - Math.min(p, fVar.f3965b);
                }
                m5069b(pVar, i2);
            } else {
                int s = m5084s(fVar.f3970g) - fVar.f3970g;
                if (s < 0) {
                    i = fVar.f3969f;
                } else {
                    i = Math.min(s, fVar.f3965b) + fVar.f3969f;
                }
                m5060a(pVar, i);
            }
        }
    }

    /* renamed from: p */
    private void m5080p(View view) {
        for (int i = this.f3805i - 1; i >= 0; i--) {
            this.f3797a[i].mo5405b(view);
        }
    }

    /* renamed from: q */
    private void m5082q(View view) {
        for (int i = this.f3805i - 1; i >= 0; i--) {
            this.f3797a[i].mo5401a(view);
        }
    }

    /* renamed from: a */
    private void m5056a(int i, int i2) {
        for (int i3 = 0; i3 < this.f3805i; i3++) {
            if (!this.f3797a[i3].f3839a.isEmpty()) {
                m5064a(this.f3797a[i3], i, i2);
            }
        }
    }

    /* renamed from: a */
    private void m5064a(C1286e eVar, int i, int i2) {
        int i3 = eVar.mo5415i();
        if (i == -1) {
            if (eVar.mo5403b() + i3 <= i2) {
                this.f3809m.set(eVar.f3843e, false);
            }
        } else if (eVar.mo5409d() - i3 >= i2) {
            this.f3809m.set(eVar.f3843e, false);
        }
    }

    /* renamed from: p */
    private int m5079p(int i) {
        int a = this.f3797a[0].mo5396a(i);
        for (int i2 = 1; i2 < this.f3805i; i2++) {
            int a2 = this.f3797a[i2].mo5396a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: q */
    private int m5081q(int i) {
        int a = this.f3797a[0].mo5396a(i);
        for (int i2 = 1; i2 < this.f3805i; i2++) {
            int a2 = this.f3797a[i2].mo5396a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo5358m() {
        int b = this.f3797a[0].mo5404b((int) C1024a.INVALID_ID);
        for (int i = 1; i < this.f3805i; i++) {
            if (this.f3797a[i].mo5404b((int) C1024a.INVALID_ID) != b) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public boolean mo5359n() {
        int a = this.f3797a[0].mo5396a((int) C1024a.INVALID_ID);
        for (int i = 1; i < this.f3805i; i++) {
            if (this.f3797a[i].mo5396a((int) C1024a.INVALID_ID) != a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r */
    private int m5083r(int i) {
        int b = this.f3797a[0].mo5404b(i);
        for (int i2 = 1; i2 < this.f3805i; i2++) {
            int b2 = this.f3797a[i2].mo5404b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: s */
    private int m5084s(int i) {
        int b = this.f3797a[0].mo5404b(i);
        for (int i2 = 1; i2 < this.f3805i; i2++) {
            int b2 = this.f3797a[i2].mo5404b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: a */
    private void m5060a(C1266p pVar, int i) {
        while (mo5186w() > 0) {
            View i2 = mo5169i(0);
            if (this.f3798b.mo5534b(i2) <= i && this.f3798b.mo5536c(i2) <= i) {
                C1280b bVar = (C1280b) i2.getLayoutParams();
                if (bVar.f3822b) {
                    int i3 = 0;
                    while (i3 < this.f3805i) {
                        if (this.f3797a[i3].f3839a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f3805i; i4++) {
                        this.f3797a[i4].mo5414h();
                    }
                } else if (bVar.f3821a.f3839a.size() != 1) {
                    bVar.f3821a.mo5414h();
                } else {
                    return;
                }
                mo5117a(i2, pVar);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m5069b(C1266p pVar, int i) {
        int w = mo5186w() - 1;
        while (w >= 0) {
            View i2 = mo5169i(w);
            if (this.f3798b.mo5530a(i2) >= i && this.f3798b.mo5538d(i2) >= i) {
                C1280b bVar = (C1280b) i2.getLayoutParams();
                if (bVar.f3822b) {
                    int i3 = 0;
                    while (i3 < this.f3805i) {
                        if (this.f3797a[i3].f3839a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f3805i; i4++) {
                        this.f3797a[i4].mo5413g();
                    }
                } else if (bVar.f3821a.f3839a.size() != 1) {
                    bVar.f3821a.mo5413g();
                } else {
                    return;
                }
                mo5117a(i2, pVar);
                w--;
            } else {
                return;
            }
        }
    }

    /* renamed from: t */
    private boolean m5085t(int i) {
        boolean z = false;
        if (this.f3806j == 0) {
            if ((i == -1) != this.f3801e) {
                z = true;
            }
            return z;
        }
        if (((i == -1) == this.f3801e) == mo5356j()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private C1286e m5055a(C1313f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (m5085t(fVar.f3968e)) {
            i2 = this.f3805i - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.f3805i;
            i = 1;
        }
        C1286e eVar = null;
        if (fVar.f3968e == 1) {
            int i4 = BaseClientBuilder.API_PRIORITY_OTHER;
            int c = this.f3798b.mo5535c();
            while (i2 != i3) {
                C1286e eVar2 = this.f3797a[i2];
                int b = eVar2.mo5404b(c);
                if (b < i4) {
                    eVar = eVar2;
                    i4 = b;
                }
                i2 += i;
            }
            return eVar;
        }
        int i5 = C1024a.INVALID_ID;
        int d = this.f3798b.mo5537d();
        while (i2 != i3) {
            C1286e eVar3 = this.f3797a[i2];
            int a = eVar3.mo5396a(d);
            if (a > i5) {
                eVar = eVar3;
                i5 = a;
            }
            i2 += i;
        }
        return eVar;
    }

    /* renamed from: f */
    public boolean mo4784f() {
        return this.f3806j == 1;
    }

    /* renamed from: e */
    public boolean mo4781e() {
        return this.f3806j == 0;
    }

    /* renamed from: a */
    public int mo4726a(int i, C1266p pVar, C1274u uVar) {
        return mo5350c(i, pVar, uVar);
    }

    /* renamed from: b */
    public int mo4746b(int i, C1266p pVar, C1274u uVar) {
        return mo5350c(i, pVar, uVar);
    }

    /* renamed from: u */
    private int m5086u(int i) {
        int i2 = -1;
        if (mo5186w() == 0) {
            if (this.f3801e) {
                i2 = 1;
            }
            return i2;
        }
        if ((i < mo5342L()) == this.f3801e) {
            i2 = 1;
        }
        return i2;
    }

    /* renamed from: d */
    public PointF mo4777d(int i) {
        int u = m5086u(i);
        PointF pointF = new PointF();
        if (u == 0) {
            return null;
        }
        if (this.f3806j == 0) {
            pointF.x = (float) u;
            pointF.y = BitmapDescriptorFactory.HUE_RED;
        } else {
            pointF.x = BitmapDescriptorFactory.HUE_RED;
            pointF.y = (float) u;
        }
        return pointF;
    }

    /* renamed from: a */
    public void mo4766a(RecyclerView recyclerView, C1274u uVar, int i) {
        C1314g gVar = new C1314g(recyclerView.getContext());
        gVar.mo5272c(i);
        mo5125a((C1271t) gVar);
    }

    /* renamed from: e */
    public void mo4780e(int i) {
        if (!(this.f3789A == null || this.f3789A.f3829a == i)) {
            this.f3789A.mo5389b();
        }
        this.f3802f = i;
        this.f3803g = C1024a.INVALID_ID;
        mo5179p();
    }

    /* renamed from: a */
    public void mo4761a(int i, int i2, C1274u uVar, C1257a aVar) {
        int i3;
        if (this.f3806j != 0) {
            i = i2;
        }
        if (mo5186w() != 0 && i != 0) {
            mo5344a(i, uVar);
            if (this.f3795G == null || this.f3795G.length < this.f3805i) {
                this.f3795G = new int[this.f3805i];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.f3805i; i5++) {
                if (this.f3808l.f3967d == -1) {
                    i3 = this.f3808l.f3969f - this.f3797a[i5].mo5396a(this.f3808l.f3969f);
                } else {
                    i3 = this.f3797a[i5].mo5404b(this.f3808l.f3970g) - this.f3808l.f3970g;
                }
                if (i3 >= 0) {
                    this.f3795G[i4] = i3;
                    i4++;
                }
            }
            Arrays.sort(this.f3795G, 0, i4);
            for (int i6 = 0; i6 < i4 && this.f3808l.mo5516a(uVar); i6++) {
                aVar.mo5195b(this.f3808l.f3966c, this.f3795G[i6]);
                this.f3808l.f3966c += this.f3808l.f3967d;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5344a(int i, C1274u uVar) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = mo5360o();
            i2 = 1;
        } else {
            i3 = mo5342L();
            i2 = -1;
        }
        this.f3808l.f3964a = true;
        m5068b(i3, uVar);
        m5076m(i2);
        this.f3808l.f3966c = i3 + this.f3808l.f3967d;
        this.f3808l.f3965b = Math.abs(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo5350c(int i, C1266p pVar, C1274u uVar) {
        if (mo5186w() == 0 || i == 0) {
            return 0;
        }
        mo5344a(i, uVar);
        int a = m5054a(pVar, this.f3808l, uVar);
        if (this.f3808l.f3965b >= a) {
            i = i < 0 ? -a : a;
        }
        this.f3798b.mo5532a(-i);
        this.f3811o = this.f3801e;
        this.f3808l.f3965b = 0;
        m5062a(pVar, this.f3808l);
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public int mo5360o() {
        int w = mo5186w();
        if (w == 0) {
            return 0;
        }
        return mo5152d(mo5169i(w - 1));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: L */
    public int mo5342L() {
        if (mo5186w() == 0) {
            return 0;
        }
        return mo5152d(mo5169i(0));
    }

    /* renamed from: v */
    private int m5087v(int i) {
        int w = mo5186w();
        for (int i2 = 0; i2 < w; i2++) {
            int d = mo5152d(mo5169i(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    /* renamed from: w */
    private int m5088w(int i) {
        for (int w = mo5186w() - 1; w >= 0; w--) {
            int d = mo5152d(mo5169i(w));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public C1259j mo4730a() {
        if (this.f3806j == 0) {
            return new C1280b(-2, -1);
        }
        return new C1280b(-1, -2);
    }

    /* renamed from: a */
    public C1259j mo4731a(Context context, AttributeSet attributeSet) {
        return new C1280b(context, attributeSet);
    }

    /* renamed from: a */
    public C1259j mo4732a(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C1280b((MarginLayoutParams) layoutParams);
        }
        return new C1280b(layoutParams);
    }

    /* renamed from: a */
    public boolean mo4745a(C1259j jVar) {
        return jVar instanceof C1280b;
    }

    /* renamed from: a */
    public View mo4728a(View view, int i, C1266p pVar, C1274u uVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (mo5186w() == 0) {
            return null;
        }
        View e = mo5157e(view);
        if (e == null) {
            return null;
        }
        m5052N();
        int x = m5089x(i);
        if (x == Integer.MIN_VALUE) {
            return null;
        }
        C1280b bVar = (C1280b) e.getLayoutParams();
        boolean z = bVar.f3822b;
        C1286e eVar = bVar.f3821a;
        if (x == 1) {
            i2 = mo5360o();
        } else {
            i2 = mo5342L();
        }
        m5068b(i2, uVar);
        m5076m(x);
        this.f3808l.f3966c = this.f3808l.f3967d + i2;
        this.f3808l.f3965b = (int) (((float) this.f3798b.mo5541f()) * 0.33333334f);
        this.f3808l.f3971h = true;
        this.f3808l.f3964a = false;
        m5054a(pVar, this.f3808l, uVar);
        this.f3811o = this.f3801e;
        if (!z) {
            View a = eVar.mo5399a(i2, x);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m5085t(x)) {
            for (int i6 = this.f3805i - 1; i6 >= 0; i6--) {
                View a2 = this.f3797a[i6].mo5399a(i2, x);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f3805i; i7++) {
                View a3 = this.f3797a[i7].mo5399a(i2, x);
                if (a3 != null && a3 != e) {
                    return a3;
                }
            }
        }
        boolean z2 = (this.f3800d ^ true) == (x == -1);
        if (!z) {
            if (z2) {
                i5 = eVar.mo5416j();
            } else {
                i5 = eVar.mo5417k();
            }
            View c = mo4774c(i5);
            if (!(c == null || c == e)) {
                return c;
            }
        }
        if (m5085t(x)) {
            for (int i8 = this.f3805i - 1; i8 >= 0; i8--) {
                if (i8 != eVar.f3843e) {
                    if (z2) {
                        i4 = this.f3797a[i8].mo5416j();
                    } else {
                        i4 = this.f3797a[i8].mo5417k();
                    }
                    View c2 = mo4774c(i4);
                    if (!(c2 == null || c2 == e)) {
                        return c2;
                    }
                }
            }
        } else {
            for (int i9 = 0; i9 < this.f3805i; i9++) {
                if (z2) {
                    i3 = this.f3797a[i9].mo5416j();
                } else {
                    i3 = this.f3797a[i9].mo5417k();
                }
                View c3 = mo4774c(i3);
                if (c3 != null && c3 != e) {
                    return c3;
                }
            }
        }
        return null;
    }

    /* renamed from: x */
    private int m5089x(int i) {
        int i2 = -1;
        int i3 = C1024a.INVALID_ID;
        if (i == 17) {
            if (this.f3806j != 0) {
                i2 = C1024a.INVALID_ID;
            }
            return i2;
        } else if (i == 33) {
            if (this.f3806j != 1) {
                i2 = C1024a.INVALID_ID;
            }
            return i2;
        } else if (i == 66) {
            if (this.f3806j == 0) {
                i3 = 1;
            }
            return i3;
        } else if (i != 130) {
            switch (i) {
                case 1:
                    return (this.f3806j != 1 && mo5356j()) ? 1 : -1;
                case 2:
                    return (this.f3806j != 1 && mo5356j()) ? -1 : 1;
                default:
                    return C1024a.INVALID_ID;
            }
        } else {
            if (this.f3806j == 1) {
                i3 = 1;
            }
            return i3;
        }
    }
}
