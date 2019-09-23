package p000a.p001a.p002a.p003a.p004a.p009d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: a.a.a.a.a.d.g */
/* compiled from: GZIPQueueFileEventStorage */
public class C0083g extends C0084h {
    public C0083g(Context context, File file, String str, String str2) throws IOException {
        super(context, file, str, str2);
    }

    /* renamed from: a */
    public OutputStream mo181a(File file) throws IOException {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
