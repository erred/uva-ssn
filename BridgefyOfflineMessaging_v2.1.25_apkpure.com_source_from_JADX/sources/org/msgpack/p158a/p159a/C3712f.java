package org.msgpack.p158a.p159a;

import com.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: org.msgpack.a.a.f */
/* compiled from: MessagePackSerializedString */
public class C3712f implements SerializableString {

    /* renamed from: a */
    private static final Charset f9826a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final Object f9827b;

    public int appendQuoted(char[] cArr, int i) {
        return 0;
    }

    public int appendQuotedUTF8(byte[] bArr, int i) {
        return 0;
    }

    public int appendUnquoted(char[] cArr, int i) {
        return 0;
    }

    public int appendUnquotedUTF8(byte[] bArr, int i) {
        return 0;
    }

    public int putQuotedUTF8(ByteBuffer byteBuffer) throws IOException {
        return 0;
    }

    public int putUnquotedUTF8(ByteBuffer byteBuffer) throws IOException {
        return 0;
    }

    public int writeQuotedUTF8(OutputStream outputStream) throws IOException {
        return 0;
    }

    public int writeUnquotedUTF8(OutputStream outputStream) throws IOException {
        return 0;
    }

    public String getValue() {
        return this.f9827b.toString();
    }

    public int charLength() {
        return getValue().length();
    }

    public char[] asQuotedChars() {
        return getValue().toCharArray();
    }

    public byte[] asUnquotedUTF8() {
        return getValue().getBytes(f9826a);
    }

    public byte[] asQuotedUTF8() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(getValue());
        sb.append("\"");
        return sb.toString().getBytes(f9826a);
    }

    /* renamed from: a */
    public Object mo31920a() {
        return this.f9827b;
    }
}
