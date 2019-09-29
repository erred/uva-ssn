package androidx.fragment.p081a;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.C1481a;

/* renamed from: androidx.fragment.a.m */
/* compiled from: FragmentPagerAdapter */
public abstract class C1101m extends C1481a {

    /* renamed from: a */
    private final C1078i f3429a;

    /* renamed from: b */
    private C1104o f3430b = null;

    /* renamed from: c */
    private C1062d f3431c = null;

    /* renamed from: a */
    public Parcelable mo4497a() {
        return null;
    }

    /* renamed from: a */
    public abstract C1062d mo4498a(int i);

    /* renamed from: a */
    public void mo4500a(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* renamed from: b */
    public long mo4504b(int i) {
        return (long) i;
    }

    public C1101m(C1078i iVar) {
        this.f3429a = iVar;
    }

    /* renamed from: a */
    public void mo4501a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewPager with adapter ");
            sb.append(this);
            sb.append(" requires a view id");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: a */
    public Object mo4499a(ViewGroup viewGroup, int i) {
        if (this.f3430b == null) {
            this.f3430b = this.f3429a.mo4370a();
        }
        long b = mo4504b(i);
        C1062d a = this.f3429a.mo4369a(m4255a(viewGroup.getId(), b));
        if (a != null) {
            this.f3430b.mo4085c(a);
        } else {
            a = mo4498a(i);
            this.f3430b.mo4066a(viewGroup.getId(), a, m4255a(viewGroup.getId(), b));
        }
        if (a != this.f3431c) {
            a.setMenuVisibility(false);
            a.setUserVisibleHint(false);
        }
        return a;
    }

    /* renamed from: a */
    public void mo4502a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f3430b == null) {
            this.f3430b = this.f3429a.mo4370a();
        }
        this.f3430b.mo4080b((C1062d) obj);
    }

    /* renamed from: b */
    public void mo4506b(ViewGroup viewGroup, int i, Object obj) {
        C1062d dVar = (C1062d) obj;
        if (dVar != this.f3431c) {
            if (this.f3431c != null) {
                this.f3431c.setMenuVisibility(false);
                this.f3431c.setUserVisibleHint(false);
            }
            dVar.setMenuVisibility(true);
            dVar.setUserVisibleHint(true);
            this.f3431c = dVar;
        }
    }

    /* renamed from: b */
    public void mo4505b(ViewGroup viewGroup) {
        if (this.f3430b != null) {
            this.f3430b.mo4088f();
            this.f3430b = null;
        }
    }

    /* renamed from: a */
    public boolean mo4503a(View view, Object obj) {
        return ((C1062d) obj).getView() == view;
    }

    /* renamed from: a */
    private static String m4255a(int i, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("android:switcher:");
        sb.append(i);
        sb.append(":");
        sb.append(j);
        return sb.toString();
    }
}
