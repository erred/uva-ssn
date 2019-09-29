package p140me.bridgefy.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import androidx.core.content.C0875a;
import androidx.p079f.p080a.C1049a;
import com.google.android.material.snackbar.Snackbar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import me.bridgefy.main.R;
import org.apache.commons.p154a.C3688b;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3667g.C3668a;

/* renamed from: me.bridgefy.utils.g */
/* compiled from: FileUtils */
public class C3667g {

    /* renamed from: a */
    private static String f9701a = "FileUtils";

    /* renamed from: me.bridgefy.utils.g$a */
    /* compiled from: FileUtils */
    public static class C3668a extends DialogFragment {

        /* renamed from: a */
        public static String f9702a = "StoragePermissionDeniedDialogFragment";

        /* renamed from: b */
        BridgefyOrmLiteBaseActivity f9703b;

        /* renamed from: c */
        C3669a f9704c;

        /* renamed from: d */
        boolean f9705d = false;

        /* renamed from: me.bridgefy.utils.g$a$a */
        /* compiled from: FileUtils */
        public interface C3669a {
            /* renamed from: b */
            void mo29062b();
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.f9703b = (BridgefyOrmLiteBaseActivity) activity;
            this.f9704c = (C3669a) activity;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return C3659b.m10907d((Context) getActivity()).setTitle((int) R.string.permission_dialog_title).setMessage((CharSequence) getString(R.string.storage_permission_dialog_body)).setPositiveButton((int) R.string.permission_dialog_grant_access, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3668a.this.m10952b(dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.never_again, (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C3668a.this.m10951a(dialogInterface, i);
                }
            }).create();
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m10952b(DialogInterface dialogInterface, int i) {
            this.f9705d = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10951a(DialogInterface dialogInterface, int i) {
            this.f9703b.getSettings().edit().putBoolean("permissionStorageInsist", false).apply();
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            if (this.f9705d) {
                C3659b.m10889a((Activity) this.f9703b, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, getArguments().getInt("permissionsStorageRequestCode"));
            } else {
                this.f9704c.mo29062b();
            }
            C1049a.m3996a(BridgefyApp.m10557c().getBaseContext()).mo4060a(new Intent("permissionsDenied"));
        }
    }

    public C3667g(BridgefyOrmLiteBaseActivity bridgefyOrmLiteBaseActivity, View view, Integer num) {
        int i;
        if (m10942a(bridgefyOrmLiteBaseActivity.getBaseContext())) {
            return;
        }
        if (!bridgefyOrmLiteBaseActivity.getSettings().getBoolean("permissionStorageInsist", true)) {
            m10940a(view, (Activity) bridgefyOrmLiteBaseActivity);
        } else if (bridgefyOrmLiteBaseActivity.getFragmentManager().findFragmentByTag(C3668a.f9702a) == null) {
            C3668a aVar = new C3668a();
            Bundle bundle = new Bundle();
            String str = "permissionsStorageRequestCode";
            if (num == null) {
                i = 4;
            } else {
                i = num.intValue();
            }
            bundle.putInt(str, i);
            aVar.setArguments(bundle);
            aVar.show(bridgefyOrmLiteBaseActivity.getFragmentManager(), C3668a.f9702a);
        }
    }

    /* renamed from: a */
    public static boolean m10942a(Context context) {
        return m10947b(context) && m10946b();
    }

    /* renamed from: b */
    public static boolean m10947b(Context context) {
        return C0875a.m3245b(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && C0875a.m3245b(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* renamed from: b */
    private static boolean m10946b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: a */
    public static void m10941a(Message message, String str) throws IOException {
        if (m10942a(BridgefyApp.m10557c().getApplicationContext())) {
            StringBuilder sb = new StringBuilder();
            sb.append(m10937a(str).getPath());
            sb.append("/");
            sb.append(message.getFileName());
            File file = new File(sb.toString());
            C3688b.m10971a(message.getFileContent(), (OutputStream) new FileOutputStream(file));
            BridgefyApp.m10557c().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
        }
    }

    /* renamed from: a */
    public String mo29836a(Context context, Uri uri) {
        try {
            String str = (String) m10938a(uri).get("fileName");
            m10936a(m10944b(context, uri), "Bridgefy/thumbs", str);
            m10936a(m10944b(context, uri), "Bridgefy", str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, context.getString(R.string.image_error), 0).show();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File m10936a(android.graphics.Bitmap r12, java.lang.String r13, java.lang.String r14) throws java.io.IOException {
        /*
            r11 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
            r2 = 90
            r12.compress(r1, r2, r0)
            java.io.File r1 = new java.io.File
            java.io.File r2 = r11.m10945b(r13)
            r1.<init>(r2, r14)
            java.lang.String r14 = f9701a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "copying image to: "
            r2.append(r3)
            android.net.Uri r3 = android.net.Uri.fromFile(r1)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r14, r2)
            java.io.FileOutputStream r14 = new java.io.FileOutputStream
            r14.<init>(r1)
            byte[] r0 = r0.toByteArray()
            r14.write(r0)
            r14.close()
            long r2 = r1.length()
            r4 = 1024(0x400, double:5.06E-321)
            long r2 = r2 / r4
            double r2 = (double) r2
            int r14 = r12.getWidth()
            int r0 = r12.getHeight()
            java.lang.String r6 = f9701a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Original image size: "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r8 = " KB"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r6, r7)
            int r6 = r13.hashCode()
            r7 = -1940989808(0xffffffff8c4ed890, float:-1.5934832E-31)
            r8 = 0
            if (r6 == r7) goto L_0x0083
            r7 = 259151420(0xf72563c, float:1.1948129E-29)
            if (r6 == r7) goto L_0x0079
            goto L_0x008d
        L_0x0079:
            java.lang.String r6 = "Bridgefy"
            boolean r13 = r13.equals(r6)
            if (r13 == 0) goto L_0x008d
            r13 = 0
            goto L_0x008e
        L_0x0083:
            java.lang.String r6 = "Bridgefy/thumbs"
            boolean r13 = r13.equals(r6)
            if (r13 == 0) goto L_0x008d
            r13 = 1
            goto L_0x008e
        L_0x008d:
            r13 = -1
        L_0x008e:
            r6 = 80
            switch(r13) {
                case 0: goto L_0x00b6;
                case 1: goto L_0x0094;
                default: goto L_0x0093;
            }
        L_0x0093:
            goto L_0x00ec
        L_0x0094:
            r13 = 360(0x168, float:5.04E-43)
            android.graphics.Bitmap r13 = android.media.ThumbnailUtils.extractThumbnail(r12, r13, r13)
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r14.<init>(r0)
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG
            r13.compress(r0, r6, r14)
            r14.flush()
            r14.close()
            r12.recycle()
            r13.recycle()
            goto L_0x00ec
        L_0x00b6:
            r9 = 4652218415073722368(0x4090000000000000, double:1024.0)
            double r2 = r2 / r9
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r13 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r13 > 0) goto L_0x00c5
            r13 = 4096(0x1000, float:5.74E-42)
            if (r14 > r13) goto L_0x00c5
            if (r0 <= r13) goto L_0x00ec
        L_0x00c5:
            int r14 = r14 * 2
            int r14 = r14 / 3
            int r0 = r0 * 2
            int r0 = r0 / 3
            android.graphics.Bitmap r13 = android.graphics.Bitmap.createScaledBitmap(r12, r14, r0, r8)
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r14.<init>(r0)
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG
            r13.compress(r0, r6, r14)
            r14.flush()
            r14.close()
            r12.recycle()
            r13.recycle()
        L_0x00ec:
            long r12 = r1.length()
            long r12 = r12 / r4
            double r12 = (double) r12
            java.lang.String r14 = f9701a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "New image size: "
            r0.append(r2)
            r0.append(r12)
            java.lang.String r12 = " KB"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.w(r14, r12)
            me.bridgefy.main.BridgefyApp r12 = p140me.bridgefy.main.BridgefyApp.m10557c()
            android.content.Intent r13 = new android.content.Intent
            java.lang.String r14 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            android.net.Uri r0 = android.net.Uri.fromFile(r1)
            r13.<init>(r14, r0)
            r12.sendBroadcast(r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.utils.C3667g.m10936a(android.graphics.Bitmap, java.lang.String, java.lang.String):java.io.File");
    }

    /* renamed from: b */
    private Bitmap m10944b(Context context, Uri uri) throws IOException {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
        openFileDescriptor.close();
        return decodeFileDescriptor;
    }

    /* renamed from: a */
    public File mo29835a() throws IOException {
        return File.createTempFile(m10948c(null), ".jpg", m10945b("Bridgefy"));
    }

    /* renamed from: b */
    private File m10945b(String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), str);
        file.mkdirs();
        return file;
    }

    /* renamed from: a */
    public static File m10937a(String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), str);
        file.mkdirs();
        return file;
    }

    /* renamed from: c */
    private static String m10948c(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("bridgefy");
        sb.append(new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
        if (str != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(".");
            sb2.append(str);
            str2 = sb2.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static HashMap m10938a(Uri uri) throws IllegalArgumentException {
        if (uri != null) {
            HashMap hashMap = new HashMap();
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.getPath());
            if (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("")) {
                fileExtensionFromUrl = "jpg";
            }
            hashMap.put("fileExt", fileExtensionFromUrl);
            hashMap.put("fileMime", singleton.getMimeTypeFromExtension(fileExtensionFromUrl));
            hashMap.put("fileName", m10948c(fileExtensionFromUrl));
            return hashMap;
        }
        throw new IllegalArgumentException("Uri cannot be null");
    }

    /* renamed from: a */
    public static void m10940a(View view, Activity activity) {
        if (activity != null) {
            Snackbar.make(view, (CharSequence) activity.getBaseContext().getString(R.string.storage_permission_denied_toast), -1).setAction((CharSequence) activity.getBaseContext().getString(R.string.permission_dialog_grant_access), (View.OnClickListener) new View.OnClickListener(activity) {
                private final /* synthetic */ Activity f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    C3659b.m10889a(this.f$0, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 4);
                }
            }).show();
        }
    }

    /* renamed from: a */
    public static byte[] m10943a(Message message, boolean z, Context context) throws IOException, IllegalArgumentException {
        byte[] bArr;
        Uri findFileUri = message.findFileUri();
        String str = f9701a;
        StringBuilder sb = new StringBuilder();
        sb.append("getDataMessageImage: image: ");
        sb.append(findFileUri);
        Log.w(str, sb.toString());
        InputStream openInputStream = context.getContentResolver().openInputStream(findFileUri);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(C3688b.m10972a(openInputStream));
            gZIPOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        } else {
            bArr = C3688b.m10972a(openInputStream);
        }
        byteArrayOutputStream.close();
        openInputStream.close();
        return bArr;
    }
}
