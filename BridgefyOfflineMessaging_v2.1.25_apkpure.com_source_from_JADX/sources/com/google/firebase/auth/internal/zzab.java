package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.p052b.C0712a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaf;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzab {
    private static final Logger zzgg = new Logger("JSONParser", new String[0]);

    public static Map<String, Object> zzcw(String str) {
        Preconditions.checkNotEmpty(str);
        String[] split = str.split("\\.");
        if (split.length < 2) {
            Logger logger = zzgg;
            String str2 = "Invalid idToken ";
            String valueOf = String.valueOf(str);
            logger.mo13499e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
            return Collections.EMPTY_MAP;
        }
        try {
            Map<String, Object> zzcx = zzcx(new String(Base64Utils.decodeUrlSafeNoPadding(split[1]), "UTF-8"));
            if (zzcx == null) {
                zzcx = Collections.EMPTY_MAP;
            }
            return zzcx;
        } catch (UnsupportedEncodingException e) {
            zzgg.mo13498e("Unable to decode token", e, new Object[0]);
            return Collections.EMPTY_MAP;
        }
    }

    public static Map<String, Object> zzcx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zzb(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzaf((Throwable) e);
        }
    }

    @VisibleForTesting
    private static Map<String, Object> zzb(JSONObject jSONObject) throws JSONException {
        C0712a aVar = new C0712a();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzb((JSONObject) obj);
            }
            aVar.put(str, obj);
        }
        return aVar;
    }

    @VisibleForTesting
    private static List<Object> zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzb((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
