package p140me.bridgefy.intro.verification;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.widget.C0686l;
import java.util.List;
import java.util.Locale;
import me.bridgefy.main.R;
import p140me.bridgefy.intro.verification.C3577d.C3578a;
import p140me.bridgefy.main.BridgefyApp;

/* renamed from: me.bridgefy.intro.verification.CountryListSpinner */
public final class CountryListSpinner extends C0686l implements OnClickListener, C3578a {

    /* renamed from: a */
    private String f9369a;

    /* renamed from: b */
    private C3570a f9370b;

    /* renamed from: c */
    private C3576c f9371c;

    /* renamed from: d */
    private OnClickListener f9372d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f9373e;

    /* renamed from: me.bridgefy.intro.verification.CountryListSpinner$a */
    public class C3570a implements DialogInterface.OnClickListener {

        /* renamed from: b */
        private final C3576c f9375b;

        /* renamed from: c */
        private AlertDialog f9376c;

        C3570a(C3576c cVar) {
            this.f9375b = cVar;
        }

        /* renamed from: a */
        public void mo29472a() {
            if (this.f9376c != null) {
                this.f9376c.dismiss();
                this.f9376c = null;
            }
        }

        /* renamed from: b */
        public boolean mo29474b() {
            return this.f9376c != null && this.f9376c.isShowing();
        }

        /* renamed from: a */
        public void mo29473a(final int i) {
            if (this.f9375b != null) {
                this.f9376c = new Builder(CountryListSpinner.this.getContext()).setSingleChoiceItems(this.f9375b, 0, this).create();
                this.f9376c.setCanceledOnTouchOutside(true);
                final ListView listView = this.f9376c.getListView();
                listView.setFastScrollEnabled(true);
                listView.setScrollbarFadingEnabled(false);
                listView.postDelayed(new Runnable() {
                    public void run() {
                        listView.setSelection(i);
                    }
                }, 10);
                this.f9376c.show();
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C3574b bVar = (C3574b) this.f9375b.getItem(i);
            CountryListSpinner.this.f9373e = bVar.f9391b.getDisplayCountry();
            CountryListSpinner.this.m10491a(bVar.f9392c, bVar.f9391b);
            mo29472a();
            if (C3574b.f9385a.contains(Integer.valueOf(bVar.f9392c))) {
                Context applicationContext = BridgefyApp.m10557c().getApplicationContext();
                Toast.makeText(applicationContext, applicationContext.getString(R.string.verify_unsupported_country), 0).show();
            }
        }
    }

    public CountryListSpinner(Context context) {
        this(context, null, 16842881);
    }

    public CountryListSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842881);
    }

    public CountryListSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10490a();
    }

    /* renamed from: a */
    private static void m10492a(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: a */
    private void m10490a() {
        super.setOnClickListener(this);
        this.f9371c = new C3576c(getContext());
        this.f9370b = new C3570a(this.f9371c);
        this.f9369a = "%1$s  +%2$d";
        this.f9373e = "";
        C3574b a = C3583h.m10534a(getContext());
        m10491a(a.f9392c, a.f9391b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10491a(int i, Locale locale) {
        setText(String.format(this.f9369a, new Object[]{C3574b.m10504a(locale), Integer.valueOf(i)}));
        setTag(new C3574b(locale, i));
    }

    /* renamed from: a */
    public void mo29468a(Locale locale, String str) {
        String displayName = locale.getDisplayName();
        if (!TextUtils.isEmpty(displayName) && !TextUtils.isEmpty(str)) {
            this.f9373e = displayName;
            m10491a(Integer.parseInt(str), locale);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f9370b.mo29474b()) {
            this.f9370b.mo29472a();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f9372d = onClickListener;
    }

    public void onClick(View view) {
        if (this.f9371c.getCount() == 0) {
            m10495b();
        } else {
            this.f9370b.mo29473a(this.f9371c.mo29486a(this.f9373e));
        }
        m10492a(getContext(), (View) this);
        m10493a(view);
    }

    /* renamed from: b */
    private void m10495b() {
        new C3577d(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* renamed from: a */
    private void m10493a(View view) {
        if (this.f9372d != null) {
            this.f9372d.onClick(view);
        }
    }

    /* renamed from: a */
    public void mo29467a(List<C3574b> list) {
        this.f9371c.mo29487a(list);
        this.f9370b.mo29473a(this.f9371c.mo29486a(this.f9373e));
    }
}
