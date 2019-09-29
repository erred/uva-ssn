package p140me.bridgefy.intro;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.intro.SignupActivity_ViewBinding */
public class SignupActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SignupActivity f9334a;

    /* renamed from: b */
    private View f9335b;

    public SignupActivity_ViewBinding(final SignupActivity signupActivity, View view) {
        this.f9334a = signupActivity;
        signupActivity.mUsernameView = (EditText) Utils.findRequiredViewAsType(view, R.id.username, "field 'mUsernameView'", EditText.class);
        signupActivity.mProgressView = Utils.findRequiredView(view, R.id.login_progress, "field 'mProgressView'");
        View findRequiredView = Utils.findRequiredView(view, R.id.register_button, "field 'mRegisterButton' and method 'attemptLogin'");
        signupActivity.mRegisterButton = (Button) Utils.castView(findRequiredView, R.id.register_button, "field 'mRegisterButton'", Button.class);
        this.f9335b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                signupActivity.attemptLogin();
            }
        });
        Resources resources = view.getContext().getResources();
        signupActivity.locationPermissionString = resources.getString(R.string.permission_bluetooth_location);
        signupActivity.contactsPermissionString = resources.getString(R.string.contacts_permission_fragment);
    }

    public void unbind() {
        SignupActivity signupActivity = this.f9334a;
        if (signupActivity != null) {
            this.f9334a = null;
            signupActivity.mUsernameView = null;
            signupActivity.mProgressView = null;
            signupActivity.mRegisterButton = null;
            this.f9335b.setOnClickListener(null);
            this.f9335b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
