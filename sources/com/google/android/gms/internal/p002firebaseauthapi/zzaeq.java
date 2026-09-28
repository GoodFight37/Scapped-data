package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaeq<ResultT, CallbackT> implements zzaeh<ResultT> {
    private final zzaeg<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzaeq(zzaeg<ResultT, CallbackT> zzaegVar, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzaegVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeh
    public final void zza(ResultT resultt, Status status) {
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status != null) {
            if (this.zza.zzq != null) {
                this.zzb.setException(zzadr.zza(FirebaseAuth.getInstance(this.zza.zzc), this.zza.zzq, ("reauthenticateWithCredential".equals(this.zza.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) ? this.zza.zzd : null));
                return;
            } else if (this.zza.zzn != null) {
                this.zzb.setException(zzadr.zza(status, this.zza.zzn, this.zza.zzo, this.zza.zzp));
                return;
            } else {
                this.zzb.setException(zzadr.zza(status));
                return;
            }
        }
        this.zzb.setResult(resultt);
    }
}
