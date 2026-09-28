package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzik extends zzjh {
    final /* synthetic */ long zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzik(zzji zzjiVar, GoogleApiClient googleApiClient, long j) {
        super(googleApiClient, null);
        this.zza = j;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzgy) anyClient).zzs(this, this.zza);
    }
}
