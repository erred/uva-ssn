package org.msgpack.p158a.p159a;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.p116io.IOContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePack.PackerConfig;

/* renamed from: org.msgpack.a.a.c */
/* compiled from: MessagePackFactory */
public class C3700c extends JsonFactory {

    /* renamed from: a */
    private final PackerConfig f9780a;

    /* renamed from: b */
    private boolean f9781b;

    /* renamed from: c */
    private boolean f9782c;

    /* renamed from: d */
    private C3696a f9783d;

    public C3700c() {
        this(MessagePack.DEFAULT_PACKER_CONFIG);
    }

    public C3700c(PackerConfig packerConfig) {
        this.f9781b = true;
        this.f9782c = true;
        this.f9780a = packerConfig;
    }

    public C3700c(C3700c cVar) {
        super(cVar, null);
        this.f9781b = true;
        this.f9782c = true;
        this.f9780a = cVar.f9780a.clone();
        this.f9781b = cVar.f9781b;
        this.f9782c = cVar.f9782c;
        if (cVar.f9783d != null) {
            this.f9783d = new C3696a(cVar.f9783d);
        }
    }

    /* renamed from: a */
    public C3700c mo31910a(boolean z) {
        this.f9782c = z;
        return this;
    }

    public JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        C3701d dVar = new C3701d(this._generatorFeatures, this._objectCodec, outputStream, this.f9780a, this.f9781b);
        return dVar;
    }

    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        return createGenerator((OutputStream) new FileOutputStream(file), jsonEncoding);
    }

    public JsonGenerator createGenerator(Writer writer) throws IOException {
        throw new UnsupportedOperationException();
    }

    public JsonParser createParser(byte[] bArr) throws IOException, JsonParseException {
        return _createParser(bArr, 0, bArr.length, _createContext(bArr, false));
    }

    public JsonParser createParser(InputStream inputStream) throws IOException, JsonParseException {
        return _createParser(inputStream, _createContext(inputStream, false));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3706e _createParser(InputStream inputStream, IOContext iOContext) throws IOException {
        C3706e eVar = new C3706e(iOContext, this._parserFeatures, this._objectCodec, inputStream, this.f9782c);
        if (this.f9783d != null) {
            eVar.mo31917a(this.f9783d);
        }
        return eVar;
    }

    /* access modifiers changed from: protected */
    public JsonParser _createParser(byte[] bArr, int i, int i2, IOContext iOContext) throws IOException, JsonParseException {
        if (!(i == 0 && i2 == bArr.length)) {
            bArr = Arrays.copyOfRange(bArr, i, i2 + i);
        }
        C3706e eVar = new C3706e(iOContext, this._parserFeatures, this._objectCodec, bArr, this.f9782c);
        if (this.f9783d != null) {
            eVar.mo31917a(this.f9783d);
        }
        return eVar;
    }

    public JsonFactory copy() {
        return new C3700c(this);
    }
}
