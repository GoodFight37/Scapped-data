package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzs extends com.google.android.gms.internal.nearby.zza implements IInterface {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    public final void zzd(zzh zzhVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zze(parcelZza, zzhVar);
        zzv(7, parcelZza);
    }

    public final void zze(zzj zzjVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zze(parcelZza, zzjVar);
        zzv(9, parcelZza);
    }

    public final void zzf(zzbz zzbzVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zze(parcelZza, zzbzVar);
        zzv(1, parcelZza);
    }

    public final void zzg(zzcb zzcbVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zze(parcelZza, zzcbVar);
        zzv(8, parcelZza);
    }

    public final void zzh(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zze(parcelZza, subscribeRequest);
        zzv(3, parcelZza);
    }

    public final void zzi(zzce zzceVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zze(parcelZza, zzceVar);
        zzv(2, parcelZza);
    }

    public final void zzj(zzcg zzcgVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.nearby.zzc.zze(parcelZza, zzcgVar);
        zzv(4, parcelZza);
    }
}
