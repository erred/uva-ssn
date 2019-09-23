package p140me.bridgefy.cloud.job_services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.util.Log;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.cloud.C3517a;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3523c;

/* renamed from: me.bridgefy.cloud.job_services.UserUpdateJobService */
public class UserUpdateJobService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("onStartJob: ");
        sb.append(jobParameters.getJobId());
        Log.i("UserUpdateJobService", sb.toString());
        final SharedPreferences sharedPreferences = getSharedPreferences("BgfyPrefs", 0);
        C3519c.m10314a((C3523c) new C3523c<BgfyUser>() {
            /* renamed from: a */
            public void onSuccess(final BgfyUser bgfyUser) {
                new Thread() {
                    public void run() {
                        String string = sharedPreferences.getString("pendingChangeUsername", null);
                        if (string != null) {
                            bgfyUser.setPublicName(string);
                        }
                        String string2 = sharedPreferences.getString("pendingPhoneUpdate", null);
                        if (string2 != null) {
                            bgfyUser.setPhone(string2);
                        }
                        try {
                            C3517a.m10256a().mo29192b(bgfyUser);
                            Log.d("UserUpdateJobService", "Updated username in backend");
                            sharedPreferences.edit().remove("pendingChangeUsername").apply();
                            sharedPreferences.edit().remove("pendingPhoneUpdate").apply();
                        } catch (Exception e) {
                            C35251.this.onError(e);
                        }
                    }
                }.start();
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
        return false;
    }
}
