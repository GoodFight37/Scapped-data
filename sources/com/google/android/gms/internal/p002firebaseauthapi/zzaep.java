package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzaep {
    zzado zza;
    Executor zzb;

    public final <ResultT> Task<ResultT> zza(final zzaer<ResultT> zzaerVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzaes
            @Override // java.lang.Runnable
            public final void run() {
                zzaerVar.zza(taskCompletionSource, this.zza.zza);
            }
        });
        return taskCompletionSource.getTask();
    }
}
