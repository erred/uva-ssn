package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import com.twitter.sdk.android.core.internal.scribe.C3243w;
import com.twitter.sdk.android.tweetui.internal.C3353f.C3355a;
import java.io.Serializable;

public class PlayerActivity extends Activity {

    /* renamed from: a */
    static final C3364n f8628a = new C3365o(C3363m.m9824a());

    /* renamed from: b */
    C3320g f8629b;

    /* renamed from: com.twitter.sdk.android.tweetui.PlayerActivity$a */
    public static class C3307a implements Serializable {

        /* renamed from: a */
        public final String f8631a;

        /* renamed from: b */
        public final boolean f8632b;

        /* renamed from: c */
        public final boolean f8633c;

        /* renamed from: d */
        public final String f8634d;

        /* renamed from: e */
        public final String f8635e;

        public C3307a(String str, boolean z, boolean z2, String str2, String str3) {
            this.f8631a = str;
            this.f8632b = z;
            this.f8633c = z2;
            this.f8635e = str2;
            this.f8634d = str3;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__player_activity);
        C3307a aVar = (C3307a) getIntent().getSerializableExtra("PLAYER_ITEM");
        this.f8629b = new C3320g(findViewById(16908290), new C3355a() {
            /* renamed from: a */
            public void mo27979a(float f) {
            }

            /* renamed from: a */
            public void mo27978a() {
                PlayerActivity.this.finish();
                PlayerActivity.this.overridePendingTransition(0, R.anim.tw__slide_out);
            }
        });
        this.f8629b.mo28006a(aVar);
        m9646a((C3243w) getIntent().getSerializableExtra("SCRIBE_ITEM"));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f8629b.mo28005a();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f8629b.mo28009b();
        super.onPause();
    }

    public void onDestroy() {
        this.f8629b.mo28011c();
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    /* renamed from: a */
    private void m9646a(C3243w wVar) {
        f8628a.mo28166a(wVar);
    }
}
