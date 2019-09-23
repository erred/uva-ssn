package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.R;
import androidx.appcompat.view.C0505b;
import androidx.appcompat.view.C0505b.C0506a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.appcompat.app.a */
/* compiled from: ActionBar */
public abstract class C0440a {

    /* renamed from: androidx.appcompat.app.a$a */
    /* compiled from: ActionBar */
    public static class C0441a extends MarginLayoutParams {

        /* renamed from: a */
        public int f973a;

        public C0441a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f973a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f973a = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0441a(int i, int i2) {
            super(i, i2);
            this.f973a = 0;
            this.f973a = 8388627;
        }

        public C0441a(C0441a aVar) {
            super(aVar);
            this.f973a = 0;
            this.f973a = aVar.f973a;
        }

        public C0441a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f973a = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.a$b */
    /* compiled from: ActionBar */
    public interface C0442b {
        /* renamed from: a */
        void mo869a(boolean z);
    }

    @Deprecated
    /* renamed from: androidx.appcompat.app.a$c */
    /* compiled from: ActionBar */
    public static abstract class C0443c {
        /* renamed from: a */
        public abstract Drawable mo870a();

        /* renamed from: b */
        public abstract CharSequence mo871b();

        /* renamed from: c */
        public abstract View mo872c();

        /* renamed from: d */
        public abstract void mo873d();

        /* renamed from: e */
        public abstract CharSequence mo874e();
    }

    /* renamed from: a */
    public abstract int mo848a();

    /* renamed from: a */
    public C0505b mo849a(C0506a aVar) {
        return null;
    }

    /* renamed from: a */
    public void mo851a(Configuration configuration) {
    }

    /* renamed from: a */
    public void mo852a(Drawable drawable) {
    }

    /* renamed from: a */
    public void mo853a(CharSequence charSequence) {
    }

    /* renamed from: a */
    public abstract void mo854a(boolean z);

    /* renamed from: a */
    public boolean mo855a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    public boolean mo856a(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public Context mo857b() {
        return null;
    }

    /* renamed from: b */
    public abstract void mo858b(boolean z);

    /* renamed from: c */
    public void mo859c(boolean z) {
    }

    /* renamed from: c */
    public boolean mo860c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo862d() {
        return false;
    }

    /* renamed from: e */
    public void mo863e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo864e() {
        return false;
    }

    /* renamed from: f */
    public void mo865f(boolean z) {
    }

    /* renamed from: f */
    public boolean mo866f() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo867g() {
    }

    /* renamed from: g */
    public void mo868g(boolean z) {
    }

    /* renamed from: d */
    public void mo861d(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* renamed from: a */
    public void mo850a(float f) {
        if (f != BitmapDescriptorFactory.HUE_RED) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }
}
