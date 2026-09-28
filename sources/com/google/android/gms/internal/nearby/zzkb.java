package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkb extends zzb implements zzkc {
    public zzkb() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzle zzleVar = (zzle) zzc.zza(parcel, zzle.CREATOR);
            zzc.zzc(parcel);
            zzc(zzleVar);
            return true;
        }
        if (i == 3) {
            zzlg zzlgVar = (zzlg) zzc.zza(parcel, zzlg.CREATOR);
            zzc.zzc(parcel);
            zzd(zzlgVar);
            return true;
        }
        if (i == 4) {
            zzc.zzc(parcel);
            return true;
        }
        if (i != 5) {
            return false;
        }
        zzlc zzlcVar = (zzlc) zzc.zza(parcel, zzlc.CREATOR);
        zzc.zzc(parcel);
        zzb(zzlcVar);
        return true;
    }
}
