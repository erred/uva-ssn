package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class JsonNode extends Base implements TreeNode, Iterable<JsonNode> {
    /* access modifiers changed from: protected */
    public abstract JsonNode _at(JsonPointer jsonPointer);

    public boolean asBoolean(boolean z) {
        return z;
    }

    public double asDouble(double d) {
        return d;
    }

    public int asInt(int i) {
        return i;
    }

    public long asLong(long j) {
        return j;
    }

    public abstract String asText();

    public byte[] binaryValue() throws IOException {
        return null;
    }

    public boolean booleanValue() {
        return false;
    }

    public boolean canConvertToInt() {
        return false;
    }

    public boolean canConvertToLong() {
        return false;
    }

    public abstract <T extends JsonNode> T deepCopy();

    public double doubleValue() {
        return 0.0d;
    }

    public abstract boolean equals(Object obj);

    public abstract JsonNode findParent(String str);

    public abstract List<JsonNode> findParents(String str, List<JsonNode> list);

    public abstract JsonNode findPath(String str);

    public abstract JsonNode findValue(String str);

    public abstract List<JsonNode> findValues(String str, List<JsonNode> list);

    public abstract List<String> findValuesAsText(String str, List<String> list);

    public float floatValue() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    public abstract JsonNode get(int i);

    public JsonNode get(String str) {
        return null;
    }

    public abstract JsonNodeType getNodeType();

    public int intValue() {
        return 0;
    }

    public boolean isBigDecimal() {
        return false;
    }

    public boolean isBigInteger() {
        return false;
    }

    public boolean isDouble() {
        return false;
    }

    public boolean isFloat() {
        return false;
    }

    public boolean isFloatingPointNumber() {
        return false;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isIntegralNumber() {
        return false;
    }

    public boolean isLong() {
        return false;
    }

    public boolean isShort() {
        return false;
    }

    public long longValue() {
        return 0;
    }

    public Number numberValue() {
        return null;
    }

    public abstract JsonNode path(int i);

    public abstract JsonNode path(String str);

    public short shortValue() {
        return 0;
    }

    public int size() {
        return 0;
    }

    public String textValue() {
        return null;
    }

    public abstract String toString();

    protected JsonNode() {
    }

    public final boolean isValueNode() {
        switch (getNodeType()) {
            case ARRAY:
            case OBJECT:
            case MISSING:
                return false;
            default:
                return true;
        }
    }

    public final boolean isContainerNode() {
        JsonNodeType nodeType = getNodeType();
        return nodeType == JsonNodeType.OBJECT || nodeType == JsonNodeType.ARRAY;
    }

    public final boolean isMissingNode() {
        return getNodeType() == JsonNodeType.MISSING;
    }

    public final boolean isArray() {
        return getNodeType() == JsonNodeType.ARRAY;
    }

    public final boolean isObject() {
        return getNodeType() == JsonNodeType.OBJECT;
    }

    public Iterator<String> fieldNames() {
        return ClassUtil.emptyIterator();
    }

    /* renamed from: at */
    public final JsonNode m8095at(JsonPointer jsonPointer) {
        if (jsonPointer.matches()) {
            return this;
        }
        JsonNode _at = _at(jsonPointer);
        if (_at == null) {
            return MissingNode.getInstance();
        }
        return _at.mo8286at(jsonPointer.tail());
    }

    /* renamed from: at */
    public final JsonNode m8096at(String str) {
        return mo8286at(JsonPointer.compile(str));
    }

    public final boolean isPojo() {
        return getNodeType() == JsonNodeType.POJO;
    }

    public final boolean isNumber() {
        return getNodeType() == JsonNodeType.NUMBER;
    }

    public final boolean isTextual() {
        return getNodeType() == JsonNodeType.STRING;
    }

    public final boolean isBoolean() {
        return getNodeType() == JsonNodeType.BOOLEAN;
    }

    public final boolean isNull() {
        return getNodeType() == JsonNodeType.NULL;
    }

    public final boolean isBinary() {
        return getNodeType() == JsonNodeType.BINARY;
    }

    public BigDecimal decimalValue() {
        return BigDecimal.ZERO;
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.ZERO;
    }

    public String asText(String str) {
        String asText = asText();
        return asText == null ? str : asText;
    }

    public int asInt() {
        return asInt(0);
    }

    public long asLong() {
        return asLong(0);
    }

    public double asDouble() {
        return asDouble(0.0d);
    }

    public boolean asBoolean() {
        return asBoolean(false);
    }

    public boolean has(String str) {
        return get(str) != null;
    }

    public boolean has(int i) {
        return get(i) != null;
    }

    public boolean hasNonNull(String str) {
        JsonNode jsonNode = get(str);
        return jsonNode != null && !jsonNode.isNull();
    }

    public boolean hasNonNull(int i) {
        JsonNode jsonNode = get(i);
        return jsonNode != null && !jsonNode.isNull();
    }

    public final Iterator<JsonNode> iterator() {
        return elements();
    }

    public Iterator<JsonNode> elements() {
        return ClassUtil.emptyIterator();
    }

    public Iterator<Entry<String, JsonNode>> fields() {
        return ClassUtil.emptyIterator();
    }

    public final List<JsonNode> findValues(String str) {
        List<JsonNode> findValues = findValues(str, null);
        return findValues == null ? Collections.emptyList() : findValues;
    }

    public final List<String> findValuesAsText(String str) {
        List<String> findValuesAsText = findValuesAsText(str, null);
        return findValuesAsText == null ? Collections.emptyList() : findValuesAsText;
    }

    public final List<JsonNode> findParents(String str) {
        List<JsonNode> findParents = findParents(str, null);
        return findParents == null ? Collections.emptyList() : findParents;
    }

    public JsonNode with(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("JsonNode not of type ObjectNode (but ");
        sb.append(getClass().getName());
        sb.append("), can not call with() on it");
        throw new UnsupportedOperationException(sb.toString());
    }

    public JsonNode withArray(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("JsonNode not of type ObjectNode (but ");
        sb.append(getClass().getName());
        sb.append("), can not call withArray() on it");
        throw new UnsupportedOperationException(sb.toString());
    }

    public boolean equals(Comparator<JsonNode> comparator, JsonNode jsonNode) {
        return comparator.compare(this, jsonNode) == 0;
    }
}
