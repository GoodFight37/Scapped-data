package com.google.android.gms.games.internal;

import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzn extends zza {
    private final TaskCompletionSource zza;

    zzn(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzd(int i, String str) {
        if (i == 0 || i == 3003) {
            this.zza.setResult(Boolean.valueOf(i == 3003));
        } else {
            GamesStatusUtils.zzb(this.zza, i);
        }
    }
}
