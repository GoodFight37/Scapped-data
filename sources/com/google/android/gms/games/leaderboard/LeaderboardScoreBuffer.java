package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final zza zza;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zza = new zza(dataHolder.getMetadata());
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.mDataHolder, i);
    }

    public final zza zza() {
        return this.zza;
    }
}
