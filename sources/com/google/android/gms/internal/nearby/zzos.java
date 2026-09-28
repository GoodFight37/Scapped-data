package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzos extends zza implements IInterface {
    zzos(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.uwb.internal.INearbyUwbService");
    }

    public final void zzd(zznz zznzVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zznzVar);
        zzv(PointerIconCompat.TYPE_TEXT, parcelZza);
    }

    public final void zze(zzob zzobVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzobVar);
        zzv(1007, parcelZza);
    }

    public final void zzf(zzof zzofVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzofVar);
        zzv(1004, parcelZza);
    }

    public final void zzg(zzoj zzojVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzojVar);
        zzv(1003, parcelZza);
    }

    public final void zzh(zzon zzonVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzonVar);
        zzv(1002, parcelZza);
    }

    public final void zzi(zzpk zzpkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzpkVar);
        zzv(1001, parcelZza);
    }

    public final void zzj(zzqe zzqeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzqeVar);
        zzv(PointerIconCompat.TYPE_VERTICAL_TEXT, parcelZza);
    }

    public final void zzk(zzqi zzqiVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzqiVar);
        zzv(1005, parcelZza);
    }

    public final void zzl(zzqm zzqmVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzqmVar);
        zzv(1006, parcelZza);
    }
}
