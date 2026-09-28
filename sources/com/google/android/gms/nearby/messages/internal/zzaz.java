package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaz implements OnCompleteListener {
    final /* synthetic */ TaskCompletionSource zza;

    zzaz(zzbh zzbhVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        if (task.isSuccessful()) {
            this.zza.setResult(null);
        } else {
            this.zza.setException((Exception) Preconditions.checkNotNull(task.getException()));
        }
    }
}
