package androidx.core.p070g;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import androidx.core.R;

/* renamed from: androidx.core.g.t */
/* compiled from: ViewGroupCompat */
public final class C0967t {
    /* renamed from: a */
    public static boolean m3618a(ViewGroup viewGroup) {
        if (VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(R.id.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && C0962r.m3593p(viewGroup) == null) ? false : true;
    }
}
