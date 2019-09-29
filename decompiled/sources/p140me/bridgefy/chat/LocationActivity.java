package p140me.bridgefy.chat;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindString;
import butterknife.ButterKnife;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.google.android.gms.maps.model.LatLng;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.bridgefy.main.R;
import p140me.bridgefy.chat.LocationFragment.C3505a.C3506a;
import p140me.bridgefy.chat.LocationFragment.C3507b.C3508a;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.PermissionFragment;
import p140me.bridgefy.utils.PermissionFragment.C3655a;

/* renamed from: me.bridgefy.chat.LocationActivity */
public class LocationActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C3506a, C3508a, C3655a {

    /* renamed from: a */
    String f9116a = "LocationActivity";

    /* renamed from: b */
    String f9117b;

    /* renamed from: c */
    LatLng f9118c;

    /* renamed from: d */
    ScheduledFuture f9119d;

    /* renamed from: e */
    boolean f9120e = false;

    /* renamed from: f */
    PermissionFragment f9121f;
    @BindString(2131689759)
    String locationPermissionString;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_location);
        ButterKnife.bind((Activity) this);
        this.f9117b = getIntent().getStringExtra("otherUserId");
        this.f9118c = (LatLng) getIntent().getParcelableExtra("coordinates");
        Toolbar toolbar = (Toolbar) findViewById(R.id.location_toolbar);
        toolbar.setTitle(this.f9118c == null ? R.string.title_activity_location_share : R.string.title_activity_location_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().mo854a(true);
        if (!BridgefyUtils.checkLocationPermissions(getBaseContext())) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            PermissionFragment a = PermissionFragment.m10877a(this.locationPermissionString);
            this.f9121f = a;
            beginTransaction.add(R.id.introContainer, a).commit();
            return;
        }
        this.f9120e = true;
        m10230f();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f9120e) {
            mo29155a();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        mo29156b();
        super.onPause();
    }

    public void onBackPressed() {
        m10231g();
        super.onBackPressed();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f9118c != null) {
            getMenuInflater().inflate(R.menu.menu_location, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.action_location_launch) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f9118c.latitude);
            sb.append(",");
            sb.append(this.f9118c.longitude);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("geo:");
            sb3.append(sb2);
            sb3.append("?q=");
            sb3.append(Uri.encode(sb2));
            sb3.append("&z=");
            sb3.append(17);
            String sb4 = sb3.toString();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb4));
            if (intent.resolveActivity(getPackageManager()) != null) {
                String str = this.f9116a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Calling intent with uri: ");
                sb5.append(sb4);
                Log.d(str, sb5.toString());
                startActivity(intent);
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("http://google.com/maps/@");
                sb6.append(sb2);
                sb6.append("?q=");
                sb6.append(Uri.encode(sb2));
                sb6.append("&z=");
                sb6.append(17);
                String sb7 = sb6.toString();
                Uri parse = Uri.parse(sb7);
                String str2 = this.f9116a;
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Maps app unavailable. Calling new intent with uri: ");
                sb8.append(sb7);
                Log.w(str2, sb8.toString());
                Toast.makeText(getApplicationContext(), getString(R.string.location_app_unavailable), 1).show();
                startActivity(new Intent("android.intent.action.VIEW", parse));
            }
            return true;
        }
    }

    /* renamed from: a */
    public void mo29155a() {
        if (this.f9118c == null) {
            Log.d(this.f9116a, "scheduling Location timeout");
            this.f9119d = new ScheduledThreadPoolExecutor(1).schedule(new Runnable(this) {
                private final /* synthetic */ Activity f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    LocationActivity.this.m10228a(this.f$1);
                }
            }, 60000, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10228a(Activity activity) {
        runOnUiThread(new Runnable(activity) {
            private final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                LocationActivity.this.m10229b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10229b(Activity activity) {
        Log.d(this.f9116a, "Location Acquire Timeout");
        Toast.makeText(activity, getString(R.string.location_error), 1).show();
        activity.finish();
    }

    /* renamed from: b */
    public void mo29156b() {
        if (this.f9119d != null) {
            Log.d(this.f9116a, "Location Timeout canceled.");
            this.f9119d.cancel(true);
        }
    }

    /* renamed from: f */
    private void m10230f() {
        if (this.f9121f != null) {
            getFragmentManager().beginTransaction().remove(this.f9121f).add(R.id.locationContainer, new LocationFragment()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.locationContainer, new LocationFragment()).commit();
        }
    }

    /* renamed from: g */
    private void m10231g() {
        setResult(0, new Intent().putExtra("otherUserId", this.f9117b));
    }

    /* renamed from: c */
    public void mo29157c() {
        C3659b.m10889a((Activity) this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length <= 0 || i != 2 || !strArr[0].equals("android.permission.ACCESS_FINE_LOCATION")) {
            Log.w(this.f9116a, "Permission request canceled by the user.");
        } else if (iArr[0] == 0) {
            m10232h();
        } else if (iArr[0] == -1) {
            Log.w(this.f9116a, "PERMISSION_FINE_LOCATION Denied!");
            m10231g();
            mo29158d();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = this.f9116a;
        StringBuilder sb = new StringBuilder();
        sb.append("LocationActivity.onActivityResult(): requestCode: ");
        sb.append(i);
        Log.d(str, sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i == 2 && BridgefyUtils.checkLocationPermissions(getBaseContext())) {
            m10232h();
        }
    }

    /* renamed from: h */
    private void m10232h() {
        Log.i(this.f9116a, "PERMISSION_FINE_LOCATION Accepted!");
        this.f9120e = true;
        m10230f();
        mo29155a();
    }

    /* renamed from: d */
    public void mo29158d() {
        Toast.makeText(this, getString(R.string.location_error), 0).show();
        finish();
    }

    /* renamed from: e */
    public void mo29159e() {
        mo29158d();
    }
}
