package com.twitter.sdk.android.core.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import java.text.Normalizer;
import java.text.Normalizer.Form;

/* renamed from: com.twitter.sdk.android.core.internal.n */
/* compiled from: TwitterApi */
public class C3188n {

    /* renamed from: a */
    private final String f8357a;

    public C3188n() {
        this("https://api.twitter.com");
    }

    public C3188n(String str) {
        this.f8357a = str;
    }

    /* renamed from: a */
    public String mo27712a() {
        return this.f8357a;
    }

    /* renamed from: a */
    public Builder mo27711a(String... strArr) {
        Builder buildUpon = Uri.parse(mo27712a()).buildUpon();
        if (strArr != null) {
            for (String appendPath : strArr) {
                buildUpon.appendPath(appendPath);
            }
        }
        return buildUpon;
    }

    /* renamed from: a */
    public static String m9331a(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('/');
        sb.append(str2);
        sb.append(' ');
        sb.append(Build.MODEL);
        sb.append('/');
        sb.append(VERSION.RELEASE);
        sb.append(" (");
        sb.append(Build.MANUFACTURER);
        sb.append(';');
        sb.append(Build.MODEL);
        sb.append(';');
        sb.append(Build.BRAND);
        sb.append(';');
        sb.append(Build.PRODUCT);
        sb.append(')');
        return m9330a(sb.toString());
    }

    /* renamed from: a */
    static String m9330a(String str) {
        return m9332b(Normalizer.normalize(str, Form.NFD));
    }

    /* renamed from: b */
    static String m9332b(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
