package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzc extends DataBufferRef implements zza {
    private final zzd zza;

    public zzc(DataHolder dataHolder, int i, zzd zzdVar) {
        super(dataHolder, i);
        this.zza = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zzh(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return MostRecentGameInfoEntity.zzg(this);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzi(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(new MostRecentGameInfoEntity(this), parcel, i);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zza() {
        return getString(this.zza.zzt);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzb() {
        return getString(this.zza.zzu);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final long zzc() {
        return getLong(this.zza.zzv);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzd() {
        return parseUri(this.zza.zzw);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zze() {
        return parseUri(this.zza.zzx);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzf() {
        return parseUri(this.zza.zzy);
    }
}
