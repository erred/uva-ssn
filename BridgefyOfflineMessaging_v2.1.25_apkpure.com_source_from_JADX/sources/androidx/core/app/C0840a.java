package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.C0866l.C0867a;
import androidx.core.content.C0875a;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.core.app.a */
/* compiled from: ActivityCompat */
public class C0840a extends C0875a {

    /* renamed from: a */
    private static C0843b f2715a;

    /* renamed from: androidx.core.app.a$a */
    /* compiled from: ActivityCompat */
    public interface C0842a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: androidx.core.app.a$b */
    /* compiled from: ActivityCompat */
    public interface C0843b {
        /* renamed from: a */
        boolean mo3453a(Activity activity, int i, int i2, Intent intent);

        /* renamed from: a */
        boolean mo3454a(Activity activity, String[] strArr, int i);
    }

    /* renamed from: androidx.core.app.a$c */
    /* compiled from: ActivityCompat */
    public interface C0844c {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* renamed from: androidx.core.app.a$d */
    /* compiled from: ActivityCompat */
    private static class C0845d extends SharedElementCallback {

        /* renamed from: a */
        private final C0866l f2719a;

        C0845d(C0866l lVar) {
            this.f2719a = lVar;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f2719a.mo3539a(list, list2, list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f2719a.mo3541b(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f2719a.mo3537a(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f2719a.mo3540a(list, map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f2719a.mo3535a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f2719a.mo3536a(context, parcelable);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, final OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f2719a.mo3538a(list, list2, (C0867a) new C0867a() {
                /* renamed from: a */
                public void mo3463a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    /* renamed from: a */
    public static C0843b m3091a() {
        return f2715a;
    }

    /* renamed from: a */
    public static void m3093a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m3094a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m3092a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* renamed from: b */
    public static void m3098b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m3095a(Activity activity, C0866l lVar) {
        if (VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(lVar != null ? new C0845d(lVar) : null);
        }
    }

    /* renamed from: b */
    public static void m3099b(Activity activity, C0866l lVar) {
        if (VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(lVar != null ? new C0845d(lVar) : null);
        }
    }

    /* renamed from: c */
    public static void m3100c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* renamed from: d */
    public static void m3101d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* renamed from: a */
    public static void m3096a(final Activity activity, final String[] strArr, final int i) {
        if (f2715a == null || !f2715a.mo3454a(activity, strArr, i)) {
            if (VERSION.SDK_INT >= 23) {
                if (activity instanceof C0844c) {
                    ((C0844c) activity).validateRequestPermissionsRequestCode(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof C0842a) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        int[] iArr = new int[strArr.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                        }
                        ((C0842a) activity).onRequestPermissionsResult(i, strArr, iArr);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static boolean m3097a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
