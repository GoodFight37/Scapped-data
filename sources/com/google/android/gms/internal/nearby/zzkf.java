package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkf extends zzb implements zzkg {
    public zzkf() {
        super("com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzli zzliVar = (zzli) zzc.zza(parcel, zzli.CREATOR);
            zzc.zzc(parcel);
            zzb(zzliVar);
            return true;
        }
        if (i != 3) {
            return false;
        }
        zzlk zzlkVar = (zzlk) zzc.zza(parcel, zzlk.CREATOR);
        zzc.zzc(parcel);
        zzc(zzlkVar);
        return true;
    }
}
