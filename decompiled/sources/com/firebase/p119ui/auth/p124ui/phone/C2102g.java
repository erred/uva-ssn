package com.firebase.p119ui.auth.p124ui.phone;

import android.text.TextUtils;

/* renamed from: com.firebase.ui.auth.ui.phone.g */
/* compiled from: PhoneNumber */
final class C2102g {

    /* renamed from: a */
    private static final C2102g f6450a = new C2102g("", "", "");

    /* renamed from: b */
    private final String f6451b;

    /* renamed from: c */
    private final String f6452c;

    /* renamed from: d */
    private final String f6453d;

    public C2102g(String str, String str2, String str3) {
        this.f6451b = str;
        this.f6452c = str2;
        this.f6453d = str3;
    }

    /* renamed from: a */
    public static boolean m8420a(C2102g gVar) {
        return gVar != null && !f6450a.equals(gVar) && !TextUtils.isEmpty(gVar.mo11967b()) && !TextUtils.isEmpty(gVar.mo11966a()) && !TextUtils.isEmpty(gVar.mo11968c());
    }

    /* renamed from: b */
    public static boolean m8421b(C2102g gVar) {
        return gVar != null && !f6450a.equals(gVar) && !TextUtils.isEmpty(gVar.mo11966a()) && !TextUtils.isEmpty(gVar.mo11968c());
    }

    /* renamed from: a */
    public String mo11966a() {
        return this.f6453d;
    }

    /* renamed from: b */
    public String mo11967b() {
        return this.f6451b;
    }

    /* renamed from: c */
    public String mo11968c() {
        return this.f6452c;
    }
}
