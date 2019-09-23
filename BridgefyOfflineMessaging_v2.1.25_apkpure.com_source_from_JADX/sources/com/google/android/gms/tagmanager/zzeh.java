package com.google.android.gms.tagmanager;

import android.net.Uri;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@ShowFirstParty
@VisibleForTesting
class zzeh {
    private static zzeh zzbea;
    private volatile String zzazo = null;
    private volatile zza zzbeb = zza.NONE;
    private volatile String zzbec = null;
    private volatile String zzbed = null;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzeh() {
    }

    @ShowFirstParty
    static zzeh zzpm() {
        zzeh zzeh;
        synchronized (zzeh.class) {
            if (zzbea == null) {
                zzbea = new zzeh();
            }
            zzeh = zzbea;
        }
        return zzeh;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized boolean zzb(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                String str = "Container preview url: ";
                String valueOf = String.valueOf(decode);
                zzdi.m8601v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                if (decode.matches(".*?&gtm_debug=x$")) {
                    this.zzbeb = zza.CONTAINER_DEBUG;
                } else {
                    this.zzbeb = zza.CONTAINER;
                }
                this.zzbed = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.zzbeb == zza.CONTAINER || this.zzbeb == zza.CONTAINER_DEBUG) {
                    String valueOf2 = String.valueOf("/r?");
                    String valueOf3 = String.valueOf(this.zzbed);
                    this.zzbec = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
                }
                this.zzazo = zzdx(this.zzbed);
                return true;
            } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                String str2 = "Invalid preview uri: ";
                String valueOf4 = String.valueOf(decode);
                zzdi.zzab(valueOf4.length() != 0 ? str2.concat(valueOf4) : new String(str2));
                return false;
            } else if (!zzdx(uri.getQuery()).equals(this.zzazo)) {
                return false;
            } else {
                String str3 = "Exit preview mode for container: ";
                String valueOf5 = String.valueOf(this.zzazo);
                zzdi.m8601v(valueOf5.length() != 0 ? str3.concat(valueOf5) : new String(str3));
                this.zzbeb = zza.NONE;
                this.zzbec = null;
                return true;
            }
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final zza zzpn() {
        return this.zzbeb;
    }

    /* access modifiers changed from: 0000 */
    public final String zzpo() {
        return this.zzbec;
    }

    /* access modifiers changed from: 0000 */
    public final String getContainerId() {
        return this.zzazo;
    }

    private static String zzdx(String str) {
        return str.split("&")[0].split(SimpleComparison.EQUAL_TO_OPERATION)[1];
    }
}
