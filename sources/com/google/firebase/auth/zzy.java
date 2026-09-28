package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzy implements Continuation<RecaptchaTasksClient, Task<Void>> {
    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<RecaptchaTasksClient> task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        Exception exception = task.getException();
        return Tasks.forException(new FirebaseAuthException("INTERNAL_ERROR", com.google.android.gms.internal.p002firebaseauthapi.zzae.zzb(exception != null ? exception.getMessage() : "")));
    }

    zzy(FirebaseAuth firebaseAuth) {
    }
}
