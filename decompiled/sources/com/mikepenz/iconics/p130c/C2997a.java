package com.mikepenz.iconics.p130c;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* renamed from: com.mikepenz.iconics.c.a */
/* compiled from: GenericsUtil */
public class C2997a {
    /* renamed from: a */
    public static String[] m8857a(Context context) {
        Class a = m8855a(context.getPackageName());
        if (a != null) {
            return m8858a(context, a.getFields());
        }
        return new String[0];
    }

    /* renamed from: a */
    private static Class m8855a(String str) {
        do {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".R$string");
                return Class.forName(sb.toString());
            } catch (ClassNotFoundException unused) {
                str = str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : "";
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
            }
        } while (TextUtils.isEmpty(str));
        return null;
    }

    /* renamed from: a */
    private static String[] m8858a(Context context, Field[] fieldArr) {
        ArrayList arrayList = new ArrayList();
        for (Field field : fieldArr) {
            if (field.getName().contains("define_font_")) {
                arrayList.add(m8856a(context, field.getName()));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    private static String m8856a(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
        if (identifier == 0) {
            return "";
        }
        return context.getString(identifier);
    }
}
