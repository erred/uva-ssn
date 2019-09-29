package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.p070g.C0947d;
import androidx.core.p070g.C0947d.C0948a;
import androidx.lifecycle.C1172e;
import androidx.lifecycle.C1172e.C1174b;
import androidx.lifecycle.C1176g;
import androidx.lifecycle.C1177h;
import androidx.lifecycle.C1186o;
import androidx.p052b.C0725g;

/* renamed from: androidx.core.app.d */
/* compiled from: ComponentActivity */
public class C0850d extends Activity implements C0948a, C1176g {
    private C0725g<Class<? extends C0851a>, C0851a> mExtraDataMap = new C0725g<>();
    private C1177h mLifecycleRegistry = new C1177h(this);

    /* renamed from: androidx.core.app.d$a */
    /* compiled from: ComponentActivity */
    public static class C0851a {
    }

    public void putExtraData(C0851a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1186o.m4491a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.mo4606a(C1174b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public <T extends C0851a> T getExtraData(Class<T> cls) {
        return (C0851a) this.mExtraDataMap.get(cls);
    }

    public C1172e getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0947d.m3499a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0947d.m3499a(decorView, keyEvent)) {
            return C0947d.m3500a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
