package com.google.firebase.auth.internal;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzagt;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbw implements Continuation<zzagt, Task<RecaptchaTasksClient>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzbx zzb;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<RecaptchaTasksClient> then(Task<zzagt> task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new zzbu((String) Preconditions.checkNotNull(((Exception) Preconditions.checkNotNull(task.getException())).getMessage())));
        }
        zzagt result = task.getResult();
        String strZza = result.zza();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(strZza)) {
            return Tasks.forException(new zzbu("No Recaptcha Enterprise siteKey configured for tenant/project " + this.zza));
        }
        List<String> listZza = com.google.android.gms.internal.p002firebaseauthapi.zzv.zza(JsonPointer.SEPARATOR).zza((CharSequence) strZza);
        String str = listZza.size() != 4 ? null : listZza.get(3);
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format " + strZza));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Successfully obtained site key for tenant " + this.zza);
        }
        Task<RecaptchaTasksClient> taskZza = this.zzb.zzb.zza((Application) this.zzb.zza.getApplicationContext(), str);
        zzbx.zza(this.zzb, result, taskZza, this.zza);
        return taskZza;
    }

    zzbw(zzbx zzbxVar, String str) {
        this.zza = str;
        this.zzb = zzbxVar;
    }
}
