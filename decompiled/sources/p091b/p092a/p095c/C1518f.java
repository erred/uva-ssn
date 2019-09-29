package p091b.p092a.p095c;

import com.google.api.client.http.HttpMethods;

/* renamed from: b.a.c.f */
/* compiled from: HttpMethod */
public final class C1518f {
    /* renamed from: a */
    public static boolean m6128a(String str) {
        return str.equals(HttpMethods.POST) || str.equals(HttpMethods.PATCH) || str.equals(HttpMethods.PUT) || str.equals(HttpMethods.DELETE) || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m6129b(String str) {
        return str.equals(HttpMethods.POST) || str.equals(HttpMethods.PUT) || str.equals(HttpMethods.PATCH) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: c */
    public static boolean m6130c(String str) {
        return !str.equals(HttpMethods.GET) && !str.equals(HttpMethods.HEAD);
    }

    /* renamed from: d */
    public static boolean m6131d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m6132e(String str) {
        return !str.equals("PROPFIND");
    }
}
