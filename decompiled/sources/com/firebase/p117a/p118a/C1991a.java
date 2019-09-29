package com.firebase.p117a.p118a;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import org.json.JSONException;
import org.json.JSONObject;
import p140me.bridgefy.ormlite.entities.FriendDTO;

/* renamed from: com.firebase.a.a.a */
/* compiled from: ClearSessionContinuation */
public class C1991a implements Continuation<Void, Task<Void>> {

    /* renamed from: a */
    private final C1994c f6166a;

    /* renamed from: com.firebase.a.a.a$a */
    /* compiled from: ClearSessionContinuation */
    public static class C1992a {

        /* renamed from: a */
        private final String f6167a;

        /* renamed from: b */
        private final String f6168b;

        /* renamed from: c */
        private final String f6169c;

        /* renamed from: d */
        private final String f6170d;

        /* renamed from: e */
        private final String f6171e;

        /* renamed from: f */
        private final String f6172f;

        /* renamed from: g */
        private final Boolean f6173g;

        /* renamed from: h */
        private final String f6174h;

        /* renamed from: i */
        private final Long f6175i;

        public C1992a(Long l, String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, String str7) {
            this.f6175i = l;
            this.f6174h = str;
            this.f6172f = str2;
            this.f6173g = bool;
            this.f6167a = str3;
            this.f6168b = str4;
            this.f6169c = str5;
            this.f6170d = str6;
            this.f6171e = str7;
        }

        /* renamed from: a */
        public JSONObject mo11771a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f6175i);
                jSONObject.put(FriendDTO.PHONE_NUMBER, this.f6174h);
                jSONObject.put("email_address", this.f6172f);
                jSONObject.put("is_email_verified", this.f6173g);
                jSONObject.put("auth_token", this.f6167a);
                jSONObject.put("auth_token_secret", this.f6168b);
                jSONObject.put("app_consumer_key", this.f6169c);
                jSONObject.put("app_consumer_secret", this.f6170d);
                jSONObject.put("fabric_api_key", this.f6171e);
                return jSONObject;
            } catch (JSONException unused) {
                return jSONObject;
            }
        }
    }

    public C1991a(C1994c cVar) {
        this.f6166a = cVar;
    }

    /* renamed from: a */
    public Task<Void> then(Task<Void> task) throws Exception {
        if (task.isSuccessful()) {
            this.f6166a.mo11776b();
            return task;
        }
        try {
            throw task.getException();
        } catch (C1993b e) {
            if (e.mo11772a() == 400 || e.mo11772a() == 403) {
                Log.d("ContentValues", "Digits session deemed invalid by server");
                Log.d("ContentValues", "Clearing legacy session");
                this.f6166a.mo11776b();
            }
            return task;
        }
    }
}
