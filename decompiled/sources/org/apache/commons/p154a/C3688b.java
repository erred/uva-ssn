package org.apache.commons.p154a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.commons.p154a.p155a.C3686a;
import org.apache.commons.p154a.p155a.C3687b;

/* renamed from: org.apache.commons.a.b */
/* compiled from: IOUtils */
public class C3688b {

    /* renamed from: a */
    public static final char f9729a = File.separatorChar;

    /* renamed from: b */
    public static final String f9730b;

    static {
        C3687b bVar = new C3687b(4);
        PrintWriter printWriter = new PrintWriter(bVar);
        printWriter.println();
        f9730b = bVar.toString();
        printWriter.close();
    }

    /* renamed from: a */
    public static byte[] m10972a(InputStream inputStream) throws IOException {
        C3686a aVar = new C3686a();
        m10969a(inputStream, (OutputStream) aVar);
        return aVar.mo30141a();
    }

    /* renamed from: a */
    public static void m10971a(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    /* renamed from: a */
    public static int m10969a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long b = m10973b(inputStream, outputStream);
        if (b > 2147483647L) {
            return -1;
        }
        return (int) b;
    }

    /* renamed from: b */
    public static long m10973b(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m10970a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m10970a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
