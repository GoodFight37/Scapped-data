package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzak extends zzdl {
    final /* synthetic */ TaskCompletionSource zza;

    zzak(zzax zzaxVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzdm
    public final void zzb(Status status, int i) {
        TaskUtil.trySetResultOrApiException(status, Integer.valueOf(i), this.zza);
    }
}
