package p140me.bridgefy.cloud.job_services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;

/* renamed from: me.bridgefy.cloud.job_services.KeyUploadJobService */
public class KeyUploadJobService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("onStartJob: ");
        sb.append(jobParameters.getJobId());
        Log.i("KeyUploadJobService", sb.toString());
        final Editor edit = getSharedPreferences("BgfyPrefs", 0).edit();
        C3519c.m10313a((C3521a) new C3521a() {
            public void onComplete() {
                Log.d("KeyUploadJobService", "Uploaded Public key");
                edit.remove("pendingKeyUpload").apply();
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                edit.putBoolean("pendingKeyUpload", true).apply();
            }
        });
        return false;
    }
}
