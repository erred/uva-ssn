package androidx.p082g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* renamed from: androidx.g.b */
/* compiled from: MultiDexExtractor */
final class C1130b implements Closeable {

    /* renamed from: a */
    private final File f3517a;

    /* renamed from: b */
    private final long f3518b;

    /* renamed from: c */
    private final File f3519c;

    /* renamed from: d */
    private final RandomAccessFile f3520d;

    /* renamed from: e */
    private final FileChannel f3521e;

    /* renamed from: f */
    private final FileLock f3522f;

    /* renamed from: androidx.g.b$a */
    /* compiled from: MultiDexExtractor */
    private static class C1132a extends File {

        /* renamed from: a */
        public long f3524a = -1;

        public C1132a(File file, String str) {
            super(file, str);
        }
    }

    C1130b(File file, File file2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        Log.i("MultiDex", sb.toString());
        this.f3517a = file;
        this.f3519c = file2;
        this.f3518b = m4390b(file);
        File file3 = new File(file2, "MultiDex.lock");
        this.f3520d = new RandomAccessFile(file3, "rw");
        try {
            this.f3521e = this.f3520d.getChannel();
            String str = "MultiDex";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Blocking on lock ");
            sb2.append(file3.getPath());
            Log.i(str, sb2.toString());
            this.f3522f = this.f3521e.lock();
            String str2 = "MultiDex";
            StringBuilder sb3 = new StringBuilder();
            sb3.append(file3.getPath());
            sb3.append(" locked");
            Log.i(str2, sb3.toString());
        } catch (IOException | Error | RuntimeException e) {
            m4387a((Closeable) this.f3521e);
            throw e;
        } catch (IOException | Error | RuntimeException e2) {
            m4387a((Closeable) this.f3520d);
            throw e2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<? extends File> mo4561a(Context context, String str, boolean z) throws IOException {
        List<? extends File> list;
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor.load(");
        sb.append(this.f3517a.getPath());
        sb.append(", ");
        sb.append(z);
        sb.append(", ");
        sb.append(str);
        sb.append(")");
        Log.i("MultiDex", sb.toString());
        if (this.f3522f.isValid()) {
            if (z || m4389a(context, this.f3517a, this.f3518b, str)) {
                if (z) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                list = m4384a();
                m4386a(context, str, m4382a(this.f3517a), this.f3518b, list);
            } else {
                try {
                    list = m4385a(context, str);
                } catch (IOException e) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                    list = m4384a();
                    m4386a(context, str, m4382a(this.f3517a), this.f3518b, list);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load found ");
            sb2.append(list.size());
            sb2.append(" secondary dex files");
            Log.i("MultiDex", sb2.toString());
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() throws IOException {
        this.f3522f.release();
        this.f3521e.close();
        this.f3520d.close();
    }

    /* renamed from: a */
    private List<C1132a> m4385a(Context context, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3517a.getName());
        sb.append(".classes");
        String sb2 = sb.toString();
        SharedPreferences a = m4383a(context);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append("dex.number");
        int i = a.getInt(sb3.toString(), 1);
        ArrayList arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append(i2);
            sb4.append(".zip");
            C1132a aVar = new C1132a(this.f3519c, sb4.toString());
            if (aVar.isFile()) {
                aVar.f3524a = m4390b(aVar);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append("dex.crc.");
                sb5.append(i2);
                long j = a.getLong(sb5.toString(), -1);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append("dex.time.");
                sb6.append(i2);
                long j2 = a.getLong(sb6.toString(), -1);
                long lastModified = aVar.lastModified();
                if (j2 == lastModified) {
                    String str3 = sb2;
                    SharedPreferences sharedPreferences = a;
                    if (j == aVar.f3524a) {
                        arrayList.add(aVar);
                        i2++;
                        sb2 = str3;
                        a = sharedPreferences;
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Invalid extracted dex: ");
                sb7.append(aVar);
                sb7.append(" (key \"");
                sb7.append(str2);
                sb7.append("\"), expected modification time: ");
                sb7.append(j2);
                sb7.append(", modification time: ");
                sb7.append(lastModified);
                sb7.append(", expected crc: ");
                sb7.append(j);
                sb7.append(", file crc: ");
                sb7.append(aVar.f3524a);
                throw new IOException(sb7.toString());
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Missing extracted secondary dex file '");
            sb8.append(aVar.getPath());
            sb8.append("'");
            throw new IOException(sb8.toString());
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m4389a(Context context, File file, long j, String str) {
        SharedPreferences a = m4383a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Param.TIMESTAMP);
        if (a.getLong(sb.toString(), -1) == m4382a(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("crc");
            if (a.getLong(sb2.toString(), -1) == j) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static long m4382a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* renamed from: b */
    private static long m4390b(File file) throws IOException {
        long a = C1133c.m4393a(file);
        return a == -1 ? a - 1 : a;
    }

    /* renamed from: a */
    private List<C1132a> m4384a() throws IOException {
        C1132a aVar;
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3517a.getName());
        sb.append(".classes");
        String sb2 = sb.toString();
        m4391b();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f3517a);
        int i = 2;
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("classes");
            sb3.append(2);
            sb3.append(".dex");
            ZipEntry entry = zipFile.getEntry(sb3.toString());
            while (entry != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb2);
                sb4.append(i);
                sb4.append(".zip");
                aVar = new C1132a(this.f3519c, sb4.toString());
                arrayList.add(aVar);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Extraction is needed for file ");
                sb5.append(aVar);
                Log.i("MultiDex", sb5.toString());
                int i2 = 0;
                z = false;
                while (i2 < 3 && !z) {
                    i2++;
                    m4388a(zipFile, entry, (File) aVar, sb2);
                    aVar.f3524a = m4390b(aVar);
                    z = true;
                    String str = "MultiDex";
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Extraction ");
                    sb6.append(z ? "succeeded" : "failed");
                    sb6.append(" '");
                    sb6.append(aVar.getAbsolutePath());
                    sb6.append("': length ");
                    sb6.append(aVar.length());
                    sb6.append(" - crc: ");
                    sb6.append(aVar.f3524a);
                    Log.i(str, sb6.toString());
                    if (!z) {
                        aVar.delete();
                        if (aVar.exists()) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Failed to delete corrupted secondary dex '");
                            sb7.append(aVar.getPath());
                            sb7.append("'");
                            Log.w("MultiDex", sb7.toString());
                        }
                    }
                }
                if (z) {
                    i++;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("classes");
                    sb8.append(i);
                    sb8.append(".dex");
                    entry = zipFile.getEntry(sb8.toString());
                } else {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Could not create zip file ");
                    sb9.append(aVar.getAbsolutePath());
                    sb9.append(" for secondary dex (");
                    sb9.append(i);
                    sb9.append(")");
                    throw new IOException(sb9.toString());
                }
            }
            try {
                zipFile.close();
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
            return arrayList;
        } catch (IOException e2) {
            String str2 = "MultiDex";
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Failed to read crc from ");
            sb10.append(aVar.getAbsolutePath());
            Log.w(str2, sb10.toString(), e2);
            z = false;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static void m4386a(Context context, String str, long j, long j2, List<C1132a> list) {
        Editor edit = m4383a(context).edit();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Param.TIMESTAMP);
        edit.putLong(sb.toString(), j);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("crc");
        edit.putLong(sb2.toString(), j2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("dex.number");
        edit.putInt(sb3.toString(), list.size() + 1);
        int i = 2;
        for (C1132a aVar : list) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("dex.crc.");
            sb4.append(i);
            edit.putLong(sb4.toString(), aVar.f3524a);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("dex.time.");
            sb5.append(i);
            edit.putLong(sb5.toString(), aVar.lastModified());
            i++;
        }
        edit.commit();
    }

    /* renamed from: a */
    private static SharedPreferences m4383a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* renamed from: b */
    private void m4391b() {
        File[] listFiles = this.f3519c.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(this.f3519c.getPath());
            sb.append(").");
            Log.w("MultiDex", sb.toString());
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            Log.i("MultiDex", sb2.toString());
            if (!file.delete()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to delete old file ");
                sb3.append(file.getPath());
                Log.w("MultiDex", sb3.toString());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(file.getPath());
                Log.i("MultiDex", sb4.toString());
            }
        }
    }

    /* renamed from: a */
    private static void m4388a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        StringBuilder sb = new StringBuilder();
        sb.append("tmp-");
        sb.append(str);
        File createTempFile = File.createTempFile(sb.toString(), ".zip", file.getParentFile());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(createTempFile.getPath());
        Log.i("MultiDex", sb2.toString());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Renaming to ");
                sb3.append(file.getPath());
                Log.i("MultiDex", sb3.toString());
                if (createTempFile.renameTo(file)) {
                    m4387a((Closeable) inputStream);
                    createTempFile.delete();
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to rename \"");
                sb4.append(createTempFile.getAbsolutePath());
                sb4.append("\" to \"");
                sb4.append(file.getAbsolutePath());
                sb4.append("\"");
                throw new IOException(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Failed to mark readonly \"");
            sb5.append(createTempFile.getAbsolutePath());
            sb5.append("\" (tmp of \"");
            sb5.append(file.getAbsolutePath());
            sb5.append("\")");
            throw new IOException(sb5.toString());
        } catch (Throwable th) {
            m4387a((Closeable) inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m4387a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }
}
