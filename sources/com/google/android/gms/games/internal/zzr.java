package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzr extends zza {
    private final TaskCompletionSource zza;

    zzr(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzp(int i, String str) {
        if (i == 0) {
            this.zza.setResult(str);
        } else {
            GamesStatusUtils.zzb(this.zza, i);
        }
    }
}
