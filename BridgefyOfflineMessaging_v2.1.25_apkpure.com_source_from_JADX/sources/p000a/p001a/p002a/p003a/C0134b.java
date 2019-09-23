package p000a.p001a.p002a.p003a;

import android.util.Log;

/* renamed from: a.a.a.a.b */
/* compiled from: DefaultLogger */
public class C0134b implements C0149l {

    /* renamed from: a */
    private int f310a;

    public C0134b(int i) {
        this.f310a = i;
    }

    public C0134b() {
        this.f310a = 4;
    }

    /* renamed from: a */
    public boolean mo272a(String str, int i) {
        return this.f310a <= i;
    }

    /* renamed from: a */
    public void mo271a(String str, String str2, Throwable th) {
        if (mo272a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    /* renamed from: b */
    public void mo274b(String str, String str2, Throwable th) {
        if (mo272a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    /* renamed from: c */
    public void mo276c(String str, String str2, Throwable th) {
        if (mo272a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    /* renamed from: d */
    public void mo278d(String str, String str2, Throwable th) {
        if (mo272a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: e */
    public void mo280e(String str, String str2, Throwable th) {
        if (mo272a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: a */
    public void mo270a(String str, String str2) {
        mo271a(str, str2, (Throwable) null);
    }

    /* renamed from: b */
    public void mo273b(String str, String str2) {
        mo274b(str, str2, null);
    }

    /* renamed from: c */
    public void mo275c(String str, String str2) {
        mo276c(str, str2, null);
    }

    /* renamed from: d */
    public void mo277d(String str, String str2) {
        mo278d(str, str2, null);
    }

    /* renamed from: e */
    public void mo279e(String str, String str2) {
        mo280e(str, str2, null);
    }

    /* renamed from: a */
    public void mo268a(int i, String str, String str2) {
        mo269a(i, str, str2, false);
    }

    /* renamed from: a */
    public void mo269a(int i, String str, String str2, boolean z) {
        if (z || mo272a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
