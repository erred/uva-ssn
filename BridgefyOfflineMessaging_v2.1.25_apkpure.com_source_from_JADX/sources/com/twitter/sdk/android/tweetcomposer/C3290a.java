package com.twitter.sdk.android.tweetcomposer;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.twitter.C3093d;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3257n;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.p132a.C3123s;

/* renamed from: com.twitter.sdk.android.tweetcomposer.a */
/* compiled from: ComposerController */
class C3290a {

    /* renamed from: a */
    final ComposerView f8603a;

    /* renamed from: b */
    final C3274y f8604b;

    /* renamed from: c */
    final Uri f8605c;

    /* renamed from: d */
    final C3276a f8606d;

    /* renamed from: e */
    final C3294c f8607e;

    /* renamed from: com.twitter.sdk.android.tweetcomposer.a$a */
    /* compiled from: ComposerController */
    interface C3292a {
        /* renamed from: a */
        void mo27955a();

        /* renamed from: a */
        void mo27956a(String str);

        /* renamed from: b */
        void mo27957b(String str);
    }

    /* renamed from: com.twitter.sdk.android.tweetcomposer.a$b */
    /* compiled from: ComposerController */
    class C3293b implements C3292a {
        C3293b() {
        }

        /* renamed from: a */
        public void mo27956a(String str) {
            int a = C3290a.this.mo27951a(str);
            C3290a.this.f8603a.setCharCount(C3290a.m9600a(a));
            if (C3290a.m9602c(a)) {
                C3290a.this.f8603a.setCharCountTextStyle(R.style.tw__ComposerCharCountOverflow);
            } else {
                C3290a.this.f8603a.setCharCountTextStyle(R.style.tw__ComposerCharCount);
            }
            C3290a.this.f8603a.mo27927a(C3290a.m9601b(a));
        }

        /* renamed from: b */
        public void mo27957b(String str) {
            C3290a.this.f8607e.mo27960b().mo27962a("tweet");
            Intent intent = new Intent(C3290a.this.f8603a.getContext(), TweetUploadService.class);
            intent.putExtra("EXTRA_USER_TOKEN", (Parcelable) C3290a.this.f8604b.mo27849a());
            intent.putExtra("EXTRA_TWEET_TEXT", str);
            intent.putExtra("EXTRA_IMAGE_URI", C3290a.this.f8605c);
            C3290a.this.f8603a.getContext().startService(intent);
            C3290a.this.f8606d.mo27925a();
        }

        /* renamed from: a */
        public void mo27955a() {
            C3290a.this.f8607e.mo27960b().mo27962a("cancel");
            C3290a.this.f8606d.mo27925a();
        }
    }

    /* renamed from: com.twitter.sdk.android.tweetcomposer.a$c */
    /* compiled from: ComposerController */
    static class C3294c {

        /* renamed from: a */
        final C3093d f8610a = new C3093d();

        C3294c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C3257n mo27959a(C3274y yVar) {
            return C3270v.m9566a().mo27912a(yVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C3093d mo27958a() {
            return this.f8610a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C3295b mo27960b() {
            return new C3296c(C3301h.m9631a().mo27966d());
        }
    }

    /* renamed from: a */
    static int m9600a(int i) {
        return 140 - i;
    }

    /* renamed from: b */
    static boolean m9601b(int i) {
        return i > 0 && i <= 140;
    }

    /* renamed from: c */
    static boolean m9602c(int i) {
        return i > 140;
    }

    C3290a(ComposerView composerView, C3274y yVar, Uri uri, String str, String str2, C3276a aVar) {
        this(composerView, yVar, uri, str, str2, aVar, new C3294c());
    }

    C3290a(ComposerView composerView, C3274y yVar, Uri uri, String str, String str2, C3276a aVar, C3294c cVar) {
        this.f8603a = composerView;
        this.f8604b = yVar;
        this.f8605c = uri;
        this.f8606d = aVar;
        this.f8607e = cVar;
        composerView.setCallbacks(new C3293b());
        composerView.setTweetText(mo27952a(str, str2));
        mo27953a();
        mo27954a(uri);
        cVar.mo27960b().mo27961a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27952a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27953a() {
        this.f8607e.mo27959a(this.f8604b).mo27858a().verifyCredentials(Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false)).mo28207a(new C3128c<C3123s>() {
            /* renamed from: a */
            public void mo11811a(C3253j<C3123s> jVar) {
                C3290a.this.f8603a.setProfilePhotoView((C3123s) jVar.f8523a);
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                C3290a.this.f8603a.setProfilePhotoView(null);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27954a(Uri uri) {
        if (uri != null) {
            this.f8603a.setImageView(uri);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo27951a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return this.f8607e.mo27958a().mo27590a(str);
    }
}
