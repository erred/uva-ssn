package androidx.core.widget;

import android.widget.ListView;

/* renamed from: androidx.core.widget.f */
/* compiled from: ListViewAutoScrollHelper */
public class C1010f extends C1003a {

    /* renamed from: f */
    private final ListView f3149f;

    /* renamed from: e */
    public boolean mo3938e(int i) {
        return false;
    }

    public C1010f(ListView listView) {
        super(listView);
        this.f3149f = listView;
    }

    /* renamed from: a */
    public void mo3928a(int i, int i2) {
        C1011g.m3855a(this.f3149f, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3939f(int r8) {
        /*
            r7 = this;
            android.widget.ListView r0 = r7.f3149f
            int r1 = r0.getCount()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r3 = r0.getChildCount()
            int r4 = r0.getFirstVisiblePosition()
            int r5 = r4 + r3
            r6 = 1
            if (r8 <= 0) goto L_0x0029
            if (r5 < r1) goto L_0x0038
            int r3 = r3 - r6
            android.view.View r8 = r0.getChildAt(r3)
            int r8 = r8.getBottom()
            int r0 = r0.getHeight()
            if (r8 > r0) goto L_0x0038
            return r2
        L_0x0029:
            if (r8 >= 0) goto L_0x0039
            if (r4 > 0) goto L_0x0038
            android.view.View r8 = r0.getChildAt(r2)
            int r8 = r8.getTop()
            if (r8 < 0) goto L_0x0038
            return r2
        L_0x0038:
            return r6
        L_0x0039:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.C1010f.mo3939f(int):boolean");
    }
}
