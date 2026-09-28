package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzao extends IStatusCallback.Stub {
    final /* synthetic */ TaskCompletionSource zza;

    zzao(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        TaskUtil.trySetResultOrApiException(status, null, this.zza);
    }
}
