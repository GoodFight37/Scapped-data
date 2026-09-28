package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjo extends zzb implements zzjp {
    public zzjo() {
        super("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzku zzkuVar = (zzku) zzc.zza(parcel, zzku.CREATOR);
            zzc.zzc(parcel);
            zzb(zzkuVar);
            return true;
        }
        if (i != 3) {
            return false;
        }
        zzc.zzc(parcel);
        return true;
    }
}
