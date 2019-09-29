package p091b.p092a.p099g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import p091b.C1654y;
import p091b.p092a.C1508c;

/* renamed from: b.a.g.c */
/* compiled from: Jdk9Platform */
final class C1579c extends C1583f {

    /* renamed from: a */
    final Method f4831a;

    /* renamed from: b */
    final Method f4832b;

    C1579c(Method method, Method method2) {
        this.f4831a = method;
        this.f4832b = method2;
    }

    /* renamed from: a */
    public void mo6426a(SSLSocket sSLSocket, String str, List<C1654y> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a = m6440a(list);
            this.f4831a.invoke(sSLParameters, new Object[]{a.toArray(new String[a.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1508c.m6072a("unable to set ssl parameters", (Exception) e);
        }
    }

    /* renamed from: a */
    public String mo6422a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f4832b.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1508c.m6072a("unable to get selected protocols", (Exception) e);
        }
    }

    /* renamed from: b */
    public static C1579c m6426b() {
        try {
            return new C1579c(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
