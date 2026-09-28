package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzb extends zzc {
    zzb() {
    }

    @Override // com.google.android.gms.games.internal.game.zzc, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.internal.game.zzc
    /* JADX INFO: renamed from: zza */
    public final GameBadgeEntity createFromParcel(Parcel parcel) {
        if (GameBadgeEntity.zzp(GameBadgeEntity.getUnparcelClientVersion()) || GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        int i = parcel.readInt();
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        return new GameBadgeEntity(i, string, string2, string3 == null ? null : Uri.parse(string3));
    }
}
