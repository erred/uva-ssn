package com.firebase.p119ui.auth.p124ui;

import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.fragment.p081a.C1062d;
import com.firebase.p119ui.auth.p121b.C2017a;

/* renamed from: com.firebase.ui.auth.ui.c */
/* compiled from: FragmentBase */
public class C2050c extends C1062d {

    /* renamed from: a */
    private C2048b f6325a;

    /* renamed from: b */
    private C2017a f6326b;

    /* renamed from: c */
    private C2076f f6327c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6326b = new C2017a(mo11880b());
        this.f6327c = new C2076f(new ContextThemeWrapper(getContext(), mo11880b().f6318c));
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6327c.mo11907a();
    }

    /* renamed from: b */
    public C2048b mo11880b() {
        if (this.f6325a == null) {
            this.f6325a = C2048b.m8278a(getArguments());
        }
        return this.f6325a;
    }

    /* renamed from: c */
    public C2017a mo11881c() {
        return this.f6326b;
    }

    /* renamed from: d */
    public C2076f mo11882d() {
        return this.f6327c;
    }

    /* renamed from: a */
    public void mo11832a(int i, Intent intent) {
        getActivity().setResult(i, intent);
        getActivity().finish();
    }

    /* renamed from: a */
    public void mo11879a(IntentSender intentSender, int i) throws SendIntentException {
        startIntentSenderForResult(intentSender, i, null, 0, 0, 0, null);
    }
}
