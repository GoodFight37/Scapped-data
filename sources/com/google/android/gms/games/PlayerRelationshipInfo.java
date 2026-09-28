package com.google.android.gms.games;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public interface PlayerRelationshipInfo extends Freezable<PlayerRelationshipInfo>, Parcelable {
    int getFriendStatus();

    String zza();

    String zzb();

    String zzc();
}
