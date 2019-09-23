package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.viewpager.widget.a */
/* compiled from: PagerAdapter */
public abstract class C1481a {

    /* renamed from: a */
    private final DataSetObservable f4433a = new DataSetObservable();

    /* renamed from: b */
    private DataSetObserver f4434b;

    /* renamed from: a */
    public int mo6146a(Object obj) {
        return -1;
    }

    /* renamed from: a */
    public Parcelable mo4497a() {
        return null;
    }

    /* renamed from: a */
    public void mo4500a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    /* renamed from: a */
    public void mo6149a(View view) {
    }

    /* renamed from: a */
    public abstract boolean mo4503a(View view, Object obj);

    /* renamed from: b */
    public abstract int mo6151b();

    @Deprecated
    /* renamed from: b */
    public void mo6153b(View view) {
    }

    @Deprecated
    /* renamed from: b */
    public void mo6154b(View view, int i, Object obj) {
    }

    /* renamed from: c */
    public CharSequence mo6155c(int i) {
        return null;
    }

    /* renamed from: d */
    public float mo6158d(int i) {
        return 1.0f;
    }

    /* renamed from: a */
    public void mo4501a(ViewGroup viewGroup) {
        mo6149a((View) viewGroup);
    }

    /* renamed from: a */
    public Object mo4499a(ViewGroup viewGroup, int i) {
        return mo6147a((View) viewGroup, i);
    }

    /* renamed from: a */
    public void mo4502a(ViewGroup viewGroup, int i, Object obj) {
        mo6150a((View) viewGroup, i, obj);
    }

    /* renamed from: b */
    public void mo4506b(ViewGroup viewGroup, int i, Object obj) {
        mo6154b((View) viewGroup, i, obj);
    }

    /* renamed from: b */
    public void mo4505b(ViewGroup viewGroup) {
        mo6153b((View) viewGroup);
    }

    @Deprecated
    /* renamed from: a */
    public Object mo6147a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    /* renamed from: a */
    public void mo6150a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    /* renamed from: c */
    public void mo6156c() {
        synchronized (this) {
            if (this.f4434b != null) {
                this.f4434b.onChanged();
            }
        }
        this.f4433a.notifyChanged();
    }

    /* renamed from: a */
    public void mo6148a(DataSetObserver dataSetObserver) {
        this.f4433a.registerObserver(dataSetObserver);
    }

    /* renamed from: b */
    public void mo6152b(DataSetObserver dataSetObserver) {
        this.f4433a.unregisterObserver(dataSetObserver);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo6157c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f4434b = dataSetObserver;
        }
    }
}
