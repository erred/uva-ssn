package androidx.p054c.p055a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.j256.ormlite.field.FieldType;

/* renamed from: androidx.c.a.a */
/* compiled from: CursorAdapter */
public abstract class C0734a extends BaseAdapter implements Filterable, C0738a {

    /* renamed from: a */
    protected boolean f2114a;

    /* renamed from: b */
    protected boolean f2115b;

    /* renamed from: c */
    protected Cursor f2116c;

    /* renamed from: d */
    protected Context f2117d;

    /* renamed from: e */
    protected int f2118e;

    /* renamed from: f */
    protected C0735a f2119f;

    /* renamed from: g */
    protected DataSetObserver f2120g;

    /* renamed from: h */
    protected C0737b f2121h;

    /* renamed from: i */
    protected FilterQueryProvider f2122i;

    /* renamed from: androidx.c.a.a$a */
    /* compiled from: CursorAdapter */
    private class C0735a extends ContentObserver {
        public boolean deliverSelfNotifications() {
            return true;
        }

        C0735a() {
            super(new Handler());
        }

        public void onChange(boolean z) {
            C0734a.this.mo2918b();
        }
    }

    /* renamed from: androidx.c.a.a$b */
    /* compiled from: CursorAdapter */
    private class C0736b extends DataSetObserver {
        C0736b() {
        }

        public void onChanged() {
            C0734a.this.f2114a = true;
            C0734a.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            C0734a.this.f2114a = false;
            C0734a.this.notifyDataSetInvalidated();
        }
    }

    /* renamed from: a */
    public abstract View mo2374a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract void mo2377a(View view, Context context, Cursor cursor);

    public boolean hasStableIds() {
        return true;
    }

    public C0734a(Context context, Cursor cursor, boolean z) {
        mo2916a(context, cursor, z ? 1 : 2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2916a(Context context, Cursor cursor, int i) {
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.f2115b = true;
        } else {
            this.f2115b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f2116c = cursor;
        this.f2114a = z;
        this.f2117d = context;
        this.f2118e = z ? cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX) : -1;
        if ((i & 2) == 2) {
            this.f2119f = new C0735a();
            this.f2120g = new C0736b();
        } else {
            this.f2119f = null;
            this.f2120g = null;
        }
        if (z) {
            if (this.f2119f != null) {
                cursor.registerContentObserver(this.f2119f);
            }
            if (this.f2120g != null) {
                cursor.registerDataSetObserver(this.f2120g);
            }
        }
    }

    /* renamed from: a */
    public Cursor mo2915a() {
        return this.f2116c;
    }

    public int getCount() {
        if (!this.f2114a || this.f2116c == null) {
            return 0;
        }
        return this.f2116c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f2114a || this.f2116c == null) {
            return null;
        }
        this.f2116c.moveToPosition(i);
        return this.f2116c;
    }

    public long getItemId(int i) {
        if (!this.f2114a || this.f2116c == null || !this.f2116c.moveToPosition(i)) {
            return 0;
        }
        return this.f2116c.getLong(this.f2118e);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2114a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f2116c.moveToPosition(i)) {
            if (view == null) {
                view = mo2374a(this.f2117d, this.f2116c, viewGroup);
            }
            mo2377a(view, this.f2117d, this.f2116c);
            return view;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("couldn't move cursor to position ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2114a) {
            return null;
        }
        this.f2116c.moveToPosition(i);
        if (view == null) {
            view = mo2917b(this.f2117d, this.f2116c, viewGroup);
        }
        mo2377a(view, this.f2117d, this.f2116c);
        return view;
    }

    /* renamed from: b */
    public View mo2917b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo2374a(context, cursor, viewGroup);
    }

    /* renamed from: a */
    public void mo2376a(Cursor cursor) {
        Cursor c = mo2919c(cursor);
        if (c != null) {
            c.close();
        }
    }

    /* renamed from: c */
    public Cursor mo2919c(Cursor cursor) {
        if (cursor == this.f2116c) {
            return null;
        }
        Cursor cursor2 = this.f2116c;
        if (cursor2 != null) {
            if (this.f2119f != null) {
                cursor2.unregisterContentObserver(this.f2119f);
            }
            if (this.f2120g != null) {
                cursor2.unregisterDataSetObserver(this.f2120g);
            }
        }
        this.f2116c = cursor;
        if (cursor != null) {
            if (this.f2119f != null) {
                cursor.registerContentObserver(this.f2119f);
            }
            if (this.f2120g != null) {
                cursor.registerDataSetObserver(this.f2120g);
            }
            this.f2118e = cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            this.f2114a = true;
            notifyDataSetChanged();
        } else {
            this.f2118e = -1;
            this.f2114a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    /* renamed from: b */
    public CharSequence mo2378b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    /* renamed from: a */
    public Cursor mo2372a(CharSequence charSequence) {
        if (this.f2122i != null) {
            return this.f2122i.runQuery(charSequence);
        }
        return this.f2116c;
    }

    public Filter getFilter() {
        if (this.f2121h == null) {
            this.f2121h = new C0737b(this);
        }
        return this.f2121h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo2918b() {
        if (this.f2115b && this.f2116c != null && !this.f2116c.isClosed()) {
            this.f2114a = this.f2116c.requery();
        }
    }
}
