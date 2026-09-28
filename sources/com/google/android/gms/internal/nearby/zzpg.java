package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzpg extends zzb implements zzph {
    public zzpg() {
        super("com.google.android.gms.nearby.uwb.internal.IUwbComplexChannelResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzqv zzqvVar = (zzqv) zzc.zza(parcel, zzqv.CREATOR);
        zzc.zzc(parcel);
        zzd(zzqvVar);
        return true;
    }
}
