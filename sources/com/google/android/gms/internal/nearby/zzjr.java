package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjr extends zzb implements zzjs {
    public zzjr() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzli zzliVar = (zzli) zzc.zza(parcel, zzli.CREATOR);
            zzc.zzc(parcel);
            zzd(zzliVar);
            return true;
        }
        if (i == 3) {
            zzla zzlaVar = (zzla) zzc.zza(parcel, zzla.CREATOR);
            zzc.zzc(parcel);
            zzc(zzlaVar);
            return true;
        }
        if (i != 4) {
            return false;
        }
        zzc.zzc(parcel);
        return true;
    }
}
