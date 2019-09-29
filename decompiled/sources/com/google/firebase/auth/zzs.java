package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzs implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zzhk;
    private final /* synthetic */ ActionCodeSettings zzhl;

    zzs(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.zzhk = firebaseUser;
        this.zzhl = actionCodeSettings;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzhk.zzcc()).zza(this.zzhl, ((GetTokenResult) task.getResult()).getToken());
    }
}
