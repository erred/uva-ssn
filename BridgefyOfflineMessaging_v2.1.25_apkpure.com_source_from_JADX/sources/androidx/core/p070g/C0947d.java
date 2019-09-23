package androidx.core.p070g;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.g.d */
/* compiled from: KeyEventDispatcher */
public class C0947d {

    /* renamed from: a */
    private static boolean f2998a = false;

    /* renamed from: b */
    private static Method f2999b = null;

    /* renamed from: c */
    private static boolean f3000c = false;

    /* renamed from: d */
    private static Field f3001d;

    /* renamed from: androidx.core.g.d$a */
    /* compiled from: KeyEventDispatcher */
    public interface C0948a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    /* renamed from: a */
    public static boolean m3499a(View view, KeyEvent keyEvent) {
        return C0962r.m3567a(view, keyEvent);
    }

    /* renamed from: a */
    public static boolean m3500a(C0948a aVar, View view, Callback callback, KeyEvent keyEvent) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 28) {
            return aVar.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return m3497a((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return m3498a((Dialog) callback, keyEvent);
        }
        if ((view != null && C0962r.m3572b(view, keyEvent)) || aVar.superDispatchKeyEvent(keyEvent)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m3496a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f2998a) {
            try {
                f2999b = actionBar.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
            } catch (NoSuchMethodException unused) {
            }
            f2998a = true;
        }
        if (f2999b != null) {
            try {
                return ((Boolean) f2999b.invoke(actionBar, new Object[]{keyEvent})).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m3497a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && m3496a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0962r.m3572b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    /* renamed from: a */
    private static OnKeyListener m3495a(Dialog dialog) {
        if (!f3000c) {
            try {
                f3001d = Dialog.class.getDeclaredField("mOnKeyListener");
                f3001d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3000c = true;
        }
        if (f3001d != null) {
            try {
                return (OnKeyListener) f3001d.get(dialog);
            } catch (IllegalAccessException unused2) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m3498a(Dialog dialog, KeyEvent keyEvent) {
        OnKeyListener a = m3495a(dialog);
        if (a != null && a.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0962r.m3572b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }
}
