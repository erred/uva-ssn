package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;

/* renamed from: a.a.a.a.a.d.b */
/* compiled from: EventsFilesManager */
public abstract class C0076b<T> {

    /* renamed from: a */
    protected final Context f157a;

    /* renamed from: b */
    protected final C0075a<T> f158b;

    /* renamed from: c */
    protected final C0025k f159c;

    /* renamed from: d */
    protected final C0079c f160d;

    /* renamed from: e */
    protected volatile long f161e;

    /* renamed from: f */
    protected final List<C0080d> f162f = new CopyOnWriteArrayList();

    /* renamed from: g */
    private final int f163g;

    /* renamed from: a.a.a.a.a.d.b$a */
    /* compiled from: EventsFilesManager */
    static class C0078a {

        /* renamed from: a */
        final File f165a;

        /* renamed from: b */
        final long f166b;

        public C0078a(File file, long j) {
            this.f165a = file;
            this.f166b = j;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo156a();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo161c() {
        return 8000;
    }

    public C0076b(Context context, C0075a<T> aVar, C0025k kVar, C0079c cVar, int i) throws IOException {
        this.f157a = context.getApplicationContext();
        this.f158b = aVar;
        this.f160d = cVar;
        this.f159c = kVar;
        this.f161e = this.f159c.mo49a();
        this.f163g = i;
    }

    /* renamed from: a */
    public void mo158a(T t) throws IOException {
        byte[] a = this.f158b.mo154a(t);
        m239a(a.length);
        this.f160d.mo172a(a);
    }

    /* renamed from: a */
    public void mo157a(C0080d dVar) {
        if (dVar != null) {
            this.f162f.add(dVar);
        }
    }

    /* renamed from: d */
    public boolean mo162d() throws IOException {
        String str;
        boolean z = true;
        if (!this.f160d.mo174b()) {
            str = mo156a();
            this.f160d.mo170a(str);
            C0020i.m66a(this.f157a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f161e = this.f159c.mo49a();
        } else {
            str = null;
            z = false;
        }
        m240b(str);
        return z;
    }

    /* renamed from: a */
    private void m239a(int i) throws IOException {
        if (!this.f160d.mo173a(i, mo161c())) {
            C0020i.m66a(this.f157a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f160d.mo168a()), Integer.valueOf(i), Integer.valueOf(mo161c())}));
            mo162d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo160b() {
        return this.f163g;
    }

    /* renamed from: b */
    private void m240b(String str) {
        for (C0080d a : this.f162f) {
            try {
                a.mo177a(str);
            } catch (Exception e) {
                C0020i.m68a(this.f157a, "One of the roll over listeners threw an exception", (Throwable) e);
            }
        }
    }

    /* renamed from: e */
    public List<File> mo163e() {
        return this.f160d.mo169a(1);
    }

    /* renamed from: a */
    public void mo159a(List<File> list) {
        this.f160d.mo171a(list);
    }

    /* renamed from: f */
    public void mo164f() {
        this.f160d.mo171a(this.f160d.mo175c());
        this.f160d.mo176d();
    }

    /* renamed from: g */
    public void mo165g() {
        List<File> c = this.f160d.mo175c();
        int b = mo160b();
        if (c.size() > b) {
            int size = c.size() - b;
            C0020i.m67a(this.f157a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(b), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new Comparator<C0078a>() {
                /* renamed from: a */
                public int compare(C0078a aVar, C0078a aVar2) {
                    return (int) (aVar.f166b - aVar2.f166b);
                }
            });
            for (File file : c) {
                treeSet.add(new C0078a(file, mo155a(file.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0078a) it.next()).f165a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f160d.mo171a((List<File>) arrayList);
        }
    }

    /* renamed from: a */
    public long mo155a(String str) {
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
