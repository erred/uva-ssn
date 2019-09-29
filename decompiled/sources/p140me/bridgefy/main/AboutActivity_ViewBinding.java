package p140me.bridgefy.main;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* renamed from: me.bridgefy.main.AboutActivity_ViewBinding */
public class AboutActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AboutActivity f9456a;

    public AboutActivity_ViewBinding(AboutActivity aboutActivity, View view) {
        this.f9456a = aboutActivity;
        aboutActivity.view = (TextView) Utils.findRequiredViewAsType(view, R.id.versionName, "field 'view'", TextView.class);
    }

    public void unbind() {
        AboutActivity aboutActivity = this.f9456a;
        if (aboutActivity != null) {
            this.f9456a = null;
            aboutActivity.view = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
