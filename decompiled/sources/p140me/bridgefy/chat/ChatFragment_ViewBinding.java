package p140me.bridgefy.chat;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.chat.ChatFragment_ViewBinding */
public class ChatFragment_ViewBinding extends ChatBaseFragment_ViewBinding {

    /* renamed from: a */
    private ChatFragment f9106a;

    /* renamed from: b */
    private View f9107b;

    /* renamed from: c */
    private View f9108c;

    /* renamed from: d */
    private View f9109d;

    public ChatFragment_ViewBinding(final ChatFragment chatFragment, View view) {
        super(chatFragment, view);
        this.f9106a = chatFragment;
        chatFragment.addContactBar = (TextView) Utils.findRequiredViewAsType(view, R.id.addContactBar, "field 'addContactBar'", TextView.class);
        chatFragment.blockedContactBar = (TextView) Utils.findRequiredViewAsType(view, R.id.blockedContactBar, "field 'blockedContactBar'", TextView.class);
        chatFragment.unverifiedContactBar = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.unverifiedContactBar, "field 'unverifiedContactBar'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.fab_action_photo, "method 'sendAttachment'");
        this.f9107b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                chatFragment.sendAttachment(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.fab_action_image, "method 'sendAttachment'");
        this.f9108c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                chatFragment.sendAttachment(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.fab_action_location, "method 'sendAttachment'");
        this.f9109d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                chatFragment.sendAttachment(view);
            }
        });
    }

    public void unbind() {
        ChatFragment chatFragment = this.f9106a;
        if (chatFragment != null) {
            this.f9106a = null;
            chatFragment.addContactBar = null;
            chatFragment.blockedContactBar = null;
            chatFragment.unverifiedContactBar = null;
            this.f9107b.setOnClickListener(null);
            this.f9107b = null;
            this.f9108c.setOnClickListener(null);
            this.f9108c = null;
            this.f9109d.setOnClickListener(null);
            this.f9109d = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
