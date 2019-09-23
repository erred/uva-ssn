package androidx.core.p069f;

import android.util.Log;
import java.io.Writer;

/* renamed from: androidx.core.f.b */
/* compiled from: LogWriter */
public class C0924b extends Writer {

    /* renamed from: a */
    private final String f2946a;

    /* renamed from: b */
    private StringBuilder f2947b = new StringBuilder(128);

    public C0924b(String str) {
        this.f2946a = str;
    }

    public void close() {
        m3392a();
    }

    public void flush() {
        m3392a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                m3392a();
            } else {
                this.f2947b.append(c);
            }
        }
    }

    /* renamed from: a */
    private void m3392a() {
        if (this.f2947b.length() > 0) {
            Log.d(this.f2946a, this.f2947b.toString());
            this.f2947b.delete(0, this.f2947b.length());
        }
    }
}
