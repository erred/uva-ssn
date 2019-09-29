package com.twitter.sdk.android.tweetcomposer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.C3274y;

public class ComposerActivity extends Activity {

    /* renamed from: com.twitter.sdk.android.tweetcomposer.ComposerActivity$a */
    interface C3276a {
        /* renamed from: a */
        void mo27925a();
    }

    /* renamed from: com.twitter.sdk.android.tweetcomposer.ComposerActivity$b */
    class C3277b implements C3276a {
        C3277b() {
        }

        /* renamed from: a */
        public void mo27925a() {
            ComposerActivity.this.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        C3274y yVar = new C3274y((C3262s) intent.getParcelableExtra("EXTRA_USER_TOKEN"), -1, "");
        Uri uri = (Uri) intent.getParcelableExtra("EXTRA_IMAGE_URI");
        String stringExtra = intent.getStringExtra("EXTRA_TEXT");
        String stringExtra2 = intent.getStringExtra("EXTRA_HASHTAGS");
        setTheme(intent.getIntExtra("EXTRA_THEME", R.style.ComposerLight));
        setContentView(R.layout.tw__activity_composer);
        new C3290a((ComposerView) findViewById(R.id.tw__composer_view), yVar, uri, stringExtra, stringExtra2, new C3277b());
    }
}
