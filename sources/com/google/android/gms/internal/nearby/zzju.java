package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzju extends zzb implements zzjv {
    public zzju() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzks zzksVar = (zzks) zzc.zza(parcel, zzks.CREATOR);
            zzc.zzc(parcel);
            zzc(zzksVar);
            return true;
        }
        if (i == 3) {
            zzky zzkyVar = (zzky) zzc.zza(parcel, zzky.CREATOR);
            zzc.zzc(parcel);
            zzd(zzkyVar);
            return true;
        }
        if (i == 4) {
            zzla zzlaVar = (zzla) zzc.zza(parcel, zzla.CREATOR);
            zzc.zzc(parcel);
            zze(zzlaVar);
            return true;
        }
        if (i != 5) {
            return false;
        }
        zzkq zzkqVar = (zzkq) zzc.zza(parcel, zzkq.CREATOR);
        zzc.zzc(parcel);
        zzb(zzkqVar);
        return true;
    }
}
