package p140me.bridgefy.settings;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.core.app.C0840a;
import androidx.core.content.C0875a;
import androidx.legacy.p083a.C1135a;
import androidx.legacy.p083a.C1135a.C1142f;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import me.bridgefy.main.R;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.cloud.C3518b;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.intro.VerificationActivity;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.settings.SettingsFragment.BroadcastMessagesLoggingLevelDialogFragment;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3661c;
import p140me.bridgefy.utils.C3662d;
import p140me.bridgefy.utils.C3667g;

/* renamed from: me.bridgefy.settings.SettingsFragment */
public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener, C1142f {

    /* renamed from: a */
    C3641a f9600a;

    /* renamed from: b */
    String f9601b;

    /* renamed from: c */
    int f9602c;

    /* renamed from: d */
    Preference f9603d;

    /* renamed from: e */
    Preference f9604e;

    /* renamed from: f */
    Preference f9605f;

    /* renamed from: g */
    Preference f9606g;

    /* renamed from: h */
    Preference f9607h;

    /* renamed from: me.bridgefy.settings.SettingsFragment$BroadcastMessagesLoggingLevelDialogFragment */
    public static class BroadcastMessagesLoggingLevelDialogFragment extends DialogFragment {

        /* renamed from: a */
        public static String f9610a = "BroadcastMessagesLoggingLevelDialogFragment";

        /* renamed from: b */
        BridgefyOrmLiteBaseActivity f9611b;

        /* renamed from: c */
        C3640a f9612c;
        @BindView(2131296510)
        TextView loggingLevelLabel;
        @BindView(2131296602)
        SeekBar seekBar;

        /* renamed from: me.bridgefy.settings.SettingsFragment$BroadcastMessagesLoggingLevelDialogFragment$a */
        public interface C3640a {
            /* renamed from: a */
            void mo29716a(int i);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ void m10775a(DialogInterface dialogInterface, int i) {
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f9611b = (BridgefyOrmLiteBaseActivity) activity;
            this.f9612c = (C3640a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            C0447a d = C3659b.m10907d((Context) getActivity());
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_broadcast_messages_logging_level, null);
            ButterKnife.bind((Object) this, inflate);
            this.loggingLevelLabel.setText(String.format(getString(R.string.broadcast_msgs_level_summary), new Object[]{SettingsFragment.m10769b(getActivity(), getArguments().getInt("bcast_msgs_log_level"))}));
            this.seekBar.setProgress(this.f9611b.getSettings().getInt("bcast_msgs_log_level", getArguments().getInt("bcast_msgs_log_level")));
            this.seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    BroadcastMessagesLoggingLevelDialogFragment.this.loggingLevelLabel.setText(String.format(BroadcastMessagesLoggingLevelDialogFragment.this.getString(R.string.broadcast_msgs_level_summary), new Object[]{SettingsFragment.m10769b(BroadcastMessagesLoggingLevelDialogFragment.this.getActivity(), i)}));
                }
            });
            d.setView(inflate);
            d.setTitle((CharSequence) getString(R.string.broadcast_msgs_level_title)).setPositiveButton((int) R.string.ok, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    BroadcastMessagesLoggingLevelDialogFragment.this.m10776b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.cancel, (OnClickListener) C3632x2856d07f.INSTANCE);
            return d.create();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m10776b(DialogInterface dialogInterface, int i) {
            this.f9612c.mo29716a(this.seekBar.getProgress());
        }
    }

    /* renamed from: me.bridgefy.settings.SettingsFragment$BroadcastMessagesLoggingLevelDialogFragment_ViewBinding */
    public class BroadcastMessagesLoggingLevelDialogFragment_ViewBinding implements Unbinder {

        /* renamed from: a */
        private BroadcastMessagesLoggingLevelDialogFragment f9614a;

        public BroadcastMessagesLoggingLevelDialogFragment_ViewBinding(BroadcastMessagesLoggingLevelDialogFragment broadcastMessagesLoggingLevelDialogFragment, View view) {
            this.f9614a = broadcastMessagesLoggingLevelDialogFragment;
            broadcastMessagesLoggingLevelDialogFragment.seekBar = (SeekBar) Utils.findRequiredViewAsType(view, R.id.seekBar, "field 'seekBar'", SeekBar.class);
            broadcastMessagesLoggingLevelDialogFragment.loggingLevelLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.logging_level_label, "field 'loggingLevelLabel'", TextView.class);
        }

        public void unbind() {
            BroadcastMessagesLoggingLevelDialogFragment broadcastMessagesLoggingLevelDialogFragment = this.f9614a;
            if (broadcastMessagesLoggingLevelDialogFragment != null) {
                this.f9614a = null;
                broadcastMessagesLoggingLevelDialogFragment.seekBar = null;
                broadcastMessagesLoggingLevelDialogFragment.loggingLevelLabel = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9600a = (C3641a) activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getPreferenceManager().setSharedPreferencesName("BgfyPrefs");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getPreferenceManager().setSharedPreferencesName("BgfyPrefs");
        addPreferencesFromResource(R.xml.settings_sdk);
        findPreference("sett_sdk").setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsFragment.this.m10772d(preference);
            }
        });
        addPreferencesFromResource(R.xml.settings_account);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(FriendDTO.USER_NAME);
        editTextPreference.setSummary(m10765a(editTextPreference.getText()));
        if (!C3608c.m10650c()) {
            addPreferencesFromResource(R.xml.settings_verification);
            this.f9607h = findPreference("verification");
            this.f9607h.setSummary(m10765a(getString(R.string.verify_hint)));
            this.f9607h.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public final boolean onPreferenceClick(Preference preference) {
                    return SettingsFragment.this.m10771c(preference);
                }
            });
        }
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getSize(point);
        if (point.x <= 480) {
            addPreferencesFromResource(R.xml.settings_checkboxes);
        } else {
            addPreferencesFromResource(R.xml.settings_switches);
        }
        findPreference("settings_read_message").setSummary(m10765a(getString(R.string.settings_read_message_summary)));
        findPreference("settings_analytics").setSummary(m10765a(getString(R.string.settings_analytics_summary)));
        if (C0875a.m3245b((Context) getActivity(), "android.permission.READ_CONTACTS") != 0) {
            addPreferencesFromResource(R.xml.settings_permission_address_book);
            this.f9604e = findPreference("address_book_permission");
            this.f9604e.setSummary(m10765a(getString(R.string.settings_contacts_permission_summary)));
            this.f9604e.setOnPreferenceClickListener(m10764a(new String[]{"android.permission.READ_CONTACTS"}, 3));
        }
        if (!C3667g.m10942a((Context) getActivity())) {
            addPreferencesFromResource(R.xml.settings_permission_storage);
            this.f9605f = findPreference("storage_permission");
            this.f9605f.setSummary(m10765a(getString(R.string.settings_storage_permission_summary)));
            this.f9605f.setOnPreferenceClickListener(m10764a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 4));
        }
        if (C0875a.m3245b((Context) getActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            addPreferencesFromResource(R.xml.settings_permission_location);
            this.f9606g = findPreference("location_permission");
            this.f9606g.setSummary(m10765a(getString(R.string.settings_location_permission_summary)));
            this.f9606g.setOnPreferenceClickListener(m10764a(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2));
        }
        addPreferencesFromResource(R.xml.settings_footer);
        Preference findPreference = findPreference("settings_contact_us");
        findPreference.setSummary(m10765a(getString(R.string.settings_contact_us_summary)));
        findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsFragment.this.m10770b(preference);
            }
        });
        findPreference("settings_rate_app").setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public final boolean onPreferenceClick(Preference preference) {
                return SettingsFragment.this.m10767a(preference);
            }
        });
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setBackgroundColor(getResources().getColor(R.color.white));
        return onCreateView;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ boolean m10772d(Preference preference) {
        startActivity(new Intent(getActivity(), BridgefyInfoActivity.class));
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ boolean m10771c(Preference preference) {
        startActivityForResult(new Intent(BridgefyApp.m10557c().getApplicationContext(), VerificationActivity.class).putExtra("requestCode", 2323), 2323);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ boolean m10770b(Preference preference) {
        C3659b.m10887a(getActivity());
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m10767a(Preference preference) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(getActivity().getPackageName());
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://play.google.com/store/apps/details?id=");
            sb2.append(getActivity().getPackageName());
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb2.toString())));
        }
        return false;
    }

    /* renamed from: a */
    private OnPreferenceClickListener m10764a(String[] strArr, int i) {
        return new OnPreferenceClickListener(strArr, i) {
            private final /* synthetic */ String[] f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final boolean onPreferenceClick(Preference preference) {
                return SettingsFragment.this.m10768a(this.f$1, this.f$2, preference);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m10768a(String[] strArr, int i, Preference preference) {
        if (!C0840a.m3097a(getActivity(), strArr[0])) {
            C3659b.m10888a(getActivity(), 0);
        } else {
            C1135a.m4397a(this, strArr, i);
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    public void onPause() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSharedPreferenceChanged(android.content.SharedPreferences r4, java.lang.String r5) {
        /*
            r3 = this;
            android.preference.Preference r4 = r3.findPreference(r5)
            int r0 = r5.hashCode()
            r1 = 339340927(0x1439ee7f, float:9.387148E-27)
            r2 = 1
            if (r0 == r1) goto L_0x001e
            r1 = 1810088554(0x6be3c26a, float:5.506885E26)
            if (r0 == r1) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            java.lang.String r0 = "settings_analytics"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0028
            r5 = 1
            goto L_0x0029
        L_0x001e:
            java.lang.String r0 = "user_name"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0028
            r5 = 0
            goto L_0x0029
        L_0x0028:
            r5 = -1
        L_0x0029:
            switch(r5) {
                case 0: goto L_0x003d;
                case 1: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x009f
        L_0x002d:
            android.preference.TwoStatePreference r4 = (android.preference.TwoStatePreference) r4
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L_0x009f
            me.bridgefy.main.BridgefyApp r4 = p140me.bridgefy.main.BridgefyApp.m10557c()
            r4.mo29527b()
            goto L_0x009f
        L_0x003d:
            android.preference.EditTextPreference r4 = (android.preference.EditTextPreference) r4
            java.lang.String r5 = r4.getText()
            boolean r5 = p140me.bridgefy.utils.C3659b.m10908d(r5)
            if (r5 == 0) goto L_0x0089
            android.preference.PreferenceScreen r4 = r3.getPreferenceScreen()
            android.content.SharedPreferences r4 = r4.getSharedPreferences()
            r4.unregisterOnSharedPreferenceChangeListener(r3)
            android.preference.PreferenceScreen r4 = r3.getPreferenceScreen()
            android.content.SharedPreferences r4 = r4.getSharedPreferences()
            android.content.SharedPreferences$Editor r4 = r4.edit()
            java.lang.String r5 = "user_name"
            java.lang.String r0 = r3.f9601b
            android.content.SharedPreferences$Editor r4 = r4.putString(r5, r0)
            r4.commit()
            android.preference.PreferenceScreen r4 = r3.getPreferenceScreen()
            android.content.SharedPreferences r4 = r4.getSharedPreferences()
            r4.registerOnSharedPreferenceChangeListener(r3)
            android.app.Activity r4 = r3.getActivity()
            r5 = 2131689622(0x7f0f0096, float:1.9008265E38)
            java.lang.String r5 = r3.getString(r5)
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r5, r2)
            r4.show()
            goto L_0x009f
        L_0x0089:
            java.lang.String r5 = r4.getText()
            r3.f9601b = r5
            java.lang.String r5 = r3.f9601b
            android.text.Spanned r5 = m10765a(r5)
            r4.setSummary(r5)
            me.bridgefy.settings.a r4 = r3.f9600a
            java.lang.String r5 = r3.f9601b
            r4.mo29717a(r5)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.settings.SettingsFragment.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr[0] == 0) {
            Toast.makeText(BridgefyApp.m10557c().getApplicationContext(), getString(R.string.permission_granted), 0).show();
            switch (i) {
                case 2:
                    if (strArr[0].equals("android.permission.ACCESS_FINE_LOCATION")) {
                        getPreferenceScreen().removePreference(this.f9606g);
                        getActivity().getSharedPreferences("BgfyPrefs", 0).edit().putBoolean("permissionLocationInsist", true).apply();
                        return;
                    }
                    return;
                case 3:
                    if (strArr[0].equals("android.permission.READ_CONTACTS")) {
                        getPreferenceScreen().removePreference(this.f9604e);
                        getActivity().getSharedPreferences("BgfyPrefs", 0).edit().putBoolean("permissionContactsInsist", true).apply();
                        return;
                    }
                    return;
                case 4:
                    if (strArr[0].equals("android.permission.WRITE_EXTERNAL_STORAGE") && strArr[1].equals("android.permission.READ_EXTERNAL_STORAGE") && iArr[1] == 0) {
                        getPreferenceScreen().removePreference(this.f9605f);
                        getActivity().getSharedPreferences("BgfyPrefs", 0).edit().putBoolean("permissionStorageInsist", true).apply();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("SettingsActivity.onActivityResult(): requestCode: ");
        sb.append(i);
        Log.d("SettingsFragment", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i == 2323) {
            if (i2 == -1) {
                Toast.makeText(BridgefyApp.m10557c().getApplicationContext(), getString(R.string.user_verified), 0).show();
                try {
                    getPreferenceScreen().removePreference(this.f9607h);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                C3519c.m10314a((C3523c) new C3523c<BgfyUser>() {
                    /* renamed from: a */
                    public void onSuccess(BgfyUser bgfyUser) {
                        bgfyUser.setPhone(C3662d.m10924c(PhoneNumberUtil.normalizeDigitsOnly(C3608c.m10654g())));
                        C3519c.m10312a(bgfyUser, (C3521a) new C3521a() {
                            public void onComplete() {
                                Log.d("SettingsFragment", "Verified phone number successfuly updated in the backend");
                            }

                            public void onError(Throwable th) {
                                Log.e("SettingsFragment", "Unable to update phone number in the backend. Scheduling JobService", th);
                                SettingsFragment.this.getPreferenceScreen().getSharedPreferences().edit().putString("pendingPhoneUpdate", C3608c.m10654g()).apply();
                                C3518b.m10290a(BridgefyApp.m10557c().getApplicationContext(), 6003);
                            }
                        });
                    }

                    public void onError(Throwable th) {
                        Log.w("SettingsFragment", "Unable to update phone number. Scheduling JobService", th);
                        SettingsFragment.this.getPreferenceScreen().getSharedPreferences().edit().putString("pendingPhoneUpdate", C3608c.m10654g()).apply();
                        C3518b.m10290a(BridgefyApp.m10557c().getApplicationContext(), 6003);
                    }
                });
                return;
            }
            Toast.makeText(BridgefyApp.m10557c().getApplicationContext(), getString(R.string.error_try_again), 0).show();
        }
    }

    /* renamed from: a */
    public static Spanned m10765a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("<font color=\"#9b9b9b\">");
        sb.append(str);
        sb.append("</font>");
        return Html.fromHtml(sb.toString());
    }

    /* renamed from: a */
    public void mo29721a(int i) {
        this.f9602c = i;
        this.f9603d.setSummary(m10765a(String.format(getString(R.string.broadcast_msgs_level_summary), new Object[]{m10769b(getActivity(), i)})));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m10769b(Context context, int i) {
        if (C3661c.f9687a[i] == -1) {
            return context.getString(R.string.broadcast_msgs_level_all);
        }
        return String.valueOf(C3661c.f9687a[i]);
    }
}
