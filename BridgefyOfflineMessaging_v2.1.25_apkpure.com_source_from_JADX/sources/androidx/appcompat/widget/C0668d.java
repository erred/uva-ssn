package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.appcompat.widget.d */
/* compiled from: ActivityChooserModel */
class C0668d extends DataSetObservable {

    /* renamed from: a */
    static final String f1941a = "d";

    /* renamed from: e */
    private static final Object f1942e = new Object();

    /* renamed from: f */
    private static final Map<String, C0668d> f1943f = new HashMap();

    /* renamed from: b */
    final Context f1944b;

    /* renamed from: c */
    final String f1945c;

    /* renamed from: d */
    boolean f1946d;

    /* renamed from: g */
    private final Object f1947g;

    /* renamed from: h */
    private final List<C0669a> f1948h;

    /* renamed from: i */
    private final List<C0671c> f1949i;

    /* renamed from: j */
    private Intent f1950j;

    /* renamed from: k */
    private C0670b f1951k;

    /* renamed from: l */
    private int f1952l;

    /* renamed from: m */
    private boolean f1953m;

    /* renamed from: n */
    private boolean f1954n;

    /* renamed from: o */
    private boolean f1955o;

    /* renamed from: p */
    private C0672d f1956p;

    /* renamed from: androidx.appcompat.widget.d$a */
    /* compiled from: ActivityChooserModel */
    public static final class C0669a implements Comparable<C0669a> {

        /* renamed from: a */
        public final ResolveInfo f1957a;

        /* renamed from: b */
        public float f1958b;

        public C0669a(ResolveInfo resolveInfo) {
            this.f1957a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1958b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.f1958b) == Float.floatToIntBits(((C0669a) obj).f1958b);
        }

        /* renamed from: a */
        public int compareTo(C0669a aVar) {
            return Float.floatToIntBits(aVar.f1958b) - Float.floatToIntBits(this.f1958b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:");
            sb.append(this.f1957a.toString());
            sb.append("; weight:");
            sb.append(new BigDecimal((double) this.f1958b));
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: androidx.appcompat.widget.d$b */
    /* compiled from: ActivityChooserModel */
    public interface C0670b {
        /* renamed from: a */
        void mo2525a(Intent intent, List<C0669a> list, List<C0671c> list2);
    }

    /* renamed from: androidx.appcompat.widget.d$c */
    /* compiled from: ActivityChooserModel */
    public static final class C0671c {

        /* renamed from: a */
        public final ComponentName f1959a;

        /* renamed from: b */
        public final long f1960b;

        /* renamed from: c */
        public final float f1961c;

        public C0671c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0671c(ComponentName componentName, long j, float f) {
            this.f1959a = componentName;
            this.f1960b = j;
            this.f1961c = f;
        }

        public int hashCode() {
            return (((((this.f1959a == null ? 0 : this.f1959a.hashCode()) + 31) * 31) + ((int) (this.f1960b ^ (this.f1960b >>> 32)))) * 31) + Float.floatToIntBits(this.f1961c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0671c cVar = (C0671c) obj;
            if (this.f1959a == null) {
                if (cVar.f1959a != null) {
                    return false;
                }
            } else if (!this.f1959a.equals(cVar.f1959a)) {
                return false;
            }
            return this.f1960b == cVar.f1960b && Float.floatToIntBits(this.f1961c) == Float.floatToIntBits(cVar.f1961c);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:");
            sb.append(this.f1959a);
            sb.append("; time:");
            sb.append(this.f1960b);
            sb.append("; weight:");
            sb.append(new BigDecimal((double) this.f1961c));
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: androidx.appcompat.widget.d$d */
    /* compiled from: ActivityChooserModel */
    public interface C0672d {
        /* renamed from: a */
        boolean mo2529a(C0668d dVar, Intent intent);
    }

    /* renamed from: androidx.appcompat.widget.d$e */
    /* compiled from: ActivityChooserModel */
    private final class C0673e extends AsyncTask<Object, Void, Void> {
        C0673e() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006f, code lost:
            if (r4 != null) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0096, code lost:
            if (r4 == null) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
            if (r4 == null) goto L_0x00dd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00da, code lost:
            if (r4 == null) goto L_0x00dd;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r12) {
            /*
                r11 = this;
                r0 = 0
                r1 = r12[r0]
                java.util.List r1 = (java.util.List) r1
                r2 = 1
                r12 = r12[r2]
                java.lang.String r12 = (java.lang.String) r12
                r3 = 0
                androidx.appcompat.widget.d r4 = androidx.appcompat.widget.C0668d.this     // Catch:{ FileNotFoundException -> 0x00e8 }
                android.content.Context r4 = r4.f1944b     // Catch:{ FileNotFoundException -> 0x00e8 }
                java.io.FileOutputStream r4 = r4.openFileOutput(r12, r0)     // Catch:{ FileNotFoundException -> 0x00e8 }
                org.xmlpull.v1.XmlSerializer r12 = android.util.Xml.newSerializer()
                r12.setOutput(r4, r3)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r5 = "UTF-8"
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r12.startDocument(r5, r6)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r5 = "historical-records"
                r12.startTag(r3, r5)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                int r5 = r1.size()     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r6 = 0
            L_0x002d:
                if (r6 >= r5) goto L_0x0063
                java.lang.Object r7 = r1.remove(r0)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                androidx.appcompat.widget.d$c r7 = (androidx.appcompat.widget.C0668d.C0671c) r7     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "historical-record"
                r12.startTag(r3, r8)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "activity"
                android.content.ComponentName r9 = r7.f1959a     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r9 = r9.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r12.attribute(r3, r8, r9)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "time"
                long r9 = r7.f1960b     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r12.attribute(r3, r8, r9)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r8 = "weight"
                float r7 = r7.f1961c     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r12.attribute(r3, r8, r7)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                java.lang.String r7 = "historical-record"
                r12.endTag(r3, r7)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                int r6 = r6 + 1
                goto L_0x002d
            L_0x0063:
                java.lang.String r0 = "historical-records"
                r12.endTag(r3, r0)     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                r12.endDocument()     // Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
                androidx.appcompat.widget.d r12 = androidx.appcompat.widget.C0668d.this
                r12.f1946d = r2
                if (r4 == 0) goto L_0x00dd
            L_0x0071:
                r4.close()     // Catch:{ IOException -> 0x00dd }
                goto L_0x00dd
            L_0x0075:
                r12 = move-exception
                goto L_0x00de
            L_0x0077:
                r12 = move-exception
                java.lang.String r0 = androidx.appcompat.widget.C0668d.f1941a     // Catch:{ all -> 0x0075 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
                r1.<init>()     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = "Error writing historical record file: "
                r1.append(r5)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r5 = androidx.appcompat.widget.C0668d.this     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = r5.f1945c     // Catch:{ all -> 0x0075 }
                r1.append(r5)     // Catch:{ all -> 0x0075 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0075 }
                android.util.Log.e(r0, r1, r12)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r12 = androidx.appcompat.widget.C0668d.this
                r12.f1946d = r2
                if (r4 == 0) goto L_0x00dd
                goto L_0x0071
            L_0x0099:
                r12 = move-exception
                java.lang.String r0 = androidx.appcompat.widget.C0668d.f1941a     // Catch:{ all -> 0x0075 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
                r1.<init>()     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = "Error writing historical record file: "
                r1.append(r5)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r5 = androidx.appcompat.widget.C0668d.this     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = r5.f1945c     // Catch:{ all -> 0x0075 }
                r1.append(r5)     // Catch:{ all -> 0x0075 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0075 }
                android.util.Log.e(r0, r1, r12)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r12 = androidx.appcompat.widget.C0668d.this
                r12.f1946d = r2
                if (r4 == 0) goto L_0x00dd
                goto L_0x0071
            L_0x00bb:
                r12 = move-exception
                java.lang.String r0 = androidx.appcompat.widget.C0668d.f1941a     // Catch:{ all -> 0x0075 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
                r1.<init>()     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = "Error writing historical record file: "
                r1.append(r5)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r5 = androidx.appcompat.widget.C0668d.this     // Catch:{ all -> 0x0075 }
                java.lang.String r5 = r5.f1945c     // Catch:{ all -> 0x0075 }
                r1.append(r5)     // Catch:{ all -> 0x0075 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0075 }
                android.util.Log.e(r0, r1, r12)     // Catch:{ all -> 0x0075 }
                androidx.appcompat.widget.d r12 = androidx.appcompat.widget.C0668d.this
                r12.f1946d = r2
                if (r4 == 0) goto L_0x00dd
                goto L_0x0071
            L_0x00dd:
                return r3
            L_0x00de:
                androidx.appcompat.widget.d r0 = androidx.appcompat.widget.C0668d.this
                r0.f1946d = r2
                if (r4 == 0) goto L_0x00e7
                r4.close()     // Catch:{ IOException -> 0x00e7 }
            L_0x00e7:
                throw r12
            L_0x00e8:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.C0668d.f1941a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Error writing historical record file: "
                r2.append(r4)
                r2.append(r12)
                java.lang.String r12 = r2.toString()
                android.util.Log.e(r1, r12, r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0668d.C0673e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    /* renamed from: a */
    public int mo2514a() {
        int size;
        synchronized (this.f1947g) {
            m2356d();
            size = this.f1948h.size();
        }
        return size;
    }

    /* renamed from: a */
    public ResolveInfo mo2516a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1947g) {
            m2356d();
            resolveInfo = ((C0669a) this.f1948h.get(i)).f1957a;
        }
        return resolveInfo;
    }

    /* renamed from: a */
    public int mo2515a(ResolveInfo resolveInfo) {
        synchronized (this.f1947g) {
            m2356d();
            List<C0669a> list = this.f1948h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0669a) list.get(i)).f1957a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    public Intent mo2517b(int i) {
        synchronized (this.f1947g) {
            if (this.f1950j == null) {
                return null;
            }
            m2356d();
            C0669a aVar = (C0669a) this.f1948h.get(i);
            ComponentName componentName = new ComponentName(aVar.f1957a.activityInfo.packageName, aVar.f1957a.activityInfo.name);
            Intent intent = new Intent(this.f1950j);
            intent.setComponent(componentName);
            if (this.f1956p != null) {
                if (this.f1956p.mo2529a(this, new Intent(intent))) {
                    return null;
                }
            }
            m2354a(new C0671c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* renamed from: b */
    public ResolveInfo mo2518b() {
        synchronized (this.f1947g) {
            m2356d();
            if (this.f1948h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0669a) this.f1948h.get(0)).f1957a;
            return resolveInfo;
        }
    }

    /* renamed from: c */
    public void mo2519c(int i) {
        synchronized (this.f1947g) {
            m2356d();
            C0669a aVar = (C0669a) this.f1948h.get(i);
            C0669a aVar2 = (C0669a) this.f1948h.get(0);
            m2354a(new C0671c(new ComponentName(aVar.f1957a.activityInfo.packageName, aVar.f1957a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1958b - aVar.f1958b) + 5.0f : 1.0f));
        }
    }

    /* renamed from: c */
    private void m2355c() {
        if (!this.f1953m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1954n) {
            this.f1954n = false;
            if (!TextUtils.isEmpty(this.f1945c)) {
                new C0673e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f1949i), this.f1945c});
            }
        }
    }

    /* renamed from: d */
    private void m2356d() {
        boolean f = m2358f() | m2359g();
        m2360h();
        if (f) {
            m2357e();
            notifyChanged();
        }
    }

    /* renamed from: e */
    private boolean m2357e() {
        if (this.f1951k == null || this.f1950j == null || this.f1948h.isEmpty() || this.f1949i.isEmpty()) {
            return false;
        }
        this.f1951k.mo2525a(this.f1950j, this.f1948h, Collections.unmodifiableList(this.f1949i));
        return true;
    }

    /* renamed from: f */
    private boolean m2358f() {
        if (!this.f1955o || this.f1950j == null) {
            return false;
        }
        this.f1955o = false;
        this.f1948h.clear();
        List queryIntentActivities = this.f1944b.getPackageManager().queryIntentActivities(this.f1950j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1948h.add(new C0669a((ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    /* renamed from: g */
    private boolean m2359g() {
        if (!this.f1946d || !this.f1954n || TextUtils.isEmpty(this.f1945c)) {
            return false;
        }
        this.f1946d = false;
        this.f1953m = true;
        m2361i();
        return true;
    }

    /* renamed from: a */
    private boolean m2354a(C0671c cVar) {
        boolean add = this.f1949i.add(cVar);
        if (add) {
            this.f1954n = true;
            m2360h();
            m2355c();
            m2357e();
            notifyChanged();
        }
        return add;
    }

    /* renamed from: h */
    private void m2360h() {
        int size = this.f1949i.size() - this.f1952l;
        if (size > 0) {
            this.f1954n = true;
            for (int i = 0; i < size; i++) {
                C0671c cVar = (C0671c) this.f1949i.remove(0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r0 != null) goto L_0x0036;
     */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2361i() {
        /*
            r9 = this;
            android.content.Context r0 = r9.f1944b     // Catch:{ FileNotFoundException -> 0x00c4 }
            java.lang.String r1 = r9.f1945c     // Catch:{ FileNotFoundException -> 0x00c4 }
            java.io.FileInputStream r0 = r0.openFileInput(r1)     // Catch:{ FileNotFoundException -> 0x00c4 }
            org.xmlpull.v1.XmlPullParser r1 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            java.lang.String r2 = "UTF-8"
            r1.setInput(r0, r2)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            r2 = 0
        L_0x0012:
            r3 = 1
            if (r2 == r3) goto L_0x001d
            r4 = 2
            if (r2 == r4) goto L_0x001d
            int r2 = r1.next()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            goto L_0x0012
        L_0x001d:
            java.lang.String r2 = "historical-records"
            java.lang.String r4 = r1.getName()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            if (r2 == 0) goto L_0x007a
            java.util.List<androidx.appcompat.widget.d$c> r2 = r9.f1949i     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            r2.clear()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        L_0x002e:
            int r4 = r1.next()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            if (r4 != r3) goto L_0x003b
            if (r0 == 0) goto L_0x00bd
        L_0x0036:
            r0.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00bd
        L_0x003b:
            r5 = 3
            if (r4 == r5) goto L_0x002e
            r5 = 4
            if (r4 != r5) goto L_0x0042
            goto L_0x002e
        L_0x0042:
            java.lang.String r4 = r1.getName()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            java.lang.String r5 = "historical-record"
            boolean r4 = r5.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            if (r4 == 0) goto L_0x0072
            java.lang.String r4 = "activity"
            r5 = 0
            java.lang.String r4 = r1.getAttributeValue(r5, r4)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            java.lang.String r6 = "time"
            java.lang.String r6 = r1.getAttributeValue(r5, r6)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            java.lang.String r8 = "weight"
            java.lang.String r5 = r1.getAttributeValue(r5, r8)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            androidx.appcompat.widget.d$c r8 = new androidx.appcompat.widget.d$c     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            r8.<init>(r4, r6, r5)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            r2.add(r8)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            goto L_0x002e
        L_0x0072:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            java.lang.String r2 = "Share records file not well-formed."
            r1.<init>(r2)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            throw r1     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        L_0x007a:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            java.lang.String r2 = "Share records file does not start with historical-records tag."
            r1.<init>(r2)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
            throw r1     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        L_0x0082:
            r1 = move-exception
            goto L_0x00be
        L_0x0084:
            r1 = move-exception
            java.lang.String r2 = f1941a     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r3.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "Error reading historical recrod file: "
            r3.append(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = r9.f1945c     // Catch:{ all -> 0x0082 }
            r3.append(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0082 }
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x00bd
            goto L_0x0036
        L_0x00a0:
            r1 = move-exception
            java.lang.String r2 = f1941a     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r3.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "Error reading historical recrod file: "
            r3.append(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = r9.f1945c     // Catch:{ all -> 0x0082 }
            r3.append(r4)     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0082 }
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x00bd
            goto L_0x0036
        L_0x00bd:
            return
        L_0x00be:
            if (r0 == 0) goto L_0x00c3
            r0.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            throw r1
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0668d.m2361i():void");
    }
}
