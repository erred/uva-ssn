package com.bridgefy.sdk.framework.utils.networkintents;

public class Discovery {

    /* renamed from: a */
    private String address;

    /* renamed from: b */
    private int port;

    /* renamed from: c */
    private DiscoveryListener discovery_listener;

    /* renamed from: d */
    private multicast_discoverer multicast_discoverer;

    public Discovery() {
        this("225.4.5.6", 5775);
    }

    public Discovery(int i) {
        this("225.4.5.6", i);
    }

    public Discovery(String str, int i) {
        this.address = str;
        this.port = i;
    }

    /* renamed from: a */
    private void set_discovery_listener(DiscoveryListener discoveryListener) {
        this.discovery_listener = discoveryListener;
    }

    public void enable(DiscoveryListener discoveryListener) throws DiscoveryException {
        set_discovery_listener(discoveryListener);
        start_multicast_discoverer();
    }

    /* renamed from: a */
    private void start_multicast_discoverer() throws DiscoveryException {
        if (this.discovery_listener == null) {
            throw new IllegalStateException("No listener set");
        } else if (this.multicast_discoverer == null) {
            this.multicast_discoverer = new_multicast_discoverer();
            this.multicast_discoverer.start();
        }
    }

    public boolean isEnabled() {
        return this.multicast_discoverer != null;
    }

    /* renamed from: b */
    private multicast_discoverer new_multicast_discoverer() {
        return new multicast_discoverer(this.address, this.port, this.discovery_listener);
    }

    public void disable() {
        if (this.multicast_discoverer != null) {
            this.multicast_discoverer.stop();
            this.multicast_discoverer = null;
        }
    }
}
