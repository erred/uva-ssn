package p140me.bridgefy.integration;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.integration.LogTestsActivity_ViewBinding */
public class LogTestsActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private LogTestsActivity f9277a;

    /* renamed from: b */
    private View f9278b;

    /* renamed from: c */
    private View f9279c;

    /* renamed from: d */
    private View f9280d;

    public LogTestsActivity_ViewBinding(final LogTestsActivity logTestsActivity, View view) {
        this.f9277a = logTestsActivity;
        logTestsActivity.logView = (TextView) Utils.findRequiredViewAsType(view, R.id.logView, "field 'logView'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.btnStartTests, "field 'btnStartTests' and method 'newTest'");
        logTestsActivity.btnStartTests = (Button) Utils.castView(findRequiredView, R.id.btnStartTests, "field 'btnStartTests'", Button.class);
        this.f9278b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                logTestsActivity.newTest();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.btnFinishTests, "field 'btnFinishTests' and method 'finishTests'");
        logTestsActivity.btnFinishTests = (Button) Utils.castView(findRequiredView2, R.id.btnFinishTests, "field 'btnFinishTests'", Button.class);
        this.f9279c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                logTestsActivity.finishTests();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btnUploadTests, "field 'btnUploadTests' and method 'uploadTests'");
        logTestsActivity.btnUploadTests = (Button) Utils.castView(findRequiredView3, R.id.btnUploadTests, "field 'btnUploadTests'", Button.class);
        this.f9280d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                logTestsActivity.uploadTests();
            }
        });
    }

    public void unbind() {
        LogTestsActivity logTestsActivity = this.f9277a;
        if (logTestsActivity != null) {
            this.f9277a = null;
            logTestsActivity.logView = null;
            logTestsActivity.btnStartTests = null;
            logTestsActivity.btnFinishTests = null;
            logTestsActivity.btnUploadTests = null;
            this.f9278b.setOnClickListener(null);
            this.f9278b = null;
            this.f9279c.setOnClickListener(null);
            this.f9279c = null;
            this.f9280d.setOnClickListener(null);
            this.f9280d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
