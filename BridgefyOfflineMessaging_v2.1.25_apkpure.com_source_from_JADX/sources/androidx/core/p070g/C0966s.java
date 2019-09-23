package androidx.core.p070g;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;

/* renamed from: androidx.core.g.s */
/* compiled from: ViewConfigurationCompat */
public final class C0966s {

    /* renamed from: a */
    private static Method f3027a;

    static {
        if (VERSION.SDK_INT == 25) {
            try {
                f3027a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    public static int m3613a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    /* renamed from: a */
    public static float m3612a(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return m3617d(viewConfiguration, context);
    }

    /* renamed from: b */
    public static float m3614b(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return m3617d(viewConfiguration, context);
    }

    /* renamed from: d */
    private static float m3617d(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 25 && f3027a != null) {
            try {
                return (float) ((Integer) f3027a.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(16842829, typedValue, true) ? typedValue.getDimension(context.getResources().getDisplayMetrics()) : BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: b */
    public static int m3615b(ViewConfiguration viewConfiguration) {
        if (VERSION.SDK_INT >= 28) {
            return viewConfiguration.getScaledHoverSlop();
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    /* renamed from: c */
    public static boolean m3616c(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", BleHandshake.DEVICE_TYPE);
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
