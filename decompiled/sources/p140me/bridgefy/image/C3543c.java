package p140me.bridgefy.image;

import android.os.AsyncTask;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.p141a.C3460d;

/* renamed from: me.bridgefy.image.c */
/* compiled from: ImageLoaderTask */
public class C3543c extends AsyncTask<C3540a, Void, Void> {

    /* renamed from: a */
    private BridgefyOrmLiteBaseActivity<DatabaseHelper> f9273a;

    /* renamed from: b */
    private Message f9274b;

    /* renamed from: c */
    private C3542b f9275c;

    /* renamed from: d */
    private C3460d f9276d = new C3460d((DatabaseHelper) this.f9273a.getHelper());

    public C3543c(C3540a aVar) {
        this.f9273a = (BridgefyOrmLiteBaseActivity) aVar.mo29408a();
        this.f9274b = aVar.mo29414b();
        this.f9275c = aVar.mo29415c();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008f, code lost:
        r4.f9275c.mo29149a(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008e A[ExcHandler: IOException | NullPointerException | NumberFormatException (r0v0 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Void doInBackground(p140me.bridgefy.image.C3540a... r5) {
        /*
            r4 = this;
            r5 = 0
            me.bridgefy.cloud.a r0 = p140me.bridgefy.cloud.C3517a.m10256a()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.entities.Message r1 = r4.f9274b     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.String r1 = r1.getMessageId()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            long r1 = java.lang.Long.parseLong(r1)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.entities.Message r0 = r0.mo29193b(r1)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            byte[] r1 = r0.getFileContent()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            if (r1 == 0) goto L_0x0030
            byte[] r1 = r0.getFileContent()     // Catch:{ IOException -> 0x0029, IOException | NullPointerException | NumberFormatException -> 0x008e }
            byte[] r1 = m10402a(r1)     // Catch:{ IOException -> 0x0029, IOException | NullPointerException | NumberFormatException -> 0x008e }
            r0.setFileContent(r1)     // Catch:{ IOException -> 0x0029, IOException | NullPointerException | NumberFormatException -> 0x008e }
            goto L_0x0030
        L_0x0029:
            byte[] r1 = r0.getFileContent()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            r0.setFileContent(r1)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
        L_0x0030:
            java.lang.String r1 = "Bridgefy"
            p140me.bridgefy.utils.C3667g.m10941a(r0, r1)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.entities.Message r1 = r4.f9274b     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.String r2 = r0.getFileName()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            r1.setFileName(r2)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity<me.bridgefy.ormlite.DatabaseHelper> r1 = r4.f9273a     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.String r2 = "BgfyPrefs"
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.String r2 = "user_uuid"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.entities.Message r2 = r4.f9274b     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.String r2 = r2.getSender()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            boolean r1 = r2.equals(r1)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            if (r1 == 0) goto L_0x0063
            me.bridgefy.a.d r1 = r4.f9276d     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.entities.Message r2 = r4.f9274b     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            r1.mo28337a(r2)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            goto L_0x0080
        L_0x0063:
            me.bridgefy.a.d r1 = r4.f9276d     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.a.c r2 = new me.bridgefy.a.c     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity<me.bridgefy.ormlite.DatabaseHelper> r3 = r4.f9273a     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            r2.<init>(r3)     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.entities.Message r3 = r4.f9274b     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.String r3 = r3.getSender()     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.ormlite.entities.FriendDTO r2 = r2.mo28323c(r3)     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            me.bridgefy.entities.Message r3 = r4.f9274b     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            r1.mo28336a(r2, r3, r5)     // Catch:{ IllegalStateException | OrmLiteBridgefyException -> 0x007c, IOException | NullPointerException | NumberFormatException -> 0x008e, IOException | NullPointerException | NumberFormatException -> 0x008e }
            goto L_0x0080
        L_0x007c:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
        L_0x0080:
            me.bridgefy.image.b r1 = r4.f9275c     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            java.lang.String r0 = r0.findFilePath()     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            r1.mo29148a(r0)     // Catch:{ IOException | NullPointerException | NumberFormatException -> 0x008e }
            goto L_0x0094
        L_0x008e:
            r0 = move-exception
            me.bridgefy.image.b r1 = r4.f9275c
            r1.mo29149a(r0)
        L_0x0094:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.image.C3543c.doInBackground(me.bridgefy.image.a[]):java.lang.Void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onCancelled(Void voidR) {
        this.f9275c.mo29149a((Exception) new IllegalStateException("Cancel download image."));
    }

    /* renamed from: a */
    public static byte[] m10402a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[256];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
