package p140me.bridgefy.chat;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.C0840a.C0842a;
import androidx.p079f.p080a.C1049a;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bridgefy.sdk.client.BFEngineProfile;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Message.Builder;
import com.bridgefy.sdk.framework.controller.Session;
import com.bridgefy.sdk.framework.controller.SessionManager;
import com.mikepenz.iconics.p128a.C2986c;
import java.util.ArrayList;
import java.util.Iterator;
import me.bridgefy.main.R;
import p140me.bridgefy.chat.C3510a.C3511a;
import p140me.bridgefy.chat.C3512b.C3513a;
import p140me.bridgefy.chat.ChatFragment.C3499a;
import p140me.bridgefy.chat.ChatFragment.C3499a.C3500a;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.entities.transport.AppEntitySignal;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.main.TabbedMainActivity;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.service.p146c.C3619a;
import p140me.bridgefy.service.p147d.C3620a;
import p140me.bridgefy.service.p147d.C3622b;
import p140me.bridgefy.service.p148e.C3631b;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3662d;
import p140me.bridgefy.utils.C3662d.C3663a.C3664a;
import p140me.bridgefy.utils.C3667g;
import p140me.bridgefy.utils.C3667g.C3668a.C3669a;
import p140me.bridgefy.utils.C3672j;

/* renamed from: me.bridgefy.chat.ChatActivity */
public class ChatActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C0842a, C3500a, C3511a, C3513a, C3619a, C3664a, C3669a {

    /* renamed from: a */
    private String f9000a = "ChatActivity";

    /* renamed from: b */
    private FriendDTO f9001b;

    /* renamed from: c */
    private String f9002c;
    @BindView(2131296360)
    View chatLineHolder;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f9003d;

    /* renamed from: e */
    private String f9004e;

    /* renamed from: f */
    private String f9005f;

    /* renamed from: g */
    private String f9006g;

    /* renamed from: h */
    private C3460d f9007h;

    /* renamed from: i */
    private C3457c f9008i;

    /* renamed from: j */
    private C3662d f9009j;

    /* renamed from: k */
    private DatabaseHelper f9010k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ChatFragment f9011l;

    /* renamed from: m */
    private TextView f9012m;

    /* renamed from: n */
    private TextView f9013n;

    /* renamed from: o */
    private C3631b f9014o;

    /* renamed from: p */
    private BroadcastReceiver f9015p = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("chatMessage")) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("otherUserId", "");
                if (ChatActivity.this.f9011l != null && ChatActivity.this.f9011l.isVisible() && ChatActivity.this.f9003d.equals(string)) {
                    ChatActivity.this.f9011l.mo29129a(Message.create(extras.getString("bridgefyMessage")));
                    ChatActivity.this.mo29065d();
                }
            }
        }
    };
    @BindView(2131296364)
    Toolbar toolbar;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10105a(DialogInterface dialogInterface, int i) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_chat);
        ButterKnife.bind((Activity) this);
        this.f9002c = this.settings.getString("user_uuid", "");
        if (bundle != null) {
            this.f9003d = bundle.getString("otherUserId");
        }
        if (this.f9003d == null) {
            this.f9003d = getIntent().getStringExtra("otherUserId");
        }
        this.toolbar = (Toolbar) findViewById(R.id.chat_toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().mo854a(true);
        getSupportActionBar().mo858b(false);
        this.f9013n = (TextView) this.toolbar.findViewById(R.id.txtOtherUserName);
        this.f9012m = (TextView) this.toolbar.findViewById(R.id.inRangeBadge);
        this.f9010k = (DatabaseHelper) getHelper();
        this.f9007h = new C3460d(this.f9010k);
        this.f9008i = new C3457c(this.f9010k);
        m10112n();
        if (!isTaskRoot()) {
            return;
        }
        if (C3608c.m10649b() || BridgefyService.f9518b) {
            Log.d(this.f9000a, "Bringing the Bridgefy App to the foreground");
            startService(new Intent(this, BridgefyService.class).setAction("me.bridgefy.main.service.foreground"));
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BridgefyService.m10663b(this.f9003d);
        this.f9014o = new C3631b(this.f9000a, this);
        C1049a.m3996a((Context) this).mo4059a(this.f9014o, this.f9014o.mo29681a());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("chatMessageBackground");
        intentFilter.addAction("chatMessage");
        C1049a.m3996a((Context) this).mo4059a(this.f9015p, intentFilter);
        if (C3615a.m10678a().mo29651a(this.f9003d)) {
            m10109k();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("otherUserId", this.f9003d);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        C1049a.m3996a((Context) this).mo4058a(this.f9015p);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        BridgefyService.m10663b(null);
        C1049a.m3996a((Context) this).mo4058a((BroadcastReceiver) this.f9014o);
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        FrameLayout g = this.f9011l.mo29136g();
        if (g != null && g.getVisibility() == 0) {
            this.f9011l.mo29137h().setBackground(getDrawable(R.drawable.ic_insert_emoticon_grey600_24dp));
            g.setVisibility(8);
            LayoutParams layoutParams = (LayoutParams) this.chatLineHolder.getLayoutParams();
            layoutParams.addRule(12);
            this.chatLineHolder.setLayoutParams(layoutParams);
        } else if (this.f9011l.mo29138i().mo12065b()) {
            this.f9011l.mo29138i().mo12066c(true);
        } else if (isTaskRoot()) {
            m10114p();
        } else {
            super.onBackPressed();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 4) {
            if (i != 3303) {
                switch (i) {
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        break;
                    default:
                        if (!(intent == null || intent.getExtras() == null || intent.getStringExtra("otherUserId") == null)) {
                            this.f9003d = intent.getStringExtra("otherUserId");
                            break;
                        }
                }
            } else if (i2 == 0) {
                m10113o();
                invalidateOptionsMenu();
                if (this.f9011l != null) {
                    this.f9011l.mo29134e().setVisibility(8);
                }
            }
            super.onActivityResult(i, i2, intent);
        }
        if (C3667g.m10947b(getBaseContext())) {
            m10108c(i);
        } else {
            mo29062b();
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length > 0) {
            switch (i) {
                case 3:
                    if (!strArr[0].equals("android.permission.READ_CONTACTS") || iArr[0] != 0) {
                        mo29056a();
                        return;
                    } else {
                        mo29064c();
                        return;
                    }
                case 4:
                    break;
                default:
                    switch (i) {
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            break;
                        default:
                            return;
                    }
            }
            if (!strArr[0].equals("android.permission.WRITE_EXTERNAL_STORAGE") || iArr[0] != 0 || !strArr[1].equals("android.permission.READ_EXTERNAL_STORAGE") || iArr[1] != 0) {
                Log.e(this.f9000a, "Permissions denied!");
                C3667g.m10940a(this.f9011l.getView(), (Activity) this);
                C1049a.m3996a(BridgefyApp.m10557c().getBaseContext()).mo4060a(new Intent("permissionsDenied"));
                return;
            }
            m10108c(i);
            return;
        }
        Log.w(this.f9000a, "Permission request canceled by the user.");
    }

    /* renamed from: a */
    public void mo29056a() {
        C3662d.m10921a(this.f9011l.getView(), (Activity) this);
    }

    /* renamed from: b */
    public void mo29062b() {
        C3667g.m10940a(this.f9011l.getView(), (Activity) this);
    }

    /* renamed from: c */
    public void mo29064c() {
        m10113o();
    }

    /* renamed from: c */
    private void m10108c(int i) {
        switch (i) {
            case 11:
                this.f9011l.mo29130a(new C3667g(this, this.f9011l.getView(), Integer.valueOf(11)));
                return;
            case 12:
                this.f9011l.startActivityForResult(new Intent("android.intent.action.GET_CONTENT").setType("image/*"), 20);
                return;
            case 13:
                this.f9011l.mo29131b();
                return;
            default:
                this.f9011l.mo29079a().notifyDataSetChanged();
                return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        if (this.f9005f != null) {
            menu.add(0, 111, 0, R.string.action_contact_call);
        }
        if (this.f9006g != null) {
            menu.add(0, 121, 0, R.string.action_contact_view);
        }
        if (mo29067f()) {
            menu.add(0, 122, 0, R.string.action_contact_add_menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_contact_unblock).setVisible(this.f9001b.isBlocked());
        menu.findItem(R.id.action_contact_block).setVisible(!this.f9001b.isBlocked());
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 111:
                startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", this.f9005f, null)));
                break;
            case 121:
                startActivity(new Intent("android.intent.action.VIEW", Uri.withAppendedPath(Contacts.CONTENT_URI, String.valueOf(this.f9006g))));
                break;
            case 122:
                mo29069h();
                break;
            case 16908332:
                m10114p();
                break;
            case R.id.action_chat_delete /*2131296276*/:
                new C3510a().show(getFragmentManager(), C3510a.f9144a);
                break;
            case R.id.action_contact_block /*2131296278*/:
                this.f9008i.mo28327f(this.f9003d);
                this.f9001b.setBlockedStatus(3);
                this.f9008i.mo28321b();
                Toast.makeText(this, getString(R.string.action_contact_block_toast), 0).show();
                this.f9011l.mo29133d().setVisibility(0);
                this.f9011l.mo29135f().setVisibility(8);
                break;
            case R.id.action_contact_unblock /*2131296279*/:
                mo29058a(this.f9003d);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    public void mo29057a(int i) {
        String str = this.f9000a;
        StringBuilder sb = new StringBuilder();
        sb.append("Deleted ");
        sb.append(new C3460d((DatabaseHelper) getHelper()).deleteMessages(this.f9003d));
        sb.append(" local messages");
        Log.d(str, sb.toString());
        C3519c.m10306a(this.f9003d, this.f9002c, (C3521a) null);
        finish();
    }

    /* renamed from: a */
    public void mo29017a(BridgefyPeer bridgefyPeer, Antenna antenna) {
        if (bridgefyPeer.getId() != null && bridgefyPeer.getId().equals(this.f9003d)) {
            m10109k();
        }
    }

    /* renamed from: b */
    public void mo29018b(BridgefyPeer bridgefyPeer, Antenna antenna) {
        if (bridgefyPeer.getId() != null && bridgefyPeer.getId().equals(this.f9003d)) {
            m10110l();
        }
    }

    /* renamed from: a */
    public void mo29014a(Antenna antenna) {
        if (!new BridgefyPeer(this.f9003d).isPeerNearby()) {
            m10110l();
        }
    }

    /* renamed from: k */
    private void m10109k() {
        this.f9012m.setVisibility(0);
    }

    /* renamed from: l */
    private void m10110l() {
        this.f9012m.setVisibility(8);
    }

    /* renamed from: d */
    public void mo29065d() {
        m10111m();
        if (this.settings.getBoolean("settings_read_message", true)) {
            m10106a(SessionManager.getSession(this.f9003d));
        }
        C3620a.m10705a(this.f9003d);
    }

    /* renamed from: m */
    private void m10111m() {
        ArrayList a = this.f9007h.mo28330a(-1, this.f9003d);
        a.addAll(this.f9007h.mo28330a(-2, this.f9003d));
        Iterator it = a.iterator();
        while (it.hasNext()) {
            MessageDTO messageDTO = (MessageDTO) it.next();
            messageDTO.setStatus(5);
            this.f9007h.mo28338a(messageDTO);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(C2986c.m8809a(context));
    }

    /* renamed from: a */
    private void m10106a(Session session) {
        if (session != null) {
            try {
                ArrayList b = this.f9007h.mo28340b(5, this.f9003d);
                if (b.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = b.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((MessageDTO) it.next()).getDatabaseId());
                    }
                    AppEntitySignal appEntitySignal = new AppEntitySignal((String[]) arrayList.toArray(new String[arrayList.size()]));
                    Builder builder = new Builder();
                    builder.setReceiverId(session.getUserId()).setContent(appEntitySignal.toHashMap());
                    if (Bridgefy.sendMessage(builder.build(), BFEngineProfile.BFConfigProfileNoFowarding) != null) {
                        Iterator it2 = b.iterator();
                        while (it2.hasNext()) {
                            MessageDTO messageDTO = (MessageDTO) it2.next();
                            messageDTO.setStatus(-3);
                            this.f9007h.mo28338a(messageDTO);
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(this.f9000a, "User disconnected, unable to send READ_ACK", e);
            }
        } else {
            try {
                if (C3622b.m10715a(getApplicationContext(), BridgefyService.m10665d()).mo29663b()) {
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public Void doInBackground(Void... voidArr) {
                            C3622b.m10715a(ChatActivity.this.getApplicationContext(), BridgefyService.m10665d()).mo29660a(ChatActivity.this.f9003d, 5);
                            return null;
                        }
                    }.execute(new Void[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo29060a(Message message) {
        if (!C1049a.m3996a((Context) BridgefyApp.m10557c()).mo4060a(new Intent().setAction("chatMessageSendqueueBackground").putExtra("userId", this.f9003d).putExtra("bridgefyMessage", message != null ? message.serialize() : null)) && message != null) {
            message.setStatus(2);
            this.f9007h.mo28337a(message);
        }
    }

    /* renamed from: e */
    public void mo29066e() {
        this.f9011l.mo29132c();
    }

    /* renamed from: f */
    public boolean mo29067f() {
        return this.f9006g == null && this.f9005f != null;
    }

    /* renamed from: g */
    public boolean mo29068g() {
        return this.f9005f == null;
    }

    /* renamed from: h */
    public void mo29069h() {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/raw_contact").putExtra("phone", this.f9005f).putExtra("name", this.f9001b.getContactOrUsername());
        startActivityForResult(intent, 3303);
    }

    /* renamed from: n */
    private void m10112n() {
        this.f9001b = this.f9008i.mo28323c(this.f9003d);
        if (this.f9001b != null) {
            if (this.f9001b.getPublicKey() == null) {
                String str = this.f9000a;
                StringBuilder sb = new StringBuilder();
                sb.append("... no key for user: ");
                sb.append(this.f9001b.getId());
                Log.w(str, sb.toString());
                C3622b.m10715a((Context) this, (DatabaseHelper) getHelper()).mo29659a(this.f9001b.getId());
            } else {
                this.f9004e = this.f9001b.buildDisplayName();
            }
            this.f9005f = this.f9001b.getPhoneNumber();
            this.f9013n.setText(this.f9004e);
            return;
        }
        Toast.makeText(this, getString(R.string.error_try_again), 0).show();
        finish();
    }

    /* renamed from: o */
    private void m10113o() {
        if (!(this.f9005f == null || this.f9009j == null)) {
            Pair b = this.f9009j.mo29827b(this.f9005f);
            if (b == null || b.first == null || b.second == null) {
                this.f9001b.setContactName(null);
            } else {
                this.f9006g = (String) b.first;
                this.f9004e = (String) b.second;
                this.f9001b.setContactName(this.f9004e);
            }
            this.f9008i.mo28319a(this.f9001b);
        }
        this.f9013n.setText(this.f9004e);
    }

    /* renamed from: i */
    public boolean mo29070i() {
        return this.f9001b.isBlocked();
    }

    /* renamed from: b */
    public void mo29063b(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("stringId", i);
        bundle.putString("otherUserId", this.f9003d);
        bundle.putString("otherUserName", this.f9004e);
        C3499a aVar = new C3499a();
        aVar.setArguments(bundle);
        aVar.show(getFragmentManager(), C3499a.f9103a);
    }

    /* renamed from: a */
    public void mo29058a(String str) {
        this.f9008i.mo28328g(str);
        this.f9001b.setBlockedStatus(0);
        this.f9008i.mo28321b();
        Toast.makeText(this, getString(R.string.action_contact_unblock_toast), 0).show();
        this.f9011l.mo29133d().setVisibility(8);
        if (mo29068g()) {
            this.f9011l.mo29135f().setVisibility(0);
        }
    }

    @OnClick({2131296737})
    public void unverifiedContactInfo() {
        C3659b.m10907d((Context) this).setTitle((int) R.string.unverified_contact_title).setMessage((int) R.string.unverified_contact_desc).setPositiveButton(17039370, (OnClickListener) $$Lambda$ChatActivity$kEi_TpGsvcqUoaCTHv_QNLz7hww.INSTANCE).create().show();
    }

    /* renamed from: a */
    public void mo29059a(ChatFragment chatFragment) {
        this.f9011l = chatFragment;
        try {
            this.f9009j = new C3662d(this, chatFragment.getView());
            m10113o();
        } catch (C3672j e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    public C3662d mo29071j() {
        return this.f9009j;
    }

    /* renamed from: p */
    private void m10114p() {
        startActivity(new Intent(this, TabbedMainActivity.class));
        finish();
    }
}
