package p140me.bridgefy.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.settings.DevelopmentOptionsActivity_ViewBinding */
public class DevelopmentOptionsActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private DevelopmentOptionsActivity f9595a;

    public DevelopmentOptionsActivity_ViewBinding(DevelopmentOptionsActivity developmentOptionsActivity, View view) {
        this.f9595a = developmentOptionsActivity;
        developmentOptionsActivity.infoTable = (TableLayout) Utils.findRequiredViewAsType(view, R.id.infoTable, "field 'infoTable'", TableLayout.class);
        developmentOptionsActivity.phoneNumberTextEdit = (EditText) Utils.findRequiredViewAsType(view, R.id.phoneNumberTextEdit, "field 'phoneNumberTextEdit'", EditText.class);
    }

    public void unbind() {
        DevelopmentOptionsActivity developmentOptionsActivity = this.f9595a;
        if (developmentOptionsActivity != null) {
            this.f9595a = null;
            developmentOptionsActivity.infoTable = null;
            developmentOptionsActivity.phoneNumberTextEdit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
