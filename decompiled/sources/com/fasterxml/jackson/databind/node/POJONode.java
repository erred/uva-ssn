package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

public class POJONode extends ValueNode {
    protected final Object _value;

    public POJONode(Object obj) {
        this._value = obj;
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.POJO;
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public byte[] binaryValue() throws IOException {
        if (this._value instanceof byte[]) {
            return (byte[]) this._value;
        }
        return super.binaryValue();
    }

    public String asText() {
        return this._value == null ? "null" : this._value.toString();
    }

    public String asText(String str) {
        return this._value == null ? str : this._value.toString();
    }

    public boolean asBoolean(boolean z) {
        return (this._value == null || !(this._value instanceof Boolean)) ? z : ((Boolean) this._value).booleanValue();
    }

    public int asInt(int i) {
        return this._value instanceof Number ? ((Number) this._value).intValue() : i;
    }

    public long asLong(long j) {
        return this._value instanceof Number ? ((Number) this._value).longValue() : j;
    }

    public double asDouble(double d) {
        return this._value instanceof Number ? ((Number) this._value).doubleValue() : d;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (this._value == null) {
            serializerProvider.defaultSerializeNull(jsonGenerator);
        } else if (this._value instanceof JsonSerializable) {
            ((JsonSerializable) this._value).serialize(jsonGenerator, serializerProvider);
        } else {
            jsonGenerator.writeObject(this._value);
        }
    }

    public Object getPojo() {
        return this._value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof POJONode)) {
            return _pojoEquals((POJONode) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean _pojoEquals(POJONode pOJONode) {
        if (this._value != null) {
            return this._value.equals(pOJONode._value);
        }
        return pOJONode._value == null;
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    public String toString() {
        if (this._value instanceof byte[]) {
            return String.format("(binary value of %d bytes)", new Object[]{Integer.valueOf(((byte[]) this._value).length)});
        } else if (!(this._value instanceof RawValue)) {
            return String.valueOf(this._value);
        } else {
            return String.format("(raw value '%s')", new Object[]{((RawValue) this._value).toString()});
        }
    }
}
