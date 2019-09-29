package com.bridgefy.sdk.client;

public class Config {

    /* renamed from: a */
    private boolean is_encryption;

    /* renamed from: b */
    private Antenna antenna;

    /* renamed from: c */
    private BFEnergyProfile bf_eneergy_profile;

    /* renamed from: d */
    private BFBleProfile bf_ble_profile;

    /* renamed from: e */
    private BFEngineProfile bf_engine_profile;

    /* renamed from: f */
    private int max_connection_retries;

    public enum Antenna {
        BLUETOOTH,
        BLUETOOTH_LE,
        UNREACHABLE
    }

    public static final class Builder {

        /* renamed from: a */
        private boolean is_encryption = true;

        /* renamed from: b */
        private Antenna antenna = Antenna.BLUETOOTH_LE;

        /* renamed from: c */
        private BFEnergyProfile bf_energy_profile = BFEnergyProfile.BALANCED;

        /* renamed from: d */
        private BFBleProfile bf_ble_profile = BFBleProfile.BACKWARDS_COMPATIBLE;

        /* renamed from: e */
        private BFEngineProfile bf_engine_profile = BFEngineProfile.BFConfigProfileDefault;

        /* renamed from: f */
        private int max_connection_retries = 10;

        public Builder setMaxConnectionRetries(int i) {
            this.max_connection_retries = i;
            return this;
        }

        public Builder setEncryption(boolean z) {
            this.is_encryption = z;
            return this;
        }

        public Builder setAntennaType(Antenna antenna) {
            this.antenna = antenna;
            return this;
        }

        public Builder setEnergyProfile(BFEnergyProfile bFEnergyProfile) {
            this.bf_energy_profile = bFEnergyProfile;
            return this;
        }

        public Builder setBleProfile(BFBleProfile bFBleProfile) {
            this.bf_ble_profile = bFBleProfile;
            return this;
        }

        public Builder setEngineProfile(BFEngineProfile bFEngineProfile) {
            this.bf_engine_profile = bFEngineProfile;
            return this;
        }

        public Config build() {
            Config config = new Config(this.is_encryption, this.antenna, this.bf_energy_profile, this.bf_ble_profile, this.bf_engine_profile, this.max_connection_retries);
            return config;
        }
    }

    public BFEngineProfile getEngineProfile() {
        return this.bf_engine_profile;
    }

    public int getMaxConnectionRetries() {
        return this.max_connection_retries;
    }

    private Config(boolean z, Antenna antenna, BFEnergyProfile bFEnergyProfile, BFBleProfile bFBleProfile, BFEngineProfile bFEngineProfile, int i) {
        this.is_encryption = z;
        this.antenna = antenna;
        this.bf_eneergy_profile = bFEnergyProfile;
        this.bf_ble_profile = bFBleProfile;
        this.bf_engine_profile = bFEngineProfile;
        this.max_connection_retries = i;
    }

    public Antenna getAntennaType() {
        return this.antenna;
    }

    public void setAntennaType(Antenna antenna) {
        this.antenna = antenna;
    }

    public BFEnergyProfile getEnergyProfile() {
        return this.bf_eneergy_profile;
    }

    public Config setEnergyProfile(BFEnergyProfile bFEnergyProfile) {
        this.bf_eneergy_profile = bFEnergyProfile;
        return this;
    }

    public BFBleProfile getBleProfile() {
        return this.bf_ble_profile;
    }

    public boolean isEncryption() {
        return this.is_encryption;
    }
}
