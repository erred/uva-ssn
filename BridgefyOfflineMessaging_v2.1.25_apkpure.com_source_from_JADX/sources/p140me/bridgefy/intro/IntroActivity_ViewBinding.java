package p140me.bridgefy.intro;

import android.view.View;
import android.widget.Button;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.viewpagerindicator.CirclePageIndicator;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.intro.IntroActivity_ViewBinding */
public class IntroActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private IntroActivity f9306a;

    /* renamed from: b */
    private View f9307b;

    /* renamed from: c */
    private View f9308c;

    public IntroActivity_ViewBinding(final IntroActivity introActivity, View view) {
        this.f9306a = introActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_get_started, "field 'btnGetStarted' and method 'startLoginWorkflow'");
        introActivity.btnGetStarted = (Button) Utils.castView(findRequiredView, R.id.btn_get_started, "field 'btnGetStarted'", Button.class);
        this.f9307b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                introActivity.startLoginWorkflow();
            }
        });
        introActivity.mViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'mViewPager'", ViewPager.class);
        introActivity.titleIndicator = (CirclePageIndicator) Utils.findRequiredViewAsType(view, R.id.view_pager_indicator, "field 'titleIndicator'", CirclePageIndicator.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.termsLink, "method 'onClick'");
        this.f9308c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                introActivity.onClick();
            }
        });
    }

    public void unbind() {
        IntroActivity introActivity = this.f9306a;
        if (introActivity != null) {
            this.f9306a = null;
            introActivity.btnGetStarted = null;
            introActivity.mViewPager = null;
            introActivity.titleIndicator = null;
            this.f9307b.setOnClickListener(null);
            this.f9307b = null;
            this.f9308c.setOnClickListener(null);
            this.f9308c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
