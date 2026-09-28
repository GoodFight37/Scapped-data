package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzcr extends zzb implements zzcs {
    public zzcr() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        ArrayList arrayListZzb = zzc.zzb(parcel);
        zzc.zzc(parcel);
        zzb(status, arrayListZzb);
        return true;
    }
}
