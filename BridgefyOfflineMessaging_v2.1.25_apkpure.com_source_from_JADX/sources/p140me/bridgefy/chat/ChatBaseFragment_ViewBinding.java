package p140me.bridgefy.chat;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.chat.ChatBaseFragment_ViewBinding */
public class ChatBaseFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ChatBaseFragment f9048a;

    /* renamed from: b */
    private View f9049b;

    /* renamed from: c */
    private TextWatcher f9050c;

    /* renamed from: d */
    private View f9051d;

    /* renamed from: e */
    private View f9052e;

    @SuppressLint({"ClickableViewAccessibility"})
    public ChatBaseFragment_ViewBinding(final ChatBaseFragment chatBaseFragment, View view) {
        this.f9048a = chatBaseFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.txtChatLine, "field 'chatLine', method 'onEditorAction', method 'onChatLineLongClick', method 'onTextChanged', and method 'toggleEmojiconFragmentIfVisible'");
        chatBaseFragment.chatLine = (EditText) Utils.castView(findRequiredView, R.id.txtChatLine, "field 'chatLine'", EditText.class);
        this.f9049b = findRequiredView;
        TextView textView = (TextView) findRequiredView;
        textView.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return chatBaseFragment.onEditorAction(textView, i, keyEvent);
            }
        });
        findRequiredView.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                return chatBaseFragment.onChatLineLongClick();
            }
        });
        this.f9050c = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                chatBaseFragment.onTextChanged(charSequence, i, i2, i3);
            }
        };
        textView.addTextChangedListener(this.f9050c);
        findRequiredView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return chatBaseFragment.toggleEmojiconFragmentIfVisible();
            }
        });
        chatBaseFragment.chatLineHolder = Utils.findRequiredView(view, R.id.chatLineHolder, "field 'chatLineHolder'");
        View findRequiredView2 = Utils.findRequiredView(view, R.id.fabText, "field 'fabText' and method 'sendMessage'");
        chatBaseFragment.fabText = (FloatingActionButton) Utils.castView(findRequiredView2, R.id.fabText, "field 'fabText'", FloatingActionButton.class);
        this.f9051d = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                chatBaseFragment.sendMessage(view);
            }
        });
        chatBaseFragment.fabAttachments = (FloatingActionMenu) Utils.findRequiredViewAsType(view, R.id.fabAttachments, "field 'fabAttachments'", FloatingActionMenu.class);
        chatBaseFragment.messagesListView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.chat_fragment_recycler_view, "field 'messagesListView'", RecyclerView.class);
        chatBaseFragment.emojiLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.emojicons, "field 'emojiLayout'", FrameLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btnEmojicon, "field 'emoticonCheckbox' and method 'toggleEmojiconFragment'");
        chatBaseFragment.emoticonCheckbox = (CheckBox) Utils.castView(findRequiredView3, R.id.btnEmojicon, "field 'emoticonCheckbox'", CheckBox.class);
        this.f9052e = findRequiredView3;
        ((CompoundButton) findRequiredView3).setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chatBaseFragment.toggleEmojiconFragment();
            }
        });
    }

    public void unbind() {
        ChatBaseFragment chatBaseFragment = this.f9048a;
        if (chatBaseFragment != null) {
            this.f9048a = null;
            chatBaseFragment.chatLine = null;
            chatBaseFragment.chatLineHolder = null;
            chatBaseFragment.fabText = null;
            chatBaseFragment.fabAttachments = null;
            chatBaseFragment.messagesListView = null;
            chatBaseFragment.emojiLayout = null;
            chatBaseFragment.emoticonCheckbox = null;
            ((TextView) this.f9049b).setOnEditorActionListener(null);
            this.f9049b.setOnLongClickListener(null);
            ((TextView) this.f9049b).removeTextChangedListener(this.f9050c);
            this.f9050c = null;
            this.f9049b.setOnTouchListener(null);
            this.f9049b = null;
            this.f9051d.setOnClickListener(null);
            this.f9051d = null;
            ((CompoundButton) this.f9052e).setOnCheckedChangeListener(null);
            this.f9052e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
