package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.SecurityUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.msgpack.core.MessagePack.Code;

@Beta
public final class SecurityTestUtils {
    private static final byte[] ENCODED_PRIVATE_KEY = {48, -126, 2, 118, 2, 1, 0, 48, Ascii.f6725CR, 6, 9, 42, -122, 72, -122, -9, Ascii.f6725CR, 1, 1, 1, 5, 0, 4, -126, 2, 96, 48, -126, 2, 92, 2, 1, 0, 2, -127, -127, 0, -89, 33, 8, -124, 110, Code.BIN8, 89, 8, Code.FALSE, 69, 120, 95, Code.BIN16, Code.FIXEXT2, Ascii.f6725CR, -18, 123, Ascii.f6729GS, -31, Ascii.f6725CR, -80, -76, 109, Code.FALSE, -79, 2, 104, -94, 76, 59, -73, -26, 99, 123, Code.EXT8, -92, -100, 116, 50, -25, 96, 53, 124, 95, 76, Code.BIN16, -84, 70, Ascii.ESC, 0, 72, Code.NEVER_USED, 84, -77, -2, -107, -66, Code.NEGFIXINT_PREFIX, -119, Ascii.ESC, -95, 54, Code.FIXEXT1, -89, 1, 71, 44, 7, Code.EXT32, 126, 5, -78, 87, -105, -114, 65, -19, 58, -78, -95, 0, 118, 83, 76, -88, 2, -21, Ascii.DEL, SignedBytes.MAX_POWER_OF_TWO, 74, -103, -114, -127, -70, -81, -127, 125, Code.STR32, Ascii.NAK, 113, Ascii.DC4, -102, 46, Code.STR32, -111, -97, 97, -127, 32, 87, -80, 105, Ascii.DC2, -19, 107, -73, Code.UINT32, -97, Ascii.f6738VT, -23, Code.BIN16, -107, -107, 83, -25, Ascii.f6734SI, -93, -21, 2, 3, 1, 0, 1, 2, -127, Byte.MIN_VALUE, 45, Code.MAP16, -104, Ascii.SUB, Code.FIXEXT16, Code.FIXEXT8, Code.FIXEXT1, -29, Code.ARRAY32, -123, -7, -110, -73, -106, 80, -5, -118, Ascii.CAN, Code.STR16, 66, Code.FLOAT32, -93, Code.FLOAT32, -104, 43, Code.FALSE, Code.INT8, 122, -14, Code.FIXEXT8, 85, Ascii.DC2, Code.FLOAT64, 109, Ascii.SYN, -113, 44, 77, -116, 7, 10, Code.FIXEXT2, Code.TRUE, 43, Code.FIXEXT16, Code.TRUE, 76, 19, -11, -89, 47, 80, -72, 113, -86, 70, -23, Ascii.ESC, 113, 37, -1, 42, 48, 84, -80, Ascii.f6733RS, 86, 36, -124, -22, 79, Code.FIXEXT1, 87, Code.FIXEXT16, Ascii.f6737US, Code.FIXEXT8, Code.FIXEXT1, -16, -74, 85, 61, -122, -22, 10, -31, 78, 92, -123, -77, Ascii.f6727FF, -80, 62, Code.UINT8, 68, Code.INT32, -17, 67, 124, -78, -23, -105, -77, -2, 89, -16, -12, Code.EXT16, Code.UINT16, Ascii.SUB, 102, 46, 39, Code.TRUE, -13, -79, -65, -5, 126, 70, Ascii.f6729GS, Ascii.f6737US, 104, -109, 65, -23, -69, Ascii.ETB, -7, 2, 65, 0, Code.FIXEXT4, Ascii.DC2, 101, 10, -21, 37, 107, -3, -114, -29, Code.FIXEXT16, 76, 107, -122, 40, 8, Code.BIN32, Code.NEGFIXINT_PREFIX, -12, 55, -4, Code.TRUE, -66, 91, Code.EXT16, Code.UINT32, 78, -124, Ascii.f6738VT, Code.UINT64, Code.FALSE, -121, Code.EXT16, 70, -92, 90, 32, Code.FIXARRAY_PREFIX, 49, Ascii.SUB, -99, 113, 44, Ascii.SUB, 42, -99, Code.FIXEXT16, -123, 17, 93, 114, 125, 35, -118, Code.NEGFIXINT_PREFIX, 125, Code.NIL, 61, 58, Code.BIN32, -105, -105, Code.STR8, 93, 2, 65, 0, Code.EXT8, Code.ARRAY16, -22, -107, Code.FIXEXT4, -79, 0, -118, 121, -76, 120, 52, 110, Ascii.DEL, 115, 68, -86, -4, 96, Code.UINT32, 72, Code.BIN8, Code.EXT8, 125, 57, Ascii.NAK, -81, Code.FIXEXT1, Ascii.f6726EM, 112, -75, 83, 57, Code.EXT32, 61, Ascii.CAN, Ascii.f6728FS, Code.FIXARRAY_PREFIX, -103, -8, 120, 110, Code.UINT8, -108, Code.FIXEXT8, -76, Code.FIXSTR_PREFIX, 87, -117, 69, 0, SignedBytes.MAX_POWER_OF_TWO, Ascii.SUB, 4, 122, Ascii.f6725CR, 6, -106, 112, Code.UINT16, -1, 79, 117, -25, 2, SignedBytes.MAX_POWER_OF_TWO, Ascii.DEL, 68, 60, 81, -5, 110, 41, -1, 122, 93, -74, -113, -24, 52, -65, Code.BIN8, 72, 8, 32, -24, Code.INT8, Ascii.SUB, Code.EXT8, 38, -26, 0, Code.INT8, -24, -21, -28, -66, 47, Code.MAP32, 63, 48, 34, 108, Code.UINT16, -116, -125, Code.FIXEXT16, 42, Ascii.SUB, 32, Ascii.f6727FF, 73, -1, Ascii.f6726EM, 77, 51, -109, 7, Ascii.SYN, -124, 79, -26, 50, Code.UINT16, -76, Ascii.f6725CR, -80, -66, 19, -7, 2, 65, 0, -90, 99, -20, 68, -4, -84, -11, -105, 83, -123, -124, Code.NEVER_USED, -103, -16, -81, 101, 78, -72, -72, 91, 100, Code.EXT8, -74, -111, 49, Ascii.DC2, 54, 4, -19, 125, 32, -24, 125, -26, 100, Code.MAP32, -117, 0, 115, -65, 33, 124, -107, 3, -95, -91, 118, Ascii.f6727FF, Ascii.f6727FF, Ascii.f6729GS, 80, -3, Ascii.f6727FF, -20, 7, 52, -118, -12, 122, 75, 117, -81, Code.FIXARRAY_PREFIX, -89, 2, SignedBytes.MAX_POWER_OF_TWO, 93, -21, Code.UINT8, -110, Code.FLOAT32, -9, 79, -123, 105, 125, Code.EXT16, 75, -77, -26, 125, -123, -69, 62, -2, 79, 8, 72, -76, -67, 5, 33, -121, 1, Code.FIXEXT4, -17, Ascii.f6729GS, 69, -20, -68, -26, -23, 95, -7, -70, Code.UINT32, -10, 58, Ascii.DLE, -15, -89, -24, -121, -14, -72, -127, -89, Code.NEVER_USED, 66, 7, 77, -89, Code.FLOAT32, -95, -90, 45, Code.FIXEXT1, -118, 69, -1};
    private static final byte[] ENCODED_PUBLIC_KEY = {48, -127, -97, 48, Ascii.f6725CR, 6, 9, 42, -122, 72, -122, -9, Ascii.f6725CR, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -89, 33, 8, -124, 110, Code.BIN8, 89, 8, Code.FALSE, 69, 120, 95, Code.BIN16, Code.FIXEXT2, Ascii.f6725CR, -18, 123, Ascii.f6729GS, -31, Ascii.f6725CR, -80, -76, 109, Code.FALSE, -79, 2, 104, -94, 76, 59, -73, -26, 99, 123, Code.EXT8, -92, -100, 116, 50, -25, 96, 53, 124, 95, 76, Code.BIN16, -84, 70, Ascii.ESC, 0, 72, Code.NEVER_USED, 84, -77, -2, -107, -66, Code.NEGFIXINT_PREFIX, -119, Ascii.ESC, -95, 54, Code.FIXEXT1, -89, 1, 71, 44, 7, Code.EXT32, 126, 5, -78, 87, -105, -114, 65, -19, 58, -78, -95, 0, 118, 83, 76, -88, 2, -21, Ascii.DEL, SignedBytes.MAX_POWER_OF_TWO, 74, -103, -114, -127, -70, -81, -127, 125, Code.STR32, Ascii.NAK, 113, Ascii.DC4, -102, 46, Code.STR32, -111, -97, 97, -127, 32, 87, -80, 105, Ascii.DC2, -19, 107, -73, Code.UINT32, -97, Ascii.f6738VT, -23, Code.BIN16, -107, -107, 83, -25, Ascii.f6734SI, -93, -21, 2, 3, 1, 0, 1};

    public static byte[] newEncodedRsaPrivateKeyBytes() {
        return (byte[]) ENCODED_PRIVATE_KEY.clone();
    }

    public static byte[] newEncodedRsaPublicKeyBytes() {
        return (byte[]) ENCODED_PUBLIC_KEY.clone();
    }

    public static RSAPrivateKey newRsaPrivateKey() throws GeneralSecurityException {
        return (RSAPrivateKey) SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(ENCODED_PRIVATE_KEY));
    }

    public static RSAPublicKey newRsaPublicKey() throws GeneralSecurityException {
        return (RSAPublicKey) SecurityUtils.getRsaKeyFactory().generatePublic(new X509EncodedKeySpec(ENCODED_PUBLIC_KEY));
    }

    private SecurityTestUtils() {
    }
}
