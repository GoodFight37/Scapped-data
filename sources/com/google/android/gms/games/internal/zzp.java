package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzp extends zza {
    private final TaskCompletionSource zza;

    zzp(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzb(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 0 || statusCode == 3) {
            this.zza.setResult(new AnnotatedData(new AchievementBuffer(dataHolder), statusCode == 3));
        } else {
            GamesStatusUtils.zzb(this.zza, statusCode);
            dataHolder.close();
        }
    }
}
