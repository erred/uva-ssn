package com.twitter.sdk.android.tweetcomposer;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import p140me.bridgefy.ormlite.entities.MessageDTO;

/* renamed from: com.twitter.sdk.android.tweetcomposer.d */
/* compiled from: FileUtils */
class C3297d {
    @TargetApi(19)
    /* renamed from: a */
    static String m9622a(Context context, Uri uri) {
        if ((VERSION.SDK_INT >= 19) && m9626a(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if (!MessageDTO.IMAGE.equals(split[0])) {
                return null;
            }
            return m9623a(context, Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{split[1]});
        } else if (m9627b(uri)) {
            return m9623a(context, uri, null, null);
        } else {
            if (m9628c(uri)) {
                return uri.getPath();
            }
            return null;
        }
    }

    /* renamed from: a */
    static boolean m9626a(Uri uri) {
        return "com.android.providers.media.documents".equalsIgnoreCase(uri.getAuthority());
    }

    /* renamed from: b */
    static boolean m9627b(Uri uri) {
        return Param.CONTENT.equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: c */
    static boolean m9628c(Uri uri) {
        return "file".equalsIgnoreCase(uri.getScheme());
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String m9623a(android.content.Context r7, android.net.Uri r8, java.lang.String r9, java.lang.String[] r10) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r0 = 0
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ all -> 0x0033 }
            r6 = 0
            r2 = r8
            r4 = r9
            r5 = r10
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x002d
            boolean r8 = r7.moveToFirst()     // Catch:{ all -> 0x002b }
            if (r8 == 0) goto L_0x002d
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x002b }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ all -> 0x002b }
            if (r7 == 0) goto L_0x002a
            r7.close()
        L_0x002a:
            return r8
        L_0x002b:
            r8 = move-exception
            goto L_0x0035
        L_0x002d:
            if (r7 == 0) goto L_0x0032
            r7.close()
        L_0x0032:
            return r0
        L_0x0033:
            r8 = move-exception
            r7 = r0
        L_0x0035:
            if (r7 == 0) goto L_0x003a
            r7.close()
        L_0x003a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetcomposer.C3297d.m9623a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    /* renamed from: a */
    static String m9624a(File file) {
        String a = m9625a(file.getName());
        return !TextUtils.isEmpty(a) ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(a) : "application/octet-stream";
    }

    /* renamed from: a */
    static String m9625a(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            str2 = "";
        } else {
            str2 = str.substring(lastIndexOf + 1);
        }
        return str2;
    }
}
