package com.bridgefy.sdk.client;

import com.bridgefy.sdk.framework.exceptions.MessageException;
import java.util.UUID;

public abstract class MessageListener {
    public void onBroadcastMessageReceived(Message message) {
    }

    public void onMessageDataProgress(UUID uuid, long j, long j2) {
    }

    public void onMessageFailed(Message message, MessageException messageException) {
    }

    public void onMessageReceived(Message message) {
    }

    public void onMessageReceivedException(String str, MessageException messageException) {
    }

    @Deprecated
    public void onMessageSent(Message message) {
    }

    public void onMessageSent(String str) {
    }
}
