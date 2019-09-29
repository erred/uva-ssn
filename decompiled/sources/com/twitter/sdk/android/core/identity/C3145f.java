package com.twitter.sdk.android.core.identity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.twitter.sdk.android.core.internal.p133a.C3161f;
import java.net.URI;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.twitter.sdk.android.core.identity.f */
/* compiled from: OAuthWebViewClient */
class C3145f extends WebViewClient {

    /* renamed from: a */
    private final String f8292a;

    /* renamed from: b */
    private final C3146a f8293b;

    /* renamed from: com.twitter.sdk.android.core.identity.f$a */
    /* compiled from: OAuthWebViewClient */
    interface C3146a {
        /* renamed from: a */
        void mo27644a(Bundle bundle);

        /* renamed from: a */
        void mo27646a(WebView webView, String str);

        /* renamed from: a */
        void mo27647a(C3151i iVar);
    }

    public C3145f(String str, C3146a aVar) {
        this.f8292a = str;
        this.f8293b = aVar;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f8293b.mo27646a(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith(this.f8292a)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        TreeMap a = C3161f.m9262a(URI.create(str), false);
        Bundle bundle = new Bundle(a.size());
        for (Entry entry : a.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        this.f8293b.mo27644a(bundle);
        return true;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f8293b.mo27647a(new C3151i(i, str, str2));
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f8293b.mo27647a(new C3151i(sslError.getPrimaryError(), null, null));
    }
}
