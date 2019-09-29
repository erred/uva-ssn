package androidx.media;

import androidx.versionedparcelable.C1459a;

public final class AudioAttributesImplBaseParcelizer {
    public static C1224c read(C1459a aVar) {
        C1224c cVar = new C1224c();
        cVar.f3634a = aVar.mo6044b(cVar.f3634a, 1);
        cVar.f3635b = aVar.mo6044b(cVar.f3635b, 2);
        cVar.f3636c = aVar.mo6044b(cVar.f3636c, 3);
        cVar.f3637d = aVar.mo6044b(cVar.f3637d, 4);
        return cVar;
    }

    public static void write(C1224c cVar, C1459a aVar) {
        aVar.mo6040a(false, false);
        aVar.mo6033a(cVar.f3634a, 1);
        aVar.mo6033a(cVar.f3635b, 2);
        aVar.mo6033a(cVar.f3636c, 3);
        aVar.mo6033a(cVar.f3637d, 4);
    }
}
