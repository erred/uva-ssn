package p140me.bridgefy.main;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.C0875a;
import androidx.legacy.p083a.C1144b;
import androidx.p079f.p080a.C1049a;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.C1475f;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.squareup.p131a.C3017h;
import java.lang.ref.WeakReference;
import net.sqlcipher.database.SQLiteDatabase;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.broadcast.BroadcastLoaderFragment;
import p140me.bridgefy.chat.C3510a.C3511a;
import p140me.bridgefy.chat.ChatActivity;
import p140me.bridgefy.chat.ChatEntryFragment;
import p140me.bridgefy.chat.LocationFragment.C3505a;
import p140me.bridgefy.chat.LocationFragment.C3505a.C3506a;
import p140me.bridgefy.chat.LocationFragment.C3507b;
import p140me.bridgefy.chat.LocationFragment.C3507b.C3508a;
import p140me.bridgefy.cloud.C3518b;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.cloud.StartupIntentService;
import p140me.bridgefy.contacts.C3535a;
import p140me.bridgefy.contacts.C3535a.C3536a;
import p140me.bridgefy.contacts.ContactsFragment;
import p140me.bridgefy.contacts.ContactsHelpActivity;
import p140me.bridgefy.integration.LogTestsActivity;
import p140me.bridgefy.intro.SignupActivity;
import p140me.bridgefy.intro.SplashActivity;
import p140me.bridgefy.intro.VerificationActivity;
import p140me.bridgefy.intro.verification.C3588k;
import p140me.bridgefy.intro.verification.C3588k.C3589a;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.settings.BridgefyInfoActivity;
import p140me.bridgefy.settings.DevelopmentOptionsActivity;
import p140me.bridgefy.settings.SettingsActivity;
import p140me.bridgefy.utils.C3657a;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3662d;
import p140me.bridgefy.utils.C3662d.C3663a.C3664a;
import p140me.bridgefy.utils.C3670h;
import p140me.bridgefy.utils.C3672j;

/* renamed from: me.bridgefy.main.TabbedMainActivity */
public class TabbedMainActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C3506a, C3508a, C3511a, C3536a, C3589a, C3664a {

    /* renamed from: a */
    Fragment[] f9463a = new Fragment[3];

    /* renamed from: b */
    ContactsFragment f9464b;

    /* renamed from: c */
    ChatEntryFragment f9465c;
    @BindView(2131296378)
    CoordinatorLayout coordinatorLayout;

    /* renamed from: d */
    BroadcastLoaderFragment f9466d;

    /* renamed from: e */
    MenuItem f9467e;

    /* renamed from: f */
    C3600a f9468f;
    @BindView(2131296429)
    public FloatingActionButton fabNewConversation;

    /* renamed from: g */
    C3601b f9469g;

    /* renamed from: h */
    C3662d f9470h;

    /* renamed from: i */
    public BroadcastReceiver f9471i = new BroadcastReceiver() {
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r2, android.content.Intent r3) {
            /*
                r1 = this;
                java.lang.String r2 = r3.getAction()
                int r3 = r2.hashCode()
                r0 = -1590531947(0xffffffffa1326895, float:-6.044716E-19)
                if (r3 == r0) goto L_0x001d
                r0 = 1393756494(0x5313094e, float:6.315163E11)
                if (r3 == r0) goto L_0x0013
                goto L_0x0027
            L_0x0013:
                java.lang.String r3 = "antennaStateChangedSignal"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L_0x0027
                r2 = 0
                goto L_0x0028
            L_0x001d:
                java.lang.String r3 = "location.disabled"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L_0x0027
                r2 = 1
                goto L_0x0028
            L_0x0027:
                r2 = -1
            L_0x0028:
                switch(r2) {
                    case 0: goto L_0x0032;
                    case 1: goto L_0x002c;
                    default: goto L_0x002b;
                }
            L_0x002b:
                goto L_0x0037
            L_0x002c:
                me.bridgefy.main.TabbedMainActivity r2 = p140me.bridgefy.main.TabbedMainActivity.this
                r2.mo29159e()
                goto L_0x0037
            L_0x0032:
                me.bridgefy.main.TabbedMainActivity r2 = p140me.bridgefy.main.TabbedMainActivity.this
                r2.m10587p()
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.main.TabbedMainActivity.C35982.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* renamed from: j */
    public C1475f f9472j = new C1475f() {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            Animation loadAnimation = AnimationUtils.loadAnimation(TabbedMainActivity.this, R.anim.view_exit_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(TabbedMainActivity.this, R.anim.view_entry_anim);
            TabbedMainActivity.this.invalidateOptionsMenu();
            switch (i) {
                case 0:
                    TabbedMainActivity.this.tabLayout.getTabAt(0).setIcon((int) R.drawable.ic_contacts_active);
                    TabbedMainActivity.this.tabLayout.getTabAt(1).setIcon((int) R.drawable.ic_chats);
                    TabbedMainActivity.this.tabLayout.getTabAt(2).setIcon((int) R.drawable.ic_broadcast);
                    TabbedMainActivity.this.toolbar.setTitle((int) R.string.title_activity_contacts);
                    m10608c(loadAnimation);
                    m10607b(loadAnimation2);
                    return;
                case 1:
                    TabbedMainActivity.this.tabLayout.getTabAt(0).setIcon((int) R.drawable.ic_contacts);
                    TabbedMainActivity.this.tabLayout.getTabAt(1).setIcon((int) R.drawable.ic_chats_active);
                    TabbedMainActivity.this.tabLayout.getTabAt(2).setIcon((int) R.drawable.ic_broadcast);
                    TabbedMainActivity.this.toolbar.setTitle((int) R.string.title_activity_chats);
                    m10609d(loadAnimation2);
                    m10606a(loadAnimation);
                    return;
                case 2:
                    TabbedMainActivity.this.tabLayout.getTabAt(0).setIcon((int) R.drawable.ic_contacts);
                    TabbedMainActivity.this.tabLayout.getTabAt(1).setIcon((int) R.drawable.ic_chats);
                    TabbedMainActivity.this.tabLayout.getTabAt(2).setIcon((int) R.drawable.ic_broadcast_active);
                    TabbedMainActivity.this.toolbar.setTitle((int) R.string.title_activity_broadcast);
                    m10608c(loadAnimation);
                    m10606a(loadAnimation);
                    return;
                default:
                    return;
            }
        }

        /* renamed from: a */
        private void m10606a(Animation animation) {
            if (TabbedMainActivity.this.tooltipNewFriend.getVisibility() == 0) {
                TabbedMainActivity.this.tooltipNewFriend.setAnimation(animation);
                TabbedMainActivity.this.tooltipNewFriend.setVisibility(8);
            }
        }

        /* renamed from: b */
        private void m10607b(Animation animation) {
            if (TabbedMainActivity.this.settings.getBoolean("tooltipNewFriend", true)) {
                TabbedMainActivity.this.tooltipNewFriend.setAnimation(animation);
                TabbedMainActivity.this.tooltipNewFriend.setVisibility(0);
            }
        }

        /* renamed from: c */
        private void m10608c(Animation animation) {
            if (TabbedMainActivity.this.fabNewConversation.getVisibility() == 0) {
                TabbedMainActivity.this.fabNewConversation.setAnimation(animation);
                TabbedMainActivity.this.fabNewConversation.setVisibility(8);
                if (TabbedMainActivity.this.settings.getBoolean("tooltipNewConversation", true)) {
                    TabbedMainActivity.this.tooltipNewConversation.setAnimation(animation);
                    TabbedMainActivity.this.tooltipNewConversation.setVisibility(8);
                }
                if (TabbedMainActivity.this.settings.getBoolean("tooltipSDK", true)) {
                    TabbedMainActivity.this.tooltipSdk.setAnimation(animation);
                    TabbedMainActivity.this.tooltipSdk.setVisibility(8);
                }
            }
        }

        /* renamed from: d */
        private void m10609d(Animation animation) {
            TabbedMainActivity.this.fabNewConversation.setAnimation(animation);
            TabbedMainActivity.this.fabNewConversation.setVisibility(0);
            if (TabbedMainActivity.this.settings.getBoolean("tooltipNewConversation", true)) {
                TabbedMainActivity.this.tooltipNewConversation.setAnimation(animation);
                TabbedMainActivity.this.tooltipNewConversation.setVisibility(0);
            }
            if (TabbedMainActivity.this.settings.getBoolean("tooltipSDK", true)) {
                TabbedMainActivity.this.tooltipSdk.setAnimation(animation);
                TabbedMainActivity.this.tooltipSdk.setVisibility(0);
            }
        }
    };

    /* renamed from: k */
    private String f9473k = "currentFragment";
    @BindView(2131296639)
    public TabLayout tabLayout;
    @BindView(2131296663)
    public Toolbar toolbar;
    @BindView(2131296665)
    public RelativeLayout tooltipNewConversation;
    @BindView(2131296666)
    public RelativeLayout tooltipNewFriend;
    @BindView(2131296667)
    public RelativeLayout tooltipSdk;
    @BindView(2131296745)
    public ViewPager viewPager;

    /* renamed from: me.bridgefy.main.TabbedMainActivity$a */
    public class C3600a extends BroadcastReceiver {

        /* renamed from: b */
        private int f9479b;

        /* renamed from: c */
        private boolean f9480c = false;

        C3600a(int i) {
            this.f9479b = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo29547a() {
            C1049a.m3996a((Context) TabbedMainActivity.this).mo4059a(this, new IntentFilter("bridgefy.event.start"));
            this.f9480c = true;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f9479b == 2) {
                Toast.makeText(TabbedMainActivity.this.getBaseContext(), R.string.broadcast_toast, 0).show();
            }
        }

        /* renamed from: b */
        public void mo29548b() {
            if (this.f9480c) {
                C1049a.m3996a((Context) TabbedMainActivity.this).mo4058a((BroadcastReceiver) this);
                this.f9480c = false;
            }
        }

        /* renamed from: c */
        public boolean mo29549c() {
            return this.f9480c;
        }
    }

    /* renamed from: me.bridgefy.main.TabbedMainActivity$b */
    class C3601b extends C1144b {

        /* renamed from: b */
        private WeakReference<BridgefyOrmLiteBaseActivity> f9482b;

        /* renamed from: b */
        public int mo6151b() {
            return 3;
        }

        C3601b() {
            super(TabbedMainActivity.this.getFragmentManager());
        }

        /* renamed from: a */
        public Fragment mo4569a(int i) {
            Fragment fragment = TabbedMainActivity.this.f9463a[i];
            if (fragment == null) {
                switch (i) {
                    case 0:
                        TabbedMainActivity.this.f9464b = new ContactsFragment();
                        TabbedMainActivity.this.f9463a[0] = TabbedMainActivity.this.f9464b;
                        return TabbedMainActivity.this.f9464b;
                    case 1:
                        TabbedMainActivity.this.f9465c = new ChatEntryFragment();
                        TabbedMainActivity.this.f9463a[1] = TabbedMainActivity.this.f9465c;
                        return TabbedMainActivity.this.f9465c;
                    case 2:
                        TabbedMainActivity.this.f9466d = new BroadcastLoaderFragment();
                        TabbedMainActivity.this.f9463a[2] = TabbedMainActivity.this.f9466d;
                        return TabbedMainActivity.this.f9466d;
                }
            }
            return fragment;
        }

        /* renamed from: a */
        public void mo29551a(BridgefyOrmLiteBaseActivity bridgefyOrmLiteBaseActivity) {
            this.f9482b = new WeakReference<>(bridgefyOrmLiteBaseActivity);
        }

        /* renamed from: a */
        public Object mo4499a(ViewGroup viewGroup, int i) {
            Fragment fragment = (Fragment) super.mo4499a(viewGroup, i);
            switch (i) {
                case 0:
                    Fragment[] fragmentArr = TabbedMainActivity.this.f9463a;
                    ContactsFragment contactsFragment = (ContactsFragment) fragment;
                    TabbedMainActivity.this.f9464b = contactsFragment;
                    fragmentArr[0] = contactsFragment;
                    break;
                case 1:
                    Fragment[] fragmentArr2 = TabbedMainActivity.this.f9463a;
                    ChatEntryFragment chatEntryFragment = (ChatEntryFragment) fragment;
                    TabbedMainActivity.this.f9465c = chatEntryFragment;
                    fragmentArr2[1] = chatEntryFragment;
                    break;
                case 2:
                    Fragment[] fragmentArr3 = TabbedMainActivity.this.f9463a;
                    BroadcastLoaderFragment broadcastLoaderFragment = (BroadcastLoaderFragment) fragment;
                    TabbedMainActivity.this.f9466d = broadcastLoaderFragment;
                    fragmentArr3[2] = broadcastLoaderFragment;
                    break;
            }
            return fragment;
        }

        /* renamed from: b */
        public void mo4505b(ViewGroup viewGroup) {
            BridgefyOrmLiteBaseActivity bridgefyOrmLiteBaseActivity = (BridgefyOrmLiteBaseActivity) this.f9482b.get();
            if (bridgefyOrmLiteBaseActivity != null && !bridgefyOrmLiteBaseActivity.isStateSaved() && !bridgefyOrmLiteBaseActivity.isFinishing() && !bridgefyOrmLiteBaseActivity.isDestroyed()) {
                try {
                    super.mo4505b(viewGroup);
                } catch (NullPointerException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Catched the NullPointerException in FragmentPagerAdapter.finishUpdate().\n");
                    sb.append(e);
                    Log.w("TabbedMainActivity", sb.toString());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BridgefyApp.m10557c().mo29530g().mo27385a((Object) this);
        m10569b(bundle);
    }

    /* renamed from: b */
    private void m10569b(Bundle bundle) {
        Log.v("TabbedMainActivity", "Checking login state...");
        if (C3608c.m10652e()) {
            m10571c(bundle);
            return;
        }
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            Log.w("TabbedMainActivity", "... user logged in only with Firebase...");
            String phoneNumber = currentUser.getPhoneNumber();
            String uid = currentUser.getUid();
            StringBuilder sb = new StringBuilder();
            sb.append("... ... phone: ");
            sb.append(phoneNumber);
            Log.v("TabbedMainActivity", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("... ... providerId: ");
            sb2.append(uid);
            Log.v("TabbedMainActivity", sb2.toString());
            Log.w("TabbedMainActivity", "... attempting login with provided information");
            startActivity(new Intent(getApplicationContext(), SignupActivity.class).putExtra("phone", phoneNumber).putExtra("providerId", uid).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        } else {
            Log.w("TabbedMainActivity", "No registered user, cleaning up and starting LoginActivity");
            this.settings.edit().clear().apply();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, SplashActivity.class));
        }
        finish();
    }

    /* renamed from: c */
    private void m10571c(Bundle bundle) {
        Log.d("TabbedMainActivity", "...logged in user! Initializing Main Activity :)");
        setContentView((int) R.layout.activity_tabbed_main);
        ButterKnife.bind((Activity) this);
        this.toolbar.setTitle((CharSequence) getString(R.string.title_activity_chats));
        setSupportActionBar(this.toolbar);
        this.f9469g = new C3601b();
        this.f9469g.mo29551a((BridgefyOrmLiteBaseActivity) this);
        this.viewPager.setAdapter(this.f9469g);
        this.viewPager.mo6069a(this.f9472j);
        this.viewPager.setOffscreenPageLimit(2);
        this.tooltipNewFriend.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                TabbedMainActivity.this.m10584h(view);
            }
        });
        if (this.settings.getBoolean("tooltipSDK", true)) {
            this.tooltipSdk.setVisibility(0);
            this.tooltipSdk.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    TabbedMainActivity.this.m10582g(view);
                }
            });
        }
        if (this.settings.getBoolean("tooltipNewConversation", true)) {
            this.tooltipNewConversation.setVisibility(0);
            this.tooltipNewConversation.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    TabbedMainActivity.this.m10580f(view);
                }
            });
        }
        this.fabNewConversation.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                TabbedMainActivity.this.m10578e(view);
            }
        });
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.tabLayout.setTabGravity(0);
        this.viewPager.post(new Runnable(bundle) {
            private final /* synthetic */ Bundle f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                TabbedMainActivity.this.m10575d(this.f$1);
            }
        });
        m10587p();
        try {
            this.f9470h = new C3662d(this, findViewById(R.id.coordinatorLayout));
        } catch (C3672j e) {
            e.printStackTrace();
        }
        startService(new Intent(this, StartupIntentService.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m10584h(View view) {
        this.tooltipNewFriend.setAnimation(AnimationUtils.loadAnimation(this, R.anim.view_exit_anim));
        this.tooltipNewFriend.setVisibility(8);
        this.settings.edit().putBoolean("tooltipNewFriend", false).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m10582g(View view) {
        this.tooltipSdk.setAnimation(AnimationUtils.loadAnimation(this, R.anim.view_exit_anim));
        this.tooltipSdk.setVisibility(8);
        startActivity(new Intent(this, BridgefyInfoActivity.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m10580f(View view) {
        this.tooltipNewConversation.setAnimation(AnimationUtils.loadAnimation(this, R.anim.view_exit_anim));
        this.tooltipNewConversation.setVisibility(8);
        this.settings.edit().putBoolean("tooltipNewConversation", false).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m10578e(View view) {
        this.viewPager.setCurrentItem(0);
        this.settings.edit().putBoolean("tooltipNewConversation", false).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m10575d(Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            i = bundle.getInt(this.f9473k, 1);
        }
        this.viewPager.mo6065a(i, false);
        if (i == 0) {
            this.f9472j.onPageSelected(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (C3608c.m10649b()) {
            Log.d("TabbedMainActivity", "Bringing the Bridgefy App to the foreground");
            startService(new Intent(this, BridgefyService.class).setAction("me.bridgefy.main.service.foreground"));
            if (!C3608c.m10650c() && C3659b.m10909e((Context) this)) {
                mo29535i();
                return;
            }
            return;
        }
        Log.w("TabbedMainActivity", "No valid Bridgefy license was found. Requesting Bridgefy SDK registration.");
        mo29533b(1);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.v("TabbedMainActivity", "onResume(): services available");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("antennaStateChangedSignal");
        intentFilter.addAction("location.disabled");
        C1049a.m3996a((Context) this).mo4059a(this.f9471i, intentFilter);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.viewPager != null) {
            bundle.putInt(this.f9473k, this.viewPager.getCurrentItem());
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        C1049a.m3996a((Context) this).mo4058a(this.f9471i);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.w("TabbedMainActivity", "onDestroy()");
        BridgefyApp.m10557c().mo29530g().mo27388b((Object) this);
        if (this.f9468f != null && this.f9468f.mo29549c()) {
            this.f9468f.mo29548b();
        }
        if (isFinishing()) {
            Log.w("TabbedMainActivity", "isFinishing()");
            C3659b.m10890a(BridgefyApp.m10557c().getApplicationContext());
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("TabbedMainActivity.onActivityResult(): requestCode: ");
        sb.append(i);
        Log.d("TabbedMainActivity", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i != 5) {
            if (i == 222) {
                if (this.tooltipNewFriend != null && this.tooltipNewFriend.getVisibility() == 0) {
                    this.tooltipNewFriend.setAnimation(AnimationUtils.loadAnimation(this, R.anim.view_exit_anim));
                    this.tooltipNewFriend.setVisibility(8);
                }
                m10567a(false);
            } else if (i != 999) {
                if (i != 2323) {
                    if (i != 4403) {
                        switch (i) {
                            case 2:
                                if (BridgefyUtils.checkLocationPermissions(getBaseContext())) {
                                    m10586o();
                                    return;
                                } else {
                                    mo29158d();
                                    return;
                                }
                            case 3:
                                if (C3662d.m10923a(getBaseContext())) {
                                    m10585n();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else {
                        Log.d("TabbedMainActivity", "Broadcast closed");
                        this.f9466d.mo29027a();
                    }
                } else if (i2 == -1) {
                    Toast.makeText(this, getString(R.string.user_verified), 0).show();
                    C3519c.m10314a((C3523c) new C3523c<BgfyUser>() {
                        /* renamed from: a */
                        public void onSuccess(BgfyUser bgfyUser) {
                            bgfyUser.setPhone(C3662d.m10924c(PhoneNumberUtil.normalizeDigitsOnly(C3608c.m10654g())));
                            C3519c.m10312a(bgfyUser, (C3521a) new C3521a() {
                                public void onComplete() {
                                    Log.d("TabbedMainActivity", "Verified phone number successfuly updated in the backend");
                                }

                                public void onError(Throwable th) {
                                    Log.e("TabbedMainActivity", "Unable to update phone number in the backend. Scheduling JobService", th);
                                    TabbedMainActivity.this.settings.edit().putString("pendingPhoneUpdate", C3608c.m10654g()).apply();
                                    C3518b.m10290a(TabbedMainActivity.this.getApplicationContext(), 6003);
                                }
                            });
                        }

                        public void onError(Throwable th) {
                            Log.w("TabbedMainActivity", "Unable to update phone number. Scheduling JobService", th);
                            TabbedMainActivity.this.settings.edit().putString("pendingPhoneUpdate", C3608c.m10654g()).apply();
                            C3518b.m10290a(TabbedMainActivity.this.getApplicationContext(), 6003);
                        }
                    });
                } else {
                    Toast.makeText(this, getString(R.string.error_try_again), 0).show();
                }
            } else if (i2 == 0) {
                Toast.makeText(this, getString(R.string.error_play_services_unavailable), 1).show();
                finish();
            } else {
                m10571c(intent.getExtras());
            }
        } else if (BridgefyUtils.isLocationAvailable(getApplicationContext())) {
            BridgefyApp.m10557c().mo29530g().mo27391c((Object) "command.services.start");
        } else {
            mo29159e();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.action_contact_add);
        this.f9467e = findItem;
        if (!(findItem == null || this.viewPager == null)) {
            boolean z = false;
            this.f9467e.setVisible(this.viewPager.getCurrentItem() == 0);
            MenuItem findItem2 = menu.findItem(R.id.action_refresh);
            if (this.viewPager.getCurrentItem() == 0) {
                z = true;
            }
            findItem2.setVisible(z);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 222:
                startActivity(new Intent(this, DevelopmentOptionsActivity.class));
                break;
            case 223:
                startActivity(new Intent(this, LogTestsActivity.class));
                break;
            case R.id.action_about /*2131296267*/:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.action_contact_add /*2131296277*/:
                this.settings.edit().putBoolean("tooltipNewFriend", false).apply();
                C3662d.m10922a((Activity) this);
                break;
            case R.id.action_help /*2131296283*/:
                if (this.f9464b.emptyContactsView != null && this.f9464b.emptyContactsView.getVisibility() == 0) {
                    startActivity(new Intent(this, ContactsHelpActivity.class));
                    break;
                } else {
                    new C3670h().show(getFragmentManager(), "troubleshootDialogFragment");
                    break;
                }
            case R.id.action_refresh /*2131296291*/:
                Log.d("TabbedMainActivity", "Click on refresh()");
                m10567a(true);
                break;
            case R.id.action_settings /*2131296292*/:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.action_share /*2131296293*/:
                C3659b.m10895a(new WeakReference<>(this));
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        if (!this.settings.getBoolean("tooltipSDK", true)) {
            return super.onMenuOpened(i, menu);
        }
        this.tooltipSdk.setVisibility(8);
        startActivity(new Intent(this, BridgefyInfoActivity.class));
        return true;
    }

    /* renamed from: a */
    public void mo29254a(Bundle bundle) {
        startActivity(new Intent(this, ChatActivity.class).putExtras(bundle));
    }

    /* renamed from: b */
    public void mo29255b() {
        finish();
    }

    @C3017h
    public void showShareContentConfirmationDialogOrStartChatActivity(Bundle bundle) {
        if (mo29532a(getIntent(), bundle)) {
            C3535a aVar = new C3535a();
            aVar.setArguments(bundle);
            aVar.show(getFragmentManager(), C3535a.f9210a);
            getFragmentManager().beginTransaction().show(aVar).commitAllowingStateLoss();
            return;
        }
        mo29254a(bundle);
    }

    /* renamed from: a */
    public boolean mo29532a(Intent intent, Bundle bundle) {
        String action = intent.getAction();
        String type = intent.getType();
        if ("android.intent.action.SEND".equals(action) && type != null) {
            bundle.putString("share_type", type);
            if (type.equals("text/plain")) {
                String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
                if (stringExtra != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Sharing: ");
                    sb.append(stringExtra);
                    Log.d("TabbedMainActivity", sb.toString());
                    bundle.putString("share_content", stringExtra);
                    return true;
                }
            } else if (type.startsWith("image/")) {
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                if (uri != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("will write from: ");
                    sb2.append(uri.toString());
                    Log.d("TabbedMainActivity", sb2.toString());
                    bundle.putString("share_content", uri.toString());
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: h */
    public void mo29534h() {
        this.settings.edit().putLong("verificationTimer", System.currentTimeMillis()).apply();
        Snackbar.make((View) this.coordinatorLayout, (CharSequence) getString(R.string.verify_snackbar), 0).setAction((CharSequence) getString(R.string.verify), (OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                TabbedMainActivity.this.m10576d(view);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m10576d(View view) {
        startActivityForResult(new Intent(getApplicationContext(), VerificationActivity.class).putExtra("requestCode", 2323), 2323);
    }

    /* renamed from: i */
    public void mo29535i() {
        if (System.currentTimeMillis() - this.settings.getLong("verificationTimer", System.currentTimeMillis() - 86400000) <= 86400000) {
            return;
        }
        if (this.settings.getBoolean("remindVerification", true)) {
            new C3588k().show(getFragmentManager(), C3588k.f9453a);
        } else {
            mo29534h();
        }
    }

    /* renamed from: c */
    public void mo29509c() {
        mo29534h();
    }

    /* renamed from: g */
    public void mo29511g() {
        mo29534h();
        this.settings.edit().putBoolean("remindVerification", false).apply();
    }

    /* renamed from: f */
    public void mo29510f() {
        startActivityForResult(new Intent(getApplicationContext(), VerificationActivity.class).putExtra("requestCode", 2323), 2323);
    }

    /* renamed from: a */
    public void mo29057a(int i) {
        this.f9465c.mo29108b(i);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Log.d("TabbedMainActivity", "onRequestPermissionsResult()");
        if (iArr.length <= 0 || strArr.length <= 0) {
            Log.w("TabbedMainActivity", "Permission request canceled by the user.");
            return;
        }
        switch (i) {
            case 2:
                if (iArr[0] == 0) {
                    m10586o();
                    return;
                } else {
                    mo29158d();
                    return;
                }
            case 3:
                if (iArr[0] == 0) {
                    m10585n();
                    return;
                } else {
                    mo29056a();
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: n */
    private void m10585n() {
        Log.v("TabbedMainActivity", "onContactsPermissionsGranted()");
        try {
            this.f9470h = new C3662d(this, findViewById(R.id.coordinatorLayout));
            m10567a(true);
        } catch (C3672j e) {
            e.printStackTrace();
        }
    }

    /* renamed from: o */
    private void m10586o() {
        if (BridgefyUtils.isLocationAvailable(getBaseContext())) {
            BridgefyApp.m10557c().mo29530g().mo27391c((Object) "command.services.start");
        } else {
            mo29537k();
        }
    }

    /* renamed from: a */
    public void mo29056a() {
        C3662d.m10921a((View) this.coordinatorLayout, (Activity) this);
    }

    /* renamed from: j */
    public void mo29536j() {
        if (getFragmentManager().findFragmentByTag(C3505a.f9132a) != null) {
            return;
        }
        if (getSettings().getBoolean("permissionLocationInsist", true)) {
            new C3505a().show(getFragmentManager(), C3505a.f9132a);
        } else {
            mo29158d();
        }
    }

    /* renamed from: d */
    public void mo29158d() {
        Snackbar.make((View) this.coordinatorLayout, (CharSequence) getString(R.string.location_permission_for_discovery_snack), 0).setAction((CharSequence) getString(R.string.permission_dialog_grant_access), (OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                TabbedMainActivity.this.m10572c(view);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10572c(View view) {
        C3659b.m10889a((Activity) this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2);
    }

    /* renamed from: k */
    public void mo29537k() {
        try {
            if (getSettings().getBoolean("permissionLocationInsist", true)) {
                C3507b bVar = new C3507b();
                Bundle bundle = new Bundle();
                bundle.putInt("stringId", R.string.location_disabled_for_discovery);
                bVar.setArguments(bundle);
                bVar.show(getFragmentManager(), C3507b.f9136a);
                return;
            }
            mo29159e();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void mo29159e() {
        Snackbar.make((View) this.coordinatorLayout, (CharSequence) getString(R.string.location_disabled_for_discovery_snack), 0).setAction((CharSequence) getString(R.string.dialog_enable), (OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                TabbedMainActivity.this.m10570b(view);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10570b(View view) {
        startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[SYNTHETIC, Splitter:B:17:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @com.squareup.p131a.C3017h
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLocationPermissionRequest(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1666599631(0x63564acf, float:3.9529938E21)
            if (r0 == r1) goto L_0x0028
            r1 = 1728327711(0x6704301f, float:6.2424005E23)
            if (r0 == r1) goto L_0x001e
            r1 = 1731637708(0x6736b1cc, float:8.627505E23)
            if (r0 == r1) goto L_0x0014
            goto L_0x0032
        L_0x0014:
            java.lang.String r0 = "locationPermissionDialog"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = 0
            goto L_0x0033
        L_0x001e:
            java.lang.String r0 = "locationPermissionDenied"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = 1
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "locationServicesDisabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = 2
            goto L_0x0033
        L_0x0032:
            r4 = -1
        L_0x0033:
            switch(r4) {
                case 0: goto L_0x005f;
                case 1: goto L_0x005b;
                case 2: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0079
        L_0x0037:
            me.bridgefy.chat.LocationFragment$b r4 = new me.bridgefy.chat.LocationFragment$b     // Catch:{ IllegalStateException -> 0x0056 }
            r4.<init>()     // Catch:{ IllegalStateException -> 0x0056 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ IllegalStateException -> 0x0056 }
            r0.<init>()     // Catch:{ IllegalStateException -> 0x0056 }
            java.lang.String r1 = "stringId"
            r2 = 2131689750(0x7f0f0116, float:1.9008524E38)
            r0.putInt(r1, r2)     // Catch:{ IllegalStateException -> 0x0056 }
            r4.setArguments(r0)     // Catch:{ IllegalStateException -> 0x0056 }
            android.app.FragmentManager r0 = r3.getFragmentManager()     // Catch:{ IllegalStateException -> 0x0056 }
            java.lang.String r1 = p140me.bridgefy.chat.LocationFragment.C3507b.f9136a     // Catch:{ IllegalStateException -> 0x0056 }
            r4.show(r0, r1)     // Catch:{ IllegalStateException -> 0x0056 }
            goto L_0x0079
        L_0x0056:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0079
        L_0x005b:
            r3.mo29158d()
            goto L_0x0079
        L_0x005f:
            android.app.FragmentManager r4 = r3.getFragmentManager()
            java.lang.String r0 = p140me.bridgefy.chat.LocationFragment.C3505a.f9132a
            android.app.Fragment r4 = r4.findFragmentByTag(r0)
            if (r4 != 0) goto L_0x0079
            me.bridgefy.chat.LocationFragment$a r4 = new me.bridgefy.chat.LocationFragment$a
            r4.<init>()
            android.app.FragmentManager r0 = r3.getFragmentManager()
            java.lang.String r1 = p140me.bridgefy.chat.LocationFragment.C3505a.f9132a
            r4.show(r0, r1)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.main.TabbedMainActivity.onLocationPermissionRequest(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m10587p() {
        boolean z = true;
        if (C0875a.m3245b(getBaseContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            mo29536j();
        } else if (!BridgefyUtils.isLocationAvailable(getBaseContext())) {
            mo29537k();
        } else if (!C3659b.m10906c(getBaseContext())) {
            if (!this.settings.getBoolean("showSignalMessage", true)) {
                mo29538l();
            } else if (getFragmentManager().findFragmentByTag(C3657a.f9675a) == null) {
                getFragmentManager().beginTransaction().add(new C3657a(), C3657a.f9675a).commitAllowingStateLoss();
            }
        }
        boolean z2 = C0875a.m3245b(getBaseContext(), "android.permission.BLUETOOTH") == -1;
        if (C0875a.m3245b(getBaseContext(), "android.permission.BLUETOOTH_ADMIN") != -1) {
            z = false;
        }
        if (z2 || z) {
            Snackbar.make((View) this.coordinatorLayout, (CharSequence) getString(R.string.bluetooth_permission), 0).show();
        }
    }

    /* renamed from: l */
    public void mo29538l() {
        Snackbar.make((View) this.coordinatorLayout, (CharSequence) getString(R.string.bluetooth_disabled_dialog), 0).setAction((CharSequence) getString(R.string.enable_bluetooth), (OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                TabbedMainActivity.this.m10566a(view);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10566a(View view) {
        C3659b.m10892a(getBaseContext(), true);
    }

    /* renamed from: a */
    private void m10567a(boolean z) {
        if (this.f9464b != null) {
            this.f9464b.mo29234a(z);
        } else {
            Log.w("TabbedMainActivity", "Can't update ContactsFragment because it hasn't been attached yet");
        }
    }

    /* renamed from: b */
    public void mo29533b(int i) {
        startService(new Intent(getBaseContext(), BridgefyService.class).putExtra("userId", C3608c.m10653f()).setAction("command.bridgefy.init_reg"));
        this.f9468f = new C3600a(i);
        this.f9468f.mo29547a();
    }

    public void onBackPressed() {
        if (this.viewPager == null || !(this.viewPager.getCurrentItem() == 0 || this.viewPager.getCurrentItem() == 2)) {
            if (C3608c.m10651d()) {
                if (VERSION.SDK_INT >= 26) {
                    startForegroundService(new Intent(this, BridgefyService.class).setAction("me.bridgefy.main.service.background"));
                } else {
                    startService(new Intent(this, BridgefyService.class).setAction("me.bridgefy.main.service.background"));
                }
            }
            super.onBackPressed();
            return;
        }
        this.viewPager.setCurrentItem(1);
    }

    /* renamed from: m */
    public C3662d mo29539m() {
        return this.f9470h;
    }
}
