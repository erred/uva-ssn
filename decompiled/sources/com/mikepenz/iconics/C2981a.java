package com.mikepenz.iconics;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.mikepenz.iconics.p129b.C2996b;
import com.mikepenz.iconics.p130c.C2997a;
import com.mikepenz.iconics.p130c.C2999c;
import com.mikepenz.iconics.p130c.C3001e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mikepenz.iconics.a */
/* compiled from: Iconics */
public final class C2981a {

    /* renamed from: a */
    public static final String f7762a = "a";

    /* renamed from: b */
    private static boolean f7763b = false;

    /* renamed from: c */
    private static HashMap<String, C2996b> f7764c = new HashMap<>();

    /* renamed from: com.mikepenz.iconics.a$a */
    /* compiled from: Iconics */
    public static class C2982a {

        /* renamed from: a */
        private List<CharacterStyle> f7765a = new LinkedList();

        /* renamed from: b */
        private HashMap<String, List<CharacterStyle>> f7766b = new HashMap<>();

        /* renamed from: c */
        private List<C2996b> f7767c = new LinkedList();

        /* renamed from: d */
        private Context f7768d;

        /* renamed from: a */
        public C2982a mo27307a(Context context) {
            this.f7768d = context;
            return this;
        }

        /* renamed from: a */
        public C2983b mo27308a(TextView textView) {
            C2983b bVar = new C2983b(this.f7768d, this.f7767c, textView, this.f7765a, this.f7766b);
            return bVar;
        }
    }

    /* renamed from: com.mikepenz.iconics.a$b */
    /* compiled from: Iconics */
    public static class C2983b {

        /* renamed from: a */
        private Context f7769a;

        /* renamed from: b */
        private TextView f7770b;

        /* renamed from: c */
        private List<CharacterStyle> f7771c;

        /* renamed from: d */
        private HashMap<String, List<CharacterStyle>> f7772d;

        /* renamed from: e */
        private List<C2996b> f7773e;

        public C2983b(Context context, List<C2996b> list, TextView textView, List<CharacterStyle> list2, HashMap<String, List<CharacterStyle>> hashMap) {
            this.f7769a = context;
            this.f7773e = list;
            this.f7770b = textView;
            this.f7771c = list2;
            this.f7772d = hashMap;
        }

        /* renamed from: a */
        public void mo27309a() {
            HashMap hashMap = new HashMap();
            for (C2996b bVar : this.f7773e) {
                hashMap.put(bVar.getMappingPrefix(), bVar);
            }
            if (this.f7770b.getText() instanceof Spanned) {
                this.f7770b.setText(C2981a.m8782a(this.f7769a, hashMap, (Spanned) this.f7770b.getText(), this.f7771c, this.f7772d));
            } else {
                this.f7770b.setText(C2981a.m8782a(this.f7769a, hashMap, (Spanned) new SpannableString(this.f7770b.getText()), this.f7771c, this.f7772d));
            }
            if (this.f7770b instanceof Button) {
                this.f7770b.setAllCaps(false);
            }
        }
    }

    /* renamed from: a */
    public static void m8785a(Context context) {
        String[] a;
        if (!f7763b) {
            for (String str : C2997a.m8857a(context)) {
                try {
                    C2996b bVar = (C2996b) Class.forName(str).newInstance();
                    m8788a(bVar);
                    f7764c.put(bVar.getMappingPrefix(), bVar);
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Can't init: ");
                    sb.append(str);
                    Log.e("Android-Iconics", sb.toString());
                }
            }
            f7763b = true;
        }
    }

    /* renamed from: a */
    private static HashMap<String, C2996b> m8784a(Context context, HashMap<String, C2996b> hashMap) {
        m8785a(context);
        return (hashMap == null || hashMap.size() == 0) ? f7764c : hashMap;
    }

    /* renamed from: a */
    private static void m8788a(C2996b bVar) {
        if (bVar.getMappingPrefix().length() != 3) {
            throw new IllegalArgumentException("The mapping prefix of a font must be three characters long.");
        }
    }

    /* renamed from: a */
    public static C2996b m8783a(Context context, String str) {
        m8785a(context);
        return (C2996b) f7764c.get(str);
    }

    private C2981a() {
    }

    /* renamed from: a */
    public static Spanned m8782a(Context context, HashMap<String, C2996b> hashMap, Spanned spanned, List<CharacterStyle> list, HashMap<String, List<CharacterStyle>> hashMap2) {
        C3001e a = C2999c.m8862a(spanned, m8784a(context, hashMap));
        SpannableString valueOf = SpannableString.valueOf(a.f7847a);
        C2999c.m8864a(context, valueOf, a.f7848b, list, hashMap2);
        return valueOf;
    }

    /* renamed from: a */
    public static void m8786a(Context context, Editable editable) {
        m8787a(context, null, editable, null, null);
    }

    /* renamed from: a */
    public static void m8787a(Context context, HashMap<String, C2996b> hashMap, Editable editable, List<CharacterStyle> list, HashMap<String, List<CharacterStyle>> hashMap2) {
        C2999c.m8864a(context, editable, C2999c.m8863a(editable, m8784a(context, hashMap)), list, hashMap2);
    }
}
