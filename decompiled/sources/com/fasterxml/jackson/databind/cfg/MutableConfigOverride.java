package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

public class MutableConfigOverride extends ConfigOverride implements Serializable {
    private static final long serialVersionUID = 1;

    public MutableConfigOverride() {
    }

    protected MutableConfigOverride(MutableConfigOverride mutableConfigOverride) {
        super(mutableConfigOverride);
    }

    /* access modifiers changed from: protected */
    public MutableConfigOverride copy() {
        return new MutableConfigOverride(this);
    }

    public MutableConfigOverride setFormat(Value value) {
        this._format = value;
        return this;
    }

    public MutableConfigOverride setInclude(JsonInclude.Value value) {
        this._include = value;
        return this;
    }

    public MutableConfigOverride setIgnorals(JsonIgnoreProperties.Value value) {
        this._ignorals = value;
        return this;
    }

    public MutableConfigOverride setIsIgnoredType(Boolean bool) {
        this._isIgnoredType = bool;
        return this;
    }
}
