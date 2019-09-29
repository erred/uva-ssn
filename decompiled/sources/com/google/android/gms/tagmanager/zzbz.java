package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzsr;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

final class zzbz extends Thread implements zzby {
    private static zzbz zzbco;
    private volatile boolean closed = false;
    private final LinkedBlockingQueue<Runnable> zzbcm = new LinkedBlockingQueue<>();
    private volatile boolean zzbcn = false;
    /* access modifiers changed from: private */
    public volatile zzcb zzbcp;
    /* access modifiers changed from: private */
    public final Context zzri;

    static zzbz zzv(Context context) {
        if (zzbco == null) {
            zzbco = new zzbz(context);
        }
        return zzbco;
    }

    private zzbz(Context context) {
        super("GAThread");
        if (context != null) {
            this.zzri = context.getApplicationContext();
        } else {
            this.zzri = context;
        }
        start();
    }

    public final void zzdt(String str) {
        zzca zzca = new zzca(this, this, System.currentTimeMillis(), str);
        zzh(zzca);
    }

    public final void zzh(Runnable runnable) {
        this.zzbcm.add(runnable);
    }

    public final void run() {
        while (true) {
            boolean z = this.closed;
            try {
                Runnable runnable = (Runnable) this.zzbcm.take();
                if (!this.zzbcn) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                try {
                    zzdi.zzdm(e.toString());
                } catch (Exception e2) {
                    String str = "Error on Google TagManager Thread: ";
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(byteArrayOutputStream);
                    zzsr.zza(e2, printStream);
                    printStream.flush();
                    String valueOf = String.valueOf(new String(byteArrayOutputStream.toByteArray()));
                    zzdi.m8600e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    zzdi.m8600e("Google TagManager is shutting down.");
                    this.zzbcn = true;
                }
            }
        }
    }
}
