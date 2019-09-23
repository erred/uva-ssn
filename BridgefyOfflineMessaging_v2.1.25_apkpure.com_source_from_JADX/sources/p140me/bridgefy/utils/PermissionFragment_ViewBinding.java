package p140me.bridgefy.utils;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.utils.PermissionFragment_ViewBinding */
public class PermissionFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PermissionFragment f9671a;

    /* renamed from: b */
    private View f9672b;

    public PermissionFragment_ViewBinding(final PermissionFragment permissionFragment, View view) {
        this.f9671a = permissionFragment;
        permissionFragment.descriptionText = (TextView) Utils.findRequiredViewAsType(view, R.id.description, "field 'descriptionText'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.next_button, "method 'onButtonPressed'");
        this.f9672b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                permissionFragment.onButtonPressed();
            }
        });
    }

    public void unbind() {
        PermissionFragment permissionFragment = this.f9671a;
        if (permissionFragment != null) {
            this.f9671a = null;
            permissionFragment.descriptionText = null;
            this.f9672b.setOnClickListener(null);
            this.f9672b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
