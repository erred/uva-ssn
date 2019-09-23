package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.p116io.CharTypes;

public final class JsonReadContext extends JsonStreamContext {
    protected JsonReadContext _child;
    protected int _columnNr;
    protected String _currentName;
    protected Object _currentValue;
    protected DupDetector _dups;
    protected int _lineNr;
    protected final JsonReadContext _parent;

    public JsonReadContext(JsonReadContext jsonReadContext, DupDetector dupDetector, int i, int i2, int i3) {
        this._parent = jsonReadContext;
        this._dups = dupDetector;
        this._type = i;
        this._lineNr = i2;
        this._columnNr = i3;
        this._index = -1;
    }

    /* access modifiers changed from: protected */
    public void reset(int i, int i2, int i3) {
        this._type = i;
        this._index = -1;
        this._lineNr = i2;
        this._columnNr = i3;
        this._currentName = null;
        this._currentValue = null;
        if (this._dups != null) {
            this._dups.reset();
        }
    }

    public JsonReadContext withDupDetector(DupDetector dupDetector) {
        this._dups = dupDetector;
        return this;
    }

    public Object getCurrentValue() {
        return this._currentValue;
    }

    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public static JsonReadContext createRootContext(int i, int i2, DupDetector dupDetector) {
        JsonReadContext jsonReadContext = new JsonReadContext(null, dupDetector, 0, i, i2);
        return jsonReadContext;
    }

    public static JsonReadContext createRootContext(DupDetector dupDetector) {
        JsonReadContext jsonReadContext = new JsonReadContext(null, dupDetector, 0, 1, 0);
        return jsonReadContext;
    }

    public JsonReadContext createChildArrayContext(int i, int i2) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, this._dups == null ? null : this._dups.child(), 1, i, i2);
            this._child = jsonReadContext;
        } else {
            jsonReadContext.reset(1, i, i2);
        }
        return jsonReadContext;
    }

    public JsonReadContext createChildObjectContext(int i, int i2) {
        JsonReadContext jsonReadContext = this._child;
        if (jsonReadContext == null) {
            JsonReadContext jsonReadContext2 = new JsonReadContext(this, this._dups == null ? null : this._dups.child(), 2, i, i2);
            this._child = jsonReadContext2;
            return jsonReadContext2;
        }
        jsonReadContext.reset(2, i, i2);
        return jsonReadContext;
    }

    public String getCurrentName() {
        return this._currentName;
    }

    public JsonReadContext getParent() {
        return this._parent;
    }

    public JsonReadContext clearAndGetParent() {
        this._currentValue = null;
        return this._parent;
    }

    public JsonLocation getStartLocation(Object obj) {
        JsonLocation jsonLocation = new JsonLocation(obj, -1, this._lineNr, this._columnNr);
        return jsonLocation;
    }

    public DupDetector getDupDetector() {
        return this._dups;
    }

    public boolean expectComma() {
        int i = this._index + 1;
        this._index = i;
        if (this._type == 0 || i <= 0) {
            return false;
        }
        return true;
    }

    public void setCurrentName(String str) throws JsonProcessingException {
        this._currentName = str;
        if (this._dups != null) {
            _checkDup(this._dups, str);
        }
    }

    private void _checkDup(DupDetector dupDetector, String str) throws JsonProcessingException {
        if (dupDetector.isDup(str)) {
            Object source = dupDetector.getSource();
            JsonParser jsonParser = source instanceof JsonParser ? (JsonParser) source : null;
            StringBuilder sb = new StringBuilder();
            sb.append("Duplicate field '");
            sb.append(str);
            sb.append("'");
            throw new JsonParseException(jsonParser, sb.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        switch (this._type) {
            case 0:
                sb.append("/");
                break;
            case 1:
                sb.append('[');
                sb.append(getCurrentIndex());
                sb.append(']');
                break;
            default:
                sb.append('{');
                if (this._currentName != null) {
                    sb.append('\"');
                    CharTypes.appendQuoted(sb, this._currentName);
                    sb.append('\"');
                } else {
                    sb.append('?');
                }
                sb.append('}');
                break;
        }
        return sb.toString();
    }
}
