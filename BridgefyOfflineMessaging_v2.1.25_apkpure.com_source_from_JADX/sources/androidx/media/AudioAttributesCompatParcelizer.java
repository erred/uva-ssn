package androidx.media;

import androidx.versionedparcelable.C1459a;
import androidx.versionedparcelable.C1461c;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(C1459a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3631a = (C1222a) aVar.mo6046b(audioAttributesCompat.f3631a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, C1459a aVar) {
        aVar.mo6040a(false, false);
        aVar.mo6037a((C1461c) audioAttributesCompat.f3631a, 1);
    }
}
