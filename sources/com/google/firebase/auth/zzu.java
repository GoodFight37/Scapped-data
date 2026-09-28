package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzu implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ FirebaseAuth zzb;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) throws Exception {
        return !task.isSuccessful() ? Tasks.forException((Exception) Preconditions.checkNotNull(task.getException())) : this.zzb.zze.zza(this.zza, (String) Preconditions.checkNotNull(task.getResult().getToken()), "apple.com", this.zzb.zzk);
    }

    zzu(FirebaseAuth firebaseAuth, String str) {
        this.zza = str;
        this.zzb = firebaseAuth;
    }
}
