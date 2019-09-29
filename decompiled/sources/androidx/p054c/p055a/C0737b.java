package androidx.p054c.p055a;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: androidx.c.a.b */
/* compiled from: CursorFilter */
class C0737b extends Filter {

    /* renamed from: a */
    C0738a f2125a;

    /* renamed from: androidx.c.a.b$a */
    /* compiled from: CursorFilter */
    interface C0738a {
        /* renamed from: a */
        Cursor mo2915a();

        /* renamed from: a */
        Cursor mo2372a(CharSequence charSequence);

        /* renamed from: a */
        void mo2376a(Cursor cursor);

        /* renamed from: b */
        CharSequence mo2378b(Cursor cursor);
    }

    C0737b(C0738a aVar) {
        this.f2125a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f2125a.mo2378b((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f2125a.mo2372a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f2125a.mo2915a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f2125a.mo2376a((Cursor) filterResults.values);
        }
    }
}
