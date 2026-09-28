package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdw extends zza implements zzdy {
    zzdw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzdy
    public final void zzb(Status status, List list) throws RemoteException {
        throw null;
    }
}
