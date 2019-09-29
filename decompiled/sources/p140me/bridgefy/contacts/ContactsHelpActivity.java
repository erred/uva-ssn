package p140me.bridgefy.contacts;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.appcompat.widget.Toolbar;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.bridgefy.main.R;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.contacts.ContactsHelpActivity */
public class ContactsHelpActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> {

    /* renamed from: me.bridgefy.contacts.ContactsHelpActivity$a */
    public static class C3533a extends DialogFragment {

        /* renamed from: a */
        public static String f9205a = "FeedbackImpossibleDF";

        /* access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ void m10366a(DialogInterface dialogInterface, int i) {
        }

        public Dialog onCreateDialog(Bundle bundle) {
            C0447a aVar = new C0447a(getActivity());
            aVar.setTitle((int) R.string.email_subject).setMessage((int) R.string.email_fallback).setPositiveButton((int) R.string.ok, (OnClickListener) $$Lambda$ContactsHelpActivity$a$arJNaz2NU9Cr_Z1irE7g1_wklI.INSTANCE);
            aVar.setCancelable(true);
            return aVar.create();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_contacts_help);
        ButterKnife.bind((Activity) this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.help_toolbar);
        toolbar.setTitle((CharSequence) getString(R.string.title_activity_contacts_help));
        setSupportActionBar(toolbar);
        getSupportActionBar().mo854a(true);
    }

    @OnClick({2131296458})
    public void onHelpClick() {
        C3659b.m10887a((Activity) this);
    }
}
