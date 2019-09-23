package com.bridgefy.sdk.logging;

import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.Session;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.bridgefy.sdk.framework.entities.ForwardPacket;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import com.bridgefy.sdk.framework.utils.Utils;
import com.bridgefy.sdk.logging.entities.CommunicationLog;
import com.bridgefy.sdk.logging.entities.CommunicationLog.CommunicationErrorEvent;
import com.bridgefy.sdk.logging.entities.CommunicationLog.CommunicationEvent;
import com.bridgefy.sdk.logging.entities.LogEntity;
import com.bridgefy.sdk.logging.entities.MeshLog;
import com.bridgefy.sdk.logging.entities.MeshLog.MeshErrorEvent;
import com.bridgefy.sdk.logging.entities.MeshLog.MeshEvent;
import com.bridgefy.sdk.logging.entities.MessageLog;
import com.bridgefy.sdk.logging.entities.MessageLog.MessageEvent;
import com.bridgefy.sdk.logging.entities.OperatorStatusLog;
import com.bridgefy.sdk.logging.entities.OperatorStatusLog.StatusErrorEvent;
import java.util.ArrayList;

public class LogFactory {
    public static LogEntity build(Device device, String str, CommunicationEvent communicationEvent) {
        CommunicationLog communicationLog = new CommunicationLog(device.getAntennaType(), device.getDeviceAddress(), communicationEvent, Utils.getCrcFromKey(device.getDeviceAddress()));
        if (communicationEvent.equals(CommunicationEvent.BFCommunicationTypePeerDetected)) {
            StringBuilder sb = new StringBuilder();
            sb.append(communicationLog.getMessage());
            sb.append(": ");
            sb.append(device.getDeviceAddress());
            sb.append(", ");
            sb.append(str);
            sb.append(" devices in list");
            communicationLog.setMessage(sb.toString());
            communicationLog.setComment(null);
        } else {
            communicationLog.setComment(str);
        }
        return communicationLog;
    }

    public static LogEntity build(Device device, CommunicationEvent communicationEvent) {
        CommunicationLog communicationLog = new CommunicationLog(device.getAntennaType(), device.getDeviceAddress(), communicationEvent, device.getCrc() == 0 ? Utils.getCrcFromKey(device.getUserId()) : device.getCrc());
        return communicationLog;
    }

    public static LogEntity build(Session session, CommunicationEvent communicationEvent) {
        CommunicationLog communicationLog = new CommunicationLog(session.getAntennaType(), session.getUserId(), communicationEvent, session.getCrc());
        return communicationLog;
    }

    public static LogEntity build(Device device, BleHandshake bleHandshake, CommunicationEvent communicationEvent) {
        if (device.getUserId() != null) {
            CommunicationLog communicationLog = new CommunicationLog(device.getAntennaType(), device.getDeviceAddress(), bleHandshake, communicationEvent, device.getCrc() == 0 ? Utils.getCrcFromKey(device.getUserId()) : device.getCrc());
            return communicationLog;
        }
        CommunicationLog communicationLog2 = new CommunicationLog(device.getAntennaType(), device.getDeviceAddress(), bleHandshake, communicationEvent, Utils.getCrcFromKey(device.getDeviceAddress()));
        StringBuilder sb = new StringBuilder();
        sb.append("crc generated with device address: ");
        sb.append(device.getDeviceAddress());
        communicationLog2.setComment(sb.toString());
        return communicationLog2;
    }

    public static LogEntity build(Session session, CommunicationErrorEvent communicationErrorEvent, ConnectionException connectionException) {
        CommunicationLog communicationLog = new CommunicationLog(session.getAntennaType(), session.getUserId() == null ? "N/A" : session.getUserId(), communicationErrorEvent, session.getUserId() == null ? -1 : Utils.getCrcFromKey(session.getUserId()), connectionException.getMessage());
        return communicationLog;
    }

    public static LogEntity build(Device device, CommunicationErrorEvent communicationErrorEvent, ConnectionException connectionException) {
        CommunicationLog communicationLog = new CommunicationLog(device.getAntennaType(), device.getDeviceAddress(), communicationErrorEvent, Utils.getCrcFromKey(device.getDeviceAddress()), connectionException.getMessage());
        return communicationLog;
    }

    public static LogEntity build(String str) {
        return new OperatorStatusLog(StatusErrorEvent.BFCommunicationBluetooth133, Antenna.BLUETOOTH_LE, str);
    }

    public static LogEntity build(Message message, Session session, MessageEvent messageEvent) {
        if (session == null || session.getUserId() == null) {
            return new MessageLog(message, "Session was null or arrived without a valid userId.");
        }
        MessageLog messageLog = new MessageLog(session.getAntennaType(), session.getCrc(), message, messageEvent);
        return messageLog;
    }

    public static LogEntity build(Message message, MessageException messageException) {
        return new MessageLog(message, messageException.getMessage());
    }

    public static LogEntity build(Session session, ForwardPacket forwardPacket, MeshEvent meshEvent) {
        if (session == null || session.getUserId() == null) {
            return new MeshLog(MeshErrorEvent.BFErrorMeshTypeSessionInvalid, forwardPacket);
        }
        return new MeshLog(meshEvent, forwardPacket, Long.valueOf(session.getCrc()));
    }

    public static LogEntity build(ForwardPacket forwardPacket, MeshErrorEvent meshErrorEvent) {
        return new MeshLog(meshErrorEvent, forwardPacket);
    }

    public static LogEntity build(ForwardPacket forwardPacket) {
        return new MeshLog(forwardPacket);
    }

    public static LogEntity build(Message message) {
        return new MeshLog(message);
    }

    public static LogEntity build(int i) {
        return new MeshLog(i);
    }

    public static LogEntity build(ArrayList<ForwardPacket> arrayList) {
        return new MeshLog(MeshErrorEvent.BFErrorMeshTypeDiscardInvalidMessages, arrayList);
    }
}
