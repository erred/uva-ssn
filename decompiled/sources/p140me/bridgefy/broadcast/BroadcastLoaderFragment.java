package p140me.bridgefy.broadcast;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import java.util.concurrent.TimeUnit;
import me.bridgefy.main.R;
import net.sqlcipher.database.SQLiteDatabase;
import p000a.p013b.C0159b;
import p000a.p013b.p014a.p016b.C0153a;
import p000a.p013b.p019d.C0177a;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.TabbedMainActivity;
import p140me.bridgefy.utils.C3657a.C3658a;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.broadcast.BroadcastLoaderFragment */
public class BroadcastLoaderFragment extends Fragment implements C3658a {

    /* renamed from: a */
    Unbinder f8991a;

    /* renamed from: b */
    private boolean f8992b = true;
    @BindView(2131296323)
    ImageView broadcastLoaderAnimation;
    @BindView(2131296324)
    TextView broadcastLoaderTextView;
    @BindView(2131296325)
    Button broadcastLoaderTextViewRetry;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        BridgefyApp.m10557c().mo29530g().mo27385a((Object) this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.broadcast_loader_fragment, viewGroup, false);
        this.f8991a = ButterKnife.bind((Object) this, inflate);
        if (this.f8992b) {
            m10100b();
        }
        return inflate;
    }

    public void onDestroy() {
        Log.w("BroadcastLoaderFragment", "onDestroy");
        if (this.f8991a != null) {
            this.f8991a.unbind();
        }
        BridgefyApp.m10557c().mo29530g().mo27388b((Object) this);
        super.onDestroy();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.f8992b) {
            Log.v("BroadcastLoaderFragment", "Fragment is visible and it's the first time loading the BroadcastFragment. Requesting to load BroadcastActivity.");
            m10099a(true);
            this.f8992b = false;
        }
    }

    @OnClick({2131296326, 2131296325})
    public void loadBroadcastFragment() {
        Log.d("BroadcastLoaderFragment", "loadBroadcastFragment()");
        startActivityForResult(new Intent(getActivity(), BroadcastActivity.class).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY), 4403);
        m10099a(false);
    }

    /* renamed from: b */
    private void m10100b() {
        this.broadcastLoaderTextView.setText(getString(R.string.broadcast_loader_text));
        this.broadcastLoaderTextViewRetry.setVisibility(4);
        this.broadcastLoaderAnimation.setImageDrawable(null);
        this.broadcastLoaderAnimation.setBackground(getActivity().getDrawable(R.drawable.broadcast_animation));
        ((AnimationDrawable) this.broadcastLoaderAnimation.getBackground()).start();
    }

    /* renamed from: a */
    public void mo29027a() {
        Log.d("BroadcastLoaderFragment", "stopAnimation()");
        if (isAdded()) {
            this.broadcastLoaderTextView.setText(getString(R.string.broadcast_loader_text_error));
            this.broadcastLoaderTextViewRetry.setVisibility(0);
            this.broadcastLoaderAnimation.setImageDrawable(getActivity().getDrawable(R.drawable.il_broadcastanim0));
            this.broadcastLoaderAnimation.setBackground(null);
        }
    }

    /* renamed from: a */
    private void m10099a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadBroadcastActivity(), start: ");
        sb.append(z);
        Log.d("BroadcastLoaderFragment", sb.toString());
        C0159b.m540a(1, TimeUnit.SECONDS).mo347b(C0153a.m534a()).mo342a(C0153a.m534a()).mo339a((C0177a) new C0177a(z) {
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                BroadcastLoaderFragment.this.m10101b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10101b(boolean z) throws Exception {
        if (z) {
            loadBroadcastFragment();
        } else {
            mo29027a();
        }
    }

    public void onAntennaeDelegate(boolean z) {
        if (z) {
            C3659b.m10892a(BridgefyApp.m10557c().getApplicationContext(), true);
            m10099a(true);
            return;
        }
        m10102c();
    }

    /* renamed from: c */
    private void m10102c() {
        Log.w("BroadcastLoaderFragment", "onBluetoothDisabled()");
        mo29027a();
        Toast.makeText(BridgefyApp.m10557c().getApplicationContext(), getString(R.string.bluetooth_disabled_toast), 0).show();
        TabbedMainActivity tabbedMainActivity = (TabbedMainActivity) getActivity();
        if (tabbedMainActivity != null) {
            tabbedMainActivity.mo29538l();
        }
    }
}
