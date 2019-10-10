package p140me.bridgefy.contacts;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.C0597b;
import androidx.p079f.p080a.C1049a;
import androidx.recyclerview.widget.C1323l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C1243a;
import androidx.recyclerview.widget.RecyclerView.C1248f;
import androidx.recyclerview.widget.RecyclerView.C1263n;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.C1347b;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bridgefy.sdk.client.Config.Antenna;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import me.bridgefy.main.R;
import p000a.p013b.p017b.C0161b;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3522b;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.TabbedMainActivity;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.service.p146c.C3619a;
import p140me.bridgefy.service.p148e.C3631b;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3662d;
import p140me.bridgefy.utils.C3672j;

/* renamed from: me.bridgefy.contacts.ContactsFragment */
public class ContactsFragment extends Fragment implements C3619a {

    /* renamed from: a */
    Unbinder f9180a;

    /* renamed from: b */
    private final String f9181b = "-1";
    @BindView(2131296334)
    Button btnAddContact;
    @BindView(2131296338)
    Button btnShareBridgefy;

    /* renamed from: c */
    private final String f9182c = "-2";

    /* renamed from: d */
    private final String f9183d = "-3";

    /* renamed from: e */
    private final String f9184e = "-4";
    @BindView(2131296419)
    public LinearLayout emptyContactsView;

    /* renamed from: f */
    private final String f9185f = "-5";

    /* renamed from: g */
    private String f9186g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SharedPreferences f9187h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C3457c f9188i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f9189j = false;

    /* renamed from: k */
    private C3631b f9190k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ProgressBar f9191l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C3532a f9192m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LinearLayoutManager f9193n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f9194o;
    @BindView(2131296550)
    RecyclerView peersRecyclerView;
    @BindView(2131296569)
    SwipeRefreshLayout refreshLayout;
    @BindView(2131296664)
    RelativeLayout tooltipNearby;

    /* renamed from: me.bridgefy.contacts.ContactsFragment$ContactViewHolder */
    public class ContactViewHolder extends C1277x implements OnClickListener {

        /* renamed from: b */
        private BridgefyPeer f9200b;
        @BindView(2131296476)
        TextView inRangeBadge;
        @BindView(2131296372)
        TextView vInitialsTextView;
        @BindView(2131296373)
        TextView vName;
        @BindView(2131296727)
        TextView vTitleRow;

        ContactViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            view.setOnClickListener(this);
        }

        /* renamed from: a */
        public void mo29241a(BridgefyPeer bridgefyPeer) {
            this.f9200b = bridgefyPeer;
            if (!ContactsFragment.this.m10348e(bridgefyPeer)) {
                FriendDTO c = ContactsFragment.this.f9188i.query_friend_dto_by_id(bridgefyPeer.getId());
                if (c != null) {
                    try {
                        this.vName.setText(bridgefyPeer.getDisplayName());
                        this.vInitialsTextView.setText(C3659b.m10902b(bridgefyPeer.getDisplayName()));
                        ((GradientDrawable) this.vInitialsTextView.getBackground()).setColor(c.getColor());
                        if (!bridgefyPeer.isPeerNearby() || getLayoutPosition() >= ContactsFragment.this.f9194o) {
                            this.inRangeBadge.setVisibility(8);
                        } else {
                            this.inRangeBadge.setVisibility(0);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            } else if (bridgefyPeer.getId().equals("-1")) {
                this.vTitleRow.setText(ContactsFragment.this.getString(R.string.row_nearby_contacts_title));
            }
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r4) {
            /*
                r3 = this;
                me.bridgefy.entities.BridgefyPeer r4 = r3.f9200b
                java.lang.String r4 = r4.getId()
                int r0 = r4.hashCode()
                switch(r0) {
                    case 1444: goto L_0x0036;
                    case 1445: goto L_0x002c;
                    case 1446: goto L_0x0022;
                    case 1447: goto L_0x0018;
                    case 1448: goto L_0x000e;
                    default: goto L_0x000d;
                }
            L_0x000d:
                goto L_0x0040
            L_0x000e:
                java.lang.String r0 = "-5"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0040
                r4 = 4
                goto L_0x0041
            L_0x0018:
                java.lang.String r0 = "-4"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0040
                r4 = 3
                goto L_0x0041
            L_0x0022:
                java.lang.String r0 = "-3"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0040
                r4 = 2
                goto L_0x0041
            L_0x002c:
                java.lang.String r0 = "-2"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0040
                r4 = 1
                goto L_0x0041
            L_0x0036:
                java.lang.String r0 = "-1"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0040
                r4 = 0
                goto L_0x0041
            L_0x0040:
                r4 = -1
            L_0x0041:
                switch(r4) {
                    case 0: goto L_0x008c;
                    case 1: goto L_0x008c;
                    case 2: goto L_0x008c;
                    case 3: goto L_0x007e;
                    case 4: goto L_0x006b;
                    default: goto L_0x0044;
                }
            L_0x0044:
                android.os.Bundle r4 = new android.os.Bundle
                r4.<init>()
                java.lang.String r0 = "otherUserName"
                me.bridgefy.entities.BridgefyPeer r1 = r3.f9200b
                java.lang.String r1 = r1.getDisplayName()
                r4.putString(r0, r1)
                java.lang.String r0 = "otherUserId"
                me.bridgefy.entities.BridgefyPeer r1 = r3.f9200b
                java.lang.String r1 = r1.getId()
                r4.putString(r0, r1)
                me.bridgefy.main.BridgefyApp r0 = p140me.bridgefy.main.BridgefyApp.m10557c()
                com.squareup.a.b r0 = r0.mo29530g()
                r0.mo27391c(r4)
                goto L_0x008c
            L_0x006b:
                me.bridgefy.contacts.ContactsFragment r4 = p140me.bridgefy.contacts.ContactsFragment.this
                android.content.Intent r0 = new android.content.Intent
                me.bridgefy.contacts.ContactsFragment r1 = p140me.bridgefy.contacts.ContactsFragment.this
                android.app.Activity r1 = r1.getActivity()
                java.lang.Class<me.bridgefy.contacts.ContactsHelpActivity> r2 = p140me.bridgefy.contacts.ContactsHelpActivity.class
                r0.<init>(r1, r2)
                r4.startActivity(r0)
                goto L_0x008c
            L_0x007e:
                java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
                me.bridgefy.contacts.ContactsFragment r0 = p140me.bridgefy.contacts.ContactsFragment.this
                android.app.Activity r0 = r0.getActivity()
                r4.<init>(r0)
                p140me.bridgefy.utils.C3659b.m10895a(r4)
            L_0x008c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.contacts.ContactsFragment.ContactViewHolder.onClick(android.view.View):void");
        }
    }

    /* renamed from: me.bridgefy.contacts.ContactsFragment$ContactViewHolder_ViewBinding */
    public class ContactViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a */
        private ContactViewHolder f9201a;

        public ContactViewHolder_ViewBinding(ContactViewHolder contactViewHolder, View view) {
            this.f9201a = contactViewHolder;
            contactViewHolder.vName = (TextView) Utils.findOptionalViewAsType(view, R.id.contactName, "field 'vName'", TextView.class);
            contactViewHolder.inRangeBadge = (TextView) Utils.findOptionalViewAsType(view, R.id.inRangeBadge, "field 'inRangeBadge'", TextView.class);
            contactViewHolder.vInitialsTextView = (TextView) Utils.findOptionalViewAsType(view, R.id.contactInitials, "field 'vInitialsTextView'", TextView.class);
            contactViewHolder.vTitleRow = (TextView) Utils.findOptionalViewAsType(view, R.id.txtTitleRow, "field 'vTitleRow'", TextView.class);
        }

        public void unbind() {
            ContactViewHolder contactViewHolder = this.f9201a;
            if (contactViewHolder != null) {
                this.f9201a = null;
                contactViewHolder.vName = null;
                contactViewHolder.inRangeBadge = null;
                contactViewHolder.vInitialsTextView = null;
                contactViewHolder.vTitleRow = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: me.bridgefy.contacts.ContactsFragment$a */
    public class C3532a extends C1243a<ContactViewHolder> {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public List<BridgefyPeer> f9203b;

        C3532a(List<BridgefyPeer> list) {
            this.f9203b = list;
        }

        public int getItemCount() {
            return this.f9203b.size();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public BridgefyPeer mo29244a(int i) {
            return (BridgefyPeer) this.f9203b.get(i);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo29245a(int i, BridgefyPeer bridgefyPeer) {
            if (bridgefyPeer.getId() != null) {
                this.f9203b.set(i, bridgefyPeer);
                notifyItemChanged(i);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo29249b(int i, BridgefyPeer bridgefyPeer) throws IndexOutOfBoundsException {
            if (bridgefyPeer.getId() != null) {
                this.f9203b.add(i, bridgefyPeer);
                notifyItemInserted(i);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo29247a(BridgefyPeer bridgefyPeer) throws IndexOutOfBoundsException {
            if (bridgefyPeer.getId() != null && this.f9203b != null) {
                this.f9203b.add(bridgefyPeer);
                notifyDataSetChanged();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo29248b(int i) {
            this.f9203b.remove(i);
            notifyItemRemoved(i);
        }

        /* renamed from: a */
        public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
            contactViewHolder.itemView.setLongClickable(true);
            BridgefyPeer bridgefyPeer = (BridgefyPeer) this.f9203b.get(i);
            if (bridgefyPeer != null) {
                contactViewHolder.mo29241a(bridgefyPeer);
            }
        }

        public int getItemViewType(int i) {
            if (i == 0 || i == ContactsFragment.this.f9194o) {
                return 2;
            }
            if (i == 1 && ((BridgefyPeer) this.f9203b.get(1)).getId().equals("-2")) {
                return 1;
            }
            if (i == this.f9203b.size() - 2) {
                return 3;
            }
            return i == this.f9203b.size() - 1 ? 4 : 0;
        }

        /* renamed from: a */
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            switch (i) {
                case 1:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_empty_row, viewGroup, false);
                    break;
                case 2:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_title_row, viewGroup, false);
                    break;
                case 3:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_share_row, viewGroup, false);
                    break;
                case 4:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_help_row, viewGroup, false);
                    break;
                default:
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_peer_row, viewGroup, false);
                    break;
            }
            return new ContactViewHolder(view);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f9190k == null) {
            this.f9190k = new C3631b("ContactsFragment", this);
        }
        C1049a.m3996a((Context) getActivity()).mo4059a(this.f9190k, this.f9190k.mo29681a());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.contacts_fragment, viewGroup, false);
        this.f9180a = ButterKnife.bind((Object) this, inflate);
        this.f9192m = new C3532a(new ArrayList());
        this.f9193n = new LinearLayoutManager(getActivity());
        this.peersRecyclerView.setLayoutManager(this.f9193n);
        this.peersRecyclerView.setAdapter(this.f9192m);
        C1248f itemAnimator = this.peersRecyclerView.getItemAnimator();
        int color = getResources().getColor(R.color.bridgefy_primary);
        this.refreshLayout.setColorSchemeColors(color);
        this.refreshLayout.setOnRefreshListener(new C1347b() {
            public final void onRefresh() {
                ContactsFragment.this.m10343c();
            }
        });
        if (itemAnimator instanceof C1323l) {
            ((C1323l) itemAnimator).mo5549a(false);
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10343c() {
        mo29234a(true);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.main_toolbar, null);
        C0597b bVar = new C0597b(-2, -2, 53);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.addView(inflate, bVar);
            this.f9191l = (ProgressBar) toolbar.findViewById(R.id.discovery_progress_bar);
        }
        this.f9187h = getActivity().getSharedPreferences("BgfyPrefs", 0);
        this.f9186g = this.f9187h.getString("user_uuid", "");
        if (this.f9187h.getBoolean("tooltipNewFriend", true)) {
            final RelativeLayout relativeLayout = ((TabbedMainActivity) getActivity()).tooltipNewFriend;
            this.peersRecyclerView.addOnScrollListener(new C1263n() {
                /* renamed from: a */
                public void mo5206a(RecyclerView recyclerView, int i) {
                    super.mo5206a(recyclerView, i);
                    if (i == 1) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(ContactsFragment.this.getActivity(), R.anim.view_exit_anim_slide_up);
                        if (relativeLayout.getVisibility() == 0) {
                            relativeLayout.setAnimation(loadAnimation);
                            relativeLayout.setVisibility(8);
                        }
                        if (ContactsFragment.this.tooltipNearby.getVisibility() == 0) {
                            ContactsFragment.this.tooltipNearby.setAnimation(loadAnimation);
                            ContactsFragment.this.tooltipNearby.setVisibility(8);
                        }
                    } else if (i == 2 && ContactsFragment.this.f9193n.mo4794n() == 0) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(ContactsFragment.this.getActivity(), R.anim.view_entry_anim_slide_down);
                        if (ContactsFragment.this.f9187h.getBoolean("tooltipNewFriend", true) && relativeLayout.getVisibility() == 8) {
                            relativeLayout.setAnimation(loadAnimation2);
                            relativeLayout.setVisibility(0);
                        }
                        if (ContactsFragment.this.f9187h.getBoolean("tooltipNearby", true) && ContactsFragment.this.tooltipNearby.getVisibility() == 8 && !ContactsFragment.this.f9192m.mo29244a(1).getId().equals("-2")) {
                            ContactsFragment.this.tooltipNearby.setAnimation(loadAnimation2);
                            ContactsFragment.this.tooltipNearby.setVisibility(0);
                        }
                    }
                }
            });
        }
        this.tooltipNearby.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ContactsFragment.this.m10339b(view);
            }
        });
        Intent intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            this.btnAddContact.setOnClickListener(new OnClickListener(intent) {
                private final /* synthetic */ Intent f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ContactsFragment.this.m10331a(this.f$1, view);
                }
            });
        } else {
            this.btnAddContact.setVisibility(8);
        }
        try {
            this.f9188i = new C3457c(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        m10338b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10339b(View view) {
        this.tooltipNearby.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_exit_anim));
        this.tooltipNearby.setVisibility(8);
        this.f9187h.edit().putBoolean("tooltipNearby", false).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10331a(Intent intent, View view) {
        startActivityForResult(intent, 222);
    }

    public void onDestroy() {
        if (this.f9180a != null) {
            this.f9180a.unbind();
        }
        C1049a.m3996a((Context) getActivity()).mo4058a((BroadcastReceiver) this.f9190k);
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f9192m = null;
        super.onDestroyView();
    }

    /* renamed from: b */
    private void m10338b() {
        this.f9192m.f9203b.clear();
        this.f9192m.f9203b.add(new BridgefyPeer("-1"));
        this.f9192m.f9203b.add(new BridgefyPeer("-2"));
        this.f9192m.f9203b.add(new BridgefyPeer("-3"));
        this.f9194o = 2;
        List arrayList = new ArrayList();
        if (this.f9188i != null) {
            arrayList = this.f9188i.mo28317a(false);
        }
        if (arrayList.size() > 0) {
            this.peersRecyclerView.setVisibility(0);
            this.f9192m.f9203b.addAll(arrayList);
            this.emptyContactsView.setVisibility(8);
        } else {
            this.emptyContactsView.setVisibility(0);
            this.btnShareBridgefy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    ContactsFragment.this.m10332a(view);
                }
            });
        }
        this.f9192m.f9203b.add(new BridgefyPeer("-4"));
        this.f9192m.f9203b.add(new BridgefyPeer("-5"));
        this.f9192m.notifyDataSetChanged();
        for (BridgefyPeer bridgefyPeer : C3615a.m10678a().mo29652b()) {
            m10337b(bridgefyPeer);
            m10346d(bridgefyPeer);
        }
        if (!this.f9189j) {
            mo29234a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10332a(View view) {
        C3659b.m10895a(new WeakReference<>(getActivity()));
    }

    /* renamed from: a */
    public void mo29017a(BridgefyPeer bridgefyPeer, Antenna antenna) {
        if (getActivity() != null && this.f9192m != null && (((antenna != Antenna.BLUETOOTH_LE && antenna != Antenna.BLUETOOTH_LE) || C3659b.m10906c((Context) getActivity())) && this.f9192m.getItemCount() != 0)) {
            BridgefyPeer b = m10337b(bridgefyPeer);
            if (b == null) {
                FriendDTO c = this.f9188i.query_friend_dto_by_id(bridgefyPeer.getId());
                if (c != null) {
                    m10346d(new BridgefyPeer(c));
                } else {
                    m10346d(bridgefyPeer);
                }
            } else {
                m10346d(b);
            }
            if (this.emptyContactsView.getVisibility() == 0 && this.f9192m.f9203b.size() > 4) {
                this.emptyContactsView.setVisibility(8);
                this.peersRecyclerView.setVisibility(0);
            }
            if (!this.f9192m.mo29244a(1).getId().equals("-2") && this.f9187h.getBoolean("tooltipNearby", true) && this.tooltipNearby.getVisibility() != 0 && this.f9193n.mo4794n() == 0) {
                this.tooltipNearby.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_entry_anim));
                this.tooltipNearby.setVisibility(0);
            }
        }
    }

    /* renamed from: b */
    public void mo29018b(BridgefyPeer bridgefyPeer, Antenna antenna) {
        if (getActivity() != null && this.f9192m != null && this.f9192m.getItemCount() != 0) {
            m10334a(m10342c(bridgefyPeer));
            if (this.f9192m.f9203b.size() <= 5) {
                this.emptyContactsView.setVisibility(0);
                this.peersRecyclerView.setVisibility(8);
            }
            if (this.f9192m.mo29244a(1).getId().equals("-2")) {
                this.tooltipNearby.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_exit_anim));
                this.tooltipNearby.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    public void mo29014a(Antenna antenna) {
        if (getActivity() != null && this.f9192m != null && this.f9192m.getItemCount() != 0) {
            if (!this.f9192m.mo29244a(1).getId().equals("-2")) {
                int i = 1;
                while (i < this.f9194o) {
                    BridgefyPeer a = this.f9192m.mo29244a(i);
                    if (!a.isPeerNearby()) {
                        this.f9192m.mo29248b(i);
                        this.f9194o--;
                        i--;
                        m10334a(a);
                    }
                    i++;
                }
                if (this.f9192m.mo29244a(1).getId().equals("-3")) {
                    this.f9192m.mo29249b(1, new BridgefyPeer("-2"));
                    this.f9194o = 2;
                }
            }
            if (this.f9192m.mo29244a(1).getId().equals("-2")) {
                this.tooltipNearby.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.view_exit_anim));
                this.tooltipNearby.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    public void mo29234a(final boolean z) {
        C3662d dVar;
        if (getActivity() != null) {
            dVar = ((TabbedMainActivity) getActivity()).mo29539m();
        } else {
            Log.w("ContactsFragment", "Activity is null, unable to update contacts list!");
            dVar = null;
        }
        if (dVar == null || this.f9188i == null) {
            Log.w("ContactsFragment", "ContactUtils or FriendController was null, unable to update contacts list!");
            return;
        }
        if (z || this.f9189j) {
            mo29233a();
            if (this.f9189j) {
                Toast.makeText(getActivity(), BridgefyApp.m10557c().getBaseContext().getString(R.string.contact_list_update), 0).show();
            }
        }
        C3519c.m10300a(this.f9187h, this.f9188i, dVar, (C3522b) new C3522b<BridgefyPeer>() {
            public void onSubscribe(C0161b bVar) {
                ContactsFragment.this.f9189j = true;
            }

            /* renamed from: a */
            public void onNext(BridgefyPeer bridgefyPeer) {
                if (ContactsFragment.this.f9192m != null && bridgefyPeer.getContactName() != null) {
                    if (C3615a.m10678a().mo29652b().contains(bridgefyPeer)) {
                        ContactsFragment.this.m10346d(bridgefyPeer);
                    } else {
                        ContactsFragment.this.m10334a(bridgefyPeer);
                    }
                }
            }

            public void onError(Throwable th) {
                ContactsFragment.this.f9189j = false;
                try {
                    if (ContactsFragment.this.f9191l != null) {
                        ContactsFragment.this.f9191l.setVisibility(8);
                    }
                    if (ContactsFragment.this.refreshLayout != null) {
                        ContactsFragment.this.refreshLayout.setRefreshing(false);
                    }
                    if (th instanceof C3672j) {
                        if (ContactsFragment.this.getActivity() != null) {
                            ((TabbedMainActivity) ContactsFragment.this.getActivity()).mo29056a();
                        }
                    } else if (z && ContactsFragment.this.getActivity() != null) {
                        Toast.makeText(ContactsFragment.this.getActivity(), ContactsFragment.this.getActivity().getString(R.string.contact_list_update_error), 1).show();
                    }
                } catch (Exception unused) {
                    th.printStackTrace();
                }
            }

            public void onComplete() {
                ContactsFragment.this.f9189j = false;
                C1049a.m3996a(BridgefyApp.m10557c().getApplicationContext()).mo4060a(new Intent("contactListUpdated"));
                if (z || (ContactsFragment.this.refreshLayout != null && ContactsFragment.this.refreshLayout.mo5591b())) {
                    if (ContactsFragment.this.refreshLayout != null) {
                        ContactsFragment.this.refreshLayout.setRefreshing(false);
                    }
                    if (ContactsFragment.this.f9191l != null) {
                        ContactsFragment.this.f9191l.setVisibility(8);
                    }
                    Toast.makeText(BridgefyApp.m10557c().getBaseContext(), BridgefyApp.m10557c().getBaseContext().getString(R.string.contact_list_updated), 0).show();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10334a(BridgefyPeer bridgefyPeer) {
        if (getActivity() != null && bridgefyPeer != null) {
            if (this.f9192m == null) {
                this.f9192m = new C3532a(new ArrayList());
                this.peersRecyclerView = (RecyclerView) getActivity().findViewById(R.id.peers_recycler_view);
                this.peersRecyclerView.setAdapter(this.f9192m);
            }
            int i = this.f9194o + 1;
            int i2 = i;
            while (i < this.f9192m.getItemCount() - 2) {
                BridgefyPeer a = this.f9192m.mo29244a(i);
                if (a.equals(bridgefyPeer)) {
                    this.f9192m.mo29245a(i, bridgefyPeer);
                    return;
                }
                if (bridgefyPeer.getDisplayName().compareToIgnoreCase(a.getDisplayName()) > 0) {
                    i2 = i + 1;
                }
                i++;
            }
            if (bridgefyPeer.getId() != null && !bridgefyPeer.getId().equals(this.f9186g)) {
                this.emptyContactsView.setVisibility(8);
                this.peersRecyclerView.setVisibility(0);
                try {
                    this.f9192m.mo29249b(i2, bridgefyPeer);
                } catch (IndexOutOfBoundsException unused) {
                    this.f9192m.mo29247a(bridgefyPeer);
                }
            }
        }
    }

    /* renamed from: b */
    private BridgefyPeer m10337b(BridgefyPeer bridgefyPeer) {
        for (int i = this.f9194o; i < this.f9192m.getItemCount() - 2; i++) {
            BridgefyPeer a = this.f9192m.mo29244a(i);
            if (a.equals(bridgefyPeer)) {
                this.f9192m.mo29248b(i);
                return a;
            }
        }
        return null;
    }

    /* renamed from: c */
    private BridgefyPeer m10342c(BridgefyPeer bridgefyPeer) {
        for (int i = 1; i < this.f9194o; i++) {
            BridgefyPeer a = this.f9192m.mo29244a(i);
            if (a.equals(bridgefyPeer)) {
                this.f9192m.mo29248b(i);
                this.f9194o--;
                if (this.f9192m.mo29244a(1).getId().equals("-3")) {
                    this.f9192m.mo29249b(1, new BridgefyPeer("-2"));
                    this.f9194o = 2;
                }
                if (a.getPhone() == null || a.getPhone().length() <= 0) {
                    return null;
                }
                return a;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10346d(BridgefyPeer bridgefyPeer) {
        int i;
        if (bridgefyPeer != null) {
            if (this.f9192m.mo29244a(1).getId().equals("-2")) {
                this.f9192m.mo29248b(1);
                this.f9194o--;
                i = 1;
            } else {
                int i2 = 1;
                i = 1;
                while (i2 < this.f9194o) {
                    BridgefyPeer a = this.f9192m.mo29244a(i2);
                    if (!a.equals(bridgefyPeer)) {
                        if (bridgefyPeer.getDisplayName().compareToIgnoreCase(a.getDisplayName()) > 0) {
                            i = i2 + 1;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }
            this.f9192m.mo29249b(i, bridgefyPeer);
            this.f9194o++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m10348e(BridgefyPeer bridgefyPeer) {
        return bridgefyPeer.getId().equals("-1") || bridgefyPeer.getId().equals("-2") || bridgefyPeer.getId().equals("-3") || bridgefyPeer.getId().equals("-4") || bridgefyPeer.getId().equals("-5");
    }

    /* renamed from: a */
    public void mo29233a() {
        if (this.f9191l != null) {
            this.f9191l.setVisibility(0);
        }
    }
}
