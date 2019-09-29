package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.api.client.http.UrlEncodedParser;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zzd implements Runnable {
    private static final Logger zzbd = new Logger("RevokeAccessOperation", new String[0]);
    private final String zzbe;
    private final StatusPendingResult zzbf = new StatusPendingResult((GoogleApiClient) null);

    private zzd(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzbe = str;
    }

    public final void run() {
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            String valueOf = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
            String valueOf2 = String.valueOf(this.zzbe);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).openConnection();
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, UrlEncodedParser.CONTENT_TYPE);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                zzbd.mo13499e("Unable to revoke access!", new Object[0]);
            }
            // Logger logger = zzbd;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.mo13497d(sb.toString(), new Object[0]);
        } catch (IOException e) {
            // Logger logger2 = zzbd;
            String str = "IOException when revoking access: ";
            String valueOf3 = String.valueOf(e.toString());
            logger2.mo13499e(valueOf3.length() != 0 ? str.concat(valueOf3) : new String(str), new Object[0]);
        } catch (Exception e2) {
            // Logger logger3 = zzbd;
            String str2 = "Exception when revoking access: ";
            String valueOf4 = String.valueOf(e2.toString());
            logger3.mo13499e(valueOf4.length() != 0 ? str2.concat(valueOf4) : new String(str2), new Object[0]);
        }
        this.zzbf.setResult(status);
    }

    public static PendingResult<Status> zzc(String str) {
        if (str == null) {
            return PendingResults.immediateFailedResult(new Status(4), null);
        }
        zzd zzd = new zzd(str);
        new Thread(zzd).start();
        return zzd.zzbf;
    }
}
