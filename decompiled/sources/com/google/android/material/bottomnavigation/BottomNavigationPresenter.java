package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0549o;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.view.menu.C0551p;
import androidx.appcompat.view.menu.C0559u;

public class BottomNavigationPresenter implements C0549o {

    /* renamed from: id */
    private int f6712id;
    private C0533h menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int selectedItemId;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
        }
    }

    public boolean collapseItemActionView(C0533h hVar, C0537j jVar) {
        return false;
    }

    public boolean expandItemActionView(C0533h hVar, C0537j jVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void onCloseMenu(C0533h hVar, boolean z) {
    }

    public boolean onSubMenuSelected(C0559u uVar) {
        return false;
    }

    public void setCallback(C0550a aVar) {
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    public void initForMenu(Context context, C0533h hVar) {
        this.menu = hVar;
        this.menuView.initialize(this.menu);
    }

    public C0551p getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    public void updateMenuView(boolean z) {
        if (!this.updateSuspended) {
            if (z) {
                this.menuView.buildMenuView();
            } else {
                this.menuView.updateMenuView();
            }
        }
    }

    public void setId(int i) {
        this.f6712id = i;
    }

    public int getId() {
        return this.f6712id;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.menuView.tryRestoreSelectedItemId(((SavedState) parcelable).selectedItemId);
        }
    }

    public void setUpdateSuspended(boolean z) {
        this.updateSuspended = z;
    }
}
