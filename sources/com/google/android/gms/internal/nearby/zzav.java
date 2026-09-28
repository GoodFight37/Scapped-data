package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzav extends zzde {
    final /* synthetic */ TaskCompletionSource zza;

    zzav(zzax zzaxVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzdf
    public final void zzb(Status status, ExposureSummary exposureSummary) {
        TaskUtil.trySetResultOrApiException(status, exposureSummary, this.zza);
    }
}
