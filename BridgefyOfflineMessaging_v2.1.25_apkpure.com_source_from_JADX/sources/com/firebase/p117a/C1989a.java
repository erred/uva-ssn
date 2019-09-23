package com.firebase.p117a;

import android.content.Context;
import android.util.Log;
import com.firebase.p117a.p118a.C1991a;
import com.firebase.p117a.p118a.C1994c;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.WeakHashMap;
import org.json.JSONException;

/* renamed from: com.firebase.a.a */
/* compiled from: AuthMigrator */
public final class C1989a {

    /* renamed from: a */
    private static final WeakHashMap<FirebaseApp, C1989a> f6159a = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Task<Void> f6160f = Tasks.forResult(null);

    /* renamed from: g */
    private static final Continuation<AuthResult, Task<Void>> f6161g = new Continuation<AuthResult, Task<Void>>() {
        /* renamed from: a */
        public Task<Void> then(Task<AuthResult> task) throws Exception {
            if (task.isSuccessful()) {
                return C1989a.f6160f;
            }
            try {
                throw task.getException();
            } catch (Exception e) {
                return Tasks.forException(e);
            }
        }
    };

    /* renamed from: b */
    private final C1994c f6162b;

    /* renamed from: c */
    private final FirebaseAuth f6163c;

    /* renamed from: d */
    private final FirebaseApp f6164d;

    /* renamed from: e */
    private final C1991a f6165e = new C1991a(this.f6162b);

    /* renamed from: a */
    public static C1989a m8103a(FirebaseApp firebaseApp) {
        C1989a aVar;
        synchronized (f6159a) {
            aVar = (C1989a) f6159a.get(firebaseApp);
            if (aVar == null) {
                aVar = new C1989a(firebaseApp, new C1994c(firebaseApp.getApplicationContext()), FirebaseAuth.getInstance());
                f6159a.put(firebaseApp, aVar);
            }
        }
        return aVar;
    }

    /* renamed from: a */
    public static C1989a m8102a() {
        return m8103a(FirebaseApp.getInstance());
    }

    /* renamed from: a */
    public Task<Void> mo11767a(boolean z) {
        FirebaseUser currentUser = this.f6163c.getCurrentUser();
        String a = this.f6162b.mo11773a();
        Context applicationContext = this.f6164d.getApplicationContext();
        if (currentUser != null) {
            Log.d("DigitsAuthMigrator", "Found existing firebase session. Skipping Exchange.");
            return m8105b(z);
        } else if (a == null) {
            Log.d("DigitsAuthMigrator", "No digits session found");
            return m8105b(z);
        } else {
            Log.d("DigitsAuthMigrator", "Exchanging digits session");
            try {
                C1995b h = C1995b.m8122h(a);
                h.mo11784e(this.f6162b.mo11774a(applicationContext, "com.digits.sdk.android.ConsumerKey")).mo11785f(this.f6162b.mo11774a(applicationContext, "com.digits.sdk.android.ConsumerSecret")).mo11786g(this.f6162b.mo11774a(applicationContext, "io.fabric.ApiKey"));
                Task<Void> continueWithTask = this.f6163c.signInWithCustomToken(this.f6162b.mo11775a(h.mo11777a().mo11771a())).continueWithTask(f6161g);
                if (z) {
                    continueWithTask = continueWithTask.continueWithTask(this.f6165e);
                }
                return continueWithTask;
            } catch (JSONException unused) {
                Log.d("DigitsAuthMigrator", "Digits sesion is corrupt");
                return m8105b(z);
            }
        }
    }

    /* renamed from: b */
    private Task<Void> m8105b(boolean z) {
        if (z) {
            Log.d("DigitsAuthMigrator", "Clearing legacy session");
            this.f6162b.mo11776b();
        }
        return f6160f;
    }

    C1989a(FirebaseApp firebaseApp, C1994c cVar, FirebaseAuth firebaseAuth) {
        this.f6164d = firebaseApp;
        this.f6162b = cVar;
        this.f6163c = firebaseAuth;
    }
}
