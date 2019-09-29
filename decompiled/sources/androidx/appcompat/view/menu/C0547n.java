package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.core.p070g.C0946c;
import androidx.core.p070g.C0962r;

/* renamed from: androidx.appcompat.view.menu.n */
/* compiled from: MenuPopupHelper */
public class C0547n {

    /* renamed from: a */
    private final Context f1453a;

    /* renamed from: b */
    private final C0533h f1454b;

    /* renamed from: c */
    private final boolean f1455c;

    /* renamed from: d */
    private final int f1456d;

    /* renamed from: e */
    private final int f1457e;

    /* renamed from: f */
    private View f1458f;

    /* renamed from: g */
    private int f1459g;

    /* renamed from: h */
    private boolean f1460h;

    /* renamed from: i */
    private C0550a f1461i;

    /* renamed from: j */
    private C0546m f1462j;

    /* renamed from: k */
    private OnDismissListener f1463k;

    /* renamed from: l */
    private final OnDismissListener f1464l;

    public C0547n(Context context, C0533h hVar, View view, boolean z, int i) {
        this(context, hVar, view, z, i, 0);
    }

    public C0547n(Context context, C0533h hVar, View view, boolean z, int i, int i2) {
        this.f1459g = 8388611;
        this.f1464l = new OnDismissListener() {
            public void onDismiss() {
                C0547n.this.mo1707e();
            }
        };
        this.f1453a = context;
        this.f1454b = hVar;
        this.f1458f = view;
        this.f1455c = z;
        this.f1456d = i;
        this.f1457e = i2;
    }

    /* renamed from: a */
    public void mo1700a(OnDismissListener onDismissListener) {
        this.f1463k = onDismissListener;
    }

    /* renamed from: a */
    public void mo1699a(View view) {
        this.f1458f = view;
    }

    /* renamed from: a */
    public void mo1702a(boolean z) {
        this.f1460h = z;
        if (this.f1462j != null) {
            this.f1462j.mo1438a(z);
        }
    }

    /* renamed from: a */
    public void mo1698a(int i) {
        this.f1459g = i;
    }

    /* renamed from: a */
    public void mo1697a() {
        if (!mo1705c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: b */
    public C0546m mo1704b() {
        if (this.f1462j == null) {
            this.f1462j = m1846g();
        }
        return this.f1462j;
    }

    /* renamed from: c */
    public boolean mo1705c() {
        if (mo1708f()) {
            return true;
        }
        if (this.f1458f == null) {
            return false;
        }
        m1845a(0, 0, false, false);
        return true;
    }

    /* renamed from: a */
    public boolean mo1703a(int i, int i2) {
        if (mo1708f()) {
            return true;
        }
        if (this.f1458f == null) {
            return false;
        }
        m1845a(i, i2, true, true);
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.m] */
    /* JADX WARNING: type inference failed for: r7v0, types: [androidx.appcompat.view.menu.t] */
    /* JADX WARNING: type inference failed for: r1v12, types: [androidx.appcompat.view.menu.e] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.t] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.e] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v1, types: [androidx.appcompat.view.menu.t]
      assigns: [androidx.appcompat.view.menu.t, androidx.appcompat.view.menu.e]
      uses: [androidx.appcompat.view.menu.t, androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.e]
      mth insns count: 49
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
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.C0546m m1846g() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f1453a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x001d
            r0.getRealSize(r1)
            goto L_0x0020
        L_0x001d:
            r0.getSize(r1)
        L_0x0020:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f1453a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R.dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x004c
            androidx.appcompat.view.menu.e r0 = new androidx.appcompat.view.menu.e
            android.content.Context r2 = r14.f1453a
            android.view.View r3 = r14.f1458f
            int r4 = r14.f1456d
            int r5 = r14.f1457e
            boolean r6 = r14.f1455c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004c:
            androidx.appcompat.view.menu.t r0 = new androidx.appcompat.view.menu.t
            android.content.Context r8 = r14.f1453a
            androidx.appcompat.view.menu.h r9 = r14.f1454b
            android.view.View r10 = r14.f1458f
            int r11 = r14.f1456d
            int r12 = r14.f1457e
            boolean r13 = r14.f1455c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            androidx.appcompat.view.menu.h r1 = r14.f1454b
            r0.mo1437a(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f1464l
            r0.mo1436a(r1)
            android.view.View r1 = r14.f1458f
            r0.mo1435a(r1)
            androidx.appcompat.view.menu.o$a r1 = r14.f1461i
            r0.setCallback(r1)
            boolean r1 = r14.f1460h
            r0.mo1438a(r1)
            int r1 = r14.f1459g
            r0.mo1434a(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.C0547n.m1846g():androidx.appcompat.view.menu.m");
    }

    /* renamed from: a */
    private void m1845a(int i, int i2, boolean z, boolean z2) {
        C0546m b = mo1704b();
        b.mo1441b(z2);
        if (z) {
            if ((C0946c.m3493a(this.f1459g, C0962r.m3579f(this.f1458f)) & 7) == 5) {
                i -= this.f1458f.getWidth();
            }
            b.mo1440b(i);
            b.mo1442c(i2);
            int i3 = (int) ((this.f1453a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.mo1694a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        b.mo1433a();
    }

    /* renamed from: d */
    public void mo1706d() {
        if (mo1708f()) {
            this.f1462j.mo1439b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1707e() {
        this.f1462j = null;
        if (this.f1463k != null) {
            this.f1463k.onDismiss();
        }
    }

    /* renamed from: f */
    public boolean mo1708f() {
        return this.f1462j != null && this.f1462j.mo1443c();
    }

    /* renamed from: a */
    public void mo1701a(C0550a aVar) {
        this.f1461i = aVar;
        if (this.f1462j != null) {
            this.f1462j.setCallback(aVar);
        }
    }
}
