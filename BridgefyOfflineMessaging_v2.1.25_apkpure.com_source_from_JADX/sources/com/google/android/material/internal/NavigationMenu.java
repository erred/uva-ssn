package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0559u;

public class NavigationMenu extends C0533h {
    public NavigationMenu(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0537j jVar = (C0537j) addInternal(i, i2, i3, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, jVar);
        jVar.mo1568a((C0559u) navigationSubMenu);
        return navigationSubMenu;
    }
}
