package com.firebase.p117a;

import android.text.TextUtils;
import android.util.Log;
import com.firebase.p117a.p118a.C1991a.C1992a;
import com.google.android.gms.common.Scopes;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import p140me.bridgefy.ormlite.entities.FriendDTO;

/* renamed from: com.firebase.a.b */
/* compiled from: RedeemableDigitsSessionBuilder */
public class C1995b {

    /* renamed from: a */
    private Long f6178a;

    /* renamed from: b */
    private String f6179b;

    /* renamed from: c */
    private String f6180c;

    /* renamed from: d */
    private Boolean f6181d;

    /* renamed from: e */
    private String f6182e;

    /* renamed from: f */
    private String f6183f;

    /* renamed from: g */
    private String f6184g;

    /* renamed from: h */
    private String f6185h;

    /* renamed from: i */
    private String f6186i;

    /* renamed from: a */
    public C1995b mo11779a(Long l) {
        this.f6178a = l;
        return this;
    }

    /* renamed from: a */
    public C1995b mo11780a(String str) {
        this.f6179b = str;
        return this;
    }

    /* renamed from: b */
    public C1995b mo11781b(String str) {
        this.f6180c = str;
        return this;
    }

    /* renamed from: a */
    public C1995b mo11778a(Boolean bool) {
        this.f6181d = bool;
        return this;
    }

    /* renamed from: c */
    public C1995b mo11782c(String str) {
        this.f6182e = str;
        return this;
    }

    /* renamed from: d */
    public C1995b mo11783d(String str) {
        this.f6183f = str;
        return this;
    }

    /* renamed from: e */
    public C1995b mo11784e(String str) {
        this.f6184g = str;
        return this;
    }

    /* renamed from: f */
    public C1995b mo11785f(String str) {
        this.f6185h = str;
        return this;
    }

    /* renamed from: g */
    public C1995b mo11786g(String str) {
        this.f6186i = str;
        return this;
    }

    /* renamed from: a */
    public C1992a mo11777a() {
        m8115a((T) this.f6182e, (Object) "Auth Token cannot be null");
        m8115a((T) this.f6183f, (Object) "Token Secret cannot be null");
        m8118b((T) this.f6184g, (Object) "Consumer Key cannot be empty. Your AndroidManifest.xml should have an entry like: \n<meta-data\n\tandroid:name=\"com.digits.sdk.android.ConsumerKey\"\n\tandroid:value=\"YOUR_DIGITS_CONSUMER_KEY\"\n\ttools:replace=\"android:value\" />\n");
        m8118b((T) this.f6185h, (Object) "Consumer Secret cannot be empty. Your AndroidManifest.xml should have an entry like:\n<meta-data\n\tandroid:name=\"com.digits.sdk.android.ConsumerSecret\"\n\tandroid:value=\"YOUR_DIGITS_CONSUMER_SECRET\"\n\ttools:replace=\"android:value\" />\n");
        m8118b((T) this.f6186i, (Object) "Fabric Api Key cannot be empty. Your AndroidManifest.xml should have an entry like: \n<meta-data\n\tandroid:name=\"io.fabric.ApiKey\"\n\tandroid:value=\"YOUR_FABRIC_API_KEY\"\n\ttools:replace=\"android:value\" />\n");
        if (m8123i(this.f6186i)) {
            C1992a aVar = new C1992a(this.f6178a, this.f6179b, this.f6180c, this.f6181d, this.f6182e, this.f6183f, this.f6184g, this.f6185h, this.f6186i);
            return aVar;
        }
        throw new IllegalArgumentException("Invalid Fabric API key.Contact support@fabric.io for assistance");
    }

    /* renamed from: h */
    static C1995b m8122h(String str) throws JSONException {
        C1995b bVar = new C1995b();
        JSONObject jSONObject = new JSONObject(str);
        JSONObject a = m8116a(Scopes.EMAIL, jSONObject);
        JSONObject a2 = m8116a("auth_token", jSONObject);
        bVar.mo11780a(m8119b(FriendDTO.PHONE_NUMBER, jSONObject));
        bVar.mo11779a(m8120c("id", jSONObject));
        JSONObject a3 = m8116a("auth_token", a2);
        bVar.mo11781b(m8119b("address", a));
        bVar.mo11778a(m8121d("is_verified", a));
        bVar.mo11782c(m8119b("token", a3));
        bVar.mo11783d(m8119b("secret", a3));
        return bVar;
    }

    /* renamed from: a */
    private static JSONObject m8116a(String str, JSONObject jSONObject) throws JSONException {
        if (m8117a(jSONObject, str)) {
            return jSONObject.getJSONObject(str);
        }
        return null;
    }

    /* renamed from: b */
    private static String m8119b(String str, JSONObject jSONObject) throws JSONException {
        if (m8117a(jSONObject, str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    /* renamed from: c */
    private static Long m8120c(String str, JSONObject jSONObject) throws JSONException {
        if (m8117a(jSONObject, str)) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        return null;
    }

    /* renamed from: d */
    private static Boolean m8121d(String str, JSONObject jSONObject) throws JSONException {
        if (m8117a(jSONObject, str)) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m8117a(JSONObject jSONObject, String str) {
        return (str == null || jSONObject == null || !jSONObject.has(str)) ? false : true;
    }

    /* renamed from: a */
    private static <T> T m8115a(T t, Object obj) {
        if ((t instanceof String) && TextUtils.isEmpty((String) t)) {
            Log.d("Digits", String.valueOf(obj));
        } else if (t == null) {
            Log.d("Digits", String.valueOf(obj));
        }
        return t;
    }

    /* renamed from: b */
    private static <T> T m8118b(T t, Object obj) {
        if ((t instanceof String) && TextUtils.isEmpty((String) t)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        } else if (t != null) {
            return t;
        } else {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: i */
    private static boolean m8123i(String str) {
        return str != null && str.length() == 40 && Pattern.compile("[0-9a-f]+").matcher(str).matches();
    }
}
