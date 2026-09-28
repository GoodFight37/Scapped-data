package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.gamessignin.AuthResponse;
import com.google.android.gms.games.gamessignin.AuthScope;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzv extends zza {
    private final TaskCompletionSource zza;

    zzv(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzs(Status status, String str, List list) {
        if (status.isSuccess()) {
            this.zza.setResult(new AuthResponse(str, AuthScope.zzb(list)));
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zza;
        int i = zzah.zze;
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
    }
}
