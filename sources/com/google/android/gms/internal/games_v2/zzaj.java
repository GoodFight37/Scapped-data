package com.google.android.gms.internal.games_v2;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaj extends zza implements zzal {
    zzaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.recall.IRecallService");
    }

    @Override // com.google.android.gms.internal.games_v2.zzal
    public final void zzd(zzai zzaiVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzaiVar);
        parcelZza.writeString("unusedServerClientId");
        zzc(2, parcelZza);
    }
}
