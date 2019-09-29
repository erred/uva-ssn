package com.bridgefy.sdk.client.registration;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bridgefy.sdk.client.CryptoRSA;
import com.bridgefy.sdk.logging.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.p154a.C3685a;

/* renamed from: com.bridgefy.sdk.client.registration.a */
class C1879a extends BridgefyCertificate {

    /* renamed from: d */
    private CertificateResponse f5835d;

    /* renamed from: e */
    private String[] f5836e;

    C1879a(CertificateResponse certificateResponse) {
        try {
            this.f5835d = certificateResponse;
            String[] split = new String(certificateResponse.getData()).split("\\|");
            this.f5829b = split[0];
            this.f5830c = this.f5828a.parse(split[1]);
            this.f5836e = split[2].split(",");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        try {
            boolean verifyData = CryptoRSA.verifyData(this.f5835d.getData(), this.f5835d.getSignature(), "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApo3jL37+YzSaMCRfClZRUeZHDQ62ur5ivE2dvBdCBZPOqH+RckEDWJquQKAHq23dVQAWWw9RgkMHR7j/dQPnOzg51mQ7uNEUB1wm3cSEVA2epxch8kzf/vwVxeVtUQf86j8fJy4QRgofYUZbTZTezWPe8YcX6n7fXWDXvVFs/pNalk8v7QKtliuL3ZGHNq088kAOAdjFsyW7xYbV7GjM5eHJL440vXWkIjceT4/GTqX091xRTDoBfn4BSHvx7NmN+l1YZ7wyyhoO9VigowqtM/UX82MyzI7LvRwqlvSg2GGgxnvvewmPT/92cZhXUztM+qRCEalTflqEv4bVr3pggwIDAQAB");
            boolean after = this.f5830c.after(Calendar.getInstance().getTime());
            if (verifyData && after) {
                StringBuilder sb = new StringBuilder();
                sb.append("Loaded expiration date is: ");
                sb.append(getExpirationDate().getTime());
                sb.append(" || current time:  ");
                sb.append(Calendar.getInstance().getTime().getTime());
                sb.append(" // ");
                sb.append(m7688a(0));
                sb.append(" [VALID]");
                Log.m8077v("BridgefyCertificate", sb.toString());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Loaded expiration date is: ");
        sb2.append(getExpirationDate());
        sb2.append(" || current time:  ");
        sb2.append(m7688a(0));
        sb2.append(" [INVALID]");
        Log.m8078w("BridgefyCertificate", sb2.toString());
        return false;
    }

    public void save(SharedPreferences sharedPreferences) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat.format(this.f5830c);
        Editor edit = sharedPreferences.edit();
        edit.putString("com.bridgefy.sdk.client.certificate.data", new String(this.f5835d.getData(), C3685a.f9716a));
        edit.putString("com.bridgefy.sdk.client.certificate.signature", new String(this.f5835d.getSignature(), C3685a.f9716a));
        edit.apply();
    }

    public String[] getBundleIds() {
        return this.f5836e;
    }

    /* renamed from: a */
    static BridgefyCertificate m7687a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("com.bridgefy.sdk.client.certificate.data", null);
        String string2 = sharedPreferences.getString("com.bridgefy.sdk.client.certificate.signature", null);
        if (string == null || string2 == null) {
            return null;
        }
        return new C1879a(new CertificateResponse(string.getBytes(C3685a.f9716a), string2.getBytes(C3685a.f9716a)));
    }

    /* renamed from: a */
    private static String m7688a(int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(instance.getTime());
        instance.add(10, i);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(instance.getTime());
    }
}
