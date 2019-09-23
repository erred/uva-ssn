package p000a.p001a.p002a.p003a.p004a.p010e;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

/* renamed from: a.a.a.a.a.e.d */
/* compiled from: HttpRequest */
public class C0090d {

    /* renamed from: b */
    private static final String[] f185b = new String[0];

    /* renamed from: c */
    private static C0093b f186c = C0093b.f202a;

    /* renamed from: a */
    public final URL f187a;

    /* renamed from: d */
    private HttpURLConnection f188d = null;

    /* renamed from: e */
    private final String f189e;

    /* renamed from: f */
    private C0097e f190f;

    /* renamed from: g */
    private boolean f191g;

    /* renamed from: h */
    private boolean f192h = true;

    /* renamed from: i */
    private boolean f193i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f194j = 8192;

    /* renamed from: k */
    private String f195k;

    /* renamed from: l */
    private int f196l;

    /* renamed from: a.a.a.a.a.e.d$a */
    /* compiled from: HttpRequest */
    protected static abstract class C0092a<V> extends C0096d<V> {

        /* renamed from: a */
        private final Closeable f200a;

        /* renamed from: b */
        private final boolean f201b;

        protected C0092a(Closeable closeable, boolean z) {
            this.f200a = closeable;
            this.f201b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo227c() throws IOException {
            if (this.f200a instanceof Flushable) {
                ((Flushable) this.f200a).flush();
            }
            if (this.f201b) {
                try {
                    this.f200a.close();
                } catch (IOException unused) {
                }
            } else {
                this.f200a.close();
            }
        }
    }

    /* renamed from: a.a.a.a.a.e.d$b */
    /* compiled from: HttpRequest */
    public interface C0093b {

        /* renamed from: a */
        public static final C0093b f202a = new C0093b() {
            /* renamed from: a */
            public HttpURLConnection mo228a(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }

            /* renamed from: a */
            public HttpURLConnection mo229a(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        /* renamed from: a */
        HttpURLConnection mo228a(URL url) throws IOException;

        /* renamed from: a */
        HttpURLConnection mo229a(URL url, Proxy proxy) throws IOException;
    }

    /* renamed from: a.a.a.a.a.e.d$c */
    /* compiled from: HttpRequest */
    public static class C0095c extends RuntimeException {
        protected C0095c(IOException iOException) {
            super(iOException);
        }

        /* renamed from: a */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* renamed from: a.a.a.a.a.e.d$d */
    /* compiled from: HttpRequest */
    protected static abstract class C0096d<V> implements Callable<V> {
        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract V mo226b() throws C0095c, IOException;

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public abstract void mo227c() throws IOException;

        protected C0096d() {
        }

        public V call() throws C0095c {
            boolean z = true;
            try {
                V b = mo226b();
                try {
                    mo227c();
                    return b;
                } catch (IOException e) {
                    throw new C0095c(e);
                }
            } catch (C0095c e2) {
                throw e2;
            } catch (IOException e3) {
                throw new C0095c(e3);
            } catch (Throwable th) {
                th = th;
                mo227c();
                throw th;
            }
        }
    }

    /* renamed from: a.a.a.a.a.e.d$e */
    /* compiled from: HttpRequest */
    public static class C0097e extends BufferedOutputStream {

        /* renamed from: a */
        private final CharsetEncoder f203a;

        public C0097e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f203a = Charset.forName(C0090d.m299f(str)).newEncoder();
        }

        /* renamed from: a */
        public C0097e mo233a(String str) throws IOException {
            ByteBuffer encode = this.f203a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static String m299f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    /* renamed from: a */
    private static StringBuilder m291a(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    /* renamed from: b */
    private static StringBuilder m294b(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    /* renamed from: a */
    public static String m289a(CharSequence charSequence) throws C0095c {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(host);
                sb.append(':');
                sb.append(Integer.toString(port));
                host = sb.toString();
            }
            try {
                URI uri = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null);
                String aSCIIString = uri.toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0) {
                    return aSCIIString;
                }
                int i = indexOf + 1;
                if (i >= aSCIIString.length()) {
                    return aSCIIString;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aSCIIString.substring(0, i));
                sb2.append(aSCIIString.substring(i).replace("+", "%2B"));
                return sb2.toString();
            } catch (URISyntaxException e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new C0095c(iOException);
            }
        } catch (IOException e2) {
            throw new C0095c(e2);
        }
    }

    /* renamed from: a */
    public static String m290a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        m291a(charSequence2, sb);
        m294b(charSequence2, sb);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        sb.append(entry.getKey().toString());
        sb.append('=');
        Object value = entry.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Entry entry2 = (Entry) it.next();
            sb.append(entry2.getKey().toString());
            sb.append('=');
            Object value2 = entry2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static C0090d m292b(CharSequence charSequence) throws C0095c {
        return new C0090d(charSequence, HttpMethods.GET);
    }

    /* renamed from: a */
    public static C0090d m288a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a = m290a(charSequence, map);
        if (z) {
            a = m289a((CharSequence) a);
        }
        return m292b((CharSequence) a);
    }

    /* renamed from: c */
    public static C0090d m295c(CharSequence charSequence) throws C0095c {
        return new C0090d(charSequence, HttpMethods.POST);
    }

    /* renamed from: b */
    public static C0090d m293b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a = m290a(charSequence, map);
        if (z) {
            a = m289a((CharSequence) a);
        }
        return m295c((CharSequence) a);
    }

    /* renamed from: d */
    public static C0090d m296d(CharSequence charSequence) throws C0095c {
        return new C0090d(charSequence, HttpMethods.PUT);
    }

    /* renamed from: e */
    public static C0090d m297e(CharSequence charSequence) throws C0095c {
        return new C0090d(charSequence, HttpMethods.DELETE);
    }

    public C0090d(CharSequence charSequence, String str) throws C0095c {
        try {
            this.f187a = new URL(charSequence.toString());
            this.f189e = str;
        } catch (MalformedURLException e) {
            throw new C0095c(e);
        }
    }

    /* renamed from: q */
    private Proxy m300q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f195k, this.f196l));
    }

    /* renamed from: r */
    private HttpURLConnection m301r() {
        HttpURLConnection httpURLConnection;
        try {
            if (this.f195k != null) {
                httpURLConnection = f186c.mo229a(this.f187a, m300q());
            } else {
                httpURLConnection = f186c.mo228a(this.f187a);
            }
            httpURLConnection.setRequestMethod(this.f189e);
            return httpURLConnection;
        } catch (IOException e) {
            throw new C0095c(e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo223p());
        sb.append(' ');
        sb.append(mo222o());
        return sb.toString();
    }

    /* renamed from: a */
    public HttpURLConnection mo198a() {
        if (this.f188d == null) {
            this.f188d = m301r();
        }
        return this.f188d;
    }

    /* renamed from: b */
    public int mo199b() throws C0095c {
        try {
            mo218k();
            return mo198a().getResponseCode();
        } catch (IOException e) {
            throw new C0095c(e);
        }
    }

    /* renamed from: c */
    public boolean mo205c() throws C0095c {
        return 200 == mo199b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public ByteArrayOutputStream mo208d() {
        int j = mo217j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    /* renamed from: a */
    public String mo197a(String str) throws C0095c {
        ByteArrayOutputStream d = mo208d();
        try {
            mo187a((InputStream) mo213f(), (OutputStream) d);
            return d.toString(m299f(str));
        } catch (IOException e) {
            throw new C0095c(e);
        }
    }

    /* renamed from: e */
    public String mo210e() throws C0095c {
        return mo197a(mo215h());
    }

    /* renamed from: f */
    public BufferedInputStream mo213f() throws C0095c {
        return new BufferedInputStream(mo214g(), this.f194j);
    }

    /* renamed from: g */
    public InputStream mo214g() throws C0095c {
        InputStream inputStream;
        if (mo199b() < 400) {
            try {
                inputStream = mo198a().getInputStream();
            } catch (IOException e) {
                throw new C0095c(e);
            }
        } else {
            inputStream = mo198a().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = mo198a().getInputStream();
                } catch (IOException e2) {
                    throw new C0095c(e2);
                }
            }
        }
        if (!this.f193i || !"gzip".equals(mo216i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e3) {
            throw new C0095c(e3);
        }
    }

    /* renamed from: a */
    public C0090d mo186a(int i) {
        mo198a().setConnectTimeout(i);
        return this;
    }

    /* renamed from: a */
    public C0090d mo189a(String str, String str2) {
        mo198a().setRequestProperty(str, str2);
        return this;
    }

    /* renamed from: a */
    public C0090d mo195a(Entry<String, String> entry) {
        return mo189a((String) entry.getKey(), (String) entry.getValue());
    }

    /* renamed from: b */
    public String mo201b(String str) throws C0095c {
        mo219l();
        return mo198a().getHeaderField(str);
    }

    /* renamed from: c */
    public int mo203c(String str) throws C0095c {
        return mo185a(str, -1);
    }

    /* renamed from: a */
    public int mo185a(String str, int i) throws C0095c {
        mo219l();
        return mo198a().getHeaderFieldInt(str, i);
    }

    /* renamed from: b */
    public String mo202b(String str, String str2) {
        return mo204c(mo201b(str), str2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[SYNTHETIC] */
    /* renamed from: c */
    protected java.lang.String mo204c(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0071
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000a
            goto L_0x0071
        L_0x000a:
            int r1 = r9.length()
            r2 = 59
            int r3 = r9.indexOf(r2)
            r4 = 1
            int r3 = r3 + r4
            if (r3 == 0) goto L_0x0070
            if (r3 != r1) goto L_0x001b
            goto L_0x0070
        L_0x001b:
            int r5 = r9.indexOf(r2, r3)
            r6 = -1
            if (r5 != r6) goto L_0x0023
        L_0x0022:
            r5 = r1
        L_0x0023:
            if (r3 >= r5) goto L_0x006f
            r7 = 61
            int r7 = r9.indexOf(r7, r3)
            if (r7 == r6) goto L_0x0066
            if (r7 >= r5) goto L_0x0066
            java.lang.String r3 = r9.substring(r3, r7)
            java.lang.String r3 = r3.trim()
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x0066
            int r7 = r7 + 1
            java.lang.String r3 = r9.substring(r7, r5)
            java.lang.String r3 = r3.trim()
            int r7 = r3.length()
            if (r7 == 0) goto L_0x0066
            r9 = 2
            if (r7 <= r9) goto L_0x0065
            r9 = 0
            char r9 = r3.charAt(r9)
            r10 = 34
            if (r10 != r9) goto L_0x0065
            int r7 = r7 - r4
            char r9 = r3.charAt(r7)
            if (r10 != r9) goto L_0x0065
            java.lang.String r9 = r3.substring(r4, r7)
            return r9
        L_0x0065:
            return r3
        L_0x0066:
            int r3 = r5 + 1
            int r5 = r9.indexOf(r2, r3)
            if (r5 != r6) goto L_0x0023
            goto L_0x0022
        L_0x006f:
            return r0
        L_0x0070:
            return r0
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p010e.C0090d.mo204c(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: h */
    public String mo215h() {
        return mo202b(HttpHeaders.CONTENT_TYPE, "charset");
    }

    /* renamed from: a */
    public C0090d mo196a(boolean z) {
        mo198a().setUseCaches(z);
        return this;
    }

    /* renamed from: i */
    public String mo216i() {
        return mo201b(HttpHeaders.CONTENT_ENCODING);
    }

    /* renamed from: d */
    public C0090d mo206d(String str) {
        return mo207d(str, null);
    }

    /* renamed from: d */
    public C0090d mo207d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return mo189a(HttpHeaders.CONTENT_TYPE, str);
        }
        String str3 = HttpHeaders.CONTENT_TYPE;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("; charset=");
        sb.append(str2);
        return mo189a(str3, sb.toString());
    }

    /* renamed from: j */
    public int mo217j() {
        return mo203c(HttpHeaders.CONTENT_LENGTH);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0090d mo187a(InputStream inputStream, OutputStream outputStream) throws IOException {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        C00911 r0 = new C0092a<C0090d>(inputStream, this.f192h) {
            /* renamed from: a */
            public C0090d mo226b() throws IOException {
                byte[] bArr = new byte[C0090d.this.f194j];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return C0090d.this;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        };
        return (C0090d) r0.call();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public C0090d mo218k() throws IOException {
        if (this.f190f == null) {
            return this;
        }
        if (this.f191g) {
            this.f190f.mo233a("\r\n--00content0boundary00--\r\n");
        }
        if (this.f192h) {
            try {
                this.f190f.close();
            } catch (IOException unused) {
            }
        } else {
            this.f190f.close();
        }
        this.f190f = null;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C0090d mo219l() throws C0095c {
        try {
            return mo218k();
        } catch (IOException e) {
            throw new C0095c(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C0090d mo220m() throws IOException {
        if (this.f190f != null) {
            return this;
        }
        mo198a().setDoOutput(true);
        this.f190f = new C0097e(mo198a().getOutputStream(), mo204c(mo198a().getRequestProperty(HttpHeaders.CONTENT_TYPE), "charset"), this.f194j);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public C0090d mo221n() throws IOException {
        if (!this.f191g) {
            this.f191g = true;
            mo206d("multipart/form-data; boundary=00content0boundary00").mo220m();
            this.f190f.mo233a("--00content0boundary00\r\n");
        } else {
            this.f190f.mo233a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0090d mo191a(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        mo212f(HttpHeaders.CONTENT_DISPOSITION, sb.toString());
        if (str3 != null) {
            mo212f(HttpHeaders.CONTENT_TYPE, str3);
        }
        return mo211f((CharSequence) "\r\n");
    }

    /* renamed from: e */
    public C0090d mo209e(String str, String str2) {
        return mo200b(str, (String) null, str2);
    }

    /* renamed from: b */
    public C0090d mo200b(String str, String str2, String str3) throws C0095c {
        return mo194a(str, str2, (String) null, str3);
    }

    /* renamed from: a */
    public C0090d mo194a(String str, String str2, String str3, String str4) throws C0095c {
        try {
            mo221n();
            mo191a(str, str2, str3);
            this.f190f.mo233a(str4);
            return this;
        } catch (IOException e) {
            throw new C0095c(e);
        }
    }

    /* renamed from: a */
    public C0090d mo188a(String str, Number number) throws C0095c {
        return mo190a(str, (String) null, number);
    }

    /* renamed from: a */
    public C0090d mo190a(String str, String str2, Number number) throws C0095c {
        return mo200b(str, str2, number != null ? number.toString() : null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0024 A[SYNTHETIC, Splitter:B:19:0x0024] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p000a.p001a.p002a.p003a.p004a.p010e.C0090d mo192a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) throws p000a.p001a.p002a.p003a.p004a.p010e.C0090d.C0095c {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x001b }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x001b }
            r2.<init>(r7)     // Catch:{ IOException -> 0x001b }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001b }
            a.a.a.a.a.e.d r4 = r3.mo193a(r4, r5, r6, r1)     // Catch:{ IOException -> 0x0016, all -> 0x0013 }
            r1.close()     // Catch:{ IOException -> 0x0012 }
        L_0x0012:
            return r4
        L_0x0013:
            r4 = move-exception
            r0 = r1
            goto L_0x0022
        L_0x0016:
            r4 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x0019:
            r4 = move-exception
            goto L_0x0022
        L_0x001b:
            r4 = move-exception
        L_0x001c:
            a.a.a.a.a.e.d$c r5 = new a.a.a.a.a.e.d$c     // Catch:{ all -> 0x0019 }
            r5.<init>(r4)     // Catch:{ all -> 0x0019 }
            throw r5     // Catch:{ all -> 0x0019 }
        L_0x0022:
            if (r0 == 0) goto L_0x0027
            r0.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p010e.C0090d.mo192a(java.lang.String, java.lang.String, java.lang.String, java.io.File):a.a.a.a.a.e.d");
    }

    /* renamed from: a */
    public C0090d mo193a(String str, String str2, String str3, InputStream inputStream) throws C0095c {
        try {
            mo221n();
            mo191a(str, str2, str3);
            mo187a(inputStream, (OutputStream) this.f190f);
            return this;
        } catch (IOException e) {
            throw new C0095c(e);
        }
    }

    /* renamed from: f */
    public C0090d mo212f(String str, String str2) throws C0095c {
        return mo211f((CharSequence) str).mo211f((CharSequence) ": ").mo211f((CharSequence) str2).mo211f((CharSequence) "\r\n");
    }

    /* renamed from: f */
    public C0090d mo211f(CharSequence charSequence) throws C0095c {
        try {
            mo220m();
            this.f190f.mo233a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new C0095c(e);
        }
    }

    /* renamed from: o */
    public URL mo222o() {
        return mo198a().getURL();
    }

    /* renamed from: p */
    public String mo223p() {
        return mo198a().getRequestMethod();
    }
}
