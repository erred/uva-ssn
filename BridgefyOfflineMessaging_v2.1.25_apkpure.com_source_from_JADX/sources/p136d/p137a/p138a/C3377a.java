package p136d.p137a.p138a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p091b.C1592ab;
import p091b.C1598ad;
import p136d.C3407e;
import p136d.C3407e.C3408a;
import p136d.C3446m;

/* renamed from: d.a.a.a */
/* compiled from: GsonConverterFactory */
public final class C3377a extends C3408a {

    /* renamed from: a */
    private final Gson f8814a;

    /* renamed from: a */
    public static C3377a m9854a() {
        return m9855a(new Gson());
    }

    /* renamed from: a */
    public static C3377a m9855a(Gson gson) {
        return new C3377a(gson);
    }

    private C3377a(Gson gson) {
        if (gson != null) {
            this.f8814a = gson;
            return;
        }
        throw new NullPointerException("gson == null");
    }

    /* renamed from: a */
    public C3407e<C1598ad, ?> mo28194a(Type type, Annotation[] annotationArr, C3446m mVar) {
        return new C3379c(this.f8814a, this.f8814a.getAdapter(TypeToken.get(type)));
    }

    /* renamed from: a */
    public C3407e<?, C1592ab> mo28195a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C3446m mVar) {
        return new C3378b(this.f8814a, this.f8814a.getAdapter(TypeToken.get(type)));
    }
}
