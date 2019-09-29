package p140me.bridgefy.broadcast;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.broadcast.BroadcastLoaderFragment_ViewBinding */
public class BroadcastLoaderFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BroadcastLoaderFragment f8993a;

    /* renamed from: b */
    private View f8994b;

    /* renamed from: c */
    private View f8995c;

    public BroadcastLoaderFragment_ViewBinding(final BroadcastLoaderFragment broadcastLoaderFragment, View view) {
        this.f8993a = broadcastLoaderFragment;
        broadcastLoaderFragment.broadcastLoaderAnimation = (ImageView) Utils.findRequiredViewAsType(view, R.id.broadcastLoaderAnimation, "field 'broadcastLoaderAnimation'", ImageView.class);
        broadcastLoaderFragment.broadcastLoaderTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.broadcastLoaderTextView, "field 'broadcastLoaderTextView'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.broadcastLoaderTextViewRetry, "field 'broadcastLoaderTextViewRetry' and method 'loadBroadcastFragment'");
        broadcastLoaderFragment.broadcastLoaderTextViewRetry = (Button) Utils.castView(findRequiredView, R.id.broadcastLoaderTextViewRetry, "field 'broadcastLoaderTextViewRetry'", Button.class);
        this.f8994b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                broadcastLoaderFragment.loadBroadcastFragment();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.broadcastLoaderWrapper, "method 'loadBroadcastFragment'");
        this.f8995c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                broadcastLoaderFragment.loadBroadcastFragment();
            }
        });
    }

    public void unbind() {
        BroadcastLoaderFragment broadcastLoaderFragment = this.f8993a;
        if (broadcastLoaderFragment != null) {
            this.f8993a = null;
            broadcastLoaderFragment.broadcastLoaderAnimation = null;
            broadcastLoaderFragment.broadcastLoaderTextView = null;
            broadcastLoaderFragment.broadcastLoaderTextViewRetry = null;
            this.f8994b.setOnClickListener(null);
            this.f8994b = null;
            this.f8995c.setOnClickListener(null);
            this.f8995c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
