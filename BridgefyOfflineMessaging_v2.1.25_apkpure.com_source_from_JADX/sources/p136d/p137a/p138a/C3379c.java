package p136d.p137a.p138a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import p091b.C1598ad;
import p136d.C3407e;

/* renamed from: d.a.a.c */
/* compiled from: GsonResponseBodyConverter */
final class C3379c<T> implements C3407e<C1598ad, T> {

    /* renamed from: a */
    private final Gson f8819a;

    /* renamed from: b */
    private final TypeAdapter<T> f8820b;

    C3379c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f8819a = gson;
        this.f8820b = typeAdapter;
    }

    /* renamed from: a */
    public T mo28198a(C1598ad adVar) throws IOException {
        try {
            return this.f8820b.read(this.f8819a.newJsonReader(adVar.mo6512e()));
        } finally {
            adVar.close();
        }
    }
}
