package com.mikepenz.iconics.p130c;

import android.content.Context;
import android.text.Editable;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;
import com.mikepenz.iconics.C2981a;
import com.mikepenz.iconics.p129b.C2995a;
import com.mikepenz.iconics.p129b.C2996b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mikepenz.iconics.c.c */
/* compiled from: IconicsUtils */
public class C2999c {

    /* renamed from: a */
    public static char f7838a = '{';

    /* renamed from: b */
    public static char f7839b = '}';

    /* renamed from: a */
    public static LinkedList<C3000d> m8863a(Editable editable, HashMap<String, C2996b> hashMap) {
        ParcelableSpan[] parcelableSpanArr;
        CharacterStyle[] characterStyleArr;
        LinkedList<C3000d> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        int i = 0;
        for (ParcelableSpan parcelableSpan : (ParcelableSpan[]) editable.getSpans(0, editable.length(), ParcelableSpan.class)) {
            linkedList2.add(new C3000d(editable.getSpanStart(parcelableSpan), editable.getSpanEnd(parcelableSpan), parcelableSpan, editable.getSpanFlags(parcelableSpan)));
        }
        for (CharacterStyle characterStyle : (CharacterStyle[]) editable.getSpans(0, editable.length(), CharacterStyle.class)) {
            linkedList2.add(new C3000d(editable.getSpanStart(characterStyle), editable.getSpanEnd(characterStyle), characterStyle, editable.getSpanFlags(characterStyle)));
        }
        try {
            editable.clearSpans();
        } catch (Exception unused) {
        }
        int i2 = -1;
        while (i < editable.length()) {
            Character valueOf = Character.valueOf(editable.charAt(i));
            if (valueOf.charValue() == f7838a) {
                i2 = i;
            } else if (valueOf.charValue() == f7839b) {
                if (i2 > -1) {
                    C3000d a = m8860a(editable, i2, i, hashMap);
                    if (a != null) {
                        linkedList.add(a);
                        Iterator it = linkedList2.iterator();
                        while (it.hasNext()) {
                            C3000d dVar = (C3000d) it.next();
                            if (dVar.f7840a > i) {
                                int i3 = i - i2;
                                dVar.f7840a -= i3;
                                dVar.f7841b -= i3;
                            } else if (dVar.f7841b > i) {
                                dVar.f7841b -= i - i2;
                            }
                        }
                        i = i2;
                    }
                }
                i2 = -1;
            }
            i++;
        }
        linkedList.addAll(linkedList2);
        return linkedList;
    }

    /* renamed from: a */
    private static C3000d m8860a(Editable editable, int i, int i2, HashMap<String, C2996b> hashMap) {
        if (i2 - i >= 6) {
            int i3 = i + 1;
            String replace = editable.subSequence(i3, i2).toString().replace("-", "_");
            String charSequence = editable.subSequence(i3, i + 4).toString();
            try {
                C2996b bVar = (C2996b) hashMap.get(charSequence);
                if (bVar != null) {
                    C2995a icon = bVar.getIcon(replace);
                    if (icon != null) {
                        editable.replace(i, i2 + 1, String.valueOf(icon.mo27305a()));
                        return new C3000d(i, i3, replace, (C2996b) hashMap.get(charSequence));
                    }
                    String str = C2981a.f7762a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Wrong icon name: ");
                    sb.append(replace);
                    Log.e(str, sb.toString());
                } else {
                    String str2 = C2981a.f7762a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Wrong fontId: ");
                    sb2.append(replace);
                    Log.e(str2, sb2.toString());
                }
            } catch (IllegalArgumentException unused) {
                String str3 = C2981a.f7762a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Wrong icon name: ");
                sb3.append(replace);
                Log.e(str3, sb3.toString());
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C3001e m8862a(Spanned spanned, HashMap<String, C2996b> hashMap) {
        ParcelableSpan[] parcelableSpanArr;
        CharacterStyle[] characterStyleArr;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (ParcelableSpan parcelableSpan : (ParcelableSpan[]) spanned.getSpans(0, spanned.length(), ParcelableSpan.class)) {
            linkedList2.add(new C3000d(spanned.getSpanStart(parcelableSpan), spanned.getSpanEnd(parcelableSpan), parcelableSpan, spanned.getSpanFlags(parcelableSpan)));
        }
        for (CharacterStyle characterStyle : (CharacterStyle[]) spanned.getSpans(0, spanned.length(), CharacterStyle.class)) {
            linkedList2.add(new C3000d(spanned.getSpanStart(characterStyle), spanned.getSpanEnd(characterStyle), characterStyle, spanned.getSpanFlags(characterStyle)));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < spanned.length(); i2++) {
            Character valueOf = Character.valueOf(spanned.charAt(i2));
            if (valueOf.charValue() == f7838a) {
                spannableStringBuilder.append(spannableStringBuilder2);
                spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append(valueOf.charValue());
            } else if (valueOf.charValue() == f7839b) {
                spannableStringBuilder2.append(valueOf.charValue());
                if (spannableStringBuilder2.length() > 5) {
                    C3000d a = m8861a(spannableStringBuilder, spannableStringBuilder2, hashMap);
                    if (a != null) {
                        linkedList.add(a);
                        Iterator it = linkedList2.iterator();
                        while (it.hasNext()) {
                            C3000d dVar = (C3000d) it.next();
                            int i3 = i2 - i;
                            if (dVar.f7840a > i3) {
                                dVar.f7840a = (dVar.f7840a - spannableStringBuilder2.length()) + 1;
                            }
                            if (dVar.f7841b > i3) {
                                dVar.f7841b = (dVar.f7841b - spannableStringBuilder2.length()) + 1;
                            }
                        }
                        i += spannableStringBuilder2.length() - 1;
                    }
                } else {
                    spannableStringBuilder.append(spannableStringBuilder2);
                }
                spannableStringBuilder2 = new SpannableStringBuilder();
            } else if (spannableStringBuilder2.length() == 0) {
                spannableStringBuilder.append(valueOf.charValue());
            } else {
                spannableStringBuilder2.append(valueOf.charValue());
            }
        }
        spannableStringBuilder.append(spannableStringBuilder2);
        linkedList.addAll(linkedList2);
        return new C3001e(spannableStringBuilder, linkedList);
    }

    /* renamed from: a */
    private static C3000d m8861a(SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, HashMap<String, C2996b> hashMap) {
        if (spannableStringBuilder2.length() >= 6) {
            String replace = spannableStringBuilder2.subSequence(1, spannableStringBuilder2.length() - 1).toString().replace("-", "_");
            String charSequence = spannableStringBuilder2.subSequence(1, 4).toString();
            try {
                C2996b bVar = (C2996b) hashMap.get(charSequence);
                if (bVar != null) {
                    C2995a icon = bVar.getIcon(replace);
                    if (icon != null) {
                        spannableStringBuilder.append(icon.mo27305a());
                        return new C3000d(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), replace, (C2996b) hashMap.get(charSequence));
                    }
                    String str = C2981a.f7762a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Wrong icon name: ");
                    sb.append(replace);
                    Log.e(str, sb.toString());
                } else {
                    String str2 = C2981a.f7762a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Wrong fontId: ");
                    sb2.append(replace);
                    Log.e(str2, sb2.toString());
                }
            } catch (IllegalArgumentException unused) {
                String str3 = C2981a.f7762a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Wrong icon name: ");
                sb3.append(replace);
                Log.e(str3, sb3.toString());
            }
        }
        spannableStringBuilder.append(spannableStringBuilder2);
        return null;
    }

    /* renamed from: a */
    public static void m8864a(Context context, Spannable spannable, List<C3000d> list, List<CharacterStyle> list2, HashMap<String, List<CharacterStyle>> hashMap) {
        for (C3000d dVar : list) {
            if (dVar.f7845f != null) {
                spannable.setSpan(dVar.f7845f, dVar.f7840a, dVar.f7841b, dVar.f7846g);
            } else if (dVar.f7844e != null) {
                spannable.setSpan(dVar.f7844e, dVar.f7840a, dVar.f7841b, dVar.f7846g);
            } else {
                spannable.setSpan(new C2998b("sans-serif", dVar.f7843d.getTypeface(context)), dVar.f7840a, dVar.f7841b, 33);
            }
            if (hashMap != null && hashMap.containsKey(dVar.f7842c)) {
                for (CharacterStyle wrap : (List) hashMap.get(dVar.f7842c)) {
                    spannable.setSpan(CharacterStyle.wrap(wrap), dVar.f7840a, dVar.f7841b, dVar.f7846g);
                }
            } else if (list2 != null) {
                for (CharacterStyle wrap2 : list2) {
                    spannable.setSpan(CharacterStyle.wrap(wrap2), dVar.f7840a, dVar.f7841b, dVar.f7846g);
                }
            }
        }
    }
}
