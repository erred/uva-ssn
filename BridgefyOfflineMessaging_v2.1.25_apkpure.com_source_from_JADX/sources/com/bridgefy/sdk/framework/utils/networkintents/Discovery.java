package com.bridgefy.sdk.framework.utils.networkintents;

public class Discovery {

    /* renamed from: a */
    private String f6067a;

    /* renamed from: b */
    private int f6068b;

    /* renamed from: c */
    private DiscoveryListener f6069c;

    /* renamed from: d */
    private C1943a f6070d;

    public Discovery() {
        this("225.4.5.6", 5775);
    }

    public Discovery(int i) {
        this("225.4.5.6", i);
    }

    public Discovery(String str, int i) {
        this.f6067a = str;
        this.f6068b = i;
    }

    /* renamed from: a */
    private void m8064a(DiscoveryListener discoveryListener) {
        this.f6069c = discoveryListener;
    }

    public void enable(DiscoveryListener discoveryListener) throws DiscoveryException {
        m8064a(discoveryListener);
        m8063a();
    }

    /* renamed from: a */
    private void m8063a() throws DiscoveryException {
        if (this.f6069c == null) {
            throw new IllegalStateException("No listener set");
        } else if (this.f6070d == null) {
            this.f6070d = m8065b();
            this.f6070d.start();
        }
    }

    public boolean isEnabled() {
        return this.f6070d != null;
    }

    /* renamed from: b */
    private C1943a m8065b() {
        return new C1943a(this.f6067a, this.f6068b, this.f6069c);
    }

    public void disable() {
        if (this.f6070d != null) {
            this.f6070d.mo7697b();
            this.f6070d = null;
        }
    }
}
