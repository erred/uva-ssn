package com.p103a.p104a.p107c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o.C0033a;

/* renamed from: com.a.a.c.ag */
/* compiled from: SessionProtobufHelper */
class C1767ag {

    /* renamed from: a */
    private static final C1776b f5528a = C1776b.m7350a("0");

    /* renamed from: b */
    private static final C1776b f5529b = C1776b.m7350a("Unity");

    /* renamed from: a */
    public static void m7331a(C1780e eVar, String str, String str2, long j) throws Exception {
        eVar.mo7053a(1, C1776b.m7350a(str2));
        eVar.mo7053a(2, C1776b.m7350a(str));
        eVar.mo7052a(3, j);
    }

    /* renamed from: a */
    public static void m7333a(C1780e eVar, String str, String str2, String str3, String str4, String str5, int i, String str6) throws Exception {
        C1776b a = C1776b.m7350a(str);
        C1776b a2 = C1776b.m7350a(str2);
        C1776b a3 = C1776b.m7350a(str3);
        C1776b a4 = C1776b.m7350a(str4);
        C1776b a5 = C1776b.m7350a(str5);
        C1776b a6 = str6 != null ? C1776b.m7350a(str6) : null;
        eVar.mo7069g(7, 2);
        eVar.mo7071k(m7316a(a, a2, a3, a4, a5, i, a6));
        eVar.mo7053a(1, a);
        eVar.mo7053a(2, a3);
        eVar.mo7053a(3, a4);
        eVar.mo7069g(5, 2);
        eVar.mo7071k(m7314a(a2));
        eVar.mo7053a(1, a2);
        eVar.mo7053a(6, a5);
        if (a6 != null) {
            eVar.mo7053a(8, f5529b);
            eVar.mo7053a(9, a6);
        }
        eVar.mo7062b(10, i);
    }

    /* renamed from: a */
    public static void m7336a(C1780e eVar, boolean z) throws Exception {
        C1776b a = C1776b.m7350a(VERSION.RELEASE);
        C1776b a2 = C1776b.m7350a(VERSION.CODENAME);
        eVar.mo7069g(8, 2);
        eVar.mo7071k(m7317a(a, a2, z));
        eVar.mo7062b(1, 3);
        eVar.mo7053a(2, a);
        eVar.mo7053a(3, a2);
        eVar.mo7054a(4, z);
    }

    /* renamed from: a */
    public static void m7330a(C1780e eVar, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<C0033a, String> map, int i3, String str3, String str4) throws Exception {
        C1780e eVar2 = eVar;
        C1776b a = C1776b.m7350a(str);
        C1776b a2 = m7322a(str2);
        C1776b a3 = m7322a(str4);
        C1776b a4 = m7322a(str3);
        eVar2.mo7069g(9, 2);
        C1776b bVar = a4;
        C1776b bVar2 = a3;
        eVar2.mo7071k(m7308a(i, a, a2, i2, j, j2, z, map, i3, a4, a3));
        eVar2.mo7053a(1, a);
        eVar2.mo7062b(3, i);
        eVar2.mo7053a(4, a2);
        eVar2.mo7051a(5, i2);
        eVar2.mo7052a(6, j);
        eVar2.mo7052a(7, j2);
        eVar2.mo7054a(10, z);
        for (Entry entry : map.entrySet()) {
            eVar2.mo7069g(11, 2);
            eVar2.mo7071k(m7310a((C0033a) entry.getKey(), (String) entry.getValue()));
            eVar2.mo7062b(1, ((C0033a) entry.getKey()).f78h);
            eVar2.mo7053a(2, C1776b.m7350a((String) entry.getValue()));
        }
        eVar2.mo7051a(12, i3);
        C1776b bVar3 = bVar;
        if (bVar3 != null) {
            eVar2.mo7053a(13, bVar3);
        }
        C1776b bVar4 = bVar2;
        if (bVar4 != null) {
            eVar2.mo7053a(14, bVar4);
        }
    }

    /* renamed from: a */
    public static void m7332a(C1780e eVar, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        C1776b a = C1776b.m7350a(str);
        C1776b a2 = m7322a(str2);
        C1776b a3 = m7322a(str3);
        int b = C1780e.m7367b(1, a) + 0;
        if (str2 != null) {
            b += C1780e.m7367b(2, a2);
        }
        if (str3 != null) {
            b += C1780e.m7367b(3, a3);
        }
        eVar.mo7069g(6, 2);
        eVar.mo7071k(b);
        eVar.mo7053a(1, a);
        if (str2 != null) {
            eVar.mo7053a(2, a2);
        }
        if (str3 != null) {
            eVar.mo7053a(3, a3);
        }
    }

    /* renamed from: a */
    public static void m7324a(C1780e eVar, long j, String str, C1770aj ajVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, C1835u uVar, RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) throws Exception {
        C1776b a;
        C1780e eVar2 = eVar;
        String str4 = str3;
        C1776b a2 = C1776b.m7350a(str2);
        if (str4 == null) {
            a = null;
        } else {
            a = C1776b.m7350a(str4.replace("-", ""));
        }
        C1776b bVar = a;
        C1776b a3 = uVar.mo7166a();
        if (a3 == null) {
            C0135c.m449h().mo270a("CrashlyticsCore", "No log data to include with this event.");
        }
        uVar.mo7170b();
        eVar2.mo7069g(10, 2);
        eVar2.mo7071k(m7309a(j, str, ajVar, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i, a2, bVar, f, i2, z, j2, j3, a3));
        eVar2.mo7052a(1, j);
        eVar2.mo7053a(2, C1776b.m7350a(str));
        C1776b bVar2 = a3;
        m7327a(eVar, ajVar, thread, stackTraceElementArr, threadArr, list, 8, a2, bVar, map, runningAppProcessInfo, i);
        m7329a(eVar, f, i2, z, i, j2, j3);
        m7328a(eVar2, bVar2);
    }

    /* renamed from: a */
    private static void m7327a(C1780e eVar, C1770aj ajVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1776b bVar, C1776b bVar2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) throws Exception {
        eVar.mo7069g(3, 2);
        eVar.mo7071k(m7313a(ajVar, thread, stackTraceElementArr, threadArr, list, i, bVar, bVar2, map, runningAppProcessInfo, i2));
        m7326a(eVar, ajVar, thread, stackTraceElementArr, threadArr, list, i, bVar, bVar2);
        if (map != null && !map.isEmpty()) {
            m7335a(eVar, map);
        }
        if (runningAppProcessInfo != null) {
            eVar.mo7054a(3, runningAppProcessInfo.importance != 100);
        }
        eVar.mo7051a(4, i2);
    }

    /* renamed from: a */
    private static void m7326a(C1780e eVar, C1770aj ajVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1776b bVar, C1776b bVar2) throws Exception {
        eVar.mo7069g(1, 2);
        eVar.mo7071k(m7312a(ajVar, thread, stackTraceElementArr, threadArr, list, i, bVar, bVar2));
        m7334a(eVar, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            m7334a(eVar, threadArr[i2], (StackTraceElement[]) list.get(i2), 0, false);
        }
        m7325a(eVar, ajVar, 1, i, 2);
        eVar.mo7069g(3, 2);
        eVar.mo7071k(m7307a());
        eVar.mo7053a(1, f5528a);
        eVar.mo7053a(2, f5528a);
        eVar.mo7052a(3, 0);
        eVar.mo7069g(4, 2);
        eVar.mo7071k(m7315a(bVar, bVar2));
        eVar.mo7052a(1, 0);
        eVar.mo7052a(2, 0);
        eVar.mo7053a(3, bVar);
        if (bVar2 != null) {
            eVar.mo7053a(4, bVar2);
        }
    }

    /* renamed from: a */
    private static void m7335a(C1780e eVar, Map<String, String> map) throws Exception {
        for (Entry entry : map.entrySet()) {
            eVar.mo7069g(2, 2);
            eVar.mo7071k(m7320a((String) entry.getKey(), (String) entry.getValue()));
            eVar.mo7053a(1, C1776b.m7350a((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            eVar.mo7053a(2, C1776b.m7350a(str));
        }
    }

    /* renamed from: a */
    private static void m7325a(C1780e eVar, C1770aj ajVar, int i, int i2, int i3) throws Exception {
        eVar.mo7069g(i3, 2);
        eVar.mo7071k(m7311a(ajVar, 1, i2));
        eVar.mo7053a(1, C1776b.m7350a(ajVar.f5534b));
        String str = ajVar.f5533a;
        if (str != null) {
            eVar.mo7053a(3, C1776b.m7350a(str));
        }
        int i4 = 0;
        for (StackTraceElement a : ajVar.f5535c) {
            m7323a(eVar, 4, a, true);
        }
        C1770aj ajVar2 = ajVar.f5536d;
        if (ajVar2 == null) {
            return;
        }
        if (i < i2) {
            m7325a(eVar, ajVar2, i + 1, i2, 6);
            return;
        }
        while (ajVar2 != null) {
            ajVar2 = ajVar2.f5536d;
            i4++;
        }
        eVar.mo7051a(7, i4);
    }

    /* renamed from: a */
    private static void m7334a(C1780e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        eVar.mo7069g(1, 2);
        eVar.mo7071k(m7321a(thread, stackTraceElementArr, i, z));
        eVar.mo7053a(1, C1776b.m7350a(thread.getName()));
        eVar.mo7051a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            m7323a(eVar, 3, a, z);
        }
    }

    /* renamed from: a */
    private static void m7323a(C1780e eVar, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        eVar.mo7069g(i, 2);
        eVar.mo7071k(m7319a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            eVar.mo7052a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            eVar.mo7052a(1, 0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName());
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        eVar.mo7053a(2, C1776b.m7350a(sb.toString()));
        if (stackTraceElement.getFileName() != null) {
            eVar.mo7053a(3, C1776b.m7350a(stackTraceElement.getFileName()));
        }
        int i2 = 4;
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            eVar.mo7052a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        eVar.mo7051a(5, i2);
    }

    /* renamed from: a */
    private static void m7329a(C1780e eVar, Float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        eVar.mo7069g(5, 2);
        eVar.mo7071k(m7318a(f, i, z, i2, j, j2));
        if (f != null) {
            eVar.mo7050a(1, f.floatValue());
        }
        eVar.mo7064c(2, i);
        eVar.mo7054a(3, z);
        eVar.mo7051a(4, i2);
        eVar.mo7052a(5, j);
        eVar.mo7052a(6, j2);
    }

    /* renamed from: a */
    private static void m7328a(C1780e eVar, C1776b bVar) throws Exception {
        if (bVar != null) {
            eVar.mo7069g(6, 2);
            eVar.mo7071k(m7337b(bVar));
            eVar.mo7053a(1, bVar);
        }
    }

    /* renamed from: a */
    private static int m7316a(C1776b bVar, C1776b bVar2, C1776b bVar3, C1776b bVar4, C1776b bVar5, int i, C1776b bVar6) {
        int b = C1780e.m7367b(1, bVar) + 0 + C1780e.m7367b(2, bVar3) + C1780e.m7367b(3, bVar4);
        int a = m7314a(bVar2);
        int j = b + C1780e.m7380j(5) + C1780e.m7381l(a) + a + C1780e.m7367b(6, bVar5);
        if (bVar6 != null) {
            j = j + C1780e.m7367b(8, f5529b) + C1780e.m7367b(9, bVar6);
        }
        return j + C1780e.m7375e(10, i);
    }

    /* renamed from: a */
    private static int m7314a(C1776b bVar) {
        return C1780e.m7367b(1, bVar) + 0;
    }

    /* renamed from: a */
    private static int m7317a(C1776b bVar, C1776b bVar2, boolean z) {
        return C1780e.m7375e(1, 3) + 0 + C1780e.m7367b(2, bVar) + C1780e.m7367b(3, bVar2) + C1780e.m7368b(4, z);
    }

    /* renamed from: a */
    private static int m7310a(C0033a aVar, String str) {
        return C1780e.m7375e(1, aVar.f78h) + C1780e.m7367b(2, C1776b.m7350a(str));
    }

    /* renamed from: a */
    private static int m7308a(int i, C1776b bVar, C1776b bVar2, int i2, long j, long j2, boolean z, Map<C0033a, String> map, int i3, C1776b bVar3, C1776b bVar4) {
        int i4;
        int i5;
        int i6 = 0;
        int b = C1780e.m7367b(1, bVar) + 0 + C1780e.m7375e(3, i);
        if (bVar2 == null) {
            i4 = 0;
        } else {
            i4 = C1780e.m7367b(4, bVar2);
        }
        int d = b + i4 + C1780e.m7372d(5, i2) + C1780e.m7366b(6, j) + C1780e.m7366b(7, j2) + C1780e.m7368b(10, z);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                int a = m7310a((C0033a) entry.getKey(), (String) entry.getValue());
                d += C1780e.m7380j(11) + C1780e.m7381l(a) + a;
            }
        }
        int d2 = d + C1780e.m7372d(12, i3);
        if (bVar3 == null) {
            i5 = 0;
        } else {
            i5 = C1780e.m7367b(13, bVar3);
        }
        int i7 = d2 + i5;
        if (bVar4 != null) {
            i6 = C1780e.m7367b(14, bVar4);
        }
        return i7 + i6;
    }

    /* renamed from: a */
    private static int m7315a(C1776b bVar, C1776b bVar2) {
        int b = C1780e.m7366b(1, 0) + 0 + C1780e.m7366b(2, 0) + C1780e.m7367b(3, bVar);
        return bVar2 != null ? b + C1780e.m7367b(4, bVar2) : b;
    }

    /* renamed from: a */
    private static int m7309a(long j, String str, C1770aj ajVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2, C1776b bVar, C1776b bVar2, Float f, int i3, boolean z, long j2, long j3, C1776b bVar3) {
        long j4 = j;
        int b = C1780e.m7366b(1, j) + 0 + C1780e.m7367b(2, C1776b.m7350a(str));
        int a = m7313a(ajVar, thread, stackTraceElementArr, threadArr, list, i, bVar, bVar2, map, runningAppProcessInfo, i2);
        int j5 = b + C1780e.m7380j(3) + C1780e.m7381l(a) + a;
        int a2 = m7318a(f, i3, z, i2, j2, j3);
        int j6 = j5 + C1780e.m7380j(5) + C1780e.m7381l(a2) + a2;
        if (bVar3 == null) {
            return j6;
        }
        int b2 = m7337b(bVar3);
        return j6 + C1780e.m7380j(6) + C1780e.m7381l(b2) + b2;
    }

    /* renamed from: a */
    private static int m7313a(C1770aj ajVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1776b bVar, C1776b bVar2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int a = m7312a(ajVar, thread, stackTraceElementArr, threadArr, list, i, bVar, bVar2);
        int j = C1780e.m7380j(1) + C1780e.m7381l(a) + a;
        boolean z = false;
        int i3 = j + 0;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                int a2 = m7320a((String) entry.getKey(), (String) entry.getValue());
                i3 += C1780e.m7380j(2) + C1780e.m7381l(a2) + a2;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance != 100) {
                z = true;
            }
            i3 += C1780e.m7368b(3, z);
        }
        return i3 + C1780e.m7372d(4, i2);
    }

    /* renamed from: a */
    private static int m7312a(C1770aj ajVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C1776b bVar, C1776b bVar2) {
        int a = m7321a(thread, stackTraceElementArr, 4, true);
        int j = C1780e.m7380j(1) + C1780e.m7381l(a) + a + 0;
        int length = threadArr.length;
        int i2 = j;
        for (int i3 = 0; i3 < length; i3++) {
            int a2 = m7321a(threadArr[i3], (StackTraceElement[]) list.get(i3), 0, false);
            i2 += C1780e.m7380j(1) + C1780e.m7381l(a2) + a2;
        }
        int a3 = m7311a(ajVar, 1, i);
        int j2 = i2 + C1780e.m7380j(2) + C1780e.m7381l(a3) + a3;
        int a4 = m7307a();
        int j3 = j2 + C1780e.m7380j(3) + C1780e.m7381l(a4) + a4;
        int a5 = m7315a(bVar, bVar2);
        return j3 + C1780e.m7380j(3) + C1780e.m7381l(a5) + a5;
    }

    /* renamed from: a */
    private static int m7320a(String str, String str2) {
        int b = C1780e.m7367b(1, C1776b.m7350a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + C1780e.m7367b(2, C1776b.m7350a(str2));
    }

    /* renamed from: a */
    private static int m7318a(Float f, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f != null) {
            i3 = 0 + C1780e.m7365b(1, f.floatValue());
        }
        return i3 + C1780e.m7377f(2, i) + C1780e.m7368b(3, z) + C1780e.m7372d(4, i2) + C1780e.m7366b(5, j) + C1780e.m7366b(6, j2);
    }

    /* renamed from: b */
    private static int m7337b(C1776b bVar) {
        return C1780e.m7367b(1, bVar);
    }

    /* renamed from: a */
    private static int m7311a(C1770aj ajVar, int i, int i2) {
        int i3 = 0;
        int b = C1780e.m7367b(1, C1776b.m7350a(ajVar.f5534b)) + 0;
        String str = ajVar.f5533a;
        if (str != null) {
            b += C1780e.m7367b(3, C1776b.m7350a(str));
        }
        int i4 = b;
        for (StackTraceElement a : ajVar.f5535c) {
            int a2 = m7319a(a, true);
            i4 += C1780e.m7380j(4) + C1780e.m7381l(a2) + a2;
        }
        C1770aj ajVar2 = ajVar.f5536d;
        if (ajVar2 == null) {
            return i4;
        }
        if (i < i2) {
            int a3 = m7311a(ajVar2, i + 1, i2);
            return i4 + C1780e.m7380j(6) + C1780e.m7381l(a3) + a3;
        }
        while (ajVar2 != null) {
            ajVar2 = ajVar2.f5536d;
            i3++;
        }
        return i4 + C1780e.m7372d(7, i3);
    }

    /* renamed from: a */
    private static int m7307a() {
        return C1780e.m7367b(1, f5528a) + 0 + C1780e.m7367b(2, f5528a) + C1780e.m7366b(3, 0);
    }

    /* renamed from: a */
    private static int m7319a(StackTraceElement stackTraceElement, boolean z) {
        int i;
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            i = C1780e.m7366b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            i = C1780e.m7366b(1, 0) + 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName());
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        int b = i + C1780e.m7367b(2, C1776b.m7350a(sb.toString()));
        if (stackTraceElement.getFileName() != null) {
            b += C1780e.m7367b(3, C1776b.m7350a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            b += C1780e.m7366b(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 2;
        }
        return b + C1780e.m7372d(5, i2);
    }

    /* renamed from: a */
    private static int m7321a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int b = C1780e.m7367b(1, C1776b.m7350a(thread.getName())) + C1780e.m7372d(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = m7319a(a, z);
            b += C1780e.m7380j(3) + C1780e.m7381l(a2) + a2;
        }
        return b;
    }

    /* renamed from: a */
    private static C1776b m7322a(String str) {
        if (str == null) {
            return null;
        }
        return C1776b.m7350a(str);
    }
}
