package com.bridgefy.sdk.framework.controller;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.Keep;
import com.bridgefy.sdk.client.BridgefyException;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.registration.Registration;
import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import java.util.HashMap;
import p000a.p013b.C0355t;
import p000a.p013b.p014a.p016b.C0153a;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p038h.C0331a;
import p091b.C1596ac;
import p091b.C1647v;

public class Analytics {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static int f5838a;

    /* renamed from: b */
    private static SharedPreferences f5839b;

    /* renamed from: c */
    private static int[] f5840c;

    /* renamed from: d */
    private static String f5841d;

    /* renamed from: e */
    private static AnalyticsMessageHolder f5842e;

    @Keep
    private static class AnalyticsMessageHolder {
        @JsonProperty("info")
        @Expose
        HashMap<String, int[]> info = new HashMap<>();
        @JsonProperty("timestamp")
        @Expose
        String timestamp;
        @JsonProperty("type")
        @Expose
        int type = 0;

        AnalyticsMessageHolder() {
        }

        /* access modifiers changed from: 0000 */
        public int getType() {
            return this.type;
        }

        /* access modifiers changed from: 0000 */
        public void setType(int i) {
            this.type = i;
        }

        /* access modifiers changed from: 0000 */
        public HashMap<String, int[]> getInfo() {
            return this.info;
        }

        /* access modifiers changed from: 0000 */
        public void setInfo(HashMap<String, int[]> hashMap) {
            this.info = hashMap;
        }

        /* access modifiers changed from: 0000 */
        public String getTimestamp() {
            return this.timestamp;
        }

        /* access modifiers changed from: 0000 */
        public void setTimestamp(String str) {
            this.timestamp = str;
        }

        static AnalyticsMessageHolder create(String str) throws JsonSyntaxException {
            return (AnalyticsMessageHolder) new Gson().fromJson(str, AnalyticsMessageHolder.class);
        }

        public String toString() {
            return new Gson().toJson((Object) this);
        }

        /* access modifiers changed from: 0000 */
        public String prettyString() {
            return new GsonBuilder().setPrettyPrinting().create().toJson((Object) this);
        }
    }

    public enum EventType {
        BFAnalyticsMessageTypeDirectSent,
        BFAnalyticsMessageTypeDirectReceived,
        BFAnalyticsMessageTypeMeshSent,
        BFAnalyticsMessageTypeMeshReceived,
        BFAnalyticsMessageTypeBroadcastSent,
        BFAnalyticsMessageTypeBroadcastReceived
    }

    public static class NetworkJobService extends JobService {
        public boolean onStopJob(JobParameters jobParameters) {
            return true;
        }

        public boolean onStartJob(final JobParameters jobParameters) {
            new Thread() {
                public void run() {
                    AnalyticsMessageHolder a = Analytics.m7699e();
                    if (a != null) {
                        String timestamp = a.getTimestamp();
                        if (a.getInfo().size() > 0) {
                            SharedPreferences sharedPreferences = NetworkJobService.this.getApplicationContext().getSharedPreferences(BridgefyCore.PREFS_NAME, 0);
                            try {
                                a.setTimestamp(BridgefyUtils.getTimeStamp());
                                Log.v("NetworkJobService", a.toString());
                                String string = sharedPreferences.getString("com.bridgefy.sdk.key.token", null);
                                C1647v a2 = C1647v.m6791a("application/x-msgpack; charset=utf-8");
                                StringBuilder sb = new StringBuilder();
                                sb.append(Analytics.m7701g());
                                sb.append("/sdk/analytics");
                                C1596ac post = BridgefyUtils.post(a2, sb.toString(), Utils.fromEntityToMessagePack(a), string);
                                String f = post.mo6487h().mo6513f();
                                if (post.mo6483d()) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Bgfy Analytics reporting succeeded! Reported ");
                                    sb2.append(a.getInfo().size());
                                    sb2.append(" events.");
                                    Log.d("NetworkJobService", sb2.toString());
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("... ");
                                    sb3.append(f);
                                    Log.v("NetworkJobService", sb3.toString());
                                    Analytics.m7700f();
                                    a.setInfo(new HashMap());
                                    Analytics.f5838a = 0;
                                } else {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Bgfy Analytics reporting failed with code: ");
                                    sb4.append(post.mo6481c());
                                    sb4.append("\n");
                                    sb4.append(f);
                                    Log.w("NetworkJobService", sb4.toString());
                                    a.setTimestamp(timestamp);
                                    if (post.mo6481c() != 401 || Analytics.f5838a >= 3) {
                                        Analytics.f5838a = 0;
                                    } else {
                                        Log.w("NetworkJobService", "... request failed because of a problem with the token. Will try to recover by registering again.");
                                        Registration.requestToken(NetworkJobService.this.getApplicationContext(), sharedPreferences.getString(BridgefyCore.PREFS_USER_UUID, null)).mo564b(C0331a.m925b()).mo562a(C0153a.m534a()).mo563a((C0355t<? super T>) new C0355t<String>() {
                                            public void onSubscribe(C0161b bVar) {
                                            }

                                            /* renamed from: a */
                                            public void onSuccess(String str) {
                                                Log.v("NetworkJobService", "Restarting Analytics Job");
                                                NetworkJobService.this.onStartJob(jobParameters);
                                            }

                                            public void onError(Throwable th) {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("Token Request failed with http code: ");
                                                sb.append(((BridgefyException) th).getErrorCode());
                                                sb.append(", message: ");
                                                sb.append(th.getMessage());
                                                Log.e("NetworkJobService", sb.toString());
                                            }
                                        });
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                a.setTimestamp(timestamp);
                                Analytics.f5838a = 0;
                            } catch (Throwable th) {
                                Analytics.m7695b(a);
                                sharedPreferences.edit().putString("com.bridgefy.sdk.client.analytics.messages", a.toString()).apply();
                                throw th;
                            }
                            Analytics.m7695b(a);
                            sharedPreferences.edit().putString("com.bridgefy.sdk.client.analytics.messages", a.toString()).apply();
                            return;
                        }
                        Log.w("NetworkJobService", "Analytics cache was empty. Won't post anything.");
                        return;
                    }
                    Log.w("NetworkJobService", "Analytics module not yet initialized. Just wait it out.");
                }
            }.start();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static String m7701g() {
        return "https://sdk-bridgefy.firebaseapp.com/api/v2";
    }

    static void initialize(Context context) {
        f5839b = context.getSharedPreferences(BridgefyCore.PREFS_NAME, 0);
        try {
            f5842e = AnalyticsMessageHolder.create(f5839b.getString("com.bridgefy.sdk.client.analytics.messages", new AnalyticsMessageHolder().toString()));
        } catch (Exception unused) {
            f5842e = new AnalyticsMessageHolder();
        }
        m7700f();
        if (!m7696b(context)) {
            m7691a(context);
        }
    }

    /* renamed from: a */
    static void m7693a(EventType eventType) {
        try {
            int[] iArr = f5840c;
            int ordinal = eventType.ordinal();
            iArr[ordinal] = iArr[ordinal] + 1;
            f5842e.getInfo().put(f5841d, f5840c);
            f5839b.edit().putString("com.bridgefy.sdk.client.analytics.messages", f5842e.toString()).apply();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("Analaytics module must be initialized before registering an event.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static AnalyticsMessageHolder m7699e() {
        return f5842e;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m7695b(AnalyticsMessageHolder analyticsMessageHolder) {
        f5842e = analyticsMessageHolder;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m7700f() {
        f5841d = String.valueOf(System.currentTimeMillis() / 1000);
        f5840c = new int[]{0, 0, 0, 0, 0, 0};
    }

    /* renamed from: a */
    private static void m7691a(Context context) {
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new Builder(1337, new ComponentName(context, NetworkJobService.class)).setRequiredNetworkType(2).setRequiresCharging(false).setPeriodic(86400000).build());
        Log.i("Analytics", "Registered Analytics JobService.");
    }

    /* renamed from: b */
    private static boolean m7696b(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        boolean z = false;
        if (VERSION.SDK_INT >= 24) {
            if (jobScheduler.getPendingJob(1337) != null) {
                z = true;
            }
            return z;
        }
        for (JobInfo id : jobScheduler.getAllPendingJobs()) {
            if (id.getId() == 1337) {
                return true;
            }
        }
        return false;
    }
}
