package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzcu extends zzb implements zzcv {
    public zzcu() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            boolean zZzc = zzc();
            parcel2.writeNoException();
            zzc.zzd(parcel2, zZzc);
        } else if (i == 2) {
            ParcelFileDescriptor parcelFileDescriptorZzb = zzb();
            parcel2.writeNoException();
            zzc.zzf(parcel2, parcelFileDescriptorZzb);
        } else {
            if (i != 3) {
                return false;
            }
            parcel2.writeNoException();
            zzc.zzd(parcel2, true);
        }
        return true;
    }
}
