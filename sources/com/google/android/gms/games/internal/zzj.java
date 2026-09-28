package com.google.android.gms.games.internal;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzj extends com.google.android.gms.internal.games_v2.zzac {
    final /* synthetic */ zzah zza;

    zzj(zzah zzahVar) {
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzac
    public final com.google.android.gms.internal.games_v2.zzab zza() {
        return new zzt(this.zza);
    }
}
