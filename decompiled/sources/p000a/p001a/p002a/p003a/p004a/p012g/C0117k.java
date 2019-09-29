package p000a.p001a.p002a.p003a.p004a.p012g;

import com.google.android.gms.common.internal.ImagesContract;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p006b.C0025k;
import p140me.bridgefy.ormlite.entities.MessageDTO;

/* renamed from: a.a.a.a.a.g.k */
/* compiled from: DefaultSettingsJsonTransform */
class C0117k implements C0130v {
    C0117k() {
    }

    /* renamed from: a */
    public C0128t mo259a(C0025k kVar, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", DateTimeConstants.SECONDS_PER_HOUR);
        C0128t tVar = new C0128t(m395a(kVar, (long) optInt2, jSONObject), m396a(jSONObject.getJSONObject("app")), m400e(jSONObject.getJSONObject("session")), m401f(jSONObject.getJSONObject("prompt")), m398c(jSONObject.getJSONObject("features")), m399d(jSONObject.getJSONObject("analytics")), m402g(jSONObject.getJSONObject("beta")), optInt, optInt2);
        return tVar;
    }

    /* renamed from: a */
    private C0111e m396a(JSONObject jSONObject) throws JSONException {
        C0111e eVar = new C0111e(jSONObject.getString("identifier"), jSONObject.getString(MessageDTO.STATUS), jSONObject.getString(ImagesContract.URL), jSONObject.getString("reports_url"), jSONObject.optBoolean("update_required", false), (!jSONObject.has("icon") || !jSONObject.getJSONObject("icon").has("hash")) ? null : m397b(jSONObject.getJSONObject("icon")));
        return eVar;
    }

    /* renamed from: b */
    private C0109c m397b(JSONObject jSONObject) throws JSONException {
        return new C0109c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    /* renamed from: c */
    private C0119m m398c(JSONObject jSONObject) {
        return new C0119m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    /* renamed from: d */
    private C0108b m399d(JSONObject jSONObject) {
        C0108b bVar = new C0108b(jSONObject.optString(ImagesContract.URL, "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
        return bVar;
    }

    /* renamed from: e */
    private C0122p m400e(JSONObject jSONObject) throws JSONException {
        C0122p pVar = new C0122p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
        return pVar;
    }

    /* renamed from: f */
    private C0121o m401f(JSONObject jSONObject) throws JSONException {
        C0121o oVar = new C0121o(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString(MessageDTO.MESSAGE, "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
        return oVar;
    }

    /* renamed from: g */
    private C0112f m402g(JSONObject jSONObject) throws JSONException {
        return new C0112f(jSONObject.optString("update_endpoint", C0129u.f297a), jSONObject.optInt("update_suspend_duration", DateTimeConstants.SECONDS_PER_HOUR));
    }

    /* renamed from: a */
    private long m395a(C0025k kVar, long j, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return kVar.mo49a() + (j * 1000);
    }
}
