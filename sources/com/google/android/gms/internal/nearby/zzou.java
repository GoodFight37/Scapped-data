package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzou extends zzb implements zzov {
    public zzou() {
        super("com.google.android.gms.nearby.uwb.internal.IRangingCapabilitiesResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzps zzpsVar = (zzps) zzc.zza(parcel, zzps.CREATOR);
        zzc.zzc(parcel);
        zzd(zzpsVar);
        return true;
    }
}
