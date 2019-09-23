package p140me.bridgefy.contacts;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.contacts.ContactsFragment_ViewBinding */
public class ContactsFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ContactsFragment f9204a;

    public ContactsFragment_ViewBinding(ContactsFragment contactsFragment, View view) {
        this.f9204a = contactsFragment;
        contactsFragment.refreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
        contactsFragment.emptyContactsView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.emptyContactsView, "field 'emptyContactsView'", LinearLayout.class);
        contactsFragment.peersRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.peers_recycler_view, "field 'peersRecyclerView'", RecyclerView.class);
        contactsFragment.btnShareBridgefy = (Button) Utils.findRequiredViewAsType(view, R.id.btnShareBridgefy, "field 'btnShareBridgefy'", Button.class);
        contactsFragment.tooltipNearby = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tooltip_nearby, "field 'tooltipNearby'", RelativeLayout.class);
        contactsFragment.btnAddContact = (Button) Utils.findRequiredViewAsType(view, R.id.btnAddContact, "field 'btnAddContact'", Button.class);
    }

    public void unbind() {
        ContactsFragment contactsFragment = this.f9204a;
        if (contactsFragment != null) {
            this.f9204a = null;
            contactsFragment.refreshLayout = null;
            contactsFragment.emptyContactsView = null;
            contactsFragment.peersRecyclerView = null;
            contactsFragment.btnShareBridgefy = null;
            contactsFragment.tooltipNearby = null;
            contactsFragment.btnAddContact = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
