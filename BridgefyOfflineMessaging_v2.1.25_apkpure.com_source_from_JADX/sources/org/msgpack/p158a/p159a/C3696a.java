package org.msgpack.p158a.p159a;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: org.msgpack.a.a.a */
/* compiled from: ExtensionTypeCustomDeserializers */
public class C3696a {

    /* renamed from: a */
    private final ObjectMapper f9776a;

    /* renamed from: b */
    private Map<Byte, C3697a> f9777b;

    /* renamed from: org.msgpack.a.a.a$a */
    /* compiled from: ExtensionTypeCustomDeserializers */
    public interface C3697a {
        /* renamed from: a */
        Object mo31904a(byte[] bArr) throws IOException;
    }

    public C3696a() {
        this.f9777b = new ConcurrentHashMap();
        this.f9776a = new ObjectMapper((JsonFactory) new C3700c().mo31910a(false));
    }

    public C3696a(C3696a aVar) {
        this();
        this.f9777b.putAll(aVar.f9777b);
    }

    /* renamed from: a */
    public C3697a mo31903a(byte b) {
        return (C3697a) this.f9777b.get(Byte.valueOf(b));
    }
}
