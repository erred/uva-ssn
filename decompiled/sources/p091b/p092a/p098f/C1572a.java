package p091b.p092a.p098f;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import p102c.C1683l;
import p102c.C1694r;
import p102c.C1695s;

/* renamed from: b.a.f.a */
/* compiled from: FileSystem */
public interface C1572a {

    /* renamed from: a */
    public static final C1572a f4817a = new C1572a() {
        /* renamed from: a */
        public C1695s mo6412a(File file) throws FileNotFoundException {
            return C1683l.m7038a(file);
        }

        /* renamed from: b */
        public C1694r mo6414b(File file) throws FileNotFoundException {
            try {
                return C1683l.m7042b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C1683l.m7042b(file);
            }
        }

        /* renamed from: c */
        public C1694r mo6415c(File file) throws FileNotFoundException {
            try {
                return C1683l.m7045c(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C1683l.m7045c(file);
            }
        }

        /* renamed from: d */
        public void mo6416d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to delete ");
                sb.append(file);
                throw new IOException(sb.toString());
            }
        }

        /* renamed from: e */
        public boolean mo6417e(File file) {
            return file.exists();
        }

        /* renamed from: f */
        public long mo6418f(File file) {
            return file.length();
        }

        /* renamed from: a */
        public void mo6413a(File file, File file2) throws IOException {
            mo6416d(file2);
            if (!file.renameTo(file2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to rename ");
                sb.append(file);
                sb.append(" to ");
                sb.append(file2);
                throw new IOException(sb.toString());
            }
        }

        /* renamed from: g */
        public void mo6419g(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        mo6419g(file2);
                    }
                    if (file2.delete()) {
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("failed to delete ");
                        sb.append(file2);
                        throw new IOException(sb.toString());
                    }
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not a readable directory: ");
            sb2.append(file);
            throw new IOException(sb2.toString());
        }
    };

    /* renamed from: a */
    C1695s mo6412a(File file) throws FileNotFoundException;

    /* renamed from: a */
    void mo6413a(File file, File file2) throws IOException;

    /* renamed from: b */
    C1694r mo6414b(File file) throws FileNotFoundException;

    /* renamed from: c */
    C1694r mo6415c(File file) throws FileNotFoundException;

    /* renamed from: d */
    void mo6416d(File file) throws IOException;

    /* renamed from: e */
    boolean mo6417e(File file);

    /* renamed from: f */
    long mo6418f(File file);

    /* renamed from: g */
    void mo6419g(File file) throws IOException;
}
