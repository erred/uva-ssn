package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.internal.p133a.C3161f;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p102c.C1677f;

/* renamed from: com.twitter.sdk.android.core.internal.oauth.d */
/* compiled from: OAuth1aParameters */
class C3197d {

    /* renamed from: a */
    private static final SecureRandom f8370a = new SecureRandom();

    /* renamed from: b */
    private final C3259p f8371b;

    /* renamed from: c */
    private final C3262s f8372c;

    /* renamed from: d */
    private final String f8373d;

    /* renamed from: e */
    private final String f8374e;

    /* renamed from: f */
    private final String f8375f;

    /* renamed from: g */
    private final Map<String, String> f8376g;

    public C3197d(C3259p pVar, C3262s sVar, String str, String str2, String str3, Map<String, String> map) {
        this.f8371b = pVar;
        this.f8372c = sVar;
        this.f8373d = str;
        this.f8374e = str2;
        this.f8375f = str3;
        this.f8376g = map;
    }

    /* renamed from: a */
    public String mo27735a() {
        String b = m9364b();
        String c = m9365c();
        return mo27738a(b, c, mo27736a(mo27737a(b, c)));
    }

    /* renamed from: b */
    private String m9364b() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(System.nanoTime()));
        sb.append(String.valueOf(Math.abs(f8370a.nextLong())));
        return sb.toString();
    }

    /* renamed from: c */
    private String m9365c() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27737a(String str, String str2) {
        URI create = URI.create(this.f8375f);
        TreeMap a = C3161f.m9262a(create, true);
        if (this.f8376g != null) {
            a.putAll(this.f8376g);
        }
        if (this.f8373d != null) {
            a.put("oauth_callback", this.f8373d);
        }
        a.put("oauth_consumer_key", this.f8371b.mo27864a());
        a.put("oauth_nonce", str);
        a.put("oauth_signature_method", "HMAC-SHA1");
        a.put("oauth_timestamp", str2);
        if (!(this.f8372c == null || this.f8372c.f8544b == null)) {
            a.put("oauth_token", this.f8372c.f8544b);
        }
        a.put("oauth_version", "1.0");
        StringBuilder sb = new StringBuilder();
        sb.append(create.getScheme());
        sb.append("://");
        sb.append(create.getHost());
        sb.append(create.getPath());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f8374e.toUpperCase(Locale.ENGLISH));
        sb3.append('&');
        sb3.append(C3161f.m9264c(sb2));
        sb3.append('&');
        sb3.append(m9362a(a));
        return sb3.toString();
    }

    /* renamed from: a */
    private String m9362a(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        int size = treeMap.size();
        int i = 0;
        for (Entry entry : treeMap.entrySet()) {
            sb.append(C3161f.m9264c(C3161f.m9264c((String) entry.getKey())));
            sb.append("%3D");
            sb.append(C3161f.m9264c(C3161f.m9264c((String) entry.getValue())));
            i++;
            if (i < size) {
                sb.append("%26");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27736a(String str) {
        try {
            String d = m9366d();
            byte[] bytes = str.getBytes("UTF8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(d.getBytes("UTF8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(bytes);
            return C1677f.m6987a(doFinal, 0, doFinal.length).mo6894b();
        } catch (InvalidKeyException e) {
            C3256m.m9537g().mo27613c("Twitter", "Failed to calculate signature", e);
            return "";
        } catch (NoSuchAlgorithmException e2) {
            C3256m.m9537g().mo27613c("Twitter", "Failed to calculate signature", e2);
            return "";
        } catch (UnsupportedEncodingException e3) {
            C3256m.m9537g().mo27613c("Twitter", "Failed to calculate signature", e3);
            return "";
        }
    }

    /* renamed from: d */
    private String m9366d() {
        String str = this.f8372c != null ? this.f8372c.f8545c : null;
        StringBuilder sb = new StringBuilder();
        sb.append(C3161f.m9260a(this.f8371b.mo27865b()));
        sb.append('&');
        sb.append(C3161f.m9260a(str));
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27738a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("OAuth");
        m9363a(sb, "oauth_callback", this.f8373d);
        m9363a(sb, "oauth_consumer_key", this.f8371b.mo27864a());
        m9363a(sb, "oauth_nonce", str);
        m9363a(sb, "oauth_signature", str3);
        m9363a(sb, "oauth_signature_method", "HMAC-SHA1");
        m9363a(sb, "oauth_timestamp", str2);
        m9363a(sb, "oauth_token", this.f8372c != null ? this.f8372c.f8544b : null);
        m9363a(sb, "oauth_version", "1.0");
        return sb.substring(0, sb.length() - 1);
    }

    /* renamed from: a */
    private void m9363a(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(C3161f.m9264c(str));
            sb.append("=\"");
            sb.append(C3161f.m9264c(str2));
            sb.append("\",");
        }
    }
}
