package androidx.legacy.p083a;

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

@Deprecated
/* renamed from: androidx.legacy.a.a */
/* compiled from: FragmentCompat */
public class C1135a {

    /* renamed from: a */
    static final C1141e f3527a;

    /* renamed from: b */
    private static C1143g f3528b;

    /* renamed from: androidx.legacy.a.a$a */
    /* compiled from: FragmentCompat */
    static class C1136a extends C1139d {
        C1136a() {
        }

        /* renamed from: a */
        public void mo4564a(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    /* renamed from: androidx.legacy.a.a$b */
    /* compiled from: FragmentCompat */
    static class C1137b extends C1136a {
        C1137b() {
        }

        /* renamed from: a */
        public void mo4565a(Fragment fragment, String[] strArr, int i) {
            fragment.requestPermissions(strArr, i);
        }
    }

    /* renamed from: androidx.legacy.a.a$c */
    /* compiled from: FragmentCompat */
    static class C1138c extends C1137b {
        C1138c() {
        }

        /* renamed from: a */
        public void mo4564a(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    /* renamed from: androidx.legacy.a.a$d */
    /* compiled from: FragmentCompat */
    static class C1139d implements C1141e {
        /* renamed from: a */
        public void mo4564a(Fragment fragment, boolean z) {
        }

        C1139d() {
        }

        /* renamed from: a */
        public void mo4565a(final Fragment fragment, final String[] strArr, final int i) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    Activity activity = fragment.getActivity();
                    if (activity != null) {
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                        }
                    } else {
                        Arrays.fill(iArr, -1);
                    }
                    ((C1142f) fragment).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    /* renamed from: androidx.legacy.a.a$e */
    /* compiled from: FragmentCompat */
    interface C1141e {
        /* renamed from: a */
        void mo4564a(Fragment fragment, boolean z);

        /* renamed from: a */
        void mo4565a(Fragment fragment, String[] strArr, int i);
    }

    @Deprecated
    /* renamed from: androidx.legacy.a.a$f */
    /* compiled from: FragmentCompat */
    public interface C1142f {
        @Deprecated
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    @Deprecated
    /* renamed from: androidx.legacy.a.a$g */
    /* compiled from: FragmentCompat */
    public interface C1143g {
        @Deprecated
        /* renamed from: a */
        boolean mo4568a(Fragment fragment, String[] strArr, int i);
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            f3527a = new C1138c();
        } else if (VERSION.SDK_INT >= 23) {
            f3527a = new C1137b();
        } else if (VERSION.SDK_INT >= 15) {
            f3527a = new C1136a();
        } else {
            f3527a = new C1139d();
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m4396a(Fragment fragment, boolean z) {
        f3527a.mo4564a(fragment, z);
    }

    @Deprecated
    /* renamed from: a */
    public static void m4397a(Fragment fragment, String[] strArr, int i) {
        if (f3528b == null || !f3528b.mo4568a(fragment, strArr, i)) {
            f3527a.mo4565a(fragment, strArr, i);
        }
    }
}
