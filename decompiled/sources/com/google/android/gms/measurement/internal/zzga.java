package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzga extends SSLSocket {
    private final SSLSocket zzaut;

    zzga(zzfz zzfz, SSLSocket sSLSocket) {
        this.zzaut = sSLSocket;
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.zzaut.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.zzaut.setEnabledProtocols(strArr);
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzaut.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.zzaut.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.zzaut.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return this.zzaut.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.zzaut.getEnabledProtocols();
    }

    public final SSLSession getSession() {
        return this.zzaut.getSession();
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzaut.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.zzaut.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void startHandshake() throws IOException {
        this.zzaut.startHandshake();
    }

    public final void setUseClientMode(boolean z) {
        this.zzaut.setUseClientMode(z);
    }

    public final boolean getUseClientMode() {
        return this.zzaut.getUseClientMode();
    }

    public final void setNeedClientAuth(boolean z) {
        this.zzaut.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.zzaut.setWantClientAuth(z);
    }

    public final boolean getNeedClientAuth() {
        return this.zzaut.getNeedClientAuth();
    }

    public final boolean getWantClientAuth() {
        return this.zzaut.getWantClientAuth();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.zzaut.setEnableSessionCreation(z);
    }

    public final boolean getEnableSessionCreation() {
        return this.zzaut.getEnableSessionCreation();
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        this.zzaut.bind(socketAddress);
    }

    public final synchronized void close() throws IOException {
        this.zzaut.close();
    }

    public final void connect(SocketAddress socketAddress) throws IOException {
        this.zzaut.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        this.zzaut.connect(socketAddress, i);
    }

    public final SocketChannel getChannel() {
        return this.zzaut.getChannel();
    }

    public final InetAddress getInetAddress() {
        return this.zzaut.getInetAddress();
    }

    public final InputStream getInputStream() throws IOException {
        return this.zzaut.getInputStream();
    }

    public final boolean getKeepAlive() throws SocketException {
        return this.zzaut.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.zzaut.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.zzaut.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.zzaut.getLocalSocketAddress();
    }

    public final boolean getOOBInline() throws SocketException {
        return this.zzaut.getOOBInline();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.zzaut.getOutputStream();
    }

    public final int getPort() {
        return this.zzaut.getPort();
    }

    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.zzaut.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.zzaut.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() throws SocketException {
        return this.zzaut.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() throws SocketException {
        return this.zzaut.getSendBufferSize();
    }

    public final int getSoLinger() throws SocketException {
        return this.zzaut.getSoLinger();
    }

    public final synchronized int getSoTimeout() throws SocketException {
        return this.zzaut.getSoTimeout();
    }

    public final boolean getTcpNoDelay() throws SocketException {
        return this.zzaut.getTcpNoDelay();
    }

    public final int getTrafficClass() throws SocketException {
        return this.zzaut.getTrafficClass();
    }

    public final boolean isBound() {
        return this.zzaut.isBound();
    }

    public final boolean isClosed() {
        return this.zzaut.isClosed();
    }

    public final boolean isConnected() {
        return this.zzaut.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.zzaut.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.zzaut.isOutputShutdown();
    }

    public final void sendUrgentData(int i) throws IOException {
        this.zzaut.sendUrgentData(i);
    }

    public final void setKeepAlive(boolean z) throws SocketException {
        this.zzaut.setKeepAlive(z);
    }

    public final void setOOBInline(boolean z) throws SocketException {
        this.zzaut.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        this.zzaut.setPerformancePreferences(i, i2, i3);
    }

    public final synchronized void setReceiveBufferSize(int i) throws SocketException {
        this.zzaut.setReceiveBufferSize(i);
    }

    public final void setReuseAddress(boolean z) throws SocketException {
        this.zzaut.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i) throws SocketException {
        this.zzaut.setSendBufferSize(i);
    }

    public final void setSoLinger(boolean z, int i) throws SocketException {
        this.zzaut.setSoLinger(z, i);
    }

    public final synchronized void setSoTimeout(int i) throws SocketException {
        this.zzaut.setSoTimeout(i);
    }

    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.zzaut.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i) throws SocketException {
        this.zzaut.setTrafficClass(i);
    }

    public final void shutdownInput() throws IOException {
        this.zzaut.shutdownInput();
    }

    public final void shutdownOutput() throws IOException {
        this.zzaut.shutdownOutput();
    }

    public final String toString() {
        return this.zzaut.toString();
    }

    public final boolean equals(Object obj) {
        return this.zzaut.equals(obj);
    }
}
