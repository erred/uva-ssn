package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;
import androidx.core.p062a.p063a.C0837b;
import androidx.core.p070g.C0943b.C0945b;

/* renamed from: androidx.appcompat.view.menu.l */
/* compiled from: MenuItemWrapperJB */
class C0544l extends C0539k {

    /* renamed from: androidx.appcompat.view.menu.l$a */
    /* compiled from: MenuItemWrapperJB */
    class C0545a extends C0540a implements VisibilityListener {

        /* renamed from: c */
        C0945b f1450c;

        public C0545a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        /* renamed from: a */
        public View mo1689a(MenuItem menuItem) {
            return this.f1445a.onCreateActionView(menuItem);
        }

        /* renamed from: d */
        public boolean mo1691d() {
            return this.f1445a.overridesItemVisibility();
        }

        /* renamed from: e */
        public boolean mo1692e() {
            return this.f1445a.isVisible();
        }

        /* renamed from: a */
        public void mo1690a(C0945b bVar) {
            this.f1450c = bVar;
            this.f1445a.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1450c != null) {
                this.f1450c.mo1624a(z);
            }
        }
    }

    C0544l(Context context, C0837b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0540a mo1625a(ActionProvider actionProvider) {
        return new C0545a(this.f1349a, actionProvider);
    }
}
