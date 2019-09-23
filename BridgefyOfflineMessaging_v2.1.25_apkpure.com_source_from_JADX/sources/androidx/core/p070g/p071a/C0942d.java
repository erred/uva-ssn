package androidx.core.p070g.p071a;

import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: androidx.core.g.a.d */
/* compiled from: AccessibilityRecordCompat */
public class C0942d {

    /* renamed from: a */
    private final AccessibilityRecord f2994a;

    /* renamed from: a */
    public static void m3478a(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }

    /* renamed from: a */
    public static void m3477a(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* renamed from: b */
    public static void m3479b(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        if (this.f2994a == null) {
            return 0;
        }
        return this.f2994a.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0942d dVar = (C0942d) obj;
        if (this.f2994a == null) {
            if (dVar.f2994a != null) {
                return false;
            }
        } else if (!this.f2994a.equals(dVar.f2994a)) {
            return false;
        }
        return true;
    }
}
