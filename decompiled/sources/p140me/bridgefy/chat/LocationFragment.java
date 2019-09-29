package p140me.bridgefy.chat;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.text.DecimalFormat;
import me.bridgefy.main.R;
import p140me.bridgefy.chat.LocationFragment.C3505a;
import p140me.bridgefy.chat.LocationFragment.C3507b;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.chat.LocationFragment */
public class LocationFragment extends Fragment implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener, OnMapReadyCallback {

    /* renamed from: a */
    Unbinder f9122a;

    /* renamed from: b */
    GoogleApiClient f9123b;
    @BindView(2131296337)
    Button btnSendLocation;

    /* renamed from: c */
    GoogleMap f9124c;

    /* renamed from: d */
    Location f9125d;

    /* renamed from: e */
    Circle f9126e;

    /* renamed from: f */
    private String f9127f = "LocationFragment";

    /* renamed from: g */
    private boolean f9128g = false;

    /* renamed from: h */
    private final int f9129h = 500;

    /* renamed from: i */
    private final int f9130i = 14;

    /* renamed from: j */
    private LatLng f9131j;
    @BindView(2131296506)
    View locationLoader;
    @BindView(2131296723)
    TextView txtViewLocationSending;
    @BindView(2131296724)
    TextView txtViewLocationViewing;

    /* renamed from: me.bridgefy.chat.LocationFragment$a */
    public static class C3505a extends DialogFragment {

        /* renamed from: a */
        public static String f9132a = "LocationPermissionDeniedDialogFragment";

        /* renamed from: b */
        BridgefyOrmLiteBaseActivity f9133b;

        /* renamed from: c */
        C3506a f9134c;

        /* renamed from: d */
        boolean f9135d = false;

        /* renamed from: me.bridgefy.chat.LocationFragment$a$a */
        public interface C3506a {
            /* renamed from: d */
            void mo29158d();
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f9133b = (BridgefyOrmLiteBaseActivity) activity;
            this.f9134c = (C3506a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return C3659b.m10907d((Context) getActivity()).setTitle((int) R.string.permission_dialog_title).setMessage((CharSequence) getString(R.string.location_permission_for_discovery)).setPositiveButton((int) R.string.permission_dialog_grant_access, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3505a.this.m10241b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.never_again, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3505a.this.m10240a(dialogInterface, i);
                }
            }).create();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m10241b(DialogInterface dialogInterface, int i) {
            this.f9135d = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10240a(DialogInterface dialogInterface, int i) {
            this.f9133b.getSettings().edit().putBoolean("permissionLocationInsist", false).apply();
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            if (this.f9135d) {
                C3659b.m10889a((Activity) this.f9133b, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2);
            } else {
                this.f9134c.mo29158d();
            }
        }
    }

    /* renamed from: me.bridgefy.chat.LocationFragment$b */
    public static class C3507b extends DialogFragment {

        /* renamed from: a */
        public static String f9136a = "LocationServicesDisabledDialogFragment";

        /* renamed from: b */
        BridgefyOrmLiteBaseActivity f9137b;

        /* renamed from: c */
        C3508a f9138c;

        /* renamed from: d */
        boolean f9139d = false;

        /* renamed from: me.bridgefy.chat.LocationFragment$b$a */
        public interface C3508a {
            /* renamed from: e */
            void mo29159e();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ void m10243a(DialogInterface dialogInterface, int i) {
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f9137b = (BridgefyOrmLiteBaseActivity) activity;
            this.f9138c = (C3508a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return C3659b.m10907d((Context) getActivity()).setTitle((int) R.string.permission_dialog_title).setMessage(getArguments().getInt("stringId")).setPositiveButton((int) R.string.dialog_enable, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3507b.this.m10244b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.cancel, (OnClickListener) $$Lambda$LocationFragment$b$eBmj66zrwrtTIzUMkq5G4Tg2oMY.INSTANCE).create();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m10244b(DialogInterface dialogInterface, int i) {
            this.f9139d = true;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            if (this.f9139d) {
                this.f9137b.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 5);
            } else {
                this.f9138c.mo29159e();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_location, viewGroup, false);
        this.f9122a = ButterKnife.bind((Object) this, inflate);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        }
        mapFragment.getMapAsync(this);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f9123b = new Builder(getActivity()).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        this.f9131j = (LatLng) getActivity().getIntent().getParcelableExtra("coordinates");
    }

    public void onStart() {
        super.onStart();
        if (BridgefyUtils.isLocationAvailable(BridgefyApp.m10557c().getApplicationContext())) {
            this.f9123b.connect();
        } else if (this.f9131j != null) {
            this.locationLoader.setVisibility(8);
        } else if (getFragmentManager().findFragmentByTag(C3507b.f9136a) == null) {
            C3507b bVar = new C3507b();
            Bundle bundle = new Bundle();
            bundle.putInt("stringId", R.string.location_disabled_for_location);
            bVar.setArguments(bundle);
            bVar.show(getFragmentManager(), C3507b.f9136a);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            this.f9123b.connect();
        }
    }

    public void onStop() {
        if (this.f9123b.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(this.f9123b, (LocationListener) this);
            this.f9123b.disconnect();
        }
        super.onStop();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f9122a != null) {
            this.f9122a.unbind();
        }
    }

    @OnClick({2131296337})
    public void sendLocation() {
        Intent intent = new Intent();
        intent.putExtra("coordinates", this.f9125d);
        intent.putExtra("otherUserId", getActivity().getIntent().getStringExtra("otherUserId"));
        String str = this.f9127f;
        StringBuilder sb = new StringBuilder();
        sb.append("Enviando ubicación (");
        sb.append(this.f9125d.getLatitude());
        sb.append(", ");
        sb.append(this.f9125d.getLongitude());
        sb.append(") a: ");
        sb.append(getActivity().getIntent().getStringExtra("otherUserId"));
        Log.d(str, sb.toString());
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public void onMapReady(GoogleMap googleMap) {
        Log.v(this.f9127f, "onMapReady()");
        this.f9124c = googleMap;
        if (BridgefyUtils.checkLocationPermissions(BridgefyApp.m10557c().getApplicationContext())) {
            googleMap.setMyLocationEnabled(true);
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
            if (this.f9131j != null) {
                googleMap.addMarker(new MarkerOptions().position(this.f9131j));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(this.f9131j));
                return;
            }
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(19.41818d, -99.16357d)));
            return;
        }
        Log.w(this.f9127f, "Location permissions haven't been granted.");
    }

    public void onConnected(Bundle bundle) {
        Log.d(this.f9127f, "onConnected()");
        if (isAdded()) {
            LocationRequest create = LocationRequest.create();
            create.setPriority(100);
            create.setInterval(500);
            if (BridgefyUtils.checkLocationPermissions(BridgefyApp.m10557c().getApplicationContext())) {
                LocationServices.FusedLocationApi.requestLocationUpdates(this.f9123b, create, (LocationListener) this);
                Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(this.f9123b);
                if (this.f9124c == null || this.f9131j != null || lastLocation == null) {
                    this.f9124c.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
                    return;
                }
                this.f9125d = lastLocation;
                mo29162a();
                this.f9126e = this.f9124c.addCircle(new CircleOptions().center(new LatLng(this.f9125d.getLatitude(), this.f9125d.getLongitude())).fillColor(getResources().getColor(R.color.gray_light_opaque)).strokeColor(getResources().getColor(R.color.gray_light)).strokeWidth((float) C3659b.m10883a(BridgefyApp.m10557c().getBaseContext(), 1)).radius((double) this.f9125d.getAccuracy()));
                this.f9124c.animateCamera(CameraUpdateFactory.zoomTo((float) C3659b.m10884a(this.f9126e)));
                m10238b();
                return;
            }
            Log.w(this.f9127f, "Location permissions haven't been granted.");
            return;
        }
        Log.w(this.f9127f, "Activity was destroyed.");
    }

    public void onLocationChanged(Location location) {
        this.f9125d = location;
        if (isAdded()) {
            if (this.f9131j != null) {
                this.txtViewLocationViewing.setText("");
                DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
                float[] fArr = {0.0f};
                Location.distanceBetween(this.f9131j.latitude, this.f9131j.longitude, location.getLatitude(), location.getLongitude(), fArr);
                if (((int) fArr[0]) < 1000) {
                    this.txtViewLocationViewing.setText(String.format(getResources().getString(R.string.location_distance_to_m), new Object[]{decimalFormat.format((long) ((int) fArr[0]))}));
                } else {
                    this.txtViewLocationViewing.setText(String.format(getResources().getString(R.string.location_distance_to_km), new Object[]{decimalFormat.format((long) (((int) fArr[0]) / 1000))}));
                }
                TextView textView = this.txtViewLocationViewing;
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getString(R.string.location_accuracy));
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append((int) location.getAccuracy());
                sb.append(" m.");
                textView.append(sb.toString());
                this.txtViewLocationViewing.setVisibility(0);
            } else if (location.getAccuracy() > 14.0f || !this.f9128g) {
                mo29162a();
                if (location.getAccuracy() < 14.0f) {
                    LocationServices.FusedLocationApi.removeLocationUpdates(this.f9123b, (LocationListener) this);
                    this.f9128g = true;
                }
                if (this.f9126e != null) {
                    this.f9126e.setVisible(false);
                }
                m10238b();
            }
            this.locationLoader.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m10238b() {
        if (this.f9124c != null) {
            this.f9124c.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(this.f9125d.getLatitude(), this.f9125d.getLongitude())));
            this.f9124c.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
        }
        if (this.locationLoader != null) {
            this.locationLoader.setVisibility(8);
        }
        if (this.btnSendLocation != null) {
            this.btnSendLocation.setVisibility(0);
        }
        if (this.txtViewLocationSending != null) {
            this.txtViewLocationSending.setText("");
            TextView textView = this.txtViewLocationSending;
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.location_accuracy));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append((int) this.f9125d.getAccuracy());
            sb.append(" m.");
            textView.append(sb.toString());
            this.txtViewLocationSending.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void mo29162a() {
        LocationActivity locationActivity = (LocationActivity) getActivity();
        if (locationActivity != null) {
            locationActivity.mo29156b();
        }
    }

    public void onConnectionSuspended(int i) {
        String str = this.f9127f;
        StringBuilder sb = new StringBuilder();
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        Log.w(str, sb.toString());
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        String str = this.f9127f;
        StringBuilder sb = new StringBuilder();
        sb.append("onConnectionFailed: ");
        sb.append(connectionResult);
        Log.e(str, sb.toString());
    }
}
