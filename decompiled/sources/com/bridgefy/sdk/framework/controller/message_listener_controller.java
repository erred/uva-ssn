package com.bridgefy.sdk.framework.controller;

import android.os.Handler;
import android.os.Looper;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.framework.exceptions.MessageException;

/* renamed from: com.bridgefy.sdk.framework.controller.ae */
class message_listener_controller extends message_listener_interface<Message> {
    message_listener_controller(Config config) {
        this.config = (Config) C1897ah.m7831a(config, "Missing config.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7440a(Message message) {
        if (get_message_listener() && !contains(message)) {
            new Handler(Looper.getMainLooper()).post(new Runnable(message) {
                private final /* synthetic */ Message f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    message_listener_controller.this.m7803b(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7803b(Message message) {
        get_message_listener_obj().onMessageReceived(message);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7441a(Message message, MessageException messageException) {
        if (get_message_listener()) {
            new Handler(Looper.getMainLooper()).post(new Runnable(message, messageException) {
                private final /* synthetic */ Message f$1;
                private final /* synthetic */ MessageException f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    message_listener_controller.this.m7804b(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7804b(Message message, MessageException messageException) {
        get_message_listener_obj().onMessageFailed(message, messageException);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7442a(String str, MessageException messageException) {
        if (get_message_listener()) {
            new Handler(Looper.getMainLooper()).post(new Runnable(str, messageException) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ MessageException f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    message_listener_controller.this.on_message_received_exception(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void on_message_received_exception(String str, MessageException messageException) {
        get_message_listener_obj().onMessageReceivedException(str, messageException);
    }
}
