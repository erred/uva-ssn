package p140me.bridgefy.contacts;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.contacts.BlockedUsersFragment_ViewBinding */
public class BlockedUsersFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BlockedUsersFragment f9179a;

    public BlockedUsersFragment_ViewBinding(BlockedUsersFragment blockedUsersFragment, View view) {
        this.f9179a = blockedUsersFragment;
        blockedUsersFragment.blockedContactsListView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.blocked_contacts_recycler_view, "field 'blockedContactsListView'", RecyclerView.class);
    }

    public void unbind() {
        BlockedUsersFragment blockedUsersFragment = this.f9179a;
        if (blockedUsersFragment != null) {
            this.f9179a = null;
            blockedUsersFragment.blockedContactsListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
