package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzpd extends zzb implements zzpe {
    public zzpd() {
        super("com.google.android.gms.nearby.uwb.internal.IUwbAddressResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzqq zzqqVar = (zzqq) zzc.zza(parcel, zzqq.CREATOR);
        zzc.zzc(parcel);
        zzd(zzqqVar);
        return true;
    }
}
