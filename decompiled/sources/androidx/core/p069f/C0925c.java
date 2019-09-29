package androidx.core.p069f;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: androidx.core.f.c */
/* compiled from: ObjectsCompat */
public class C0925c {
    /* renamed from: a */
    public static boolean m3394a(Object obj, Object obj2) {
        if (VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m3393a(Object... objArr) {
        if (VERSION.SDK_INT >= 19) {
            return Objects.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }
}
