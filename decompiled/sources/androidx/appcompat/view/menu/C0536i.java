package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.R;
import androidx.appcompat.app.C0446c;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.appcompat.view.menu.C0549o.C0550a;

/* renamed from: androidx.appcompat.view.menu.i */
/* compiled from: MenuDialogHelper */
class C0536i implements OnClickListener, OnDismissListener, OnKeyListener, C0550a {

    /* renamed from: a */
    C0530f f1408a;

    /* renamed from: b */
    private C0533h f1409b;

    /* renamed from: c */
    private C0446c f1410c;

    /* renamed from: d */
    private C0550a f1411d;

    public C0536i(C0533h hVar) {
        this.f1409b = hVar;
    }

    /* renamed from: a */
    public void mo1560a(IBinder iBinder) {
        C0533h hVar = this.f1409b;
        C0447a aVar = new C0447a(hVar.getContext());
        this.f1408a = new C0530f(aVar.getContext(), R.layout.abc_list_menu_item_layout);
        this.f1408a.setCallback(this);
        this.f1409b.addMenuPresenter(this.f1408a);
        aVar.setAdapter(this.f1408a.mo1457a(), this);
        View headerView = hVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(hVar.getHeaderIcon()).setTitle(hVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        this.f1410c = aVar.create();
        this.f1410c.setOnDismissListener(this);
        LayoutParams attributes = this.f1410c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1410c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window = this.f1410c.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window2 = this.f1410c.getWindow();
                if (window2 != null) {
                    View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.f1409b.close(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1409b.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public void mo1559a() {
        if (this.f1410c != null) {
            this.f1410c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1408a.onCloseMenu(this.f1409b, true);
    }

    /* renamed from: a */
    public void mo1030a(C0533h hVar, boolean z) {
        if (z || hVar == this.f1409b) {
            mo1559a();
        }
        if (this.f1411d != null) {
            this.f1411d.mo1030a(hVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo1031a(C0533h hVar) {
        if (this.f1411d != null) {
            return this.f1411d.mo1031a(hVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1409b.performItemAction((C0537j) this.f1408a.mo1457a().getItem(i), 0);
    }
}
