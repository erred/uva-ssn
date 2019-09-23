package p140me.bridgefy.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.appcompat.widget.Toolbar;
import me.bridgefy.main.R;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.cloud.C3518b;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.contacts.BlockedUsersActivity;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.settings.SettingsFragment.BroadcastMessagesLoggingLevelDialogFragment.C3640a;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.settings.SettingsActivity */
public class SettingsActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C3640a, C3641a {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10759a(DialogInterface dialogInterface, int i) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.settings_toolbar);
        toolbar.setTitle((int) R.string.settings);
        setSupportActionBar(toolbar);
        getSupportActionBar().mo854a(true);
        setTheme(R.style.SettingsTheme);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_blocked_users) {
            startActivity(new Intent(this, BlockedUsersActivity.class));
        } else if (itemId == R.id.action_sign_out) {
            C0447a d = C3659b.m10907d((Context) this);
            d.setTitle((int) R.string.signout);
            d.setMessage((int) R.string.signout_question).setPositiveButton((int) R.string.yes, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsActivity.this.m10760b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.no, (OnClickListener) $$Lambda$SettingsActivity$8H1RDR_O5rWnkeqORpnVsGfvxj8.INSTANCE);
            d.create().show();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10760b(DialogInterface dialogInterface, int i) {
        C3608c.m10642a(this, (DatabaseHelper) getHelper(), 1);
    }

    /* renamed from: a */
    public void mo29717a(final String str) {
        final Editor edit = this.settings.edit();
        C3519c.m10314a((C3523c) new C3523c<BgfyUser>() {
            /* renamed from: a */
            public void onSuccess(BgfyUser bgfyUser) {
                bgfyUser.setPublicName(str);
                C3519c.m10312a(bgfyUser, (C3521a) new C3521a() {
                    public void onComplete() {
                        Log.d("Settings", "User was succesfully updated.");
                        Toast.makeText(SettingsActivity.this.getApplicationContext(), SettingsActivity.this.getString(R.string.settings_update_success), 0).show();
                        edit.remove("pendingChangeUsername").apply();
                    }

                    public void onError(Throwable th) {
                        Log.w("Settings", "Unable to update username. Scheduling JobService", th);
                        Toast.makeText(SettingsActivity.this.getApplicationContext(), SettingsActivity.this.getString(R.string.settings_update_failure), 1).show();
                        edit.putString("pendingChangeUsername", str).apply();
                        C3518b.m10290a(SettingsActivity.this.getApplicationContext(), 6003);
                    }
                });
            }

            public void onError(Throwable th) {
                Log.w("Settings", "Unable to update username. Scheduling JobService", th);
                Toast.makeText(SettingsActivity.this.getApplicationContext(), SettingsActivity.this.getString(R.string.settings_update_failure), 1).show();
                edit.putString("pendingChangeUsername", str).apply();
                C3518b.m10290a(SettingsActivity.this.getApplicationContext(), 6003);
            }
        });
    }

    /* renamed from: a */
    public void mo29716a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Setting BroadcastMessagesLoggingLevel to: ");
        sb.append(i);
        Log.d("Settings", sb.toString());
        this.settings.edit().putInt("bcast_msgs_log_level", i).apply();
        ((SettingsFragment) getFragmentManager().findFragmentByTag("settings")).mo29721a(i);
    }
}
