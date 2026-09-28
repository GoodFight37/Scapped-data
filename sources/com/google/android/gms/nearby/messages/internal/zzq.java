package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzq extends com.google.android.gms.internal.nearby.zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Status status = (Status) com.google.android.gms.internal.nearby.zzc.zza(parcel, Status.CREATOR);
        com.google.android.gms.internal.nearby.zzc.zzc(parcel);
        zzd(status);
        return true;
    }
}
