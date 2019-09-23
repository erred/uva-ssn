package com.bridgefy.sdk.logging.entities;

import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.logging.entities.LogEntity.LogType;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class OperatorStatusLog extends LogEntity {

    public enum StatusErrorEvent {
        BFStatusErrorTypeManager,
        BFStatusErrorTypeWritingFailed,
        BFStatusErrorTypeWritingOnCentralFailed,
        BFStatusErrorTypeWritingOnPeripheralFailed,
        BFStatusErrorTypePeripheralServices,
        BFStatusErrorTypePeripheralCharacteristics,
        BFStatusErrorTypeReceivingInfoFromPeripheral,
        BFStatusErrorTypePeripheralWritingChunkFailed,
        BFStatusErrorTypeCentralDisconnection,
        BFStatusErrorTypePeripheralDisconnection,
        BFStatusErrorTypeTransactionInterrupted,
        BFStatusErrorTypeUpdateSuscribers,
        BFStatusErrorTypeServiceError,
        BFCommunicationBluetooth133
    }

    public enum StatusEvent {
        BFStatusTypeOperatorStarted,
        BFStatusTypeOperatorStopped,
        BFStatusTypeStartAdvertising,
        BFStatusTypeStopAdvertising,
        BFStatusTypeCentralWritingAlreadyStarted,
        BFStatusTypePeripheralWritingAlreadyStarted,
        BFStatusTypePacketSent,
        BFStatusTypePacketReceived,
        BFStatusTypeCloseConnectionRequest,
        BFStatusTypePeripheralServicesOK,
        BFStatusTypeCentralReadyForCommunication,
        BFStatusTypeCentralReadyAndScanning,
        BFStatusTypePeripheralServiceDiscovered,
        BFStatusTypePeripheralCharacteristicDiscovered,
        BFStatusTypePeripheralReadyForCommunication,
        BFStatusTypePeripheralNotificationsStopped,
        BFStatusTypeCentralDisconnection,
        BFStatusTypePeripheralDisconnection,
        BFStatusTypeCentralReadingAlreadyStarted,
        BFStatusTypePeerSuspended,
        BFStatusTypePeerSuspensionReactivation,
        BFStatusTypeIgnoredConnection,
        BFStatusTypeDiscoveryStarted,
        BFStatusTypeDiscoveryStopped
    }

    public OperatorStatusLog(StatusEvent statusEvent, Antenna antenna) {
        super(LogType.OPERATOR_STATUS, statusEvent.ordinal(), antenna);
    }

    public OperatorStatusLog(StatusErrorEvent statusErrorEvent, Antenna antenna, String str) {
        super(LogType.OPERATOR_STATUS_ERROR, statusErrorEvent.ordinal(), antenna);
        this.f6108i = str;
    }

    public String getMessage() {
        if (this.f6107h == null) {
            if (this.f6108i != null) {
                this.f6107h = this.f6108i;
            } else {
                this.f6107h = StatusEvent.values()[this.f6103d].name();
            }
        }
        return this.f6107h;
    }

    public String serialize() {
        return new Gson().toJson((Object) this);
    }

    public static OperatorStatusLog create(String str) throws JsonSyntaxException {
        return (OperatorStatusLog) new Gson().fromJson(str, OperatorStatusLog.class);
    }
}
