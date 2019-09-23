package p140me.bridgefy.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.p079f.p080a.C1049a;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.framework.controller.DeviceManager;
import me.bridgefy.main.R;
import p140me.bridgefy.broadcast.BroadcastFragment.C3464b;
import p140me.bridgefy.broadcast.BroadcastFragment.C3464b.C3465a;
import p140me.bridgefy.broadcast.BroadcastFragment.C3466c.C3467a;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.transport.AppEntityBroadcast;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.service.p146c.C3619a;
import p140me.bridgefy.service.p148e.C3631b;

/* renamed from: me.bridgefy.broadcast.BroadcastActivity */
public class BroadcastActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C3465a, C3467a, C3619a {

    /* renamed from: a */
    private String f8966a = "BroadcastActivity";

    /* renamed from: b */
    private C3457c f8967b;

    /* renamed from: c */
    private DatabaseHelper f8968c;
    @BindView(2131296360)
    View chatLineHolder;

    /* renamed from: d */
    private String f8969d;

    /* renamed from: e */
    private C3631b f8970e;
    @BindView(2131296327)
    Toolbar toolbar;

    /* renamed from: a */
    public void mo29014a(Antenna antenna) {
    }

    /* renamed from: b */
    public void mo29018b(BridgefyPeer bridgefyPeer, Antenna antenna) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.v(this.f8966a, "Broadcast.onCreate()");
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_broadcast);
        ButterKnife.bind((Activity) this);
        this.f8969d = this.settings.getString("user_uuid", "");
        this.f8967b = new C3457c((DatabaseHelper) getHelper());
        setSupportActionBar(this.toolbar);
        getSupportActionBar().mo854a(true);
        getSupportActionBar().mo858b(false);
        this.f8968c = (DatabaseHelper) getHelper();
        if (this.settings.getBoolean("broadcastOnboardingDialog", true)) {
            new C3464b().show(getFragmentManager(), "BroadcastFragment");
        }
        m10081a(true);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f8970e = new C3631b(this.f8966a, this);
        C1049a.m3996a((Context) this).mo4059a(this.f8970e, this.f8970e.mo29681a());
    }

    /* renamed from: a */
    private void m10081a(boolean z) {
        C1049a.m3996a((Context) BridgefyApp.m10557c()).mo4060a(new Intent().setAction("chatMessageBroadcastChangequeueBackground").putExtra("broadcastClosed", z));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m10081a(false);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        C1049a.m3996a((Context) this).mo4058a((BroadcastReceiver) this.f8970e);
    }

    public void onBackPressed() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.emojicons);
        CheckBox checkBox = (CheckBox) findViewById(R.id.btnEmojicon);
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            super.onBackPressed();
            return;
        }
        checkBox.setBackground(getDrawable(R.drawable.ic_insert_emoticon_grey600_24dp));
        frameLayout.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.chatLineHolder.getLayoutParams();
        layoutParams.addRule(12);
        this.chatLineHolder.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public void mo29016a(String str, String str2) {
        this.f8967b.mo28327f(str2);
        Toast.makeText(this, getString(R.string.action_contact_block_toast), 0).show();
    }

    /* renamed from: a */
    public void mo29015a(String str) {
        this.f8967b.mo28328g(str);
        Toast.makeText(this, getString(R.string.action_contact_unblock_toast), 0).show();
    }

    /* renamed from: a */
    public void mo29013a() {
        this.settings.edit().putBoolean("broadcastOnboardingDialog", false).apply();
    }

    /* renamed from: a */
    public void mo29017a(BridgefyPeer bridgefyPeer, Antenna antenna) {
        AppEntityBroadcast appEntityBroadcastChange = AppEntityBroadcast.getAppEntityBroadcastChange(true);
        Device deviceByUserId = DeviceManager.getDeviceByUserId(bridgefyPeer.getId());
        if (deviceByUserId != null) {
            String str = this.f8966a;
            StringBuilder sb = new StringBuilder();
            sb.append("onPeerAvailable: ");
            sb.append(appEntityBroadcastChange);
            Log.w(str, sb.toString());
            deviceByUserId.sendMessage(appEntityBroadcastChange.toHashMap());
        }
    }
}
