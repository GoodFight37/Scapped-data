package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaab implements OnCompleteListener {
    final /* synthetic */ TaskCompletionSource zaa;
    final /* synthetic */ zaac zab;

    zaab(zaac zaacVar, TaskCompletionSource taskCompletionSource) {
        this.zaa = taskCompletionSource;
        this.zab = zaacVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.zab.zab.remove(this.zaa);
    }
}
