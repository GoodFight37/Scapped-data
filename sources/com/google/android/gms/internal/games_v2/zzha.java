package com.google.android.gms.internal.games_v2;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzha extends zzfy {
    private final zzhd zza;

    zzha(zzhd zzhdVar, int i) {
        super(zzhdVar.size(), i);
        this.zza = zzhdVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzfy
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
