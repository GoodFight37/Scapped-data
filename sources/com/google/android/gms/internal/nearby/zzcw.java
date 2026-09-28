package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcw extends zza implements zzcy {
    zzcw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzcy
    public final void zzb(Status status, DiagnosisKeysDataMapping diagnosisKeysDataMapping) throws RemoteException {
        throw null;
    }
}
