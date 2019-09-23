package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.p052b.C0712a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfz;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzm extends zzfn {
    zzm(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgy() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x08c8  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0aa2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzfr[] zza(java.lang.String r99, com.google.android.gms.internal.measurement.zzft[] r100, com.google.android.gms.internal.measurement.zzfz[] r101) {
        /*
            r98 = this;
            r7 = r98
            r15 = r99
            r13 = r100
            r14 = r101
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r99)
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            androidx.b.a r12 = new androidx.b.a
            r12.<init>()
            androidx.b.a r10 = new androidx.b.a
            r10.<init>()
            androidx.b.a r9 = new androidx.b.a
            r9.<init>()
            androidx.b.a r8 = new androidx.b.a
            r8.<init>()
            androidx.b.a r6 = new androidx.b.a
            r6.<init>()
            com.google.android.gms.measurement.internal.zzq r0 = r98.zzgv()
            boolean r23 = r0.zzbb(r15)
            com.google.android.gms.measurement.internal.zzt r0 = r98.zzjt()
            java.util.Map r0 = r0.zzbp(r15)
            if (r0 == 0) goto L_0x0185
            java.util.Set r1 = r0.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0043:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0185
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzfx r4 = (com.google.android.gms.internal.measurement.zzfx) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            java.lang.Object r5 = r10.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r9.get(r3)
            java.util.BitSet r3 = (java.util.BitSet) r3
            if (r23 == 0) goto L_0x00b3
            r27 = r0
            androidx.b.a r0 = new androidx.b.a
            r0.<init>()
            if (r4 == 0) goto L_0x00a5
            r28 = r1
            com.google.android.gms.internal.measurement.zzfs[] r1 = r4.zzayp
            if (r1 != 0) goto L_0x0083
            goto L_0x00a7
        L_0x0083:
            com.google.android.gms.internal.measurement.zzfs[] r1 = r4.zzayp
            r29 = r3
            int r3 = r1.length
            r30 = r11
            r11 = 0
        L_0x008b:
            if (r11 >= r3) goto L_0x00ab
            r31 = r3
            r3 = r1[r11]
            r32 = r1
            java.lang.Integer r1 = r3.zzawx
            if (r1 == 0) goto L_0x009e
            java.lang.Integer r1 = r3.zzawx
            java.lang.Long r3 = r3.zzawy
            r0.put(r1, r3)
        L_0x009e:
            int r11 = r11 + 1
            r3 = r31
            r1 = r32
            goto L_0x008b
        L_0x00a5:
            r28 = r1
        L_0x00a7:
            r29 = r3
            r30 = r11
        L_0x00ab:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r8.put(r1, r0)
            goto L_0x00bc
        L_0x00b3:
            r27 = r0
            r28 = r1
            r29 = r3
            r30 = r11
            r0 = 0
        L_0x00bc:
            if (r5 != 0) goto L_0x00d7
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r10.put(r1, r5)
            java.util.BitSet r3 = new java.util.BitSet
            r3.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r9.put(r1, r3)
            goto L_0x00d9
        L_0x00d7:
            r3 = r29
        L_0x00d9:
            r1 = 0
        L_0x00da:
            long[] r11 = r4.zzayn
            int r11 = r11.length
            int r11 = r11 << 6
            if (r1 >= r11) goto L_0x012f
            long[] r11 = r4.zzayn
            boolean r11 = com.google.android.gms.measurement.internal.zzfu.zza(r11, r1)
            if (r11 == 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zzas r11 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r11 = r11.zzjo()
            r33 = r8
            java.lang.String r8 = "Filter already evaluated. audience ID, filter ID"
            r34 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r35 = r10
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            r11.zze(r8, r9, r10)
            r3.set(r1)
            long[] r8 = r4.zzayo
            boolean r8 = com.google.android.gms.measurement.internal.zzfu.zza(r8, r1)
            if (r8 == 0) goto L_0x011a
            r5.set(r1)
            r8 = 1
            goto L_0x011b
        L_0x0114:
            r33 = r8
            r34 = r9
            r35 = r10
        L_0x011a:
            r8 = 0
        L_0x011b:
            if (r0 == 0) goto L_0x0126
            if (r8 != 0) goto L_0x0126
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r0.remove(r8)
        L_0x0126:
            int r1 = r1 + 1
            r8 = r33
            r9 = r34
            r10 = r35
            goto L_0x00da
        L_0x012f:
            r33 = r8
            r34 = r9
            r35 = r10
            com.google.android.gms.internal.measurement.zzfr r1 = new com.google.android.gms.internal.measurement.zzfr
            r1.<init>()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            r12.put(r8, r1)
            r8 = 0
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)
            r1.zzawv = r9
            r1.zzawu = r4
            com.google.android.gms.internal.measurement.zzfx r4 = new com.google.android.gms.internal.measurement.zzfx
            r4.<init>()
            r1.zzawt = r4
            com.google.android.gms.internal.measurement.zzfx r4 = r1.zzawt
            long[] r5 = com.google.android.gms.measurement.internal.zzfu.zza(r5)
            r4.zzayo = r5
            com.google.android.gms.internal.measurement.zzfx r4 = r1.zzawt
            long[] r3 = com.google.android.gms.measurement.internal.zzfu.zza(r3)
            r4.zzayn = r3
            if (r23 == 0) goto L_0x0177
            com.google.android.gms.internal.measurement.zzfx r1 = r1.zzawt
            com.google.android.gms.internal.measurement.zzfs[] r0 = zzb(r0)
            r1.zzayp = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            androidx.b.a r1 = new androidx.b.a
            r1.<init>()
            r6.put(r0, r1)
        L_0x0177:
            r0 = r27
            r1 = r28
            r11 = r30
            r8 = r33
            r9 = r34
            r10 = r35
            goto L_0x0043
        L_0x0185:
            r33 = r8
            r34 = r9
            r35 = r10
            r30 = r11
            if (r13 == 0) goto L_0x079c
            androidx.b.a r9 = new androidx.b.a
            r9.<init>()
            int r8 = r13.length
            r27 = 0
            r2 = r27
            r0 = 0
            r1 = 0
            r4 = 0
        L_0x019c:
            if (r4 >= r8) goto L_0x079c
            r5 = r13[r4]
            java.lang.String r10 = r5.name
            com.google.android.gms.internal.measurement.zzfu[] r11 = r5.zzaxa
            r36 = r2
            com.google.android.gms.measurement.internal.zzq r2 = r98.zzgv()
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzai.zzaki
            boolean r2 = r2.zzd(r15, r3)
            r16 = 1
            if (r2 == 0) goto L_0x0379
            r98.zzjr()
            java.lang.String r2 = "_eid"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfu.zzb(r5, r2)
            r3 = r2
            java.lang.Long r3 = (java.lang.Long) r3
            if (r3 == 0) goto L_0x01c4
            r2 = 1
            goto L_0x01c5
        L_0x01c4:
            r2 = 0
        L_0x01c5:
            if (r2 == 0) goto L_0x01d3
            r38 = r4
            java.lang.String r4 = "_ep"
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x01d5
            r4 = 1
            goto L_0x01d6
        L_0x01d3:
            r38 = r4
        L_0x01d5:
            r4 = 0
        L_0x01d6:
            if (r4 == 0) goto L_0x0330
            r98.zzjr()
            java.lang.String r2 = "_en"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfu.zzb(r5, r2)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 == 0) goto L_0x01ff
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjg()
            java.lang.String r4 = "Extra parameter without an event name. eventId"
            r2.zzg(r4, r3)
            r41 = r6
            r26 = r38
            r24 = 1
            goto L_0x031c
        L_0x01ff:
            if (r0 == 0) goto L_0x0216
            if (r1 == 0) goto L_0x0216
            long r18 = r3.longValue()
            long r20 = r1.longValue()
            int r2 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r2 == 0) goto L_0x0210
            goto L_0x0216
        L_0x0210:
            r4 = r0
            r18 = r1
            r1 = r36
            goto L_0x0240
        L_0x0216:
            com.google.android.gms.measurement.internal.zzt r2 = r98.zzjt()
            android.util.Pair r2 = r2.zza(r15, r3)
            if (r2 == 0) goto L_0x0309
            java.lang.Object r4 = r2.first
            if (r4 != 0) goto L_0x0226
            goto L_0x0309
        L_0x0226:
            java.lang.Object r0 = r2.first
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            java.lang.Object r1 = r2.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r98.zzjr()
            java.lang.String r4 = "_eid"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfu.zzb(r0, r4)
            java.lang.Long r4 = (java.lang.Long) r4
            r18 = r4
            r4 = r0
        L_0x0240:
            r0 = 0
            long r19 = r1 - r16
            int r0 = (r19 > r27 ? 1 : (r19 == r27 ? 0 : -1))
            if (r0 > 0) goto L_0x028f
            com.google.android.gms.measurement.internal.zzt r1 = r98.zzjt()
            r1.zzaf()
            com.google.android.gms.measurement.internal.zzas r0 = r1.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjo()
            java.lang.String r2 = "Clearing complex main event info. appId"
            r0.zzg(r2, r15)
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0272 }
            java.lang.String r2 = "delete from main_event_params where app_id=?"
            r39 = r4
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0270 }
            r21 = 0
            r4[r21] = r15     // Catch:{ SQLiteException -> 0x026e }
            r0.execSQL(r2, r4)     // Catch:{ SQLiteException -> 0x026e }
            goto L_0x0285
        L_0x026e:
            r0 = move-exception
            goto L_0x0278
        L_0x0270:
            r0 = move-exception
            goto L_0x0276
        L_0x0272:
            r0 = move-exception
            r39 = r4
            r3 = 1
        L_0x0276:
            r21 = 0
        L_0x0278:
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjg()
            java.lang.String r2 = "Error clearing complex main event"
            r1.zzg(r2, r0)
        L_0x0285:
            r13 = r5
            r41 = r6
            r26 = r38
            r1 = r39
            r24 = 1
            goto L_0x02ac
        L_0x028f:
            r39 = r4
            r4 = 1
            r21 = 0
            com.google.android.gms.measurement.internal.zzt r1 = r98.zzjt()
            r2 = r99
            r13 = r5
            r26 = r38
            r40 = r39
            r24 = 1
            r4 = r19
            r41 = r6
            r6 = r40
            r1.zza(r2, r3, r4, r6)
            r1 = r40
        L_0x02ac:
            com.google.android.gms.internal.measurement.zzfu[] r0 = r1.zzaxa
            int r0 = r0.length
            int r2 = r11.length
            int r0 = r0 + r2
            com.google.android.gms.internal.measurement.zzfu[] r0 = new com.google.android.gms.internal.measurement.zzfu[r0]
            com.google.android.gms.internal.measurement.zzfu[] r2 = r1.zzaxa
            int r3 = r2.length
            r4 = 0
            r5 = 0
        L_0x02b8:
            if (r4 >= r3) goto L_0x02d3
            r6 = r2[r4]
            r98.zzjr()
            r42 = r1
            java.lang.String r1 = r6.name
            com.google.android.gms.internal.measurement.zzfu r1 = com.google.android.gms.measurement.internal.zzfu.zza(r13, r1)
            if (r1 != 0) goto L_0x02ce
            int r1 = r5 + 1
            r0[r5] = r6
            r5 = r1
        L_0x02ce:
            int r4 = r4 + 1
            r1 = r42
            goto L_0x02b8
        L_0x02d3:
            r42 = r1
            if (r5 <= 0) goto L_0x02f3
            int r1 = r11.length
            r2 = 0
        L_0x02d9:
            if (r2 >= r1) goto L_0x02e5
            r3 = r11[r2]
            int r4 = r5 + 1
            r0[r5] = r3
            int r2 = r2 + 1
            r5 = r4
            goto L_0x02d9
        L_0x02e5:
            int r1 = r0.length
            if (r5 != r1) goto L_0x02e9
            goto L_0x02ef
        L_0x02e9:
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r5)
            com.google.android.gms.internal.measurement.zzfu[] r0 = (com.google.android.gms.internal.measurement.zzfu[]) r0
        L_0x02ef:
            r29 = r0
            r0 = r10
            goto L_0x0303
        L_0x02f3:
            com.google.android.gms.measurement.internal.zzas r0 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()
            java.lang.String r1 = "No unique parameters in main event. eventName"
            r0.zzg(r1, r10)
            r0 = r10
            r29 = r11
        L_0x0303:
            r25 = r18
            r36 = r19
            goto L_0x0387
        L_0x0309:
            r41 = r6
            r26 = r38
            r24 = 1
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjg()
            java.lang.String r4 = "Extra parameter without existing main event. eventName, eventId"
            r2.zze(r4, r10, r3)
        L_0x031c:
            r31 = r8
            r65 = r9
            r79 = r12
            r14 = r30
            r77 = r33
            r78 = r34
            r80 = r35
            r2 = r36
            r72 = r41
            goto L_0x0780
        L_0x0330:
            r13 = r5
            r41 = r6
            r26 = r38
            r24 = 1
            if (r2 == 0) goto L_0x0380
            r98.zzjr()
            java.lang.String r0 = "_epc"
            java.lang.Long r1 = java.lang.Long.valueOf(r27)
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzfu.zzb(r13, r0)
            if (r0 != 0) goto L_0x0349
            r0 = r1
        L_0x0349:
            java.lang.Long r0 = (java.lang.Long) r0
            long r18 = r0.longValue()
            int r0 = (r18 > r27 ? 1 : (r18 == r27 ? 0 : -1))
            if (r0 > 0) goto L_0x0362
            com.google.android.gms.measurement.internal.zzas r0 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()
            java.lang.String r1 = "Complex event with zero extra param count. eventName"
            r0.zzg(r1, r10)
            r0 = r3
            goto L_0x036f
        L_0x0362:
            com.google.android.gms.measurement.internal.zzt r1 = r98.zzjt()
            r2 = r99
            r0 = r3
            r4 = r18
            r6 = r13
            r1.zza(r2, r3, r4, r6)
        L_0x036f:
            r25 = r0
            r0 = r10
            r29 = r11
            r42 = r13
            r36 = r18
            goto L_0x0387
        L_0x0379:
            r26 = r4
            r13 = r5
            r41 = r6
            r24 = 1
        L_0x0380:
            r42 = r0
            r25 = r1
            r0 = r10
            r29 = r11
        L_0x0387:
            com.google.android.gms.measurement.internal.zzt r1 = r98.zzjt()
            java.lang.String r2 = r13.name
            com.google.android.gms.measurement.internal.zzac r1 = r1.zzg(r15, r2)
            if (r1 != 0) goto L_0x03e5
            com.google.android.gms.measurement.internal.zzas r1 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjj()
            java.lang.String r2 = "Event aggregate wasn't created during raw event logging. appId, event"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r99)
            com.google.android.gms.measurement.internal.zzaq r4 = r98.zzgq()
            java.lang.String r4 = r4.zzbt(r0)
            r1.zze(r2, r3, r4)
            com.google.android.gms.measurement.internal.zzac r1 = new com.google.android.gms.measurement.internal.zzac
            java.lang.String r10 = r13.name
            r2 = 1
            r4 = 1
            java.lang.Long r6 = r13.zzaxb
            long r16 = r6.longValue()
            r18 = 0
            r6 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r31 = r8
            r11 = r33
            r8 = r1
            r44 = r9
            r43 = r34
            r9 = r99
            r45 = r35
            r48 = r11
            r47 = r12
            r46 = r30
            r11 = r2
            r2 = r13
            r3 = r14
            r13 = r4
            r5 = r15
            r15 = r16
            r17 = r18
            r19 = r6
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21, r22)
            goto L_0x0426
        L_0x03e5:
            r31 = r8
            r44 = r9
            r47 = r12
            r2 = r13
            r3 = r14
            r5 = r15
            r46 = r30
            r48 = r33
            r43 = r34
            r45 = r35
            com.google.android.gms.measurement.internal.zzac r4 = new com.google.android.gms.measurement.internal.zzac
            java.lang.String r6 = r1.zztt
            java.lang.String r8 = r1.name
            long r9 = r1.zzahv
            long r52 = r9 + r16
            long r9 = r1.zzahw
            long r54 = r9 + r16
            long r9 = r1.zzahx
            long r11 = r1.zzahy
            java.lang.Long r13 = r1.zzahz
            java.lang.Long r14 = r1.zzaia
            java.lang.Long r15 = r1.zzaib
            java.lang.Boolean r1 = r1.zzaic
            r49 = r4
            r50 = r6
            r51 = r8
            r56 = r9
            r58 = r11
            r60 = r13
            r61 = r14
            r62 = r15
            r63 = r1
            r49.<init>(r50, r51, r52, r54, r56, r58, r60, r61, r62, r63)
            r1 = r4
        L_0x0426:
            com.google.android.gms.measurement.internal.zzt r4 = r98.zzjt()
            r4.zza(r1)
            long r8 = r1.zzahv
            r10 = r44
            java.lang.Object r1 = r10.get(r0)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 != 0) goto L_0x044b
            com.google.android.gms.measurement.internal.zzt r1 = r98.zzjt()
            java.util.Map r1 = r1.zzl(r5, r0)
            if (r1 != 0) goto L_0x0448
            androidx.b.a r1 = new androidx.b.a
            r1.<init>()
        L_0x0448:
            r10.put(r0, r1)
        L_0x044b:
            r11 = r1
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r12 = r1.iterator()
        L_0x0454:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x076c
            java.lang.Object r1 = r12.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r13 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r14 = r46
            boolean r1 = r14.contains(r1)
            if (r1 == 0) goto L_0x0484
            com.google.android.gms.measurement.internal.zzas r1 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r4 = "Skipping failed audience ID"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)
            r1.zzg(r4, r6)
            r46 = r14
            goto L_0x0454
        L_0x0484:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r15 = r47
            java.lang.Object r1 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzfr r1 = (com.google.android.gms.internal.measurement.zzfr) r1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r6 = r45
            java.lang.Object r4 = r6.get(r4)
            java.util.BitSet r4 = (java.util.BitSet) r4
            r64 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r65 = r10
            r10 = r43
            java.lang.Object r2 = r10.get(r2)
            java.util.BitSet r2 = (java.util.BitSet) r2
            if (r23 == 0) goto L_0x04cd
            r66 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r67 = r12
            r12 = r48
            java.lang.Object r2 = r12.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            r68 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r7 = r41
            java.lang.Object r2 = r7.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            goto L_0x04d8
        L_0x04cd:
            r66 = r2
            r67 = r12
            r7 = r41
            r12 = r48
            r2 = 0
            r68 = 0
        L_0x04d8:
            if (r1 != 0) goto L_0x0537
            com.google.android.gms.internal.measurement.zzfr r1 = new com.google.android.gms.internal.measurement.zzfr
            r1.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r15.put(r4, r1)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r24)
            r1.zzawv = r4
            java.util.BitSet r4 = new java.util.BitSet
            r4.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r6.put(r1, r4)
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            r69 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r10.put(r2, r1)
            if (r23 == 0) goto L_0x052c
            androidx.b.a r2 = new androidx.b.a
            r2.<init>()
            r70 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r12.put(r1, r2)
            androidx.b.a r1 = new androidx.b.a
            r1.<init>()
            r71 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r7.put(r2, r1)
            r72 = r7
            r2 = r70
            r73 = r71
            r7 = r1
            goto L_0x0541
        L_0x052c:
            r70 = r1
            r72 = r7
            r73 = r68
            r7 = r69
            r2 = r70
            goto L_0x0541
        L_0x0537:
            r69 = r2
            r72 = r7
            r2 = r66
            r73 = r68
            r7 = r69
        L_0x0541:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            java.lang.Object r1 = r11.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r16 = r1.iterator()
        L_0x054f:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x0750
            java.lang.Object r1 = r16.next()
            com.google.android.gms.internal.measurement.zzfj r1 = (com.google.android.gms.internal.measurement.zzfj) r1
            r74 = r2
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            r75 = r11
            r11 = 2
            boolean r2 = r2.isLoggable(r11)
            if (r2 == 0) goto L_0x05a1
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjo()
            java.lang.String r11 = "Evaluating filter. audience, filter, event"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r5 = r1.zzavk
            r76 = r6
            com.google.android.gms.measurement.internal.zzaq r6 = r98.zzgq()
            r77 = r12
            java.lang.String r12 = r1.zzavl
            java.lang.String r6 = r6.zzbt(r12)
            r2.zzd(r11, r3, r5, r6)
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjo()
            java.lang.String r3 = "Filter definition"
            com.google.android.gms.measurement.internal.zzfu r5 = r98.zzjr()
            java.lang.String r5 = r5.zza(r1)
            r2.zzg(r3, r5)
            goto L_0x05a5
        L_0x05a1:
            r76 = r6
            r77 = r12
        L_0x05a5:
            java.lang.Integer r2 = r1.zzavk
            if (r2 == 0) goto L_0x0711
            java.lang.Integer r2 = r1.zzavk
            int r2 = r2.intValue()
            r11 = 256(0x100, float:3.59E-43)
            if (r2 <= r11) goto L_0x05b5
            goto L_0x0711
        L_0x05b5:
            if (r23 == 0) goto L_0x069e
            if (r1 == 0) goto L_0x05c7
            java.lang.Boolean r2 = r1.zzavh
            if (r2 == 0) goto L_0x05c7
            java.lang.Boolean r2 = r1.zzavh
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x05c7
            r12 = 1
            goto L_0x05c8
        L_0x05c7:
            r12 = 0
        L_0x05c8:
            if (r1 == 0) goto L_0x05d9
            java.lang.Boolean r2 = r1.zzavi
            if (r2 == 0) goto L_0x05d9
            java.lang.Boolean r2 = r1.zzavi
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x05d9
            r17 = 1
            goto L_0x05db
        L_0x05d9:
            r17 = 0
        L_0x05db:
            java.lang.Integer r2 = r1.zzavk
            int r2 = r2.intValue()
            boolean r2 = r4.get(r2)
            if (r2 == 0) goto L_0x0608
            if (r12 != 0) goto L_0x0608
            if (r17 != 0) goto L_0x0608
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjo()
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r1 = r1.zzavk
            r2.zze(r3, r5, r1)
            r2 = r74
            r11 = r75
            r6 = r76
            r12 = r77
            goto L_0x074a
        L_0x0608:
            r5 = r1
            r6 = r73
            r1 = r98
            r3 = r64
            r11 = r74
            r2 = r5
            r78 = r10
            r79 = r15
            r10 = r101
            r15 = r3
            r3 = r0
            r10 = r4
            r4 = r29
            r81 = r0
            r0 = r5
            r82 = r6
            r80 = r76
            r5 = r8
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjo()
            java.lang.String r3 = "Event filter result"
            if (r1 != 0) goto L_0x0638
            java.lang.String r4 = "null"
            goto L_0x0639
        L_0x0638:
            r4 = r1
        L_0x0639:
            r2.zzg(r3, r4)
            if (r1 != 0) goto L_0x0659
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            r14.add(r0)
        L_0x0645:
            r4 = r10
            r2 = r11
            r64 = r15
            r11 = r75
            r12 = r77
            r10 = r78
            r15 = r79
            r6 = r80
            r0 = r81
            r73 = r82
            goto L_0x074a
        L_0x0659:
            java.lang.Integer r2 = r0.zzavk
            int r2 = r2.intValue()
            r11.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0645
            java.lang.Integer r1 = r0.zzavk
            int r1 = r1.intValue()
            r10.set(r1)
            if (r12 != 0) goto L_0x0675
            if (r17 == 0) goto L_0x0645
        L_0x0675:
            java.lang.Long r1 = r15.zzaxb
            if (r1 == 0) goto L_0x0645
            if (r17 == 0) goto L_0x068b
            java.lang.Integer r0 = r0.zzavk
            int r0 = r0.intValue()
            java.lang.Long r1 = r15.zzaxb
            long r1 = r1.longValue()
            zzb(r7, r0, r1)
            goto L_0x0645
        L_0x068b:
            java.lang.Integer r0 = r0.zzavk
            int r0 = r0.intValue()
            java.lang.Long r1 = r15.zzaxb
            long r1 = r1.longValue()
            r12 = r82
            zza(r12, r0, r1)
            goto L_0x0738
        L_0x069e:
            r81 = r0
            r0 = r1
            r78 = r10
            r79 = r15
            r15 = r64
            r12 = r73
            r11 = r74
            r80 = r76
            r10 = r4
            java.lang.Integer r1 = r0.zzavk
            int r1 = r1.intValue()
            boolean r1 = r10.get(r1)
            if (r1 == 0) goto L_0x06cf
            com.google.android.gms.measurement.internal.zzas r1 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r2 = "Event filter already evaluated true. audience ID, filter ID"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r0 = r0.zzavk
            r1.zze(r2, r3, r0)
            goto L_0x0738
        L_0x06cf:
            r1 = r98
            r2 = r0
            r3 = r81
            r4 = r29
            r5 = r8
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzas r2 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjo()
            java.lang.String r3 = "Event filter result"
            if (r1 != 0) goto L_0x06ea
            java.lang.String r4 = "null"
            goto L_0x06eb
        L_0x06ea:
            r4 = r1
        L_0x06eb:
            r2.zzg(r3, r4)
            if (r1 != 0) goto L_0x06f8
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            r14.add(r0)
            goto L_0x0738
        L_0x06f8:
            java.lang.Integer r2 = r0.zzavk
            int r2 = r2.intValue()
            r11.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0738
            java.lang.Integer r0 = r0.zzavk
            int r0 = r0.intValue()
            r10.set(r0)
            goto L_0x0738
        L_0x0711:
            r81 = r0
            r0 = r1
            r78 = r10
            r79 = r15
            r15 = r64
            r12 = r73
            r11 = r74
            r80 = r76
            r10 = r4
            com.google.android.gms.measurement.internal.zzas r1 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjj()
            java.lang.String r2 = "Invalid event filter ID. appId, id"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r99)
            java.lang.Integer r0 = r0.zzavk
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.zze(r2, r3, r0)
        L_0x0738:
            r4 = r10
            r2 = r11
            r73 = r12
            r64 = r15
            r11 = r75
            r12 = r77
            r10 = r78
            r15 = r79
            r6 = r80
            r0 = r81
        L_0x074a:
            r3 = r101
            r5 = r99
            goto L_0x054f
        L_0x0750:
            r79 = r15
            r45 = r6
            r43 = r10
            r48 = r12
            r46 = r14
            r2 = r64
            r10 = r65
            r12 = r67
            r41 = r72
            r47 = r79
            r3 = r101
            r5 = r99
            r7 = r98
            goto L_0x0454
        L_0x076c:
            r65 = r10
            r72 = r41
            r78 = r43
            r80 = r45
            r14 = r46
            r79 = r47
            r77 = r48
            r1 = r25
            r2 = r36
            r0 = r42
        L_0x0780:
            int r4 = r26 + 1
            r13 = r100
            r30 = r14
            r8 = r31
            r9 = r65
            r6 = r72
            r33 = r77
            r34 = r78
            r12 = r79
            r35 = r80
            r7 = r98
            r14 = r101
            r15 = r99
            goto L_0x019c
        L_0x079c:
            r72 = r6
            r79 = r12
            r14 = r30
            r77 = r33
            r78 = r34
            r80 = r35
            r24 = 1
            r1 = r101
            if (r1 == 0) goto L_0x0ace
            androidx.b.a r0 = new androidx.b.a
            r0.<init>()
            int r2 = r1.length
            r3 = 0
        L_0x07b5:
            if (r3 >= r2) goto L_0x0ace
            r4 = r1[r3]
            java.lang.String r5 = r4.name
            java.lang.Object r5 = r0.get(r5)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x07dc
            com.google.android.gms.measurement.internal.zzt r5 = r98.zzjt()
            java.lang.String r6 = r4.name
            r7 = r99
            java.util.Map r5 = r5.zzm(r7, r6)
            if (r5 != 0) goto L_0x07d6
            androidx.b.a r5 = new androidx.b.a
            r5.<init>()
        L_0x07d6:
            java.lang.String r6 = r4.name
            r0.put(r6, r5)
            goto L_0x07de
        L_0x07dc:
            r7 = r99
        L_0x07de:
            java.util.Set r6 = r5.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x07e6:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0ab8
            java.lang.Object r8 = r6.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            boolean r9 = r14.contains(r9)
            if (r9 == 0) goto L_0x0812
            com.google.android.gms.measurement.internal.zzas r9 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r9 = r9.zzjo()
            java.lang.String r10 = "Skipping failed audience ID"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.zzg(r10, r8)
            goto L_0x07e6
        L_0x0812:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r10 = r79
            java.lang.Object r9 = r10.get(r9)
            com.google.android.gms.internal.measurement.zzfr r9 = (com.google.android.gms.internal.measurement.zzfr) r9
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
            r12 = r80
            java.lang.Object r11 = r12.get(r11)
            java.util.BitSet r11 = (java.util.BitSet) r11
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r15 = r78
            java.lang.Object r13 = r15.get(r13)
            java.util.BitSet r13 = (java.util.BitSet) r13
            if (r23 == 0) goto L_0x0857
            r83 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r1 = r77
            java.lang.Object r0 = r1.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            r84 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r85 = r2
            r2 = r72
            java.lang.Object r0 = r2.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            goto L_0x0862
        L_0x0857:
            r83 = r0
            r85 = r2
            r2 = r72
            r1 = r77
            r0 = 0
            r84 = 0
        L_0x0862:
            if (r9 != 0) goto L_0x08af
            com.google.android.gms.internal.measurement.zzfr r9 = new com.google.android.gms.internal.measurement.zzfr
            r9.<init>()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
            r10.put(r11, r9)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r24)
            r9.zzawv = r11
            java.util.BitSet r11 = new java.util.BitSet
            r11.<init>()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r12.put(r9, r11)
            java.util.BitSet r13 = new java.util.BitSet
            r13.<init>()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r15.put(r9, r13)
            if (r23 == 0) goto L_0x08af
            androidx.b.a r0 = new androidx.b.a
            r0.<init>()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r1.put(r9, r0)
            androidx.b.a r9 = new androidx.b.a
            r9.<init>()
            r86 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r2.put(r0, r9)
            r87 = r2
            r0 = r86
            goto L_0x08b4
        L_0x08af:
            r9 = r0
            r87 = r2
            r0 = r84
        L_0x08b4:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            java.lang.Object r2 = r5.get(r2)
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x08c2:
            boolean r16 = r2.hasNext()
            if (r16 == 0) goto L_0x0aa2
            java.lang.Object r16 = r2.next()
            r88 = r2
            r2 = r16
            com.google.android.gms.internal.measurement.zzfm r2 = (com.google.android.gms.internal.measurement.zzfm) r2
            r89 = r5
            com.google.android.gms.measurement.internal.zzas r5 = r98.zzgt()
            r90 = r6
            r6 = 2
            boolean r5 = r5.isLoggable(r6)
            if (r5 == 0) goto L_0x091a
            com.google.android.gms.measurement.internal.zzas r5 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjo()
            java.lang.String r6 = "Evaluating filter. audience, filter, property"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r91 = r1
            java.lang.Integer r1 = r2.zzavk
            r92 = r15
            com.google.android.gms.measurement.internal.zzaq r15 = r98.zzgq()
            r93 = r10
            java.lang.String r10 = r2.zzawa
            java.lang.String r10 = r15.zzbv(r10)
            r5.zzd(r6, r7, r1, r10)
            com.google.android.gms.measurement.internal.zzas r1 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r5 = "Filter definition"
            com.google.android.gms.measurement.internal.zzfu r6 = r98.zzjr()
            java.lang.String r6 = r6.zza(r2)
            r1.zzg(r5, r6)
            goto L_0x0920
        L_0x091a:
            r91 = r1
            r93 = r10
            r92 = r15
        L_0x0920:
            java.lang.Integer r1 = r2.zzavk
            if (r1 == 0) goto L_0x0a6b
            java.lang.Integer r1 = r2.zzavk
            int r1 = r1.intValue()
            r5 = 256(0x100, float:3.59E-43)
            if (r1 <= r5) goto L_0x0930
            goto L_0x0a6b
        L_0x0930:
            if (r23 == 0) goto L_0x09f8
            if (r2 == 0) goto L_0x0942
            java.lang.Boolean r1 = r2.zzavh
            if (r1 == 0) goto L_0x0942
            java.lang.Boolean r1 = r2.zzavh
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0942
            r1 = 1
            goto L_0x0943
        L_0x0942:
            r1 = 0
        L_0x0943:
            if (r2 == 0) goto L_0x0953
            java.lang.Boolean r6 = r2.zzavi
            if (r6 == 0) goto L_0x0953
            java.lang.Boolean r6 = r2.zzavi
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0953
            r6 = 1
            goto L_0x0954
        L_0x0953:
            r6 = 0
        L_0x0954:
            java.lang.Integer r7 = r2.zzavk
            int r7 = r7.intValue()
            boolean r7 = r11.get(r7)
            if (r7 == 0) goto L_0x0985
            if (r1 != 0) goto L_0x0985
            if (r6 != 0) goto L_0x0985
            com.google.android.gms.measurement.internal.zzas r1 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r6 = "Property filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r2 = r2.zzavk
            r1.zze(r6, r7, r2)
            r2 = r88
            r5 = r89
            r6 = r90
            r1 = r91
            r15 = r92
            r10 = r93
            goto L_0x0a2d
        L_0x0985:
            r10 = r87
            r7 = r98
            java.lang.Boolean r15 = r7.zza(r2, r4)
            com.google.android.gms.measurement.internal.zzas r16 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r5 = r16.zzjo()
            r94 = r10
            java.lang.String r10 = "Property filter result"
            if (r15 != 0) goto L_0x09a2
            java.lang.String r16 = "null"
            r95 = r12
            r12 = r16
            goto L_0x09a5
        L_0x09a2:
            r95 = r12
            r12 = r15
        L_0x09a5:
            r5.zzg(r10, r12)
            if (r15 != 0) goto L_0x09b2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r14.add(r1)
            goto L_0x0a1d
        L_0x09b2:
            java.lang.Integer r5 = r2.zzavk
            int r5 = r5.intValue()
            r13.set(r5)
            java.lang.Integer r5 = r2.zzavk
            int r5 = r5.intValue()
            boolean r10 = r15.booleanValue()
            r11.set(r5, r10)
            boolean r5 = r15.booleanValue()
            if (r5 == 0) goto L_0x0a1d
            if (r1 != 0) goto L_0x09d2
            if (r6 == 0) goto L_0x0a1d
        L_0x09d2:
            java.lang.Long r1 = r4.zzayu
            if (r1 == 0) goto L_0x0a1d
            if (r6 == 0) goto L_0x09e8
            java.lang.Integer r1 = r2.zzavk
            int r1 = r1.intValue()
            java.lang.Long r2 = r4.zzayu
            long r5 = r2.longValue()
            zzb(r9, r1, r5)
            goto L_0x0a1d
        L_0x09e8:
            java.lang.Integer r1 = r2.zzavk
            int r1 = r1.intValue()
            java.lang.Long r2 = r4.zzayu
            long r5 = r2.longValue()
            zza(r0, r1, r5)
            goto L_0x0a1d
        L_0x09f8:
            r95 = r12
            r94 = r87
            r7 = r98
            java.lang.Integer r1 = r2.zzavk
            int r1 = r1.intValue()
            boolean r1 = r11.get(r1)
            if (r1 == 0) goto L_0x0a31
            com.google.android.gms.measurement.internal.zzas r1 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r5 = "Property filter already evaluated true. audience ID, filter ID"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r2 = r2.zzavk
            r1.zze(r5, r6, r2)
        L_0x0a1d:
            r2 = r88
            r5 = r89
            r6 = r90
            r1 = r91
            r15 = r92
            r10 = r93
            r87 = r94
            r12 = r95
        L_0x0a2d:
            r7 = r99
            goto L_0x08c2
        L_0x0a31:
            java.lang.Boolean r1 = r7.zza(r2, r4)
            com.google.android.gms.measurement.internal.zzas r5 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjo()
            java.lang.String r6 = "Property filter result"
            if (r1 != 0) goto L_0x0a44
            java.lang.String r10 = "null"
            goto L_0x0a45
        L_0x0a44:
            r10 = r1
        L_0x0a45:
            r5.zzg(r6, r10)
            if (r1 != 0) goto L_0x0a52
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r14.add(r1)
            goto L_0x0a1d
        L_0x0a52:
            java.lang.Integer r5 = r2.zzavk
            int r5 = r5.intValue()
            r13.set(r5)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0a1d
            java.lang.Integer r1 = r2.zzavk
            int r1 = r1.intValue()
            r11.set(r1)
            goto L_0x0a1d
        L_0x0a6b:
            r95 = r12
            r94 = r87
            r7 = r98
            com.google.android.gms.measurement.internal.zzas r0 = r98.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()
            java.lang.String r1 = "Invalid property filter ID. appId, id"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzas.zzbw(r99)
            java.lang.Integer r2 = r2.zzavk
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.zze(r1, r5, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r14.add(r0)
            r0 = r83
            r2 = r85
            r5 = r89
            r6 = r90
            r77 = r91
            r78 = r92
            r79 = r93
            r72 = r94
            r80 = r95
            goto L_0x0ab2
        L_0x0aa2:
            r7 = r98
            r77 = r1
            r79 = r10
            r80 = r12
            r78 = r15
            r0 = r83
            r2 = r85
            r72 = r87
        L_0x0ab2:
            r1 = r101
            r7 = r99
            goto L_0x07e6
        L_0x0ab8:
            r83 = r0
            r85 = r2
            r94 = r72
            r91 = r77
            r92 = r78
            r93 = r79
            r95 = r80
            r7 = r98
            int r3 = r3 + 1
            r1 = r101
            goto L_0x07b5
        L_0x0ace:
            r94 = r72
            r91 = r77
            r92 = r78
            r93 = r79
            r95 = r80
            r7 = r98
            int r0 = r95.size()
            com.google.android.gms.internal.measurement.zzfr[] r1 = new com.google.android.gms.internal.measurement.zzfr[r0]
            java.util.Set r0 = r95.keySet()
            java.util.Iterator r2 = r0.iterator()
            r3 = 0
        L_0x0ae9:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0c9a
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            boolean r4 = r14.contains(r4)
            if (r4 != 0) goto L_0x0c96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r5 = r93
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.internal.measurement.zzfr r4 = (com.google.android.gms.internal.measurement.zzfr) r4
            if (r4 != 0) goto L_0x0b16
            com.google.android.gms.internal.measurement.zzfr r4 = new com.google.android.gms.internal.measurement.zzfr
            r4.<init>()
        L_0x0b16:
            int r6 = r3 + 1
            r1[r3] = r4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r4.zzave = r3
            com.google.android.gms.internal.measurement.zzfx r3 = new com.google.android.gms.internal.measurement.zzfx
            r3.<init>()
            r4.zzawt = r3
            com.google.android.gms.internal.measurement.zzfx r3 = r4.zzawt
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r9 = r95
            java.lang.Object r8 = r9.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            long[] r8 = com.google.android.gms.measurement.internal.zzfu.zza(r8)
            r3.zzayo = r8
            com.google.android.gms.internal.measurement.zzfx r3 = r4.zzawt
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r10 = r92
            java.lang.Object r8 = r10.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            long[] r8 = com.google.android.gms.measurement.internal.zzfu.zza(r8)
            r3.zzayn = r8
            if (r23 == 0) goto L_0x0bef
            com.google.android.gms.internal.measurement.zzfx r3 = r4.zzawt
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r11 = r91
            java.lang.Object r8 = r11.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            com.google.android.gms.internal.measurement.zzfs[] r8 = zzb(r8)
            r3.zzayp = r8
            com.google.android.gms.internal.measurement.zzfx r3 = r4.zzawt
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r12 = r94
            java.lang.Object r8 = r12.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            if (r8 != 0) goto L_0x0b7f
            r13 = 0
            com.google.android.gms.internal.measurement.zzfy[] r8 = new com.google.android.gms.internal.measurement.zzfy[r13]
            r96 = r2
            r97 = r5
            r15 = r8
            goto L_0x0bec
        L_0x0b7f:
            r13 = 0
            int r15 = r8.size()
            com.google.android.gms.internal.measurement.zzfy[] r15 = new com.google.android.gms.internal.measurement.zzfy[r15]
            java.util.Set r16 = r8.keySet()
            java.util.Iterator r16 = r16.iterator()
            r17 = 0
        L_0x0b90:
            boolean r18 = r16.hasNext()
            if (r18 == 0) goto L_0x0be8
            java.lang.Object r18 = r16.next()
            r13 = r18
            java.lang.Integer r13 = (java.lang.Integer) r13
            r96 = r2
            com.google.android.gms.internal.measurement.zzfy r2 = new com.google.android.gms.internal.measurement.zzfy
            r2.<init>()
            r2.zzawx = r13
            java.lang.Object r13 = r8.get(r13)
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x0bda
            java.util.Collections.sort(r13)
            r97 = r5
            int r5 = r13.size()
            long[] r5 = new long[r5]
            java.util.Iterator r13 = r13.iterator()
            r18 = 0
        L_0x0bc0:
            boolean r19 = r13.hasNext()
            if (r19 == 0) goto L_0x0bd7
            java.lang.Object r19 = r13.next()
            java.lang.Long r19 = (java.lang.Long) r19
            int r20 = r18 + 1
            long r21 = r19.longValue()
            r5[r18] = r21
            r18 = r20
            goto L_0x0bc0
        L_0x0bd7:
            r2.zzays = r5
            goto L_0x0bdc
        L_0x0bda:
            r97 = r5
        L_0x0bdc:
            int r5 = r17 + 1
            r15[r17] = r2
            r17 = r5
            r2 = r96
            r5 = r97
            r13 = 0
            goto L_0x0b90
        L_0x0be8:
            r96 = r2
            r97 = r5
        L_0x0bec:
            r3.zzayq = r15
            goto L_0x0bf7
        L_0x0bef:
            r96 = r2
            r97 = r5
            r11 = r91
            r12 = r94
        L_0x0bf7:
            com.google.android.gms.measurement.internal.zzt r2 = r98.zzjt()
            com.google.android.gms.internal.measurement.zzfx r3 = r4.zzawt
            r2.zzcl()
            r2.zzaf()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r99)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            int r4 = r3.zzvx()     // Catch:{ IOException -> 0x0c71 }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0c71 }
            int r5 = r4.length     // Catch:{ IOException -> 0x0c71 }
            r8 = 0
            com.google.android.gms.internal.measurement.zzya r5 = com.google.android.gms.internal.measurement.zzya.zzk(r4, r8, r5)     // Catch:{ IOException -> 0x0c6f }
            r3.zza(r5)     // Catch:{ IOException -> 0x0c6f }
            r5.zzza()     // Catch:{ IOException -> 0x0c6f }
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r5 = "app_id"
            r13 = r99
            r3.put(r5, r13)
            java.lang.String r5 = "audience_id"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.put(r5, r0)
            java.lang.String r0 = "current_results"
            r3.put(r0, r4)
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0c5b }
            java.lang.String r4 = "audience_filter_values"
            r5 = 5
            r15 = 0
            long r3 = r0.insertWithOnConflict(r4, r15, r3, r5)     // Catch:{ SQLiteException -> 0x0c59 }
            r16 = -1
            int r0 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0c87
            com.google.android.gms.measurement.internal.zzas r0 = r2.zzgt()     // Catch:{ SQLiteException -> 0x0c59 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ SQLiteException -> 0x0c59 }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r99)     // Catch:{ SQLiteException -> 0x0c59 }
            r0.zzg(r3, r4)     // Catch:{ SQLiteException -> 0x0c59 }
            goto L_0x0c87
        L_0x0c59:
            r0 = move-exception
            goto L_0x0c5d
        L_0x0c5b:
            r0 = move-exception
            r15 = 0
        L_0x0c5d:
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjg()
            java.lang.String r3 = "Error storing filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r99)
            r2.zze(r3, r4, r0)
            goto L_0x0c87
        L_0x0c6f:
            r0 = move-exception
            goto L_0x0c73
        L_0x0c71:
            r0 = move-exception
            r8 = 0
        L_0x0c73:
            r13 = r99
            r15 = 0
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjg()
            java.lang.String r3 = "Configuration loss. Failed to serialize filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r99)
            r2.zze(r3, r4, r0)
        L_0x0c87:
            r3 = r6
            r95 = r9
            r92 = r10
            r91 = r11
            r94 = r12
            r2 = r96
            r93 = r97
            goto L_0x0ae9
        L_0x0c96:
            r13 = r99
            goto L_0x0ae9
        L_0x0c9a:
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r3)
            com.google.android.gms.internal.measurement.zzfr[] r0 = (com.google.android.gms.internal.measurement.zzfr[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzm.zza(java.lang.String, com.google.android.gms.internal.measurement.zzft[], com.google.android.gms.internal.measurement.zzfz[]):com.google.android.gms.internal.measurement.zzfr[]");
    }

    private final Boolean zza(zzfj zzfj, String str, zzfu[] zzfuArr, long j) {
        zzfk[] zzfkArr;
        zzfk[] zzfkArr2;
        Boolean bool;
        if (zzfj.zzavo != null) {
            Boolean zza = zza(j, zzfj.zzavo);
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        HashSet hashSet = new HashSet();
        for (zzfk zzfk : zzfj.zzavm) {
            if (TextUtils.isEmpty(zzfk.zzavt)) {
                zzgt().zzjj().zzg("null or empty param name in filter. event", zzgq().zzbt(str));
                return null;
            }
            hashSet.add(zzfk.zzavt);
        }
        C0712a aVar = new C0712a();
        for (zzfu zzfu : zzfuArr) {
            if (hashSet.contains(zzfu.name)) {
                if (zzfu.zzaxe != null) {
                    aVar.put(zzfu.name, zzfu.zzaxe);
                } else if (zzfu.zzaun != null) {
                    aVar.put(zzfu.name, zzfu.zzaun);
                } else if (zzfu.zzaml != null) {
                    aVar.put(zzfu.name, zzfu.zzaml);
                } else {
                    zzgt().zzjj().zze("Unknown value for param. event, param", zzgq().zzbt(str), zzgq().zzbu(zzfu.name));
                    return null;
                }
            }
        }
        for (zzfk zzfk2 : zzfj.zzavm) {
            boolean equals = Boolean.TRUE.equals(zzfk2.zzavs);
            String str2 = zzfk2.zzavt;
            if (TextUtils.isEmpty(str2)) {
                zzgt().zzjj().zzg("Event has empty param name. event", zzgq().zzbt(str));
                return null;
            }
            Object obj = aVar.get(str2);
            if (obj instanceof Long) {
                if (zzfk2.zzavr == null) {
                    zzgt().zzjj().zze("No number filter for long param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                Boolean zza2 = zza(((Long) obj).longValue(), zzfk2.zzavr);
                if (zza2 == null) {
                    return null;
                }
                if ((true ^ zza2.booleanValue()) ^ equals) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (zzfk2.zzavr == null) {
                    zzgt().zzjj().zze("No number filter for double param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                Boolean zza3 = zza(((Double) obj).doubleValue(), zzfk2.zzavr);
                if (zza3 == null) {
                    return null;
                }
                if ((true ^ zza3.booleanValue()) ^ equals) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (zzfk2.zzavq != null) {
                    bool = zza((String) obj, zzfk2.zzavq);
                } else if (zzfk2.zzavr != null) {
                    String str3 = (String) obj;
                    if (zzfu.zzcs(str3)) {
                        bool = zza(str3, zzfk2.zzavr);
                    } else {
                        zzgt().zzjj().zze("Invalid param value for number filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                        return null;
                    }
                } else {
                    zzgt().zzjj().zze("No filter for String param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if ((true ^ bool.booleanValue()) ^ equals) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                zzgt().zzjo().zze("Missing param for filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                return Boolean.valueOf(false);
            } else {
                zzgt().zzjj().zze("Unknown param type. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private final Boolean zza(zzfm zzfm, zzfz zzfz) {
        zzfk zzfk = zzfm.zzawb;
        if (zzfk == null) {
            zzgt().zzjj().zzg("Missing property filter. property", zzgq().zzbv(zzfz.name));
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzfk.zzavs);
        if (zzfz.zzaxe != null) {
            if (zzfk.zzavr != null) {
                return zza(zza(zzfz.zzaxe.longValue(), zzfk.zzavr), equals);
            }
            zzgt().zzjj().zzg("No number filter for long property. property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfz.zzaun != null) {
            if (zzfk.zzavr != null) {
                return zza(zza(zzfz.zzaun.doubleValue(), zzfk.zzavr), equals);
            }
            zzgt().zzjj().zzg("No number filter for double property. property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfz.zzaml == null) {
            zzgt().zzjj().zzg("User property has no value, property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfk.zzavq != null) {
            return zza(zza(zzfz.zzaml, zzfk.zzavq), equals);
        } else {
            if (zzfk.zzavr == null) {
                zzgt().zzjj().zzg("No string or number filter defined. property", zzgq().zzbv(zzfz.name));
            } else if (zzfu.zzcs(zzfz.zzaml)) {
                return zza(zza(zzfz.zzaml, zzfk.zzavr), equals);
            } else {
                zzgt().zzjj().zze("Invalid user property value for Numeric number filter. property, value", zzgq().zzbv(zzfz.name), zzfz.zzaml);
            }
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzfn zzfn) {
        String str2;
        List list;
        Preconditions.checkNotNull(zzfn);
        if (str == null || zzfn.zzawc == null || zzfn.zzawc.intValue() == 0) {
            return null;
        }
        if (zzfn.zzawc.intValue() == 6) {
            if (zzfn.zzawf == null || zzfn.zzawf.length == 0) {
                return null;
            }
        } else if (zzfn.zzawd == null) {
            return null;
        }
        int intValue = zzfn.zzawc.intValue();
        boolean z = zzfn.zzawe != null && zzfn.zzawe.booleanValue();
        if (z || intValue == 1 || intValue == 6) {
            str2 = zzfn.zzawd;
        } else {
            str2 = zzfn.zzawd.toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzfn.zzawf == null) {
            list = null;
        } else {
            String[] strArr = zzfn.zzawf;
            if (z) {
                list = Arrays.asList(strArr);
            } else {
                ArrayList arrayList = new ArrayList();
                for (String upperCase : strArr) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                list = arrayList;
            }
        }
        return zza(str, intValue, z, str3, list, intValue == 1 ? str3 : null);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzgt().zzjj().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(long j, zzfl zzfl) {
        try {
            return zza(new BigDecimal(j), zzfl, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(double d, zzfl zzfl) {
        try {
            return zza(new BigDecimal(d), zzfl, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(String str, zzfl zzfl) {
        if (!zzfu.zzcs(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzfl, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0072, code lost:
        if (r3 != null) goto L_0x0074;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r7, com.google.android.gms.internal.measurement.zzfl r8, double r9) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.lang.Integer r0 = r8.zzavu
            r1 = 0
            if (r0 == 0) goto L_0x00f0
            java.lang.Integer r0 = r8.zzavu
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x0012
            goto L_0x00f0
        L_0x0012:
            java.lang.Integer r0 = r8.zzavu
            int r0 = r0.intValue()
            r2 = 4
            if (r0 != r2) goto L_0x0024
            java.lang.String r0 = r8.zzavx
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = r8.zzavy
            if (r0 != 0) goto L_0x0029
        L_0x0023:
            return r1
        L_0x0024:
            java.lang.String r0 = r8.zzavw
            if (r0 != 0) goto L_0x0029
            return r1
        L_0x0029:
            java.lang.Integer r0 = r8.zzavu
            int r0 = r0.intValue()
            java.lang.Integer r3 = r8.zzavu
            int r3 = r3.intValue()
            if (r3 != r2) goto L_0x005b
            java.lang.String r3 = r8.zzavx
            boolean r3 = com.google.android.gms.measurement.internal.zzfu.zzcs(r3)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = r8.zzavy
            boolean r3 = com.google.android.gms.measurement.internal.zzfu.zzcs(r3)
            if (r3 != 0) goto L_0x0048
            goto L_0x005a
        L_0x0048:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0059 }
            java.lang.String r4 = r8.zzavx     // Catch:{ NumberFormatException -> 0x0059 }
            r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x0059 }
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0059 }
            java.lang.String r8 = r8.zzavy     // Catch:{ NumberFormatException -> 0x0059 }
            r4.<init>(r8)     // Catch:{ NumberFormatException -> 0x0059 }
            r8 = r3
            r3 = r1
            goto L_0x006d
        L_0x0059:
            return r1
        L_0x005a:
            return r1
        L_0x005b:
            java.lang.String r3 = r8.zzavw
            boolean r3 = com.google.android.gms.measurement.internal.zzfu.zzcs(r3)
            if (r3 != 0) goto L_0x0064
            return r1
        L_0x0064:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x00ef }
            java.lang.String r8 = r8.zzavw     // Catch:{ NumberFormatException -> 0x00ef }
            r3.<init>(r8)     // Catch:{ NumberFormatException -> 0x00ef }
            r8 = r1
            r4 = r8
        L_0x006d:
            if (r0 != r2) goto L_0x0072
            if (r8 != 0) goto L_0x0074
            return r1
        L_0x0072:
            if (r3 == 0) goto L_0x00ee
        L_0x0074:
            r2 = -1
            r5 = 0
            r6 = 1
            switch(r0) {
                case 1: goto L_0x00e2;
                case 2: goto L_0x00d6;
                case 3: goto L_0x008d;
                case 4: goto L_0x007b;
                default: goto L_0x007a;
            }
        L_0x007a:
            goto L_0x00ee
        L_0x007b:
            int r8 = r7.compareTo(r8)
            if (r8 == r2) goto L_0x0088
            int r7 = r7.compareTo(r4)
            if (r7 == r6) goto L_0x0088
            r5 = 1
        L_0x0088:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x008d:
            r0 = 0
            int r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r8 == 0) goto L_0x00ca
            java.math.BigDecimal r8 = new java.math.BigDecimal
            r8.<init>(r9)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r1 = 2
            r0.<init>(r1)
            java.math.BigDecimal r8 = r8.multiply(r0)
            java.math.BigDecimal r8 = r3.subtract(r8)
            int r8 = r7.compareTo(r8)
            if (r8 != r6) goto L_0x00c5
            java.math.BigDecimal r8 = new java.math.BigDecimal
            r8.<init>(r9)
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r1)
            java.math.BigDecimal r8 = r8.multiply(r9)
            java.math.BigDecimal r8 = r3.add(r8)
            int r7 = r7.compareTo(r8)
            if (r7 != r2) goto L_0x00c5
            r5 = 1
        L_0x00c5:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00ca:
            int r7 = r7.compareTo(r3)
            if (r7 != 0) goto L_0x00d1
            r5 = 1
        L_0x00d1:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00d6:
            int r7 = r7.compareTo(r3)
            if (r7 != r6) goto L_0x00dd
            r5 = 1
        L_0x00dd:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00e2:
            int r7 = r7.compareTo(r3)
            if (r7 != r2) goto L_0x00e9
            r5 = 1
        L_0x00e9:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00ee:
            return r1
        L_0x00ef:
            return r1
        L_0x00f0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzm.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzfl, double):java.lang.Boolean");
    }

    private static zzfs[] zzb(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        int i = 0;
        zzfs[] zzfsArr = new zzfs[map.size()];
        for (Integer num : map.keySet()) {
            zzfs zzfs = new zzfs();
            zzfs.zzawx = num;
            zzfs.zzawy = (Long) map.get(num);
            int i2 = i + 1;
            zzfsArr[i] = zzfs;
            i = i2;
        }
        return zzfsArr;
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = (Long) map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List list = (List) map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
