package com.p103a.p104a.p105a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p009d.C0075a;

/* renamed from: com.a.a.a.u */
/* compiled from: SessionEventTransform */
class C1732u implements C0075a<C1727s> {
    C1732u() {
    }

    /* renamed from: a */
    public byte[] mo154a(C1727s sVar) throws IOException {
        return mo6994b(sVar).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    /* renamed from: b */
    public JSONObject mo6994b(C1727s sVar) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            C1731t tVar = sVar.f5401a;
            jSONObject.put("appBundleId", tVar.f5426a);
            jSONObject.put("executionId", tVar.f5427b);
            jSONObject.put("installationId", tVar.f5428c);
            jSONObject.put("androidId", tVar.f5429d);
            jSONObject.put("advertisingId", tVar.f5430e);
            jSONObject.put("limitAdTrackingEnabled", tVar.f5431f);
            jSONObject.put("betaDeviceToken", tVar.f5432g);
            jSONObject.put("buildId", tVar.f5433h);
            jSONObject.put("osVersion", tVar.f5434i);
            jSONObject.put("deviceModel", tVar.f5435j);
            jSONObject.put("appVersionCode", tVar.f5436k);
            jSONObject.put("appVersionName", tVar.f5437l);
            jSONObject.put(Param.TIMESTAMP, sVar.f5402b);
            jSONObject.put(Param.TYPE, sVar.f5403c.toString());
            if (sVar.f5404d != null) {
                jSONObject.put("details", new JSONObject(sVar.f5404d));
            }
            jSONObject.put("customType", sVar.f5405e);
            if (sVar.f5406f != null) {
                jSONObject.put("customAttributes", new JSONObject(sVar.f5406f));
            }
            jSONObject.put("predefinedType", sVar.f5407g);
            if (sVar.f5408h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(sVar.f5408h));
            }
            return jSONObject;
        } catch (JSONException e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
