package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.C3176g;
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

/* renamed from: com.twitter.sdk.android.core.internal.scribe.p */
/* compiled from: QueueFileEventStorage */
public class C3235p implements C3225j {

    /* renamed from: a */
    private final Context f8468a;

    /* renamed from: b */
    private final File f8469b;

    /* renamed from: c */
    private final String f8470c;

    /* renamed from: d */
    private final File f8471d;

    /* renamed from: e */
    private C3230o f8472e = new C3230o(this.f8471d);

    /* renamed from: f */
    private File f8473f;

    public C3235p(Context context, File file, String str, String str2) throws IOException {
        this.f8468a = context;
        this.f8469b = file;
        this.f8470c = str2;
        this.f8471d = new File(this.f8469b, str);
        m9495d();
    }

    /* renamed from: d */
    private void m9495d() {
        this.f8473f = new File(this.f8469b, this.f8470c);
        if (!this.f8473f.exists()) {
            this.f8473f.mkdirs();
        }
    }

    /* renamed from: a */
    public void mo27812a(byte[] bArr) throws IOException {
        this.f8472e.mo27818a(bArr);
    }

    /* renamed from: a */
    public int mo27808a() {
        return this.f8472e.mo27816a();
    }

    /* renamed from: a */
    public void mo27810a(String str) throws IOException {
        this.f8472e.close();
        m9494a(this.f8471d, new File(this.f8473f, str));
        this.f8472e = new C3230o(this.f8471d);
    }

    /* renamed from: a */
    private void m9494a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream a;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                a = mo27827a(file2);
            } catch (Throwable th) {
                th = th;
                C3176g.m9305a((Closeable) fileInputStream, "Failed to close file input stream");
                C3176g.m9305a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
            try {
                C3176g.m9306a((InputStream) fileInputStream, a, new byte[1024]);
                C3176g.m9305a((Closeable) fileInputStream, "Failed to close file input stream");
                C3176g.m9305a((Closeable) a, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                outputStream = a;
                th = th3;
                C3176g.m9305a((Closeable) fileInputStream, "Failed to close file input stream");
                C3176g.m9305a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            C3176g.m9305a((Closeable) fileInputStream, "Failed to close file input stream");
            C3176g.m9305a((Closeable) outputStream, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    /* renamed from: a */
    public OutputStream mo27827a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    /* renamed from: a */
    public List<File> mo27809a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File add : this.f8473f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo27811a(List<File> list) {
        for (File file : list) {
            C3176g.m9302a(this.f8468a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    /* renamed from: c */
    public List<File> mo27815c() {
        return Arrays.asList(this.f8473f.listFiles());
    }

    /* renamed from: b */
    public boolean mo27814b() {
        return this.f8472e.mo27821b();
    }

    /* renamed from: a */
    public boolean mo27813a(int i, int i2) {
        return this.f8472e.mo27820a(i, i2);
    }
}
