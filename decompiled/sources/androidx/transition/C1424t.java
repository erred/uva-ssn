package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.transition.t */
/* compiled from: TransitionValues */
public class C1424t {

    /* renamed from: a */
    public final Map<String, Object> f4233a = new HashMap();

    /* renamed from: b */
    public View f4234b;

    /* renamed from: c */
    final ArrayList<C1407m> f4235c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj instanceof C1424t) {
            C1424t tVar = (C1424t) obj;
            if (this.f4234b == tVar.f4234b && this.f4233a.equals(tVar.f4233a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f4234b.hashCode() * 31) + this.f4233a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransitionValues@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(":\n");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("    view = ");
        sb3.append(this.f4234b);
        sb3.append("\n");
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        sb5.append("    values:");
        String sb6 = sb5.toString();
        for (String str : this.f4233a.keySet()) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append("    ");
            sb7.append(str);
            sb7.append(": ");
            sb7.append(this.f4233a.get(str));
            sb7.append("\n");
            sb6 = sb7.toString();
        }
        return sb6;
    }
}
