package com.twitter.sdk.android.core.internal.p134b;

import android.content.Context;
import com.twitter.sdk.android.core.C3256m;
import java.io.File;

/* renamed from: com.twitter.sdk.android.core.internal.b.a */
/* compiled from: FileStoreImpl */
public class C3163a {

    /* renamed from: a */
    private final Context f8314a;

    public C3163a(Context context) {
        if (context != null) {
            this.f8314a = context;
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    /* renamed from: a */
    public File mo27681a() {
        return mo27682a(this.f8314a.getFilesDir());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo27682a(File file) {
        if (file == null) {
            C3256m.m9537g().mo27607a("Twitter", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C3256m.m9537g().mo27610b("Twitter", "Couldn't create file");
        }
        return null;
    }
}
