package org.msgpack.core.buffer;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;
import sun.misc.Unsafe;

public class MessageBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ARRAY_BYTE_BASE_OFFSET;
    private static final String BIGENDIAN_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferBE";
    private static final String DEFAULT_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBuffer";
    private static final String UNIVERSAL_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferU";
    static final boolean isUniversalBuffer;
    private static final Constructor<?> mbArrConstructor;
    private static final Constructor<?> mbBBConstructor;
    static final Unsafe unsafe;
    protected final long address;
    protected final Object base;
    protected final ByteBuffer reference;
    protected final int size;

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01ad, code lost:
        if (java.nio.ByteOrder.nativeOrder() == java.nio.ByteOrder.LITTLE_ENDIAN) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01af, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01b1, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01b2, code lost:
        if (r0 != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01b4, code lost:
        r0 = DEFAULT_MESSAGE_BUFFER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01b7, code lost:
        r0 = BIGENDIAN_MESSAGE_BUFFER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01ba, code lost:
        r0 = UNIVERSAL_MESSAGE_BUFFER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x013c, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x013d, code lost:
        r7 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061 A[Catch:{ Exception -> 0x013f, all -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[Catch:{ Exception -> 0x013f, all -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0153  */
    static {
        /*
            r0 = 16
            r1 = 0
            r2 = 2
            r3 = 3
            r4 = 0
            r5 = 1
            java.lang.String r6 = "java.specification.version"
            java.lang.String r7 = ""
            java.lang.String r6 = java.lang.System.getProperty(r6, r7)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            r7 = 46
            int r7 = r6.indexOf(r7)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            r8 = -1
            if (r7 == r8) goto L_0x0031
            java.lang.String r8 = r6.substring(r4, r7)     // Catch:{ NumberFormatException -> 0x0035 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0035 }
            int r7 = r7 + r5
            java.lang.String r6 = r6.substring(r7)     // Catch:{ NumberFormatException -> 0x0035 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x0035 }
            if (r8 > r5) goto L_0x0033
            if (r8 != r5) goto L_0x0031
            r7 = 7
            if (r6 < r7) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r6 = 0
            goto L_0x003c
        L_0x0033:
            r6 = 1
            goto L_0x003c
        L_0x0035:
            r6 = move-exception
            java.io.PrintStream r7 = java.lang.System.err     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            r6.printStackTrace(r7)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            goto L_0x0031
        L_0x003c:
            java.lang.String r7 = "sun.misc.Unsafe"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ Exception -> 0x0046, all -> 0x013c }
            if (r7 == 0) goto L_0x0046
            r7 = 1
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            java.lang.String r8 = "java.runtime.name"
            java.lang.String r9 = ""
            java.lang.String r8 = java.lang.System.getProperty(r8, r9)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            java.lang.String r9 = "android"
            boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            java.lang.String r9 = "com.google.appengine.runtime.version"
            java.lang.String r9 = java.lang.System.getProperty(r9)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            if (r9 == 0) goto L_0x0063
            r9 = 1
            goto L_0x0064
        L_0x0063:
            r9 = 0
        L_0x0064:
            java.lang.String r10 = "msgpack.universal-buffer"
            java.lang.String r11 = "false"
            java.lang.String r10 = java.lang.System.getProperty(r10, r11)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            boolean r10 = java.lang.Boolean.parseBoolean(r10)     // Catch:{ Exception -> 0x013f, all -> 0x013c }
            if (r10 != 0) goto L_0x007d
            if (r8 != 0) goto L_0x007d
            if (r9 != 0) goto L_0x007d
            if (r6 == 0) goto L_0x007d
            if (r7 != 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r6 = 0
            goto L_0x007e
        L_0x007d:
            r6 = 1
        L_0x007e:
            if (r6 != 0) goto L_0x00e6
            java.lang.Class<sun.misc.Unsafe> r7 = sun.misc.Unsafe.class
            java.lang.String r8 = "theUnsafe"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r8)     // Catch:{ Exception -> 0x00e1, all -> 0x00db }
            r7.setAccessible(r5)     // Catch:{ Exception -> 0x00e1, all -> 0x00db }
            java.lang.Object r7 = r7.get(r1)     // Catch:{ Exception -> 0x00e1, all -> 0x00db }
            sun.misc.Unsafe r7 = (sun.misc.Unsafe) r7     // Catch:{ Exception -> 0x00e1, all -> 0x00db }
            if (r7 == 0) goto L_0x00c5
            java.lang.Class<byte[]> r1 = byte[].class
            int r1 = r7.arrayBaseOffset(r1)     // Catch:{ Exception -> 0x00d4, all -> 0x00cd }
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = r7.arrayIndexScale(r0)     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            if (r0 != r5) goto L_0x00a4
            r0 = r1
            r1 = r7
            goto L_0x00e6
        L_0x00a4:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            r9.<init>()     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            java.lang.String r10 = "Byte array index scale must be 1, but is "
            r9.append(r10)     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            r9.append(r0)     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            r8.<init>(r0)     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
            throw r8     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            r12 = r6
            r6 = r0
            r0 = r1
            goto L_0x00d0
        L_0x00c0:
            r0 = move-exception
            r12 = r6
            r6 = r0
            r0 = r1
            goto L_0x00d7
        L_0x00c5:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x00d4, all -> 0x00cd }
            java.lang.String r8 = "Unsafe is unavailable"
            r1.<init>(r8)     // Catch:{ Exception -> 0x00d4, all -> 0x00cd }
            throw r1     // Catch:{ Exception -> 0x00d4, all -> 0x00cd }
        L_0x00cd:
            r1 = move-exception
            r12 = r6
            r6 = r1
        L_0x00d0:
            r1 = r7
            r7 = r12
            goto L_0x019d
        L_0x00d4:
            r1 = move-exception
            r12 = r6
            r6 = r1
        L_0x00d7:
            r1 = r7
            r7 = r12
            goto L_0x0141
        L_0x00db:
            r7 = move-exception
            r12 = r7
            r7 = r6
            r6 = r12
            goto L_0x019d
        L_0x00e1:
            r7 = move-exception
            r12 = r7
            r7 = r6
            r6 = r12
            goto L_0x0141
        L_0x00e6:
            unsafe = r1
            ARRAY_BYTE_BASE_OFFSET = r0
            isUniversalBuffer = r6
            boolean r0 = isUniversalBuffer
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBufferU"
            goto L_0x0105
        L_0x00f3:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r1) goto L_0x00fd
            r0 = 1
            goto L_0x00fe
        L_0x00fd:
            r0 = 0
        L_0x00fe:
            if (r0 == 0) goto L_0x0103
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBuffer"
            goto L_0x0105
        L_0x0103:
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBufferBE"
        L_0x0105:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0130 }
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0130 }
            java.lang.Class<byte[]> r3 = byte[].class
            r1[r4] = r3     // Catch:{ Exception -> 0x0130 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0130 }
            r1[r5] = r3     // Catch:{ Exception -> 0x0130 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0130 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0130 }
            java.lang.reflect.Constructor r1 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x0130 }
            r1.setAccessible(r5)     // Catch:{ Exception -> 0x0130 }
            mbArrConstructor = r1     // Catch:{ Exception -> 0x0130 }
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0130 }
            java.lang.Class<java.nio.ByteBuffer> r2 = java.nio.ByteBuffer.class
            r1[r4] = r2     // Catch:{ Exception -> 0x0130 }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x0130 }
            r0.setAccessible(r5)     // Catch:{ Exception -> 0x0130 }
            mbBBConstructor = r0     // Catch:{ Exception -> 0x0130 }
            goto L_0x018f
        L_0x0130:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            r0.printStackTrace(r1)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x013c:
            r6 = move-exception
            r7 = 0
            goto L_0x019d
        L_0x013f:
            r6 = move-exception
            r7 = 0
        L_0x0141:
            java.io.PrintStream r8 = java.lang.System.err     // Catch:{ all -> 0x019c }
            r6.printStackTrace(r8)     // Catch:{ all -> 0x019c }
            unsafe = r1
            ARRAY_BYTE_BASE_OFFSET = r0
            isUniversalBuffer = r5
            boolean r0 = isUniversalBuffer
            if (r0 == 0) goto L_0x0153
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBufferU"
            goto L_0x0165
        L_0x0153:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r1) goto L_0x015d
            r0 = 1
            goto L_0x015e
        L_0x015d:
            r0 = 0
        L_0x015e:
            if (r0 == 0) goto L_0x0163
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBuffer"
            goto L_0x0165
        L_0x0163:
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBufferBE"
        L_0x0165:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0190 }
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0190 }
            java.lang.Class<byte[]> r3 = byte[].class
            r1[r4] = r3     // Catch:{ Exception -> 0x0190 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0190 }
            r1[r5] = r3     // Catch:{ Exception -> 0x0190 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0190 }
            r1[r2] = r3     // Catch:{ Exception -> 0x0190 }
            java.lang.reflect.Constructor r1 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x0190 }
            r1.setAccessible(r5)     // Catch:{ Exception -> 0x0190 }
            mbArrConstructor = r1     // Catch:{ Exception -> 0x0190 }
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0190 }
            java.lang.Class<java.nio.ByteBuffer> r2 = java.nio.ByteBuffer.class
            r1[r4] = r2     // Catch:{ Exception -> 0x0190 }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x0190 }
            r0.setAccessible(r5)     // Catch:{ Exception -> 0x0190 }
            mbBBConstructor = r0     // Catch:{ Exception -> 0x0190 }
        L_0x018f:
            return
        L_0x0190:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            r0.printStackTrace(r1)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x019c:
            r6 = move-exception
        L_0x019d:
            unsafe = r1
            ARRAY_BYTE_BASE_OFFSET = r0
            isUniversalBuffer = r7
            boolean r0 = isUniversalBuffer
            if (r0 != 0) goto L_0x01ba
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r1) goto L_0x01b1
            r0 = 1
            goto L_0x01b2
        L_0x01b1:
            r0 = 0
        L_0x01b2:
            if (r0 == 0) goto L_0x01b7
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBuffer"
            goto L_0x01bc
        L_0x01b7:
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBufferBE"
            goto L_0x01bc
        L_0x01ba:
            java.lang.String r0 = "org.msgpack.core.buffer.MessageBufferU"
        L_0x01bc:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x01e7 }
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x01e7 }
            java.lang.Class<byte[]> r3 = byte[].class
            r1[r4] = r3     // Catch:{ Exception -> 0x01e7 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x01e7 }
            r1[r5] = r3     // Catch:{ Exception -> 0x01e7 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x01e7 }
            r1[r2] = r3     // Catch:{ Exception -> 0x01e7 }
            java.lang.reflect.Constructor r1 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x01e7 }
            r1.setAccessible(r5)     // Catch:{ Exception -> 0x01e7 }
            mbArrConstructor = r1     // Catch:{ Exception -> 0x01e7 }
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x01e7 }
            java.lang.Class<java.nio.ByteBuffer> r2 = java.nio.ByteBuffer.class
            r1[r4] = r2     // Catch:{ Exception -> 0x01e7 }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x01e7 }
            r0.setAccessible(r5)     // Catch:{ Exception -> 0x01e7 }
            mbBBConstructor = r0     // Catch:{ Exception -> 0x01e7 }
            throw r6
        L_0x01e7:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            r0.printStackTrace(r1)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.msgpack.core.buffer.MessageBuffer.<clinit>():void");
    }

    public static MessageBuffer allocate(int i) {
        if (i >= 0) {
            return wrap(new byte[i]);
        }
        throw new IllegalArgumentException("size must not be negative");
    }

    public static MessageBuffer wrap(byte[] bArr) {
        return newMessageBuffer(bArr, 0, bArr.length);
    }

    public static MessageBuffer wrap(byte[] bArr, int i, int i2) {
        return newMessageBuffer(bArr, i, i2);
    }

    public static MessageBuffer wrap(ByteBuffer byteBuffer) {
        return newMessageBuffer(byteBuffer);
    }

    private static MessageBuffer newMessageBuffer(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        return newInstance(mbArrConstructor, bArr, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private static MessageBuffer newMessageBuffer(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        return newInstance(mbBBConstructor, byteBuffer);
    }

    private static MessageBuffer newInstance(Constructor<?> constructor, Object... objArr) {
        try {
            return (MessageBuffer) constructor.newInstance(objArr);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            } else if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            } else {
                throw new IllegalStateException(e3.getCause());
            }
        }
    }

    public static void releaseBuffer(MessageBuffer messageBuffer) {
        if (!isUniversalBuffer && !messageBuffer.hasArray()) {
            if (DirectBufferAccess.isDirectByteBufferInstance(messageBuffer.reference)) {
                DirectBufferAccess.clean(messageBuffer.reference);
            } else {
                unsafe.freeMemory(messageBuffer.address);
            }
        }
    }

    MessageBuffer(byte[] bArr, int i, int i2) {
        this.base = bArr;
        this.address = (long) (ARRAY_BYTE_BASE_OFFSET + i);
        this.size = i2;
        this.reference = null;
    }

    MessageBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            if (!isUniversalBuffer) {
                this.base = null;
                this.address = DirectBufferAccess.getAddress(byteBuffer) + ((long) byteBuffer.position());
                this.size = byteBuffer.remaining();
                this.reference = byteBuffer;
                return;
            }
            throw new UnsupportedOperationException("Cannot create MessageBuffer from a DirectBuffer on this platform");
        } else if (byteBuffer.hasArray()) {
            this.base = byteBuffer.array();
            this.address = (long) (ARRAY_BYTE_BASE_OFFSET + byteBuffer.arrayOffset() + byteBuffer.position());
            this.size = byteBuffer.remaining();
            this.reference = null;
        } else {
            throw new IllegalArgumentException("Only the array-backed ByteBuffer or DirectBuffer is supported");
        }
    }

    protected MessageBuffer(Object obj, long j, int i) {
        this.base = obj;
        this.address = j;
        this.size = i;
        this.reference = null;
    }

    public int size() {
        return this.size;
    }

    public MessageBuffer slice(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        Preconditions.checkArgument(i + i2 <= size());
        return new MessageBuffer(this.base, this.address + ((long) i), i2);
    }

    public byte getByte(int i) {
        return unsafe.getByte(this.base, this.address + ((long) i));
    }

    public boolean getBoolean(int i) {
        return unsafe.getBoolean(this.base, this.address + ((long) i));
    }

    public short getShort(int i) {
        return Short.reverseBytes(unsafe.getShort(this.base, this.address + ((long) i)));
    }

    public int getInt(int i) {
        return Integer.reverseBytes(unsafe.getInt(this.base, this.address + ((long) i)));
    }

    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    public long getLong(int i) {
        return Long.reverseBytes(unsafe.getLong(this.base, this.address + ((long) i)));
    }

    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        unsafe.copyMemory(this.base, this.address + ((long) i), bArr, (long) (ARRAY_BYTE_BASE_OFFSET + i2), (long) i3);
    }

    public void getBytes(int i, int i2, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= i2) {
            byteBuffer.put(sliceAsByteBuffer(i, i2));
            return;
        }
        throw new BufferOverflowException();
    }

    public void putByte(int i, byte b) {
        unsafe.putByte(this.base, this.address + ((long) i), b);
    }

    public void putBoolean(int i, boolean z) {
        unsafe.putBoolean(this.base, this.address + ((long) i), z);
    }

    public void putShort(int i, short s) {
        unsafe.putShort(this.base, this.address + ((long) i), Short.reverseBytes(s));
    }

    public void putInt(int i, int i2) {
        unsafe.putInt(this.base, this.address + ((long) i), Integer.reverseBytes(i2));
    }

    public void putFloat(int i, float f) {
        putInt(i, Float.floatToRawIntBits(f));
    }

    public void putLong(int i, long j) {
        unsafe.putLong(this.base, ((long) i) + this.address, Long.reverseBytes(j));
    }

    public void putDouble(int i, double d) {
        putLong(i, Double.doubleToRawLongBits(d));
    }

    public void putBytes(int i, byte[] bArr, int i2, int i3) {
        unsafe.copyMemory(bArr, (long) (ARRAY_BYTE_BASE_OFFSET + i2), this.base, this.address + ((long) i), (long) i3);
    }

    public void putByteBuffer(int i, ByteBuffer byteBuffer, int i2) {
        if (byteBuffer.isDirect()) {
            unsafe.copyMemory(null, DirectBufferAccess.getAddress(byteBuffer) + ((long) byteBuffer.position()), this.base, this.address + ((long) i), (long) i2);
            byteBuffer.position(byteBuffer.position() + i2);
        } else if (byteBuffer.hasArray()) {
            unsafe.copyMemory(byteBuffer.array(), (long) (ARRAY_BYTE_BASE_OFFSET + byteBuffer.position()), this.base, this.address + ((long) i), (long) i2);
            byteBuffer.position(byteBuffer.position() + i2);
        } else if (hasArray()) {
            byteBuffer.get((byte[]) this.base, i, i2);
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                unsafe.putByte(this.base, this.address + ((long) i), byteBuffer.get());
            }
        }
    }

    public void putMessageBuffer(int i, MessageBuffer messageBuffer, int i2, int i3) {
        unsafe.copyMemory(messageBuffer.base, messageBuffer.address + ((long) i2), this.base, ((long) i) + this.address, (long) i3);
    }

    public ByteBuffer sliceAsByteBuffer(int i, int i2) {
        if (hasArray()) {
            return ByteBuffer.wrap((byte[]) this.base, (int) ((this.address - ((long) ARRAY_BYTE_BASE_OFFSET)) + ((long) i)), i2);
        }
        return DirectBufferAccess.newByteBuffer(this.address, i, i2, this.reference);
    }

    public ByteBuffer sliceAsByteBuffer() {
        return sliceAsByteBuffer(0, size());
    }

    public boolean hasArray() {
        return this.base != null;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        unsafe.copyMemory(this.base, this.address, bArr, (long) ARRAY_BYTE_BASE_OFFSET, (long) size());
        return bArr;
    }

    public byte[] array() {
        return (byte[]) this.base;
    }

    public int arrayOffset() {
        return ((int) this.address) - ARRAY_BYTE_BASE_OFFSET;
    }

    public void copyTo(int i, MessageBuffer messageBuffer, int i2, int i3) {
        unsafe.copyMemory(this.base, this.address + ((long) i), messageBuffer.base, ((long) i2) + messageBuffer.address, (long) i3);
    }

    public String toHexString(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i2; i3++) {
            if (i3 != i) {
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(getByte(i3))}));
        }
        return sb.toString();
    }
}
