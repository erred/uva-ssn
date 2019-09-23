package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* renamed from: androidx.media.b */
/* compiled from: AudioAttributesImplApi21 */
class C1223b implements C1222a {

    /* renamed from: a */
    AudioAttributes f3632a;

    /* renamed from: b */
    int f3633b = -1;

    C1223b() {
    }

    public int hashCode() {
        return this.f3632a.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1223b)) {
            return false;
        }
        return this.f3632a.equals(((C1223b) obj).f3632a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioAttributesCompat: audioattributes=");
        sb.append(this.f3632a);
        return sb.toString();
    }
}
