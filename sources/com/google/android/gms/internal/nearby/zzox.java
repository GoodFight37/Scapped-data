package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzox extends zzb implements zzoy {
    public zzox() {
        super("com.google.android.gms.nearby.uwb.internal.IRangingSessionCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzpm zzpmVar = (zzpm) zzc.zza(parcel, zzpm.CREATOR);
            zzc.zzc(parcel);
            zzd(zzpmVar);
            return true;
        }
        if (i == 3) {
            zzpo zzpoVar = (zzpo) zzc.zza(parcel, zzpo.CREATOR);
            zzc.zzc(parcel);
            zze(zzpoVar);
            return true;
        }
        if (i != 4) {
            return false;
        }
        zzpq zzpqVar = (zzpq) zzc.zza(parcel, zzpq.CREATOR);
        zzc.zzc(parcel);
        zzf(zzpqVar);
        return true;
    }
}
