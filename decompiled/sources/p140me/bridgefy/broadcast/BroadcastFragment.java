package p140me.bridgefy.broadcast;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.C0446c;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.fragment.p081a.C1061c;
import androidx.p079f.p080a.C1049a;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.squareup.p131a.C3017h;
import com.squareup.picasso.C3068t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.bridgefy.main.R;
import p140me.bridgefy.broadcast.BroadcastFragment.C3464b;
import p140me.bridgefy.broadcast.BroadcastFragment.C3466c;
import p140me.bridgefy.chat.ChatActivity;
import p140me.bridgefy.chat.ChatBaseFragment;
import p140me.bridgefy.chat.ChatBaseFragment.C3480a;
import p140me.bridgefy.chat.LocationActivity;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.broadcast.BroadcastFragment */
public class BroadcastFragment extends ChatBaseFragment {

    /* renamed from: a */
    Unbinder f8972a;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public HashMap<String, Integer> f8973j;

    /* renamed from: me.bridgefy.broadcast.BroadcastFragment$MessageViewHolder */
    class MessageViewHolder extends p140me.bridgefy.chat.ChatBaseFragment.MessageViewHolder {
        @BindView(2131296328)
        protected TextView broadcastUserName;
        @BindView(2131296372)
        TextView chatEntryInitialsTextView;

        public MessageViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131296372, 2131296328})
        @Optional
        public void showPeerActions() {
            Bundle bundle = new Bundle();
            bundle.putString("userId", this.f9034b.getSender());
            bundle.putString("userName", this.f9034b.getOtherUserName());
            bundle.putBoolean("userIsBlocked", new C3457c(BridgefyService.get_database_helper()).mo28329h(this.f9034b.getSender()));
            C3466c cVar = new C3466c();
            cVar.setArguments(bundle);
            cVar.show(BroadcastFragment.this.getFragmentManager(), C3466c.f8985a);
        }

        /* renamed from: a */
        public void mo29022a(Message message) {
            int i;
            String str;
            this.f9034b = message;
            boolean z = false;
            if (!message.getMessageId().equals(String.valueOf(0))) {
                if (!message.getSender().equals(BroadcastFragment.this.f9027f) && message.getSender() != null) {
                    FriendDTO c = new C3457c(BridgefyService.get_database_helper()).query_friend_dto_by_id(message.getSender());
                    if (c == null) {
                        str = message.getOtherUserName();
                        if (BroadcastFragment.this.f8973j.containsKey(message.getSender())) {
                            i = ((Integer) BroadcastFragment.this.f8973j.get(message.getSender())).intValue();
                        } else {
                            i = C3659b.m10900b();
                            BroadcastFragment.this.f8973j.put(message.getSender(), Integer.valueOf(i));
                        }
                    } else {
                        String contactOrUsername = c.getContactOrUsername();
                        i = c.getColor();
                        str = contactOrUsername;
                    }
                    if (this.chatEntryInitialsTextView != null) {
                        ((GradientDrawable) this.chatEntryInitialsTextView.getBackground()).setColor(i);
                        this.chatEntryInitialsTextView.setText(C3659b.m10902b(str));
                    }
                    if (this.broadcastUserName != null) {
                        this.broadcastUserName.setText(str);
                        this.broadcastUserName.setTextColor(i);
                    }
                }
                boolean z2 = message.getDateSent() != null;
                if (this.dateSentView != null) {
                    z = true;
                }
                if (z2 && z) {
                    this.dateSentView.setText(C3659b.m10886a(BroadcastFragment.this.getResources(), message.getServerDate()));
                }
                if (message.getType() != 2) {
                    String text = message.getText();
                    if (text != null && !text.isEmpty()) {
                        this.messageView.setText(text);
                    }
                } else {
                    String text2 = message.getText();
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://maps.googleapis.com/maps/api/staticmap?center=");
                    sb.append(text2);
                    sb.append("&zoom=");
                    sb.append(16);
                    sb.append("&size=300x300&maptype=roadmap&markers=color:red%7C");
                    sb.append(text2);
                    C3068t.m9058b().mo27532a(Uri.parse(sb.toString())).mo27572a((int) R.drawable.ic_map_grey).mo27575a(this.imageView);
                    this.imageView.setOnClickListener(this.f9035c);
                }
            }
        }
    }

    /* renamed from: me.bridgefy.broadcast.BroadcastFragment$MessageViewHolder_ViewBinding */
    public class MessageViewHolder_ViewBinding extends p140me.bridgefy.chat.ChatBaseFragment.MessageViewHolder_ViewBinding {

        /* renamed from: a */
        private MessageViewHolder f8975a;

        /* renamed from: b */
        private View f8976b;

        /* renamed from: c */
        private View f8977c;

        public MessageViewHolder_ViewBinding(final MessageViewHolder messageViewHolder, View view) {
            super(messageViewHolder, view);
            this.f8975a = messageViewHolder;
            View findViewById = view.findViewById(R.id.broadcast_user_name);
            messageViewHolder.broadcastUserName = (TextView) Utils.castView(findViewById, R.id.broadcast_user_name, "field 'broadcastUserName'", TextView.class);
            if (findViewById != null) {
                this.f8976b = findViewById;
                findViewById.setOnClickListener(new DebouncingOnClickListener() {
                    public void doClick(View view) {
                        messageViewHolder.showPeerActions();
                    }
                });
            }
            View findViewById2 = view.findViewById(R.id.contactInitials);
            messageViewHolder.chatEntryInitialsTextView = (TextView) Utils.castView(findViewById2, R.id.contactInitials, "field 'chatEntryInitialsTextView'", TextView.class);
            if (findViewById2 != null) {
                this.f8977c = findViewById2;
                findViewById2.setOnClickListener(new DebouncingOnClickListener() {
                    public void doClick(View view) {
                        messageViewHolder.showPeerActions();
                    }
                });
            }
        }

        public void unbind() {
            MessageViewHolder messageViewHolder = this.f8975a;
            if (messageViewHolder != null) {
                this.f8975a = null;
                messageViewHolder.broadcastUserName = null;
                messageViewHolder.chatEntryInitialsTextView = null;
                if (this.f8976b != null) {
                    this.f8976b.setOnClickListener(null);
                    this.f8976b = null;
                }
                if (this.f8977c != null) {
                    this.f8977c.setOnClickListener(null);
                    this.f8977c = null;
                }
                super.unbind();
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: me.bridgefy.broadcast.BroadcastFragment$a */
    public class C3463a extends C3480a {
        C3463a(List<Message> list) {
            super();
            this.f9045b = list;
        }

        /* renamed from: a */
        public MessageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i != 0) {
                switch (i) {
                    case 10:
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.broadcast_message_row_outbound, viewGroup, false);
                        break;
                    case 11:
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.broadcast_image_row_outbound, viewGroup, false);
                        break;
                    default:
                        switch (i) {
                            case 20:
                                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.broadcast_message_row_inbound, viewGroup, false);
                                break;
                            case 21:
                                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.broadcast_image_row_inbound, viewGroup, false);
                                break;
                            default:
                                view = null;
                                break;
                        }
                }
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_paginator, viewGroup, false);
            }
            return new MessageViewHolder(view);
        }
    }

    /* renamed from: me.bridgefy.broadcast.BroadcastFragment$b */
    public static class C3464b extends DialogFragment {

        /* renamed from: a */
        public static String f8983a = "BroadcastOnboardingDialog";

        /* renamed from: b */
        C3465a f8984b;

        /* renamed from: me.bridgefy.broadcast.BroadcastFragment$b$a */
        public interface C3465a {
            /* renamed from: a */
            void mo29013a();
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f8984b = (C3465a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            C0447a d = C3659b.m10907d((Context) getActivity());
            d.setTitle((CharSequence) getString(R.string.broadcast_onboarding_title)).setMessage((CharSequence) getString(R.string.broadcast_onboarding_body)).setPositiveButton((int) R.string.dialog_gotit, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3464b.this.m10094a(dialogInterface, i);
                }
            });
            C0446c create = d.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10094a(DialogInterface dialogInterface, int i) {
            this.f8984b.mo29013a();
        }
    }

    /* renamed from: me.bridgefy.broadcast.BroadcastFragment$c */
    public static class C3466c extends C1061c {

        /* renamed from: a */
        public static String f8985a = "PeerActionsDialogFragment";

        /* renamed from: b */
        C3467a f8986b;

        /* renamed from: me.bridgefy.broadcast.BroadcastFragment$c$a */
        public interface C3467a {
            /* renamed from: a */
            void mo29015a(String str);

            /* renamed from: a */
            void mo29016a(String str, String str2);
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f8986b = (C3467a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            String[] stringArray = getResources().getStringArray(R.array.peer_actions);
            boolean z = getArguments().getBoolean("userIsBlocked");
            String str = stringArray[1];
            Object[] objArr = new Object[1];
            objArr[0] = getString(z ? R.string.action_contact_unblock : R.string.action_contact_block);
            stringArray[1] = String.format(str, objArr);
            C0447a aVar = new C0447a(new ContextThemeWrapper(getActivity(), R.style.PeerActionsDialogStyle));
            aVar.setItems((CharSequence[]) stringArray, (OnClickListener) new OnClickListener(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3466c.this.m10096a(this.f$1, dialogInterface, i);
                }
            });
            C0446c create = aVar.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10096a(boolean z, DialogInterface dialogInterface, int i) {
            switch (i) {
                case 0:
                    Bundle bundle = new Bundle();
                    bundle.putString("otherUserName", getArguments().getString("userName"));
                    bundle.putString("otherUserId", getArguments().getString("userId"));
                    startActivity(new Intent(getContext(), ChatActivity.class).putExtras(bundle));
                    return;
                case 1:
                    if (z) {
                        this.f8986b.mo29015a(getArguments().getString("userId"));
                        return;
                    } else {
                        this.f8986b.mo29016a(getArguments().getString("userName"), getArguments().getString("userId"));
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8973j = new HashMap<>();
        this.f9030i = "broadcast.public";
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.broadcast_fragment, viewGroup, false);
        this.f8972a = ButterKnife.bind((Object) this, inflate);
        BridgefyApp.m10557c().mo29530g().mo27385a((Object) this);
        this.f9023b = new C3463a(new ArrayList());
        this.messagesListView.setAdapter(this.f9023b);
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return inflate;
    }

    public void onDestroyView() {
        BridgefyApp.m10557c().mo29530g().mo27388b((Object) this);
        if (this.f8972a != null) {
            this.f8972a.unbind();
        }
        super.onDestroyView();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.i("BroadcastFragment", "on activity result");
        if (i2 == -1) {
            if (i == 30) {
                Location location = (Location) intent.getParcelableExtra("coordinates");
                StringBuilder sb = new StringBuilder();
                sb.append(location.getLatitude());
                sb.append(",");
                sb.append(location.getLongitude());
                mo29019a(sb.toString(), 2);
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    /* renamed from: a */
    public boolean mo29019a(String str, int i) {
        if (str.isEmpty() || str.trim().length() == 0) {
            return false;
        }
        Message message = new Message(this.f9030i, this.f9027f, str, this.f9028g, i);
        this.f9024c.mo28343b(message);
        pushMessage(message);
        C1049a.m3996a(getContext()).mo4060a(new Intent().setAction("chatMessageBroadcastSendqueueBackground").putExtra("bridgefyMessage", message.serialize()));
        toggleEmojiconFragmentIfVisible();
        this.chatLine.setText("");
        this.chatLine.requestFocus();
        Editor editor = this.f9026e;
        StringBuilder sb = new StringBuilder();
        sb.append("chatLine-");
        sb.append(this.f9030i);
        editor.remove(sb.toString()).apply();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10089a(Message message) {
        this.f9023b.mo29095a(message);
    }

    @C3017h
    public void pushMessage(Message message) {
        getActivity().runOnUiThread(new Runnable(message) {
            private final /* synthetic */ Message f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                BroadcastFragment.this.m10089a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: protected */
    @OnClick({2131296432})
    public void sendAttachment(View view) {
        this.fabAttachments.mo12066c(false);
        if (view.getId() == R.id.fab_action_location) {
            startActivityForResult(new Intent(getActivity(), LocationActivity.class).putExtra("otherUserId", this.f9030i), 30);
        }
    }
}
