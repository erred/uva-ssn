package org.msgpack.p158a.p159a;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

@JsonSerialize(using = C3699a.class)
/* renamed from: org.msgpack.a.a.b */
/* compiled from: MessagePackExtensionType */
public class C3698b {

    /* renamed from: a */
    private final byte f9778a;

    /* renamed from: b */
    private final byte[] f9779b;

    /* renamed from: org.msgpack.a.a.b$a */
    /* compiled from: MessagePackExtensionType */
    public static class C3699a extends JsonSerializer<C3698b> {
        /* renamed from: a */
        public void serialize(C3698b bVar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            if (jsonGenerator instanceof C3701d) {
                ((C3701d) jsonGenerator).mo31912a(bVar);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("'gen' is expected to be MessagePackGenerator but it's ");
            sb.append(jsonGenerator.getClass());
            throw new IllegalStateException(sb.toString());
        }
    }

    public C3698b(byte b, byte[] bArr) {
        this.f9778a = b;
        this.f9779b = bArr;
    }

    /* renamed from: a */
    public byte mo31905a() {
        return this.f9778a;
    }

    /* renamed from: b */
    public byte[] mo31906b() {
        return this.f9779b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3698b)) {
            return false;
        }
        C3698b bVar = (C3698b) obj;
        if (this.f9778a != bVar.f9778a) {
            return false;
        }
        return Arrays.equals(this.f9779b, bVar.f9779b);
    }

    public int hashCode() {
        return (this.f9778a * Ascii.f6737US) + Arrays.hashCode(this.f9779b);
    }
}
