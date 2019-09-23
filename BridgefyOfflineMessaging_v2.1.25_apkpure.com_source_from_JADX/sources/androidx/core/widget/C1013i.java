package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.p068e.C0911c;
import androidx.core.p068e.C0911c.C0912a;
import androidx.core.p068e.C0911c.C0912a.C0913a;
import androidx.core.p069f.C0930e;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.core.widget.i */
/* compiled from: TextViewCompat */
public final class C1013i {

    /* renamed from: a */
    private static Field f3154a;

    /* renamed from: b */
    private static boolean f3155b;

    /* renamed from: c */
    private static Field f3156c;

    /* renamed from: d */
    private static boolean f3157d;

    /* renamed from: androidx.core.widget.i$a */
    /* compiled from: TextViewCompat */
    private static class C1014a implements Callback {

        /* renamed from: a */
        private final Callback f3158a;

        /* renamed from: b */
        private final TextView f3159b;

        /* renamed from: c */
        private Class f3160c;

        /* renamed from: d */
        private Method f3161d;

        /* renamed from: e */
        private boolean f3162e;

        /* renamed from: f */
        private boolean f3163f = false;

        C1014a(Callback callback, TextView textView) {
            this.f3158a = callback;
            this.f3159b = textView;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f3158a.onCreateActionMode(actionMode, menu);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            m3880a(menu);
            return this.f3158a.onPrepareActionMode(actionMode, menu);
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f3158a.onActionItemClicked(actionMode, menuItem);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f3158a.onDestroyActionMode(actionMode);
        }

        /* renamed from: a */
        private void m3880a(Menu menu) {
            Method method;
            Context context = this.f3159b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f3163f) {
                this.f3163f = true;
                try {
                    this.f3160c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f3161d = this.f3160c.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f3162e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f3160c = null;
                    this.f3161d = null;
                    this.f3162e = false;
                }
            }
            try {
                if (!this.f3162e || !this.f3160c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f3161d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List a = m3879a(context, packageManager);
                for (int i = 0; i < a.size(); i++) {
                    ResolveInfo resolveInfo = (ResolveInfo) a.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(m3878a(resolveInfo, this.f3159b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        /* renamed from: a */
        private List<ResolveInfo> m3879a(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(m3877a(), 0)) {
                if (m3881a(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        private boolean m3881a(ResolveInfo resolveInfo, Context context) {
            boolean z = true;
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (!resolveInfo.activityInfo.exported) {
                return false;
            }
            if (!(resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0)) {
                z = false;
            }
            return z;
        }

        /* renamed from: a */
        private Intent m3878a(ResolveInfo resolveInfo, TextView textView) {
            return m3877a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !m3882a(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        /* renamed from: a */
        private boolean m3882a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* renamed from: a */
        private Intent m3877a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    /* renamed from: a */
    private static Field m3864a(String str) {
        Field field;
        try {
            field = TextView.class.getDeclaredField(str);
            try {
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        } catch (NoSuchFieldException unused2) {
            field = null;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve ");
            sb.append(str);
            sb.append(" field.");
            Log.e("TextViewCompat", sb.toString());
            return field;
        }
        return field;
    }

    /* renamed from: a */
    private static int m3862a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve value of ");
            sb.append(field.getName());
            sb.append(" field.");
            Log.d("TextViewCompat", sb.toString());
            return -1;
        }
    }

    /* renamed from: a */
    public static void m3866a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (VERSION.SDK_INT >= 17) {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: a */
    public static int m3861a(TextView textView) {
        if (VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f3157d) {
            f3156c = m3864a("mMaxMode");
            f3157d = true;
        }
        if (f3156c != null && m3862a(f3156c, textView) == 1) {
            if (!f3155b) {
                f3154a = m3864a("mMaximum");
                f3155b = true;
            }
            if (f3154a != null) {
                return m3862a(f3154a, textView);
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m3865a(TextView textView, int i) {
        if (VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    /* renamed from: b */
    public static Drawable[] m3870b(TextView textView) {
        if (VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (VERSION.SDK_INT < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z = true;
        if (textView.getLayoutDirection() != 1) {
            z = false;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    /* renamed from: a */
    public static Callback m3863a(TextView textView, Callback callback) {
        return (VERSION.SDK_INT < 26 || VERSION.SDK_INT > 27 || (callback instanceof C1014a)) ? callback : new C1014a(callback, textView);
    }

    /* renamed from: b */
    public static void m3869b(TextView textView, int i) {
        int i2;
        C0930e.m3402a(i);
        if (VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i - (-i2), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* renamed from: c */
    public static void m3872c(TextView textView, int i) {
        int i2;
        C0930e.m3402a(i);
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    /* renamed from: c */
    public static int m3871c(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* renamed from: d */
    public static int m3873d(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* renamed from: d */
    public static void m3874d(TextView textView, int i) {
        C0930e.m3402a(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
        }
    }

    /* renamed from: e */
    public static C0912a m3875e(TextView textView) {
        if (VERSION.SDK_INT >= 28) {
            return new C0912a(textView.getTextMetricsParams());
        }
        C0913a aVar = new C0913a(new TextPaint(textView.getPaint()));
        if (VERSION.SDK_INT >= 23) {
            aVar.mo3637a(textView.getBreakStrategy());
            aVar.mo3640b(textView.getHyphenationFrequency());
        }
        if (VERSION.SDK_INT >= 18) {
            aVar.mo3638a(m3876f(textView));
        }
        return aVar.mo3639a();
    }

    /* renamed from: a */
    public static void m3867a(TextView textView, C0912a aVar) {
        if (VERSION.SDK_INT >= 18) {
            textView.setTextDirection(m3860a(aVar.mo3631b()));
        }
        if (VERSION.SDK_INT < 23) {
            float textScaleX = aVar.mo3629a().getTextScaleX();
            textView.getPaint().set(aVar.mo3629a());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.mo3629a());
        textView.setBreakStrategy(aVar.mo3632c());
        textView.setHyphenationFrequency(aVar.mo3633d());
    }

    /* renamed from: a */
    public static void m3868a(TextView textView, C0911c cVar) {
        if (m3875e(textView).mo3630a(cVar.mo3617a())) {
            textView.setText(cVar);
            return;
        }
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    /* renamed from: f */
    private static TextDirectionHeuristic m3876f(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z = false;
        if (VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    return z ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
    }

    /* renamed from: a */
    private static int m3860a(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return 1;
    }
}
