package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactorSession;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzai implements Continuation<GetTokenResult, Task<MultiFactorSession>> {
    private final /* synthetic */ zzaj zza;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<MultiFactorSession> then(Task<GetTokenResult> task) throws Exception {
        return !task.isSuccessful() ? Tasks.forException(task.getException()) : Tasks.forResult(zzam.zza(task.getResult().getToken(), this.zza.zza));
    }

    zzai(zzaj zzajVar) {
        this.zza = zzajVar;
    }
}
