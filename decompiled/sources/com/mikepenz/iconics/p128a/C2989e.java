package com.mikepenz.iconics.p128a;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.mikepenz.iconics.a.e */
/* compiled from: InternalLayoutInflater */
class C2989e extends LayoutInflater {

    /* renamed from: a */
    private static final String[] f7791a = {"android.widget.", "android.webkit."};

    /* renamed from: b */
    private final C2987d f7792b = new C2987d();

    /* renamed from: c */
    private boolean f7793c = false;

    /* renamed from: d */
    private Field f7794d = null;

    @TargetApi(11)
    /* renamed from: com.mikepenz.iconics.a.e$a */
    /* compiled from: InternalLayoutInflater */
    private static class C2990a extends C2992c {

        /* renamed from: c */
        private final C2989e f7795c;

        public C2990a(Factory2 factory2, C2989e eVar, C2987d dVar) {
            super(factory2, dVar);
            this.f7795c = eVar;
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f7800b.mo27325a(this.f7795c.m8812a(view, this.f7799a.onCreateView(view, str, context, attributeSet), str, context, attributeSet), context, attributeSet);
        }
    }

    /* renamed from: com.mikepenz.iconics.a.e$b */
    /* compiled from: InternalLayoutInflater */
    private static class C2991b implements Factory {

        /* renamed from: a */
        private final Factory f7796a;

        /* renamed from: b */
        private final C2989e f7797b;

        /* renamed from: c */
        private final C2987d f7798c;

        public C2991b(Factory factory, C2989e eVar, C2987d dVar) {
            this.f7796a = factory;
            this.f7797b = eVar;
            this.f7798c = dVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f7798c.mo27325a(this.f7796a.onCreateView(str, context, attributeSet), context, attributeSet);
        }
    }

    @TargetApi(11)
    /* renamed from: com.mikepenz.iconics.a.e$c */
    /* compiled from: InternalLayoutInflater */
    private static class C2992c implements Factory2 {

        /* renamed from: a */
        protected final Factory2 f7799a;

        /* renamed from: b */
        protected final C2987d f7800b;

        public C2992c(Factory2 factory2, C2987d dVar) {
            this.f7799a = factory2;
            this.f7800b = dVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f7800b.mo27325a(this.f7799a.onCreateView(str, context, attributeSet), context, attributeSet);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f7800b.mo27325a(this.f7799a.onCreateView(view, str, context, attributeSet), context, attributeSet);
        }
    }

    protected C2989e(LayoutInflater layoutInflater, Context context, boolean z) {
        super(layoutInflater, context);
        m8815a(z);
    }

    public LayoutInflater cloneInContext(Context context) {
        return new C2989e(this, context, true);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        View view = null;
        for (String createView : f7791a) {
            try {
                view = createView(str, createView, attributeSet);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (view == null) {
            view = super.onCreateView(str, attributeSet);
        }
        return this.f7792b.mo27325a(view, view.getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(View view, String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return this.f7792b.mo27325a(super.onCreateView(view, str, attributeSet), getContext(), attributeSet);
    }

    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        m8814a();
        return super.inflate(xmlPullParser, viewGroup, z);
    }

    /* renamed from: a */
    private void m8815a(boolean z) {
        if (!z && getFactory2() != null && !(getFactory2() instanceof C2992c)) {
            setFactory2(getFactory2());
        }
    }

    public void setFactory(Factory factory) {
        if (!(factory instanceof C2991b)) {
            super.setFactory(new C2991b(factory, this, this.f7792b));
        } else {
            super.setFactory(factory);
        }
    }

    @TargetApi(11)
    public void setFactory2(Factory2 factory2) {
        if (!(factory2 instanceof C2992c)) {
            super.setFactory2(new C2992c(factory2, this.f7792b));
        } else {
            super.setFactory2(factory2);
        }
    }

    /* renamed from: a */
    private void m8814a() {
        if (!this.f7793c) {
            if (!(getContext() instanceof Factory2)) {
                this.f7793c = true;
                return;
            }
            Method b = C2993f.m8820b(LayoutInflater.class, "setPrivateFactory");
            if (b != null) {
                C2993f.m8818a((Object) this, b, new C2990a((Factory2) getContext(), this, this.f7792b));
            }
            this.f7793c = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m8812a(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        if (view2 != null || str.indexOf(46) <= -1) {
            return view2;
        }
        if (this.f7794d == null) {
            this.f7794d = C2993f.m8817a(LayoutInflater.class, "mConstructorArgs");
        }
        Object[] objArr = (Object[]) C2993f.m8816a(this.f7794d, (Object) this);
        Object obj = objArr[0];
        objArr[0] = context;
        C2993f.m8819a(this.f7794d, (Object) this, (Object) objArr);
        try {
            View createView = createView(str, null, attributeSet);
            objArr[0] = obj;
            C2993f.m8819a(this.f7794d, (Object) this, (Object) objArr);
            return createView;
        } catch (ClassNotFoundException unused) {
            objArr[0] = obj;
            C2993f.m8819a(this.f7794d, (Object) this, (Object) objArr);
            return view2;
        } catch (Throwable th) {
            objArr[0] = obj;
            C2993f.m8819a(this.f7794d, (Object) this, (Object) objArr);
            throw th;
        }
    }
}
