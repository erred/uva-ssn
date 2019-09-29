package androidx.recyclerview.widget;

import androidx.core.p065c.C0872b;
import androidx.recyclerview.widget.RecyclerView.C1254i;
import androidx.recyclerview.widget.RecyclerView.C1254i.C1257a;
import androidx.recyclerview.widget.RecyclerView.C1266p;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.recyclerview.widget.e */
/* compiled from: GapWorker */
final class C1309e implements Runnable {

    /* renamed from: a */
    static final ThreadLocal<C1309e> f3949a = new ThreadLocal<>();

    /* renamed from: e */
    static Comparator<C1312b> f3950e = new Comparator<C1312b>() {
        /* renamed from: a */
        public int compare(C1312b bVar, C1312b bVar2) {
            int i = 1;
            if ((bVar.f3962d == null) != (bVar2.f3962d == null)) {
                if (bVar.f3962d != null) {
                    i = -1;
                }
                return i;
            } else if (bVar.f3959a != bVar2.f3959a) {
                if (bVar.f3959a) {
                    i = -1;
                }
                return i;
            } else {
                int i2 = bVar2.f3960b - bVar.f3960b;
                if (i2 != 0) {
                    return i2;
                }
                int i3 = bVar.f3961c - bVar2.f3961c;
                if (i3 != 0) {
                    return i3;
                }
                return 0;
            }
        }
    };

    /* renamed from: b */
    ArrayList<RecyclerView> f3951b = new ArrayList<>();

    /* renamed from: c */
    long f3952c;

    /* renamed from: d */
    long f3953d;

    /* renamed from: f */
    private ArrayList<C1312b> f3954f = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.e$a */
    /* compiled from: GapWorker */
    static class C1311a implements C1257a {

        /* renamed from: a */
        int f3955a;

        /* renamed from: b */
        int f3956b;

        /* renamed from: c */
        int[] f3957c;

        /* renamed from: d */
        int f3958d;

        C1311a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5511a(int i, int i2) {
            this.f3955a = i;
            this.f3956b = i2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5512a(RecyclerView recyclerView, boolean z) {
            this.f3958d = 0;
            if (this.f3957c != null) {
                Arrays.fill(this.f3957c, -1);
            }
            C1254i iVar = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && iVar != null && iVar.mo5180q()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.mo5433d()) {
                        iVar.mo4762a(recyclerView.mAdapter.getItemCount(), (C1257a) this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    iVar.mo4761a(this.f3955a, this.f3956b, recyclerView.mState, (C1257a) this);
                }
                if (this.f3958d > iVar.f3721x) {
                    iVar.f3721x = this.f3958d;
                    iVar.f3722y = z;
                    recyclerView.mRecycler.mo5234b();
                }
            }
        }

        /* renamed from: b */
        public void mo5195b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f3958d * 2;
                if (this.f3957c == null) {
                    this.f3957c = new int[4];
                    Arrays.fill(this.f3957c, -1);
                } else if (i3 >= this.f3957c.length) {
                    int[] iArr = this.f3957c;
                    this.f3957c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.f3957c, 0, iArr.length);
                }
                this.f3957c[i3] = i;
                this.f3957c[i3 + 1] = i2;
                this.f3958d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5513a(int i) {
            if (this.f3957c != null) {
                int i2 = this.f3958d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f3957c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5510a() {
            if (this.f3957c != null) {
                Arrays.fill(this.f3957c, -1);
            }
            this.f3958d = 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$b */
    /* compiled from: GapWorker */
    static class C1312b {

        /* renamed from: a */
        public boolean f3959a;

        /* renamed from: b */
        public int f3960b;

        /* renamed from: c */
        public int f3961c;

        /* renamed from: d */
        public RecyclerView f3962d;

        /* renamed from: e */
        public int f3963e;

        C1312b() {
        }

        /* renamed from: a */
        public void mo5514a() {
            this.f3959a = false;
            this.f3960b = 0;
            this.f3961c = 0;
            this.f3962d = null;
            this.f3963e = 0;
        }
    }

    C1309e() {
    }

    /* renamed from: a */
    public void mo5504a(RecyclerView recyclerView) {
        this.f3951b.add(recyclerView);
    }

    /* renamed from: b */
    public void mo5506b(RecyclerView recyclerView) {
        this.f3951b.remove(recyclerView);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5505a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f3952c == 0) {
            this.f3952c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.mo5511a(i, i2);
    }

    /* renamed from: a */
    private void m5318a() {
        C1312b bVar;
        int size = this.f3951b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = (RecyclerView) this.f3951b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.mo5512a(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f3958d;
            }
        }
        this.f3954f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f3951b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                C1311a aVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(aVar.f3955a) + Math.abs(aVar.f3956b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.f3958d * 2; i6 += 2) {
                    if (i5 >= this.f3954f.size()) {
                        bVar = new C1312b();
                        this.f3954f.add(bVar);
                    } else {
                        bVar = (C1312b) this.f3954f.get(i5);
                    }
                    int i7 = aVar.f3957c[i6 + 1];
                    bVar.f3959a = i7 <= abs;
                    bVar.f3960b = abs;
                    bVar.f3961c = i7;
                    bVar.f3962d = recyclerView2;
                    bVar.f3963e = aVar.f3957c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f3954f, f3950e);
    }

    /* renamed from: a */
    static boolean m5321a(RecyclerView recyclerView, int i) {
        int c = recyclerView.mChildHelper.mo5449c();
        for (int i2 = 0; i2 < c; i2++) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.mo5452d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private C1277x m5317a(RecyclerView recyclerView, int i, long j) {
        if (m5321a(recyclerView, i)) {
            return null;
        }
        C1266p pVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            C1277x a = pVar.mo5220a(i, false, j);
            if (a != null) {
                if (!a.isBound() || a.isInvalid()) {
                    pVar.mo5230a(a, false);
                } else {
                    pVar.mo5226a(a.itemView);
                }
            }
            return a;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    /* renamed from: a */
    private void m5319a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.mo5449c() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            C1311a aVar = recyclerView.mPrefetchRegistry;
            aVar.mo5512a(recyclerView, true);
            if (aVar.f3958d != 0) {
                try {
                    C0872b.m3226a("RV Nested Prefetch");
                    recyclerView.mState.mo5286a(recyclerView.mAdapter);
                    for (int i = 0; i < aVar.f3958d * 2; i += 2) {
                        m5317a(recyclerView, aVar.f3957c[i], j);
                    }
                } finally {
                    C0872b.m3225a();
                }
            }
        }
    }

    /* renamed from: a */
    private void m5320a(C1312b bVar, long j) {
        C1277x a = m5317a(bVar.f3962d, bVar.f3963e, bVar.f3959a ? Long.MAX_VALUE : j);
        if (a != null && a.mNestedRecyclerView != null && a.isBound() && !a.isInvalid()) {
            m5319a((RecyclerView) a.mNestedRecyclerView.get(), j);
        }
    }

    /* renamed from: b */
    private void m5322b(long j) {
        int i = 0;
        while (i < this.f3954f.size()) {
            C1312b bVar = (C1312b) this.f3954f.get(i);
            if (bVar.f3962d != null) {
                m5320a(bVar, j);
                bVar.mo5514a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5503a(long j) {
        m5318a();
        m5322b(j);
    }

    public void run() {
        try {
            C0872b.m3226a("RV Prefetch");
            if (!this.f3951b.isEmpty()) {
                int size = this.f3951b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) this.f3951b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j == 0) {
                    this.f3952c = 0;
                    C0872b.m3225a();
                    return;
                }
                mo5503a(TimeUnit.MILLISECONDS.toNanos(j) + this.f3953d);
                this.f3952c = 0;
                C0872b.m3225a();
            }
        } finally {
            this.f3952c = 0;
            C0872b.m3225a();
        }
    }
}
