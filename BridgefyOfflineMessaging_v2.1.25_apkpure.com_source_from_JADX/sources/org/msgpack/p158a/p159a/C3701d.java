package org.msgpack.p158a.p159a;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.p116io.SerializedString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.msgpack.core.MessagePack.PackerConfig;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.core.buffer.OutputStreamBufferOutput;

/* renamed from: org.msgpack.a.a.d */
/* compiled from: MessagePackGenerator */
public class C3701d extends GeneratorBase {

    /* renamed from: a */
    private static final Charset f9784a = Charset.forName("UTF-8");

    /* renamed from: c */
    private static ThreadLocal<OutputStreamBufferOutput> f9785c = new ThreadLocal<>();

    /* renamed from: b */
    private final MessagePacker f9786b;

    /* renamed from: d */
    private final OutputStream f9787d;

    /* renamed from: e */
    private final PackerConfig f9788e;

    /* renamed from: f */
    private LinkedList<C3703a> f9789f;

    /* renamed from: g */
    private C3703a f9790g;

    /* renamed from: org.msgpack.a.a.d$a */
    /* compiled from: MessagePackGenerator */
    private static abstract class C3703a {

        /* renamed from: a */
        protected List<Object> f9791a;

        /* renamed from: b */
        protected List<Object> f9792b;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract List<Object> mo31913a();

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract void mo31914a(Object obj);

        private C3703a() {
            this.f9791a = new ArrayList();
            this.f9792b = new ArrayList();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo31916b(Object obj) {
            this.f9792b.add(obj);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public List<Object> mo31915b() {
            return this.f9792b;
        }
    }

    /* renamed from: org.msgpack.a.a.d$b */
    /* compiled from: MessagePackGenerator */
    private static class C3704b extends C3703a {
        private C3704b() {
            super();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo31914a(Object obj) {
            throw new IllegalStateException("This method shouldn't be called");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public List<Object> mo31913a() {
            throw new IllegalStateException("This method shouldn't be called");
        }
    }

    /* renamed from: org.msgpack.a.a.d$c */
    /* compiled from: MessagePackGenerator */
    private static class C3705c extends C3703a {
        private C3705c() {
            super();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo31914a(Object obj) {
            this.f9791a.add(obj);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public List<Object> mo31913a() {
            return this.f9791a;
        }
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() {
    }

    public C3701d(int i, ObjectCodec objectCodec, OutputStream outputStream, PackerConfig packerConfig, boolean z) throws IOException {
        OutputStreamBufferOutput outputStreamBufferOutput;
        super(i, objectCodec);
        this.f9787d = outputStream;
        if (z) {
            outputStreamBufferOutput = (OutputStreamBufferOutput) f9785c.get();
            if (outputStreamBufferOutput == null) {
                outputStreamBufferOutput = new OutputStreamBufferOutput(outputStream);
                f9785c.set(outputStreamBufferOutput);
            } else {
                outputStreamBufferOutput.reset(outputStream);
            }
        } else {
            outputStreamBufferOutput = new OutputStreamBufferOutput(outputStream);
        }
        this.f9786b = packerConfig.newPacker((MessageBufferOutput) outputStreamBufferOutput);
        this.f9788e = packerConfig;
        this.f9789f = new LinkedList<>();
    }

    public void writeStartArray() throws IOException, JsonGenerationException {
        this._writeContext = this._writeContext.createChildArrayContext();
        this.f9789f.push(new C3704b());
    }

    public void writeEndArray() throws IOException, JsonGenerationException {
        if (!this._writeContext.inArray()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Current context not an array but ");
            sb.append(this._writeContext.getTypeDesc());
            _reportError(sb.toString());
        }
        m11002d();
        this._writeContext = this._writeContext.getParent();
        m11003e();
    }

    public void writeStartObject() throws IOException, JsonGenerationException {
        this._writeContext = this._writeContext.createChildObjectContext();
        this.f9789f.push(new C3705c());
    }

    public void writeEndObject() throws IOException, JsonGenerationException {
        if (!this._writeContext.inObject()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Current context not an object but ");
            sb.append(this._writeContext.getTypeDesc());
            _reportError(sb.toString());
        }
        C3705c c = m11000c();
        if (c.mo31913a().size() == c.mo31915b().size()) {
            this._writeContext = this._writeContext.getParent();
            m11003e();
            return;
        }
        throw new IllegalStateException(String.format("objectKeys.size() and objectValues.size() is not same: depth=%d, key=%d, value=%d", new Object[]{Integer.valueOf(this.f9789f.size()), Integer.valueOf(c.mo31913a().size()), Integer.valueOf(c.mo31915b().size())}));
    }

    /* renamed from: a */
    private void m10994a(Object obj) throws IOException {
        MessagePacker f = m11004f();
        if (obj == null) {
            f.packNil();
        } else if (obj instanceof Integer) {
            f.packInt(((Integer) obj).intValue());
        } else if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            int remaining = byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                f.packBinaryHeader(remaining);
                f.writePayload(byteBuffer.array(), byteBuffer.arrayOffset(), remaining);
                return;
            }
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            f.packBinaryHeader(remaining);
            f.addPayload(bArr);
        } else if (obj instanceof String) {
            f.packString((String) obj);
        } else if (obj instanceof Float) {
            f.packFloat(((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            f.packLong(((Long) obj).longValue());
        } else if (obj instanceof C3705c) {
            m10997a((C3705c) obj);
        } else if (obj instanceof C3704b) {
            m10996a((C3704b) obj);
        } else if (obj instanceof Double) {
            f.packDouble(((Double) obj).doubleValue());
        } else if (obj instanceof BigInteger) {
            f.packBigInteger((BigInteger) obj);
        } else if (obj instanceof BigDecimal) {
            m10995a((BigDecimal) obj);
        } else if (obj instanceof Boolean) {
            f.packBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof C3698b) {
            C3698b bVar = (C3698b) obj;
            byte[] b = bVar.mo31906b();
            f.packExtensionTypeHeader(bVar.mo31905a(), b.length);
            f.writePayload(b);
        } else {
            f.flush();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C3701d dVar = new C3701d(getFeatureMask(), getCodec(), byteArrayOutputStream, this.f9788e, false);
            getCodec().writeValue(dVar, obj);
            this.f9787d.write(byteArrayOutputStream.toByteArray());
        }
    }

    /* renamed from: a */
    private void m10995a(BigDecimal bigDecimal) throws IOException {
        MessagePacker f = m11004f();
        boolean z = true;
        try {
            f.packBigInteger(bigDecimal.toBigIntegerExact());
            z = false;
        } catch (ArithmeticException | IllegalArgumentException unused) {
        }
        if (z) {
            double doubleValue = bigDecimal.doubleValue();
            if (bigDecimal.stripTrailingZeros().toEngineeringString().equals(BigDecimal.valueOf(doubleValue).toEngineeringString())) {
                f.packDouble(doubleValue);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("MessagePack cannot serialize a BigDecimal that can't be represented as double. ");
            sb.append(bigDecimal);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private void m10997a(C3705c cVar) throws IOException {
        List a = cVar.mo31913a();
        List b = cVar.mo31915b();
        m11004f().packMapHeader(a.size());
        for (int i = 0; i < a.size(); i++) {
            m10994a(a.get(i));
            m10994a(b.get(i));
        }
    }

    /* renamed from: a */
    private void m10996a(C3704b bVar) throws IOException {
        List b = bVar.mo31915b();
        m11004f().packArrayHeader(b.size());
        for (int i = 0; i < b.size(); i++) {
            m10994a(b.get(i));
        }
    }

    public void writeFieldName(String str) throws IOException, JsonGenerationException {
        m10999b(str);
    }

    public void writeFieldName(SerializableString serializableString) throws IOException {
        if (serializableString instanceof C3712f) {
            m10999b(((C3712f) serializableString).mo31920a());
        } else if (serializableString instanceof SerializedString) {
            m10999b(serializableString.getValue());
        } else {
            System.out.println(serializableString.getClass());
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported key: ");
            sb.append(serializableString);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void writeString(String str) throws IOException, JsonGenerationException {
        m11001c(str);
    }

    public void writeString(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        m11001c(new String(cArr, i, i2));
    }

    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        m11001c(new String(bArr, i, i2, f9784a));
    }

    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        m11001c(new String(bArr, i, i2, f9784a));
    }

    public void writeRaw(String str) throws IOException, JsonGenerationException {
        m11001c(str);
    }

    public void writeRaw(String str, int i, int i2) throws IOException, JsonGenerationException {
        m11001c(str.substring(0, i2));
    }

    public void writeRaw(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        m11001c(new String(cArr, i, i2));
    }

    public void writeRaw(char c) throws IOException, JsonGenerationException {
        m11001c(String.valueOf(c));
    }

    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        m11001c(ByteBuffer.wrap(bArr, i, i2));
    }

    public void writeNumber(int i) throws IOException, JsonGenerationException {
        m11001c(Integer.valueOf(i));
    }

    public void writeNumber(long j) throws IOException, JsonGenerationException {
        m11001c(Long.valueOf(j));
    }

    public void writeNumber(BigInteger bigInteger) throws IOException, JsonGenerationException {
        m11001c(bigInteger);
    }

    public void writeNumber(double d) throws IOException, JsonGenerationException {
        m11001c(Double.valueOf(d));
    }

    public void writeNumber(float f) throws IOException, JsonGenerationException {
        m11001c(Float.valueOf(f));
    }

    public void writeNumber(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        m11001c(bigDecimal);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        m11001c(new java.math.BigDecimal(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        throw new java.lang.NumberFormatException(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        m11001c(java.lang.Double.valueOf(java.lang.Double.parseDouble(r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        m11001c(new java.math.BigInteger(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0018 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeNumber(java.lang.String r3) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException, java.lang.UnsupportedOperationException {
        /*
            r2 = this;
            long r0 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x000c }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x000c }
            r2.m11001c(r0)     // Catch:{ NumberFormatException -> 0x000c }
            return
        L_0x000c:
            double r0 = java.lang.Double.parseDouble(r3)     // Catch:{ NumberFormatException -> 0x0018 }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0018 }
            r2.m11001c(r0)     // Catch:{ NumberFormatException -> 0x0018 }
            return
        L_0x0018:
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ NumberFormatException -> 0x0021 }
            r0.<init>(r3)     // Catch:{ NumberFormatException -> 0x0021 }
            r2.m11001c(r0)     // Catch:{ NumberFormatException -> 0x0021 }
            return
        L_0x0021:
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x002a }
            r0.<init>(r3)     // Catch:{ NumberFormatException -> 0x002a }
            r2.m11001c(r0)     // Catch:{ NumberFormatException -> 0x002a }
            return
        L_0x002a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.msgpack.p158a.p159a.C3701d.writeNumber(java.lang.String):void");
    }

    public void writeBoolean(boolean z) throws IOException, JsonGenerationException {
        m11001c(Boolean.valueOf(z));
    }

    public void writeNull() throws IOException, JsonGenerationException {
        m11001c(null);
    }

    /* renamed from: a */
    public void mo31912a(C3698b bVar) throws IOException {
        m11001c(bVar);
    }

    public void close() throws IOException {
        try {
            flush();
        } finally {
            if (isEnabled(Feature.AUTO_CLOSE_TARGET)) {
                m11004f().close();
            }
        }
    }

    public void flush() throws IOException {
        if (this.f9790g != null) {
            if (this.f9790g instanceof C3705c) {
                m10997a((C3705c) this.f9790g);
            } else if (this.f9790g instanceof C3704b) {
                m10996a((C3704b) this.f9790g);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected rootStackItem: ");
                sb.append(this.f9790g);
                throw new IllegalStateException(sb.toString());
            }
            this.f9790g = null;
            m10993a();
        }
    }

    /* renamed from: a */
    private void m10993a() throws IOException {
        m11004f().flush();
    }

    /* access modifiers changed from: protected */
    public void _verifyValueWrite(String str) throws IOException, JsonGenerationException {
        if (this._writeContext.writeValue() == 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not ");
            sb.append(str);
            sb.append(", expecting field name");
            _reportError(sb.toString());
        }
    }

    /* renamed from: b */
    private C3703a m10998b() {
        if (!this.f9789f.isEmpty()) {
            return (C3703a) this.f9789f.getFirst();
        }
        throw new IllegalStateException("The stack is empty");
    }

    /* renamed from: c */
    private C3705c m11000c() {
        C3703a b = m10998b();
        if (b instanceof C3705c) {
            return (C3705c) b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The stack top should be Object: ");
        sb.append(b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: d */
    private C3704b m11002d() {
        C3703a b = m10998b();
        if (b instanceof C3704b) {
            return (C3704b) b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The stack top should be Array: ");
        sb.append(b);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: b */
    private void m10999b(Object obj) {
        m10998b().mo31914a(obj);
    }

    /* renamed from: c */
    private void m11001c(Object obj) throws IOException {
        if (this.f9789f.isEmpty()) {
            m10994a(obj);
            m10993a();
            return;
        }
        m10998b().mo31916b(obj);
    }

    /* renamed from: e */
    private void m11003e() throws IOException {
        C3703a aVar = (C3703a) this.f9789f.pop();
        if (this.f9789f.size() > 0) {
            m11001c(aVar);
        } else if (this.f9790g == null) {
            this.f9790g = aVar;
        } else {
            throw new IllegalStateException("rootStackItem is not null");
        }
    }

    /* renamed from: f */
    private MessagePacker m11004f() {
        return this.f9786b;
    }
}
