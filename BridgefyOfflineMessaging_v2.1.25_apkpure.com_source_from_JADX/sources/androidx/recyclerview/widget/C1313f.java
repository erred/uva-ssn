package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.C1266p;
import androidx.recyclerview.widget.RecyclerView.C1274u;

/* renamed from: androidx.recyclerview.widget.f */
/* compiled from: LayoutState */
class C1313f {

    /* renamed from: a */
    boolean f3964a = true;

    /* renamed from: b */
    int f3965b;

    /* renamed from: c */
    int f3966c;

    /* renamed from: d */
    int f3967d;

    /* renamed from: e */
    int f3968e;

    /* renamed from: f */
    int f3969f = 0;

    /* renamed from: g */
    int f3970g = 0;

    /* renamed from: h */
    boolean f3971h;

    /* renamed from: i */
    boolean f3972i;

    C1313f() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5516a(C1274u uVar) {
        return this.f3966c >= 0 && this.f3966c < uVar.mo5291e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo5515a(C1266p pVar) {
        View c = pVar.mo5238c(this.f3966c);
        this.f3966c += this.f3967d;
        return c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LayoutState{mAvailable=");
        sb.append(this.f3965b);
        sb.append(", mCurrentPosition=");
        sb.append(this.f3966c);
        sb.append(", mItemDirection=");
        sb.append(this.f3967d);
        sb.append(", mLayoutDirection=");
        sb.append(this.f3968e);
        sb.append(", mStartLine=");
        sb.append(this.f3969f);
        sb.append(", mEndLine=");
        sb.append(this.f3970g);
        sb.append('}');
        return sb.toString();
    }
}
