package com.squareup.picasso;

import java.io.PrintWriter;

/* renamed from: com.squareup.picasso.ab */
/* compiled from: StatsSnapshot */
public class C3026ab {

    /* renamed from: a */
    public final int f7907a;

    /* renamed from: b */
    public final int f7908b;

    /* renamed from: c */
    public final long f7909c;

    /* renamed from: d */
    public final long f7910d;

    /* renamed from: e */
    public final long f7911e;

    /* renamed from: f */
    public final long f7912f;

    /* renamed from: g */
    public final long f7913g;

    /* renamed from: h */
    public final long f7914h;

    /* renamed from: i */
    public final long f7915i;

    /* renamed from: j */
    public final long f7916j;

    /* renamed from: k */
    public final int f7917k;

    /* renamed from: l */
    public final int f7918l;

    /* renamed from: m */
    public final int f7919m;

    /* renamed from: n */
    public final long f7920n;

    public C3026ab(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f7907a = i;
        this.f7908b = i2;
        this.f7909c = j;
        this.f7910d = j2;
        this.f7911e = j3;
        this.f7912f = j4;
        this.f7913g = j5;
        this.f7914h = j6;
        this.f7915i = j7;
        this.f7916j = j8;
        this.f7917k = i3;
        this.f7918l = i4;
        this.f7919m = i5;
        this.f7920n = j9;
    }

    /* renamed from: a */
    public void mo27444a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f7907a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f7908b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f7908b) / ((float) this.f7907a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f7909c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f7910d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f7917k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f7911e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f7914h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f7918l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f7912f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f7919m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f7913g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f7915i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f7916j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatsSnapshot{maxSize=");
        sb.append(this.f7907a);
        sb.append(", size=");
        sb.append(this.f7908b);
        sb.append(", cacheHits=");
        sb.append(this.f7909c);
        sb.append(", cacheMisses=");
        sb.append(this.f7910d);
        sb.append(", downloadCount=");
        sb.append(this.f7917k);
        sb.append(", totalDownloadSize=");
        sb.append(this.f7911e);
        sb.append(", averageDownloadSize=");
        sb.append(this.f7914h);
        sb.append(", totalOriginalBitmapSize=");
        sb.append(this.f7912f);
        sb.append(", totalTransformedBitmapSize=");
        sb.append(this.f7913g);
        sb.append(", averageOriginalBitmapSize=");
        sb.append(this.f7915i);
        sb.append(", averageTransformedBitmapSize=");
        sb.append(this.f7916j);
        sb.append(", originalBitmapCount=");
        sb.append(this.f7918l);
        sb.append(", transformedBitmapCount=");
        sb.append(this.f7919m);
        sb.append(", timeStamp=");
        sb.append(this.f7920n);
        sb.append('}');
        return sb.toString();
    }
}
