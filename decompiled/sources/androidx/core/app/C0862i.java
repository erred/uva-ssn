package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.C0854g.C0855a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p140me.bridgefy.ormlite.entities.FriendDTO;

/* renamed from: androidx.core.app.i */
/* compiled from: NotificationCompatJellybean */
class C0862i {

    /* renamed from: a */
    private static final Object f2799a = new Object();

    /* renamed from: b */
    private static Field f2800b;

    /* renamed from: c */
    private static boolean f2801c;

    /* renamed from: d */
    private static final Object f2802d = new Object();

    /* renamed from: a */
    public static SparseArray<Bundle> m3188a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m3185a(Notification notification) {
        synchronized (f2799a) {
            if (f2801c) {
                return null;
            }
            try {
                if (f2800b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2801c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2800b = declaredField;
                }
                Bundle bundle = (Bundle) f2800b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2800b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f2801c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f2801c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Bundle m3184a(Builder builder, C0855a aVar) {
        builder.addAction(aVar.mo3469a(), aVar.mo3470b(), aVar.mo3471c());
        Bundle bundle = new Bundle(aVar.mo3472d());
        if (aVar.mo3474f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m3189a(aVar.mo3474f()));
        }
        if (aVar.mo3476h() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m3189a(aVar.mo3476h()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3473e());
        return bundle;
    }

    /* renamed from: a */
    static Bundle m3186a(C0855a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.mo3469a());
        bundle2.putCharSequence("title", aVar.mo3470b());
        bundle2.putParcelable("actionIntent", aVar.mo3471c());
        if (aVar.mo3472d() != null) {
            bundle = new Bundle(aVar.mo3472d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3473e());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", m3189a(aVar.mo3474f()));
        bundle2.putBoolean("showsUserInterface", aVar.mo3477i());
        bundle2.putInt("semanticAction", aVar.mo3475g());
        return bundle2;
    }

    /* renamed from: a */
    private static Bundle m3187a(C0865k kVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", kVar.mo3529a());
        bundle.putCharSequence(FriendDTO.LABEL, kVar.mo3530b());
        bundle.putCharSequenceArray("choices", kVar.mo3531c());
        bundle.putBoolean("allowFreeFormInput", kVar.mo3533e());
        bundle.putBundle("extras", kVar.mo3534f());
        Set<String> d = kVar.mo3532d();
        if (d != null && !d.isEmpty()) {
            ArrayList arrayList = new ArrayList(d.size());
            for (String add : d) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: a */
    private static Bundle[] m3189a(C0865k[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[kVarArr.length];
        for (int i = 0; i < kVarArr.length; i++) {
            bundleArr[i] = m3187a(kVarArr[i]);
        }
        return bundleArr;
    }
}
