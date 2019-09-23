package p140me.bridgefy.chat;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.p079f.p080a.C1049a;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bridgefy.sdk.framework.controller.DeviceManager;
import com.github.clans.fab.FloatingActionMenu;
import com.squareup.picasso.C3068t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.bridgefy.main.R;
import p140me.bridgefy.chat.ChatBaseFragment.C3480a;
import p140me.bridgefy.chat.ChatFragment.C3499a;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.image.BridgefyProgress;
import p140me.bridgefy.image.C3540a;
import p140me.bridgefy.image.C3542b;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.service.p147d.C3620a;
import p140me.bridgefy.service.p147d.C3622b;
import p140me.bridgefy.storage.C3642a;
import p140me.bridgefy.storage.C3644b;
import p140me.bridgefy.storage.p149a.C3643a;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3667g;

/* renamed from: me.bridgefy.chat.ChatFragment */
public class ChatFragment extends ChatBaseFragment {

    /* renamed from: a */
    Unbinder f9083a;
    @BindView(2131296300)
    TextView addContactBar;
    @BindView(2131296314)
    TextView blockedContactBar;

    /* renamed from: j */
    private boolean f9084j = true;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C3667g f9085k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ChatActivity f9086l;

    /* renamed from: m */
    private Uri f9087m;

    /* renamed from: n */
    private Intent f9088n;

    /* renamed from: o */
    private BroadcastReceiver f9089o = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            ChatFragment.this.f9086l.finish();
        }
    };

    /* renamed from: p */
    private BroadcastReceiver f9090p = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Message create = Message.create(intent.getStringExtra("bridgefyMessage"));
            if (create != null && create.getReceiver().equals(ChatFragment.this.f9030i)) {
                ((C3501b) ChatFragment.this.f9023b).mo29154b(create);
            }
        }
    };

    /* renamed from: q */
    private C3643a f9091q = new C3643a() {
        /* renamed from: a */
        public void mo29142a(String str, int i) {
            int a = m10206a(ChatFragment.this.f9023b.f9045b, str);
            if (a >= 0) {
                C1277x findViewHolderForAdapterPosition = ChatFragment.this.messagesListView.findViewHolderForAdapterPosition(a);
                if (findViewHolderForAdapterPosition != null) {
                    MessageViewHolder messageViewHolder = (MessageViewHolder) findViewHolderForAdapterPosition;
                    C3644b a2 = C3642a.m10779a().mo29735a(messageViewHolder.f9034b.getOfflineId());
                    if (a2 != null) {
                        a2.mo29747b(i);
                    }
                    messageViewHolder.mo29145a(i);
                }
            }
        }

        /* renamed from: a */
        public void mo29144a(String str, Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("onError: uploadId: ");
            sb.append(str);
            Log.w("ChatFragment", sb.toString());
            exc.printStackTrace();
            C3642a.m10779a().mo29737b(str);
            int a = m10206a(ChatFragment.this.f9023b.f9045b, str);
            if (a >= 0) {
                C1277x findViewHolderForAdapterPosition = ChatFragment.this.messagesListView.findViewHolderForAdapterPosition(a);
                if (findViewHolderForAdapterPosition != null) {
                    MessageViewHolder messageViewHolder = (MessageViewHolder) findViewHolderForAdapterPosition;
                    messageViewHolder.imgProgressBar.mo29364b();
                    messageViewHolder.imgProgressBar.setText(ChatFragment.this.getString(R.string.dialog_retry));
                    messageViewHolder.imgProgressBar.setOnClickListener(ChatFragment.this.f9092r);
                }
            }
        }

        /* renamed from: a */
        public void mo29143a(String str, int i, String str2) {
            C3642a.m10779a().mo29737b(str);
            int a = m10206a(ChatFragment.this.f9023b.f9045b, str);
            if (a >= 0) {
                C1277x findViewHolderForAdapterPosition = ChatFragment.this.messagesListView.findViewHolderForAdapterPosition(a);
                if (findViewHolderForAdapterPosition != null) {
                    MessageViewHolder messageViewHolder = (MessageViewHolder) findViewHolderForAdapterPosition;
                    if (i == 409) {
                        messageViewHolder.imgProgressBar.setText("Sending...");
                    }
                    if (i == 200) {
                        messageViewHolder.m10212b();
                    }
                }
            }
        }

        /* renamed from: a */
        private int m10206a(List<Message> list, String str) {
            Message b = ChatFragment.this.f9024c.mo28341b(str);
            if (b != null) {
                for (int i = 0; i < list.size(); i++) {
                    Message message = (Message) list.get(i);
                    if (message != null && ((message.getOfflineId() != null && message.getOfflineId().equals(str)) || (message.getDateSent() != null && message.getDateSent().equalsIgnoreCase(b.getDateSent())))) {
                        return i;
                    }
                }
            }
            return -1;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnClickListener f9092r = new OnClickListener() {
        public final void onClick(View view) {
            ChatFragment.this.m10186a(view);
        }
    };
    @BindView(2131296737)
    LinearLayout unverifiedContactBar;

    /* renamed from: me.bridgefy.chat.ChatFragment$MessageViewHolder */
    class MessageViewHolder extends p140me.bridgefy.chat.ChatBaseFragment.MessageViewHolder {

        /* renamed from: a */
        OnClickListener f9096a = new OnClickListener() {

            /* renamed from: b */
            private final C3542b f9100b = new C3542b() {
                /* renamed from: a */
                public void mo29150a(C3540a aVar) {
                    Log.d("ChatFragment", "Start image download.");
                }

                /* renamed from: a */
                public void mo29148a(Uri uri) {
                    if (MessageViewHolder.this.imgProgressBar != null && ChatFragment.this.f9086l != null && !ChatFragment.this.f9086l.isFinishing()) {
                        ChatFragment.this.f9086l.runOnUiThread(new Runnable(this) {
                            private final /* synthetic */ C34981 f$0;

                            public final 
/*
Method generation error in method: me.bridgefy.chat.-$$Lambda$ChatFragment$MessageViewHolder$2$1$GoBp2Fe75x2R-efY4QBb_V20LPY.run():null, dex: classes2.dex
                            java.lang.NullPointerException
                            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:442)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:109)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:311)
                            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:661)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:595)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:773)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:713)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:239)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:138)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:316)
                            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:661)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:595)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:95)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:469)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:435)
                            	at jadx.core.codegen.ClassGen.addField(ClassGen.java:376)
                            	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:346)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:223)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:661)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:595)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:95)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:469)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:435)
                            	at jadx.core.codegen.ClassGen.addField(ClassGen.java:376)
                            	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:346)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:223)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
                            	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:237)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:76)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
                            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
                            
*/
                        });
                        C34972.this.m10217a(MessageViewHolder.this.f9034b);
                    }
                }

                /* access modifiers changed from: private */
                /* renamed from: b */
                public /* synthetic */ void m10219b() {
                    MessageViewHolder.this.imageView.setImageURI(MessageViewHolder.this.f9034b.findFileUri());
                    MessageViewHolder.this.imgProgressBar.mo29365c();
                    MessageViewHolder.this.imgProgressBar.setVisibility(8);
                }

                /* renamed from: a */
                public void mo29149a(Exception exc) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(exc.getMessage());
                    Log.e("ChatFragment", sb.toString());
                    if (MessageViewHolder.this.imgProgressBar != null) {
                        ChatFragment.this.f9086l.runOnUiThread(new Runnable(this) {
                            private final /* synthetic */ C34981 f$0;

                            public final 
/*
Method generation error in method: me.bridgefy.chat.-$$Lambda$ChatFragment$MessageViewHolder$2$1$AZXbuvpiMrf86a28kVa6QzGPDIw.run():null, dex: classes2.dex
                            java.lang.NullPointerException
                            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:442)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:109)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:311)
                            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:661)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:595)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:773)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:713)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:357)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:239)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:138)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:316)
                            	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:262)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:225)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:661)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:595)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:95)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:469)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:435)
                            	at jadx.core.codegen.ClassGen.addField(ClassGen.java:376)
                            	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:346)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:223)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:661)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:595)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:105)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:95)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:469)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:223)
                            	at jadx.core.codegen.ClassGen.addInsnBody(ClassGen.java:435)
                            	at jadx.core.codegen.ClassGen.addField(ClassGen.java:376)
                            	at jadx.core.codegen.ClassGen.addFields(ClassGen.java:346)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:223)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
                            	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:237)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:76)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
                            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
                            
*/
                        });
                    }
                }

                /* access modifiers changed from: private */
                /* renamed from: a */
                public /* synthetic */ void m10218a() {
                    MessageViewHolder.this.m10212b();
                }
            };

            public void onClick(View view) {
                if (new File(MessageViewHolder.this.f9034b.getBridgefyImagePath()).exists()) {
                    m10217a(MessageViewHolder.this.f9034b);
                    return;
                }
                ChatFragment.this.f9085k = new C3667g(ChatFragment.this.f9086l, ChatFragment.this.getView(), Integer.valueOf(14));
                if (C3667g.m10942a(ChatFragment.this.getContext())) {
                    C3540a.m10384a((Activity) ChatFragment.this.f9086l).mo29410a(MessageViewHolder.this.f9034b).mo29411a(MessageViewHolder.this.imgProgressBar).mo29409a((int) R.drawable.icn_error).mo29412a(this.f9100b).mo29413a(MessageViewHolder.this.imageView);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: a */
            public void m10217a(Message message) {
                StringBuilder sb = new StringBuilder();
                sb.append("Opening image with file: ");
                sb.append(message.findFileUri());
                Log.d("ChatFragment", sb.toString());
                File file = new File(message.getBridgefyImagePath());
                ChatFragment.this.startActivity(new Intent("android.intent.action.VIEW").setDataAndType(VERSION.SDK_INT >= 24 ? FileProvider.m3228a(ChatFragment.this.getContext(), "me.bridgefy.main.provider", file) : Uri.fromFile(file), "image/*").addFlags(1));
            }
        };
        @BindView(2131296437)
        protected TextView failView;
        @BindView(2131296474)
        protected BridgefyProgress imgProgressBar;
        @BindView(2131296518)
        protected RelativeLayout messageHolder;
        @BindView(2131296522)
        protected ImageView statusView;

        public MessageViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        /* renamed from: a */
        public void mo29022a(Message message) {
            this.f9034b = message;
            if (!(!message.getSender().equals(ChatFragment.this.f9027f) || this.statusView == null || this.failView == null)) {
                switch (message.getStatus()) {
                    case 0:
                    case 1:
                        this.statusView.setImageDrawable(ChatFragment.this.getActivity().getDrawable(R.drawable.ic_msg_queued));
                        this.failView.setVisibility(8);
                        m10210a();
                        break;
                    case 2:
                        this.statusView.setImageDrawable(ChatFragment.this.getActivity().getDrawable(R.drawable.ic_status_retry));
                        this.failView.setVisibility(0);
                        m10210a();
                        if (this.imgProgressBar != null) {
                            this.imgProgressBar.mo29364b();
                            this.imgProgressBar.setText(ChatFragment.this.getString(R.string.dialog_retry));
                        }
                        this.failView.setOnClickListener(ChatFragment.this.f9092r);
                        if (this.messageHolder != null) {
                            this.messageHolder.setOnClickListener(ChatFragment.this.f9092r);
                        }
                        if (this.dateSentView != null) {
                            this.dateSentView.setVisibility(8);
                        }
                        if (this.imageView != null) {
                            this.imageView.setOnClickListener(ChatFragment.this.f9092r);
                            break;
                        }
                        break;
                    case 3:
                        this.statusView.setImageDrawable(ChatFragment.this.getActivity().getDrawable(R.drawable.ic_status_sent));
                        this.failView.setVisibility(8);
                        m10212b();
                        break;
                    case 4:
                        this.statusView.setImageDrawable(ChatFragment.this.getActivity().getDrawable(R.drawable.ic_status_delivered));
                        this.failView.setVisibility(8);
                        m10212b();
                        break;
                    case 5:
                        this.statusView.setImageDrawable(ChatFragment.this.getActivity().getDrawable(R.drawable.ic_status_read));
                        this.failView.setVisibility(8);
                        m10212b();
                        break;
                }
            }
            if (this.dateSentView != null && (this.failView == null || !(this.failView == null || this.failView.getVisibility() == 0))) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                if (message.getDateSent() != null) {
                    valueOf = message.getServerDate();
                }
                String a = C3659b.m10886a(ChatFragment.this.getResources(), valueOf);
                this.dateSentView.setVisibility(0);
                this.dateSentView.setText(a);
            }
            switch (message.getType()) {
                case 1:
                    if (this.imageView != null) {
                        Uri findThumbnailUri = message.findThumbnailUri();
                        this.imageView.setClickable(true);
                        this.imageView.setOnClickListener(this.f9096a);
                        C3068t.m9058b().mo27532a(findThumbnailUri).mo27572a((int) R.drawable.image_placeholder).mo27575a(this.imageView);
                        return;
                    }
                    try {
                        long parseLong = Long.parseLong(message.getMessageId());
                        if (parseLong > 0) {
                            Log.w("ChatFragment", "No image found. Downloading Thumbnail.");
                            ChatFragment.this.f9085k = new C3667g(ChatFragment.this.f9086l, ChatFragment.this.getView(), null);
                            C3519c.m10293a(parseLong, (C3523c) new C3523c<Message>() {
                                /* renamed from: a */
                                public void onSuccess(Message message) {
                                    if (message != null) {
                                        try {
                                            if (message.getFileContent() != null && message.getFileContent().length > 0) {
                                                C3667g.m10941a(message, "Bridgefy/thumbs");
                                                if (MessageViewHolder.this.imageView != null) {
                                                    MessageViewHolder.this.imageView.setImageURI(message.findFileUri());
                                                }
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                            onError(e);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    } catch (NumberFormatException unused) {
                        Log.w("ChatFragment", "No image found. Message was sent offline.");
                        return;
                    }
                case 2:
                    String text = message.getText();
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://maps.googleapis.com/maps/api/staticmap?center=");
                    sb.append(text);
                    sb.append("&zoom=");
                    sb.append(16);
                    sb.append("&size=300x300&maptype=roadmap&markers=color:red%7C");
                    sb.append(text);
                    C3068t.m9058b().mo27532a(Uri.parse(sb.toString())).mo27572a((int) R.drawable.ic_map_grey).mo27575a(this.imageView);
                    this.imageView.setOnClickListener(this.f9035c);
                    return;
                default:
                    String text2 = message.getText();
                    if (this.messageView != null && text2 != null && !text2.isEmpty()) {
                        this.messageView.setText(text2);
                        return;
                    }
                    return;
            }
        }

        /* renamed from: a */
        private void m10210a() {
            if (this.imgProgressBar != null) {
                this.imgProgressBar.setVisibility(0);
                C3644b a = C3642a.m10779a().mo29735a(this.f9034b.getOfflineId());
                if (a != null) {
                    mo29145a(a.mo29758l());
                    return;
                }
                this.imgProgressBar.setProgress(0);
                this.imgProgressBar.setText("Waiting...");
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m10212b() {
            if (this.imgProgressBar != null && this.imgProgressBar.getVisibility() == 0) {
                this.imgProgressBar.mo29365c();
                this.imgProgressBar.setVisibility(8);
            }
        }

        /* renamed from: a */
        public void mo29145a(int i) {
            int i2 = (i * 360) / 100;
            if (this.imgProgressBar != null) {
                if (this.imgProgressBar.mo29363a()) {
                    this.imgProgressBar.mo29365c();
                }
                this.imgProgressBar.setProgress(i2);
            }
        }
    }

    /* renamed from: me.bridgefy.chat.ChatFragment$MessageViewHolder_ViewBinding */
    public class MessageViewHolder_ViewBinding extends p140me.bridgefy.chat.ChatBaseFragment.MessageViewHolder_ViewBinding {

        /* renamed from: a */
        private MessageViewHolder f9102a;

        public MessageViewHolder_ViewBinding(MessageViewHolder messageViewHolder, View view) {
            super(messageViewHolder, view);
            this.f9102a = messageViewHolder;
            messageViewHolder.imgProgressBar = (BridgefyProgress) Utils.findOptionalViewAsType(view, R.id.imgProgressBar, "field 'imgProgressBar'", BridgefyProgress.class);
            messageViewHolder.messageHolder = (RelativeLayout) Utils.findOptionalViewAsType(view, R.id.messageHolder, "field 'messageHolder'", RelativeLayout.class);
            messageViewHolder.failView = (TextView) Utils.findOptionalViewAsType(view, R.id.failView, "field 'failView'", TextView.class);
            messageViewHolder.statusView = (ImageView) Utils.findOptionalViewAsType(view, R.id.msgStatus, "field 'statusView'", ImageView.class);
        }

        public void unbind() {
            MessageViewHolder messageViewHolder = this.f9102a;
            if (messageViewHolder != null) {
                this.f9102a = null;
                messageViewHolder.imgProgressBar = null;
                messageViewHolder.messageHolder = null;
                messageViewHolder.failView = null;
                messageViewHolder.statusView = null;
                super.unbind();
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: me.bridgefy.chat.ChatFragment$a */
    public static class C3499a extends DialogFragment {

        /* renamed from: a */
        public static String f9103a = "BlockedContactNoticeDialog";

        /* renamed from: b */
        C3500a f9104b;

        /* renamed from: me.bridgefy.chat.ChatFragment$a$a */
        public interface C3500a {
            /* renamed from: a */
            void mo29058a(String str);
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f9104b = (C3500a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return C3659b.m10907d((Context) getActivity()).setMessage((CharSequence) String.format(getString(getArguments().getInt("stringId")), new Object[]{getArguments().getString("otherUserName")})).setPositiveButton((int) R.string.action_contact_unblock, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3499a.this.m10224b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3499a.this.m10223a(dialogInterface, i);
                }
            }).create();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m10224b(DialogInterface dialogInterface, int i) {
            this.f9104b.mo29058a(getArguments().getString("otherUserId"));
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10223a(DialogInterface dialogInterface, int i) {
            dismiss();
        }
    }

    /* renamed from: me.bridgefy.chat.ChatFragment$b */
    public class C3501b extends C3480a {
        public C3501b(List<Message> list) {
            super();
            this.f9045b = list;
        }

        /* renamed from: a */
        public MessageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i != 0) {
                switch (i) {
                    case 10:
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_row_outbound, viewGroup, false);
                        break;
                    case 11:
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_image_row_outbound, viewGroup, false);
                        break;
                    default:
                        switch (i) {
                            case 20:
                                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_row_inbound, viewGroup, false);
                                break;
                            case 21:
                                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_image_row_inbound, viewGroup, false);
                                break;
                            default:
                                view = new View(ChatFragment.this.f9086l);
                                break;
                        }
                }
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_paginator, viewGroup, false);
            }
            return new MessageViewHolder(view);
        }

        /* renamed from: b */
        public void mo29154b(Message message) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateMessageStatus: databaseId: ");
            sb.append(message.getOfflineId());
            sb.append(", status: ");
            sb.append(message.getStatus());
            Log.v("ChatFragment", sb.toString());
            for (int i = 0; i < this.f9045b.size(); i++) {
                Message message2 = (Message) this.f9045b.get(i);
                if (message2 != null && ((message2.getOfflineId() != null && message2.getOfflineId().equals(message.getOfflineId())) || (message2.getDateSent() != null && message2.getDateSent().equalsIgnoreCase(message.getDateSent())))) {
                    try {
                        if (message.getStatus() > message2.getStatus()) {
                            message2.setStatus(message.getStatus());
                            this.f9045b.set(i, message2);
                            notifyItemChanged(i);
                            BridgefyPeer b = C3615a.m10678a().mo29653b(ChatFragment.this.f9030i);
                            if (message.getType() == 1 && message.getStatus() == 2 && b != null) {
                                Toast.makeText(ChatFragment.this.f9086l, R.string.share_image_without_internet, 1).show();
                            }
                        }
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10185a(DialogInterface dialogInterface, int i) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ChatActivity) {
            this.f9086l = (ChatActivity) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            this.f9029h = extras.getString("otherUserName");
            this.f9030i = extras.getString("otherUserId");
        }
        if (this.f9025d.getString("pendingUri", null) != null) {
            this.f9087m = Uri.parse(this.f9025d.getString("pendingUri", null));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        this.f9083a = ButterKnife.bind((Object) this, inflate);
        this.f9023b = new C3501b(new ArrayList());
        this.messagesListView.setAdapter(this.f9023b);
        this.addContactBar.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ChatFragment.this.m10192c(view);
            }
        });
        this.blockedContactBar.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ChatFragment.this.m10190b(view);
            }
        });
        this.f9084j = false;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10192c(View view) {
        this.f9086l.mo29069h();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10190b(View view) {
        this.f9086l.mo29063b((int) R.string.dialog_unblock);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f9086l.mo29059a(this);
        if (!this.f9086l.mo29067f() || this.f9086l.mo29071j() == null) {
            this.addContactBar.setVisibility(8);
        } else {
            this.addContactBar.setText(String.format(getString(R.string.action_contact_add_bar), new Object[]{this.f9029h}));
            this.addContactBar.setVisibility(0);
        }
        if (this.f9086l.mo29068g() && !this.f9086l.mo29070i()) {
            this.unverifiedContactBar.setVisibility(0);
        }
    }

    public void onStart() {
        super.onStart();
        C1049a.m3996a((Context) this.f9086l).mo4059a(this.f9090p, new IntentFilter("messageStatusUpdate"));
    }

    public void onResume() {
        super.onResume();
        if (C3620a.m10705a(this.f9030i)) {
            if (this.f9084j) {
                m10194j();
            }
            this.f9084j = true;
        }
        if (this.f9086l.mo29070i()) {
            this.blockedContactBar.setVisibility(0);
        } else {
            this.blockedContactBar.setVisibility(8);
        }
        this.f9091q.mo29738a(this.f9086l);
        mo29131b();
        this.f9086l.mo29065d();
    }

    public void onPause() {
        this.f9091q.mo29739b(this.f9086l);
        super.onPause();
    }

    public void onStop() {
        C1049a.m3996a((Context) this.f9086l).mo4058a(this.f9089o);
        C1049a.m3996a((Context) this.f9086l).mo4058a(this.f9090p);
        super.onStop();
    }

    public void onDestroy() {
        if (this.f9083a != null) {
            this.f9083a.unbind();
        }
        super.onDestroy();
    }

    /* renamed from: j */
    private void m10194j() {
        ArrayList a = this.f9024c.mo28330a(-1, this.f9030i);
        a.addAll(this.f9024c.mo28330a(-2, this.f9030i));
        Iterator it = a.iterator();
        while (it.hasNext()) {
            mo29129a(new Message((MessageDTO) it.next()));
        }
    }

    /* renamed from: a */
    public void mo29130a(C3667g gVar) {
        File file;
        this.f9085k = gVar;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            try {
                file = gVar.mo29835a();
            } catch (IOException unused) {
                file = null;
            }
            if (file != null) {
                if (VERSION.SDK_INT >= 24) {
                    this.f9087m = FileProvider.m3228a(getContext(), "me.bridgefy.main.provider", file);
                } else {
                    this.f9087m = Uri.fromFile(file);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("CAMERA URI IS ");
                sb.append(this.f9087m.toString());
                Log.i("ChatFragment", sb.toString());
                this.f9025d.edit().putString("pendingUri", this.f9087m.toString());
                intent.addFlags(3);
                intent.putExtra("output", this.f9087m);
                startActivityForResult(intent, 10);
            }
        }
    }

    /* access modifiers changed from: protected */
    @OnClick({2131296433, 2131296431, 2131296432})
    public void sendAttachment(View view) {
        switch (view.getId()) {
            case R.id.fab_action_image /*2131296431*/:
                this.f9085k = new C3667g(this.f9086l, getView(), Integer.valueOf(12));
                if (C3667g.m10942a((Context) this.f9086l)) {
                    startActivityForResult(new Intent("android.intent.action.GET_CONTENT").setType("image/*"), 20);
                    break;
                }
                break;
            case R.id.fab_action_location /*2131296432*/:
                startActivityForResult(new Intent(getActivity(), LocationActivity.class).putExtra("otherUserId", this.f9030i), 30);
                break;
            case R.id.fab_action_photo /*2131296433*/:
                mo29130a(new C3667g(this.f9086l, getView(), Integer.valueOf(11)));
                break;
        }
        this.fabAttachments.mo12066c(true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 10) {
            if (this.f9087m == null && this.f9025d.getString("pendingUri", null) != null) {
                this.f9087m = Uri.parse(this.f9025d.getString("pendingUri", null));
            }
            if (this.f9087m != null) {
                m10187a(this.f9085k.mo29836a((Context) this.f9086l, this.f9087m));
                StringBuilder sb = new StringBuilder();
                sb.append("temporary file was deleted: ");
                sb.append(new File(this.f9087m.getPath()).delete());
                Log.d("ChatFragment", sb.toString());
                Log.d("ChatFragment", this.f9087m.toString());
                BridgefyApp.m10557c().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", this.f9087m));
                this.f9087m = null;
            }
            this.f9025d.edit().remove("pendingUri").apply();
        } else if (i == 20) {
            this.f9085k = new C3667g(this.f9086l, getView(), Integer.valueOf(12));
            m10187a(this.f9085k.mo29836a((Context) this.f9086l, intent.getData()));
        } else if (i == 30) {
            Location location = (Location) intent.getParcelableExtra("coordinates");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(location.getLatitude());
            sb2.append(",");
            sb2.append(location.getLongitude());
            mo29019a(sb2.toString(), 2);
        }
    }

    /* renamed from: a */
    public boolean mo29019a(String str, int i) {
        if (this.f9086l.mo29070i()) {
            this.f9086l.mo29063b((int) R.string.dialog_blocked);
        } else if (!str.isEmpty() && str.trim().length() != 0) {
            Message message = new Message(this.f9030i, this.f9027f, str, this.f9029h, i);
            mo29129a(message);
            toggleEmojiconFragmentIfVisible();
            this.chatLine.setText("");
            this.chatLine.requestFocus();
            Editor editor = this.f9026e;
            StringBuilder sb = new StringBuilder();
            sb.append("chatLine-");
            sb.append(this.f9030i);
            editor.remove(sb.toString()).apply();
            this.f9086l.mo29060a(message);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m10187a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("sendImage() from uri: ");
        sb.append(str);
        Log.d("ChatFragment", sb.toString());
        if (str != null) {
            if (this.f9086l.mo29070i()) {
                this.f9086l.mo29063b((int) R.string.dialog_blocked);
            } else {
                m10191b(new Message(str, this.f9030i, this.f9027f));
            }
        }
    }

    /* renamed from: b */
    private void m10191b(Message message) {
        int i = 0;
        try {
            i = C3667g.m10943a(message, false, getContext()).length;
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("image size error: ");
            sb.append(e.getMessage());
            Log.v("ChatFragment", sb.toString());
        }
        if ((!C3622b.m10715a(getContext(), (DatabaseHelper) ((BridgefyOrmLiteBaseActivity) getActivity()).getHelper()).mo29663b() || DeviceManager.getDeviceByUserId(this.f9030i) != null) && i > 0 && i > 143360) {
            C3659b.m10907d((Context) getActivity()).setMessage((int) R.string.confirm_sen_data).setPositiveButton((int) R.string.btn_send, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(message) {
                private final /* synthetic */ Message f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ChatFragment.this.m10188a(this.f$1, dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) $$Lambda$ChatFragment$KgvNhk5LA25uopxPJomPUl3DRbM.INSTANCE).create().show();
        } else {
            m10193c(message);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10188a(Message message, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        m10193c(message);
    }

    /* renamed from: c */
    private void m10193c(Message message) {
        mo29129a(message);
        this.chatLine.requestFocus();
        this.f9086l.mo29060a(message);
    }

    /* renamed from: a */
    public void mo29129a(Message message) {
        this.f9023b.mo29095a(message);
    }

    /* renamed from: b */
    public void mo29131b() {
        if (this.f9088n == null) {
            this.f9088n = this.f9086l.getIntent();
        }
        if (this.f9088n.getStringExtra("share_content") != null) {
            String trim = this.f9088n.getStringExtra("share_content").trim();
            if (this.f9088n.getStringExtra("share_type").equals("text/plain")) {
                StringBuilder sb = new StringBuilder();
                sb.append(".{1,");
                sb.append(getResources().getInteger(R.integer.max_text_input));
                sb.append("}");
                Matcher matcher = Pattern.compile(sb.toString()).matcher(trim);
                while (matcher.find()) {
                    if (!mo29019a(trim.substring(matcher.start(), matcher.end()), 0)) {
                        break;
                    }
                }
                this.f9088n = null;
                this.f9086l.getIntent().removeExtra("share_type");
                this.f9086l.getIntent().removeExtra("share_content");
            } else if (this.f9088n.getStringExtra("share_type").startsWith("image/")) {
                try {
                    C1049a.m3996a((Context) this.f9086l).mo4059a(this.f9089o, new IntentFilter("permissionsDenied"));
                    m10187a(new C3667g(this.f9086l, getView(), Integer.valueOf(13)).mo29836a(getContext(), Uri.parse(trim)));
                    this.f9088n = null;
                    this.f9086l.getIntent().removeExtra("share_type");
                    this.f9086l.getIntent().removeExtra("share_content");
                } catch (SecurityException e) {
                    Toast.makeText(getContext(), getString(R.string.error_try_again), 1).show();
                    this.f9086l.finish();
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10186a(View view) {
        new C3512b().show(getFragmentManager(), "MessageRetryFragment");
    }

    /* renamed from: c */
    public void mo29132c() {
        Log.w("ChatFragment", "retryMessages()");
        this.f9024c.mo28348e(this.f9030i);
        this.f9023b.notifyDataSetChanged();
        this.f9086l.mo29060a((Message) null);
    }

    /* renamed from: d */
    public TextView mo29133d() {
        return this.blockedContactBar;
    }

    /* renamed from: e */
    public TextView mo29134e() {
        return this.addContactBar;
    }

    /* renamed from: f */
    public View mo29135f() {
        return this.unverifiedContactBar;
    }

    /* renamed from: g */
    public FrameLayout mo29136g() {
        return this.emojiLayout;
    }

    /* renamed from: h */
    public CheckBox mo29137h() {
        return this.emoticonCheckbox;
    }

    /* renamed from: i */
    public FloatingActionMenu mo29138i() {
        return this.fabAttachments;
    }
}
