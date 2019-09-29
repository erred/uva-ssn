package com.bridgefy.sdk.framework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.zip.CRC32;
import org.msgpack.p158a.p159a.C3700c;

public class Utils {

    /* renamed from: a */
    private static CRC32 f6066a = new CRC32();

    private Utils() {
    }

    public static String generateSessionId() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    public static synchronized String generateRandomString(int i) {
        String sb;
        synchronized (Utils.class) {
            if (i >= 1) {
                Random random = new Random();
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < i; i2++) {
                    sb2.append((char) random.nextInt(65535));
                }
                sb = sb2.toString();
            } else {
                throw new IllegalArgumentException("Length cannot be minor to 1.");
            }
        }
        return sb;
    }

    public static synchronized void sendBroadcastAction(Context context, String str, Bundle bundle) {
        synchronized (Utils.class) {
        }
    }

    public static long getCrcFromKey(String str) {
        long value;
        synchronized (f6066a) {
            f6066a.reset();
            byte[] bytes = str.trim().replaceAll("[\n\r]", "").getBytes();
            f6066a.update(bytes, 0, bytes.length);
            value = f6066a.getValue();
        }
        return value;
    }

    public static boolean equalCRCKeys(String str, String str2) {
        return getCrcFromKey(str) == getCrcFromKey(str2);
    }

    public static boolean isWifiConnected(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    public static Object executePrivateMethod(Object obj, Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, objArr);
            declaredMethod.setAccessible(false);
            return invoke;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void saveToInternalStorage(byte[] bArr, String str, Context context) throws IOException {
        FileOutputStream openFileOutput = context.openFileOutput("fn", 0);
        openFileOutput.write(bArr);
        openFileOutput.close();
    }

    public static String readFromInternalStorage(String str, Context context) throws IOException {
        FileInputStream openFileInput = context.openFileInput(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sb2 = sb.toString();
        openFileInput.close();
        return sb2;
    }

    public static <T> byte[] fromEntityToMessagePack(T t) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper((JsonFactory) new C3700c());
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        return objectMapper.writeValueAsBytes(t);
    }

    public static <T> T fromMessagePacktoEntity(byte[] bArr, Class<T> cls) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper((JsonFactory) new C3700c());
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return objectMapper.readValue(bArr, cls);
    }

    public static Object getBuildConfigValue(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".BuildConfig");
            return Class.forName(sb.toString()).getField(str).get(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static byte[] fromStringRepresentedArrayToByteArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "[,]");
        byte[] bArr = new byte[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            bArr[i] = (byte) Double.valueOf(stringTokenizer.nextToken().trim()).intValue();
            i++;
        }
        return bArr;
    }

    public static boolean lengthOfDataAllowed(byte[] bArr) {
        boolean z = false;
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        if ((((long) bArr.length) / 1024) / 1024 < 2) {
            z = true;
        }
        return z;
    }
}
