package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzag implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zza;

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) throws Exception {
        return FirebaseAuth.getInstance(this.zza.zza()).zza((ActionCodeSettings) null, (String) Preconditions.checkNotNull(task.getResult().getToken()));
    }

    zzag(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }
}
