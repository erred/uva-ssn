package p140me.bridgefy.cloud.job_services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import p140me.bridgefy.cloud.C3517a;
import p140me.bridgefy.cloud.FirebaseIdService;

/* renamed from: me.bridgefy.cloud.job_services.RegIdJobService */
public class RegIdJobService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("onStartJob: ");
        sb.append(jobParameters.getJobId());
        Log.i("RegIdJobService", sb.toString());
        C3517a.m10259a(getApplicationContext());
        FirebaseIdService.m10252a(FirebaseInstanceId.getInstance().getToken(), getApplicationContext());
        return false;
    }
}
