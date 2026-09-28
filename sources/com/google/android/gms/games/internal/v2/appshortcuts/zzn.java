package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
class zzn extends zzw {
    protected final TaskCompletionSource zza;

    zzn(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public void zzb(zzg zzgVar) {
        zzd(new Status(10));
    }

    public void zzc(Intent intent) {
        zzd(new Status(10));
    }

    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzx
    public final void zzd(Status status) {
        this.zza.trySetException(ApiExceptionUtil.fromStatus(status));
    }
}
