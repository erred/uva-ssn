package com.firebase.p119ui.auth.p121b;

import android.os.Bundle;
import androidx.fragment.p081a.C1071e;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.net.ConnectException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.firebase.ui.auth.b.b */
/* compiled from: GoogleApiHelper */
public abstract class C2020b implements ConnectionCallbacks, OnConnectionFailedListener {

    /* renamed from: b */
    private static final AtomicInteger f6253b = new AtomicInteger(10);

    /* renamed from: a */
    protected GoogleApiClient f6254a;

    /* renamed from: c */
    private TaskCompletionSource<Bundle> f6255c = new TaskCompletionSource<>();

    /* renamed from: com.firebase.ui.auth.b.b$a */
    /* compiled from: GoogleApiHelper */
    protected static class C2021a<TResult> implements OnCompleteListener<TResult> {

        /* renamed from: a */
        private TaskCompletionSource f6256a;

        /* renamed from: b */
        private OnSuccessListener<TResult> f6257b;

        public C2021a(TaskCompletionSource taskCompletionSource, OnSuccessListener<TResult> onSuccessListener) {
            this.f6256a = taskCompletionSource;
            this.f6257b = onSuccessListener;
        }

        public void onComplete(Task<TResult> task) {
            if (task.isSuccessful()) {
                this.f6257b.onSuccess(task.getResult());
            } else {
                this.f6256a.setException(task.getException());
            }
        }
    }

    /* renamed from: com.firebase.ui.auth.b.b$b */
    /* compiled from: GoogleApiHelper */
    protected static final class C2022b<R extends Result> implements ResultCallback<R> {

        /* renamed from: a */
        private TaskCompletionSource<R> f6258a;

        public C2022b(TaskCompletionSource<R> taskCompletionSource) {
            this.f6258a = taskCompletionSource;
        }

        public void onResult(R r) {
            this.f6258a.setResult(r);
        }
    }

    public void onConnectionSuspended(int i) {
    }

    protected C2020b(C1071e eVar, Builder builder) {
        builder.enableAutoManage(eVar, m8200a(), this);
        builder.addConnectionCallbacks(this);
        this.f6254a = builder.build();
    }

    /* renamed from: a */
    public static int m8200a() {
        return f6253b.getAndIncrement();
    }

    /* renamed from: b */
    public Task<Bundle> mo11821b() {
        return this.f6255c.getTask();
    }

    public void onConnected(Bundle bundle) {
        this.f6255c.trySetResult(bundle);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f6255c.trySetException(new ConnectException(connectionResult.toString()));
    }
}
