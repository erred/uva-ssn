package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.R;
import androidx.appcompat.view.C0508d;
import androidx.appcompat.widget.C0642as;
import androidx.appcompat.widget.C0674e;
import androidx.appcompat.widget.C0676g;
import androidx.appcompat.widget.C0677h;
import androidx.appcompat.widget.C0678i;
import androidx.appcompat.widget.C0686l;
import androidx.appcompat.widget.C0688n;
import androidx.appcompat.widget.C0690p;
import androidx.appcompat.widget.C0691q;
import androidx.appcompat.widget.C0694t;
import androidx.appcompat.widget.C0695u;
import androidx.appcompat.widget.C0696v;
import androidx.appcompat.widget.C0698x;
import androidx.appcompat.widget.C0707z;
import androidx.core.p070g.C0962r;
import androidx.p052b.C0712a;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new C0712a();
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {16843375};
    private final Object[] mConstructorArgs = new Object[2];

    /* renamed from: androidx.appcompat.app.AppCompatViewInflater$a */
    private static class C0439a implements OnClickListener {

        /* renamed from: a */
        private final View f969a;

        /* renamed from: b */
        private final String f970b;

        /* renamed from: c */
        private Method f971c;

        /* renamed from: d */
        private Context f972d;

        public C0439a(View view, String str) {
            this.f969a = view;
            this.f970b = str;
        }

        public void onClick(View view) {
            if (this.f971c == null) {
                m1304a(this.f969a.getContext(), this.f970b);
            }
            try {
                this.f971c.invoke(this.f972d, new Object[]{view});
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        /* renamed from: a */
        private void m1304a(Context context, String str) {
            String str2;
            while (context != null) {
                try {
                    if (!context.isRestricted()) {
                        Method method = context.getClass().getMethod(this.f970b, new Class[]{View.class});
                        if (method != null) {
                            this.f971c = method;
                            this.f972d = context;
                            return;
                        }
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f969a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(" with id '");
                sb.append(this.f969a.getContext().getResources().getResourceEntryName(id));
                sb.append("'");
                str2 = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find method ");
            sb2.append(this.f970b);
            sb2.append("(View) in a parent or ancestor Context for android:onClick ");
            sb2.append("attribute defined on view ");
            sb2.append(this.f969a.getClass());
            sb2.append(str2);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View view2;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = C0642as.m2225a(context2);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                view2 = createTextView(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 1:
                view2 = createImageView(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 2:
                view2 = createButton(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 3:
                view2 = createEditText(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 4:
                view2 = createSpinner(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 5:
                view2 = createImageButton(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 6:
                view2 = createCheckBox(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 7:
                view2 = createRadioButton(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 8:
                view2 = createCheckedTextView(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 9:
                view2 = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 10:
                view2 = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 11:
                view2 = createRatingBar(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            case 12:
                view2 = createSeekBar(context2, attributeSet);
                verifyNotNull(view2, str);
                break;
            default:
                view2 = createView(context2, str, attributeSet);
                break;
        }
        if (view2 == null && context != context2) {
            view2 = createViewFromTag(context2, str, attributeSet);
        }
        if (view2 != null) {
            checkOnClickListener(view2, attributeSet);
        }
        return view2;
    }

    /* access modifiers changed from: protected */
    public C0707z createTextView(Context context, AttributeSet attributeSet) {
        return new C0707z(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0690p createImageView(Context context, AttributeSet attributeSet) {
        return new C0690p(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0676g createButton(Context context, AttributeSet attributeSet) {
        return new C0676g(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0686l createEditText(Context context, AttributeSet attributeSet) {
        return new C0686l(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0698x createSpinner(Context context, AttributeSet attributeSet) {
        return new C0698x(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0688n createImageButton(Context context, AttributeSet attributeSet) {
        return new C0688n(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0677h createCheckBox(Context context, AttributeSet attributeSet) {
        return new C0677h(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0694t createRadioButton(Context context, AttributeSet attributeSet) {
        return new C0694t(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0678i createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new C0678i(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0674e createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new C0674e(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0691q createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new C0691q(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0695u createRatingBar(Context context, AttributeSet attributeSet) {
        return new C0695u(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0696v createSeekBar(Context context, AttributeSet attributeSet) {
        return new C0696v(context, attributeSet);
    }

    private void verifyNotNull(View view, String str) {
        if (view == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(" asked to inflate view for <");
            sb.append(str);
            sb.append(">, but returned null");
            throw new IllegalStateException(sb.toString());
        }
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(Promotion.ACTION_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String createViewByPrefix : sClassPrefixList) {
                    View createViewByPrefix2 = createViewByPrefix(context, str, createViewByPrefix);
                    if (createViewByPrefix2 != null) {
                        return createViewByPrefix2;
                    }
                }
                this.mConstructorArgs[0] = null;
                this.mConstructorArgs[1] = null;
                return null;
            }
            View createViewByPrefix3 = createViewByPrefix(context, str, null);
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            return createViewByPrefix3;
        } catch (Exception unused) {
            return null;
        } finally {
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && (VERSION.SDK_INT < 15 || C0962r.m3544D(view))) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0439a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Constructor constructor = (Constructor) sConstructorMap.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    str3 = sb.toString();
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }

    private static Context themifyContext(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(R.styleable.View_theme, 0);
            if (resourceId != 0) {
                Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return (!(context instanceof C0508d) || ((C0508d) context).mo1254a() != resourceId) ? new C0508d(context, resourceId) : context;
        }
        return context;
    }
}
