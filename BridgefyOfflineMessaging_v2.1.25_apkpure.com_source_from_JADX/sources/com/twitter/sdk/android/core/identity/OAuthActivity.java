package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3261q;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.R;
import com.twitter.sdk.android.core.internal.C3188n;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;

public class OAuthActivity extends Activity implements C3142a {

    /* renamed from: a */
    C3139c f8277a;

    /* renamed from: b */
    private ProgressBar f8278b;

    /* renamed from: c */
    private WebView f8279c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__activity_oauth);
        this.f8278b = (ProgressBar) findViewById(R.id.tw__spinner);
        this.f8279c = (WebView) findViewById(R.id.tw__web_view);
        int i = 0;
        boolean z = bundle != null ? bundle.getBoolean("progress", false) : true;
        ProgressBar progressBar = this.f8278b;
        if (!z) {
            i = 8;
        }
        progressBar.setVisibility(i);
        C3139c cVar = new C3139c(this.f8278b, this.f8279c, (C3259p) getIntent().getParcelableExtra("auth_config"), new OAuth1aService(C3270v.m9566a(), new C3188n()), this);
        this.f8277a = cVar;
        this.f8277a.mo27642a();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f8278b.getVisibility() == 0) {
            bundle.putBoolean("progress", true);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onBackPressed() {
        this.f8277a.mo27643a(0, new C3261q("Authorization failed, request was canceled."));
    }

    /* renamed from: a */
    public void mo27630a(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }
}
