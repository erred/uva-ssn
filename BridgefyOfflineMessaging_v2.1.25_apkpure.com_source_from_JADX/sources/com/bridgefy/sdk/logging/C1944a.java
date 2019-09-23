package com.bridgefy.sdk.logging;

import android.content.Intent;
import com.bridgefy.sdk.framework.controller.Constants;
import com.bridgefy.sdk.logging.entities.LogEntity;
import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.bridgefy.sdk.logging.a */
class C1944a implements Runnable {

    /* renamed from: a */
    private BlockingQueue<LogEntity> f6090a = new LinkedBlockingDeque();

    C1944a(BlockingQueue<LogEntity> blockingQueue) {
        this.f6090a = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                LogEntity logEntity = (LogEntity) this.f6090a.take();
                if (Logger.getInstance().shouldWriteToTempFile()) {
                    m8081a(logEntity);
                }
                Logger.getInstance().getContext().sendBroadcast(new Intent().setAction(Constants.LOGGING_EVENT_BROADCAST).putExtra(Constants.LOGGING_EVENT_TYPE, logEntity.getLogType()).putExtra(Constants.LOGGING_EVENT_ENTRY, logEntity.serialize()));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: a */
    private void m8081a(LogEntity logEntity) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Logger.getOrCreateFile(Logger.TEMP_FILE), true);
            fileOutputStream.write(new Gson().toJson((Object) logEntity).getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
