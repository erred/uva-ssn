package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.CryptoRSA;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.entities.BleEntityContent;
import com.bridgefy.sdk.framework.entities.ForwardPacket;
import com.bridgefy.sdk.framework.entities.ForwardTransaction;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import com.bridgefy.sdk.framework.utils.Utils;
import com.google.gson.Gson;
import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.p154a.C3688b;
import org.apache.commons.p156b.C3689a;

/* renamed from: com.bridgefy.sdk.framework.controller.q */
class chunk_utils {
    /* renamed from: a */
    // z ? messagepack : json
    static ArrayList<byte[]> generate_compressed_chunk(BleEntity bleEntity, int i, boolean z, boolean z2, String str) throws IOException, MessageException {
        int i2;
        BleEntity bleEntity2 = bleEntity;
        int i3 = i;
        ArrayList<byte[]> arrayList = new ArrayList<>();
        byte[] bArr = null;
        if (bleEntity.getEt() == 3) {
            ArrayList arrayList2 = new ArrayList();
            ForwardTransaction forwardTransaction = (ForwardTransaction) bleEntity.getCt();
            bleEntity2.setCt(null);
            if (forwardTransaction.getMesh_reach() == null) {
                ArrayList arrayList3 = new ArrayList();
                for (ForwardPacket forwardPacket : forwardTransaction.getMesh()) {
                    if (z2) {
                        try {
                            if (forwardPacket.getReceiver_type() != 1) {
                                if (forwardPacket.getForwardedPayload() != null) {
                                    arrayList2.add(forwardPacket.getForwardedPayload());
                                    forwardPacket.setPayload(null);
                                    forwardPacket.setEnc_payload(arrayList2.size() - 1);
                                } else {
                                    HashMap payload = forwardPacket.getPayload();
                                    if (payload == null || payload.size() <= 0) {
                                        arrayList3.add(forwardPacket);
                                    } else {
                                        arrayList2.add(CryptoRSA.encrypt(get_corresponding_key(forwardPacket.getReceiver()), gzip_byte_stream(Utils.fromEntityToMessagePack(payload))));
                                        forwardPacket.setPayload(null);
                                        forwardPacket.setEnc_payload(arrayList2.size() - 1);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("generateCompressedChunk: UNABLE TO ENCRYPT OR COMPRESS ");
                            sb.append(e.getMessage());
                            Log.e("ChunkUtils", sb.toString(), e);
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    forwardTransaction.getMesh().removeAll(arrayList3);
                }
            }
            bArr = byte_arraylist_to_byte_arrayb.serialize(arrayList2);
            i2 = bArr.length;
            bleEntity2.setCt(forwardTransaction);
        } else {
            i2 = 0;
        }
        if (z2 && bleEntity.getEt() == 1 && z) {
            try {
                Log.v("ChunkUtils", "generateCompressedChunk: sending entity type packages");
                BleEntityContent bleEntityContent = (BleEntityContent) bleEntity.getCt();
                byte[] b = gzip_byte_stream(Utils.fromEntityToMessagePack(bleEntityContent.getPld()));
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(CryptoRSA.encrypt(get_corresponding_key(str), b));
                if (bleEntity.getData() != null && bleEntity.getData().length > 0) {
                    ContentInfo findMatch = new ContentInfoUtil().findMatch(bleEntity.getData());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("generateCompressedChunk: match data ");
                    sb2.append(findMatch.getMimeType());
                    Log.i("ChunkUtils", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("generateCompressedChunk: match data mime ");
                    sb3.append(findMatch.getContentType().getMimeType());
                    Log.i("ChunkUtils", sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("generateCompressedChunk: match data simple ");
                    sb4.append(findMatch.getContentType().getSimpleName());
                    Log.i("ChunkUtils", sb4.toString());
                    if (findMatch == null || findMatch.getContentType().getMimeType().equals("image/jpeg") || findMatch.getContentType().getMimeType().equals("image/jp2") || findMatch.getContentType().getMimeType().equals("image/tiff") || findMatch.getContentType().getMimeType().equals("image/png") || findMatch.getContentType().getMimeType().equals("image/gif") || findMatch.getContentType().getMimeType().equals("application/zip") || findMatch.getContentType().getMimeType().equals("application/x-7z-compressed")) {
                        Log.w("ChunkUtils", "generateCompressedChunk: not compressing because it's a knkown file type");
                        arrayList4.add(bleEntity.getData());
                    } else {
                        Log.i("ChunkUtils", "generateCompressedChunk: compressing");
                        arrayList4.add(gzip_byte_stream(bleEntity.getData()));
                    }
                }
                bArr = byte_arraylist_to_byte_arrayb.serialize(arrayList4);
                i2 = bArr.length;
                bleEntity2.setCt(new BleEntityContent(bleEntityContent.getId()));
            } catch (Exception e2) {
                throw new MessageException(e2.getMessage(), e2);
            }
        }
        byte[] b2 = gzip_byte_stream(z ? Utils.fromEntityToMessagePack(bleEntity) : new Gson().toJson((Object) bleEntity2, (Type) BleEntity.class).getBytes());
        int length = b2.length + 2;
        if (i2 > 0) {
            length += i2 + 1;
        }
        if (length <= i3) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (bArr == null || bArr.length <= 0) {
                byteArrayOutputStream.write(2);
            } else {
                byteArrayOutputStream.write(1);
            }
            byteArrayOutputStream.write(3);
            byteArrayOutputStream.write(b2);
            arrayList.add(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            if (bArr != null && bArr.length > 0) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                byteArrayOutputStream2.write(2);
                byteArrayOutputStream2.write(4);
                byteArrayOutputStream2.write(bArr);
                arrayList.add(byteArrayOutputStream2.toByteArray());
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
            }
        } else {
            int ceil = (int) Math.ceil(((double) ((b2.length + 1) + 1)) / ((double) i3));
            for (int i4 = 0; i4 < ceil; i4++) {
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                int i5 = i3 * i4;
                byte[] a = C3689a.m10974a(b2, i5, i5 + i3);
                if (i4 == 0) {
                    byteArrayOutputStream3.write(1);
                } else if (i4 == ceil - 1 && (bArr == null || bArr.length == 0)) {
                    byteArrayOutputStream3.write(2);
                }
                byteArrayOutputStream3.write(3);
                byteArrayOutputStream3.write(a);
                arrayList.add(byteArrayOutputStream3.toByteArray());
                byteArrayOutputStream3.flush();
                byteArrayOutputStream3.close();
            }
            if (bArr != null && bArr.length > 0) {
                int i6 = i2 / i3;
                for (int i7 = 0; i7 <= i6; i7++) {
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    int i8 = i3 * i7;
                    byte[] a2 = C3689a.m10974a(bArr, i8, i8 + i3);
                    if (i7 == i6) {
                        byteArrayOutputStream4.write(2);
                    }
                    byteArrayOutputStream4.write(4);
                    byteArrayOutputStream4.write(a2);
                    arrayList.add(byteArrayOutputStream4.toByteArray());
                    byteArrayOutputStream4.flush();
                    byteArrayOutputStream4.close();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static BleEntity stitch_chunks_to_entity(ArrayList<byte[]> arrayList, boolean z, boolean z2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) it.next());
                int read = byteArrayInputStream.read();
                byte[] bArr = new byte[byteArrayInputStream.available()];
                byteArrayInputStream.read(bArr, 0, bArr.length);
                if (read == 4) {
                    byteArrayOutputStream2.write(bArr);
                } else if (read == 3) {
                    byteArrayOutputStream.write(bArr);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("stitchChunksToEntity: UNDEFINE ");
                    sb.append(read);
                    Log.e("ChunkUtils", sb.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BleEntity bleEntity = null;
        try {
            byte[] d = setup_gzip_byte_stream(byteArrayOutputStream.toByteArray());
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            bleEntity = (BleEntity) (z ? Utils.fromMessagePacktoEntity(d, BleEntity.class) : new Gson().fromJson(new String(d), BleEntity.class));
            if (bleEntity.getEt() != 1) {
                bleEntity.setBinaryPart(byteArray);
            } else if (byteArray != null && byteArray.length > 0) {
                ArrayList a = byte_arraylist_to_byte_arrayb.deserialize(byteArray);
                bleEntity.setCt(new BleEntityContent((HashMap) Utils.fromMessagePacktoEntity(setup_gzip_byte_stream(CryptoRSA.decrypt(Bridgefy.getInstance().getBridgefyClient().getSecretKey(), (byte[]) a.get(0))), HashMap.class), ((BleEntityContent) bleEntity.getCt()).getId()));
                if (a.size() > 1) {
                    ContentInfo findMatch = new ContentInfoUtil().findMatch((byte[]) a.get(1));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("generateCompressedChunk: match data ");
                    sb2.append(findMatch.getMimeType());
                    Log.i("ChunkUtils", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("generateCompressedChunk: match data mime ");
                    sb3.append(findMatch.getContentType().getMimeType());
                    Log.i("ChunkUtils", sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("generateCompressedChunk: match data simple ");
                    sb4.append(findMatch.getContentType().getSimpleName());
                    Log.i("ChunkUtils", sb4.toString());
                    if (findMatch == null || findMatch.getContentType().getMimeType().equals("image/jpeg") || findMatch.getContentType().getMimeType().equals("image/jp2") || findMatch.getContentType().getMimeType().equals("image/tiff") || findMatch.getContentType().getMimeType().equals("image/png") || findMatch.getContentType().getMimeType().equals("image/gif") || findMatch.getContentType().getMimeType().equals("application/zip") || findMatch.getContentType().getMimeType().equals("application/x-7z-compressed")) {
                        Log.i("ChunkUtils", "stitchChunksToEntity: not decompressing");
                        bleEntity.setData((byte[]) a.get(1));
                    } else {
                        Log.i("ChunkUtils", "stitchChunksToEntity: decompressing data");
                        bleEntity.setData(setup_gzip_byte_stream((byte[]) a.get(1)));
                    }
                }
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream2.flush();
        } catch (Exception e2) {
            Log.e("ChunkUtils", "stitchChunksToEntity: ", e2);
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream2.flush();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return bleEntity;
    }

    /* renamed from: a */
    static byte[] m8002a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        int read = byteArrayInputStream.read();
        byte[] bArr2 = new byte[byteArrayInputStream.available()];
        byteArrayInputStream.read(bArr2, 0, bArr2.length);
        if (read != 3 && read != 4) {
            return bArr2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(read);
            byteArrayOutputStream.write(bArr2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    static String get_corresponding_key(String str) {
        return (String) Session.get_key_pairs().get(str);
    }

    /* renamed from: b */
    public static byte[] gzip_byte_stream(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    /* renamed from: a */
    static int get_bluetooth_characteristics(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        try {
            return bluetoothGattCharacteristic.getValue()[0];
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: c */
    static int m8004c(byte[] bArr) {
        try {
            return bArr[0];
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: d */
    public static byte[] setup_gzip_byte_stream(byte[] bArr) throws IOException {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (bArr.length <= 512) {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } else {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream, bArr.length);
        }
        return C3688b.m10972a(gZIPInputStream);
    }
}
