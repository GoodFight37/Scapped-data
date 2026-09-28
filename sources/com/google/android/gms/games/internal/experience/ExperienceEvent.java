package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public interface ExperienceEvent extends Freezable<ExperienceEvent>, Parcelable {
    @Deprecated
    String getIconImageUrl();

    String zza();

    Game zzb();

    String zzc();

    String zzd();

    Uri zze();

    long zzf();

    long zzg();

    long zzh();

    int zzi();

    int zzj();
}
