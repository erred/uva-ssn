package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement.Event;

public class zzcu {
    public static final String[] zzaqq = {"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter"};
    public static final String[] zzaqr = {"_cd", Event.APP_EXCEPTION, "_ui", "_ug", "_in", "_au", "_cmp", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", Event.AD_REWARD, "_vs", "_ep"};

    protected zzcu() {
    }

    public static String zzcn(String str) {
        return zzdw.zza(str, zzaqr, zzaqq);
    }

    public static String zzco(String str) {
        return zzdw.zza(str, zzaqq, zzaqr);
    }
}
