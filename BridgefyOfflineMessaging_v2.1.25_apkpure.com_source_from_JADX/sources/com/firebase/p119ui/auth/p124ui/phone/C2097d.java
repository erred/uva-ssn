package com.firebase.p119ui.auth.p124ui.phone;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import com.firebase.ui.auth.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* renamed from: com.firebase.ui.auth.ui.phone.d */
/* compiled from: CountryListAdapter */
final class C2097d extends ArrayAdapter<C2096c> implements SectionIndexer {

    /* renamed from: a */
    private final HashMap<String, Integer> f6442a = new LinkedHashMap();

    /* renamed from: b */
    private final HashMap<String, Integer> f6443b = new LinkedHashMap();

    /* renamed from: c */
    private String[] f6444c;

    public int getSectionForPosition(int i) {
        return 0;
    }

    public C2097d(Context context) {
        super(context, R.layout.fui_dgts_country_row, 16908308);
    }

    /* renamed from: a */
    public void mo11950a(List<C2096c> list) {
        int i = 0;
        for (C2096c cVar : list) {
            String upperCase = cVar.f6439a.getDisplayCountry().substring(0, 1).toUpperCase(Locale.getDefault());
            if (!this.f6442a.containsKey(upperCase)) {
                this.f6442a.put(upperCase, Integer.valueOf(i));
            }
            this.f6443b.put(cVar.f6439a.getDisplayCountry(), Integer.valueOf(i));
            i++;
            add(cVar);
        }
        this.f6444c = new String[this.f6442a.size()];
        this.f6442a.keySet().toArray(this.f6444c);
        notifyDataSetChanged();
    }

    public Object[] getSections() {
        return this.f6444c;
    }

    public int getPositionForSection(int i) {
        if (this.f6444c == null || i <= 0) {
            return 0;
        }
        if (i >= this.f6444c.length) {
            i = this.f6444c.length - 1;
        }
        return ((Integer) this.f6442a.get(this.f6444c[i])).intValue();
    }

    /* renamed from: a */
    public int mo11949a(String str) {
        Integer num = (Integer) this.f6443b.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
