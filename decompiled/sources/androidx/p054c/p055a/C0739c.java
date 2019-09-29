package androidx.p054c.p055a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.c.a.c */
/* compiled from: ResourceCursorAdapter */
public abstract class C0739c extends C0734a {

    /* renamed from: j */
    private int f2126j;

    /* renamed from: k */
    private int f2127k;

    /* renamed from: l */
    private LayoutInflater f2128l;

    @Deprecated
    public C0739c(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2127k = i;
        this.f2126j = i;
        this.f2128l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public View mo2374a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2128l.inflate(this.f2126j, viewGroup, false);
    }

    /* renamed from: b */
    public View mo2917b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2128l.inflate(this.f2127k, viewGroup, false);
    }
}
