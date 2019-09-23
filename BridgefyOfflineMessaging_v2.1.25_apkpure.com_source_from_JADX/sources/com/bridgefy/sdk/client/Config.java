package com.bridgefy.sdk.client;

public class Config {

    /* renamed from: a */
    private boolean f5786a;

    /* renamed from: b */
    private Antenna f5787b;

    /* renamed from: c */
    private BFEnergyProfile f5788c;

    /* renamed from: d */
    private BFBleProfile f5789d;

    /* renamed from: e */
    private BFEngineProfile f5790e;

    /* renamed from: f */
    private int f5791f;

    public enum Antenna {
        BLUETOOTH,
        BLUETOOTH_LE,
        UNREACHABLE
    }

    public static final class Builder {

        /* renamed from: a */
        private boolean f5793a = true;

        /* renamed from: b */
        private Antenna f5794b = Antenna.BLUETOOTH_LE;

        /* renamed from: c */
        private BFEnergyProfile f5795c = BFEnergyProfile.BALANCED;

        /* renamed from: d */
        private BFBleProfile f5796d = BFBleProfile.BACKWARDS_COMPATIBLE;

        /* renamed from: e */
        private BFEngineProfile f5797e = BFEngineProfile.BFConfigProfileDefault;

        /* renamed from: f */
        private int f5798f = 10;

        public Builder setMaxConnectionRetries(int i) {
            this.f5798f = i;
            return this;
        }

        public Builder setEncryption(boolean z) {
            this.f5793a = z;
            return this;
        }

        public Builder setAntennaType(Antenna antenna) {
            this.f5794b = antenna;
            return this;
        }

        public Builder setEnergyProfile(BFEnergyProfile bFEnergyProfile) {
            this.f5795c = bFEnergyProfile;
            return this;
        }

        public Builder setBleProfile(BFBleProfile bFBleProfile) {
            this.f5796d = bFBleProfile;
            return this;
        }

        public Builder setEngineProfile(BFEngineProfile bFEngineProfile) {
            this.f5797e = bFEngineProfile;
            return this;
        }

        public Config build() {
            Config config = new Config(this.f5793a, this.f5794b, this.f5795c, this.f5796d, this.f5797e, this.f5798f);
            return config;
        }
    }

    public BFEngineProfile getEngineProfile() {
        return this.f5790e;
    }

    public int getMaxConnectionRetries() {
        return this.f5791f;
    }

    private Config(boolean z, Antenna antenna, BFEnergyProfile bFEnergyProfile, BFBleProfile bFBleProfile, BFEngineProfile bFEngineProfile, int i) {
        this.f5786a = z;
        this.f5787b = antenna;
        this.f5788c = bFEnergyProfile;
        this.f5789d = bFBleProfile;
        this.f5790e = bFEngineProfile;
        this.f5791f = i;
    }

    public Antenna getAntennaType() {
        return this.f5787b;
    }

    public void setAntennaType(Antenna antenna) {
        this.f5787b = antenna;
    }

    public BFEnergyProfile getEnergyProfile() {
        return this.f5788c;
    }

    public Config setEnergyProfile(BFEnergyProfile bFEnergyProfile) {
        this.f5788c = bFEnergyProfile;
        return this;
    }

    public BFBleProfile getBleProfile() {
        return this.f5789d;
    }

    public boolean isEncryption() {
        return this.f5786a;
    }
}
