package androidx.core.app;

import android.app.Person;
import android.app.Person.Builder;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: androidx.core.app.j */
/* compiled from: Person */
public class C0863j {

    /* renamed from: a */
    CharSequence f2803a;

    /* renamed from: b */
    IconCompat f2804b;

    /* renamed from: c */
    String f2805c;

    /* renamed from: d */
    String f2806d;

    /* renamed from: e */
    boolean f2807e;

    /* renamed from: f */
    boolean f2808f;

    /* renamed from: androidx.core.app.j$a */
    /* compiled from: Person */
    public static class C0864a {

        /* renamed from: a */
        CharSequence f2809a;

        /* renamed from: b */
        IconCompat f2810b;

        /* renamed from: c */
        String f2811c;

        /* renamed from: d */
        String f2812d;

        /* renamed from: e */
        boolean f2813e;

        /* renamed from: f */
        boolean f2814f;

        /* renamed from: a */
        public C0864a mo3527a(CharSequence charSequence) {
            this.f2809a = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0863j mo3528a() {
            return new C0863j(this);
        }
    }

    C0863j(C0864a aVar) {
        this.f2803a = aVar.f2809a;
        this.f2804b = aVar.f2810b;
        this.f2805c = aVar.f2811c;
        this.f2806d = aVar.f2812d;
        this.f2807e = aVar.f2813e;
        this.f2808f = aVar.f2814f;
    }

    /* renamed from: a */
    public Bundle mo3519a() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f2803a);
        bundle.putBundle("icon", this.f2804b != null ? this.f2804b.mo3792d() : null);
        bundle.putString("uri", this.f2805c);
        bundle.putString("key", this.f2806d);
        bundle.putBoolean("isBot", this.f2807e);
        bundle.putBoolean("isImportant", this.f2808f);
        return bundle;
    }

    /* renamed from: b */
    public Person mo3520b() {
        return new Builder().setName(mo3521c()).setIcon(mo3522d() != null ? mo3522d().mo3791c() : null).setUri(mo3523e()).setKey(mo3524f()).setBot(mo3525g()).setImportant(mo3526h()).build();
    }

    /* renamed from: c */
    public CharSequence mo3521c() {
        return this.f2803a;
    }

    /* renamed from: d */
    public IconCompat mo3522d() {
        return this.f2804b;
    }

    /* renamed from: e */
    public String mo3523e() {
        return this.f2805c;
    }

    /* renamed from: f */
    public String mo3524f() {
        return this.f2806d;
    }

    /* renamed from: g */
    public boolean mo3525g() {
        return this.f2807e;
    }

    /* renamed from: h */
    public boolean mo3526h() {
        return this.f2808f;
    }
}
