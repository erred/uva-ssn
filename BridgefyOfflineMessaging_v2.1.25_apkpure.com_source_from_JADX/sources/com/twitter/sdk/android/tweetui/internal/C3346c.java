package com.twitter.sdk.android.tweetui.internal;

import java.util.Locale;
import org.joda.time.DateTimeConstants;

/* renamed from: com.twitter.sdk.android.tweetui.internal.c */
/* compiled from: MediaTimeUtils */
final class C3346c {
    /* renamed from: a */
    static String m9770a(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / DateTimeConstants.SECONDS_PER_HOUR;
        if (i4 > 0) {
            return String.format(Locale.getDefault(), "%1$d:%2$02d:%3$02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)});
        }
        return String.format(Locale.getDefault(), "%1$d:%2$02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }
}
