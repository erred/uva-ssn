package p140me.bridgefy.cloud;

import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import p140me.bridgefy.cloud.job_services.BlockedOpsJobService;
import p140me.bridgefy.cloud.job_services.KeyUploadJobService;
import p140me.bridgefy.cloud.job_services.RegIdJobService;
import p140me.bridgefy.cloud.job_services.UserUpdateJobService;

/* renamed from: me.bridgefy.cloud.b */
/* compiled from: JobSchedulerFactory */
public class C3518b {
    /* renamed from: a */
    public static void m10290a(Context context, int i) {
        m10291a(context, i, 3600000);
    }

    /* renamed from: a */
    public static void m10291a(Context context, int i, long j) {
        ComponentName componentName;
        StringBuilder sb = new StringBuilder();
        sb.append("RegisteringJobService, JOB_ID = [");
        sb.append(i);
        sb.append("]");
        Log.d("JobSchedulerFactory", sb.toString());
        switch (i) {
            case 6001:
                componentName = new ComponentName(context, KeyUploadJobService.class);
                break;
            case 6002:
                componentName = new ComponentName(context, RegIdJobService.class);
                break;
            case 6003:
                componentName = new ComponentName(context, UserUpdateJobService.class);
                break;
            case 6004:
                componentName = new ComponentName(context, BlockedOpsJobService.class);
                break;
            default:
                componentName = null;
                break;
        }
        Builder periodic = new Builder(i, componentName).setRequiredNetworkType(1).setPeriodic(j);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.schedule(periodic.build());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Registered job: ");
            sb2.append(i);
            Log.v("JobSchedulerFactory", sb2.toString());
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Wanted to register JobService but unable  to acquire JOB_SCHEDULER_SERVICE system service [JOB_ID:");
        sb3.append(i);
        sb3.append("]");
        Log.w("JobSchedulerFactory", sb3.toString());
    }

    /* renamed from: a */
    public static void m10289a(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancelAll();
            Log.w("JobSchedulerFactory", "Cancelled all pending JobSchedule jobs");
            return;
        }
        Log.w("JobSchedulerFactory", "Wanted to cancell All Jobs but unable to acquire JOB_SCHEDULER_SERVICE system service");
    }
}
