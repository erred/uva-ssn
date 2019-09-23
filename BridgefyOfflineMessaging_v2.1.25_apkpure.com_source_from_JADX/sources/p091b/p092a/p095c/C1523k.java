package p091b.p092a.p095c;

import java.io.IOException;
import java.net.ProtocolException;
import p091b.C1654y;

/* renamed from: b.a.c.k */
/* compiled from: StatusLine */
public final class C1523k {

    /* renamed from: a */
    public final C1654y f4607a;

    /* renamed from: b */
    public final int f4608b;

    /* renamed from: c */
    public final String f4609c;

    public C1523k(C1654y yVar, int i, String str) {
        this.f4607a = yVar;
        this.f4608b = i;
        this.f4609c = str;
    }

    /* renamed from: a */
    public static C1523k m6160a(String str) throws IOException {
        C1654y yVar;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected status line: ");
                sb.append(str);
                throw new ProtocolException(sb.toString());
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                yVar = C1654y.HTTP_1_0;
            } else if (charAt == 1) {
                yVar = C1654y.HTTP_1_1;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected status line: ");
                sb2.append(str);
                throw new ProtocolException(sb2.toString());
            }
        } else if (str.startsWith("ICY ")) {
            yVar = C1654y.HTTP_1_0;
            i = 4;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected status line: ");
            sb3.append(str);
            throw new ProtocolException(sb3.toString());
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                String str2 = "";
                if (str.length() > i2) {
                    if (str.charAt(i2) == ' ') {
                        str2 = str.substring(i + 4);
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Unexpected status line: ");
                        sb4.append(str);
                        throw new ProtocolException(sb4.toString());
                    }
                }
                return new C1523k(yVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Unexpected status line: ");
                sb5.append(str);
                throw new ProtocolException(sb5.toString());
            }
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Unexpected status line: ");
            sb6.append(str);
            throw new ProtocolException(sb6.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4607a == C1654y.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f4608b);
        if (this.f4609c != null) {
            sb.append(' ');
            sb.append(this.f4609c);
        }
        return sb.toString();
    }
}
