package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzaa extends com.google.android.gms.internal.nearby.zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzd();
        return true;
    }
}
