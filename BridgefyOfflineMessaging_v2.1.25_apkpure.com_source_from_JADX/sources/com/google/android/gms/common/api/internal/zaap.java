package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;

final class zaap extends zabf {
    private final /* synthetic */ ConnectionProgressReportCallbacks zagn;

    zaap(zaan zaan, zabd zabd, ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zagn = connectionProgressReportCallbacks;
        super(zabd);
    }

    public final void zaan() {
        this.zagn.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
