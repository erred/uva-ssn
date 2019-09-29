package p140me.bridgefy.chat;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.chat.ChatEntryFragment_ViewBinding */
public class ChatEntryFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ChatEntryFragment f9082a;

    public ChatEntryFragment_ViewBinding(ChatEntryFragment chatEntryFragment, View view) {
        this.f9082a = chatEntryFragment;
        chatEntryFragment.emptyContactsView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.emptyContactsView, "field 'emptyContactsView'", LinearLayout.class);
        chatEntryFragment.chatEntriesRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.chat_entries_recycler_view, "field 'chatEntriesRecyclerView'", RecyclerView.class);
        chatEntryFragment.emptyContainerView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.emptyContainerView, "field 'emptyContainerView'", LinearLayout.class);
        chatEntryFragment.emptyChatsView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.emptyChatsView, "field 'emptyChatsView'", LinearLayout.class);
        chatEntryFragment.btnShareBridgefy = (Button) Utils.findRequiredViewAsType(view, R.id.btnShareBridgefy, "field 'btnShareBridgefy'", Button.class);
        chatEntryFragment.btnAddContact = (Button) Utils.findRequiredViewAsType(view, R.id.btnAddContact, "field 'btnAddContact'", Button.class);
    }

    public void unbind() {
        ChatEntryFragment chatEntryFragment = this.f9082a;
        if (chatEntryFragment != null) {
            this.f9082a = null;
            chatEntryFragment.emptyContactsView = null;
            chatEntryFragment.chatEntriesRecyclerView = null;
            chatEntryFragment.emptyContainerView = null;
            chatEntryFragment.emptyChatsView = null;
            chatEntryFragment.btnShareBridgefy = null;
            chatEntryFragment.btnAddContact = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
