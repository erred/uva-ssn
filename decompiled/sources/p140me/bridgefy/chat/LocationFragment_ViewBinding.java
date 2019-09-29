package p140me.bridgefy.chat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.chat.LocationFragment_ViewBinding */
public class LocationFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LocationFragment f9140a;

    /* renamed from: b */
    private View f9141b;

    public LocationFragment_ViewBinding(final LocationFragment locationFragment, View view) {
        this.f9140a = locationFragment;
        locationFragment.txtViewLocationViewing = (TextView) Utils.findRequiredViewAsType(view, R.id.txtLocationViewing, "field 'txtViewLocationViewing'", TextView.class);
        locationFragment.txtViewLocationSending = (TextView) Utils.findRequiredViewAsType(view, R.id.txtLocationSending, "field 'txtViewLocationSending'", TextView.class);
        locationFragment.locationLoader = Utils.findRequiredView(view, R.id.locationLoaderView, "field 'locationLoader'");
        View findRequiredView = Utils.findRequiredView(view, R.id.btnLocationSend, "field 'btnSendLocation' and method 'sendLocation'");
        locationFragment.btnSendLocation = (Button) Utils.castView(findRequiredView, R.id.btnLocationSend, "field 'btnSendLocation'", Button.class);
        this.f9141b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                locationFragment.sendLocation();
            }
        });
    }

    public void unbind() {
        LocationFragment locationFragment = this.f9140a;
        if (locationFragment != null) {
            this.f9140a = null;
            locationFragment.txtViewLocationViewing = null;
            locationFragment.txtViewLocationSending = null;
            locationFragment.locationLoader = null;
            locationFragment.btnSendLocation = null;
            this.f9141b.setOnClickListener(null);
            this.f9141b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
