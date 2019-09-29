package com.p103a.p104a.p107c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;

/* renamed from: com.a.a.c.a */
/* compiled from: AppData */
class C1746a {

    /* renamed from: a */
    public final String f5472a;

    /* renamed from: b */
    public final String f5473b;

    /* renamed from: c */
    public final String f5474c;

    /* renamed from: d */
    public final String f5475d;

    /* renamed from: e */
    public final String f5476e;

    /* renamed from: f */
    public final String f5477f;

    /* renamed from: a */
    public static C1746a m7272a(Context context, C0032o oVar, String str, String str2) throws NameNotFoundException {
        String packageName = context.getPackageName();
        String j = oVar.mo63j();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        C1746a aVar = new C1746a(str, str2, j, packageName, Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? "0.0" : packageInfo.versionName);
        return aVar;
    }

    C1746a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f5472a = str;
        this.f5473b = str2;
        this.f5474c = str3;
        this.f5475d = str4;
        this.f5476e = str5;
        this.f5477f = str6;
    }
}
