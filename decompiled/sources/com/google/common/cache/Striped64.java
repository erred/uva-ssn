package com.google.common.cache;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64 extends Number {
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    static final ThreadHashCode threadHashCode = new ThreadHashCode();
    volatile transient long base;
    volatile transient int busy;
    volatile transient Cell[] cells;

    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* renamed from: p0 */
        volatile long f6745p0;

        /* renamed from: p1 */
        volatile long f6746p1;

        /* renamed from: p2 */
        volatile long f6747p2;

        /* renamed from: p3 */
        volatile long f6748p3;

        /* renamed from: p4 */
        volatile long f6749p4;

        /* renamed from: p5 */
        volatile long f6750p5;

        /* renamed from: p6 */
        volatile long f6751p6;

        /* renamed from: q0 */
        volatile long f6752q0;

        /* renamed from: q1 */
        volatile long f6753q1;

        /* renamed from: q2 */
        volatile long f6754q2;

        /* renamed from: q3 */
        volatile long f6755q3;

        /* renamed from: q4 */
        volatile long f6756q4;

        /* renamed from: q5 */
        volatile long f6757q5;

        /* renamed from: q6 */
        volatile long f6758q6;
        volatile long value;

        Cell(long j) {
            this.value = j;
        }

        /* access modifiers changed from: 0000 */
        public final boolean cas(long j, long j2) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j, j2);
        }

        static {
            try {
                UNSAFE = Striped64.getUnsafe();
                valueOffset = UNSAFE.objectFieldOffset(Cell.class.getDeclaredField(Param.VALUE));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    static final class HashCode {
        static final Random rng = new Random();
        int code;

        HashCode() {
            int nextInt = rng.nextInt();
            if (nextInt == 0) {
                nextInt = 1;
            }
            this.code = nextInt;
        }
    }

    static final class ThreadHashCode extends ThreadLocal<HashCode> {
        ThreadHashCode() {
        }

        public HashCode initialValue() {
            return new HashCode();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: fn */
    public abstract long mo21820fn(long j, long j2);

    static {
        try {
            UNSAFE = getUnsafe();
            Class<Striped64> cls = Striped64.class;
            baseOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField("base"));
            busyOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    /* access modifiers changed from: 0000 */
    public final boolean casBase(long j, long j2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j, j2);
    }

    /* access modifiers changed from: 0000 */
    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006f, code lost:
        if (r11.cells != r3) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0071, code lost:
        r2 = new com.google.common.cache.Striped64.Cell[(r5 << 1)];
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0076, code lost:
        if (r4 >= r5) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0078, code lost:
        r2[r4] = r3[r4];
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007f, code lost:
        r11.cells = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00cb A[EDGE_INSN: B:76:0x00cb->B:73:0x00cb ?: BREAK  
    EDGE_INSN: B:76:0x00cb->B:73:0x00cb ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void retryUpdate(long r12, com.google.common.cache.Striped64.HashCode r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r14.code
            r1 = 0
        L_0x0003:
            r2 = 0
        L_0x0004:
            com.google.common.cache.Striped64$Cell[] r3 = r11.cells
            r4 = 1
            if (r3 == 0) goto L_0x0094
            int r5 = r3.length
            if (r5 <= 0) goto L_0x0094
            int r6 = r5 + -1
            r6 = r6 & r0
            r6 = r3[r6]
            if (r6 != 0) goto L_0x0044
            int r3 = r11.busy
            if (r3 != 0) goto L_0x0042
            com.google.common.cache.Striped64$Cell r3 = new com.google.common.cache.Striped64$Cell
            r3.<init>(r12)
            int r5 = r11.busy
            if (r5 != 0) goto L_0x0042
            boolean r5 = r11.casBusy()
            if (r5 == 0) goto L_0x0042
            com.google.common.cache.Striped64$Cell[] r5 = r11.cells     // Catch:{ all -> 0x003e }
            if (r5 == 0) goto L_0x0037
            int r6 = r5.length     // Catch:{ all -> 0x003e }
            if (r6 <= 0) goto L_0x0037
            int r6 = r6 + -1
            r6 = r6 & r0
            r7 = r5[r6]     // Catch:{ all -> 0x003e }
            if (r7 != 0) goto L_0x0037
            r5[r6] = r3     // Catch:{ all -> 0x003e }
            goto L_0x0038
        L_0x0037:
            r4 = 0
        L_0x0038:
            r11.busy = r1
            if (r4 == 0) goto L_0x0004
            goto L_0x00cb
        L_0x003e:
            r12 = move-exception
            r11.busy = r1
            throw r12
        L_0x0042:
            r2 = 0
            goto L_0x0089
        L_0x0044:
            if (r15 != 0) goto L_0x0048
            r15 = 1
            goto L_0x0089
        L_0x0048:
            long r7 = r6.value
            long r9 = r11.mo21820fn(r7, r12)
            boolean r6 = r6.cas(r7, r9)
            if (r6 == 0) goto L_0x0056
            goto L_0x00cb
        L_0x0056:
            int r6 = NCPU
            if (r5 >= r6) goto L_0x0042
            com.google.common.cache.Striped64$Cell[] r6 = r11.cells
            if (r6 == r3) goto L_0x005f
            goto L_0x0042
        L_0x005f:
            if (r2 != 0) goto L_0x0063
            r2 = 1
            goto L_0x0089
        L_0x0063:
            int r4 = r11.busy
            if (r4 != 0) goto L_0x0089
            boolean r4 = r11.casBusy()
            if (r4 == 0) goto L_0x0089
            com.google.common.cache.Striped64$Cell[] r2 = r11.cells     // Catch:{ all -> 0x0085 }
            if (r2 != r3) goto L_0x0081
            int r2 = r5 << 1
            com.google.common.cache.Striped64$Cell[] r2 = new com.google.common.cache.Striped64.Cell[r2]     // Catch:{ all -> 0x0085 }
            r4 = 0
        L_0x0076:
            if (r4 >= r5) goto L_0x007f
            r6 = r3[r4]     // Catch:{ all -> 0x0085 }
            r2[r4] = r6     // Catch:{ all -> 0x0085 }
            int r4 = r4 + 1
            goto L_0x0076
        L_0x007f:
            r11.cells = r2     // Catch:{ all -> 0x0085 }
        L_0x0081:
            r11.busy = r1
            goto L_0x0003
        L_0x0085:
            r12 = move-exception
            r11.busy = r1
            throw r12
        L_0x0089:
            int r3 = r0 << 13
            r0 = r0 ^ r3
            int r3 = r0 >>> 17
            r0 = r0 ^ r3
            int r3 = r0 << 5
            r0 = r0 ^ r3
            goto L_0x0004
        L_0x0094:
            int r5 = r11.busy
            if (r5 != 0) goto L_0x00bf
            com.google.common.cache.Striped64$Cell[] r5 = r11.cells
            if (r5 != r3) goto L_0x00bf
            boolean r5 = r11.casBusy()
            if (r5 == 0) goto L_0x00bf
            com.google.common.cache.Striped64$Cell[] r5 = r11.cells     // Catch:{ all -> 0x00bb }
            if (r5 != r3) goto L_0x00b5
            r3 = 2
            com.google.common.cache.Striped64$Cell[] r3 = new com.google.common.cache.Striped64.Cell[r3]     // Catch:{ all -> 0x00bb }
            r5 = r0 & 1
            com.google.common.cache.Striped64$Cell r6 = new com.google.common.cache.Striped64$Cell     // Catch:{ all -> 0x00bb }
            r6.<init>(r12)     // Catch:{ all -> 0x00bb }
            r3[r5] = r6     // Catch:{ all -> 0x00bb }
            r11.cells = r3     // Catch:{ all -> 0x00bb }
            goto L_0x00b6
        L_0x00b5:
            r4 = 0
        L_0x00b6:
            r11.busy = r1
            if (r4 == 0) goto L_0x0004
            goto L_0x00cb
        L_0x00bb:
            r12 = move-exception
            r11.busy = r1
            throw r12
        L_0x00bf:
            long r3 = r11.base
            long r5 = r11.mo21820fn(r3, r12)
            boolean r3 = r11.casBase(r3, r5)
            if (r3 == 0) goto L_0x0004
        L_0x00cb:
            r14.code = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.retryUpdate(long, com.google.common.cache.Striped64$HashCode, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    public final void internalReset(long j) {
        Cell[] cellArr = this.cells;
        this.base = j;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.cache.Striped64.C24111());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static sun.misc.Unsafe getUnsafe() {
        /*
            sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
            return r0
        L_0x0005:
            com.google.common.cache.Striped64$1 r0 = new com.google.common.cache.Striped64$1     // Catch:{ PrivilegedActionException -> 0x0011 }
            r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
            sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
            return r0
        L_0x0011:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.Throwable r0 = r0.getCause()
            java.lang.String r2 = "Could not initialize intrinsics"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.getUnsafe():sun.misc.Unsafe");
    }
}
