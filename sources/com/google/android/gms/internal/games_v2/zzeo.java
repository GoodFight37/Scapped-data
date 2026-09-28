package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.RecallAccess;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzeo extends zzfl {
    final /* synthetic */ TaskCompletionSource zza;

    zzeo(zzer zzerVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzerVar);
    }

    @Override // com.google.android.gms.internal.games_v2.zzfl, com.google.android.gms.internal.games_v2.zzai
    public final void zzb(zzam zzamVar) {
        this.zza.setResult(RecallAccess.zza(zzamVar));
    }

    @Override // com.google.android.gms.internal.games_v2.zzfl, com.google.android.gms.internal.games_v2.zzai
    public final void zzc(Status status) {
        this.zza.setException(new ApiException(status));
    }
}
