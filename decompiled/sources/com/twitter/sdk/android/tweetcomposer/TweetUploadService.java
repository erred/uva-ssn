package com.twitter.sdk.android.tweetcomposer;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3257n;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.p132a.C3111i;
import com.twitter.sdk.android.core.p132a.C3119o;
import java.io.File;
import p091b.C1592ab;
import p091b.C1647v;

public class TweetUploadService extends IntentService {

    /* renamed from: a */
    C3289a f8597a;

    /* renamed from: b */
    Intent f8598b;

    /* renamed from: com.twitter.sdk.android.tweetcomposer.TweetUploadService$a */
    static class C3289a {
        C3289a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C3257n mo27950a(C3274y yVar) {
            return C3270v.m9566a().mo27912a(yVar);
        }
    }

    public TweetUploadService() {
        this(new C3289a());
    }

    TweetUploadService(C3289a aVar) {
        super("TweetUploadService");
        this.f8597a = aVar;
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        C3262s sVar = (C3262s) intent.getParcelableExtra("EXTRA_USER_TOKEN");
        this.f8598b = intent;
        mo27947a(new C3274y(sVar, -1, ""), intent.getStringExtra("EXTRA_TWEET_TEXT"), (Uri) intent.getParcelableExtra("EXTRA_IMAGE_URI"));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27947a(final C3274y yVar, final String str, Uri uri) {
        if (uri != null) {
            mo27946a(yVar, uri, (C3128c<C3111i>) new C3128c<C3111i>() {
                /* renamed from: a */
                public void mo11811a(C3253j<C3111i> jVar) {
                    TweetUploadService.this.mo27948a(yVar, str, ((C3111i) jVar.f8523a).f8167a);
                }

                /* renamed from: a */
                public void mo11812a(C3272w wVar) {
                    TweetUploadService.this.mo27945a(wVar);
                }
            });
        } else {
            mo27948a(yVar, str, (String) null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27948a(C3274y yVar, String str, String str2) {
        this.f8597a.mo27950a(yVar).mo27861c().update(str, null, null, null, null, null, null, Boolean.valueOf(true), str2).mo28207a(new C3128c<C3119o>() {
            /* renamed from: a */
            public void mo11811a(C3253j<C3119o> jVar) {
                TweetUploadService.this.mo27943a(((C3119o) jVar.f8523a).mo27595a());
                TweetUploadService.this.stopSelf();
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                TweetUploadService.this.mo27945a(wVar);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27946a(C3274y yVar, Uri uri, C3128c<C3111i> cVar) {
        C3257n a = this.f8597a.mo27950a(yVar);
        String a2 = C3297d.m9622a(this, uri);
        if (a2 == null) {
            mo27945a(new C3272w("Uri file path resolved to null"));
            return;
        }
        File file = new File(a2);
        a.mo27862d().upload(C1592ab.m6495a(C1647v.m6791a(C3297d.m9624a(file)), file), null, null).mo28207a(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27945a(C3272w wVar) {
        mo27944a(this.f8598b);
        C3256m.m9537g().mo27613c("TweetUploadService", "Post Tweet failed", wVar);
        stopSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27943a(long j) {
        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_SUCCESS");
        intent.putExtra("EXTRA_TWEET_ID", j);
        intent.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27944a(Intent intent) {
        Intent intent2 = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_FAILURE");
        intent2.putExtra("EXTRA_RETRY_INTENT", intent);
        intent2.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent2);
    }
}
