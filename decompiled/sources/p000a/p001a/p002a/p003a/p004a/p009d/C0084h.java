package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0036q;

/* renamed from: a.a.a.a.a.d.h */
/* compiled from: QueueFileEventStorage */
public class C0084h implements C0079c {

    /* renamed from: a */
    private final Context f167a;

    /* renamed from: b */
    private final File f168b;

    /* renamed from: c */
    private final String f169c;

    /* renamed from: d */
    private final File f170d;

    /* renamed from: e */
    private C0036q f171e = new C0036q(this.f170d);

    /* renamed from: f */
    private File f172f;

    public C0084h(Context context, File file, String str, String str2) throws IOException {
        this.f167a = context;
        this.f168b = file;
        this.f169c = str2;
        this.f170d = new File(this.f168b, str);
        m268e();
    }

    /* renamed from: e */
    private void m268e() {
        this.f172f = new File(this.f168b, this.f169c);
        if (!this.f172f.exists()) {
            this.f172f.mkdirs();
        }
    }

    /* renamed from: a */
    public void mo172a(byte[] bArr) throws IOException {
        this.f171e.mo72a(bArr);
    }

    /* renamed from: a */
    public int mo168a() {
        return this.f171e.mo70a();
    }

    /* renamed from: a */
    public void mo170a(String str) throws IOException {
        this.f171e.close();
        m267a(this.f170d, new File(this.f172f, str));
        this.f171e = new C0036q(this.f170d);
    }

    /* renamed from: a */
    private void m267a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream a;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                a = mo181a(file2);
            } catch (Throwable th) {
                th = th;
                C0020i.m70a((Closeable) fileInputStream, "Failed to close file input stream");
                C0020i.m70a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
            try {
                C0020i.m72a((InputStream) fileInputStream, a, new byte[1024]);
                C0020i.m70a((Closeable) fileInputStream, "Failed to close file input stream");
                C0020i.m70a((Closeable) a, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                outputStream = a;
                th = th3;
                C0020i.m70a((Closeable) fileInputStream, "Failed to close file input stream");
                C0020i.m70a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            C0020i.m70a((Closeable) fileInputStream, "Failed to close file input stream");
            C0020i.m70a((Closeable) outputStream, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    /* renamed from: a */
    public OutputStream mo181a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    /* renamed from: a */
    public List<File> mo169a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File add : this.f172f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo171a(List<File> list) {
        for (File file : list) {
            C0020i.m67a(this.f167a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    /* renamed from: c */
    public List<File> mo175c() {
        return Arrays.asList(this.f172f.listFiles());
    }

    /* renamed from: d */
    public void mo176d() {
        try {
            this.f171e.close();
        } catch (IOException unused) {
        }
        this.f170d.delete();
    }

    /* renamed from: b */
    public boolean mo174b() {
        return this.f171e.mo75b();
    }

    /* renamed from: a */
    public boolean mo173a(int i, int i2) {
        return this.f171e.mo74a(i, i2);
    }
}
