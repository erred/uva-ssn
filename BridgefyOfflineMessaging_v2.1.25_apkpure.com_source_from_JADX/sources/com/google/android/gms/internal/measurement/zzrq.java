package com.google.android.gms.internal.measurement;

import com.google.android.gms.tagmanager.zzdi;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class zzrq implements zzrr {
    private HttpURLConnection zzbop;
    private InputStream zzboq = null;

    zzrq() {
    }

    public final InputStream zzez(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzbop = httpURLConnection;
        HttpURLConnection httpURLConnection2 = this.zzbop;
        int responseCode = httpURLConnection2.getResponseCode();
        if (responseCode == 200) {
            this.zzboq = httpURLConnection2.getInputStream();
            return this.zzboq;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Bad response: ");
        sb.append(responseCode);
        String sb2 = sb.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(sb2);
        } else if (responseCode == 503) {
            throw new zzrt(sb2);
        } else {
            throw new IOException(sb2);
        }
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzbop;
        try {
            if (this.zzboq != null) {
                this.zzboq.close();
            }
        } catch (IOException e) {
            String str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ";
            String valueOf = String.valueOf(e.getMessage());
            zzdi.zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
