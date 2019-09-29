package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.C1459a;

public final class AudioAttributesImplApi21Parcelizer {
    public static C1223b read(C1459a aVar) {
        C1223b bVar = new C1223b();
        bVar.f3632a = (AudioAttributes) aVar.mo6045b(bVar.f3632a, 1);
        bVar.f3633b = aVar.mo6044b(bVar.f3633b, 2);
        return bVar;
    }

    public static void write(C1223b bVar, C1459a aVar) {
        aVar.mo6040a(false, false);
        aVar.mo6035a((Parcelable) bVar.f3632a, 1);
        aVar.mo6033a(bVar.f3633b, 2);
    }
}
