package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjx extends zzb implements zzjy {
    public zzjx() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzkw zzkwVar = (zzkw) zzc.zza(parcel, zzkw.CREATOR);
        zzc.zzc(parcel);
        zzb(zzkwVar);
        return true;
    }
}
