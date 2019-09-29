package org.msgpack.core;

import com.bridgefy.sdk.client.StateListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.msgpack.core.MessagePack.Code;
import org.msgpack.core.MessagePack.UnpackerConfig;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.p160b.C3731aa;
import org.msgpack.p160b.C3760q;
import org.msgpack.p160b.C3767x;
import org.msgpack.p160b.C3768y;

public class MessageUnpacker implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final MessageBuffer EMPTY_BUFFER = MessageBuffer.wrap(new byte[0]);
    private static final String EMPTY_STRING = "";
    private final CodingErrorAction actionOnMalformedString;
    private final CodingErrorAction actionOnUnmappableString;
    private final boolean allowReadingBinaryAsString;
    private final boolean allowReadingStringAsBinary;
    private MessageBuffer buffer = EMPTY_BUFFER;
    private CharBuffer decodeBuffer;
    private StringBuilder decodeStringBuffer;
    private CharsetDecoder decoder;

    /* renamed from: in */
    private MessageBufferInput f9912in;
    private int nextReadPosition;
    private final MessageBuffer numberBuffer = MessageBuffer.allocate(8);
    private int position;
    private final int stringDecoderBufferSize;
    private final int stringSizeLimit;
    private long totalReadBytes;

    protected MessageUnpacker(MessageBufferInput messageBufferInput, UnpackerConfig unpackerConfig) {
        this.f9912in = (MessageBufferInput) Preconditions.checkNotNull(messageBufferInput, "MessageBufferInput is null");
        this.allowReadingStringAsBinary = unpackerConfig.getAllowReadingStringAsBinary();
        this.allowReadingBinaryAsString = unpackerConfig.getAllowReadingBinaryAsString();
        this.actionOnMalformedString = unpackerConfig.getActionOnMalformedString();
        this.actionOnUnmappableString = unpackerConfig.getActionOnUnmappableString();
        this.stringSizeLimit = unpackerConfig.getStringSizeLimit();
        this.stringDecoderBufferSize = unpackerConfig.getStringDecoderBufferSize();
    }

    public MessageBufferInput reset(MessageBufferInput messageBufferInput) throws IOException {
        MessageBufferInput messageBufferInput2 = (MessageBufferInput) Preconditions.checkNotNull(messageBufferInput, "MessageBufferInput is null");
        MessageBufferInput messageBufferInput3 = this.f9912in;
        this.f9912in = messageBufferInput2;
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.totalReadBytes = 0;
        return messageBufferInput3;
    }

    public long getTotalReadBytes() {
        return this.totalReadBytes + ((long) this.position);
    }

    private MessageBuffer getNextBuffer() throws IOException {
        MessageBuffer next = this.f9912in.next();
        if (next != null) {
            this.totalReadBytes += (long) this.buffer.size();
            return next;
        }
        throw new MessageInsufficientBufferException();
    }

    private void nextBuffer() throws IOException {
        this.buffer = getNextBuffer();
        this.position = 0;
    }

    private MessageBuffer prepareNumberBuffer(int i) throws IOException {
        int i2;
        int size = this.buffer.size() - this.position;
        if (size >= i) {
            this.nextReadPosition = this.position;
            this.position += i;
            return this.buffer;
        }
        if (size > 0) {
            this.numberBuffer.putMessageBuffer(0, this.buffer, this.position, size);
            i -= size;
            i2 = size + 0;
        } else {
            i2 = 0;
        }
        while (true) {
            nextBuffer();
            int size2 = this.buffer.size();
            if (size2 >= i) {
                this.numberBuffer.putMessageBuffer(i2, this.buffer, 0, i);
                this.position = i;
                this.nextReadPosition = 0;
                return this.numberBuffer;
            }
            this.numberBuffer.putMessageBuffer(i2, this.buffer, 0, size2);
            i -= size2;
            i2 += size2;
        }
    }

    private static int utf8MultibyteCharacterSize(byte b) {
        return Integer.numberOfLeadingZeros((~(b & UnsignedBytes.MAX_VALUE)) << 24);
    }

    public boolean hasNext() throws IOException {
        return ensureBuffer();
    }

    private boolean ensureBuffer() throws IOException {
        while (this.buffer.size() <= this.position) {
            MessageBuffer next = this.f9912in.next();
            if (next == null) {
                return false;
            }
            this.totalReadBytes += (long) this.buffer.size();
            this.buffer = next;
            this.position = 0;
        }
        return true;
    }

    public MessageFormat getNextFormat() throws IOException {
        if (ensureBuffer()) {
            return MessageFormat.valueOf(this.buffer.getByte(this.position));
        }
        throw new MessageInsufficientBufferException();
    }

    private byte readByte() throws IOException {
        if (this.buffer.size() > this.position) {
            byte b = this.buffer.getByte(this.position);
            this.position++;
            return b;
        }
        nextBuffer();
        if (this.buffer.size() <= 0) {
            return readByte();
        }
        byte b2 = this.buffer.getByte(0);
        this.position = 1;
        return b2;
    }

    private short readShort() throws IOException {
        return prepareNumberBuffer(2).getShort(this.nextReadPosition);
    }

    private int readInt() throws IOException {
        return prepareNumberBuffer(4).getInt(this.nextReadPosition);
    }

    private long readLong() throws IOException {
        return prepareNumberBuffer(8).getLong(this.nextReadPosition);
    }

    private float readFloat() throws IOException {
        return prepareNumberBuffer(4).getFloat(this.nextReadPosition);
    }

    private double readDouble() throws IOException {
        return prepareNumberBuffer(8).getDouble(this.nextReadPosition);
    }

    public void skipValue() throws IOException {
        skipValue(1);
    }

    public void skipValue(int i) throws IOException {
        while (i > 0) {
            byte readByte = readByte();
            switch (MessageFormat.valueOf(readByte)) {
                case FIXMAP:
                    i += (readByte & Ascii.f6734SI) * 2;
                    break;
                case FIXARRAY:
                    i += readByte & Ascii.f6734SI;
                    break;
                case FIXSTR:
                    skipPayload(readByte & Ascii.f6737US);
                    break;
                case INT8:
                case UINT8:
                    skipPayload(1);
                    break;
                case INT16:
                case UINT16:
                    skipPayload(2);
                    break;
                case INT32:
                case UINT32:
                case FLOAT32:
                    skipPayload(4);
                    break;
                case INT64:
                case UINT64:
                case FLOAT64:
                    skipPayload(8);
                    break;
                case BIN8:
                case STR8:
                    skipPayload(readNextLength8());
                    break;
                case BIN16:
                case STR16:
                    skipPayload(readNextLength16());
                    break;
                case BIN32:
                case STR32:
                    skipPayload(readNextLength32());
                    break;
                case FIXEXT1:
                    skipPayload(2);
                    break;
                case FIXEXT2:
                    skipPayload(3);
                    break;
                case FIXEXT4:
                    skipPayload(5);
                    break;
                case FIXEXT8:
                    skipPayload(9);
                    break;
                case FIXEXT16:
                    skipPayload(17);
                    break;
                case EXT8:
                    skipPayload(readNextLength8() + 1);
                    break;
                case EXT16:
                    skipPayload(readNextLength16() + 1);
                    break;
                case EXT32:
                    skipPayload(readNextLength32() + 1);
                    break;
                case ARRAY16:
                    i += readNextLength16();
                    break;
                case ARRAY32:
                    i += readNextLength32();
                    break;
                case MAP16:
                    i += readNextLength16() * 2;
                    break;
                case MAP32:
                    i += readNextLength32() * 2;
                    break;
                case NEVER_USED:
                    throw new MessageNeverUsedFormatException("Encountered 0xC1 \"NEVER_USED\" byte");
            }
            i--;
        }
    }

    private static MessagePackException unexpected(String str, byte b) {
        MessageFormat valueOf = MessageFormat.valueOf(b);
        if (valueOf == MessageFormat.NEVER_USED) {
            return new MessageNeverUsedFormatException(String.format("Expected %s, but encountered 0xC1 \"NEVER_USED\" byte", new Object[]{str}));
        }
        String name = valueOf.getValueType().name();
        StringBuilder sb = new StringBuilder();
        sb.append(name.substring(0, 1));
        sb.append(name.substring(1).toLowerCase());
        return new MessageTypeException(String.format("Expected %s, but got %s (%02x)", new Object[]{str, sb.toString(), Byte.valueOf(b)}));
    }

    public C3760q unpackValue() throws IOException {
        int i = 0;
        switch (getNextFormat().getValueType()) {
            case NIL:
                readByte();
                return C3768y.m11451a();
            case BOOLEAN:
                return C3768y.m11445a(unpackBoolean());
            case INTEGER:
                if (C37701.$SwitchMap$org$msgpack$core$MessageFormat[getNextFormat().ordinal()] != 16) {
                    return C3768y.m11448a(unpackLong());
                }
                return C3768y.m11449a(unpackBigInteger());
            case FLOAT:
                return C3768y.m11447a(unpackDouble());
            case STRING:
                return C3768y.m11454b(readPayload(unpackRawStringHeader()), true);
            case BINARY:
                return C3768y.m11444a(readPayload(unpackBinaryHeader()), true);
            case ARRAY:
                int unpackArrayHeader = unpackArrayHeader();
                C3767x[] xVarArr = new C3767x[unpackArrayHeader];
                while (i < unpackArrayHeader) {
                    xVarArr[i] = unpackValue();
                    i++;
                }
                return C3768y.m11442a(xVarArr, true);
            case MAP:
                int unpackMapHeader = unpackMapHeader() * 2;
                C3767x[] xVarArr2 = new C3767x[unpackMapHeader];
                while (i < unpackMapHeader) {
                    xVarArr2[i] = unpackValue();
                    int i2 = i + 1;
                    xVarArr2[i2] = unpackValue();
                    i = i2 + 1;
                }
                return C3768y.m11452b(xVarArr2, true);
            case EXTENSION:
                ExtensionTypeHeader unpackExtensionTypeHeader = unpackExtensionTypeHeader();
                return C3768y.m11446a(unpackExtensionTypeHeader.getType(), readPayload(unpackExtensionTypeHeader.getLength()));
            default:
                throw new MessageNeverUsedFormatException("Unknown value type");
        }
    }

    public C3731aa unpackValue(C3731aa aaVar) throws IOException {
        int i = 0;
        switch (getNextFormat().getValueType()) {
            case NIL:
                readByte();
                aaVar.mo32005a();
                return aaVar;
            case BOOLEAN:
                aaVar.mo32012a(unpackBoolean());
                return aaVar;
            case INTEGER:
                if (C37701.$SwitchMap$org$msgpack$core$MessageFormat[getNextFormat().ordinal()] != 16) {
                    aaVar.mo32008a(unpackLong());
                    return aaVar;
                }
                aaVar.mo32009a(unpackBigInteger());
                return aaVar;
            case FLOAT:
                aaVar.mo32007a(unpackDouble());
                return aaVar;
            case STRING:
                aaVar.mo32014b(readPayload(unpackRawStringHeader()));
                return aaVar;
            case BINARY:
                aaVar.mo32013a(readPayload(unpackBinaryHeader()));
                return aaVar;
            case ARRAY:
                int unpackArrayHeader = unpackArrayHeader();
                ArrayList arrayList = new ArrayList(unpackArrayHeader);
                while (i < unpackArrayHeader) {
                    arrayList.add(unpackValue());
                    i++;
                }
                aaVar.mo32010a((List<C3767x>) arrayList);
                return aaVar;
            case MAP:
                int unpackMapHeader = unpackMapHeader();
                HashMap hashMap = new HashMap();
                while (i < unpackMapHeader) {
                    hashMap.put(unpackValue(), unpackValue());
                    i++;
                }
                aaVar.mo32011a((Map<C3767x, C3767x>) hashMap);
                return aaVar;
            case EXTENSION:
                ExtensionTypeHeader unpackExtensionTypeHeader = unpackExtensionTypeHeader();
                aaVar.mo32006a(unpackExtensionTypeHeader.getType(), readPayload(unpackExtensionTypeHeader.getLength()));
                return aaVar;
            default:
                throw new MessageFormatException("Unknown value type");
        }
    }

    public void unpackNil() throws IOException {
        byte readByte = readByte();
        if (readByte != -64) {
            throw unexpected("Nil", readByte);
        }
    }

    public boolean tryUnpackNil() throws IOException {
        if (!ensureBuffer()) {
            throw new MessageInsufficientBufferException();
        } else if (this.buffer.getByte(this.position) != -64) {
            return false;
        } else {
            readByte();
            return true;
        }
    }

    public boolean unpackBoolean() throws IOException {
        byte readByte = readByte();
        if (readByte == -62) {
            return false;
        }
        if (readByte == -61) {
            return true;
        }
        throw unexpected("boolean", readByte);
    }

    public byte unpackByte() throws IOException {
        byte readByte = readByte();
        if (Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case -52:
                byte readByte2 = readByte();
                if (readByte2 >= 0) {
                    return readByte2;
                }
                throw overflowU8(readByte2);
            case -51:
                short readShort = readShort();
                if (readShort >= 0 && readShort <= 127) {
                    return (byte) readShort;
                }
                throw overflowU16(readShort);
            case -50:
                int readInt = readInt();
                if (readInt >= 0 && readInt <= 127) {
                    return (byte) readInt;
                }
                throw overflowU32(readInt);
            case -49:
                long readLong = readLong();
                if (readLong >= 0 && readLong <= 127) {
                    return (byte) ((int) readLong);
                }
                throw overflowU64(readLong);
            case -48:
                return readByte();
            case -47:
                short readShort2 = readShort();
                if (readShort2 >= -128 && readShort2 <= 127) {
                    return (byte) readShort2;
                }
                throw overflowI16(readShort2);
            case -46:
                int readInt2 = readInt();
                if (readInt2 >= -128 && readInt2 <= 127) {
                    return (byte) readInt2;
                }
                throw overflowI32(readInt2);
            case -45:
                long readLong2 = readLong();
                if (readLong2 >= -128 && readLong2 <= 127) {
                    return (byte) ((int) readLong2);
                }
                throw overflowI64(readLong2);
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public short unpackShort() throws IOException {
        byte readByte = readByte();
        if (Code.isFixInt(readByte)) {
            return (short) readByte;
        }
        switch (readByte) {
            case -52:
                return (short) (readByte() & UnsignedBytes.MAX_VALUE);
            case -51:
                short readShort = readShort();
                if (readShort >= 0) {
                    return readShort;
                }
                throw overflowU16(readShort);
            case -50:
                int readInt = readInt();
                if (readInt >= 0 && readInt <= 32767) {
                    return (short) readInt;
                }
                throw overflowU32(readInt);
            case -49:
                long readLong = readLong();
                if (readLong >= 0 && readLong <= 32767) {
                    return (short) ((int) readLong);
                }
                throw overflowU64(readLong);
            case -48:
                return (short) readByte();
            case -47:
                return readShort();
            case -46:
                int readInt2 = readInt();
                if (readInt2 >= -32768 && readInt2 <= 32767) {
                    return (short) readInt2;
                }
                throw overflowI32(readInt2);
            case -45:
                long readLong2 = readLong();
                if (readLong2 >= -32768 && readLong2 <= 32767) {
                    return (short) ((int) readLong2);
                }
                throw overflowI64(readLong2);
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public int unpackInt() throws IOException {
        byte readByte = readByte();
        if (Code.isFixInt(readByte)) {
            return readByte;
        }
        switch (readByte) {
            case -52:
                return readByte() & UnsignedBytes.MAX_VALUE;
            case -51:
                return readShort() & 65535;
            case -50:
                int readInt = readInt();
                if (readInt >= 0) {
                    return readInt;
                }
                throw overflowU32(readInt);
            case -49:
                long readLong = readLong();
                if (readLong >= 0 && readLong <= 2147483647L) {
                    return (int) readLong;
                }
                throw overflowU64(readLong);
            case -48:
                return readByte();
            case -47:
                return readShort();
            case -46:
                return readInt();
            case -45:
                long readLong2 = readLong();
                if (readLong2 >= -2147483648L && readLong2 <= 2147483647L) {
                    return (int) readLong2;
                }
                throw overflowI64(readLong2);
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public long unpackLong() throws IOException {
        byte readByte = readByte();
        if (Code.isFixInt(readByte)) {
            return (long) readByte;
        }
        switch (readByte) {
            case -52:
                return (long) (readByte() & UnsignedBytes.MAX_VALUE);
            case -51:
                return (long) (readShort() & 65535);
            case -50:
                int readInt = readInt();
                return readInt < 0 ? ((long) (readInt & BaseClientBuilder.API_PRIORITY_OTHER)) + 2147483648L : (long) readInt;
            case -49:
                long readLong = readLong();
                if (readLong >= 0) {
                    return readLong;
                }
                throw overflowU64(readLong);
            case -48:
                return (long) readByte();
            case -47:
                return (long) readShort();
            case -46:
                return (long) readInt();
            case -45:
                return readLong();
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public BigInteger unpackBigInteger() throws IOException {
        byte readByte = readByte();
        if (Code.isFixInt(readByte)) {
            return BigInteger.valueOf((long) readByte);
        }
        switch (readByte) {
            case -52:
                return BigInteger.valueOf((long) (readByte() & UnsignedBytes.MAX_VALUE));
            case -51:
                return BigInteger.valueOf((long) (readShort() & 65535));
            case -50:
                int readInt = readInt();
                if (readInt < 0) {
                    return BigInteger.valueOf(((long) (readInt & BaseClientBuilder.API_PRIORITY_OTHER)) + 2147483648L);
                }
                return BigInteger.valueOf((long) readInt);
            case -49:
                long readLong = readLong();
                if (readLong < 0) {
                    return BigInteger.valueOf(readLong + Long.MAX_VALUE + 1).setBit(63);
                }
                return BigInteger.valueOf(readLong);
            case -48:
                return BigInteger.valueOf((long) readByte());
            case -47:
                return BigInteger.valueOf((long) readShort());
            case -46:
                return BigInteger.valueOf((long) readInt());
            case -45:
                return BigInteger.valueOf(readLong());
            default:
                throw unexpected("Integer", readByte);
        }
    }

    public float unpackFloat() throws IOException {
        byte readByte = readByte();
        switch (readByte) {
            case -54:
                return readFloat();
            case -53:
                return (float) readDouble();
            default:
                throw unexpected("Float", readByte);
        }
    }

    public double unpackDouble() throws IOException {
        byte readByte = readByte();
        switch (readByte) {
            case -54:
                return (double) readFloat();
            case -53:
                return readDouble();
            default:
                throw unexpected("Float", readByte);
        }
    }

    private void resetDecoder() {
        if (this.decoder == null) {
            this.decodeBuffer = CharBuffer.allocate(this.stringDecoderBufferSize);
            this.decoder = MessagePack.UTF8.newDecoder().onMalformedInput(this.actionOnMalformedString).onUnmappableCharacter(this.actionOnUnmappableString);
        } else {
            this.decoder.reset();
        }
        if (this.decodeStringBuffer == null) {
            this.decodeStringBuffer = new StringBuilder();
        } else {
            this.decodeStringBuffer.setLength(0);
        }
    }

    /* JADX INFO: used method not loaded: org.msgpack.core.MessageFormatException.<init>(java.lang.String):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r3.throwException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0100, code lost:
        throw new org.msgpack.core.MessageFormatException("Unexpected UTF-8 multibyte sequence");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String unpackString() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.unpackRawStringHeader()
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = ""
            return r0
        L_0x0009:
            int r1 = r7.stringSizeLimit
            r2 = 0
            if (r0 > r1) goto L_0x012d
            r7.resetDecoder()
            org.msgpack.core.buffer.MessageBuffer r1 = r7.buffer
            int r1 = r1.size()
            int r3 = r7.position
            int r1 = r1 - r3
            if (r1 < r0) goto L_0x0021
            java.lang.String r0 = r7.decodeStringFastPath(r0)
            return r0
        L_0x0021:
            if (r0 <= 0) goto L_0x0120
            org.msgpack.core.buffer.MessageBuffer r1 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r1 = r1.size()     // Catch:{ CharacterCodingException -> 0x011e }
            int r3 = r7.position     // Catch:{ CharacterCodingException -> 0x011e }
            int r1 = r1 - r3
            if (r1 < r0) goto L_0x0039
            java.lang.StringBuilder r1 = r7.decodeStringBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.lang.String r0 = r7.decodeStringFastPath(r0)     // Catch:{ CharacterCodingException -> 0x011e }
            r1.append(r0)     // Catch:{ CharacterCodingException -> 0x011e }
            goto L_0x0120
        L_0x0039:
            if (r1 != 0) goto L_0x003f
            r7.nextBuffer()     // Catch:{ CharacterCodingException -> 0x011e }
            goto L_0x0021
        L_0x003f:
            org.msgpack.core.buffer.MessageBuffer r3 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r4 = r7.position     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.ByteBuffer r3 = r3.sliceAsByteBuffer(r4, r1)     // Catch:{ CharacterCodingException -> 0x011e }
            int r4 = r3.position()     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.CharBuffer r5 = r7.decodeBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            r5.clear()     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.charset.CharsetDecoder r5 = r7.decoder     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.CharBuffer r6 = r7.decodeBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.charset.CoderResult r5 = r5.decode(r3, r6, r2)     // Catch:{ CharacterCodingException -> 0x011e }
            int r3 = r3.position()     // Catch:{ CharacterCodingException -> 0x011e }
            int r3 = r3 - r4
            int r4 = r7.position     // Catch:{ CharacterCodingException -> 0x011e }
            int r4 = r4 + r3
            r7.position = r4     // Catch:{ CharacterCodingException -> 0x011e }
            int r0 = r0 - r3
            java.lang.StringBuilder r4 = r7.decodeStringBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.CharBuffer r6 = r7.decodeBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.Buffer r6 = r6.flip()     // Catch:{ CharacterCodingException -> 0x011e }
            r4.append(r6)     // Catch:{ CharacterCodingException -> 0x011e }
            boolean r4 = r5.isError()     // Catch:{ CharacterCodingException -> 0x011e }
            if (r4 == 0) goto L_0x0077
            r7.handleCoderError(r5)     // Catch:{ CharacterCodingException -> 0x011e }
        L_0x0077:
            boolean r4 = r5.isUnderflow()     // Catch:{ CharacterCodingException -> 0x011e }
            if (r4 == 0) goto L_0x0021
            if (r3 >= r1) goto L_0x0021
            org.msgpack.core.buffer.MessageBuffer r1 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r3 = r7.position     // Catch:{ CharacterCodingException -> 0x011e }
            byte r1 = r1.getByte(r3)     // Catch:{ CharacterCodingException -> 0x011e }
            int r1 = utf8MultibyteCharacterSize(r1)     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ CharacterCodingException -> 0x011e }
            org.msgpack.core.buffer.MessageBuffer r3 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r4 = r7.position     // Catch:{ CharacterCodingException -> 0x011e }
            org.msgpack.core.buffer.MessageBuffer r5 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r5 = r5.size()     // Catch:{ CharacterCodingException -> 0x011e }
            int r6 = r7.position     // Catch:{ CharacterCodingException -> 0x011e }
            int r5 = r5 - r6
            r3.getBytes(r4, r5, r1)     // Catch:{ CharacterCodingException -> 0x011e }
        L_0x009f:
            r7.nextBuffer()     // Catch:{ CharacterCodingException -> 0x011e }
            int r3 = r1.remaining()     // Catch:{ CharacterCodingException -> 0x011e }
            org.msgpack.core.buffer.MessageBuffer r4 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r4 = r4.size()     // Catch:{ CharacterCodingException -> 0x011e }
            if (r4 < r3) goto L_0x010a
            org.msgpack.core.buffer.MessageBuffer r4 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            r4.getBytes(r2, r3, r1)     // Catch:{ CharacterCodingException -> 0x011e }
            r7.position = r3     // Catch:{ CharacterCodingException -> 0x011e }
            r1.position(r2)     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.CharBuffer r3 = r7.decodeBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            r3.clear()     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.charset.CharsetDecoder r3 = r7.decoder     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.CharBuffer r4 = r7.decodeBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.charset.CoderResult r3 = r3.decode(r1, r4, r2)     // Catch:{ CharacterCodingException -> 0x011e }
            boolean r4 = r3.isError()     // Catch:{ CharacterCodingException -> 0x011e }
            if (r4 == 0) goto L_0x00ce
            r7.handleCoderError(r3)     // Catch:{ CharacterCodingException -> 0x011e }
        L_0x00ce:
            boolean r4 = r3.isOverflow()     // Catch:{ CharacterCodingException -> 0x011e }
            if (r4 != 0) goto L_0x00f6
            boolean r4 = r3.isUnderflow()     // Catch:{ CharacterCodingException -> 0x011e }
            if (r4 == 0) goto L_0x00e4
            int r4 = r1.position()     // Catch:{ CharacterCodingException -> 0x011e }
            int r5 = r1.limit()     // Catch:{ CharacterCodingException -> 0x011e }
            if (r4 < r5) goto L_0x00f6
        L_0x00e4:
            int r1 = r1.limit()     // Catch:{ CharacterCodingException -> 0x011e }
            int r0 = r0 - r1
            java.lang.StringBuilder r1 = r7.decodeStringBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.CharBuffer r3 = r7.decodeBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.nio.Buffer r3 = r3.flip()     // Catch:{ CharacterCodingException -> 0x011e }
            r1.append(r3)     // Catch:{ CharacterCodingException -> 0x011e }
            goto L_0x0021
        L_0x00f6:
            r3.throwException()     // Catch:{ Exception -> 0x0101 }
            org.msgpack.core.MessageFormatException r0 = new org.msgpack.core.MessageFormatException     // Catch:{ Exception -> 0x0101 }
            java.lang.String r1 = "Unexpected UTF-8 multibyte sequence"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0101 }
            throw r0     // Catch:{ Exception -> 0x0101 }
        L_0x0101:
            r0 = move-exception
            org.msgpack.core.MessageFormatException r1 = new org.msgpack.core.MessageFormatException     // Catch:{ CharacterCodingException -> 0x011e }
            java.lang.String r2 = "Unexpected UTF-8 multibyte sequence"
            r1.<init>(r2, r0)     // Catch:{ CharacterCodingException -> 0x011e }
            throw r1     // Catch:{ CharacterCodingException -> 0x011e }
        L_0x010a:
            org.msgpack.core.buffer.MessageBuffer r3 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            org.msgpack.core.buffer.MessageBuffer r4 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r4 = r4.size()     // Catch:{ CharacterCodingException -> 0x011e }
            r3.getBytes(r2, r4, r1)     // Catch:{ CharacterCodingException -> 0x011e }
            org.msgpack.core.buffer.MessageBuffer r3 = r7.buffer     // Catch:{ CharacterCodingException -> 0x011e }
            int r3 = r3.size()     // Catch:{ CharacterCodingException -> 0x011e }
            r7.position = r3     // Catch:{ CharacterCodingException -> 0x011e }
            goto L_0x009f
        L_0x011e:
            r0 = move-exception
            goto L_0x0127
        L_0x0120:
            java.lang.StringBuilder r0 = r7.decodeStringBuffer     // Catch:{ CharacterCodingException -> 0x011e }
            java.lang.String r0 = r0.toString()     // Catch:{ CharacterCodingException -> 0x011e }
            return r0
        L_0x0127:
            org.msgpack.core.MessageStringCodingException r1 = new org.msgpack.core.MessageStringCodingException
            r1.<init>(r0)
            throw r1
        L_0x012d:
            org.msgpack.core.MessageSizeException r1 = new org.msgpack.core.MessageSizeException
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r7.stringSizeLimit
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            r2 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r3[r2] = r4
            java.lang.String r2 = "cannot unpack a String of size larger than %,d: %,d"
            java.lang.String r2 = java.lang.String.format(r2, r3)
            long r3 = (long) r0
            r1.<init>(r2, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.msgpack.core.MessageUnpacker.unpackString():java.lang.String");
    }

    private void handleCoderError(CoderResult coderResult) throws CharacterCodingException {
        if ((coderResult.isMalformed() && this.actionOnMalformedString == CodingErrorAction.REPORT) || (coderResult.isUnmappable() && this.actionOnUnmappableString == CodingErrorAction.REPORT)) {
            coderResult.throwException();
        }
    }

    private String decodeStringFastPath(int i) {
        if (this.actionOnMalformedString == CodingErrorAction.REPLACE && this.actionOnUnmappableString == CodingErrorAction.REPLACE && this.buffer.hasArray()) {
            String str = new String(this.buffer.array(), this.buffer.arrayOffset() + this.position, i, MessagePack.UTF8);
            this.position += i;
            return str;
        }
        try {
            CharBuffer decode = this.decoder.decode(this.buffer.sliceAsByteBuffer(this.position, i));
            this.position += i;
            return decode.toString();
        } catch (CharacterCodingException e) {
            throw new MessageStringCodingException(e);
        }
    }

    public int unpackArrayHeader() throws IOException {
        byte readByte = readByte();
        if (Code.isFixedArray(readByte)) {
            return readByte & Ascii.f6734SI;
        }
        switch (readByte) {
            case -36:
                return readNextLength16();
            case -35:
                return readNextLength32();
            default:
                throw unexpected("Array", readByte);
        }
    }

    public int unpackMapHeader() throws IOException {
        byte readByte = readByte();
        if (Code.isFixedMap(readByte)) {
            return readByte & Ascii.f6734SI;
        }
        switch (readByte) {
            case -34:
                return readNextLength16();
            case -33:
                return readNextLength32();
            default:
                throw unexpected("Map", readByte);
        }
    }

    public ExtensionTypeHeader unpackExtensionTypeHeader() throws IOException {
        byte readByte = readByte();
        switch (readByte) {
            case -57:
                MessageBuffer prepareNumberBuffer = prepareNumberBuffer(2);
                return new ExtensionTypeHeader(prepareNumberBuffer.getByte(this.nextReadPosition + 1), prepareNumberBuffer.getByte(this.nextReadPosition) & UnsignedBytes.MAX_VALUE);
            case -56:
                MessageBuffer prepareNumberBuffer2 = prepareNumberBuffer(3);
                return new ExtensionTypeHeader(prepareNumberBuffer2.getByte(this.nextReadPosition + 2), prepareNumberBuffer2.getShort(this.nextReadPosition) & 65535);
            case -55:
                MessageBuffer prepareNumberBuffer3 = prepareNumberBuffer(5);
                int i = prepareNumberBuffer3.getInt(this.nextReadPosition);
                if (i >= 0) {
                    return new ExtensionTypeHeader(prepareNumberBuffer3.getByte(this.nextReadPosition + 4), i);
                }
                throw overflowU32Size(i);
            default:
                switch (readByte) {
                    case -44:
                        return new ExtensionTypeHeader(readByte(), 1);
                    case -43:
                        return new ExtensionTypeHeader(readByte(), 2);
                    case -42:
                        return new ExtensionTypeHeader(readByte(), 4);
                    case -41:
                        return new ExtensionTypeHeader(readByte(), 8);
                    case StateListener.INITIALIZATION_ERROR /*-40*/:
                        return new ExtensionTypeHeader(readByte(), 16);
                    default:
                        throw unexpected("Ext", readByte);
                }
        }
    }

    private int tryReadStringHeader(byte b) throws IOException {
        switch (b) {
            case -39:
                return readNextLength8();
            case -38:
                return readNextLength16();
            case -37:
                return readNextLength32();
            default:
                return -1;
        }
    }

    private int tryReadBinaryHeader(byte b) throws IOException {
        switch (b) {
            case -60:
                return readNextLength8();
            case -59:
                return readNextLength16();
            case -58:
                return readNextLength32();
            default:
                return -1;
        }
    }

    public int unpackRawStringHeader() throws IOException {
        byte readByte = readByte();
        if (Code.isFixedRaw(readByte)) {
            return readByte & Ascii.f6737US;
        }
        int tryReadStringHeader = tryReadStringHeader(readByte);
        if (tryReadStringHeader >= 0) {
            return tryReadStringHeader;
        }
        if (this.allowReadingBinaryAsString) {
            int tryReadBinaryHeader = tryReadBinaryHeader(readByte);
            if (tryReadBinaryHeader >= 0) {
                return tryReadBinaryHeader;
            }
        }
        throw unexpected("String", readByte);
    }

    public int unpackBinaryHeader() throws IOException {
        byte readByte = readByte();
        if (Code.isFixedRaw(readByte)) {
            return readByte & Ascii.f6737US;
        }
        int tryReadBinaryHeader = tryReadBinaryHeader(readByte);
        if (tryReadBinaryHeader >= 0) {
            return tryReadBinaryHeader;
        }
        if (this.allowReadingStringAsBinary) {
            int tryReadStringHeader = tryReadStringHeader(readByte);
            if (tryReadStringHeader >= 0) {
                return tryReadStringHeader;
            }
        }
        throw unexpected("Binary", readByte);
    }

    private void skipPayload(int i) throws IOException {
        while (true) {
            int size = this.buffer.size() - this.position;
            if (size >= i) {
                this.position += i;
                return;
            }
            this.position += size;
            i -= size;
            nextBuffer();
        }
    }

    public void readPayload(ByteBuffer byteBuffer) throws IOException {
        while (true) {
            int remaining = byteBuffer.remaining();
            int size = this.buffer.size() - this.position;
            if (size >= remaining) {
                this.buffer.getBytes(this.position, remaining, byteBuffer);
                this.position += remaining;
                return;
            }
            this.buffer.getBytes(this.position, size, byteBuffer);
            this.position += size;
            nextBuffer();
        }
    }

    public void readPayload(MessageBuffer messageBuffer, int i, int i2) throws IOException {
        while (true) {
            int size = this.buffer.size() - this.position;
            if (size >= i2) {
                messageBuffer.putMessageBuffer(i, this.buffer, this.position, i2);
                this.position += i2;
                return;
            }
            messageBuffer.putMessageBuffer(i, this.buffer, this.position, size);
            i += size;
            i2 -= size;
            this.position += size;
            nextBuffer();
        }
    }

    public void readPayload(byte[] bArr) throws IOException {
        readPayload(bArr, 0, bArr.length);
    }

    public byte[] readPayload(int i) throws IOException {
        byte[] bArr = new byte[i];
        readPayload(bArr);
        return bArr;
    }

    public void readPayload(byte[] bArr, int i, int i2) throws IOException {
        readPayload(MessageBuffer.wrap(bArr), i, i2);
    }

    public MessageBuffer readPayloadAsReference(int i) throws IOException {
        if (this.buffer.size() - this.position >= i) {
            MessageBuffer slice = this.buffer.slice(this.position, i);
            this.position += i;
            return slice;
        }
        MessageBuffer allocate = MessageBuffer.allocate(i);
        readPayload(allocate, 0, i);
        return allocate;
    }

    private int readNextLength8() throws IOException {
        return readByte() & UnsignedBytes.MAX_VALUE;
    }

    private int readNextLength16() throws IOException {
        return readShort() & 65535;
    }

    private int readNextLength32() throws IOException {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw overflowU32Size(readInt);
    }

    public void close() throws IOException {
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.f9912in.close();
    }

    private static MessageIntegerOverflowException overflowU8(byte b) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) (b & UnsignedBytes.MAX_VALUE)));
    }

    private static MessageIntegerOverflowException overflowU16(short s) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) (s & 65535)));
    }

    private static MessageIntegerOverflowException overflowU32(int i) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(((long) (i & BaseClientBuilder.API_PRIORITY_OTHER)) + 2147483648L));
    }

    private static MessageIntegerOverflowException overflowU64(long j) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(j + Long.MAX_VALUE + 1).setBit(63));
    }

    private static MessageIntegerOverflowException overflowI16(short s) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) s));
    }

    private static MessageIntegerOverflowException overflowI32(int i) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((long) i));
    }

    private static MessageIntegerOverflowException overflowI64(long j) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(j));
    }

    private static MessageSizeException overflowU32Size(int i) {
        return new MessageSizeException(((long) (i & BaseClientBuilder.API_PRIORITY_OTHER)) + 2147483648L);
    }
}
