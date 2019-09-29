package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0786e;
import androidx.constraintlayout.p060b.p061a.C0761e.C0765c;
import androidx.constraintlayout.p060b.p061a.C0766f.C0768a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: androidx.constraintlayout.b.a.g */
/* compiled from: ConstraintWidgetContainer */
public class C0769g extends C0782r {

    /* renamed from: aA */
    private boolean f2302aA = false;

    /* renamed from: aB */
    private boolean f2303aB = false;

    /* renamed from: af */
    protected C0786e f2304af = new C0786e();

    /* renamed from: ag */
    int f2305ag;

    /* renamed from: ah */
    int f2306ah;

    /* renamed from: ai */
    int f2307ai;

    /* renamed from: aj */
    int f2308aj;

    /* renamed from: ak */
    int f2309ak = 0;

    /* renamed from: al */
    int f2310al = 0;

    /* renamed from: am */
    C0760d[] f2311am = new C0760d[4];

    /* renamed from: an */
    C0760d[] f2312an = new C0760d[4];

    /* renamed from: ao */
    public List<C0770h> f2313ao = new ArrayList();

    /* renamed from: ap */
    public boolean f2314ap = false;

    /* renamed from: aq */
    public boolean f2315aq = false;

    /* renamed from: ar */
    public boolean f2316ar = false;

    /* renamed from: as */
    public int f2317as = 0;

    /* renamed from: at */
    public int f2318at = 0;

    /* renamed from: au */
    public boolean f2319au = false;

    /* renamed from: av */
    int f2320av = 0;

    /* renamed from: ax */
    private boolean f2321ax = false;

    /* renamed from: ay */
    private C0780q f2322ay;

    /* renamed from: az */
    private int f2323az = 3;

    /* renamed from: S */
    public boolean mo3134S() {
        return false;
    }

    /* renamed from: a */
    public void mo3029a(int i) {
        this.f2323az = i;
    }

    /* renamed from: b */
    public int mo3034b() {
        return this.f2323az;
    }

    /* renamed from: q */
    public boolean mo3140q(int i) {
        return (this.f2323az & i) == i;
    }

    /* renamed from: g */
    public void mo3095g() {
        this.f2304af.mo3215b();
        this.f2305ag = 0;
        this.f2307ai = 0;
        this.f2306ah = 0;
        this.f2308aj = 0;
        this.f2313ao.clear();
        this.f2319au = false;
        super.mo3095g();
    }

    /* renamed from: K */
    public boolean mo3126K() {
        return this.f2302aA;
    }

    /* renamed from: L */
    public boolean mo3127L() {
        return this.f2303aB;
    }

    /* renamed from: d */
    public boolean mo3138d(C0786e eVar) {
        mo3030a(eVar);
        int size = this.f2371aw.size();
        for (int i = 0; i < size; i++) {
            C0766f fVar = (C0766f) this.f2371aw.get(i);
            if (fVar instanceof C0769g) {
                C0768a aVar = fVar.f2228C[0];
                C0768a aVar2 = fVar.f2228C[1];
                if (aVar == C0768a.WRAP_CONTENT) {
                    fVar.mo3070a(C0768a.FIXED);
                }
                if (aVar2 == C0768a.WRAP_CONTENT) {
                    fVar.mo3080b(C0768a.FIXED);
                }
                fVar.mo3030a(eVar);
                if (aVar == C0768a.WRAP_CONTENT) {
                    fVar.mo3070a(aVar);
                }
                if (aVar2 == C0768a.WRAP_CONTENT) {
                    fVar.mo3080b(aVar2);
                }
            } else {
                C0775l.m2868a(this, eVar, fVar);
                fVar.mo3030a(eVar);
            }
        }
        if (this.f2309ak > 0) {
            C0759c.m2729a(this, eVar, 0);
        }
        if (this.f2310al > 0) {
            C0759c.m2729a(this, eVar, 1);
        }
        return true;
    }

    /* renamed from: a */
    public void mo3136a(C0786e eVar, boolean[] zArr) {
        zArr[2] = false;
        mo3086c(eVar);
        int size = this.f2371aw.size();
        for (int i = 0; i < size; i++) {
            C0766f fVar = (C0766f) this.f2371aw.get(i);
            fVar.mo3086c(eVar);
            if (fVar.f2228C[0] == C0768a.MATCH_CONSTRAINT && fVar.mo3113p() < fVar.mo3115q()) {
                zArr[2] = true;
            }
            if (fVar.f2228C[1] == C0768a.MATCH_CONSTRAINT && fVar.mo3116r() < fVar.mo3117s()) {
                zArr[2] = true;
            }
        }
    }

    /* renamed from: a */
    public void mo3137a(boolean z) {
        this.f2321ax = z;
    }

    /* renamed from: M */
    public boolean mo3128M() {
        return this.f2321ax;
    }

    /* renamed from: b */
    public void mo3033b(int i) {
        super.mo3033b(i);
        int size = this.f2371aw.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C0766f) this.f2371aw.get(i2)).mo3033b(i);
        }
    }

    /* JADX WARNING: type inference failed for: r7v10, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r7v44 */
    /* JADX WARNING: type inference failed for: r7v45 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v10, types: [boolean]
      assigns: []
      uses: [?[int, short, byte, char], boolean]
      mth insns count: 316
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0253  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: N */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3129N() {
        /*
            r23 = this;
            r1 = r23
            int r2 = r1.f2234I
            int r3 = r1.f2235J
            int r0 = r23.mo3113p()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r23.mo3116r()
            int r6 = java.lang.Math.max(r4, r0)
            r1.f2302aA = r4
            r1.f2303aB = r4
            androidx.constraintlayout.b.a.f r0 = r1.f2229D
            if (r0 == 0) goto L_0x0046
            androidx.constraintlayout.b.a.q r0 = r1.f2322ay
            if (r0 != 0) goto L_0x002a
            androidx.constraintlayout.b.a.q r0 = new androidx.constraintlayout.b.a.q
            r0.<init>(r1)
            r1.f2322ay = r0
        L_0x002a:
            androidx.constraintlayout.b.a.q r0 = r1.f2322ay
            r0.mo3168a(r1)
            int r0 = r1.f2305ag
            r1.mo3093f(r0)
            int r0 = r1.f2306ah
            r1.mo3096g(r0)
            r23.mo3058F()
            androidx.constraintlayout.b.e r0 = r1.f2304af
            androidx.constraintlayout.b.c r0 = r0.mo3223g()
            r1.mo3072a(r0)
            goto L_0x004a
        L_0x0046:
            r1.f2234I = r4
            r1.f2235J = r4
        L_0x004a:
            int r0 = r1.f2323az
            r7 = 8
            r8 = 1
            if (r0 == 0) goto L_0x0062
            boolean r0 = r1.mo3140q(r7)
            if (r0 != 0) goto L_0x005a
            r23.mo3132Q()
        L_0x005a:
            r23.mo3133R()
            androidx.constraintlayout.b.e r0 = r1.f2304af
            r0.f2384c = r8
            goto L_0x0066
        L_0x0062:
            androidx.constraintlayout.b.e r0 = r1.f2304af
            r0.f2384c = r4
        L_0x0066:
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            r9 = r0[r8]
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            r10 = r0[r4]
            r23.m2828V()
            java.util.List<androidx.constraintlayout.b.a.h> r0 = r1.f2313ao
            int r0 = r0.size()
            if (r0 != 0) goto L_0x008a
            java.util.List<androidx.constraintlayout.b.a.h> r0 = r1.f2313ao
            r0.clear()
            java.util.List<androidx.constraintlayout.b.a.h> r0 = r1.f2313ao
            androidx.constraintlayout.b.a.h r11 = new androidx.constraintlayout.b.a.h
            java.util.ArrayList r12 = r1.f2371aw
            r11.<init>(r12)
            r0.add(r4, r11)
        L_0x008a:
            java.util.List<androidx.constraintlayout.b.a.h> r0 = r1.f2313ao
            int r11 = r0.size()
            java.util.ArrayList r12 = r1.f2371aw
            androidx.constraintlayout.b.a.f$a r0 = r23.mo3059G()
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r0 == r13) goto L_0x00a5
            androidx.constraintlayout.b.a.f$a r0 = r23.mo3060H()
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r0 != r13) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r13 = 0
            goto L_0x00a6
        L_0x00a5:
            r13 = 1
        L_0x00a6:
            r0 = 0
            r14 = 0
        L_0x00a8:
            if (r14 >= r11) goto L_0x02a6
            boolean r15 = r1.f2319au
            if (r15 != 0) goto L_0x02a6
            java.util.List<androidx.constraintlayout.b.a.h> r15 = r1.f2313ao
            java.lang.Object r15 = r15.get(r14)
            androidx.constraintlayout.b.a.h r15 = (androidx.constraintlayout.p060b.p061a.C0770h) r15
            java.util.List<androidx.constraintlayout.b.a.f> r15 = r15.f2324a
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            r1.f2371aw = r15
            r23.m2828V()
            java.util.ArrayList r15 = r1.f2371aw
            int r15 = r15.size()
            r7 = 0
        L_0x00c6:
            if (r7 >= r15) goto L_0x00de
            java.util.ArrayList r4 = r1.f2371aw
            java.lang.Object r4 = r4.get(r7)
            androidx.constraintlayout.b.a.f r4 = (androidx.constraintlayout.p060b.p061a.C0766f) r4
            boolean r8 = r4 instanceof androidx.constraintlayout.p060b.p061a.C0782r
            if (r8 == 0) goto L_0x00d9
            androidx.constraintlayout.b.a.r r4 = (androidx.constraintlayout.p060b.p061a.C0782r) r4
            r4.mo3129N()
        L_0x00d9:
            int r7 = r7 + 1
            r4 = 0
            r8 = 1
            goto L_0x00c6
        L_0x00de:
            r7 = r0
            r0 = 0
            r4 = 1
        L_0x00e1:
            if (r4 == 0) goto L_0x0298
            r18 = r4
            r8 = 1
            int r4 = r0 + 1
            androidx.constraintlayout.b.e r0 = r1.f2304af     // Catch:{ Exception -> 0x0122 }
            r0.mo3215b()     // Catch:{ Exception -> 0x0122 }
            androidx.constraintlayout.b.e r0 = r1.f2304af     // Catch:{ Exception -> 0x0122 }
            r1.mo3081b(r0)     // Catch:{ Exception -> 0x0122 }
            r0 = 0
        L_0x00f3:
            if (r0 >= r15) goto L_0x0109
            java.util.ArrayList r8 = r1.f2371aw     // Catch:{ Exception -> 0x0122 }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x0122 }
            androidx.constraintlayout.b.a.f r8 = (androidx.constraintlayout.p060b.p061a.C0766f) r8     // Catch:{ Exception -> 0x0122 }
            r19 = r7
            androidx.constraintlayout.b.e r7 = r1.f2304af     // Catch:{ Exception -> 0x0120 }
            r8.mo3081b(r7)     // Catch:{ Exception -> 0x0120 }
            int r0 = r0 + 1
            r7 = r19
            goto L_0x00f3
        L_0x0109:
            r19 = r7
            androidx.constraintlayout.b.e r0 = r1.f2304af     // Catch:{ Exception -> 0x0120 }
            boolean r7 = r1.mo3138d(r0)     // Catch:{ Exception -> 0x0120 }
            if (r7 == 0) goto L_0x011b
            androidx.constraintlayout.b.e r0 = r1.f2304af     // Catch:{ Exception -> 0x0119 }
            r0.mo3222f()     // Catch:{ Exception -> 0x0119 }
            goto L_0x011b
        L_0x0119:
            r0 = move-exception
            goto L_0x0127
        L_0x011b:
            r20 = r7
            r21 = r11
            goto L_0x0144
        L_0x0120:
            r0 = move-exception
            goto L_0x0125
        L_0x0122:
            r0 = move-exception
            r19 = r7
        L_0x0125:
            r7 = r18
        L_0x0127:
            r0.printStackTrace()
            java.io.PrintStream r8 = java.lang.System.out
            r20 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r21 = r11
            java.lang.String r11 = "EXCEPTION : "
            r7.append(r11)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r8.println(r0)
        L_0x0144:
            if (r20 == 0) goto L_0x014f
            androidx.constraintlayout.b.e r7 = r1.f2304af
            boolean[] r8 = androidx.constraintlayout.p060b.p061a.C0775l.f2344a
            r1.mo3136a(r7, r8)
        L_0x014d:
            r8 = 2
            goto L_0x0198
        L_0x014f:
            androidx.constraintlayout.b.e r7 = r1.f2304af
            r1.mo3086c(r7)
            r7 = 0
        L_0x0155:
            if (r7 >= r15) goto L_0x014d
            java.util.ArrayList r8 = r1.f2371aw
            java.lang.Object r8 = r8.get(r7)
            androidx.constraintlayout.b.a.f r8 = (androidx.constraintlayout.p060b.p061a.C0766f) r8
            androidx.constraintlayout.b.a.f$a[] r11 = r8.f2228C
            r17 = 0
            r11 = r11[r17]
            androidx.constraintlayout.b.a.f$a r0 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r11 != r0) goto L_0x017a
            int r0 = r8.mo3113p()
            int r11 = r8.mo3115q()
            if (r0 >= r11) goto L_0x017a
            boolean[] r0 = androidx.constraintlayout.p060b.p061a.C0775l.f2344a
            r7 = 2
            r11 = 1
            r0[r7] = r11
            goto L_0x014d
        L_0x017a:
            r11 = 1
            androidx.constraintlayout.b.a.f$a[] r0 = r8.f2228C
            r0 = r0[r11]
            androidx.constraintlayout.b.a.f$a r11 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r0 != r11) goto L_0x0194
            int r0 = r8.mo3116r()
            int r8 = r8.mo3117s()
            if (r0 >= r8) goto L_0x0194
            boolean[] r0 = androidx.constraintlayout.p060b.p061a.C0775l.f2344a
            r7 = 1
            r8 = 2
            r0[r8] = r7
            goto L_0x0198
        L_0x0194:
            r8 = 2
            int r7 = r7 + 1
            goto L_0x0155
        L_0x0198:
            if (r13 == 0) goto L_0x0212
            r7 = 8
            if (r4 >= r7) goto L_0x0212
            boolean[] r0 = androidx.constraintlayout.p060b.p061a.C0775l.f2344a
            boolean r0 = r0[r8]
            if (r0 == 0) goto L_0x0212
            r0 = 0
            r8 = 0
            r11 = 0
        L_0x01a7:
            if (r0 >= r15) goto L_0x01d1
            java.util.ArrayList r7 = r1.f2371aw
            java.lang.Object r7 = r7.get(r0)
            androidx.constraintlayout.b.a.f r7 = (androidx.constraintlayout.p060b.p061a.C0766f) r7
            r22 = r4
            int r4 = r7.f2234I
            int r16 = r7.mo3113p()
            int r4 = r4 + r16
            int r8 = java.lang.Math.max(r8, r4)
            int r4 = r7.f2235J
            int r7 = r7.mo3116r()
            int r4 = r4 + r7
            int r11 = java.lang.Math.max(r11, r4)
            int r0 = r0 + 1
            r4 = r22
            r7 = 8
            goto L_0x01a7
        L_0x01d1:
            r22 = r4
            int r0 = r1.f2241P
            int r0 = java.lang.Math.max(r0, r8)
            int r4 = r1.f2242Q
            int r4 = java.lang.Math.max(r4, r11)
            androidx.constraintlayout.b.a.f$a r7 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r10 != r7) goto L_0x01f7
            int r7 = r23.mo3113p()
            if (r7 >= r0) goto L_0x01f7
            r1.mo3098h(r0)
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            androidx.constraintlayout.b.a.f$a r7 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            r8 = 0
            r0[r8] = r7
            r0 = 1
            r19 = 1
            goto L_0x01f8
        L_0x01f7:
            r0 = 0
        L_0x01f8:
            androidx.constraintlayout.b.a.f$a r7 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r9 != r7) goto L_0x020f
            int r7 = r23.mo3116r()
            if (r7 >= r4) goto L_0x020f
            r1.mo3100i(r4)
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            androidx.constraintlayout.b.a.f$a r4 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            r7 = 1
            r0[r7] = r4
            r0 = 1
            r8 = 1
            goto L_0x0217
        L_0x020f:
            r8 = r19
            goto L_0x0217
        L_0x0212:
            r22 = r4
            r8 = r19
            r0 = 0
        L_0x0217:
            int r4 = r1.f2241P
            int r7 = r23.mo3113p()
            int r4 = java.lang.Math.max(r4, r7)
            int r7 = r23.mo3113p()
            if (r4 <= r7) goto L_0x0233
            r1.mo3098h(r4)
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            androidx.constraintlayout.b.a.f$a r4 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.FIXED
            r7 = 0
            r0[r7] = r4
            r0 = 1
            r8 = 1
        L_0x0233:
            int r4 = r1.f2242Q
            int r7 = r23.mo3116r()
            int r4 = java.lang.Math.max(r4, r7)
            int r7 = r23.mo3116r()
            if (r4 <= r7) goto L_0x0250
            r1.mo3100i(r4)
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            androidx.constraintlayout.b.a.f$a r4 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.FIXED
            r7 = 1
            r0[r7] = r4
            r0 = 1
            r8 = 1
            goto L_0x0251
        L_0x0250:
            r7 = 1
        L_0x0251:
            if (r8 != 0) goto L_0x0290
            androidx.constraintlayout.b.a.f$a[] r4 = r1.f2228C
            r11 = 0
            r4 = r4[r11]
            androidx.constraintlayout.b.a.f$a r11 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r4 != r11) goto L_0x0272
            if (r5 <= 0) goto L_0x0272
            int r4 = r23.mo3113p()
            if (r4 <= r5) goto L_0x0272
            r1.f2302aA = r7
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            androidx.constraintlayout.b.a.f$a r4 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.FIXED
            r8 = 0
            r0[r8] = r4
            r1.mo3098h(r5)
            r0 = 1
            r8 = 1
        L_0x0272:
            androidx.constraintlayout.b.a.f$a[] r4 = r1.f2228C
            r4 = r4[r7]
            androidx.constraintlayout.b.a.f$a r11 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r4 != r11) goto L_0x0290
            if (r6 <= 0) goto L_0x0290
            int r4 = r23.mo3116r()
            if (r4 <= r6) goto L_0x0290
            r1.f2303aB = r7
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            androidx.constraintlayout.b.a.f$a r4 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.FIXED
            r0[r7] = r4
            r1.mo3100i(r6)
            r4 = 1
            r7 = 1
            goto L_0x0292
        L_0x0290:
            r4 = r0
            r7 = r8
        L_0x0292:
            r11 = r21
            r0 = r22
            goto L_0x00e1
        L_0x0298:
            r19 = r7
            r21 = r11
            int r14 = r14 + 1
            r0 = r19
            r4 = 0
            r7 = 8
            r8 = 1
            goto L_0x00a8
        L_0x02a6:
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            r1.f2371aw = r12
            androidx.constraintlayout.b.a.f r4 = r1.f2229D
            if (r4 == 0) goto L_0x02da
            int r2 = r1.f2241P
            int r3 = r23.mo3113p()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.f2242Q
            int r4 = r23.mo3116r()
            int r3 = java.lang.Math.max(r3, r4)
            androidx.constraintlayout.b.a.q r4 = r1.f2322ay
            r4.mo3169b(r1)
            int r4 = r1.f2305ag
            int r2 = r2 + r4
            int r4 = r1.f2307ai
            int r2 = r2 + r4
            r1.mo3098h(r2)
            int r2 = r1.f2306ah
            int r3 = r3 + r2
            int r2 = r1.f2308aj
            int r3 = r3 + r2
            r1.mo3100i(r3)
            goto L_0x02de
        L_0x02da:
            r1.f2234I = r2
            r1.f2235J = r3
        L_0x02de:
            if (r0 == 0) goto L_0x02ea
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            r2 = 0
            r0[r2] = r10
            androidx.constraintlayout.b.a.f$a[] r0 = r1.f2228C
            r2 = 1
            r0[r2] = r9
        L_0x02ea:
            androidx.constraintlayout.b.e r0 = r1.f2304af
            androidx.constraintlayout.b.c r0 = r0.mo3223g()
            r1.mo3072a(r0)
            androidx.constraintlayout.b.a.g r0 = r23.mo3172T()
            if (r1 != r0) goto L_0x02fc
            r23.mo3057E()
        L_0x02fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.p061a.C0769g.mo3129N():void");
    }

    /* renamed from: O */
    public void mo3130O() {
        mo3132Q();
        mo3033b(this.f2323az);
    }

    /* renamed from: P */
    public void mo3131P() {
        C0777n a = mo3063a(C0765c.LEFT).mo3038a();
        C0777n a2 = mo3063a(C0765c.TOP).mo3038a();
        a.mo3151a((C0777n) null, (float) BitmapDescriptorFactory.HUE_RED);
        a2.mo3151a((C0777n) null, (float) BitmapDescriptorFactory.HUE_RED);
    }

    /* renamed from: e */
    public void mo3139e(int i, int i2) {
        if (!(this.f2228C[0] == C0768a.WRAP_CONTENT || this.f2271c == null)) {
            this.f2271c.mo3162a(i);
        }
        if (this.f2228C[1] != C0768a.WRAP_CONTENT && this.f2272d != null) {
            this.f2272d.mo3162a(i2);
        }
    }

    /* renamed from: Q */
    public void mo3132Q() {
        int size = this.f2371aw.size();
        mo3035c();
        for (int i = 0; i < size; i++) {
            ((C0766f) this.f2371aw.get(i)).mo3035c();
        }
    }

    /* renamed from: R */
    public void mo3133R() {
        if (!mo3140q(8)) {
            mo3033b(this.f2323az);
        }
        mo3131P();
    }

    /* renamed from: V */
    private void m2828V() {
        this.f2309ak = 0;
        this.f2310al = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3135a(C0766f fVar, int i) {
        if (i == 0) {
            m2829d(fVar);
        } else if (i == 1) {
            m2830e(fVar);
        }
    }

    /* renamed from: d */
    private void m2829d(C0766f fVar) {
        if (this.f2309ak + 1 >= this.f2312an.length) {
            this.f2312an = (C0760d[]) Arrays.copyOf(this.f2312an, this.f2312an.length * 2);
        }
        this.f2312an[this.f2309ak] = new C0760d(fVar, 0, mo3128M());
        this.f2309ak++;
    }

    /* renamed from: e */
    private void m2830e(C0766f fVar) {
        if (this.f2310al + 1 >= this.f2311am.length) {
            this.f2311am = (C0760d[]) Arrays.copyOf(this.f2311am, this.f2311am.length * 2);
        }
        this.f2311am[this.f2310al] = new C0760d(fVar, 1, mo3128M());
        this.f2310al++;
    }
}
