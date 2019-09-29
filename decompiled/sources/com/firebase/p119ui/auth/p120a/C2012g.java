package com.firebase.p119ui.auth.p120a;

import android.text.TextUtils;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import java.util.List;

/* renamed from: com.firebase.ui.auth.a.g */
/* compiled from: ProviderUtils */
public final class C2012g {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.auth.AuthCredential m8175a(com.firebase.p119ui.auth.C2034c r3) {
        /*
            java.lang.String r0 = r3.mo11837c()
            int r1 = r0.hashCode()
            r2 = -1830313082(0xffffffff92e7a386, float:-1.4618461E-27)
            if (r1 == r2) goto L_0x002c
            r2 = -1536293812(0xffffffffa46e044c, float:-5.1611663E-17)
            if (r1 == r2) goto L_0x0022
            r2 = -364826023(0xffffffffea413259, float:-5.839011E25)
            if (r1 == r2) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r1 = "facebook.com"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0022:
            java.lang.String r1 = "google.com"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x002c:
            java.lang.String r1 = "twitter.com"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 2
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            switch(r0) {
                case 0: goto L_0x0046;
                case 1: goto L_0x0041;
                case 2: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r3 = 0
            return r3
        L_0x003c:
            com.google.firebase.auth.AuthCredential r3 = com.firebase.p119ui.auth.p120a.C2014h.m8180a(r3)
            return r3
        L_0x0041:
            com.google.firebase.auth.AuthCredential r3 = com.firebase.p119ui.auth.p120a.C2006b.m8146a(r3)
            return r3
        L_0x0046:
            com.google.firebase.auth.AuthCredential r3 = com.firebase.p119ui.auth.p120a.C2007c.m8154a(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.p119ui.auth.p120a.C2012g.m8175a(com.firebase.ui.auth.c):com.google.firebase.auth.AuthCredential");
    }

    /* renamed from: a */
    public static Task<String> m8174a(FirebaseAuth firebaseAuth, String str) {
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new NullPointerException("Email cannot be empty"));
        }
        return firebaseAuth.fetchProvidersForEmail(str).addOnFailureListener(new C2077g("ProviderUtils", "Error fetching providers for email")).continueWith(new Continuation<ProviderQueryResult, String>() {
            /* renamed from: a */
            public String then(Task<ProviderQueryResult> task) throws Exception {
                String str = null;
                if (!task.isSuccessful()) {
                    return null;
                }
                List providers = ((ProviderQueryResult) task.getResult()).getProviders();
                if (providers != null && !providers.isEmpty()) {
                    str = (String) providers.get(providers.size() - 1);
                }
                return str;
            }
        });
    }
}
