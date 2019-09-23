package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.C3177h;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.u */
/* compiled from: ScribeFilesManager */
class C3241u extends C3218g<C3238s> {
    public C3241u(Context context, C3217f<C3238s> fVar, C3177h hVar, C3235p pVar, int i) throws IOException {
        super(context, fVar, hVar, pVar, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo27796b() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append("se");
        sb.append("_");
        sb.append(randomUUID.toString());
        sb.append("_");
        sb.append(this.f8437c.mo27698a());
        sb.append(".tap");
        return sb.toString();
    }
}
