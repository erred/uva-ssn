package p140me.bridgefy.main;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: me.bridgefy.main.-$$Lambda$c$dA_vahkNfFxu52D_xieskykVmec reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$c$dA_vahkNfFxu52D_xieskykVmec implements OnFailureListener {
    public static final /* synthetic */ $$Lambda$c$dA_vahkNfFxu52D_xieskykVmec INSTANCE = new $$Lambda$c$dA_vahkNfFxu52D_xieskykVmec();

    private /* synthetic */ $$Lambda$c$dA_vahkNfFxu52D_xieskykVmec() {
    }

    public final void onFailure(Exception exc) {
        Log.w("BridgefySession", "... Digits -> Firebase migration failed. Will retry next time TMA is started.", exc);
    }
}
