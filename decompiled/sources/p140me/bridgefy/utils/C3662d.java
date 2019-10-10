package p140me.bridgefy.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.C0875a;
import com.google.android.material.snackbar.Snackbar;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.j256.ormlite.field.FieldType;
import java.util.HashMap;
import me.bridgefy.main.R;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3662d.C3663a;

/* renamed from: me.bridgefy.utils.d */
/* compiled from: ContactUtils */
public class C3662d {

    /* renamed from: a */
    private BridgefyOrmLiteBaseActivity f9692a;

    /* renamed from: me.bridgefy.utils.d$a */
    /* compiled from: ContactUtils */
    public static class C3663a extends DialogFragment {

        /* renamed from: a */
        public static String f9693a = "ContactsPermissionDeniedDialogFragment";

        /* renamed from: b */
        BridgefyOrmLiteBaseActivity f9694b;

        /* renamed from: c */
        C3664a f9695c;

        /* renamed from: d */
        boolean f9696d = false;

        /* renamed from: me.bridgefy.utils.d$a$a */
        /* compiled from: ContactUtils */
        public interface C3664a {
            /* renamed from: a */
            void mo29056a();
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f9694b = (BridgefyOrmLiteBaseActivity) activity;
            this.f9695c = (C3664a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return C3659b.m10907d((Context) getActivity()).setTitle((int) R.string.permission_dialog_title).setMessage((CharSequence) getString(R.string.contacts_permission_dialog_body)).setPositiveButton((int) R.string.permission_dialog_grant_access, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3663a.this.m10928b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.never_again, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3663a.this.m10927a(dialogInterface, i);
                }
            }).create();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m10928b(DialogInterface dialogInterface, int i) {
            this.f9696d = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10927a(DialogInterface dialogInterface, int i) {
            this.f9694b.getSettings().edit().putBoolean("permissionContactsInsist", false).apply();
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f9696d) {
                C3659b.m10889a((Activity) this.f9694b, new String[]{"android.permission.READ_CONTACTS"}, 3);
            } else {
                this.f9695c.mo29056a();
            }
            super.onDismiss(dialogInterface);
        }
    }

    public C3662d(BridgefyOrmLiteBaseActivity bridgefyOrmLiteBaseActivity, View view) throws C3672j {
        this.f9692a = bridgefyOrmLiteBaseActivity;
        if (!m10923a((Context) bridgefyOrmLiteBaseActivity)) {
            if (bridgefyOrmLiteBaseActivity.getSettings().getBoolean("permissionContactsInsist", true)) {
                if (bridgefyOrmLiteBaseActivity.getFragmentManager().findFragmentByTag(C3663a.f9693a) == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Displaying dialog from activity: ");
                    sb.append(bridgefyOrmLiteBaseActivity.getLocalClassName());
                    Log.d("ContactUtils", sb.toString());
                    bridgefyOrmLiteBaseActivity.getFragmentManager().beginTransaction().add(new C3663a(), C3663a.f9693a).commitAllowingStateLoss();
                }
            } else if (view != null) {
                m10921a(view, (Activity) bridgefyOrmLiteBaseActivity);
            }
            throw new C3672j("READ_CONTACTS permission NOT GRANTED");
        }
    }

    /* renamed from: a */
    public static boolean m10923a(Context context) {
        return C0875a.m3245b(context, "android.permission.READ_CONTACTS") == 0;
    }

    /* renamed from: a */
    public static boolean m10922a(Activity activity) {
        try {
            activity.startActivityForResult(new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI), 222);
            return true;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(activity.getBaseContext(), activity.getString(R.string.error), 0).show();
            return false;
        }
    }

    /* renamed from: a */
    public HashMap<String, Pair<String, String>> get_phone_records(String str) {
        String c = str != null ? m10924c(str) : "";
        HashMap<String, Pair<String, String>> hashMap = new HashMap<>();
        Cursor query = this.f9692a.getContentResolver().query(Phone.CONTENT_URI, new String[]{"data1", "display_name", "data2"}, null, null, null);
        int columnIndex = query.getColumnIndex("data1");
        int columnIndex2 = query.getColumnIndex("display_name");
        int columnIndex3 = query.getColumnIndex("data2");
        if (query.getCount() >= 1) {
            while (query.moveToNext()) {
                String c2 = m10924c(query.getString(columnIndex));
                if (c2 != null && !c2.equals(c)) {
                    hashMap.put(c2, new Pair(query.getString(columnIndex2), (String) Phone.getTypeLabel(this.f9692a.getResources(), query.getInt(columnIndex3), "")));
                }
            }
        } else {
            Log.w("ContactUtils", "No phone records found on phone!");
        }
        query.close();
        return hashMap;
    }

    /* renamed from: b */
    public Pair<String, String> mo29827b(String str) {
        try {
            Cursor query = BridgefyApp.m10557c().getBaseContext().getContentResolver().query(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "display_name"}, null, null, null);
            if (query != null) {
                String str2 = null;
                String str3 = null;
                while (query.moveToNext()) {
                    str2 = query.getString(query.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                    str3 = query.getString(query.getColumnIndexOrThrow("display_name"));
                }
                query.close();
                return new Pair<>(str2, str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public static String m10919a(Context context, String str) throws C3672j {
        String str2 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    str2 = query.getString(query.getColumnIndexOrThrow("display_name"));
                }
                query.close();
            }
            return str2;
        } catch (SecurityException unused) {
            throw new C3672j("READ_CONTACTS permission DENIED");
        }
    }

    /* renamed from: c */
    public static String m10924c(String str) {
        String normalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(str);
        if (normalizeDigitsOnly.length() > 10) {
            return normalizeDigitsOnly.substring(normalizeDigitsOnly.length() - 10);
        }
        if (normalizeDigitsOnly.length() < 10) {
            return null;
        }
        return normalizeDigitsOnly;
    }

    /* renamed from: a */
    public static void m10921a(View view, Activity activity) {
        if (activity != null) {
            Snackbar.make(view, (CharSequence) activity.getBaseContext().getString(R.string.contacts_permission_denied_snack), 0).setAction((CharSequence) activity.getBaseContext().getString(R.string.permission_dialog_grant_access), (View.OnClickListener) new View.OnClickListener(activity) {
                private final /* synthetic */ Activity f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    C3659b.m10889a(this.f$0, new String[]{"android.permission.READ_CONTACTS"}, 3);
                }
            }).show();
        }
    }
}
