package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0559u;

public class NavigationSubMenu extends C0559u {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, C0537j jVar) {
        super(context, navigationMenu, jVar);
    }

    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((C0533h) getParentMenu()).onItemsChanged(z);
    }
}
