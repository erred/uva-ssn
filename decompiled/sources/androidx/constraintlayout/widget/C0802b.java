package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Xml;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.constraintlayout.widget.b */
/* compiled from: ConstraintAttribute */
public class C0802b {

    /* renamed from: a */
    String f2545a;

    /* renamed from: b */
    boolean f2546b;

    /* renamed from: c */
    private C0804a f2547c;

    /* renamed from: d */
    private int f2548d;

    /* renamed from: e */
    private float f2549e;

    /* renamed from: f */
    private String f2550f;

    /* renamed from: g */
    private int f2551g;

    /* renamed from: androidx.constraintlayout.widget.b$a */
    /* compiled from: ConstraintAttribute */
    public enum C0804a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public C0802b(String str, C0804a aVar, Object obj) {
        this.f2545a = str;
        this.f2547c = aVar;
        mo3275a(obj);
    }

    public C0802b(C0802b bVar, Object obj) {
        this.f2545a = bVar.f2545a;
        this.f2547c = bVar.f2547c;
        mo3275a(obj);
    }

    /* renamed from: a */
    public void mo3275a(Object obj) {
        switch (this.f2547c) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.f2551g = ((Integer) obj).intValue();
                return;
            case INT_TYPE:
                this.f2548d = ((Integer) obj).intValue();
                return;
            case FLOAT_TYPE:
                this.f2549e = ((Float) obj).floatValue();
                return;
            case STRING_TYPE:
                this.f2550f = (String) obj;
                return;
            case BOOLEAN_TYPE:
                this.f2546b = ((Boolean) obj).booleanValue();
                return;
            case DIMENSION_TYPE:
                this.f2549e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public static HashMap<String, C0802b> m3001a(HashMap<String, C0802b> hashMap, View view) {
        HashMap<String, C0802b> hashMap2 = new HashMap<>();
        Class cls = view.getClass();
        for (String str : hashMap.keySet()) {
            C0802b bVar = (C0802b) hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new C0802b(bVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getMap");
                    sb.append(str);
                    hashMap2.put(str, new C0802b(bVar, cls.getMethod(sb.toString(), new Class[0]).invoke(view, new Object[0])));
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return hashMap2;
    }

    /* renamed from: a */
    public static void m3003a(View view, HashMap<String, C0802b> hashMap) {
        Class cls = view.getClass();
        for (String str : hashMap.keySet()) {
            C0802b bVar = (C0802b) hashMap.get(str);
            StringBuilder sb = new StringBuilder();
            sb.append("set");
            sb.append(str);
            String sb2 = sb.toString();
            try {
                switch (bVar.f2547c) {
                    case COLOR_TYPE:
                        cls.getMethod(sb2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(bVar.f2551g)});
                        break;
                    case COLOR_DRAWABLE_TYPE:
                        Method method = cls.getMethod(sb2, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(bVar.f2551g);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case INT_TYPE:
                        cls.getMethod(sb2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(bVar.f2548d)});
                        break;
                    case FLOAT_TYPE:
                        cls.getMethod(sb2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(bVar.f2549e)});
                        break;
                    case STRING_TYPE:
                        cls.getMethod(sb2, new Class[]{CharSequence.class}).invoke(view, new Object[]{bVar.f2550f});
                        break;
                    case BOOLEAN_TYPE:
                        cls.getMethod(sb2, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(bVar.f2546b)});
                        break;
                    case DIMENSION_TYPE:
                        cls.getMethod(sb2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(bVar.f2549e)});
                        break;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m3002a(Context context, XmlPullParser xmlPullParser, HashMap<String, C0802b> hashMap) {
        C0804a aVar;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        C0804a aVar2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Character.toUpperCase(str.charAt(0)));
                    sb.append(str.substring(1));
                    str = sb.toString();
                }
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar2 = C0804a.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    aVar = C0804a.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    aVar = C0804a.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    aVar = C0804a.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, BitmapDescriptorFactory.HUE_RED));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    aVar = C0804a.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    aVar = C0804a.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    aVar = C0804a.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                Object obj2 = string;
                aVar2 = aVar;
                obj = obj2;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new C0802b(str, aVar2, obj));
        }
        obtainStyledAttributes.recycle();
    }
}
