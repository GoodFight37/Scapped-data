package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzc extends zzg implements CurrentPlayerInfo {
    private final com.google.android.gms.games.internal.player.zzd zza;

    public zzc(DataHolder dataHolder, int i, com.google.android.gms.games.internal.player.zzd zzdVar) {
        super(dataHolder, i);
        this.zza = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return zza.zzb(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ CurrentPlayerInfo freeze() {
        return new zza(this);
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return zzu(this.zza.zzL, 0);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return zza.zza(this);
    }

    public final String toString() {
        return zza.zzc(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(new zza(this), parcel, i);
    }

    public final boolean zza() {
        String str = this.zza.zzL;
        return hasColumn(str) && !hasNull(str);
    }
}
