package p140me.bridgefy.chat;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p079f.p080a.C1049a;
import androidx.recyclerview.widget.C1323l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C1243a;
import androidx.recyclerview.widget.RecyclerView.C1248f;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bridgefy.sdk.client.Config.Antenna;
import com.p110b.p111a.C1857a;
import com.p110b.p111a.C1860b;
import com.p110b.p111a.C1860b.C1865a;
import com.p110b.p111a.p112a.C1858a;
import com.p110b.p111a.p112a.C1859b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import me.bridgefy.main.R;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.ChatEntry;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.TabbedMainActivity;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.service.p146c.C3619a;
import p140me.bridgefy.service.p147d.C3620a;
import p140me.bridgefy.service.p148e.C3631b;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3662d;
import p140me.bridgefy.utils.C3665e;
import p140me.bridgefy.utils.C3673k;

/* renamed from: me.bridgefy.chat.ChatEntryFragment */
public class ChatEntryFragment extends Fragment implements C3619a {

    /* renamed from: a */
    Unbinder f9065a;

    /* renamed from: b */
    private final String f9066b = "ChatEntryFragment";
    @BindView(2131296334)
    Button btnAddContact;
    @BindView(2131296338)
    Button btnShareBridgefy;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f9067c;
    @BindView(2131296362)
    RecyclerView chatEntriesRecyclerView;

    /* renamed from: d */
    private SharedPreferences f9068d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Editor f9069e;
    @BindView(2131296418)
    LinearLayout emptyChatsView;
    @BindView(2131296419)
    public LinearLayout emptyContactsView;
    @BindView(2131296420)
    LinearLayout emptyContainerView;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C3491a f9070f = null;

    /* renamed from: g */
    private C3631b f9071g;

    /* renamed from: h */
    private BroadcastReceiver f9072h = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            ChatEntryFragment.this.m10153a();
            String action = intent.getAction();
            if (((action.hashCode() == 1483287037 && action.equals("contactListUpdated")) ? (char) 0 : 65535) == 0) {
                ChatEntryFragment.this.m10157b();
            }
        }
    };

    /* renamed from: me.bridgefy.chat.ChatEntryFragment$ChatEntryViewHolder */
    class ChatEntryViewHolder extends C1277x {

        /* renamed from: b */
        private ChatEntry f9077b;
        @BindView(2131296311)
        RelativeLayout badgeInitials;
        @BindView(2131296358)
        ConstraintLayout chatEntryContainer;
        @BindView(2131296718)
        TextView chatEntryDateView;
        @BindView(2131296372)
        TextView chatEntryInitialsTextView;
        @BindView(2131296492)
        ImageView chatEntryMessageStatus;
        @BindView(2131296719)
        TextView chatEntryMessageView;
        @BindView(2131296720)
        TextView chatEntryNameView;
        @BindView(2131296736)
        TextView unseenMessagesView;

        public ChatEntryViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        /* renamed from: a */
        public void mo29117a(ChatEntry chatEntry) {
            this.f9077b = chatEntry;
            try {
                C3460d dVar = new C3460d(BridgefyService.m10665d());
                int size = dVar.mo28330a(-1, chatEntry.getUserId()).size() + dVar.mo28330a(-2, chatEntry.getUserId()).size();
                if (chatEntry.isMeshEnabled()) {
                    C3659b.m10893a((View) this.chatEntryContainer);
                } else {
                    C3659b.m10903b((View) this.chatEntryContainer);
                }
                if (size > 0) {
                    this.f9077b.setUnseenMessages(size);
                    this.unseenMessagesView.setText(String.valueOf(size));
                    this.unseenMessagesView.setVisibility(0);
                    this.chatEntryMessageView.setTypeface(null, 1);
                } else {
                    this.unseenMessagesView.setVisibility(8);
                    this.chatEntryMessageView.setTypeface(null, 0);
                }
                ((GradientDrawable) this.chatEntryInitialsTextView.getBackground()).setColor(chatEntry.getColor());
                this.chatEntryInitialsTextView.setText(chatEntry.getInitials());
                this.chatEntryNameView.setText(C3659b.m10905c(chatEntry.getUserName()));
                switch (chatEntry.getMessageType()) {
                    case 1:
                        TextView textView = this.chatEntryMessageView;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ChatEntryFragment.this.getString(R.string.placeholder_image));
                        sb.append(" 🖼");
                        textView.setText(sb.toString());
                        break;
                    case 2:
                        TextView textView2 = this.chatEntryMessageView;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(ChatEntryFragment.this.getString(R.string.placeholder_location));
                        sb2.append(" 📌");
                        textView2.setText(sb2.toString());
                        break;
                    default:
                        this.chatEntryMessageView.setText(chatEntry.getLastText());
                        break;
                }
                if (chatEntry.getLastMessageSender().equals(ChatEntryFragment.this.f9067c)) {
                    switch (chatEntry.getLastMessageStatus()) {
                        case 0:
                        case 1:
                            this.chatEntryMessageStatus.setImageDrawable(ChatEntryFragment.this.getActivity().getDrawable(R.drawable.ic_msg_queued));
                            break;
                        case 2:
                            this.chatEntryMessageStatus.setImageDrawable(ChatEntryFragment.this.getActivity().getDrawable(R.drawable.ic_status_retry));
                            break;
                        case 3:
                            this.chatEntryMessageStatus.setImageDrawable(ChatEntryFragment.this.getActivity().getDrawable(R.drawable.ic_status_sent));
                            break;
                        case 4:
                            this.chatEntryMessageStatus.setImageDrawable(ChatEntryFragment.this.getActivity().getDrawable(R.drawable.ic_status_delivered));
                            break;
                        case 5:
                            this.chatEntryMessageStatus.setImageDrawable(ChatEntryFragment.this.getActivity().getDrawable(R.drawable.ic_status_read));
                            break;
                    }
                } else {
                    this.chatEntryMessageStatus.setImageDrawable(ChatEntryFragment.this.getActivity().getDrawable(R.drawable.ic_msg_received));
                }
                this.chatEntryDateView.setText(C3659b.m10886a(ChatEntryFragment.this.getResources(), chatEntry.getLastDateSent()));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: me.bridgefy.chat.ChatEntryFragment$ChatEntryViewHolder_ViewBinding */
    public class ChatEntryViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a */
        private ChatEntryViewHolder f9078a;

        public ChatEntryViewHolder_ViewBinding(ChatEntryViewHolder chatEntryViewHolder, View view) {
            this.f9078a = chatEntryViewHolder;
            chatEntryViewHolder.chatEntryInitialsTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.contactInitials, "field 'chatEntryInitialsTextView'", TextView.class);
            chatEntryViewHolder.chatEntryContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.chatEntryContainer, "field 'chatEntryContainer'", ConstraintLayout.class);
            chatEntryViewHolder.badgeInitials = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.badgeInitials, "field 'badgeInitials'", RelativeLayout.class);
            chatEntryViewHolder.chatEntryNameView = (TextView) Utils.findRequiredViewAsType(view, R.id.txtChatEntryName, "field 'chatEntryNameView'", TextView.class);
            chatEntryViewHolder.chatEntryDateView = (TextView) Utils.findRequiredViewAsType(view, R.id.txtChatEntryDate, "field 'chatEntryDateView'", TextView.class);
            chatEntryViewHolder.chatEntryMessageView = (TextView) Utils.findRequiredViewAsType(view, R.id.txtChatEntryMessage, "field 'chatEntryMessageView'", TextView.class);
            chatEntryViewHolder.chatEntryMessageStatus = (ImageView) Utils.findRequiredViewAsType(view, R.id.lastMessageStatusView, "field 'chatEntryMessageStatus'", ImageView.class);
            chatEntryViewHolder.unseenMessagesView = (TextView) Utils.findRequiredViewAsType(view, R.id.unseenMessagesView, "field 'unseenMessagesView'", TextView.class);
        }

        public void unbind() {
            ChatEntryViewHolder chatEntryViewHolder = this.f9078a;
            if (chatEntryViewHolder != null) {
                this.f9078a = null;
                chatEntryViewHolder.chatEntryInitialsTextView = null;
                chatEntryViewHolder.chatEntryContainer = null;
                chatEntryViewHolder.badgeInitials = null;
                chatEntryViewHolder.chatEntryNameView = null;
                chatEntryViewHolder.chatEntryDateView = null;
                chatEntryViewHolder.chatEntryMessageView = null;
                chatEntryViewHolder.chatEntryMessageStatus = null;
                chatEntryViewHolder.unseenMessagesView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: me.bridgefy.chat.ChatEntryFragment$a */
    public class C3491a extends C1243a<ChatEntryViewHolder> {

        /* renamed from: a */
        ArrayList<ChatEntry> f9079a;

        /* renamed from: a */
        public ArrayList<ChatEntry> mo29118a() {
            return this.f9079a;
        }

        public C3491a(ArrayList<ChatEntry> arrayList) {
            this.f9079a = arrayList;
        }

        /* renamed from: a */
        public ChatEntry mo29120a(int i) {
            try {
                return (ChatEntry) this.f9079a.get(i);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* renamed from: b */
        public void mo29125b(int i) {
            this.f9079a.remove(i);
            notifyItemRemoved(i);
        }

        public int getItemCount() {
            return this.f9079a.size();
        }

        /* renamed from: a */
        public void mo29121a(String str) {
            int i = 0;
            while (i < this.f9079a.size()) {
                ChatEntry chatEntry = (ChatEntry) this.f9079a.get(i);
                if (chatEntry.getUserId() == null || !chatEntry.getUserId().equals(str)) {
                    i++;
                } else {
                    chatEntry.setMeshEnabled(true);
                    notifyItemChanged(i);
                    return;
                }
            }
        }

        /* renamed from: b */
        public void mo29126b(String str) {
            for (int i = 0; i < this.f9079a.size(); i++) {
                ChatEntry chatEntry = (ChatEntry) this.f9079a.get(i);
                if (chatEntry.getUserId().equals(str)) {
                    chatEntry.setMeshEnabled(C3615a.m10678a().mo29651a(str));
                    notifyItemChanged(i);
                    return;
                }
            }
        }

        /* renamed from: b */
        public void mo29124b() {
            Iterator it = this.f9079a.iterator();
            while (it.hasNext()) {
                ChatEntry chatEntry = (ChatEntry) it.next();
                chatEntry.setMeshEnabled(new BridgefyPeer(chatEntry.getUserId()).isPeerNearby());
            }
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public void mo29122a(ArrayList<ChatEntry> arrayList) {
            HashSet hashSet = new HashSet();
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                ChatEntry chatEntry = (ChatEntry) it.next();
                for (int i = 0; i < this.f9079a.size(); i++) {
                    ChatEntry chatEntry2 = (ChatEntry) this.f9079a.get(i);
                    if (z) {
                        Editor d = ChatEntryFragment.this.f9069e;
                        StringBuilder sb = new StringBuilder();
                        sb.append("chatEntry-");
                        sb.append(chatEntry2.getUserId());
                        d.remove(sb.toString());
                    }
                    try {
                        if (chatEntry2.equals(chatEntry)) {
                            chatEntry.setMeshEnabled(chatEntry2.isMeshEnabled());
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
                if (C3615a.m10678a().mo29651a(chatEntry.getUserId())) {
                    chatEntry.setMeshEnabled(true);
                } else {
                    chatEntry.setMeshEnabled(false);
                }
                z = !ChatEntryFragment.this.f9069e.commit();
                Editor d2 = ChatEntryFragment.this.f9069e;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("chatEntry-");
                sb2.append(chatEntry.getUserId());
                d2.putString(sb2.toString(), chatEntry.serialize());
                hashSet.add(chatEntry.getUserId());
            }
            ChatEntryFragment.this.f9069e.putStringSet("chatEntries", hashSet).apply();
            this.f9079a.clear();
            this.f9079a.addAll(arrayList);
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public void onBindViewHolder(ChatEntryViewHolder chatEntryViewHolder, int i) {
            ChatEntry chatEntry = (ChatEntry) this.f9079a.get(i);
            if (chatEntry != null) {
                chatEntryViewHolder.mo29117a(chatEntry);
            }
        }

        /* renamed from: a */
        public ChatEntryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ChatEntryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_entry_row, viewGroup, false));
        }
    }

    /* renamed from: me.bridgefy.chat.ChatEntryFragment$b */
    private class C3492b extends AsyncTask<String, Void, Void> {
        private C3492b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            String str = strArr[0];
            String str2 = strArr[1];
            new C3460d(BridgefyService.m10665d()).deleteMessages(str);
            C3519c.m10306a(str, str2, (C3521a) null);
            return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f9068d = BridgefyApp.m10557c().getSharedPreferences("BgfyPrefs", 0);
        this.f9069e = this.f9068d.edit();
        this.f9067c = this.f9068d.getString("user_uuid", "");
        if (this.f9071g == null) {
            this.f9071g = new C3631b("ChatEntryFragment", this);
        }
        C1049a.m3996a((Context) getActivity()).mo4059a(this.f9071g, this.f9071g.mo29681a());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.chat_entry_fragment, viewGroup, false);
        this.f9065a = ButterKnife.bind((Object) this, inflate);
        this.f9070f = new C3491a(new ArrayList());
        this.chatEntriesRecyclerView.setAdapter(this.f9070f);
        this.chatEntriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.chatEntriesRecyclerView.addItemDecoration(new C3665e(getActivity(), 1));
        C1860b bVar = new C1860b(new C1858a(this.chatEntriesRecyclerView), new C1865a() {
            /* renamed from: a */
            public boolean mo7196a(int i) {
                return true;
            }

            /* renamed from: a */
            public void mo7195a(C1859b bVar, int i) {
                ChatEntryFragment.this.mo29108b(i);
            }
        });
        C1248f itemAnimator = this.chatEntriesRecyclerView.getItemAnimator();
        if (itemAnimator instanceof C1323l) {
            ((C1323l) itemAnimator).mo5549a(false);
        }
        this.chatEntriesRecyclerView.addOnItemTouchListener(new C3673k(getActivity(), new C1857a(bVar) {
            private final /* synthetic */ C1860b f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(View view, int i) {
                ChatEntryFragment.this.m10155a(this.f$1, view, i);
            }
        }, this));
        m10160c();
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10155a(C1860b bVar, View view, int i) {
        if (view.getId() == R.id.txt_delete) {
            bVar.mo7187a();
        } else if (view.getId() == R.id.txt_undo) {
            bVar.mo7189c();
        } else {
            Bundle bundle = new Bundle();
            ChatEntry a = this.f9070f.mo29120a(i);
            if (a != null) {
                bundle.putString("otherUserName", a.getUserName());
                bundle.putString("otherUserId", a.getUserId());
            }
            BridgefyApp.m10557c().mo29530g().mo27391c((Object) bundle);
        }
    }

    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("chatMessage");
        intentFilter.addAction("messageStatusUpdate");
        intentFilter.addAction("contactListUpdated");
        C1049a.m3996a((Context) getActivity()).mo4059a(this.f9072h, intentFilter);
        m10153a();
    }

    public void onPause() {
        C1049a.m3996a((Context) getActivity()).mo4058a(this.f9072h);
        super.onPause();
    }

    public void onDestroy() {
        C1049a.m3996a((Context) getActivity()).mo4058a((BroadcastReceiver) this.f9071g);
        if (this.f9065a != null) {
            this.f9065a.unbind();
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f9070f = null;
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10153a() {
        if (BridgefyService.m10665d() != null) {
            try {
                new C3460d(BridgefyService.m10665d()).mo28339a(((TabbedMainActivity) getActivity()).mo29539m(), (C3523c<ArrayList<ChatEntry>>) new C3523c<ArrayList<ChatEntry>>() {
                    /* renamed from: a */
                    public void onSuccess(ArrayList<ChatEntry> arrayList) {
                        if (ChatEntryFragment.this.f9070f != null) {
                            ChatEntryFragment.this.f9070f.mo29122a(arrayList);
                            ChatEntryFragment.this.m10157b();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10157b() {
        if (getView() != null && this.chatEntriesRecyclerView != null) {
            if (this.f9070f != null) {
                if (this.f9070f.mo29118a().size() != 0) {
                    this.chatEntriesRecyclerView.setVisibility(0);
                    this.emptyContainerView.setVisibility(8);
                    this.emptyContactsView.setVisibility(8);
                    this.emptyChatsView.setVisibility(8);
                } else if (new C3457c(BridgefyService.m10665d()).mo28317a(false).size() == 0) {
                    if (getActivity() != null) {
                        ((TabbedMainActivity) getActivity()).tooltipNewConversation.setVisibility(8);
                    }
                    this.chatEntriesRecyclerView.setVisibility(8);
                    this.emptyContainerView.setVisibility(0);
                    this.emptyContactsView.setVisibility(0);
                    this.emptyChatsView.setVisibility(8);
                    this.btnShareBridgefy.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            ChatEntryFragment.this.m10158b(view);
                        }
                    });
                    this.btnAddContact.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            ChatEntryFragment.this.m10154a(view);
                        }
                    });
                } else {
                    this.chatEntriesRecyclerView.setVisibility(8);
                    this.emptyContainerView.setVisibility(0);
                    this.emptyContactsView.setVisibility(8);
                    this.emptyChatsView.setVisibility(0);
                }
                for (BridgefyPeer id : C3615a.m10678a().mo29652b()) {
                    this.f9070f.mo29121a(id.getId());
                }
                return;
            }
            this.f9070f = new C3491a(new ArrayList());
            this.chatEntriesRecyclerView.setAdapter(this.f9070f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10158b(View view) {
        C3659b.m10895a(new WeakReference<>(getActivity()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10154a(View view) {
        C3662d.m10922a(getActivity());
    }

    /* renamed from: c */
    private void m10160c() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = (HashSet) this.f9068d.getStringSet("chatEntries", null);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                try {
                    SharedPreferences sharedPreferences = this.f9068d;
                    StringBuilder sb = new StringBuilder();
                    sb.append("chatEntry-");
                    sb.append(str);
                    ChatEntry create = ChatEntry.create(sharedPreferences.getString(sb.toString(), null));
                    boolean z = false;
                    create.setMeshEnabled(false);
                    int i = 0;
                    while (true) {
                        if (i >= arrayList.size()) {
                            break;
                        }
                        if (Long.parseLong(create.getLastDateSent()) > Long.parseLong(((ChatEntry) arrayList.get(i)).getLastDateSent())) {
                            arrayList.add(i, create);
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (!z) {
                        arrayList.add(create);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.f9070f.mo29118a().addAll(arrayList);
        this.f9070f.notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m10156a(BridgefyPeer bridgefyPeer) {
        if (getActivity() != null && isAdded() && this.f9070f != null) {
            for (int i = 0; i < this.f9070f.f9079a.size(); i++) {
                ChatEntry a = this.f9070f.mo29120a(i);
                if (!(a == null || a.getUserId() == null || !a.getUserId().equals(bridgefyPeer.getId()))) {
                    a.setMeshEnabled(true);
                    this.f9070f.notifyItemChanged(i);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo29017a(BridgefyPeer bridgefyPeer, Antenna antenna) {
        if (getActivity() != null) {
            m10156a(bridgefyPeer);
        }
    }

    /* renamed from: b */
    public void mo29018b(BridgefyPeer bridgefyPeer, Antenna antenna) {
        if (this.chatEntriesRecyclerView != null) {
            if (this.f9070f == null) {
                this.f9070f = new C3491a(new ArrayList());
                this.chatEntriesRecyclerView.setAdapter(this.f9070f);
            }
            this.f9070f.mo29126b(bridgefyPeer.getId());
        }
    }

    /* renamed from: a */
    public void mo29014a(Antenna antenna) {
        if (this.f9070f == null) {
            this.f9070f = new C3491a(new ArrayList());
            this.chatEntriesRecyclerView.setAdapter(this.f9070f);
        }
        this.f9070f.mo29124b();
    }

    /* renamed from: a */
    public void mo29107a(int i) {
        C3510a aVar = new C3510a();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        aVar.setArguments(bundle);
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().add(aVar, "delete_fragment").commitAllowingStateLoss();
        }
    }

    /* renamed from: b */
    public void mo29108b(int i) {
        if (this.f9070f != null) {
            ChatEntry a = this.f9070f.mo29120a(i);
            if (a != null) {
                String userId = a.getUserId();
                new C3492b().execute(new String[]{userId, this.f9067c});
                this.f9070f.mo29125b(i);
                m10157b();
                C3620a.m10705a(userId);
            }
        } else if (this.chatEntriesRecyclerView != null) {
            this.f9070f = new C3491a(new ArrayList());
            this.chatEntriesRecyclerView.setAdapter(this.f9070f);
        }
    }
}
