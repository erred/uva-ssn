package p140me.bridgefy.contacts;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C1243a;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.List;
import me.bridgefy.main.R;
import p140me.bridgefy.contacts.BlockedUsersFragment.C3528b;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3665e;

/* renamed from: me.bridgefy.contacts.BlockedUsersFragment */
public class BlockedUsersFragment extends Fragment {

    /* renamed from: a */
    Activity f9168a;

    /* renamed from: b */
    C3457c f9169b;
    @BindView(2131296315)
    RecyclerView blockedContactsListView;

    /* renamed from: c */
    Unbinder f9170c;

    /* renamed from: d */
    public C3527a f9171d;

    /* renamed from: me.bridgefy.contacts.BlockedUsersFragment$ContactViewHolder */
    class ContactViewHolder extends C1277x implements OnClickListener {

        /* renamed from: b */
        private FriendDTO f9173b;
        @BindView(2131296372)
        TextView initialsTextView;
        @BindView(2131296476)
        TextView txtUnblock;
        @BindView(2131296373)
        TextView usernameTextView;

        ContactViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            view.setOnClickListener(this);
        }

        /* renamed from: a */
        public void mo29226a(FriendDTO friendDTO) {
            this.f9173b = friendDTO;
            ((GradientDrawable) this.initialsTextView.getBackground()).setColor(BlockedUsersFragment.this.f9169b.mo28323c(friendDTO.getId()).getColor());
            this.usernameTextView.setText(friendDTO.buildDisplayName());
            this.initialsTextView.setText(C3659b.m10902b(friendDTO.buildDisplayName()));
            this.txtUnblock.setText(BlockedUsersFragment.this.getString(R.string.action_contact_unblock));
        }

        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("otherUserId", this.f9173b.getId());
            bundle.putString("otherUserName", this.f9173b.getContactOrUsername());
            C3528b bVar = new C3528b();
            bVar.setArguments(bundle);
            bVar.show(BlockedUsersFragment.this.getFragmentManager(), C3528b.f9177a);
        }
    }

    /* renamed from: me.bridgefy.contacts.BlockedUsersFragment$ContactViewHolder_ViewBinding */
    public class ContactViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a */
        private ContactViewHolder f9174a;

        public ContactViewHolder_ViewBinding(ContactViewHolder contactViewHolder, View view) {
            this.f9174a = contactViewHolder;
            contactViewHolder.usernameTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.contactName, "field 'usernameTextView'", TextView.class);
            contactViewHolder.initialsTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.contactInitials, "field 'initialsTextView'", TextView.class);
            contactViewHolder.txtUnblock = (TextView) Utils.findRequiredViewAsType(view, R.id.inRangeBadge, "field 'txtUnblock'", TextView.class);
        }

        public void unbind() {
            ContactViewHolder contactViewHolder = this.f9174a;
            if (contactViewHolder != null) {
                this.f9174a = null;
                contactViewHolder.usernameTextView = null;
                contactViewHolder.initialsTextView = null;
                contactViewHolder.txtUnblock = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: me.bridgefy.contacts.BlockedUsersFragment$a */
    public class C3527a extends C1243a<ContactViewHolder> {

        /* renamed from: b */
        private List<FriendDTO> f9176b;

        public C3527a(List<FriendDTO> list) {
            this.f9176b = list;
        }

        public int getItemCount() {
            return this.f9176b.size();
        }

        /* renamed from: a */
        public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
            FriendDTO friendDTO = (FriendDTO) this.f9176b.get(i);
            if (friendDTO != null) {
                contactViewHolder.mo29226a(friendDTO);
            }
        }

        /* renamed from: a */
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ContactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_peer_row, viewGroup, false));
        }
    }

    /* renamed from: me.bridgefy.contacts.BlockedUsersFragment$b */
    public static class C3528b extends DialogFragment {

        /* renamed from: a */
        public static String f9177a = "unblockContactConfirmationDialogFragment";

        /* renamed from: b */
        C3529a f9178b;

        /* renamed from: me.bridgefy.contacts.BlockedUsersFragment$b$a */
        public interface C3529a {
            /* renamed from: a */
            void mo29220a();

            /* renamed from: a */
            void mo29221a(String str);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ void m10326a(DialogInterface dialogInterface, int i) {
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f9178b = (C3529a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            C0447a d = C3659b.m10907d((Context) getActivity());
            d.setMessage((CharSequence) String.format(getString(R.string.dialog_unblock), new Object[]{getArguments().getString("otherUserName")})).setPositiveButton((int) R.string.action_contact_unblock, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3528b.this.m10327b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) $$Lambda$BlockedUsersFragment$b$UBDNsc7GLYN3YxGeKsmWi2UbbLU.INSTANCE);
            return d.create();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m10327b(DialogInterface dialogInterface, int i) {
            this.f9178b.mo29221a(getArguments().getString("otherUserId"));
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            this.f9178b.mo29220a();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.blocked_contacts_fragment, viewGroup, false);
        this.f9170c = ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f9170c != null) {
            this.f9170c.unbind();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f9168a = getActivity();
        this.f9169b = new C3457c((DatabaseHelper) ((BlockedUsersActivity) getActivity()).getHelper());
        mo29222a();
    }

    /* renamed from: a */
    public void mo29222a() {
        this.f9171d = new C3527a(this.f9169b.mo28322c());
        this.blockedContactsListView.setAdapter(this.f9171d);
        this.blockedContactsListView.setLayoutManager(new LinearLayoutManager(this.f9168a));
        this.blockedContactsListView.addItemDecoration(new C3665e(this.f9168a, 1));
        this.f9171d.notifyDataSetChanged();
    }
}
