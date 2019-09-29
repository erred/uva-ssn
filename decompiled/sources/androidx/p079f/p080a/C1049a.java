package androidx.p079f.p080a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: androidx.f.a.a */
/* compiled from: LocalBroadcastManager */
public final class C1049a {

    /* renamed from: f */
    private static final Object f3264f = new Object();

    /* renamed from: g */
    private static C1049a f3265g;

    /* renamed from: a */
    private final Context f3266a;

    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<C1052b>> f3267b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C1052b>> f3268c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C1051a> f3269d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f3270e;

    /* renamed from: androidx.f.a.a$a */
    /* compiled from: LocalBroadcastManager */
    private static final class C1051a {

        /* renamed from: a */
        final Intent f3272a;

        /* renamed from: b */
        final ArrayList<C1052b> f3273b;

        C1051a(Intent intent, ArrayList<C1052b> arrayList) {
            this.f3272a = intent;
            this.f3273b = arrayList;
        }
    }

    /* renamed from: androidx.f.a.a$b */
    /* compiled from: LocalBroadcastManager */
    private static final class C1052b {

        /* renamed from: a */
        final IntentFilter f3274a;

        /* renamed from: b */
        final BroadcastReceiver f3275b;

        /* renamed from: c */
        boolean f3276c;

        /* renamed from: d */
        boolean f3277d;

        C1052b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f3274a = intentFilter;
            this.f3275b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f3275b);
            sb.append(" filter=");
            sb.append(this.f3274a);
            if (this.f3277d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static C1049a m3996a(Context context) {
        C1049a aVar;
        synchronized (f3264f) {
            if (f3265g == null) {
                f3265g = new C1049a(context.getApplicationContext());
            }
            aVar = f3265g;
        }
        return aVar;
    }

    private C1049a(Context context) {
        this.f3266a = context;
        this.f3270e = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    C1049a.this.mo4057a();
                }
            }
        };
    }

    /* renamed from: a */
    public void mo4059a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f3267b) {
            C1052b bVar = new C1052b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f3267b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f3267b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = (ArrayList) this.f3268c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f3268c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    /* renamed from: a */
    public void mo4058a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f3267b) {
            ArrayList arrayList = (ArrayList) this.f3267b.remove(broadcastReceiver);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    C1052b bVar = (C1052b) arrayList.get(size);
                    bVar.f3277d = true;
                    for (int i = 0; i < bVar.f3274a.countActions(); i++) {
                        String action = bVar.f3274a.getAction(i);
                        ArrayList arrayList2 = (ArrayList) this.f3268c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                C1052b bVar2 = (C1052b) arrayList2.get(size2);
                                if (bVar2.f3275b == broadcastReceiver) {
                                    bVar2.f3277d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f3268c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0168, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x016b, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4060a(android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.f.a.a$b>> r2 = r1.f3267b
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x016c }
            android.content.Context r3 = r1.f3266a     // Catch:{ all -> 0x016c }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x016c }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x016c }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x016c }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x016c }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x016c }
            int r3 = r22.getFlags()     // Catch:{ all -> 0x016c }
            r3 = r3 & 8
            if (r3 == 0) goto L_0x002c
            r16 = 1
            goto L_0x002e
        L_0x002c:
            r16 = 0
        L_0x002e:
            if (r16 == 0) goto L_0x0056
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r4.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r5 = "Resolving type "
            r4.append(r5)     // Catch:{ all -> 0x016c }
            r4.append(r11)     // Catch:{ all -> 0x016c }
            java.lang.String r5 = " scheme "
            r4.append(r5)     // Catch:{ all -> 0x016c }
            r4.append(r13)     // Catch:{ all -> 0x016c }
            java.lang.String r5 = " of intent "
            r4.append(r5)     // Catch:{ all -> 0x016c }
            r4.append(r0)     // Catch:{ all -> 0x016c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x016c }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x016c }
        L_0x0056:
            java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.f.a.a$b>> r3 = r1.f3268c     // Catch:{ all -> 0x016c }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x016c }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x016c }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x016c }
            if (r8 == 0) goto L_0x0169
            if (r16 == 0) goto L_0x007d
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r4.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r5 = "Action list: "
            r4.append(r5)     // Catch:{ all -> 0x016c }
            r4.append(r8)     // Catch:{ all -> 0x016c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x016c }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x016c }
        L_0x007d:
            r3 = 0
            r6 = r3
            r7 = 0
        L_0x0080:
            int r3 = r8.size()     // Catch:{ all -> 0x016c }
            if (r7 >= r3) goto L_0x0139
            java.lang.Object r3 = r8.get(r7)     // Catch:{ all -> 0x016c }
            r5 = r3
            androidx.f.a.a$b r5 = (androidx.p079f.p080a.C1049a.C1052b) r5     // Catch:{ all -> 0x016c }
            if (r16 == 0) goto L_0x00a7
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r4.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r9 = "Matching against filter "
            r4.append(r9)     // Catch:{ all -> 0x016c }
            android.content.IntentFilter r9 = r5.f3274a     // Catch:{ all -> 0x016c }
            r4.append(r9)     // Catch:{ all -> 0x016c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x016c }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x016c }
        L_0x00a7:
            boolean r3 = r5.f3276c     // Catch:{ all -> 0x016c }
            if (r3 == 0) goto L_0x00c0
            if (r16 == 0) goto L_0x00b4
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r4 = "  Filter's target already added"
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x016c }
        L_0x00b4:
            r18 = r7
            r19 = r8
            r17 = r10
            r20 = r11
            r11 = 1
            r10 = r6
            goto L_0x012e
        L_0x00c0:
            android.content.IntentFilter r3 = r5.f3274a     // Catch:{ all -> 0x016c }
            java.lang.String r9 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r17 = r10
            r10 = r6
            r6 = r13
            r18 = r7
            r7 = r12
            r19 = r8
            r8 = r14
            r20 = r11
            r11 = 1
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x016c }
            if (r3 < 0) goto L_0x0105
            if (r16 == 0) goto L_0x00f6
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r5.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r6 = "  Filter matched!  match=0x"
            r5.append(r6)     // Catch:{ all -> 0x016c }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x016c }
            r5.append(r3)     // Catch:{ all -> 0x016c }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x016c }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x016c }
        L_0x00f6:
            if (r10 != 0) goto L_0x00fe
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x016c }
            r6.<init>()     // Catch:{ all -> 0x016c }
            goto L_0x00ff
        L_0x00fe:
            r6 = r10
        L_0x00ff:
            r6.add(r15)     // Catch:{ all -> 0x016c }
            r15.f3276c = r11     // Catch:{ all -> 0x016c }
            goto L_0x012f
        L_0x0105:
            if (r16 == 0) goto L_0x012e
            switch(r3) {
                case -4: goto L_0x0116;
                case -3: goto L_0x0113;
                case -2: goto L_0x0110;
                case -1: goto L_0x010d;
                default: goto L_0x010a;
            }     // Catch:{ all -> 0x016c }
        L_0x010a:
            java.lang.String r3 = "unknown reason"
            goto L_0x0118
        L_0x010d:
            java.lang.String r3 = "type"
            goto L_0x0118
        L_0x0110:
            java.lang.String r3 = "data"
            goto L_0x0118
        L_0x0113:
            java.lang.String r3 = "action"
            goto L_0x0118
        L_0x0116:
            java.lang.String r3 = "category"
        L_0x0118:
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r5.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r6 = "  Filter did not match: "
            r5.append(r6)     // Catch:{ all -> 0x016c }
            r5.append(r3)     // Catch:{ all -> 0x016c }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x016c }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x016c }
        L_0x012e:
            r6 = r10
        L_0x012f:
            int r7 = r18 + 1
            r10 = r17
            r8 = r19
            r11 = r20
            goto L_0x0080
        L_0x0139:
            r10 = r6
            r11 = 1
            if (r10 == 0) goto L_0x0169
            r3 = 0
        L_0x013e:
            int r4 = r10.size()     // Catch:{ all -> 0x016c }
            if (r3 >= r4) goto L_0x0150
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x016c }
            androidx.f.a.a$b r4 = (androidx.p079f.p080a.C1049a.C1052b) r4     // Catch:{ all -> 0x016c }
            r5 = 0
            r4.f3276c = r5     // Catch:{ all -> 0x016c }
            int r3 = r3 + 1
            goto L_0x013e
        L_0x0150:
            java.util.ArrayList<androidx.f.a.a$a> r3 = r1.f3269d     // Catch:{ all -> 0x016c }
            androidx.f.a.a$a r4 = new androidx.f.a.a$a     // Catch:{ all -> 0x016c }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x016c }
            r3.add(r4)     // Catch:{ all -> 0x016c }
            android.os.Handler r0 = r1.f3270e     // Catch:{ all -> 0x016c }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x016c }
            if (r0 != 0) goto L_0x0167
            android.os.Handler r0 = r1.f3270e     // Catch:{ all -> 0x016c }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x016c }
        L_0x0167:
            monitor-exit(r2)     // Catch:{ all -> 0x016c }
            return r11
        L_0x0169:
            monitor-exit(r2)     // Catch:{ all -> 0x016c }
            r0 = 0
            return r0
        L_0x016c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x016c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p079f.p080a.C1049a.mo4060a(android.content.Intent):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2 >= r1.length) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r3 = r1[r2];
        r4 = r3.f3273b.size();
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r5 >= r4) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r6 = (androidx.p079f.p080a.C1049a.C1052b) r3.f3273b.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r6.f3277d != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r6.f3275b.onReceive(r9.f3266a, r3.f3272a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r2 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4057a() {
        /*
            r9 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.f.a.a$b>> r0 = r9.f3267b
            monitor-enter(r0)
            java.util.ArrayList<androidx.f.a.a$a> r1 = r9.f3269d     // Catch:{ all -> 0x0045 }
            int r1 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x000d:
            androidx.f.a.a$a[] r1 = new androidx.p079f.p080a.C1049a.C1051a[r1]     // Catch:{ all -> 0x0045 }
            java.util.ArrayList<androidx.f.a.a$a> r2 = r9.f3269d     // Catch:{ all -> 0x0045 }
            r2.toArray(r1)     // Catch:{ all -> 0x0045 }
            java.util.ArrayList<androidx.f.a.a$a> r2 = r9.f3269d     // Catch:{ all -> 0x0045 }
            r2.clear()     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            r0 = 0
            r2 = 0
        L_0x001c:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0000
            r3 = r1[r2]
            java.util.ArrayList<androidx.f.a.a$b> r4 = r3.f3273b
            int r4 = r4.size()
            r5 = 0
        L_0x0028:
            if (r5 >= r4) goto L_0x0042
            java.util.ArrayList<androidx.f.a.a$b> r6 = r3.f3273b
            java.lang.Object r6 = r6.get(r5)
            androidx.f.a.a$b r6 = (androidx.p079f.p080a.C1049a.C1052b) r6
            boolean r7 = r6.f3277d
            if (r7 != 0) goto L_0x003f
            android.content.BroadcastReceiver r6 = r6.f3275b
            android.content.Context r7 = r9.f3266a
            android.content.Intent r8 = r3.f3272a
            r6.onReceive(r7, r8)
        L_0x003f:
            int r5 = r5 + 1
            goto L_0x0028
        L_0x0042:
            int r2 = r2 + 1
            goto L_0x001c
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p079f.p080a.C1049a.mo4057a():void");
    }
}
