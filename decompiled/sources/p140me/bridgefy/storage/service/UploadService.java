package p140me.bridgefy.storage.service;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import androidx.core.app.C0854g.C0857c;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.integration.C3549b;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.ormlite.service.BridgefyORMLiteIntentService;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.storage.C3644b;
import p140me.bridgefy.storage.p150b.C3645a;
import p140me.bridgefy.storage.p151c.C3647a;
import p140me.bridgefy.storage.p151c.C3649b;
import p140me.bridgefy.storage.p152d.C3651a;

/* renamed from: me.bridgefy.storage.service.UploadService */
public class UploadService extends BridgefyORMLiteIntentService<DatabaseHelper> {

    /* renamed from: a */
    public static String f9645a = "me.bridgefy";

    /* renamed from: c */
    private static final String f9646c = "me.bridgefy.storage.service.UploadService";

    /* renamed from: i */
    private static volatile boolean f9647i = true;

    /* renamed from: b */
    C3460d f9648b;

    /* renamed from: d */
    private NotificationManager f9649d;

    /* renamed from: e */
    private C0857c f9650e;

    /* renamed from: f */
    private WakeLock f9651f;

    /* renamed from: g */
    private C3645a f9652g;

    /* renamed from: h */
    private int f9653h;

    /* renamed from: a */
    public static String m10837a() {
        StringBuilder sb = new StringBuilder();
        sb.append(f9645a);
        sb.append(".uploadservice.action.upload");
        return sb.toString();
    }

    /* renamed from: b */
    public static String m10853b() {
        StringBuilder sb = new StringBuilder();
        sb.append(f9645a);
        sb.append(".uploadservice.broadcast.status");
        return sb.toString();
    }

    /* renamed from: a */
    public static void m10850a(Message message, C3644b bVar) throws IllegalArgumentException, MalformedURLException {
        if (bVar != null) {
            bVar.mo29741a();
            BridgefyService.m10660a(message.getOfflineId(), message.getFileContent());
            message.setFileContent(null);
            Intent intent = new Intent(bVar.mo29755i(), UploadService.class);
            intent.setAction(m10837a());
            intent.putExtra("notificationConfig", bVar.mo29754h());
            intent.putExtra("id", bVar.mo29749c());
            intent.putExtra(ImagesContract.URL, bVar.mo29750d());
            intent.putExtra(Param.METHOD, bVar.mo29746b());
            intent.putExtra("customUserAgent", bVar.mo29756j());
            intent.putExtra("maxRetries", bVar.mo29757k());
            intent.putExtra("bridgefyMessage", message.serialize());
            intent.putParcelableArrayListExtra("files", bVar.mo29751e());
            intent.putParcelableArrayListExtra("requestHeaders", bVar.mo29752f());
            intent.putParcelableArrayListExtra("requestParameters", bVar.mo29753g());
            bVar.mo29755i().startService(intent);
            return;
        }
        throw new IllegalArgumentException("Can't pass an empty task!");
    }

    /* renamed from: c */
    public static void m10856c() {
        f9647i = false;
    }

    public UploadService() {
        super(f9646c);
    }

    public void onCreate() {
        super.onCreate();
        this.f9648b = new C3460d((DatabaseHelper) getHelper());
        this.f9649d = (NotificationManager) getSystemService("notification");
        this.f9650e = new C0857c(this, f9645a);
        this.f9651f = ((PowerManager) getSystemService("power")).newWakeLock(1, "UploadService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Intent intent2 = intent;
        if (intent2 != null) {
            if (m10837a().equals(intent.getAction())) {
                this.f9652g = (C3645a) intent2.getParcelableExtra("notificationConfig");
                String stringExtra = intent2.getStringExtra("id");
                String stringExtra2 = intent2.getStringExtra(ImagesContract.URL);
                String stringExtra3 = intent2.getStringExtra(Param.METHOD);
                String stringExtra4 = intent2.getStringExtra("customUserAgent");
                int i = 0;
                int intExtra = intent2.getIntExtra("maxRetries", 0);
                ArrayList parcelableArrayListExtra = intent2.getParcelableArrayListExtra("files");
                ArrayList parcelableArrayListExtra2 = intent2.getParcelableArrayListExtra("requestHeaders");
                ArrayList parcelableArrayListExtra3 = intent2.getParcelableArrayListExtra("requestParameters");
                Message create = Message.create(intent2.getStringExtra("bridgefyMessage"));
                create.setFileContent(BridgefyService.m10662a(create.getOfflineId()));
                this.f9653h = 0;
                f9647i = true;
                this.f9651f.acquire();
                m10858e();
                while (i <= intExtra && f9647i) {
                    String str = stringExtra2;
                    String str2 = stringExtra3;
                    String str3 = stringExtra2;
                    int i2 = i + 1;
                    String str4 = stringExtra3;
                    Message message = create;
                    try {
                        m10846a(stringExtra, str, str2, parcelableArrayListExtra, parcelableArrayListExtra2, parcelableArrayListExtra3, stringExtra4);
                    } catch (Exception e) {
                        Exception exc = e;
                        if (i2 > intExtra || !f9647i) {
                            m10849a(message, stringExtra, exc);
                        } else {
                            String name = getClass().getName();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Error in uploadId ");
                            sb.append(stringExtra);
                            sb.append(" on attempt ");
                            sb.append(i2);
                            Log.w(name, sb.toString(), exc);
                        }
                    }
                    i = i2;
                    create = message;
                    stringExtra2 = str3;
                    stringExtra3 = str4;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m10846a(String str, String str2, String str3, ArrayList<C3647a> arrayList, ArrayList<C3649b> arrayList2, ArrayList<C3649b> arrayList3, String str4) throws IOException {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream;
        String str5 = str;
        ArrayList<C3647a> arrayList4 = arrayList;
        ArrayList<C3649b> arrayList5 = arrayList2;
        ArrayList<C3649b> arrayList6 = arrayList3;
        String str6 = str4;
        String d = m10857d();
        byte[] a = m10851a(d);
        InputStream inputStream2 = null;
        try {
            long a2 = m10836a(arrayList6, (long) a.length);
            long b = m10852b(arrayList4, (long) a.length);
            byte[] b2 = m10855b(d);
            long length = a2 + b + ((long) b2.length);
            httpURLConnection = m10839a(str2, str3, d, arrayList.size());
            if (str6 != null) {
                try {
                    if (!str6.equals("")) {
                        arrayList5.add(new C3649b(HttpHeaders.USER_AGENT, str6));
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    m10841a(outputStream);
                    m10854b(inputStream2);
                    m10847a(httpURLConnection);
                    throw th;
                }
            }
            m10848a(httpURLConnection, arrayList5);
            httpURLConnection.setFixedLengthStreamingMode(length);
            outputStream = httpURLConnection.getOutputStream();
            try {
                m10842a(outputStream, arrayList6, a);
                m10845a(str5, outputStream, arrayList4, a);
                outputStream.write(b2, 0, b2.length);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode / 100 == 2) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        m10856c();
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                    }
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }
                inputStream2 = inputStream;
                C3651a.m10830a().mo29792a(arrayList5, responseCode, arrayList6, (DatabaseHelper) getHelper());
                String a3 = m10838a(inputStream2);
                m10843a(str5, responseCode, a3);
                Message b3 = this.f9648b.mo28341b(str5);
                b3.setMessageId(new JSONObject(a3).getString("cloudId"));
                this.f9648b.mo28337a(b3);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Throwable th3) {
                th = th3;
                m10841a(outputStream);
                m10854b(inputStream2);
                m10847a(httpURLConnection);
                throw th;
            }
            m10841a(outputStream);
            m10854b(inputStream2);
            m10847a(httpURLConnection);
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            httpURLConnection = null;
            m10841a(outputStream);
            m10854b(inputStream2);
            m10847a(httpURLConnection);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d A[SYNTHETIC, Splitter:B:11:0x001d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m10838a(java.io.InputStream r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x001b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x001b }
            r3.<init>(r5)     // Catch:{ Exception -> 0x001b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001b }
        L_0x0010:
            java.lang.String r5 = r2.readLine()     // Catch:{ Exception -> 0x001a }
            if (r5 == 0) goto L_0x0020
            r0.append(r5)     // Catch:{ Exception -> 0x001a }
            goto L_0x0010
        L_0x001a:
            r1 = r2
        L_0x001b:
            if (r1 == 0) goto L_0x0020
            r1.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.storage.service.UploadService.m10838a(java.io.InputStream):java.lang.String");
    }

    /* renamed from: d */
    private String m10857d() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------");
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    /* renamed from: a */
    private byte[] m10851a(String str) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n--");
        sb.append(str);
        sb.append("\r\n");
        return sb.toString().getBytes("US-ASCII");
    }

    /* renamed from: b */
    private byte[] m10855b(String str) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n--");
        sb.append(str);
        sb.append("--");
        sb.append("\r\n");
        return sb.toString().getBytes("US-ASCII");
    }

    /* renamed from: a */
    private HttpURLConnection m10839a(String str, String str2, String str3, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(str2);
        if (i <= 1) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
        } else {
            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
        }
        httpURLConnection.setRequestProperty("ENCTYPE", "multipart/form-data");
        String str4 = HttpHeaders.CONTENT_TYPE;
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(str3);
        httpURLConnection.setRequestProperty(str4, sb.toString());
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m10848a(HttpURLConnection httpURLConnection, ArrayList<C3649b> arrayList) {
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C3649b bVar = (C3649b) it.next();
                httpURLConnection.setRequestProperty(bVar.mo29782a(), bVar.mo29783b());
            }
        }
    }

    /* renamed from: a */
    private void m10842a(OutputStream outputStream, ArrayList<C3649b> arrayList, byte[] bArr) throws IOException {
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C3649b bVar = (C3649b) it.next();
                outputStream.write(bArr, 0, bArr.length);
                byte[] c = bVar.mo29784c();
                outputStream.write(c, 0, c.length);
            }
        }
    }

    /* renamed from: a */
    private long m10836a(ArrayList<C3649b> arrayList, long j) throws UnsupportedEncodingException {
        long j2 = 0;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j2 += ((long) ((C3649b) it.next()).mo29784c().length) + j;
            }
        }
        return j2;
    }

    /* renamed from: a */
    private void m10845a(String str, OutputStream outputStream, ArrayList<C3647a> arrayList, byte[] bArr) throws IOException {
        OutputStream outputStream2 = outputStream;
        byte[] bArr2 = bArr;
        long a = m10835a(arrayList);
        Iterator it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            C3647a aVar = (C3647a) it.next();
            if (f9647i) {
                outputStream2.write(bArr2, 0, bArr2.length);
                byte[] b = aVar.mo29774b();
                outputStream2.write(b, 0, b.length);
                InputStream a2 = aVar.mo29773a();
                byte[] bArr3 = new byte[4096];
                while (true) {
                    try {
                        int read = a2.read(bArr3, 0, bArr3.length);
                        if (read > 0 && f9647i) {
                            outputStream2.write(bArr3, 0, read);
                            long j2 = j + ((long) read);
                            m10844a(str, j2, a);
                            j = j2;
                        }
                    } finally {
                        m10854b(a2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private long m10835a(ArrayList<C3647a> arrayList) {
        Iterator it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((C3647a) it.next()).mo29775c();
        }
        return j;
    }

    /* renamed from: b */
    private long m10852b(ArrayList<C3647a> arrayList, long j) throws UnsupportedEncodingException {
        Iterator it = arrayList.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 += ((C3647a) it.next()).mo29772a(j);
        }
        return j2;
    }

    /* renamed from: b */
    private void m10854b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m10841a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m10847a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m10844a(String str, long j, long j2) {
        int i = (int) ((j * 100) / j2);
        if (i > this.f9653h) {
            this.f9653h = i;
            m10840a(i);
            Intent intent = new Intent(m10853b());
            intent.putExtra("id", str);
            intent.putExtra(MessageDTO.STATUS, 1);
            intent.putExtra("progress", i);
            sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    private void m10843a(String str, int i, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (i >= 200 && i <= 299) {
            m10861h();
        }
        if (i == 409) {
            m10862i();
        }
        if (i >= 500) {
            m10862i();
        }
        Intent intent = new Intent(m10853b());
        intent.putExtra("id", str);
        intent.putExtra(MessageDTO.STATUS, 2);
        intent.putExtra("serverResponseCode", i);
        intent.putExtra("serverResponseMessage", str2);
        sendBroadcast(intent);
        if (this.f9651f.isHeld()) {
            this.f9651f.release();
        }
    }

    /* renamed from: a */
    private void m10849a(Message message, String str, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("broadcastError: uploadId: ");
        sb.append(str);
        Log.w("UploadService", sb.toString());
        m10862i();
        Intent intent = new Intent(m10853b());
        intent.setAction(m10853b());
        intent.putExtra("id", str);
        intent.putExtra(MessageDTO.STATUS, 3);
        intent.putExtra("errorException", exc);
        sendBroadcast(intent);
        if (this.f9651f.isHeld()) {
            this.f9651f.release();
        }
        message.setStatus(2);
        this.f9648b.mo28337a(message);
        C3549b.m10417a(message);
    }

    /* renamed from: e */
    private void m10858e() {
        this.f9650e.mo3490a((CharSequence) this.f9652g.mo29761b()).mo3496b((CharSequence) this.f9652g.mo29762c()).mo3486a(this.f9652g.mo29760a(this)).mo3481a(this.f9652g.mo29759a()).mo3483a(100, 0, true).mo3492a(true);
        m10860g();
    }

    /* renamed from: a */
    private void m10840a(int i) {
        this.f9650e.mo3490a((CharSequence) this.f9652g.mo29761b()).mo3496b((CharSequence) this.f9652g.mo29762c()).mo3486a(this.f9652g.mo29760a(this)).mo3497b(true).mo3481a(this.f9652g.mo29759a()).mo3483a(100, i, false).mo3492a(true);
        m10859f();
    }

    /* renamed from: f */
    private void m10859f() {
        this.f9649d.notify(1234, this.f9650e.mo3493b());
    }

    /* renamed from: g */
    private void m10860g() {
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(f9645a, "Bridgefy", 1);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
        startForeground(1234, this.f9650e.mo3493b());
    }

    /* renamed from: h */
    private void m10861h() {
        stopForeground(this.f9652g.mo29766f());
        if (!this.f9652g.mo29766f()) {
            this.f9650e.mo3490a((CharSequence) this.f9652g.mo29761b()).mo3496b((CharSequence) this.f9652g.mo29763d()).mo3486a(this.f9652g.mo29760a(this)).mo3481a(this.f9652g.mo29759a()).mo3483a(0, 0, false).mo3492a(false);
            this.f9649d.notify(1235, this.f9650e.mo3493b());
        }
    }

    /* renamed from: i */
    private void m10862i() {
        stopForeground(false);
        this.f9650e.mo3490a((CharSequence) this.f9652g.mo29761b()).mo3496b((CharSequence) this.f9652g.mo29765e()).mo3486a(this.f9652g.mo29760a(this)).mo3481a(this.f9652g.mo29759a()).mo3483a(0, 0, false).mo3492a(false);
        this.f9649d.notify(1235, this.f9650e.mo3493b());
    }
}
