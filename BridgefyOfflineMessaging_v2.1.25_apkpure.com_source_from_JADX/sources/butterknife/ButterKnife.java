package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ButterKnife {
    static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    @Deprecated
    public interface Action<T extends View> extends Action<T> {
    }

    @Deprecated
    public interface Setter<T extends View, V> extends Setter<T, V> {
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static Unbinder bind(Activity activity) {
        return bind((Object) activity, activity.getWindow().getDecorView());
    }

    public static Unbinder bind(View view) {
        return bind((Object) view, view);
    }

    public static Unbinder bind(Dialog dialog) {
        return bind((Object) dialog, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, View view) {
        Class cls = obj.getClass();
        if (debug) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Looking up binding for ");
            sb.append(cls.getName());
            Log.d(str, sb.toString());
        }
        Constructor findBindingConstructorForClass = findBindingConstructorForClass(cls);
        if (findBindingConstructorForClass == null) {
            return Unbinder.EMPTY;
        }
        try {
            return (Unbinder) findBindingConstructorForClass.newInstance(new Object[]{obj, view});
        } catch (IllegalAccessException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to invoke ");
            sb2.append(findBindingConstructorForClass);
            throw new RuntimeException(sb2.toString(), e);
        } catch (InstantiationException e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to invoke ");
            sb3.append(findBindingConstructorForClass);
            throw new RuntimeException(sb3.toString(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Constructor<? extends Unbinder> constructor2 = (Constructor) BINDINGS.get(cls);
        if (constructor2 != null) {
            if (debug) {
                Log.d(TAG, "HIT: Cached in binding map.");
            }
            return constructor2;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            if (debug) {
                Log.d(TAG, "MISS: Reached framework class. Abandoning search.");
            }
            return null;
        }
        try {
            ClassLoader classLoader = cls.getClassLoader();
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append("_ViewBinding");
            constructor = classLoader.loadClass(sb.toString()).getConstructor(new Class[]{cls, View.class});
            if (debug) {
                Log.d(TAG, "HIT: Loaded binding class and constructor.");
            }
        } catch (ClassNotFoundException unused) {
            if (debug) {
                String str = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Not found. Trying superclass ");
                sb2.append(cls.getSuperclass().getName());
                Log.d(str, sb2.toString());
            }
            constructor = findBindingConstructorForClass(cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to find binding constructor for ");
            sb3.append(name);
            throw new RuntimeException(sb3.toString(), e);
        }
        BINDINGS.put(cls, constructor);
        return constructor;
    }

    @Deprecated
    @SafeVarargs
    public static <T extends View> void apply(List<T> list, Action<? super T>... actionArr) {
        ViewCollections.run(list, (Action<? super T>[]) actionArr);
    }

    @Deprecated
    @SafeVarargs
    public static <T extends View> void apply(T[] tArr, Action<? super T>... actionArr) {
        ViewCollections.run(tArr, (Action<? super T>[]) actionArr);
    }

    @Deprecated
    public static <T extends View> void apply(List<T> list, Action<? super T> action) {
        ViewCollections.run(list, (Action<? super T>) action);
    }

    @Deprecated
    public static <T extends View> void apply(T[] tArr, Action<? super T> action) {
        ViewCollections.run(tArr, (Action<? super T>) action);
    }

    @Deprecated
    @SafeVarargs
    public static <T extends View> void apply(T t, Action<? super T>... actionArr) {
        ViewCollections.run(t, (Action<? super T>[]) actionArr);
    }

    @Deprecated
    public static <T extends View> void apply(T t, Action<? super T> action) {
        ViewCollections.run(t, (Action<? super T>) action);
    }

    @Deprecated
    public static <T extends View, V> void apply(List<T> list, Setter<? super T, V> setter, V v) {
        ViewCollections.set(list, (Setter<? super T, V>) setter, v);
    }

    @Deprecated
    public static <T extends View, V> void apply(T[] tArr, Setter<? super T, V> setter, V v) {
        ViewCollections.set(tArr, (Setter<? super T, V>) setter, v);
    }

    @Deprecated
    public static <T extends View, V> void apply(T t, Setter<? super T, V> setter, V v) {
        ViewCollections.set(t, (Setter<? super T, V>) setter, v);
    }

    @Deprecated
    public static <T extends View, V> void apply(List<T> list, Property<? super T, V> property, V v) {
        ViewCollections.set(list, property, v);
    }

    @Deprecated
    public static <T extends View, V> void apply(T[] tArr, Property<? super T, V> property, V v) {
        ViewCollections.set(tArr, property, v);
    }

    @Deprecated
    public static <T extends View, V> void apply(T t, Property<? super T, V> property, V v) {
        ViewCollections.set(t, property, v);
    }
}
