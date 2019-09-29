package p091b.p092a.p099g;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p091b.C1654y;
import p091b.p092a.C1508c;

/* renamed from: b.a.g.d */
/* compiled from: JdkWithJettyBootPlatform */
class C1580d extends C1583f {

    /* renamed from: a */
    private final Method f4833a;

    /* renamed from: b */
    private final Method f4834b;

    /* renamed from: c */
    private final Method f4835c;

    /* renamed from: d */
    private final Class<?> f4836d;

    /* renamed from: e */
    private final Class<?> f4837e;

    /* renamed from: b.a.g.d$a */
    /* compiled from: JdkWithJettyBootPlatform */
    private static class C1581a implements InvocationHandler {

        /* renamed from: a */
        boolean f4838a;

        /* renamed from: b */
        String f4839b;

        /* renamed from: c */
        private final List<String> f4840c;

        C1581a(List<String> list) {
            this.f4840c = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<String> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C1508c.f4561b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f4838a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f4840c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f4840c.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f4839b = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f4840c.get(0);
                    this.f4839b = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f4839b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    C1580d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f4833a = method;
        this.f4834b = method2;
        this.f4835c = method3;
        this.f4836d = cls;
        this.f4837e = cls2;
    }

    /* renamed from: a */
    public void mo6426a(SSLSocket sSLSocket, String str, List<C1654y> list) {
        List a = m6440a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(C1583f.class.getClassLoader(), new Class[]{this.f4836d, this.f4837e}, new C1581a(a));
            this.f4833a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1508c.m6072a("unable to set alpn", (Exception) e);
        }
    }

    /* renamed from: b */
    public void mo6438b(SSLSocket sSLSocket) {
        try {
            this.f4835c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1508c.m6072a("unable to remove alpn", (Exception) e);
        }
    }

    /* renamed from: a */
    public String mo6422a(SSLSocket sSLSocket) {
        try {
            Object[] objArr = {sSLSocket};
            String str = null;
            C1581a aVar = (C1581a) Proxy.getInvocationHandler(this.f4834b.invoke(null, objArr));
            if (aVar.f4838a || aVar.f4839b != null) {
                if (!aVar.f4838a) {
                    str = aVar.f4839b;
                }
                return str;
            }
            C1583f.m6443c().mo6423a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw C1508c.m6072a("unable to get selected protocol", (Exception) e);
        }
    }

    /* renamed from: b */
    public static C1583f m6429b() {
        String str = "org.eclipse.jetty.alpn.ALPN";
        try {
            Class cls = Class.forName(str);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("$Provider");
            Class cls2 = Class.forName(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("$ClientProvider");
            Class cls3 = Class.forName(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("$ServerProvider");
            Class cls4 = Class.forName(sb3.toString());
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            Method method2 = method;
            C1580d dVar = new C1580d(method2, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod(ProductAction.ACTION_REMOVE, new Class[]{SSLSocket.class}), cls3, cls4);
            return dVar;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
