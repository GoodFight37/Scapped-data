package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzde extends zzb implements zzdf {
    public zzde() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        ExposureSummary exposureSummary = (ExposureSummary) zzc.zza(parcel, ExposureSummary.CREATOR);
        zzc.zzc(parcel);
        zzb(status, exposureSummary);
        return true;
    }
}
