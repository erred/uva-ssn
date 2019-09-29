package androidx.loader.p087a;

import android.os.Bundle;
import androidx.lifecycle.C1176g;
import androidx.lifecycle.C1192s;
import androidx.loader.p088b.C1206b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.loader.a.a */
/* compiled from: LoaderManager */
public abstract class C1197a {

    /* renamed from: androidx.loader.a.a$a */
    /* compiled from: LoaderManager */
    public interface C1198a<D> {
        C1206b<D> onCreateLoader(int i, Bundle bundle);

        void onLoadFinished(C1206b<D> bVar, D d);

        void onLoaderReset(C1206b<D> bVar);
    }

    /* renamed from: a */
    public abstract <D> C1206b<D> mo4627a(int i, Bundle bundle, C1198a<D> aVar);

    /* renamed from: a */
    public abstract void mo4628a();

    @Deprecated
    /* renamed from: a */
    public abstract void mo4629a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: a */
    public static <T extends C1176g & C1192s> C1197a m4506a(T t) {
        return new C1199b(t, ((C1192s) t).getViewModelStore());
    }
}
