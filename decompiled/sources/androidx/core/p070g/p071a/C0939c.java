package androidx.core.p070g.p071a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.core.g.a.c */
/* compiled from: AccessibilityNodeProviderCompat */
public class C0939c {

    /* renamed from: a */
    private final Object f2992a;

    /* renamed from: androidx.core.g.a.c$a */
    /* compiled from: AccessibilityNodeProviderCompat */
    static class C0940a extends AccessibilityNodeProvider {

        /* renamed from: a */
        final C0939c f2993a;

        C0940a(C0939c cVar) {
            this.f2993a = cVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            C0935b a = this.f2993a.mo3721a(i);
            if (a == null) {
                return null;
            }
            return a.mo3668a();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List a = this.f2993a.mo3723a(str, i);
            if (a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((C0935b) a.get(i2)).mo3668a());
            }
            return arrayList;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f2993a.mo3724a(i, i2, bundle);
        }
    }

    /* renamed from: androidx.core.g.a.c$b */
    /* compiled from: AccessibilityNodeProviderCompat */
    static class C0941b extends C0940a {
        C0941b(C0939c cVar) {
            super(cVar);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            C0935b b = this.f2993a.mo3725b(i);
            if (b == null) {
                return null;
            }
            return b.mo3668a();
        }
    }

    /* renamed from: a */
    public C0935b mo3721a(int i) {
        return null;
    }

    /* renamed from: a */
    public List<C0935b> mo3723a(String str, int i) {
        return null;
    }

    /* renamed from: a */
    public boolean mo3724a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: b */
    public C0935b mo3725b(int i) {
        return null;
    }

    public C0939c() {
        if (VERSION.SDK_INT >= 19) {
            this.f2992a = new C0941b(this);
        } else if (VERSION.SDK_INT >= 16) {
            this.f2992a = new C0940a(this);
        } else {
            this.f2992a = null;
        }
    }

    public C0939c(Object obj) {
        this.f2992a = obj;
    }

    /* renamed from: a */
    public Object mo3722a() {
        return this.f2992a;
    }
}
