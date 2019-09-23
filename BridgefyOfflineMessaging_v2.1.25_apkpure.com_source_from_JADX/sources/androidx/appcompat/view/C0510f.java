package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.C0505b.C0506a;
import androidx.appcompat.view.menu.C0553q;
import androidx.core.p062a.p063a.C0836a;
import androidx.core.p062a.p063a.C0837b;
import androidx.p052b.C0725g;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.f */
/* compiled from: SupportActionModeWrapper */
public class C0510f extends ActionMode {

    /* renamed from: a */
    final Context f1227a;

    /* renamed from: b */
    final C0505b f1228b;

    /* renamed from: androidx.appcompat.view.f$a */
    /* compiled from: SupportActionModeWrapper */
    public static class C0511a implements C0506a {

        /* renamed from: a */
        final Callback f1229a;

        /* renamed from: b */
        final Context f1230b;

        /* renamed from: c */
        final ArrayList<C0510f> f1231c = new ArrayList<>();

        /* renamed from: d */
        final C0725g<Menu, Menu> f1232d = new C0725g<>();

        public C0511a(Context context, Callback callback) {
            this.f1230b = context;
            this.f1229a = callback;
        }

        /* renamed from: a */
        public boolean mo1033a(C0505b bVar, Menu menu) {
            return this.f1229a.onCreateActionMode(mo1279b(bVar), m1682a(menu));
        }

        /* renamed from: b */
        public boolean mo1035b(C0505b bVar, Menu menu) {
            return this.f1229a.onPrepareActionMode(mo1279b(bVar), m1682a(menu));
        }

        /* renamed from: a */
        public boolean mo1034a(C0505b bVar, MenuItem menuItem) {
            return this.f1229a.onActionItemClicked(mo1279b(bVar), C0553q.m1862a(this.f1230b, (C0837b) menuItem));
        }

        /* renamed from: a */
        public void mo1032a(C0505b bVar) {
            this.f1229a.onDestroyActionMode(mo1279b(bVar));
        }

        /* renamed from: a */
        private Menu m1682a(Menu menu) {
            Menu menu2 = (Menu) this.f1232d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu a = C0553q.m1861a(this.f1230b, (C0836a) menu);
            this.f1232d.put(menu, a);
            return a;
        }

        /* renamed from: b */
        public ActionMode mo1279b(C0505b bVar) {
            int size = this.f1231c.size();
            for (int i = 0; i < size; i++) {
                C0510f fVar = (C0510f) this.f1231c.get(i);
                if (fVar != null && fVar.f1228b == bVar) {
                    return fVar;
                }
            }
            C0510f fVar2 = new C0510f(this.f1230b, bVar);
            this.f1231c.add(fVar2);
            return fVar2;
        }
    }

    public C0510f(Context context, C0505b bVar) {
        this.f1227a = context;
        this.f1228b = bVar;
    }

    public Object getTag() {
        return this.f1228b.mo1250j();
    }

    public void setTag(Object obj) {
        this.f1228b.mo1249a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1228b.mo1103b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1228b.mo1099a(charSequence);
    }

    public void invalidate() {
        this.f1228b.mo1105d();
    }

    public void finish() {
        this.f1228b.mo1104c();
    }

    public Menu getMenu() {
        return C0553q.m1861a(this.f1227a, (C0836a) this.f1228b.mo1101b());
    }

    public CharSequence getTitle() {
        return this.f1228b.mo1107f();
    }

    public void setTitle(int i) {
        this.f1228b.mo1097a(i);
    }

    public CharSequence getSubtitle() {
        return this.f1228b.mo1108g();
    }

    public void setSubtitle(int i) {
        this.f1228b.mo1102b(i);
    }

    public View getCustomView() {
        return this.f1228b.mo1110i();
    }

    public void setCustomView(View view) {
        this.f1228b.mo1098a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f1228b.mo1096a();
    }

    public boolean getTitleOptionalHint() {
        return this.f1228b.mo1251k();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1228b.mo1100a(z);
    }

    public boolean isTitleOptional() {
        return this.f1228b.mo1109h();
    }
}
