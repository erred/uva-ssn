package com.bridgefy.sdk.client;

import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CryptoRSA {
    /* renamed from: a */
    static HashMap<String, String> m7670a() throws NoSuchAlgorithmException {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(2048);
        KeyPair generateKeyPair = instance.generateKeyPair();
        String base64StringFromBytes = base64StringFromBytes(generateKeyPair.getPublic().getEncoded());
        String base64StringFromBytes2 = base64StringFromBytes(generateKeyPair.getPrivate().getEncoded());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tirmo", base64StringFromBytes.trim().replaceAll("[\n\r]", ""));
        hashMap.put("satya", base64StringFromBytes2.trim().replaceAll("[\n\r]", ""));
        return hashMap;
    }

    public static byte[] encrypt(String str, byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        int i = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (i < bArr.length) {
                int i2 = 245;
                int length = bArr.length - i;
                if (length <= 245) {
                    i2 = length;
                }
                int i3 = i2 + i;
                byteArrayOutputStream.write(m7671a(str, Arrays.copyOfRange(bArr, i, i3)));
                i = i3;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Encryption failed ");
            sb.append(e.getMessage());
            Log.e("CryptoRSA", sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m7671a(String str, byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytesFromBase64(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePublic);
        return instance.doFinal(bArr);
    }

    public static byte[] decrypt(String str, byte[] bArr) throws NoSuchProviderException, IOException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException {
        int i = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (i < bArr.length) {
                int i2 = 256;
                int length = bArr.length - i;
                if (length <= 256) {
                    i2 = length;
                }
                int i3 = i2 + i;
                byteArrayOutputStream.write(m7672b(str, Arrays.copyOfRange(bArr, i, i3)));
                i = i3;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("decrypt: decryption error");
            sb.append(e.getMessage());
            Log.e("CryptoRSA", sb.toString());
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m7672b(String str, byte[] bArr) throws NoSuchProviderException, IOException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytesFromBase64(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePrivate);
        return instance.doFinal(bArr);
    }

    public static boolean verifyData(byte[] bArr, byte[] bArr2, String str) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, InvalidKeySpecException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytesFromBase64(str)));
        Signature instance = Signature.getInstance("SHA256withRSA");
        instance.initVerify(generatePublic);
        instance.update(bArr);
        return instance.verify(bArr2);
    }

    public static byte[] bytesFromBase64(String str) {
        return Base64.decode(clean_base64(str), 0);
    }

    /* renamed from: a */
    private static String clean_base64(String str) {
        return str.replaceAll("[^a-zA-Z0-9+/=]", "").split("==")[0];
    }

    public static String base64StringFromBytes(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    public static String decodeBase64StringFromString(String str) {
        return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
    }
}
