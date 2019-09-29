package p140me.bridgefy.intro.verification;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.intro.verification.c */
/* compiled from: CountryListAdapter */
final class C3576c extends ArrayAdapter<C3574b> implements SectionIndexer {

    /* renamed from: a */
    private final HashMap<String, Integer> f9394a = new LinkedHashMap();

    /* renamed from: b */
    private final HashMap<String, Integer> f9395b = new LinkedHashMap();

    /* renamed from: c */
    private String[] f9396c;

    public int getSectionForPosition(int i) {
        return 0;
    }

    public C3576c(Context context) {
        super(context, R.layout.fui_dgts_country_row, 16908308);
    }

    /* renamed from: a */
    public void mo29487a(List<C3574b> list) {
        int i = 0;
        for (C3574b bVar : list) {
            String upperCase = bVar.f9391b.getDisplayCountry().substring(0, 1).toUpperCase(Locale.getDefault());
            if (!this.f9394a.containsKey(upperCase)) {
                this.f9394a.put(upperCase, Integer.valueOf(i));
            }
            this.f9395b.put(bVar.f9391b.getDisplayCountry(), Integer.valueOf(i));
            i++;
            add(bVar);
        }
        this.f9396c = new String[this.f9394a.size()];
        this.f9394a.keySet().toArray(this.f9396c);
        notifyDataSetChanged();
    }

    public Object[] getSections() {
        return this.f9396c;
    }

    public int getPositionForSection(int i) {
        if (this.f9396c == null || i <= 0) {
            return 0;
        }
        if (i >= this.f9396c.length) {
            i = this.f9396c.length - 1;
        }
        return ((Integer) this.f9394a.get(this.f9396c[i])).intValue();
    }

    /* renamed from: a */
    public int mo29486a(String str) {
        Integer num = (Integer) this.f9395b.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
