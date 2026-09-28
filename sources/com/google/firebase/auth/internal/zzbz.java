package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbz implements Continuation<RecaptchaTasksClient, Task<String>> {
    private final /* synthetic */ RecaptchaAction zza;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<String> then(Task<RecaptchaTasksClient> task) throws Exception {
        if (task.isSuccessful()) {
            return task.getResult().executeTask(this.zza);
        }
        Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
        if (!(exc instanceof zzbu)) {
            return Tasks.forException(exc);
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Ignoring error related to fetching recaptcha config - " + exc.getMessage());
        }
        return Tasks.forResult("");
    }

    zzbz(zzbx zzbxVar, RecaptchaAction recaptchaAction) {
        this.zza = recaptchaAction;
    }
}
