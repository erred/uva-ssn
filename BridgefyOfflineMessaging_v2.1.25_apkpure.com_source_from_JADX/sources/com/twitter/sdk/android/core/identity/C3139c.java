package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3261q;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.internal.oauth.C3200f;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;

/* renamed from: com.twitter.sdk.android.core.identity.c */
/* compiled from: OAuthController */
class C3139c implements C3146a {

    /* renamed from: a */
    final C3142a f8284a;

    /* renamed from: b */
    C3262s f8285b;

    /* renamed from: c */
    private final ProgressBar f8286c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WebView f8287d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C3259p f8288e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final OAuth1aService f8289f;

    /* renamed from: com.twitter.sdk.android.core.identity.c$a */
    /* compiled from: OAuthController */
    interface C3142a {
        /* renamed from: a */
        void mo27630a(int i, Intent intent);
    }

    C3139c(ProgressBar progressBar, WebView webView, C3259p pVar, OAuth1aService oAuth1aService, C3142a aVar) {
        this.f8286c = progressBar;
        this.f8287d = webView;
        this.f8288e = pVar;
        this.f8289f = oAuth1aService;
        this.f8284a = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27642a() {
        C3256m.m9537g().mo27607a("Twitter", "Obtaining request token to start the sign in flow");
        this.f8289f.mo27718a(mo27648b());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3128c<C3200f> mo27648b() {
        return new C3128c<C3200f>() {
            /* renamed from: a */
            public void mo11811a(C3253j<C3200f> jVar) {
                C3139c.this.f8285b = ((C3200f) jVar.f8523a).f8379a;
                String a = C3139c.this.f8289f.mo27717a(C3139c.this.f8285b);
                C3256m.m9537g().mo27607a("Twitter", "Redirecting user to web view to complete authorization flow");
                C3139c.this.mo27645a(C3139c.this.f8287d, new C3145f(C3139c.this.f8289f.mo27716a(C3139c.this.f8288e), C3139c.this), a, new C3144e());
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                C3256m.m9537g().mo27613c("Twitter", "Failed to get request token", wVar);
                C3139c.this.mo27643a(1, new C3261q("Failed to get request token"));
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27643a(int i, C3261q qVar) {
        Intent intent = new Intent();
        intent.putExtra("auth_error", qVar);
        this.f8284a.mo27630a(i, intent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27645a(WebView webView, WebViewClient webViewClient, String str, WebChromeClient webChromeClient) {
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(false);
        settings.setSaveFormData(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(str);
        webView.setVisibility(4);
        webView.setWebChromeClient(webChromeClient);
    }

    /* renamed from: b */
    private void m9195b(Bundle bundle) {
        C3256m.m9537g().mo27607a("Twitter", "OAuth web view completed successfully");
        if (bundle != null) {
            String string = bundle.getString("oauth_verifier");
            if (string != null) {
                C3256m.m9537g().mo27607a("Twitter", "Converting the request token to an access token.");
                this.f8289f.mo27719a(mo27649c(), this.f8285b, string);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to get authorization, bundle incomplete ");
        sb.append(bundle);
        C3256m.m9537g().mo27613c("Twitter", sb.toString(), null);
        mo27643a(1, new C3261q("Failed to get authorization, bundle incomplete"));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C3128c<C3200f> mo27649c() {
        return new C3128c<C3200f>() {
            /* renamed from: a */
            public void mo11811a(C3253j<C3200f> jVar) {
                Intent intent = new Intent();
                C3200f fVar = (C3200f) jVar.f8523a;
                intent.putExtra("screen_name", fVar.f8380b);
                intent.putExtra("user_id", fVar.f8381c);
                intent.putExtra("tk", fVar.f8379a.f8544b);
                intent.putExtra("ts", fVar.f8379a.f8545c);
                C3139c.this.f8284a.mo27630a(-1, intent);
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                C3256m.m9537g().mo27613c("Twitter", "Failed to get access token", wVar);
                C3139c.this.mo27643a(1, new C3261q("Failed to get access token"));
            }
        };
    }

    /* renamed from: b */
    private void m9196b(C3151i iVar) {
        C3256m.m9537g().mo27613c("Twitter", "OAuth web view completed with an error", iVar);
        mo27643a(1, new C3261q("OAuth web view completed with an error"));
    }

    /* renamed from: d */
    private void m9198d() {
        this.f8287d.stopLoading();
        m9199e();
    }

    /* renamed from: e */
    private void m9199e() {
        this.f8286c.setVisibility(8);
    }

    /* renamed from: a */
    public void mo27646a(WebView webView, String str) {
        m9199e();
        webView.setVisibility(0);
    }

    /* renamed from: a */
    public void mo27644a(Bundle bundle) {
        m9195b(bundle);
        m9198d();
    }

    /* renamed from: a */
    public void mo27647a(C3151i iVar) {
        m9196b(iVar);
        m9198d();
    }
}
