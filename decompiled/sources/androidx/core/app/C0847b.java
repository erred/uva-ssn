package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: androidx.core.app.b */
/* compiled from: AppOpsManagerCompat */
public final class C0847b {
    /* renamed from: a */
    public static String m3106a(String str) {
        if (VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    /* renamed from: a */
    public static int m3105a(Context context, String str, String str2) {
        if (VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }
}
