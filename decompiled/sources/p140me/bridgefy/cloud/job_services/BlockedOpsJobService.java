package p140me.bridgefy.cloud.job_services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.service.BridgefyService;

/* renamed from: me.bridgefy.cloud.job_services.BlockedOpsJobService */
public class BlockedOpsJobService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        try {
            new C3457c(BridgefyService.get_database_helper()).mo28321b();
        } catch (Exception unused) {
            Log.w("BlockedOpsJobService", "DatabaseHelper from the BridgefyService was null. Won't run BlockOperations");
        }
        return false;
    }
}
