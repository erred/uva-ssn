package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzad {
    private Logger zzgg = new Logger("StorageHelpers", new String[0]);
    private Context zzjx;
    private String zzrw;
    private SharedPreferences zzrx = this.zzjx.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.zzrw}), 0);

    public zzad(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzrw = Preconditions.checkNotEmpty(str);
        this.zzjx = context.getApplicationContext();
    }

    public final void zzg(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String zzi = zzi(firebaseUser);
        if (!TextUtils.isEmpty(zzi)) {
            this.zzrx.edit().putString("com.google.firebase.auth.FIREBASE_USER", zzi).apply();
        }
    }

    public final FirebaseUser zzeo() {
        String string = this.zzrx.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has(Param.TYPE)) {
                if ("com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString(Param.TYPE))) {
                    return zzc(jSONObject);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void zza(FirebaseUser firebaseUser, zzcz zzcz) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcz);
        this.zzrx.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), zzcz.zzdz()).apply();
    }

    public final zzcz zzh(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzrx.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), null);
        if (string != null) {
            return zzcz.zzcf(string);
        }
        return null;
    }

    public final void clear(String str) {
        this.zzrx.edit().remove(str).apply();
    }

    private final String zzi(FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzl.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzl zzl = (zzl) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzl.zzch());
            jSONObject.put("applicationName", zzl.zzcc().getName());
            jSONObject.put(Param.TYPE, "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzl.zzef() != null) {
                JSONArray jSONArray = new JSONArray();
                List zzef = zzl.zzef();
                for (int i = 0; i < zzef.size(); i++) {
                    jSONArray.put(((zzh) zzef.get(i)).zzdz());
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzl.isAnonymous());
            jSONObject.put("version", "2");
            if (zzl.getMetadata() != null) {
                jSONObject.put("userMetadata", ((zzn) zzl.getMetadata()).zzeg());
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.zzgg.wtf("Failed to turn object into JSON", e, new Object[0]);
            throw new zzaf((Throwable) e);
        }
    }

    private final zzl zzc(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = "2";
            String string3 = jSONObject.getString("version");
            if (string3 != null) {
                str = string3;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("userInfos");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzh.zzcs(jSONArray.getString(i)));
            }
            zzl zzl = new zzl(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzl.zza(zzcz.zzcf(string));
            }
            if (!z) {
                zzl.zzce();
            }
            zzl.zzct(str);
            if (jSONObject.has("userMetadata")) {
                zzn zza = zzn.zza(jSONObject.getJSONObject("userMetadata"));
                if (zza != null) {
                    zzl.zza(zza);
                }
            }
            return zzl;
        } catch (zzaf | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            this.zzgg.wtf(e);
            return null;
        }
    }
}
