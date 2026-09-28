package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzc extends zzd {
    zzc() {
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.zzd, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.zzd
    /* JADX INFO: renamed from: zza */
    public final RoomEntity createFromParcel(Parcel parcel) {
        return (RoomEntity.zzp(RoomEntity.getUnparcelClientVersion()) || RoomEntity.canUnparcelSafely(RoomEntity.class.getCanonicalName())) ? super.createFromParcel(parcel) : new RoomEntity();
    }
}
