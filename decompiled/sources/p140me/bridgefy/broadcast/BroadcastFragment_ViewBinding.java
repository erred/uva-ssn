package p140me.bridgefy.broadcast;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;
import p140me.bridgefy.chat.ChatBaseFragment_ViewBinding;

/* renamed from: me.bridgefy.broadcast.BroadcastFragment_ViewBinding */
public class BroadcastFragment_ViewBinding extends ChatBaseFragment_ViewBinding {

    /* renamed from: a */
    private BroadcastFragment f8987a;

    /* renamed from: b */
    private View f8988b;

    public BroadcastFragment_ViewBinding(final BroadcastFragment broadcastFragment, View view) {
        super(broadcastFragment, view);
        this.f8987a = broadcastFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.fab_action_location, "method 'sendAttachment'");
        this.f8988b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                broadcastFragment.sendAttachment(view);
            }
        });
    }

    public void unbind() {
        if (this.f8987a != null) {
            this.f8987a = null;
            this.f8988b.setOnClickListener(null);
            this.f8988b = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
