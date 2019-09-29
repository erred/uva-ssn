package com.p103a.p104a.p106b;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import org.json.JSONObject;

/* renamed from: com.a.a.b.g */
/* compiled from: CheckForUpdatesResponseTransform */
class C1742g {
    C1742g() {
    }

    /* renamed from: a */
    public C1741f mo7008a(JSONObject jSONObject) throws IOException {
        if (jSONObject == null) {
            return null;
        }
        C1741f fVar = new C1741f(jSONObject.optString(ImagesContract.URL, null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
        return fVar;
    }
}
