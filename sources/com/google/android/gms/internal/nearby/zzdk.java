package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdk extends zza implements zzdm {
    zzdk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IIntCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzdm
    public final void zzb(Status status, int i) throws RemoteException {
        throw null;
    }
}
