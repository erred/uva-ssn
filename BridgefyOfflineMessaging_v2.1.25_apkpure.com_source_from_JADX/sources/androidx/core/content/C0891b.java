package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.core.app.C0847b;

/* renamed from: androidx.core.content.b */
/* compiled from: PermissionChecker */
public final class C0891b {
    /* renamed from: a */
    public static int m3309a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0847b.m3106a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if (C0847b.m3105a(context, a, str2) != 0) {
            return -2;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m3308a(Context context, String str) {
        return m3309a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
