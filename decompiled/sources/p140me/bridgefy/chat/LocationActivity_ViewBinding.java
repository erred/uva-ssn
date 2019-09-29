package p140me.bridgefy.chat;

import android.content.Context;
import android.view.View;
import butterknife.Unbinder;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.chat.LocationActivity_ViewBinding */
public class LocationActivity_ViewBinding implements Unbinder {
    public void unbind() {
    }

    @Deprecated
    public LocationActivity_ViewBinding(LocationActivity locationActivity, View view) {
        this(locationActivity, view.getContext());
    }

    public LocationActivity_ViewBinding(LocationActivity locationActivity, Context context) {
        locationActivity.locationPermissionString = context.getResources().getString(R.string.location_permission_for_location);
    }
}
