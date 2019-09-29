package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.twitter.sdk.android.core.g */
/* compiled from: IntentUtils */
public class C3134g {
    /* renamed from: a */
    public static boolean m9163a(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    /* renamed from: b */
    public static boolean m9164b(Context context, Intent intent) {
        if (!m9163a(context, intent)) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }
}
