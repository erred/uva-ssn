package org.msgpack.core.buffer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

class DirectBufferAccess {
    static Constructor byteBufferConstructor;
    static DirectBufferConstructorType directBufferConstructorType;
    static Class<?> directByteBufferClass;
    static Method mClean;
    static Method mCleaner;
    static Method mGetAddress;
    static Method memoryBlockWrapFromJni;

    enum DirectBufferConstructorType {
        ARGS_LONG_INT_REF,
        ARGS_LONG_INT,
        ARGS_INT_INT,
        ARGS_MB_INT_INT
    }

    private DirectBufferAccess() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|13|(2:15|16)(2:17|18)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003b */
    static {
        /*
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r1 = "java.nio.DirectByteBuffer"
            java.lang.Class r0 = r0.loadClass(r1)     // Catch:{ Exception -> 0x00cd }
            directByteBufferClass = r0     // Catch:{ Exception -> 0x00cd }
            r0 = 0
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            java.lang.Class<?> r5 = directByteBufferClass     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r6[r3] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r6[r4] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r6[r2] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r6)     // Catch:{ NoSuchMethodException -> 0x0028 }
            org.msgpack.core.buffer.DirectBufferAccess$DirectBufferConstructorType r6 = org.msgpack.core.buffer.DirectBufferAccess.DirectBufferConstructorType.ARGS_LONG_INT_REF     // Catch:{ NoSuchMethodException -> 0x0028 }
            goto L_0x007e
        L_0x0028:
            java.lang.Class<?> r5 = directByteBufferClass     // Catch:{ NoSuchMethodException -> 0x003b }
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x003b }
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ NoSuchMethodException -> 0x003b }
            r6[r3] = r7     // Catch:{ NoSuchMethodException -> 0x003b }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x003b }
            r6[r4] = r7     // Catch:{ NoSuchMethodException -> 0x003b }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r6)     // Catch:{ NoSuchMethodException -> 0x003b }
            org.msgpack.core.buffer.DirectBufferAccess$DirectBufferConstructorType r6 = org.msgpack.core.buffer.DirectBufferAccess.DirectBufferConstructorType.ARGS_LONG_INT     // Catch:{ NoSuchMethodException -> 0x003b }
            goto L_0x007e
        L_0x003b:
            java.lang.Class<?> r5 = directByteBufferClass     // Catch:{ NoSuchMethodException -> 0x004e }
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x004e }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x004e }
            r6[r3] = r7     // Catch:{ NoSuchMethodException -> 0x004e }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x004e }
            r6[r4] = r7     // Catch:{ NoSuchMethodException -> 0x004e }
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r6)     // Catch:{ NoSuchMethodException -> 0x004e }
            org.msgpack.core.buffer.DirectBufferAccess$DirectBufferConstructorType r6 = org.msgpack.core.buffer.DirectBufferAccess.DirectBufferConstructorType.ARGS_INT_INT     // Catch:{ NoSuchMethodException -> 0x004e }
            goto L_0x007e
        L_0x004e:
            java.lang.String r0 = "java.nio.MemoryBlock"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r5 = "wrapFromJni"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00cd }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00cd }
            r6[r3] = r7     // Catch:{ Exception -> 0x00cd }
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x00cd }
            r6[r4] = r7     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r5, r6)     // Catch:{ Exception -> 0x00cd }
            r5.setAccessible(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.Class<?> r6 = directByteBufferClass     // Catch:{ Exception -> 0x00cd }
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00cd }
            r1[r3] = r0     // Catch:{ Exception -> 0x00cd }
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00cd }
            r1[r4] = r0     // Catch:{ Exception -> 0x00cd }
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00cd }
            r1[r2] = r0     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Constructor r0 = r6.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x00cd }
            org.msgpack.core.buffer.DirectBufferAccess$DirectBufferConstructorType r6 = org.msgpack.core.buffer.DirectBufferAccess.DirectBufferConstructorType.ARGS_MB_INT_INT     // Catch:{ Exception -> 0x00cd }
            r8 = r5
            r5 = r0
            r0 = r8
        L_0x007e:
            byteBufferConstructor = r5     // Catch:{ Exception -> 0x00cd }
            directBufferConstructorType = r6     // Catch:{ Exception -> 0x00cd }
            memoryBlockWrapFromJni = r0     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Constructor r0 = byteBufferConstructor     // Catch:{ Exception -> 0x00cd }
            if (r0 == 0) goto L_0x00c5
            java.lang.reflect.Constructor r0 = byteBufferConstructor     // Catch:{ Exception -> 0x00cd }
            r0.setAccessible(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.Class<?> r0 = directByteBufferClass     // Catch:{ Exception -> 0x00cd }
            java.lang.String r1 = "address"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x00cd }
            mGetAddress = r0     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r0 = mGetAddress     // Catch:{ Exception -> 0x00cd }
            r0.setAccessible(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.Class<?> r0 = directByteBufferClass     // Catch:{ Exception -> 0x00cd }
            java.lang.String r1 = "cleaner"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x00cd }
            mCleaner = r0     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r0 = mCleaner     // Catch:{ Exception -> 0x00cd }
            r0.setAccessible(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r0 = mCleaner     // Catch:{ Exception -> 0x00cd }
            java.lang.Class r0 = r0.getReturnType()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r1 = "clean"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x00cd }
            mClean = r0     // Catch:{ Exception -> 0x00cd }
            java.lang.reflect.Method r0 = mClean     // Catch:{ Exception -> 0x00cd }
            r0.setAccessible(r4)     // Catch:{ Exception -> 0x00cd }
            return
        L_0x00c5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x00cd }
            java.lang.String r1 = "Constructor of DirectByteBuffer is not found"
            r0.<init>(r1)     // Catch:{ Exception -> 0x00cd }
            throw r0     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.msgpack.core.buffer.DirectBufferAccess.<clinit>():void");
    }

    static long getAddress(Object obj) {
        try {
            return ((Long) mGetAddress.invoke(obj, new Object[0])).longValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    static void clean(Object obj) {
        try {
            mClean.invoke(mCleaner.invoke(obj, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    static boolean isDirectByteBufferInstance(Object obj) {
        return directByteBufferClass.isInstance(obj);
    }

    static ByteBuffer newByteBuffer(long j, int i, int i2, ByteBuffer byteBuffer) {
        try {
            switch (directBufferConstructorType) {
                case ARGS_LONG_INT_REF:
                    return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{Long.valueOf(j + ((long) i)), Integer.valueOf(i2), byteBuffer});
                case ARGS_LONG_INT:
                    return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{Long.valueOf(j + ((long) i)), Integer.valueOf(i2)});
                case ARGS_INT_INT:
                    return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{Integer.valueOf(((int) j) + i), Integer.valueOf(i2)});
                case ARGS_MB_INT_INT:
                    return (ByteBuffer) byteBufferConstructor.newInstance(new Object[]{memoryBlockWrapFromJni.invoke(null, new Object[]{Long.valueOf(j + ((long) i)), Integer.valueOf(i2)}), Integer.valueOf(i2), Integer.valueOf(0)});
                default:
                    throw new IllegalStateException("Unexpected value");
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
