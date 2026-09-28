package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzp extends com.google.android.gms.internal.nearby.zza implements zzr {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final void zzd(Status status) throws RemoteException {
        throw null;
    }
}
