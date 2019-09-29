package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.C3176g;
import com.twitter.sdk.android.core.internal.C3177h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.g */
/* compiled from: EventsFilesManager */
public abstract class C3218g<T> {

    /* renamed from: a */
    protected final Context f8435a;

    /* renamed from: b */
    protected final C3217f<T> f8436b;

    /* renamed from: c */
    protected final C3177h f8437c;

    /* renamed from: d */
    protected final C3225j f8438d;

    /* renamed from: e */
    protected volatile long f8439e;

    /* renamed from: f */
    protected final List<C3226k> f8440f = new CopyOnWriteArrayList();

    /* renamed from: g */
    private final int f8441g;

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.g$a */
    /* compiled from: EventsFilesManager */
    static class C3220a {

        /* renamed from: a */
        final File f8443a;

        /* renamed from: b */
        final long f8444b;

        public C3220a(File file, long j) {
            this.f8443a = file;
            this.f8444b = j;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo27796b();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo27798d() {
        return 8000;
    }

    public C3218g(Context context, C3217f<T> fVar, C3177h hVar, C3225j jVar, int i) throws IOException {
        this.f8435a = context.getApplicationContext();
        this.f8436b = fVar;
        this.f8438d = jVar;
        this.f8437c = hVar;
        this.f8439e = this.f8437c.mo27698a();
        this.f8441g = i;
    }

    /* renamed from: a */
    public void mo27793a(T t) throws IOException {
        byte[] a = this.f8436b.mo27790a(t);
        m9436a(a.length);
        this.f8438d.mo27812a(a);
    }

    /* renamed from: a */
    public void mo27792a(C3226k kVar) {
        if (kVar != null) {
            this.f8440f.add(kVar);
        }
    }

    /* renamed from: a */
    public boolean mo27795a() throws IOException {
        String str;
        boolean z = true;
        if (!this.f8438d.mo27814b()) {
            str = mo27796b();
            this.f8438d.mo27810a(str);
            C3176g.m9301a(this.f8435a, 4, "Twitter", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f8439e = this.f8437c.mo27698a();
        } else {
            str = null;
            z = false;
        }
        m9437b(str);
        return z;
    }

    /* renamed from: a */
    private void m9436a(int i) throws IOException {
        if (!this.f8438d.mo27813a(i, mo27798d())) {
            C3176g.m9301a(this.f8435a, 4, "Twitter", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f8438d.mo27808a()), Integer.valueOf(i), Integer.valueOf(mo27798d())}));
            mo27795a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo27797c() {
        return this.f8441g;
    }

    /* renamed from: b */
    private void m9437b(String str) {
        for (C3226k a : this.f8440f) {
            try {
                a.mo27805a(str);
            } catch (Exception e) {
                C3176g.m9303a(this.f8435a, "One of the roll over listeners threw an exception", (Throwable) e);
            }
        }
    }

    /* renamed from: e */
    public List<File> mo27799e() {
        return this.f8438d.mo27809a(1);
    }

    /* renamed from: a */
    public void mo27794a(List<File> list) {
        this.f8438d.mo27811a(list);
    }

    /* renamed from: f */
    public void mo27800f() {
        List<File> c = this.f8438d.mo27815c();
        int c2 = mo27797c();
        if (c.size() > c2) {
            int size = c.size() - c2;
            C3176g.m9302a(this.f8435a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(c2), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new Comparator<C3220a>() {
                /* renamed from: a */
                public int compare(C3220a aVar, C3220a aVar2) {
                    return (int) (aVar.f8444b - aVar2.f8444b);
                }
            });
            for (File file : c) {
                treeSet.add(new C3220a(file, mo27791a(file.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3220a) it.next()).f8443a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f8438d.mo27811a((List<File>) arrayList);
        }
    }

    /* renamed from: a */
    public long mo27791a(String str) {
        String[] split = str.split("_");
        if (split.length != 3) {
            return 0;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
