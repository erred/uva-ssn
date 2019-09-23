package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.C1459a;

public class IconCompatParcelizer {
    public static IconCompat read(C1459a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3049a = aVar.mo6044b(iconCompat.f3049a, 1);
        iconCompat.f3051c = aVar.mo6050b(iconCompat.f3051c, 2);
        iconCompat.f3052d = aVar.mo6045b(iconCompat.f3052d, 3);
        iconCompat.f3053e = aVar.mo6044b(iconCompat.f3053e, 4);
        iconCompat.f3054f = aVar.mo6044b(iconCompat.f3054f, 5);
        iconCompat.f3055g = (ColorStateList) aVar.mo6045b(iconCompat.f3055g, 6);
        iconCompat.f3057j = aVar.mo6047b(iconCompat.f3057j, 7);
        iconCompat.mo3793e();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, C1459a aVar) {
        aVar.mo6040a(true, true);
        iconCompat.mo3789a(aVar.mo6043a());
        aVar.mo6033a(iconCompat.f3049a, 1);
        aVar.mo6042a(iconCompat.f3051c, 2);
        aVar.mo6035a(iconCompat.f3052d, 3);
        aVar.mo6033a(iconCompat.f3053e, 4);
        aVar.mo6033a(iconCompat.f3054f, 5);
        aVar.mo6035a((Parcelable) iconCompat.f3055g, 6);
        aVar.mo6039a(iconCompat.f3057j, 7);
    }
}
