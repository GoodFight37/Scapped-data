package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkl extends zzb implements zzkm {
    public zzkl() {
        super("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        zzlm zzlmVar = (zzlm) zzc.zza(parcel, zzlm.CREATOR);
        zzc.zzc(parcel);
        zzb(zzlmVar);
        return true;
    }
}
