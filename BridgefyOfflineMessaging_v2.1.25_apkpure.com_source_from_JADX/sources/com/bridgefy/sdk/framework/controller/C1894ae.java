package com.bridgefy.sdk.framework.controller;

import android.os.Handler;
import android.os.Looper;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.framework.exceptions.MessageException;

/* renamed from: com.bridgefy.sdk.framework.controller.ae */
class C1894ae extends C1893ad<Message> {
    C1894ae(Config config) {
        this.f5890b = (Config) C1897ah.m7831a(config, "Missing config.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7440a(Message message) {
        if (mo7437a() && !mo7438a(message)) {
            new Handler(Looper.getMainLooper()).post(new Runnable(message) {
                private final /* synthetic */ Message f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C1894ae.this.m7803b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7803b(Message message) {
        mo7439b().onMessageReceived(message);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7441a(Message message, MessageException messageException) {
        if (mo7437a()) {
            new Handler(Looper.getMainLooper()).post(new Runnable(message, messageException) {
                private final /* synthetic */ Message f$1;
                private final /* synthetic */ MessageException f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    C1894ae.this.m7804b(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7804b(Message message, MessageException messageException) {
        mo7439b().onMessageFailed(message, messageException);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7442a(String str, MessageException messageException) {
        if (mo7437a()) {
            new Handler(Looper.getMainLooper()).post(new Runnable(str, messageException) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ MessageException f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    C1894ae.this.m7805b(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7805b(String str, MessageException messageException) {
        mo7439b().onMessageReceivedException(str, messageException);
    }
}
