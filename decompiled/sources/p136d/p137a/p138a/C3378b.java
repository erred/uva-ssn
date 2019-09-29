package p136d.p137a.p138a;

import com.google.api.client.json.Json;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import p091b.C1592ab;
import p091b.C1647v;
import p102c.C1672c;
import p136d.C3407e;

/* renamed from: d.a.a.b */
/* compiled from: GsonRequestBodyConverter */
final class C3378b<T> implements C3407e<T, C1592ab> {

    /* renamed from: a */
    private static final C1647v f8815a = C1647v.m6791a(Json.MEDIA_TYPE);

    /* renamed from: b */
    private static final Charset f8816b = Charset.forName("UTF-8");

    /* renamed from: c */
    private final Gson f8817c;

    /* renamed from: d */
    private final TypeAdapter<T> f8818d;

    C3378b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f8817c = gson;
        this.f8818d = typeAdapter;
    }

    /* renamed from: b */
    public C1592ab mo28198a(T t) throws IOException {
        C1672c cVar = new C1672c();
        JsonWriter newJsonWriter = this.f8817c.newJsonWriter(new OutputStreamWriter(cVar.mo6836d(), f8816b));
        this.f8818d.write(newJsonWriter, t);
        newJsonWriter.close();
        return C1592ab.m6494a(f8815a, cVar.mo6865p());
    }
}
