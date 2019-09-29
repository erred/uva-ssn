package p140me.bridgefy.main;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

/* renamed from: me.bridgefy.main.TabbedMainActivity_ViewBinding */
public class TabbedMainActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private TabbedMainActivity f9483a;

    public TabbedMainActivity_ViewBinding(TabbedMainActivity tabbedMainActivity, View view) {
        this.f9483a = tabbedMainActivity;
        tabbedMainActivity.toolbar = (Toolbar) Utils.findOptionalViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        tabbedMainActivity.viewPager = (ViewPager) Utils.findOptionalViewAsType(view, R.id.viewPager, "field 'viewPager'", ViewPager.class);
        tabbedMainActivity.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tabLayout, "field 'tabLayout'", TabLayout.class);
        tabbedMainActivity.tooltipNewFriend = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tooltip_newfriend, "field 'tooltipNewFriend'", RelativeLayout.class);
        tabbedMainActivity.tooltipSdk = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tooltip_sdk, "field 'tooltipSdk'", RelativeLayout.class);
        tabbedMainActivity.tooltipNewConversation = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.tooltip_new_conversation, "field 'tooltipNewConversation'", RelativeLayout.class);
        tabbedMainActivity.fabNewConversation = (FloatingActionButton) Utils.findRequiredViewAsType(view, R.id.fabNewConversation, "field 'fabNewConversation'", FloatingActionButton.class);
        tabbedMainActivity.coordinatorLayout = (CoordinatorLayout) Utils.findRequiredViewAsType(view, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    }

    public void unbind() {
        TabbedMainActivity tabbedMainActivity = this.f9483a;
        if (tabbedMainActivity != null) {
            this.f9483a = null;
            tabbedMainActivity.toolbar = null;
            tabbedMainActivity.viewPager = null;
            tabbedMainActivity.tabLayout = null;
            tabbedMainActivity.tooltipNewFriend = null;
            tabbedMainActivity.tooltipSdk = null;
            tabbedMainActivity.tooltipNewConversation = null;
            tabbedMainActivity.fabNewConversation = null;
            tabbedMainActivity.coordinatorLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
