package com.bridgefy.sdk.client.registration;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.bridgefy.sdk.client.BridgefyException;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.framework.controller.BridgefyCore;
import com.bridgefy.sdk.framework.utils.Utils;
import com.bridgefy.sdk.logging.Log;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p013b.C0353r;
import p000a.p013b.C0354s;
import p000a.p013b.C0355t;
import p000a.p013b.C0356u;
import p000a.p013b.C0357v;
import p000a.p013b.p014a.p016b.C0153a;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p038h.C0331a;
import p091b.C1596ac;
import p091b.C1647v;

public class Registration {

    /* renamed from: a */
    private static int f5831a;

    /* renamed from: a */
    private static String m7682a() {
        return "https://sdk-bridgefy.firebaseapp.com/api/v2";
    }

    public static C0353r<String> requestToken(Context context, String str) {
        return C0353r.m949a((C0356u<T>) new C0356u(context, str) {
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(C0354s sVar) {
                Registration.m7683a(this.f$0, this.f$1, sVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m7683a(Context context, String str, C0354s sVar) throws Exception {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BridgefyCore.PREFS_NAME, 0);
        String string = sharedPreferences.getString("com.bridgefy.sdk.key.token", null);
        if (string != null && m7685b(string)) {
            sVar.mo463a(string);
        } else if (f5831a <= 3) {
            try {
                C1647v a = C1647v.m6791a("application/x-msgpack; charset=utf-8");
                StringBuilder sb = new StringBuilder();
                sb.append(m7682a());
                sb.append("/sdk");
                C1596ac post = BridgefyUtils.post(a, sb.toString(), Utils.fromEntityToMessagePack(new RegistrationRequest(context, str)), null);
                String f = post.mo6487h().mo6513f();
                if (post.mo6483d()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Registration post successful: ");
                    sb2.append(f);
                    Log.m8076i("Registration", sb2.toString());
                    String token = ((RegistrationResponse) new Gson().fromJson(new Gson().toJson(((Response) new Gson().fromJson(f, Response.class)).getData()), RegistrationResponse.class)).getToken();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("... received token: ");
                    sb3.append(token);
                    Log.m8073d("Registration", sb3.toString());
                    sharedPreferences.edit().putString("com.bridgefy.sdk.key.token", token).apply();
                    sVar.mo463a(token);
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Registration (Token Request) failed with http code: ");
                sb4.append(post.mo6481c());
                sb4.append(", body: ");
                sb4.append(f);
                Log.m8074e("Registration", sb4.toString());
                ErrorResponse errorResponse = (ErrorResponse) new Gson().fromJson(f, ErrorResponse.class);
                int code = errorResponse.getCode();
                if (errorResponse.getMessage() != null) {
                    f = errorResponse.getMessage();
                }
                sVar.mo464a((Throwable) new BridgefyException(code, f));
            } catch (SSLHandshakeException e) {
                e.printStackTrace();
                sVar.mo464a((Throwable) new BridgefyException(-2, e.getMessage()));
            } catch (IOException e2) {
                f5831a++;
                sVar.mo464a((Throwable) e2);
            } catch (Exception e3) {
                e3.printStackTrace();
                sVar.mo464a((Throwable) new BridgefyException(-66, e3.getMessage()));
            }
        } else {
            sVar.mo464a((Throwable) new BridgefyException(-66, "Max requests achieved"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static C0353r<BridgefyCertificate> m7681a(String str) {
        return C0353r.m949a((C0356u<T>) new C0356u(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(C0354s sVar) {
                Registration.m7684a(this.f$0, sVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m7684a(String str, C0354s sVar) throws Exception {
        try {
            C1880b bVar = new C1880b(BridgefyUtils.getTimeStamp());
            Log.m8077v("Registration", bVar.toString());
            C1647v a = C1647v.m6791a("application/x-msgpack; charset=utf-8");
            StringBuilder sb = new StringBuilder();
            sb.append(m7682a());
            sb.append("/sdk/validation");
            C1596ac post = BridgefyUtils.post(a, sb.toString(), Utils.fromEntityToMessagePack(bVar), str);
            if (post.mo6483d()) {
                Log.m8073d("Registration", "... Request successful! Unpacking valid CertificateResponse...");
                C1879a aVar = new C1879a((CertificateResponse) Utils.fromMessagePacktoEntity(Utils.fromStringRepresentedArrayToByteArray(new Gson().toJson(((Response) new Gson().fromJson(post.mo6487h().mo6513f(), Response.class)).getData())), CertificateResponse.class));
                if (m7686c(aVar.getTimestamp())) {
                    f5831a = 0;
                    sVar.mo463a(aVar);
                    return;
                }
                sVar.mo464a((Throwable) new BridgefyException(-2, "Double check your device settings. Are the date and time correct?"));
                return;
            }
            String f = post.mo6487h().mo6513f();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate Request failed with http code: ");
            sb2.append(post.mo6481c());
            sb2.append("\n");
            sb2.append(f);
            Log.m8078w("Registration", sb2.toString());
            ErrorResponse errorResponse = (ErrorResponse) new Gson().fromJson(f, ErrorResponse.class);
            if (errorResponse.getMessage() != null) {
                f = errorResponse.getMessage();
            }
            sVar.mo464a((Throwable) new BridgefyException(-2, f));
        } catch (IOException e) {
            Log.m8074e("Registration", e.getMessage());
            sVar.mo464a((Throwable) new BridgefyException(-1, e.getMessage()));
        } catch (Exception e2) {
            Log.m8074e("Registration", e2.getMessage());
            sVar.mo464a((Throwable) new BridgefyException(-66, e2.getMessage()));
        }
    }

    public static void requestCertificate(Context context, String str, C0355t<BridgefyCertificate> tVar) {
        requestToken(context, str).mo561a((C0181e<? super T, ? extends C0357v<? extends R>>) $$Lambda$Registration$7naBJQagGGvEkyUBFzoGaXAYIc.INSTANCE).mo564b(C0331a.m925b()).mo562a(C0153a.m534a()).mo563a(tVar);
    }

    public static BridgefyCertificate loadCertificate(SharedPreferences sharedPreferences) {
        return C1879a.m7687a(sharedPreferences);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        if (r3 != null) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2 A[SYNTHETIC, Splitter:B:31:0x00a2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bridgefy.sdk.client.registration.BridgefyCertificate loadCertificate(android.content.Context r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.String r2 = "APPLICATION_ID"
            java.lang.Object r2 = com.bridgefy.sdk.framework.utils.Utils.getBuildConfigValue(r6, r2)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.lang.String r3 = "Registration"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            r4.<init>()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.lang.String r5 = "loadCertificate: APPLICATION_ID: "
            r4.append(r5)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            r4.append(r2)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            com.bridgefy.sdk.logging.Log.m8073d(r3, r4)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            if (r2 != 0) goto L_0x0029
            android.content.Context r2 = r6.getApplicationContext()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
        L_0x0029:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.io.InputStream r6 = r6.open(r2)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            java.lang.String r2 = "UTF-8"
            r4.<init>(r6, r2)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
            r3.<init>(r4)     // Catch:{ Exception -> 0x007f, all -> 0x007c }
        L_0x0041:
            java.lang.String r6 = r3.readLine()     // Catch:{ Exception -> 0x007a }
            if (r6 == 0) goto L_0x0057
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
            r2.<init>()     // Catch:{ Exception -> 0x007a }
            r2.append(r0)     // Catch:{ Exception -> 0x007a }
            r2.append(r6)     // Catch:{ Exception -> 0x007a }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x007a }
            goto L_0x0041
        L_0x0057:
            byte[] r6 = com.bridgefy.sdk.client.CryptoRSA.bytesFromBase64(r0)     // Catch:{ Exception -> 0x007a }
            java.lang.Class<com.bridgefy.sdk.client.registration.CertificateResponse> r0 = com.bridgefy.sdk.client.registration.CertificateResponse.class
            java.lang.Object r6 = com.bridgefy.sdk.framework.utils.Utils.fromMessagePacktoEntity(r6, r0)     // Catch:{ Exception -> 0x007a }
            com.bridgefy.sdk.client.registration.CertificateResponse r6 = (com.bridgefy.sdk.client.registration.CertificateResponse) r6     // Catch:{ Exception -> 0x007a }
            com.bridgefy.sdk.client.registration.a r0 = new com.bridgefy.sdk.client.registration.a     // Catch:{ Exception -> 0x007a }
            r0.<init>(r6)     // Catch:{ Exception -> 0x007a }
            java.lang.String r6 = r0.getTimestamp()     // Catch:{ Exception -> 0x007a }
            boolean r6 = m7686c(r6)     // Catch:{ Exception -> 0x007a }
            if (r6 == 0) goto L_0x0076
            r3.close()     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            return r0
        L_0x0076:
            r3.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x009e
        L_0x007a:
            r6 = move-exception
            goto L_0x0081
        L_0x007c:
            r6 = move-exception
            r3 = r1
            goto L_0x00a0
        L_0x007f:
            r6 = move-exception
            r3 = r1
        L_0x0081:
            java.lang.String r0 = "Registration"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r2.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r4 = "BridgefySDK not started: \nCertified preloaded invalid, error cause: "
            r2.append(r4)     // Catch:{ all -> 0x009f }
            java.lang.Throwable r6 = r6.fillInStackTrace()     // Catch:{ all -> 0x009f }
            r2.append(r6)     // Catch:{ all -> 0x009f }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x009f }
            com.bridgefy.sdk.logging.Log.m8074e(r0, r6)     // Catch:{ all -> 0x009f }
            if (r3 == 0) goto L_0x009e
            goto L_0x0076
        L_0x009e:
            return r1
        L_0x009f:
            r6 = move-exception
        L_0x00a0:
            if (r3 == 0) goto L_0x00a5
            r3.close()     // Catch:{ IOException -> 0x00a5 }
        L_0x00a5:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.client.registration.Registration.loadCertificate(android.content.Context):com.bridgefy.sdk.client.registration.BridgefyCertificate");
    }

    /* renamed from: b */
    private static boolean m7685b(String str) {
        String[] split = str.split("\\.");
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[2];
        try {
            str3 = new String(Base64.decode(str3, 0), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String str5 = "Registration";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("token: ");
            sb.append(str3);
            Log.m8073d(str5, sb.toString());
            long j = new JSONObject(str3).getLong("exp");
            Timestamp timestamp = new Timestamp(j);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bridgefyToken expires in: ");
            sb2.append((j - currentTimeMillis) / 60);
            sb2.append(" minutes.");
            Log.m8077v("Registration", sb2.toString());
            return new Timestamp(currentTimeMillis).before(timestamp);
        } catch (JSONException e2) {
            Log.m8075e("Registration", "Token error: ", e2);
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m7686c(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date parse = simpleDateFormat.parse(str);
            Date date = new Date(System.currentTimeMillis());
            date.setTime(date.getTime() + 43200000);
            return date.after(parse);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
