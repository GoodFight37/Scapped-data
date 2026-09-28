package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzab extends zza {
    private final TaskCompletionSource zza;

    zzab(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzq(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode != 0 && statusCode != 3) {
            GamesStatusUtils.zzb(this.zza, statusCode);
            dataHolder.close();
            return;
        }
        PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
        try {
            PlayerStatsEntity playerStatsEntity = playerStatsBuffer.getCount() > 0 ? new PlayerStatsEntity(playerStatsBuffer.get(0)) : null;
            playerStatsBuffer.close();
            this.zza.setResult(new AnnotatedData(playerStatsEntity, statusCode == 3));
        } catch (Throwable th) {
            try {
                playerStatsBuffer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
