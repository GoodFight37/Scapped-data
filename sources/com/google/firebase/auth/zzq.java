package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzq implements Continuation<Void, Task<Void>> {
    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<Void> task) throws Exception {
        return (!task.isSuccessful() && (task.getException() instanceof FirebaseAuthException) && ((FirebaseAuthException) task.getException()).getErrorCode().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) ? Tasks.forResult(null) : task;
    }

    zzq(FirebaseAuth firebaseAuth) {
    }
}
