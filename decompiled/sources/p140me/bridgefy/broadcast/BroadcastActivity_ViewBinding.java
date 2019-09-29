package p140me.bridgefy.broadcast;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.broadcast.BroadcastActivity_ViewBinding */
public class BroadcastActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BroadcastActivity f8971a;

    public BroadcastActivity_ViewBinding(BroadcastActivity broadcastActivity, View view) {
        this.f8971a = broadcastActivity;
        broadcastActivity.chatLineHolder = Utils.findRequiredView(view, R.id.chatLineHolder, "field 'chatLineHolder'");
        broadcastActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.broadcast_toolbar, "field 'toolbar'", Toolbar.class);
    }

    public void unbind() {
        BroadcastActivity broadcastActivity = this.f8971a;
        if (broadcastActivity != null) {
            this.f8971a = null;
            broadcastActivity.chatLineHolder = null;
            broadcastActivity.toolbar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
