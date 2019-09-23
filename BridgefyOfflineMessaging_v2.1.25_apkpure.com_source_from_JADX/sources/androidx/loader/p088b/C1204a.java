package androidx.loader.p088b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.p065c.C0871a;
import androidx.core.p069f.C0931f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: androidx.loader.b.a */
/* compiled from: AsyncTaskLoader */
public abstract class C1204a<D> extends C1206b<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile C1205a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile C1205a mTask;
    long mUpdateThrottle;

    /* renamed from: androidx.loader.b.a$a */
    /* compiled from: AsyncTaskLoader */
    final class C1205a extends C1209c<Void, Void, D> implements Runnable {

        /* renamed from: a */
        boolean f3605a;

        /* renamed from: f */
        private final CountDownLatch f3607f = new CountDownLatch(1);

        C1205a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public D mo4665a(Void... voidArr) {
            try {
                return C1204a.this.onLoadInBackground();
            } catch (C0871a e) {
                if (mo4706d()) {
                    return null;
                }
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4668a(D d) {
            try {
                C1204a.this.dispatchOnLoadComplete(this, d);
            } finally {
                this.f3607f.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4669b(D d) {
            try {
                C1204a.this.dispatchOnCancelled(this, d);
            } finally {
                this.f3607f.countDown();
            }
        }

        public void run() {
            this.f3605a = false;
            C1204a.this.executePendingTask();
        }

        /* renamed from: a */
        public void mo4667a() {
            try {
                this.f3607f.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void cancelLoadInBackground() {
    }

    public abstract D loadInBackground();

    public void onCanceled(D d) {
    }

    public C1204a(Context context) {
        this(context, C1209c.f3610c);
    }

    private C1204a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor;
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new C1205a<>();
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.f3605a) {
                this.mTask.f3605a = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.f3605a) {
            this.mTask.f3605a = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            boolean a = this.mTask.mo4700a(false);
            if (a) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return a;
        }
    }

    /* access modifiers changed from: 0000 */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.f3605a) {
                this.mTask.f3605a = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.mo4699a(this.mExecutor, null);
            } else {
                this.mTask.f3605a = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnCancelled(C1205a aVar, D d) {
        onCanceled(d);
        if (this.mCancellingTask == aVar) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnLoadComplete(C1205a aVar, D d) {
        if (this.mTask != aVar) {
            dispatchOnCancelled(aVar, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d);
        }
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public void waitForLoader() {
        C1205a aVar = this.mTask;
        if (aVar != null) {
            aVar.mo4667a();
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.f3605a);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.f3605a);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C0931f.m3409a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C0931f.m3408a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
