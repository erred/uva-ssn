package org.msgpack.p158a.p159a;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.p116io.IOContext;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import org.msgpack.core.ExtensionTypeHeader;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.core.buffer.ArrayBufferInput;
import org.msgpack.core.buffer.InputStreamBufferInput;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.p158a.p159a.C3696a.C3697a;

/* renamed from: org.msgpack.a.a.e */
/* compiled from: MessagePackParser */
public class C3706e extends ParserMinimalBase {

    /* renamed from: a */
    private static final ThreadLocal<C3713g<Object, MessageUnpacker>> f9793a = new ThreadLocal<>();

    /* renamed from: c */
    private static final BigInteger f9794c = BigInteger.valueOf(Long.MIN_VALUE);

    /* renamed from: d */
    private static final BigInteger f9795d = BigInteger.valueOf(Long.MAX_VALUE);

    /* renamed from: b */
    private final MessageUnpacker f9796b;

    /* renamed from: e */
    private ObjectCodec f9797e;

    /* renamed from: f */
    private JsonReadContext f9798f;

    /* renamed from: g */
    private final LinkedList<C3708a> f9799g;

    /* renamed from: h */
    private boolean f9800h;

    /* renamed from: i */
    private long f9801i;

    /* renamed from: j */
    private long f9802j;

    /* renamed from: k */
    private final IOContext f9803k;

    /* renamed from: l */
    private C3696a f9804l;

    /* renamed from: m */
    private C3711d f9805m;

    /* renamed from: n */
    private int f9806n;

    /* renamed from: o */
    private long f9807o;

    /* renamed from: p */
    private double f9808p;

    /* renamed from: q */
    private byte[] f9809q;

    /* renamed from: r */
    private String f9810r;

    /* renamed from: s */
    private BigInteger f9811s;

    /* renamed from: t */
    private C3698b f9812t;

    /* renamed from: u */
    private boolean f9813u;

    /* renamed from: org.msgpack.a.a.e$1 */
    /* compiled from: MessagePackParser */
    static /* synthetic */ class C37071 {

        /* renamed from: a */
        static final /* synthetic */ int[] f9814a = new int[MessageFormat.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|(2:45|46)|47|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|(2:45|46)|47|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|49|50|52) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0091 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b1 */
        static {
            /*
                org.msgpack.a.a.e$d[] r0 = org.msgpack.p158a.p159a.C3706e.C3711d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9816c = r0
                r0 = 1
                int[] r1 = f9816c     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.msgpack.a.a.e$d r2 = org.msgpack.p158a.p159a.C3706e.C3711d.STRING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f9816c     // Catch:{ NoSuchFieldError -> 0x001f }
                org.msgpack.a.a.e$d r3 = org.msgpack.p158a.p159a.C3706e.C3711d.BYTES     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f9816c     // Catch:{ NoSuchFieldError -> 0x002a }
                org.msgpack.a.a.e$d r4 = org.msgpack.p158a.p159a.C3706e.C3711d.INT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f9816c     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.msgpack.a.a.e$d r5 = org.msgpack.p158a.p159a.C3706e.C3711d.LONG     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f9816c     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.msgpack.a.a.e$d r6 = org.msgpack.p158a.p159a.C3706e.C3711d.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                r5 = 6
                int[] r6 = f9816c     // Catch:{ NoSuchFieldError -> 0x004b }
                org.msgpack.a.a.e$d r7 = org.msgpack.p158a.p159a.C3706e.C3711d.BIG_INT     // Catch:{ NoSuchFieldError -> 0x004b }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                r6 = 7
                int[] r7 = f9816c     // Catch:{ NoSuchFieldError -> 0x0056 }
                org.msgpack.a.a.e$d r8 = org.msgpack.p158a.p159a.C3706e.C3711d.EXT     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                org.msgpack.b.z[] r7 = org.msgpack.p160b.C3769z.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f9815b = r7
                int[] r7 = f9815b     // Catch:{ NoSuchFieldError -> 0x0069 }
                org.msgpack.b.z r8 = org.msgpack.p160b.C3769z.NIL     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r7[r8] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r7 = f9815b     // Catch:{ NoSuchFieldError -> 0x0073 }
                org.msgpack.b.z r8 = org.msgpack.p160b.C3769z.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r1 = f9815b     // Catch:{ NoSuchFieldError -> 0x007d }
                org.msgpack.b.z r7 = org.msgpack.p160b.C3769z.INTEGER     // Catch:{ NoSuchFieldError -> 0x007d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r1[r7] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r1 = f9815b     // Catch:{ NoSuchFieldError -> 0x0087 }
                org.msgpack.b.z r2 = org.msgpack.p160b.C3769z.FLOAT     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r1 = f9815b     // Catch:{ NoSuchFieldError -> 0x0091 }
                org.msgpack.b.z r2 = org.msgpack.p160b.C3769z.STRING     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r1[r2] = r4     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                int[] r1 = f9815b     // Catch:{ NoSuchFieldError -> 0x009b }
                org.msgpack.b.z r2 = org.msgpack.p160b.C3769z.BINARY     // Catch:{ NoSuchFieldError -> 0x009b }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r1[r2] = r5     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                int[] r1 = f9815b     // Catch:{ NoSuchFieldError -> 0x00a5 }
                org.msgpack.b.z r2 = org.msgpack.p160b.C3769z.ARRAY     // Catch:{ NoSuchFieldError -> 0x00a5 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r1[r2] = r6     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                int[] r1 = f9815b     // Catch:{ NoSuchFieldError -> 0x00b1 }
                org.msgpack.b.z r2 = org.msgpack.p160b.C3769z.MAP     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r3 = 8
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                int[] r1 = f9815b     // Catch:{ NoSuchFieldError -> 0x00bd }
                org.msgpack.b.z r2 = org.msgpack.p160b.C3769z.EXTENSION     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r3 = 9
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                org.msgpack.core.MessageFormat[] r1 = org.msgpack.core.MessageFormat.values()
                int r1 = r1.length
                int[] r1 = new int[r1]
                f9814a = r1
                int[] r1 = f9814a     // Catch:{ NoSuchFieldError -> 0x00d0 }
                org.msgpack.core.MessageFormat r2 = org.msgpack.core.MessageFormat.UINT64     // Catch:{ NoSuchFieldError -> 0x00d0 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d0 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x00d0 }
            L_0x00d0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.msgpack.p158a.p159a.C3706e.C37071.<clinit>():void");
        }
    }

    /* renamed from: org.msgpack.a.a.e$a */
    /* compiled from: MessagePackParser */
    private static abstract class C3708a {

        /* renamed from: a */
        private long f9817a;

        protected C3708a(long j) {
            this.f9817a = j;
        }

        /* renamed from: a */
        public void mo31918a() {
            this.f9817a--;
        }

        /* renamed from: b */
        public boolean mo31919b() {
            return this.f9817a == 0;
        }
    }

    /* renamed from: org.msgpack.a.a.e$b */
    /* compiled from: MessagePackParser */
    private static class C3709b extends C3708a {
        C3709b(long j) {
            super(j);
        }
    }

    /* renamed from: org.msgpack.a.a.e$c */
    /* compiled from: MessagePackParser */
    private static class C3710c extends C3708a {
        C3710c(long j) {
            super(j);
        }
    }

    /* renamed from: org.msgpack.a.a.e$d */
    /* compiled from: MessagePackParser */
    private enum C3711d {
        INT,
        LONG,
        DOUBLE,
        STRING,
        BYTES,
        BIG_INT,
        EXT
    }

    /* access modifiers changed from: protected */
    public void _handleEOF() throws JsonParseException {
    }

    public int getTextOffset() throws IOException, JsonParseException {
        return 0;
    }

    public boolean hasTextCharacters() {
        return false;
    }

    public Version version() {
        return null;
    }

    public C3706e(IOContext iOContext, int i, ObjectCodec objectCodec, InputStream inputStream, boolean z) throws IOException {
        this(iOContext, i, new InputStreamBufferInput(inputStream), objectCodec, inputStream, z);
    }

    public C3706e(IOContext iOContext, int i, ObjectCodec objectCodec, byte[] bArr, boolean z) throws IOException {
        this(iOContext, i, new ArrayBufferInput(bArr), objectCodec, bArr, z);
    }

    private C3706e(IOContext iOContext, int i, MessageBufferInput messageBufferInput, ObjectCodec objectCodec, Object obj, boolean z) throws IOException {
        MessageUnpacker messageUnpacker;
        super(i);
        this.f9799g = new LinkedList<>();
        this.f9797e = objectCodec;
        this.f9803k = iOContext;
        this.f9798f = JsonReadContext.createRootContext(Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? DupDetector.rootDetector((JsonParser) this) : null);
        this.f9813u = z;
        if (!z) {
            this.f9796b = MessagePack.newDefaultUnpacker(messageBufferInput);
            return;
        }
        this.f9796b = null;
        C3713g gVar = (C3713g) f9793a.get();
        if (gVar == null) {
            messageUnpacker = MessagePack.newDefaultUnpacker(messageBufferInput);
        } else {
            if (isEnabled(Feature.AUTO_CLOSE_SOURCE) || gVar.mo31921a() != obj) {
                ((MessageUnpacker) gVar.mo31922b()).reset(messageBufferInput);
            }
            messageUnpacker = (MessageUnpacker) gVar.mo31922b();
        }
        f9793a.set(new C3713g(obj, messageUnpacker));
    }

    /* renamed from: a */
    public void mo31917a(C3696a aVar) {
        this.f9804l = aVar;
    }

    public ObjectCodec getCodec() {
        return this.f9797e;
    }

    public void setCodec(ObjectCodec objectCodec) {
        this.f9797e = objectCodec;
    }

    public JsonToken nextToken() throws IOException, JsonParseException {
        JsonToken jsonToken;
        Object obj;
        Object obj2;
        MessageUnpacker a = m11014a();
        this.f9801i = a.getTotalReadBytes();
        if ((this.f9798f.inObject() || this.f9798f.inArray()) && ((C3708a) this.f9799g.getFirst()).mo31919b()) {
            this.f9799g.pop();
            this._currToken = this.f9798f.inObject() ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            this.f9798f = this.f9798f.getParent();
            return this._currToken;
        }
        Object obj3 = null;
        if (!a.hasNext()) {
            return null;
        }
        MessageFormat nextFormat = a.getNextFormat();
        switch (a.getNextFormat().getValueType()) {
            case NIL:
                a.unpackNil();
                jsonToken = JsonToken.VALUE_NULL;
                break;
            case BOOLEAN:
                boolean unpackBoolean = a.unpackBoolean();
                if (!this.f9798f.inObject() || this._currToken == JsonToken.FIELD_NAME) {
                    if (!unpackBoolean) {
                        jsonToken = JsonToken.VALUE_FALSE;
                        break;
                    } else {
                        jsonToken = JsonToken.VALUE_TRUE;
                        break;
                    }
                } else {
                    this.f9798f.setCurrentName(Boolean.toString(unpackBoolean));
                    jsonToken = JsonToken.FIELD_NAME;
                    break;
                }
                break;
            case INTEGER:
                if (C37071.f9814a[nextFormat.ordinal()] != 1) {
                    long unpackLong = a.unpackLong();
                    if (-2147483648L > unpackLong || unpackLong > 2147483647L) {
                        this.f9805m = C3711d.LONG;
                        this.f9807o = unpackLong;
                        obj = Long.valueOf(this.f9807o);
                    } else {
                        this.f9805m = C3711d.INT;
                        this.f9806n = (int) unpackLong;
                        obj = Integer.valueOf(this.f9806n);
                    }
                } else {
                    BigInteger unpackBigInteger = a.unpackBigInteger();
                    if (unpackBigInteger.compareTo(f9794c) < 0 || unpackBigInteger.compareTo(f9795d) > 0) {
                        this.f9805m = C3711d.BIG_INT;
                        this.f9811s = unpackBigInteger;
                        obj = this.f9811s;
                    } else {
                        this.f9805m = C3711d.LONG;
                        this.f9807o = unpackBigInteger.longValue();
                        obj = Long.valueOf(this.f9807o);
                    }
                }
                if (this.f9798f.inObject() && this._currToken != JsonToken.FIELD_NAME) {
                    this.f9798f.setCurrentName(String.valueOf(obj));
                    jsonToken = JsonToken.FIELD_NAME;
                    break;
                } else {
                    jsonToken = JsonToken.VALUE_NUMBER_INT;
                    break;
                }
                break;
            case FLOAT:
                this.f9805m = C3711d.DOUBLE;
                this.f9808p = a.unpackDouble();
                if (this.f9798f.inObject() && this._currToken != JsonToken.FIELD_NAME) {
                    this.f9798f.setCurrentName(String.valueOf(this.f9808p));
                    jsonToken = JsonToken.FIELD_NAME;
                    break;
                } else {
                    jsonToken = JsonToken.VALUE_NUMBER_FLOAT;
                    break;
                }
                break;
            case STRING:
                this.f9805m = C3711d.STRING;
                this.f9810r = a.unpackString();
                if (this.f9798f.inObject() && this._currToken != JsonToken.FIELD_NAME) {
                    this.f9798f.setCurrentName(this.f9810r);
                    jsonToken = JsonToken.FIELD_NAME;
                    break;
                } else {
                    jsonToken = JsonToken.VALUE_STRING;
                    break;
                }
                break;
            case BINARY:
                this.f9805m = C3711d.BYTES;
                this.f9809q = a.readPayload(a.unpackBinaryHeader());
                if (this.f9798f.inObject() && this._currToken != JsonToken.FIELD_NAME) {
                    this.f9798f.setCurrentName(new String(this.f9809q, MessagePack.UTF8));
                    jsonToken = JsonToken.FIELD_NAME;
                    break;
                } else {
                    jsonToken = JsonToken.VALUE_EMBEDDED_OBJECT;
                    break;
                }
            case ARRAY:
                obj2 = new C3709b((long) a.unpackArrayHeader());
                break;
            case MAP:
                obj2 = new C3710c((long) a.unpackMapHeader());
                break;
            case EXTENSION:
                this.f9805m = C3711d.EXT;
                ExtensionTypeHeader unpackExtensionTypeHeader = a.unpackExtensionTypeHeader();
                this.f9812t = new C3698b(unpackExtensionTypeHeader.getType(), a.readPayload(unpackExtensionTypeHeader.getLength()));
                jsonToken = JsonToken.VALUE_EMBEDDED_OBJECT;
                break;
            default:
                throw new IllegalStateException("Shouldn't reach here");
        }
        obj3 = obj2;
        jsonToken = null;
        this.f9802j = a.getTotalReadBytes();
        if ((this.f9798f.inObject() && jsonToken != JsonToken.FIELD_NAME) || this.f9798f.inArray()) {
            ((C3708a) this.f9799g.getFirst()).mo31918a();
        }
        if (obj3 != null) {
            this.f9799g.push(obj3);
            if (obj3 instanceof C3709b) {
                jsonToken = JsonToken.START_ARRAY;
                this.f9798f = this.f9798f.createChildArrayContext(-1, -1);
            } else if (obj3 instanceof C3710c) {
                jsonToken = JsonToken.START_OBJECT;
                this.f9798f = this.f9798f.createChildObjectContext(-1, -1);
            }
        }
        this._currToken = jsonToken;
        return jsonToken;
    }

    public String getText() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case STRING:
                return this.f9810r;
            case BYTES:
                return new String(this.f9809q, MessagePack.UTF8);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public char[] getTextCharacters() throws IOException, JsonParseException {
        return getText().toCharArray();
    }

    public int getTextLength() throws IOException, JsonParseException {
        return getText().length();
    }

    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        switch (this.f9805m) {
            case STRING:
                return this.f9810r.getBytes(MessagePack.UTF8);
            case BYTES:
                return this.f9809q;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public Number getNumberValue() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case INT:
                return Integer.valueOf(this.f9806n);
            case LONG:
                return Long.valueOf(this.f9807o);
            case DOUBLE:
                return Double.valueOf(this.f9808p);
            case BIG_INT:
                return this.f9811s;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public int getIntValue() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case INT:
                return this.f9806n;
            case LONG:
                return (int) this.f9807o;
            case DOUBLE:
                return (int) this.f9808p;
            case BIG_INT:
                return this.f9811s.intValue();
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public long getLongValue() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case INT:
                return (long) this.f9806n;
            case LONG:
                return this.f9807o;
            case DOUBLE:
                return (long) this.f9808p;
            case BIG_INT:
                return this.f9811s.longValue();
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case INT:
                return BigInteger.valueOf((long) this.f9806n);
            case LONG:
                return BigInteger.valueOf(this.f9807o);
            case DOUBLE:
                return BigInteger.valueOf((long) this.f9808p);
            case BIG_INT:
                return this.f9811s;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public float getFloatValue() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case INT:
                return (float) this.f9806n;
            case LONG:
                return (float) this.f9807o;
            case DOUBLE:
                return (float) this.f9808p;
            case BIG_INT:
                return this.f9811s.floatValue();
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public double getDoubleValue() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case INT:
                return (double) this.f9806n;
            case LONG:
                return (double) this.f9807o;
            case DOUBLE:
                return this.f9808p;
            case BIG_INT:
                return this.f9811s.doubleValue();
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public BigDecimal getDecimalValue() throws IOException {
        switch (this.f9805m) {
            case INT:
                return BigDecimal.valueOf((long) this.f9806n);
            case LONG:
                return BigDecimal.valueOf(this.f9807o);
            case DOUBLE:
                return BigDecimal.valueOf(this.f9808p);
            case BIG_INT:
                return new BigDecimal(this.f9811s);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public Object getEmbeddedObject() throws IOException, JsonParseException {
        int i = C37071.f9816c[this.f9805m.ordinal()];
        if (i == 2) {
            return this.f9809q;
        }
        if (i == 7) {
            if (this.f9804l != null) {
                C3697a a = this.f9804l.mo31903a(this.f9812t.mo31905a());
                if (a != null) {
                    return a.mo31904a(this.f9812t.mo31906b());
                }
            }
            return this.f9812t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid type=");
        sb.append(this.f9805m);
        throw new IllegalStateException(sb.toString());
    }

    public NumberType getNumberType() throws IOException, JsonParseException {
        switch (this.f9805m) {
            case INT:
                return NumberType.INT;
            case LONG:
                return NumberType.LONG;
            case DOUBLE:
                return NumberType.DOUBLE;
            case BIG_INT:
                return NumberType.BIG_INTEGER;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid type=");
                sb.append(this.f9805m);
                throw new IllegalStateException(sb.toString());
        }
    }

    public void close() throws IOException {
        try {
            if (isEnabled(Feature.AUTO_CLOSE_SOURCE)) {
                m11014a().close();
            }
        } finally {
            this.f9800h = true;
        }
    }

    public boolean isClosed() {
        return this.f9800h;
    }

    public JsonStreamContext getParsingContext() {
        return this.f9798f;
    }

    public JsonLocation getTokenLocation() {
        JsonLocation jsonLocation = new JsonLocation(this.f9803k.getSourceReference(), this.f9801i, -1, -1, (int) this.f9801i);
        return jsonLocation;
    }

    public JsonLocation getCurrentLocation() {
        JsonLocation jsonLocation = new JsonLocation(this.f9803k.getSourceReference(), this.f9802j, -1, -1, (int) this.f9802j);
        return jsonLocation;
    }

    public void overrideCurrentName(String str) {
        try {
            if (this._currToken != JsonToken.START_OBJECT) {
                if (this._currToken != JsonToken.START_ARRAY) {
                    this.f9798f.setCurrentName(str);
                    return;
                }
            }
            this.f9798f.getParent().setCurrentName(str);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getCurrentName() throws IOException {
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            return this.f9798f.getParent().getCurrentName();
        }
        return this.f9798f.getCurrentName();
    }

    /* renamed from: a */
    private MessageUnpacker m11014a() {
        if (!this.f9813u) {
            return this.f9796b;
        }
        C3713g gVar = (C3713g) f9793a.get();
        if (gVar != null) {
            return (MessageUnpacker) gVar.mo31922b();
        }
        throw new IllegalStateException("messageUnpacker is null");
    }
}
