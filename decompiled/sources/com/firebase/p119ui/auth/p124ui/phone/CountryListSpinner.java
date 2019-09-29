package com.firebase.p119ui.auth.p124ui.phone;

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
import androidx.appcompat.widget.C0686l;
import com.firebase.p119ui.auth.p124ui.phone.C2098e.C2099a;
import java.util.List;
import java.util.Locale;

/* renamed from: com.firebase.ui.auth.ui.phone.CountryListSpinner */
public final class CountryListSpinner extends C0686l implements OnClickListener, C2099a {

    /* renamed from: a */
    private String f6396a;

    /* renamed from: b */
    private C2082a f6397b;

    /* renamed from: c */
    private C2097d f6398c;

    /* renamed from: d */
    private OnClickListener f6399d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f6400e;

    /* renamed from: com.firebase.ui.auth.ui.phone.CountryListSpinner$a */
    public class C2082a implements DialogInterface.OnClickListener {

        /* renamed from: b */
        private final C2097d f6402b;

        /* renamed from: c */
        private AlertDialog f6403c;

        C2082a(C2097d dVar) {
            this.f6402b = dVar;
        }

        /* renamed from: a */
        public void mo11917a() {
            if (this.f6403c != null) {
                this.f6403c.dismiss();
                this.f6403c = null;
            }
        }

        /* renamed from: b */
        public boolean mo11919b() {
            return this.f6403c != null && this.f6403c.isShowing();
        }

        /* renamed from: a */
        public void mo11918a(final int i) {
            if (this.f6402b != null) {
                this.f6403c = new Builder(CountryListSpinner.this.getContext()).setSingleChoiceItems(this.f6402b, 0, this).create();
                this.f6403c.setCanceledOnTouchOutside(true);
                final ListView listView = this.f6403c.getListView();
                listView.setFastScrollEnabled(true);
                listView.setScrollbarFadingEnabled(false);
                listView.postDelayed(new Runnable() {
                    public void run() {
                        listView.setSelection(i);
                    }
                }, 10);
                this.f6403c.show();
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C2096c cVar = (C2096c) this.f6402b.getItem(i);
            CountryListSpinner.this.f6400e = cVar.f6439a.getDisplayCountry();
            CountryListSpinner.this.m8357a(cVar.f6440b, cVar.f6439a);
            mo11917a();
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
        m8356a();
    }

    /* renamed from: a */
    private static void m8358a(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: a */
    private void m8356a() {
        super.setOnClickListener(this);
        this.f6398c = new C2097d(getContext());
        this.f6397b = new C2082a(this.f6398c);
        this.f6396a = "%1$s  +%2$d";
        this.f6400e = "";
        C2096c a = C2103h.m8425a(getContext());
        m8357a(a.f6440b, a.f6439a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8357a(int i, Locale locale) {
        setText(String.format(this.f6396a, new Object[]{C2096c.m8406a(locale), Integer.valueOf(i)}));
        setTag(new C2096c(locale, i));
    }

    /* renamed from: a */
    public void mo11913a(Locale locale, String str) {
        String displayName = locale.getDisplayName();
        if (!TextUtils.isEmpty(displayName) && !TextUtils.isEmpty(str)) {
            this.f6400e = displayName;
            m8357a(Integer.parseInt(str), locale);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6397b.mo11919b()) {
            this.f6397b.mo11917a();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f6399d = onClickListener;
    }

    public void onClick(View view) {
        if (this.f6398c.getCount() == 0) {
            m8361b();
        } else {
            this.f6397b.mo11918a(this.f6398c.mo11949a(this.f6400e));
        }
        m8358a(getContext(), (View) this);
        m8359a(view);
    }

    /* renamed from: b */
    private void m8361b() {
        new C2098e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* renamed from: a */
    private void m8359a(View view) {
        if (this.f6399d != null) {
            this.f6399d.onClick(view);
        }
    }

    /* renamed from: a */
    public void mo11912a(List<C2096c> list) {
        this.f6398c.mo11950a(list);
        this.f6397b.mo11918a(this.f6398c.mo11949a(this.f6400e));
    }
}
