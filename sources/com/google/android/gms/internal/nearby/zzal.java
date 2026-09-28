package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzal extends zzcx {
    final /* synthetic */ TaskCompletionSource zza;

    zzal(zzax zzaxVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzcy
    public final void zzb(Status status, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        TaskUtil.trySetResultOrApiException(status, diagnosisKeysDataMapping, this.zza);
    }
}
