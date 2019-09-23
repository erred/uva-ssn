package com.p103a.p104a.p107c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* renamed from: com.a.a.c.d */
/* compiled from: ClsFileOutputStream */
class C1778d extends FileOutputStream {

    /* renamed from: a */
    public static final FilenameFilter f5551a = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };

    /* renamed from: b */
    private final String f5552b;

    /* renamed from: c */
    private File f5553c;

    /* renamed from: d */
    private File f5554d;

    /* renamed from: e */
    private boolean f5555e = false;

    public C1778d(File file, String str) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".cls_temp");
        super(new File(file, sb.toString()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file);
        sb2.append(File.separator);
        sb2.append(str);
        this.f5552b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f5552b);
        sb3.append(".cls_temp");
        this.f5553c = new File(sb3.toString());
    }

    public synchronized void close() throws IOException {
        if (!this.f5555e) {
            this.f5555e = true;
            super.flush();
            super.close();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5552b);
            sb.append(".cls");
            File file = new File(sb.toString());
            if (this.f5553c.renameTo(file)) {
                this.f5553c = null;
                this.f5554d = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.f5553c.exists()) {
                str = " (source does not exist)";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not rename temp file: ");
            sb2.append(this.f5553c);
            sb2.append(" -> ");
            sb2.append(file);
            sb2.append(str);
            throw new IOException(sb2.toString());
        }
    }

    /* renamed from: a */
    public void mo7044a() throws IOException {
        if (!this.f5555e) {
            this.f5555e = true;
            super.flush();
            super.close();
        }
    }
}
