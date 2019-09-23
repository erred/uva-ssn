package androidx.legacy.p083a;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.C1481a;

@Deprecated
/* renamed from: androidx.legacy.a.b */
/* compiled from: FragmentPagerAdapter */
public abstract class C1144b extends C1481a {

    /* renamed from: a */
    private final FragmentManager f3533a;

    /* renamed from: b */
    private FragmentTransaction f3534b = null;

    /* renamed from: c */
    private Fragment f3535c = null;

    @Deprecated
    /* renamed from: a */
    public abstract Fragment mo4569a(int i);

    @Deprecated
    /* renamed from: a */
    public Parcelable mo4497a() {
        return null;
    }

    @Deprecated
    /* renamed from: a */
    public void mo4500a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    /* renamed from: b */
    public long mo4570b(int i) {
        return (long) i;
    }

    @Deprecated
    public C1144b(FragmentManager fragmentManager) {
        this.f3533a = fragmentManager;
    }

    @Deprecated
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

    @Deprecated
    /* renamed from: a */
    public Object mo4499a(ViewGroup viewGroup, int i) {
        if (this.f3534b == null) {
            this.f3534b = this.f3533a.beginTransaction();
        }
        long b = mo4570b(i);
        Fragment findFragmentByTag = this.f3533a.findFragmentByTag(m4406a(viewGroup.getId(), b));
        if (findFragmentByTag != null) {
            this.f3534b.attach(findFragmentByTag);
        } else {
            findFragmentByTag = mo4569a(i);
            this.f3534b.add(viewGroup.getId(), findFragmentByTag, m4406a(viewGroup.getId(), b));
        }
        if (findFragmentByTag != this.f3535c) {
            findFragmentByTag.setMenuVisibility(false);
            C1135a.m4396a(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    @Deprecated
    /* renamed from: a */
    public void mo4502a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f3534b == null) {
            this.f3534b = this.f3533a.beginTransaction();
        }
        this.f3534b.detach((Fragment) obj);
    }

    @Deprecated
    /* renamed from: b */
    public void mo4506b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f3535c) {
            if (this.f3535c != null) {
                this.f3535c.setMenuVisibility(false);
                C1135a.m4396a(this.f3535c, false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                C1135a.m4396a(fragment, true);
            }
            this.f3535c = fragment;
        }
    }

    @Deprecated
    /* renamed from: b */
    public void mo4505b(ViewGroup viewGroup) {
        if (this.f3534b != null) {
            this.f3534b.commitAllowingStateLoss();
            this.f3534b = null;
            this.f3533a.executePendingTransactions();
        }
    }

    @Deprecated
    /* renamed from: a */
    public boolean mo4503a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    /* renamed from: a */
    private static String m4406a(int i, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("android:switcher:");
        sb.append(i);
        sb.append(":");
        sb.append(j);
        return sb.toString();
    }
}
