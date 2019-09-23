package p091b;

import java.io.IOException;

/* renamed from: b.y */
/* compiled from: Protocol */
public enum C1654y {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    QUIC("quic");
    

    /* renamed from: f */
    private final String f5267f;

    private C1654y(String str) {
        this.f5267f = str;
    }

    /* renamed from: a */
    public static C1654y m6848a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f5267f)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f5267f)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f5267f)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f5267f)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.f5267f)) {
            return QUIC;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected protocol: ");
        sb.append(str);
        throw new IOException(sb.toString());
    }

    public String toString() {
        return this.f5267f;
    }
}
