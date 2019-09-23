package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.app.C0444b.C0445a;
import androidx.appcompat.view.C0505b;
import androidx.appcompat.view.C0505b.C0506a;
import androidx.appcompat.widget.C0655ba;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.C0840a;
import androidx.core.app.C0852e;
import androidx.core.app.C0868m;
import androidx.core.app.C0868m.C0869a;
import androidx.fragment.p081a.C1071e;

/* renamed from: androidx.appcompat.app.d */
/* compiled from: AppCompatActivity */
public class C0448d extends C1071e implements C0449e, C0869a {
    private C0450f mDelegate;
    private Resources mResources;
    private int mThemeId = 0;

    public void onPrepareSupportNavigateUpTaskStack(C0868m mVar) {
    }

    public void onSupportActionModeFinished(C0505b bVar) {
    }

    public void onSupportActionModeStarted(C0505b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public C0505b onWindowStartingSupportActionMode(C0506a aVar) {
        return null;
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        C0450f delegate = getDelegate();
        delegate.mo988i();
        delegate.mo971a(bundle);
        if (delegate.mo989j() && this.mThemeId != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.mThemeId, false);
            } else {
                setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().mo978b(bundle);
    }

    public C0440a getSupportActionBar() {
        return getDelegate().mo968a();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().mo974a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().mo976b();
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

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().mo979b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().mo970a(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getDelegate().mo984e();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getDelegate().mo980c();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().mo983d();
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().mo967a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0440a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.mo848a() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getDelegate().mo986g();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().mo975a(charSequence);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().mo982c(i);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().mo985f();
    }

    public void invalidateOptionsMenu() {
        getDelegate().mo985f();
    }

    public C0505b startSupportActionMode(C0506a aVar) {
        return getDelegate().mo969a(aVar);
    }

    public void onCreateSupportNavigateUpTaskStack(C0868m mVar) {
        mVar.mo3542a((Activity) this);
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            C0868m a = C0868m.m3217a((Context) this);
            onCreateSupportNavigateUpTaskStack(a);
            onPrepareSupportNavigateUpTaskStack(a);
            a.mo3545a();
            try {
                C0840a.m3092a(this);
            } catch (IllegalStateException unused) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    public Intent getSupportParentActivityIntent() {
        return C0852e.m3111a(this);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return C0852e.m3113a((Activity) this, intent);
    }

    public void supportNavigateUpTo(Intent intent) {
        C0852e.m3116b((Activity) this, intent);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public C0445a getDrawerToggleDelegate() {
        return getDelegate().mo987h();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().mo981c(bundle);
    }

    public C0450f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0450f.m1333a((Activity) this, (C0449e) this);
        }
        return this.mDelegate;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        C0440a supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.mo856a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public Resources getResources() {
        if (this.mResources == null && C0655ba.m2310a()) {
            this.mResources = new C0655ba(this, super.getResources());
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }

    private boolean performMenuItemShortcut(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode())) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void openOptionsMenu() {
        C0440a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.mo860c()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        C0440a supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.mo862d()) {
            super.closeOptionsMenu();
        }
    }
}
