package com.google.android.gms.games.multiplayer;

import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zza extends zzb {
    zza() {
    }

    @Override // com.google.android.gms.games.multiplayer.zzb, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.multiplayer.zzb
    /* JADX INFO: renamed from: zza */
    public final ParticipantEntity createFromParcel(Parcel parcel) {
        return (ParticipantEntity.zzp(ParticipantEntity.getUnparcelClientVersion()) || ParticipantEntity.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) ? super.createFromParcel(parcel) : new ParticipantEntity();
    }
}
