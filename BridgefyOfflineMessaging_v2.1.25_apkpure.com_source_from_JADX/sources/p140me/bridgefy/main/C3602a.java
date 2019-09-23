package p140me.bridgefy.main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import p140me.bridgefy.intro.verification.C3582g;

/* renamed from: me.bridgefy.main.a */
/* compiled from: BGBaseAuth */
public abstract class C3602a {

    /* renamed from: a */
    protected SharedPreferences f9484a;

    /* renamed from: me.bridgefy.main.a$a */
    /* compiled from: BGBaseAuth */
    public enum C3603a {
        UNKNOWN,
        PHONE_FORMAT,
        TIMEOUT,
        INCORRECT_CODE,
        QUOTA_EXCEEDED,
        USER_COLLISION,
        NETWORK_ERROR
    }

    /* renamed from: me.bridgefy.main.a$b */
    /* compiled from: BGBaseAuth */
    public interface C3604b {
        /* renamed from: a */
        void mo29445a(Bundle bundle, String str);

        /* renamed from: a */
        void mo29446a(C3603a aVar, String str);

        /* renamed from: d */
        void mo29450d();
    }

    /* renamed from: a */
    public abstract void mo29552a(Activity activity, C3582g gVar, int i);

    /* renamed from: a */
    public abstract void mo29553a(String str);
}
