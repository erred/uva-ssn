package p140me.bridgefy.contacts;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.contacts.ContactsHelpActivity_ViewBinding */
public class ContactsHelpActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ContactsHelpActivity f9206a;

    /* renamed from: b */
    private View f9207b;

    public ContactsHelpActivity_ViewBinding(final ContactsHelpActivity contactsHelpActivity, View view) {
        this.f9206a = contactsHelpActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.help_contact, "method 'onHelpClick'");
        this.f9207b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactsHelpActivity.onHelpClick();
            }
        });
    }

    public void unbind() {
        if (this.f9206a != null) {
            this.f9206a = null;
            this.f9207b.setOnClickListener(null);
            this.f9207b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
