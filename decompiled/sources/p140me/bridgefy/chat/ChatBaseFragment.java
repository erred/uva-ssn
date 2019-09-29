package p140me.bridgefy.chat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.p081a.C1062d;
import androidx.recyclerview.widget.C1323l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C1243a;
import androidx.recyclerview.widget.RecyclerView.C1248f;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;
import butterknife.OnTouch;
import butterknife.Optional;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import me.bridgefy.main.R;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3460d;

/* renamed from: me.bridgefy.chat.ChatBaseFragment */
public abstract class ChatBaseFragment extends C1062d {

    /* renamed from: a */
    private static String f9022a = "ChatBaseFragment";

    /* renamed from: b */
    protected C3480a f9023b = null;

    /* renamed from: c */
    protected C3460d f9024c;
    @BindView(2131296721)
    protected EditText chatLine;
    @BindView(2131296360)
    protected View chatLineHolder;

    /* renamed from: d */
    SharedPreferences f9025d;

    /* renamed from: e */
    protected Editor f9026e;
    @BindView(2131296417)
    protected FrameLayout emojiLayout;
    @BindView(2131296335)
    protected CheckBox emoticonCheckbox;
    /* access modifiers changed from: protected */

    /* renamed from: f */
    public String f9027f;
    @BindView(2131296428)
    protected FloatingActionMenu fabAttachments;
    @BindView(2131296430)
    protected FloatingActionButton fabText;

    /* renamed from: g */
    protected String f9028g;

    /* renamed from: h */
    String f9029h;

    /* renamed from: i */
    protected String f9030i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C3481b f9031j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f9032k;
    @BindView(2131296363)
    protected RecyclerView messagesListView;

    /* renamed from: me.bridgefy.chat.ChatBaseFragment$MessageViewHolder */
    public abstract class MessageViewHolder extends C1277x {

        /* renamed from: b */
        protected Message f9034b;

        /* renamed from: c */
        protected OnClickListener f9035c = new OnClickListener() {
            public void onClick(View view) {
                try {
                    String[] split = MessageViewHolder.this.f9034b.getText().split(",");
                    LatLng latLng = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                    Intent intent = new Intent(ChatBaseFragment.this.getActivity(), LocationActivity.class);
                    intent.putExtra("coordinates", latLng);
                    ChatBaseFragment.this.startActivity(intent);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(ChatBaseFragment.this.getContext(), ChatBaseFragment.this.getString(R.string.location_error), 0).show();
                }
            }
        };
        @BindView(2131296521)
        protected TextView dateSentView;
        @BindView(2131296472)
        protected ImageView imageView;
        @BindView(2131296725)
        protected TextView messageView;

        /* renamed from: a */
        public abstract void mo29022a(Message message);

        public MessageViewHolder(View view) {
            super(view);
        }

        @OnLongClick({2131296725})
        @Optional
        public boolean onMessageLongClick(View view) {
            if (!(this.messageView == null || this.messageView.getText() == null)) {
                ((ClipboardManager) ChatBaseFragment.this.getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.messageView.getText(), this.messageView.getText()));
                Toast.makeText(ChatBaseFragment.this.getActivity(), R.string.android_text_copy, 0).show();
            }
            return true;
        }

        @OnClick({2131296540})
        @Optional
        public void loadMoreMessages(View view) {
            ChatBaseFragment.this.f9031j = new C3481b();
            ChatBaseFragment.this.f9031j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    /* renamed from: me.bridgefy.chat.ChatBaseFragment$MessageViewHolder_ViewBinding */
    public class MessageViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a */
        private MessageViewHolder f9038a;

        /* renamed from: b */
        private View f9039b;

        /* renamed from: c */
        private View f9040c;

        public MessageViewHolder_ViewBinding(final MessageViewHolder messageViewHolder, View view) {
            this.f9038a = messageViewHolder;
            View findViewById = view.findViewById(R.id.txtMessage);
            messageViewHolder.messageView = (TextView) Utils.castView(findViewById, R.id.txtMessage, "field 'messageView'", TextView.class);
            if (findViewById != null) {
                this.f9039b = findViewById;
                findViewById.setOnLongClickListener(new OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        return messageViewHolder.onMessageLongClick(view);
                    }
                });
            }
            messageViewHolder.imageView = (ImageView) Utils.findOptionalViewAsType(view, R.id.imageView, "field 'imageView'", ImageView.class);
            messageViewHolder.dateSentView = (TextView) Utils.findOptionalViewAsType(view, R.id.msgDate, "field 'dateSentView'", TextView.class);
            View findViewById2 = view.findViewById(R.id.paginator);
            if (findViewById2 != null) {
                this.f9040c = findViewById2;
                findViewById2.setOnClickListener(new DebouncingOnClickListener() {
                    public void doClick(View view) {
                        messageViewHolder.loadMoreMessages(view);
                    }
                });
            }
        }

        public void unbind() {
            MessageViewHolder messageViewHolder = this.f9038a;
            if (messageViewHolder != null) {
                this.f9038a = null;
                messageViewHolder.messageView = null;
                messageViewHolder.imageView = null;
                messageViewHolder.dateSentView = null;
                if (this.f9039b != null) {
                    this.f9039b.setOnLongClickListener(null);
                    this.f9039b = null;
                }
                if (this.f9040c != null) {
                    this.f9040c.setOnClickListener(null);
                    this.f9040c = null;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* renamed from: me.bridgefy.chat.ChatBaseFragment$a */
    public abstract class C3480a extends C1243a<MessageViewHolder> {

        /* renamed from: b */
        protected List<Message> f9045b;

        public C3480a() {
        }

        /* renamed from: a */
        public Message mo29091a(int i) {
            return (Message) this.f9045b.get(i);
        }

        public int getItemCount() {
            return this.f9045b.size();
        }

        /* renamed from: a */
        public void mo29095a(Message message) {
            this.f9045b.add(0, message);
            notifyItemInserted(0);
            ChatBaseFragment.this.messagesListView.scrollToPosition(0);
        }

        /* renamed from: a */
        public void mo29093a(List<Message> list) {
            if (((long) this.f9045b.size()) > 20) {
                this.f9045b.remove(this.f9045b.size() - 1);
            }
            this.f9045b.addAll(list);
            if (((long) list.size()) >= 20) {
                this.f9045b.add(new Message());
            }
            notifyDataSetChanged();
            if (ChatBaseFragment.this.f9032k == 0) {
                ChatBaseFragment.this.messagesListView.scrollToPosition(0);
            }
        }

        /* renamed from: a */
        public void mo29092a() {
            this.f9045b.clear();
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public void onBindViewHolder(MessageViewHolder messageViewHolder, int i) {
            Message message = (Message) this.f9045b.get(i);
            if (message != null) {
                Message a = ChatBaseFragment.this.f9024c.mo28334a(message.getDateSent(), ChatBaseFragment.this.f9030i);
                if (a != null) {
                    message.setMessageId(a.getMessageId());
                    message.setOfflineId(a.getOfflineId());
                }
                messageViewHolder.mo29022a(message);
            }
        }

        public int getItemViewType(int i) {
            Message a = ChatBaseFragment.this.f9023b.mo29091a(i);
            if (a != null) {
                if (String.valueOf(0).equals(a.getMessageId()) || (a.getReceiver().equals("") && a.getSender().equals(""))) {
                    return 0;
                }
                if (a.getSender().equals(ChatBaseFragment.this.f9027f)) {
                    switch (a.getType()) {
                        case 0:
                            return 10;
                        case 1:
                            return 11;
                        case 2:
                            return 11;
                    }
                } else if (!a.getSender().equals(ChatBaseFragment.this.f9027f)) {
                    switch (a.getType()) {
                        case 0:
                            return 20;
                        case 1:
                            return 21;
                        case 2:
                            return 21;
                    }
                }
            }
            return -1;
        }
    }

    /* renamed from: me.bridgefy.chat.ChatBaseFragment$b */
    protected class C3481b extends AsyncTask<String, Void, List<Message>> {
        protected C3481b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public List<Message> doInBackground(String... strArr) {
            return ChatBaseFragment.this.f9024c.mo28331a(ChatBaseFragment.this.f9030i, ((long) ChatBaseFragment.this.f9032k) * 20);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<Message> list) {
            if (!isCancelled()) {
                ChatBaseFragment.this.f9023b.mo29093a(list);
                ChatBaseFragment.this.f9032k = ChatBaseFragment.this.f9032k + 1;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m10140b(boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo29019a(String str, int i);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f9024c = new C3460d((DatabaseHelper) ((BridgefyOrmLiteBaseActivity) getActivity()).getHelper());
        this.f9025d = getActivity().getSharedPreferences("BgfyPrefs", 0);
        this.f9026e = this.f9025d.edit();
        this.f9027f = this.f9025d.getString("user_uuid", "");
        this.f9028g = this.f9025d.getString(FriendDTO.USER_NAME, "");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fabAttachments.getMenuIconView().setImageResource(R.drawable.ic_attachment_white);
        this.fabAttachments.setClosedOnTouchOutside(true);
        mo29131b();
        this.fabAttachments.setOnMenuToggleListener($$Lambda$ChatBaseFragment$KAgXTkrA6t4H3XUyJsnYhKZsdAg.INSTANCE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.mo4771b(true);
        this.messagesListView.setLayoutManager(linearLayoutManager);
        C1248f itemAnimator = this.messagesListView.getItemAnimator();
        if (itemAnimator instanceof C1323l) {
            ((C1323l) itemAnimator).mo5549a(false);
        }
        SharedPreferences sharedPreferences = this.f9025d;
        StringBuilder sb = new StringBuilder();
        sb.append("chatLine-");
        sb.append(this.f9030i);
        String string = sharedPreferences.getString(sb.toString(), "");
        if (!string.equals("")) {
            this.chatLine.append(string);
            this.fabAttachments.setVisibility(8);
            this.fabAttachments.setBackgroundColor(0);
            this.fabText.setVisibility(0);
        }
        toggleEmojiconFragmentIfVisible();
        this.f9032k = 0;
        this.f9023b.mo29092a();
        this.f9031j = new C3481b();
        this.f9031j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        Editor editor = this.f9026e;
        StringBuilder sb = new StringBuilder();
        sb.append("chatLine-");
        sb.append(this.f9030i);
        editor.putString(sb.toString(), this.chatLine.getText().toString()).apply();
        toggleEmojiconFragmentIfVisible();
        this.f9031j.cancel(true);
        super.onPause();
    }

    @OnClick({2131296430})
    public void sendMessage(View view) {
        mo29019a(this.chatLine.getText().toString(), 0);
    }

    @OnEditorAction({2131296721})
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.chatLine.getWindowToken(), 0);
        mo29019a(this.chatLine.getText().toString(), 0);
        return true;
    }

    @OnLongClick({2131296721})
    public boolean onChatLineLongClick() {
        ClipboardManager clipboardManager = (ClipboardManager) getActivity().getSystemService("clipboard");
        if (!(clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemAt(0) == null)) {
            Item itemAt = clipboardManager.getPrimaryClip().getItemAt(0);
            String str = "";
            if (itemAt.getText() != null) {
                str = itemAt.getText().toString();
            }
            this.chatLine.append(str);
        }
        return true;
    }

    @OnTextChanged({2131296721})
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 0) {
            this.fabAttachments.setVisibility(0);
            this.fabAttachments.mo12066c(false);
            this.fabText.setVisibility(8);
            m10137a(!this.fabAttachments.mo12065b());
            return;
        }
        this.fabAttachments.setVisibility(8);
        this.fabAttachments.mo12066c(false);
        this.fabText.setVisibility(0);
    }

    @OnTouch({2131296721})
    public boolean toggleEmojiconFragmentIfVisible() {
        if (this.emojiLayout.getVisibility() != 0) {
            return false;
        }
        toggleEmojiconFragment();
        return true;
    }

    @OnCheckedChanged({2131296335})
    public void toggleEmojiconFragment() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        getActivity().getWindow().setSoftInputMode(48);
        if (this.emojiLayout.getVisibility() == 0) {
            this.emoticonCheckbox.setBackground(getActivity().getDrawable(R.drawable.ic_insert_emoticon_grey600_24dp));
            this.emojiLayout.setVisibility(8);
            inputMethodManager.hideSoftInputFromWindow(this.chatLine.getWindowToken(), 0);
            inputMethodManager.toggleSoftInputFromWindow(this.chatLine.getWindowToken(), 0, 0);
            LayoutParams layoutParams = (LayoutParams) this.chatLineHolder.getLayoutParams();
            layoutParams.addRule(12);
            this.chatLineHolder.setLayoutParams(layoutParams);
        } else {
            this.emoticonCheckbox.setBackground(getActivity().getDrawable(R.drawable.ic_keyboard_grey));
            inputMethodManager.hideSoftInputFromWindow(this.chatLine.getWindowToken(), 0);
            this.emojiLayout.setVisibility(0);
            LayoutParams layoutParams2 = (LayoutParams) this.chatLineHolder.getLayoutParams();
            layoutParams2.addRule(12, 0);
            layoutParams2.addRule(2, R.id.emojicons);
            this.chatLineHolder.setLayoutParams(layoutParams2);
        }
        getActivity().getWindow().setSoftInputMode(16);
    }

    /* renamed from: a */
    public C3480a mo29079a() {
        return this.f9023b;
    }

    /* renamed from: b */
    private void mo29131b() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fabAttachments.getMenuIconView(), "scaleX", new float[]{1.0f, 0.2f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fabAttachments.getMenuIconView(), "scaleY", new float[]{1.0f, 0.2f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fabAttachments.getMenuIconView(), "scaleX", new float[]{0.2f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fabAttachments.getMenuIconView(), "scaleY", new float[]{0.2f, 1.0f});
        ofFloat.setDuration(50);
        ofFloat2.setDuration(50);
        ofFloat3.setDuration(150);
        ofFloat4.setDuration(150);
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                ChatBaseFragment.this.m10137a(ChatBaseFragment.this.fabAttachments.mo12065b());
            }
        });
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat);
        animatorSet.setInterpolator(new OvershootInterpolator(2.0f));
        this.fabAttachments.setIconToggleAnimatorSet(animatorSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10137a(boolean z) {
        if (z) {
            this.fabAttachments.setMenuButtonColorNormal(-2473162);
            this.fabAttachments.setBackgroundColor(0);
            this.fabAttachments.getMenuIconView().setImageResource(R.drawable.ic_attachment_white);
            return;
        }
        this.fabAttachments.setMenuButtonColorNormal(-12105913);
        this.fabAttachments.setBackgroundColor(getResources().getColor(R.color.white_transparent));
        this.fabAttachments.getMenuIconView().setImageResource(R.drawable.ic_close_white);
    }
}
