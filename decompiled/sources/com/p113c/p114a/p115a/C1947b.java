package com.p113c.p114a.p115a;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.p113c.p114a.p115a.C1945a.C1946a;
import java.io.ByteArrayOutputStream;
import p140me.bridgefy.ormlite.entities.MessageDTO;

/* renamed from: com.c.a.a.b */
/* compiled from: MessagingExtension */
public abstract class C1947b extends Service {

    /* renamed from: a */
    private final C1946a f6124a = new C1946a() {
        /* renamed from: a */
        public void mo7716a(String str, String str2) throws RemoteException {
            C1947b.this.mo7720a(str, str2);
        }

        /* renamed from: a */
        public void mo7715a(String str) throws RemoteException {
            C1947b.this.mo7719a(str);
        }
    };

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7719a(String str);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7720a(String str, String str2);

    /* renamed from: a */
    public static void m8084a(Context context, String str, String str2, String str3, Bitmap bitmap, String str4, int i) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("conversationIden must not be null or empty");
        } else if (bitmap != null) {
            try {
                if (context.getPackageManager().getPackageInfo("com.pushbullet.android", 0).versionCode >= 90) {
                    final Bitmap bitmap2 = bitmap;
                    final String str5 = str2;
                    final String str6 = str3;
                    final Context context2 = context;
                    final String str7 = str;
                    final int i2 = i;
                    final String str8 = str4;
                    C19492 r1 = new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public Void doInBackground(Void... voidArr) {
                            Bitmap bitmap;
                            if (bitmap2.getHeight() > 512 || bitmap2.getWidth() > 512) {
                                bitmap = Bitmap.createScaledBitmap(bitmap2, 512, (int) (((float) bitmap2.getHeight()) / (((float) bitmap2.getWidth()) / 512.0f)), true);
                            } else {
                                bitmap = bitmap2;
                            }
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(CompressFormat.JPEG, 90, byteArrayOutputStream);
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName("com.pushbullet.android", "com.pushbullet.android.notifications.mirroring.ExtensionMirrorMessageReceiver"));
                            intent.putExtra(MessageDTO.SENDER, str5);
                            intent.putExtra(MessageDTO.MESSAGE, str6);
                            intent.putExtra("package_name", context2.getPackageName());
                            intent.putExtra(MessageDTO.IMAGE, byteArrayOutputStream.toByteArray());
                            intent.putExtra("converstation_iden", str7);
                            intent.putExtra("notification_id", i2);
                            intent.putExtra("notification_tag", str8);
                            context2.sendBroadcast(intent);
                            return null;
                        }
                    };
                    r1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[]{null});
                }
            } catch (NameNotFoundException unused) {
            }
        } else {
            throw new IllegalArgumentException("image must not be null");
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f6124a;
    }
}
