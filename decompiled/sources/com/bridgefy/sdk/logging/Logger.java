package com.bridgefy.sdk.logging;

import android.content.Context;
import android.os.Environment;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.logging.entities.DeviceInfo;
import com.bridgefy.sdk.logging.entities.LogEntity;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger {
    public static final String DEVICE_STR = "device_info";
    public static final String LOGS_DIR = "BridgefyLogs";
    public static final String TEMP_FILE = "tmp.log";
    public static final String TESTS_STR = "tests";

    /* renamed from: a */
    private static String f6080a = "Logger";

    /* renamed from: b */
    private static Logger f6081b;

    /* renamed from: c */
    private final BlockingQueue<LogEntity> f6082c = new LinkedBlockingQueue();

    /* renamed from: d */
    private boolean f6083d = false;

    /* renamed from: e */
    private Context f6084e;

    /* renamed from: f */
    private String f6085f;

    /* renamed from: g */
    private int f6086g = 0;

    /* renamed from: h */
    private ArrayList<LogEntity> f6087h = new ArrayList<>();

    /* renamed from: i */
    private HashMap<String, Object> f6088i = new HashMap<>();

    /* renamed from: j */
    private boolean f6089j;

    public Logger(boolean z, Context context) {
        this.f6089j = z;
        this.f6084e = context;
        new Thread(new C1944a(this.f6082c)).start();
    }

    public static void init(Context context, boolean z) {
        if (z && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        if (f6081b == null) {
            f6081b = new Logger(z, context);
        }
    }

    public static Logger getInstance() {
        if (f6081b != null) {
            return f6081b;
        }
        throw new IllegalStateException("Logger must be initialized before trying to reference it.");
    }

    /* renamed from: a */
    private static boolean m8079a() {
        return getInstance().f6083d;
    }

    public static synchronized void startLogs(String str) {
        synchronized (Logger.class) {
            getInstance().getLogHashMap().put(DEVICE_STR, new DeviceInfo(Bridgefy.getInstance().getBridgefyClient().getUserUuid()));
            getInstance().getLogHashMap().put(TESTS_STR, new ArrayList());
            getInstance().f6085f = str;
            getInstance().f6083d = true;
        }
    }

    public static synchronized int stopLogs() {
        synchronized (Logger.class) {
            ArrayList arrayList = (ArrayList) getInstance().getLogHashMap().get(TESTS_STR);
            arrayList.add(getInstance().getActiveLogEntityList());
            int size = getInstance().getActiveLogEntityList().size();
            getInstance().getLogHashMap().put(TESTS_STR, arrayList);
            if (!m8080a(getInstance().getFileName(), new Gson().toJson((Object) getInstance().getLogHashMap()).getBytes())) {
                return -1;
            }
            getInstance().f6083d = false;
            clearLogs();
            return size;
        }
    }

    public static synchronized void clearLogs() {
        synchronized (Logger.class) {
            getInstance().setLogHashMap(new HashMap());
            getInstance().setActiveLogEntityList(new ArrayList());
            m8080a(TEMP_FILE, new byte[0]);
        }
    }

    public static synchronized void log(LogEntity logEntity) {
        synchronized (Logger.class) {
            try {
                if (f6081b != null && m8079a()) {
                    try {
                        getInstance().f6082c.put(logEntity);
                        getInstance().getActiveLogEntityList().add(logEntity);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return;
    }

    public static File getOrCreateFile(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb.append("/");
            sb.append(LOGS_DIR);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("/");
            sb3.append(str);
            File file = new File(sb3.toString());
            if (!file.exists()) {
                new File(sb2).mkdirs();
                file.createNewFile();
                new FileWriter(file).close();
                file.setLastModified(System.currentTimeMillis());
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m8080a(String str, byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getOrCreateFile(str));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean shouldWriteToTempFile() {
        return this.f6089j;
    }

    public int getTestNumber() {
        return this.f6086g;
    }

    public void setTestNumber(int i) {
        this.f6086g = i;
    }

    public String getFileName() {
        return this.f6085f;
    }

    public ArrayList<LogEntity> getActiveLogEntityList() {
        return this.f6087h;
    }

    public void setActiveLogEntityList(ArrayList<LogEntity> arrayList) {
        this.f6087h = arrayList;
    }

    public HashMap<String, Object> getLogHashMap() {
        return this.f6088i;
    }

    public void setLogHashMap(HashMap<String, Object> hashMap) {
        this.f6088i = hashMap;
    }

    public Context getContext() {
        return this.f6084e;
    }
}
