package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzad extends com.google.android.gms.internal.common.zza implements zzaf {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final com.google.android.gms.common.zzu zze(com.google.android.gms.common.zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zzc(parcelZza, zzsVar);
        Parcel parcelZzB = zzB(6, parcelZza);
        com.google.android.gms.common.zzu zzuVar = (com.google.android.gms.common.zzu) com.google.android.gms.internal.common.zzc.zza(parcelZzB, com.google.android.gms.common.zzu.CREATOR);
        parcelZzB.recycle();
        return zzuVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final com.google.android.gms.common.zzu zzf(com.google.android.gms.common.zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zzc(parcelZza, zzsVar);
        Parcel parcelZzB = zzB(8, parcelZza);
        com.google.android.gms.common.zzu zzuVar = (com.google.android.gms.common.zzu) com.google.android.gms.internal.common.zzc.zza(parcelZzB, com.google.android.gms.common.zzu.CREATOR);
        parcelZzB.recycle();
        return zzuVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzg() throws RemoteException {
        Parcel parcelZzB = zzB(9, zza());
        boolean zZzf = com.google.android.gms.internal.common.zzc.zzf(parcelZzB);
        parcelZzB.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzh(com.google.android.gms.common.zzw zzwVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zzc(parcelZza, zzwVar);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, iObjectWrapper);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zZzf = com.google.android.gms.internal.common.zzc.zzf(parcelZzB);
        parcelZzB.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzB = zzB(7, zza());
        boolean zZzf = com.google.android.gms.internal.common.zzc.zzf(parcelZzB);
        parcelZzB.recycle();
        return zZzf;
    }
}
