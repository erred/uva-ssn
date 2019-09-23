package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.R;
import androidx.appcompat.view.C0505b;
import androidx.appcompat.view.C0505b.C0506a;
import androidx.core.p070g.C0947d;
import androidx.core.p070g.C0947d.C0948a;

/* renamed from: androidx.appcompat.app.h */
/* compiled from: AppCompatDialog */
public class C0470h extends Dialog implements C0449e {
    private C0450f mDelegate;
    private final C0948a mKeyDispatcher;

    public void onSupportActionModeFinished(C0505b bVar) {
    }

    public void onSupportActionModeStarted(C0505b bVar) {
    }

    public C0505b onWindowStartingSupportActionMode(C0506a aVar) {
        return null;
    }

    public C0470h(Context context) {
        this(context, 0);
    }

    public C0470h(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new C0948a() {
            public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return C0470h.this.superDispatchKeyEvent(keyEvent);
            }
        };
        getDelegate().mo971a((Bundle) null);
        getDelegate().mo989j();
    }

    protected C0470h(Context context, boolean z, OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new C0948a() {
            public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return C0470h.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().mo988i();
        super.onCreate(bundle);
        getDelegate().mo971a(bundle);
    }

    public C0440a getSupportActionBar() {
        return getDelegate().mo968a();
    }

    public void setContentView(int i) {
        getDelegate().mo977b(i);
    }

    public void setContentView(View view) {
        getDelegate().mo972a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().mo973a(view, layoutParams);
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().mo967a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().mo975a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().mo975a((CharSequence) getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().mo979b(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().mo983d();
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().mo982c(i);
    }

    public void invalidateOptionsMenu() {
        getDelegate().mo985f();
    }

    public C0450f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0450f.m1334a((Dialog) this, (C0449e) this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: 0000 */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0947d.m3500a(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}
