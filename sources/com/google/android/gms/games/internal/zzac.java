package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzac extends zza {
    final /* synthetic */ zzah zza;
    private final TaskCompletionSource zzb;

    zzac(zzah zzahVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzh(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 10003) {
            this.zza.zzT(this.zzb);
            dataHolder.close();
            return;
        }
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            this.zzb.setResult(new AnnotatedData(new PlayerBuffer(dataHolder), z));
        } else {
            GamesStatusUtils.zzb(this.zzb, statusCode);
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzaj
    public final void zzi(DataHolder dataHolder) {
        zzh(dataHolder);
    }
}
