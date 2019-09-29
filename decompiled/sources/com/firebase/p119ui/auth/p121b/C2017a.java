package com.firebase.p119ui.auth.p121b;

import com.firebase.p119ui.auth.p121b.p123b.C2024b;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.firebase.ui.auth.b.a */
/* compiled from: AuthHelper */
public class C2017a {

    /* renamed from: a */
    private final C2048b f6249a;

    public C2017a(C2048b bVar) {
        this.f6249a = bVar;
    }

    /* renamed from: a */
    public FirebaseAuth mo11815a() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.f6249a.f6316a));
    }

    /* renamed from: b */
    public CredentialsApi mo11816b() {
        return Auth.CredentialsApi;
    }

    /* renamed from: c */
    public FirebaseUser mo11817c() {
        return mo11815a().getCurrentUser();
    }

    /* renamed from: a */
    public C2024b mo11814a(C2051d dVar) {
        return C2024b.m8206a(dVar);
    }

    /* renamed from: d */
    public PhoneAuthProvider mo11818d() {
        return PhoneAuthProvider.getInstance(mo11815a());
    }
}
