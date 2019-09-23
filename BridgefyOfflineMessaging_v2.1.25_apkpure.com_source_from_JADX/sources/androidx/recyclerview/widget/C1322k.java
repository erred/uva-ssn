package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.C1254i;
import androidx.recyclerview.widget.RecyclerView.C1274u;

/* renamed from: androidx.recyclerview.widget.k */
/* compiled from: ScrollbarHelper */
class C1322k {
    /* renamed from: a */
    static int m5406a(C1274u uVar, C1317i iVar, View view, View view2, C1254i iVar2, boolean z, boolean z2) {
        int i;
        if (iVar2.mo5186w() == 0 || uVar.mo5291e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar2.mo5152d(view), iVar2.mo5152d(view2));
        int max = Math.max(iVar2.mo5152d(view), iVar2.mo5152d(view2));
        if (z2) {
            i = Math.max(0, (uVar.mo5291e() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(iVar.mo5534b(view2) - iVar.mo5530a(view))) / ((float) (Math.abs(iVar2.mo5152d(view) - iVar2.mo5152d(view2)) + 1)))) + ((float) (iVar.mo5535c() - iVar.mo5530a(view))));
    }

    /* renamed from: a */
    static int m5405a(C1274u uVar, C1317i iVar, View view, View view2, C1254i iVar2, boolean z) {
        if (iVar2.mo5186w() == 0 || uVar.mo5291e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar2.mo5152d(view) - iVar2.mo5152d(view2)) + 1;
        }
        return Math.min(iVar.mo5541f(), iVar.mo5534b(view2) - iVar.mo5530a(view));
    }

    /* renamed from: b */
    static int m5407b(C1274u uVar, C1317i iVar, View view, View view2, C1254i iVar2, boolean z) {
        if (iVar2.mo5186w() == 0 || uVar.mo5291e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.mo5291e();
        }
        return (int) ((((float) (iVar.mo5534b(view2) - iVar.mo5530a(view))) / ((float) (Math.abs(iVar2.mo5152d(view) - iVar2.mo5152d(view2)) + 1))) * ((float) uVar.mo5291e()));
    }
}
