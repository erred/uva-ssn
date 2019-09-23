package androidx.recyclerview.widget;

import java.util.List;

/* renamed from: androidx.recyclerview.widget.h */
/* compiled from: OpReorderer */
class C1315h {

    /* renamed from: a */
    final C1316a f3979a;

    /* renamed from: androidx.recyclerview.widget.h$a */
    /* compiled from: OpReorderer */
    interface C1316a {
        /* renamed from: a */
        C1289b mo5419a(int i, int i2, int i3, Object obj);

        /* renamed from: a */
        void mo5421a(C1289b bVar);
    }

    C1315h(C1316a aVar) {
        this.f3979a = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5527a(List<C1289b> list) {
        while (true) {
            int b = m5351b(list);
            if (b != -1) {
                m5350a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m5350a(List<C1289b> list, int i, int i2) {
        C1289b bVar = (C1289b) list.get(i);
        C1289b bVar2 = (C1289b) list.get(i2);
        int i3 = bVar2.f3853a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    m5352c(list, i, bVar, i2, bVar2);
                    return;
                case 2:
                    mo5528a(list, i, bVar, i2, bVar2);
                    return;
                default:
                    return;
            }
        } else {
            mo5529b(list, i, bVar, i2, bVar2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5528a(java.util.List<androidx.recyclerview.widget.C1287a.C1289b> r9, int r10, androidx.recyclerview.widget.C1287a.C1289b r11, int r12, androidx.recyclerview.widget.C1287a.C1289b r13) {
        /*
            r8 = this;
            int r0 = r11.f3854b
            int r1 = r11.f3856d
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x001c
            int r0 = r13.f3854b
            int r1 = r11.f3854b
            if (r0 != r1) goto L_0x001a
            int r0 = r13.f3856d
            int r1 = r11.f3856d
            int r4 = r11.f3854b
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x001a
            r0 = 0
        L_0x0018:
            r2 = 1
            goto L_0x002f
        L_0x001a:
            r0 = 0
            goto L_0x002f
        L_0x001c:
            int r0 = r13.f3854b
            int r1 = r11.f3856d
            int r1 = r1 + r3
            if (r0 != r1) goto L_0x002e
            int r0 = r13.f3856d
            int r1 = r11.f3854b
            int r4 = r11.f3856d
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x002e
            r0 = 1
            goto L_0x0018
        L_0x002e:
            r0 = 1
        L_0x002f:
            int r1 = r11.f3856d
            int r4 = r13.f3854b
            r5 = 2
            if (r1 >= r4) goto L_0x003c
            int r1 = r13.f3854b
            int r1 = r1 - r3
            r13.f3854b = r1
            goto L_0x005b
        L_0x003c:
            int r1 = r11.f3856d
            int r4 = r13.f3854b
            int r6 = r13.f3856d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x005b
            int r10 = r13.f3856d
            int r10 = r10 - r3
            r13.f3856d = r10
            r11.f3853a = r5
            r11.f3856d = r3
            int r10 = r13.f3856d
            if (r10 != 0) goto L_0x005a
            r9.remove(r12)
            androidx.recyclerview.widget.h$a r9 = r8.f3979a
            r9.mo5421a(r13)
        L_0x005a:
            return
        L_0x005b:
            int r1 = r11.f3854b
            int r4 = r13.f3854b
            r6 = 0
            if (r1 > r4) goto L_0x0068
            int r1 = r13.f3854b
            int r1 = r1 + r3
            r13.f3854b = r1
            goto L_0x0089
        L_0x0068:
            int r1 = r11.f3854b
            int r4 = r13.f3854b
            int r7 = r13.f3856d
            int r4 = r4 + r7
            if (r1 >= r4) goto L_0x0089
            int r1 = r13.f3854b
            int r4 = r13.f3856d
            int r1 = r1 + r4
            int r4 = r11.f3854b
            int r1 = r1 - r4
            androidx.recyclerview.widget.h$a r4 = r8.f3979a
            int r7 = r11.f3854b
            int r7 = r7 + r3
            androidx.recyclerview.widget.a$b r6 = r4.mo5419a(r5, r7, r1, r6)
            int r1 = r11.f3854b
            int r3 = r13.f3854b
            int r1 = r1 - r3
            r13.f3856d = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r9.set(r10, r13)
            r9.remove(r12)
            androidx.recyclerview.widget.h$a r9 = r8.f3979a
            r9.mo5421a(r11)
            return
        L_0x0097:
            if (r0 == 0) goto L_0x00d0
            if (r6 == 0) goto L_0x00b5
            int r0 = r11.f3854b
            int r1 = r6.f3854b
            if (r0 <= r1) goto L_0x00a8
            int r0 = r11.f3854b
            int r1 = r6.f3856d
            int r0 = r0 - r1
            r11.f3854b = r0
        L_0x00a8:
            int r0 = r11.f3856d
            int r1 = r6.f3854b
            if (r0 <= r1) goto L_0x00b5
            int r0 = r11.f3856d
            int r1 = r6.f3856d
            int r0 = r0 - r1
            r11.f3856d = r0
        L_0x00b5:
            int r0 = r11.f3854b
            int r1 = r13.f3854b
            if (r0 <= r1) goto L_0x00c2
            int r0 = r11.f3854b
            int r1 = r13.f3856d
            int r0 = r0 - r1
            r11.f3854b = r0
        L_0x00c2:
            int r0 = r11.f3856d
            int r1 = r13.f3854b
            if (r0 <= r1) goto L_0x0106
            int r0 = r11.f3856d
            int r1 = r13.f3856d
            int r0 = r0 - r1
            r11.f3856d = r0
            goto L_0x0106
        L_0x00d0:
            if (r6 == 0) goto L_0x00ec
            int r0 = r11.f3854b
            int r1 = r6.f3854b
            if (r0 < r1) goto L_0x00df
            int r0 = r11.f3854b
            int r1 = r6.f3856d
            int r0 = r0 - r1
            r11.f3854b = r0
        L_0x00df:
            int r0 = r11.f3856d
            int r1 = r6.f3854b
            if (r0 < r1) goto L_0x00ec
            int r0 = r11.f3856d
            int r1 = r6.f3856d
            int r0 = r0 - r1
            r11.f3856d = r0
        L_0x00ec:
            int r0 = r11.f3854b
            int r1 = r13.f3854b
            if (r0 < r1) goto L_0x00f9
            int r0 = r11.f3854b
            int r1 = r13.f3856d
            int r0 = r0 - r1
            r11.f3854b = r0
        L_0x00f9:
            int r0 = r11.f3856d
            int r1 = r13.f3854b
            if (r0 < r1) goto L_0x0106
            int r0 = r11.f3856d
            int r1 = r13.f3856d
            int r0 = r0 - r1
            r11.f3856d = r0
        L_0x0106:
            r9.set(r10, r13)
            int r13 = r11.f3854b
            int r0 = r11.f3856d
            if (r13 == r0) goto L_0x0113
            r9.set(r12, r11)
            goto L_0x0116
        L_0x0113:
            r9.remove(r12)
        L_0x0116:
            if (r6 == 0) goto L_0x011b
            r9.add(r10, r6)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C1315h.mo5528a(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    /* renamed from: c */
    private void m5352c(List<C1289b> list, int i, C1289b bVar, int i2, C1289b bVar2) {
        int i3 = bVar.f3856d < bVar2.f3854b ? -1 : 0;
        if (bVar.f3854b < bVar2.f3854b) {
            i3++;
        }
        if (bVar2.f3854b <= bVar.f3854b) {
            bVar.f3854b += bVar2.f3856d;
        }
        if (bVar2.f3854b <= bVar.f3856d) {
            bVar.f3856d += bVar2.f3856d;
        }
        bVar2.f3854b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5529b(java.util.List<androidx.recyclerview.widget.C1287a.C1289b> r8, int r9, androidx.recyclerview.widget.C1287a.C1289b r10, int r11, androidx.recyclerview.widget.C1287a.C1289b r12) {
        /*
            r7 = this;
            int r0 = r10.f3856d
            int r1 = r12.f3854b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000f
            int r0 = r12.f3854b
            int r0 = r0 - r4
            r12.f3854b = r0
            goto L_0x0028
        L_0x000f:
            int r0 = r10.f3856d
            int r1 = r12.f3854b
            int r5 = r12.f3856d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            int r0 = r12.f3856d
            int r0 = r0 - r4
            r12.f3856d = r0
            androidx.recyclerview.widget.h$a r0 = r7.f3979a
            int r1 = r10.f3854b
            java.lang.Object r5 = r12.f3855c
            androidx.recyclerview.widget.a$b r0 = r0.mo5419a(r2, r1, r4, r5)
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r1 = r10.f3854b
            int r5 = r12.f3854b
            if (r1 > r5) goto L_0x0035
            int r1 = r12.f3854b
            int r1 = r1 + r4
            r12.f3854b = r1
            goto L_0x0056
        L_0x0035:
            int r1 = r10.f3854b
            int r5 = r12.f3854b
            int r6 = r12.f3856d
            int r5 = r5 + r6
            if (r1 >= r5) goto L_0x0056
            int r1 = r12.f3854b
            int r3 = r12.f3856d
            int r1 = r1 + r3
            int r3 = r10.f3854b
            int r1 = r1 - r3
            androidx.recyclerview.widget.h$a r3 = r7.f3979a
            int r5 = r10.f3854b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f3855c
            androidx.recyclerview.widget.a$b r3 = r3.mo5419a(r2, r5, r1, r4)
            int r2 = r12.f3856d
            int r2 = r2 - r1
            r12.f3856d = r2
        L_0x0056:
            r8.set(r11, r10)
            int r10 = r12.f3856d
            if (r10 <= 0) goto L_0x0061
            r8.set(r9, r12)
            goto L_0x0069
        L_0x0061:
            r8.remove(r9)
            androidx.recyclerview.widget.h$a r10 = r7.f3979a
            r10.mo5421a(r12)
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r8.add(r9, r0)
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            r8.add(r9, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C1315h.mo5529b(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    /* renamed from: b */
    private int m5351b(List<C1289b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((C1289b) list.get(size)).f3853a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
