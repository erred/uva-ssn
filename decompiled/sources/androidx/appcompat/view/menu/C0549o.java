package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* renamed from: androidx.appcompat.view.menu.o */
/* compiled from: MenuPresenter */
public interface C0549o {

    /* renamed from: androidx.appcompat.view.menu.o$a */
    /* compiled from: MenuPresenter */
    public interface C0550a {
        /* renamed from: a */
        void mo1030a(C0533h hVar, boolean z);

        /* renamed from: a */
        boolean mo1031a(C0533h hVar);
    }

    boolean collapseItemActionView(C0533h hVar, C0537j jVar);

    boolean expandItemActionView(C0533h hVar, C0537j jVar);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, C0533h hVar);

    void onCloseMenu(C0533h hVar, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(C0559u uVar);

    void setCallback(C0550a aVar);

    void updateMenuView(boolean z);
}
