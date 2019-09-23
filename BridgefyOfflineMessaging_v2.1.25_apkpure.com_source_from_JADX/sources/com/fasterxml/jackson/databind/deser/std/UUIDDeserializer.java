package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class UUIDDeserializer extends FromStringDeserializer<UUID> {
    static final int[] HEX_DIGITS = new int[127];
    private static final long serialVersionUID = 1;

    static {
        Arrays.fill(HEX_DIGITS, -1);
        for (int i = 0; i < 10; i++) {
            HEX_DIGITS[i + 48] = i;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            int i3 = i2 + 10;
            HEX_DIGITS[i2 + 97] = i3;
            HEX_DIGITS[i2 + 65] = i3;
        }
    }

    public UUIDDeserializer() {
        super(UUID.class);
    }

    /* access modifiers changed from: protected */
    public UUID _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
        if (str.length() == 36) {
            if (!(str.charAt(8) == '-' && str.charAt(13) == '-' && str.charAt(18) == '-' && str.charAt(23) == '-')) {
                _badFormat(str, deserializationContext);
            }
            return new UUID((((long) intFromChars(str, 0, deserializationContext)) << 32) + ((((long) shortFromChars(str, 9, deserializationContext)) << 16) | ((long) shortFromChars(str, 14, deserializationContext))), ((((long) intFromChars(str, 28, deserializationContext)) << 32) >>> 32) | (((long) (shortFromChars(str, 24, deserializationContext) | (shortFromChars(str, 19, deserializationContext) << 16))) << 32));
        } else if (str.length() == 24) {
            return _fromBytes(Base64Variants.getDefaultVariant().decode(str), deserializationContext);
        } else {
            return _badFormat(str, deserializationContext);
        }
    }

    /* access modifiers changed from: protected */
    public UUID _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) throws IOException {
        if (obj instanceof byte[]) {
            return _fromBytes((byte[]) obj, deserializationContext);
        }
        super._deserializeEmbedded(obj, deserializationContext);
        return null;
    }

    private UUID _badFormat(String str, DeserializationContext deserializationContext) throws IOException {
        return (UUID) deserializationContext.handleWeirdStringValue(handledType(), str, "UUID has to be represented by standard 36-char representation", new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public int intFromChars(String str, int i, DeserializationContext deserializationContext) throws JsonMappingException {
        return (byteFromChars(str, i, deserializationContext) << 24) + (byteFromChars(str, i + 2, deserializationContext) << 16) + (byteFromChars(str, i + 4, deserializationContext) << 8) + byteFromChars(str, i + 6, deserializationContext);
    }

    /* access modifiers changed from: 0000 */
    public int shortFromChars(String str, int i, DeserializationContext deserializationContext) throws JsonMappingException {
        return (byteFromChars(str, i, deserializationContext) << 8) + byteFromChars(str, i + 2, deserializationContext);
    }

    /* access modifiers changed from: 0000 */
    public int byteFromChars(String str, int i, DeserializationContext deserializationContext) throws JsonMappingException {
        char charAt = str.charAt(i);
        int i2 = i + 1;
        char charAt2 = str.charAt(i2);
        if (charAt <= 127 && charAt2 <= 127) {
            int i3 = (HEX_DIGITS[charAt] << 4) | HEX_DIGITS[charAt2];
            if (i3 >= 0) {
                return i3;
            }
        }
        if (charAt > 127 || HEX_DIGITS[charAt] < 0) {
            return _badChar(str, i, deserializationContext, charAt);
        }
        return _badChar(str, i2, deserializationContext, charAt2);
    }

    /* access modifiers changed from: 0000 */
    public int _badChar(String str, int i, DeserializationContext deserializationContext, char c) throws JsonMappingException {
        throw deserializationContext.weirdStringException(str, handledType(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", new Object[]{Character.valueOf(c), Integer.toHexString(c)}));
    }

    private UUID _fromBytes(byte[] bArr, DeserializationContext deserializationContext) throws JsonMappingException {
        if (bArr.length == 16) {
            return new UUID(_long(bArr, 0), _long(bArr, 8));
        }
        JsonParser parser = deserializationContext.getParser();
        StringBuilder sb = new StringBuilder();
        sb.append("Can only construct UUIDs from byte[16]; got ");
        sb.append(bArr.length);
        sb.append(" bytes");
        throw InvalidFormatException.from(parser, sb.toString(), bArr, handledType());
    }

    private static long _long(byte[] bArr, int i) {
        return ((((long) _int(bArr, i + 4)) << 32) >>> 32) | (((long) _int(bArr, i)) << 32);
    }

    private static int _int(byte[] bArr, int i) {
        return (bArr[i + 3] & UnsignedBytes.MAX_VALUE) | (bArr[i] << Ascii.CAN) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }
}
