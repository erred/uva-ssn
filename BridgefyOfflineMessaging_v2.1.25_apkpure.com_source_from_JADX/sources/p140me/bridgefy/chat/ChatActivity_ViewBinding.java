package p140me.bridgefy.chat;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.chat.ChatActivity_ViewBinding */
public class ChatActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ChatActivity f9018a;

    /* renamed from: b */
    private View f9019b;

    public ChatActivity_ViewBinding(final ChatActivity chatActivity, View view) {
        this.f9018a = chatActivity;
        chatActivity.chatLineHolder = Utils.findRequiredView(view, R.id.chatLineHolder, "field 'chatLineHolder'");
        chatActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.chat_toolbar, "field 'toolbar'", Toolbar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.unverifiedContactBar, "method 'unverifiedContactInfo'");
        this.f9019b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                chatActivity.unverifiedContactInfo();
            }
        });
    }

    public void unbind() {
        ChatActivity chatActivity = this.f9018a;
        if (chatActivity != null) {
            this.f9018a = null;
            chatActivity.chatLineHolder = null;
            chatActivity.toolbar = null;
            this.f9019b.setOnClickListener(null);
            this.f9019b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
