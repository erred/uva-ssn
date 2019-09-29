package p140me.bridgefy.contacts;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import me.bridgefy.main.R;
import p140me.bridgefy.contacts.BlockedUsersFragment.C3528b.C3529a;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.p141a.C3457c;

/* renamed from: me.bridgefy.contacts.BlockedUsersActivity */
public class BlockedUsersActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C3529a {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_blocked_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.blocked_toolbar);
        toolbar.setTitle((int) R.string.activity_block_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().mo854a(true);
    }

    /* renamed from: a */
    public void mo29220a() {
        ((BlockedUsersFragment) getFragmentManager().findFragmentByTag("blocked_contacts_fragment")).mo29222a();
    }

    /* renamed from: a */
    public void mo29221a(String str) {
        C3457c cVar = new C3457c((DatabaseHelper) getHelper());
        cVar.mo28328g(str);
        cVar.mo28321b();
        Toast.makeText(this, getString(R.string.action_contact_unblock_toast), 0).show();
    }
}
